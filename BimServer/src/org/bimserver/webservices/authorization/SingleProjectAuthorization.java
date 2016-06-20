package org.bimserver.webservices.authorization;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.bimserver.BimServer;

public class SingleProjectAuthorization extends Authorization {
	public static final byte ID = 6;

	private long poid;
	
	public SingleProjectAuthorization(BimServer bimServer, long uoid, long poid) {
		super(bimServer.getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds(), TimeUnit.SECONDS);
		this.setUoid(uoid);
		this.poid = poid;
	}

	public SingleProjectAuthorization() {
		super();
	}

	@Override
	protected int getBufferSize() {
		return 16;
	}

	@Override
	protected byte getId() {
		return ID;
	}

	@Override
	protected void getBytes(ByteBuffer buffer) {
		buffer.putLong(getUoid());
		buffer.putLong(poid);
	}

	public static Authorization fromBuffer(ByteBuffer buffer) {
		SingleProjectAuthorization explicitRightsAuthorization = new SingleProjectAuthorization();
		explicitRightsAuthorization.setUoid(buffer.getLong());
		explicitRightsAuthorization.setPoid(buffer.getLong());
		return explicitRightsAuthorization;
	}

	private void setPoid(long poid) {
		this.poid = poid;
	}
}