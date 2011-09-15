package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
import java.util.Set;
import org.bimserver.tools.generators.GenerateUtils;
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
  protected final String TEXT_1 = "package org.bimserver.interfaces;" + NL + "" + NL + "import org.bimserver.interfaces.objects.*;" + NL + "import java.util.*;" + NL + "import org.bimserver.models.log.*;" + NL + "import org.bimserver.models.store.*;" + NL + "import org.bimserver.database.BimDatabaseSession;" + NL + "" + NL + "public class SConverter {";
  protected final String TEXT_2 = NL + NL + "\tpublic Set<S";
  protected final String TEXT_3 = "> convertToSSet";
  protected final String TEXT_4 = "(Collection<";
  protected final String TEXT_5 = "> input) {" + NL + "\t\tSet<S";
  protected final String TEXT_6 = "> result = new HashSet<S";
  protected final String TEXT_7 = ">();" + NL + "\t\tfor (";
  protected final String TEXT_8 = " o : input) {" + NL + "\t\t\tresult.add(convertToSObject(o));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic Set<";
  protected final String TEXT_9 = "> convertFromSSet";
  protected final String TEXT_10 = "(Collection<S";
  protected final String TEXT_11 = "> input, BimDatabaseSession session) {" + NL + "\t\tSet<";
  protected final String TEXT_12 = "> result = new HashSet<";
  protected final String TEXT_13 = ">();" + NL + "\t\tfor (S";
  protected final String TEXT_14 = " o : input) {" + NL + "\t\t\tresult.add(convertFromSObject(o, session));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic List<S";
  protected final String TEXT_15 = "> convertToSList";
  protected final String TEXT_16 = "(Collection<";
  protected final String TEXT_17 = "> input) {" + NL + "\t\tList<S";
  protected final String TEXT_18 = "> result = new ArrayList<S";
  protected final String TEXT_19 = ">();" + NL + "\t\tfor (";
  protected final String TEXT_20 = " o : input) {" + NL + "\t\t\tresult.add(convertToSObject(o));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic List<";
  protected final String TEXT_21 = "> convertFromSList";
  protected final String TEXT_22 = "(Collection<S";
  protected final String TEXT_23 = "> input, BimDatabaseSession session) {" + NL + "\t\tList<";
  protected final String TEXT_24 = "> result = new ArrayList<";
  protected final String TEXT_25 = ">();" + NL + "\t\tfor (S";
  protected final String TEXT_26 = " o : input) {" + NL + "\t\t\tresult.add(convertFromSObject(o, session));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic S";
  protected final String TEXT_27 = " convertToSObject(";
  protected final String TEXT_28 = " input) {" + NL + "\t\tif (input == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tS";
  protected final String TEXT_29 = " result = new S";
  protected final String TEXT_30 = "();" + NL + "\t\tresult.setOid(input.getOid());";
  protected final String TEXT_31 = NL + "\t\tresult.set";
  protected final String TEXT_32 = "(S";
  protected final String TEXT_33 = ".values()[input.get";
  protected final String TEXT_34 = "().ordinal()]);";
  protected final String TEXT_35 = NL + "\t\tresult.set";
  protected final String TEXT_36 = "(input.";
  protected final String TEXT_37 = "());";
  protected final String TEXT_38 = NL + "\t\tList<Long> list";
  protected final String TEXT_39 = " = new ArrayList<Long>();" + NL + "\t\tfor (";
  protected final String TEXT_40 = " v : input.get";
  protected final String TEXT_41 = "()) {" + NL + "\t\t\tlist";
  protected final String TEXT_42 = ".add(v.getOid());" + NL + "\t\t}" + NL + "\t\tresult.set";
  protected final String TEXT_43 = "(list";
  protected final String TEXT_44 = ");";
  protected final String TEXT_45 = NL + "\t\t";
  protected final String TEXT_46 = " ";
  protected final String TEXT_47 = "Val = input.get";
  protected final String TEXT_48 = "();" + NL + "\t\tresult.set";
  protected final String TEXT_49 = "Id(";
  protected final String TEXT_50 = "Val == null ? -1 : ";
  protected final String TEXT_51 = "Val.getOid());";
  protected final String TEXT_52 = NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_53 = " convertFromSObject(S";
  protected final String TEXT_54 = " input, BimDatabaseSession session) {" + NL + "\t\tif (input == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_55 = " result = ";
  protected final String TEXT_56 = "Factory.eINSTANCE.create";
  protected final String TEXT_57 = "();" + NL + "\t\tresult.setOid(input.getOid());";
  protected final String TEXT_58 = NL + "\t\tresult.set";
  protected final String TEXT_59 = "(";
  protected final String TEXT_60 = ".values()[input.get";
  protected final String TEXT_61 = "().ordinal()]);";
  protected final String TEXT_62 = NL + "\t\tresult.set";
  protected final String TEXT_63 = "(input.";
  protected final String TEXT_64 = "());";
  protected final String TEXT_65 = NL + "\t\tList<";
  protected final String TEXT_66 = "> list";
  protected final String TEXT_67 = " = result.get";
  protected final String TEXT_68 = "();" + NL + "\t\tfor (long oid : input.get";
  protected final String TEXT_69 = "()) {" + NL + "\t\t\tlist";
  protected final String TEXT_70 = ".add((";
  protected final String TEXT_71 = ")session.get(";
  protected final String TEXT_72 = "Package.eINSTANCE.get";
  protected final String TEXT_73 = "(), oid, false));" + NL + "\t\t}";
  protected final String TEXT_74 = NL + "\t\tresult.set";
  protected final String TEXT_75 = "((";
  protected final String TEXT_76 = ")session.get(";
  protected final String TEXT_77 = "Package.eINSTANCE.get";
  protected final String TEXT_78 = "(), input.get";
  protected final String TEXT_79 = "Id(), false));";
  protected final String TEXT_80 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_81 = NL + "\t\tpublic S";
  protected final String TEXT_82 = " convertToSObject(";
  protected final String TEXT_83 = " input) {" + NL + "\t\t\treturn S";
  protected final String TEXT_84 = ".values()[input.ordinal()];" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic ";
  protected final String TEXT_85 = " convertFromSObject(S";
  protected final String TEXT_86 = " input) {" + NL + "\t\t\treturn ";
  protected final String TEXT_87 = ".values()[input.ordinal()];" + NL + "\t\t}";
  protected final String TEXT_88 = NL + "}";
  protected final String TEXT_89 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	Set<EPackage> ePackages = (Set<EPackage>)argument;
	for (EPackage ePackage : ePackages) {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(eClass.getName());
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
    
	for (EAttribute eAttribute : eClass.getEAllAttributes()) {
		if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_34);
    
		} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_37);
    
		}
	}
	for (EReference eReference : eClass.getEAllReferences()) {
		if (eReference.isMany()) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_44);
    		
		} else {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_51);
    
		}
	}

    stringBuffer.append(TEXT_52);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(StringUtils.firstUpperCase(eClass.getEPackage().getName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(eClass.getName());
    stringBuffer.append(TEXT_57);
    
	for (EAttribute eAttribute : eClass.getEAllAttributes()) {
		if (eAttribute.getEType() instanceof EEnum) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(eAttribute.getEType().getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_61);
    
		} else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean() ? "is" : "get");
    stringBuffer.append(StringUtils.firstUpperCase(eAttribute.getName()));
    stringBuffer.append(TEXT_64);
    
		}
	}
	for (EReference eReference : eClass.getEAllReferences()) {
		if (eReference.isMany()) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(eReference.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getEType().getEPackage().getName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_73);
    		
		} else {

    stringBuffer.append(TEXT_74);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getEType().getEPackage().getName()));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(eReference.getEType().getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(StringUtils.firstUpperCase(eReference.getName()));
    stringBuffer.append(TEXT_79);
    
		}
	}

    stringBuffer.append(TEXT_80);
    
		} else if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum)eClassifier;

    stringBuffer.append(TEXT_81);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(eEnum.getName());
    stringBuffer.append(TEXT_87);
    
		}
	}
}

    stringBuffer.append(TEXT_88);
    stringBuffer.append(TEXT_89);
    return stringBuffer.toString();
  }
}
