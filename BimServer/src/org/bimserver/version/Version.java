package org.bimserver.version;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "version")
@XmlAccessorType(XmlAccessType.FIELD)
public class Version {
	@XmlElement(name = "version")
	private String version;
	
	@XmlElement(name = "date")
	private Date date;

	@XmlElement(name = "download")
	private String downloadUrl;
	
	@XmlElement(name = "support")
	private String supportUrl;
	
	@XmlElement(name = "info")
	private String supportEmail;

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getSupportUrl() {
		return supportUrl;
	}

	public void setSupportUrl(String supportUrl) {
		this.supportUrl = supportUrl;
	}

	public String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}
	
	public int getMajor() {
		String[] split = version.split(".");
		if (split.length > 0) {
			return Integer.parseInt(split[0]);
		}
		return 0;
	}
	
	public int getMinor() {
		String[] split = version.split(".");
		if (split.length > 1) {
			return Integer.parseInt(split[1]);
		}
		return 0;
	}
	
	public int getRevision() {
		String[] split = version.split(".");
		if (split.length > 2) {
			return Integer.parseInt(split[2]);
		}
		return 0;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
}