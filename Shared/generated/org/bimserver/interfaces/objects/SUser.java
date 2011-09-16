package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.bimserver.shared.meta.*;

@XmlRootElement
public class SUser implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("User");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("name", java.lang.String.class));
		sClass.addField(new SField("password", java.lang.String.class));
		sClass.addField(new SField("hasRightsOn", Long.class, true));
		sClass.addField(new SField("revisions", Long.class, true));
		sClass.addField(new SField("state", SObjectState.class));
		sClass.addField(new SField("createdOn", java.util.Date.class));
		sClass.addField(new SField("createdById", long.class));
		sClass.addField(new SField("userType", SUserType.class));
		sClass.addField(new SField("username", java.lang.String.class));
		sClass.addField(new SField("lastSeen", java.util.Date.class));
		sClass.addField(new SField("validationToken", java.lang.String.class));
		sClass.addField(new SField("validationTokenCreated", java.util.Date.class));
		sClass.addField(new SField("notificationUrl", java.lang.String.class));
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
	private java.lang.String password;
	private List<Long> hasRightsOn = new ArrayList<Long>();
	private List<Long> revisions = new ArrayList<Long>();
	private SObjectState state;
	private java.util.Date createdOn;
	private long createdById;
	private SUserType userType;
	private java.lang.String username;
	private java.util.Date lastSeen;
	private java.lang.String validationToken;
	private java.util.Date validationTokenCreated;
	private java.lang.String notificationUrl;

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
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

	public java.lang.String getValidationToken() {
		return validationToken;
	}

	public void setValidationToken(java.lang.String validationToken) {
		this.validationToken = validationToken;
	}

	public java.util.Date getValidationTokenCreated() {
		return validationTokenCreated;
	}

	public void setValidationTokenCreated(java.util.Date validationTokenCreated) {
		this.validationTokenCreated = validationTokenCreated;
	}

	public java.lang.String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(java.lang.String notificationUrl) {
		this.notificationUrl = notificationUrl;
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