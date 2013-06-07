package org.bimserver.utils;

import java.util.Stack;

public class Tokenizer {

	private static class Pair {
		public int oldLeft;
		public int oldRight;
		public String leftChar;
		public String rightChar;

		public Pair(String leftChar, String rightChar, int oldLeft, int oldRight) {
			this.leftChar = leftChar;
			this.rightChar = rightChar;
			this.oldLeft = oldLeft;
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
		int leftIndex = input.indexOf(startChar, leftPositionInclude);
		if (leftIndex == -1 || leftIndex > rightPositionInclude) {
			throw new TokenizeException("No " + startChar + " found in " + input.substring(leftPositionInclude, rightPositionInclude));
		}
		int rightIndex = input.lastIndexOf(endChar, rightPositionInclude);
		if (rightIndex == -1 || rightIndex < leftPositionInclude) {
			throw new TokenizeException("No " + endChar + " found in " + input.substring(leftPositionInclude, rightPositionInclude));
		}
		zoomStack.push(new Pair(startChar, endChar, this.leftPositionInclude, this.rightPositionInclude));
		this.leftPositionInclude = leftIndex + 1;
		this.rightPositionInclude = rightIndex - 1;
		return this;
	}

	public Tokenizer readComma() throws TokenizeException {
		String x = toString().trim();
		if (!x.startsWith(",")) {
			throw new TokenizeException("No comma at starting index in " + x);
		}
		this.leftPositionInclude++;
		return this;
	}

	public String readSingleQuoted() throws TokenizeException {
		String x = toString().trim();
		if (!x.startsWith("'")) {
			throw new TokenizeException("No opening \"'\" found in " + x);
		}
		int endIndex = x.indexOf("'", 1);
		if (endIndex == -1) {
			throw new TokenizeException("No closing \"'\" found in " + x);
		}
		this.leftPositionInclude += endIndex + 1;
		return x.substring(1, endIndex);
	}

	public void shouldBeFinished() throws TokenizeException {
//		if (leftPosition != rightPosition) {
//			throw new TokenizeException("");
//		}
	}

	public void zoomOut() throws TokenizeException {
		Pair pair = zoomStack.pop();
		String x = input.substring(this.leftPositionInclude, this.leftPositionInclude + 1);
		if (!x.equals(pair.rightChar)) {
			throw new TokenizeException(pair.rightChar + " expected, got " + x);
		}
		this.leftPositionInclude++;
		this.rightPositionInclude = pair.oldRight;
	}

	public String readAll() {
		String substring = input.substring(leftPositionInclude, rightPositionInclude + 1);
		leftPositionInclude = rightPositionInclude + 1;
		return substring;
	}
}