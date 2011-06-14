package org.bimserver.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ifc.step.deserializer.IncorrectIfcFileException;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.Merger;
import org.bimserver.merging.Merger.GuidMergeIdentifier;
import org.bimserver.plugins.schema.SchemaDefinition;

public class GuidHighlighterTester {
	private SchemaDefinition schema;

	public static void main(String[] args) {
		new GuidHighlighterTester().start();
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

	private IfcModel readModel(File file) {
		IfcStepDeserializer deserializer = new IfcStepDeserializer();
		deserializer.init(schema);
		try {
			IfcModel model = deserializer.read(file);
			return model;
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void start() {
		schema = SchemaLoader.loadDefaultSchema();
		File lars = new File("C:\\Users\\Ruben\\Documents\\My Dropbox\\Logic Labs\\Projecten\\BIMserver\\Lars\\");
		Set<String> highlightedGuids = readGuidsFromFile(new File(lars, "missing.csv"));
		System.out.println(highlightedGuids.size() + " GUIDs");
		File inputFile1 = new File(lars, "2440_ARK_Alt4.ifc");
		File inputFile2 = new File(lars, "612252_RIV_Alt4.ifc");
		Merger merger = new Merger(new GuidMergeIdentifier());
		IfcModel model1 = readModel(inputFile1);
		IfcModel model2 = readModel(inputFile2);
		model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
		IfcModelSet modelSet = new IfcModelSet(model1, model2);
		IfcModel mergedModel = merger.merge(null, modelSet, true);
		new GuidHighlighter(schema, mergedModel, new File(lars, "output.ifc"), highlightedGuids);
	}
}