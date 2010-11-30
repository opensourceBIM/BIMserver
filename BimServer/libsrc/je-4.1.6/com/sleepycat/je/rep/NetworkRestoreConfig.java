/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.util.List;

/**
 * NetworkRestoreConfig defines the configuration parameters used to configure
 * a NetworkRestore operation.
 *
 * @see NetworkRestore
 */
public class NetworkRestoreConfig {
    /* determines whether obsolete log files must be renamed or deleted. */
    private boolean retainLogFiles = true;

    /*
     * List (in priority order) of the members who should be contacted for the
     * the log files.
     */
    private List<ReplicationNode> logProviders;

    /**
     * Returns a boolean indicating whether existing log files should be
     * retained or deleted.
     *
     * @return true if log files must be retained
     */
    public boolean getRetainLogFiles() {
        return retainLogFiles;
    }

    /**
     * If true retains obsolete log files, by renaming them instead of deleting
     * them. The default is "true".
     * <p>
     * A renamed file has its <code>.jdb</code> suffix replaced by
     * <code>.bup</code> and an additional numeric monotonically increasing
     * numeric suffix. All files that were renamed as part of the same
     * NetworkRestore attempt will have the same numeric suffix.
     * <p>
     * For example, if files 00000001.jdb and files 00000002.jdb were rendered
     * obsolete, and 4 was the highest suffix in use for this environment when
     * the operation was initiated, then the files would be renamed as
     * 00000001.bup.5 and 00000002.bup.5.
     *
     * @param retainLogFiles if true retains obsolete log files
     *
     * @return this
     */
    public NetworkRestoreConfig setRetainLogFiles(boolean retainLogFiles) {
        this.retainLogFiles = retainLogFiles;
        return this;
    }

    /**
     * Returns the candidate list of members that may be used to obtain log
     * files.
     *
     * @return this
     */
    public List<ReplicationNode> getLogProviders() {
        return logProviders;
    }

    /**
     * Sets the prioritized list of members used to select a node from which to
     * obtain log files for the NetworkRestore operation. If a list is
     * supplied, NetworkRestore will only use nodes from this list, trying each
     * one in order.
     * <p>
     * The default value is null. If a null value is configured for
     * NetworkRestore, it will choose the least busy member with a current set
     * of logs, as the provider of log files.
     *
     * @param providers the list of members in priority order, or null
     *
     * @return this
     */
    public NetworkRestoreConfig
        setLogProviders(List<ReplicationNode>  providers) {

        logProviders = providers;
        return this;
    }
}
