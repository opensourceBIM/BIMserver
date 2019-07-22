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
public class SSystemInfo implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private int cpucores;
	private java.util.Date datetime;
	private java.lang.String osname;
	private java.lang.String osversion;
	private java.lang.String userName;
	private java.lang.String userHome;
	private java.lang.String userDir;

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
		SSystemInfo.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("cpucores")) {
			return getCpucores();
		}
		if (sField.getName().equals("datetime")) {
			return getDatetime();
		}
		if (sField.getName().equals("osname")) {
			return getOsname();
		}
		if (sField.getName().equals("osversion")) {
			return getOsversion();
		}
		if (sField.getName().equals("userName")) {
			return getUserName();
		}
		if (sField.getName().equals("userHome")) {
			return getUserHome();
		}
		if (sField.getName().equals("userDir")) {
			return getUserDir();
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
		if (sField.getName().equals("cpucores")) {
			setCpucores((Integer)val);
			return;
		}
		if (sField.getName().equals("datetime")) {
			setDatetime((Date)val);
			return;
		}
		if (sField.getName().equals("osname")) {
			setOsname((String)val);
			return;
		}
		if (sField.getName().equals("osversion")) {
			setOsversion((String)val);
			return;
		}
		if (sField.getName().equals("userName")) {
			setUserName((String)val);
			return;
		}
		if (sField.getName().equals("userHome")) {
			setUserHome((String)val);
			return;
		}
		if (sField.getName().equals("userDir")) {
			setUserDir((String)val);
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
	
	public int getCpucores() {
		return cpucores;
	}

	public void setCpucores(int cpucores) {
		this.cpucores = cpucores;
	}
	
	public java.util.Date getDatetime() {
		return datetime;
	}

	public void setDatetime(java.util.Date datetime) {
		this.datetime = datetime;
	}
	
	public java.lang.String getOsname() {
		return osname;
	}

	public void setOsname(java.lang.String osname) {
		this.osname = osname;
	}
	
	public java.lang.String getOsversion() {
		return osversion;
	}

	public void setOsversion(java.lang.String osversion) {
		this.osversion = osversion;
	}
	
	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}
	
	public java.lang.String getUserHome() {
		return userHome;
	}

	public void setUserHome(java.lang.String userHome) {
		this.userHome = userHome;
	}
	
	public java.lang.String getUserDir() {
		return userDir;
	}

	public void setUserDir(java.lang.String userDir) {
		this.userDir = userDir;
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
		SSystemInfo other = (SSystemInfo) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}