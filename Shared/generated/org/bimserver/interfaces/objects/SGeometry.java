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
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SGeometry implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private long boundsId = -1;
	private List<java.lang.Integer> indices = new ArrayList<java.lang.Integer>();
	private List<java.lang.Float> vertices = new ArrayList<java.lang.Float>();
	private List<java.lang.Float> normals = new ArrayList<java.lang.Float>();
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
		SGeometry.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("boundsId")) {
			return getBoundsId();
		}
		if (sField.getName().equals("indices")) {
			return getIndices();
		}
		if (sField.getName().equals("vertices")) {
			return getVertices();
		}
		if (sField.getName().equals("normals")) {
			return getNormals();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	@SuppressWarnings("unchecked")

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("boundsId")) {
			setBoundsId((Long)val);
			return;
		}
		if (sField.getName().equals("indices")) {
			setIndices((List<Integer>)val);
			return;
		}
		if (sField.getName().equals("vertices")) {
			setVertices((List<Float>)val);
			return;
		}
		if (sField.getName().equals("normals")) {
			setNormals((List<Float>)val);
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
	
	public long getBoundsId() {
		return boundsId;
	}

	public void setBoundsId(long boundsId) {
		this.boundsId = boundsId;
	}
	

	public List<java.lang.Integer> getIndices() {
		return indices;
	}

	public void setIndices(List<java.lang.Integer> indices) {
		this.indices = indices;
	}
	

	public List<java.lang.Float> getVertices() {
		return vertices;
	}

	public void setVertices(List<java.lang.Float> vertices) {
		this.vertices = vertices;
	}
	

	public List<java.lang.Float> getNormals() {
		return normals;
	}

	public void setNormals(List<java.lang.Float> normals) {
		this.normals = normals;
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
		SGeometry other = (SGeometry) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}