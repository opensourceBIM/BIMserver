/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.dbi;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentFailureException;
import com.sleepycat.je.log.LogUtils;
import com.sleepycat.je.log.Loggable;

/**
 * DatabaseImpl Ids are wrapped in a class so they can be logged.
 */
public class DatabaseId implements Comparable<DatabaseId>, Loggable {

    /**
     * The unique id of this database.
     */
    private int id;

    /**
     *
     */
    public DatabaseId(int id) {
        this.id = id;
    }

    /**
     * Uninitialized database id, for logging.
     */
    public DatabaseId() {
    }

    /**
     * @return id value
     */
    public int getId() {
        return id;
    }

    /**
     * @return id as bytes, for use as a key
     */
    public byte[] getBytes()
        throws DatabaseException {

        try {
            return toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException UEE) {
            throw EnvironmentFailureException.unexpectedException(UEE);
        }
    }

    /**
     * Compare two DatabaseImpl Id's.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DatabaseId)) {
            return false;
        }

        return ((DatabaseId) obj).id == id;
    }

    public int hashCode() {
        return id;
    }

    public String toString() {
        return Integer.toString(id);
    }

    /**
     * see Comparable#compareTo
     */
    public int compareTo(DatabaseId o) {
        if (o == null) {
            throw EnvironmentFailureException.unexpectedState("null arg");
        }

        if (id == o.id) {
            return 0;
        } else if (id > o.id) {
            return 1;
        } else {
            return -1;
        }
    }

    /*
     * Logging support.
     */

    /**
     * @see Loggable#getLogSize
     */
    public int getLogSize() {
        return LogUtils.getPackedIntLogSize(id);
    }

    /**
     * @see Loggable#writeToLog
     */
    public void writeToLog(ByteBuffer logBuffer) {
        LogUtils.writePackedInt(logBuffer, id);
    }

    /**
     * @see Loggable#readFromLog
     */
    public void readFromLog(ByteBuffer itemBuffer, int entryVersion) {
        id = LogUtils.readInt(itemBuffer, (entryVersion < 6));
    }

    /**
     * @see Loggable#dumpLog
     */
    public void dumpLog(StringBuilder sb, boolean verbose) {
        sb.append("<dbId id=\"");
        sb.append(id);
        sb.append("\"/>");
    }

    /**
     * @see Loggable#getTransactionId
     */
    public long getTransactionId() {
        return 0;
    }

   /**
     * @see Loggable#logicalEquals
     */
    public boolean logicalEquals(Loggable other) {

        if (!(other instanceof DatabaseId))
            return false;

        return id == ((DatabaseId) other).id;
    }
}
