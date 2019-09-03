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
public class SJavaInfo implements SDataBase
{
	private long oid = -1;
	private UUID uuid;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private long heapTotal;
	private long heapUsed;
	private long heapFree;
	private long heapMax;
	private int threads;
	private java.lang.String javaHome;
	private java.lang.String javaVersion;
	private java.lang.String javaVendor;
	private java.lang.String javaVendorurl;
	private java.lang.String javavmVersion;
	private java.lang.String javavmVendor;
	private java.lang.String javavmName;
	private java.lang.String javaspecVersion;
	private java.lang.String javaspecVendor;
	private java.lang.String javaspecName;
	private java.lang.String javaClassVersion;
	private List<java.lang.String> javaClasspath = new ArrayList<java.lang.String>();
	private List<java.lang.String> javaLibrarypath = new ArrayList<java.lang.String>();
	private java.lang.String javaIoTmp;
	private java.lang.String javaExtdir;
	private java.lang.String javaFileSeparator;
	private java.lang.String javaPathSeparator;
	private java.lang.String javaLineSeparator;

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
		SJavaInfo.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("heapTotal")) {
			return getHeapTotal();
		}
		if (sField.getName().equals("heapUsed")) {
			return getHeapUsed();
		}
		if (sField.getName().equals("heapFree")) {
			return getHeapFree();
		}
		if (sField.getName().equals("heapMax")) {
			return getHeapMax();
		}
		if (sField.getName().equals("threads")) {
			return getThreads();
		}
		if (sField.getName().equals("javaHome")) {
			return getJavaHome();
		}
		if (sField.getName().equals("javaVersion")) {
			return getJavaVersion();
		}
		if (sField.getName().equals("javaVendor")) {
			return getJavaVendor();
		}
		if (sField.getName().equals("javaVendorurl")) {
			return getJavaVendorurl();
		}
		if (sField.getName().equals("javavmVersion")) {
			return getJavavmVersion();
		}
		if (sField.getName().equals("javavmVendor")) {
			return getJavavmVendor();
		}
		if (sField.getName().equals("javavmName")) {
			return getJavavmName();
		}
		if (sField.getName().equals("javaspecVersion")) {
			return getJavaspecVersion();
		}
		if (sField.getName().equals("javaspecVendor")) {
			return getJavaspecVendor();
		}
		if (sField.getName().equals("javaspecName")) {
			return getJavaspecName();
		}
		if (sField.getName().equals("javaClassVersion")) {
			return getJavaClassVersion();
		}
		if (sField.getName().equals("javaClasspath")) {
			return getJavaClasspath();
		}
		if (sField.getName().equals("javaLibrarypath")) {
			return getJavaLibrarypath();
		}
		if (sField.getName().equals("javaIoTmp")) {
			return getJavaIoTmp();
		}
		if (sField.getName().equals("javaExtdir")) {
			return getJavaExtdir();
		}
		if (sField.getName().equals("javaFileSeparator")) {
			return getJavaFileSeparator();
		}
		if (sField.getName().equals("javaPathSeparator")) {
			return getJavaPathSeparator();
		}
		if (sField.getName().equals("javaLineSeparator")) {
			return getJavaLineSeparator();
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
		if (sField.getName().equals("heapTotal")) {
			setHeapTotal((Long)val);
			return;
		}
		if (sField.getName().equals("heapUsed")) {
			setHeapUsed((Long)val);
			return;
		}
		if (sField.getName().equals("heapFree")) {
			setHeapFree((Long)val);
			return;
		}
		if (sField.getName().equals("heapMax")) {
			setHeapMax((Long)val);
			return;
		}
		if (sField.getName().equals("threads")) {
			setThreads((Integer)val);
			return;
		}
		if (sField.getName().equals("javaHome")) {
			setJavaHome((String)val);
			return;
		}
		if (sField.getName().equals("javaVersion")) {
			setJavaVersion((String)val);
			return;
		}
		if (sField.getName().equals("javaVendor")) {
			setJavaVendor((String)val);
			return;
		}
		if (sField.getName().equals("javaVendorurl")) {
			setJavaVendorurl((String)val);
			return;
		}
		if (sField.getName().equals("javavmVersion")) {
			setJavavmVersion((String)val);
			return;
		}
		if (sField.getName().equals("javavmVendor")) {
			setJavavmVendor((String)val);
			return;
		}
		if (sField.getName().equals("javavmName")) {
			setJavavmName((String)val);
			return;
		}
		if (sField.getName().equals("javaspecVersion")) {
			setJavaspecVersion((String)val);
			return;
		}
		if (sField.getName().equals("javaspecVendor")) {
			setJavaspecVendor((String)val);
			return;
		}
		if (sField.getName().equals("javaspecName")) {
			setJavaspecName((String)val);
			return;
		}
		if (sField.getName().equals("javaClassVersion")) {
			setJavaClassVersion((String)val);
			return;
		}
		if (sField.getName().equals("javaClasspath")) {
			setJavaClasspath((List<String>)val);
			return;
		}
		if (sField.getName().equals("javaLibrarypath")) {
			setJavaLibrarypath((List<String>)val);
			return;
		}
		if (sField.getName().equals("javaIoTmp")) {
			setJavaIoTmp((String)val);
			return;
		}
		if (sField.getName().equals("javaExtdir")) {
			setJavaExtdir((String)val);
			return;
		}
		if (sField.getName().equals("javaFileSeparator")) {
			setJavaFileSeparator((String)val);
			return;
		}
		if (sField.getName().equals("javaPathSeparator")) {
			setJavaPathSeparator((String)val);
			return;
		}
		if (sField.getName().equals("javaLineSeparator")) {
			setJavaLineSeparator((String)val);
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
	
	public long getHeapTotal() {
		return heapTotal;
	}

	public void setHeapTotal(long heapTotal) {
		this.heapTotal = heapTotal;
	}
	
	public long getHeapUsed() {
		return heapUsed;
	}

	public void setHeapUsed(long heapUsed) {
		this.heapUsed = heapUsed;
	}
	
	public long getHeapFree() {
		return heapFree;
	}

	public void setHeapFree(long heapFree) {
		this.heapFree = heapFree;
	}
	
	public long getHeapMax() {
		return heapMax;
	}

	public void setHeapMax(long heapMax) {
		this.heapMax = heapMax;
	}
	
	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}
	
	public java.lang.String getJavaHome() {
		return javaHome;
	}

	public void setJavaHome(java.lang.String javaHome) {
		this.javaHome = javaHome;
	}
	
	public java.lang.String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(java.lang.String javaVersion) {
		this.javaVersion = javaVersion;
	}
	
	public java.lang.String getJavaVendor() {
		return javaVendor;
	}

	public void setJavaVendor(java.lang.String javaVendor) {
		this.javaVendor = javaVendor;
	}
	
	public java.lang.String getJavaVendorurl() {
		return javaVendorurl;
	}

	public void setJavaVendorurl(java.lang.String javaVendorurl) {
		this.javaVendorurl = javaVendorurl;
	}
	
	public java.lang.String getJavavmVersion() {
		return javavmVersion;
	}

	public void setJavavmVersion(java.lang.String javavmVersion) {
		this.javavmVersion = javavmVersion;
	}
	
	public java.lang.String getJavavmVendor() {
		return javavmVendor;
	}

	public void setJavavmVendor(java.lang.String javavmVendor) {
		this.javavmVendor = javavmVendor;
	}
	
	public java.lang.String getJavavmName() {
		return javavmName;
	}

	public void setJavavmName(java.lang.String javavmName) {
		this.javavmName = javavmName;
	}
	
	public java.lang.String getJavaspecVersion() {
		return javaspecVersion;
	}

	public void setJavaspecVersion(java.lang.String javaspecVersion) {
		this.javaspecVersion = javaspecVersion;
	}
	
	public java.lang.String getJavaspecVendor() {
		return javaspecVendor;
	}

	public void setJavaspecVendor(java.lang.String javaspecVendor) {
		this.javaspecVendor = javaspecVendor;
	}
	
	public java.lang.String getJavaspecName() {
		return javaspecName;
	}

	public void setJavaspecName(java.lang.String javaspecName) {
		this.javaspecName = javaspecName;
	}
	
	public java.lang.String getJavaClassVersion() {
		return javaClassVersion;
	}

	public void setJavaClassVersion(java.lang.String javaClassVersion) {
		this.javaClassVersion = javaClassVersion;
	}
	

	public List<java.lang.String> getJavaClasspath() {
		return javaClasspath;
	}

	public void setJavaClasspath(List<java.lang.String> javaClasspath) {
		this.javaClasspath = javaClasspath;
	}
	

	public List<java.lang.String> getJavaLibrarypath() {
		return javaLibrarypath;
	}

	public void setJavaLibrarypath(List<java.lang.String> javaLibrarypath) {
		this.javaLibrarypath = javaLibrarypath;
	}
	
	public java.lang.String getJavaIoTmp() {
		return javaIoTmp;
	}

	public void setJavaIoTmp(java.lang.String javaIoTmp) {
		this.javaIoTmp = javaIoTmp;
	}
	
	public java.lang.String getJavaExtdir() {
		return javaExtdir;
	}

	public void setJavaExtdir(java.lang.String javaExtdir) {
		this.javaExtdir = javaExtdir;
	}
	
	public java.lang.String getJavaFileSeparator() {
		return javaFileSeparator;
	}

	public void setJavaFileSeparator(java.lang.String javaFileSeparator) {
		this.javaFileSeparator = javaFileSeparator;
	}
	
	public java.lang.String getJavaPathSeparator() {
		return javaPathSeparator;
	}

	public void setJavaPathSeparator(java.lang.String javaPathSeparator) {
		this.javaPathSeparator = javaPathSeparator;
	}
	
	public java.lang.String getJavaLineSeparator() {
		return javaLineSeparator;
	}

	public void setJavaLineSeparator(java.lang.String javaLineSeparator) {
		this.javaLineSeparator = javaLineSeparator;
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
		SJavaInfo other = (SJavaInfo) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}