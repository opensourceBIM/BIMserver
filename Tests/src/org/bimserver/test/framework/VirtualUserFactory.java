package org.bimserver.test.framework;

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

import org.bimserver.client.ConnectionException;
import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;

public class VirtualUserFactory {
	private final BimServerClientFactory randomBimServerClientFactory;
	private final TestFramework testFramework;

	public VirtualUserFactory(TestFramework testFramework, BimServerClientFactory randomBimServerClientFactory) {
		this.testFramework = testFramework;
		this.randomBimServerClientFactory = randomBimServerClientFactory;
	}

	public VirtualUser create(String name) {
		try {
			return new VirtualUser(testFramework, randomBimServerClientFactory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"), "localhost"), name);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return null;
	}
}