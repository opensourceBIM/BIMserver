package org.bimserver.interfaces.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SProject
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
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