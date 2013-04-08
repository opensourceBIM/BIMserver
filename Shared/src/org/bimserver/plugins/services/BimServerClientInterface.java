package org.bimserver.plugins.services;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface BimServerClientInterface extends ServiceHolder {

	IfcModelInterface getModel(long poid, long roid, boolean deep) throws BimServerClientException, UserException, ServerException, PublicInterfaceNotFoundException;
}