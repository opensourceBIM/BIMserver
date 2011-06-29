package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SPlugin
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private java.lang.String name;
	private boolean enabled;
	private long settingsId;

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public long getSettingsId() {
		return settingsId;
	}

	public void setSettingsId(long settingsId) {
		this.settingsId = settingsId;
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
		SPlugin other = (SPlugin) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}