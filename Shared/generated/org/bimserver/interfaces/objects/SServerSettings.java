package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
public class SServerSettings implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private boolean sendConfirmationEmailAfterRegistration;
	private java.lang.Boolean allowSelfRegistration;
	private boolean allowUsersToCreateTopLevelProjects;
	private java.lang.Boolean checkinMergingEnabled;
	private java.lang.String smtpServer;
	private java.lang.String emailSenderAddress;
	private java.lang.String emailSenderName;
	private java.lang.String siteAddress;
	private boolean generateGeometryOnCheckin;
	private boolean allowOnlyWhitelisted;
	private List<java.lang.String> whitelistedDomains = new ArrayList<java.lang.String>();
	private java.lang.Boolean hideUserListForNonAdmin;
	private java.lang.Integer protocolBuffersPort;
	private java.lang.Boolean cacheOutputFiles;
	private List<Long> webModules = new ArrayList<Long>();
	private long webModuleId = -1;
	private java.lang.String serviceRepositoryUrl;
	private boolean sendEmailOnNewRevision;
	private int sessionTimeOutSeconds;
	private java.lang.String smtpUsername;
	private java.lang.String smtpPassword;
	private int smtpPort;
	private SSmtpProtocol smtpProtocol;
	private boolean reuseGeometry;

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
		SServerSettings.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("sendConfirmationEmailAfterRegistration")) {
			return isSendConfirmationEmailAfterRegistration();
		}
		if (sField.getName().equals("allowSelfRegistration")) {
			return getAllowSelfRegistration();
		}
		if (sField.getName().equals("allowUsersToCreateTopLevelProjects")) {
			return isAllowUsersToCreateTopLevelProjects();
		}
		if (sField.getName().equals("checkinMergingEnabled")) {
			return getCheckinMergingEnabled();
		}
		if (sField.getName().equals("smtpServer")) {
			return getSmtpServer();
		}
		if (sField.getName().equals("emailSenderAddress")) {
			return getEmailSenderAddress();
		}
		if (sField.getName().equals("emailSenderName")) {
			return getEmailSenderName();
		}
		if (sField.getName().equals("siteAddress")) {
			return getSiteAddress();
		}
		if (sField.getName().equals("generateGeometryOnCheckin")) {
			return isGenerateGeometryOnCheckin();
		}
		if (sField.getName().equals("allowOnlyWhitelisted")) {
			return isAllowOnlyWhitelisted();
		}
		if (sField.getName().equals("whitelistedDomains")) {
			return getWhitelistedDomains();
		}
		if (sField.getName().equals("hideUserListForNonAdmin")) {
			return getHideUserListForNonAdmin();
		}
		if (sField.getName().equals("protocolBuffersPort")) {
			return getProtocolBuffersPort();
		}
		if (sField.getName().equals("cacheOutputFiles")) {
			return getCacheOutputFiles();
		}
		if (sField.getName().equals("webModules")) {
			return getWebModules();
		}
		if (sField.getName().equals("webModuleId")) {
			return getWebModuleId();
		}
		if (sField.getName().equals("serviceRepositoryUrl")) {
			return getServiceRepositoryUrl();
		}
		if (sField.getName().equals("sendEmailOnNewRevision")) {
			return isSendEmailOnNewRevision();
		}
		if (sField.getName().equals("sessionTimeOutSeconds")) {
			return getSessionTimeOutSeconds();
		}
		if (sField.getName().equals("smtpUsername")) {
			return getSmtpUsername();
		}
		if (sField.getName().equals("smtpPassword")) {
			return getSmtpPassword();
		}
		if (sField.getName().equals("smtpPort")) {
			return getSmtpPort();
		}
		if (sField.getName().equals("smtpProtocol")) {
			return getSmtpProtocol();
		}
		if (sField.getName().equals("reuseGeometry")) {
			return isReuseGeometry();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		if (sField.getName().equals("rid")) {
			return getRid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	@SuppressWarnings("unchecked")

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("sendConfirmationEmailAfterRegistration")) {
			setSendConfirmationEmailAfterRegistration((Boolean)val);
			return;
		}
		if (sField.getName().equals("allowSelfRegistration")) {
			setAllowSelfRegistration((Boolean)val);
			return;
		}
		if (sField.getName().equals("allowUsersToCreateTopLevelProjects")) {
			setAllowUsersToCreateTopLevelProjects((Boolean)val);
			return;
		}
		if (sField.getName().equals("checkinMergingEnabled")) {
			setCheckinMergingEnabled((Boolean)val);
			return;
		}
		if (sField.getName().equals("smtpServer")) {
			setSmtpServer((String)val);
			return;
		}
		if (sField.getName().equals("emailSenderAddress")) {
			setEmailSenderAddress((String)val);
			return;
		}
		if (sField.getName().equals("emailSenderName")) {
			setEmailSenderName((String)val);
			return;
		}
		if (sField.getName().equals("siteAddress")) {
			setSiteAddress((String)val);
			return;
		}
		if (sField.getName().equals("generateGeometryOnCheckin")) {
			setGenerateGeometryOnCheckin((Boolean)val);
			return;
		}
		if (sField.getName().equals("allowOnlyWhitelisted")) {
			setAllowOnlyWhitelisted((Boolean)val);
			return;
		}
		if (sField.getName().equals("whitelistedDomains")) {
			setWhitelistedDomains((List<String>)val);
			return;
		}
		if (sField.getName().equals("hideUserListForNonAdmin")) {
			setHideUserListForNonAdmin((Boolean)val);
			return;
		}
		if (sField.getName().equals("protocolBuffersPort")) {
			setProtocolBuffersPort((Integer)val);
			return;
		}
		if (sField.getName().equals("cacheOutputFiles")) {
			setCacheOutputFiles((Boolean)val);
			return;
		}
		if (sField.getName().equals("webModules")) {
			setWebModules((List<Long>)val);
			return;
		}
		if (sField.getName().equals("webModuleId")) {
			setWebModuleId((Long)val);
			return;
		}
		if (sField.getName().equals("serviceRepositoryUrl")) {
			setServiceRepositoryUrl((String)val);
			return;
		}
		if (sField.getName().equals("sendEmailOnNewRevision")) {
			setSendEmailOnNewRevision((Boolean)val);
			return;
		}
		if (sField.getName().equals("sessionTimeOutSeconds")) {
			setSessionTimeOutSeconds((Integer)val);
			return;
		}
		if (sField.getName().equals("smtpUsername")) {
			setSmtpUsername((String)val);
			return;
		}
		if (sField.getName().equals("smtpPassword")) {
			setSmtpPassword((String)val);
			return;
		}
		if (sField.getName().equals("smtpPort")) {
			setSmtpPort((Integer)val);
			return;
		}
		if (sField.getName().equals("smtpProtocol")) {
			setSmtpProtocol((SSmtpProtocol)val);
			return;
		}
		if (sField.getName().equals("reuseGeometry")) {
			setReuseGeometry((Boolean)val);
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
	
	public boolean isSendConfirmationEmailAfterRegistration() {
		return sendConfirmationEmailAfterRegistration;
	}

	public void setSendConfirmationEmailAfterRegistration(boolean sendConfirmationEmailAfterRegistration) {
		this.sendConfirmationEmailAfterRegistration = sendConfirmationEmailAfterRegistration;
	}
	
	public java.lang.Boolean getAllowSelfRegistration() {
		return allowSelfRegistration;
	}

	public void setAllowSelfRegistration(java.lang.Boolean allowSelfRegistration) {
		this.allowSelfRegistration = allowSelfRegistration;
	}
	
	public boolean isAllowUsersToCreateTopLevelProjects() {
		return allowUsersToCreateTopLevelProjects;
	}

	public void setAllowUsersToCreateTopLevelProjects(boolean allowUsersToCreateTopLevelProjects) {
		this.allowUsersToCreateTopLevelProjects = allowUsersToCreateTopLevelProjects;
	}
	
	public java.lang.Boolean getCheckinMergingEnabled() {
		return checkinMergingEnabled;
	}

	public void setCheckinMergingEnabled(java.lang.Boolean checkinMergingEnabled) {
		this.checkinMergingEnabled = checkinMergingEnabled;
	}
	
	public java.lang.String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(java.lang.String smtpServer) {
		this.smtpServer = smtpServer;
	}
	
	public java.lang.String getEmailSenderAddress() {
		return emailSenderAddress;
	}

	public void setEmailSenderAddress(java.lang.String emailSenderAddress) {
		this.emailSenderAddress = emailSenderAddress;
	}
	
	public java.lang.String getEmailSenderName() {
		return emailSenderName;
	}

	public void setEmailSenderName(java.lang.String emailSenderName) {
		this.emailSenderName = emailSenderName;
	}
	
	public java.lang.String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(java.lang.String siteAddress) {
		this.siteAddress = siteAddress;
	}
	
	public boolean isGenerateGeometryOnCheckin() {
		return generateGeometryOnCheckin;
	}

	public void setGenerateGeometryOnCheckin(boolean generateGeometryOnCheckin) {
		this.generateGeometryOnCheckin = generateGeometryOnCheckin;
	}
	
	public boolean isAllowOnlyWhitelisted() {
		return allowOnlyWhitelisted;
	}

	public void setAllowOnlyWhitelisted(boolean allowOnlyWhitelisted) {
		this.allowOnlyWhitelisted = allowOnlyWhitelisted;
	}
	

	public List<java.lang.String> getWhitelistedDomains() {
		return whitelistedDomains;
	}

	public void setWhitelistedDomains(List<java.lang.String> whitelistedDomains) {
		this.whitelistedDomains = whitelistedDomains;
	}
	
	public java.lang.Boolean getHideUserListForNonAdmin() {
		return hideUserListForNonAdmin;
	}

	public void setHideUserListForNonAdmin(java.lang.Boolean hideUserListForNonAdmin) {
		this.hideUserListForNonAdmin = hideUserListForNonAdmin;
	}
	
	public java.lang.Integer getProtocolBuffersPort() {
		return protocolBuffersPort;
	}

	public void setProtocolBuffersPort(java.lang.Integer protocolBuffersPort) {
		this.protocolBuffersPort = protocolBuffersPort;
	}
	
	public java.lang.Boolean getCacheOutputFiles() {
		return cacheOutputFiles;
	}

	public void setCacheOutputFiles(java.lang.Boolean cacheOutputFiles) {
		this.cacheOutputFiles = cacheOutputFiles;
	}
	
	public List<Long> getWebModules() {
		return webModules;
	}

	public void setWebModules(List<Long> webModules) {
		this.webModules = webModules;
	}
	
	public long getWebModuleId() {
		return webModuleId;
	}

	public void setWebModuleId(long webModuleId) {
		this.webModuleId = webModuleId;
	}
	
	public java.lang.String getServiceRepositoryUrl() {
		return serviceRepositoryUrl;
	}

	public void setServiceRepositoryUrl(java.lang.String serviceRepositoryUrl) {
		this.serviceRepositoryUrl = serviceRepositoryUrl;
	}
	
	public boolean isSendEmailOnNewRevision() {
		return sendEmailOnNewRevision;
	}

	public void setSendEmailOnNewRevision(boolean sendEmailOnNewRevision) {
		this.sendEmailOnNewRevision = sendEmailOnNewRevision;
	}
	
	public int getSessionTimeOutSeconds() {
		return sessionTimeOutSeconds;
	}

	public void setSessionTimeOutSeconds(int sessionTimeOutSeconds) {
		this.sessionTimeOutSeconds = sessionTimeOutSeconds;
	}
	
	public java.lang.String getSmtpUsername() {
		return smtpUsername;
	}

	public void setSmtpUsername(java.lang.String smtpUsername) {
		this.smtpUsername = smtpUsername;
	}
	
	public java.lang.String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(java.lang.String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}
	
	public int getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}
	
	public SSmtpProtocol getSmtpProtocol() {
		return smtpProtocol;
	}

	public void setSmtpProtocol(SSmtpProtocol smtpProtocol) {
		this.smtpProtocol = smtpProtocol;
	}
	
	public boolean isReuseGeometry() {
		return reuseGeometry;
	}

	public void setReuseGeometry(boolean reuseGeometry) {
		this.reuseGeometry = reuseGeometry;
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
		SServerSettings other = (SServerSettings) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}