package org.bimserver.notifications;

import java.util.List;

import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.RemoteServiceInterface;

public class RemoteServiceInterfaceAdapter implements RemoteServiceInterface {

	@Override
	public List<SProfileDescriptor> getPublicProfiles(String serviceIdentifier)
			throws UserException, ServerException {
		return null;
	}

	@Override
	public List<SProfileDescriptor> getPrivateProfiles(String serviceIdentifier, String token) throws UserException, ServerException {
		return null;
	}

	@Override
	public SServiceDescriptor getService(String serviceIdentifier) throws UserException, ServerException {
		return null;
	}

	@Override
	public void newRevision(Long roid, String serviceIdentifier, String profileIdentifier, String token, String apiUrl)
			throws UserException, ServerException {
	}
}