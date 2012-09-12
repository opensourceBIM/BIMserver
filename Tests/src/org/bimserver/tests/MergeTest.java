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


public class MergeTest {
	public static void main(String[] args) {
		new MergeTest().start();
	}

	private void start() {
//		try {
//			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
//			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
//			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
//			deserializer.init(pluginManager.requireSchemaDefinition());
////			File baseFolder = new File("C:\\Users\\Ruben de Laat\\Documents\\My Dropbox\\Logic Labs\\Projecten\\BIMserver\\IFCFiles");
////			IfcModel model1 = deserializer.read(new File(baseFolder, "Constructiedeel.ifc"));
////			IfcModel model2 = deserializer.read(new File(baseFolder, "Installatiedeel.ifc"));
//			
//			IfcModelInterface model1 = deserializer.read(TestFile.EXPORT1.getFile(), true);
//			IfcModelInterface model2 = deserializer.read(TestFile.EXPORT1.getFile(), true);
////			IfcModel model3 = deserializer.read(TestFile.EXPORT3.getFile());
//			
//			model1.setObjectOids();
//			model2.setObjectOids();
//			model1.indexGuids();
//			model2.indexGuids();
//			model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
//			IfcModelSet ifcModelSet = new IfcModelSet(model1, model2);
//			IfcModelInterface merged = new IntelligentGuidBasedModelMerger().merge(null, ifcModelSet);
//			merged.checkDoubleOidsPlusReferences();
//			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
//			EmfSerializer serializer = serializerPlugin.createSerializer();
//			serializer.init(merged, null, null, pluginManager.requireIfcEngine().createIfcEngine());
//			serializer.writeToFile(new File("merged.ifc"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}