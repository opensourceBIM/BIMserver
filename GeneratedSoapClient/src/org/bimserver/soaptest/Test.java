package org.bimserver.soaptest;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.headers.Header;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.bimserver.generatedclient.AuthInterface;
import org.bimserver.generatedclient.AuthInterfaceService;
import org.bimserver.generatedclient.LowLevelInterface;
import org.bimserver.generatedclient.LowLevelInterfaceService;
import org.bimserver.generatedclient.SDataObject;
import org.bimserver.generatedclient.SDataValue;
import org.bimserver.generatedclient.SListDataValue;
import org.bimserver.generatedclient.SProject;
import org.bimserver.generatedclient.SReferenceDataValue;
import org.bimserver.generatedclient.SSimpleDataValue;
import org.bimserver.generatedclient.ServerException_Exception;
import org.bimserver.generatedclient.ServiceInterface;
import org.bimserver.generatedclient.ServiceInterfaceService;
import org.bimserver.generatedclient.UserException_Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		new Test().start();
	}

	private void start() {
		try {
			URL serviceInterfaceUrl = new URL("http://localhost:8080/soap12/ServiceInterface?wsdl");
			URL authInterfaceUrl = new URL("http://localhost:8080/soap12/AuthInterface?wsdl");
			URL lowLevelInterfaceUrl = new URL("http://localhost:8080/soap12/LowLevelInterface?wsdl");

			ServiceInterfaceService serviceInterfaceService = new ServiceInterfaceService(serviceInterfaceUrl);
			ServiceInterface serviceInterface = serviceInterfaceService.getServiceInterfacePort();

			AuthInterfaceService authInterfaceService = new AuthInterfaceService(authInterfaceUrl);
			AuthInterface authInterface = authInterfaceService.getAuthInterfacePort();
			
			LowLevelInterfaceService lowLevelInterfaceService = new LowLevelInterfaceService(lowLevelInterfaceUrl);
			LowLevelInterface lowLevelInterface = lowLevelInterfaceService.getLowLevelInterfacePort();
			
			String token = authInterface.login("admin@bimserver.org", "admin");
			try {
				List<Header> headers = new ArrayList<Header>();
				Token tokenObject = new Token();
				tokenObject.setToken(token);
				Header sessionHeader = new Header(new QName("uri:org.bimserver.shared", "token"), tokenObject, new JAXBDataBinding(Token.class));
				headers.add(sessionHeader);
				((BindingProvider) serviceInterface).getRequestContext().put(Header.HEADER_LIST, headers);
				((BindingProvider) authInterface).getRequestContext().put(Header.HEADER_LIST, headers);
				((BindingProvider) lowLevelInterface).getRequestContext().put(Header.HEADER_LIST, headers);
			} catch (JAXBException e) {
				LOGGER.error("", e);
			}
				for (SProject sProject : serviceInterface.getAllProjects(true)) {
					System.out.println(sProject.getName());
					long roid = sProject.getLastRevisionId();
					if (roid != -1) {
						List<SDataObject> dataObjectsByType = lowLevelInterface.getDataObjectsByType(roid, "IfcWindow");
						for (SDataObject sDataObject : dataObjectsByType) {
							for (SDataValue sDataValue : sDataObject.getValues()) {
								System.out.print(sDataValue.getFieldName() + ": ");
								if (sDataValue instanceof SSimpleDataValue) {
									SSimpleDataValue sSimpleDataValue = (SSimpleDataValue)sDataValue;
									System.out.print(sSimpleDataValue.getStringValue());
								} else if (sDataValue instanceof SListDataValue) {
									SListDataValue sListDataValue = (SListDataValue)sDataValue;
									System.out.print(sListDataValue.getValues().size());
								} else if (sDataValue instanceof SReferenceDataValue) {
									SReferenceDataValue sReferenceDataValue = (SReferenceDataValue)sDataValue;
									System.out.print(sReferenceDataValue.getTypeName() + ": " + sReferenceDataValue.getOid());
								} else {
									System.out.print("Unknown type: " + sDataValue);
								}
								System.out.println();
							}
						}
					}
				}
		} catch (MalformedURLException e) {
			LOGGER.error("", e);
		} catch (UserException_Exception e) {
			LOGGER.error("", e);
		} catch (ServerException_Exception e) {
			LOGGER.error("", e);
		}
	}
}