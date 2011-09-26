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
public class SProject implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("Project");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("id", int.class));
		sClass.addField(new SField("name", java.lang.String.class));
		sClass.addField(new SField("hasAuthorizedUsers", Long.class, true));
		sClass.addField(new SField("concreteRevisions", Long.class, true));
		sClass.addField(new SField("revisions", Long.class, true));
		sClass.addField(new SField("lastConcreteRevisionId", long.class));
		sClass.addField(new SField("lastRevisionId", long.class));
		sClass.addField(new SField("checkouts", Long.class, true));
		sClass.addField(new SField("state", SObjectState.class));
		sClass.addField(new SField("createdDate", java.util.Date.class));
		sClass.addField(new SField("createdById", long.class));
		sClass.addField(new SField("geoTagId", long.class));
		sClass.addField(new SField("subProjects", Long.class, true));
		sClass.addField(new SField("parentId", long.class));
		sClass.addField(new SField("description", java.lang.String.class));
		sClass.addField(new SField("clashDetectionSettingsId", long.class));
		sClass.addField(new SField("exportLengthMeasurePrefix", SSIPrefix.class));
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
		if (sField.getName().equals("id")) {
			return getId();
		}
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("hasAuthorizedUsers")) {
			return getHasAuthorizedUsers();
		}
		if (sField.getName().equals("concreteRevisions")) {
			return getConcreteRevisions();
		}
		if (sField.getName().equals("revisions")) {
			return getRevisions();
		}
		if (sField.getName().equals("lastConcreteRevisionId")) {
			return getLastConcreteRevisionId();
		}
		if (sField.getName().equals("lastRevisionId")) {
			return getLastRevisionId();
		}
		if (sField.getName().equals("checkouts")) {
			return getCheckouts();
		}
		if (sField.getName().equals("state")) {
			return getState();
		}
		if (sField.getName().equals("createdDate")) {
			return getCreatedDate();
		}
		if (sField.getName().equals("createdById")) {
			return getCreatedById();
		}
		if (sField.getName().equals("geoTagId")) {
			return getGeoTagId();
		}
		if (sField.getName().equals("subProjects")) {
			return getSubProjects();
		}
		if (sField.getName().equals("parentId")) {
			return getParentId();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("clashDetectionSettingsId")) {
			return getClashDetectionSettingsId();
		}
		if (sField.getName().equals("exportLengthMeasurePrefix")) {
			return getExportLengthMeasurePrefix();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("id")) {
			setId((Integer)val);
		}
		if (sField.getName().equals("name")) {
			setName((String)val);
		}
		if (sField.getName().equals("hasAuthorizedUsers")) {
			setHasAuthorizedUsers((List<Long>)val);
		}
		if (sField.getName().equals("concreteRevisions")) {
			setConcreteRevisions((List<Long>)val);
		}
		if (sField.getName().equals("revisions")) {
			setRevisions((List<Long>)val);
		}
		if (sField.getName().equals("lastConcreteRevisionId")) {
			setLastConcreteRevisionId((Long)val);
		}
		if (sField.getName().equals("lastRevisionId")) {
			setLastRevisionId((Long)val);
		}
		if (sField.getName().equals("checkouts")) {
			setCheckouts((List<Long>)val);
		}
		if (sField.getName().equals("state")) {
			setState((SObjectState)val);
		}
		if (sField.getName().equals("createdDate")) {
			setCreatedDate((Date)val);
		}
		if (sField.getName().equals("createdById")) {
			setCreatedById((Long)val);
		}
		if (sField.getName().equals("geoTagId")) {
			setGeoTagId((Long)val);
		}
		if (sField.getName().equals("subProjects")) {
			setSubProjects((List<Long>)val);
		}
		if (sField.getName().equals("parentId")) {
			setParentId((Long)val);
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
		}
		if (sField.getName().equals("clashDetectionSettingsId")) {
			setClashDetectionSettingsId((Long)val);
		}
		if (sField.getName().equals("exportLengthMeasurePrefix")) {
			setExportLengthMeasurePrefix((SSIPrefix)val);
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private int id;
	private java.lang.String name;
	private List<Long> hasAuthorizedUsers = new ArrayList<Long>();
	private List<Long> concreteRevisions = new ArrayList<Long>();
	private List<Long> revisions = new ArrayList<Long>();
	private long lastConcreteRevisionId;
	private long lastRevisionId;
	private List<Long> checkouts = new ArrayList<Long>();
	private SObjectState state;
	private java.util.Date createdDate;
	private long createdById;
	private long geoTagId;
	private List<Long> subProjects = new ArrayList<Long>();
	private long parentId;
	private java.lang.String description;
	private long clashDetectionSettingsId;
	private SSIPrefix exportLengthMeasurePrefix;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	public List<Long> getHasAuthorizedUsers() {
		return hasAuthorizedUsers;
	}

	public void setHasAuthorizedUsers(List<Long> hasAuthorizedUsers) {
		this.hasAuthorizedUsers = hasAuthorizedUsers;
	}
	public List<Long> getConcreteRevisions() {
		return concreteRevisions;
	}

	public void setConcreteRevisions(List<Long> concreteRevisions) {
		this.concreteRevisions = concreteRevisions;
	}
	public List<Long> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Long> revisions) {
		this.revisions = revisions;
	}
	public long getLastConcreteRevisionId() {
		return lastConcreteRevisionId;
	}

	public void setLastConcreteRevisionId(long lastConcreteRevisionId) {
		this.lastConcreteRevisionId = lastConcreteRevisionId;
	}
	
	public long getLastRevisionId() {
		return lastRevisionId;
	}

	public void setLastRevisionId(long lastRevisionId) {
		this.lastRevisionId = lastRevisionId;
	}
	
	public List<Long> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Long> checkouts) {
		this.checkouts = checkouts;
	}
	public SObjectState getState() {
		return state;
	}

	public void setState(SObjectState state) {
		this.state = state;
	}
	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(long createdById) {
		this.createdById = createdById;
	}
	
	public long getGeoTagId() {
		return geoTagId;
	}

	public void setGeoTagId(long geoTagId) {
		this.geoTagId = geoTagId;
	}
	
	public List<Long> getSubProjects() {
		return subProjects;
	}

	public void setSubProjects(List<Long> subProjects) {
		this.subProjects = subProjects;
	}
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public long getClashDetectionSettingsId() {
		return clashDetectionSettingsId;
	}

	public void setClashDetectionSettingsId(long clashDetectionSettingsId) {
		this.clashDetectionSettingsId = clashDetectionSettingsId;
	}
	
	public SSIPrefix getExportLengthMeasurePrefix() {
		return exportLengthMeasurePrefix;
	}

	public void setExportLengthMeasurePrefix(SSIPrefix exportLengthMeasurePrefix) {
		this.exportLengthMeasurePrefix = exportLengthMeasurePrefix;
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
		SProject other = (SProject) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}