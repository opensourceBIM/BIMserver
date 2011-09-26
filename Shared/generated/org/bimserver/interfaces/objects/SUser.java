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

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

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
	
	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("password")) {
			return getPassword();
		}
		if (sField.getName().equals("hasRightsOn")) {
			return getHasRightsOn();
		}
		if (sField.getName().equals("revisions")) {
			return getRevisions();
		}
		if (sField.getName().equals("state")) {
			return getState();
		}
		if (sField.getName().equals("createdOn")) {
			return getCreatedOn();
		}
		if (sField.getName().equals("createdById")) {
			return getCreatedById();
		}
		if (sField.getName().equals("userType")) {
			return getUserType();
		}
		if (sField.getName().equals("username")) {
			return getUsername();
		}
		if (sField.getName().equals("lastSeen")) {
			return getLastSeen();
		}
		if (sField.getName().equals("validationToken")) {
			return getValidationToken();
		}
		if (sField.getName().equals("validationTokenCreated")) {
			return getValidationTokenCreated();
		}
		if (sField.getName().equals("notificationUrl")) {
			return getNotificationUrl();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
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