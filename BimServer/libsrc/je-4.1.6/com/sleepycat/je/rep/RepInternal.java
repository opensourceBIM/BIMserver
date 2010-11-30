/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep;

import java.io.File;
import java.util.Properties;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.rep.impl.RepGroupImpl;
import com.sleepycat.je.rep.impl.RepImpl;
import com.sleepycat.je.rep.impl.node.FeederManager;
import com.sleepycat.je.rep.impl.node.Replica;

/**
 * @hidden
 * For internal use only. It serves to shelter methods that must be public to
 * be used by other BDBJE packages but that are not part of the public api
 * available to applications.
 */
public class RepInternal {

    public static RepImpl getRepImpl(ReplicatedEnvironment rep) {
        return rep.getRepImpl();
    }

    public static RepGroupImpl getRepGroupImpl(ReplicationGroup group) {
        return group.getRepGroupImpl();
    }

    public static ReplicationConfig
        makeReplicationConfig(Properties props, boolean validateParams)
        throws IllegalArgumentException {

        return new ReplicationConfig(props, validateParams);
    }

    public static int getNodeId(ReplicatedEnvironment rep) {
        return getRepImpl(rep).getNodeId();
    }

    /*
     * Create an environment handle but do not join the group as part of the
     * creation of this handle. This operation is only really meaningful in
     * the absence of existing handles that had already been used to join the
     * group.
     */
    public static ReplicatedEnvironment
        createDetachedEnv(File envHome,
                          ReplicationConfig repConfig,
                          EnvironmentConfig envConfig)
        throws DatabaseException {

        return new ReplicatedEnvironment(envHome, repConfig, envConfig,
                                         null,
                                         QuorumPolicy.SIMPLE_MAJORITY,
                                         false);
    }

    /**
     * Proxy to ReplicationMutableConfig.validateParams.
     */
    public static void disableParameterValidation
        (ReplicationMutableConfig config) {
        config.setOverrideValidateParams(false);
    }

    public static
        ReplicatedEnvironmentStats makeReplicatedEnvironmentStats
        (FeederManager feederManager, Replica replica, StatsConfig config) {

        return new ReplicatedEnvironmentStats(feederManager, replica, config);
    }

    public static void setAllowConvert(final ReplicationConfig repConfig,
                                       final boolean allowConvert) {
        repConfig.setAllowConvert(allowConvert);
    }

    public static boolean getAllowConvert(final ReplicationConfig repConfig) {
        return repConfig.getAllowConvert();
    }

    public static boolean isClosed(ReplicatedEnvironment replicatedEnvironment) {
        return replicatedEnvironment.isClosed();
    }
}
