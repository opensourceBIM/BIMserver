/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.networkRestore;

import static com.sleepycat.je.rep.impl.networkRestore.NetworkBackupStatDefinition.BACKUP_FILE_COUNT;
import static com.sleepycat.je.rep.impl.networkRestore.NetworkBackupStatDefinition.DISPOSED_COUNT;
import static com.sleepycat.je.rep.impl.networkRestore.NetworkBackupStatDefinition.FETCH_COUNT;
import static com.sleepycat.je.rep.impl.networkRestore.NetworkBackupStatDefinition.SKIP_COUNT;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Logger;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.networkRestore.Protocol.FeederInfoResp;
import com.sleepycat.je.rep.impl.networkRestore.Protocol.FileEnd;
import com.sleepycat.je.rep.impl.networkRestore.Protocol.FileInfoResp;
import com.sleepycat.je.rep.impl.networkRestore.Protocol.FileListResp;
import com.sleepycat.je.rep.impl.networkRestore.Protocol.FileStart;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.utilint.RepUtils;
import com.sleepycat.je.rep.utilint.ServiceDispatcher;
import com.sleepycat.je.rep.utilint.BinaryProtocol.ProtocolException;
import com.sleepycat.je.rep.utilint.BinaryProtocol.ServerVersion;
import com.sleepycat.je.rep.utilint.ServiceDispatcher.ServiceConnectFailedException;
import com.sleepycat.je.utilint.IntStat;
import com.sleepycat.je.utilint.LoggerUtils;
import com.sleepycat.je.utilint.StatGroup;
import com.sleepycat.je.utilint.VLSN;

/**
 * This class implements a hot network backup that permits it to obtain a
 * consistent set of log files from any running environment that provides a
 * LogFileFeeder service. This class thus plays the role of a client, and the
 * running environment that of a server.
 * <p>
 * The log files that are retrieved over the network are placed in a directory
 * that can serve as an environment directory for a JE stand alone or HA
 * environment. If log files are already present in the target directory, it
 * will try reuse them, if they are really consistent with those on the server.
 * Extant log files that are no longer part of the current backup file set are
 * deleted or are renamed, depending on how the backup operation was
 * configured.
 * <p>
 * Renamed backup files have the following syntax:
 *
 * NNNNNNNN.bup.<backup number>
 *
 * where the backup number is the number associated with the backup attempt,
 * rather than with an individual file. That is, the backup number is increased
 * by one each time a backup is repeated in the same directory and log files
 * actually needed to be renamed.
 * <p>
 * The implementation tries to be resilient in the face of network failures and
 * minimizes the amount of work that might need to be done if the client or
 * server were to fail and had to be restarted. Users of this API must be
 * careful to ensure that the execute() completes successfully before accessing
 * the environment. [Sam: should we create a je.lck file to ensure that this is
 * the case?]
 */
public class NetworkBackup {
    /* The server that was chosen to supply the log files. */
    private final InetSocketAddress serverAddress;

    /* The environment directory into which the log files will be backed up */
    private final File envDir;

    /*
     * Used as the version number associated with any old files that may
     * need to be retained as a result of this backup operation.
     */
    private int backupNumber;

    /* The id used during logging to identify a node. */
    private final NameIdPair clientNameId;

    /*
     * Determines whether any existing log files in the envDir should be
     * retained under a different name (with a BUP_SUFFIX), or whether it
     * should be deleted.
     */
    private final boolean retainLogfiles;

    /*
     * The minimal VLSN that the backup must cover. Used to ensure that the
     * backup is sufficient to permit replay of a replication stream from a
     * feeder. It's NULL_VLSN if the VLSN does not matter, that is, it's a
     * backup for a standalone environment.
     */
    private final VLSN minVLSN;

    /*
     * The client abandons a backup attempt if the server is loaded beyond this
     * threshold
     */
    final int serverLoadThreshold;

