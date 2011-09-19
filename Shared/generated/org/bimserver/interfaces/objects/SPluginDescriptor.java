package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SPluginDescriptor implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("PluginDescriptor");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("name", java.lang.String.class));
		sClass.addField(new SField("description", java.lang.String.class));
		sClass.addField(new SField("location", java.lang.String.class));
		sClass.addField(new SField("enabled", boolean.class));
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
	private java.lang.String name;
	private java.lang.String description;
	private java.lang.String location;
	private boolean enabled;
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public java.lang.String getLocation() {
		return location;
	}

	public void setLocation(java.lang.String location) {
		this.location = location;
	}
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
		SPluginDescriptor other = (SPluginDescriptor) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}