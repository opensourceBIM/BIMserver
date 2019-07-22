package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SUser implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private byte[] passwordHash;
	private byte[] passwordSalt;
	private List<Long> hasRightsOn = new ArrayList<Long>();
	private SObjectState state;
	private java.util.Date createdOn;
	private long createdById = -1;
	private SUserType userType;
	private java.lang.String username;
	private java.util.Date lastSeen;
	private java.lang.String token;
	private byte[] validationToken;
	private java.util.Date validationTokenCreated;
	private long userSettingsId = -1;
	private List<Long> schemas = new ArrayList<Long>();
	private List<Long> extendedData = new ArrayList<Long>();
	private List<Long> services = new ArrayList<Long>();
	private List<Long> logs = new ArrayList<Long>();
	private List<Long> oAuthAuthorizationCodes = new ArrayList<Long>();
	private List<Long> oAuthIssuedAuthorizationCodes = new ArrayList<Long>();

	public long getOid() {
		return this.oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public UUID getUuid() {
		return this.uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public int getRid() {
		return rid;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SUser.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("passwordHash")) {
			return getPasswordHash();
		}
		if (sField.getName().equals("passwordSalt")) {
			return getPasswordSalt();
		}
		if (sField.getName().equals("hasRightsOn")) {
			return getHasRightsOn();
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
		if (sField.getName().equals("token")) {
			return getToken();
		}
		if (sField.getName().equals("validationToken")) {
			return getValidationToken();
		}
		if (sField.getName().equals("validationTokenCreated")) {
			return getValidationTokenCreated();
		}
		if (sField.getName().equals("userSettingsId")) {
			return getUserSettingsId();
		}
		if (sField.getName().equals("schemas")) {
			return getSchemas();
		}
		if (sField.getName().equals("extendedData")) {
			return getExtendedData();
		}
		if (sField.getName().equals("services")) {
			return getServices();
		}
		if (sField.getName().equals("logs")) {
			return getLogs();
		}
		if (sField.getName().equals("oAuthAuthorizationCodes")) {
			return getOAuthAuthorizationCodes();
		}
		if (sField.getName().equals("oAuthIssuedAuthorizationCodes")) {
			return getOAuthIssuedAuthorizationCodes();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		if (sField.getName().equals("uuid")) {
			return getUuid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	@SuppressWarnings("unchecked")

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("passwordHash")) {
			setPasswordHash((byte[])val);
			return;
		}
		if (sField.getName().equals("passwordSalt")) {
			setPasswordSalt((byte[])val);
			return;
		}
		if (sField.getName().equals("hasRightsOn")) {
			setHasRightsOn((List<Long>)val);
			return;
		}
		if (sField.getName().equals("state")) {
			setState((SObjectState)val);
			return;
		}
		if (sField.getName().equals("createdOn")) {
			setCreatedOn((Date)val);
			return;
		}
		if (sField.getName().equals("createdById")) {
			setCreatedById((Long)val);
			return;
		}
		if (sField.getName().equals("userType")) {
			setUserType((SUserType)val);
			return;
		}
		if (sField.getName().equals("username")) {
			setUsername((String)val);
			return;
		}
		if (sField.getName().equals("lastSeen")) {
			setLastSeen((Date)val);
			return;
		}
		if (sField.getName().equals("token")) {
			setToken((String)val);
			return;
		}
		if (sField.getName().equals("validationToken")) {
			setValidationToken((byte[])val);
			return;
		}
		if (sField.getName().equals("validationTokenCreated")) {
			setValidationTokenCreated((Date)val);
			return;
		}
		if (sField.getName().equals("userSettingsId")) {
			setUserSettingsId((Long)val);
			return;
		}
		if (sField.getName().equals("schemas")) {
			setSchemas((List<Long>)val);
			return;
		}
		if (sField.getName().equals("extendedData")) {
			setExtendedData((List<Long>)val);
			return;
		}
		if (sField.getName().equals("services")) {
			setServices((List<Long>)val);
			return;
		}
		if (sField.getName().equals("logs")) {
			setLogs((List<Long>)val);
			return;
		}
		if (sField.getName().equals("oAuthAuthorizationCodes")) {
			setOAuthAuthorizationCodes((List<Long>)val);
			return;
		}
		if (sField.getName().equals("oAuthIssuedAuthorizationCodes")) {
			setOAuthIssuedAuthorizationCodes((List<Long>)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		if (sField.getName().equals("rid")) {
			setRid((Integer)val);
			return;
		}
		if (sField.getName().equals("uuid")) {
			setUuid((UUID)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public byte[] getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(byte[] passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	public byte[] getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	
	public List<Long> getHasRightsOn() {
		return hasRightsOn;
	}

	public void setHasRightsOn(List<Long> hasRightsOn) {
		this.hasRightsOn = hasRightsOn;
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
	
	public java.lang.String getToken() {
		return token;
	}

	public void setToken(java.lang.String token) {
		this.token = token;
	}
	
	public byte[] getValidationToken() {
		return validationToken;
	}

	public void setValidationToken(byte[] validationToken) {
		this.validationToken = validationToken;
	}
	
	public java.util.Date getValidationTokenCreated() {
		return validationTokenCreated;
	}

	public void setValidationTokenCreated(java.util.Date validationTokenCreated) {
		this.validationTokenCreated = validationTokenCreated;
	}
	
	public long getUserSettingsId() {
		return userSettingsId;
	}

	public void setUserSettingsId(long userSettingsId) {
		this.userSettingsId = userSettingsId;
	}
	
	public List<Long> getSchemas() {
		return schemas;
	}

	public void setSchemas(List<Long> schemas) {
		this.schemas = schemas;
	}
	
	public List<Long> getExtendedData() {
		return extendedData;
	}

	public void setExtendedData(List<Long> extendedData) {
		this.extendedData = extendedData;
	}
	
	public List<Long> getServices() {
		return services;
	}

	public void setServices(List<Long> services) {
		this.services = services;
	}
	
	public List<Long> getLogs() {
		return logs;
	}

	public void setLogs(List<Long> logs) {
		this.logs = logs;
	}
	
	public List<Long> getOAuthAuthorizationCodes() {
		return oAuthAuthorizationCodes;
	}

	public void setOAuthAuthorizationCodes(List<Long> oAuthAuthorizationCodes) {
		this.oAuthAuthorizationCodes = oAuthAuthorizationCodes;
	}
	
	public List<Long> getOAuthIssuedAuthorizationCodes() {
		return oAuthIssuedAuthorizationCodes;
	}

	public void setOAuthIssuedAuthorizationCodes(List<Long> oAuthIssuedAuthorizationCodes) {
		this.oAuthIssuedAuthorizationCodes = oAuthIssuedAuthorizationCodes;
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