/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.io.IOException;

/**
 * TestHook is used induce testing behavior that can't be provoked externally.
 * For example, unit tests may use hooks to throw IOExceptions, or to cause
 * waiting behavior.
 *
 * To use this, a unit test should extend TestHook with a class that overrides
 * the desired method. The desired code will have a method that allows the unit
 * test to specify a hook, and will execute the hook if it is non-null.
 * This should be done within an assert like so:
 *
 *    assert TestHookExecute(myTestHook);
 *
 * See Tree.java for examples.
 */
public interface TestHook<T> {

    public void hookSetup();

    public void doIOHook()
        throws IOException;

    public void doHook();

    public void doHook(T obj);

    public T getHookValue();
}
