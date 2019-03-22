package org.bimserver.plugins.web;

import javax.servlet.http.HttpServletRequest;

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

import javax.servlet.http.HttpServletResponse;

import org.bimserver.interfaces.objects.SPluginType;
import org.bimserver.plugins.Plugin;

public interface WebModulePlugin extends Plugin {

	/**
	 * Handles the individual requests, just like a servlet
	 * 
	 * @param requestUrl Request URL
	 * @param response The HTTP response
	 */
	boolean service(String requestUrl, HttpServletRequest httpServletRequest, HttpServletResponse response);
	
	@Override
	default SPluginType getPluginType() {
		return SPluginType.WEB_MODULE;
	}
}