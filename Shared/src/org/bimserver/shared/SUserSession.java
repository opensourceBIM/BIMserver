package org.bimserver.shared;

import java.util.Date;

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SUserType;

public class SUserSession {
	private long uoid;
	private String username;
	private String name;
	private SUserType type;
	private Date activeSince;
	private Date lastActive;
	private SAccessMethod accessMethod;

	public long getUoid() {
		return uoid;
	}

	public void setUoid(long uoid) {
		this.uoid = uoid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getActiveSince() {
		return activeSince;
	}

	public void setActiveSince(Date activeSince) {
		this.activeSince = activeSince;
	}

	public Date getLastActive() {
		return lastActive;
	}

	public void setLastActive(Date lastActive) {
		this.lastActive = lastActive;
	}

	public void setType(SUserType type) {
		this.type = type;
	}

	public SUserType getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAccessMethod(SAccessMethod accessMethod) {
		this.accessMethod = accessMethod;
	}

	public SAccessMethod getAccessMethod() {
		return accessMethod;
	}
}