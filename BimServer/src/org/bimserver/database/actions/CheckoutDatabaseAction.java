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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class CheckoutDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long roid;
	private int progress;
	private Authorization authorization;

	public CheckoutDatabaseAction(DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long roid) {
		super(databaseSession, accessMethod);
		this.authorization = authorization;
		this.roid = roid;
	}

	@Override
	public IfcModel execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		User user = getUserByUoid(authorization.getUoid());
		Revision revision = getVirtualRevision(roid);
		Project project = revision.getProject();
		if (user.getHasRightsOn().contains(project)) {
			for (Checkout checkout : revision.getCheckouts()) {
				if (checkout.getRevision() == revision && checkout.getUser() == user && checkout.getActive()) {
					throw new UserException("This revision has already been checked out by you on " + dateFormat.format(checkout.getDate()));
				}
			}
			for (Checkout checkout : project.getCheckouts()) {
				if (checkout.getUser() == user && checkout.getActive()) {
					checkout.setActive(false);
					Checkout newCheckout = StoreFactory.eINSTANCE.createCheckout();
					newCheckout.setActive(true);
					newCheckout.setDate(new Date());
					newCheckout.setUser(user);
					newCheckout.setProject(project);
					newCheckout.setRevision(revision);
					getDatabaseSession().store(checkout);
					getDatabaseSession().store(newCheckout);
					getDatabaseSession().store(project);
					return realCheckout(project, revision, getDatabaseSession(), user);
				}
			}
			Checkout checkout = StoreFactory.eINSTANCE.createCheckout();
			checkout.setActive(true);
			checkout.setDate(new Date());
			checkout.setUser(user);
			checkout.setProject(project);
			checkout.setRevision(revision);
			getDatabaseSession().store(checkout);
			getDatabaseSession().store(project);
			return realCheckout(project, revision, getDatabaseSession(), user);
		} else {
			throw new UserException("Insufficient rights to checkout this project");
		}
	}

	private IfcModel realCheckout(Project project, Revision revision, DatabaseSession databaseSession, User user) throws BimserverLockConflictException, BimserverDatabaseException {
		final long totalSize = revision.getSize();
		final AtomicLong total = new AtomicLong();
		IfcModel ifcModel = new IfcModel();
		ifcModel.addChangeListener(new IfcModelChangeListener() {
			@Override
			public void objectAdded() {
				total.incrementAndGet();
				progress = Math.round(100L * total.get() / totalSize);
			}
		});
		databaseSession.getMap(ifcModel, project.getId(), revision.getLastConcreteRevision().getId(), true, null);
		ifcModel.setName(project.getName() + "." + revision.getId());
		ifcModel.setRevisionNr(project.getRevisions().indexOf(revision) + 1);
		ifcModel.setAuthorizedUser(user.getName());
		ifcModel.setDate(new Date());
		return ifcModel;
	}
	
	public int getProgress() {
		return progress;
	}
}