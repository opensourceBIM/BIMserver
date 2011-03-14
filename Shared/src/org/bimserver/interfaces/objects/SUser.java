package org.bimserver.interfaces.objects;

import java.util.ArrayList;
import java.util.List;

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
	private java.lang.String attr1;
	private List<java.lang.String> attr2 = new ArrayList<java.lang.String>();
	private SObjectState attr3;
	private long ref1Id;
	private List<Long> ref2 = new ArrayList<Long>();

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

	public java.lang.String getAttr1() {
		return attr1;
	}

	public void setAttr1(java.lang.String attr1) {
		this.attr1 = attr1;
	}

	public List<java.lang.String> getAttr2() {
		return attr2;
	}

	public void setAttr2(List<java.lang.String> attr2) {
		this.attr2 = attr2;
	}
	public SObjectState getAttr3() {
		return attr3;
	}

	public void setAttr3(SObjectState attr3) {
		this.attr3 = attr3;
	}
	public long getRef1Id() {
		return ref1Id;
	}

	public void setRef1Id(long ref1Id) {
		this.ref1Id = ref1Id;
	}
	
	public List<Long> getRef2() {
		return ref2;
	}

	public void setRef2(List<Long> ref2) {
		this.ref2 = ref2;
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