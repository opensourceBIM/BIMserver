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
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SServiceDescriptor implements SBase
{

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.String url;
	private java.lang.String token;
	private java.lang.String identifier;
	private SAccessMethod notificationProtocol;
	private java.lang.String description;
	private STrigger trigger;
	private boolean readRevision;
	private java.lang.String readExtendedData;
	private boolean writeRevision;
	private java.lang.String writeExtendedData;
	private java.lang.String providerName;
	private java.lang.String companyUrl;
	private java.lang.String tokenUrl;
	private java.lang.String newProfileUrl;
	private java.lang.String registerUrl;
	private java.lang.String authorizeUrl;
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SServiceDescriptor.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("url")) {
			return getUrl();
		}
		if (sField.getName().equals("token")) {
			return getToken();
		}
		if (sField.getName().equals("identifier")) {
			return getIdentifier();
		}
		if (sField.getName().equals("notificationProtocol")) {
			return getNotificationProtocol();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("trigger")) {
			return getTrigger();
		}
		if (sField.getName().equals("readRevision")) {
			return isReadRevision();
		}
		if (sField.getName().equals("readExtendedData")) {
			return getReadExtendedData();
		}
		if (sField.getName().equals("writeRevision")) {
			return isWriteRevision();
		}
		if (sField.getName().equals("writeExtendedData")) {
			return getWriteExtendedData();
		}
		if (sField.getName().equals("providerName")) {
			return getProviderName();
		}
		if (sField.getName().equals("companyUrl")) {
			return getCompanyUrl();
		}
		if (sField.getName().equals("tokenUrl")) {
			return getTokenUrl();
		}
		if (sField.getName().equals("newProfileUrl")) {
			return getNewProfileUrl();
		}
		if (sField.getName().equals("registerUrl")) {
			return getRegisterUrl();
		}
		if (sField.getName().equals("authorizeUrl")) {
			return getAuthorizeUrl();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("url")) {
			setUrl((String)val);
			return;
		}
		if (sField.getName().equals("token")) {
			setToken((String)val);
			return;
		}
		if (sField.getName().equals("identifier")) {
			setIdentifier((String)val);
			return;
		}
		if (sField.getName().equals("notificationProtocol")) {
			setNotificationProtocol((SAccessMethod)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("trigger")) {
			setTrigger((STrigger)val);
			return;
		}
		if (sField.getName().equals("readRevision")) {
			setReadRevision((Boolean)val);
			return;
		}
		if (sField.getName().equals("readExtendedData")) {
			setReadExtendedData((String)val);
			return;
		}
		if (sField.getName().equals("writeRevision")) {
			setWriteRevision((Boolean)val);
			return;
		}
		if (sField.getName().equals("writeExtendedData")) {
			setWriteExtendedData((String)val);
			return;
		}
		if (sField.getName().equals("providerName")) {
			setProviderName((String)val);
			return;
		}
		if (sField.getName().equals("companyUrl")) {
			setCompanyUrl((String)val);
			return;
		}
		if (sField.getName().equals("tokenUrl")) {
			setTokenUrl((String)val);
			return;
		}
		if (sField.getName().equals("newProfileUrl")) {
			setNewProfileUrl((String)val);
			return;
		}
		if (sField.getName().equals("registerUrl")) {
			setRegisterUrl((String)val);
			return;
		}
		if (sField.getName().equals("authorizeUrl")) {
			setAuthorizeUrl((String)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getUrl() {
		return url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	
	public java.lang.String getToken() {
		return token;
	}

	public void setToken(java.lang.String token) {
		this.token = token;
	}
	
	public java.lang.String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(java.lang.String identifier) {
		this.identifier = identifier;
	}
	
	public SAccessMethod getNotificationProtocol() {
		return notificationProtocol;
	}

	public void setNotificationProtocol(SAccessMethod notificationProtocol) {
		this.notificationProtocol = notificationProtocol;
	}
	
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	public STrigger getTrigger() {
		return trigger;
	}

	public void setTrigger(STrigger trigger) {
		this.trigger = trigger;
	}
	
	public boolean isReadRevision() {
		return readRevision;
	}

	public void setReadRevision(boolean readRevision) {
		this.readRevision = readRevision;
	}
	
	public java.lang.String getReadExtendedData() {
		return readExtendedData;
	}

	public void setReadExtendedData(java.lang.String readExtendedData) {
		this.readExtendedData = readExtendedData;
	}
	
	public boolean isWriteRevision() {
		return writeRevision;
	}

	public void setWriteRevision(boolean writeRevision) {
		this.writeRevision = writeRevision;
	}
	
	public java.lang.String getWriteExtendedData() {
		return writeExtendedData;
	}

	public void setWriteExtendedData(java.lang.String writeExtendedData) {
		this.writeExtendedData = writeExtendedData;
	}
	
	public java.lang.String getProviderName() {
		return providerName;
	}

	public void setProviderName(java.lang.String providerName) {
		this.providerName = providerName;
	}
	
	public java.lang.String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(java.lang.String companyUrl) {
		this.companyUrl = companyUrl;
	}
	
	public java.lang.String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(java.lang.String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}
	
	public java.lang.String getNewProfileUrl() {
		return newProfileUrl;
	}

	public void setNewProfileUrl(java.lang.String newProfileUrl) {
		this.newProfileUrl = newProfileUrl;
	}
	
	public java.lang.String getRegisterUrl() {
		return registerUrl;
	}

	public void setRegisterUrl(java.lang.String registerUrl) {
		this.registerUrl = registerUrl;
	}
	
	public java.lang.String getAuthorizeUrl() {
		return authorizeUrl;
	}

	public void setAuthorizeUrl(java.lang.String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}
	
}