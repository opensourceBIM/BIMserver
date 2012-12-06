package org.bimserver.webservices.authorization;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class AnonymousAuthorization extends Authorization {
	public static final byte ID = 1;
	
	public AnonymousAuthorization(int expires, TimeUnit expiresUnit) {
		super(expires, expiresUnit);
	}
	
	public AnonymousAuthorization(long expires) {
		super(expires);
	}
	
	public AnonymousAuthorization() {
		super();
	}

	public static AnonymousAuthorization fromBuffer(ByteBuffer buffer) {
		return new AnonymousAuthorization();
	}
	
	@Override
	public void getBytes(ByteBuffer buffer) {
	}

	public byte getId() {
		return ID;
	}
	
	@Override
	protected int getBufferSize() {
		return 0;
	}
}