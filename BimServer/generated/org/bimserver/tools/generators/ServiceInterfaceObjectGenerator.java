package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
import org.bimserver.utils.*;
import org.bimserver.MetaDataManager;
import java.io.File;
import org.bimserver.tools.generators.GenerateUtils;
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
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "@XmlRootElement";
  protected final String TEXT_6 = NL + "@XmlSeeAlso(value={";
  protected final String TEXT_7 = "S";
  protected final String TEXT_8 = ".class, ";
  protected final String TEXT_9 = NL + "})";
  protected final String TEXT_10 = NL + "public class S";
  protected final String TEXT_11 = " extends ";
  protected final String TEXT_12 = "S";
  protected final String TEXT_13 = " implements SBase" + NL + "{" + NL + "\tprivate long oid = -1;" + NL + "\tprivate static final SClass sClass = new SClass(\"S";
  protected final String TEXT_14 = "\");" + NL + "\t" + NL + "\tstatic {" + NL + "\t\tsClass.addField(new SField(\"oid\", long.class));";
  protected final String TEXT_15 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_16 = "\", S";
  protected final String TEXT_17 = ".class));";
  protected final String TEXT_18 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_19 = "\", ";
  protected final String TEXT_20 = ".class, true));";
  protected final String TEXT_21 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_22 = "\", ";
  protected final String TEXT_23 = ".class));";
  protected final String TEXT_24 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_25 = "\", S";
  protected final String TEXT_26 = ".class, true));";
  protected final String TEXT_27 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_28 = "\", Long.class, true));";
  protected final String TEXT_29 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_30 = "Id\", S";
  protected final String TEXT_31 = ".class));";
  protected final String TEXT_32 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_33 = "Id\", long.class));";
  protected final String TEXT_34 = NL + "\t\tSPackage.getInstance().addSClass(sClass);" + NL + "" + NL + "\t}" + NL + "\t" + NL + "\tpublic long getOid() {" + NL + "\t\treturn oid;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setOid(long oid) {" + NL + "\t\tthis.oid = oid;" + NL + "\t}" + NL + "\t" + NL + "\tpublic SClass getSClass() {" + NL + "\t\treturn sClass;" + NL + "\t}" + NL + "\t" + NL + "\tpublic Object sGet(SField sField) {";
  protected final String TEXT_35 = NL + "\t\tif (sField.getName().equals(\"";
  protected final String TEXT_36 = "\")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_37 = "();" + NL + "\t\t}";
  protected final String TEXT_38 = NL + "\t\tif (sField.getName().equals(\"oid\")) {" + NL + "\t\t\treturn getOid();" + NL + "\t\t}" + NL + "\t\tthrow new RuntimeException(\"Field \" + sField.getName() + \" not found\");" + NL + "\t}";
  protected final String TEXT_39 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_40 = NL + "\tpublic void sSet(SField sField, Object val) {";
  protected final String TEXT_41 = NL + "\t\tif (sField.getName().equals(\"";
  protected final String TEXT_42 = "\")) {" + NL + "\t\t\tset";
  protected final String TEXT_43 = "((";
  protected final String TEXT_44 = ")val);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_45 = NL + "\t\tif (sField.getName().equals(\"oid\")) {" + NL + "\t\t\tsetOid((Long)val);" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tthrow new RuntimeException(\"Field \" + sField.getName() + \" not found\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_46 = NL + "\tprivate S";
  protected final String TEXT_47 = " ";
  protected final String TEXT_48 = ";";
  protected final String TEXT_49 = NL + "\tprivate List<";
  protected final String TEXT_50 = "> ";
  protected final String TEXT_51 = " = new ArrayList<";
  protected final String TEXT_52 = ">();";
  protected final String TEXT_53 = NL + "\t@XmlMimeType(\"application/octet-stream\")" + NL + "\tprivate DataHandler ";
  protected final String TEXT_54 = ";";
  protected final String TEXT_55 = NL + "\tprivate ";
  protected final String TEXT_56 = " ";
  protected final String TEXT_57 = ";";
  protected final String TEXT_58 = NL + "\tprivate List<S";
  protected final String TEXT_59 = "> ";
  protected final String TEXT_60 = " = new ArrayList<S";
  protected final String TEXT_61 = ">();";
  protected final String TEXT_62 = NL + "\tprivate List<Long> ";
  protected final String TEXT_63 = " = new ArrayList<Long>();";
  protected final String TEXT_64 = NL + "\tprivate S";
  protected final String TEXT_65 = " ";
  protected final String TEXT_66 = ";";
  protected final String TEXT_67 = NL + "\tprivate long ";
  protected final String TEXT_68 = "Id;";
  protected final String TEXT_69 = NL + "\tpublic S";
  protected final String TEXT_70 = " ";
  protected final String TEXT_71 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_72 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_73 = "(S";
  protected final String TEXT_74 = " ";
  protected final String TEXT_75 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL + "\t}";
  protected final String TEXT_78 = NL + NL + "\tpublic List<";
  protected final String TEXT_79 = "> ";
  protected final String TEXT_80 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_81 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_82 = "(List<";
  protected final String TEXT_83 = "> ";
  protected final String TEXT_84 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";" + NL + "\t}";
  protected final String TEXT_87 = NL + "\tpublic DataHandler ";
  protected final String TEXT_88 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_89 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_90 = "(DataHandler ";
  protected final String TEXT_91 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ";" + NL + "\t}";
  protected final String TEXT_94 = NL + "\tpublic ";
  protected final String TEXT_95 = " ";
  protected final String TEXT_96 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_97 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_98 = "(";
  protected final String TEXT_99 = " ";
  protected final String TEXT_100 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";" + NL + "\t}";
  protected final String TEXT_103 = NL + "\tpublic List<S";
  protected final String TEXT_104 = "> ";
  protected final String TEXT_105 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_106 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_107 = "(List<S";
  protected final String TEXT_108 = "> ";
  protected final String TEXT_109 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_110 = " = ";
  protected final String TEXT_111 = ";" + NL + "\t}";
  protected final String TEXT_112 = NL + "\tpublic List<Long> ";
  protected final String TEXT_113 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_114 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_115 = "(List<Long> ";
  protected final String TEXT_116 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_117 = " = ";
  protected final String TEXT_118 = ";" + NL + "\t}";
  protected final String TEXT_119 = NL + "\tpublic S";
  protected final String TEXT_120 = " ";
  protected final String TEXT_121 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_122 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_123 = "(S";
  protected final String TEXT_124 = " ";
  protected final String TEXT_125 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_126 = " = ";
  protected final String TEXT_127 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_128 = NL + "\tpublic long ";
  protected final String TEXT_129 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_130 = "Id;" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_131 = "(long ";
  protected final String TEXT_132 = "Id) {" + NL + "\t\tthis.";
  protected final String TEXT_133 = "Id = ";
  protected final String TEXT_134 = "Id;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_135 = NL + "\t@Override" + NL + "\tpublic int hashCode() {" + NL + "\t\tfinal int prime = 31;" + NL + "\t\tint result = 1;" + NL + "\t\tresult = prime * result + (int) (oid ^ (oid >>> 32));" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (this == obj)" + NL + "\t\t\treturn true;" + NL + "\t\tif (obj == null)" + NL + "\t\t\treturn false;" + NL + "\t\tif (getClass() != obj.getClass())" + NL + "\t\t\treturn false;" + NL + "\t\tS";
  protected final String TEXT_136 = " other = (S";
  protected final String TEXT_137 = ") obj;" + NL + "\t\tif (oid != other.oid)" + NL + "\t\t\treturn false;" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_138 = NL + "public enum S";
  protected final String TEXT_139 = " {";
  protected final String TEXT_140 = NL + "\t";
  protected final String TEXT_141 = "(";
  protected final String TEXT_142 = ")";
  protected final String TEXT_143 = NL + "\tint ordinal;" + NL + "" + NL + "\tS";
  protected final String TEXT_144 = "(int ordinal) {" + NL + "\t\tthis.ordinal = ordinal;" + NL + "\t}" + NL + "\t" + NL + "\tpublic int getOrdinal() {" + NL + "\t\treturn ordinal;" + NL + "\t}";
  protected final String TEXT_145 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
    stringBuffer.append(TEXT_3);
    stringBuffer.append(Licenser.getCommentedLicenseText(new File("license.txt")));
    stringBuffer.append(TEXT_4);
    
	Object[] arguments = (Object[])argument;
	EClassifier eClassifier = (EClassifier)arguments[0];
	ImportManager importManager = (ImportManager)arguments[1];
	MetaDataManager metaDataManager = (MetaDataManager)arguments[2];
	importManager.mark(stringBuffer);
	boolean hasLists = false;
	if (eClassifier instanceof EClass) {
		importManager.getImport("javax.xml.bind.annotation.XmlRootElement");
		importManager.getImport("org.bimserver.shared.meta.*");
		EClass eClass = (EClass)eClassifier;

    stringBuffer.append(TEXT_5);
     if (!metaDataManager.getDirectSubClasses(eClass).isEmpty()) { 
importManager.getImport("javax.xml.bind.annotation.XmlSeeAlso");

    stringBuffer.append(TEXT_6);
    
for (EClass subClass : metaDataManager.getDirectSubClasses(eClass)) {
	
    stringBuffer.append(TEXT_7);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_8);
    
}

    stringBuffer.append(TEXT_9);
    
} 

    stringBuffer.append(TEXT_10);
    stringBuffer.append(eClass.getName());
    
	if (!eClass.getESuperTypes().isEmpty()) {
		
    stringBuffer.append(TEXT_11);
    
		for (EClass eSuperClass : eClass.getESuperTypes()) {
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(eSuperClass.getName());
    
		}
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_14);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
		if (eStructuralFeature instanceof EAttribute) {
			EAttribute eAttribute = (EAttribute)eStructuralFeature;
			if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_17);
    
			} else {
				if (eAttribute.isMany()) {
					hasLists = true;

    stringBuffer.append(TEXT_18);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_20);
    
				} else {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_23);
    
				}
			}
		} else if (eStructuralFeature instanceof EReference) {
			EReference eReference = (EReference)eStructuralFeature;
			if (eReference.isMany()) {
				hasLists = true;
				if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_26);
    
				} else {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_28);
    
				}
			} else {
				if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_31);
    
				} else {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_33);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_34);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eStructuralFeature.getName()));
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_37);
    
	}

    stringBuffer.append(TEXT_38);
     if (hasLists) { 
    stringBuffer.append(TEXT_39);
     } 
    stringBuffer.append(TEXT_40);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEDate()) {
			importManager.getImport("java.util.Date");
		} else if (eStructuralFeature.getEType().getName().equals("DataHandler")) {
			importManager.getImport("javax.activation.DataHandler");
		
		}
		boolean useId = (eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null);

    stringBuffer.append(TEXT_41);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(StringUtils.firstUpperCase(eStructuralFeature.getName()));
    stringBuffer.append(useId ? "Id" : "" );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(GenerateUtils.getType(eStructuralFeature));
    stringBuffer.append(TEXT_44);
    
	}

    stringBuffer.append(TEXT_45);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
		if (eStructuralFeature.getEAnnotation("notinserviceinterface") == null) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_48);
    
				} else {
					if (eAttribute.isMany()) {
						importManager.getImport("java.util.List");
						importManager.getImport("java.util.ArrayList");

    stringBuffer.append(TEXT_49);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_52);
    
					} else {
						if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray() && eAttribute.getEAnnotation("file") != null) {
							importManager.getImport("javax.activation.DataHandler");

    stringBuffer.append(TEXT_53);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_54);
    
						} else {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_57);
    
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					importManager.getImport("java.util.List");
					importManager.getImport("java.util.ArrayList");
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_61);
    			
					} else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_63);
    
					}
				} else {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_64);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_66);
    
					} else {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_68);
    
					}
				}
			}
		}
	}
	for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
		if (eStructuralFeature.getEAnnotation("notinserviceinterface") == null) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_77);
    
				} else {
					if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_86);
    
					} else {
						if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray() && eAttribute.getEAnnotation("file") != null) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_93);
    
						} else {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_102);
    
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_111);
    
					} else {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_118);
    
					}
				} else {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_127);
    
					} else {

    stringBuffer.append(TEXT_128);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_134);
    
					}
				}
			}
		}
	}

    stringBuffer.append(TEXT_135);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_137);
    
	} else if (eClassifier instanceof EEnum) {
		EEnum eEnum = (EEnum)eClassifier;

    stringBuffer.append(TEXT_138);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_139);
    
	for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {

    stringBuffer.append(TEXT_140);
    stringBuffer.append(eEnumLiteral.getName());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(eEnumLiteral.getValue());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(eEnum.getELiterals().get(eEnum.getELiterals().size()-1) == eEnumLiteral ? ";" : ",");
    
	}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_144);
    	} 
    
	importManager.writeImports(stringBuffer);

    stringBuffer.append(TEXT_145);
    return stringBuffer.toString();
  }
}
