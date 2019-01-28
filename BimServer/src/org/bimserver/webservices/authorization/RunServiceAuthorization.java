package org.bimserver.webservices.authorization;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.bimserver.BimServer;

public class RunServiceAuthorization extends Authorization {
	public static final byte ID = 7;

	private long soid;
	
	public RunServiceAuthorization(BimServer bimServer, long uoid, long soid) {
		super(bimServer.getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds(), TimeUnit.SECONDS);
		this.soid = soid;
		this.setUoid(uoid);
	}
	
	public long getSoid() {
		return soid;
	}

	public RunServiceAuthorization() {
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
		buffer.putLong(soid);
	}

	public static Authorization fromBuffer(ByteBuffer buffer) {
		RunServiceAuthorization runServiceAuthorization = new RunServiceAuthorization();
		runServiceAuthorization.setUoid(buffer.getLong());
		runServiceAuthorization.setSoid(buffer.getLong());
		return runServiceAuthorization;
	}

	private void setSoid(long soid) {
		this.soid = soid;
	}
}