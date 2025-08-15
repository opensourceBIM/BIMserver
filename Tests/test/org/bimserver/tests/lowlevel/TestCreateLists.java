package org.bimserver.tests.lowlevel;

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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.tests.TestWithEmbeddedServer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCreateLists extends TestWithEmbeddedServer {

	@Test
	public void test() throws ServiceException, ChannelConnectionException {
		// Create a new BimServerClient with authentication
		BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
		LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();

		// Create a new project
		SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");

		// Start a transaction
		Long tid = lowLevelInterface.startTransaction(newProject.getOid());

		Long cartesianPointOid = lowLevelInterface.createObject(tid, "IfcCartesianPoint", false);

		double firstVal = 5.1;
		lowLevelInterface.addDoubleAttribute(tid, cartesianPointOid, "Coordinates", firstVal);
		double secondVal = 6.2;
		lowLevelInterface.addDoubleAttribute(tid, cartesianPointOid, "Coordinates", secondVal);
		double thirdVal = 7.3;
		lowLevelInterface.addDoubleAttribute(tid, cartesianPointOid, "Coordinates", thirdVal);

		// Commit the transaction
		lowLevelInterface.commitTransaction(tid, "test", false);

		tid = lowLevelInterface.startTransaction(newProject.getOid());
		List<Double> coordinates = lowLevelInterface.getDoubleAttributes(tid, cartesianPointOid, "Coordinates");
		assertEquals(3, coordinates.size());
		assertEquals(firstVal, coordinates.get(0), 0);
		assertEquals(secondVal, coordinates.get(1), 0);
		assertEquals(thirdVal, coordinates.get(2), 0);

		List<String> stringCoords = lowLevelInterface.getStringAttributes(tid, cartesianPointOid, "CoordinatesAsString");
		assertEquals(3, stringCoords.size());
		assertEquals("5.1", stringCoords.get(0));
		assertEquals("6.2", stringCoords.get(1));
		assertEquals("7.3", stringCoords.get(2));

		tid = lowLevelInterface.startTransaction(newProject.getOid());
		ArrayList<Double> al = new ArrayList<Double>();
		al.add(1.0);
		al.add(2.0);
		al.add(3.0);
		lowLevelInterface.setDoubleAttributes(tid, cartesianPointOid, "Coordinates", al);
		lowLevelInterface.commitTransaction(tid, "replace", false);

		tid = lowLevelInterface.startTransaction(newProject.getOid());
		coordinates = lowLevelInterface.getDoubleAttributes(tid, cartesianPointOid, "Coordinates");
		assertEquals(3, coordinates.size());
		assertEquals(1.0, coordinates.get(0), 0);
		assertEquals(2.0, coordinates.get(1), 0);
		assertEquals(3.0, coordinates.get(2), 0);

		stringCoords = lowLevelInterface.getStringAttributes(tid, cartesianPointOid, "CoordinatesAsString");
		assertEquals(3, stringCoords.size());
		assertEquals("1.0", stringCoords.get(0));
		assertEquals("2.0", stringCoords.get(1));
		assertEquals("3.0", stringCoords.get(2));

		tid = lowLevelInterface.startTransaction(newProject.getOid());
		lowLevelInterface.setDoubleAttributeAtIndex(tid, cartesianPointOid, "Coordinates", 1, 5.0);
		lowLevelInterface.commitTransaction(tid, "changed middle one", false);

		tid = lowLevelInterface.startTransaction(newProject.getOid());
		coordinates = lowLevelInterface.getDoubleAttributes(tid, cartesianPointOid, "Coordinates");
		assertEquals(3, coordinates.size());
		assertEquals(1.0, coordinates.get(0), 0);
		assertEquals(5.0, coordinates.get(1), 0);
		assertEquals(3.0, coordinates.get(2), 0);

	 	stringCoords = lowLevelInterface.getStringAttributes(tid, cartesianPointOid, "CoordinatesAsString");
		assertEquals(3, stringCoords.size());
		assertEquals("1.0", stringCoords.get(0));
		assertEquals("5.0", stringCoords.get(1));
		assertEquals("3.0", stringCoords.get(2));

		tid = lowLevelInterface.startTransaction(newProject.getOid());
		lowLevelInterface.removeAttribute(tid, cartesianPointOid, "Coordinates", 1);
		lowLevelInterface.commitTransaction(tid, "removed middle one", false);

		tid = lowLevelInterface.startTransaction(newProject.getOid());
		coordinates = lowLevelInterface.getDoubleAttributes(tid, cartesianPointOid, "Coordinates");
		assertEquals(2, coordinates.size());
		assertEquals(1.0, coordinates.get(0), 0);
		assertEquals(3.0, coordinates.get(1), 0);

		stringCoords = lowLevelInterface.getStringAttributes(tid, cartesianPointOid, "CoordinatesAsString");
		assertEquals(2, stringCoords.size());
		assertEquals("1.0", stringCoords.get(0));
		assertEquals("3.0", stringCoords.get(1));

	}
}