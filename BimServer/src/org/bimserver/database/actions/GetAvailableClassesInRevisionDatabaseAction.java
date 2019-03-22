package org.bimserver.database.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OidCounters;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public class GetAvailableClassesInRevisionDatabaseAction extends BimDatabaseAction<List<String>> {

	private final long roid;
	private BimServer bimServer;

	public GetAvailableClassesInRevisionDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
	}

	@Override
	public List<String> execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);

		EPackage ePackage = bimServer.getMetaDataManager().getPackageMetaData(revision.getProject().getSchema()).getEPackage();
		// TODO there are still some situations where there are no oid counters, in those cases this will fail
		
		Set<String> set = new HashSet<>();
		for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
			OidCounters oidCounters = new OidCounters(getDatabaseSession(), concreteRevision.getOidCounters());
			
			set.addAll(oidCounters.keySet().stream().filter(eClass -> eClass.getEPackage() == ePackage).map(EClass::getName).collect(Collectors.toSet()));
		}
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
	}
}