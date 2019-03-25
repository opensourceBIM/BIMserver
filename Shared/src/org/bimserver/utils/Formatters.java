package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class Formatters {
	private Formatters() {
	}

	public static String bytesToString(long bytes) {
		Formatter formatter = new Formatter();
		try {
			if (bytes > 1024) {
				if (bytes > 1024L * 1024L) {
					if (bytes > 1024L * 1024L * 1024L) {
						if (bytes > 1024L * 1024L * 1024L * 1024L) {
							return formatter.format("%9.2f", ((float) bytes / (float) (1024L * 1024L * 1024L * 1024L))).toString().trim() + " TB";
						} else {
							return formatter.format("%9.2f", (float) bytes / (float) (1024L * 1024L * 1024L)).toString().trim() + " GB";
						}
					} else {
						return formatter.format("%9.2f", ((float) bytes / (float) (1024L * 1024L))).toString().trim() + " MB";
					}
				} else {
					return formatter.format("%9.2f", ((float) bytes / (float) 1024L)).toString().trim() + " KB";
				}
			} else {
				return "" + bytes + " B";
			}
		} finally {
			formatter.close();
		}
	}

	public static final String timeSpanToString(GregorianCalendar startGc, GregorianCalendar stopGc) {
		long millis = stopGc.getTimeInMillis() - startGc.getTimeInMillis();
		return millis / 60000 + " minutes";
	}
	
	public static final String nanosToString(long nanos) {
		return millisecondsToString(nanos / 1000000);
	}
	
	public static final String millisecondsToString(long millis) {
		if (millis < 1000) {
			return millis + "ms";
		}
		if (millis < 60 * 1000) {
			return (millis / 1000f) + "s";
		}
		if (millis < 60 * 60 * 1000) {
			long m = millis / 60000;
			long s = (millis % 60000) / 1000;
			return addBefore(m, 2, "0") + "m " + addBefore(s, 2, "0") + "s";
		}
		if (millis < 24 * 60 * 60 * 1000) {
			long h = millis / 3600000;
			long m = (millis % 3600000) / 60000;
			return addBefore(h, 2, "0") + "h " + addBefore(m, 2, "0") + "m";
		}
		long d = millis / (24 * 60 * 60 * 1000);
		long u = millis % (24 * 60 * 60 * 1000);
		return d + "d " + addBefore(u, 2, "0") + "h";
	}

	@SuppressWarnings("unused")
	private static String addAfter(long value, int zeros, String c) {
		String result = String.valueOf(value);
		while (result.length() < zeros) {
			result += c;
		}
		return result;
	}

	private static String addBefore(long value, int zeros, String c) {
		String result = String.valueOf(value);
		while (result.length() < zeros) {
			result = c + result;
		}
		return result;
	}

	@SuppressWarnings("unused")
	private static void check(long millis, String result) {
		if (millisecondsToString(millis).equals(result)) {
			System.out.println("OK  ");
		} else {
			System.err.println("ERR: format(" + millis + ") !equals (" + result + ") but (" + millisecondsToString(millis) + ")");
		}
	}

	public static void main(String[] args) {
//		check(1000, "1s");
//		check(60000, "01:00m");
//		check(55, "55ms");
//		check(69000, "01:09m");
//		check(13560000, "03:46h");
		
		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar before = new GregorianCalendar();
		before.add(Calendar.DAY_OF_YEAR, -60);
		System.out.println(before.getTime());
		System.out.println(timeSpanToString(before, now));
	}

	public static String formatNanoSeconds(long l) {
		return (l / 1000000) + " ms";
	}

	public static void dumpKey(String tableName, byte[] key) {
		if (key.length != 16) {
			return;
		}
		byte[] pidBytes = new byte[4];
		byte[] oidBytes = new byte[8];
		byte[] ridBytes = new byte[4];
		System.arraycopy(key, 0, pidBytes, 0, 4);
		System.arraycopy(key, 4, oidBytes, 0, 8);
		System.arraycopy(key, 12, ridBytes, 0, 4);
		int pid = BinUtils.byteArrayToInt(pidBytes);
		long oid = BinUtils.byteArrayToLong(oidBytes);
		int rid = BinUtils.byteArrayToInt(ridBytes);
		System.out.println(tableName + ", pid: " + pid + ", oid: " + oid + ", rid: " + rid);
	}
}
