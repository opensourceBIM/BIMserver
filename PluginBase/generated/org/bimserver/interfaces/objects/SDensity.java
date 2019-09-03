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
public class SDensity implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String type;
	private long geometryInfoId;
	private long trianglesBelow;
	private long trianglesAbove;
	private float volume;
	private float density;

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
		SDensity.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("geometryInfoId")) {
			return getGeometryInfoId();
		}
		if (sField.getName().equals("trianglesBelow")) {
			return getTrianglesBelow();
		}
		if (sField.getName().equals("trianglesAbove")) {
			return getTrianglesAbove();
		}
		if (sField.getName().equals("volume")) {
			return getVolume();
		}
		if (sField.getName().equals("density")) {
			return getDensity();
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
		if (sField.getName().equals("type")) {
			setType((String)val);
			return;
		}
		if (sField.getName().equals("geometryInfoId")) {
			setGeometryInfoId((Long)val);
			return;
		}
		if (sField.getName().equals("trianglesBelow")) {
			setTrianglesBelow((Long)val);
			return;
		}
		if (sField.getName().equals("trianglesAbove")) {
			setTrianglesAbove((Long)val);
			return;
		}
		if (sField.getName().equals("volume")) {
			setVolume((Float)val);
			return;
		}
		if (sField.getName().equals("density")) {
			setDensity((Float)val);
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
	
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	public long getGeometryInfoId() {
		return geometryInfoId;
	}

	public void setGeometryInfoId(long geometryInfoId) {
		this.geometryInfoId = geometryInfoId;
	}
	
	public long getTrianglesBelow() {
		return trianglesBelow;
	}

	public void setTrianglesBelow(long trianglesBelow) {
		this.trianglesBelow = trianglesBelow;
	}
	
	public long getTrianglesAbove() {
		return trianglesAbove;
	}

	public void setTrianglesAbove(long trianglesAbove) {
		this.trianglesAbove = trianglesAbove;
	}
	
	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	public float getDensity() {
		return density;
	}

	public void setDensity(float density) {
		this.density = density;
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
		SDensity other = (SDensity) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}