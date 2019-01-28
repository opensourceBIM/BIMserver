package org.bimserver.tests;

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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.utils.DeserializerUtils;

public class GuidHighlighterTester {

	public static void main(String[] args) {
		new GuidHighlighterTester().start();
	}

	public static Set<String> readGuidsFromFile(File file) {
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

	public IfcModelInterface readModel(Path file) {
		PluginManager pluginManager;
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			try {
				IfcModelInterface model = DeserializerUtils.readFromFile(deserializer, file);
				return model;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private void start() {
//		File lars = Paths.get("C:\\Users\\Ruben\\Documents\\My Dropbox\\Logic Labs\\Projecten\\BIMserver\\Lars\\");
//		Set<String> highlightedGuids = readGuidsFromFile(Paths.get(lars, "missing.csv"));
//		System.out.println(highlightedGuids.size() + " GUIDs");
//		File inputFile1 = Paths.get(lars, "2440_ARK_Alt4.ifc");
//		File inputFile2 = Paths.get(lars, "612252_RIV_Alt4.ifc");
//		ModelMerger merger = new IntelligentGuidBasedModelMerger();
//		IfcModelInterface model1 = readModel(inputFile1);
//		IfcModelInterface model2 = readModel(inputFile2);
//		model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
//		IfcModelSet modelSet = new IfcModelSet(model1, model2);
//		IfcModelInterface mergedModel;
//		try {
//			mergedModel = merger.merge(null, modelSet);
//			new GuidHighlighter(schema, mergedModel, Paths.get(lars, "output.ifc"), highlightedGuids);
//		} catch (MergeException e) {
//			e.printStackTrace();
//		}
	}
}