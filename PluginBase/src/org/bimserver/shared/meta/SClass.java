package org.bimserver.shared.meta;

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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

import javax.activation.DataHandler;

import org.bimserver.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SClass implements Comparable<SClass> {
	private static final Logger LOGGER = LoggerFactory.getLogger(SClass.class);
	private final Map<String, SField> ownFields = new TreeMap<String, SField>();
	private final Map<String, SField> allFields = new TreeMap<String, SField>();
	private final String name;
	private final Class<?> instanceClass;
	private final Set<SClass> subClasses = new TreeSet<SClass>();
	private final SConstructor sConstructor;
	private final SimpleType simpleType;
	private SClass superClass;
	private SServicesMap sServicesMap;
	
	public SClass(SServicesMap sServicesMap, Class<?> instanceClass, SConstructor sConstructor) {
		this.sServicesMap = sServicesMap;
		this.sConstructor = sConstructor;
		if (instanceClass == null) {
			throw new RuntimeException("InstanceClass cannot be null");
		}
		if (instanceClass.isEnum() || instanceClass.isArray() || instanceClass == Enum.class || instanceClass.getName().equals("java.lang.Object") || instanceClass.isPrimitive() || instanceClass == String.class || instanceClass.getName().startsWith("java.")) {
			
		} else {
			if (sConstructor == null) {
				throw new RuntimeException("No constructor for " + instanceClass.getName());
			}
		}
		this.instanceClass = instanceClass;
		this.name = instanceClass.getName();
		this.simpleType = SimpleType.get(instanceClass);
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

	public SServicesMap getServicesMap() {
		return this.sServicesMap;
	}
	
	public void init() {
		for (Method method : instanceClass.getMethods()) {
			if (method.getDeclaringClass() == instanceClass) {
				if (method.getName().startsWith("get") && method.getName().length() > 3 && !method.getName().equals("getSClass")) {
					String fieldName = StringUtils.firstLowerCase(method.getName().substring(3));
					try {
						if (instanceClass.getMethod("set" + StringUtils.firstUpperCase(fieldName), method.getReturnType()) != null) {
							Class<?> genericType = sServicesMap.getGenericType(method);
							boolean aggregate = List.class.isAssignableFrom(method.getReturnType()) || Set.class.isAssignableFrom(method.getReturnType());
							SField sField = new SField(fieldName, sServicesMap.getSType(method.getReturnType().getName()), genericType == null ? null : sServicesMap.getSType(genericType.getName()), aggregate);
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
							Class<?> genericType = sServicesMap.getGenericType(method);
							boolean aggregate = List.class.isAssignableFrom(method.getReturnType()) || Set.class.isAssignableFrom(method.getReturnType());
							SField sField = new SField(fieldName, sServicesMap.getSType(method.getReturnType().getName()), genericType == null ? null : sServicesMap.getSType(genericType.getName()), aggregate);
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
			addSuperClass(sServicesMap.getSType(superclass.getName()));
		}
	}

	private void addSuperClass(SClass sType) {
		superClass = sType;
		for (SField field : superClass.getAllFields()) {
			allFields.put(field.getName(), field);
		}
		sType.addSubClass(this);
	}
	
	private void addSubClass(SClass sClass) {
		subClasses.add(sClass);
	}

	public void addField(SField sField) {
		ownFields.put(sField.getName(), sField);
		allFields.put(sField.getName(), sField);
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
		return allFields.get(name);
	}

	public Class<?> getInstanceClass() {
		return instanceClass;
	}
	
	public Collection<SField> getOwnFields() {
		return ownFields.values();
	}

	public Collection<SField> getAllFields() {
		return allFields.values();
	}
	
	public SBase newInstance() {
		if (sConstructor == null) {
			throw new RuntimeException("No constructor for " + getName() + "!");
		}
		return (SBase) sConstructor.newInstance();
	}

	public boolean isPrimitive() {
		if (instanceClass.isPrimitive()) {
			return true;
		} else if (instanceClass == Long.class || instanceClass == Integer.class || instanceClass == Short.class || instanceClass == Float.class || instanceClass == Double.class || instanceClass == Boolean.class || instanceClass == Character.class) {
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
	
	public String toJavaCode() {
		if (instanceClass == byte[].class) {
			return "byte[]";
		}
		if (instanceClass == Byte[].class) {
			return "java.lang.Byte[]";
		}
		return name;
	}

	public boolean isLong() {
		return name.equals("java.lang.Long") || name.equals("long");
	}

	public boolean isShort() {
		return name.equals("java.lang.Short") || name.equals("short");
	}

	public boolean isByteArray() {
		return instanceClass == byte[].class || instanceClass == Byte[].class;
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
	
	public SimpleType getSimpleType() {
		return simpleType;
	}

	public ObjectNode toJson(ObjectMapper OBJECT_MAPPER) {
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		result.put("name", getName());
		result.put("simpleName", getSimpleName());
		result.put("simpleType", getSimpleType().name());
		ArrayNode fieldsJson = OBJECT_MAPPER.createArrayNode();
		for (SField field : ownFields.values()) {
			fieldsJson.add(field.toJson(OBJECT_MAPPER));
		}
		result.set("fields", fieldsJson);
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instanceClass == null) ? 0 : instanceClass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SClass other = (SClass) obj;
		if (instanceClass == null) {
			if (other.instanceClass != null)
				return false;
		} else if (!instanceClass.equals(other.instanceClass))
			return false;
		return true;
	}

	@Override
	public int compareTo(SClass arg0) {
		return name.compareTo(arg0.getName());
	}

	public boolean isUuid() {
		return instanceClass == UUID.class;
	}
}