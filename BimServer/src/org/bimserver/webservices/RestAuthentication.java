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

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.binding.soap.interceptor.SoapHeaderInterceptor;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.bimserver.BimServer;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.Token;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestAuthentication extends SoapHeaderInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestAuthentication.class);
	private final BimServer bimServer;
	
	public RestAuthentication(BimServer bimServer) {
		this.bimServer = bimServer;
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		HttpServletRequest httpRequest = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		HttpServletResponse httpResponse = (HttpServletResponse) message.get(AbstractHTTPDestination.HTTP_RESPONSE);
		httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader("Origin"));
		httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type");
		Token token = (Token)message.getExchange().getSession().get("token");
		ServiceInterface newService = null;
		if (token == null) {
			try {
				newService = bimServer.getServiceFactory().newServiceMap(AccessMethod.REST, httpRequest.getRemoteAddr()).get(ServiceInterface.class);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			}
			message.getExchange().getSession().put("token", ((Service)newService).getCurrentToken());
		} else {
			try {
				newService = bimServer.getServiceFactory().getService(ServiceInterface.class, token);
			} catch (UserException e) {
				LOGGER.error("", e);
			}
		}
		try {
			if (newService.isLoggedIn()) {
				return;
			}
		} catch (ServiceException e1) {
			LOGGER.error("", e1);
		}
		AuthorizationPolicy policy = message.get(AuthorizationPolicy.class);
		if (policy == null) {
			sendErrorResponse(message, HttpURLConnection.HTTP_UNAUTHORIZED);
			return;
		}
		try {
			if (newService.login(policy.getUserName(), policy.getPassword()) != null) {
                httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
				return;
			} else {
				LOGGER.warn("Invalid username or password for user: " + policy.getUserName());
				sendErrorResponse(message, HttpURLConnection.HTTP_UNAUTHORIZED);
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
			sendErrorResponse(message, HttpURLConnection.HTTP_INTERNAL_ERROR);
		}
	}

	@SuppressWarnings("unchecked")
	private void sendErrorResponse(Message message, int responseCode) {
		Message outMessage = getOutMessage(message);
		outMessage.put(Message.RESPONSE_CODE, responseCode);
		// Set the response headers
		Map<String, List<String>> responseHeaders = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
		if (responseHeaders != null) {
			responseHeaders.put("WWW-Authenticate", Arrays.asList(new String[] { "Basic realm=realm" }));
			responseHeaders.put("Content-Length", Arrays.asList(new String[] { "0" }));
		}
		message.getInterceptorChain().abort();
		try {
			getConduit(message).prepare(outMessage);
			close(outMessage);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	private Message getOutMessage(Message inMessage) {
		Exchange exchange = inMessage.getExchange();
		Message outMessage = exchange.getOutMessage();
		if (outMessage == null) {
			Endpoint endpoint = exchange.get(Endpoint.class);
			outMessage = endpoint.getBinding().createMessage();
			exchange.setOutMessage(outMessage);
		}
		outMessage.putAll(inMessage);
		return outMessage;
	}

	private Conduit getConduit(Message inMessage) throws IOException {
		Exchange exchange = inMessage.getExchange();
		EndpointReferenceType target = exchange.get(EndpointReferenceType.class);
		Conduit conduit = exchange.getDestination().getBackChannel(inMessage, null, target);
		exchange.setConduit(conduit);
		return conduit;
	}

	private void close(Message outMessage) throws IOException {
		OutputStream os = outMessage.getContent(OutputStream.class);
		os.flush();
		os.close();
	}
}