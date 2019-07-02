package org.bimserver;

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

import java.util.HashMap;
import java.util.Map;

import org.bimserver.webservices.authorization.Authorization;

public class AuthCache {
	private BimServer bimServer;
	private final Map<String, Authorization> authorizations = new HashMap<>();

	public AuthCache(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public void store(String token, Authorization authorization) {
		authorizations.put(token, authorization);
	}

	public Authorization getAuthorization(String token) {
		return authorizations.get(token);
	}
}
