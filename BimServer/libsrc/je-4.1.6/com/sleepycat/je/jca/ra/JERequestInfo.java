/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.jca.ra;

import java.io.File;

import javax.resource.spi.ConnectionRequestInfo;

import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.TransactionConfig;

public class JERequestInfo implements ConnectionRequestInfo {
    private File rootDir;
    private EnvironmentConfig envConfig;
    private TransactionConfig transConfig;

    public JERequestInfo(File rootDir,
                         EnvironmentConfig envConfig,
                         TransactionConfig transConfig) {
        this.rootDir = rootDir;
        this.envConfig = envConfig;
        this.transConfig = transConfig;
    }

    File getJERootDir() {
        return rootDir;
    }

    EnvironmentConfig getEnvConfig() {
        return envConfig;
    }

    TransactionConfig getTransactionConfig() {
        return transConfig;
    }

    public boolean equals(Object obj) {
        JERequestInfo info = (JERequestInfo) obj;
        return rootDir.equals(info.rootDir);
    }

    public int hashCode() {
        return rootDir.hashCode();
    }

    public String toString() {
        return "</JERequestInfo rootDir=" + rootDir.getAbsolutePath() + "/>";
    }
}
