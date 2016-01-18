package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PluginDescriptor")
@XmlAccessorType(XmlAccessType.NONE)
public class PluginDescriptor {
	
	@XmlElement(name="PluginImplementation")
	private List<PluginImplementation> implementations = new ArrayList<PluginImplementation>();
	
//	@XmlElementWrapper(name="dependencies")
//	@XmlElement(name="Dependency")
//	private List<Dependency> dependencies = new ArrayList<Dependency>();
	
//	public List<Dependency> getDependencies() {
//		return dependencies;
//	}
//	
//	public void setDependencies(List<Dependency> dependencies) {
//		this.dependencies = dependencies;
//	}

	public void setImplementations(List<PluginImplementation> implementations) {
		this.implementations = implementations;
	}

	public List<PluginImplementation> getImplementations() {
		return implementations;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (PluginImplementation pluginImplementation : implementations) {
			sb.append(pluginImplementation.toString() + "\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		PluginDescriptor descriptor = new PluginDescriptor();
//		Dependency dependency = new Dependency();
//		dependency.setPath("test");
		PluginImplementation pluginImplementation = new PluginImplementation();
		descriptor.getImplementations().add(pluginImplementation);
//		descriptor.getDependencies().add(dependency);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PluginDescriptor.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(descriptor, new FileOutputStream(new File("testdescriptor.xml")));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}