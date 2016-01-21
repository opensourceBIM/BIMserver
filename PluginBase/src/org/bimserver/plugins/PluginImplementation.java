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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class PluginImplementation {
	@XmlElement
	private boolean enabled;

	@XmlElement
	private String interfaceClass;

	@XmlElement
	private String implementationJson;

	@XmlElement
	private String implementationClass;
	
	@XmlElement
	private String description;
	
	@XmlElement
	private List<String> requires = new ArrayList<String>();
	
	public String getInterfaceClass() {
		return interfaceClass;
	}

	public void setInterfaceClass(String interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public String getImplementationClass() {
		return implementationClass;
	}

	public void setImplementationClass(String implementationClass) {
		this.implementationClass = implementationClass;
	}
	
	@Override
	public String toString() {
		return interfaceClass + " / " + implementationClass;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<String> getRequires() {
		return requires;
	}

	public void setRequires(List<String> requires) {
		this.requires = requires;
	}

	public String getImplementationJson() {
		return implementationJson;
	}

	public void setImplementationJson(String implementationJson) {
		this.implementationJson = implementationJson;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}