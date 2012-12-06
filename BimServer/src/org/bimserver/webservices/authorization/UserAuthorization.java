package org.bimserver.webservices.authorization;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class UserAuthorization extends Authorization {
	public static final byte ID = 4;

	public UserAuthorization(int expires, TimeUnit expiresUnit) {
		super(expires, expiresUnit);
	}
	
	public UserAuthorization(long expires) {
		super(expires);
	}
	
	public UserAuthorization() {
		super();
	}

	public static UserAuthorization fromBuffer(ByteBuffer buffer) {
		return new UserAuthorization();
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