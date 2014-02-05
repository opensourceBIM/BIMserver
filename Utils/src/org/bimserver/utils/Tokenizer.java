package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Stack;

public class Tokenizer {

	private static class Pair {
		public int oldRight;
		public String rightChar;

		public Pair(String rightChar, int oldRight) {
			this.rightChar = rightChar;
			this.oldRight = oldRight;
		}
	}
	
	private final String input;
	private int leftPositionInclude;
	private int rightPositionInclude;
	private Stack<Pair> zoomStack = new Stack<Pair>();
	
	public Tokenizer(String input) {
		this.input = input;
		leftPositionInclude = 0;
		rightPositionInclude = input.length() - 1;
	}
	
	@Override
	public String toString() {
		return input.substring(leftPositionInclude, rightPositionInclude + 1);
	}

	public Tokenizer zoomIn(String startChar, String endChar) throws TokenizeException {
		String trimmed = toString().trim();
		if (!trimmed.startsWith(startChar)) {
			throw new TokenizeException("No " + startChar + " found in " + input.substring(leftPositionInclude, rightPositionInclude));
		}
		int leftIndex = input.indexOf(startChar, leftPositionInclude);
		int rightIndex = -1;
		int depth = 0;
		for (int i=leftIndex + 1; i<=rightPositionInclude; i++) {
			String c = input.substring(i, i + endChar.length());
			if (c.equals(endChar)) {
				if (depth == 0) {
					rightIndex = i;
					break;
				} else {
					depth--;
				}
			} else if (c.equals(startChar)) {
				depth++;
			}
		}
		if (rightIndex == -1 || rightIndex < leftPositionInclude) {
			throw new TokenizeException("No " + endChar + " found in " + input.substring(leftPositionInclude, rightPositionInclude));
		}
		zoomStack.push(new Pair(endChar, this.rightPositionInclude));
		this.leftPositionInclude = leftIndex + startChar.length();
		this.rightPositionInclude = rightIndex - endChar.length();
		return this;
	}

	public Tokenizer readComma() throws TokenizeException {
		String toString = toString();
		String x = toString.trim();
		if (!x.startsWith(",")) {
			throw new TokenizeException("No comma at starting index in " + x);
		}
		int offset = toString.indexOf(",");
		this.leftPositionInclude += offset + 1;
		return this;
	}

	public String readSingleQuoted() throws TokenizeException {
		String toString = toString();
		String trimmed = toString.trim();
		if (!trimmed.startsWith("'")) {
			throw new TokenizeException("No opening \"'\" found in " + trimmed);
		}
		int add = toString.indexOf("'");
		int endIndex = trimmed.indexOf("'", 1);
		while (trimmed.length() > endIndex + 1 && trimmed.charAt(endIndex + 1) == '\'') {
			// Two quotes
			endIndex = trimmed.indexOf("'", endIndex + 2);
		}
		if (endIndex == -1) {
			throw new TokenizeException("No closing \"'\" found in " + trimmed);
		}
		this.leftPositionInclude += endIndex + add + 1;
		return trimmed.substring(1, endIndex);
	}

	public void shouldBeFinished() throws TokenizeException {
//		if (leftPosition != rightPosition) {
//			throw new TokenizeException("");
//		}
	}

	public void zoomOut() throws TokenizeException {
		Pair pair = zoomStack.pop();
		String trimmed = input.substring(this.leftPositionInclude, pair.oldRight + 1).trim();
		String x = trimmed.substring(0, pair.rightChar.length());
		int offset = input.indexOf(pair.rightChar, this.leftPositionInclude);
		if (!x.equals(pair.rightChar)) {
			throw new TokenizeException(pair.rightChar + " expected, got " + x);
		}
		this.leftPositionInclude = offset + pair.rightChar.length();
		this.rightPositionInclude = pair.oldRight;
	}

	public String readAll() {
		String substring = input.substring(leftPositionInclude, rightPositionInclude + 1);
		leftPositionInclude = rightPositionInclude + 1;
		return substring;
	}

	public boolean isEmpty() {
		return toString().trim().isEmpty();
	}
	
	public boolean nextIsAComma() throws TokenizeException {
		String toString = toString();
		String x = toString.trim();
		return x.startsWith(",");
	}

	public boolean startsWith(String string) {
		return toString().trim().startsWith(string);
	}

	public boolean nextIsDollar() {
		String toString = toString();
		String x = toString.trim();
		return x.startsWith("$");
	}

	public Tokenizer readDollar() throws TokenizeException {
		String toString = toString();
		String x = toString.trim();
		if (!x.startsWith("$")) {
			throw new TokenizeException("No dollar at starting index in " + x);
		}
		int offset = toString.indexOf("$");
		this.leftPositionInclude += offset + 1;
		return this;
	}
}