package org.bimserver.unittests;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.PluginException;
import org.bimserver.shared.exceptions.ServiceException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClientEmfModelCheckinRemoteSoap {
	private static BimServerClient bimServerClient;

	@BeforeClass
	public static void setup() throws ConnectionException {
		try {
			bimServerClient = new BimServerClient(LocalDevPluginLoader.createPluginManager());
			UsernamePasswordAuthenticationInfo usernamePasswordAuthenticationInfo = new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin");
			bimServerClient.setAuthentication(usernamePasswordAuthenticationInfo);
			bimServerClient.connectSoap("http://localhost/soap", true);
		} catch (PluginException e) {
			e.printStackTrace();
		}		
	}

	@AfterClass
	public static void shutdown() {
		// bimServer.stop();
	}

	private long createProject() {
		try {
			SProject project = bimServerClient.getServiceInterface().addProject("Project " + new Random().nextInt());
			return project.getOid();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Test
	public void test() {
		try {
			long poid = createProject();
			
			File file = new File("../TestData/data/AC11-FZK-Haus-IFC.ifc");
			DataSource dataSource = new org.bimserver.utils.FileDataSource(file);
			DataHandler dataHandler = new DataHandler(dataSource);
			Integer checkin = bimServerClient.getServiceInterface().checkin(poid, "lala", "IfcStepDeserializer", file.length(), dataHandler, false, true);
			bimServerClient.getServiceInterface().getCheckinState(checkin);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}