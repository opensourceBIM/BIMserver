package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;

public class DownloadDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private final long roid;
	private final BimServer bimServer;
	private final ObjectIDM objectIDM;
	private final long ignoreUoid;
	private long serializerOid;

	public DownloadDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long ignoreUoid, long serializerOid, Authorization authorization,
			ObjectIDM objectIDM, Reporter reporter) {
		super(databaseSession, accessMethod, authorization);
		this.bimServer = bimServer;
		this.roid = roid;
		this.ignoreUoid = ignoreUoid;
		this.serializerOid = serializerOid;
		this.objectIDM = objectIDM;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getRevisionByRoid(roid);
		SerializerPluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), serializerOid, Query.getDefault());
		getAuthorization().canDownload(roid);
		if (revision == null) {
			throw new UserException("Revision with oid " + roid + " not found");
		}
		Project project = revision.getProject();
		User user = getUserByUoid(getAuthorization().getUoid());
		try {
			getAuthorization().canDownload(roid);
		} catch (UserException e) {
			if (!getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
				throw new UserException("User has insufficient rights to download revisions from this project");
			}
		}
		IfcModelSet ifcModelSet = new IfcModelSet();
		long incrSize = 0;
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			incrSize += subRevision.getSize();
		}
		final long totalSize = incrSize;
		final AtomicLong total = new AtomicLong();
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			if (subRevision.getUser().getOid() != ignoreUoid) {
				IfcModel subModel = new IfcModel();
				int highestStopId = findHighestStopRid(project, subRevision);
				Query query = new Query(subRevision.getProject().getId(), subRevision.getId(), objectIDM, Deep.YES, highestStopId);
				subModel.addChangeListener(new IfcModelChangeListener() {
					@Override
					public void objectAdded() {
						total.incrementAndGet();
						if (totalSize == 0) {
							setProgress("Preparing download...", 0);
						} else {
							setProgress("Preparing download...", Math.round(100L * total.get() / totalSize));
						}
					}
				});
				getDatabaseSession().getMap(subModel, query);
				checkGeometry(serializerPluginConfiguration, bimServer.getPluginManager(), subModel, project, subRevision, revision);
				subModel.getModelMetaData().setDate(subRevision.getDate());
				ifcModelSet.add(subModel);
			}
		}
		IfcModelInterface ifcModel;
		if (ifcModelSet.size() > 1) {
			try {
				ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid())
						.merge(revision.getProject(), ifcModelSet, new ModelHelper());
			} catch (MergeException e) {
				throw new UserException(e);
			}
		} else {
			ifcModel = ifcModelSet.iterator().next();
		}
		ifcModel.getModelMetaData().setName(project.getName() + "." + revision.getId());
		ifcModel.getModelMetaData().setRevisionId(project.getRevisions().indexOf(revision) + 1);
		if (user != null) {
			ifcModel.getModelMetaData().setAuthorizedUser(user.getName());
		}
		ifcModel.getModelMetaData().setDate(revision.getDate());

		if (revision.getProject().getGeoTag() != null) {
			// ifcModel.setLon(revision.getProject().getGeoTag().getX());
			// ifcModel.setLat(revision.getProject().getGeoTag().getY());
			// ifcModel.setAltitude((int)
			// revision.getProject().getGeoTag().getZ());
			// ifcModel.setDirectionAngle(revision.getProject().getGeoTag().getDirectionAngle());
			// try {
			// CoordinateReferenceSystem sourceCRS = CRS.decode("EPSG:" +
			// revision.getProject().getGeoTag().getEpsg());
			// CoordinateReferenceSystem targetCRS =
			// DefaultGeocentricCRS.CARTESIAN;
			// MathTransform transform = CRS.findMathTransform(sourceCRS,
			// targetCRS, true);
			// float[] in = new
			// float[]{revision.getProject().getGeoTag().getX1(),
			// revision.getProject().getGeoTag().getY1(),
			// revision.getProject().getGeoTag().getZ1()};
			// float[] result = new float[3];
			// transform.transform(in, 0, result, 0, 1);
			// IfcModel.setLon(result[0]);
			// IfcModel.setLat(result[1]);
			// } catch (NoSuchAuthorityCodeException e) {
			// LOGGER.error("", e);
			// } catch (FactoryException e) {
			// LOGGER.error("", e);
			// } catch (MismatchedDimensionException e) {
			// LOGGER.error("", e);
			// } catch (TransformException e) {
			// LOGGER.error("", e);
			// }
		}
		return ifcModel;
	}
}