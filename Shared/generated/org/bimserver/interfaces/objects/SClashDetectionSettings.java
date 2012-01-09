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
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SClashDetectionSettings implements SBase
{
	private long oid = -1;
	@XmlTransient
	private static SClass sClass;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SClashDetectionSettings.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("enabled")) {
			return isEnabled();
		}
		if (sField.getName().equals("projects")) {
			return getProjects();
		}
		if (sField.getName().equals("margin")) {
			return getMargin();
		}
		if (sField.getName().equals("revisions")) {
			return getRevisions();
		}
		if (sField.getName().equals("ignoredClasses")) {
			return getIgnoredClasses();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
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
		if (sField.getName().equals("margin")) {
			setMargin((Float)val);
			return;
		}
		if (sField.getName().equals("revisions")) {
			setRevisions((List<Long>)val);
			return;
		}
		if (sField.getName().equals("ignoredClasses")) {
			setIgnoredClasses((List<String>)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private boolean enabled;
	private List<Long> projects = new ArrayList<Long>();
	private float margin;
	private List<Long> revisions = new ArrayList<Long>();
	private List<java.lang.String> ignoredClasses = new ArrayList<java.lang.String>();
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
	public float getMargin() {
		return margin;
	}

	public void setMargin(float margin) {
		this.margin = margin;
	}
	public List<Long> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Long> revisions) {
		this.revisions = revisions;
	}

	public List<java.lang.String> getIgnoredClasses() {
		return ignoredClasses;
	}

	public void setIgnoredClasses(List<java.lang.String> ignoredClasses) {
		this.ignoredClasses = ignoredClasses;
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
		SClashDetectionSettings other = (SClashDetectionSettings) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}