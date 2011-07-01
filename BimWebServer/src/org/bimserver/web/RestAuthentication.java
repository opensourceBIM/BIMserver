package org.bimserver.web;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.interceptor.SoapHeaderInterceptor;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.bimserver.BimServer;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceException;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.UserException;
import org.bimserver.webservices.Service;
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
		Token token = (Token)message.getExchange().getService().get("token");
		ServiceInterface newService = null;
		if (token == null) {
			newService = bimServer.getServiceFactory().newService(AccessMethod.REST);
			message.getExchange().getService().put("token", ((Service)newService).getCurrentToken());
		} else {
			try {
				newService = bimServer.getServiceFactory().getService((Token)message.getExchange().getService().get("token"));
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
			if (newService.login(policy.getUserName(), policy.getPassword())) {
				return;
			} else {
				LOGGER.warn("Invalid username or password for user: " + policy.getUserName());
				sendErrorResponse(message, HttpURLConnection.HTTP_FORBIDDEN);
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
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
