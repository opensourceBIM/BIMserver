package org.bimserver.interfaces.objects;

import java.util.*;

public class SRevision {
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
	private List<Long> concreteRevisions;
	private long lastConcreteRevisionId;
	private List<Long> checkouts;
	private long projectId;
	private boolean finalized;
	private List<Long> lastClashes;
	private boolean processingClashes;
	private java.lang.String tag;

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

	public boolean isFinalized() {
		return finalized;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}

	public List<Long> getLastClashes() {
		return lastClashes;
	}

	public void setLastClashes(List<Long> lastClashes) {
		this.lastClashes = lastClashes;
	}

	public boolean isProcessingClashes() {
		return processingClashes;
	}

	public void setProcessingClashes(boolean processingClashes) {
		this.processingClashes = processingClashes;
	}

	public java.lang.String getTag() {
		return tag;
	}

	public void setTag(java.lang.String tag) {
		this.tag = tag;
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