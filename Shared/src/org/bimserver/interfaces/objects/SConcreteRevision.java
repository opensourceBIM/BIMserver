package org.bimserver.interfaces.objects;

import java.util.*;

public class SConcreteRevision
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private int id;
	private long projectId;
	private boolean finalized;
	private byte[] checksum;
	private List<Long> revisions;
	private long size;
	private java.util.Date date;

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
	

	public boolean isFinalized() {
		return finalized;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
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