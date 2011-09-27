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

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SMethod {
	private final List<SParameter> parameters = new ArrayList<SParameter>();
	private final Method method;
	private SClass returnType;
	
	public SMethod(Method method) {
		this.method = method;
		for (Class<?> parameterType : method.getParameterTypes()) {
			parameters.add(new SParameter(parameterType));
		}
		this.returnType = SPackage.getInstance().getSClass(method.getReturnType().getSimpleName());
		if (returnType == null) {
			if (method.getReturnType() == List.class) {
				Type genericReturnType = method.getGenericReturnType();
				ParameterizedType parameterizedType = (ParameterizedType)genericReturnType;
				returnType = SPackage.getInstance().getSClass(((Class<?>)parameterizedType.getActualTypeArguments()[0]).getSimpleName());
			}
		}
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
}