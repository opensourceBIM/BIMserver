package org.bimserver.collada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Converter {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("tmp.txt"));
			PrintWriter out = new PrintWriter(new File("out.txt"));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				out.println("out.println(\"" + line.replace("\"", "\\\"") + "\");");
			}
			out.close();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
