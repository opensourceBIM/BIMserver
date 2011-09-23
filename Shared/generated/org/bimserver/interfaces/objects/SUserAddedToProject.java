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
public class SUserAddedToProject extends SLogAction implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("UserAddedToProject");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("date", java.util.Date.class));
		sClass.addField(new SField("executorId", long.class));
		sClass.addField(new SField("accessMethod", SAccessMethod.class));
		sClass.addField(new SField("userId", long.class));
		sClass.addField(new SField("projectId", long.class));
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
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("executorId")) {
			return getExecutorId();
		}
		if (sField.getName().equals("accessMethod")) {
			return getAccessMethod();
		}
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("projectId")) {
			return getProjectId();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private long userId;
	private long projectId;
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
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
		SUserAddedToProject other = (SUserAddedToProject) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}