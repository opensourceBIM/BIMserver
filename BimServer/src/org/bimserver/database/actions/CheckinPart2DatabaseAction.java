package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.CheckinState;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.shared.UserException;

public class CheckinPart2DatabaseAction extends BimDatabaseAction<Void> {

	private final IfcModel ifcModel;
	private final long actingUoid;
	private final long croid;

	public CheckinPart2DatabaseAction(AccessMethod accessMethod, IfcModel ifcModel, long actingUoid, long croid) {
		super(accessMethod);
		this.ifcModel = ifcModel;
		this.actingUoid = actingUoid;
		this.croid = croid;
	}

	@Override
	public Void execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		ConcreteRevision concreteRevision = bimDatabaseSession.getConcreteRevision(croid);
		try {
			if (concreteRevision.getProject().getConcreteRevisions().size() != 0) {
				// There already was a revision, lets delete it
				bimDatabaseSession.clearProject(concreteRevision.getProject().getId(), concreteRevision.getId() - 1, concreteRevision.getId());
			}
			bimDatabaseSession.store(getIfcModel().getValues(), concreteRevision.getProject().getId(), concreteRevision.getId());
			for (Revision revision : concreteRevision.getRevisions()) {
				revision.setState(CheckinState.DONE);
			}
			concreteRevision.setState(CheckinState.DONE);
			bimDatabaseSession.store(concreteRevision);
		} catch (Throwable e) {
			if (e instanceof BimDeadlockException) {
				// Let this one slide
				throw (BimDeadlockException)e;
			}
			for (Revision revision : concreteRevision.getRevisions()) {
				revision.setState(CheckinState.ERROR);
				revision.setLastError(e.getMessage());
			}
			throw new UserException(e);
		}
		return null;
	}

	public IfcModel getIfcModel() {
		return ifcModel;
	}

	public long getActingUid() {
		return actingUoid;
	}

	public long getCroid() {
		return croid;
	}
}