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

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SCheckout implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("Checkout");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("userId", long.class));
		sClass.addField(new SField("revisionId", long.class));
		sClass.addField(new SField("projectId", long.class));
		sClass.addField(new SField("date", java.util.Date.class));
		sClass.addField(new SField("checkinId", long.class));
		sClass.addField(new SField("active", boolean.class));
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
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("revisionId")) {
			return getRevisionId();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("checkinId")) {
			return getCheckinId();
		}
		if (sField.getName().equals("active")) {
			return isActive();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private long userId;
	private long revisionId;
	private long projectId;
	private java.util.Date date;
	private long checkinId;
	private boolean active;
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(long revisionId) {
		this.revisionId = revisionId;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public long getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(long checkinId) {
		this.checkinId = checkinId;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
		SCheckout other = (SCheckout) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}