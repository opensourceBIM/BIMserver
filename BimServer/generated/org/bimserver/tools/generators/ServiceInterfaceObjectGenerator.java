package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
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
  protected final String TEXT_1 = "package org.bimserver.interfaces.objects;" + NL + "" + NL + "import java.util.*;" + NL + "import javax.xml.bind.annotation.*;" + NL + "import org.bimserver.shared.meta.*;" + NL + "import javax.activation.DataHandler;";
  protected final String TEXT_2 = NL + NL + "@XmlRootElement" + NL + "public class S";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = "S";
  protected final String TEXT_5 = " implements SBase" + NL + "{" + NL + "\tprivate long oid;" + NL + "\tprivate static final SClass sClass = new SClass(\"";
  protected final String TEXT_6 = "\");" + NL + "\t" + NL + "\tstatic {" + NL + "\t\tsClass.addField(new SField(\"oid\", long.class));";
  protected final String TEXT_7 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_8 = "\", S";
  protected final String TEXT_9 = ".class));";
  protected final String TEXT_10 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_11 = "\", ";
  protected final String TEXT_12 = ".class, true));";
  protected final String TEXT_13 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_14 = "\", ";
  protected final String TEXT_15 = ".class));";
  protected final String TEXT_16 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_17 = "\", S";
  protected final String TEXT_18 = ".class, true));";
  protected final String TEXT_19 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_20 = "\", Long.class, true));";
  protected final String TEXT_21 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_22 = "Id\", S";
  protected final String TEXT_23 = ".class));";
  protected final String TEXT_24 = NL + "\t\tsClass.addField(new SField(\"";
  protected final String TEXT_25 = "Id\", long.class));";
  protected final String TEXT_26 = NL + "\t}" + NL + "\t" + NL + "\tpublic long getOid() {" + NL + "\t\treturn oid;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setOid(long oid) {" + NL + "\t\tthis.oid = oid;" + NL + "\t}" + NL + "\t" + NL + "\tpublic SClass getSClass() {" + NL + "\t\treturn sClass;" + NL + "\t}" + NL + "\t" + NL + "\tpublic Object sGet(SField sField) {";
  protected final String TEXT_27 = NL + "\t\tif (sField.getName().equals(\"";
  protected final String TEXT_28 = "\")) {" + NL + "\t\t\treturn ";
  protected final String TEXT_29 = "();" + NL + "\t\t}";
  protected final String TEXT_30 = NL + "\t\tif (sField.getName().equals(\"oid\")) {" + NL + "\t\t\treturn getOid();" + NL + "\t\t}" + NL + "\t\tthrow new RuntimeException(\"Field \" + sField.getName() + \" not found\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_31 = NL + "\tprivate S";
  protected final String TEXT_32 = " ";
  protected final String TEXT_33 = ";";
  protected final String TEXT_34 = NL + "\tprivate List<";
  protected final String TEXT_35 = "> ";
  protected final String TEXT_36 = " = new ArrayList<";
  protected final String TEXT_37 = ">();";
  protected final String TEXT_38 = NL + "\t@XmlMimeType(\"application/octet-stream\")" + NL + "\tprivate DataHandler ";
  protected final String TEXT_39 = ";";
  protected final String TEXT_40 = NL + "\tprivate ";
  protected final String TEXT_41 = " ";
  protected final String TEXT_42 = ";";
  protected final String TEXT_43 = NL + "\tprivate List<S";
  protected final String TEXT_44 = "> ";
  protected final String TEXT_45 = " = new ArrayList<S";
  protected final String TEXT_46 = ">();";
  protected final String TEXT_47 = NL + "\tprivate List<Long> ";
  protected final String TEXT_48 = " = new ArrayList<Long>();";
  protected final String TEXT_49 = NL + "\tprivate S";
  protected final String TEXT_50 = " ";
  protected final String TEXT_51 = ";";
  protected final String TEXT_52 = NL + "\tprivate long ";
  protected final String TEXT_53 = "Id;";
  protected final String TEXT_54 = NL + "\tpublic S";
  protected final String TEXT_55 = " ";
  protected final String TEXT_56 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_57 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_58 = "(S";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = ";" + NL + "\t}";
  protected final String TEXT_63 = NL + NL + "\tpublic List<";
  protected final String TEXT_64 = "> ";
  protected final String TEXT_65 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_66 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_67 = "(List<";
  protected final String TEXT_68 = "> ";
  protected final String TEXT_69 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_70 = " = ";
  protected final String TEXT_71 = ";" + NL + "\t}";
  protected final String TEXT_72 = NL + "\tpublic DataHandler ";
  protected final String TEXT_73 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_74 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_75 = "(DataHandler ";
  protected final String TEXT_76 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ";" + NL + "\t}";
  protected final String TEXT_79 = NL + "\tpublic ";
  protected final String TEXT_80 = " ";
  protected final String TEXT_81 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_82 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_83 = "(";
  protected final String TEXT_84 = " ";
  protected final String TEXT_85 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ";" + NL + "\t}";
  protected final String TEXT_88 = NL + "\tpublic List<S";
  protected final String TEXT_89 = "> ";
  protected final String TEXT_90 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_91 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_92 = "(List<S";
  protected final String TEXT_93 = "> ";
  protected final String TEXT_94 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_95 = " = ";
  protected final String TEXT_96 = ";" + NL + "\t}";
  protected final String TEXT_97 = NL + "\tpublic List<Long> ";
  protected final String TEXT_98 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_99 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_100 = "(List<Long> ";
  protected final String TEXT_101 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = ";" + NL + "\t}";
  protected final String TEXT_104 = NL + "\tpublic S";
  protected final String TEXT_105 = " ";
  protected final String TEXT_106 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_107 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_108 = "(S";
  protected final String TEXT_109 = " ";
  protected final String TEXT_110 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = ";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_113 = NL + "\tpublic long ";
  protected final String TEXT_114 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_115 = "Id;" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_116 = "(long ";
  protected final String TEXT_117 = "Id) {" + NL + "\t\tthis.";
  protected final String TEXT_118 = "Id = ";
  protected final String TEXT_119 = "Id;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_120 = NL + "\t@Override" + NL + "\tpublic int hashCode() {" + NL + "\t\tfinal int prime = 31;" + NL + "\t\tint result = 1;" + NL + "\t\tresult = prime * result + (int) (oid ^ (oid >>> 32));" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (this == obj)" + NL + "\t\t\treturn true;" + NL + "\t\tif (obj == null)" + NL + "\t\t\treturn false;" + NL + "\t\tif (getClass() != obj.getClass())" + NL + "\t\t\treturn false;" + NL + "\t\tS";
  protected final String TEXT_121 = " other = (S";
  protected final String TEXT_122 = ") obj;" + NL + "\t\tif (oid != other.oid)" + NL + "\t\t\treturn false;" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_123 = NL + "public enum S";
  protected final String TEXT_124 = " {";
  protected final String TEXT_125 = NL + "\t";
  protected final String TEXT_126 = "(";
  protected final String TEXT_127 = ")";
  protected final String TEXT_128 = NL + "\tint ordinal;" + NL + "" + NL + "\tS";
  protected final String TEXT_129 = "(int ordinal) {" + NL + "\t\tthis.ordinal = ordinal;" + NL + "\t}" + NL + "\t" + NL + "\tpublic int getOrdinal() {" + NL + "\t\treturn ordinal;" + NL + "\t}";
  protected final String TEXT_130 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	if (argument instanceof EClass) {
		EClass eClass = (EClass)argument;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(eClass.getName());
    
	if (!eClass.getESuperTypes().isEmpty()) {
		
    stringBuffer.append(TEXT_3);
    
		for (EClass eSuperClass : eClass.getESuperTypes()) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(eSuperClass.getName());
    
		}
	}

    stringBuffer.append(TEXT_5);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_6);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
		if (eStructuralFeature instanceof EAttribute) {
			EAttribute eAttribute = (EAttribute)eStructuralFeature;
			if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_9);
    
			} else {
				if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_12);
    
				} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_15);
    
				}
			}
		} else if (eStructuralFeature instanceof EReference) {
			EReference eReference = (EReference)eStructuralFeature;
			if (eReference.isMany()) {
				if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_18);
    
				} else {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_20);
    
				}
			} else {
				if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_23);
    
				} else {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append(TEXT_25);
    
				}
			}
		}
	}

    stringBuffer.append(TEXT_26);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(eStructuralFeature.getName());
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eStructuralFeature.getName()));
    stringBuffer.append((eStructuralFeature instanceof EReference && !eStructuralFeature.isMany() && eStructuralFeature.getEAnnotation("embedsreference") == null) ? "Id" : "" );
    stringBuffer.append(TEXT_29);
    
	}

    stringBuffer.append(TEXT_30);
    
	for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
		if (eStructuralFeature.getEAnnotation("notinserviceinterface") == null) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_33);
    
				} else {
					if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_37);
    
					} else {
						if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray() && eAttribute.getEAnnotation("file") != null) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_39);
    
						} else {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_42);
    
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_46);
    			
					} else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_48);
    
					}
				} else {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_51);
    
					} else {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_53);
    
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

    stringBuffer.append(TEXT_54);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_62);
    
				} else {
					if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_71);
    
					} else {
						if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray() && eAttribute.getEAnnotation("file") != null) {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_78);
    
						} else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_87);
    
						}
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_96);
    
					} else {

    stringBuffer.append(TEXT_97);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_103);
    
					}
				} else {
					if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_104);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_112);
    
					} else {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_119);
    
					}
				}
			}
		}
	}

    stringBuffer.append(TEXT_120);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_122);
    
	} else if (argument instanceof EEnum) {
		EEnum eEnum = (EEnum)argument;

    stringBuffer.append(TEXT_123);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_124);
    
	for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(eEnumLiteral.getName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(eEnumLiteral.getValue());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(eEnum.getELiterals().get(eEnum.getELiterals().size()-1) == eEnumLiteral ? ";" : ",");
    
	}

    stringBuffer.append(TEXT_128);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_129);
    	} 
    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}
