/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

/**
 * Execute a test hook if set. This wrapper is used so that test hook execution
 * can be packaged into a single statement that can be done within an assert
 * statement.
 */
public class TestHookExecute {

    public static boolean doHookSetupIfSet(TestHook<?> testHook) {
        if (testHook != null) {
            testHook.hookSetup();
        }
        return true;
    }

    public static boolean doHookIfSet(TestHook<?> testHook) {
        if (testHook != null) {
            testHook.doHook();
        }
        return true;
    }

    public static <T> boolean doHookIfSet(TestHook<T> testHook, T obj) {
        if (testHook != null) {
            testHook.doHook(obj);
        }
        return true;
    }
}
