package org.bimserver.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import com.google.common.base.Charsets;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

public class StringUtils {

	public static StringBuilder stripEnd(StringBuilder sb, String needle) {
		if (needle.length() > sb.length()) {
			return sb;
		}
		if (sb.substring(sb.length() - (needle.length())).equals(needle)) {
			sb.delete(sb.length() - needle.length(), sb.length());
		}
		return sb;
	}

	public static String fill(String startValue, int length, String token) {
		return fill(new StringBuilder(startValue), length, token).toString();
	}

	public static StringBuilder fill(StringBuilder startValue, int length, String token) {
		while (startValue.length() < length) {
			startValue.append(token);
		}
		return startValue;
	}
	
	public static void main(String[] args) {
		String in = "Dit is een 'test',ik snap er nix van,dit moet 'ge,split' worden";
		int lastIndex = 0;
		while (lastIndex < in.length()) {
			int newIndex = nextString(in, lastIndex);
			String value = in.substring(lastIndex, newIndex-1);
			System.out.println(value);
			lastIndex = newIndex;
		}
	}
	
	public static int nextString(String in, int start) {
		int haakjes = 0;
		int quotes = 0;
		char c;
		int length = in.length();
		for (int i=start; i<length; i++) {
			c = in.charAt(i);
			if (c == ',') {
				if (haakjes == 0 && quotes == 0) {
					return i+1;
				}
			} else if (c == '(') {
				if (quotes == 0) {
					haakjes++;
				}
			} else if (c == ')') {
				if (quotes == 0) {
					haakjes--;
				}
			} else if (c == '\'') {
				if (quotes == 0) {
					quotes = 1;
				} else {
					quotes = 0;
				}
			}
		}
		return length + 1;
	}
	
	public static String getPrettyFileUrl(URL url) {
		try {
			String result = URLDecoder.decode(url.toString(), "UTF-8");
			if (result.startsWith("file:/")) {
				result = result.substring(6);
			}
			if (result.startsWith("jndi:/")) {
				result = result.substring(6);
			}
			result = result.replace("/", File.separator).replace("\\", File.separator);
			return result;
		} catch (UnsupportedEncodingException e) {
			// Cannot happen, UTF-8 is always available
		}
		return url.toString();
	}

	public static String firstUpperCase(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static String firstLowerCase(String name) {
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}

	public static String readFromFile(File file) {
		try {
			StringBuilder sb = new StringBuilder();
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int red = fis.read(buffer);
			while (red != -1) {
				sb.append(new String(buffer, 0, red, Charsets.UTF_8));
				red = fis.read(buffer);
			}
			fis.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}