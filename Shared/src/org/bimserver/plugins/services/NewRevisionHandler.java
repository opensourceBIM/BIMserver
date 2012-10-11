package org.bimserver.plugins.services;

import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public interface NewRevisionHandler {

	void newRevision(ServiceInterface serviceInterface, SNewRevisionAdded notification, SObjectType settings) throws ServerException, UserException;
}