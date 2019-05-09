package org.bimserver.shared.reflector;

import org.apache.commons.lang.RandomStringUtils;
import org.bimserver.generated.GeneratedNeighbourClass;
import org.bimserver.reflector.NeighbourClass;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SParameter;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.SServicesMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javassist.CannotCompileException;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.LoaderClassPath;
import javassist.NotFoundException;

public class RealtimeReflectorFactoryBuilder implements ReflectorFactoryBuilder {
	private static final Logger LOGGER = LoggerFactory.getLogger(RealtimeReflectorFactoryBuilder.class);
	private SServicesMap servicesMap;
	private ClassPool pool;
	private String prefix;
	private static volatile int implementationCounter = 0;
	private static final String GENERATED_CLASSES_PACKAGE = "org.bimserver.generated";

	public RealtimeReflectorFactoryBuilder(SServicesMap servicesMap) {
		this.servicesMap = servicesMap;
		this.prefix = RandomStringUtils.randomAlphabetic(12);
	}

	public ReflectorFactory newReflectorFactory() {
		try {
			pool = ClassPool.getDefault();
			pool.appendClassPath(new LoaderClassPath(getClass().getClassLoader()));
			pool.insertClassPath(new ClassClassPath(this.getClass()));
			
			String newClassPrefix = getNewClassPrefix();

			for (String name : servicesMap.keySetName()) {
				SService sService = servicesMap.getByName(name);
				build1(newClassPrefix, (Class<? extends PublicInterface>) sService.getInterfaceClass(), sService);
				build2(newClassPrefix, (Class<? extends PublicInterface>) sService.getInterfaceClass(), sService);
			}
			
			CtClass reflectorFactoryImpl = pool.makeClass("org.bimserver.reflector.ReflectorFactoryImpl" + newClassPrefix);
			reflectorFactoryImpl.addInterface(pool.get(ReflectorFactory.class.getName()));
			
			createCreateReflectorMethod1(newClassPrefix, reflectorFactoryImpl);
			createCreateReflectorMethod2(newClassPrefix, reflectorFactoryImpl);
			
			Class<?> class1 = pool.toClass(reflectorFactoryImpl, NeighbourClass.class, getClass().getClassLoader(), getClass().getProtectionDomain());
			return (ReflectorFactory) class1.newInstance();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return null;
	}

	private String getNewClassPrefix() {
		implementationCounter++;
		return prefix + "_" + implementationCounter;
	}
	
	private void createCreateReflectorMethod2(String newClassPrefix, CtClass reflectorFactoryImpl) throws NotFoundException, CannotCompileException {
		CtClass[] parameters = new CtClass[2];
		parameters[0] = pool.get(Class.class.getName());
		parameters[1] = pool.get(PublicInterface.class.getName());
		CtMethod method = new CtMethod(pool.get(Reflector.class.getName()), "createReflector", parameters, reflectorFactoryImpl);
		StringBuilder methodBuilder = new StringBuilder();
		methodBuilder.append("{");
		methodBuilder.append("if (1==0) {");
		for (String name : servicesMap.keySetName()) {
			SService sService = servicesMap.getByName(name);
			methodBuilder.append("} else if ($1.getSimpleName().equals(\"" + sService.getSimpleName() + "\")) {");
			methodBuilder.append("return new " + GENERATED_CLASSES_PACKAGE + "." + sService.getSimpleName() + "Reflector" + newClassPrefix + "((" + sService.getInterfaceClass().getName() + ")$2);");
		}
		methodBuilder.append("}");
		methodBuilder.append("return null;");
		methodBuilder.append("}");
		method.setBody(methodBuilder.toString());
		reflectorFactoryImpl.addMethod(method);
	}

	private void createCreateReflectorMethod1(String newClassPrefix, CtClass reflectorFactoryImpl) throws NotFoundException, CannotCompileException {
		CtClass[] parameters = new CtClass[2];
		parameters[0] = pool.get(Class.class.getName());
		parameters[1] = pool.get(Reflector.class.getName());
		CtMethod method = new CtMethod(pool.get(PublicInterface.class.getName()), "createReflector", parameters, reflectorFactoryImpl);
		StringBuilder methodBuilder = new StringBuilder();
		methodBuilder.append("{");
		methodBuilder.append("if (1==0) {");
		for (String name : servicesMap.keySetName()) {
			SService sService = servicesMap.getByName(name);
			methodBuilder.append("} else if ($1.getSimpleName().equals(\"" + sService.getSimpleName() + "\")) {");
			methodBuilder.append("return new " + GENERATED_CLASSES_PACKAGE + "." + sService.getSimpleName() + "Impl" + newClassPrefix + "($2);");
		}
		methodBuilder.append("}");
		methodBuilder.append("return null;");
		methodBuilder.append("}");
		method.setBody(methodBuilder.toString());
		reflectorFactoryImpl.addMethod(method);
	}
	
	private void build1(String newClassPrefix, Class<? extends PublicInterface> interfaceClass, org.bimserver.shared.meta.SService sService) {
		try {
			CtClass reflectorImplClass = pool.makeClass(GENERATED_CLASSES_PACKAGE + "." + interfaceClass.getSimpleName() + "Impl" + newClassPrefix);
			reflectorImplClass.addInterface(pool.get(interfaceClass.getName()));
			CtClass reflectorClass = pool.get(Reflector.class.getName());
			CtField reflectorField = new CtField(reflectorClass, "reflector", reflectorImplClass);
			reflectorImplClass.addField(reflectorField);
			CtConstructor constructor = new CtConstructor(new CtClass[] {reflectorClass}, reflectorImplClass);
			StringBuilder sb = new StringBuilder();
			reflectorImplClass.addConstructor(constructor);
			sb.append("{");
			sb.append("this.reflector = $1;");
			sb.append("}");
			constructor.setBody(sb.toString());
			
			for (SMethod sMethod : sService.getMethods()) {
				CtClass[] parameters = new CtClass[sMethod.getParameters().size()];
				int i=0;
				for (org.bimserver.shared.meta.SParameter sParameter : sMethod.getParameters()) {
					parameters[i] = pool.get(sParameter.getType().toJavaCode());
					i++;
				}
				CtMethod method = new CtMethod(pool.get(sMethod.getReturnType().toJavaCode()), sMethod.getName(), parameters, reflectorImplClass);
				StringBuilder methodBuilder = new StringBuilder();
				methodBuilder.append("{");
				if (sMethod.getReturnType().isVoid()) {
				} else {
					methodBuilder.append("return (" + sMethod.getReturnType().toJavaCode() + ")");
				}
				methodBuilder.append("reflector.callMethod(\"" + interfaceClass.getSimpleName() + "\", \"" + sMethod.getName() + "\", " + sMethod.getReturnType().toJavaCode() + ".class");
				if (sMethod.getParameters().isEmpty()) {
					methodBuilder.append(", new " + KeyValuePair.class.getName() + "[0]");
				} else {
					methodBuilder.append(", new " + KeyValuePair.class.getName() + "[]{");
					int x=1;
					for (SParameter sParameter : sMethod.getParameters()) {
						methodBuilder.append("new " + KeyValuePair.class.getName() + "(\"" + sParameter.getName() + "\", $" + x + ")");
						if (sMethod.getParameter(sMethod.getParameters().size() - 1) != sParameter) {
							methodBuilder.append(", ");
						}
						x++;
					}
					methodBuilder.append("}");
				}
				methodBuilder.append(");");
				methodBuilder.append("}");
				method.setBody(methodBuilder.toString());
				reflectorImplClass.addMethod(method);
			}
			pool.toClass(reflectorImplClass, GeneratedNeighbourClass.class, getClass().getClassLoader(), getClass().getProtectionDomain());
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	private void build2(String newClassPrefix, Class<? extends PublicInterface> interfaceClass, org.bimserver.shared.meta.SService sService) {
		try {
			CtClass reflectorImplClass = pool.makeClass(GENERATED_CLASSES_PACKAGE + "." + interfaceClass.getSimpleName() + "Reflector" + newClassPrefix);
			CtClass reflectorClass = pool.get(Reflector.class.getName());
			CtClass interfaceCtClass = pool.get(interfaceClass.getName());
			reflectorImplClass.addInterface(reflectorClass);
			CtField reflectorField = new CtField(interfaceCtClass, "publicInterface", reflectorImplClass);
			reflectorImplClass.addField(reflectorField);
			CtConstructor constructor = new CtConstructor(new CtClass[] {interfaceCtClass}, reflectorImplClass);
			StringBuilder sb = new StringBuilder();
			reflectorImplClass.addConstructor(constructor);
			sb.append("{");
			sb.append("this.publicInterface = $1;");
			sb.append("}");
			constructor.setBody(sb.toString());

			CtClass[] parameters = new CtClass[4];
			parameters[0] = pool.get(String.class.getName());
			parameters[1] = pool.get(String.class.getName());
			parameters[2] = pool.get(Class.class.getName());
			parameters[3] = pool.get(KeyValuePair.class.getName() + "[]");
			CtMethod method = new CtMethod(pool.get(Object.class.getName()), "callMethod", parameters, reflectorImplClass);

			StringBuilder methodBuilder = new StringBuilder();
			methodBuilder.append("{");
			methodBuilder.append("if  (1==0) {} ");
			for (SMethod sMethod : sService.getMethods()) {
				methodBuilder.append(" else if ($2.equals(\"" + sMethod.getName() + "\")) {");
				if (!sMethod.getReturnType().isVoid()) {
					methodBuilder.append("return ");
				}
				methodBuilder.append("publicInterface." + sMethod.getName() + "(");
				int i=0;
				for (SParameter sParameter : sMethod.getParameters()) {
					methodBuilder.append("(" + sParameter.getType().toJavaCode() + ")$4[" + i + "].getValue()");
					if (i < sMethod.getParameters().size() - 1) {
						methodBuilder.append(", ");
					}
					i++;
				}
				methodBuilder.append(");");
				methodBuilder.append("}");
			}
			methodBuilder.append("return null;");
			methodBuilder.append("}");
			method.setBody(methodBuilder.toString());
			reflectorImplClass.addMethod(method);
			
			pool.toClass(reflectorImplClass, GeneratedNeighbourClass.class, getClass().getClassLoader(), getClass().getProtectionDomain());
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}