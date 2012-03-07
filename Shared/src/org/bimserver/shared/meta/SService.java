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

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.bimserver.shared.ServiceInterface;
import org.bimserver.utils.StringUtils;

public class SService {
	private final Map<String, SMethod> methods = new HashMap<String, SMethod>();
	private final Map<String, SClass> types = new HashMap<String, SClass>();
	private final String name;
	private final Class<?> clazz;

	public static void main(String[] args) {
		SService sService = new SService(ServiceInterface.class);
		System.out.println(sService.getMethods().size());
		for (SClass type : sService.getTypes()) {
			System.out.println(type.getName());
			if (type instanceof SClass) {
				SClass sClass = (SClass)type;
				for (SField sField : sClass.getFields()) {
					System.out.println("\t" + sField.getName() + " " + sField.getType().getName());
				}
			}
			System.out.println();
		}
	}
	
	public SService(Class<?> clazz) {
		this.clazz = clazz;
		this.name = clazz.getSimpleName();
		init();
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
	}
	
	private Class<?> getGenericType(Method method) {
		Type genericReturnType = method.getGenericReturnType();
		if (method.getGenericReturnType() instanceof ParameterizedType) {
			ParameterizedType parameterizedTypeImpl = (ParameterizedType)genericReturnType;
			if (parameterizedTypeImpl.getActualTypeArguments()[0] instanceof Class) {
				return (Class<?>) parameterizedTypeImpl.getActualTypeArguments()[0];
			}
		} else {
			return (Class<?>) method.getGenericReturnType();
		}
		return null;
	}
	
	private void addType(Class<?> type) {
		if (!types.containsKey(type.getSimpleName())) {
			SClass sClass = new SClass(this, type);
			types.put(sClass.getSimpleName(), sClass);
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
		return new HashSet<SMethod>(methods.values());
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
			} else {
				System.out.println("Type not found: " + name);
			}
		}
		return sType;
	}
}