package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import nl.tue.buildingsmart.emf.SchemaLoader;

import org.bimserver.citygml.CityGmlSerializer;
import org.bimserver.ifc.FileFieldIgnoreMap;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.utils.CollectionUtils;

import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class CityGmlTest {
	public static void main(String[] args) {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer ifcStepDeserializer = new IfcStepDeserializer();
		ifcStepDeserializer.init(schema);
		ResourceFetcher resourceFetcher = new LocalDevelopmentResourceFetcher();
		PluginManager pluginManager = new PluginManager(resourceFetcher, null, null);
		try {
			IfcModelInterface model = ifcStepDeserializer.read(TestFile.AC11.getFile());
			try {
				CityGmlSerializer cityGmlSerializer = new CityGmlSerializer();
				cityGmlSerializer.init(model, null, pluginManager);
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
		} catch (DeserializationException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
