package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PluginDescriptor")
@XmlAccessorType(XmlAccessType.NONE)
public class PluginDescriptor {
	
	@XmlElement(name="PluginImplementation")
	private List<PluginImplementation> implementations = new ArrayList<PluginImplementation>();

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
}
