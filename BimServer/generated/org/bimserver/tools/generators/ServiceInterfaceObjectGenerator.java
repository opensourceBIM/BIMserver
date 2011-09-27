package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
import org.bimserver.utils.*;
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
  protected final String TEXT_4 = NL + NL + "import java.util.*;" + NL + "import javax.xml.bind.annotation.*;" + NL + "import org.bimserver.shared.meta.*;" + NL + "import javax.activation.DataHandler;";
  protected final String TEXT_5 = NL + NL + "@XmlRootElement" + NL + "public class S";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = "S";
  protected final String TEXT_8 = " implements SBase" + NL + "{" + NL + "\tprivate long oid;" + NL + "\tprivate static final SClass sClass = new SClass(\"S";
  protected final String TEXT_9 = "\");" + NL + "\t" + NL + "\tstatic {" + NL + "\t\tsClass.addField(new SField(\"oid\", long.class));";
  protected final String TEXT_10 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_11 = "\", S";
  protected final String TEXT_12 = ".class));";
  protected final String TEXT_13 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_14 = "\", ";
  protected final String TEXT_15 = ".class, true));";
  protected final String TEXT_16 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_17 = "\", ";
  protected final String TEXT_18 = ".class));";
  protected final String TEXT_19 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_20 = "\", S";
  protected final String TEXT_21 = ".class, true));";
  protected final String TEXT_22 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_23 = "\", Long.class, true));";
  protected final String TEXT_24 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_25 = "Id\", S";
  protected final String TEXT_26 = ".class));";
  protected final String TEXT_27 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_28 = "Id\", long.class));";
  protected final String TEXT_29 = NL + "\t\tSPackage.getInstance().addSClass(sClass);" + NL + "" + NL + "\t}" + NL + "\t" + NL + "\tpublic long getOid() {" + NL + "\t\treturn oid;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setOid(long oid) {" + NL + "\t\tthis.oid = oid;" + NL + "\t}" + NL + "\t" + NL + "\tpublic SClass getSClass() {" + NL + "\t\treturn sClass;" + NL + "\t}" + NL + "\t" + NL + "\tpublic Object sGet(SField sField) {";
  protected final String TEXT_30 = NL + "\t\tif (sField.getName().equals(\"";
  protected final String TEXT_31 = "\")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_32 = "();" + NL + "\t\t}";
  protected final String TEXT_33 = NL + "\t\tif (sField.getName().equals(\"oid\")) {" + NL + "\t\t\treturn getOid();" + NL + "\t\t}" + NL + "\t\tthrow new RuntimeException(\"Field \" + sField.getName() + \" not found\");" + NL + "\t}" + NL + "" + NL + "\tpublic void sSet(SField sField, Object val) {";
  protected final String TEXT_34 = NL + "\t\tif (sField.getName().equals(\"";
  protected final String TEXT_35 = "\")) {" + NL + "\t\t\tset";
  protected final String TEXT_36 = "((";
  protected final String TEXT_37 = ")val);" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_38 = NL + "\t\tif (sField.getName().equals(\"oid\")) {" + NL + "\t\t\tsetOid((Long)val);" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tthrow new RuntimeException(\"Field \" + sField.getName() + \" not found\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_39 = NL + "\tprivate S";
  protected final String TEXT_40 = " ";
  protected final String TEXT_41 = ";";
  protected final String TEXT_42 = NL + "\tprivate List<";
  protected final String TEXT_43 = "> ";
  protected final String TEXT_44 = " = new ArrayList<";
  protected final String TEXT_45 = ">();";
  protected final String TEXT_46 = NL + "\t@XmlMimeType(\"application/octet-stream\")" + NL + "\tprivate DataHandler ";
  protected final String TEXT_47 = ";";
  protected final String TEXT_48 = NL + "\tprivate ";
  protected final String TEXT_49 = " ";
  protected final String TEXT_50 = ";";
  protected final String TEXT_51 = NL + "\tprivate List<S";
  protected final String TEXT_52 = "> ";
  protected final String TEXT_53 = " = new ArrayList<S";
  protected final String TEXT_54 = ">();";
  protected final String TEXT_55 = NL + "\tprivate List<Long> ";
  protected final String TEXT_56 = " = new ArrayList<Long>();";
  protected final String TEXT_57 = NL + "\tprivate S";
  protected final String TEXT_58 = " ";
  protected final String TEXT_59 = ";";
  protected final String TEXT_60 = NL + "\tprivate long ";
  protected final String TEXT_61 = "Id;";
  protected final String TEXT_62 = NL + "\tpublic S";
  protected final String TEXT_63 = " ";
  protected final String TEXT_64 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_65 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_66 = "(S";
  protected final String TEXT_67 = " ";
  protected final String TEXT_68 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_69 = " = ";
  protected final String TEXT_70 = ";" + NL + "\t}";
  protected final String TEXT_71 = NL + NL + "\tpublic List<";
  protected final String TEXT_72 = "> ";
  protected final String TEXT_73 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_74 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_75 = "(List<";
  protected final String TEXT_76 = "> ";
  protected final String TEXT_77 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";" + NL + "\t}";
  protected final String TEXT_80 = NL + "\tpublic DataHandler ";
  protected final String TEXT_81 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_82 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_83 = "(DataHandler ";
  protected final String TEXT_84 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = ";" + NL + "\t}";
  protected final String TEXT_87 = NL + "\tpublic ";
  protected final String TEXT_88 = " ";
  protected final String TEXT_89 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_90 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_91 = "(";
  protected final String TEXT_92 = " ";
  protected final String TEXT_93 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_94 = " = ";
  protected final String TEXT_95 = ";" + NL + "\t}";
  protected final String TEXT_96 = NL + "\tpublic List<S";
  protected final String TEXT_97 = "> ";
  protected final String TEXT_98 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_99 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_100 = "(List<S";
  protected final String TEXT_101 = "> ";
  protected final String TEXT_102 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = ";" + NL + "\t}";
  protected final String TEXT_105 = NL + "\tpublic List<Long> ";
  protected final String TEXT_106 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_107 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_108 = "(List<Long> ";
  protected final String TEXT_109 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_110 = " = ";
  protected final String TEXT_111 = ";" + NL + "\t}";
  protected final String TEXT_112 = NL + "\tpublic S";
  protected final String TEXT_113 = " ";
  protected final String TEXT_114 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_115 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_116 = "(S";
  protected final String TEXT_117 = " ";
  protected final String TEXT_118 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_119 = " = ";
  protected final String TEXT_120 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_121 = NL + "\tpublic long ";
  protected final String TEXT_122 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_123 = "Id;" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_124 = "(long ";
  protected final String TEXT_125 = "Id) {" + NL + "\t\tthis.";
  protected final String TEXT_126 = "Id = ";
  protected final String TEXT_127 = "Id;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_128 = NL + "\t@Override" + NL + "\tpublic int hashCode() {" + NL + "\t\tfinal int prime = 31;" + NL + "\t\tint result = 1;" + NL + "\t\tresult = prime * result + (int) (oid ^ (oid >>> 32));" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (this == obj)" + NL + "\t\t\treturn true;" + NL + "\t\tif (obj == null)" + NL + "\t\t\treturn false;" + NL + "\t\tif (getClass() != obj.getClass())" + NL + "\t\t\treturn false;" + NL + "\t\tS";
  protected final String TEXT_129 = " other = (S";
  protected final String TEXT_130 = ") obj;" + NL + "\t\tif (oid != other.oid)" + NL + "\t\t\treturn false;" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_131 = NL + "public enum S";
  protected final String TEXT_132 = " {";
  protected final String TEXT_133 = NL + "\t";
  protected final String TEXT_134 = "(";
  protected final String TEXT_135 = ")";
  protected final String TEXT_136 = NL + "\tint ordinal;" + NL + "" + NL + "\tS";
  protected final String TEXT_137 = "(int ordinal) {" + NL + "\t\tthis.ordinal = ordinal;" + NL + "\t}" + NL + "\t" + NL + "\tpublic int getOrdinal() {" + NL + "\t\treturn ordinal;" + NL + "\t}";
  protected final String TEXT_138 = NL + "}";

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
    
	if (argument instanceof EClass) {
		EClass eClass = (EClass)argument;

    stringBuffer.append(TEXT_5);
    stringBuffer.append(eClass.getName());
    
	if (!eClass.getESuperTypes().isEmpty()) {
		
    stringBuffer.append(TEXT_6);
    
		for (EClass eSuperClass : eClass.getESuperTypes()) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(eSuperClass.getName());
    
		}
	}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_9);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
		if (eStructuralFeature instanceof EAttribute) {
			EAttribute eAttribute = (EAttribute)eStructuralFeature;
			if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_12);
    
			} else {
				if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_15);
    
				} else {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_18);
    
				}
			}
		} else if (eStructuralFeature instanceof EReference) {
			EReference eReference = (EReference)eStructuralFeature;
			if (eReference.isMany()) {
				if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_21);
    
				} else {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_23);
    
				}
			} else {
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
			}
		}
	}

    stringBuffer.append(TEXT_29);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eStructuralFeature.getName()));
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_32);
    
	}

    stringBuffer.append(TEXT_33);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
		boolean useId = (eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null);

    stringBuffer.append(TEXT_34);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(StringUtils.firstUpperCase(eStructuralFeature.getName()));
    stringBuffer.append(useId ? "Id" : "" );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(GenerateUtils.getType(eStructuralFeature));
    stringBuffer.append(TEXT_37);
    
	}

    stringBuffer.append(TEXT_38);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
		if (eStructuralFeature.getEAnnotation("notinserviceinterface") == null) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_41);
    
				} else {
					if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_45);
    
					} else {
						if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray() && eAttribute.getEAnnotation("file") != null) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_47);
    
						} else {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_50);
    
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_54);
    			
					} else {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_56);
    
					}
				} else {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_59);
    
					} else {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_61);
    
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

    stringBuffer.append(TEXT_62);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_70);
    
				} else {
					if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_79);
    
					} else {
						if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray() && eAttribute.getEAnnotation("file") != null) {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_86);
    
						} else {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_95);
    
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_103);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_104);
    
					} else {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_111);
    
					}
				} else {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_120);
    
					} else {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_127);
    
					}
				}
			}
		}
	}

    stringBuffer.append(TEXT_128);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_130);
    
	} else if (argument instanceof EEnum) {
		EEnum eEnum = (EEnum)argument;

    stringBuffer.append(TEXT_131);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_132);
    
	for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(eEnumLiteral.getName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(eEnumLiteral.getValue());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(eEnum.getELiterals().get(eEnum.getELiterals().size()-1) == eEnumLiteral ? ";" : ",");
    
	}

    stringBuffer.append(TEXT_136);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_137);
    	} 
    stringBuffer.append(TEXT_138);
    return stringBuffer.toString();
  }
}
