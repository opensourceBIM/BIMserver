package org.bimserver.pb;

import org.bimserver.shared.pb.Reflector;

@SuppressWarnings("unchecked")
public class NotificationInterfaceReflectorImpl implements org.bimserver.shared.NotificationInterface {

private Reflector reflector;

	public NotificationInterfaceReflectorImpl (Reflector reflector) {this.reflector = reflector;}
	public void newLogAction(org.bimserver.interfaces.objects.SLogAction arg0) throws org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("newLogAction", arg0);
	}
}
