package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.*;
import org.bimserver.utils.*;
import java.io.File;
import java.util.Set;

public class SPackageGenerator
{
  protected static String nl;
  public static synchronized SPackageGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SPackageGenerator result = new SPackageGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package org.bimserver.shared.meta;";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "import java.util.*;" + NL + "import org.bimserver.shared.meta.SClass;" + NL + "import org.slf4j.Logger;" + NL + "import org.slf4j.LoggerFactory;" + NL + "" + NL + "public class SPackage {" + NL + "\tprivate static final Logger LOGGER = LoggerFactory.getLogger(SPackage.class);";
  protected final String TEXT_5 = NL + NL + "\tprivate static final SPackage sPackage = new SPackage();" + NL + "\tprivate final Map<String, SClass> sClasses = new HashMap<String, SClass>();" + NL + "" + NL + "\tstatic {" + NL + "\t\tgetInstance().init();" + NL + "\t}" + NL + "" + NL + "\tprivate void init() {" + NL + "\t\t\ttry {" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tClass.forName(\"org.bimserver.interfaces.objects.S";
  protected final String TEXT_7 = "\");";
  protected final String TEXT_8 = NL + "\t\t} catch (ClassNotFoundException e) {" + NL + "\t\t\tLOGGER.error(\"\", e);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tpublic static SPackage getInstance() {" + NL + "\t\treturn sPackage;" + NL + "\t}" + NL + "" + NL + "\tpublic void addSClass(SClass sClass) {" + NL + "\t\tsClasses.put(sClass.getName(), sClass);" + NL + "\t}" + NL + "" + NL + "\tpublic SClass getSClass(String name) {" + NL + "\t\treturn sClasses.get(name);" + NL + "\t}" + NL + "}";

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
    
	@SuppressWarnings("unchecked") Set<EPackage> ePackages = (Set<EPackage>)argument;

    stringBuffer.append(TEXT_5);
    
	for (EPackage ePackage : ePackages) {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass || eClassifier instanceof EEnum) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(eClassifier.getName());
    stringBuffer.append(TEXT_7);
    
			}
		}
	}

    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
