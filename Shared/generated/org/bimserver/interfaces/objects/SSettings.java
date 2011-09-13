package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SSettings
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private boolean showVersionUpgradeAvailable;
	private boolean sendConfirmationEmailAfterRegistration;
	private boolean useCaching;
	private boolean allowSelfRegistration;
	private boolean autoTestClashes;
	private boolean intelligentMerging;
	private boolean allowUsersToCreateTopLevelProjects;
	private boolean checkinMergingEnabled;
	private java.lang.String registrationAddition;
	private java.lang.String smtpServer;
	private java.lang.String emailSenderAddress;
	private java.lang.String enabledExportTypes;
	private java.lang.String customLogoAddress;
	private java.lang.String siteAddress;
	private List<Long> serializers = new ArrayList<Long>();
	private List<Long> guidanceProviders = new ArrayList<Long>();
	private java.lang.String headerAddition;
	private java.lang.String footerAddition;
	private SMergeIdentifier mergeIdentifier;
	private boolean cacheOutputFiles;
	private List<Long> ifcEngines = new ArrayList<Long>();
	private List<Long> plugins = new ArrayList<Long>();
	private List<Long> deserializers = new ArrayList<Long>();

	public boolean isShowVersionUpgradeAvailable() {
		return showVersionUpgradeAvailable;
	}

	public void setShowVersionUpgradeAvailable(boolean showVersionUpgradeAvailable) {
		this.showVersionUpgradeAvailable = showVersionUpgradeAvailable;
	}

	public boolean isSendConfirmationEmailAfterRegistration() {
		return sendConfirmationEmailAfterRegistration;
	}

	public void setSendConfirmationEmailAfterRegistration(boolean sendConfirmationEmailAfterRegistration) {
		this.sendConfirmationEmailAfterRegistration = sendConfirmationEmailAfterRegistration;
	}

	public boolean isUseCaching() {
		return useCaching;
	}

	public void setUseCaching(boolean useCaching) {
		this.useCaching = useCaching;
	}

	public boolean isAllowSelfRegistration() {
		return allowSelfRegistration;
	}

	public void setAllowSelfRegistration(boolean allowSelfRegistration) {
		this.allowSelfRegistration = allowSelfRegistration;
	}

	public boolean isAutoTestClashes() {
		return autoTestClashes;
	}

	public void setAutoTestClashes(boolean autoTestClashes) {
		this.autoTestClashes = autoTestClashes;
	}

	public boolean isIntelligentMerging() {
		return intelligentMerging;
	}

	public void setIntelligentMerging(boolean intelligentMerging) {
		this.intelligentMerging = intelligentMerging;
	}

	public boolean isAllowUsersToCreateTopLevelProjects() {
		return allowUsersToCreateTopLevelProjects;
	}

	public void setAllowUsersToCreateTopLevelProjects(boolean allowUsersToCreateTopLevelProjects) {
		this.allowUsersToCreateTopLevelProjects = allowUsersToCreateTopLevelProjects;
	}

	public boolean isCheckinMergingEnabled() {
		return checkinMergingEnabled;
	}

	public void setCheckinMergingEnabled(boolean checkinMergingEnabled) {
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

	public java.lang.String getEnabledExportTypes() {
		return enabledExportTypes;
	}

	public void setEnabledExportTypes(java.lang.String enabledExportTypes) {
		this.enabledExportTypes = enabledExportTypes;
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
	public List<Long> getSerializers() {
		return serializers;
	}

	public void setSerializers(List<Long> serializers) {
		this.serializers = serializers;
	}
	public List<Long> getGuidanceProviders() {
		return guidanceProviders;
	}

	public void setGuidanceProviders(List<Long> guidanceProviders) {
		this.guidanceProviders = guidanceProviders;
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

	public boolean isCacheOutputFiles() {
		return cacheOutputFiles;
	}

	public void setCacheOutputFiles(boolean cacheOutputFiles) {
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