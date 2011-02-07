package org.bimserver.ifc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Somehow at least JAXB thinks the IFC-XML XSD is not valid because elements have the same 
 * names as the simple and complex types, this code was used to try and fix that
 */
public class SchemaSimplifier {
	private static final Logger LOGGER = LoggerFactory.getLogger(SchemaSimplifier.class);
	
	public static void main(String[] args) {
		new SchemaSimplifier().start();
	}

	private void start() {
		File inFile = new File("ifcxml/IFC2X3.xsd");
		File outFile = new File("ifcxml/IFC2X3_simplified.xsd");
		PrintStream out;
		try {
			out = new PrintStream(outFile);
			Scanner scanner = new Scanner(inFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.contains("<xs:element")) {
					if (line.contains("name=")) {
						int indexName = line.indexOf("name=") + 6;
						int endIndex = line.indexOf("\"", indexName + 1);
						String newName = line.substring(indexName, endIndex) + "Type";
						line = line.substring(0, indexName) + newName + line.substring(endIndex);
					}
					if (line.contains("ref=")) {
						int indexName = line.indexOf("ref=") + 5;
						int endIndex = line.indexOf("\"", indexName + 1);
						String newName = line.substring(indexName, endIndex) + "Type";
						if (!newName.contains("ex:")) {
							line = line.substring(0, indexName) + newName + line.substring(endIndex);
						}
					}
					if (line.contains("substitutionGroup=")) {
						int indexName = line.indexOf("substitutionGroup=") + 19;
						int endIndex = line.indexOf("\"", indexName + 1);
						String newName = line.substring(indexName, endIndex) + "Type";
						if (!newName.contains("ex:")) {
							line = line.substring(0, indexName) + newName + line.substring(endIndex);
						}
					}
				}
				out.println(line);
			}
			scanner.close();
			out.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
	}
}
