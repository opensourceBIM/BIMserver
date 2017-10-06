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
public class SGeometryInfo implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private SVector3f minBounds;
	private SVector3f maxBounds;
	private java.lang.Integer startVertex;
	private java.lang.Integer startIndex;
	private java.lang.Integer primitiveCount;
	private long dataId = -1;
	private byte[] transformation;
	private double area;
	private double volume;
	private SVector3f minBoundsUntranslated;
	private SVector3f maxBoundsUntranslated;

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
		SGeometryInfo.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("minBounds")) {
			return getMinBounds();
		}
		if (sField.getName().equals("maxBounds")) {
			return getMaxBounds();
		}
		if (sField.getName().equals("startVertex")) {
			return getStartVertex();
		}
		if (sField.getName().equals("startIndex")) {
			return getStartIndex();
		}
		if (sField.getName().equals("primitiveCount")) {
			return getPrimitiveCount();
		}
		if (sField.getName().equals("dataId")) {
			return getDataId();
		}
		if (sField.getName().equals("transformation")) {
			return getTransformation();
		}
		if (sField.getName().equals("area")) {
			return getArea();
		}
		if (sField.getName().equals("volume")) {
			return getVolume();
		}
		if (sField.getName().equals("minBoundsUntranslated")) {
			return getMinBoundsUntranslated();
		}
		if (sField.getName().equals("maxBoundsUntranslated")) {
			return getMaxBoundsUntranslated();
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
		if (sField.getName().equals("minBounds")) {
			setMinBounds((SVector3f)val);
			return;
		}
		if (sField.getName().equals("maxBounds")) {
			setMaxBounds((SVector3f)val);
			return;
		}
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
		if (sField.getName().equals("dataId")) {
			setDataId((Long)val);
			return;
		}
		if (sField.getName().equals("transformation")) {
			setTransformation((byte[])val);
			return;
		}
		if (sField.getName().equals("area")) {
			setArea((Double)val);
			return;
		}
		if (sField.getName().equals("volume")) {
			setVolume((Double)val);
			return;
		}
		if (sField.getName().equals("minBoundsUntranslated")) {
			setMinBoundsUntranslated((SVector3f)val);
			return;
		}
		if (sField.getName().equals("maxBoundsUntranslated")) {
			setMaxBoundsUntranslated((SVector3f)val);
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
	
	public SVector3f getMinBounds() {
		return minBounds;
	}

	public void setMinBounds(SVector3f minBounds) {
		this.minBounds = minBounds;
	}
	
	
	public SVector3f getMaxBounds() {
		return maxBounds;
	}

	public void setMaxBounds(SVector3f maxBounds) {
		this.maxBounds = maxBounds;
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
	
	public long getDataId() {
		return dataId;
	}

	public void setDataId(long dataId) {
		this.dataId = dataId;
	}
	
	public byte[] getTransformation() {
		return transformation;
	}

	public void setTransformation(byte[] transformation) {
		this.transformation = transformation;
	}
	
	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	public SVector3f getMinBoundsUntranslated() {
		return minBoundsUntranslated;
	}

	public void setMinBoundsUntranslated(SVector3f minBoundsUntranslated) {
		this.minBoundsUntranslated = minBoundsUntranslated;
	}
	
	
	public SVector3f getMaxBoundsUntranslated() {
		return maxBoundsUntranslated;
	}

	public void setMaxBoundsUntranslated(SVector3f maxBoundsUntranslated) {
		this.maxBoundsUntranslated = maxBoundsUntranslated;
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
		SGeometryInfo other = (SGeometryInfo) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}