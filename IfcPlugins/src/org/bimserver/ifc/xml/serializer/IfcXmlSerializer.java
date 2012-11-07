package org.bimserver.ifc.xml.serializer;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcSerializer;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.BaseType;
import org.bimserver.plugins.schema.DefinedType;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.ExplicitAttribute;
import org.bimserver.plugins.schema.IntegerType;
import org.bimserver.plugins.schema.ListType;
import org.bimserver.plugins.schema.RealType;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SetType;
import org.bimserver.plugins.schema.StringType;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class IfcXmlSerializer extends IfcSerializer {

	private PrintWriter out;
	private Map<EObject, Long> objectToOidMap;
	private int tabs;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, IfcEngine ifcEngine, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, pluginManager, ifcEngine, normalizeOids);
		objectToOidMap = new HashMap<EObject, Long>((int) model.size());
		for (Long key : model.keySet()) {
			objectToOidMap.put(model.get(key), key);
		}
	}

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}
	
	@Override
	public boolean write(OutputStream out) throws SerializerException {
		if (getMode() == Mode.BODY) {
			this.out = new UTF8PrintWriter(out);
			printLineTabbed("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			tabs = 0;
			printLineTabbed("<iso_10303_28 version=\"2.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns=\"urn:iso.org:standard:10303:part(28):version(2):xmlschema:common\" xsi:schemaLocation=\"urn:iso.org:standard:10303:part(28):version(2):xmlschema:common  http://www.iai-tech.org/ifcXML/IFC2x3/FINAL/ex.xsd\">");
			tabs++;
			printLineTabbed("<uos id=\"uos_1\" description=\"\" configuration=\"i-ifc2x3\" edo=\"\" xmlns=\"http://www.iai-tech.org/ifcXML/IFC2x3/FINAL\" xmlns:ex=\"urn:iso.org:standard:10303:part(28):version(2):xmlschema:common\" xsi:schemaLocation=\"http://www.iai-tech.org/ifcXML/IFC2x3/FINAL http://www.iai-tech.org/ifcXML/IFC2x3/FINAL/IFC2X3.xsd\">");
			tabs++;
			for (Long key : model.getObjects().keySet()) {
				EObject object = model.getObjects().get(key);
				if (object.eClass().getEStructuralFeature("wrappedValue") == null) {
					store(key, object);
				}
			}
			tabs--;
			printLineTabbed("</uos>");
			tabs--;
			printLineTabbed("</iso_10303_28>");
			this.out.flush();
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	public void write(File file) throws FileNotFoundException, SerializerException {
		write(new FileOutputStream(file));
	}

	/**
	 * Writes the XML structural equivalent of each IFC "record" in an IFC file.
	 * 
	 * @param key
	 *            record ID
	 * @param object
	 *            IFC object with this record ID
	 * @throws SerializerException 
	 */
	/*
	 * Because of insufficient info in the EMF model a few hacks were necessary
	 * to guarantee XML code that obeys the IFC XML schema. When these
	 * shortcomings are solved the hacks will be removed. (PW)
	 */
	private void store(Long key, EObject object) throws SerializerException {
		printLineTabbed("<" + object.eClass().getName() + " id=\"i" + key + "\">");
		tabs++;
		for (EStructuralFeature structuralFeature : object.eClass().getEAllStructuralFeatures()) {
			SchemaDefinition schema;
			try {
				schema = getPluginManager().requireSchemaDefinition();
			} catch (PluginException e) {
				throw new SerializerException(e);
			}
			EntityDefinition entityBN = schema.getEntityBN(object.eClass().getName().toUpperCase());
			Attribute attributeBN = entityBN != null ? entityBN.getAttributeBNWithSuper(structuralFeature.getName()) : null;
			boolean derived = entityBN.isDerived(structuralFeature.getName());
			if (!isInverse(structuralFeature) && !structuralFeature.isDerived() && !derived) {
				// Because of small deviations in the string/float/string
				// conversions some float attributes are also stored in the
				// original string representations. These auxiliary attribute
				// types should be skipped in the XML output. Though their value
				// must be used instead of the original attribute types.
				if (structuralFeature.getName().endsWith("AsString")) {
					continue;
				}
				Object value = object.eGet(structuralFeature);
				if (value == null) {
				} else {
					EClassifier classifier = structuralFeature.getEType();
					if (!structuralFeature.isMany()) {
						if (classifier instanceof EClass) {
							EObject eObject = (EObject) value;
							EClass type = eObject.eClass();
							printTabbed("<" + structuralFeature.getName() + ">");
							if (Ifc2x3tc1Package.eINSTANCE.getWrappedValue().isSuperTypeOf(type)) {
								// Only references should print the type,
								// GlobalId is an exception, because in EMF we
								// chose to create a Class for GlobalId, because
								// of the (added) backreference to IfcRoot
								boolean showTag = (structuralFeature instanceof EReference && !(structuralFeature.getName().equals("GlobalId")));
								if (showTag) {
									print("<" + type.getName() + ">");
								}
								EStructuralFeature wrappedFeature = type.getEStructuralFeature("wrappedValue");
								Object get = ((EObject) value).eGet(wrappedFeature);
								if (wrappedFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
									printEscaped((String) get);
								} else {
									if (!type.getName().equals("IfcLogical") && !type.getName().equals("IfcBoolean")) {
										print(get.toString());
									} else {
										writeValue(get);
									}
								}
								if (showTag) {
									print("</" + type.getName() + ">");
								}
							} else {
								String ref = "i" + objectToOidMap.get(value);
								print("<" + type.getName() + " xsi:nil=\"true\" ref=\"" + ref + "\"/>");
							}
							printLine("</" + structuralFeature.getName() + ">");
						} else if (classifier instanceof EEnum) {
							Enumerator enumerator = (Enumerator) value;
							if (enumerator.getName().equals("NULL")) {
								continue;
							}
							printTabbed("<" + structuralFeature.getName() + ">");
							writeValue(value);
							printLine("</" + structuralFeature.getName() + ">");
						} else if (classifier instanceof EDataType) {
							printTabbed("<" + structuralFeature.getName() + ">");
							print(value.toString());
							printLine("</" + structuralFeature.getName() + ">");
						}
					} else {
						BasicEList<?> list = (BasicEList<?>) value;
						String type = "set";
						if (attributeBN instanceof ExplicitAttribute) {
							ExplicitAttribute explicitAttribute = (ExplicitAttribute) attributeBN;
							if (list.isEmpty() && explicitAttribute.isOptional())
								continue;
							BaseType domain = explicitAttribute.getDomain(true);
							if (domain == null) {
								domain = explicitAttribute.getDomain();
								if (domain instanceof DefinedType) {
									if (((DefinedType) domain).getName().equals("IfcCompoundPlaneAngleMeasure")) {
										type = "list";
									}
								}
							}
							if (domain instanceof SetType) {
								type = "set";
							} else if (domain instanceof ListType) {
								type = "list";
								if (structuralFeature.getName().equals("Polygon")) {
									type = "list-unique";
								}
							}
						}
						printLineTabbed("<" + structuralFeature.getName() + " ex:cType=\"" + type + "\" >");
						tabs++;
						int i = 0;
						for (Object o : list) {
							if (o instanceof EObject) {
								EObject eObject = (EObject) o;
								EStructuralFeature wrappedFeature = eObject.eClass().getEStructuralFeature("wrappedValue");
								if (wrappedFeature != null) {
									Object val = eObject.eGet(wrappedFeature);
									printLineTabbed("<" + eObject.eClass().getName() + " pos=\"" + i + "\">" + val + "</" + eObject.eClass().getName() + ">");
								} else {
									String ref = "i" + objectToOidMap.get(eObject);
									printLineTabbed("<" + eObject.eClass().getName() + " pos=\"" + i + "\" xsi:nil=\"true\" ref=\"" + ref + "\" />");
								}
								i++;
							} else {
								if (attributeBN instanceof ExplicitAttribute) {
									BaseType domain = ((ExplicitAttribute) attributeBN).getDomain(true);
									if (attributeBN.getName().equals("RefLatitude") || attributeBN.getName().equals("RefLongitude")) {
										printLineTabbed("<ex:long-wrapper>" + o + "</ex:long-wrapper>");
									} else if (domain instanceof ListType) {
										BaseType elementType = ((ListType) domain).getElement_type();
										if (elementType instanceof DefinedType) {
											DefinedType def = (DefinedType) elementType;
											printLineTabbed("<" + def.getName() + ">" + o + "</" + def.getName() + ">");
										} else if (elementType instanceof RealType) {
											printLineTabbed("<ex:double-wrapper>" + o + "</ex:double-wrapper>");
										} else if (elementType instanceof IntegerType) {
											printLineTabbed("<ex:long-wrapper>" + o + "</ex:long-wrapper>");
										} else if (elementType instanceof StringType) {
											printLineTabbed("<string-wrapper>" + o + "</string-wrapper>");
										}
									}
								}
							}
						}
						tabs--;
						printLineTabbed("</" + structuralFeature.getName() + ">");
						// }
					}
				}
			}
		}
		tabs--;
		printLineTabbed("</" + object.eClass().getName() + ">");
	}

	private void writeValue(Object value) {
		if (value instanceof Tristate && value == Tristate.UNDEFINED) {
			print("unknown");
		} else {
			print(value.toString().toLowerCase());
		}
	}

	private void printEscaped(String value) {
		out.print(StringEscapeUtils.escapeXml(value));
	}

	private void writeTabs(int tabs) {
		for (int i = 0; i < tabs; i++) {
			out.print("\t");
		}
	}

	private void printTabbed(String str) {
		writeTabs(tabs);
		out.print(str);
	}

	private void printLineTabbed(String str) {
		writeTabs(tabs);
		out.println(str);
	}

	private void print(String str) {
		out.print(str);
	}

	private void printLine(String str) {
		out.println(str);
	}
}