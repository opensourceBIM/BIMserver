package org.bimserver.plugins;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class PluginDescriptorWriter {
	public static void main(String[] args) {
		new PluginDescriptorWriter().start();
	}

	private void start() {
		PluginDescriptor pluginDescriptor = new PluginDescriptor();
		PluginImplementation pluginImplementation = new PluginImplementation();
		pluginImplementation.setInterfaceClass("blabla");
		pluginImplementation.setImplementationClass("blabla");
		pluginDescriptor.getImplementations().add(pluginImplementation);
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PluginDescriptor.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(pluginDescriptor, new FileOutputStream("test.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
