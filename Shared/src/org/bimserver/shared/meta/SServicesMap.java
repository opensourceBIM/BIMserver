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

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.reflector.ReflectorFactory;
import org.bimserver.utils.StringUtils;

import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SServicesMap {
	// Must be LinkedHashMap because order IS important for dependencies
	private final Map<String, SService> servicesByName = new LinkedHashMap<String, SService>();
	private final Map<String, SService> servicesBySimpleName = new LinkedHashMap<String, SService>();
	private final Map<String, SClass> types = new TreeMap<String, SClass>();
	private ReflectorFactory reflectorFactory;

	public void add(SService sService) {
		servicesByName.put(sService.getName(), sService);
		servicesBySimpleName.put(sService.getSimpleName(), sService);
	}

	public SService getByName(String name) {
		return servicesByName.get(name);
	}

	public Collection<SService> list() {
		return servicesByName.values();
	}
	
	public SService getBySimpleName(String name) {
		return servicesBySimpleName.get(name);
	}

	public SClass getType(String name) {
		for (SService sService : servicesByName.values()) {
			SClass type = sService.getServicesMap().getSType(name);
			if (type != null) {
				return type;
			}
		}
		return null;
	}

	public Set<String> keySetName() {
		return servicesByName.keySet();
	}

	public Set<String> keySetSimpleName() {
		return servicesBySimpleName.keySet();
	}

	public void addType(final Class<?> type) {
		if (!types.containsKey(type.getSimpleName())) {
			// TODO reflective constructor use can be slow
			SClass sClass = new SClass(this, type, new SConstructor(){
				@Override
				public Object newInstance() {
					try {
						return type.getConstructors()[0].newInstance();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}
					return null;
				}});
			types.put(sClass.getSimpleName(), sClass);
			types.put(sClass.getName(), sClass);
			addRelatedTypes(type);
		}
	}

	public void addType(SClass type) {
		types.put(type.getSimpleName(), type);
		types.put(type.getName(), type);
		addRelatedTypes(type.getInstanceClass());
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
	
	public Class<?> getGenericType(Method method) {
		Type genericReturnType = method.getGenericReturnType();
		if (method.getGenericReturnType() instanceof ParameterizedType) {
			ParameterizedType parameterizedTypeImpl = (ParameterizedType)genericReturnType;
			Type first = parameterizedTypeImpl.getActualTypeArguments()[0];
			if (first instanceof WildcardType) {
				return null;
			} else if (first instanceof ParameterizedType) {
				return null;
			} else if (first instanceof TypeVariableImpl) {
				TypeVariableImpl<?> typeVariableImpl = (TypeVariableImpl<?>)first;
				GenericDeclaration genericDeclaration = typeVariableImpl.getGenericDeclaration();
				if (genericDeclaration instanceof Class) {
					return (Class<?>) genericDeclaration;
				}
			} else {
				return (Class<?>) first;
			}
		}
		return (Class<?>) method.getGenericReturnType();
	}

	public Set<SClass> getTypes() {
		return new HashSet<SClass>(types.values());
	}

//	public SClass getSType(String name, Set<SService> checked) {
//		checked.add(this);
//		SClass sType = types.get(name);
//		if (sType == null) {
//			if (name.contains(".")) {
//				name = name.substring(name.lastIndexOf(".") + 1);
//				return getSType(name, checked);
//			}
//		}
//		if (sType == null) {
//			for (SService other : others) {
//				if (!checked.contains(other)) {
//					SClass otherClass = other.getSType(name, checked);
//					if (otherClass != null) {
//						return otherClass;
//					}
//				}
//			}
//		}
//		return sType;
//	}

	public SClass getSType(String name) {
		return types.get(name);
//		return getSType(name, new HashSet<SService>());
	}
	
	public Set<Class<? extends PublicInterface>> getInterfaceClasses() {
		Set<Class<? extends PublicInterface>> result = new LinkedHashSet<Class<? extends PublicInterface>>();
		for (SService sService : servicesByName.values()) {
			result.add((Class<? extends PublicInterface>) sService.getInterfaceClass());
		}
		return result;
	}

	public void setReflectorFactory(ReflectorFactory reflectorFactory) {
		this.reflectorFactory = reflectorFactory;
	}

	public ReflectorFactory getReflectorFactory() {
		return reflectorFactory;
	}

	/**
	 * Inefficient method of getting a SMethod
	 * 
	 * @param methodName
	 * @return
	 */
	public SMethod findMethod(String methodName) {
		for (SService sService : servicesByName.values()) {
			SMethod method = sService.getSMethod(methodName);
			if (method != null) {
				return method;
			}
		}
		return null;
	}

	public ObjectNode toJson(ObjectMapper objectMapper) {
		ObjectNode result = objectMapper.createObjectNode();
		ArrayNode servicesJson = objectMapper.createArrayNode();
		result.set("services", servicesJson);
		for (SService sService : servicesByName.values()) {
			ObjectNode serviceJson = objectMapper.createObjectNode();
			serviceJson.put("name", sService.getName());
			serviceJson.put("simpleName", sService.getSimpleName());
			servicesJson.add(serviceJson);
			ArrayNode methodsJson = objectMapper.createArrayNode();
			serviceJson.set("methods", methodsJson);
			for (SMethod method : sService.getMethods()) {
				methodsJson.add(method.toJson(objectMapper));
			}
		}
		return result;
	}

	public void initialize() {
		for (SService sService : servicesByName.values()) {
			sService.init();
		}
	}
}