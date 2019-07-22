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
public class SCheckout implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private long userId = -1;
	private SRevision revision;
	private long projectId = -1;
	private java.util.Date date;
	private SRevision checkin;
	private java.lang.Boolean active;
	private List<Long> logs = new ArrayList<Long>();

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
		SCheckout.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("revision")) {
			return getRevision();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("checkin")) {
			return getCheckin();
		}
		if (sField.getName().equals("active")) {
			return getActive();
		}
		if (sField.getName().equals("logs")) {
			return getLogs();
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
		if (sField.getName().equals("userId")) {
			setUserId((Long)val);
			return;
		}
		if (sField.getName().equals("revision")) {
			setRevision((SRevision)val);
			return;
		}
		if (sField.getName().equals("projectId")) {
			setProjectId((Long)val);
			return;
		}
		if (sField.getName().equals("date")) {
			setDate((Date)val);
			return;
		}
		if (sField.getName().equals("checkin")) {
			setCheckin((SRevision)val);
			return;
		}
		if (sField.getName().equals("active")) {
			setActive((Boolean)val);
			return;
		}
		if (sField.getName().equals("logs")) {
			setLogs((List<Long>)val);
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
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public SRevision getRevision() {
		return revision;
	}

	public void setRevision(SRevision revision) {
		this.revision = revision;
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
	
	public SRevision getCheckin() {
		return checkin;
	}

	public void setCheckin(SRevision checkin) {
		this.checkin = checkin;
	}
	
	
	public java.lang.Boolean getActive() {
		return active;
	}

	public void setActive(java.lang.Boolean active) {
		this.active = active;
	}
	
	public List<Long> getLogs() {
		return logs;
	}

	public void setLogs(List<Long> logs) {
		this.logs = logs;
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