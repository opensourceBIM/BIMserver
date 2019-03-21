package org.bimserver.database.actions;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;

public class GetAvailableClassesInRevisionDatabaseAction extends BimDatabaseAction<List<String>> {

	private final long roid;

	public GetAvailableClassesInRevisionDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid) {
		super(databaseSession, accessMethod);
		this.roid = roid;
	}

	@Override
	public List<String> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);

		// TODO there are still some situations where there are no oid counters, in those cases this will fail
		
		Set<String> set = new HashSet<>();
		for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
			Map<EClass, Long> updateOidCounters = updateOidCounters(concreteRevision, getDatabaseSession());
			
			set.addAll(updateOidCounters.keySet().stream().map(EClass::getName).collect(Collectors.toSet()));
		}
		return new ArrayList<>(set);
	}
	
	private Map<EClass, Long> updateOidCounters(ConcreteRevision subRevision, DatabaseSession databaseSession) throws BimserverDatabaseException {
		if (subRevision.getOidCounters() != null) {
			Map<EClass, Long> oidCounters = new HashMap<>(subRevision.getOidCounters().length / 8);
			ByteBuffer buffer = ByteBuffer.wrap(subRevision.getOidCounters());
			buffer.order(ByteOrder.LITTLE_ENDIAN);
			for (int i=0; i<buffer.capacity() / 8; i++) {
				long oid = buffer.getLong();
				EClass eClass = databaseSession.getEClass((short)oid);
				oidCounters.put(eClass, oid);
			}
			return oidCounters;
		}
		return null;
	}
}