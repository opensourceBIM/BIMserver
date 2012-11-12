package org.bimserver.tests;

import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.shared.ReflectorBuilder;
import org.bimserver.shared.ReflectorFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.json.JsonSocketReflector;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.ServicesMap;

public class TestJsonCall {
	public static void main(String[] args) {
		ServicesMap servicesMap = new ServicesMap();
		SService sService = new SService(null, ServiceInterface.class);
		servicesMap.add(sService);
		servicesMap.add(new SService(null, NotificationInterface.class, sService));
		JsonSocketReflector jsonSocketReflector = new JsonSocketReflector(servicesMap, "http://thebimfederation.com/json", false, new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
		ReflectorBuilder reflectorBuilder = new ReflectorBuilder(servicesMap);
		ReflectorFactory reflectorFactory = reflectorBuilder.newReflectorFactory();
		NotificationInterface notificationInterface = reflectorFactory.createReflector(NotificationInterface.class, jsonSocketReflector);
		
		SNewRevisionAdded logAction = new SNewRevisionAdded();
		logAction.setProjectId(262145);
		logAction.setRevisionId(327683);
					
		SToken token = new SToken();
		token.setTokenString("B6284AFB80D37F4EC41E40E7917F860F");
		token.setExpires(1351771318243L);
					
		try {
			notificationInterface.newLogAction("d512c196-47b4-4742-812e-8245504774c2", logAction, "Floor Demo", "p1", token, "http://localhost:8080");
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
	}
}
