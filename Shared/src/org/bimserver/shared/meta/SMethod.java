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

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMethod {
	private static final Logger LOGGER = LoggerFactory.getLogger(SMethod.class);
	private String doc = "";
	private final List<SParameter> parameters = new ArrayList<SParameter>();
	private final Method method;
	private SClass returnType;
	private SClass genericReturnType;
	private String returnDoc;
	private String name;
	
	public SMethod(SService service, Method method) {
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
			Class<?> genericType = getGenericType(parameterCounter);
			parameters.add(new SParameter(this, service.getSType(parameterType.getName()), genericType == null ? null : service.getSType(genericType.getName()), paramName));
			parameterCounter++;			
		}
		this.returnType = service.getSType(method.getReturnType().getName());
		if (method.getReturnType() == List.class || method.getReturnType() == Set.class) {
			Type genericReturnType = method.getGenericReturnType();
			ParameterizedType parameterizedType = (ParameterizedType)genericReturnType;
			this.genericReturnType = service.getSType(((Class<?>)parameterizedType.getActualTypeArguments()[0]).getName());
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
	
	private Class<?> getGenericType(int parameterCounter) {
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

	public Object invoke(Object service, Object[] parameters) throws ServiceException {
		for (Method method : service.getClass().getMethods()) {
			if (method.getName().equals(getName())) {
				try {
					return method.invoke(service, parameters);
				} catch (Exception e) {
					if (e instanceof ServiceException) {
						throw (ServiceException)e;
					} else if (e instanceof InvocationTargetException) {
						if (e.getCause() instanceof ServiceException) {
							throw (ServiceException)(e.getCause());
						} else {
							dumpError(parameters, method, e);
						}
					} else {
						dumpError(parameters, method, e);
						throw new UserException("Invalid arguments");
					}
				}
			}
		}
		return null;
	}

	private void dumpError(Object[] parameters, Method method, Exception e) {
		LOGGER.error(method.getName());
		LOGGER.error(Arrays.toString(parameters));
		StringBuilder sb = new StringBuilder();
		for (Object o : parameters) {
			sb.append((o == null ? "null" : o.getClass().getName()) + ", ");
		}
		LOGGER.error(sb.toString());
		LOGGER.error(Arrays.toString(method.getParameterTypes()));
		e.printStackTrace();
	}
}