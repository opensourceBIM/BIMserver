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

import org.bimserver.client.factories.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.framework.actions.ActionFactory;

public class VirtualUserFactory {
	private final RandomBimServerClientFactory randomBimServerClientFactory;
	private final TestFramework testFramework;
	private ActionFactory actionFactory;

	public VirtualUserFactory(TestFramework testFramework, RandomBimServerClientFactory randomBimServerClientFactory) {
		this.testFramework = testFramework;
		this.randomBimServerClientFactory = randomBimServerClientFactory;
		this.actionFactory = new ActionFactory(testFramework);
	}

	public VirtualUser create(String name) {
		return new VirtualUser(testFramework, randomBimServerClientFactory.create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"), "localhost"), actionFactory, name);
	}
}