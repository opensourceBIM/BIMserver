package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SExternalProfile implements SBase
{
	private long oid = -1;
	@XmlTransient
	private static SClass sClass;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SExternalProfile.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("serverId")) {
			return getServerId();
		}
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("readRevision")) {
			return isReadRevision();
		}
		if (sField.getName().equals("readExtendedData")) {
			return isReadExtendedData();
		}
		if (sField.getName().equals("writeRevisionId")) {
			return getWriteRevisionId();
		}
		if (sField.getName().equals("writeExtendedDataId")) {
			return getWriteExtendedDataId();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("serverId")) {
			setServerId((Long)val);
			return;
		}
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("readRevision")) {
			setReadRevision((Boolean)val);
			return;
		}
		if (sField.getName().equals("readExtendedData")) {
			setReadExtendedData((Boolean)val);
			return;
		}
		if (sField.getName().equals("writeRevisionId")) {
			setWriteRevisionId((Long)val);
			return;
		}
		if (sField.getName().equals("writeExtendedDataId")) {
			setWriteExtendedDataId((Long)val);
			return;
		}
		if (sField.getName().equals("projectId")) {
			setProjectId((Long)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private long serverId;
	private java.lang.String name;
	private java.lang.String description;
	private boolean readRevision;
	private boolean readExtendedData;
	private long writeRevisionId;
	private long writeExtendedDataId;
	private long projectId;
	public long getServerId() {
		return serverId;
	}

	public void setServerId(long serverId) {
		this.serverId = serverId;
	}
	
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
	public boolean isReadRevision() {
		return readRevision;
	}

	public void setReadRevision(boolean readRevision) {
		this.readRevision = readRevision;
	}
	public boolean isReadExtendedData() {
		return readExtendedData;
	}

	public void setReadExtendedData(boolean readExtendedData) {
		this.readExtendedData = readExtendedData;
	}
	public long getWriteRevisionId() {
		return writeRevisionId;
	}

	public void setWriteRevisionId(long writeRevisionId) {
		this.writeRevisionId = writeRevisionId;
	}
	
	public long getWriteExtendedDataId() {
		return writeExtendedDataId;
	}

	public void setWriteExtendedDataId(long writeExtendedDataId) {
		this.writeExtendedDataId = writeExtendedDataId;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
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
		SExternalProfile other = (SExternalProfile) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}