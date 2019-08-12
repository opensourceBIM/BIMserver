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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.bimserver.shared.reflector.ReflectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SMethod {
	private static final Logger LOGGER = LoggerFactory.getLogger(SMethod.class);
	private String doc = "";
	private final List<SParameter> parameters = new ArrayList<SParameter>();
	private final Method method;
	private SClass returnType;
	private SClass genericReturnType;
	private String returnDoc;
	private String name;
	private SService service;
	private final Map<PublicInterface, Reflector> reflectorCache = java.util.Collections.synchronizedMap(new HashMap<>());
	
	@SuppressWarnings("rawtypes")
	public SMethod(SService service, Method method) {
		this.service = service;
		this.method = method;
		
		WebMethod webMethod = method.getAnnotation(WebMethod.class);
		if (webMethod == null) {
			this.name = method.getName();
			LOGGER.warn("Method " + method.getName() + " has no @WebMethod annotation");
		} else {
			this.name = webMethod.action();
		}
		
		int parameterCounter = 0;
		for (Class<?> parameterType : method.getParameterTypes()) {
			String paramName = "arg" + parameterCounter;
			WebParam webParam = extractAnnotation(parameterCounter, WebParam.class);
			if (webParam != null) {
				paramName = webParam.name();
			} else {
				LOGGER.warn("Method " + method.getName() + " parameter " + parameterCounter + " has no @WebParam annotation");
			}
			Class<?> genericType = getGenericReturnType(parameterCounter);
			parameters.add(new SParameter(this, service.getServicesMap().getSType(parameterType.getName()), genericType == null ? null : service.getServicesMap().getSType(genericType.getName()), paramName));
			parameterCounter++;			
		}
		this.returnType = service.getServicesMap().getSType(method.getReturnType().getName());
		if (method.getReturnType() == List.class || method.getReturnType() == Set.class) {
			Type genericReturnType = method.getGenericReturnType();
			ParameterizedType parameterizedType = (ParameterizedType)genericReturnType;
			Type type = parameterizedType.getActualTypeArguments()[0];
			if (type instanceof Class) {
				this.genericReturnType = service.getServicesMap().getSType(((Class)type).getName());
			}
		}
 	}

	@SuppressWarnings("unchecked")
	private <T extends Annotation> T extractAnnotation(int parameterIndex, Class<T> annotationClass) {
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		Annotation[] annotations = parameterAnnotations[parameterIndex];
		for (Annotation annotation : annotations) {
			if (annotationClass.isInstance(annotation)) {
				return (T) annotation;
			}
		}
		return null;
	}
	
	private Class<?> getGenericReturnType(int parameterCounter) {
		Class<?> parameterType = null;
		Type genericReturnType = method.getGenericParameterTypes()[parameterCounter];
		if (genericReturnType instanceof ParameterizedType) {
			ParameterizedType parameterizedTypeImpl = (ParameterizedType)genericReturnType;
			Type type2 = parameterizedTypeImpl.getActualTypeArguments()[0];
			parameterType = ((Class<?>)type2);
		}
		return parameterType;
	}
	
	public String getName() {
		return name;
	}
	
	public SParameter getParameter(int index) {
		return parameters.get(index);
	}

	public Method getMethod() {
		return method;
	}

	public SClass getReturnType() {
		return returnType;
	}
	
	public List<SParameter> getParameters() {
		return parameters;
	}

	public boolean returnsVoid() {
		return method.getReturnType() == Void.class || method.getReturnType() == void.class;
	}

	public boolean isAggregateReturnType() {
		return List.class.isAssignableFrom(method.getReturnType()) || Set.class.isAssignableFrom(method.getReturnType());
	}

	public SClass getGenericReturnType() {
		return genericReturnType;
	}
	
	public SClass getBestReturnType() {
		return genericReturnType != null ? genericReturnType : returnType;
	}

	public String returnTypeToJavaCode() {
		StringBuilder sb = new StringBuilder();
		if (getGenericReturnType() != null) {
			sb.append(getReturnType().toJavaCode());
			sb.append("<");
			sb.append(getGenericReturnType().toJavaCode());
			sb.append(">");
		} else {
			sb.append(getReturnType().toJavaCode());
		}
		return sb.toString();
	}
	
	public String signatureToJavaCode() {
		StringBuilder sb = new StringBuilder();
		for (SParameter parameter : getParameters()) {
			sb.append((parameter.getGenericType() != null ? (parameter.getGenericType().toJavaCode() + "<" + parameter.getType() + ">") : parameter.getType().toJavaCode()) + parameter.getName());
			if (!parameter.isLast()) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
	
	public boolean isListReturnType() {
		return List.class.isAssignableFrom(method.getReturnType());
	}

	public String getPrintableName() {
		String r = getReturnType().getPrintableName();
		if (getGenericReturnType() != null) {
			r += "<" + getGenericReturnType().getPrintableName() + ">";
		}
		return r;
	}
	
	public SParameter getParameter(String name) {
		for (SParameter parameter : this.parameters) {
			if (parameter.getName().equals(name)) {
				return parameter;
			}
		}
		return null;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}
	
	public String getDoc() {
		return doc;
	}

	public void setReturnDoc(String returnDoc) {
		this.returnDoc = returnDoc;
	}
	
	public String getReturnDoc() {
		return returnDoc;
	}

	public <T extends PublicInterface, K extends PublicInterface> Object invoke(Class<K> clazz, T service, KeyValuePair[] keyValuePairs) throws ServiceException, ReflectorException {
		Reflector reflector = null;
		if (reflectorCache.containsKey(service)) {
			reflector = reflectorCache.get(service);
		} else {
			reflector = this.service.getServicesMap().getReflectorFactory().createReflector(clazz, service);
			reflectorCache.put(service, reflector);
		}
		return reflector.callMethod(clazz.getName(), getName(), getReturnType().getInstanceClass(), keyValuePairs);
	}
	
	public SService getService() {
		return service;
	}

	public ObjectNode toJson(ObjectMapper OBJECT_MAPPER) {
		ObjectNode methodJson = OBJECT_MAPPER.createObjectNode();
		methodJson.put("name", getName());
		methodJson.put("doc", getDoc());
		methodJson.put("returnDoc", getReturnDoc());
		ArrayNode parametersJson = OBJECT_MAPPER.createArrayNode();
		methodJson.set("parameters", parametersJson);
		for (SParameter parameter : parameters) {
			parametersJson.add(parameter.toJson(OBJECT_MAPPER));
		}
		return methodJson;
	}
}