package org.bimserver.webservices.authorization;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.bimserver.shared.exceptions.UserException;

public class ExplicitRightsAuthorization extends Authorization {
	public static final byte ID = 2;
	private long readRevisionRoid = -1;
	private long writeProjectPoid = -1;
	private long readExtendedDataRoid = -1;
	private long writeExtendedDataRoid = -1;

	public ExplicitRightsAuthorization(long uoid, long readRevisionRoid, long writeProjectPoid, long readExtendedDataRoid, long writeExtendedDataRoid) {
		super(1, TimeUnit.HOURS);
		this.setUoid(uoid);
		this.setReadRevisionRoid(readRevisionRoid);
		this.setWriteProjectPoid(writeProjectPoid);
		this.setReadExtendedDataRoid(readExtendedDataRoid);
		this.setWriteExtendedDataRoid(writeExtendedDataRoid);
	}
	
	public ExplicitRightsAuthorization() {
		super();
	}
	
	public void canDownload(long roid) throws UserException {
		if (getReadRevisionRoid() != roid) {
			throw new UserException("No rights to download revision");
		}
	}
	
	public void canCheckin(long poid) throws UserException {
		if (getWriteProjectPoid() != poid) {
			throw new UserException("No rights to checkin to this project");
		}
	}
	
	public void canReadExtendedData(long roid) throws UserException {
		if (getReadExtendedDataRoid() != roid) {
			throw new UserException("No rights to read extended data from revision");
		}
	}
	
	public void canWriteExtendedData(long roid) throws UserException {
		if (getWriteExtendedDataRoid() != roid) {
			throw new UserException("No rights to write extended data to revision");
		}
	}

	public static ExplicitRightsAuthorization fromBuffer(ByteBuffer buffer) {
		ExplicitRightsAuthorization explicitRightsAuthorization = new ExplicitRightsAuthorization();
		explicitRightsAuthorization.setUoid(buffer.getLong());
		explicitRightsAuthorization.setReadRevisionRoid(buffer.getLong());
		explicitRightsAuthorization.setWriteProjectPoid(buffer.getLong());
		explicitRightsAuthorization.setReadExtendedDataRoid(buffer.getLong());
		explicitRightsAuthorization.setWriteExtendedDataRoid(buffer.getLong());
		return explicitRightsAuthorization;
	}

	public byte getId() {
		return ID;
	}
	
	@Override
	protected int getBufferSize() {
		return 40;
	}

	@Override
	public void getBytes(ByteBuffer buffer) {
		buffer.putLong(getUoid());
		buffer.putLong(getReadRevisionRoid());
		buffer.putLong(getWriteProjectPoid());
		buffer.putLong(getReadExtendedDataRoid());
		buffer.putLong(getWriteExtendedDataRoid());
	}

	public long getReadRevisionRoid() {
		return readRevisionRoid;
	}

	public void setReadRevisionRoid(long readRevisionRoid) {
		this.readRevisionRoid = readRevisionRoid;
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