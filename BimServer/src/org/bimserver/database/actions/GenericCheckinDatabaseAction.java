package org.bimserver.database.actions;

import java.util.Arrays;
import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.shared.UserException;

public abstract class GenericCheckinDatabaseAction extends BimDatabaseAction<ConcreteRevision>{

	private final IfcModelInterface model;

	public GenericCheckinDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, IfcModelInterface model) {
		super(bimDatabaseSession, accessMethod);
		this.model = model;
	}

	protected void checkCheckSum(Project project) throws UserException {
		if (!project.getConcreteRevisions().isEmpty()) {
			ConcreteRevision concreteRevision = project.getConcreteRevisions().get(project.getConcreteRevisions().size()-1);
			if (concreteRevision.getState() == CheckinState.ERROR) {
				// When in error state, user usually tries the same file again, this should not give the 'duplicate model' error
				return;
			}
			byte[] revisionChecksum = concreteRevision.getChecksum();
			if (revisionChecksum != null && getModel().getChecksum() != null) {
				if (Arrays.equals(revisionChecksum, getModel().getChecksum())) {
					throw new UserException("Uploaded model is the same as last revision (" + (1+project.getConcreteRevisions().indexOf(concreteRevision)) + ") duplicate model not stored");
				}
			}
		}
	}
	
	public ConcreteRevision createNewConcreteRevision(BimDatabaseSession session, long size, long poid, long uoid, String comment, CheckinState checkinState) throws BimDatabaseException, BimDeadlockException {
		ConcreteRevision concreteRevision = StoreFactory.eINSTANCE.createConcreteRevision();
		concreteRevision.setSize(size);
		Date date = new Date();
		concreteRevision.setDate(date);
		Project project = getProjectByPoid(poid);
		concreteRevision.setId(project.getConcreteRevisions().size() + 1);
		User user = getUserByUoid(uoid);
		concreteRevision.setProject(project);
		concreteRevision.setState(checkinState);
		createNewVirtualRevision(session, project, concreteRevision, comment, date, user, size, checkinState);

		for (Checkout checkout : project.getCheckouts()) {
			if (checkout.getUser() == user) {
				checkout.setActive(false);
				session.store(checkout);
			}
		}

		Project parent = project.getParent();
		while (parent != null) {
			Revision revision = StoreFactory.eINSTANCE.createRevision();
			revision.setComment(comment);
			revision.setDate(date);
			revision.setUser(user);
			revision.setProject(parent);
			revision.setState(checkinState);
			if (parent.getLastRevision() != null) {
				Revision lastRevision = parent.getLastRevision();
				for (ConcreteRevision oldRevision : lastRevision.getConcreteRevisions()) {
					if (oldRevision.getProject() != project && oldRevision.getProject() != parent) {
						revision.getConcreteRevisions().add(oldRevision);
						revision.setSize(revision.getSize() + oldRevision.getSize());
						session.store(revision);
					}
					session.store(oldRevision);
				}
			}
			revision.getConcreteRevisions().add(concreteRevision);
			revision.setSize(revision.getSize() + concreteRevision.getSize());
			revision.setLastConcreteRevision(concreteRevision);
			if (parent.getLastRevision() == null) {
				revision.setId(1);
			} else {
				revision.setId(parent.getLastRevision().getId() + 1);
			}
			parent.setLastRevision(revision);
			session.store(revision);
			session.store(parent);
			parent = parent.getParent();
		}
		session.store(project);
		session.store(user);
		session.store(concreteRevision);
		return concreteRevision;
	}

	private void createNewVirtualRevision(BimDatabaseSession session, Project project, ConcreteRevision revision, String comment, Date date, User user, long size, CheckinState checkinState)
			throws BimDeadlockException, BimDatabaseException {
		Revision virtualRevision = StoreFactory.eINSTANCE.createRevision();
		virtualRevision.setLastConcreteRevision(revision);
		virtualRevision.setComment(comment);
		virtualRevision.setDate(date);
		virtualRevision.setUser(user);
		virtualRevision.setSize(size);
		virtualRevision.setState(checkinState);
		virtualRevision.setId(project.getRevisions().size() + 1);
		virtualRevision.getConcreteRevisions().add(revision);
		virtualRevision.setProject(project);
		session.store(virtualRevision);
	}

	public IfcModelInterface getModel() {
		return model;
	}
}