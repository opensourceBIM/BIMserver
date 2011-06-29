package org.bimserver.database.actions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.conditions.IsOfTypeCondition;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.UserException;
import org.bimserver.utils.CollectionUtils;

public class GetAllSerializersDatabaseAction extends GetAllDatabaseAction<Serializer> {

	private final boolean onlyEnabled;
	private final BimServer bimServer;

	public GetAllSerializersDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, BimServer bimServer, boolean onlyEnabled) {
		super(bimDatabaseSession, accessMethod, Serializer.class, StorePackage.eINSTANCE.getSerializer());
		this.bimServer = bimServer;
		this.onlyEnabled = onlyEnabled;
	}

	@Override
	public List<Serializer> execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Condition condition = new IsOfTypeCondition(StorePackage.eINSTANCE.getSerializer());
		Map<Long, Serializer> result = getDatabaseSession().query(condition, Serializer.class, false);
		List<Serializer> mapToList = CollectionUtils.mapToList(result);
		if (onlyEnabled) {
			Iterator<Serializer> iterator = mapToList.iterator();
			while (iterator.hasNext()) {
				Serializer serializer = iterator.next();
				if (!bimServer.getPluginManager().isEnabled(serializer.getClassName())) {
					iterator.remove();
				}
			}
		}
		return mapToList;
	}
}