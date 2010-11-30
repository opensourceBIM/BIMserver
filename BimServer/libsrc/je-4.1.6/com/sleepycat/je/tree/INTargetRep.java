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
 * The abstract class that defines the various representations used to
 * represent an array of target pointers to children of an IN node. These
 * arrays can be sparse, so the non-default representations are designed to
 * make efficient representations for the sparse cases. Each specialized
 * representation is a subclass of INTargetReps.
 *
 * A new IN node starts out with the None representation and grows through a
 * sparse into the full default representation. Subsequently, the default
 * representation can be <i>compacted</i> into a Sparse or None representation
 * whenever an IN is stripped. Note that representations do not currently move
 * to more compact forms when entries are nulled to minimize the possibility of
 * tansitionary representation changes, since each representation change has
 * a cpu cost and a gc cost associated with it.
 */
public abstract class INTargetRep
    extends INArrayRep<INTargetRep, INTargetRep.Type, Node> {

    /* Enumeration for the different types of supported representations. */
    public enum Type { DEFAULT, SPARSE, NONE }

    public INTargetRep(IN parent) {
        super(parent);
    }

    /* The default non-sparse representation. It simply wraps an array. */
    public static class Default extends INTargetRep {

        /* The target nodes */
        private final Node[] targets;

        @Override
        public Type getType() {
            return Type.DEFAULT;
        }

        @Override
        public long calculateMemorySize() {
            return MemoryBudget.DEFAULT_TARGET_ENTRY_OVERHEAD +
                   MemoryBudget.objectArraySize(targets.length);
        }

        public Default(IN parent, int capacity) {
            super(parent);
            this.targets = new Node[capacity];
        }

        /* Only for use by the Sizeof utility. */
        public Default(@SuppressWarnings("unused") SizeofMarker marker) {
            super(null);
            targets = null;
        }

        @Override
        public Node get(int idx) {
            return targets[idx];
        }

        @Override
        public INTargetRep set(int idx, Node node) {
            targets[idx] = node;
            return this;
        }

        @Override
        public int length() {
            return targets.length;
        }

        @Override
        public INTargetRep copy(int from, int to, int n) {
            System.arraycopy(targets, from, targets, to, n);
            return this;
        }

        @Override
        public INTargetRep compact() {
            int count = 0;
            for (Node target : targets) {
                if (target != null) {
                    count++;
                }
            }

            if ((count > Sparse.MAX_ENTRIES) ||
                (targets.length > Sparse.MAX_INDEX)) {
                return this;
            }

            INTargetRep newRep = null;
            if (count == 0) {
                newRep = new None(parent, targets.length);
            } else {
                newRep = new Sparse(parent, targets.length);
                for (int i=0; i < targets.length; i++) {
                    if (targets[i] != null) {
                        newRep.set(i, targets[i]);
                    }
                }
            }

            noteRepChange(newRep);
            return newRep;
        }

        @Override
        public void updateCacheStats(@SuppressWarnings("unused")
                                     boolean increment,
                                     @SuppressWarnings("unused")
                                     Evictor evictor) {
            /* No stats for this default rep. */
        }
    }

    /**
     * Representation used when 1-4 children are cached. Note that the IN
     * itself may have more children, but they are not currently cached.
     * The INArrayRep is represented by two parallel arrays: an array of
     * indices (idxs) and an array of values (targets). All elements that are
     * not explicitly represented are null.
     */
    public static class Sparse extends INTargetRep {

        /* The maximum number of entries that can be represented. */
        public static final int MAX_ENTRIES = 4;

        /* The maximum index that can be represented. */
        public static final int MAX_INDEX= Short.MAX_VALUE;

        /* The maximum number of children for the IN. */
        final int nodeMaxEntries;

        /*
         * The parallel arrays implementing the INArrayRep.
         */
        final short idxs[] = new short[MAX_ENTRIES];
        final Node targets[] = new Node[MAX_ENTRIES];

        @Override
        public Type getType() {
            return Type.SPARSE;
        }

        @Override
        public long calculateMemorySize() {
            /*
             * Note that fixed array sizes are already accounted for in the
             * SPARSE_TARGET_ENTRY_OVERHEAD computed vis Sizeof.
             */
            return MemoryBudget.SPARSE_TARGET_ENTRY_OVERHEAD;
        }

        public Sparse(IN parent, int capacity) {
            super(parent);
            this.nodeMaxEntries = capacity;

            /* Unroll initialization. */
            idxs[0] = idxs[1] = idxs[2] = idxs[3] = -1;
        }

        /* Only for use by the Sizeof utility. */
        public Sparse(@SuppressWarnings("unused") SizeofMarker marker) {
            super(null);
            nodeMaxEntries = 0;
        }

        @Override
        public INTargetRep copy(int from, int to, int n) {

            INTargetRep target = this;

            if ((to == from) || (n == 0)) {
                /* Nothing to do */
            } else if (to < from) {
                /* Copy ascending */
                for (int i = 0; i < n; i++) {
                    target = target.set(to++, get(from++));
                }
            } else {
                /* to > form. Copy descending */
                from += n;
                to += n;
                for (int i = 0; i < n; i++) {
                    target = target.set(--to, get(--from));
                }
            }
            return target;
        }

        @Override
        public Node get(int j) {
            assert (j >= 0) && (j <= MAX_INDEX);

            if (j >= nodeMaxEntries) {
                throw new IndexOutOfBoundsException("index:" + j +
                                                    "exceeds capacity:" +
                                                    nodeMaxEntries);
            }
            /* Unrolled for loop */
            if (idxs[0] == j) {
                return targets[0];
            }
            if (idxs[1] == j) {
                return targets[1];
            }
            if (idxs[2] == j) {
                return targets[2];
            }
            if (idxs[3] == j) {
                return targets[3];
            }
            return null;
        }

        @Override
        public int length() {
            return nodeMaxEntries;
        }

        @Override
        public INTargetRep set(int j, Node node) {

            assert (j >= 0) && (j <= MAX_INDEX);

            if (j >= nodeMaxEntries) {
                throw new ArrayIndexOutOfBoundsException
                    ("j:" + j + " >= " + "capacity: " + nodeMaxEntries);
            }

            int slot = -1;
            for (int i=0; i < targets.length; i++) {

                if (idxs[i] == j) {
                    targets[i] = node;
                    return this;
                }

                if ((slot < 0) && (targets[i] == null)) {
                   slot = i;
                }
            }

            /* Have a free slot, use it. */
            if (slot >= 0) {
                targets[slot] = node;
                idxs[slot] = (short)j;
                return this;
            }

            /* It's full, mutate it. */
            Default fe = new Default(parent, nodeMaxEntries);
            noteRepChange(fe);

            for (int i=0; i < targets.length; i++) {
                if (targets[i] != null) {
                    fe.set(idxs[i], targets[i]);
                }
            }

            return fe.set(j, node);
        }

        @Override
        public INTargetRep compact() {
            int count = 0;
            for (Node target : targets) {
                if (target != null) {
                    count++;
                }
            }
            if (count == 0) {
                None newRep = new None(parent, nodeMaxEntries);
                noteRepChange(newRep);
                return newRep;
            }
            return this;
        }

        @Override
        public void updateCacheStats(boolean increment, Evictor evictor) {
            long stat = increment ?
                evictor.getNINSparseTarget().incrementAndGet() :
                evictor.getNINSparseTarget().decrementAndGet();
            assert stat >= 0;
        }
    }

    /**
     * Representation used when an IN has no children cached.
     */
    public static class None extends INTargetRep {
        /* The maximum number of children for this IN. */
        final int nodeMaxEntries;

        @Override
        public Type getType() {
            return Type.NONE;
        }

        public None(IN parent, int nodeMaxEntries) {
            super(parent);
            this.nodeMaxEntries = nodeMaxEntries;
        }

        /* Only for use by the Sizeof utility. */
        public None(@SuppressWarnings("unused") SizeofMarker marker) {
            super(null);
            nodeMaxEntries = 0;
        }

        @Override
        public Node get(@SuppressWarnings("unused") int idx) {
            return null;
        }

        @Override
        public INTargetRep set(int idx, Node node) {
            INTargetRep targets = new Sparse(parent, nodeMaxEntries);
            noteRepChange(targets);
            return targets.set(idx, node);
        }

        @Override
        public int length() {
            return nodeMaxEntries;
        }

        @Override
        public INTargetRep copy(@SuppressWarnings("unused") int from,
                                 @SuppressWarnings("unused") int to,
                                 @SuppressWarnings("unused") int n) {
            /* Nothing to copy. */
            return this;
        }

        @Override
        public long calculateMemorySize() {
            return MemoryBudget.NULL_TARGET_ENTRY_OVERHEAD;
        }

        @Override
        public INTargetRep compact() {
            return this;
        }

        @Override
        public void updateCacheStats(boolean increment, Evictor evictor) {
            if (increment) {
                evictor.getNINNoTarget().incrementAndGet();
            } else {
                evictor.getNINNoTarget().decrementAndGet();
            }
        }
    }
}
