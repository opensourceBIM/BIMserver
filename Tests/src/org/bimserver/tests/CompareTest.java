package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;

public class CompareTest {
	public static void main(String[] args) {
		new CompareTest().start();
	}

	@SuppressWarnings("rawtypes")
	private void start() {
		File file1 = new File("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\_IFC revisies wozoco\\1407_WE_WOZOCO_versie_1_general_translator.ifc");
		File file2 = new File("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\_IFC revisies wozoco\\1407_WE_WOZOCO_versie_2_verplaatsen_binnenwandje.ifc");
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			IfcModelInterface model1 = readModel(file1, pluginManager);
			IfcModelInterface model2 = readModel(file2, pluginManager);

			Map<IdEObject, Set<IdEObject>> map = new HashMap<IdEObject, Set<IdEObject>>();
			
			if (model1.size() != model2.size()) {
				for (IdEObject idEObject : model1.getValues()) {
					for (EReference eReference : idEObject.eClass().getEAllReferences()) {
						Object value = idEObject.eGet(eReference);
						if (eReference.isMany()) {
							List list = (List)value;
							for (Object o : list) {
								if (!map.containsKey(((IdEObject)o))) {
									map.put((IdEObject)o, new HashSet<IdEObject>());
								}
								map.get((IdEObject)o).add(idEObject);
							}
						} else {
							if (!map.containsKey(((IdEObject)value))) {
								map.put((IdEObject)value, new HashSet<IdEObject>());
							}
							map.get((IdEObject)value).add(idEObject);
						}
					}
				}
				
				for (IdEObject firstModel1 : model1.getValues()) {
					if (!map.containsKey(firstModel1)) {
						for (IdEObject model2Object : model2.getAll(firstModel1.eClass())) {
							boolean same = true;
							for (EAttribute attribute : firstModel1.eClass().getEAllAttributes()) {
								if (attribute.isMany()) {
									List firstList = (List)firstModel1.eGet(attribute);
									List otherList = (List)model2Object.eGet(attribute);
									if (firstList.size() != otherList.size()) {
										same = false;
									}
									for (int i=0; i<firstList.size(); i++) {
										Object o1 = firstList.get(i);
										Object o2 = firstList.get(i);
										if (o1 != o2 && !o1.equals(o2)) {
											same = false;
											break;
										}
									}
								} else {
									Object value = firstModel1.eGet(attribute);
									Object otherValue = model2Object.eGet(attribute);
									if (value != otherValue && !value.equals(otherValue)) {
										same = false;
									}
								}
								if (!same) {
									break;
								}
							}
							if (same) {
								dumpObject(firstModel1);
								dumpObject(model2Object);
							}
						}
						break;
					}
				}
			} else {
				System.out.println("Same");
			}
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
	
	private void dumpObject(IdEObject idEObject) {
		System.out.println(idEObject.eClass().getName());
		for (EAttribute attribute : idEObject.eClass().getEAllAttributes()) {
			System.out.println("\t" + idEObject.eGet(attribute));
		}
	}

	private IfcModelInterface readModel(File file1, PluginManager pluginManager) throws DeserializeException, PluginException {
		Deserializer deserializer = pluginManager.requireDeserializer("ifc").createDeserializer(new PluginConfiguration());
		deserializer.init(pluginManager.requireSchemaDefinition());
		IfcModelInterface model1 = deserializer.read(file1);
		return model1;
	}
}
