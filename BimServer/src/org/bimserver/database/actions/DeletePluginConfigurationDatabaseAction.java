package org.bimserver.database.actions;

import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EReference;

public class DeletePluginConfigurationDatabaseAction extends BimDatabaseAction<Void>{

	private long oid;

	public DeletePluginConfigurationDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, long oid) {
		super(databaseSession, accessMethod);
		this.oid = oid;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Void execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		PluginConfiguration pluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), oid, OldQuery.getDefault());
		UserSettings settings = (UserSettings) pluginConfiguration.eGet(pluginConfiguration.eClass().getEStructuralFeature("userSettings"));
		if (settings == null) {
			throw new UserException("No user settings found...");
		}
		for (EReference eReference : settings.eClass().getEAllReferences()) {
			if (eReference.getEType() == pluginConfiguration.eClass() && eReference.isMany()) {
				List list = (List) settings.eGet(eReference);
				list.remove(pluginConfiguration);
			}
		}
		getDatabaseSession().store(settings);
		pluginConfiguration.remove();
		return null;
	} 
}