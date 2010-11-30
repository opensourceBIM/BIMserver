/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */
package com.sleepycat.je.tree;

import com.sleepycat.je.dbi.MemoryBudget;
import com.sleepycat.je.evictor.Evictor;
import com.sleepycat.je.utilint.SizeofMarker;

/**
 * The abstract class that defines the various representation used to represent
 * the keys associated with the IN node. There are currently two supported
 * representations:
 * <ol>
 * <li>A default representation <code>Default</code> that's capable of holding
 * any set of keys.</li>
 * <li>
 * A compact representation <code>MaxKeySize</code> that's more efficient for
 * holding small keys (<= 16 bytes) in length. If key prefixing is in use this
 * represents the unprefixed part of the key, since that's what is stored in
 * this array.</li>
 * </ol>
 * <p>
 * The choice of representation is made when an IN node is first read in from
 * the log. The <code>MaxKeySize</code> representation is only used when it is
 * more storage efficient than the default representation for the set of keys
 * currently associated with the IN.
 * <p>
 * Note that no attempt is currently made to optimize the storage
 * representation as keys are added to, or removed from, the
 * <code>Default</code> representation to minimize the chances of transitionary
 * "back and forth" representation changes that could prove to be expensive.
 */
public abstract class INKeyRep
    extends INArrayRep<INKeyRep, INKeyRep.Type, byte[]> {

    /* The different representations for keys. */
    public enum Type { DEFAULT, MAX_KEY_SIZE };

    public INKeyRep(IN parent) {
        super(parent);
    }

    /**
     * The default representation that's capable of storing keys of any size.
     */
    public static class Default extends INKeyRep {
        private final byte[][] keys;

        Default(IN parent, int nodeMaxEntries) {
            super(parent);
            this.keys = new byte[nodeMaxEntries][];
        }

        public Default(@SuppressWarnings("unused") SizeofMarker marker) {
            super(null);
            keys = null;
        }

        @Override
        public Type getType() {
            return Type.DEFAULT;
        }

        @Override
        public byte[] get(int idx) {
            return keys[idx];
        }

        @Override
        public INKeyRep set(int idx, byte[] key) {
            keys[idx] = key;
            return this;
        }

        @Override
        public INKeyRep copy(int from, int to, int n) {
            System.arraycopy(keys, from, keys, to, n);
            return this;
        }

        @Override
        public long calculateMemorySize() {

            return MemoryBudget.DEFAULT_KEYVALS_OVERHEAD +
                /* empty keys  array */
                MemoryBudget.objectArraySize(keys.length);
        }


        @Override
        /**
         * Evolves to the MaxKeySize representation if that is more efficient
         * for the current set of keys. Note that since all the keys must be
         * examined to make the decision, there is a reasonable cost to the
         * method and it should not be invoked indiscriminately.
         */
        public INKeyRep compact() {

            if (keys.length > MaxKeySize.MAX_KEYS) {
                return this;
            }

            int keyCount = 0;
            int maxKeyLength = 0;
            int defaultKeyBytes = 0;
            for (byte[] key : keys) {
                if (key != null) {
                    keyCount++;
                    if (key.length > maxKeyLength) {
                        maxKeyLength = key.length;
                        if (maxKeyLength > MaxKeySize.MAX_KEY_LENGTH) {
                            return this;
                        }
                    }
                    defaultKeyBytes += MemoryBudget.byteArraySize(key.length);
                }
            }

            if (keyCount == 0) {
                return this;
            }

            long defaultSizeWithKeys = calculateMemorySize() + defaultKeyBytes;

            if (defaultSizeWithKeys >
                MaxKeySize.getMemorySize(keys.length, maxKeyLength)) {
                return compactToMaxKeySizeRep(maxKeyLength, defaultKeyBytes);
            }
            return this;
        }

        private MaxKeySize compactToMaxKeySizeRep(int maxKeyLength,
                                                  int defaultKeyBytes) {
            MaxKeySize newRep =
                new MaxKeySize(parent, keys.length, (short) maxKeyLength);

            for (int i=0; i < keys.length; i++) {
                newRep.set(i, keys[i]);
            }

            /*
             * Since the key bytes overhead is a variable number that is
             * accounted for in the IN node (IN.getEntryInMemorySize()) and
             * not as part of the default representation, they need to
             * calculated and subtracted from the IN overhead here.
             */
            noteRepChange(newRep, -defaultKeyBytes);
            return newRep;
        }

        @Override
        public int length() {
            return keys.length;
        }

        @Override
        void updateCacheStats(@SuppressWarnings("unused") boolean increment,
                              @SuppressWarnings("unused") Evictor evictor) {
            /* No stats for the default representation. */
        }
    }

    /**
     * The compact representation that can be used to represent keys <= 16
     * bytes in length. The keys are all represented inside a single byte array
     * instead of having one byte array per key. Within the array, all keys are
     * assigned a storage size equal to that taken up by the largest key, plus
     * one byte to hold the actual key length. This makes key retreival fast.
     * However, insertion and deletion for larger keys move bytes proportional
     * to the storage length of the keys. This is why the representation is
     * restricted to keys <= 16 bytes in size.
     *
     * On a 32 bit VM the per key overhead for the Default representation is 4
     * bytes for the pointer + 16 bytes for each byte array key object, for a
     * total of 20 bytes/key. On a 64 bit machine the overheads are much
     * larger: 8 bytes for the pointer plus 24 bytes per key.
     *
     * The more fully populated the IN the more the savings with this
     * representation since the single byte array is sized to hold all the keys
     * regardless of the actual number of keys that are present.
     *
     * It's worth noting that the storage savings here are realized in addition
     * to the storage benefits of key prefixing, since the keys stored in the
     * key array are the smaller key values after the prefix has been stripped,
     * reducing the length of the key and making it more likely that it's small
     * enough for this specialized representation.
     */
    public static class MaxKeySize extends INKeyRep {

        private static final int LENGTH_BYTES = 1;
        private static final byte NULL_KEY = Byte.MAX_VALUE;
        public static final byte MAX_KEY_LENGTH = 16;
        public static final int MAX_KEYS = 256;

        /*
         * The array is sized to hold all the keys associated with the IN node.
         * Each key is allocated a fixed amount of storage equal to the maximum
         * length of all the keys in the IN node + 1 byte to hold the size of
         * each key. The length is biased, by -128. That is, a zero length
         * key is represented by -128, a 1 byte key by -127, etc.
         */
        private final byte[] keys;

        /* The maximum key size + 1 (for the key length byte) */
        private final short keyLength;

        public MaxKeySize(IN parent,
                          int nodeMaxEntries,
                          short maxKeySize) {
            super(parent);

            assert maxKeySize < 255;
            this.keyLength = (short) (maxKeySize + LENGTH_BYTES);
            this.keys = new byte[keyLength * nodeMaxEntries];
            for (int i = 0; i < nodeMaxEntries; i++) {
                INKeyRep rep = set(i, null);
                assert rep == this; /* Rep remains unchanged. */
            }
        }

        /* Only for use by Sizeof */
        public MaxKeySize(@SuppressWarnings("unused") SizeofMarker marker) {
            super(null);
            keys = null;
            keyLength = 0;
        }

        @Override
        public Type getType() {
            return Type.MAX_KEY_SIZE;
        }

        @Override
        public INKeyRep copy(int from, int to, int n) {
            System.arraycopy(keys, (from * keyLength),
                             keys, (to * keyLength),
                             n * keyLength);
            return this;
        }

        @Override
        public byte[] get(int idx) {

            final int k = idx * keyLength;

            if (keys[k] == NULL_KEY) {
                return null;
            }

            final int length = keys[k] - Byte.MIN_VALUE;
            final byte[] key = new byte[length];

            for (int i = LENGTH_BYTES; i <= length; i++) {
                key[i - LENGTH_BYTES] = keys[k + i];
            }
            return key;
        }

        @Override
        public INKeyRep set(int idx, byte[] key) {

            final int ki = idx * keyLength;

            if (key == null) {
                keys[ki] = NULL_KEY;
                return this;
            }

            if (key.length >= keyLength) {
                Default newRep = expandToDefaultRep();
                return newRep.set(idx, key);
            }

            keys[ki] = (byte) (key.length + Byte.MIN_VALUE);
            for (int i = LENGTH_BYTES; i <= key.length; i++) {
                keys[ki + i] = key[i - LENGTH_BYTES];
            }
            return this;
        }

        private Default expandToDefaultRep() {
            final int capacity = length();
            final Default newRep = new Default(parent, capacity);
            int defaultKeyBytes = 0;
            for (int i = 0; i < capacity; i++) {
                final byte[] k = get(i);
                if (k != null) {
                    defaultKeyBytes += MemoryBudget.byteArraySize(k.length);
                }
                newRep.set(i, k);
            }
            /*
             * Since the key bytes overhead is a variable number which is
             * accounted for in the IN node (IN.getEntryInMemorySize()) and
             * not as part of the default representation, they need to be
             * calculated and added to the IN overhead here.
             */
            noteRepChange(newRep, defaultKeyBytes);
            return newRep;
        }

        @Override
        public long calculateMemorySize() {
            return MemoryBudget.MAX_KEY_SIZE_KEYVALS_OVERHEAD +
                   MemoryBudget.byteArraySize(keys.length);
        }

        private static long getMemorySize(int maxKeys, int maxKeySize) {
            return MemoryBudget.MAX_KEY_SIZE_KEYVALS_OVERHEAD +
                   MemoryBudget.byteArraySize(maxKeys *
                                              (maxKeySize + LENGTH_BYTES));
        }

        @Override
        public INKeyRep compact() {
            /* It's as compact as it gets. */
            return this;
        }

        @Override
        public int length() {
            return keys.length / keyLength;
        }

        @Override
        void updateCacheStats(boolean increment, Evictor evictor) {
            if (increment) {
                evictor.getNINCompactKey().incrementAndGet();
            } else {
                evictor.getNINCompactKey().decrementAndGet();
            }
        }
    }
}
