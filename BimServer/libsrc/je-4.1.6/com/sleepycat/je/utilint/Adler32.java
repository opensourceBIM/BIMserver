/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.zip.Checksum;

import com.sleepycat.je.dbi.EnvironmentImpl;

/**
 * Adler32 checksum implementation.
 *
 * This class is used rather than the native java.util.zip.Adler32 class
 * because we have seen a JIT problem when calling the Adler32 class using
 * the Server JVM on Linux and Solaris.  Specifically, we suspect this may
 * be Bug Parade number 4965907.  See SR [#9376].  We also believe that this
 * bug is fixed in Java 5 and therefore only use this class conditionally
 * if we find that we're in a 1.4 JVM. [#13354].
 *
 * The Adler32 checksum is discussed in RFC1950.  The sample implementation
 * from this RFC is shown below:
 *
 * <pre>
 *    #define BASE 65521  largest prime smaller than 65536
 *    unsigned long update_adler32(unsigned long adler,
 *       unsigned char *buf, int len)
 *    {
 *      unsigned long s1 = adler & 0xffff;
 *      unsigned long s2 = (adler >> 16) & 0xffff;
 *      int n;
 *
 *      for (n = 0; n < len; n++) {
 *        s1 = (s1 + buf[n]) % BASE;
 *        s2 = (s2 + s1)     % BASE;
 *      }
 *      return (s2 << 16) + s1;
 *    }
 *
 *    unsigned long adler32(unsigned char *buf, int len)
 *    {
 *      return update_adler32(1L, buf, len);
 *    }
 * </pre>
 *
 * The NMAX optimization is so that we don't have to do modulo calculations
 * on every iteration.  NMAX is the max number of additions to make
 * before you have to perform the modulo calculation.
 */
public class Adler32 implements Checksum {

    /* This class and the ctor are public for the unit tests. */
    public static class ChunkingAdler32 extends java.util.zip.Adler32 {
        int adler32ChunkSize = 0;

        public ChunkingAdler32(int adler32ChunkSize) {
            this.adler32ChunkSize = adler32ChunkSize;
        }

        @Override
        public void update(byte[] b, int off, int len) {
            if (len < adler32ChunkSize) {
                super.update(b, off, len);
                return;
            }

            int i = 0;
            while (i < len) {
                int bytesRemaining = len - i;
                int nBytesThisChunk =
                    Math.min(bytesRemaining, adler32ChunkSize);
                super.update(b, off + i, nBytesThisChunk);
                i += nBytesThisChunk;
            }
        }
    }

    public static Checksum makeChecksum() {
        if (EnvironmentImpl.USE_JAVA5_ADLER32) {
            int adler32ChunkSize = EnvironmentImpl.getAdler32ChunkSize();
            if (adler32ChunkSize > 0) {
                return new ChunkingAdler32(adler32ChunkSize);
            } else {
                return new java.util.zip.Adler32();
            }
        } else {
            return new Adler32();
        }
    }

    private long adler = 1;

    /*
     * BASE is the largest prime number smaller than 65536
     * NMAX is the largest n such that 255n(n+1)/2 + (n+1)(BASE-1) <= 2^32-1
     */
    private static final int BASE = 65521;
    private static final int NMAX = 5552;

    /**
     * Update current Adler-32 checksum given the specified byte.
     */
    public void update(int b) {
        long s1 = adler & 0xffff;
        long s2 = (adler >> 16) & 0xffff;
        s1 = (s1 + (b & 0xff)) % BASE;
        s2 = (s1 + s2) % BASE;
        adler = (s2 << 16) | s1;
    }

    /**
     * Update current Adler-32 checksum given the specified byte array.
     */
    public void update(byte[] b, int off, int len) {
        long s1 = adler & 0xffff;
        long s2 = (adler >> 16) & 0xffff;

        while (len > 0) {
            int k = len < NMAX ? len : NMAX;
            len -= k;

            /* This does not benefit from loop unrolling. */
            while (k-- > 0) {
                s1 += (b[off++] & 0xff);
                s2 += s1;
            }

            s1 %= BASE;
            s2 %= BASE;
        }
        adler = (s2 << 16) | s1;
    }

    /**
     * Reset Adler-32 checksum to initial value.
     */
    public void reset() {
        adler = 1;
    }

    /**
     * Returns current checksum value.
     */
    public long getValue() {
        return adler;
    }
}
