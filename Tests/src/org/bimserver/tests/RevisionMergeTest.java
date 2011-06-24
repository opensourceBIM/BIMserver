package org.bimserver.tests;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.ifc.IfcModel;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.EmfSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerPlugin;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class RevisionMergeTest {
	public static void main(String[] args) {
		new RevisionMergeTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(pluginManager.requireSchemaDefinition());
			IfcModelInterface model1 = deserializer.read(TestFile.EXPORT1.getFile(), true);
			IfcModelInterface model2 = deserializer.read(TestFile.EXPORT3.getFile(), true);
			model1.setObjectOids();
			model2.setObjectOids();
			model1.indexGuids();
			model2.indexGuids();
			model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
			IfcModel merged = new RevisionMerger(model1, model2).merge();
			SerializerPlugin serializerPlugin = pluginManager.getFirstSerializerPlugin("application/ifc", true);
			EmfSerializer serializer = serializerPlugin.createSerializer();
			serializer.init(merged, null, null);
			serializer.writeToFile(new File("merged.ifc"));
		} catch (DeserializationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}