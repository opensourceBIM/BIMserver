/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.utilint;

import java.io.Serializable;

/**
 * Per-stat Metadata for JE statistics. The name and description are meant to
 * available in a verbose display of stats, and should be meaningful for users.
 */
public class StatDefinition implements Comparable, Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final String description;

    public StatDefinition(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

    public int compareTo(Object other) {
        return toString().compareTo(other.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof StatDefinition)) {
            return false;
        }

        StatDefinition other = (StatDefinition) obj;
        return (name.equals(other.name));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
