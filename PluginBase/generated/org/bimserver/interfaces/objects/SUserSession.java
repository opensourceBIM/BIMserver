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
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SUserSession implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private long userId = -1;
	private java.lang.String username;
	private java.lang.String name;
	private SUserType type;
	private java.lang.String remoteAddress;
	private java.util.Date activeSince;
	private java.util.Date lastActive;
	private SAccessMethod accessMethod;

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
		SUserSession.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("username")) {
			return getUsername();
		}
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("remoteAddress")) {
			return getRemoteAddress();
		}
		if (sField.getName().equals("activeSince")) {
			return getActiveSince();
		}
		if (sField.getName().equals("lastActive")) {
			return getLastActive();
		}
		if (sField.getName().equals("accessMethod")) {
			return getAccessMethod();
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

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("userId")) {
			setUserId((Long)val);
			return;
		}
		if (sField.getName().equals("username")) {
			setUsername((String)val);
			return;
		}
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("type")) {
			setType((SUserType)val);
			return;
		}
		if (sField.getName().equals("remoteAddress")) {
			setRemoteAddress((String)val);
			return;
		}
		if (sField.getName().equals("activeSince")) {
			setActiveSince((Date)val);
			return;
		}
		if (sField.getName().equals("lastActive")) {
			setLastActive((Date)val);
			return;
		}
		if (sField.getName().equals("accessMethod")) {
			setAccessMethod((SAccessMethod)val);
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
	
	public java.lang.String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(java.lang.String remoteAddress) {
		this.remoteAddress = remoteAddress;
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