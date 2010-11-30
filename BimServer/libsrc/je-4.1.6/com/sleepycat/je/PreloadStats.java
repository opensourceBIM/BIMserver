/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.io.Serializable;

/**
 * Statistics returned from {@link com.sleepycat.je.Database#preload 
 * Database.preload}
 */
public class PreloadStats implements Serializable {

    private static final long serialVersionUID = 2131949076L;

    /**
     * The number of INs loaded during the preload() operation.
     */
    private int nINsLoaded;

    /**
     * The number of BINs loaded during the preload() operation.
     */
    private int nBINsLoaded;

    /**
     * The number of LNs loaded during the preload() operation.
     */
    private int nLNsLoaded;

    /**
     * The number of DINs loaded during the preload() operation.
     */
    private int nDINsLoaded;

    /**
     * The number of DBINs loaded during the preload() operation.
     */
    private int nDBINsLoaded;

    /**
     * The number of DupCountLNs loaded during the preload() operation.
     */
    private int nDupCountLNsLoaded;

    /**
     * The status of the preload() operation.
     */
    private PreloadStatus status;

    PreloadStats(int nINsLoaded,
                 int nBINsLoaded,
                 int nLNsLoaded,
                 int nDINsLoaded,
                 int nDBINsLoaded,
                 int nDupCountLNsLoaded,
                 PreloadStatus status) {

        this.nINsLoaded = nINsLoaded;
        this.nBINsLoaded = nBINsLoaded;
        this.nLNsLoaded = nLNsLoaded;
        this.nDINsLoaded = nDINsLoaded;
        this.nDBINsLoaded = nDBINsLoaded;
        this.nDupCountLNsLoaded = nDupCountLNsLoaded;
        this.status = status;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public PreloadStats() {
        reset();
    }

    /**
     * Resets all stats.
     */
    private void reset() {
        nINsLoaded = 0;
        nBINsLoaded = 0;
        nLNsLoaded = 0;
        nDINsLoaded = 0;
        nDBINsLoaded = 0;
        nDupCountLNsLoaded = 0;
        status = PreloadStatus.SUCCESS;
    }

    /**
     * Returns the number of INs that were loaded into the cache during the
     * preload() operation.
     */
    public int getNINsLoaded() {
        return nINsLoaded;
    }

    /**
     * Returns the number of BINs that were loaded into the cache during the
     * preload() operation.
     */
    public int getNBINsLoaded() {
        return nBINsLoaded;
    }

    /**
     * Returns the number of LNs that were loaded into the cache during the
     * preload() operation.
     */
    public int getNLNsLoaded() {
        return nLNsLoaded;
    }

    /**
     * Returns the number of DINs that were loaded into the cache during the
     * preload() operation.
     */
    public int getNDINsLoaded() {
        return nDINsLoaded;
    }

    /**
     * Returns the number of DBINs that were loaded into the cache during the
     * preload() operation.
     */
    public int getNDBINsLoaded() {
        return nDBINsLoaded;
    }

    /**
     * Returns the number of DupCountLNs that were loaded into the cache during
     * the preload() operation.
     */
    public int getNDupCountLNsLoaded() {
        return nDupCountLNsLoaded;
    }

    /**
     * Returns the PreloadStatus value for the preload() operation.
     */
    public PreloadStatus getStatus() {
        return status;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public void incINsLoaded() {
        this.nINsLoaded++;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public void incBINsLoaded() {
        this.nBINsLoaded++;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public void incLNsLoaded() {
        this.nLNsLoaded++;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public void addLNsLoaded(int newLNs ) {
        this.nLNsLoaded+=newLNs;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public void incDINsLoaded() {
        this.nDINsLoaded++;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public void incDBINsLoaded() {
        this.nDBINsLoaded++;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public void incDupCountLNsLoaded() {
        this.nDupCountLNsLoaded++;
    }

    /**
     * @hidden
     * Internal use only.
     */
    public void setStatus(PreloadStatus status) {
        this.status = status;
    }

    /**
     * Returns a String representation of the stats in the form of
     * &lt;stat&gt;=&lt;value&gt;
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("status=").append(status).append('\n');
        sb.append("nINsLoaded=").append(nINsLoaded).append('\n');
        sb.append("nBINsLoaded=").append(nBINsLoaded).append('\n');
        sb.append("nLNsLoaded=").append(nLNsLoaded).append('\n');
        sb.append("nDINsLoaded=").append(nDINsLoaded).append('\n');
        sb.append("nDBINsLoaded=").append(nDBINsLoaded).append('\n');
        sb.append("nDupCountLNsLoaded=").append(nDupCountLNsLoaded).
            append('\n');

        return sb.toString();
    }
}