    /* The RepImpl instance used in Protocol. */
    private final RepImpl repImpl;

    /* The protocol used to communicate with the server. */
    private Protocol protocol;

    /* The channel connecting this client to the server. */
    private SocketChannel channel;

    /*
     * The message digest used to compute the digest as each log file is pulled
     * over the network.
     */
    final MessageDigest messageDigest;

    /* Statistics on number of files actually fetched and skipped */
    private final StatGroup statistics;
    private final IntStat backupFileCount;
    private final IntStat disposedCount;
    private final IntStat fetchCount;
    private final IntStat skipCount;

    private final Logger logger;

    private CyclicBarrier testBarrier = null;

    /**
     * Time to wait for a request from the client.
     */
    private static final int SOCKET_TIMEOUT_MS = 10000;

    /*
     * The number of times to retry on a digest exception. That is, when the
     * SHA1 hash as computed by the server for the file does not match the hash
     * as computed by the client for the same file.
     */
    private static final int DIGEST_RETRIES = 5;

    /**
     * Creates a configured backup instance which when executed will backup the
     * files to the environment directory.
     *
     * @param serverSocket the socket on which to contact the server
     * @param envDir the directory in which to place the log files
     * @param clientNameId the id used to identify this client
     * @param retainLogfiles determines whether obsolete log files should be
     * retained by renaming them, instead of deleting them.
     * @param serverLoadThreshold only backup from this server if it has fewer
     * than this number of feeders active.
     * @param minVLSN the VLSN that should be covered by the server. It ensures
     * that the log files are sufficiently current for this client's needs.
     * @throws IllegalArgumentException if the environment directory is not
     * valid. When used internally, this should be caught appropriately.
     */
    public NetworkBackup(InetSocketAddress serverSocket,
                         File envDir,
                         NameIdPair clientNameId,
                         boolean retainLogfiles,
                         int serverLoadThreshold,
                         VLSN minVLSN,
                         RepImpl repImpl)
        throws IllegalArgumentException {

        super();
        this.serverAddress = serverSocket;
        if (!envDir.exists()) {
            throw new IllegalArgumentException("Environment directory: " +
                                               envDir + " not found");
        }
        this.envDir = envDir;
        this.clientNameId = clientNameId;
        this.retainLogfiles = retainLogfiles;
        this.serverLoadThreshold = serverLoadThreshold;
        this.minVLSN = minVLSN;
        this.repImpl = repImpl;
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            // Should not happen -- if it does it's a JDK config issue
            throw EnvironmentFailureException.unexpectedException(e);
        }

