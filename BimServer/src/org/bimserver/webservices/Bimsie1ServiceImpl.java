package org.bimserver.webservices;

import javax.activation.DataHandler;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.Bimsie1Interface;

public class Bimsie1ServiceImpl extends LowLevelServiceImpl implements Bimsie1Interface {

	public Bimsie1ServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public String login(String username, String password) throws ServerException, UserException {
		return null;
	}

	@Override
	public void logout() throws ServerException, UserException {
	}

	@Override
	public Long checkin(Long poid, String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler ifcFile, Boolean sync) throws ServerException, UserException {
		return null;
	}

	@Override
	public Long download(Long roid, Long serializerOid, Boolean showOwn, Boolean sync) throws ServerException, UserException {
		return null;
	}

	@Override
	public String getServiceLog() throws ServerException, UserException {
		return getServiceMap().get(AdminInterface.class).getServerLog();
	}
}