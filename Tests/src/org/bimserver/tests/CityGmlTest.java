package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.citygml.CityGmlSerializer;
import org.bimserver.ifc.FileFieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.ifcengine.IfcEngineFactory;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.OSGIManager;
import org.bimserver.shared.ResourceFetcher;
import org.bimserver.utils.CollectionUtils;

public class CityGmlTest {
	public static void main(String[] args) {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer fastIfcFileReader = new IfcStepDeserializer(schema);
		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		FileFieldIgnoreMap fieldIgnoreMap = new FileFieldIgnoreMap(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), resourceFetcher);
		File nativeFolder = resourceFetcher.getFile("lib/" + File.separator + System.getProperty("sun.arch.data.model"));
		OSGIManager osgiManager = new OSGIManager();
		IfcEngineFactory ifcEngineFactory = new IfcEngineFactory(SchemaLoader.DEFAULT_SCHEMA_FILE, nativeFolder, new File("tmp"), null, osgiManager.getIfcPlugins().iterator().next());
		try {
			IfcModel model = fastIfcFileReader.read(TestFile.AC11.getFile());
			try {
				CityGmlSerializer cityGmlSerializer = new CityGmlSerializer();
				cityGmlSerializer.init(null, null, "test", model, schema, fieldIgnoreMap, ifcEngineFactory);
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
