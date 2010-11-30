/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.utilint.Adler32;

public class LDiffUtil {

    /* Convenient masking constant. */
    final static long MASK_32BIT = 0xffffffffl;

    /* To compute a MD5 hash for each block. */
    static MessageDigest md = null;
    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /* Concatenate two byte arrays into one. */
    public static byte[] concatByteArray(byte[] a, byte[] b) {
        if ((a == null) || (b == null)) {
            return (a == null) ? b : a;
        }

        int len = a.length + b.length;
        byte[] dest = new byte[len];
        /* Copy the content of a to dest. */
        System.arraycopy(a, 0, dest, 0, a.length);
        /* Copy the content from b to the remaining part of dest. */
        System.arraycopy(b, 0, dest, a.length, b.length);

        return dest;
    }

    /**
     * Each byte (Xi in the tech report) is replaced by a 32 bit Adler checksum
     * of the bytes representing the concatenation of the key/value pair.
     * 
     * @return the checksum
     */
    public static int getXi(byte[] keyValue) {
        Adler32 adler32 = new Adler32();
        adler32.update(keyValue, 0, keyValue.length);
        return (int) adler32.getValue();
    }

    public static Block readBlock(int blockId, Cursor cursor, int numKeys)
        throws DatabaseException {

        /* DatabaseEntry represents the key and data of each record. */
        DatabaseEntry key = new DatabaseEntry();
        DatabaseEntry data = new DatabaseEntry();
        /* Adler32 to compute the rolling checksum of key/data pair. */
        Adler32 adler32 = new Adler32();
        int i = 0;
        int a = 0, b = 0;
        md.reset();
        Block block = new Block(blockId);

        /* Please pay attention to the check order in while loop. */
        while ((i < numKeys) &&
               (cursor.getNext(key, data, LockMode.DEFAULT) ==
                OperationStatus.SUCCESS)) {
            /* Indicates having a new block. */
            if (i == 0) {
                block.setBeginKey(key.getData());
                block.setBeginData(data.getData());
            }

            /* Calculate rollingChksum on "key|data" bytes. */
            adler32.reset();
            adler32.update(key.getData(), 0, key.getData().length);
            adler32.update(data.getData(), 0, data.getData().length);
            final int xi = (int) adler32.getValue();
            a += xi;
            b += a;
            /* Update MessageDigest with "key|data" bytes. */
            md.update(key.getData());
            md.update(data.getData());
            i++;
        }

        /* Allocate a block and return. */
        long cksum = (a & LDiffUtil.MASK_32BIT) | ((long) b << 32);
        block.setRollingChksum(cksum);
        block.setMd5Hash(md.digest());
        block.setNumRecords(i);
        return block;
    }

    public static Environment openEnv(String envDir) {
        /* Open the database environment. */
        EnvironmentConfig envConfig = new EnvironmentConfig();
        /* envConfig.setTransactional(false); */
        envConfig.setAllowCreate(false);
        envConfig.setReadOnly(true);
        try {
            return new Environment(new File(envDir), envConfig);
        } catch (EnvironmentLockedException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Database openDb(Environment env, String dbName) {

        /* Open the remote database within that environment. */
        DatabaseConfig dbConfig = new DatabaseConfig();
        /* dbConfig.setTransactional(false); */
        dbConfig.setAllowCreate(false);
        dbConfig.setReadOnly(true);
        dbConfig.setSortedDuplicates(true);
        try {
            return env.openDatabase(null, dbName, dbConfig);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Environment env, Database db) {
        if (db != null) {
            try {
                db.close();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        }
        if (env != null) {
            try {
                env.close();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        }
    }
}
