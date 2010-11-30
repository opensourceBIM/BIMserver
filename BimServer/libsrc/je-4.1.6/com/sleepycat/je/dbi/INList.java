/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.evictor.EvictorStatDefinition;
import com.sleepycat.je.tree.BIN;
import com.sleepycat.je.tree.IN;
import com.sleepycat.je.utilint.LongStat;
import com.sleepycat.je.utilint.StatGroup;

/**
 * The INList is a list of in-memory INs for a given environment.
 */
public class INList implements Iterable<IN> {
    private EnvironmentImpl envImpl;
    private final boolean updateMemoryUsage;
    private boolean enabled;
    private volatile boolean recalcInProgress;
    private volatile boolean recalcToggle;
    private boolean recalcConsistent;
    private AtomicLong recalcTotal;

    /**
     * We use a Map of INs because there is no ConcurrentHashSet, only a
     * ConcurrentHashMap.  But this map is treated as a set of INs with the
     * same object as the key and the value.
     */
    private Map<IN,IN> ins = null;

    /**
     * Stats about the composition of the INList must be kept in this class
     * rather than the evictor because a sharedEnvCache encompasses many
     * INLists. Note that we are keeping a true StatGroup instance/Stat fields.
     * That's because these values are "instantaneous", and don't need to obey
     * the accumulate/clear semantics of stats. When stats are loaded, we'll
     * just create a new stats group to pass back.
     */
    private AtomicLong nCachedUpperINs;
    private AtomicLong nCachedBINs;

    INList(EnvironmentImpl envImpl) {
        init(envImpl);
        ins = new ConcurrentHashMap<IN,IN>();
        updateMemoryUsage = true;
        enabled = false;
    }

    /**
     * Used only by tree verifier when validating INList.
     */
    public INList(INList orig, EnvironmentImpl envImpl) {
        init(envImpl);
        ins = new ConcurrentHashMap<IN,IN>(orig.ins);
        updateMemoryUsage = false;
        enabled = true;
    }

    private void init(EnvironmentImpl environmentImpl) {
        this.envImpl = environmentImpl;
        recalcInProgress = false;
        recalcToggle = false;
        recalcConsistent = true;
        recalcTotal = new AtomicLong();

        nCachedUpperINs = new AtomicLong();
        nCachedBINs = new AtomicLong();
    }

    /**
     * All stats from the INList are instantaneous -- never need to be cleared.
     */
    public StatGroup loadStats() {
        StatGroup stats = new StatGroup(EvictorStatDefinition.GROUP_NAME,
                              EvictorStatDefinition.GROUP_DESC);

        long bstat = nCachedBINs.get();
        long istat = nCachedUpperINs.get();
        new LongStat(stats, EvictorStatDefinition.CACHED_UPPER_INS, 
                     istat);
        new LongStat(stats, EvictorStatDefinition.CACHED_BINS,
                     bstat);

        // verifyPrint(istat, bstat);

        return stats;
    }
    
    private void verifyPrint(long istat, long bstat) {
        int numINs = 0;
        int numBINs = 0;

        for (IN theIN : ins.keySet()) {
            if (theIN instanceof BIN) {
                numBINs++;
            } else {
                numINs++;
            }
        }
        System.out.println("size=" + getSize() + " INcount=" + numINs +
                           " BINCount=" + numBINs + " INstat=" + istat +
                           " bstat=" + bstat);
    }

    /*
     * Ok to be imprecise.
     */
    public int getSize() {
        return ins.size();
    }

    public boolean contains(IN in) {
        return ins.containsKey(in);
    }

    /**
     * Enable the INList during recovery.
     */
    public void enable() {
        assert ins.isEmpty();
        assert !enabled;
        enabled = true;
    }

    /**
     * An IN has just come into memory, add it to the list.
     */
    public void add(IN in) {
        /* Ignore additions until the INList is enabled. */
        if (!enabled) {
            return;
        }

        envImpl.getEvictor().noteINListChange(1 /*nINs*/);
        if (in instanceof BIN) {
            /* Be sure to check for BIN first, since it's a subclass of IN! */
            nCachedBINs.incrementAndGet();
        } else {
            nCachedUpperINs.incrementAndGet();
        }

        IN oldValue  = ins.put(in, in);

        assert oldValue == null : "failed adding IN " + in.getNodeId();

        if (updateMemoryUsage) {
            long size = in.getBudgetedMemorySize();
            memRecalcAdd(in, size);
            envImpl.getMemoryBudget().updateTreeMemoryUsage(size);
            in.setInListResident(true);
        }
    }

