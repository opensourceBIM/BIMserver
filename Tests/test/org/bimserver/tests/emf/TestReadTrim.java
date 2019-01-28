package org.bimserver.tests.emf;

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

import static org.junit.Assert.fail;

import java.net.URL;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcParameterValue;
import org.bimserver.models.ifc2x3tc1.IfcTrimmedCurve;
import org.bimserver.models.ifc2x3tc1.IfcTrimmingSelect;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestReadTrim extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			// Create a new BimServerClient with authentication
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a new project
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Get the appropriate deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			
			// Checkin the file
			bimServerClient.checkinSync(newProject.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/TST.ifc"));
			
			// Refresh project info
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			
			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), true, false);
			for (IfcTrimmedCurve ifcTrimmedCurve : model.getAllWithSubTypes(IfcTrimmedCurve.class)) {
				for (IfcTrimmingSelect ifcTrimmingSelect : ifcTrimmedCurve.getTrim1()) {
					if (ifcTrimmingSelect instanceof IfcParameterValue) {
						IfcParameterValue ifcParameterValue = (IfcParameterValue)ifcTrimmingSelect;
						System.out.println("Trim1: " + ifcParameterValue.getWrappedValue());
					}
				}
				for (IfcTrimmingSelect ifcTrimmingSelect : ifcTrimmedCurve.getTrim2()) {
					if (ifcTrimmingSelect instanceof IfcParameterValue) {
						IfcParameterValue ifcParameterValue = (IfcParameterValue)ifcTrimmingSelect;
						System.out.println("Trim2: " + ifcParameterValue.getWrappedValue());
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
			if (e instanceof AssertionError) {
				throw (AssertionError)e;
			}
			fail(e.getMessage());
		}
	}
}