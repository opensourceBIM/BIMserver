package org.bimserver.utils;

public class TestTokenizer {
	public static void main(String[] args) {
		Tokenizer tokenizer = new Tokenizer("(('ArchiCAD 11.00 Release 1 generated IFC file.','Build Number of the Ifc 2x3 interface: 63090 (13-06-2008)\\X\\0A'),'2;1')");
		try {
			tokenizer.zoomIn("(", ")");
			tokenizer.zoomIn("(", ")");
			System.out.println("Description: " + tokenizer.readSingleQuoted());
			tokenizer.readComma();
			System.out.println("Build: " + tokenizer.readSingleQuoted());
			tokenizer.zoomOut();
			tokenizer.readComma();
			tokenizer.readSingleQuoted();
			tokenizer.zoomOut();
			tokenizer.shouldBeFinished();
		} catch (TokenizeException e) {
			e.printStackTrace();
		}
	}
}
