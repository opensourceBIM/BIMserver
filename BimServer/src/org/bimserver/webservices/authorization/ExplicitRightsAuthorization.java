package org.bimserver.webservices.authorization;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

import org.bimserver.shared.exceptions.UserException;

public class ExplicitRightsAuthorization extends Authorization {
	public static final byte ID = 2;
	private long readRevisionRoid = -1;
	private long writeProjectPoid = -1;
	private long readExtendedDataRoid = -1;
	private long writeExtendedDataRoid = -1;

	public ExplicitRightsAuthorization(long readRevisionRoid, long writeProjectPoid, long readExtendedDataRoid, long writeExtendedDataRoid) {
		super(1, TimeUnit.HOURS);
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
		return 32;
	}

	@Override
	public void getBytes(ByteBuffer buffer) {
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