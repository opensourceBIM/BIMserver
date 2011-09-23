package org.bimserver.pb;

import org.bimserver.shared.pb.Reflector;

@SuppressWarnings("unchecked")
public class NotificationInterfaceReflectorImpl implements org.bimserver.shared.NotificationInterface {

private Reflector reflector;

	public NotificationInterfaceReflectorImpl (Reflector reflector) {this.reflector = reflector;}
	public void newRevision(org.bimserver.interfaces.objects.SNewRevisionNotification arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("NotificationInterface", "newRevision", arg0);
	}
	public void newProject(org.bimserver.interfaces.objects.SNewProjectNotification arg0) throws org.bimserver.shared.exceptions.ServiceException {
		reflector.callMethod("NotificationInterface", "newProject", arg0);
	}
}
