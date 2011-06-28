package org.bimserver.guidanceproviders;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PackageDefinition")
@XmlAccessorType(XmlAccessType.FIELD)
public class PackageDefinition {
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

	public static PackageDefinition readFromFile(URL resource) throws JAXBException, IOException {
		JAXBContext jc = JAXBContext.newInstance(PackageDefinition.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		Object unmarshal = unmarshaller.unmarshal(resource.openStream());
		PackageDefinition settings = (PackageDefinition) unmarshal;
		return settings;
	}
}
