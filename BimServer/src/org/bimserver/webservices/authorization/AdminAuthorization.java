package org.bimserver.webservices.authorization;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class AdminAuthorization extends Authorization {
	public static final byte ID = 5;

	public AdminAuthorization(int expires, TimeUnit expiresUnit) {
		super(expires, expiresUnit);
	}
	
	public AdminAuthorization(long expires) {
		super(expires);
	}
	
	public AdminAuthorization() {
		super();
	}

	public static AdminAuthorization fromBuffer(ByteBuffer buffer) {
		return new AdminAuthorization();
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