/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import com.sleepycat.je.utilint.LoggerUtils;

/**
 * A class representing an exception event.  Contains an exception and the name
 * of the daemon thread that it was thrown from.
 */
public class ExceptionEvent {

    private Exception exception;
    private String threadName;

    public ExceptionEvent(Exception exception, String threadName) {
        this.exception = exception;
        this.threadName = threadName;
    }

    public ExceptionEvent(Exception exception) {
        this.exception = exception;
        this.threadName = Thread.currentThread().toString();
    }

    /**
     * Returns the exception in the event.
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Returns the name of the daemon thread that threw the exception.
     */
    public String getThreadName() {
        return threadName;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("<ExceptionEvent exception=\"");
        sb.append(exception);
        sb.append("\" threadName=\"");
        sb.append(threadName);
        sb.append("\">");
        sb.append(LoggerUtils.getStackTrace(exception));
        return sb.toString();
    }
}
