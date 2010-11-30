/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

import java.nio.ByteBuffer;

import com.sleepycat.je.dbi.EnvironmentImpl;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.rep.impl.node.NameIdPair;
import com.sleepycat.je.rep.utilint.BinaryProtocol;
import com.sleepycat.je.utilint.VLSN;

/**
 * Protocol used by LDiff to request the blocks associated with a database and
 * do the record level analysis.
 *
 * BLOCK LEVEL ANALYSIS
 * =========================================
 * The request response sequence for a block list request is:
 *
 * EnvDiff -> EnvInfo -> DbBlocks -> BlockListStart [BlockInfo]+ BlockListEnd
 *
 * A DbMismatch response is sent back if the database does not exist, or if the
 * database has different persistent attributes associated with it.
 *
 * Note that this request is designed to maximize overlap. That is, the
 * responder could be working on block n, while the requester is working on
 * blocks n+1 and beyond (to the end of the database).
 *
 * The above is the minimal set of messages, biased for performance when the
 * databases are expected to match.
 *
 * RECORD LEVEL ANALYSIS
 * =========================================
 * User can configure LDiff to do record level analysis by setting 
 * LDiffConfig.setDiffAnalysis(true), it can help you find out which records 
 * are different between two databases.
 *
 * The request response sequence for record level analysis is: 
 *
 * RemoteDiffRequest -> DiffAreaStart|Error [RemoteRecord] DiffAreaEnd -> Done 
 *
 * The local Environment would send out a RemoteDiffRequest to the remote 
 * Environment, the remote Environment can get all the records of a different 
 * area: 
 *    1. If there exists exceptions during the fetching process, remote 
 *       Environment would send back an Error message, local Environment would 
 *       throw out a LDiffRecordRequestException and exit.
 *    2. If the fetching process is correct, remote Environment would send a 
 *       DiffAreaStart message to the local Environment to notify that it now
 *       transfers RemoteRecords of a different area. 
 *    3. After all the records of a different area are transferred, remote 
 *       Environment would send out a DiffAreaEnd message, which specifies 
 *       transferring a different area is finished. 
 *    4. When all the RemoteDiffRequest are processed, local Environment would
 *       send a Done message to presents the record level analysis is done.
 *
 * TODO: 1) Protocol version matching 2) Block granularity sync request. 3)
 * Protocol to narrow a diff down to a specific set of key inserts, updates and
 * deletes.
 */
public class Protocol extends BinaryProtocol {

    static public final int VERSION = 2;

    public final static MessageOp DB_BLOCKS =
        new MessageOp((short) 1, DbBlocks.class);

    public final static MessageOp DB_MISMATCH =
        new MessageOp((short) 2, DbMismatch.class);

    public final static MessageOp BLOCK_LIST_START =
        new MessageOp((short) 3, BlockListStart.class);

    public final static MessageOp BLOCK_INFO =
        new MessageOp((short) 4, BlockInfo.class);

    public final static MessageOp BLOCK_LIST_END =
        new MessageOp((short) 5, BlockListEnd.class);

    public final static MessageOp ENV_DIFF =
        new MessageOp((short) 6, EnvDiff.class);

    public final static MessageOp ENV_INFO =
        new MessageOp((short) 7, EnvInfo.class);

    public final static MessageOp REMOTE_DIFF_REQUEST =
        new MessageOp((short) 8, RemoteDiffRequest.class);

    public final static MessageOp REMOTE_RECORD =
        new MessageOp((short) 9, RemoteRecord.class);

    public final static MessageOp DIFF_AREA_START =
        new MessageOp((short) 10, DiffAreaStart.class);

    public final static MessageOp DIFF_AREA_END =
        new MessageOp((short) 11, DiffAreaEnd.class);

    public final static MessageOp DONE = new MessageOp((short) 12, Done.class);

    public final static MessageOp ERROR = 
        new MessageOp((short) 13, Error.class);

    public Protocol(NameIdPair nameIdPair, EnvironmentImpl envImpl) {

        /*
         * Make the configured version the same as the code version for now to
         * ignore protocol negotiation issues.
         */
        super(nameIdPair, VERSION, VERSION, envImpl);

        initializeMessageOps(new MessageOp[]
            { DB_BLOCKS, DB_MISMATCH, BLOCK_LIST_START,
              BLOCK_INFO, BLOCK_LIST_END, ENV_DIFF, ENV_INFO, 
              REMOTE_DIFF_REQUEST, REMOTE_RECORD, DIFF_AREA_START, 
              DIFF_AREA_END, DONE, ERROR });
    }

    /**
     * Message used to request a list of blocks. Note that the message only
     * needs to identify a specific database, since the service itself is
     * associated with a specific environment.
     */
    public class DbBlocks extends SimpleMessage {
        final String dbName;
        final int blockSize;

        // TODO: add all the persistent properties of the database, so they can
        // be checked.
        public DbBlocks(String dbName, int blockSize) {
            super();
            this.dbName = dbName;
            this.blockSize = blockSize;
        }

        public DbBlocks(ByteBuffer buffer) {
            super();
            dbName = getString(buffer);
            blockSize = LogUtils.readInt(buffer);
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(dbName, blockSize);
        }

        @Override
        public MessageOp getOp() {
            return DB_BLOCKS;
        }

        public String getDbName() {
            return dbName;
        }

        public int getBlockSize() {
            return blockSize;
        }
    }

    /**
     * Issued in response to a database level mismatch either because the
     * database itself does not exist at the node, or because it's properties
     * are different.
     */
    public class DbMismatch extends RejectMessage {

        public DbMismatch(String message) {
            super(message);
        }

