package org.bimserver.database.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.CommitSet;
import org.bimserver.database.Database;
import org.bimserver.database.store.Checkout;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.StoreFactory;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.shared.UserException;

public class CheckoutDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long uoid;
	private final long roid;

	public CheckoutDatabaseAction(AccessMethod accessMethod, long uoid, long roid) {
		super(accessMethod);
		this.uoid = uoid;
		this.roid = roid;
	}

	@Override
	public IfcModel execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDatabaseException, BimDeadlockException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		User user = bimDatabaseSession.getUserByUoid(uoid);
		Revision revision = bimDatabaseSession.getVirtualRevision(roid);
		Project project = revision.getProject();
		if (user.getHasRightsOn().contains(project)) {
			for (Checkout checkout : revision.getCheckouts()) {
				if (checkout.getRevision() == revision && checkout.getUser() == user && checkout.isActive()) {
					throw new UserException("This revision has already been checked out by you on " + dateFormat.format(checkout.getDate()));
				}
			}
			CommitSet commitSet = new CommitSet(Database.STORE_PROJECT_ID, -1);
			for (Checkout checkout : project.getCheckouts()) {
				if (checkout.getUser() == user && checkout.isActive()) {
					checkout.setActive(false);
					Checkout newCheckout = StoreFactory.eINSTANCE.createCheckout();
					newCheckout.setActive(true);
					newCheckout.setDate(new Date());
					newCheckout.setUser(user);
					newCheckout.setProject(project);
					newCheckout.setRevision(revision);
					bimDatabaseSession.store(checkout, commitSet);
					bimDatabaseSession.store(newCheckout, commitSet);
					bimDatabaseSession.saveOidCounter();
					return realCheckout(project, revision, bimDatabaseSession, user);
				}
			}
			Checkout checkout = StoreFactory.eINSTANCE.createCheckout();
			checkout.setActive(true);
			checkout.setDate(new Date());
			checkout.setUser(user);
			checkout.setProject(project);
			checkout.setRevision(revision);
			bimDatabaseSession.store(checkout, commitSet);
			bimDatabaseSession.saveOidCounter();
			return realCheckout(project, revision, bimDatabaseSession, user);
		} else {
			throw new UserException("Insufficient rights to checkout this project");
		}
	}

	private IfcModel realCheckout(Project project, Revision revision, BimDatabaseSession bimDatabaseSession, User user) throws BimDeadlockException, BimDatabaseException {
		IfcModel IfcModel = new IfcModel(bimDatabaseSession.getMap(project.getId(), revision.getLastConcreteRevision().getId()).getMap());
		IfcModel.setRevisionNr(project.getRevisions().indexOf(revision) + 1);
		IfcModel.setAuthorizedUser(user.getName());
		IfcModel.setDate(new Date());
		return IfcModel;
	}
}