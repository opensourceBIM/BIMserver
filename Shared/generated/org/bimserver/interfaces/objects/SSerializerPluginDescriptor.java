package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.bimserver.shared.meta.*;

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