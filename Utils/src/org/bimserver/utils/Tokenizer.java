package org.bimserver.utils;

public class Tokenizer {

	private String input;
	private int position = 0;
	
	public Tokenizer(String input) {
		this.input = input;
	}
	
	public Tokenizer readSingle(String character) throws TokenizeException {
		int index = input.indexOf(character, position);
		if (index == -1) {
			throw new TokenizeException("No " + character + " found in " + input + " after position " + position);
		}
		position += index;
		return new Tokenizer(input.substring(0, index));
	}
	
	public Tokenizer readWrapped(String startChar, String endChar) throws TokenizeException {
		int startIndex = input.indexOf(startChar);
		if (startIndex == -1) {
			throw new TokenizeException("No " + startChar + " found in " + input);
		}
		int endIndex = input.lastIndexOf(endChar);
		if (endIndex == -1) {
			throw new TokenizeException("No " + endChar + " found in " + input);
		}
		return new Tokenizer(input.substring(startIndex + 1, endIndex));
	}
	
	public Tokenizer readWrapped(String startAndEndChar) throws TokenizeException {
		return readWrapped(startAndEndChar, startAndEndChar);
	}
	
	@Override
	public String toString() {
		return input;
	}

	public void zoomIn(String startChar, String endChar) {
	}

	public void readComma() {
	}

	public String readSingleQuoted() throws TokenizeException {
		return null;
	}

	public void shouldBeFinished() {
	}

	public void zoomOut() {
	}
}