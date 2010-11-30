/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.rep.impl;

import com.sleepycat.je.config.ConfigParam;

/**
 * A JE configuration parameter with an enumerated value
 */
public class EnumConfigParam<T extends Enum<T>> extends ConfigParam {

    /* The class denoting the enum type */
    private final Class<T> enumClass;

    public EnumConfigParam(String configName,
                           Enum<T> defaultValue,
                           boolean mutable,
                           boolean forReplication,
                           Class<T> enumClass) {
        super(configName, defaultValue.name(), mutable, forReplication);
        this.enumClass = enumClass;
    }

    /**
     * Returns the enumerator associated with the name
     *
     * @param enumName the string naming the enumerator
     *
     * @return the enumerator
     */
    public T getEnumerator(String enumName) {
        return Enum.valueOf(enumClass, enumName);
    }

    @Override
    public void validateValue(String value)
        throws IllegalArgumentException {

        /*
         * If validateValue() is called by through the ConfigParam
         * constructor, enumVal is not assigned yet, so we guard against
         * that happening.
         */
        if (enumClass != null) {
            Enum.valueOf(enumClass, value);
        }
    }
}
