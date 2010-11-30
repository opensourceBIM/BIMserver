/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl.networkRestore;

import com.sleepycat.je.utilint.StatDefinition;

/**
 * Per-stat Metadata for each NetworkBackup statistics.
 */
public class NetworkBackupStatDefinition {

    public static final String GROUP_NAME = "NetworkBackup";
    public static final String GROUP_DESC = "NetworkBackup statistics";

    public static StatDefinition BACKUP_FILE_COUNT =
        new StatDefinition
        ("backupFileCount",
         "The number of files that were needed to be transferred.");

    public static StatDefinition SKIP_COUNT =
        new StatDefinition
        ("skipCount",
         "The number of files that were skipped because they were already " +
         "present and current in the local environment directory.");

    public static StatDefinition FETCH_COUNT =
        new StatDefinition
        ("fetchCount",
         "The number of files that were actually transferred from the " +
         "server");

    public static StatDefinition DISPOSED_COUNT =
        new StatDefinition
        ("disposedCount",
         "The number of files that were disposed (deleted or renamed) from " +
         "the local environment directory.");
}
