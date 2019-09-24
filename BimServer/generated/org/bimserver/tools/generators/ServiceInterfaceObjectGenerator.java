package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
import org.bimserver.utils.*;
import org.bimserver.emf.MetaDataManager;
import java.io.File;
import org.bimserver.utils.StringUtils;

public class ServiceInterfaceObjectGenerator
{
  protected static String nl;
  public static synchronized ServiceInterfaceObjectGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ServiceInterfaceObjectGenerator result = new ServiceInterfaceObjectGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package org.bimserver.interfaces.objects;";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "@XmlRootElement";
  protected final String TEXT_4 = NL + "@XmlSeeAlso(value={";
  protected final String TEXT_5 = "S";
  protected final String TEXT_6 = ".class";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = "})";
  protected final String TEXT_9 = NL + "public class S";
  protected final String TEXT_10 = " extends ";
  protected final String TEXT_11 = " implements ";
  protected final String TEXT_12 = NL + "{";
  protected final String TEXT_13 = NL + "\tprivate long oid = -1;" + NL + "\tprivate UUID uuid;" + NL + "\tprivate int rid = 0;";
  protected final String TEXT_14 = NL + NL + "\t@XmlTransient" + NL + "\tprivate static SClass sClass;";
  protected final String TEXT_15 = NL + "\tprivate S";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = ";";
  protected final String TEXT_18 = NL + "\tprivate List<";
  protected final String TEXT_19 = "> ";
  protected final String TEXT_20 = " = new ArrayList<";
  protected final String TEXT_21 = ">();";
  protected final String TEXT_22 = NL + "\t@XmlMimeType(\"application/octet-stream\")" + NL + "\tprivate DataHandler ";
  protected final String TEXT_23 = NL + "\tprivate ";
  protected final String TEXT_24 = NL + "\tprivate List<S";
  protected final String TEXT_25 = " = new ArrayList<S";
  protected final String TEXT_26 = NL + "\tprivate List<Long> ";
  protected final String TEXT_27 = " = new ArrayList<Long>();";
  protected final String TEXT_28 = NL + "\tprivate long ";
  protected final String TEXT_29 = "Id = -1;";
  protected final String TEXT_30 = NL + NL + "\tpublic long getOid() {" + NL + "\t\treturn this.oid;" + NL + "\t}" + NL + "" + NL + "\tpublic void setOid(long oid) {" + NL + "\t\tthis.oid = oid;" + NL + "\t}" + NL + "" + NL + "\tpublic UUID getUuid() {" + NL + "\t\treturn this.uuid;" + NL + "\t}" + NL + "" + NL + "\tpublic void setUuid(UUID uuid) {" + NL + "\t\tthis.uuid = uuid;" + NL + "\t}" + NL + "" + NL + "\tpublic int getRid() {" + NL + "\t\treturn rid;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setRid(int rid) {" + NL + "\t\tthis.rid = rid;" + NL + "\t}";
  protected final String TEXT_31 = NL + "\t" + NL + "\t@XmlTransient" + NL + "\tpublic SClass getSClass() {" + NL + "\t\treturn sClass;" + NL + "\t}" + NL + "\t" + NL + "\tpublic static void setSClass(SClass sClass) {" + NL + "\t\tS";
  protected final String TEXT_32 = ".sClass = sClass;" + NL + "\t}" + NL + "" + NL + "\tpublic Object sGet(SField sField) {";
  protected final String TEXT_33 = NL + "\t\tif (sField.getName().equals(\"";
  protected final String TEXT_34 = "\")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_35 = "();" + NL + "\t\t}";
  protected final String TEXT_36 = NL + "\t\tif (sField.getName().equals(\"oid\")) {" + NL + "\t\t\treturn getOid();" + NL + "\t\t}" + NL + "\t\tif (sField.getName().equals(\"rid\")) {" + NL + "\t\t\treturn getRid();" + NL + "\t\t}" + NL + "\t\tif (sField.getName().equals(\"uuid\")) {" + NL + "\t\t\treturn getUuid();" + NL + "\t\t}";
  protected final String TEXT_37 = NL + "\t\tthrow new RuntimeException(\"Field \" + sField.getName() + \" not found\");" + NL + "\t}";
  protected final String TEXT_38 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_39 = NL + NL + "\tpublic void sSet(SField sField, Object val) {";
  protected final String TEXT_40 = "\")) {" + NL + "\t\t\tset";
  protected final String TEXT_41 = "((";
  protected final String TEXT_42 = ")val);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_43 = NL + "\t\tif (sField.getName().equals(\"oid\")) {" + NL + "\t\t\tsetOid((Long)val);" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (sField.getName().equals(\"rid\")) {" + NL + "\t\t\tsetRid((Integer)val);" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (sField.getName().equals(\"uuid\")) {" + NL + "\t\t\tsetUuid((UUID)val);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_44 = NL + "\t\tthrow new RuntimeException(\"Field \" + sField.getName() + \" not found\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_45 = NL + "\tpublic S";
  protected final String TEXT_46 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_47 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_48 = "(S";
  protected final String TEXT_49 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_52 = NL + NL + "\tpublic List<";
  protected final String TEXT_53 = "(List<";
  protected final String TEXT_54 = NL + "\tpublic DataHandler ";
  protected final String TEXT_55 = "(DataHandler ";
  protected final String TEXT_56 = NL + "\tpublic ";
  protected final String TEXT_57 = "(";
  protected final String TEXT_58 = NL + "\tpublic List<S";
  protected final String TEXT_59 = "(List<S";
  protected final String TEXT_60 = NL + "\tpublic List<Long> ";
  protected final String TEXT_61 = "(List<Long> ";
  protected final String TEXT_62 = ";" + NL + "\t}" + NL + "\t" + NL + "\t";
  protected final String TEXT_63 = NL + "\tpublic long ";
  protected final String TEXT_64 = "Id;" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_65 = "(long ";
  protected final String TEXT_66 = "Id) {" + NL + "\t\tthis.";
  protected final String TEXT_67 = "Id = ";
  protected final String TEXT_68 = "Id;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_69 = NL + "\t@Override" + NL + "\tpublic int hashCode() {" + NL + "\t\tfinal int prime = 31;" + NL + "\t\tint result = 1;" + NL + "\t\tresult = prime * result + (int) (oid ^ (oid >>> 32));" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (this == obj)" + NL + "\t\t\treturn true;" + NL + "\t\tif (obj == null)" + NL + "\t\t\treturn false;" + NL + "\t\tif (getClass() != obj.getClass())" + NL + "\t\t\treturn false;" + NL + "\t\tS";
  protected final String TEXT_70 = " other = (S";
  protected final String TEXT_71 = ") obj;" + NL + "\t\tif (oid != other.oid)" + NL + "\t\t\treturn false;" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_72 = NL + "public enum S";
  protected final String TEXT_73 = " {";
  protected final String TEXT_74 = NL + "\t";
  protected final String TEXT_75 = ")";
  protected final String TEXT_76 = NL + "\tint ordinal;" + NL + "" + NL + "\tS";
  protected final String TEXT_77 = "(int ordinal) {" + NL + "\t\tthis.ordinal = ordinal;" + NL + "\t}" + NL + "\t" + NL + "\tpublic int getOrdinal() {" + NL + "\t\treturn ordinal;" + NL + "\t}";
  protected final String TEXT_78 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(Licenser.getCommentedLicenseText(new File("license.txt")));
    stringBuffer.append(TEXT_2);
    
	Object[] arguments = (Object[])argument;
	EClassifier eClassifier = (EClassifier)arguments[0];
	ImportManager importManager = (ImportManager)arguments[1];
	MetaDataManager metaDataManager = (MetaDataManager)arguments[2];
	importManager.mark(stringBuffer);
	boolean hasLists = false;
	if (eClassifier instanceof EClass) {
		EClass eClass = (EClass)eClassifier;
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (eStructuralFeature.isMany()) {
				hasLists = true;
				break;
			}
		}
	
		importManager.getImport("javax.xml.bind.annotation.XmlRootElement");
		importManager.getImport("org.bimserver.shared.meta.*");
		importManager.getImport("java.util.UUID");

    stringBuffer.append(TEXT_3);
    
importManager.getImport("javax.xml.bind.annotation.XmlTransient");
if (metaDataManager.getPackageMetaData(eClassifier.getEPackage().getName()).getDirectSubClasses(eClass) != null && !metaDataManager.getPackageMetaData(eClassifier.getEPackage().getName()).getDirectSubClasses(eClass).isEmpty()) { 
importManager.getImport("javax.xml.bind.annotation.XmlSeeAlso");

    stringBuffer.append(TEXT_4);
    
java.util.Set<EClass> subClasses = metaDataManager.getPackageMetaData(eClassifier.getEPackage().getName()).getDirectSubClasses(eClass);
int i=0;
for (EClass subClass : subClasses) {
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_6);
    
	if (i != subClasses.size() - 1) {
	
    stringBuffer.append(TEXT_7);
    
	}
	i++;
}
    stringBuffer.append(TEXT_8);
    
} 

    stringBuffer.append(TEXT_9);
    stringBuffer.append(eClass.getName());
    
	if (!eClass.getESuperTypes().isEmpty()) {
		
    stringBuffer.append(TEXT_10);
    
		for (EClass eSuperClass : eClass.getESuperTypes()) {
			
    stringBuffer.append(TEXT_5);
    stringBuffer.append(eSuperClass.getName());
    
		}
	}

    stringBuffer.append(TEXT_11);
    stringBuffer.append( eClass.getEAnnotation("nodatabase") != null ? "SBase" : "SDataBase" );
    stringBuffer.append(TEXT_12);
     if (eClass.getEAnnotation("nodatabase") == null) { 
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
		if (eStructuralFeature.getEAnnotation("notinserviceinterface") == null) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_17);
    
				} else {
					if (eAttribute.isMany()) {
						importManager.getImport("java.util.List");
						importManager.getImport("java.util.ArrayList");

    stringBuffer.append(TEXT_18);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_21);
    
					} else {
						if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray() && eAttribute.getEAnnotation("file") != null) {
							importManager.getImport("javax.activation.DataHandler");

    stringBuffer.append(TEXT_22);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_17);
    
						} else {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_17);
    
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					importManager.getImport("java.util.List");
					importManager.getImport("java.util.ArrayList");
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_21);
    			
					} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_27);
    
					}
				} else {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_17);
    
					} else {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_29);
    
					}
				}
			}
		}
	}

	if (eClass.getEAnnotation("nodatabase") == null) { 
    stringBuffer.append(TEXT_30);
     } 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_32);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eStructuralFeature.getName()));
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_35);
    
	}
