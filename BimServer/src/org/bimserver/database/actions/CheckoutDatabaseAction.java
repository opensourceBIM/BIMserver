package org.bimserver.database.actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.shared.UserException;

public class CheckoutDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long uoid;
	private final long roid;
	private int progress;

	public CheckoutDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long uoid, long roid) {
		super(bimDatabaseSession, accessMethod);
		this.uoid = uoid;
		this.roid = roid;
	}

	@Override
	public IfcModel execute() throws UserException, BimDatabaseException, BimDeadlockException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		User user = getUserByUoid(uoid);
		if (user.getUserType() == UserType.ANONYMOUS) {
			throw new UserException("Anonymous user is never allowed to checkout revisions");
		}
		Revision revision = getVirtualRevision(roid);
		Project project = revision.getProject();
		if (user.getHasRightsOn().contains(project)) {
			for (Checkout checkout : revision.getCheckouts()) {
				if (checkout.getRevision() == revision && checkout.getUser() == user && checkout.isActive()) {
					throw new UserException("This revision has already been checked out by you on " + dateFormat.format(checkout.getDate()));
				}
			}
			for (Checkout checkout : project.getCheckouts()) {
				if (checkout.getUser() == user && checkout.isActive()) {
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

	private IfcModel realCheckout(Project project, Revision revision, BimDatabaseSession bimDatabaseSession, User user) throws BimDeadlockException, BimDatabaseException {
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
		bimDatabaseSession.getMap(ifcModel, project.getId(), revision.getLastConcreteRevision().getId(), true);
		ifcModel.setRevisionNr(project.getRevisions().indexOf(revision) + 1);
		ifcModel.setAuthorizedUser(user.getName());
		ifcModel.setDate(new Date());
		return ifcModel;
	}
	
	public int getProgress() {
		return progress;
	}
}