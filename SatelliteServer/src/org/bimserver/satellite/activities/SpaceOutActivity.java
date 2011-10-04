package org.bimserver.satellite.activities;

import org.bimserver.client.notifications.NotificationInterfaceAdapter;
import org.bimserver.emf.IdEObject;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.models.ifc2x3.IfcAxis2Placement;
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcLocalPlacement;
import org.bimserver.models.ifc2x3.IfcObjectPlacement;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.satellite.SatelliteServer;
import org.bimserver.shared.exceptions.ServiceException;

public class SpaceOutActivity extends Activity {
	public void activate(final SatelliteServer satelliteServer) {
		satelliteServer.getBimServerClient().registerNotificationListener(new NotificationInterfaceAdapter(){
			@Override
			public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException {
				SRevision revision = satelliteServer.getBimServerClient().getServiceInterface().getRevision(newRevisionNotification.getRevisionId());
				IfcModelInterface model = satelliteServer.getBimServerClient().getModel(newRevisionNotification.getRevisionId());
				for (IdEObject idEObject : model.getValues()) {
					if (idEObject instanceof IfcObjectPlacement) {
						IfcObjectPlacement ifcObjectPlacement = (IfcObjectPlacement)idEObject;
						for (IfcLocalPlacement ifcLocalPlacement : ifcObjectPlacement.getReferencedByPlacements()) {
							IfcAxis2Placement relativePlacement = ifcLocalPlacement.getRelativePlacement();
							if (relativePlacement instanceof IfcAxis2Placement3D) {
								IfcAxis2Placement3D ifcAxis2Placement3D = (IfcAxis2Placement3D)relativePlacement;
								IfcCartesianPoint ifcCartesianPoint = ifcAxis2Placement3D.getLocation();
								float[] newValues = new float[ifcCartesianPoint.getCoordinates().size()];
								int i=0;
								for (float val : ifcCartesianPoint.getCoordinates()) {
									newValues[i++] = val * 1.5f;
								}
								ifcCartesianPoint.getCoordinates().clear();
								for (i=0; i<newValues.length; i++) {
									ifcCartesianPoint.getCoordinates().add(newValues[i]);
								}
							}
						}
					}
				}
				satelliteServer.getBimServerClient().uploadModel(revision.getProjectId(), "Update by SpaceOutActivity", model);
			}
		});
	}
}