package org.bimserver.webservices.impl;

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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.webservices.ServiceMap;

public class RemoteServiceImpl extends GenericServiceImpl implements RemoteServiceInterface {
	private BimServer bimServer;

	public RemoteServiceImpl(BimServer bimServer, ServiceMap serviceMapInterface) {
		super(serviceMapInterface);
		this.bimServer = bimServer;
	}
	
	@Override
	public List<SProfileDescriptor> getPublicProfiles(String serviceIdentifier) throws UserException, ServerException {
		DatabaseSession session = getServiceMap().getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		List<SProfileDescriptor> descriptors = new ArrayList<SProfileDescriptor>();
		try {
			IfcModelInterface modelInterface = session.getAllOfType(StorePackage.eINSTANCE.getInternalServicePluginConfiguration(), OldQuery.getDefault());
			for (InternalServicePluginConfiguration internalServicePluginConfiguration : modelInterface.getAll(InternalServicePluginConfiguration.class)) {
				if (internalServicePluginConfiguration.isPublicProfile()) {
					if (serviceIdentifier.equals("" + internalServicePluginConfiguration.getOid())) {
						SProfileDescriptor sProfileDescriptor = new SProfileDescriptor();
						descriptors.add(sProfileDescriptor);
						
						sProfileDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
						sProfileDescriptor.setName(internalServicePluginConfiguration.getName());
						sProfileDescriptor.setDescription(internalServicePluginConfiguration.getDescription());
						sProfileDescriptor.setPublicProfile(false);
					}
				}
			}
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return descriptors;
	}

	@Override
	public List<SProfileDescriptor> getPrivateProfiles(String serviceIdentifier, String token) throws UserException, ServerException {
		DatabaseSession session = getServiceMap().getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		List<SProfileDescriptor> descriptors = new ArrayList<SProfileDescriptor>();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Token(), new StringLiteral(token));
			User user = session.querySingle(condition, User.class, OldQuery.getDefault());
			if (user != null) {
				for (InternalServicePluginConfiguration internalServicePluginConfiguration : user.getUserSettings().getServices()) {
					if (internalServicePluginConfiguration.getPluginDescriptor().getPluginClassName().equals(serviceIdentifier)) {
						SProfileDescriptor sProfileDescriptor = new SProfileDescriptor();
						descriptors.add(sProfileDescriptor);
						
						sProfileDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
						sProfileDescriptor.setName(internalServicePluginConfiguration.getName());
						sProfileDescriptor.setDescription(internalServicePluginConfiguration.getDescription());
						sProfileDescriptor.setPublicProfile(false);
					}
				}
			}
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return descriptors;
	}
	
	@Override
	public void newRevision(Long poid, Long roid, Long soid, String serviceIdentifier, String profileIdentifier, String userToken, String token, String apiUrl) throws UserException, ServerException {
		RemoteServiceInterface localRemoteServiceInterface = bimServer.getInternalServicesManager().getLocalRemoteServiceInterface(serviceIdentifier);
		if (localRemoteServiceInterface == null) {
			throw new UserException("No local remote service found " + serviceIdentifier);
		}
		localRemoteServiceInterface.newRevision(poid, roid, soid, serviceIdentifier, profileIdentifier, userToken, token, apiUrl);
	}

	@Override
	public SServiceDescriptor getService(String serviceIdentifier) throws UserException, ServerException {
		ServiceDescriptor internalService = getBimServer().getInternalServicesManager().getInternalService(getAuthorization().getUoid(), serviceIdentifier);
		return getBimServer().getSConverter().convertToSObject(internalService);
	}

	@Override
	public void newExtendedDataOnProject(Long poid, Long edid, Long soid, String serviceIdentifier, String profileIdentifier, String userToken, String token, String apiUrl) throws UserException, ServerException {
		bimServer.getInternalServicesManager().getLocalRemoteServiceInterface(serviceIdentifier).newExtendedDataOnProject(poid, edid, soid, serviceIdentifier, profileIdentifier, userToken, token, apiUrl);
	}

	@Override
	public void newExtendedDataOnRevision(Long poid, Long roid, Long edid, Long soid, String serviceIdentifier, String profileIdentifier, String userToken, String token, String apiUrl) throws UserException, ServerException {
		bimServer.getInternalServicesManager().getLocalRemoteServiceInterface(serviceIdentifier).newExtendedDataOnRevision(poid, roid, edid, soid, serviceIdentifier, profileIdentifier, userToken, token, apiUrl);
	}
}