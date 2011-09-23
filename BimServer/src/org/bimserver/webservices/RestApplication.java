package org.bimserver.webservices;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.bimserver.BimServer;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceInterface;

public class RestApplication extends Application {
	private final BimServer bimServer;

	public RestApplication(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ServiceInterface.class);
		return classes;
	}
	
	@Override
	public Set<Object> getSingletons() {
		Set<Object> objects = new HashSet<Object>();
		objects.add(bimServer.getServiceFactory().newService(AccessMethod.REST));
		return objects;
	}
}