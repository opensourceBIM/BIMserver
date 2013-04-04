package org.bimserver.shared.exceptions;

public enum ErrorCode {
	SET_REFERENCE_FAILED_OPPOSITE_ALREADY_SET(500);

	private int code;

	ErrorCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static ErrorCode parse(int asInt) {
		// TODO make faster
		for (ErrorCode errorCode : ErrorCode.values()) {
			if (asInt == errorCode.getCode()) {
				return errorCode;
			}
		}
		return null;
	}
}
