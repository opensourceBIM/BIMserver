package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
public class SExternalServer implements SBase
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
		SExternalServer.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("title")) {
			return getTitle();
		}
		if (sField.getName().equals("url")) {
			return getUrl();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("token")) {
			return getToken();
		}
		if (sField.getName().equals("userId")) {
			return getUserId();
		}
		if (sField.getName().equals("profiles")) {
			return getProfiles();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	@SuppressWarnings("unchecked")
	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("title")) {
			setTitle((String)val);
			return;
		}
		if (sField.getName().equals("url")) {
			setUrl((String)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("token")) {
			setToken((String)val);
			return;
		}
		if (sField.getName().equals("userId")) {
			setUserId((Long)val);
			return;
		}
		if (sField.getName().equals("profiles")) {
			setProfiles((List<Long>)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private java.lang.String title;
	private java.lang.String url;
	private java.lang.String description;
	private java.lang.String token;
	private long userId;
	private List<Long> profiles = new ArrayList<Long>();
	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getUrl() {
		return url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public java.lang.String getToken() {
		return token;
	}

	public void setToken(java.lang.String token) {
		this.token = token;
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public List<Long> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Long> profiles) {
		this.profiles = profiles;
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
		SExternalServer other = (SExternalServer) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}