/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.config;

/**
 * A JE configuration parameter with an integer value.
 */
public class LongConfigParam extends ConfigParam {

    private static final String DEBUG_NAME = LongConfigParam.class.getName();

    private Long min;
    private Long max;

    public LongConfigParam(String configName,
                           Long minVal,
                           Long maxVal,
                           Long defaultValue,
                           boolean mutable,
                           boolean forReplication) {

        /* defaultValue must not be null. */
        super(configName, defaultValue.toString(), mutable, forReplication);
        min = minVal;
        max = maxVal;
    }

    /**
     * Self validate. Check mins and maxs
     */
    private void validate(Long value)
        throws IllegalArgumentException {

        if (value != null) {
            if (min != null) {
                if (value.compareTo(min) < 0) {
                    throw new IllegalArgumentException
                        (DEBUG_NAME + ":" +
                         " param " + name +
                         " doesn't validate, " +
                         value +
                         " is less than min of "
                         + min);
                }
            }
            if (max != null) {
                if (value.compareTo(max) > 0) {
                    throw new IllegalArgumentException
                        (DEBUG_NAME + ":" +
                         " param " + name +
                         " doesn't validate, " +
                         value +
                         " is greater than max "+
                         " of " +  max);
                }
            }
        }
    }

    @Override
    public void validateValue(String value)
        throws IllegalArgumentException {

        try {
            validate(new Long(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException
                (DEBUG_NAME + ": " +  value + " not valid value for " + name);
        }
    }
}
