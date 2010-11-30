/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log.entry;

import java.nio.ByteBuffer;

import com.sleepycat.je.log.FileHeader;
import com.sleepycat.je.log.LogEntryHeader;
import com.sleepycat.je.log.LogEntryType;
import com.sleepycat.je.log.Loggable;

/**
 * Contains a FileHeader entry.
 */
public class FileHeaderEntry extends SingleItemEntry {

    /**
     * Construct a log entry for reading.
     */
    public FileHeaderEntry(Class<?> logClass) {
        super(logClass);
    }

    /**
     * Construct a log entry for writing.
     */
    public FileHeaderEntry(LogEntryType entryType, Loggable item) {
        super(entryType, item);
    }

    /**
     * For a file header, the version is not available until after reading the
     * item.  Set the version in the entry header so it can be used by
     * FileReaders, etc.  [#16939]
     */
    public void readEntry(LogEntryHeader header,
                          ByteBuffer entryBuffer,
                          boolean readFullItem) {
        super.readEntry(header, entryBuffer, readFullItem);
        FileHeader entry = (FileHeader) getMainItem();
        header.setFileHeaderVersion(entry.getLogVersion());
    }
}
