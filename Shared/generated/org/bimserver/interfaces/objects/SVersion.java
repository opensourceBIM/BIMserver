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
public class SVersion implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("SVersion");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("major", int.class));
		sClass.addField(new SField("minor", int.class));
		sClass.addField(new SField("revision", int.class));
		sClass.addField(new SField("date", java.util.Date.class));
		sClass.addField(new SField("downloadUrl", java.lang.String.class));
		sClass.addField(new SField("supportUrl", java.lang.String.class));
		sClass.addField(new SField("supportEmail", java.lang.String.class));
		SPackage.getInstance().addSClass(sClass);

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
		if (sField.getName().equals("major")) {
			return getMajor();
		}
		if (sField.getName().equals("minor")) {
			return getMinor();
		}
		if (sField.getName().equals("revision")) {
			return getRevision();
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
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private int major;
	private int minor;
	private int revision;
	private java.util.Date date;
	private java.lang.String downloadUrl;
	private java.lang.String supportUrl;
	private java.lang.String supportEmail;
	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}
	public int getMinor() {
		return minor;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}
	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
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