    /**
     * An IN is being evicted.
     */
    public void remove(IN in) {
        if (!enabled) {
            return;
        }

        if (in instanceof BIN) {
            /* 
             * Be sure to check for BIN first, since it's a subclass of IN!
             */
            nCachedBINs.decrementAndGet();
        } else {
            nCachedUpperINs.decrementAndGet();
        }

        envImpl.getEvictor().noteINListChange(1 /*nINs*/);

        IN oldValue = ins.remove(in);
        assert oldValue != null;

        if (updateMemoryUsage) {
            long delta = 0 - in.getBudgetedMemorySize();
            memRecalcRemove(in, delta);
            envImpl.getMemoryBudget().updateTreeMemoryUsage(delta);
            in.setInListResident(false);
        }
    }

    /**
     * Return an iterator over the main 'ins' set.  Returned iterator may or
     * may not show elements added or removed after the iterator is created.
     *
     * @return an iterator over the main 'ins' set.
     */
    public Iterator<IN> iterator() {
        return new Iter();
    }

    /**
     * A direct Iterator on the INList may return INs that have been removed,
     * since the underlying ConcurrentHashMap doesn't block changes to the list
     * during the iteration.  This Iterator implementation wraps a direct
     * Iterator and returns only those INs that are on the INList.
     *
     * Note that this doesn't guarantee that an IN will not be removed from the
     * INList after being returned by this iterator.  But filtering out the INs
     * already removed will avoid wasting effort in the evictor, checkpointer,
     * and other places where INs are iterated and processed.
     */
    private class Iter implements Iterator<IN> {

        private final Iterator<IN> baseIter;
        private IN next;
        private IN lastReturned;

        private Iter() {
            baseIter = ins.keySet().iterator();
        }

        public boolean hasNext() {
            if (next != null) {
                return true;
            } else {
                return advance();
            }
        }

        public IN next() {
            if (next == null) {
                if (!advance()) {
                    throw new NoSuchElementException();
                }
            }
            lastReturned = next;
            next = null;
            return lastReturned;
        }

        private boolean advance() {
            while (baseIter.hasNext()) {
                IN in = baseIter.next();
                if (in.getInListResident()) {
                    next = in;
                    return true;
                }
            }
            return false;
        }

        public void remove() {
            if (lastReturned != null) {
                envImpl.getEvictor().noteINListChange(1 /*nINs*/);
                ins.remove(lastReturned);
                lastReturned = null;
            } else {
                throw EnvironmentFailureException.unexpectedState();
            }
        }
    }

    /**
     * Clear the entire list at shutdown and release its portion of the memory
     * budget.
     */
    public void clear()  {
        if (envImpl.getEvictor() != null) {
            envImpl.getEvictor().noteINListChange(getSize() /*nINs*/);
        }

        ins.clear();
        nCachedUpperINs.set(0);
        nCachedBINs.set(0);

        if (updateMemoryUsage) {
            MemoryBudget mb = envImpl.getMemoryBudget();
            mb.refreshTreeMemoryUsage(0);
            mb.refreshTreeAdminMemoryUsage(0);            
        }
    }

    public void dump() {
        System.out.println("size=" + getSize());
        for (IN theIN : ins.keySet()) {
            System.out.println("db=" + theIN.getDatabase().getId() +
                               " nid=: " + theIN.getNodeId() + "/" +
                               theIN.getLevel());
        }
    }

