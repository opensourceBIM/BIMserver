package org.bimserver.test;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ClientIfcModel;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestNewQueryViaClient {
	public static void main(String[] args) {
		new TestNewQueryViaClient().start();
	}

	private void start() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://localhost:8080")){
			BimServerClient client = factory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			String projectName = "Test " + new Random().nextInt();
			SProject project = client.getServiceInterface().addProject(projectName, "ifc2x3tc1");
			
			SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			
			client.checkinSync(project.getOid(), "Test Model", deserializer.getOid(), false, Paths.get("C:/Git/TestFiles/TestData/data/AC11-FZK-Haus-IFC.ifc"));
			
			project = client.getServiceInterface().getProjectByPoid(project.getOid());
			
			System.out.println(project.getName());
			
			ClientIfcModel model = client.getModel(project, project.getLastRevisionId(), false, false);
			
			Query query = new Query(model.getPackageMetaData());
			
			QueryPart queryPart = query.createQueryPart();
			queryPart.addType(Ifc2x3tc1Package.eINSTANCE.getIfcWall(), true);
			
			for (IfcWall ifcWall : model.getAllWithSubTypes(IfcWall.class)) {
				System.out.println(ifcWall.getGlobalId());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}