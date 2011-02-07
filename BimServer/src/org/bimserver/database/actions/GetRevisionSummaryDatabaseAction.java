package org.bimserver.database.actions;

import java.util.Map;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.bimserver.shared.SRevisionSummary;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;

public class GetRevisionSummaryDatabaseAction extends BimDatabaseAction<SRevisionSummary> {

	private final long roid;

	public GetRevisionSummaryDatabaseAction(AccessMethod accessMethod, long roid) {
		super(accessMethod);
		this.roid = roid;
	}

	@Override
	public SRevisionSummary execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		SRevisionSummary revisionSummary = new SRevisionSummary();
		Revision revision = bimDatabaseSession.getVirtualRevision(roid);
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			for (EClass eClass : bimDatabaseSession.getClasses()) {
				int count = bimDatabaseSession.getCount(eClass, new IfcModel(), subRevision.getProject().getId(), subRevision.getId());
				add(revisionSummary, eClass, count);
			}
		}
		return revisionSummary;
	}
	
	public void add(SRevisionSummary sRevisionSummary, EClass eClass, int count) {
		if (count == 0) {
			return;
		}
		Map<String, Integer> subMap = null;
		if (Ifc2x3Package.eINSTANCE.getIfcObject().isSuperTypeOf(eClass)) {
			subMap = sRevisionSummary.getMap().get("IFC Entities");
		} else if (Ifc2x3Package.eINSTANCE.getIfcRelationship().isSuperTypeOf(eClass)) {
			subMap = sRevisionSummary.getMap().get("IFC Relations");
		} else if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(eClass)) {
			subMap = sRevisionSummary.getMap().get("IFC Primitives");
		} else {
			subMap = sRevisionSummary.getMap().get("Rest");
		}
		if (subMap.containsKey(eClass.getName())) {
			subMap.put(eClass.getName(), subMap.get(eClass.getName()) + count);
		} else {
			subMap.put(eClass.getName(), count);
		}
	}
}