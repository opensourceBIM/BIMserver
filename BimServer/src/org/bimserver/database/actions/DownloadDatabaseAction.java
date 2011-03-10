package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.log.AccessMethod;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.Merger;
import org.bimserver.rights.RightsManager;
import org.bimserver.settings.ServerSettings;
import org.bimserver.shared.UserException;

public class DownloadDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long roid;
	private final long actingUoid;

	public DownloadDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.roid = roid;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute() throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = getVirtualRevision(roid);
		if (revision == null) {
			throw new UserException("Revision with oid " + roid + " not found");
		}
		Project project = revision.getProject();
		User user = getUserByUoid(actingUoid);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		IfcModelSet ifcModelSet = new IfcModelSet();
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			IfcModel subModel = getDatabaseSession().getMap(subRevision.getProject().getId(), subRevision.getId(), true);
			subModel.setDate(subRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModel ifcModel = new Merger().merge(revision.getProject(), ifcModelSet, ServerSettings.getSettings().isIntelligentMerging());
		ifcModel.setRevisionNr(project.getRevisions().indexOf(revision) + 1);
		ifcModel.setAuthorizedUser(user.getName());
		ifcModel.setDate(revision.getDate());

		if (revision.getProject().getGeoTag() != null) {
//			ifcModel.setLon(revision.getProject().getGeoTag().getX());
//			ifcModel.setLat(revision.getProject().getGeoTag().getY());
//			ifcModel.setAltitude((int) revision.getProject().getGeoTag().getZ());
//			ifcModel.setDirectionAngle(revision.getProject().getGeoTag().getDirectionAngle());
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
			// 	LOGGER.error("", e);
			// } catch (FactoryException e) {
			// 	LOGGER.error("", e);
			// } catch (MismatchedDimensionException e) {
			// 	LOGGER.error("", e);
			// } catch (TransformException e) {
			// 	LOGGER.error("", e);
			// }
		}
		return ifcModel;
	}
}