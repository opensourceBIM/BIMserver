package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SRevision implements SBase
{
	private long oid = -1;
	@XmlTransient
	private static SClass sClass;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SRevision.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("id")) {
			return getId();
		}
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("comment")) {
			return getComment();
		}
		if (sField.getName().equals("size")) {
			return getSize();
		}
		if (sField.getName().equals("concreteRevisions")) {
			return getConcreteRevisions();
		}
		if (sField.getName().equals("lastConcreteRevisionId")) {
			return getLastConcreteRevisionId();
		}
		if (sField.getName().equals("checkouts")) {
			return getCheckouts();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("state")) {
			return getState();
		}
		if (sField.getName().equals("lastClashes")) {
			return getLastClashes();
		}
		if (sField.getName().equals("tag")) {
			return getTag();
		}
		if (sField.getName().equals("lastError")) {
			return getLastError();
		}
		if (sField.getName().equals("bmi")) {
			return getBmi();
		}
		if (sField.getName().equals("nrClashes")) {
			return getNrClashes();
		}
		if (sField.getName().equals("laid")) {
			return getLaid();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	@SuppressWarnings("unchecked")
	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("id")) {
			setId((Integer)val);
			return;
		}
		if (sField.getName().equals("userId")) {
			setUserId((Long)val);
			return;
		}
		if (sField.getName().equals("date")) {
			setDate((Date)val);
			return;
		}
		if (sField.getName().equals("comment")) {
			setComment((String)val);
			return;
		}
		if (sField.getName().equals("size")) {
			setSize((Long)val);
			return;
		}
		if (sField.getName().equals("concreteRevisions")) {
			setConcreteRevisions((List<Long>)val);
			return;
		}
		if (sField.getName().equals("lastConcreteRevisionId")) {
			setLastConcreteRevisionId((Long)val);
			return;
		}
		if (sField.getName().equals("checkouts")) {
			setCheckouts((List<Long>)val);
			return;
		}
		if (sField.getName().equals("projectId")) {
			setProjectId((Long)val);
			return;
		}
		if (sField.getName().equals("state")) {
			setState((SCheckinState)val);
			return;
		}
		if (sField.getName().equals("lastClashes")) {
			setLastClashes((List<Long>)val);
			return;
		}
		if (sField.getName().equals("tag")) {
			setTag((String)val);
			return;
		}
		if (sField.getName().equals("lastError")) {
			setLastError((String)val);
			return;
		}
		if (sField.getName().equals("bmi")) {
			setBmi((Integer)val);
			return;
		}
		if (sField.getName().equals("nrClashes")) {
			setNrClashes((Integer)val);
			return;
		}
		if (sField.getName().equals("laid")) {
			setLaid((Long)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private java.lang.Integer id;
	private long userId;
	private java.util.Date date;
	private java.lang.String comment;
	private java.lang.Long size;
	private List<Long> concreteRevisions = new ArrayList<Long>();
	private long lastConcreteRevisionId;
	private List<Long> checkouts = new ArrayList<Long>();
	private long projectId;
	private SCheckinState state;
	private List<Long> lastClashes = new ArrayList<Long>();
	private java.lang.String tag;
	private java.lang.String lastError;
	private java.lang.Integer bmi;
	private java.lang.Integer nrClashes;
	private java.lang.Long laid;
	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
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
	public java.lang.Long getSize() {
		return size;
	}

	public void setSize(java.lang.Long size) {
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
	public java.lang.Integer getBmi() {
		return bmi;
	}

	public void setBmi(java.lang.Integer bmi) {
		this.bmi = bmi;
	}
	public java.lang.Integer getNrClashes() {
		return nrClashes;
	}

	public void setNrClashes(java.lang.Integer nrClashes) {
		this.nrClashes = nrClashes;
	}
	public java.lang.Long getLaid() {
		return laid;
	}

	public void setLaid(java.lang.Long laid) {
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