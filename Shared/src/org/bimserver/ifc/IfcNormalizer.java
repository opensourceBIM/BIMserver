package org.bimserver.ifc;

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

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Comparator;
//import java.util.Map;
//import java.util.TreeMap;
//
//import nl.tue.buildingsmart.emf.DerivedReader;
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.bimserver.emf.IfcModel;
//import org.bimserver.emf.IdEObject;
//import org.bimserver.emf.NormalizedIfcModel;
//import org.bimserver.ifc.file.reader.FastIfcFileReader;
//import org.bimserver.ifc.file.reader.IfcFileReader;
//import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
//import org.bimserver.ifc.file.writer.IfcStepSerializer;
//import org.eclipse.emf.ecore.EAttribute;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EcorePackage;
//
//public class IfcNormalizer {
//	public static void main(String[] args) {
//		new IfcNormalizer().normalize(new File("../CityGML/test.ifc"));
//	}
//
//	private SchemaDefinition schema;
//
//	public IfcNormalizer() {
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//		schemaParser.parse();
//		schema = schemaParser.getSchema();
//		try {
//			new DerivedReader(IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
//		} catch (FileNotFoundException e) {
//			LOGGER.error("", e);
//		}
//	}
//	
//	public NormalizedIfcModel normalize(IfcModel original) {
//		Map<Long, IdEObject> objects = original.getObjects();
//		Map<IdEObject, Long> treeMap = new TreeMap<IdEObject, Long>(new Comparator<IdEObject>() {
//			@Override
//			public int compare(IdEObject object1, IdEObject object2) {
//				int compareTo = object1.eClass().getName().compareTo(object2.eClass().getName());
//				if (compareTo == 0) {
//					EClass eClass = object1.eClass();
//					for (EAttribute eAttribute : eClass.getEAllAttributes()) {
//						Object val1 = object1.eGet(eAttribute);
//						Object val2 = object2.eGet(eAttribute);
//						if (val1 == null && val2 != null) {
//						} else if (val1 == null) {
//							return -1;
//						} else if (val2 == null) {
//							return 1;
//						} else {
//							if (eAttribute.getEType() instanceof EEnum) {
//								int compareTo2 = val1.toString().compareTo(val2.toString());
//								if (compareTo2 != 0) {
//									return compareTo2;
//								}
//							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEString()) {
//								int compareTo2 = ((String)val1).compareTo((String)val2);
//								if (compareTo2 != 0) {
//									return compareTo2;
//								}
//							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEInt()) {
//								int compareTo2 = ((Integer)val1).compareTo((Integer)val2);
//								if (compareTo2 != 0) {
//									return compareTo2;
//								}
//							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
//								int compareTo2 = ((Float)val1).compareTo((Float)val2);
//								if (compareTo2 != 0) {
//									return compareTo2;
//								}
//							}
//						}
//					}
//					return object1.hashCode() - object2.hashCode();
//				}
//				return compareTo * 100000;
//			}
//		});
//		for (Long key : objects.keySet()) {
//			treeMap.put(objects.get(key), key);
//		}
//		NormalizedIfcModel resultModel = new NormalizedIfcModel();
//		for (IdEObject object : treeMap.keySet()) {
//			resultModel.add(object);
//		}
//		return resultModel;
//	}
//	
//	private void normalize(File file) {
//		File destFile = new File(file.getParentFile(), "normalized-" + file.getName());
//		FastIfcFileReader fastIfcFileReader = new FastIfcFileReader(schema);
//		try {
//			fastIfcFileReader.read(file);
//			IfcModel model = fastIfcFileReader.getModel();
//			IfcModel normalize = normalize(model);
//			IfcStepSerializer ifcSerializer = new IfcStepSerializer("", normalize, schema);
//			ifcSerializer.writeToFile(destFile);
//		} catch (IncorrectIfcFileException e) {
//			LOGGER.error("", e);
//		} catch (Exception e) {
//			LOGGER.error("", e);
//		}
//	}
//}