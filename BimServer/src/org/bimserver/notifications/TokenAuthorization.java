package org.bimserver.notifications;

import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class TokenAuthorization extends Authorization {
	private long readRevisionRoid = -1;
	private long writeProjectPoid = -1;
	private long readExtendedDataRoid = -1;
	private long writeExtendedDataRoid = -1;

	public TokenAuthorization(long uoid, long readRevisionRoid, long writeProjectPoid, long readExtendedDataRoid, long writeExtendedDataRoid) {
		super(uoid);
		this.readRevisionRoid = readRevisionRoid;
		this.writeProjectPoid = writeProjectPoid;
		this.readExtendedDataRoid = readExtendedDataRoid;
		this.writeExtendedDataRoid = writeExtendedDataRoid;
	}
	
	public void canDownload(long roid) throws UserException {
		if (readRevisionRoid != roid) {
			throw new UserException("No rights to download revision");
		}
	}
	
	public void canCheckin(long poid) throws UserException {
		if ( writeProjectPoid != poid) {
			throw new UserException("No rights to checkin to this project");
		}
	}
	
	public void canReadExtendedData(long roid) throws UserException {
		if (readExtendedDataRoid != roid) {
			throw new UserException("No rights to read extended data from revision");
		}
	}
	
	public void canWriteExtendedData(long roid) throws UserException {
		if (writeExtendedDataRoid != roid) {
			throw new UserException("No rights to write extended data to revision");
		}
	}
}