        logger = LoggerUtils.getLoggerFixedPrefix(getClass(), 
                                                  clientNameId.toString(),
                                                  repImpl);
        statistics = new StatGroup(NetworkBackupStatDefinition.GROUP_NAME,
                                   NetworkBackupStatDefinition.GROUP_DESC);
        backupFileCount = new IntStat(statistics, BACKUP_FILE_COUNT);
        disposedCount = new IntStat(statistics, DISPOSED_COUNT);
        fetchCount = new IntStat(statistics, FETCH_COUNT);
        skipCount = new IntStat(statistics, SKIP_COUNT);
    }

    /**
     * Convenience overloading.
     *
     * @see #NetworkBackup(InetSocketAddress, File, NameIdPair, boolean, int,
     * VLSN, RepImpl)
     */
    public NetworkBackup(InetSocketAddress serverSocket,
                         File envDir,
                         NameIdPair clientNameId,
                         boolean retainLogfiles)
        throws DatabaseException {

        this(serverSocket,
             envDir,
             clientNameId,
             retainLogfiles,
             Integer.MAX_VALUE,
             VLSN.NULL_VLSN,
             null);
    }

    /**
     * Computes the backup version number to be used for this backup based upon
     * the maximum of the version numbers used so far.
     * @return
     */
    private int getBackupNumber() {
        int maxBackupNumber = 0;
        for (String name : envDir.list(new BUPFilter())) {
            int start = name.lastIndexOf('.') + 1;
            int fileBackupNumber = Integer.parseInt(name.substring(start));
            if (fileBackupNumber > maxBackupNumber) {
                maxBackupNumber = fileBackupNumber;
            }
        }
        return maxBackupNumber+1;
    }

    /**
     * Returns statistics associated with the NetworkBackup execution.
     */
    public StatGroup getStats() {
        StatGroup ret = statistics.cloneGroup(false);

        return ret;
    }

    /**
     * Execute the backup.
     *
     * @throws ServiceConnectFailedException
     * @throws LoadThresholdExceededException
     * @throws InsufficientVLSNRangeException
     */
    public String[] execute()
        throws IOException,
               DatabaseException,
               ServiceConnectFailedException,
               LoadThresholdExceededException,
               InsufficientVLSNRangeException {

        /* Associate a new backup number with each execution */
        backupNumber = getBackupNumber();
        try {
            channel = RepUtils.openBlockingChannel(serverAddress, true,
                                                   SOCKET_TIMEOUT_MS);
            ServiceDispatcher.doServiceHandshake
                (channel, FeederManager.FEEDER_SERVICE);

            protocol = checkProtocol(new Protocol(clientNameId,
                                                  Protocol.VERSION,
                                                  repImpl));
            checkServer();
            String[] fileNames = getFileList();
            getFiles(fileNames);
            cleanup(fileNames);
            assert envDir.listFiles(new JDBFilter()).length ==
                fileNames.length : "envDir=" + envDir + " list=" +
                Arrays.asList(envDir.listFiles(new JDBFilter())) +
                " fileNames=" + Arrays.asList(fileNames);
            return fileNames;
        } finally {
            if (channel != null) {
                channel.socket().close();
                channel.close();
            }
            logger.info("Backup file total: " +
                        backupFileCount.get() +
                        ".  Files actually fetched: " +
                        fetchCount.get() +
                        ".  Files skipped(available locally): " +
                        skipCount.get() +
                        ".  Local files renamed/deleted: " +
                        disposedCount.get());
        }
    }

    /**
     * Ensures that the log file feeder is a suitable choice for this backup:
     * The feeder must cover the VLSN if its not null and must not be too busy.
     */
    private void checkServer()
        throws IOException,
               ProtocolException,
               LoadThresholdExceededException,
               InsufficientVLSNRangeException {

        protocol.write(protocol.new FeederInfoReq(), channel);
        FeederInfoResp resp = protocol.read(channel, FeederInfoResp.class);
        if ((!VLSN.NULL_VLSN.equals(minVLSN)) &&
            ((resp.getRangeFirst().compareTo(minVLSN) > 0) ||
             (resp.getRangeLast().compareTo(minVLSN)) < 0)) {
            throw new InsufficientVLSNRangeException(minVLSN,
                                                     resp.getRangeFirst(),
                                                     resp.getRangeLast());
        }
        if (resp.getActiveFeeders() > serverLoadThreshold) {
            LoadThresholdExceededException exception
                = new LoadThresholdExceededException(serverLoadThreshold,
                                                     resp.getActiveFeeders());
            throw exception;
        }
    }

    /**
     * Delete or rename residual jdb files that are not part of the log file
     * set. This method is only invoked after all required files have been
     * copied over from the server.
     *
     * @throws IOException
     */
    private void cleanup(String[] fileNames)
        throws IOException {

        logger.fine("Cleaning up");

        Set<String> logFileSet = new HashSet<String>(Arrays.asList(fileNames));
        for (File file : envDir.listFiles(new JDBFilter())) {
            if (!logFileSet.contains(file.getName())) {
                disposeFile(file);
            }
        }

        StringBuffer logFiles = new StringBuffer();
        for (String string : logFileSet) {
            File file = new File(envDir, string);
            if (!file.exists()) {
                throw EnvironmentFailureException.unexpectedState
                    ("Missing file: " + file);
            }
            logFiles.append(file.getCanonicalPath()).append(", ");
        }

        String names = logFiles.toString();
        if (names.length() > 0) {
            names = names.substring(0, names.length()-2);
        }
        logger.fine("Log file set: " + names);
    }

    /**
     * Retrieves all the files in the list, that are not already in the envDir.
     * @throws DatabaseException
     */
    private void getFiles(String[] fileNames)
        throws IOException, DatabaseException {

        logger.fine(fileNames.length + " files in backup set");

        for (String fileName : fileNames) {
            if (testBarrier != null) {
                try {
                    testBarrier.await();
                } catch (InterruptedException e) {
                    // Ignore just a test mechanism
                } catch (BrokenBarrierException e) {
                    throw EnvironmentFailureException.unexpectedException(e);
                }
            }
            File file = new File(envDir, fileName);
            if (haveFile(file)) {
                logger.fine("File: " + file.getCanonicalPath() +
                            " length: " + file.length() +
                            " available with matching SHA1, copy skipped");
                skipCount.increment();
                continue;
            }
            for (int i = 0; i < DIGEST_RETRIES; i++) {
                try {
                    getFile(file);
                    fetchCount.increment();
                    break;
                } catch (DigestException e) {
                    if ((i + 1) == DIGEST_RETRIES) {
                        throw new IOException("Digest mismatch despite "
                                + DIGEST_RETRIES + " attempts");
                    }
                    continue;
                }
            }
        }
        /* All done, shutdown conversation with the server. */
        protocol.write(protocol.new Done(), channel);
    }

    /**
     * Returns true if the file in this directory is the same as the file on
     * the server. The method tries to avoid requesting the SHA1 if the file
     * lengths are not equal, since computing the SHA1 if it's not already
     * cached requires a pass over the the log file. Note that the server
     * will always send back the SHA1 value if it has it cached.
     */
    private boolean haveFile(File file, boolean getSHA1)
        throws IOException, DatabaseException {

        if (!file.exists()) {
            return false;
        }
        protocol.write(protocol.new
                       FileInfoReq(file.getName(), getSHA1), channel);
        FileInfoResp statResp =
            protocol.read(channel, Protocol.FileInfoResp.class);
        long fileLength = file.length();
        if (statResp.getFileLength() != fileLength) {
            return false;
        }
        if (statResp.getDigestSHA1().length == 0) {
            assert(!getSHA1);
            return haveFile(file, true); // request SHA1 this time around
        }
        byte digest[] =
            LogFileFeeder.getSHA1Digest(file, file.length()).digest();
        return Arrays.equals(digest, statResp.getDigestSHA1());
    }

    /**
     * Convenience overloading for the above method.
     */
    private boolean haveFile(File file)
        throws IOException, DatabaseException {

        return haveFile(file, false);
    }

    /**
     * Requests and obtains the specific log file from the server. The file is
     * first created under a name with the .tmp suffix and is renamed to its
     * true name only after its digest has been verified.
     *
     * This method is protected to facilitate error testing.
     */
    protected void getFile(File file)
        throws IOException, ProtocolException, DigestException {

        logger.fine("Requesting file: " + file);
        protocol.write(protocol.new FileReq(file.getName()), channel);
        FileStart fileResp = protocol.read(channel, Protocol.FileStart.class);
        File tmpFile = new File(envDir, file.getName() +
                                FileManager.TMP_SUFFIX);
        if (tmpFile.exists()) {
            boolean deleted = tmpFile.delete();
            if (!deleted) {
                throw EnvironmentFailureException.unexpectedState
                    ("Could not delete file: " + tmpFile);
            }
        }
        ByteBuffer buffer = ByteBuffer.allocate(LogFileFeeder.TRANSFER_BYTES);
        messageDigest.reset();

        final FileOutputStream fileStream = new FileOutputStream(tmpFile);
        try {
            /* Copy over the file contents. */
            for (long bytes = fileResp.getFileLength(); bytes > 0;) {
                int readSize =
                    (int) Math.min(LogFileFeeder.TRANSFER_BYTES, bytes);
                buffer.rewind();
                buffer.limit(readSize);
                int actualBytes = channel.read(buffer);
                if (actualBytes == -1) {
                    throw new IOException("Premature EOF. Was expecting:"
                                          + readSize);
                }
                bytes -= actualBytes;
                fileStream.write(buffer.array(), 0, actualBytes);
                messageDigest.update(buffer.array(), 0, actualBytes);
            }
            logger.info(String.format("Fetched log file: %s, size: %,d bytes",
                                      file.getName(),
                                      fileResp.getFileLength()));
        } finally {
            fileStream.close();
        }
        FileEnd fileEnd = protocol.read(channel, Protocol.FileEnd.class);

        if (!Arrays.equals(messageDigest.digest(), fileEnd.getDigestSHA1())) {
            logger.warning("digest mismatch on file: " + file);
            throw new DigestException();
        }
        /* Now that we know it's good, move the file into place. */
        if (file.exists()) {
            /* delete or back up this and all subsequent obsolete files */
            disposeObsoleteFiles(file);
        }
        logger.fine("Renamed " + tmpFile + " to " + file);
        boolean renamed = tmpFile.renameTo(file);
        if (!renamed) {
            throw EnvironmentFailureException.unexpectedState
                ("Rename from: " + tmpFile + " to " + file + " failed");
        }
        /* Retain last modified time, to leave an audit trail. */
        if (!file.setLastModified(fileResp.getLastModifiedTime())) {
            throw EnvironmentFailureException.unexpectedState
                ("File.setlastModifiedTime() for:" + file + " and time " +
                 new Date(fileResp.getLastModifiedTime()) + " failed.");
        }
    }

    /**
     * Renames (or deletes) this log file, and all other files following it in
     * the log sequence. The operation is done from the highest file down to
     * this one, to ensure the integrity of the log files in the directory is
     * always preserved.
     *
     * @param file the lowest numbered log file that must be renamed or deleted
     */
    private void disposeObsoleteFiles(File startFile) {
        File[] dirFiles = envDir.listFiles(new JDBFilter());
        Arrays.sort(dirFiles); // sorts in ascending order

        /* Start with highest numbered file to be robust in case of failure. */
        for (int i= dirFiles.length-1; i >= 0; i--) {
            File file = dirFiles[i];
            disposeFile(file);
            if (startFile.equals(file)) {
                break;
            }
        }
    }

    /**
     * Remove the file from the current set of log files in the directory.
     * @param file
     */
    private void disposeFile(File file) {
        disposedCount.increment();
        if (retainLogfiles) {
            File renamedFile = new File(file.getPath() +
                                        FileManager.BUP_SUFFIX +
                                        "." + backupNumber);
            boolean renamed = file.renameTo(renamedFile);
            if (!renamed) {
                throw EnvironmentFailureException.unexpectedState
                    ("Could not rename log file from " +  file.getPath() +
                     " to file " + renamedFile.getPath());
            }
            logger.fine("Renamed log file: " + file.getPath() +
                        " to file " + renamedFile.getPath());
        } else {
            boolean deleted = file.delete();
            if (!deleted) {
                throw EnvironmentFailureException.unexpectedState
                    ("Could not delete log file " +  file.getPath());
            }
            logger.fine("deleted log file: " + file.getPath());
        }
    }

    /**
     * Carries out the message exchange to obtain the list of backup files.
     * @return
     * @throws IOException
     * @throws ProtocolException
     */
    private String[] getFileList()
        throws IOException, ProtocolException {

        protocol.write(protocol.new FileListReq(), channel);
        FileListResp fileListResp = protocol.read(channel,
                                                  Protocol.FileListResp.class);
        String[] fileList = fileListResp.getFileNames();
        backupFileCount.set(fileList.length);
        return fileList;
    }

    /**
     * Verify that the protocols are compatible, switch to a different protocol
     * version, if we need to.
     *
     * @throws DatabaseException
     */
    private Protocol checkProtocol(Protocol candidateProtocol)
        throws IOException, ProtocolException {

        candidateProtocol.write
            (candidateProtocol.new ClientVersion(), channel);
        ServerVersion serverVersion =
            candidateProtocol.read(channel, Protocol.ServerVersion.class);

        if (serverVersion.getVersion() != candidateProtocol.getVersion()) {
            String message = "Server requested protocol version:"
                    + serverVersion.getVersion()
                    + " but the client version is " +
                    candidateProtocol.getVersion();
            logger.info(message);
            throw new ProtocolException(message);
        }

        /*
         * In future we may switch protocol versions to accommodate the server.
         * For now, simply return the one and only version.
         */
        return candidateProtocol;
    }

    /*
     * @hidden
     *
     * A test entry point used to simulate a slow network restore.
     */
    public void setTestBarrier(CyclicBarrier  testBarrier) {
        this.testBarrier = testBarrier;
    }


    /**
     * @hidden
     * Filter class suitable for listing .jdb files.
     */
    public static class JDBFilter implements FilenameFilter {
        @SuppressWarnings("unused")
        public boolean accept(File dir, String name) {
            return name.endsWith(FileManager.JE_SUFFIX);
        }
    }

    /**
     * Filter class suitable for listing backup suffix files.
     */
    public static class BUPFilter implements FilenameFilter {
        @SuppressWarnings("unused")
        public boolean accept(File dir, String name) {
            int start = name.indexOf(FileManager.BUP_SUFFIX);
            if (start == -1) {
                return false;
            }
            start += FileManager.BUP_SUFFIX.length();
            if ((start+1 >= name.length()) || (name.charAt(start) != '.')) {
                /* Invalid suffix */
                return false;
            }
            try {
                Integer.parseInt(name.substring(start+1));
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }
    }

    /**
     * Exception indicating that the digest sent by the server did not match
     * the digest computed by the client, that is, the log file was corrupted
     * during transit.
     */
    @SuppressWarnings("serial")
    protected static class DigestException extends Exception {
    }

    /**
     * Exception indicating that the server vlsn range did not cover the VLSN
     * of interest.
     */
    @SuppressWarnings("serial")
    public static class InsufficientVLSNRangeException extends Exception {
        /* The VLSN that must be covered by the server. */
        private final VLSN minVLSN;

        /* The actual range covered by the server. */
        private final VLSN rangeFirst;
        private final VLSN rangeLast;

        public InsufficientVLSNRangeException(VLSN minVLSN,
                                              VLSN rangeFirst,
                                              VLSN rangeLast) {
            this.minVLSN = minVLSN;
            this.rangeFirst = rangeFirst;
            this.rangeLast = rangeLast;
        }

        public VLSN getMinVLSN() {
            return minVLSN;
        }

        public VLSN getRangeFirst() {
            return rangeFirst;
        }

        @Override
        public String getMessage() {
            return "Insufficient VLSN range. Needed VLSN: " + minVLSN +
                   " Available range: " +
                   "[" + rangeFirst + ", " + rangeLast + "]";
        }
    }

    @SuppressWarnings("serial")
    public static class LoadThresholdExceededException extends Exception {
        final int threshold;
        final int activeServers;

        LoadThresholdExceededException(int threshold,
                                       int activeServers) {
            assert(activeServers > threshold);
            this.threshold = threshold;
            this.activeServers = activeServers;
        }

        public int getActiveServers() {
            return activeServers;
        }

        public int getThreshold() {
            return threshold;
        }

        @Override
        public String getMessage() {
            return "Active server threshold: " + threshold + " exceeded. " +
            "Active servers: " + activeServers;
        }
    }
}
