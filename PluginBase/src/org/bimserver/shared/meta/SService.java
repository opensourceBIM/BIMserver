package org.bimserver.shared.meta;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.jws.WebService;

import org.bimserver.shared.interfaces.PublicInterface;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.TagElement;
import org.eclipse.jdt.core.dom.TextElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SService.class);
	private final Map<String, SMethod> methods = new TreeMap<String, SMethod>();
	private final String fullName;
	private final Class<? extends PublicInterface> interfaceClass;
	private boolean processJavaDoc = true;
	private SServicesMap servicesMap;
	private String simpleName;
	private SourceCodeFetcher sourceCodeFetcher;
	private String nameSpace;

	public SService(SServicesMap servicesMap, SourceCodeFetcher sourceCodeFetcher, Class<? extends PublicInterface> interfaceClass) {
		this.servicesMap = servicesMap;
		this.sourceCodeFetcher = sourceCodeFetcher;
		this.interfaceClass = interfaceClass;
		this.nameSpace = interfaceClass.getAnnotation(WebService.class).targetNamespace();
		this.fullName = interfaceClass.getAnnotation(WebService.class).targetNamespace() + "." + interfaceClass.getAnnotation(WebService.class).name();
		this.simpleName = interfaceClass.getAnnotation(WebService.class).name();
	}
	
	private void processClass(Class<?> clazz) {
		if (clazz == Class.class) {
			return;
		}
		for (Class<?> x : clazz.getInterfaces()) {
			processClass(x);
		}
		// Parents first, subclasses their documentation have precedence
		extractJavaDoc(clazz);
	}

	private void extractJavaDoc(Class<?> clazz) {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setSource(sourceCodeFetcher.get(clazz).toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		cu.accept(new ASTVisitor() {
			MethodDeclaration currentMethod = null;

			public boolean visit(Javadoc javaDoc) {
				if (currentMethod != null) {
					SMethod method = getSMethod(currentMethod.getName().getIdentifier());
					if (method == null) {
						LOGGER.error("Method " + currentMethod.getName().getIdentifier() + " not found in class");
					} else {
						for (Object tag : javaDoc.tags()) {
							if (tag instanceof TagElement) {
								TagElement tagElement = (TagElement) tag;
								String tagName = tagElement.getTagName() == null ? null : tagElement.getTagName().trim();
								if ("@param".equals(tagName)) {
									SParameter parameter = null;
									for (int i = 0; i < tagElement.fragments().size(); i++) {
										Object fragment = tagElement.fragments().get(i);
										if (i == 0 && fragment instanceof SimpleName) {
											parameter = method.getParameter(((SimpleName) fragment).getIdentifier());
										} else if (i == 1 && parameter != null && fragment instanceof TextElement) {
											parameter.setDoc(((TextElement) fragment).getText());
										}
									}
								} else if ("@return".equals(tagName)) {
									method.setReturnDoc(extractFullText(tagElement));
								} else if ("@throws".equals(tagName)) {
								} else {
									method.setDoc(extractFullText(tagElement));
								}
							}
						}
					}
				}
				return super.visit(javaDoc);
			}

			@Override
			public boolean visit(MethodDeclaration node) {
				currentMethod = node;
				return super.visit(node);
			}

			@Override
			public void endVisit(MethodDeclaration node) {
				currentMethod = null;
				super.endVisit(node);
			}
		});
	}

	private String extractFullText(TagElement tagElement) {
		StringBuilder builder = new StringBuilder();
		for (Object fragment : tagElement.fragments()) {
			if (fragment instanceof TextElement) {
				TextElement textElement = (TextElement) fragment;
				builder.append(textElement.getText() + " ");
			}
		}
		return builder.toString().trim();
	}

	public void init() {
		for (Method method : interfaceClass.getMethods()) {
			getServicesMap().addType(method.getReturnType());
			if (getGenericType(method) != null) {
				getServicesMap().addType(getGenericType(method));
			}
			for (Class<?> paramType : method.getParameterTypes()) {
				getServicesMap().addType(paramType);
			}
		}
		for (SClass sType : getServicesMap().getTypes()) {
			sType.init();
		}
		for (Method method : interfaceClass.getMethods()) {
			methods.put(method.getName(), new SMethod(this, method));
		}
		if (processJavaDoc && sourceCodeFetcher != null) {
			processClass(interfaceClass);
		}
	}

	private Class<?> getGenericType(Method method) {
		Type genericReturnType = method.getGenericReturnType();
		if (method.getGenericReturnType() instanceof ParameterizedType) {
			ParameterizedType parameterizedTypeImpl = (ParameterizedType) genericReturnType;
			if (parameterizedTypeImpl.getActualTypeArguments()[0] instanceof Class) {
				return (Class<?>) parameterizedTypeImpl.getActualTypeArguments()[0];
			} else if (parameterizedTypeImpl.getActualTypeArguments()[0] instanceof GenericArrayType) {
//				GenericArrayType genericArrayType = (GenericArrayType)parameterizedTypeImpl.getActualTypeArguments()[0];
//				Type genericComponentType = genericArrayType.getGenericComponentType();
//				if (genericComponentType instanceof Class) {
//					return (Class<?>)genericComponentType;
//				}
			}
		} else if (method.getGenericReturnType() instanceof TypeVariable) {
		} else if (method.getGenericReturnType() instanceof GenericArrayType) {
		} else {
			return (Class<?>) method.getGenericReturnType();
		}
		return null;
	}

	public String getName() {
		return fullName;
	}

	public Set<SMethod> getMethods() {
		return new LinkedHashSet<SMethod>(methods.values());
	}

	public SMethod getSMethod(String name) {
		return methods.get(name);
	}

	public Class<? extends PublicInterface> getInterfaceClass() {
		return interfaceClass;
	}

//	public void dump() {
//		System.out.println(getMethods().size());
//		for (SMethod method : getMethods()) {
//			System.out.println(method.getName() + ": " + method.getReturnType().getName() + " (" + method.getDoc() + ")");
//			for (SParameter parameter : method.getParameters()) {
//				System.out.println("\t" + parameter.getName() + " " + parameter.getType().getName() + " (" + parameter.getDoc() + ")");
//			}
//			System.out.println();
//		}
//		for (SClass type : getTypes()) {
//			System.out.println(type.getName());
//			for (SField sField : type.getAllFields()) {
//				SClass type2 = sField.getType();
//				if (type2 == null) {
//					System.err.println("type for " + sField.getName() + " = null");
//				} else {
//					System.out.println("\t" + sField.getName() + " " + type2.getName());
//				}
//			}
//			System.out.println();
//		}
//	}

	public SServicesMap getServicesMap() {
		return servicesMap;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public SMethod getMethod(String methodName) {
		return methods.get(methodName);
	}

	public String getNameSpace() {
		return nameSpace;
	}
}