package org.bimserver.tests.lowlevel;

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

import static org.junit.Assert.fail;

import java.util.Random;

import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestUnsetReferenceWithOpposite extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Get the service interface
//			PluginInterface pluginInterface = bimServerClient.getPlugin();
			
			LowLevelInterface service = bimServerClient.getLowLevelInterface();
			
			Long projectId = bimServerClient.getServiceInterface().addProject("PG-unsetReferenceTest" + new Random().nextInt(), "ifc2x3tc1").getOid();
			Long transactionId = service.startTransaction(projectId);

			Long ifcRelContainedInSpatialStructureId = service.createObject(transactionId, "IfcRelContainedInSpatialStructure", true);
			Long ifcBuildingId = service.createObject(transactionId, "IfcBuilding", true);
			service.setReference(transactionId, ifcRelContainedInSpatialStructureId,"RelatingStructure", ifcBuildingId);

//			Long revisionId = service.commitTransaction(transactionId, "comment");
			
//			SSerializerPluginConfiguration serializerByPluginClassName = pluginInterface.getSerializerByPluginClassName("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin");
//			bimServerClient.download(revisionId, serializerByPluginClassName.getOid(), new File("1.ifc"));

//			transactionId = service.startTransaction(projectId);
//			service.unsetReference(transactionId, ifcRelContainedInSpatialStructureId, "RelatingStructure");
//			revisionId = service.commitTransaction(transactionId, "comment");

//			bimServerClient.download(revisionId, serializerByPluginClassName.getOid(), new File("2.ifc"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
