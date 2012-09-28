package org.bimserver.satellite.activities;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashSet;
import java.util.Set;

import org.bimserver.client.BimServerClientException;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcObjectPlacement;
import org.bimserver.satellite.SatelliteServer;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class ExploderActivity extends Activity {
	private static final String COMMENT_TAG = "Exploder";
	private SatelliteServer satelliteServer;
	
	public void activate(final SatelliteServer satelliteServer) {
		this.satelliteServer = satelliteServer;
		satelliteServer.getBimServerClient().registerNotificationListener(this);
	}
	
	@Override
	public void deactivate(SatelliteServer satelliteServer) {
		satelliteServer.getBimServerClient().unregisterNotificationListener(this);
	}
	
	@Override
	public void newLogAction(SLogAction logAction, SToken token, String apiUrl) throws UserException, ServerException {
		if (logAction instanceof SNewRevisionAdded) {
			SNewRevisionAdded sNewRevisionAdded = (SNewRevisionAdded)logAction;
			SRevision revision = satelliteServer.getBimServerClient().getServiceInterface().getRevision(sNewRevisionAdded.getRevisionId());
			if (!revision.getComment().contains(COMMENT_TAG)) {
				SProject project = satelliteServer.getBimServerClient().getServiceInterface().getProjectByPoid(revision.getProjectId());
				log("Downloading revision " + revision.getId() + " of project " + project.getName());
				try {
					IfcModelInterface model = satelliteServer.getBimServerClient().getModel(sNewRevisionAdded.getRevisionId());
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
										for (double val : ifcCartesianPoint.getCoordinates()) {
											ifcCartesianPoint.getCoordinates().set(i, val * 1.5d);
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
				} catch (BimServerClientException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String getName() {
		return "Exploder";
	}
}