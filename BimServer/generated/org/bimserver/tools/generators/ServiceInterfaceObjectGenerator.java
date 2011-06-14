package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
import org.bimserver.tools.generators.GenerateUtils;

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
  protected final String TEXT_1 = "package org.bimserver.interfaces.objects;" + NL + "" + NL + "import java.util.*;" + NL + "import javax.xml.bind.annotation.XmlRootElement;";
  protected final String TEXT_2 = NL + NL + "@XmlRootElement" + NL + "public class S";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = "S";
  protected final String TEXT_5 = NL + "{" + NL + "\tprivate long oid;" + NL + "\t" + NL + "\tpublic long getOid() {" + NL + "\t\treturn oid;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setOid(long oid) {" + NL + "\t\tthis.oid = oid;" + NL + "\t}";
  protected final String TEXT_6 = NL + "\tprivate S";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = ";";
  protected final String TEXT_9 = NL + "\tprivate List<";
  protected final String TEXT_10 = "> ";
  protected final String TEXT_11 = " = new ArrayList<";
  protected final String TEXT_12 = ">();";
  protected final String TEXT_13 = NL + "\tprivate ";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = ";";
  protected final String TEXT_16 = NL + "\tprivate List<Long> ";
  protected final String TEXT_17 = " = new ArrayList<Long>();";
  protected final String TEXT_18 = NL + "\tprivate long ";
  protected final String TEXT_19 = "Id;";
  protected final String TEXT_20 = NL + "\tpublic S";
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_23 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_24 = "(S";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_27 = " = ";
  protected final String TEXT_28 = ";" + NL + "\t}";
  protected final String TEXT_29 = NL + NL + "\tpublic List<";
  protected final String TEXT_30 = "> ";
  protected final String TEXT_31 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_32 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_33 = "(List<";
  protected final String TEXT_34 = "> ";
  protected final String TEXT_35 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ";" + NL + "\t}";
  protected final String TEXT_38 = NL + NL + "\tpublic ";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_41 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = " ";
  protected final String TEXT_44 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";" + NL + "\t}";
  protected final String TEXT_47 = NL + "\tpublic List<Long> ";
  protected final String TEXT_48 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_49 = ";" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_50 = "(List<Long> ";
  protected final String TEXT_51 = ") {" + NL + "\t\tthis.";
  protected final String TEXT_52 = " = ";
  protected final String TEXT_53 = ";" + NL + "\t}";
  protected final String TEXT_54 = NL + "\tpublic long ";
  protected final String TEXT_55 = "() {" + NL + "\t\treturn ";
  protected final String TEXT_56 = "Id;" + NL + "\t}" + NL + "" + NL + "\tpublic void ";
  protected final String TEXT_57 = "(long ";
  protected final String TEXT_58 = "Id) {" + NL + "\t\tthis.";
  protected final String TEXT_59 = "Id = ";
  protected final String TEXT_60 = "Id;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_61 = NL + "\t@Override" + NL + "\tpublic int hashCode() {" + NL + "\t\tfinal int prime = 31;" + NL + "\t\tint result = 1;" + NL + "\t\tresult = prime * result + (int) (oid ^ (oid >>> 32));" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (this == obj)" + NL + "\t\t\treturn true;" + NL + "\t\tif (obj == null)" + NL + "\t\t\treturn false;" + NL + "\t\tif (getClass() != obj.getClass())" + NL + "\t\t\treturn false;" + NL + "\t\tS";
  protected final String TEXT_62 = " other = (S";
  protected final String TEXT_63 = ") obj;" + NL + "\t\tif (oid != other.oid)" + NL + "\t\t\treturn false;" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_64 = NL + "public enum S";
  protected final String TEXT_65 = " {";
  protected final String TEXT_66 = NL + "\t";
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = ")";
  protected final String TEXT_69 = NL + "\tint ordinal;" + NL + "" + NL + "\tS";
  protected final String TEXT_70 = "(int ordinal) {" + NL + "\t\tthis.ordinal = ordinal;" + NL + "\t}" + NL + "\t" + NL + "\tpublic int getOrdinal() {" + NL + "\t\treturn ordinal;" + NL + "\t}";
  protected final String TEXT_71 = NL + "}";

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
    
	for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
		if (eStructuralFeature.getEAnnotation("notinserviceinterface") == null) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_8);
    
				} else {
					if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_12);
    
					} else {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_15);
    
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_17);
    
				} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_19);
    
				}
			}
		}
	}
	for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
		if (eStructuralFeature.getEAnnotation("notinserviceinterface") == null) {
			if (eStructuralFeature instanceof EAttribute) {
				EAttribute eAttribute = (EAttribute)eStructuralFeature;
				if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_28);
    
				} else {
					if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_37);
    
					} else {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(GenerateUtils.makeGetter(eAttribute));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(GenerateUtils.makeSetter(eAttribute));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(eAttribute.getEType().getInstanceClassName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(eAttribute.getName());
    stringBuffer.append(TEXT_46);
    
					}
				}
			} else if (eStructuralFeature instanceof EReference) {
				EReference eReference = (EReference)eStructuralFeature;
				if (eReference.isMany()) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_53);
    
				} else {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(GenerateUtils.makeGetter(eReference));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(GenerateUtils.makeSetter(eReference));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_60);
    
	}
	}
		}
			}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_63);
    
	} else if (argument instanceof EEnum) {
		EEnum eEnum = (EEnum)argument;

    stringBuffer.append(TEXT_64);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_65);
    
	for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(eEnumLiteral.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(eEnumLiteral.getValue());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(eEnum.getELiterals().get(eEnum.getELiterals().size()-1) == eEnumLiteral ? ";" : ",");
    
	}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_70);
    	} 
    stringBuffer.append(TEXT_71);
    return stringBuffer.toString();
  }
}
