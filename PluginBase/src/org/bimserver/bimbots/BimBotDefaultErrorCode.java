package org.bimserver.bimbots;

public enum BimBotDefaultErrorCode implements BimBotErrorCode {
	NO_DESERIALIZER(1), NO_OUTPUT_SCHEMA(2), NO_INPUT_SCHEMA(3), NO_RENDER_ENGINE(4), INVALID_CONFIGURATION(5);

	private int errorCode;

	BimBotDefaultErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}
