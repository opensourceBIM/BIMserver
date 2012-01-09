package org.bimserver.shared.meta;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.jws.WebParam;

public class SMethod {
	private final List<SParameter> parameters = new ArrayList<SParameter>();
	private final Method method;
	private SClass returnType;
	private SClass genericReturnType;
	
	public SMethod(SService service, Method method) {
		this.method = method;
		int parameterCounter = 0;
		for (Class<?> parameterType : method.getParameterTypes()) {
			String paramName = "arg" + parameterCounter;
			WebParam webParam = extractAnnotation(parameterCounter, WebParam.class);
			if (webParam != null) {
				paramName = webParam.name();
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
		return method.getName();
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
}