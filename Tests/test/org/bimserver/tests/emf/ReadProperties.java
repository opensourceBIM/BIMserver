package org.bimserver.tests.emf;

import static org.junit.Assert.fail;

import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcAreaMeasure;
import org.bimserver.models.ifc2x3tc1.IfcIdentifier;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.tests.utils.TestWithEmbeddedServer;
import org.junit.Test;

public class ReadProperties extends TestWithEmbeddedServer {
	@Test
	public void test() {
		try {
			// New client
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			// Create a project
			SProject project = bimServerClient.getBimsie1ServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			// Look for a deserializer
			SDeserializerPluginConfiguration deserializer = bimServerClient.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
			
			// Checkin file
			bimServerClient.checkin(project.getOid(), "test", deserializer.getOid(), false, true, Paths.get("../TestData/data/AC11-Institute-Var-2-IFC.ifc"));
			
			// Refresh project
			project = bimServerClient.getBimsie1ServiceInterface().getProjectByPoid(project.getOid());
			
			// Load model without lazy loading (complete model at once)
			IfcModelInterface model = bimServerClient.getModel(project, project.getLastRevisionId(), true, false);

			// Iterate over all projects, there should be 1
			for (IfcProject ifcProject : model.getAllWithSubTypes(IfcProject.class)) {
				for (IfcRelDefines ifcRelDefines : ifcProject.getIsDefinedBy()) {
					if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
						IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
						IfcPropertySetDefinition relatingPropertyDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
						if (relatingPropertyDefinition instanceof IfcPropertySet) {
							IfcPropertySet ifcPropertySet = (IfcPropertySet)relatingPropertyDefinition;
							for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
								if (ifcProperty instanceof IfcPropertySingleValue) {
									IfcPropertySingleValue ifcPropertySingleValue = (IfcPropertySingleValue)ifcProperty;
									IfcValue nominalValue = ifcPropertySingleValue.getNominalValue();
									String stringValue = "";
									if (nominalValue instanceof IfcLabel) {
										stringValue = ((IfcLabel)nominalValue).getWrappedValue();
									} else if (nominalValue instanceof IfcIdentifier) {
										stringValue = ((IfcIdentifier)nominalValue).getWrappedValue();
									} else if (nominalValue instanceof IfcAreaMeasure) {
										stringValue = "" + ((IfcAreaMeasure)nominalValue).getWrappedValue();
									}
									if (ifcPropertySingleValue.getName().equals("ConstructionMode")) {
										if (!stringValue.equals("Massivbau")) {
											fail("Massivbau expected");
										}
									} else if (ifcPropertySingleValue.getName().equals("BuildingPermitId")) {
										if (!stringValue.equals("4711")) {
											fail("4711 expected");
										}
									} else if (ifcPropertySingleValue.getName().equals("GrossAreaPlanned")) {
										if (stringValue == null || !stringValue.equals("1000.0")) {
											fail("1000. expected");
										}
									}
									System.out.println(ifcPropertySingleValue.getName() + ": " + stringValue);
								}
							}
						}
					}
				}
			}
		} catch (Throwable e) {
			if (!(e instanceof AssertionError)) {
				fail(e.getMessage());
			}
		}
	}
}
