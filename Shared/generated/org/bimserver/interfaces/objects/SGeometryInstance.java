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
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SGeometryInstance implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.Integer startVertex;
	private java.lang.Integer startIndex;
	private java.lang.Integer primitiveCount;
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
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
		SGeometryInstance.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("startVertex")) {
			return getStartVertex();
		}
		if (sField.getName().equals("startIndex")) {
			return getStartIndex();
		}
		if (sField.getName().equals("primitiveCount")) {
			return getPrimitiveCount();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("startVertex")) {
			setStartVertex((Integer)val);
			return;
		}
		if (sField.getName().equals("startIndex")) {
			setStartIndex((Integer)val);
			return;
		}
		if (sField.getName().equals("primitiveCount")) {
			setPrimitiveCount((Integer)val);
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
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public java.lang.Integer getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(java.lang.Integer startVertex) {
		this.startVertex = startVertex;
	}
	
	public java.lang.Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(java.lang.Integer startIndex) {
		this.startIndex = startIndex;
	}
	
	public java.lang.Integer getPrimitiveCount() {
		return primitiveCount;
	}

	public void setPrimitiveCount(java.lang.Integer primitiveCount) {
		this.primitiveCount = primitiveCount;
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
		SGeometryInstance other = (SGeometryInstance) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}