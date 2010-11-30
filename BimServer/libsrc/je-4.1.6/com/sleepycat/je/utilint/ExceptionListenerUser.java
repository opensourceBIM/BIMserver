/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import com.sleepycat.je.ExceptionListener;

/**
 * Any daemon thread has these responsibilities:
 *  - it is required to publish any exceptions to the JE exception
 *  - it must be able to accept a reu
 * listener should implement this interface, and should register itself with
 * the EnvironmentImpl.
 */
public interface ExceptionListenerUser {
    public void setExceptionListener(ExceptionListener listener);
}
