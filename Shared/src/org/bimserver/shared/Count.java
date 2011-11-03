package org.bimserver.shared;

import java.lang.reflect.Method;

import javax.jws.WebMethod;

public class Count {
	public static void main(String[] args) {
		int count = 0;
		for (Method method : ServiceInterface.class.getMethods()) {
			if (method.getAnnotation(WebMethod.class) != null) {
				count++;
			}
		}
		System.out.println(count);
	}
}
