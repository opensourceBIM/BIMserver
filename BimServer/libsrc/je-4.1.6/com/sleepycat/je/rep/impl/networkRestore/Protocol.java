/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.networkRestore;

import java.nio.ByteBuffer;

import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.utilint.BinaryProtocol;
import com.sleepycat.je.utilint.VLSN;

/**
 * The protocol used to obtain backup files from a LF Feeder. The message
 * exchange is always initiated by the client.
 *
 * The following describes the request/response messages exchanged between the
 * two nodes:
 *
 *      FeederInfoReq -> FeederInfoResp
 *
 *      FileListReq -> FileListResp
 *
 *      FileInfoReq -> FileInfoResp
 *
 *      FileReq -> FileStart <byte stream> FileEnd
 *
 *      Done
 *
 * So a complete sequence of successful request messages looks like:
 *
 * FeederInfoReq FileListReq [[FileInfoReq] [FileReq] ]+ Done
 *
 * A response sequence would look like:
 *
 * FeederInfoResp FileListResp [[FileInfoResp] [FileStart <byte stream> FileEnd] ]+
 *
 * The client may abandon its interaction with the server if it decides the
 * server is overloaded.
 *
 * The client tries to minimize the number of files it actually requests based
 * upon its current state.
 *
 */
public class Protocol extends BinaryProtocol {

    static public final int VERSION = 2;

    /* The messages defined by this class. */
    public final MessageOp FEEDER_INFO_REQ =
        new MessageOp((short)1, FeederInfoReq.class);

    public final MessageOp FEEDER_INFO_RESP =
        new MessageOp((short)2, FeederInfoResp.class);

    public final MessageOp FILE_LIST_REQ =
        new MessageOp((short)3, FileListReq.class);

    public final MessageOp FILE_LIST_RESP =
        new MessageOp((short)4, FileListResp.class);

    public final MessageOp FILE_REQ =
        new MessageOp((short)5, FileReq.class);

    public final MessageOp FILE_START =
        new MessageOp((short)6, FileStart.class);

    public final MessageOp FILE_END =
        new MessageOp((short)7, FileEnd.class);

    public final MessageOp FILE_INFO_REQ =
        new MessageOp((short)8, FileInfoReq.class);

    public final MessageOp FILE_INFO_RESP =
        new MessageOp((short)9, FileInfoResp.class);

    public final MessageOp DONE =
        new MessageOp((short)10, Done.class);

    public Protocol(NameIdPair nameIdPair,
                    int configuredVersion,
                    EnvironmentImpl envImpl) {

        super(nameIdPair, VERSION, configuredVersion, envImpl);

        initializeMessageOps(new MessageOp[]
                             {FEEDER_INFO_REQ,
                              FEEDER_INFO_RESP,
                              FILE_LIST_REQ,
                              FILE_LIST_RESP,
                              FILE_INFO_REQ,
                              FILE_INFO_RESP,
                              FILE_REQ,
                              FILE_START,
                              FILE_END,
                              DONE});
    }

    /* Requests the list of log files that need to be backed up. */
    public class FeederInfoReq extends SimpleMessage {

        public FeederInfoReq() {
            super();
        }

        @SuppressWarnings("unused")
        public FeederInfoReq(ByteBuffer buffer) {
            super();
        }

        @Override
        public MessageOp getOp() {
            return FEEDER_INFO_REQ;
        }
    }

    public class FeederInfoResp extends SimpleMessage {
        /* The number of feeders that are currently busy at this server. */
        private final int activeFeeders;

        /* The vlsn range covered by this server if it's a rep node. */
        private final VLSN rangeFirst;
        private final VLSN rangeLast;

        public FeederInfoResp(int activeFeeders,
                              VLSN rangeFirst,
                              VLSN rangeLast) {
            super();
            this.activeFeeders = activeFeeders;
            this.rangeFirst = rangeFirst;
            this.rangeLast = rangeLast;
        }

        public FeederInfoResp(ByteBuffer buffer) {
            super();
            activeFeeders = LogUtils.readInt(buffer);
            rangeFirst = getVLSN(buffer);
            rangeLast = getVLSN(buffer);
        }

        @Override
        public MessageOp getOp() {
            return FEEDER_INFO_RESP;
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(activeFeeders, rangeFirst, rangeLast);
        }

        public int getActiveFeeders() {
            return activeFeeders;
        }

        public VLSN getRangeFirst() {
            return rangeFirst;
        }

        public VLSN getRangeLast() {
            return rangeLast;
        }
    }

    /* Requests the list of log files that need to be backed up. */
    public class FileListReq extends SimpleMessage {

        public FileListReq() {
            super();
        }

