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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.DataHandler;

import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SClass {
	private static final Logger LOGGER = LoggerFactory.getLogger(SClass.class);
	private final Map<String, SField> fields = new HashMap<String, SField>();
	private final String name;
	private final Class<?> instanceClass;
	private final SService sService;
	private SClass superClass;
	private Set<SClass> subClasses = new HashSet<SClass>();
	
	public SClass(SService sService, Class<?> instanceClass) {
		if (instanceClass == null) {
			throw new RuntimeException("InstanceClass cannot be null " + sService.getName());
		}
		this.sService = sService;
		this.instanceClass = instanceClass;
		this.name = instanceClass.getName();
		try {
			Method method = instanceClass.getMethod("setSClass", new Class[]{SClass.class});
			if (method != null) {
				method.invoke(null, this);
			}
		} catch (SecurityException e) {
			LOGGER.error("", e);
		} catch (NoSuchMethodException e) {
		} catch (IllegalArgumentException e) {
			LOGGER.error("", e);
		} catch (IllegalAccessException e) {
			LOGGER.error("", e);
		} catch (InvocationTargetException e) {
			LOGGER.error("", e);
		}
	}

	public SService getsService() {
		return sService;
	}
	
	public void init() {
		for (Method method : instanceClass.getMethods()) {
			if (method.getDeclaringClass() == instanceClass) {
				if (method.getName().startsWith("get") && method.getName().length() > 3 && !method.getName().equals("getSClass")) {
					String fieldName = StringUtils.firstLowerCase(method.getName().substring(3));
					try {
						if (instanceClass.getMethod("set" + StringUtils.firstUpperCase(fieldName), method.getReturnType()) != null) {
							Class<?> genericType = getGenericType(method);
							boolean aggregate = List.class.isAssignableFrom(method.getReturnType()) || Set.class.isAssignableFrom(method.getReturnType());
							SField sField = new SField(fieldName, sService.getSType(method.getReturnType().getName()), genericType == null ? null : sService.getSType(genericType.getName()), aggregate);
							addField(sField);
						}
					} catch (SecurityException e) {
					} catch (NoSuchMethodException e) {
					}
				}
				if (method.getName().startsWith("is") && method.getName().length() > 2) {
					String fieldName = StringUtils.firstLowerCase(method.getName().substring(2));
					try {
						if (instanceClass.getMethod("set" + StringUtils.firstUpperCase(fieldName), method.getReturnType()) != null) {
							Class<?> genericType = getGenericType(method);
							boolean aggregate = List.class.isAssignableFrom(method.getReturnType()) || Set.class.isAssignableFrom(method.getReturnType());
							SField sField = new SField(fieldName, sService.getSType(method.getReturnType().getName()), genericType == null ? null : sService.getSType(genericType.getName()), aggregate);
							addField(sField);
						}
					} catch (SecurityException e) {
					} catch (NoSuchMethodException e) {
					}
				}
			}
		}
		Class<?> superclass = instanceClass.getSuperclass();
		if (SBase.class.isAssignableFrom(instanceClass) && superclass != null) {
			addSuperClass(sService.getSType(superclass.getName()));
		}
	}

	private void addSuperClass(SClass sType) {
		superClass = sType;
		sType.addSubClass(this);
	}

	private void addSubClass(SClass sClass) {
		subClasses.add(sClass);
	}

	private Class<?> getGenericType(Method method) {
		Type genericReturnType = method.getGenericReturnType();
		if (method.getGenericReturnType() instanceof ParameterizedType) {
			ParameterizedType parameterizedTypeImpl = (ParameterizedType)genericReturnType;
			Type first = parameterizedTypeImpl.getActualTypeArguments()[0];
			if (first instanceof WildcardType) {
				return null;
			} else if (first instanceof ParameterizedType) {
				return null;
			} else {
				return (Class<?>) first;
			}
		}
		return (Class<?>) method.getGenericReturnType();
	}

	public void addField(SField sField) {
		fields.put(sField.getName(), sField);
	}
	
	public String getName() {
		return name;
	}
	
	public SClass getSuperClass() {
		return superClass;
	}
	
	public Set<SClass> getSubClasses() {
		return subClasses;
	}
	
	public SField getField(String name) {
		SField sField = fields.get(name);
		if (sField != null) {
			return sField;
		}
		if (superClass != null) {
			return superClass.getField(name);
		}
		return null;
	}

	public Class<?> getInstanceClass() {
		return instanceClass;
	}
	
	public Set<SField> getFields() {
		return new LinkedHashSet<SField>(fields.values());
	}
	
	public Set<SField> getAllFields() {
		Set<SField> fields = new LinkedHashSet<SField>(getFields());
		if (getSuperClass() != null) {
			fields.addAll(getSuperClass().getAllFields());
		}
		return fields;
	}
	
	public SBase newInstance() {
		try {
			return (SBase) Class.forName(name).newInstance();
		} catch (InstantiationException e) {
			LOGGER.error("", e);
		} catch (IllegalAccessException e) {
			LOGGER.error("", e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public boolean isPrimitive() {
		if (instanceClass.isPrimitive()) {
			return true;
		} else if (instanceClass == Long.class || instanceClass == Integer.class || instanceClass == Float.class || instanceClass == Double.class || instanceClass == Boolean.class || instanceClass == Character.class) {
			return true;
		} else if (instanceClass == Date.class) {
			return true;
		}
		return false;
	}

	public boolean isEnum() {
		return instanceClass.isEnum();
	}

	public List<String> getEnumValues() {
		List<String> results = new ArrayList<String>();
		for (Object cl : instanceClass.getEnumConstants()) {
			results.add(cl.toString());
		}
		return results;
	}
	
	public boolean isSet() {
		return instanceClass.isAssignableFrom(Set.class);
	}

	public boolean isString() {
		return instanceClass == String.class;
	}

	public boolean isDate() {
		return instanceClass == Date.class;
	}

	public boolean isClass() {
		return instanceClass.isAssignableFrom(Class.class);
	}

	public boolean isDataHandler() {
		return instanceClass == DataHandler.class;
	}

	public boolean isList() {
		return name.equals("java.util.List");
	}

	public String getPrintableName() {
		String name = instanceClass.getName();
		if (name.startsWith("class ")) {
			name = name.substring(6);
		}
		if (name.startsWith("interface ")) {
			name = name.substring(10);
		}
		return name;
	}

	public String getSimpleName() {
		return instanceClass.getSimpleName();
	}
	
	@Override
	public String toString() {
		return name;
	}

	public boolean isLong() {
		return name.equals("java.lang.Long") || name.equals("long");
	}

	public boolean isByteArray() {
		return instanceClass == byte[].class;
	}

	public boolean isBoolean() {
		return name.equals("java.lang.Boolean") || name.equals("boolean");
	}

	public boolean isDouble() {
		return name.equals("java.lang.Double") || name.equals("double");
	}

	public boolean isFloat() {
		return name.equals("java.lang.Float") || name.equals("float");
	}

	public boolean isInteger() {
		return name.equals("java.lang.Integer") || name.equals("int");
	}

	public boolean isVoid() {
		return name.equals("void") || name.equals("Void");
	}
}