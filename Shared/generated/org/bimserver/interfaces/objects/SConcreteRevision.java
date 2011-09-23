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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SConcreteRevision implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("ConcreteRevision");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("id", int.class));
		sClass.addField(new SField("projectId", long.class));
		sClass.addField(new SField("state", SCheckinState.class));
		sClass.addField(new SField("checksum", byte[].class));
		sClass.addField(new SField("revisions", Long.class, true));
		sClass.addField(new SField("size", long.class));
		sClass.addField(new SField("date", java.util.Date.class));
		sClass.addField(new SField("lastError", java.lang.String.class));
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
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("state")) {
			return getState();
		}
		if (sField.getName().equals("checksum")) {
			return getChecksum();
		}
		if (sField.getName().equals("revisions")) {
			return getRevisions();
		}
		if (sField.getName().equals("size")) {
			return getSize();
		}
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("lastError")) {
			return getLastError();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private int id;
	private long projectId;
	private SCheckinState state;
	private byte[] checksum;
	private List<Long> revisions = new ArrayList<Long>();
	private long size;
	private java.util.Date date;
	private java.lang.String lastError;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public SCheckinState getState() {
		return state;
	}

	public void setState(SCheckinState state) {
		this.state = state;
	}
	public byte[] getChecksum() {
		return checksum;
	}

	public void setChecksum(byte[] checksum) {
		this.checksum = checksum;
	}
	public List<Long> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Long> revisions) {
		this.revisions = revisions;
	}
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public java.lang.String getLastError() {
		return lastError;
	}

	public void setLastError(java.lang.String lastError) {
		this.lastError = lastError;
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
		SConcreteRevision other = (SConcreteRevision) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}