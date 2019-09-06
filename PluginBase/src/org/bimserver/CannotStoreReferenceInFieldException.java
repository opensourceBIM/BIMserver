package org.bimserver;

import org.bimserver.plugins.deserializers.DeserializerErrorCode;

public class CannotStoreReferenceInFieldException extends BimserverDatabaseException {

	private static final long serialVersionUID = -5596980882716261285L;
	private DeserializerErrorCode deserializerErrorCode;

	public CannotStoreReferenceInFieldException(String message) {
		super(message);
	}

	public CannotStoreReferenceInFieldException(DeserializerErrorCode deserializerErrorCode, String message) {
		super(message);
		this.deserializerErrorCode = deserializerErrorCode;
	}
	
	public DeserializerErrorCode getDeserializerErrorCode() {
		return deserializerErrorCode;
	}
}
