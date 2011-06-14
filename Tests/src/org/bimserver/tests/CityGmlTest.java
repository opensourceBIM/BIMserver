package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.bimserver.citygml.CityGmlSerializer;
import org.bimserver.ifc.FileFieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.ifc.step.deserializer.IncorrectIfcFileException;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.ifcengine.IfcEngineFactory;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.PluginManager;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.utils.CollectionUtils;

public class CityGmlTest {
	public static void main(String[] args) {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer ifcStepDeserializer = new IfcStepDeserializer();
		ifcStepDeserializer.init(schema);
		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		FileFieldIgnoreMap fieldIgnoreMap = new FileFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), resourceFetcher);
		File nativeFolder = resourceFetcher.getFile("lib/" + File.separator + System.getProperty("sun.arch.data.model"));
		PluginManager osgiManager = new PluginManager();
		IfcEngineFactory ifcEngineFactory = new IfcEngineFactory(SchemaLoader.DEFAULT_SCHEMA_FILE, nativeFolder, new File("tmp"), null, osgiManager.getAllIfcEnginePlugins().iterator().next());
		try {
			IfcModel model = ifcStepDeserializer.read(TestFile.AC11.getFile());
			try {
				CityGmlSerializer cityGmlSerializer = new CityGmlSerializer();
				cityGmlSerializer.init(model, schema, fieldIgnoreMap, ifcEngineFactory, null);
				FileOutputStream fos = new FileOutputStream(new File("out.citygml"));
				cityGmlSerializer.write(fos);
				fos.close();
			} catch (SerializerException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IncorrectIfcFileException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
