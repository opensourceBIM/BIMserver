package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SGeoTag
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
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