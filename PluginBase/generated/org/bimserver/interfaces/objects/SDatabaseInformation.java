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
public class SDatabaseInformation implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.Integer numberOfProjects;
	private java.lang.Integer numberOfUsers;
	private java.lang.Integer numberOfRevisions;
	private java.lang.Integer numberOfCheckouts;
	private java.lang.Long databaseSizeInBytes;
	private java.lang.String type;
	private java.util.Date created;
	private java.lang.String location;
	private java.lang.Integer schemaVersion;
	private List<SDatabaseInformationCategory> categories = new ArrayList<SDatabaseInformationCategory>();

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
		SDatabaseInformation.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("numberOfProjects")) {
			return getNumberOfProjects();
		}
		if (sField.getName().equals("numberOfUsers")) {
			return getNumberOfUsers();
		}
		if (sField.getName().equals("numberOfRevisions")) {
			return getNumberOfRevisions();
		}
		if (sField.getName().equals("numberOfCheckouts")) {
			return getNumberOfCheckouts();
		}
		if (sField.getName().equals("databaseSizeInBytes")) {
			return getDatabaseSizeInBytes();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("created")) {
			return getCreated();
		}
		if (sField.getName().equals("location")) {
			return getLocation();
		}
		if (sField.getName().equals("schemaVersion")) {
			return getSchemaVersion();
		}
		if (sField.getName().equals("categories")) {
			return getCategories();
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
		if (sField.getName().equals("numberOfProjects")) {
			setNumberOfProjects((Integer)val);
			return;
		}
		if (sField.getName().equals("numberOfUsers")) {
			setNumberOfUsers((Integer)val);
			return;
		}
		if (sField.getName().equals("numberOfRevisions")) {
			setNumberOfRevisions((Integer)val);
			return;
		}
		if (sField.getName().equals("numberOfCheckouts")) {
			setNumberOfCheckouts((Integer)val);
			return;
		}
		if (sField.getName().equals("databaseSizeInBytes")) {
			setDatabaseSizeInBytes((Long)val);
			return;
		}
		if (sField.getName().equals("type")) {
			setType((String)val);
			return;
		}
		if (sField.getName().equals("created")) {
			setCreated((Date)val);
			return;
		}
		if (sField.getName().equals("location")) {
			setLocation((String)val);
			return;
		}
		if (sField.getName().equals("schemaVersion")) {
			setSchemaVersion((Integer)val);
			return;
		}
		if (sField.getName().equals("categories")) {
			setCategories((List<SDatabaseInformationCategory>)val);
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
	
	public java.lang.Integer getNumberOfProjects() {
		return numberOfProjects;
	}

	public void setNumberOfProjects(java.lang.Integer numberOfProjects) {
		this.numberOfProjects = numberOfProjects;
	}
	
	public java.lang.Integer getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(java.lang.Integer numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}
	
	public java.lang.Integer getNumberOfRevisions() {
		return numberOfRevisions;
	}

	public void setNumberOfRevisions(java.lang.Integer numberOfRevisions) {
		this.numberOfRevisions = numberOfRevisions;
	}
	
	public java.lang.Integer getNumberOfCheckouts() {
		return numberOfCheckouts;
	}

	public void setNumberOfCheckouts(java.lang.Integer numberOfCheckouts) {
		this.numberOfCheckouts = numberOfCheckouts;
	}
	
	public java.lang.Long getDatabaseSizeInBytes() {
		return databaseSizeInBytes;
	}

	public void setDatabaseSizeInBytes(java.lang.Long databaseSizeInBytes) {
		this.databaseSizeInBytes = databaseSizeInBytes;
	}
	
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	public java.util.Date getCreated() {
		return created;
	}

	public void setCreated(java.util.Date created) {
		this.created = created;
	}
	
	public java.lang.String getLocation() {
		return location;
	}

	public void setLocation(java.lang.String location) {
		this.location = location;
	}
	
	public java.lang.Integer getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(java.lang.Integer schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	
	public List<SDatabaseInformationCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<SDatabaseInformationCategory> categories) {
		this.categories = categories;
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
		SDatabaseInformation other = (SDatabaseInformation) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}