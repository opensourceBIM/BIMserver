package org.bimserver.unittests;

import static org.junit.Assert.fail;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.junit.Test;

public class TestIfcStepSerializer {
	@Test
	public void testSerializer() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
			EmfSerializer serializer = serializerPlugin.createSerializer();
			IfcModel model = new IfcModel();
			IfcWall wall = Ifc2x3tc1Factory.eINSTANCE.createIfcWall();
			model.add(wall);
			wall.setName("Test with 'quotes");
			serializer.init(model, null, pluginManager, pluginManager.requireIfcEngine().createIfcEngine());
			serializer.writeToFile(new File("output/test.ifc"));
		} catch (PluginException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}
}