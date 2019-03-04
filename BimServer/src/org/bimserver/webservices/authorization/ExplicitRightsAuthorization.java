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
import org.bimserver.shared.exceptions.UserException;

public class ExplicitRightsAuthorization extends Authorization {
	public static final byte ID = 2;
	private long[] readRevisionRoids;
	private long writeProjectPoid = -1;
	private long readExtendedDataRoid = -1;
	private long writeExtendedDataRoid = -1;
	private long soid;

	public ExplicitRightsAuthorization(BimServer bimServer, long uoid, long soid, long[] readRevisionRoids, long writeProjectPoid, long readExtendedDataRoid, long writeExtendedDataRoid) {
		super(bimServer.getServerSettingsCache().getServerSettings().getSessionTimeOutSeconds(), TimeUnit.SECONDS);
		this.soid = soid;
		this.setUoid(uoid);
		this.setReadRevisionRoids(readRevisionRoids);
		this.setWriteProjectPoid(writeProjectPoid);
		this.setReadExtendedDataRoid(readExtendedDataRoid);
		this.setWriteExtendedDataRoid(writeExtendedDataRoid);
	}
	
	private ExplicitRightsAuthorization() {
		super();
	}
	
	public long getSoid() {
		return soid;
	}
	
	public void canDownload(long roid) throws UserException {
		for (long rroid : getReadRevisionRoids()) {
			if (rroid == roid) {
				return;
			}
		}
		throw new UserException("No rights to download revision");
	}
	
	public void canCheckin(long poid) throws UserException {
		if (getWriteProjectPoid() != poid) {
			throw new UserException("No rights to checkin to this project (" + poid + ", " + getWriteProjectPoid() + ")");
		}
	}
	
	public void canReadExtendedData(long roid) throws UserException {
		if (getReadExtendedDataRoid() != roid) {
			throw new UserException("No rights to read extended data from revision");
		}
	}
	
	public void canWriteExtendedData(long roid) throws UserException {
		if (getWriteExtendedDataRoid() != roid) {
			throw new UserException("No rights to write extended data to revision (" + roid + "), has rights for " + getWriteExtendedDataRoid());
		}
	}

	public static ExplicitRightsAuthorization fromBuffer(ByteBuffer buffer) {
		ExplicitRightsAuthorization explicitRightsAuthorization = new ExplicitRightsAuthorization();
		explicitRightsAuthorization.setUoid(buffer.getLong());
		explicitRightsAuthorization.setSoid(buffer.getLong());
		int nrRoids = buffer.getInt();
		long[] roids = new long[nrRoids];
		for (int i=0; i<nrRoids; i++) {
			roids[i] = buffer.getLong();
		}
		explicitRightsAuthorization.setReadRevisionRoids(roids);
		explicitRightsAuthorization.setWriteProjectPoid(buffer.getLong());
		explicitRightsAuthorization.setReadExtendedDataRoid(buffer.getLong());
		explicitRightsAuthorization.setWriteExtendedDataRoid(buffer.getLong());
		return explicitRightsAuthorization;
	}

	private void setSoid(long soid) {
		this.soid = soid;
	}

	public byte getId() {
		return ID;
	}
	
	@Override
	protected int getBufferSize() {
		return 44 + getReadRevisionRoids().length * 8;
	}

	@Override
	public void getBytes(ByteBuffer buffer) {
		buffer.putLong(getUoid());
		buffer.putLong(getSoid());
		buffer.putInt(getReadRevisionRoids().length);
		for (long roid : getReadRevisionRoids()) {
			buffer.putLong(roid);
		}
		buffer.putLong(getWriteProjectPoid());
		buffer.putLong(getReadExtendedDataRoid());
		buffer.putLong(getWriteExtendedDataRoid());
	}

	public long[] getReadRevisionRoids() {
		return readRevisionRoids;
	}

	public void setReadRevisionRoids(long[] readRevisionRoids) {
		this.readRevisionRoids = readRevisionRoids;
	}

	public long getWriteProjectPoid() {
		return writeProjectPoid;
	}

	public void setWriteProjectPoid(long writeProjectPoid) {
		this.writeProjectPoid = writeProjectPoid;
	}

	public long getReadExtendedDataRoid() {
		return readExtendedDataRoid;
	}

	public void setReadExtendedDataRoid(long readExtendedDataRoid) {
		this.readExtendedDataRoid = readExtendedDataRoid;
	}

	public long getWriteExtendedDataRoid() {
		return writeExtendedDataRoid;
	}

	public void setWriteExtendedDataRoid(long writeExtendedDataRoid) {
		this.writeExtendedDataRoid = writeExtendedDataRoid;
	}
}