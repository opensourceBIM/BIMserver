package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SUserSession implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("UserSession");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("userId", long.class));
		sClass.addField(new SField("username", java.lang.String.class));
		sClass.addField(new SField("name", java.lang.String.class));
		sClass.addField(new SField("type", SUserType.class));
		sClass.addField(new SField("activeSince", java.util.Date.class));
		sClass.addField(new SField("lastActive", java.util.Date.class));
		sClass.addField(new SField("accessMethod", SAccessMethod.class));
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
	private long userId;
	private java.lang.String username;
	private java.lang.String name;
	private SUserType type;
	private java.util.Date activeSince;
	private java.util.Date lastActive;
	private SAccessMethod accessMethod;
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public java.lang.String getUsername() {
		return username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	public SUserType getType() {
		return type;
	}

	public void setType(SUserType type) {
		this.type = type;
	}
	public java.util.Date getActiveSince() {
		return activeSince;
	}

	public void setActiveSince(java.util.Date activeSince) {
		this.activeSince = activeSince;
	}
	public java.util.Date getLastActive() {
		return lastActive;
	}

	public void setLastActive(java.util.Date lastActive) {
		this.lastActive = lastActive;
	}
	public SAccessMethod getAccessMethod() {
		return accessMethod;
	}

	public void setAccessMethod(SAccessMethod accessMethod) {
		this.accessMethod = accessMethod;
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
		SUserSession other = (SUserSession) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}