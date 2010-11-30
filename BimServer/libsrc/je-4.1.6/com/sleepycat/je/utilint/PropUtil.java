/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * Convenience methods for handling JE properties.
 */
public class PropUtil {

    /**
     * Converts the given duration (interval value plus unit) to milliseconds,
     * ensuring that any given value greater than zero converts to at least one
     * millisecond to avoid a zero millisecond result, since Object.wait(0)
     * waits forever.
     *
     * @throws IllegalArgumentException if the duration argument is illegal.
     * Thrown via API setter methods such as Transaction.setLockTimeout.
     */
    public static int durationToMillis(final long val, final TimeUnit unit) {
        if (val == 0) {
            /* Allow zero duration with null unit. */
            return 0;
        }
        if (unit == null) {
            throw new IllegalArgumentException
                ("Duration TimeUnit argument may not be null if interval " +
                 "is non-zero");
        }
        if (val < 0) {
            throw new IllegalArgumentException
                ("Duration argument may not be negative: " + val);
        }
        final long newVal = unit.toMillis(val);
        if (newVal == 0) {
            /* Input val is positive, so return at least one. */
            return 1;
        }
        if (newVal > Integer.MAX_VALUE) {
            throw new IllegalArgumentException
                ("Duration argument may not be greater than " +
                 "Integer.MAX_VALUE milliseconds: " + newVal);
        }
        return (int) newVal;
    }

    /**
     * Converts the given duration value in milliseconds to the given unit.
     *
     * @throws IllegalArgumentException if the unit is null. Thrown via API
     * getter methods such as Transaction.getLockTimeout.
     */
    public static long millisToDuration(final int val, final TimeUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException
                ("TimeUnit argument may not be null");
        }
        return unit.convert(val, TimeUnit.MILLISECONDS);
    }

    /**
     * Parses a String duration property (time + optional unit) and returns the
     * value in millis.
     *
     * @throws IllegalArgumentException if the duration string is illegal.
     * Thrown via the Enviornment ctor and setMutableConfig, and likewise for a
     * ReplicatedEnvironment.
     */
    public static int parseDuration(final String property) {
        StringTokenizer tokens =
            new StringTokenizer(property.toUpperCase(java.util.Locale.ENGLISH),
                                " \t");
        if (!tokens.hasMoreTokens()) {
            throw new IllegalArgumentException("Duration argument is empty");
        }
        final long time;
        try {
            time = Long.parseLong(tokens.nextToken());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException
                ("Duration argument does not start with a long integer: " +
                 property);
        }
        /* Convert time from specified unit to millis. */
        long millis;
        if (tokens.hasMoreTokens()) {
            final String unitName = tokens.nextToken();
            if (tokens.hasMoreTokens()) {
                throw new IllegalArgumentException
                    ("Duration argument has extra characters after unit: " +
                     property);
            }
            try {
                final TimeUnit unit = TimeUnit.valueOf(unitName);
                millis = TimeUnit.MILLISECONDS.convert(time, unit);
            } catch (IllegalArgumentException e) {
                try {
                    final IEEETimeUnit unit = IEEETimeUnit.valueOf(unitName);
                    millis = unit.toMillis(time);
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException
                        ("Duration argument has unknown unit name: " +
                         property);
                }
            }
        } else {
            /* Default unit is micros. */
            millis = TimeUnit.MILLISECONDS.convert(time, TimeUnit.MICROSECONDS);
        }
        /* If input val is positive, return at least one. */
        if (time > 0 && millis == 0) {
            return 1;
        }
        if (millis > Integer.MAX_VALUE) {
            throw new IllegalArgumentException
                ("Duration argument may not be greater than " +
                 "Integer.MAX_VALUE milliseconds: " + property);
        }
        return (int) millis;
    }

    /**
     * Formats a String duration property (time + optional unit).
     * value in millis.
     */
    public static String formatDuration(long time, TimeUnit unit) {
        return String.valueOf(time) + ' ' + unit.name();
    }

    /**
     * Support for conversion of IEEE time units.  Although names are defined
     * in uppercase, we uppercase the input string before calling
     * IEEETimeUnit.valueOf, in order to support input names in both upper and
     * lower case.
     */
    private enum IEEETimeUnit {

        /* Nanoseconds */
        NS() {
            long toMillis(long val) {
                return millisUnit.convert(val, TimeUnit.NANOSECONDS);
            }
        },

        /* Microseconds */
        US() {
            long toMillis(long val) {
                return millisUnit.convert(val, TimeUnit.MICROSECONDS);
            }
        },

        /* Milliseconds */
        MS() {
            long toMillis(long val) {
                return millisUnit.convert(val, TimeUnit.MILLISECONDS);
            }
        },

        /* Seconds */
        S() {
            long toMillis(long val) {
                return millisUnit.convert(val, TimeUnit.SECONDS);
            }
        },

        /* Minutes */
        MIN() {
            long toMillis(long val) {
                return val * 60000;
            }
        },

        /* Hours */
        H() {
            long toMillis(long val) {
                return val * 3600000;
            }
        };

        private static final TimeUnit millisUnit = TimeUnit.MILLISECONDS;

        abstract long toMillis(long val);
    }
}
