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