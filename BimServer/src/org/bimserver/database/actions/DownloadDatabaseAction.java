package org.bimserver.database.actions;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.ConcreteRevision;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.Revision;
import org.bimserver.database.store.User;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long roid;
	private final long actingUoid;

	public DownloadDatabaseAction(AccessMethod accessMethod, long roid, long actingUoid) {
		super(accessMethod);
		this.roid = roid;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModel execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException {
		Revision revision = bimDatabaseSession.getVirtualRevision(roid);
		Project project = revision.getProject();
		User user = bimDatabaseSession.getUserByUoid(actingUoid);
		if (!RightsManager.hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project)) {
			throw new UserException("User has insufficient rights to download revisions from this project");
		}
		IfcModel ifcModel = new IfcModel((int) revision.getSize());
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			merge(subRevision.getProject(), ifcModel, new IfcModel(bimDatabaseSession.getMap(subRevision.getProject().getId(), subRevision.getId()).getMap()));
		}
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
			// e.printStackTrace();
			// } catch (FactoryException e) {
			// e.printStackTrace();
			// } catch (MismatchedDimensionException e) {
			// e.printStackTrace();
			// } catch (TransformException e) {
			// e.printStackTrace();
			// }
		}
		return ifcModel;
	}
}