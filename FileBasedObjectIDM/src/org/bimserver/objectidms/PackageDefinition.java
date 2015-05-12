package org.bimserver.objectidms;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PackageDefinition")
@XmlAccessorType(XmlAccessType.FIELD)
public class PackageDefinition {
	@XmlAttribute(name = "name")
	private String name;
	
	@XmlElement(name = "ClassDefinition")
	private List<ClassDefinition> classDefinitions = new ArrayList<ClassDefinition>();

	public PackageDefinition() {
	}

	public List<ClassDefinition> getClassDefinitions() {
		return classDefinitions;
	}

	public void setClassDefinitions(List<ClassDefinition> classDefinitions) {
		this.classDefinitions = classDefinitions;
	}

	public boolean hasClassDefinition(String name) {
		for (ClassDefinition classDefinition : classDefinitions) {
			if (classDefinition.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	public void writeToFile(File file) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(PackageDefinition.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(this, file);
	}
	
	public static PackageDefinition readFromFile(File file) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(PackageDefinition.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		Object unmarshal = unmarshaller.unmarshal(file);
		PackageDefinition settings = (PackageDefinition) unmarshal;
		return settings;
	}
	
	public static PackageDefinition readFromFile(URL resource) throws JAXBException, IOException {
		JAXBContext jc = JAXBContext.newInstance(PackageDefinition.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		Object unmarshal = unmarshaller.unmarshal(resource.openStream());
		PackageDefinition settings = (PackageDefinition) unmarshal;
		return settings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}