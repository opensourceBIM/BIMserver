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
public class SBimServerInfo implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String currentVersion;
	private java.util.Date currentDate;
	private int schemaVersion;
	private java.util.Date latestDate;
	private java.lang.String latestVersion;
	private int projects;
	private int revisions;
	private int users;
	private int checkouts;
	private java.lang.String serverLogUrl;
	private java.util.Date started;

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
		SBimServerInfo.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("currentVersion")) {
			return getCurrentVersion();
		}
		if (sField.getName().equals("currentDate")) {
			return getCurrentDate();
		}
		if (sField.getName().equals("schemaVersion")) {
			return getSchemaVersion();
		}
		if (sField.getName().equals("latestDate")) {
			return getLatestDate();
		}
		if (sField.getName().equals("latestVersion")) {
			return getLatestVersion();
		}
		if (sField.getName().equals("projects")) {
			return getProjects();
		}
		if (sField.getName().equals("revisions")) {
			return getRevisions();
		}
		if (sField.getName().equals("users")) {
			return getUsers();
		}
		if (sField.getName().equals("checkouts")) {
			return getCheckouts();
		}
		if (sField.getName().equals("serverLogUrl")) {
			return getServerLogUrl();
		}
		if (sField.getName().equals("started")) {
			return getStarted();
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
		if (sField.getName().equals("currentVersion")) {
			setCurrentVersion((String)val);
			return;
		}
		if (sField.getName().equals("currentDate")) {
			setCurrentDate((Date)val);
			return;
		}
		if (sField.getName().equals("schemaVersion")) {
			setSchemaVersion((Integer)val);
			return;
		}
		if (sField.getName().equals("latestDate")) {
			setLatestDate((Date)val);
			return;
		}
		if (sField.getName().equals("latestVersion")) {
			setLatestVersion((String)val);
			return;
		}
		if (sField.getName().equals("projects")) {
			setProjects((Integer)val);
			return;
		}
		if (sField.getName().equals("revisions")) {
			setRevisions((Integer)val);
			return;
		}
		if (sField.getName().equals("users")) {
			setUsers((Integer)val);
			return;
		}
		if (sField.getName().equals("checkouts")) {
			setCheckouts((Integer)val);
			return;
		}
		if (sField.getName().equals("serverLogUrl")) {
			setServerLogUrl((String)val);
			return;
		}
		if (sField.getName().equals("started")) {
			setStarted((Date)val);
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
	
	public java.lang.String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(java.lang.String currentVersion) {
		this.currentVersion = currentVersion;
	}
	
	public java.util.Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(java.util.Date currentDate) {
		this.currentDate = currentDate;
	}
	
	public int getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(int schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	
	public java.util.Date getLatestDate() {
		return latestDate;
	}

	public void setLatestDate(java.util.Date latestDate) {
		this.latestDate = latestDate;
	}
	
	public java.lang.String getLatestVersion() {
		return latestVersion;
	}

	public void setLatestVersion(java.lang.String latestVersion) {
		this.latestVersion = latestVersion;
	}
	
	public int getProjects() {
		return projects;
	}

	public void setProjects(int projects) {
		this.projects = projects;
	}
	
	public int getRevisions() {
		return revisions;
	}

	public void setRevisions(int revisions) {
		this.revisions = revisions;
	}
	
	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}
	
	public int getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(int checkouts) {
		this.checkouts = checkouts;
	}
	
	public java.lang.String getServerLogUrl() {
		return serverLogUrl;
	}

	public void setServerLogUrl(java.lang.String serverLogUrl) {
		this.serverLogUrl = serverLogUrl;
	}
	
	public java.util.Date getStarted() {
		return started;
	}

	public void setStarted(java.util.Date started) {
		this.started = started;
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
		SBimServerInfo other = (SBimServerInfo) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}