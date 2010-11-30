/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.sleepycat.je.DbInternal;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.JEVersion;
import com.sleepycat.je.config.EnvironmentParams;
import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.FileManager;
import com.sleepycat.je.utilint.CmdUtil;

/**
 * Verifies the checksums in one or more log files.
 *
 * <p>This class may be instantiated and used programmatically, or used as a
 * command line utility as described below.</p>
 *
 * <pre>
 * usage: java { com.sleepycat.je.util.DbVerifyLog |
 *               -jar je-&lt;version&gt;.jar DbVerifyLog }
 *  [-h &lt;dir&gt;]  # environment home directory
 *  [-s &lt;file&gt;] # starting (minimum) file number
 *  [-e &lt;file&gt;] # ending (one past the maximum) file number
 *  [-V]              # print JE version number"
 * </pre>
 * 
 * <p>All arguments are optional.  The current directory is used if {@code -h}
 * is not specified.  File numbers may be specified in hex (preceded by {@code
 * 0x}) or decimal format.  For convenience when copy/pasting from other
 * output, LSN format (&lt;file&gt;/&lt;offset&gt;) is also allowed.</p>
 */
public class DbVerifyLog {

    private static final String USAGE =
        "usage: " + CmdUtil.getJavaCommand(DbVerifyLog.class) + "\n" +
        "   [-h <dir>]  # environment home directory\n" +
        "   [-s <file>] # starting (minimum) file number\n" +
        "   [-e <file>] # ending (one past the maximum) file number\n" +
        "   [-V]        # print JE version number";
    
    private final EnvironmentImpl envImpl;
    private final int readBufferSize;

    /**
     * Creates a utility object for verifying the checksums in log files.
     *
     * <p>The read buffer size is {@link
     * EnvironmentConfig#LOG_ITERATOR_READ_SIZE}.</p>
     *
     * @param env the {@code Environment} associated with the log.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public DbVerifyLog(final Environment env) {
        this(env, 0);
    }

    /**
     * Creates a utility object for verifying log files.
     *
     * @param env the {@code Environment} associated with the log.
     *
     * @param readBufferSize is the buffer size to use.  If a value less than
     * or equal to zero is specified, {@link
     * EnvironmentConfig#LOG_ITERATOR_READ_SIZE} is used.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public DbVerifyLog(final Environment env, final int readBufferSize) {
        this(DbInternal.getEnvironmentImpl(env), readBufferSize);
    }

    private DbVerifyLog(final EnvironmentImpl envImpl,
                        final int readBufferSize) {
        this.readBufferSize = (readBufferSize > 0) ?
            readBufferSize :
            envImpl.getConfigManager().getInt
                (EnvironmentParams.LOG_ITERATOR_READ_SIZE);
        this.envImpl = envImpl;
    }

    /**
     * Verifies all log files in the environment.
     *
     * @throws LogVerificationException if a checksum cannot be verified or a
     * log entry is determined to be invalid by examining its contents.
     *
     * @throws IOException if an IOException occurs while reading a log file.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public void verifyAll()
        throws LogVerificationException, IOException {

        verify(0, Long.MAX_VALUE);
    }

    /**
     * Verifies the given range of log files in the environment.
     *
     * @param startFile is the lowest numbered log file to be verified.
     *
     * @param endFile is one greater than the highest numbered log file to be
     * verified.
     *
     * @throws LogVerificationException if a checksum cannot be verified or a
     * log entry is determined to be invalid by examining its contents.
     *
     * @throws IOException if an IOException occurs while reading a log file.
     *
     * @throws EnvironmentFailureException if an unexpected, internal or
     * environment-wide failure occurs.
     */
    public void verify(final long startFile, final long endFile)
        throws LogVerificationException, IOException {

        final FileManager fileManager = envImpl.getFileManager();
        final File homeDir = envImpl.getEnvironmentHome();
        final String[] fileNames =
            fileManager.listFiles(startFile, endFile - 1);
        final byte[] buf = new byte[readBufferSize];

        for (String fileName : fileNames) {
            final File file = new File(homeDir, fileName);
            final FileInputStream fis = new FileInputStream(file);
            final LogVerificationInputStream vis =
                new LogVerificationInputStream(envImpl, fis, fileName, -1L);
            while (vis.read(buf) > 0) {
            }
            vis.close();
        }
    }

    public static void main(String[] argv) {
        try {
            File envHome = new File(".");
            long startFile = 0;
            long endFile = Long.MAX_VALUE;

            for (int whichArg = 0; whichArg < argv.length; whichArg += 1) {
                final String nextArg = argv[whichArg];
                if (nextArg.equals("-h")) {
                    whichArg++;
                    envHome = new File(CmdUtil.getArg(argv, whichArg));
                } else if (nextArg.equals("-s")) {
                    whichArg++;
                    String arg = CmdUtil.getArg(argv, whichArg);
                    final int slashOff = arg.indexOf("/");
                    if (slashOff >= 0) {
                        arg = arg.substring(0, slashOff);
                    }
                    startFile = CmdUtil.readLongNumber(arg);
                } else if (nextArg.equals("-e")) {
                    whichArg++;
                    String arg = CmdUtil.getArg(argv, whichArg);
                    final int slashOff = arg.indexOf("/");
                    if (slashOff >= 0) {
                        arg = arg.substring(0, slashOff);
                    }
                    endFile = CmdUtil.readLongNumber(arg);
                } else if (nextArg.equals("-V")) {
                    System.out.println(JEVersion.CURRENT_VERSION);
                    System.exit(0);
                } else {
                    printUsageAndExit("Unknown argument: " + nextArg);
                }
            }

            final EnvironmentImpl envImpl =
                CmdUtil.makeUtilityEnvironment(envHome, true /*readOnly*/);
            final DbVerifyLog verifier = new DbVerifyLog(envImpl, 0);
            verifier.verify(startFile, endFile);
            System.exit(0);
        } catch (Throwable e) {
            e.printStackTrace();
            printUsageAndExit(e.toString());
        }
    }

    private static void printUsageAndExit(String msg) {
        if (msg != null) {
            System.err.println(msg);
        }
        System.err.println(USAGE);
        System.exit(1);
    }
}
