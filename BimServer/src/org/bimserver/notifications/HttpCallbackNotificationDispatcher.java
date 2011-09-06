package org.bimserver.notifications;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;

public class HttpCallbackNotificationDispatcher implements NotificationListener {

	private final BimServer bimServer;

	public HttpCallbackNotificationDispatcher(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	@Override
	public void notify(LogAction notificationMessage) {
		BimDatabaseSession session = bimServer.getDatabase().createReadOnlySession();
		try {
			IfcModel allOfType = session.getAllOfType(StorePackage.eINSTANCE.getUser(), false);
			for (IdEObject idEObject : allOfType.getValues()) {
				if (idEObject instanceof User) {
					User user = (User)idEObject;
					if (user.getNotificationUrl() != null && !user.getNotificationUrl().isEmpty()) {
						try {
							URL url = new URL(user.getNotificationUrl());
							URLConnection connection = url.openConnection();
							
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (BimDeadlockException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}