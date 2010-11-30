/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

import java.util.Arrays;
import java.util.Formatter;

public class Block implements java.io.Serializable {

    private static final long serialVersionUID = 111858779935447845L;

    /* The block ID. */
    private final int blockId;

    /* The actual records that the block holds. */
    int numRecords;

    /*
     * For debugging support and to minimize the actual data that is
     * transferred over the network, I store the beginKey and endKey as the
     * index to each of the block.
     * 
     * TODO to optimize: replace the {beginKey, endKey} by something like LSN.
     */

    /* The database key that the current block starts with. */
    private byte[] beginKey;

    /* The database key that the current block ends with. */
    private byte[] beginData;

    /* The rolling checksum computed from the sequence of Adler32 checksums. */
    private long rollingChksum;

    /* An md5 hash is also computed for each block. */
    private byte[] md5Hash;

    public Block(int blockId) {
        this.blockId = blockId;
    }

    int getBlockId() {
        return blockId;
    }

    int getNumRecords() {
        return numRecords;
    }

    public void setNumRecords(int numRecords) {
        this.numRecords = numRecords;
    }

    byte[] getBeginKey() {
        return beginKey;
    }

    public void setBeginKey(byte[] beginKey) {
        this.beginKey = beginKey;
    }

    byte[] getBeginData() {
        return beginData;
    }

    public void setBeginData(byte[] beginData) {
        this.beginData = beginData;
    }

    long getRollingChksum() {
        return rollingChksum;
    }

    public void setRollingChksum(long rollingChksum) {
        this.rollingChksum = rollingChksum;
    }

    byte[] getMd5Hash() {
        return md5Hash;
    }

    public void setMd5Hash(byte[] md5Hash) {
        this.md5Hash = md5Hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Block)) {
            return false;
        }
        final Block other = (Block) o;
        return (this.blockId == other.blockId) &&
            (this.numRecords == other.numRecords) &&
            Arrays.equals(this.beginKey, other.beginKey) &&
            Arrays.equals(this.beginData, other.beginData) &&
            (this.rollingChksum == other.rollingChksum) &&
            Arrays.equals(this.md5Hash, other.md5Hash);
    }

    @Override
    public String toString() {
        final Formatter fmt = new Formatter();
        fmt.format("Block %d: rollingChksum=%x md5Hash=%s numRecords=%d", 
                   blockId, rollingChksum, Arrays.toString(md5Hash), 
                   numRecords);
        return fmt.toString();
    }
}
