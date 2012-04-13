package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.Merger;
import org.bimserver.merging.Merger.GuidMergeIdentifier;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.IfcModelInterface;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

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

	private IfcModelInterface readModel(File file) {
		PluginManager pluginManager;
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(schema);
			try {
				IfcModelInterface model = deserializer.read(file, true);
				return model;
			} catch (DeserializationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private void start() {
		File lars = new File("C:\\Users\\Ruben\\Documents\\My Dropbox\\Logic Labs\\Projecten\\BIMserver\\Lars\\");
		Set<String> highlightedGuids = readGuidsFromFile(new File(lars, "missing.csv"));
		System.out.println(highlightedGuids.size() + " GUIDs");
		File inputFile1 = new File(lars, "2440_ARK_Alt4.ifc");
		File inputFile2 = new File(lars, "612252_RIV_Alt4.ifc");
		Merger merger = new Merger(new GuidMergeIdentifier());
		IfcModelInterface model1 = readModel(inputFile1);
		IfcModelInterface model2 = readModel(inputFile2);
		model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
		IfcModelSet modelSet = new IfcModelSet(model1, model2);
		IfcModelInterface mergedModel = merger.merge(null, modelSet, true);
		new GuidHighlighter(schema, mergedModel, new File(lars, "output.ifc"), highlightedGuids);
	}
}