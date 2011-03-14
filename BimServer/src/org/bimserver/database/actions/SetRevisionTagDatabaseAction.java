package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.shared.UserException;
import org.eclipse.emf.common.util.EList;

public class SetRevisionTagDatabaseAction extends BimDatabaseAction<String> {
	private final Long roid;
	private final String tag;

	public SetRevisionTagDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, Long roid, String tag) {
		super(bimDatabaseSession, accessMethod);
		this.roid = roid;
		this.tag = tag;
	}

	@Override
	public String execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		String trimmedTag = tag.trim();
		Project project = revision.getProject();
		if (project.getParent() != null) {
			throw new UserException("Revision is not contained by a top project.");
		}
		EList<Revision> projRevs = project.getRevisions();
		revision.setTag(trimmedTag);
		getDatabaseSession().store(revision);
		EList<ConcreteRevision> concreteRevisions = revision.getConcreteRevisions();
		for (ConcreteRevision cRev : concreteRevisions) {
			EList<Revision> revisions = cRev.getRevisions();
			for (Revision vRev : revisions) {
				if (projRevs.contains(vRev)) {
					continue;
				}
				vRev.setTag(trimmedTag);
				getDatabaseSession().store(vRev);
			}
		}
		return null;
	}
}