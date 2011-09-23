package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SSerializerPluginDescriptor implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("SerializerPluginDescriptor");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("pluginClassName", java.lang.String.class));
		sClass.addField(new SField("defaultName", java.lang.String.class));
		sClass.addField(new SField("defaultExtension", java.lang.String.class));
		sClass.addField(new SField("defaultContentType", java.lang.String.class));
	}
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	public SClass getSClass() {
		return sClass;
	}
	
	public Object sGet(SField sField) {
		if (sField.getName().equals("pluginClassName")) {
			return getPluginClassName();
		}
		if (sField.getName().equals("defaultName")) {
			return getDefaultName();
		}
		if (sField.getName().equals("defaultExtension")) {
			return getDefaultExtension();
		}
		if (sField.getName().equals("defaultContentType")) {
			return getDefaultContentType();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private java.lang.String pluginClassName;
	private java.lang.String defaultName;
	private java.lang.String defaultExtension;
	private java.lang.String defaultContentType;
	public java.lang.String getPluginClassName() {
		return pluginClassName;
	}

	public void setPluginClassName(java.lang.String pluginClassName) {
		this.pluginClassName = pluginClassName;
	}
	public java.lang.String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(java.lang.String defaultName) {
		this.defaultName = defaultName;
	}
	public java.lang.String getDefaultExtension() {
		return defaultExtension;
	}

	public void setDefaultExtension(java.lang.String defaultExtension) {
		this.defaultExtension = defaultExtension;
	}
	public java.lang.String getDefaultContentType() {
		return defaultContentType;
	}

	public void setDefaultContentType(java.lang.String defaultContentType) {
		this.defaultContentType = defaultContentType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SSerializerPluginDescriptor other = (SSerializerPluginDescriptor) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}