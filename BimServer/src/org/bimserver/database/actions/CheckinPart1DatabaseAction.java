package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.store.CheckinState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.exceptions.UserException;

public class CheckinPart1DatabaseAction extends GenericCheckinDatabaseAction {

	private final long actingUid;
	private final String comment;
	private final long poid;
	private ConcreteRevision concreteRevision;

	public CheckinPart1DatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long poid, long actingUid, IfcModelInterface model, String comment) {
		super(bimDatabaseSession, accessMethod, model);
		this.poid = poid;
		this.actingUid = actingUid;
		this.comment = comment;
	}

	@Override
	public ConcreteRevision execute() throws UserException, BimDeadlockException, BimDatabaseException {
		try {
			Project project = getProjectByPoid(poid);
			User user = getUserByUoid(actingUid);
			if (project == null) {
				throw new UserException("Project with poid " + poid + " not found");
			}
			if (!RightsManager.hasRightsOnProjectOrSuperProjects(user, project)) {
				throw new UserException("User has no rights to checkin models to this project");
			}
			if (!MailSystem.isValidEmailAddress(user.getUsername())) {
				throw new UserException("Users must have a valid e-mail address to checkin");
			}
			if (getModel() != null) {
				checkCheckSum(project);
			}
			if (!project.getRevisions().isEmpty() && project.getRevisions().get(project.getRevisions().size() - 1).getState() == CheckinState.STORING) {
				throw new UserException("Another checkin on this project is currently running, please wait and try again");
			}
			concreteRevision = createNewConcreteRevision(getDatabaseSession(), getModel() == null ? 0 : getModel().getSize(), poid, actingUid, comment.trim(), CheckinState.STORING);
			if (getModel() != null) {
				concreteRevision.setChecksum(getModel().getChecksum());
			}
			NewRevisionAdded newRevisionAdded = LogFactory.eINSTANCE.createNewRevisionAdded();
			newRevisionAdded.setDate(new Date());
			newRevisionAdded.setExecutor(user);
			newRevisionAdded.setRevision(concreteRevision.getRevisions().get(0));
			newRevisionAdded.setAccessMethod(getAccessMethod());
			getDatabaseSession().store(newRevisionAdded);
			getDatabaseSession().store(concreteRevision);
			getDatabaseSession().store(project);
			return concreteRevision;
		} catch (UserException e) {
			throw e;
		} catch (Throwable e) {
			throw new UserException(e);
		}
	}

	public ConcreteRevision getConcreteRevision() {
		return concreteRevision;
	}

	public Revision getRevision() {
		return concreteRevision.getRevisions().get(0);
	}
}