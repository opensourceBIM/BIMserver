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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SGeoTag implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.Boolean enabled;
	private List<Long> projects = new ArrayList<Long>();
	private java.lang.Double x;
	private java.lang.Double y;
	private java.lang.Double z;
	private java.lang.Integer epsg;
	private java.lang.Double directionAngle;

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
		SGeoTag.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("enabled")) {
			return getEnabled();
		}
		if (sField.getName().equals("projects")) {
			return getProjects();
		}
		if (sField.getName().equals("x")) {
			return getX();
		}
		if (sField.getName().equals("y")) {
			return getY();
		}
		if (sField.getName().equals("z")) {
			return getZ();
		}
		if (sField.getName().equals("epsg")) {
			return getEpsg();
		}
		if (sField.getName().equals("directionAngle")) {
			return getDirectionAngle();
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
		if (sField.getName().equals("enabled")) {
			setEnabled((Boolean)val);
			return;
		}
		if (sField.getName().equals("projects")) {
			setProjects((List<Long>)val);
			return;
		}
		if (sField.getName().equals("x")) {
			setX((Double)val);
			return;
		}
		if (sField.getName().equals("y")) {
			setY((Double)val);
			return;
		}
		if (sField.getName().equals("z")) {
			setZ((Double)val);
			return;
		}
		if (sField.getName().equals("epsg")) {
			setEpsg((Integer)val);
			return;
		}
		if (sField.getName().equals("directionAngle")) {
			setDirectionAngle((Double)val);
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
	
	public java.lang.Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(java.lang.Boolean enabled) {
		this.enabled = enabled;
	}
	
	public List<Long> getProjects() {
		return projects;
	}

	public void setProjects(List<Long> projects) {
		this.projects = projects;
	}
	
	public java.lang.Double getX() {
		return x;
	}

	public void setX(java.lang.Double x) {
		this.x = x;
	}
	
	public java.lang.Double getY() {
		return y;
	}

	public void setY(java.lang.Double y) {
		this.y = y;
	}
	
	public java.lang.Double getZ() {
		return z;
	}

	public void setZ(java.lang.Double z) {
		this.z = z;
	}
	
	public java.lang.Integer getEpsg() {
		return epsg;
	}

	public void setEpsg(java.lang.Integer epsg) {
		this.epsg = epsg;
	}
	
	public java.lang.Double getDirectionAngle() {
		return directionAngle;
	}

	public void setDirectionAngle(java.lang.Double directionAngle) {
		this.directionAngle = directionAngle;
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
		SGeoTag other = (SGeoTag) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}