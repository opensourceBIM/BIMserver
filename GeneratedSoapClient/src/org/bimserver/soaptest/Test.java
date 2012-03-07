package org.bimserver.soaptest;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.bimserver.generatedclient.SDataObject;
import org.bimserver.generatedclient.SDataValue;
import org.bimserver.generatedclient.SListDataValue;
import org.bimserver.generatedclient.SProject;
import org.bimserver.generatedclient.SReferenceDataValue;
import org.bimserver.generatedclient.SSimpleDataValue;
import org.bimserver.generatedclient.ServerException_Exception;
import org.bimserver.generatedclient.ServiceInterfaceService;
import org.bimserver.generatedclient.Soap;
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
			URL url = new URL("http://localhost/soap?wsdl");
			ServiceInterfaceService service = new ServiceInterfaceService(url);
			Soap soapPort = service.getSoapPort();
			((BindingProvider) soapPort).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
				soapPort.login("admin@bimserver.org", "admin");
				for (SProject sProject : soapPort.getAllProjects()) {
					System.out.println(sProject.getName());
					long roid = sProject.getLastRevisionId();
					if (roid != -1) {
						List<SDataObject> dataObjectsByType = soapPort.getDataObjectsByType(roid, "IfcWindow");
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
