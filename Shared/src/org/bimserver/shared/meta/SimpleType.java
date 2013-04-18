package org.bimserver.shared.meta;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;

public enum SimpleType {
	ENUM,
	STRING,
	LONG,
	INT,
	BOOLEAN,
	FLOAT,
	DOUBLE,
	DATE,
	CLASS,
	DATAHANDLER,
	BYTEARRAY,
	LIST,
	SET,
	VOID,
	UNKNOWN;

	public static SimpleType get(Class<?> instanceClass) {
		if (instanceClass.isEnum()) {
			return ENUM;
		} else if (instanceClass == String.class) {
			return STRING;
		} else if (instanceClass == Long.class) {
			return LONG;
		} else if (instanceClass == Integer.class) {
			return INT;
		} else if (instanceClass == Boolean.class) {
			return BOOLEAN;
		} else if (instanceClass == Float.class) {
			return FLOAT;
		} else if (instanceClass == Double.class) {
			return DOUBLE;
		} else if (instanceClass == Date.class) {
			return DATE;
		} else if (instanceClass == DataHandler.class) {
			return DATAHANDLER;
		} else if (instanceClass == byte[].class) {
			return BYTEARRAY;
		} else if (instanceClass == List.class) {
			return LIST;
		} else if (instanceClass == Set.class) {
			return SET;
		} else if (instanceClass == Void.class) {
			return VOID;
		}
		return UNKNOWN;
	}
}
