package org.bimserver.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.models.ifc2x3.IfcRoot;

public class GuidHighlighter {
	public static void main(String[] args) {
		File lars = new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Logic Labs\\Projecten\\BIMserver\\Lars\\");
		Set<String> highlightedGuids = readGuidsFromFile(new File(lars, "missing.csv"));
		System.out.println(highlightedGuids.size());
		new GuidHighlighter(new File(lars, "2440_ARK_Alt4.ifc"), new File("output.ifc"), highlightedGuids);
	}
	
	private static Set<String> readGuidsFromFile(File file) {
		Set<String> guids = new HashSet<String>();
		try {
			FileInputStream fis = new FileInputStream(file);
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
				String line = bufferedReader.readLine();
				while (line != null) {
					guids.add(line);
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
				return guids;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public GuidHighlighter(File inputFile, File outputFile, Set<String> highlightedGuids) {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer deserializer = new IfcStepDeserializer(schema);
		try {
			IfcModel model = deserializer.read(inputFile);
			highlightGuids(model, highlightedGuids);
			IfcStepSerializer serializer = new IfcStepSerializer(null, null, outputFile.getName(), model, schema);
			serializer.writeToFile(outputFile);
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void highlightGuids(IfcModel model, Set<String> highlightedGuids) {
		for (IdEObject idEObject : model.getValues()) {
			if (idEObject instanceof IfcRoot) {
				IfcRoot ifcRoot = (IfcRoot)idEObject;
			}
		}
	}
}