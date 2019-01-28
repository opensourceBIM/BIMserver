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
import java.util.HashSet;
import java.util.Set;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcBoolean;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCreateProperties extends TestWithEmbeddedServer  {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestCreateProperties.class);
	@Test
	public void test() {
		try {
			// New client
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a project
			SProject project = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Look for a deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			
			bimServerClient.checkinSync(project.getOid(), "test", deserializer.getOid(), false, new URL("https://github.com/opensourceBIM/TestFiles/raw/master/TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			
			// Refresh project
			project = bimServerClient.getServiceInterface().getProjectByPoid(project.getOid());
			
			// Load model without lazy loading (complete model at once)
			IfcModelInterface model = bimServerClient.getModel(project, project.getLastRevisionId(), true, true);

			String propertyName = "BooleanProperty";

			int nrWindowsFirst = 0;
			// Iterate over all projects, there should be 1
			for (IfcWindow window : model.getAllWithSubTypes(IfcWindow.class)) {
				nrWindowsFirst++;
				createProperty(window, model, propertyName, "Description of property", true);
			}
			
			long newRoid = model.commit("Added boolean properties to " + nrWindowsFirst + " windows");
			
			model = bimServerClient.getModel(project, newRoid, true, false);
			int foundOke = 0;
			int nrWindowsSecond = 0;
			Set<Long> counted = new HashSet<Long>();
			for (IfcWindow window : model.getAllWithSubTypes(IfcWindow.class)) {
				nrWindowsSecond++;
				for (IfcRelDefines ifcRelDefines : window.getIsDefinedBy()) {
					if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
						IfcRelDefinesByProperties ifcRelDefinesByProperties  = (IfcRelDefinesByProperties)ifcRelDefines;
						IfcPropertySetDefinition relatingPropertyDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
						if (relatingPropertyDefinition instanceof IfcPropertySet) {
							IfcPropertySet ifcPropertySet = (IfcPropertySet)relatingPropertyDefinition;
							for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
								if (ifcProperty instanceof IfcPropertySingleValue) {
									IfcPropertySingleValue ifcPropertySingleValue = (IfcPropertySingleValue)ifcProperty;
									if (ifcPropertySingleValue.getName().equals(propertyName)) {
										IfcValue nominalValue = ifcPropertySingleValue.getNominalValue();
										if (nominalValue instanceof IfcBoolean) {
											if (((IfcBoolean)nominalValue).getWrappedValue() == Tristate.TRUE) {
												if (!counted.contains(ifcPropertySingleValue.getOid())) {
													foundOke++;
													counted.add(ifcPropertySingleValue.getOid());
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			LOGGER.info("Windows first: " + nrWindowsFirst);
			LOGGER.info("Windows second: " + nrWindowsSecond);
			LOGGER.info("Found Oke: " + foundOke);
			if (foundOke != nrWindowsFirst) {
				fail(foundOke + " / " + nrWindowsFirst);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private void createProperty(IfcWindow window, IfcModelInterface model, String name, String description, Object value) throws IfcModelInterfaceException {
		IfcRelDefinesByProperties ifcRelDefinesByProperties = model.create(IfcRelDefinesByProperties.class);
		window.getIsDefinedBy().add(ifcRelDefinesByProperties);
		IfcPropertySet propertySet = model.create(IfcPropertySet.class);
		ifcRelDefinesByProperties.setRelatingPropertyDefinition(propertySet);
		IfcPropertySingleValue property = model.create(IfcPropertySingleValue.class);
		propertySet.getHasProperties().add(property);
		property.setName(name);
		property.setDescription(description);
		if (value instanceof Boolean) {
			IfcBoolean ifcValue = model.create(IfcBoolean.class);
			ifcValue.setWrappedValue(((Boolean)value) ? Tristate.TRUE : Tristate.FALSE);
			property.setNominalValue(ifcValue);
		} else {
			// Unimplemented
		}
	}
}