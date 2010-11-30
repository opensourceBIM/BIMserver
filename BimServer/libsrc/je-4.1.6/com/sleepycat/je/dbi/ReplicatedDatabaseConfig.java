/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import java.nio.ByteBuffer;
import java.util.Arrays;

import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DbInternal;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;

/**
 * This class contains all fields of the database configuration which are
 * persistent. This class is logged as part of a nameLN so that databases can
 * be created on replica nodes with the correct configuration.
 */
public class ReplicatedDatabaseConfig implements Loggable {

    private byte flags;
    private int maxMainTreeEntriesPerNode;
    private int maxDupTreeEntriesPerNode;
    private byte[] btreeComparatorBytes = LogUtils.ZERO_LENGTH_BYTE_ARRAY;
    private byte[] duplicateComparatorBytes = LogUtils.ZERO_LENGTH_BYTE_ARRAY;

    /** For reading */
    public ReplicatedDatabaseConfig() {
    }

    /** For writing */
    ReplicatedDatabaseConfig(byte flags,
                            int maxMainTreeEntriesPerNode,
                            int maxDupTreeEntriesPerNode,
                            byte[] btreeComparatorBytes,
                            byte[] duplicateComparatorBytes) {

        this.flags = flags;
        this.maxMainTreeEntriesPerNode = maxMainTreeEntriesPerNode;
        this.maxDupTreeEntriesPerNode = maxDupTreeEntriesPerNode;

        if (btreeComparatorBytes != null) {
            this.btreeComparatorBytes = btreeComparatorBytes;
        }

        if (duplicateComparatorBytes != null) {
            this.duplicateComparatorBytes = duplicateComparatorBytes;
        }
    }

    /**
     * Create a database config for use on the replica which contains
     * all the configuration options that were conveyed by way of this class.
     */
    public DatabaseConfig getReplicaConfig() {
        DatabaseConfig replicaConfig = new DatabaseConfig();
        replicaConfig.setTransactional(true);
        replicaConfig.setSortedDuplicates
            (DatabaseImpl.getSortedDuplicates(flags));
        replicaConfig.setTemporary(DatabaseImpl.isTemporary(flags));
        DbInternal.setReplicated(replicaConfig, true);
        replicaConfig.setNodeMaxEntries(maxMainTreeEntriesPerNode);
        replicaConfig.setNodeMaxDupTreeEntries(maxDupTreeEntriesPerNode);

        DatabaseImpl.ComparatorReader reader =
            new DatabaseImpl.ComparatorReader(btreeComparatorBytes, "Btree");
        if (reader.isClass()) {
            replicaConfig.setBtreeComparator(reader.getComparatorClass());
        } else {
            replicaConfig.setBtreeComparator(reader.getComparator());
        }

        reader = new DatabaseImpl.ComparatorReader(duplicateComparatorBytes,
                                                   "Duplicate");
        if (reader.isClass()) {
            replicaConfig.setDuplicateComparator(reader.getComparatorClass());
        } else {
            replicaConfig.setDuplicateComparator(reader.getComparator());
        }

        return replicaConfig;
    }

    /** @see Loggable#getLogSize */
    public int getLogSize() {
        return 1 + // flags, 1 byte
            LogUtils.getPackedIntLogSize(maxMainTreeEntriesPerNode) +
            LogUtils.getPackedIntLogSize(maxDupTreeEntriesPerNode) +
            LogUtils.getByteArrayLogSize(btreeComparatorBytes) +
            LogUtils.getByteArrayLogSize(duplicateComparatorBytes);
    }

    /** @see Loggable#writeToLog */
    public void writeToLog(ByteBuffer logBuffer) {
        logBuffer.put(flags);
        LogUtils.writePackedInt(logBuffer, maxMainTreeEntriesPerNode);
        LogUtils.writePackedInt(logBuffer, maxDupTreeEntriesPerNode);
        LogUtils.writeByteArray(logBuffer, btreeComparatorBytes);
        LogUtils.writeByteArray(logBuffer, duplicateComparatorBytes);
    }

    /** @see Loggable#readFromLog */
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {

        /*
         * ReplicatedDatabaseConfigs didn't exist before version 6 so they are
         * always packed.
         */
        flags = itemBuffer.get();
        maxMainTreeEntriesPerNode =
            LogUtils.readInt(itemBuffer, false/*unpacked*/);
        maxDupTreeEntriesPerNode =
            LogUtils.readInt(itemBuffer, false/*unpacked*/);
        btreeComparatorBytes =
            LogUtils.readByteArray(itemBuffer, false/*unpacked*/);
        duplicateComparatorBytes =
            LogUtils.readByteArray(itemBuffer, false/*unpacked*/);
    }

    /** @see Loggable#dumpLog */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<config ");
        DatabaseImpl.dumpFlags(sb, verbose, flags);
        sb.append(" btcmpSet=\"").append(btreeComparatorBytes !=
                                         LogUtils.ZERO_LENGTH_BYTE_ARRAY);
        sb.append("\" dupcmpSet=\"").append(duplicateComparatorBytes !=
                                            LogUtils.ZERO_LENGTH_BYTE_ARRAY
                                            ).append("\"");
        sb.append(" />");
    }

    /** @see Loggable.getTransactionId() */
    public long getTransactionId() {
        return 0;
    }

    /** @see Loggable.logicalEquals() */
    public boolean logicalEquals(Loggable other) {
        if (!(other instanceof ReplicatedDatabaseConfig))
            return false;

        ReplicatedDatabaseConfig otherConfig =
            (ReplicatedDatabaseConfig) other;

        if (flags != otherConfig.flags)
            return false;

        if (maxMainTreeEntriesPerNode !=
            otherConfig.maxMainTreeEntriesPerNode)
            return false;

        if (maxDupTreeEntriesPerNode !=
            otherConfig.maxDupTreeEntriesPerNode)
            return false;

        if (!Arrays.equals(btreeComparatorBytes,
                           otherConfig.btreeComparatorBytes))
            return false;

        if (!Arrays.equals(duplicateComparatorBytes,
                           otherConfig.duplicateComparatorBytes))
            return false;

        return true;
    }
}
