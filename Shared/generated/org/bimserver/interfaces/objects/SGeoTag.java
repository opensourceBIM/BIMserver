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

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SGeoTag implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("GeoTag");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("enabled", boolean.class));
		sClass.addField(new SField("projects", Long.class, true));
		sClass.addField(new SField("x", float.class));
		sClass.addField(new SField("y", float.class));
		sClass.addField(new SField("z", float.class));
		sClass.addField(new SField("epsg", int.class));
		sClass.addField(new SField("directionAngle", float.class));
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
		if (sField.getName().equals("enabled")) {
			return isEnabled();
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
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("enabled")) {
			setEnabled((Boolean)val);
		}
		if (sField.getName().equals("projects")) {
			setProjects((List<Long>)val);
		}
		if (sField.getName().equals("x")) {
			setX((Float)val);
		}
		if (sField.getName().equals("y")) {
			setY((Float)val);
		}
		if (sField.getName().equals("z")) {
			setZ((Float)val);
		}
		if (sField.getName().equals("epsg")) {
			setEpsg((Integer)val);
		}
		if (sField.getName().equals("directionAngle")) {
			setDirectionAngle((Float)val);
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private boolean enabled;
	private List<Long> projects = new ArrayList<Long>();
	private float x;
	private float y;
	private float z;
	private int epsg;
	private float directionAngle;
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<Long> getProjects() {
		return projects;
	}

	public void setProjects(List<Long> projects) {
		this.projects = projects;
	}
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	public int getEpsg() {
		return epsg;
	}

	public void setEpsg(int epsg) {
		this.epsg = epsg;
	}
	public float getDirectionAngle() {
		return directionAngle;
	}

	public void setDirectionAngle(float directionAngle) {
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