package org.bimserver.database.actions;

import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.SettingsManager;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.merging.Merger;
import org.bimserver.merging.Merger.GuidMergeIdentifier;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadDatabaseAction extends BimDatabaseAction<IfcModel> {

	private final long roid;
	private final long actingUoid;
	private int progress;
	private final SettingsManager settingsManager;

	public DownloadDatabaseAction(BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, SettingsManager settingsManager, long roid, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.settingsManager = settingsManager;
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
		long incrSize = 0;
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			incrSize += subRevision.getSize();
		}
		final long totalSize = incrSize;
		final AtomicLong total = new AtomicLong();
		for (ConcreteRevision subRevision : revision.getConcreteRevisions()) {
			IfcModel subModel = new IfcModel();
			subModel.addChangeListener(new IfcModelChangeListener() {
				@Override
				public void objectAdded() {
					total.incrementAndGet();
					progress = Math.round(100L * total.get() / totalSize);
				}
			});
			getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true);
			subModel.setDate(subRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModel ifcModel = new Merger(new GuidMergeIdentifier()).merge(revision.getProject(), ifcModelSet, settingsManager.getSettings().isIntelligentMerging());
		ifcModel.setRevisionNr(project.getRevisions().indexOf(revision) + 1);
		ifcModel.setAuthorizedUser(user.getName());
		ifcModel.setDate(revision.getDate());

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

	public int getProgress() {
		return progress;
	}
}