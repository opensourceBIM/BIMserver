/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.tree;

import java.util.Comparator;

import com.sleepycat.je.DatabaseEntry;

/**
 * Key represents a JE B-Tree Key.  Keys are immutable.  Within JE, keys are
 * usually represented as byte arrays rather than as Key instances in order to
 * reduce the in-memory footprint. The static methods of this class are used to
 * operate on the byte arrays.
 *
 * One exception is when keys are held within a collection. In that case, Key
 * objects are instantiated so that keys are hashed and compared by value.
 */
public final class Key implements Comparable<Key> {
    public abstract static class DumpType {

        private String name;

        private DumpType(String name) {
            this.name = name;
        }

        public static final DumpType BINARY = new DumpType("BINARY") {
                @Override
                void dumpByteArrayInternal(StringBuffer sb, byte[] b) {
                    for (int i = 0; i < b.length; i++) {
                        sb.append(b[i] & 0xFF).append(" ");
                    }
                }
            };

        public static final DumpType HEX = new DumpType("HEX") {
                @Override
                void dumpByteArrayInternal(StringBuffer sb, byte[] b) {
                    for (int i = 0; i < b.length; i++) {
                        sb.append(Integer.toHexString(b[i] & 0xFF)).
                            append(" ");
                    }
                }
            };

        public static final DumpType TEXT = new DumpType("TEXT") {
                @Override
                void dumpByteArrayInternal(StringBuffer sb, byte[] b) {
                    sb.append(new String(b));
                }
            };

        public static final DumpType OBFUSCATE = new DumpType("OBFUSCATE") {
                @Override
                void dumpByteArrayInternal(StringBuffer sb, byte[] b) {
                    int len = b.length;
                    sb.append("[").append(len).
                        append(len == 1 ? " byte]" : " bytes]");
                }
            };

        public String dumpByteArray(byte[] b) {
            StringBuffer sb = new StringBuffer();
            if (b != null) {
                dumpByteArrayInternal(sb, b);
            } else {
                sb.append("null");
            }
            return sb.toString();
        }

        @Override
        public String toString() {
            return name;
        }

        abstract void dumpByteArrayInternal(StringBuffer sb, byte[] b);
    }

    public static DumpType DUMP_TYPE = DumpType.BINARY;

    /* Not declared final since unit tests use it. */
    public static final byte[] EMPTY_KEY = new byte[0];
    private byte[] key;

    /**
     * Construct a new key from a byte array.
     */
    public Key(byte[] key) {
        if (key == null) {
            this.key = null;
        } else {
            this.key = new byte[key.length];
            System.arraycopy(key, 0, this.key, 0, key.length);
        }
    }

    public static byte[] makeKey(DatabaseEntry dbt) {
        byte[] entryKey = dbt.getData();
        if (entryKey == null) {
            return EMPTY_KEY;
        } else {
            byte[] newKey = new byte[dbt.getSize()];
            System.arraycopy(entryKey, dbt.getOffset(), newKey,
                             0, dbt.getSize());
            return newKey;
        }
    }

    /**
     * Get the byte array for the key.
     */
    public byte[] getKey() {
        return key;
    }

    /**
     * Compare two keys.  Standard compareTo function and returns.
     *
     * Note that any configured user comparison function is not used, and
     * therefore this method should not be used for comparison of keys during
     * Btree operations.
     */
    public int compareTo(Key argKey) {
        return compareUnsignedBytes(this.key, argKey.key);
    }

    /**
     * Support Set of Key in BINReference.
     */
    @Override
    public boolean equals(Object o) {
        return (o instanceof Key) && (compareTo((Key)o) == 0);
    }

    /**
     * Support HashSet of Key in BINReference.
     */
    @Override
    public int hashCode() {
        int code = 0;
        for (int i = 0; i < key.length; i += 1) {
            code += key[i];
        }
        return code;
    }

    /**
     * Compare keys with an optional comparator.
     */
    public static int compareKeys(byte[] key1,
                                  byte[] key2,
                                  Comparator<byte[]> comparator) {
        if (comparator != null) {
            return comparator.compare(key1, key2);
        } else {
            return compareUnsignedBytes(key1, key2);
        }
    }

    /**
     * Compare using a default unsigned byte comparison.
     */
    private static int compareUnsignedBytes(byte[] key1, byte[] key2) {
        int a1Len = key1.length;
        int a2Len = key2.length;

        int limit = Math.min(a1Len, a2Len);

        for (int i = 0; i < limit; i++) {
            byte b1 = key1[i];
            byte b2 = key2[i];
            if (b1 == b2) {
                continue;
            } else {

                /* 
                 * Remember, bytes are signed, so convert to shorts so that we
                 * effectively do an unsigned byte comparison.
                 */
                return (b1 & 0xff) - (b2 & 0xff);
            }
        }

        return (a1Len - a2Len);
    }

    /*
     * Return the number of leading bytes that key1 and key2 have in common
     * (i.e. the length of their common prefix).
     */
    public static int getKeyPrefixLength(byte[] key1, int a1Len, byte[] key2) {
        assert key1 != null && key2 != null;

        int a2Len = key2.length;

        int limit = Math.min(a1Len, a2Len);

        for (int i = 0; i < limit; i++) {
            byte b1 = key1[i];
            byte b2 = key2[i];
            if (b1 != b2) {
                return i;
            }
        }

        return limit;
    }

    /*
     * Return a new byte[] containing the common prefix of key1 and key2.
     * Return null if there is no common prefix.
     */
    public static byte[] createKeyPrefix(byte[] key1, byte[] key2) {
        int len = getKeyPrefixLength(key1, key1.length, key2);
        if (len == 0) {
            return null;
        }

        byte[] ret = new byte[len];
        System.arraycopy(key1, 0, ret, 0, len);

        return ret;
    }

    public static String dumpString(byte[] key, int nspaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(TreeUtils.indent(nspaces));
        sb.append("<key v=\"");

        if (DUMP_TYPE == DumpType.BINARY ||
            DUMP_TYPE == DumpType.HEX) {
            if (key == null) {
                sb.append("<null>");
            } else {
                sb.append(DUMP_TYPE.dumpByteArray(key));
            }
        } else if (DUMP_TYPE == DumpType.TEXT) {
            sb.append(key == null ? "" : new String(key));
        } else if (DUMP_TYPE == DumpType.OBFUSCATE) {
            int len = key.length;
            sb.append("[").append(len).append(len == 1 ? " byte]" : " bytes]");
        }
        sb.append("\"/>");

        return sb.toString();
    }

    /**
     * Print the string w/out XML format.
     */
    public static String getNoFormatString(byte[] key) {
        return "key=" + dumpString(key, 0);
    }
}
