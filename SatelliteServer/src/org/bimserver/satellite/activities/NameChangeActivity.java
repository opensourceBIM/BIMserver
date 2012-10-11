package org.bimserver.satellite.activities;

import org.bimserver.client.BimServerClientException;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.satellite.SatelliteServer;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;

public class NameChangeActivity extends Activity {
	private static final String COMMENT_TAG = "NameChange";
	private SatelliteServer satelliteServer;

	@Override
	public void activate(SatelliteServer satelliteServer) {
		this.satelliteServer = satelliteServer;
		satelliteServer.getBimServerClient().registerNotificationListener(this);
	}

	@Override
	public void deactivate(SatelliteServer satelliteServer) {
		satelliteServer.getBimServerClient().unregisterNotificationListener(this);
	}

	@Override
	public void newLogAction(SLogAction logAction, String serviceIdentifier, String profileIdentifier, SToken token, String apiUrl) throws UserException, ServerException {
		try {
			if (logAction instanceof SNewRevisionAdded) {
				SNewRevisionAdded newRevisionAdded = (SNewRevisionAdded)logAction;
				IfcModelInterface model = satelliteServer.getBimServerClient().getModel(newRevisionAdded.getRevisionId());
				ServiceInterface serviceInterface = satelliteServer.getBimServerClient().getServiceInterface();
				SRevision revision = serviceInterface.getRevision(newRevisionAdded.getRevisionId());
				if (!revision.getComment().contains(COMMENT_TAG)) {
					serviceInterface.startTransaction(newRevisionAdded.getProjectId());
					int changed = 0;
					for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
						if (ifcProduct.getName() == null) {
							serviceInterface.setStringAttribute(ifcProduct.getOid(), "Name", "Ruben was here");
						} else {
							serviceInterface.setStringAttribute(ifcProduct.getOid(), "Name", "Ruben was here (" + ifcProduct.getName() + ")");
						}
						changed++;
					}
					log("Changed " + changed + " objects");
					serviceInterface.commitTransaction(COMMENT_TAG);
				}
			}
		} catch (BimServerClientException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getName() {
		return "NameChanger";
	}
}