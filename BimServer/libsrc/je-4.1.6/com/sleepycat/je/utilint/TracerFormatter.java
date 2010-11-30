/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Formatter for java.util.logging output.
 */
public class TracerFormatter extends Formatter {

    private final Date date;
    private final DateFormat formatter;
    private String envName;

    public TracerFormatter() {
        date = new Date();
        formatter = makeDateFormat();
    }

    public TracerFormatter(String envName) {
        this();
        this.envName = envName;
    }

    /* The date and formatter are not thread safe. */
    protected synchronized String getDate(long millis) {
        date.setTime(millis);

        return formatter.format(date);
    }

    /**
     * Format the log record in this form:
     *   <short date> <short time> <message level> <message>
     * @param record the log record to be formatted.
     * @return a formatted log record
     */
    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();

        String dateVal = getDate(record.getMillis());
        sb.append(dateVal);
        sb.append(" ");
        sb.append(record.getLevel().getLocalizedName());
        appendEnvironmentName(sb);
        sb.append(formatMessage(record));
        sb.append("\n");

        getThrown(record, sb);

        return sb.toString();
    }

    protected void appendEnvironmentName(StringBuilder sb) {
        if (envName != null) {
            sb.append(" [" + envName + "]");
        }
    }

    protected void getThrown(LogRecord record, StringBuilder sb) {
        if (record.getThrown() != null) {
            try {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                record.getThrown().printStackTrace(pw);
                pw.close();
                sb.append(sw.toString());
            } catch (Exception ex) {
                /* Ignored. */
            }
        }
    }

    /* For unit test support */
    public static DateFormat makeDateFormat() {
        return new SimpleDateFormat("yyMMdd HH:mm:ss:SSS");
    }
}
