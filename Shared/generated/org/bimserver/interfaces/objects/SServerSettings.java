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
public class SServerSettings implements SDataBase
{
	private long oid = -1;
	private int rid = 0;

	@XmlTransient
	private static SClass sClass;
	private java.lang.Boolean showVersionUpgradeAvailable;
	private boolean sendConfirmationEmailAfterRegistration;
	private java.lang.Boolean useCaching;
	private java.lang.Boolean allowSelfRegistration;
	private boolean allowUsersToCreateTopLevelProjects;
	private java.lang.Boolean checkinMergingEnabled;
	private java.lang.String registrationAddition;
	private java.lang.String smtpServer;
	private java.lang.String emailSenderAddress;
	private java.lang.String customLogoAddress;
	private java.lang.String siteAddress;
	private List<java.lang.String> whitelistedDomains = new ArrayList<java.lang.String>();
	private java.lang.Boolean hideUserListForNonAdmin;
	private java.lang.Integer protocolBuffersPort;
	private java.lang.String headerAddition;
	private java.lang.String footerAddition;
	private java.lang.Boolean cacheOutputFiles;
	private java.lang.String serviceRepositoryUrl;
	public long getOid() {
		return oid;
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
		if (sField.getName().equals("showVersionUpgradeAvailable")) {
			return getShowVersionUpgradeAvailable();
		}
		if (sField.getName().equals("sendConfirmationEmailAfterRegistration")) {
			return isSendConfirmationEmailAfterRegistration();
		}
		if (sField.getName().equals("useCaching")) {
			return getUseCaching();
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
		if (sField.getName().equals("registrationAddition")) {
			return getRegistrationAddition();
		}
		if (sField.getName().equals("smtpServer")) {
			return getSmtpServer();
		}
		if (sField.getName().equals("emailSenderAddress")) {
			return getEmailSenderAddress();
		}
		if (sField.getName().equals("customLogoAddress")) {
			return getCustomLogoAddress();
		}
		if (sField.getName().equals("siteAddress")) {
			return getSiteAddress();
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
		if (sField.getName().equals("headerAddition")) {
			return getHeaderAddition();
		}
		if (sField.getName().equals("footerAddition")) {
			return getFooterAddition();
		}
		if (sField.getName().equals("cacheOutputFiles")) {
			return getCacheOutputFiles();
		}
		if (sField.getName().equals("serviceRepositoryUrl")) {
			return getServiceRepositoryUrl();
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
		if (sField.getName().equals("showVersionUpgradeAvailable")) {
			setShowVersionUpgradeAvailable((Boolean)val);
			return;
		}
		if (sField.getName().equals("sendConfirmationEmailAfterRegistration")) {
			setSendConfirmationEmailAfterRegistration((Boolean)val);
			return;
		}
		if (sField.getName().equals("useCaching")) {
			setUseCaching((Boolean)val);
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
		if (sField.getName().equals("registrationAddition")) {
			setRegistrationAddition((String)val);
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
		if (sField.getName().equals("customLogoAddress")) {
			setCustomLogoAddress((String)val);
			return;
		}
		if (sField.getName().equals("siteAddress")) {
			setSiteAddress((String)val);
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
		if (sField.getName().equals("headerAddition")) {
			setHeaderAddition((String)val);
			return;
		}
		if (sField.getName().equals("footerAddition")) {
			setFooterAddition((String)val);
			return;
		}
		if (sField.getName().equals("cacheOutputFiles")) {
			setCacheOutputFiles((Boolean)val);
			return;
		}
		if (sField.getName().equals("serviceRepositoryUrl")) {
			setServiceRepositoryUrl((String)val);
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
	
	public java.lang.Boolean getShowVersionUpgradeAvailable() {
		return showVersionUpgradeAvailable;
	}

	public void setShowVersionUpgradeAvailable(java.lang.Boolean showVersionUpgradeAvailable) {
		this.showVersionUpgradeAvailable = showVersionUpgradeAvailable;
	}
	
	public boolean isSendConfirmationEmailAfterRegistration() {
		return sendConfirmationEmailAfterRegistration;
	}

	public void setSendConfirmationEmailAfterRegistration(boolean sendConfirmationEmailAfterRegistration) {
		this.sendConfirmationEmailAfterRegistration = sendConfirmationEmailAfterRegistration;
	}
	
	public java.lang.Boolean getUseCaching() {
		return useCaching;
	}

	public void setUseCaching(java.lang.Boolean useCaching) {
		this.useCaching = useCaching;
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
	
	public java.lang.String getRegistrationAddition() {
		return registrationAddition;
	}

	public void setRegistrationAddition(java.lang.String registrationAddition) {
		this.registrationAddition = registrationAddition;
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
	
	public java.lang.String getCustomLogoAddress() {
		return customLogoAddress;
	}

	public void setCustomLogoAddress(java.lang.String customLogoAddress) {
		this.customLogoAddress = customLogoAddress;
	}
	
	public java.lang.String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(java.lang.String siteAddress) {
		this.siteAddress = siteAddress;
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
	
	public java.lang.String getHeaderAddition() {
		return headerAddition;
	}

	public void setHeaderAddition(java.lang.String headerAddition) {
		this.headerAddition = headerAddition;
	}
	
	public java.lang.String getFooterAddition() {
		return footerAddition;
	}

	public void setFooterAddition(java.lang.String footerAddition) {
		this.footerAddition = footerAddition;
	}
	
	public java.lang.Boolean getCacheOutputFiles() {
		return cacheOutputFiles;
	}

	public void setCacheOutputFiles(java.lang.Boolean cacheOutputFiles) {
		this.cacheOutputFiles = cacheOutputFiles;
	}
	
	public java.lang.String getServiceRepositoryUrl() {
		return serviceRepositoryUrl;
	}

	public void setServiceRepositoryUrl(java.lang.String serviceRepositoryUrl) {
		this.serviceRepositoryUrl = serviceRepositoryUrl;
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