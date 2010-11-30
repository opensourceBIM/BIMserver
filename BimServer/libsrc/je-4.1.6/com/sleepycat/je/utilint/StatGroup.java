/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.sleepycat.je.TransactionStats.Active;

/**
 * The Stats infrastructure provides context for JE statistics. Each statistic
 * has these attributes:
 * - metadata - specifically, a name and description
 * - each statistic is associated with a parent stat group, which itself has
 *   a name and description.
 * - support for the StatsConfig.clear semantics
 * - a way to print statistics in a user friendly way.
 *
 * To create a statistic variable, instantiate one of the concrete subclasses
 * of Stat. Each concrete subclass should hold the methods that are needed to
 * best set and display the value. For example, instead of using LongStat to
 * hold a timestamp or LSN value, use TimestampStat or LSNStat. A Stat instance
 * needs to specify a StatDefinition. There may be multiple Stat variables in
 * different components that share a StatDefinition. They are differentiated
 * when displayed by their parent StatGroup.
 * 
 * Each Stat instance is associated with a StatGroup, which holds the
 * collection of stats that belong to a given component. Each member of the
 * StatGroup has a unique StatDefinition. StatGroups can be combined, in order
 * to accumulate values. For example, the LockManager may have multiple lock
 * tables. Each lock table keeps its own latch statistics. When LockStats are
 * generated, the StatsGroup for each latch is collected and rolled up into a
 * single StatGroup, using the addAll(StatGroup) method.
 *
 * The Stats infrastructure is for internal use only. Public API classes like
 * EnvironmentStats, LockStats, etc, contain StatGroups. A call to retrieve
 * stats is implementing by getting a clone of the StatGroups held by the
 * components like the cleaner, the incompressor, the LockManager, etc.  The
 * public API classes provide getter methods that reach into the StatGroups to
 * return the specific stat value.
 *
 * To add a statistic, create the Stat variable in the component where it is
 * being used and associate it with a StatGroup. The Stat infrastruture does
 * the rest of the work for plumbing that statistic up to the public API
 * class. Each API class must provide a getter method to access the specific
 * statistic. Currenly, this is done manually.
 */
public class StatGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    /* 
     * User understandable description of the grouping. The description may
     * indicate that these stats are meant for internal use.
     */
    private final String groupName;
    private final String groupDescription;
    private final Map<StatDefinition, Stat<?>> stats;

    public StatGroup(String groupName, String groupDescription) {
        this(groupName, groupDescription, 
             new HashMap<StatDefinition, Stat<?>>());
    }

    private StatGroup(String groupName,
                      String groupDescription, 
                      Map<StatDefinition, Stat<?>> values) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.stats = values;
    }

    /**
     * Add a stat to the group. User is responsible for serializing calls to
     * register().
     */
    void register(Stat<?> oneStat) {
        Stat<?> prev = stats.put(oneStat.getDefinition(), oneStat);
        assert (prev == null) : "prev = " + prev + " oneStat=" + oneStat.getDefinition();
    }

    /**
     * Add all the stats from the other group into this group. If both groups
     * have the same stat, add the values.
     */
    public void addAll(StatGroup other) {
        for (Entry<StatDefinition, Stat<?>> entry : 
             other.stats.entrySet()) {
            StatDefinition definition = entry.getKey();
            Stat<?> localStat = stats.get(definition);
            if (localStat == null) {
                stats.put(definition, entry.getValue());
            } else {
                
                /* 
                 * Cast to get around type problem. We know it's the same
                 * stat type because the definition is the same, but the
                 * compiler doesn't know that.
                 */
                Stat additionalValue = entry.getValue(); 
                localStat.add(additionalValue);
            }
        }
    }

    /**
     * Clear all stats in a StatGroup.
     */
    public void clear() {
        for (Stat<?> s : stats.values()) {
            s.clear();
        }
    }

    public String getName() {
        return groupName;
    }

    public String getDescription() {
        return groupDescription;
    }

    /**
     * @return a Stats class that copies the value of all stats in the group
     */
    public StatGroup cloneGroup(boolean clear) {

        Map<StatDefinition, Stat<?>> copyValues = 
            new HashMap<StatDefinition, Stat<?>>();
        
        for (Stat<?> s : stats.values()) {
            if (clear) {
                copyValues.put(s.getDefinition(), s.copyAndClear());
            } else {
                copyValues.put(s.getDefinition(), s.copy());
            }
        }
        return new StatGroup(groupName, groupDescription, copyValues);
    }

    public int getInt(StatDefinition definition) {
        IntStat s = (IntStat) stats.get(definition);
        if (s == null) {
            return 0;
        } else {
            return s.get();
        }
    }

    public LongStat getLongStat(StatDefinition definition) {
        return (LongStat) stats.get(definition);
    }

    public long getLong(StatDefinition definition) {
        LongStat s = getLongStat(definition);
        if (s == null) {
            return 0L;
        } else {
            return s.get();
        }
    }

    public Long getAtomicLong(StatDefinition definition) {
        AtomicLongStat s = (AtomicLongStat) stats.get(definition);
        if (s == null) {
            return 0L;
        } else {
            return s.get();
        }
    }

    public Active[] getActiveTxnArray(StatDefinition definition) {
        ActiveTxnArrayStat s = (ActiveTxnArrayStat) stats.get(definition);
        if (s == null) {
            return null;
        } else {
            return s.get();
        }
    }

    public long[] getLongArray(StatDefinition definition) {
        LongArrayStat s = (LongArrayStat) stats.get(definition);
        if (s == null) {
            return null;
        } else {
            return s.get();
        }
    }
    
    public boolean getBoolean(StatDefinition definition) {
        BooleanStat s = (BooleanStat) stats.get(definition);
        if (s == null) {
            return false;
        } else {
            return s.get();
        }
    }

    public String getString(StatDefinition definition) {
        StringStat s = (StringStat) stats.get(definition);
        if (s == null) {
            return null;
        } else {
            return s.get();
        }
    }
    
    /* 
     * Add this group's information to the jconsole tip map.
     */
    public void addToTipMap(Map<String,String> tips) {
        tips.put(getName(), getDescription());
        for (StatDefinition d: stats.keySet()) {
            tips.put(d.getName(), d.getDescription());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(groupName).append(": ");
        sb.append(groupDescription).append("\n");

        /* Order the stats for consistent display.*/
        Map<StatDefinition,Stat<?>> sortedStats = 
            new TreeMap<StatDefinition, Stat<?>> (stats);
        for (Stat<?> s : sortedStats.values()) {
            sb.append("\t").append(s).append("\n");
        }
        return sb.toString();
    }

    /**
     * Includes the per-stat description in the output string.
     */
    public String toStringVerbose() {
        StringBuilder sb = new StringBuilder();
        sb.append(groupName).append(": ");
        sb.append(groupDescription).append("\n");

        /* Order the stats for consistent display.*/
        Map<StatDefinition,Stat<?>> sortedStats = 
            new TreeMap<StatDefinition, Stat<?>> (stats);
        for (Stat<?> s : sortedStats.values()) {
            sb.append("\t").append(s.toStringVerbose()).append("\n");
        }
        return sb.toString();
    }
}
