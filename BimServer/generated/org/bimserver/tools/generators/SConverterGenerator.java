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
  protected final String TEXT_3 = NL + NL + "import org.bimserver.emf.IdEObjectImpl;" + NL + "import org.bimserver.interfaces.objects.*;" + NL + "import java.util.*;" + NL + "import org.bimserver.models.log.*;" + NL + "import org.bimserver.models.store.*;" + NL + "import org.bimserver.models.geometry.*;" + NL + "import org.bimserver.database.DatabaseSession;" + NL + "import org.bimserver.BimserverDatabaseException;" + NL + "import org.bimserver.database.OldQuery;" + NL + "import org.slf4j.Logger;" + NL + "import org.slf4j.LoggerFactory;" + NL + "" + NL + "public class SConverter {" + NL + "\tprivate static final Logger LOGGER = LoggerFactory.getLogger(SConverter.class);";
  protected final String TEXT_4 = NL + NL + "\tpublic Set<S";
  protected final String TEXT_5 = "> convertToSSet";
  protected final String TEXT_6 = "(Collection<";
  protected final String TEXT_7 = "> input) {" + NL + "\t\tSet<S";
  protected final String TEXT_8 = "> result = new HashSet<S";
  protected final String TEXT_9 = ">();" + NL + "\t\tfor (";
  protected final String TEXT_10 = " o : input) {" + NL + "\t\t\tresult.add(convertToSObject(o));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic Set<";
  protected final String TEXT_11 = "> convertFromSSet";
  protected final String TEXT_12 = "(Collection<S";
  protected final String TEXT_13 = "> input, DatabaseSession session) throws BimserverDatabaseException {" + NL + "\t\tSet<";
  protected final String TEXT_14 = "> result = new HashSet<";
  protected final String TEXT_15 = ">();" + NL + "\t\tfor (S";
  protected final String TEXT_16 = " o : input) {" + NL + "\t\t\tresult.add(convertFromSObject(o, session));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic List<S";
  protected final String TEXT_17 = "> convertToSList";
  protected final String TEXT_18 = "> input) {" + NL + "\t\tList<S";
  protected final String TEXT_19 = "> result = new ArrayList<S";
  protected final String TEXT_20 = " o : input) {" + NL + "\t\t\tresult.add(convertToSObject(o));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic List<";
  protected final String TEXT_21 = "> convertFromSList";
  protected final String TEXT_22 = "> input, DatabaseSession session) throws BimserverDatabaseException {" + NL + "\t\tList<";
  protected final String TEXT_23 = "> result = new ArrayList<";
  protected final String TEXT_24 = " o : input) {" + NL + "\t\t\tresult.add(convertFromSObject(o, session));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic S";
  protected final String TEXT_25 = " convertToSObject(";
  protected final String TEXT_26 = " input) {" + NL + "\t\tif (input == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = "if (input instanceof ";
  protected final String TEXT_29 = ") {" + NL + "\t\t\treturn convertToSObject((";
  protected final String TEXT_30 = ")input);" + NL + "\t\t}";
  protected final String TEXT_31 = NL + "\t\tS";
  protected final String TEXT_32 = " result = new S";
  protected final String TEXT_33 = "();";
  protected final String TEXT_34 = NL + "\t\tresult.setOid(input.getOid());" + NL + "\t\tresult.setUuid(input.getUuid());" + NL + "\t\tresult.setRid(input.getRid());";
  protected final String TEXT_35 = NL + "\t\tresult.set";
  protected final String TEXT_36 = "(S";
  protected final String TEXT_37 = ".values()[input.get";
  protected final String TEXT_38 = "().ordinal()]);";
  protected final String TEXT_39 = NL + "\t\tresult.get";
  protected final String TEXT_40 = "().addAll(input.";
  protected final String TEXT_41 = "());";
  protected final String TEXT_42 = "(input.";
  protected final String TEXT_43 = NL + "\t\tList<S";
  protected final String TEXT_44 = "> list";
  protected final String TEXT_45 = " = new ArrayList<S";
  protected final String TEXT_46 = " v : input.get";
  protected final String TEXT_47 = "()) {" + NL + "\t\t\tlist";
  protected final String TEXT_48 = ".add(convertToSObject(v));" + NL + "\t\t}" + NL + "\t\tresult.set";
  protected final String TEXT_49 = "(list";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = NL + "\t\tList<Long> list";
  protected final String TEXT_52 = " = new ArrayList<Long>();" + NL + "\t\tfor (";
  protected final String TEXT_53 = ".add(v.getOid());" + NL + "\t\t}" + NL + "\t\tresult.set";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = "Val = input.get";
  protected final String TEXT_56 = "();" + NL + "\t\tresult.set";
  protected final String TEXT_57 = "(convertToSObject(";
  protected final String TEXT_58 = "Val));";
  protected final String TEXT_59 = "Id(";
  protected final String TEXT_60 = "Val == null ? -1 : ";
  protected final String TEXT_61 = "Val.getOid());";
  protected final String TEXT_62 = NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_63 = " convertFromSObject(S";
  protected final String TEXT_64 = " input, DatabaseSession session) throws BimserverDatabaseException {" + NL + "\t\tif (session == null) {" + NL + "\t\t\tthrow new BimserverDatabaseException(\"session == null, use the other method\");" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_65 = " result = convertFromSObject(input, (";
  protected final String TEXT_66 = ")session.create(";
  protected final String TEXT_67 = "Package.eINSTANCE.get";
  protected final String TEXT_68 = "()), session);" + NL + "\t\t";
  protected final String TEXT_69 = " input) throws BimserverDatabaseException {" + NL + "\t\t";
  protected final String TEXT_70 = " result = convertFromSObject(input, ";
  protected final String TEXT_71 = "Factory.eINSTANCE.create";
  protected final String TEXT_72 = "(), null);" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_73 = " input, ";
  protected final String TEXT_74 = " result, DatabaseSession session) throws BimserverDatabaseException {" + NL + "\t\tif (input == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_75 = "if (input instanceof S";
  protected final String TEXT_76 = ") {" + NL + "\t\t\treturn convertFromSObject((S";
  protected final String TEXT_77 = ")input, session);" + NL + "\t\t}";
  protected final String TEXT_78 = "(";
  protected final String TEXT_79 = NL + "\t\tList<";
  protected final String TEXT_80 = " = result.get";
  protected final String TEXT_81 = "();" + NL + "\t\tfor (S";
  protected final String TEXT_82 = ".add(convertFromSObject(v, session));" + NL + "\t\t}";
  protected final String TEXT_83 = "();" + NL + "\t\tfor (long oid : input.get";
  protected final String TEXT_84 = ".add((";
  protected final String TEXT_85 = ")session.get(";
  protected final String TEXT_86 = "(), oid, OldQuery.getDefault()));" + NL + "\t\t}";
  protected final String TEXT_87 = "(convertFromSObject(input.get";
  protected final String TEXT_88 = "(), session));";
  protected final String TEXT_89 = "((";
  protected final String TEXT_90 = "(), input.get";
  protected final String TEXT_91 = "Id(), OldQuery.getDefault()));";
  protected final String TEXT_92 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_93 = NL + "\t\tpublic S";
  protected final String TEXT_94 = " input) {" + NL + "\t\t\treturn S";
  protected final String TEXT_95 = ".values()[input.ordinal()];" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic ";
  protected final String TEXT_96 = " input) {" + NL + "\t\t\treturn ";
  protected final String TEXT_97 = ".values()[input.ordinal()];" + NL + "\t\t}";
  protected final String TEXT_98 = NL + "}";

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
    stringBuffer.append(TEXT_3);
    
	try {
	Object[] argumentsArray = (Object[])argument;
	MetaDataManager metaDataManager = (MetaDataManager)argumentsArray[0];
	@SuppressWarnings("unchecked") Set<EPackage> ePackages = (Set<EPackage>)argumentsArray[1];
	for (EPackage ePackage : ePackages) {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;

    stringBuffer.append(TEXT_4);
    stringBuffer.append(eClass.getName());
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
    stringBuffer.append(TEXT_6);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_26);
     if (metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass) != null && !metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass).isEmpty()) {
	for (EClass subClass : metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass)) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass).iterator().next() == subClass ? "" : "else ");
    stringBuffer.append(TEXT_28);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_30);
    
		}
	}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_33);
     if (eClass.getEAnnotation("nodatabase") == null) {
    stringBuffer.append(TEXT_34);
     } 
    
	for (EAttribute eAttribute : eClass.getEAllAttributes()) {
		if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_38);
    
		} else {
			if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_41);
    
			} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_41);
    
			}
		}
	}
	for (EReference eReference : eClass.getEAllReferences()) {
		if (eReference.isMany()) {
			if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_50);
    
			} else {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_50);
    
			}
		} else {
			if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_58);
    
			} else {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_61);
    
			}
		}
	}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(StringUtils.firstUpperCase(eClass.getEPackage().getName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_68);
     if (eClass.getEAnnotation("nodatabase") == null) { 
    stringBuffer.append(TEXT_27);
     } 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(StringUtils.firstUpperCase(eClass.getEPackage().getName()));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_74);
    
	if (!metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass).isEmpty()) {
		for (EClass subClass : metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass)) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(metaDataManager.getPackageMetaData(ePackage.getName()).getDirectSubClasses(eClass).iterator().next() == subClass ? "" : "else ");
    stringBuffer.append(TEXT_75);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(subClass.getName());
    stringBuffer.append(TEXT_77);
    
		}
		}
	for (EAttribute eAttribute : eClass.getEAllAttributes()) {
		if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_38);
    
		} else {
			if (eAttribute.isMany()) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_41);
    
			} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_41);
    
			}
		}
	}
	for (EReference eReference : eClass.getEAllReferences()) {
		if (eReference.isMany()) {
			if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_82);
    
			} else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getEType().getEPackage().getName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_86);
    		
			}
		} else {
			if (eReference.getEAnnotation("embedsreference") != null) {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_88);
    
			} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getEType().getEPackage().getName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_91);
    
			}
		}
	}

    stringBuffer.append(TEXT_92);
    
		} else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum)eClassifier;

    stringBuffer.append(TEXT_93);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_97);
    
		}
	}
}
} catch (Exception e) {
	e.printStackTrace();
}

    stringBuffer.append(TEXT_98);
    return stringBuffer.toString();
  }
}
