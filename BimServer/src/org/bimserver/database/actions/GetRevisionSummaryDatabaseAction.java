package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.SRevisionSummary;
import org.bimserver.shared.SRevisionSummaryContainer;
import org.bimserver.shared.UserException;
import org.eclipse.emf.ecore.EClass;

public class GetRevisionSummaryDatabaseAction extends BimDatabaseAction<SRevisionSummary> {

	private final long roid;

	public GetRevisionSummaryDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid) {
		super(bimDatabaseSession, accessMethod);
		this.roid = roid;
	}

	@Override
	public SRevisionSummary execute() throws UserException, BimDeadlockException, BimDatabaseException {
		SRevisionSummary revisionSummary = new SRevisionSummary();
		Revision revision = getVirtualRevision(roid);
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			for (EClass eClass : getDatabaseSession().getClasses()) {
				int count = getDatabaseSession().getCount(eClass, new IfcModel(), subRevision.getProject().getId(), subRevision.getId());
				add(revisionSummary, eClass, count);
			}
		}
		return revisionSummary;
	}
	
	public void add(SRevisionSummary sRevisionSummary, EClass eClass, int count) {
		if (count == 0) {
			return;
		}
		SRevisionSummaryContainer subMap = null;
		if (Ifc2x3Package.eINSTANCE.getIfcObject().isSuperTypeOf(eClass)) {
			subMap = sRevisionSummary.get("IFC Entities");
		} else if (Ifc2x3Package.eINSTANCE.getIfcRelationship().isSuperTypeOf(eClass)) {
			subMap = sRevisionSummary.get("IFC Relations");
		} else if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(eClass)) {
			subMap = sRevisionSummary.get("IFC Primitives");
		} else {
			subMap = sRevisionSummary.get("Rest");
		}
		subMap.increment(eClass.getName(), count);
	}
}