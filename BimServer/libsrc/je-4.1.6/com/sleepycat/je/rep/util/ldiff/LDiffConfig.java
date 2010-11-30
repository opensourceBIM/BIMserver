/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.util.ldiff;

public class LDiffConfig {
    private static final int DEFAULT_BLOCK_SIZE = 1 << 13; // 8k
    private static final int DEFAULT_MAX_ERRORS = 0;

    private int maxErrors = DEFAULT_MAX_ERRORS;
    private boolean diffAnalysis = false;
    private int blockSize = DEFAULT_BLOCK_SIZE;
    private boolean waitIfBusy = false;
    private int maxConnects = 1;
    private int reconnectDelay = 0;
    public boolean verbose = false;

    /**
     * Return the maximum number of errors to analyze before ending the LDiff
     * operation.
     *
     * @return the maximum number of errors to analyze before throwing
     * MismatchException.
     */
    public int getMaxErrors() {
        return maxErrors;
    }

    /**
     * Configure the maximum number of errors to be analyzed before ending the
     * LDiff operation. A value of zero forces the algorithm to run to
     * completion. The default value is 0.
     *
     * @param max the maximum number of errors to be analyzed before ending the
     * LDiff operation.
     */
    public void setMaxErrors(int max) {
        this.maxErrors = max;
    }

    /**
     * Return whether an LDiff object will provide detailed analysis about diff
     * failures.
     *
     * @return true if an LDiff object will provide detailed analysis about
     * diff failures.
     */
    public boolean getDiffAnalysis() {
        return diffAnalysis;
    }

    /**
     * Configure an LDiff object to provide detailed analysis about diff
     * failures. The default value is false.
     *
     * @param analysis if true, provides detailed analysis about the reason why
     * the diff failed. The detailed analysis can be time consuming.
     */
    public void setDiffAnalysis(boolean analysis) {
        diffAnalysis = analysis;
    }

    /**
     * Return the number of records to include in each block analyzed by the
     * LDiff operation.
     *
     * @return the number of records to include in each block analyzed by the
     * LDiff operation.
     */
    public int getBlockSize() {
        return blockSize;
    }

    /**
     * Configure the number of records to include in each block analyzed by the
     * LDiff operation. The default is 10240.
     *
     * @param size the number of records to include in each block analyzed by
     * the LDiff operation.
     */
    public void setBlockSize(int size) {
        blockSize = size;
    }

    /**
     * Return whether or not the operation will wait for the remote service to
     * become available if the remote service is busy.
     *
     * @return true if the LDiff operation will block until the remote service
     * becomes available
     */
    public boolean getWaitIfBusy() {
        return waitIfBusy;
    }

    /**
     * Return the maximum number of times the operation will attempt to connect
     * to the remote service before aborting.  A value of -1 means the operation
     * will never abort.
     *
     * @return the maximum number of times the operation will attempt to connect
     * to the remote service before aborting.
     */
    public int getMaxConnectionAttempts() {
        return maxConnects;
    }

    /**
     * Return the delay, in milliseconds, between reconnect attempts.
     *
     * @return the amount of time, in milliseconds, between reconnection
     * attempts
     */
    public int getReconnectDelay() {
        return reconnectDelay;
    }

    /**
     * Configure whether or not the operation should wait for the remote
     * service to become available, if the remote service is busy.
     *
     * @param wait if true, the LDiff operation will block until the remote
     * node is available
     * @param maxAttempts the number of times to attempt connecting to
     * the service before aborting.  Pass -1 to never abort.
     * @param delay the number of milliseconds to wait between connection
     * attempts.
     */
    public void setWaitIfBusy(boolean wait, int maxAttempts, int delay) {
        waitIfBusy = wait;
        maxConnects = maxAttempts;
        reconnectDelay = delay;
    }

    /**
     * Return whether or not the operation will output information on its
     * success or failure.
     *
     * @return true if the operation will output information
     */
    public boolean getVerbose() {
        return verbose;
    }

    /**
     * Configure whether or not the operation will output information on its
     * success or failure.
     *
     * @param verbose if true, the LDiff operation will output information
     * as it compares databases
     */
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }
}
