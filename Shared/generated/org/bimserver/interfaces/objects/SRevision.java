package org.bimserver.interfaces.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SRevision
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private int id;
	private long userId;
	private java.util.Date date;
	private java.lang.String comment;
	private long size;
	private List<Long> concreteRevisions = new ArrayList<Long>();
	private long lastConcreteRevisionId;
	private List<Long> checkouts = new ArrayList<Long>();
	private long projectId;
	private SCheckinState state;
	private List<Long> lastClashes = new ArrayList<Long>();
	private java.lang.String tag;
	private java.lang.String lastError;
	private int bmi;
	private int nrClashes;
	private long laid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public java.lang.String getComment() {
		return comment;
	}

	public void setComment(java.lang.String comment) {
		this.comment = comment;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	public List<Long> getConcreteRevisions() {
		return concreteRevisions;
	}

	public void setConcreteRevisions(List<Long> concreteRevisions) {
		this.concreteRevisions = concreteRevisions;
	}
	public long getLastConcreteRevisionId() {
		return lastConcreteRevisionId;
	}

	public void setLastConcreteRevisionId(long lastConcreteRevisionId) {
		this.lastConcreteRevisionId = lastConcreteRevisionId;
	}
	
	public List<Long> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(List<Long> checkouts) {
		this.checkouts = checkouts;
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
	public List<Long> getLastClashes() {
		return lastClashes;
	}

	public void setLastClashes(List<Long> lastClashes) {
		this.lastClashes = lastClashes;
	}

	public java.lang.String getTag() {
		return tag;
	}

	public void setTag(java.lang.String tag) {
		this.tag = tag;
	}

	public java.lang.String getLastError() {
		return lastError;
	}

	public void setLastError(java.lang.String lastError) {
		this.lastError = lastError;
	}

	public int getBmi() {
		return bmi;
	}

	public void setBmi(int bmi) {
		this.bmi = bmi;
	}

	public int getNrClashes() {
		return nrClashes;
	}

	public void setNrClashes(int nrClashes) {
		this.nrClashes = nrClashes;
	}

	public long getLaid() {
		return laid;
	}

	public void setLaid(long laid) {
		this.laid = laid;
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
		SRevision other = (SRevision) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}