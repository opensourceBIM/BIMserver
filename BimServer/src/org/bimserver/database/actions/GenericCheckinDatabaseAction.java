package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;

public abstract class GenericCheckinDatabaseAction extends BimDatabaseAction<ConcreteRevision>{

	private final IfcModelInterface model;

	public static class CreateRevisionResult {
		private final List<Revision> revisions = new ArrayList<Revision>();
		private ConcreteRevision concreteRevision;
		
		public void addRevision(Revision revision) {
			this.revisions.add(revision);
		}

		public List<Revision> getRevisions() {
			return revisions;
		}
		
		public void setConcreteRevision(ConcreteRevision concreteRevision) {
			this.concreteRevision = concreteRevision;
		}
		
		public ConcreteRevision getConcreteRevision() {
			return concreteRevision;
		}
	}
	
	public GenericCheckinDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, IfcModelInterface model) {
		super(databaseSession, accessMethod);
		this.model = model;
	}

	protected void checkCheckSum(Project project) throws UserException {
		ConcreteRevision lastConcreteRevision = project.getLastConcreteRevision();
		if (lastConcreteRevision != null) {
			int revisionId = -1;
			for (Revision revision : lastConcreteRevision.getRevisions()) {
				if (revision.getProject() == project) {
					revisionId = revision.getId();
				}
			}
			byte[] revisionChecksum = lastConcreteRevision.getChecksum();
			if (revisionChecksum != null && getModel().getChecksum() != null) {
				if (Arrays.equals(revisionChecksum, getModel().getChecksum())) {
					throw new UserException("Uploaded model is the same as last revision (" + revisionId + "), duplicate model not stored");
				}
			}
		}
	}
	
	public CreateRevisionResult createNewConcreteRevision(DatabaseSession session, long size, Project project, User user, String comment) throws BimserverDatabaseException, BimserverLockConflictException {
		CreateRevisionResult result = new CreateRevisionResult();
		ConcreteRevision concreteRevision = StoreFactory.eINSTANCE.createConcreteRevision();
		concreteRevision.setSize(size);
		Date date = new Date();
		concreteRevision.setDate(date);
		concreteRevision.setId(project.getConcreteRevisions().size() + 1);
		concreteRevision.setUser(user);
		concreteRevision.setProject(project);
		project.setLastConcreteRevision(concreteRevision);
		Revision newRevision = createNewVirtualRevision(session, project, concreteRevision, comment, date, user, size);

		for (Checkout checkout : project.getCheckouts()) {
			if (checkout.getUser() == user) {
				checkout.setActive(false);
				session.store(checkout);
			}
		}

		project.setLastRevision(newRevision);
		Project parent = project.getParent();
		while (parent != null) {
			Revision revision = StoreFactory.eINSTANCE.createRevision();
			result.addRevision(revision);
			revision.setComment("generated for subproject " + project.getName() + ", revision " + concreteRevision.getId() + ", by " + user.getName());
			revision.setDate(date);
			revision.setUser(getSystemUser());
			revision.setProject(parent);
			if (parent.getLastRevision() != null) {
				Revision lastRevision = parent.getLastRevision();
				for (ConcreteRevision oldRevision : lastRevision.getConcreteRevisions()) {
					if (oldRevision.getProject() != project && oldRevision.getProject() != parent) {
						revision.getConcreteRevisions().add(oldRevision);
						revision.setSize((revision.getSize() == null ? 0 : revision.getSize()) + oldRevision.getSize());
						session.store(revision);
					}
					session.store(oldRevision);
				}
			}
			revision.getConcreteRevisions().add(concreteRevision);
			revision.setSize((revision.getSize() == null ? 0 : revision.getSize()) + concreteRevision.getSize());
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
		result.setConcreteRevision(concreteRevision);
		return result;
	}

	private Revision createNewVirtualRevision(DatabaseSession session, Project project, ConcreteRevision concreteRevision, String comment, Date date, User user, long size)
			throws BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = StoreFactory.eINSTANCE.createRevision();
		revision.setLastConcreteRevision(concreteRevision);
		revision.setComment(comment);
		revision.setDate(date);
		revision.setUser(user);
		user.getRevisions().add(revision);
		revision.setSize(size);
		revision.setId(project.getRevisions().size() + 1);
		revision.getConcreteRevisions().add(concreteRevision);
		revision.setProject(project);
		session.store(revision);
		return revision;
	}

	public IfcModelInterface getModel() {
		return model;
	}
}