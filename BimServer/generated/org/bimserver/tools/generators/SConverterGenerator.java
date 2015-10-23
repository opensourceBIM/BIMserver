package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
import org.bimserver.utils.*;
import org.bimserver.emf.MetaDataManager;
import java.io.File;
import java.util.Set;
import org.bimserver.utils.StringUtils;

public class SConverterGenerator
{
  protected static String nl;
  public static synchronized SConverterGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SConverterGenerator result = new SConverterGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package org.bimserver.interfaces;";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "import org.bimserver.emf.IdEObjectImpl;" + NL + "import org.bimserver.interfaces.objects.*;" + NL + "import java.util.*;" + NL + "import org.bimserver.models.log.*;" + NL + "import org.bimserver.models.store.*;" + NL + "import org.bimserver.database.DatabaseSession;" + NL + "import org.bimserver.database.BimserverDatabaseException;" + NL + "import org.bimserver.database.Query;" + NL + "" + NL + "public class SConverter {";
  protected final String TEXT_5 = NL + NL + "\tpublic Set<S";
  protected final String TEXT_6 = "> convertToSSet";
  protected final String TEXT_7 = "(Collection<";
  protected final String TEXT_8 = "> input) {" + NL + "\t\tSet<S";
  protected final String TEXT_9 = "> result = new HashSet<S";
  protected final String TEXT_10 = ">();" + NL + "\t\tfor (";
  protected final String TEXT_11 = " o : input) {" + NL + "\t\t\tresult.add(convertToSObject(o));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic Set<";
  protected final String TEXT_12 = "> convertFromSSet";
  protected final String TEXT_13 = "(Collection<S";
  protected final String TEXT_14 = "> input, DatabaseSession session) throws BimserverDatabaseException {" + NL + "\t\tSet<";
  protected final String TEXT_15 = "> result = new HashSet<";
  protected final String TEXT_16 = ">();" + NL + "\t\tfor (S";
  protected final String TEXT_17 = " o : input) {" + NL + "\t\t\tresult.add(convertFromSObject(o, session));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic List<S";
  protected final String TEXT_18 = "> convertToSList";
  protected final String TEXT_19 = "(Collection<";
  protected final String TEXT_20 = "> input) {" + NL + "\t\tList<S";
  protected final String TEXT_21 = "> result = new ArrayList<S";
  protected final String TEXT_22 = ">();" + NL + "\t\tfor (";
  protected final String TEXT_23 = " o : input) {" + NL + "\t\t\tresult.add(convertToSObject(o));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic List<";
  protected final String TEXT_24 = "> convertFromSList";
  protected final String TEXT_25 = "(Collection<S";
  protected final String TEXT_26 = "> input, DatabaseSession session) throws BimserverDatabaseException {" + NL + "\t\tList<";
  protected final String TEXT_27 = "> result = new ArrayList<";
  protected final String TEXT_28 = ">();" + NL + "\t\tfor (S";
  protected final String TEXT_29 = " o : input) {" + NL + "\t\t\tresult.add(convertFromSObject(o, session));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic S";
  protected final String TEXT_30 = " convertToSObject(";
  protected final String TEXT_31 = " input) {" + NL + "\t\tif (input == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = "if (input instanceof ";
  protected final String TEXT_34 = ") {" + NL + "\t\t\treturn convertToSObject((";
  protected final String TEXT_35 = ")input);" + NL + "\t\t}";
  protected final String TEXT_36 = NL + "\t\tS";
  protected final String TEXT_37 = " result = new S";
  protected final String TEXT_38 = "();";
  protected final String TEXT_39 = NL + "\t\tresult.setOid(input.getOid());" + NL + "\t\tresult.setRid(input.getRid());";
  protected final String TEXT_40 = NL + "\t\tresult.set";
  protected final String TEXT_41 = "(S";
  protected final String TEXT_42 = ".values()[input.get";
  protected final String TEXT_43 = "().ordinal()]);";
  protected final String TEXT_44 = NL + "\t\tresult.get";
  protected final String TEXT_45 = "().addAll(input.";
  protected final String TEXT_46 = "());";
  protected final String TEXT_47 = NL + "\t\tresult.set";
  protected final String TEXT_48 = "(input.";
  protected final String TEXT_49 = "());";
  protected final String TEXT_50 = NL + "\t\tList<S";
  protected final String TEXT_51 = "> list";
  protected final String TEXT_52 = " = new ArrayList<S";
  protected final String TEXT_53 = ">();" + NL + "\t\tfor (";
  protected final String TEXT_54 = " v : input.get";
  protected final String TEXT_55 = "()) {" + NL + "\t\t\tlist";
  protected final String TEXT_56 = ".add(convertToSObject(v));" + NL + "\t\t}" + NL + "\t\tresult.set";
  protected final String TEXT_57 = "(list";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\t\tList<Long> list";
  protected final String TEXT_60 = " = new ArrayList<Long>();" + NL + "\t\tfor (";
  protected final String TEXT_61 = " v : input.get";
  protected final String TEXT_62 = "()) {" + NL + "\t\t\tlist";
  protected final String TEXT_63 = ".add(v.getOid());" + NL + "\t\t}" + NL + "\t\tresult.set";
  protected final String TEXT_64 = "(list";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\t";
  protected final String TEXT_67 = " ";
  protected final String TEXT_68 = "Val = input.get";
  protected final String TEXT_69 = "();" + NL + "\t\tresult.set";
  protected final String TEXT_70 = "(convertToSObject(";
  protected final String TEXT_71 = "Val));";
  protected final String TEXT_72 = NL + "\t\t";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = "Val = input.get";
  protected final String TEXT_75 = "();" + NL + "\t\tresult.set";
  protected final String TEXT_76 = "Id(";
  protected final String TEXT_77 = "Val == null ? -1 : ";
  protected final String TEXT_78 = "Val.getOid());";
  protected final String TEXT_79 = NL + "\t\treturn result;" + NL + "\t}" + NL + "\tpublic ";
  protected final String TEXT_80 = " convertFromSObject(S";
  protected final String TEXT_81 = " input, DatabaseSession session) throws BimserverDatabaseException {" + NL + "\t\t";
  protected final String TEXT_82 = " result = convertFromSObject(input, ";
  protected final String TEXT_83 = "Factory.eINSTANCE.create";
  protected final String TEXT_84 = "(), session);" + NL + "\t\t";
  protected final String TEXT_85 = NL + "\t\t((IdEObjectImpl)result).setOid(input.getOid());" + NL + "\t\t((IdEObjectImpl)result).setRid(input.getRid());" + NL + "\t\t";
  protected final String TEXT_86 = NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_87 = " convertFromSObject(S";
  protected final String TEXT_88 = " input, ";
  protected final String TEXT_89 = " result, DatabaseSession session) throws BimserverDatabaseException {" + NL + "\t\tif (input == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_90 = NL + "\t\t";
  protected final String TEXT_91 = "if (input instanceof S";
  protected final String TEXT_92 = ") {" + NL + "\t\t\treturn convertFromSObject((S";
  protected final String TEXT_93 = ")input, session);" + NL + "\t\t}";
  protected final String TEXT_94 = NL + "\t\tresult.set";
  protected final String TEXT_95 = "(";
  protected final String TEXT_96 = ".values()[input.get";
  protected final String TEXT_97 = "().ordinal()]);";
  protected final String TEXT_98 = NL + "\t\tresult.get";
  protected final String TEXT_99 = "().addAll(input.";
  protected final String TEXT_100 = "());";
  protected final String TEXT_101 = NL + "\t\tresult.set";
  protected final String TEXT_102 = "(input.";
  protected final String TEXT_103 = "());";
  protected final String TEXT_104 = NL + "\t\tList<";
  protected final String TEXT_105 = "> list";
  protected final String TEXT_106 = " = result.get";
  protected final String TEXT_107 = "();" + NL + "\t\tfor (S";
  protected final String TEXT_108 = " v : input.get";
  protected final String TEXT_109 = "()) {" + NL + "\t\t\tlist";
  protected final String TEXT_110 = ".add(convertFromSObject(v, session));" + NL + "\t\t}";
  protected final String TEXT_111 = NL + "\t\tList<";
  protected final String TEXT_112 = "> list";
  protected final String TEXT_113 = " = result.get";
  protected final String TEXT_114 = "();" + NL + "\t\tfor (long oid : input.get";
  protected final String TEXT_115 = "()) {" + NL + "\t\t\tlist";
  protected final String TEXT_116 = ".add((";
  protected final String TEXT_117 = ")session.get(";
  protected final String TEXT_118 = "Package.eINSTANCE.get";
  protected final String TEXT_119 = "(), oid, Query.getDefault()));" + NL + "\t\t}";
  protected final String TEXT_120 = NL + "\t\tresult.set";
  protected final String TEXT_121 = "(convertFromSObject(input.get";
  protected final String TEXT_122 = "(), session));";
  protected final String TEXT_123 = NL + "\t\tresult.set";
  protected final String TEXT_124 = "((";
  protected final String TEXT_125 = ")session.get(";
  protected final String TEXT_126 = "Package.eINSTANCE.get";
  protected final String TEXT_127 = "(), input.get";
  protected final String TEXT_128 = "Id(), Query.getDefault()));";
  protected final String TEXT_129 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_130 = NL + "\t\tpublic S";
  protected final String TEXT_131 = " convertToSObject(";
  protected final String TEXT_132 = " input) {" + NL + "\t\t\treturn S";
  protected final String TEXT_133 = ".values()[input.ordinal()];" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic ";
  protected final String TEXT_134 = " convertFromSObject(S";
  protected final String TEXT_135 = " input) {" + NL + "\t\t\treturn ";
  protected final String TEXT_136 = ".values()[input.ordinal()];" + NL + "\t\t}";
  protected final String TEXT_137 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(Licenser.getCommentedLicenseText(new File("license.txt")));
    stringBuffer.append(TEXT_4);
    
	try {
	Object[] argumentsArray = (Object[])argument;
	MetaDataManager metaDataManager = (MetaDataManager)argumentsArray[0];
	@SuppressWarnings("unchecked") Set<EPackage> ePackages = (Set<EPackage>)argumentsArray[1];
	for (EPackage ePackage : ePackages) {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;

    stringBuffer.append(TEXT_5);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_31);
     if (metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass) != null && !metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass).isEmpty()) {
	for (EClass subClass : metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass)) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass).iterator().next() == subClass ? "" : "else ");
    stringBuffer.append(TEXT_33);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_35);
    
		}
	}

    stringBuffer.append(TEXT_36);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_38);
     if (eClass.getEAnnotation("nodatabase") == null) {
    stringBuffer.append(TEXT_39);
     } 
    
	for (EAttribute eAttribute : eClass.getEAllAttributes()) {
		if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_43);
    
		} else {
			if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_46);
    
			} else {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_49);
    
			}
		}
	}
	for (EReference eReference : eClass.getEAllReferences()) {
		if (eReference.isMany()) {
			if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_58);
    
			} else {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_65);
    
			}
		} else {
			if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_71);
    
			} else {

    stringBuffer.append(TEXT_72);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_78);
    
			}
		}
	}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(StringUtils.firstUpperCase(eClass.getEPackage().getName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_84);
     if (eClass.getEAnnotation("nodatabase") == null) { 
    stringBuffer.append(TEXT_85);
     } 
    stringBuffer.append(TEXT_86);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_89);
    
	if (!metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass).isEmpty()) {
		for (EClass subClass : metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass)) {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass).iterator().next() == subClass ? "" : "else ");
    stringBuffer.append(TEXT_91);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_93);
    
		}
		}
	for (EAttribute eAttribute : eClass.getEAllAttributes()) {
		if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_97);
    
		} else {
			if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_100);
    
			} else {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_103);
    
			}
		}
	}
	for (EReference eReference : eClass.getEAllReferences()) {
		if (eReference.isMany()) {
			if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_104);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_110);
    
			} else {

    stringBuffer.append(TEXT_111);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getEType().getEPackage().getName()));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_119);
    		
			}
		} else {
			if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_120);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_122);
    
			} else {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getEType().getEPackage().getName()));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_128);
    
			}
		}
	}

    stringBuffer.append(TEXT_129);
    
		} else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum)eClassifier;

    stringBuffer.append(TEXT_130);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_136);
    
		}
	}
}
} catch (Exception e) {
	e.printStackTrace();
}

    stringBuffer.append(TEXT_137);
    return stringBuffer.toString();
  }
}
