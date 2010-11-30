/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.utilint.Adler32;

/**
 * A rolling window of key/data pairs used by the ldiff algorithm.
 */
public class Window {
    private final Cursor cursor;
    private List<byte[]> window;
    private final MessageDigest md;
    private final int windowSize;
    private long chksum;

    /* The begin key/data pair of a window. */
    private byte[] beginKey;
    private byte[] beginData;
    /* The size of a different area. */
    private long diffSize;

    /**
     * Create a window of the given size, starting at the next record pointed
     * at by the Cursor.
     * 
     * @param cursor an open cursor on the database being diff'd
     * @param windowSize the number of records to include in the window
     * @throws Exception
     */
    public Window(Cursor cursor, int windowSize)
        throws Exception {

        this.cursor = cursor;
        this.windowSize = windowSize;
        /* To compute a MD5 hash for each block. */
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new Exception("MD5 hashes are required for ldiff.");
        }

        nextWindow();
    }

    /**
     * Roll a window forward by one key. The rolling checksum is adjusted to
     * account for this move past one key/value pair. Note that the md5 hash
     * associated with the window is computed on demand and is not updated
     * here.
     */
    public void rollWindow()
        throws Exception {

        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data = new DatabaseEntry();
        if (cursor.getNext(key, data, LockMode.DEFAULT) ==
            OperationStatus.SUCCESS) {
            byte[] keyValue = LDiffUtil.concatByteArray(key.getData(),
                                                        data.getData());
            int removeXi = LDiffUtil.getXi(window.remove(0));
            window.add(keyValue);
            int addXi = LDiffUtil.getXi(keyValue);
            rollChecksum(removeXi, addXi);
        } else {
            chksum = 0;
        }
        diffSize++;
    }

    /**
     * Advance the window to the next block of records and update the rolling
     * checksum.
     */
    public void nextWindow() {
        /* DatabaseEntry represents the key and data of each record. */
        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data = new DatabaseEntry();
        int i = 0;
        window = new ArrayList<byte[]>();
        diffSize = 0;

        /* Please pay attention to the check order in while loop. */
        while ((i < windowSize) &&
                (cursor.getNext(key, data, LockMode.DEFAULT) ==
                 OperationStatus.SUCCESS)) {
            if (i == 0) {
                beginKey = key.getData();
                beginData = data.getData();
            }
            window.add(LDiffUtil.concatByteArray(key.getData(),
                                                 data.getData()));
            i++;
        }

        setChecksum();
    }

    /**
     * The checksum for the window.
     * 
     * @return the checksum for the window.
     */
    public long getChecksum() {
        return chksum;
    }

    public byte[] getBeginKey() {
        return beginKey;
    }

    public byte[] getBeginData() {
        return beginData;
    }

    public long getDiffSize() {
        return diffSize;
    }

    /**
     * Compute the MD5 hash for the window. This is an expensive operation and
     * should be used sparingly.
     * 
     * @return the MD5 for the window.
     */
    public byte[] getMd5Hash() {
        /* Reset the Message Digest first. */
        md.reset();
        /* Feed the data into the Message Digest. */
        for (byte[] ba : window) {
            md.update(ba);
        }
        return md.digest();
    }

    /**
     * The number of records in the window. The size of the window will match
     * the value set during instantiation, until the end of the database is
     * reached.
     * 
     * @return the number of records in the window.
     */
    public int size() {
        return window.size();
    }

    /**
     * We use the rsync rolling checksum algorithm with the following changes:
     * 
     * 1. Each byte (Xi in the tech report) is replaced by a 32 bit Adler
     * checksum of the bytes representing the concatenation of the key/value
     * pair.
     * 
     * 2. The value for M is 64 instead of 32 to reduce the chances of false
     * collisions on the rolling checksum, given our adaptation of the original
     * algorithm to logically use 32 bit bytes.
     */
    private void setChecksum() {

        /* Adler32 to compute the rolling checksum of key/data pair. */
        Adler32 adler32 = new Adler32();

        int a = 0, b = 0;
        for (int i = 0; i < size(); i++) {
            byte[] element = window.get(i);
            adler32.reset();
            adler32.update(element, 0, element.length);
            final int xi = (int) adler32.getValue(); /* It's really 32 bits */
            a += xi;
            b += (xi * (size() - i));
        }
        chksum = (a & LDiffUtil.MASK_32BIT) | ((long) b << 32);
    }

    /**
     * Update the checksum by removing removeXi and adding addXi, according to
     * the rsync algorithm.
     * 
     * @param removeXi
     *            the value to remove from the checksum
     * @param addXi
     *            the value to add to the checksum
     */
    private void rollChecksum(int removeXi, int addXi) {
        final int a = (int) chksum - removeXi + addXi;
        final int b = (int) (chksum >> 32) - (removeXi * size()) + a;
        chksum = (a & LDiffUtil.MASK_32BIT) | ((long) b << 32);
    }
}
