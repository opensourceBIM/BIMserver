package org.bimserver.plugins;

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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PluginDescriptorWriter {
	private static final Logger LOGGER = LoggerFactory.getLogger(PluginDescriptorWriter.class);
	public static void main(String[] args) {
		new PluginDescriptorWriter().start();
	}

	private void start() {
		PluginDescriptor pluginDescriptor = new PluginDescriptor();
		
		JavaPlugin pluginImplementation = new JavaPlugin();
		pluginImplementation.setInterfaceClass("blabla");
		pluginImplementation.setImplementationClass("blabla");
		pluginDescriptor.getPlugins().add(pluginImplementation);
		
		WebModulePlugin webModulePlugin = new WebModulePlugin();
		webModulePlugin.setDescription("test");
		webModulePlugin.setIdentifier("kaka");
		
		pluginDescriptor.getPlugins().add(webModulePlugin);
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PluginDescriptor.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(pluginDescriptor, new FileOutputStream("test.xml"));
		} catch (JAXBException e) {
			LOGGER.error("", e);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} 
	}
}
