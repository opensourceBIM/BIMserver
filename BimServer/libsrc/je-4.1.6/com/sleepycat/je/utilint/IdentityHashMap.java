/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.Map;
import java.util.Set;

import com.sleepycat.je.EnvironmentFailureException;

/**
 * The Harmony IdentityHashMap implementation has a bug in entrySet() where
 * it returns a set of Map.Entry's which, when setValue() is called, do not
 * actually mutate the underlying Map.  This bug is reported as HARMONY-6419
 * (http://issues.apache.org/jira/browse/HARMONY-6419).
 *
 * (Harmony is found on Android in the form of the Dalvik compiler/runtime).
 *
 * This is also described in [#18167].
 */
public class IdentityHashMap<K, V> extends java.util.IdentityHashMap<K, V> {
    private static final long serialVersionUID = 1L;

    @Override
    public Set<Map.Entry<K, V>> entrySet() {

        throw EnvironmentFailureException.unexpectedState
            ("IdentityHashMap.entrySet() should not be used. See [#18167].");
    }
}
