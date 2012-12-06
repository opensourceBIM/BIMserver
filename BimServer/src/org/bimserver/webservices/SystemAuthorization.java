package org.bimserver.webservices;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.bimserver.webservices.authorization.Authorization;

public class SystemAuthorization extends Authorization {
	public static final byte ID = 3;

	public SystemAuthorization(int expires, TimeUnit expiresUnit) {
		super(expires, expiresUnit);
	}

	public SystemAuthorization(long expires) {
		super(expires);
	}
	
	public SystemAuthorization() {
		super();
	}
	
	public static SystemAuthorization fromBuffer(ByteBuffer buffer) {
		return new SystemAuthorization();
	}

	public byte getId() {
		return ID;
	}
	
	@Override
	protected int getBufferSize() {
		return 0;
	}

	@Override
	public void getBytes(ByteBuffer buffer) {
	}
}
