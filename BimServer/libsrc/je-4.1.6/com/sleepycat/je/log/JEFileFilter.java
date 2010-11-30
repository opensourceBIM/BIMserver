/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.je.log;

import java.io.File;
import java.io.FilenameFilter;
import java.util.StringTokenizer;

/**
 * JEFileFilters are used for listing je files.
 */
class JEFileFilter implements FilenameFilter {
    String[] suffix;
    long minFileNumber = 0;
    long maxFileNumber = -1;

    JEFileFilter(String[] suffix) {
        this.suffix = suffix;
    }

    /**
     * @param maxFileNumber this filter will only return
     * files that are numbers <= maxFileNumber.
     */
    JEFileFilter(String[] suffix, long maxFileNumber) {
        this.suffix = suffix;
        this.maxFileNumber = maxFileNumber;
    }

    /**
     * @param minFileNumber this filter will only return files that are >=
     * minFileNumber.
     * @param maxFileNumber this filter will only return
     * files that are numbers <= maxFileNumber.
     */
    JEFileFilter(String[] suffix, long minFileNumber, long maxFileNumber) {
        this.suffix = suffix;
        this.minFileNumber = minFileNumber;
        this.maxFileNumber = maxFileNumber;
    }

    private boolean matches(String fileSuffix) {
        for (int i = 0; i < suffix.length; i++) {
            if (fileSuffix.equalsIgnoreCase(suffix[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * A JE file has to be of the format nnnnnnnn.suffix.
     */
    public boolean accept(File dir, String name) {
        boolean ok = false;
        StringTokenizer tokenizer = new StringTokenizer(name, ".");
        /* There should be two parts. */
        int nTokens = tokenizer.countTokens();
        if (nTokens == 2 || nTokens == 3) {
            boolean hasVersion = (nTokens == 3);
            String fileNumber = tokenizer.nextToken();
            String fileSuffix = "." + tokenizer.nextToken();
            String fileVersion = (hasVersion ? tokenizer.nextToken() : null);

            /* Check the length and the suffix. */
            if ((fileNumber.length() == 8) &&
                matches(fileSuffix)) {
                //(fileSuffix.equalsIgnoreCase(suffix))) {

                /* The first part should be a number. */
                try {
                    long fileNum = Long.parseLong(fileNumber, 16);
                    if (fileNum < minFileNumber) {
                        ok = false;
                    } else if ((fileNum <= maxFileNumber) ||
                               (maxFileNumber == -1)) {
                        ok = true;
                    }
                } catch (NumberFormatException e) {
                    ok = false;
                }
                if (hasVersion) {
                    try {
                        Integer.parseInt(fileVersion);
                        ok = true;
                    } catch (NumberFormatException e) {
                        ok = false;
                    }
                }
            }
        }

        return ok;
    }
}
