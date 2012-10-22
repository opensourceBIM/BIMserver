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

import java.util.List;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.ConnectionException;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDataValue;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.junit.Test;

public class TestUnknown {
	@Test
	public void test() {
		try {
			BimServerClient bimServerClient = new BimServerClient("", null);
			bimServerClient.setAuthentication(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.connectProtocolBuffers("localhost", 8020);
			Long roid = 47L;
			List<SDataObject> dataObjectsByType = bimServerClient.getServiceInterface().getDataObjectsByType(roid, "IfcWindow");
			for (SDataObject sDataObject : dataObjectsByType) {
				System.out.println(sDataObject.getType() + ": " + sDataObject.getOid());
				for (SDataValue sDataValue : sDataObject.getValues()) {
					System.out.println(sDataValue.getClass().getName());
				}
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
}
