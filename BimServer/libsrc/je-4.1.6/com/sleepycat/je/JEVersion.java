/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je;

import java.util.StringTokenizer;

/**
 * Berkeley DB Java Edition version information.  Versions consist of major,
 * minor and patch numbers.
 *
 * There is one JEVersion object per running JVM and it may be accessed using
 * the static field JEVersion.CURRENT_VERSION.
 */
public class JEVersion implements Comparable<JEVersion> {

    /**
     * Release version.
     */
    public static final JEVersion CURRENT_VERSION =
        new JEVersion(4, 1, 6, null);

    private final int majorNum;
    private final int minorNum;
    private final int patchNum;
    private final String name;

    private JEVersion(int majorNum, int minorNum, int patchNum, String name) {
        this.majorNum = majorNum;
        this.minorNum = minorNum;
        this.patchNum = patchNum;
        this.name = name;
    }

    public JEVersion(String version) {
        StringTokenizer st = new StringTokenizer(version, ".");

        majorNum = Integer.parseInt(st.nextToken());
        minorNum = Integer.parseInt(st.nextToken());
        patchNum = Integer.parseInt(st.nextToken());
        if (st.hasMoreTokens()) {
            name = st.nextToken();
        } else {
            name = null;
        }
    }

    @Override
    public String toString() {
        return getVersionString();
    }

    /**
     * Major number of the release version.
     *
     * @return The major number of the release version.
     */
    public int getMajor() {
        return majorNum;
    }

    /**
     * Minor number of the release version.
     *
     * @return The minor number of the release version.
     */
    public int getMinor() {
        return minorNum;
    }

    /**
     * Patch number of the release version.
     *
     * @return The patch number of the release version.
     */
    public int getPatch() {
        return patchNum;
    }

    /**
     * The numeric version string, without the patch tag.
     *
     * @return The release version
     */
    public String getNumericVersionString() {
        StringBuffer version = new StringBuffer();
        version.append(majorNum).append(".");
        version.append(minorNum).append(".");
        version.append(patchNum);
        return version.toString();
    }

    /**
     * Release version, suitable for display.
     *
     * @return The release version, suitable for display.
     */
    public String getVersionString() {
        StringBuffer version = new StringBuffer();
        version.append(majorNum).append(".");
        version.append(minorNum).append(".");
        version.append(patchNum);
        if (name != null) {
            version.append(".");
            version.append(name);
        }
        return version.toString();
    }

    /*
     * Return -1 if the current version is earlier than the comparedVersion.
     * Return 0 if the current version is the same as the comparedVersion.
     * Return 1 if the current version is later than the comparedVersion.
     */
    public int compareTo(JEVersion comparedVersion) {
        int result = 0;

        if (majorNum == comparedVersion.getMajor()) {
            if (minorNum == comparedVersion.getMinor()) {
                if (patchNum > comparedVersion.getPatch()) {
                    result = 1;
                } else if (patchNum < comparedVersion.getPatch()) {
                    result = -1;
                }
            } else if (minorNum > comparedVersion.getMinor()) {
                result = 1;
            } else {
                result = -1;
            }
        } else if (majorNum > comparedVersion.getMajor()) {
            result = 1;
        } else {
            result = -1;
        }

        return result;
    }

    /*
     * If its type is JEVersion, and the version numbers are the same,
     * then we consider these two versions equal.
     */
    @Override
    public boolean equals(Object o) {
        return (o instanceof JEVersion) && (compareTo((JEVersion) o) == 0);
    }

    /* Produce a unique hash code for JEVersion. */
    @Override
    public int hashCode() {
        return majorNum * 1000 * 1000 + minorNum * 1000 + patchNum;
    }
}
