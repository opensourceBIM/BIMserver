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

import java.io.ByteArrayOutputStream;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;

public class TestConstantlyDownloading {
	public static void main(String[] args) {
		long poid = 196609;		
		
		try {
			BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			for (int i=0; i<200; i++) {
				SProject project = client.getServiceInterface().getProjectByPoid(poid);
				long roid = project.getLastRevisionId();
				SSerializerPluginConfiguration serializer = client.getPluginInterface().getSerializerByPluginClassName("org.bimserver.geometry.json.JsonGeometrySerializerPlugin");
				System.out.println(i);
				client.download(roid, serializer.getOid(), new ByteArrayOutputStream());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
