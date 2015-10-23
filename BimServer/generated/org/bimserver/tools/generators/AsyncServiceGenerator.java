package org.bimserver.tools.generators;

import org.bimserver.shared.meta.*;
import org.bimserver.utils.*;
import java.io.File;

public class AsyncServiceGenerator
{
  protected static String nl;
  public static synchronized AsyncServiceGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AsyncServiceGenerator result = new AsyncServiceGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package org.bimserver.shared.interfaces.async;" + NL;
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "import java.util.concurrent.ExecutorService;";
  protected final String TEXT_4 = NL + "import ";
  protected final String TEXT_5 = ";" + NL + "" + NL + "public class Async";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\tprivate final ExecutorService executorService;" + NL + "\tprivate final ";
  protected final String TEXT_7 = " syncService;" + NL + "" + NL + "\tpublic Async";
  protected final String TEXT_8 = "(";
  protected final String TEXT_9 = " syncService, ExecutorService executorService) {" + NL + "\t\tthis.executorService = executorService;" + NL + "\t\tthis.syncService = syncService;" + NL + "\t}" + NL;
  protected final String TEXT_10 = NL + "\tpublic interface ";
  protected final String TEXT_11 = "Callback {" + NL + "\t\tvoid success(";
  protected final String TEXT_12 = ");" + NL + "\t\tvoid error(Throwable e);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_13 = NL + NL;
  protected final String TEXT_14 = NL + "\tpublic void ";
  protected final String TEXT_15 = "(";
  protected final String TEXT_16 = "final ";
  protected final String TEXT_17 = " ";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = "final ";
  protected final String TEXT_20 = "Callback callback) {" + NL + "\t\texecutorService.submit(new Runnable(){" + NL + "\t\t\tpublic void run(){" + NL + "\t\t\t\ttry {";
  protected final String TEXT_21 = NL + "\t\t\t\t\tsyncService.";
  protected final String TEXT_22 = "(";
  protected final String TEXT_23 = ");" + NL + "\t\t\t\t\tcallback.success();" + NL + "\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t\tcallback.success(syncService.";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_27 = "} catch (Throwable e) {" + NL + "\t\t\t\t\tcallback.error(e);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "\t";
  protected final String TEXT_28 = NL + "}";

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
    stringBuffer.append(sService.getInterfaceClass().getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sService.getInterfaceClass().getSimpleName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(sService.getInterfaceClass().getSimpleName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sService.getInterfaceClass().getSimpleName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sService.getInterfaceClass().getSimpleName());
    stringBuffer.append(TEXT_9);
    
for (SMethod method : sService.getMethods()) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(StringUtils.firstUpperCase(method.getName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(method.getReturnType().isVoid() ? "" : (method.returnTypeToJavaCode() + " result"));
    stringBuffer.append(TEXT_12);
    
}

    stringBuffer.append(TEXT_13);
    
for (SMethod method : sService.getMethods()) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(method.getName());
    stringBuffer.append(TEXT_15);
    
	for (SParameter parameter : method.getParameters()) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(parameter.getGenericType() != null ? (parameter.getType().toJavaCode() + "<" + parameter.getGenericType() + ">") : parameter.getType().toJavaCode());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_18);
    
	}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(StringUtils.firstUpperCase(method.getName()));
    stringBuffer.append(TEXT_20);
    	if (method.getReturnType().isVoid()) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(method.getName());
    stringBuffer.append(TEXT_22);
    
						for (SParameter sParameter : method.getParameters()) {
							
    stringBuffer.append(sParameter.getName());
    stringBuffer.append(sParameter.isLast() ? "" : ", ");
    
						}
					
    stringBuffer.append(TEXT_23);
    
					} else {
				
    stringBuffer.append(TEXT_24);
    stringBuffer.append(method.getName());
    stringBuffer.append(TEXT_25);
    
						for (SParameter sParameter : method.getParameters()) {
							
    stringBuffer.append(sParameter.getName());
    stringBuffer.append(sParameter.isLast() ? "" : ", ");
    
						}
					
    stringBuffer.append(TEXT_26);
    
					}
				
    stringBuffer.append(TEXT_27);
    
}

    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
