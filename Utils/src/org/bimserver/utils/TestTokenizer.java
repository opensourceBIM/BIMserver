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
			System.out.println("Version: " + tokenizer.readSingleQuoted());
			tokenizer.zoomOut();
			tokenizer.shouldBeFinished();

			
			
			tokenizer = new Tokenizer("(('ArchiCAD 11.00 Release 1 generated IFC file.','Build Number of the Ifc 2x3 interface: 63090 (13-06-2008)\\X\\0A'),'2;1')");
			tokenizer.zoomIn("(", ")");
			tokenizer.zoomIn("(", ")");
			System.out.println(tokenizer.readAll());
			tokenizer.zoomOut();
			tokenizer.readComma();
			System.out.println(tokenizer.readSingleQuoted());
			tokenizer.zoomOut();
			tokenizer.shouldBeFinished();
			
			
			tokenizer = new Tokenizer("('S:\\[IFC]\\COMPLETE-BUILDINGS\\FZK-MODELS\\Buerogebaeude-Zones\\ArchiCAD-11\\Institute-Var-2\\IFC2x3\\AC11-Institute-Var-2-IFC.ifc','2008-07-03T15:22:43',('Architect'),('Building Designer Office'),'PreProc - EDM 4.5.0033','Windows System','The authorising person')");
			tokenizer.zoomIn("(", ")");
			System.out.println(tokenizer.readSingleQuoted());
			System.out.println(tokenizer.readComma().readSingleQuoted());
			System.out.println(tokenizer.readComma().zoomIn("(", ")").readSingleQuoted());
			tokenizer.zoomOut();
			System.out.println(tokenizer.readComma().zoomIn("(", ")").readSingleQuoted());
			tokenizer.zoomOut();
			System.out.println(tokenizer.readComma().readSingleQuoted());
			System.out.println(tokenizer.readComma().readSingleQuoted());
			System.out.println(tokenizer.readComma().readSingleQuoted());
			tokenizer.zoomOut();
			tokenizer.shouldBeFinished();
		} catch (TokenizeException e) {
			e.printStackTrace();
		}
	}
}