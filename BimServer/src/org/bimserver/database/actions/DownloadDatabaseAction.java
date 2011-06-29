package org.bimserver.database.actions;

import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.IfcModelChangeListener;
import org.bimserver.ifc.IfcModelSet;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.rights.RightsManager;
import org.bimserver.shared.UserException;

public class DownloadDatabaseAction extends BimDatabaseAction<IfcModelInterface> {

	private final long roid;
	private final long actingUoid;
	private int progress;
	private final BimServer bimServer;

	public DownloadDatabaseAction(BimServer bimServer, BimDatabaseSession bimDatabaseSession, AccessMethod accessMethod, long roid, long actingUoid) {
		super(bimDatabaseSession, accessMethod);
		this.bimServer = bimServer;
		this.roid = roid;
		this.actingUoid = actingUoid;
	}

	@Override
	public IfcModelInterface execute() throws UserException, BimDeadlockException, BimDatabaseException {
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
					if (totalSize == 0) {
						progress = 0;
					} else {
						progress = Math.round(100L * total.get() / totalSize);
					}
				}
			});
			getDatabaseSession().getMap(subModel, subRevision.getProject().getId(), subRevision.getId(), true);
			subModel.setDate(subRevision.getDate());
			ifcModelSet.add(subModel);
		}
		IfcModelInterface ifcModel = bimServer.getMergerFactory().createMerger().merge(revision.getProject(), ifcModelSet, bimServer.getSettingsManager().getSettings().isIntelligentMerging());
		ifcModel.setName(project.getName() + "." + revision.getId());
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