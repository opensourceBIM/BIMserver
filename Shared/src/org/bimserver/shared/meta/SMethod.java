package org.bimserver.shared.meta;

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