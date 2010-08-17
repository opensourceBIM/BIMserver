package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.shared.UserException;
import org.eclipse.emf.common.util.EList;

public class SetRevisionTagDatabaseAction extends BimDatabaseAction<String> {
	private final Long roid;
	private final String tag;

	public SetRevisionTagDatabaseAction(AccessMethod accessMethod, Long roid, String tag) {
		super(accessMethod);
		this.roid = roid;
		this.tag = tag;
	}

	@Override
	public String execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = bimDatabaseSession.getRevisionByRoid(roid);
		Project project = revision.getProject();
		if (project.getParent() != null) {
			throw new UserException("Revision is not contained by a top project.");
		}
		EList<Revision> projRevs = project.getRevisions();
		revision.setTag(tag);
		bimDatabaseSession.store(revision, new CommitSet(Database.STORE_PROJECT_ID, -1));
		EList<ConcreteRevision> concreteRevisions = revision.getConcreteRevisions();
		for (ConcreteRevision cRev : concreteRevisions) {
			EList<Revision> revisions = cRev.getRevisions();
			for (Revision vRev : revisions) {
				if (projRevs.contains(vRev)) {
					continue;
				}
				vRev.setTag(tag);
				bimDatabaseSession.store(vRev, new CommitSet(Database.STORE_PROJECT_ID, -1));
			}
		}
		return null;
	}

}
