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
public class SIfcHeader implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private List<java.lang.String> description = new ArrayList<java.lang.String>();
	private java.lang.String implementationLevel;
	private java.lang.String filename;
	private java.util.Date timeStamp;
	private List<java.lang.String> author = new ArrayList<java.lang.String>();
	private List<java.lang.String> organization = new ArrayList<java.lang.String>();
	private java.lang.String preProcessorVersion;
	private java.lang.String originatingSystem;
	private java.lang.String ifcSchemaVersion;
	private java.lang.String authorization;

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
		SIfcHeader.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("implementationLevel")) {
			return getImplementationLevel();
		}
		if (sField.getName().equals("filename")) {
			return getFilename();
		}
		if (sField.getName().equals("timeStamp")) {
			return getTimeStamp();
		}
		if (sField.getName().equals("author")) {
			return getAuthor();
		}
		if (sField.getName().equals("organization")) {
			return getOrganization();
		}
		if (sField.getName().equals("preProcessorVersion")) {
			return getPreProcessorVersion();
		}
		if (sField.getName().equals("originatingSystem")) {
			return getOriginatingSystem();
		}
		if (sField.getName().equals("ifcSchemaVersion")) {
			return getIfcSchemaVersion();
		}
		if (sField.getName().equals("authorization")) {
			return getAuthorization();
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
		if (sField.getName().equals("description")) {
			setDescription((List<String>)val);
			return;
		}
		if (sField.getName().equals("implementationLevel")) {
			setImplementationLevel((String)val);
			return;
		}
		if (sField.getName().equals("filename")) {
			setFilename((String)val);
			return;
		}
		if (sField.getName().equals("timeStamp")) {
			setTimeStamp((Date)val);
			return;
		}
		if (sField.getName().equals("author")) {
			setAuthor((List<String>)val);
			return;
		}
		if (sField.getName().equals("organization")) {
			setOrganization((List<String>)val);
			return;
		}
		if (sField.getName().equals("preProcessorVersion")) {
			setPreProcessorVersion((String)val);
			return;
		}
		if (sField.getName().equals("originatingSystem")) {
			setOriginatingSystem((String)val);
			return;
		}
		if (sField.getName().equals("ifcSchemaVersion")) {
			setIfcSchemaVersion((String)val);
			return;
		}
		if (sField.getName().equals("authorization")) {
			setAuthorization((String)val);
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
	

	public List<java.lang.String> getDescription() {
		return description;
	}

	public void setDescription(List<java.lang.String> description) {
		this.description = description;
	}
	
	public java.lang.String getImplementationLevel() {
		return implementationLevel;
	}

	public void setImplementationLevel(java.lang.String implementationLevel) {
		this.implementationLevel = implementationLevel;
	}
	
	public java.lang.String getFilename() {
		return filename;
	}

	public void setFilename(java.lang.String filename) {
		this.filename = filename;
	}
	
	public java.util.Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(java.util.Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	

	public List<java.lang.String> getAuthor() {
		return author;
	}

	public void setAuthor(List<java.lang.String> author) {
		this.author = author;
	}
	

	public List<java.lang.String> getOrganization() {
		return organization;
	}

	public void setOrganization(List<java.lang.String> organization) {
		this.organization = organization;
	}
	
	public java.lang.String getPreProcessorVersion() {
		return preProcessorVersion;
	}

	public void setPreProcessorVersion(java.lang.String preProcessorVersion) {
		this.preProcessorVersion = preProcessorVersion;
	}
	
	public java.lang.String getOriginatingSystem() {
		return originatingSystem;
	}

	public void setOriginatingSystem(java.lang.String originatingSystem) {
		this.originatingSystem = originatingSystem;
	}
	
	public java.lang.String getIfcSchemaVersion() {
		return ifcSchemaVersion;
	}

	public void setIfcSchemaVersion(java.lang.String ifcSchemaVersion) {
		this.ifcSchemaVersion = ifcSchemaVersion;
	}
	
	public java.lang.String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(java.lang.String authorization) {
		this.authorization = authorization;
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
		SIfcHeader other = (SIfcHeader) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}