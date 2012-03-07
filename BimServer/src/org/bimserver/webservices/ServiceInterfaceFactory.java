package org.bimserver.webservices;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSession;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceFactory;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.GeneratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceInterfaceFactory implements ServiceFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInterfaceFactory.class);
	private static final int TOKEN_TTL_SECONDS = 60*60; // one hour
	private final HashMap<Token, ServiceInterface> tokens = new HashMap<Token, ServiceInterface>();
	private final BimServer bimServer;

	public ServiceInterfaceFactory(BimServer bimServer) {
		this.bimServer = bimServer;
	}
	
	public ServiceInterface newService(AccessMethod accessMethod, String remoteAddress) {
		Service service = new Service(bimServer, accessMethod, remoteAddress, this);
		Date expires = new Date(new Date().getTime() + (TOKEN_TTL_SECONDS * 1000));
		Token token = new Token(GeneratorUtils.generateToken(), expires);
		tokens.put(token, service);
		service.setToken(token);
		return service;
	}

	public synchronized ServiceInterface getService(Token token) throws UserException {
		if (tokens.containsKey(token)) {
			return tokens.get(token);
		}
		throw new UserException("Invalid token");
	}

	public synchronized void cleanup() {
		int tokensCleaned = 0;
		Date now = new Date();
		Iterator<Token> iterator = tokens.keySet().iterator();
		while (iterator.hasNext()) {
			Token token = iterator.next();
			if (token.getExpiresAsDate().before(now)) {
				tokensCleaned++;
				iterator.remove();
			}
		}
		if (tokensCleaned > 0) {
			LOGGER.info("Removed " + tokensCleaned + " tokens");
		}
	}

	public synchronized int getNumberOfTokens() {
		return tokens.size();
	}

	public synchronized void remove(Token token) {
		tokens.remove(token);
	}

	public List<SUserSession> getActiveUserSessions() throws org.bimserver.shared.exceptions.ServerException, UserException {
		List<SUserSession> userSessions = new ArrayList<SUserSession>();
		for (Token token : tokens.keySet()) {
			ServiceInterface serviceInterface = tokens.get(token);
			if (serviceInterface.isLoggedIn() && serviceInterface.getAccessMethod() != SAccessMethod.INTERNAL) {
				SUser user = serviceInterface.getCurrentUser();
				if (user != null) {
					SUserSession userSession = new SUserSession();
					userSession.setUsername(user.getUsername());
					userSession.setType(user.getUserType());
					userSession.setName(user.getName());
					userSession.setRemoteAddress(serviceInterface.getRemoteAddress());
					userSession.setUserId(user.getOid());
					userSession.setAccessMethod(serviceInterface.getAccessMethod());
					userSession.setActiveSince(serviceInterface.getActiveSince());
					userSession.setLastActive(serviceInterface.getLastActive());
					userSessions.add(userSession);
				}
			}
		}
		Collections.sort(userSessions, new Comparator<SUserSession>(){
			@Override
			public int compare(SUserSession o1, SUserSession o2) {
				return o1.getLastActive().compareTo(o2.getLastActive());
			}});
		return userSessions;
	}

	@Override
	public String getName() {
		return "ServiceInterface";
	}
}