        @SuppressWarnings("unused")
        public FileListReq(ByteBuffer buffer) {
            super();
        }

        @Override
        public MessageOp getOp() {
            return FILE_LIST_REQ;
        }
    }

    /* Response to the above containing the list of files. */
    public class FileListResp extends SimpleMessage {
        private final String[] fileNames;

        public FileListResp(String[] fileNames) {
            super();
            this.fileNames = fileNames;
        }

        public FileListResp(ByteBuffer buffer) {
            fileNames = getStringArray(buffer);
        }

        @Override
        public MessageOp getOp() {
            return FILE_LIST_RESP;
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat((Object)fileNames);
        }

        public String[] getFileNames() {
            return fileNames;
        }
    }

    /**
     * Requests that a specific file be sent to the client.
     */
    public class FileReq extends SimpleMessage {

        protected final String fileName;

        public FileReq(String fileName) {
            super();
            this.fileName = fileName;
        }

        public FileReq(ByteBuffer buffer) {
            fileName = getString(buffer);
        }

        @Override
        public MessageOp getOp() {
            return FILE_REQ;
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(fileName);
        }

        public String getFileName() {
            return fileName;
        }
    }

    /**
     * Requests information about a specific log file.
     */
    public class FileInfoReq extends FileReq {
        private final boolean needSHA1;

        public FileInfoReq(String fileName, boolean needSHA1) {
            super(fileName);
            this.needSHA1 = needSHA1;
        }

        public FileInfoReq(ByteBuffer buffer) {
            super(buffer);
            needSHA1 = getBoolean(buffer);
        }

        @Override
        public MessageOp getOp() {
            return FILE_INFO_REQ;
        }

        @Override
        public ByteBuffer wireFormat() {
            return super.wireFormat(fileName, needSHA1);
        }

        public boolean getNeedSHA1() {
            return needSHA1;
        }
    }

    /*
     * The Response for information about a specific log file.
     */
    public class FileInfoResp extends FileStart {
        private final byte[] digestSHA1;

        public FileInfoResp(String fileName,
                            long fileLength,
                            long lastModifiedTime,
                            byte[] digestSHA1) {
            super(fileName, fileLength, lastModifiedTime);
            this.digestSHA1 = digestSHA1;
        }

        public FileInfoResp(ByteBuffer buffer) {
            super(buffer);
            this.digestSHA1 = getByteArray(buffer);
        }

        @Override
        public MessageOp getOp() {
            return FILE_INFO_RESP;
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(fileName,
                              fileLength,
                              lastModifiedTime,
                              digestSHA1);
        }

        /**
         * Returns the SHA1 value if it was requested, or a zero length byte
         * array if it was not requested.
         */
        public byte[] getDigestSHA1() {
            return digestSHA1;
        }
    }

    /**
     * The message starting the response triple:
     *
     * FileStart <byte stream> FileEnd
     */
    public class FileStart extends SimpleMessage {
        /* Must match the request name. */
        protected final String fileName;

        /* The actual file length in bytes on disk */
        protected final long fileLength;
        protected final long lastModifiedTime;

        public FileStart(String fileName,
                         long fileLength,
                         long lastModifiedTime) {
            super();
            this.fileName = fileName;
            this.fileLength = fileLength;
            this.lastModifiedTime = lastModifiedTime;
        }

        public FileStart(ByteBuffer buffer) {
            fileName = getString(buffer);
            fileLength = LogUtils.readLong(buffer);
            lastModifiedTime = LogUtils.readLong(buffer);
        }

        @Override
        public MessageOp getOp() {
            return FILE_START;
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(fileName, fileLength, lastModifiedTime);
        }

        public long getFileLength() {
            return fileLength;
        }

        public long getLastModifiedTime() {
            return lastModifiedTime;
        }
    }

    /**
     * The message ending the response triple:
     *
     * FileStart <byte stream> FileEnd
     */
    public class FileEnd extends FileInfoResp {

        public FileEnd(String fileName,
                       long fileLength,
                       long lastModifiedTime,
                       byte[] digestSHA1) {
            super(fileName, fileLength, lastModifiedTime, digestSHA1);
        }

        public FileEnd(ByteBuffer buffer) {
            super(buffer);
        }

        @Override
        public MessageOp getOp() {
            return FILE_END;
        }

        @Override
        public ByteBuffer wireFormat() {
            return super.wireFormat();
        }
    }

    /**
     * Message from client indicating it's done with all the files it needs and
     * that the connection can be terminated.
     */
    public class Done extends SimpleMessage {

        public Done() {
            super();
        }

        @SuppressWarnings("unused")
        public Done(ByteBuffer buffer) {
            super();
        }

        @Override
        public MessageOp getOp() {
            return DONE;
        }
    }
}
