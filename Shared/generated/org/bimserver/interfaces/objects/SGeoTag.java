package org.bimserver.interfaces.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

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