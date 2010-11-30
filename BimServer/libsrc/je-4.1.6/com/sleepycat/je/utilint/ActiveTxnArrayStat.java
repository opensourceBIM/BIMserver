/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.TransactionStats.Active;

/**
 * An array of active Txn stats.
 */
public class ActiveTxnArrayStat extends Stat<Active[]> {
    private static final long serialVersionUID = 1L;

    private Active[] array;

    public ActiveTxnArrayStat(StatGroup group, StatDefinition definition) {
        super(group, definition);
    }

    public ActiveTxnArrayStat(StatGroup group,
                              StatDefinition definition,
                              Active[] array) {
        super(group, definition);
        this.array = array;
    }

    @Override
    public Active[] get() {
        return array;
    }

    @Override
    public void set(Active[] array) {
        this.array = array;
    }

    @Override
    public void add(Stat<Active[]> other) {
        throw EnvironmentFailureException.unexpectedState
            ("ActiveTxnArrayStat doesn't support the add operation.");
    }

    @Override
    public void clear() {
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] = new Active(array[i].getName(), 0, 0);
            }
        }
    }

    @Override
    public ActiveTxnArrayStat copy() {
        try {
            ActiveTxnArrayStat ret = (ActiveTxnArrayStat) super.clone();
            if (array != null && array.length > 0) {
                Active[] newArray = new Active[array.length];
                System.arraycopy
                    (array, 0, newArray, 0, array.length);
                ret.set(newArray);
            }

            return ret;
        } catch (CloneNotSupportedException e) {
            throw EnvironmentFailureException.unexpectedException(e);
        }
    }

    @Override
    String getFormattedValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (array != null && array.length > 0) {
            for (Active active : array) {
                sb.append("  txnId = " + Stat.FORMAT.format(active.getId()) +
                          " txnName = " + active.getName() + "\n");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
