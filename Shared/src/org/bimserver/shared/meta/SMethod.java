package org.bimserver.shared.meta;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SMethod {
	private final List<SParameter> parameters = new ArrayList<SParameter>();
	private final Method method;
	
	public SMethod(Method method) {
		this.method = method;
		for (Class<?> parameterType : method.getParameterTypes()) {
			parameters.add(new SParameter(parameterType)); 
		}
 	}
	
	public SParameter getParameter(int index) {
		return parameters.get(index);
	}

	public Method getMethod() {
		return method;
	}
}