package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;
/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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
import javax.xml.bind.annotation.XmlTransient;

import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SDataBase;
import org.bimserver.shared.meta.SField;


@XmlRootElement
public class SGeometryData implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private byte[] indices;
	private byte[] vertices;
	private byte[] normals;
	private byte[] materials;
	private byte[] materialIndices;
	private SVector4f color;

	public long getOid() {
		return this.oid;
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
		SGeometryData.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("indices")) {
			return getIndices();
		}
		if (sField.getName().equals("vertices")) {
			return getVertices();
		}
		if (sField.getName().equals("normals")) {
			return getNormals();
		}
		if (sField.getName().equals("materials")) {
			return getMaterials();
		}
		if (sField.getName().equals("materialIndices")) {
			return getMaterialIndices();
		}
		if (sField.getName().equals("color")) {
			return getColor();
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
		if (sField.getName().equals("indices")) {
			setIndices((byte[])val);
			return;
		}
		if (sField.getName().equals("vertices")) {
			setVertices((byte[])val);
			return;
		}
		if (sField.getName().equals("normals")) {
			setNormals((byte[])val);
			return;
		}
		if (sField.getName().equals("materials")) {
			setMaterials((byte[])val);
			return;
		}
		if (sField.getName().equals("materialIndices")) {
			setMaterialIndices((byte[])val);
			return;
		}
		if (sField.getName().equals("color")) {
			setColor((SVector4f)val);
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
	
	public byte[] getIndices() {
		return indices;
	}

	public void setIndices(byte[] indices) {
		this.indices = indices;
	}
	
	public byte[] getVertices() {
		return vertices;
	}

	public void setVertices(byte[] vertices) {
		this.vertices = vertices;
	}
	
	public byte[] getNormals() {
		return normals;
	}

	public void setNormals(byte[] normals) {
		this.normals = normals;
	}
	
	public byte[] getMaterials() {
		return materials;
	}

	public void setMaterials(byte[] materials) {
		this.materials = materials;
	}
	
	public byte[] getMaterialIndices() {
		return materialIndices;
	}

	public void setMaterialIndices(byte[] materialIndices) {
		this.materialIndices = materialIndices;
	}
	
	public SVector4f getColor() {
		return color;
	}

	public void setColor(SVector4f color) {
		this.color = color;
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
		SGeometryData other = (SGeometryData) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}