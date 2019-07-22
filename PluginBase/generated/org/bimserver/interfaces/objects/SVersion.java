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
import java.util.Date;
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SVersion implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.Integer major;
	private java.lang.Integer minor;
	private java.lang.Integer revision;
	private java.lang.String fullString;
	private java.util.Date date;
	private java.lang.String downloadUrl;
	private java.lang.String supportUrl;
	private java.lang.String supportEmail;

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
		SVersion.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("major")) {
			return getMajor();
		}
		if (sField.getName().equals("minor")) {
			return getMinor();
		}
		if (sField.getName().equals("revision")) {
			return getRevision();
		}
		if (sField.getName().equals("fullString")) {
			return getFullString();
		}
		if (sField.getName().equals("date")) {
			return getDate();
		}
		if (sField.getName().equals("downloadUrl")) {
			return getDownloadUrl();
		}
		if (sField.getName().equals("supportUrl")) {
			return getSupportUrl();
		}
		if (sField.getName().equals("supportEmail")) {
			return getSupportEmail();
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
		if (sField.getName().equals("major")) {
			setMajor((Integer)val);
			return;
		}
		if (sField.getName().equals("minor")) {
			setMinor((Integer)val);
			return;
		}
		if (sField.getName().equals("revision")) {
			setRevision((Integer)val);
			return;
		}
		if (sField.getName().equals("fullString")) {
			setFullString((String)val);
			return;
		}
		if (sField.getName().equals("date")) {
			setDate((Date)val);
			return;
		}
		if (sField.getName().equals("downloadUrl")) {
			setDownloadUrl((String)val);
			return;
		}
		if (sField.getName().equals("supportUrl")) {
			setSupportUrl((String)val);
			return;
		}
		if (sField.getName().equals("supportEmail")) {
			setSupportEmail((String)val);
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
	
	public java.lang.Integer getMajor() {
		return major;
	}

	public void setMajor(java.lang.Integer major) {
		this.major = major;
	}
	
	public java.lang.Integer getMinor() {
		return minor;
	}

	public void setMinor(java.lang.Integer minor) {
		this.minor = minor;
	}
	
	public java.lang.Integer getRevision() {
		return revision;
	}

	public void setRevision(java.lang.Integer revision) {
		this.revision = revision;
	}
	
	public java.lang.String getFullString() {
		return fullString;
	}

	public void setFullString(java.lang.String fullString) {
		this.fullString = fullString;
	}
	
	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	public java.lang.String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(java.lang.String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	
	public java.lang.String getSupportUrl() {
		return supportUrl;
	}

	public void setSupportUrl(java.lang.String supportUrl) {
		this.supportUrl = supportUrl;
	}
	
	public java.lang.String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(java.lang.String supportEmail) {
		this.supportEmail = supportEmail;
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
		SVersion other = (SVersion) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}