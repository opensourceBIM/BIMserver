package org.bimserver.satellite.activities;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SNewRevisionNotification;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.satellite.SatelliteServer;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;

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
	public void newRevision(SNewRevisionNotification newRevisionNotification) throws ServiceException {
		IfcModelInterface model = satelliteServer.getBimServerClient().getModel(newRevisionNotification.getRevisionId());
		ServiceInterface serviceInterface = satelliteServer.getBimServerClient().getServiceInterface();
		SRevision revision = serviceInterface.getRevision(newRevisionNotification.getRevisionId());
		if (!revision.getComment().contains(COMMENT_TAG)) {
			serviceInterface.startTransaction(newRevisionNotification.getProjectId());
			int changed = 0;
			for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
				if (ifcProduct.getName() == null) {
					serviceInterface.setStringAttribute(ifcProduct.getOid(), ifcProduct.eClass().getName(), "Name", "Ruben was here");
				} else {
					serviceInterface.setStringAttribute(ifcProduct.getOid(), ifcProduct.eClass().getName(), "Name", "Ruben was here (" + ifcProduct.getName() + ")");
				}
				changed++;
			}
			log("Changed " + changed + " objects");
			serviceInterface.commitTransaction(COMMENT_TAG);
		}
	}
	
	@Override
	public String getName() {
		return "NameChanger";
	}
}