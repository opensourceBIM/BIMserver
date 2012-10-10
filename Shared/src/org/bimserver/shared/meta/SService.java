package org.bimserver.shared.meta;

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

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.bimserver.utils.StringUtils;
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
	private final Map<String, SClass> types = new TreeMap<String, SClass>();
	private final String name;
	private final Class<?> clazz;
	private String sourceCode;

	// Disabled for now, makes the deployed JAR stop at this point
	private boolean processJavaDoc = true;
	private SService[] others;

	public SService(String sourceCode, Class<?> clazz, SService...others) {
		this.sourceCode = sourceCode;
		this.clazz = clazz;
		this.others = others;
		this.name = clazz.getSimpleName();
		init();
		if (processJavaDoc && sourceCode != null) {
			extractJavaDoc();
		}
	}

	private void extractJavaDoc() {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setSource(sourceCode.toCharArray());
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
								if ("@param".equals(tagElement.getTagName())) {
									SParameter parameter = null;
									for (int i = 0; i < tagElement.fragments().size(); i++) {
										Object fragment = tagElement.fragments().get(i);
										if (i == 0 && fragment instanceof SimpleName) {
											parameter = method.getParameter(((SimpleName) fragment).getIdentifier());
										} else if (i == 1 && parameter != null && fragment instanceof TextElement) {
											parameter.setDoc(((TextElement) fragment).getText());
										}
									}
								} else if ("@return".equals(tagElement.getTagName())) {
									method.setReturnDoc(extractFullText(tagElement));
								} else if ("@throws".equals(tagElement.getTagName())) {
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
		for (Method method : clazz.getMethods()) {
			addType(method.getReturnType());
			if (getGenericType(method) != null) {
				addType(getGenericType(method));
			}
			for (Class<?> paramType : method.getParameterTypes()) {
				addType(paramType);
			}
		}
		for (SClass sType : types.values()) {
			sType.init();
		}
		for (Method method : clazz.getMethods()) {
			methods.put(method.getName(), new SMethod(this, method));
		}
		LOGGER.info(methods.size() + " methods in " + getName());
	}

	private Class<?> getGenericType(Method method) {
		Type genericReturnType = method.getGenericReturnType();
		if (method.getGenericReturnType() instanceof ParameterizedType) {
			ParameterizedType parameterizedTypeImpl = (ParameterizedType) genericReturnType;
			if (parameterizedTypeImpl.getActualTypeArguments()[0] instanceof Class) {
				return (Class<?>) parameterizedTypeImpl.getActualTypeArguments()[0];
			}
		} else if (method.getGenericReturnType() instanceof TypeVariable) {
		} else if (method.getGenericReturnType() instanceof GenericArrayType) {
		} else {
			return (Class<?>) method.getGenericReturnType();
		}
		return null;
	}

	private void addType(Class<?> type) {
		if (!types.containsKey(type.getSimpleName())) {
			SClass sClass = new SClass(this, type);
			types.put(sClass.getSimpleName(), sClass);
			types.put(sClass.getName(), sClass);
			addRelatedTypes(type);
		}
	}

	private void addRelatedTypes(Class<?> type) {
		for (Method method : type.getMethods()) {
			if (method.getName().startsWith("get") && method.getName().length() > 3 && !method.getName().equals("getSClass")) {
				if (type.getAnnotation(XmlSeeAlso.class) != null) {
					XmlSeeAlso xmlSeeAlso = type.getAnnotation(XmlSeeAlso.class);
					for (Class<?> c : xmlSeeAlso.value()) {
						addType(c);
					}
				}
				if (type.getSuperclass() != null) {
					addType(type.getSuperclass());
				}
				String fieldName = StringUtils.firstLowerCase(method.getName().substring(3));
				try {
					if (type.getMethod("set" + StringUtils.firstUpperCase(fieldName), method.getReturnType()) != null) {
						addType(method.getReturnType());
					}
				} catch (SecurityException e) {
				} catch (NoSuchMethodException e) {
				}
				if (getGenericType(method) != null) {
					addType(getGenericType(method));
				}
				for (Class<?> pt : method.getParameterTypes()) {
					addType(pt);
				}
			}
		}
	}

	public void addType(SClass type) {
		types.put(type.getSimpleName(), type);
	}

	public String getName() {
		return name;
	}

	public Set<SMethod> getMethods() {
		return new LinkedHashSet<SMethod>(methods.values());
	}

	public SMethod getSMethod(String name) {
		return methods.get(name);
	}

	public Set<SClass> getTypes() {
		return new HashSet<SClass>(types.values());
	}

	public Class<?> getInstanceClass() {
		return clazz;
	}

	public SClass getSType(String name) {
		SClass sType = types.get(name);
		if (sType == null) {
			if (name.contains(".")) {
				name = name.substring(name.lastIndexOf(".") + 1);
				return getSType(name);
			}
		}
		if (sType == null) {
			for (SService other : others) {
				SClass otherClass = other.getSType(name);
				if (otherClass != null) {
					return otherClass;
				}
			}
		}
		return sType;
	}
	
	public void dump() {
		System.out.println(getMethods().size());
		for (SMethod method : getMethods()) {
			System.out.println(method.getName() + ": " + method.getReturnType().getName() + " (" + method.getDoc() + ")");
			for (SParameter parameter : method.getParameters()) {
				System.out.println("\t" + parameter.getName() + " " + parameter.getType().getName() + " (" + parameter.getDoc() + ")");
			}
			System.out.println();
		}
		for (SClass type : getTypes()) {
			System.out.println(type.getName());
			if (type instanceof SClass) {
				SClass sClass = (SClass) type;
				for (SField sField : sClass.getFields()) {
					SClass type2 = sField.getType();
					if (type2 == null) {
						System.err.println("type for " + sField.getName() + " = null");
					}
					System.out.println("\t" + sField.getName() + " " + type2.getName());
				}
			}
			System.out.println();
		}
	}
}