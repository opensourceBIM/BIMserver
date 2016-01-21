package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SPluginBundleVersion implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.String version;
	private SPluginBundleType type;
	private java.lang.String description;
	private boolean mismatch;
	private java.lang.String repository;
	private java.lang.String groupId;
	private java.lang.String artifactId;

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
		SPluginBundleVersion.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("version")) {
			return getVersion();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("mismatch")) {
			return isMismatch();
		}
		if (sField.getName().equals("repository")) {
			return getRepository();
		}
		if (sField.getName().equals("groupId")) {
			return getGroupId();
		}
		if (sField.getName().equals("artifactId")) {
			return getArtifactId();
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
		if (sField.getName().equals("version")) {
			setVersion((String)val);
			return;
		}
		if (sField.getName().equals("type")) {
			setType((SPluginBundleType)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("mismatch")) {
			setMismatch((Boolean)val);
			return;
		}
		if (sField.getName().equals("repository")) {
			setRepository((String)val);
			return;
		}
		if (sField.getName().equals("groupId")) {
			setGroupId((String)val);
			return;
		}
		if (sField.getName().equals("artifactId")) {
			setArtifactId((String)val);
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
	
	public java.lang.String getVersion() {
		return version;
	}

	public void setVersion(java.lang.String version) {
		this.version = version;
	}
	
	public SPluginBundleType getType() {
		return type;
	}

	public void setType(SPluginBundleType type) {
		this.type = type;
	}
	
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	public boolean isMismatch() {
		return mismatch;
	}

	public void setMismatch(boolean mismatch) {
		this.mismatch = mismatch;
	}
	
	public java.lang.String getRepository() {
		return repository;
	}

	public void setRepository(java.lang.String repository) {
		this.repository = repository;
	}
	
	public java.lang.String getGroupId() {
		return groupId;
	}

	public void setGroupId(java.lang.String groupId) {
		this.groupId = groupId;
	}
	
	public java.lang.String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(java.lang.String artifactId) {
		this.artifactId = artifactId;
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
		SPluginBundleVersion other = (SPluginBundleVersion) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}