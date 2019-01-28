package org.bimserver.webservices;

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

import java.lang.reflect.Method;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.service.invoker.AbstractInvoker;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.Token;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PublicInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInvoker extends AbstractInvoker {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomInvoker.class);
	private final PublicInterfaceFactory serviceFactory;
	private Class<? extends PublicInterface> interfaceClass;

	public CustomInvoker(PublicInterfaceFactory serviceFactory, Class<? extends PublicInterface> interfaceClass) {
		this.serviceFactory = serviceFactory;
		this.interfaceClass = interfaceClass;
	}

	@Override
	public Object getServiceObject(Exchange exchange) {
		Message inMessage = exchange.getInMessage();
		if (inMessage instanceof SoapMessage) {
			SoapMessage soapMessage = (SoapMessage) inMessage;
			Header header = soapMessage.getHeader(new QName("uri:org.bimserver.shared", "token"));
			String token = null;
			if (header != null) {
				token = ((Token)(header.getObject())).getToken();
			}
			if (token == null) {
				token = (String) exchange.getSession().get("token");
			}
			if (token != null) {
				try {
					return serviceFactory.get(token, AccessMethod.SOAP).get(interfaceClass);
				} catch (UserException e) {
					LOGGER.error("", e);
					return null;
				}
			} else {
				try {
					PublicInterface newService = serviceFactory.get(AccessMethod.SOAP).get(interfaceClass);
					exchange.getSession().put("token", token);
					return newService;
				} catch (UserException e) {
					LOGGER.error("", e);
				}
			}
		} else {
			try {
				return serviceFactory.get(AccessMethod.SOAP).get(interfaceClass);
			} catch (UserException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}
	
	@Override
	protected Object invoke(Exchange exchange, Object service, Method method, List<Object> arguments) {
		if (method.getName().equals("login")) {
			MessageContentsList mcl = (MessageContentsList) super.invoke(exchange, service, method, arguments);
			String token = (String) mcl.get(0);
			exchange.getSession().put("token", token);
			return mcl;
		} else {
			return super.invoke(exchange, service, method, arguments);
		}
	}

	@Override
	public void releaseServiceObject(Exchange context, Object obj) {
	}
}