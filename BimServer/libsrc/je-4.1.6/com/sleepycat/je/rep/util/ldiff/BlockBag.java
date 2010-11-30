/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * A bag of Blocks used during the LDiff process. Blocks are accessed by their
 * checksum; when checksums collide, blocks are returned in insertion order.
 */
public class BlockBag implements Iterable<Block> {
    /* Map checksums to the corresponding block's index in blocks. */
    private final HashMap<Long, List<Integer>> chksums;
    /* Maintain the list of blocks in insertion order. */
    private final List<Block> blocks;

    /*
     * The index in blocks of the first block that has not yet been removed.
     * Items in blocks prior to blockIndex have been deleted from the bag.
     */
    private int blockIndex;

    /**
     * Instantiate a new BlockBag object.
     */
    public BlockBag() {
        blockIndex = 0;
        blocks = new ArrayList<Block>();
        chksums = new HashMap<Long, List<Integer>>();
    }

    /**
     * Adds a new Block to the bag.
     * 
     * @param b The Block to be added.
     */
    public void add(Block b) {
        final Long chksum = b.getRollingChksum();
        final Integer indx = blocks.size();
        blocks.add(b);
        List<Integer> indices = chksums.get(chksum);
        if (indices == null) {
            indices = new ArrayList<Integer>();
        }
        indices.add(indx);
        chksums.put(chksum, indices);
    }

    /**
     * Returns all Blocks in the bag with a given checksum.
     * 
     * @param chksum The checksum to match
     * @return A List of blocks with the given checksum, in insertion order, or
     * null if no matching blocks were found.
     */
    public List<Block> get(long chksum) {
        List<Integer> indices;
        List<Block> ret;

        ret = new ArrayList<Block>();
        indices = chksums.get(new Long(chksum));
        if (indices == null) {
            return null;
        }
        for (Integer indx : indices) {
            int i = indx.intValue();
            if (i >= blockIndex)
                ret.add(blocks.get(i));
        }

        if (ret.size() == 0) {
            return null;
        }
        return ret;
    }

    /**
     * Returns an iterator over the blocks in the bag, in insertion order.
     * 
     * @return an iterator over the blocks in the bag, in insertion order.
     */
    public Iterator<Block> iterator() {
        return new BagIterator();
    }

    /**
     * Removes the given Block, plus any blocks inserted previous to the given
     * Block.
     * 
     * @param b The Block to remove.
     * @return A List of all unmatched blocks, or null
     */
    public List<Block> remove(Block b) {
        final int startIndex = blockIndex;
        while (blockIndex < blocks.size()) {
            Block b2 = blocks.get(blockIndex);
            blockIndex++;
            if (b == b2) {
                break;
            }
        }

        return (blockIndex - startIndex <= 1) ? null : blocks.subList(
                startIndex, blockIndex - 1);
    }

    /**
     * Removes all blocks from the bag.
     * 
     * @return A list of all blocks removed, or null if the bag is already
     * empty.
     */
    public List<Block> removeAll() {
        List<Block> ret;

        ret = new ArrayList<Block>();
        while (blockIndex < blocks.size()) {
            Block b = blocks.get(blockIndex);
            blockIndex++;
            ret.add(b);
        }

        if (ret.size() == 0) {
            return null;
        }
        return ret;
    }

    public int getBlockIndex() {
        return blockIndex;
    }

    public Block getBlock() {
        return blocks.get(blockIndex);
    }

    /**
     * Returns the number of blocks in this bag.
     * 
     * @return the number of blocks in the bag
     */
    public int size() {
        return blocks.size() - blockIndex;
    }

    private class BagIterator implements Iterator<Block> {
        private int offset;

        BagIterator() {
            offset = 0;
        }

        public boolean hasNext() {
            return (offset + blockIndex < blocks.size());
        }

        public void remove() {
            BlockBag.this.remove(blocks.get(blockIndex));
        }

        public Block next() {
            return blocks.get(blockIndex + offset++);
        }
    }
}
