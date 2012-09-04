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
public class SSettings implements SBase
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
		SSettings.sClass = sClass;
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
		if (sField.getName().equals("autoTestClashes")) {
			return getAutoTestClashes();
		}
		if (sField.getName().equals("intelligentMerging")) {
			return getIntelligentMerging();
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
		if (sField.getName().equals("hideUserListForNonAdmin")) {
			return getHideUserListForNonAdmin();
		}
		if (sField.getName().equals("protocolBuffersPort")) {
			return getProtocolBuffersPort();
		}
		if (sField.getName().equals("serializers")) {
			return getSerializers();
		}
		if (sField.getName().equals("objectIDMs")) {
			return getObjectIDMs();
		}
		if (sField.getName().equals("headerAddition")) {
			return getHeaderAddition();
		}
		if (sField.getName().equals("footerAddition")) {
			return getFooterAddition();
		}
		if (sField.getName().equals("mergeIdentifier")) {
			return getMergeIdentifier();
		}
		if (sField.getName().equals("cacheOutputFiles")) {
			return getCacheOutputFiles();
		}
		if (sField.getName().equals("ifcEngines")) {
			return getIfcEngines();
		}
		if (sField.getName().equals("plugins")) {
			return getPlugins();
		}
		if (sField.getName().equals("deserializers")) {
			return getDeserializers();
		}
		if (sField.getName().equals("schemas")) {
			return getSchemas();
		}
		if (sField.getName().equals("queryengines")) {
			return getQueryengines();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
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
		if (sField.getName().equals("autoTestClashes")) {
			setAutoTestClashes((Boolean)val);
			return;
		}
		if (sField.getName().equals("intelligentMerging")) {
			setIntelligentMerging((Boolean)val);
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
		if (sField.getName().equals("hideUserListForNonAdmin")) {
			setHideUserListForNonAdmin((Boolean)val);
			return;
		}
		if (sField.getName().equals("protocolBuffersPort")) {
			setProtocolBuffersPort((Integer)val);
			return;
		}
		if (sField.getName().equals("serializers")) {
			setSerializers((List<Long>)val);
			return;
		}
		if (sField.getName().equals("objectIDMs")) {
			setObjectIDMs((List<Long>)val);
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
		if (sField.getName().equals("mergeIdentifier")) {
			setMergeIdentifier((SMergeIdentifier)val);
			return;
		}
		if (sField.getName().equals("cacheOutputFiles")) {
			setCacheOutputFiles((Boolean)val);
			return;
		}
		if (sField.getName().equals("ifcEngines")) {
			setIfcEngines((List<Long>)val);
			return;
		}
		if (sField.getName().equals("plugins")) {
			setPlugins((List<Long>)val);
			return;
		}
		if (sField.getName().equals("deserializers")) {
			setDeserializers((List<Long>)val);
			return;
		}
		if (sField.getName().equals("schemas")) {
			setSchemas((List<Long>)val);
			return;
		}
		if (sField.getName().equals("queryengines")) {
			setQueryengines((List<Long>)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private java.lang.Boolean showVersionUpgradeAvailable;
	private boolean sendConfirmationEmailAfterRegistration;
	private java.lang.Boolean useCaching;
	private java.lang.Boolean allowSelfRegistration;
	private java.lang.Boolean autoTestClashes;
	private java.lang.Boolean intelligentMerging;
	private boolean allowUsersToCreateTopLevelProjects;
	private java.lang.Boolean checkinMergingEnabled;
	private java.lang.String registrationAddition;
	private java.lang.String smtpServer;
	private java.lang.String emailSenderAddress;
	private java.lang.String customLogoAddress;
	private java.lang.String siteAddress;
	private java.lang.Boolean hideUserListForNonAdmin;
	private java.lang.Integer protocolBuffersPort;
	private List<Long> serializers = new ArrayList<Long>();
	private List<Long> objectIDMs = new ArrayList<Long>();
	private java.lang.String headerAddition;
	private java.lang.String footerAddition;
	private SMergeIdentifier mergeIdentifier;
	private java.lang.Boolean cacheOutputFiles;
	private List<Long> ifcEngines = new ArrayList<Long>();
	private List<Long> plugins = new ArrayList<Long>();
	private List<Long> deserializers = new ArrayList<Long>();
	private List<Long> schemas = new ArrayList<Long>();
	private List<Long> queryengines = new ArrayList<Long>();
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
	public java.lang.Boolean getAutoTestClashes() {
		return autoTestClashes;
	}

	public void setAutoTestClashes(java.lang.Boolean autoTestClashes) {
		this.autoTestClashes = autoTestClashes;
	}
	public java.lang.Boolean getIntelligentMerging() {
		return intelligentMerging;
	}

	public void setIntelligentMerging(java.lang.Boolean intelligentMerging) {
		this.intelligentMerging = intelligentMerging;
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
	public List<Long> getSerializers() {
		return serializers;
	}

	public void setSerializers(List<Long> serializers) {
		this.serializers = serializers;
	}
	public List<Long> getObjectIDMs() {
		return objectIDMs;
	}

	public void setObjectIDMs(List<Long> objectIDMs) {
		this.objectIDMs = objectIDMs;
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
	public SMergeIdentifier getMergeIdentifier() {
		return mergeIdentifier;
	}

	public void setMergeIdentifier(SMergeIdentifier mergeIdentifier) {
		this.mergeIdentifier = mergeIdentifier;
	}
	public java.lang.Boolean getCacheOutputFiles() {
		return cacheOutputFiles;
	}

	public void setCacheOutputFiles(java.lang.Boolean cacheOutputFiles) {
		this.cacheOutputFiles = cacheOutputFiles;
	}
	public List<Long> getIfcEngines() {
		return ifcEngines;
	}

	public void setIfcEngines(List<Long> ifcEngines) {
		this.ifcEngines = ifcEngines;
	}
	public List<Long> getPlugins() {
		return plugins;
	}

	public void setPlugins(List<Long> plugins) {
		this.plugins = plugins;
	}
	public List<Long> getDeserializers() {
		return deserializers;
	}

	public void setDeserializers(List<Long> deserializers) {
		this.deserializers = deserializers;
	}
	public List<Long> getSchemas() {
		return schemas;
	}

	public void setSchemas(List<Long> schemas) {
		this.schemas = schemas;
	}
	public List<Long> getQueryengines() {
		return queryengines;
	}

	public void setQueryengines(List<Long> queryengines) {
		this.queryengines = queryengines;
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
		SSettings other = (SSettings) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}