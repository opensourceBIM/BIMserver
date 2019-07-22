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
public class SProject implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.Integer id;
	private java.lang.String name;
	private List<Long> hasAuthorizedUsers = new ArrayList<Long>();
	private List<Long> concreteRevisions = new ArrayList<Long>();
	private List<Long> revisions = new ArrayList<Long>();
	private long lastConcreteRevisionId = -1;
	private long lastRevisionId = -1;
	private List<Long> checkouts = new ArrayList<Long>();
	private SObjectState state;
	private java.util.Date createdDate;
	private long createdById = -1;
	private long geoTagId = -1;
	private List<Long> subProjects = new ArrayList<Long>();
	private long parentId = -1;
	private java.lang.String description;
	private SSIPrefix exportLengthMeasurePrefix;
	private List<Long> extendedData = new ArrayList<Long>();
	private List<Long> services = new ArrayList<Long>();
	private List<Long> logs = new ArrayList<Long>();
	private List<Long> modelCheckers = new ArrayList<Long>();
	private java.lang.String schema;
	private boolean sendEmailOnNewRevision;
	private List<Long> newServices = new ArrayList<Long>();
	private long checkinInProgress;

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
		SProject.sClass = sClass;
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
		if (sField.getName().equals("exportLengthMeasurePrefix")) {
			return getExportLengthMeasurePrefix();
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
		if (sField.getName().equals("modelCheckers")) {
			return getModelCheckers();
		}
		if (sField.getName().equals("schema")) {
			return getSchema();
		}
		if (sField.getName().equals("sendEmailOnNewRevision")) {
			return isSendEmailOnNewRevision();
		}
		if (sField.getName().equals("newServices")) {
			return getNewServices();
		}
		if (sField.getName().equals("checkinInProgress")) {
			return getCheckinInProgress();
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
		if (sField.getName().equals("id")) {
			setId((Integer)val);
			return;
		}
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("hasAuthorizedUsers")) {
			setHasAuthorizedUsers((List<Long>)val);
			return;
		}
		if (sField.getName().equals("concreteRevisions")) {
			setConcreteRevisions((List<Long>)val);
			return;
		}
		if (sField.getName().equals("revisions")) {
			setRevisions((List<Long>)val);
			return;
		}
		if (sField.getName().equals("lastConcreteRevisionId")) {
			setLastConcreteRevisionId((Long)val);
			return;
		}
		if (sField.getName().equals("lastRevisionId")) {
			setLastRevisionId((Long)val);
			return;
		}
		if (sField.getName().equals("checkouts")) {
			setCheckouts((List<Long>)val);
			return;
		}
		if (sField.getName().equals("state")) {
			setState((SObjectState)val);
			return;
		}
		if (sField.getName().equals("createdDate")) {
			setCreatedDate((Date)val);
			return;
		}
		if (sField.getName().equals("createdById")) {
			setCreatedById((Long)val);
			return;
		}
		if (sField.getName().equals("geoTagId")) {
			setGeoTagId((Long)val);
			return;
		}
		if (sField.getName().equals("subProjects")) {
			setSubProjects((List<Long>)val);
			return;
		}
		if (sField.getName().equals("parentId")) {
			setParentId((Long)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("exportLengthMeasurePrefix")) {
			setExportLengthMeasurePrefix((SSIPrefix)val);
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
		if (sField.getName().equals("modelCheckers")) {
			setModelCheckers((List<Long>)val);
			return;
		}
		if (sField.getName().equals("schema")) {
			setSchema((String)val);
			return;
		}
		if (sField.getName().equals("sendEmailOnNewRevision")) {
			setSendEmailOnNewRevision((Boolean)val);
			return;
		}
		if (sField.getName().equals("newServices")) {
			setNewServices((List<Long>)val);
			return;
		}
		if (sField.getName().equals("checkinInProgress")) {
			setCheckinInProgress((Long)val);
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
	
	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
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
	
	public SSIPrefix getExportLengthMeasurePrefix() {
		return exportLengthMeasurePrefix;
	}

	public void setExportLengthMeasurePrefix(SSIPrefix exportLengthMeasurePrefix) {
		this.exportLengthMeasurePrefix = exportLengthMeasurePrefix;
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
	
	public List<Long> getModelCheckers() {
		return modelCheckers;
	}

	public void setModelCheckers(List<Long> modelCheckers) {
		this.modelCheckers = modelCheckers;
	}
	
	public java.lang.String getSchema() {
		return schema;
	}

	public void setSchema(java.lang.String schema) {
		this.schema = schema;
	}
	
	public boolean isSendEmailOnNewRevision() {
		return sendEmailOnNewRevision;
	}

	public void setSendEmailOnNewRevision(boolean sendEmailOnNewRevision) {
		this.sendEmailOnNewRevision = sendEmailOnNewRevision;
	}
	
	public List<Long> getNewServices() {
		return newServices;
	}

	public void setNewServices(List<Long> newServices) {
		this.newServices = newServices;
	}
	
	public long getCheckinInProgress() {
		return checkinInProgress;
	}

	public void setCheckinInProgress(long checkinInProgress) {
		this.checkinInProgress = checkinInProgress;
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