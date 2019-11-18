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
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SGeometryInfo implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private SBounds bounds;
	private SBounds boundsUntransformed;
	private java.lang.Integer startVertex;
	private java.lang.Integer startIndex;
	private java.lang.Integer primitiveCount;
	private byte[] transformation;
	private long dataId = -1;
	private double area;
	private double volume;
	private boolean hasTransparency;
	private long ifcProductOid;
	private byte[] ifcProductUuid;
	private int ifcProductRid;
	private float density;
	private SBounds boundsMm;
	private SBounds boundsUntransformedMm;
	private java.lang.String additionalData;
	private int nrColors;
	private int nrVertices;
	private int ifcProductPid;

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
		SGeometryInfo.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("bounds")) {
			return getBounds();
		}
		if (sField.getName().equals("boundsUntransformed")) {
			return getBoundsUntransformed();
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
		if (sField.getName().equals("transformation")) {
			return getTransformation();
		}
		if (sField.getName().equals("dataId")) {
			return getDataId();
		}
		if (sField.getName().equals("area")) {
			return getArea();
		}
		if (sField.getName().equals("volume")) {
			return getVolume();
		}
		if (sField.getName().equals("hasTransparency")) {
			return isHasTransparency();
		}
		if (sField.getName().equals("ifcProductOid")) {
			return getIfcProductOid();
		}
		if (sField.getName().equals("ifcProductUuid")) {
			return getIfcProductUuid();
		}
		if (sField.getName().equals("ifcProductRid")) {
			return getIfcProductRid();
		}
		if (sField.getName().equals("density")) {
			return getDensity();
		}
		if (sField.getName().equals("boundsMm")) {
			return getBoundsMm();
		}
		if (sField.getName().equals("boundsUntransformedMm")) {
			return getBoundsUntransformedMm();
		}
		if (sField.getName().equals("additionalData")) {
			return getAdditionalData();
		}
		if (sField.getName().equals("nrColors")) {
			return getNrColors();
		}
		if (sField.getName().equals("nrVertices")) {
			return getNrVertices();
		}
		if (sField.getName().equals("ifcProductPid")) {
			return getIfcProductPid();
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

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("bounds")) {
			setBounds((SBounds)val);
			return;
		}
		if (sField.getName().equals("boundsUntransformed")) {
			setBoundsUntransformed((SBounds)val);
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
		if (sField.getName().equals("transformation")) {
			setTransformation((byte[])val);
			return;
		}
		if (sField.getName().equals("dataId")) {
			setDataId((Long)val);
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
		if (sField.getName().equals("hasTransparency")) {
			setHasTransparency((Boolean)val);
			return;
		}
		if (sField.getName().equals("ifcProductOid")) {
			setIfcProductOid((Long)val);
			return;
		}
		if (sField.getName().equals("ifcProductUuid")) {
			setIfcProductUuid((byte[])val);
			return;
		}
		if (sField.getName().equals("ifcProductRid")) {
			setIfcProductRid((Integer)val);
			return;
		}
		if (sField.getName().equals("density")) {
			setDensity((Float)val);
			return;
		}
		if (sField.getName().equals("boundsMm")) {
			setBoundsMm((SBounds)val);
			return;
		}
		if (sField.getName().equals("boundsUntransformedMm")) {
			setBoundsUntransformedMm((SBounds)val);
			return;
		}
		if (sField.getName().equals("additionalData")) {
			setAdditionalData((String)val);
			return;
		}
		if (sField.getName().equals("nrColors")) {
			setNrColors((Integer)val);
			return;
		}
		if (sField.getName().equals("nrVertices")) {
			setNrVertices((Integer)val);
			return;
		}
		if (sField.getName().equals("ifcProductPid")) {
			setIfcProductPid((Integer)val);
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
	
	public SBounds getBounds() {
		return bounds;
	}

	public void setBounds(SBounds bounds) {
		this.bounds = bounds;
	}
	
	
	public SBounds getBoundsUntransformed() {
		return boundsUntransformed;
	}

	public void setBoundsUntransformed(SBounds boundsUntransformed) {
		this.boundsUntransformed = boundsUntransformed;
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
	
	public byte[] getTransformation() {
		return transformation;
	}

	public void setTransformation(byte[] transformation) {
		this.transformation = transformation;
	}
	
	public long getDataId() {
		return dataId;
	}

	public void setDataId(long dataId) {
		this.dataId = dataId;
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
	
	public boolean isHasTransparency() {
		return hasTransparency;
	}

	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}
	
	public long getIfcProductOid() {
		return ifcProductOid;
	}

	public void setIfcProductOid(long ifcProductOid) {
		this.ifcProductOid = ifcProductOid;
	}
	
	public byte[] getIfcProductUuid() {
		return ifcProductUuid;
	}

	public void setIfcProductUuid(byte[] ifcProductUuid) {
		this.ifcProductUuid = ifcProductUuid;
	}
	
	public int getIfcProductRid() {
		return ifcProductRid;
	}

	public void setIfcProductRid(int ifcProductRid) {
		this.ifcProductRid = ifcProductRid;
	}
	
	public float getDensity() {
		return density;
	}

	public void setDensity(float density) {
		this.density = density;
	}
	
	public SBounds getBoundsMm() {
		return boundsMm;
	}

	public void setBoundsMm(SBounds boundsMm) {
		this.boundsMm = boundsMm;
	}
	
	
	public SBounds getBoundsUntransformedMm() {
		return boundsUntransformedMm;
	}

	public void setBoundsUntransformedMm(SBounds boundsUntransformedMm) {
		this.boundsUntransformedMm = boundsUntransformedMm;
	}
	
	
	public java.lang.String getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(java.lang.String additionalData) {
		this.additionalData = additionalData;
	}
	
	public int getNrColors() {
		return nrColors;
	}

	public void setNrColors(int nrColors) {
		this.nrColors = nrColors;
	}
	
	public int getNrVertices() {
		return nrVertices;
	}

	public void setNrVertices(int nrVertices) {
		this.nrVertices = nrVertices;
	}
	
	public int getIfcProductPid() {
		return ifcProductPid;
	}

	public void setIfcProductPid(int ifcProductPid) {
		this.ifcProductPid = ifcProductPid;
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