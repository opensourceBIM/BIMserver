package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OldQuery.Deep;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class CheckoutDatabaseAction extends AbstractDownloadDatabaseAction<IfcModel> {

	private final long roid;
	private long serializerOid;

	public CheckoutDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, Authorization authorization, long roid, long serializerOid) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roid = roid;
		this.serializerOid = serializerOid;
	}

	@Override
	public IfcModel execute() throws UserException, BimserverDatabaseException, BimserverLockConflictException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		User user = getUserByUoid(getAuthorization().getUoid());
		Revision revision = getRevisionByRoid(roid);
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
					Checkout newCheckout = getDatabaseSession().create(Checkout.class);
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
			Checkout checkout = getDatabaseSession().create(Checkout.class);
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

	private IfcModel realCheckout(Project project, Revision revision, DatabaseSession databaseSession, User user) throws BimserverLockConflictException, BimserverDatabaseException, UserException {
		PluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), serializerOid, OldQuery.getDefault());
		final long totalSize = revision.getSize();
		final AtomicLong total = new AtomicLong();
		
		IfcModelSet ifcModelSet = new IfcModelSet();
		PackageMetaData lastPackageMetaData = null;
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(subRevision.getProject().getSchema());
			lastPackageMetaData = packageMetaData;
			IfcModel subModel = new BasicIfcModel(packageMetaData, null);
			int highestStopId = findHighestStopRid(project, subRevision);
			OldQuery query = new OldQuery(packageMetaData, subRevision.getProject().getId(), subRevision.getId(), revision.getOid(), Deep.YES, highestStopId);
			subModel.addChangeListener(new IfcModelChangeListener() {
				@Override
				public void objectAdded(IdEObject idEObject) {
					total.incrementAndGet();
					if (totalSize == 0) {
						setProgress("Preparing checkout...", 0);
					} else {
						setProgress("Preparing checkout...", (int)Math.round(100.0 * total.get() / totalSize));
					}
				}
			});
			getDatabaseSession().getMap(subModel, query);
			try {
				checkGeometry(serializerPluginConfiguration, getBimServer().getPluginManager(), subModel, project, subRevision, revision);
			} catch (GeometryGeneratingException e) {
				throw new UserException(e);
			}
			subModel.getModelMetaData().setDate(subRevision.getDate());
			ifcModelSet.add(subModel);
		}
		
		IfcModelInterface ifcModel = new BasicIfcModel(lastPackageMetaData, null);
		if (ifcModelSet.size() > 1) {
			try {
				ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid())
						.merge(revision.getProject(), ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
			} catch (MergeException e) {
				throw new UserException(e);
			}
		} else {
			ifcModel = ifcModelSet.iterator().next();
		}
		
		ifcModel.getModelMetaData().setName(project.getName() + "." + revision.getId());
		ifcModel.getModelMetaData().setRevisionId(project.getRevisions().indexOf(revision) + 1);
		ifcModel.getModelMetaData().setAuthorizedUser(user.getName());
		ifcModel.getModelMetaData().setDate(new Date());
		return (IfcModel) ifcModel;
	}
}