        public DbMismatch(ByteBuffer buffer) {
            super(buffer);
        }

        @Override
        public MessageOp getOp() {
            return DB_MISMATCH;
        }
    }

    /**
     * Denotes the start of the list of blocks. 
     */
    public class BlockListStart extends SimpleMessage {

        public BlockListStart() {
            super();
        }

        @SuppressWarnings("unused")
            public BlockListStart(ByteBuffer buffer) {
            super();
        }

        @Override
        public MessageOp getOp() {
            return BLOCK_LIST_START;
        }
    }

    /**
     * Denotes the end of the list of blocks. 
     */
    public class BlockListEnd extends SimpleMessage {

        public BlockListEnd() {
            super();
        }

        @SuppressWarnings("unused")
            public BlockListEnd(ByteBuffer buffer) {
            super();
        }

        @Override
        public MessageOp getOp() {
            return BLOCK_LIST_END;
        }
    }

    /**
     * Supplies the properties of an individual block. 
     */
    public class BlockInfo extends SimpleMessage {
        /* The block associated with the request */
        final Block block;

        public BlockInfo(Block block) {
            super();
            this.block = block;
        }

        public BlockInfo(ByteBuffer buffer) {
            super();
            block = new Block(LogUtils.readInt(buffer));
            block.setBeginKey(getByteArray(buffer));
            block.setBeginData(getByteArray(buffer));
            block.setMd5Hash(getByteArray(buffer));
            block.setRollingChksum(LogUtils.readLong(buffer));
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(block.getBlockId(), block.getBeginKey(),
                              block.getBeginData(), block.getMd5Hash(),
                              block.getRollingChksum());
        }

        @Override
        public MessageOp getOp() {
            return BLOCK_INFO;
        }

        public Block getBlock() {
            return block;
        }
    }

    /**
     * Message used to present that an Environment is requesting to do a 
     * LDiff with another Environment.
     */
    public class EnvDiff extends SimpleMessage {
        public EnvDiff() {
            super();
        }

        @SuppressWarnings("unused")
        public EnvDiff(ByteBuffer buffer) {
            super();
        }

        @Override
        public MessageOp getOp() {
            return ENV_DIFF;
        }
    }

    /**
     * Message used to present how many databases in a compared Environment. 
     */
    public class EnvInfo extends SimpleMessage {
        final int numDBs;

        public EnvInfo(int numberOfDbs) {
            super();
            numDBs = numberOfDbs;
        }

        public EnvInfo(ByteBuffer buffer) {
            super();
            numDBs = LogUtils.readInt(buffer);
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(numDBs);
        }

        @Override
        public MessageOp getOp() {
            return ENV_INFO;
        }

        public int getNumberOfDBs() {
            return numDBs;
        }
    }

    /**
     * Message used to request records of a different area on the remote
     * database.
     */
    public class RemoteDiffRequest extends SimpleMessage {
        final byte[] key;
        final byte[] data;
        final long diffSize;

        public RemoteDiffRequest(MismatchedRegion region) {
            super();
            key = region.getRemoteBeginKey();
            data = region.getRemoteBeginData();
            diffSize = region.getRemoteDiffSize();
        }

        public RemoteDiffRequest(ByteBuffer buffer) {
            super();
            key = getByteArray(buffer);
            data = getByteArray(buffer);
            diffSize = LogUtils.readInt(buffer);
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(key, data, diffSize);
        }

        @Override
        public MessageOp getOp() {
            return REMOTE_DIFF_REQUEST;
        }

        public byte[] getKey() {
            return key;
        }

        public byte[] getData() {
            return data;
        }

        public long getDiffSize() {
            return diffSize;
        }
    }

    /**
     * Message used to transfer a record from remote to local database.
     */
    public class RemoteRecord extends SimpleMessage {
        final byte[] key;
        final byte[] data;
        final VLSN vlsn;

        public RemoteRecord(Record record) {
            super();
            key = record.getKey();
            data = record.getData();
            vlsn = record.getVLSN();
        }

        public RemoteRecord(ByteBuffer buffer) {
            super();
            key = getByteArray(buffer);
            data = getByteArray(buffer);
            vlsn = getVLSN(buffer);
        }

        @Override
        public ByteBuffer wireFormat() {
            return wireFormat(key, data, vlsn);
        }

        @Override
        public MessageOp getOp() {
            return REMOTE_RECORD;
        }

        public byte[] getKey() {
            return key;
        }

        public byte[] getData() {
            return data;
        }

        public VLSN getVLSN() {
            return vlsn;
        }
    }

    /**
     * Message used to present the transfer of a different area on remote
     * database begins.
     */
    public class DiffAreaStart extends SimpleMessage {
        public DiffAreaStart() {
            super();
        }

        @SuppressWarnings("unused")
        public DiffAreaStart(ByteBuffer buffer) {
            super();
        }

        @Override
        public MessageOp getOp() {
            return DIFF_AREA_START;
        }
    }

    /**
     * Message used to present the transfer of a different area on remote
     * database is done.
     */
    public class DiffAreaEnd extends SimpleMessage {
        public DiffAreaEnd() {
            super();
        }

        @SuppressWarnings("unused")
        public DiffAreaEnd(ByteBuffer buffer) {
            super();
        }

        @Override
        public MessageOp getOp() {
            return DIFF_AREA_END;
        }
    }

    /**
     * Message used to present the transfer of all the different data is done.
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

    /**
     * Message used to present an operation error on remote database.
     */
    public class Error extends RejectMessage {
        public Error(String message) {
            super(message);
        }

        public Error(ByteBuffer buffer) {
            super(buffer);
        }

        @Override
        public MessageOp getOp() {
            return ERROR;
        }
    }
}
