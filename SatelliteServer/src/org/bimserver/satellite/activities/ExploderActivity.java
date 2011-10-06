package org.bimserver.satellite.activities;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.client.notifications.NotificationInterfaceAdapter;
import org.bimserver.emf.IdEObject;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.models.ifc2x3.IfcAxis2Placement;
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcLocalPlacement;
import org.bimserver.models.ifc2x3.IfcObjectPlacement;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.satellite.SatelliteServer;
import org.bimserver.shared.exceptions.ServiceException;

public class ExploderActivity extends Activity {
	private static final String COMMENT_TAG = "Exploder";
	
	public void activate(final SatelliteServer satelliteServer) {
		satelliteServer.getBimServerClient().registerNotificationListener(new NotificationInterfaceAdapter(){
			@Override
			public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException {
				SRevision revision = satelliteServer.getBimServerClient().getServiceInterface().getRevision(newRevisionNotification.getRevisionId());
				if (!revision.getComment().contains(COMMENT_TAG)) {
					SProject project = satelliteServer.getBimServerClient().getServiceInterface().getProjectByPoid(revision.getProjectId());
					log("Downloading revision " + revision.getId() + " of project " + project.getName());
					IfcModelInterface model = satelliteServer.getBimServerClient().getModel(newRevisionNotification.getRevisionId());
					Set<IfcCartesianPoint> changed = new HashSet<IfcCartesianPoint>();
					for (IdEObject idEObject : model.getValues()) {
						if (idEObject instanceof IfcObjectPlacement) {
							IfcObjectPlacement ifcObjectPlacement = (IfcObjectPlacement)idEObject;
							for (IfcLocalPlacement ifcLocalPlacement : ifcObjectPlacement.getReferencedByPlacements()) {
								IfcAxis2Placement relativePlacement = ifcLocalPlacement.getRelativePlacement();
								if (relativePlacement instanceof IfcAxis2Placement3D) {
									IfcAxis2Placement3D ifcAxis2Placement3D = (IfcAxis2Placement3D)relativePlacement;
									IfcCartesianPoint ifcCartesianPoint = ifcAxis2Placement3D.getLocation();
									if (!changed.contains(ifcCartesianPoint)) {
										int i=0;
										for (float val : ifcCartesianPoint.getCoordinates()) {
											ifcCartesianPoint.getCoordinates().set(i, val * 1.5f);
										}
										changed.add(ifcCartesianPoint);
									}
								}
							}
						}
					}
					log("Changed " + changed.size() + " IfcCartesianPoints");
					long newRoid = satelliteServer.getBimServerClient().uploadModel(revision.getProjectId(), "Update by " + COMMENT_TAG, model);
					SRevision newRevision = satelliteServer.getBimServerClient().getServiceInterface().getRevision(newRoid);
					log("Checked in new revision " + newRevision.getId() + " for project " + project.getName());
				}
			}
		});
	}

	@Override
	public String getName() {
		return "Exploder";
	}
}