    /*
     * The following set of memRecalc methods allow an iteration over the
     * INList to recalculate the tree memory budget.  This is done during a
     * checkpoint by the DirtyINMap class.
     *
     * We flip the INList toggle, recalcToggle, at the beginning of the recalc.
     * At that point, if recalcConsistent is true, all IN toggles have the
     * opposite value of recalcToggle.  As we process INs we flip their
     * toggles.  We can tell whether we have already processed an IN by
     * comparing its toggle to recalcToggle.  If they are equal, we have
     * already processed the IN.
     *
     * The scenarios below describe how the recalcTotal is updated for a
     * particular IN.
     *
     * Scenario #1: IN size is unchanged during the iteration
     *  begin
     *   iterate -- add total IN size, mark processed
     *  end
     *
     * Scenario #2: IN size is updated during the iteration
     *  begin
     *   update  -- do not add delta because IN is not yet processed
     *   iterate -- add total IN size, mark processed
     *   update  -- do add delta because IN was already processed
     *  end
     *
     * Scenario #3: IN is added during the iteration but not iterated
     *  begin
     *   add -- add IN size, mark processed
     *  end
     *
     * Scenario #4: IN is added during the iteration and is iterated
     *  begin
     *   add     -- add IN size, mark processed
     *   iterate -- do not add size because IN was already processed
     *  end
     *
     * Scenario #5: IN is removed during the iteration but not iterated
     *  begin
     *   remove  -- do not add delta because IN is not yet processed
     *  end
     *
     * Scenario #6: IN is removed during the iteration and is iterated
     *  begin
     *   iterate -- add total IN size, mark processed
     *   remove  -- add delta because IN was already processed
     *  end
     *
     * If recalcConsistent is false, the last attempted recalc was not
     * compeleted.  In that case the next reset pass will simply set the toggle
     * in every IN so that they are consistent.  The pass following that will
     * then do a normal recalc.  At the end of any pass, we only update the
     * memory budget if the last recalc was consistent (or this is the first
     * recalc), and the current recalc is completed.
     *
     * We do not synchronize when changing state variables.  In memRecalcBegin
     * and memRecalcEnd it is possible for an IN to be added or removed by
     * another thread in the window between settting recalcInProgress and
     * setting or getting the recalclTotal.  In memRecalcUpdate a similar thing
     * can happen in the window between checking the IN toggle and adding to
     * recalcTotal, if memRecaclcIterate is called by the checkpointer in that
     * window. If this occurs, the reset total can be inaccurate by the amount
     * that was changed in the window.  We have chosen to live with this
     * possible inaccuracy rather than synchronize these methods.  We would
     * have to synchronize every time we add/remove INs and update the size of
     * an IN, which could introduce a new point of contention.
     */

    /**
     * We are starting the iteration of the INList.  Flip the INList toggle
     * and set the total amount to zero.
     *
     * After calling this method, memRecalcEnd must be called in a finally
     * block.  If it is not called, internal state will be invalid.
     */
    public void memRecalcBegin() {
        recalcTotal.set(0);
        recalcInProgress = true;
        recalcToggle = !recalcToggle;
    }

    /**
     * An IN was encountered during the iteration through the entire INList.
     * Add its size to the recalc total if we have not already processed it,
     * and mark it as processed.  If it was already processed, memRecalcAdd
     * must have been called for the IN when it was added to the INList during
     * the iteration.
     */
    public void memRecalcIterate(IN in) {
        assert recalcInProgress;
        if (recalcConsistent &&
            recalcToggle != in.getRecalcToggle()) {
            long delta = in.resetAndGetMemorySize();
            recalcTotal.addAndGet(delta);
        }
        in.setRecalcToggle(recalcToggle);
    }

    /**
     * An IN is being added to the INList.  Add its size to the recalc total
     * and mark it as processed.  It cannot have already been processed since
     * it is a new IN.
     */
    private void memRecalcAdd(IN in, long size) {
        if (recalcInProgress &&
            recalcConsistent) {
            recalcTotal.addAndGet(size);
        }
        in.setRecalcToggle(recalcToggle);
    }

    /**
     * An IN is being removed from the INList.  Add the delta to the recalc
     * total if it was already processed, and mark it as processed.  If we have
     * not yet processed it, it is not included in the total.
     */
    private void memRecalcRemove(IN in, long delta) {
        memRecalcUpdate(in, delta); // Remove and update are the same
    }

    /**
     * The size of an IN is changing.  Add the delta to the recalc total if it
     * have already processed the IN.  If we have not yet processed it, its
     * total size will be added by memRecalcIterate.
     */
    public void memRecalcUpdate(IN in, long delta) {
        if (recalcInProgress &&
            recalcConsistent &&
            recalcToggle == in.getRecalcToggle()) {
            recalcTotal.addAndGet(delta);
        }
    }

    /**
     * The reset operation is over.  Only update the tree budget if the
     * iteration was completed and the state was consistent prior to this reset
     * operation.
     */
    public void memRecalcEnd(boolean completed) {
        assert recalcInProgress;
        if (completed &&
            recalcConsistent) {
            envImpl.getMemoryBudget().refreshTreeMemoryUsage
                (recalcTotal.get());
        }
        recalcInProgress = false;
        recalcConsistent = completed;
    }
}
