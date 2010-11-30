/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is used for tracking the different regions between local and 
 * remote database, it saves the begin key/data pair and size of different area
 * on both local and remote database.
 */
public class DiffTracker {
    /* Start block for the block different area. */
    private Block startBlock;
    /* Start position for the different block in the database. */
    private long remoteStart;
    /* Size of a block different area. */
    private long remoteDiffSize;
    /* Size of each block. */
    private final long blockSize;
    /* Collection of different areas. */
    private final List<MismatchedRegion> regions;

    public DiffTracker(long blockSize) {
        this.blockSize = blockSize;
        regions = new ArrayList<MismatchedRegion>();
    }

    /* Set begin key/data pair and start position of a different block area. */
    public void setBlockDiffBegin(Block startBlock, int startIndex) {
        this.startBlock = startBlock;
        remoteStart = startIndex * blockSize;
    }

    /* Calculate the size of a block different area. */
    public void calBlockDiffSize(int currentIndex) {
        remoteDiffSize = (currentIndex - 1) * blockSize - remoteStart;
    }

    /* Add the different local and remote different areas to the collection. */
    public void addDiffRegion(Window window) {
        MismatchedRegion region = new MismatchedRegion();
        setBlockDiff(region, startBlock, remoteDiffSize, true);
        setWindowDiff(region, window, window.getDiffSize(), true);

        if (!region.isNull()) {
            regions.add(region);
        }

        remoteDiffSize = 0;
    }

    private void setWindowDiff(MismatchedRegion region, 
                               Window window,
                               long diffSize, 
                               boolean doCheck) {
        if (doCheck && window.getDiffSize() == 0) {
            return;
        }

        region.setLocalBeginKey(window.getBeginKey());
        region.setLocalBeginData(window.getBeginData());
        region.setLocalDiffSize(diffSize);
    }

    private void setBlockDiff(MismatchedRegion region,
                              Block block,
                              long diffSize,
                              boolean doCheck) {
        if (doCheck && remoteDiffSize == 0) {
            return;
        }

        region.setRemoteBeginKey(block.getBeginKey());
        region.setRemoteBeginData(block.getBeginData());
        region.setRemoteDiffSize(diffSize);
    }

    /* Add the window additional area to the difference collection. */
    public void addWindowAdditionalDiffs(Window window) {
        MismatchedRegion region = new MismatchedRegion();
        setWindowDiff(region, window, DiffRecordAnalyzer.DATABASE_END, false);
        regions.add(region);
    }

    /* Add the block additional area to the different collection. */
    public void addBlockBagAdditionalDiffs(Window window, BlockBag blkBag) {
        MismatchedRegion region = new MismatchedRegion();
        setBlockDiff(region, blkBag.getBlock(), 
                     DiffRecordAnalyzer.DATABASE_END, false);
        setWindowDiff(region, window, DiffRecordAnalyzer.DATABASE_END, true);
        regions.add(region);
    }

    /* Return the different regions. */
    public List<MismatchedRegion> getDiffRegions() {
        return regions;
    }
}
