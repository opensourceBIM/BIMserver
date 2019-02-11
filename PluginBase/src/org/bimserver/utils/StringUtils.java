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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class StringUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);
	
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
		int parentheses = 0;
		int quotes = 0;
		char c;
		int length = in.length();
		int escapeMode = 0;
		
		// 5: Just had a slash, looking for * to complete a comment block start
		// 7: Just had a *, looking for / to complete a comment block end
		
		for (int i=start; i<length; i++) {
			c = in.charAt(i);
			if (escapeMode == 5 && c != '*') {
				escapeMode = 0;
			}
			if (escapeMode == 7 && c != '/') {
				escapeMode = 0;
			}
			if (c == ',') {
				if (parentheses == 0 && quotes == 0 && escapeMode != 3 && escapeMode != 6) {
					return i+1;
				}
			} else if (c == '(') {
				if (quotes == 0) {
					parentheses++;
				}
			} else if (c == ')') {
				if (quotes == 0) {
					parentheses--;
				}
			} else if (c == '\'' && escapeMode != 3) {
				if (quotes == 0) {
					quotes = 1;
				} else {
					quotes = 0;
				}
			} else if (c == '\\') {
				if (escapeMode == 2) {
					escapeMode = 3;
					continue;
				} else {
					escapeMode = 1;
				}
			} else if (c == '/') {
				if (escapeMode == 7) {
					escapeMode = 0;
				} else if (quotes == 0) {
					escapeMode = 5;
				}
			} else if (c == '*') {
				if (escapeMode == 5) {
					escapeMode = 6;
				} else if (escapeMode == 6) {
					escapeMode = 7;
				}
			} else if (c == 'S' && escapeMode == 1) {
				escapeMode = 2;
			}
			if (escapeMode == 3) {
				escapeMode = 0;
			}
		}
		return length + 1;
	}

	public static int nextField(String in, int start) {
		char c;
		int length = in.length();
		int escapeMode = 0;
		for (int i=start; i<length; i++) {
			c = in.charAt(i);
			if (c == ' ') {
				// Continue
			} else if (c == '/') {
				if (escapeMode == 7) {
					escapeMode = 0;
				} else {
					escapeMode = 5;
				}
			} else if (c == '*') {
				if (escapeMode == 5) {
					escapeMode = 6;
				} else if (escapeMode == 6) {
					escapeMode = 7;
				}
			} else if (c == '\'' || c == '(' || c == '$') {
				if (escapeMode != 6) {
					return i;
				}
				escapeMode = 0;
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
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	public static String concat(List<String> items, String quotation, String separation) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<items.size(); i++) {
			sb.append(quotation + items.get(i) + quotation);
			if (i < items.size() - 1) {
				sb.append(separation);
			}
		}
		return sb.toString();
	}

	public static String stripHttps(String baseAddress) {
		if (baseAddress.startsWith("http://")) {
			return baseAddress.substring(7);
		} else if (baseAddress.startsWith("https://")) {
			return baseAddress.substring(8);
		}
		return baseAddress;
	}

	public static String gen(String string, int indent) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<indent; i++) {
			sb.append(string);
		}
		return sb.toString();
	}
}