package org.bimserver.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.Schema;
import org.bimserver.ifc.step.deserializer.Ifc2x3tc1StepDeserializer;
import org.bimserver.ifc.step.deserializer.IfcStepDeserializer;
import org.bimserver.plugins.OptionsParser;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class ToXMI {
	public static void main(String[] args) {
		new ToXMI().start(args);
	}

	private void start(String[] args) {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			File outputFile = new File("test.xmi");
			Resource resource = resourceSet.createResource(URI.createFileURI(outputFile.getAbsolutePath()));
			IfcStepDeserializer ifcStepDeserializer = new Ifc2x3tc1StepDeserializer(Schema.IFC2X3TC1);
			
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
	 		LocalDevPluginLoader.loadPlugins(pluginManager, new File(".."), new OptionsParser(args).getPluginDirectories());
			
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			ifcStepDeserializer.init(metaDataManager.getEPackage(Schema.IFC2X3TC1.name()));
			IfcModelInterface model = ifcStepDeserializer.read(new File("../TestData/data/export1.ifc"));
			System.out.println(model.getValues().size());
			System.out.println(resource);
			resource.getContents().addAll(model.getValues());
			resource.getContents().addAll(model.getUnidentifiedValues());
			resource.save(new FileOutputStream(outputFile), null);
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
