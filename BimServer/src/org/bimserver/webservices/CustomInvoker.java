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

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.invoker.AbstractInvoker;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.bimserver.interfaces.objects.SToken;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInvoker extends AbstractInvoker {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomInvoker.class);
	private final PublicInterfaceFactory serviceFactory;

	public CustomInvoker(PublicInterfaceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Override
	public Object getServiceObject(Exchange context) {
		Message inMessage = context.getInMessage();
		HttpServletRequest httpRequest = (HttpServletRequest) inMessage.get(AbstractHTTPDestination.HTTP_REQUEST);
		if (inMessage instanceof SoapMessage) {
			SoapMessage soapMessage = (SoapMessage) inMessage;
			Header header = soapMessage.getHeader(new QName("uri:org.bimserver.interfaces.objects", "token"));
			SToken token = null;
			if (header != null) {
				token = (SToken) header.getObject();
			}
			if (token == null) {
				token = (SToken) context.getSession().get("token");
			}
			if (token != null) {
				try {
					return serviceFactory.getService(ServiceInterface.class, token);
				} catch (UserException e) {
					LOGGER.error("", e);
					return null;
				}
			} else {
				ServiceInterface newService;
				try {
					newService = serviceFactory.newServiceMap(AccessMethod.SOAP, httpRequest.getRemoteAddr()).get(ServiceInterface.class);
					context.getSession().put("token", newService.getCurrentToken());
					return newService;
				} catch (ServerException e1) {
					LOGGER.error("", e1);
				} catch (UserException e1) {
					LOGGER.error("", e1);
				}
			}
		} else {
			try {
				return serviceFactory.newServiceMap(AccessMethod.REST, httpRequest.getRemoteAddr()).get(ServiceInterface.class);
			} catch (ServerException e) {
				LOGGER.error("", e);
			} catch (UserException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	@Override
	public void releaseServiceObject(Exchange context, Object obj) {
	}
}