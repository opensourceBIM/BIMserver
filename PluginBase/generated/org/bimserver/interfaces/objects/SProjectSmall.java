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
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SProjectSmall implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private long parentId;
	private SObjectState state;
	private int nrRevisions;
	private int nrSubProjects;
	private boolean hasCheckinRights;
	private long lastRevisionId;
	private java.lang.String schema;

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
		SProjectSmall.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("parentId")) {
			return getParentId();
		}
		if (sField.getName().equals("state")) {
			return getState();
		}
		if (sField.getName().equals("nrRevisions")) {
			return getNrRevisions();
		}
		if (sField.getName().equals("nrSubProjects")) {
			return getNrSubProjects();
		}
		if (sField.getName().equals("hasCheckinRights")) {
			return isHasCheckinRights();
		}
		if (sField.getName().equals("lastRevisionId")) {
			return getLastRevisionId();
		}
		if (sField.getName().equals("schema")) {
			return getSchema();
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
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("parentId")) {
			setParentId((Long)val);
			return;
		}
		if (sField.getName().equals("state")) {
			setState((SObjectState)val);
			return;
		}
		if (sField.getName().equals("nrRevisions")) {
			setNrRevisions((Integer)val);
			return;
		}
		if (sField.getName().equals("nrSubProjects")) {
			setNrSubProjects((Integer)val);
			return;
		}
		if (sField.getName().equals("hasCheckinRights")) {
			setHasCheckinRights((Boolean)val);
			return;
		}
		if (sField.getName().equals("lastRevisionId")) {
			setLastRevisionId((Long)val);
			return;
		}
		if (sField.getName().equals("schema")) {
			setSchema((String)val);
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
	
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	public SObjectState getState() {
		return state;
	}

	public void setState(SObjectState state) {
		this.state = state;
	}
	
	public int getNrRevisions() {
		return nrRevisions;
	}

	public void setNrRevisions(int nrRevisions) {
		this.nrRevisions = nrRevisions;
	}
	
	public int getNrSubProjects() {
		return nrSubProjects;
	}

	public void setNrSubProjects(int nrSubProjects) {
		this.nrSubProjects = nrSubProjects;
	}
	
	public boolean isHasCheckinRights() {
		return hasCheckinRights;
	}

	public void setHasCheckinRights(boolean hasCheckinRights) {
		this.hasCheckinRights = hasCheckinRights;
	}
	
	public long getLastRevisionId() {
		return lastRevisionId;
	}

	public void setLastRevisionId(long lastRevisionId) {
		this.lastRevisionId = lastRevisionId;
	}
	
	public java.lang.String getSchema() {
		return schema;
	}

	public void setSchema(java.lang.String schema) {
		this.schema = schema;
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
		SProjectSmall other = (SProjectSmall) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}