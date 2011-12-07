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

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.invoker.AbstractInvoker;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInvoker extends AbstractInvoker {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomInvoker.class);
	private final ServiceInterfaceFactory serviceFactory;

	public CustomInvoker(ServiceInterfaceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Override
	public Object getServiceObject(Exchange context) {
		Message inMessage = context.getInMessage();
		HttpServletRequest httpRequest = (HttpServletRequest) inMessage.get(AbstractHTTPDestination.HTTP_REQUEST);
		if (inMessage instanceof SoapMessage) {
			SoapMessage soapMessage = (SoapMessage) inMessage;
			Header header = soapMessage.getHeader(new QName("uri:org.bimserver", "token"));
			Token token = null;
			if (header != null) {
				token = (Token) header.getObject();
			}
			if (token == null) {
				token = (Token) context.getSession().get("token");
			}
			if (token != null) {
				try {
					return serviceFactory.getService(token);
				} catch (UserException e) {
					LOGGER.error("", e);
					return null;
				}
			} else {
				ServiceInterface newService = serviceFactory.newService(AccessMethod.SOAP, httpRequest.getRemoteAddr());
				try {
					context.getSession().put("token", newService.getCurrentToken());
				} catch (ServiceException e) {
					LOGGER.error("", e);
				}
				return newService;
			}
		} else {
			ServiceInterface newService = serviceFactory.newService(AccessMethod.REST, httpRequest.getRemoteAddr());
			return newService;
		}
	}

	@Override
	public void releaseServiceObject(Exchange context, Object obj) {
	}
}