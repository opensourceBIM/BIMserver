package org.bimserver.tools.generators;

import org.bimserver.shared.meta.*;
import org.bimserver.utils.*;
import java.io.File;

public class AdaptorGenerator
{
  protected static String nl;
  public static synchronized AdaptorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AdaptorGenerator result = new AdaptorGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package org.bimserver.shared.interfaces;" + NL;
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "import org.bimserver.shared.exceptions.UserException;" + NL + "import org.bimserver.shared.exceptions.ServerException;";
  protected final String TEXT_4 = NL + NL + "public class ";
  protected final String TEXT_5 = "Adaptor implements ";
  protected final String TEXT_6 = " {" + NL;
  protected final String TEXT_7 = NL + "\tpublic ";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = "(";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = ") throws UserException, ServerException {";
  protected final String TEXT_12 = NL + "\t\treturn null;";
  protected final String TEXT_13 = NL + "\t}" + NL + "\t";
  protected final String TEXT_14 = NL + "}";

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
    stringBuffer.append(Licenser.getCommentedLicenseText(new File("license.txt")));
    stringBuffer.append(TEXT_3);
    
SService sService = (SService)argument;

    stringBuffer.append(TEXT_4);
    stringBuffer.append(sService.getSimpleName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sService.getInterfaceClass().getName());
    stringBuffer.append(TEXT_6);
    
for (SMethod method : sService.getMethods()) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(method.getGenericReturnType() != null ? (method.getReturnType().toJavaCode() + "<" + method.getGenericReturnType().toJavaCode() + ">") : method.getReturnType().toJavaCode());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(method.getName());
    stringBuffer.append(TEXT_9);
    
	for (SParameter parameter : method.getParameters()) {

    stringBuffer.append(parameter.getGenericType() != null ? (parameter.getType().toJavaCode() + "<" + parameter.getGenericType() + ">") : parameter.getType().toJavaCode());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(parameter.isLast() ? "" : ", ");
    
	}

    stringBuffer.append(TEXT_11);
    
if (!method.getReturnType().isVoid()) {

    stringBuffer.append(TEXT_12);
    
}

    stringBuffer.append(TEXT_13);
    
}

    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