if (eClass.getEAnnotation("nodatabase") == null) {

    stringBuffer.append(TEXT_36);
     } 
    stringBuffer.append(TEXT_37);
     if (hasLists) { 
	importManager.getImport("java.util.List");

    stringBuffer.append(TEXT_38);
     } 
    stringBuffer.append(TEXT_39);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDate()) {
			importManager.getImport("java.util.Date");
		} else if (eStructuralFeature.getEType().getName().equals("DataHandler")) {
			importManager.getImport("javax.activation.DataHandler");
		
		}
		boolean useId = (eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null);

    stringBuffer.append(TEXT_33);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(StringUtils.firstUpperCase(eStructuralFeature.getName()));
    stringBuffer.append(useId ? "Id" : "" );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(GenerateUtils.getType(eStructuralFeature));
    stringBuffer.append(TEXT_42);
    
	}
if (eClass.getEAnnotation("nodatabase") == null) {

    stringBuffer.append(TEXT_43);
     } 
    stringBuffer.append(TEXT_44);
    

	for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
		if (eStructuralFeature.getEAnnotation("notinserviceinterface") == null) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_51);
    
				} else {
					if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_51);
    
					} else {
						if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray() && eAttribute.getEAnnotation("file") != null) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_51);
    
						} else {

    stringBuffer.append(TEXT_56);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_51);
    
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_51);
    
					} else {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_51);
    
					}
				} else {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_62);
    
					} else {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_68);
    
					}
				}
			}
		}
	}
if (eClass.getEAnnotation("nodatabase") == null) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_71);
    
}
	} else if (eClassifier instanceof EEnum) {
		EEnum eEnum = (EEnum)eClassifier;

    stringBuffer.append(TEXT_72);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_73);
    
	for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(eEnumLiteral.getName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(eEnumLiteral.getValue());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(eEnum.getELiterals().get(eEnum.getELiterals().size()-1) == eEnumLiteral ? ";" : ",");
    
	}

    stringBuffer.append(TEXT_76);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_77);
    	} 
    
	importManager.writeImports(stringBuffer);

    stringBuffer.append(TEXT_78);
    return stringBuffer.toString();
  }
}
