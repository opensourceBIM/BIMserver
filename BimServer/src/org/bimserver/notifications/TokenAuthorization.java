package org.bimserver.notifications;

import org.bimserver.models.store.Service;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class TokenAuthorization extends Authorization {
	private Service service;

	public TokenAuthorization(long uoid, Service service) {
		super(uoid);
		this.service = service;
	}
	
	public void canDownload(long roid) throws UserException {
		if (service.getReadRevision() == null || service.getReadRevision().getOid() != roid) {
			throw new UserException("No rights to download revision");
		}
	}
	
	public void canCheckin(long poid) throws UserException {
		if (service.getWriteRevision() == null || service.getWriteRevision().getOid() != poid) {
			throw new UserException("No rights to checkin to this project");
		}
	}
	
	public void canReadExtendedData(long roid) throws UserException {
		if (service.getReadExtendedData() == null || service.getReadExtendedData().getOid() != roid) {
			throw new UserException("No rights to read extended data from revision");
		}
	}
	
	public void canWriteExtendedData(long roid) throws UserException {
		if (service.getWriteExtendedData() == null || service.getWriteExtendedData().getOid() != roid) {
			throw new UserException("No rights to write extended data to revision");
		}
	}
}