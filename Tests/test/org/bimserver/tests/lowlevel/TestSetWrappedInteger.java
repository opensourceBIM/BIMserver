package org.bimserver.tests.lowlevel;

import static org.junit.Assert.fail;

import java.nio.file.Paths;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.Flow;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.test.TestWithEmbeddedServer;
import org.junit.Test;

public class TestSetWrappedInteger extends TestWithEmbeddedServer {

	@Test
	public void test() {
		try {
			BimServerClientInterface bimServerClient = getFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			bimServerClient.getSettingsInterface().setCacheOutputFiles(false);
			LowLevelInterface lowLevelInterface = bimServerClient.getLowLevelInterface();
			
			SProject newProject = bimServerClient.getServiceInterface().addProject("test" + Math.random(), "ifc2x3tc1");
			
			SDeserializerPluginConfiguration suggestedDeserializerForExtension = bimServerClient.getServiceInterface().getSuggestedDeserializerForExtension("ifc", newProject.getOid());
			bimServerClient.checkin(newProject.getOid(), "initial", suggestedDeserializerForExtension.getOid(), false, Flow.SYNC, Paths.get("../TestData/data/revit_quantities.ifc"));
			newProject = bimServerClient.getServiceInterface().getProjectByPoid(newProject.getOid());
			
			SSerializerPluginConfiguration serializer = bimServerClient.getServiceInterface().getSerializerByName("Ifc2x3");
			
			bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), Paths.get("test1.ifc"));

			IfcModelInterface model = bimServerClient.getModel(newProject, newProject.getLastRevisionId(), false, false);
			long tid = lowLevelInterface.startTransaction(newProject.getOid());
			
			IfcPropertySingleValue ifcPropertySingleValue = model.getAll(IfcPropertySingleValue.class).iterator().next();

			bimServerClient.getLowLevelInterface().setWrappedIntegerAttribute(tid, ifcPropertySingleValue.getOid(), "NominalValue", "IfcInteger", 12345);

			long roid = lowLevelInterface.commitTransaction(tid, "v2");
			
			bimServerClient.download(newProject.getLastRevisionId(), serializer.getOid(), Paths.get("test2.ifc"));
			
			bimServerClient.download(roid, serializer.getOid(), Paths.get("test3.ifc"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}