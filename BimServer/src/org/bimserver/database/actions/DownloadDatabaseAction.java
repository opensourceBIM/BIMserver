package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.GeometryGeneratingException;
import org.bimserver.ServerIfcModel;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.plugins.IfcModelSet;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.modelmerger.MergeException;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.Authorization;
import org.eclipse.emf.common.util.EList;

public class DownloadDatabaseAction extends AbstractDownloadDatabaseAction<IfcModelInterface> {

	private final long roid;
	private final ObjectIDM objectIDM;
	private final long ignoreUoid;
	private long serializerOid;

	public DownloadDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long roid, long ignoreUoid, long serializerOid, Authorization authorization,
			ObjectIDM objectIDM) {
		super(bimServer, databaseSession, accessMethod, authorization);
		this.roid = roid;
		this.ignoreUoid = ignoreUoid;
		this.serializerOid = serializerOid;
		this.objectIDM = objectIDM;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException, ServerException {
		Revision revision = getRevisionByRoid(roid);
		PluginConfiguration serializerPluginConfiguration = getDatabaseSession().get(StorePackage.eINSTANCE.getPluginConfiguration(), serializerOid, Query.getDefault());
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
		EList<ConcreteRevision> concreteRevisions = revision.getConcreteRevisions();
		if (concreteRevisions.size() == 0) {
			throw new ServerException("No concrete revisions in revision");
		}
		for (ConcreteRevision subRevision : concreteRevisions) {
			incrSize += subRevision.getSize();
		}
		final long totalSize = incrSize;
		final AtomicLong total = new AtomicLong();
		IfcHeader ifcHeader = null;
		PackageMetaData lastPackageMetaData = null;
		Map<Integer, Long> pidRoidMap = new HashMap<>();
		pidRoidMap.put(project.getId(), roid);
		for (ConcreteRevision concreteRevision : concreteRevisions) {
			if (concreteRevision.getUser().getOid() != ignoreUoid) {
				PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(concreteRevision.getProject().getSchema());
				lastPackageMetaData = packageMetaData;
				IfcModel subModel = new ServerIfcModel(packageMetaData, pidRoidMap, getDatabaseSession());
				ifcHeader = concreteRevision.getIfcHeader();
				int highestStopId = findHighestStopRid(project, concreteRevision);
				Query query = new Query(packageMetaData, concreteRevision.getProject().getId(), concreteRevision.getId(), concreteRevision.getOid(), objectIDM, Deep.YES, highestStopId);
				subModel.addChangeListener(new IfcModelChangeListener() {
					@Override
					public void objectAdded() {
						total.incrementAndGet();
						if (totalSize == 0) {
							setProgress("Preparing download...", 0);
						} else {
							setProgress("Preparing download...", (int) Math.round(100.0 * total.get() / totalSize));
						}
					}
				});
				query.updateOidCounters(concreteRevision, getDatabaseSession());
				getDatabaseSession().getMap(subModel, query);
				if (serializerPluginConfiguration != null) {
					try {
						checkGeometry(serializerPluginConfiguration, getBimServer().getPluginManager(), subModel, project, concreteRevision, revision);
					} catch (GeometryGeneratingException e) {
						throw new UserException(e);
					}
				}
				subModel.getModelMetaData().setDate(concreteRevision.getDate());
				ifcModelSet.add(subModel);
			}
		}
		IfcModelInterface ifcModel = new ServerIfcModel(lastPackageMetaData, pidRoidMap, getDatabaseSession());
		if (ifcModelSet.size() > 1) {
			try {
				ifcModel = getBimServer().getMergerFactory().createMerger(getDatabaseSession(), getAuthorization().getUoid()).merge(revision.getProject(), ifcModelSet, new ModelHelper(getBimServer().getMetaDataManager(), ifcModel));
			} catch (MergeException e) {
				throw new UserException(e);
			}
		} else {
			ifcModel = ifcModelSet.iterator().next();
		}
		if (ifcHeader != null) {
			ifcHeader.load();
			ifcModel.getModelMetaData().setIfcHeader(ifcHeader);
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