package org.bimserver.web;

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

import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class LoginManager {
	private ServiceInterface service;

	public long getUoid() throws ServiceException {
		return service.getCurrentUser().getOid();
	}

	public ServiceInterface getService() {
		if (service == null) {
			service = WebServerHelper.getBimServer().getServiceFactory().newService(AccessMethod.WEB_INTERFACE);
		}
		return service;
	}

	public SUserType getUserType() throws ServiceException {
		return getService().getCurrentUser().getUserType();
	}
	
	public ServiceInterface getSystemService() {
		return WebServerHelper.getBimServer().getSystemService();
	}
}