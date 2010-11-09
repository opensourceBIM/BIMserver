package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SUser
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private java.lang.String name;
	private List<Long> hasRightsOn;
	private List<Long> revisions;
	private SObjectState state;
	private java.util.Date createdOn;
	private long createdById;
	private SUserType userType;
	private java.lang.String username;
	private java.util.Date lastSeen;

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	public List<Long> getHasRightsOn() {
		return hasRightsOn;
	}

	public void setHasRightsOn(List<Long> hasRightsOn) {
		this.hasRightsOn = hasRightsOn;
	}
	public List<Long> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Long> revisions) {
		this.revisions = revisions;
	}
	public SObjectState getState() {
		return state;
	}

	public void setState(SObjectState state) {
		this.state = state;
	}

	public java.util.Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(java.util.Date createdOn) {
		this.createdOn = createdOn;
	}
	public long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(long createdById) {
		this.createdById = createdById;
	}
	
	public SUserType getUserType() {
		return userType;
	}

	public void setUserType(SUserType userType) {
		this.userType = userType;
	}

	public java.lang.String getUsername() {
		return username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	public java.util.Date getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(java.util.Date lastSeen) {
		this.lastSeen = lastSeen;
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
		SUser other = (SUser) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}