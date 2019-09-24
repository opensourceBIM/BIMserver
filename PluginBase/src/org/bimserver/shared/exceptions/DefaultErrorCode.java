package org.bimserver.shared.exceptions;

import java.util.HashMap;
import java.util.Map;

public enum DefaultErrorCode implements ErrorCode {
	ENDPOINT_NOT_FOUND(1),
	HTTP_CONNECTION_REFUSED(2), 
	INVALID_TOKEN(3);
	
	private static final Map<Integer, DefaultErrorCode> MAP = new HashMap<>();

	private int code;

	DefaultErrorCode(int code) {
		this.code = code;
	}
	
	@Override
	public int getCode() {
		return code;
	}

	public static DefaultErrorCode fromCode(int code) {
		return MAP.get(code);
	}
	
	static {
		for (DefaultErrorCode defaultErrorCode : DefaultErrorCode.values()) {
			MAP.put(defaultErrorCode.getCode(), defaultErrorCode);
		}
	}
}
