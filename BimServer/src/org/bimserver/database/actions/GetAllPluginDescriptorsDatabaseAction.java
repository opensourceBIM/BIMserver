package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class GetAllPluginDescriptorsDatabaseAction extends BimDatabaseAction<List<SPluginDescriptor>>{

	private String interfaceClassName;
	private BimServer bimServer;

	public GetAllPluginDescriptorsDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, BimServer bimServer, String interfaceClassName) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.interfaceClassName = interfaceClassName;
	}

	@Override
	public List<SPluginDescriptor> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		IfcModelInterface allOfType = getDatabaseSession().getAllOfType(StorePackage.eINSTANCE.getPluginDescriptor(), OldQuery.getDefault());
		List<SPluginDescriptor> result = new ArrayList<SPluginDescriptor>();
		for (PluginDescriptor pluginDescriptor : allOfType.getAll(PluginDescriptor.class)) {
			if (pluginDescriptor.getPluginInterfaceClassName().equals(interfaceClassName)) {
				result.add(bimServer.getSConverter().convertToSObject(pluginDescriptor));
			}
		}
		return result;
	}
}