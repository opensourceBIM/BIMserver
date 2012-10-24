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

import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Geometry;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.Authorization;

public class DownloadDatabaseAction extends BimDatabaseAction<IfcModelInterface> {

	private final long roid;
	private final BimServer bimServer;
	private final ObjectIDM objectIDM;
	private final long ignoreUoid;
	private Authorization authorization;

	public DownloadDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long ignoreUoid, Authorization authorization,
			ObjectIDM objectIDM, Reporter reporter) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.ignoreUoid = ignoreUoid;
		this.authorization = authorization;
		this.objectIDM = objectIDM;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		Revision revision = getVirtualRevision(roid);
		authorization.canDownload(roid);
		if (revision == null) {
			throw new UserException("Revision with oid " + roid + " not found");
		}
		Project project = revision.getProject();
		User user = getUserByUoid(authorization.getUoid());
		if (!authorization.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
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
				subModel.addChangeListener(new IfcModelChangeListener() {
					@Override
					public void objectAdded() {
						total.incrementAndGet();
						if (totalSize == 0) {
							setProgress(0);
						} else {
							setProgress(Math.round(100L * total.get() / totalSize));
						}
					}
				});
				getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true, objectIDM);
				for (IfcProduct ifcProduct : subModel.getAllWithSubTypes(IfcProduct.class)) {
					GeometryInstance geometryInstance = ifcProduct.getGeometryInstance();
					if (geometryInstance != null) {
						geometryInstance.load();
						geometryInstance.getBounds().load();
						geometryInstance.getBounds().getMin().load();
						geometryInstance.getBounds().getMax().load();
					}
				}
				subModel.setDate(subRevision.getDate());
				ifcModelSet.add(subModel);
			}
		}
		IfcModelInterface ifcModel;
		try {
			ifcModel = bimServer.getMergerFactory().createMerger(getDatabaseSession(), authorization.getUoid())
					.merge(revision.getProject(), ifcModelSet, new ModelHelper());
		} catch (MergeException e) {
			throw new UserException(e);
		}
		ifcModel.setName(project.getName() + "." + revision.getId());
		ifcModel.setRevisionNr(project.getRevisions().indexOf(revision) + 1);
		ifcModel.setAuthorizedUser(user.getName());
		ifcModel.setDate(revision.getDate());
		Geometry geometry = revision.getGeometry();
		if (geometry != null) {
			geometry.load();
			ifcModel.setGeometry(geometry);
		}
		for (IfcProduct ifcProduct : ifcModel.getAllWithSubTypes(IfcProduct.class)) {
			GeometryInstance geometryInstance = ifcProduct.getGeometryInstance();
			if (geometryInstance != null) {
				geometryInstance.load();
			}
		}

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