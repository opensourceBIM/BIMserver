package org.bimserver.ifc.step.serializer;

/************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcSerializer;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcTrimmedCurve;
import org.bimserver.models.ifc2x3.Tristate;
import org.bimserver.models.ifc2x3.WrappedValue;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTFPrintWriter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class IfcStepSerializer extends IfcSerializer {
	private static final EcorePackage ECORE_PACKAGE_INSTANCE = EcorePackage.eINSTANCE;
	private static final String NULL = "NULL";
	private static final String OPEN_CLOSE_PAREN = "()";
	private static final String ASTERISK = "*";
	private static final String PAREN_CLOSE_SEMICOLON = ");";
	private static final String DOT_0 = ".0";
	private static final String DASH = "#";
	private static final String IFC_LOGICAL = "IfcLogical";
	private static final String IFC_BOOLEAN = "IfcBoolean";
	private static final String DOT = ".";
	private static final String COMMA = ",";
	private static final String OPEN_CLOSE = "(";
	private static final String CLOSE_PAREN = ")";
	private static final String BOOLEAN_UNDEFINED = ".U.";
	private static final String SINGLE_QUOTE = "'";
	private static final String BOOLEAN_FALSE = ".F.";
	private static final String BOOLEAN_TRUE = ".T.";
	private static final String DOLLAR = "$";
	private static final String WRAPPED_VALUE = "wrappedValue";

	private String fileDescription = "";
	private String name = "";
	private String author = "";
	private String organization = "";
	private String originatingSystem = "";
	private String authorization = "";
	private String preProcessorVersion = "";
	private Date date = new Date();

	private Iterator<Long> iterator;
	private UTFPrintWriter out;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException {
		super.init(model, projectInfo, pluginManager);
	}

	@Override
	protected void reset() {
		setMode(Mode.HEADER);
		out = null;
	}
	
	public boolean write(OutputStream outputStream) throws SerializerException {
		if (out == null) {
			out = new UTFPrintWriter(outputStream);
		}
		if (getMode() == Mode.HEADER) {
			writeHeader(out);
			setMode(Mode.BODY);
			iterator = model.keySet().iterator();
			out.flush();
			return true;
		} else if (getMode() == Mode.BODY) {
			if (iterator.hasNext()) {
				long key = iterator.next();
				if (key != -1) {
					write(out, key, model.get(key));
				}
			} else {
				iterator = null;
				setMode(Mode.FOOTER);
				return write(outputStream);
			}
			return true;
		} else if (getMode() == Mode.FOOTER) {
			writeFooter(out);
			out.flush();
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setOriginatingSystem(String originatingSystem) {
		this.originatingSystem = originatingSystem;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPreProcessorVersion(String preProcessorVersion) {
		this.preProcessorVersion = preProcessorVersion;
	}

	private void writeFooter(UTFPrintWriter out) {
		out.println("ENDSEC;");
		out.println("END-ISO-10303-21;");
	}

	private void writeHeader(UTFPrintWriter out) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
		String dateString = dateFormatter.format(date);

		out.println("ISO-10303-21;");
		out.println("HEADER;");
		out.println("FILE_DESCRIPTION (('" + fileDescription + "'), '2;1');");
		out.println("FILE_NAME ('" + name + "', '" + dateString + "', ('" + author + "'), ('" + organization + "'), '" + preProcessorVersion + "', '" + originatingSystem + "', '"
				+ authorization + "');");
		out.println("FILE_SCHEMA (('IFC2X3'));");
		out.println("ENDSEC;");
		out.println("DATA;");
		// out.println("//This program comes with ABSOLUTELY NO WARRANTY.");
		// out.println("//This is free software, and you are welcome to redistribute it under certain conditions. See www.bimserver.org <http://www.bimserver.org>");
	}

	private void writePrimitive(PrintWriter out, Object val) {
		if (val instanceof Tristate) {
			Tristate bool = (Tristate) val;
			if (bool == Tristate.TRUE) {
				out.print(BOOLEAN_TRUE);
			} else if (bool == Tristate.FALSE) {
				out.print(BOOLEAN_FALSE);
			} else if (bool == Tristate.UNDEFINED) {
				out.print(BOOLEAN_UNDEFINED);
			}
		} else if (val instanceof Float || val instanceof Double) {
			String string = val.toString();
			if (string.endsWith(DOT_0)) {
				out.print(string.substring(0, string.length() - 1));
			} else {
				out.print(string);
			}
		} else if (val instanceof Boolean) {
			Boolean bool = (Boolean)val;
			if (bool) {
				out.print(BOOLEAN_TRUE);
			} else {
				out.print(BOOLEAN_FALSE);
			}
		} else if (val instanceof String) {
			out.print(SINGLE_QUOTE);
			out.print(val.toString());
			out.print(SINGLE_QUOTE);
		} else {
			out.print(val == null ? "$" : val.toString());
		}
	}

	private void write(PrintWriter out, Long key, EObject object) throws SerializerException {
		EClass eClass = object.eClass();
		out.print(DASH);
		out.print(String.valueOf(key));
		out.print("= ");
		out.print(upperCases.get(eClass));
		out.print(OPEN_CLOSE);
		boolean isFirst = true;
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (!feature.isDerived() && !feature.isVolatile() && !feature.getName().endsWith("AsString")) {
				EClassifier type = feature.getEType();
				if (type instanceof EEnum) {
					if (!isFirst) {
						out.print(COMMA);
					}
					writeEnum(out, object, feature);
					isFirst = false;
				} else if (type instanceof EClass) {
					if (!isInverse(feature)) {
						if (!isFirst) {
							out.print(COMMA);
						}
						writeEClass(out, object, feature);
						isFirst = false;
					}
				} else if (type instanceof EDataType) {
					if (!isFirst) {
						out.print(COMMA);
					}
					writeEDataType(out, object, feature);
					isFirst = false;
				}
			}
		}
		out.println(PAREN_CLOSE_SEMICOLON);
	}

	private void writeEDataType(PrintWriter out, EObject object, EStructuralFeature feature) throws SerializerException {
		SchemaDefinition schema;
		try {
			schema = getPluginManager().requireSchemaDefinition();
		} catch (PluginException e) {
			throw new SerializerException(e);
		}
		EntityDefinition entityBN = schema.getEntityBNNoCaseConvert(upperCases.get(object.eClass()));
		if (entityBN != null && entityBN.isDerived(feature.getName())) {
			out.print(ASTERISK);
		} else if (feature.isMany()) {
			writeList(out, object, feature);
		} else {
			writeObject(out, object, feature);
		}
	}

	private void writeEClass(PrintWriter out, EObject object, EStructuralFeature feature) throws SerializerException {
		Object referencedObject = object.eGet(feature);
		if (referencedObject instanceof WrappedValue || referencedObject instanceof IfcGloballyUniqueId) {
			writeWrappedValue(out, object, feature, ((EObject)referencedObject).eClass());
		} else {
			SchemaDefinition schema;
			try {
				schema = getPluginManager().requireSchemaDefinition();
			} catch (PluginException e) {
				throw new SerializerException(e);
			}
			EntityDefinition entityBN = schema.getEntityBNNoCaseConvert(upperCases.get(object.eClass()));
			if (referencedObject instanceof EObject && model.contains((IdEObject) referencedObject)) {
				out.print(DASH);
				out.print(String.valueOf(model.get((IdEObject) referencedObject)));
			} else {
				if (entityBN != null && entityBN.isDerived(feature.getName())) {
					out.print(ASTERISK);
				} else if (feature.isMany()) {
					writeList(out, object, feature);
				} else {
					writeObject(out, object, feature);
				}
			}
		}
	}

	private void writeObject(PrintWriter out, EObject object, EStructuralFeature feature) {
		Object ref = object.eGet(feature);
		if (ref == null) {
			EClassifier type = feature.getEType();
			if (type instanceof EClass) {
				EStructuralFeature structuralFeature = ((EClass) type).getEStructuralFeature(WRAPPED_VALUE);
				if (structuralFeature != null) {
					String name = structuralFeature.getEType().getName();
					if (structuralFeature.isUnsettable()) {
						out.print(DOLLAR);
					} else if (name.equals(IFC_BOOLEAN) || name.equals(IFC_LOGICAL)) {
						out.print(BOOLEAN_UNDEFINED);
					} else {
						out.print(DOLLAR);
					}
				} else {
					out.print(DOLLAR);
				}
			} else {
				out.print(DOLLAR);
			}
		} else {
			if (ref instanceof EObject) {
				writeEmbedded(out, (EObject) ref);
			} else if (feature.getEType() == ECORE_PACKAGE_INSTANCE.getEFloat() || feature.getEType() == ECORE_PACKAGE_INSTANCE.getEDouble()) {
				Object eGet = object.eGet(object.eClass().getEStructuralFeature(feature.getName() + "AsString"));
				if (eGet != null) {
					out.print(eGet);
				} else {
					out.print(DOLLAR);
				}
			} else {
				writePrimitive(out, ref);
			}
		}
	}

	private void writeEmbedded(PrintWriter out, EObject eObject) {
		EClass class1 = eObject.eClass();
		out.print(upperCases.get(class1));
		out.print(OPEN_CLOSE);
		EStructuralFeature structuralFeature = class1.getEStructuralFeature(WRAPPED_VALUE);
		if (structuralFeature != null) {
			Object get = eObject.eGet(structuralFeature);
			if (structuralFeature.getEType() == ECORE_PACKAGE_INSTANCE.getEFloat() || structuralFeature.getEType() == ECORE_PACKAGE_INSTANCE.getEDouble()) {
				Object realVal = eObject.eGet(class1.getEStructuralFeature(structuralFeature.getName() + "AsString"));
				if (realVal != null) {
					out.print(realVal);					
				} else {
					out.print(get);
				}
			} else {
				writePrimitive(out, get);
			}
		}
		out.print(CLOSE_PAREN);
	}

	private void writeList(PrintWriter out, EObject object, EStructuralFeature feature) {
		List<?> list = (List<?>) object.eGet(feature);
		if (list.size() == 0) {
			if (feature.isUnsettable()) {
				out.print(DOLLAR);
			} else {
				out.print(OPEN_CLOSE_PAREN);
			}
		} else {
			out.print(OPEN_CLOSE);
			boolean first = true;
			for (Object listObject : list) {
				if (!first) {
					out.print(COMMA);
				}
				if ((listObject instanceof IdEObject) && model.contains((IdEObject)listObject)) {
					IdEObject eObject = (IdEObject) listObject;
					out.print(DASH);
					out.print(String.valueOf(model.get(eObject)));
				} else {
					if (listObject == null) {
						out.print(DOLLAR);
					} else {
						if (listObject instanceof WrappedValue && Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) feature.getEType())) {
							IdEObject eObject = (IdEObject) listObject;
							Object realVal = eObject.eGet(eObject.eClass().getEStructuralFeature("wrappedValue"));
							if (realVal instanceof Float || realVal instanceof Double) {
								Object stringVal = eObject.eGet(eObject.eClass().getEStructuralFeature("wrappedValueAsString"));
								if (stringVal != null) {
									out.print(stringVal);									
								} else {
									out.print(realVal);
								}
							} else {
								writePrimitive(out, realVal);
							}
						} else if (listObject instanceof EObject) {
							IdEObject eObject = (IdEObject) listObject;
							EClass class1 = eObject.eClass();
							EStructuralFeature structuralFeature = class1.getEStructuralFeature(WRAPPED_VALUE);
							if (structuralFeature != null) {
								Object realVal = eObject.eGet(structuralFeature);
								out.print(upperCases.get(class1));
								out.print(OPEN_CLOSE);
								if (realVal instanceof Float || realVal instanceof Double) {
									Object stringVal = eObject.eGet(class1.getEStructuralFeature(structuralFeature.getName() + "AsString"));
									if (stringVal != null) {
										out.print(stringVal);										
									} else {
										out.print(realVal);
									}
								} else {
									writePrimitive(out, realVal);
								}
								out.print(CLOSE_PAREN);
							}
						} else {
							writePrimitive(out, listObject);
						}
					}
				}
				first = false;
			}
			out.print(CLOSE_PAREN);
		}
	}

	private void writeWrappedValue(PrintWriter out, EObject object, EStructuralFeature feature, EClass ec) throws SerializerException {
		Object get = object.eGet(feature);
		boolean isWrapped = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(ec) || ec == Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId();
		EStructuralFeature structuralFeature = ec.getEStructuralFeature(WRAPPED_VALUE);
		if (get instanceof EObject) {
			boolean isDefinedWrapped = Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) feature.getEType()) || feature.getEType() == Ifc2x3Package.eINSTANCE.getIfcGloballyUniqueId();
			EObject betweenObject = (EObject) get;
			if (betweenObject != null) {
				if (isWrapped && isDefinedWrapped) {
					Object val = betweenObject.eGet(structuralFeature);
					String name = structuralFeature.getEType().getName();
					if ((name.equals(IFC_BOOLEAN) || name.equals(IFC_LOGICAL)) && val == null) {
						out.print(BOOLEAN_UNDEFINED);
					} else if (structuralFeature.getEType() == ECORE_PACKAGE_INSTANCE.getEFloat()) {
						Object stringVal = betweenObject.eGet(betweenObject.eClass().getEStructuralFeature("wrappedValueAsString"));
						if (stringVal != null) {
							out.print(stringVal);							
						} else {
							out.print(val);
						}
					} else {
						writePrimitive(out, val);
					}
				} else {
					writeEmbedded(out, betweenObject);
				}
			}
		} else if (get instanceof EList<?>) {
			EList<?> list = (EList<?>) get;
			if (list.size() == 0) {
				if (feature.isUnsettable()) {
					out.print(DOLLAR);
				} else {
					out.print(OPEN_CLOSE_PAREN);
				}
			} else {
				out.print(OPEN_CLOSE);
				boolean first = true;
				for (Object o : list) {
					if (!first) {
						out.print(COMMA);
					}
					EObject object2 = (EObject) o;
					Object val = object2.eGet(structuralFeature);
					if (structuralFeature.getEType() == ECORE_PACKAGE_INSTANCE.getEFloat()) {
						out.print(object2.eGet(object2.eClass().getEStructuralFeature("stringValue" + structuralFeature.getName())));
					} else {
						writePrimitive(out, val);
					}
					first = false;
				}
				out.print(CLOSE_PAREN);
			}
		} else {
			if (get == null) {
				EClassifier type = structuralFeature.getEType();
				if (type == IFC_PACKAGE_INSTANCE.getIfcBoolean() || type == IFC_PACKAGE_INSTANCE.getIfcLogical() || type == ECORE_PACKAGE_INSTANCE.getEBoolean()) {
					if (feature.isUnsettable()) {
						out.print(DOLLAR);
					} else {
						out.print(BOOLEAN_UNDEFINED);
					}
				} else {
					SchemaDefinition schema;
					try {
						schema = getPluginManager().requireSchemaDefinition();
					} catch (PluginException e) {
						throw new SerializerException(e);
					}
					EntityDefinition entityBN = schema.getEntityBN(object.eClass().getName());
					if (entityBN != null && entityBN.isDerived(feature.getName())) {
						out.print("*");
					} else {
						out.print(DOLLAR);
					}
				}
			}
		}
	}

	private void writeEnum(PrintWriter out, EObject object, EStructuralFeature feature) {
		Object val = object.eGet(feature);
		if (feature.getEType() == Ifc2x3Package.eINSTANCE.getTristate()) {
			writePrimitive(out, val);
		} else {
			if (val == null) {
				out.print(DOLLAR);
			} else {
				if (((Enum<?>) val).toString().equals(NULL)) {
					out.print(DOLLAR);
				} else {
					out.print(DOT);
					out.print(val.toString());
					out.print(DOT);
				}
			}
		}
	}
}