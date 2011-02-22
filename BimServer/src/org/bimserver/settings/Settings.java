package org.bimserver.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.ServerInitializer;
import org.bimserver.shared.ResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlRootElement
public class Settings {

	private static final Logger LOGGER = LoggerFactory.getLogger(Settings.class);
	private boolean showVersionUpgradeAvailable;
	private boolean sendConfirmationEmailAfterRegistration;
	private boolean useCaching;
	private boolean allowSelfRegistration;
	private boolean autoTestClashes;
	private boolean intelligentMerging;
	private boolean allowUsersToCreateTopLevelProjects;
	private boolean checkinMergingEnabled;
	private String registrationAddition;
	private String smtpServer;
	private String emailSenderAddress;
	private String enabledExportTypes;
	private String customLogoAddress;
	private String siteAddress;

	public boolean isShowVersionUpgradeAvailable() {
		return showVersionUpgradeAvailable;
	}

	public void setShowVersionUpgradeAvailable(boolean showVersionUpgradeAvailable) {
		this.showVersionUpgradeAvailable = showVersionUpgradeAvailable;
	}

	public String getRegistrationAddition() {
		return registrationAddition;
	}

	public void setRegistrationAddition(String registrationAddition) {
		this.registrationAddition = registrationAddition;
	}

	public boolean isUseCaching() {
		return useCaching;
	}

	public void setUseCaching(boolean useCaching) {
		this.useCaching = useCaching;
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getEmailSenderAddress() {
		return emailSenderAddress;
	}

	public void setEmailSenderAddress(String emailSenderAddress) {
		this.emailSenderAddress = emailSenderAddress;
	}

	public boolean isSendConfirmationEmailAfterRegistration() {
		return sendConfirmationEmailAfterRegistration;
	}

	public void setSendConfirmationEmailAfterRegistration(boolean sendConfirmationEmailAfterRegistration) {
		this.sendConfirmationEmailAfterRegistration = sendConfirmationEmailAfterRegistration;
	}

	public static Settings readFromFile(File file) throws FileNotFoundException, SettingsReadException {
		if (file.exists() && file.isFile()) {
			return readFromStream(new FileInputStream(file));
		}
		return new Settings();
	}

	public void updateEnabledResultTypes(Set<ResultType> resultTypes) {
		String enabledExportTypes = "";
		for (ResultType resultType : resultTypes) {
			enabledExportTypes += resultType.name() + ",";
		}
		if (enabledExportTypes.endsWith(",")) {
			enabledExportTypes = enabledExportTypes.substring(0, enabledExportTypes.length() - 1);
		}
		this.enabledExportTypes = enabledExportTypes;
	}

	public void saveToFile(File file) throws SettingsSaveException, FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(file);
		saveToStream(fos);
		try {
			fos.close();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public void saveToStream(OutputStream out) throws SettingsSaveException {
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Settings.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.marshal(this, out);
		} catch (JAXBException e) {
			throw new SettingsSaveException(e);
		}
	}

	public static Settings readFromUrl(URL resource) throws SettingsReadException, IOException {
		return readFromStream(resource.openStream());
	}

	public void setEnabledExportTypes(String enabledExportTypes) {
		this.enabledExportTypes = enabledExportTypes;
	}

	public String getEnabledExportTypes() {
		return enabledExportTypes;
	}

	public void setAllowSelfRegistration(boolean allowSelfRegistration) {
		this.allowSelfRegistration = allowSelfRegistration;
	}

	public boolean isAllowSelfRegistration() {
		return allowSelfRegistration;
	}

	public static Settings readFromStream(InputStream inputStream) throws SettingsReadException {
		try {
			JAXBContext jc = JAXBContext.newInstance(Settings.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object unmarshal = unmarshaller.unmarshal(inputStream);
			return (Settings) unmarshal;
		} catch (JAXBException e) {
			throw new SettingsReadException(e);
		}
	}

	public void save() throws SettingsSaveException {
		File file = ServerInitializer.getResourceFetcher().getFile("settings.xml");
		try {
			saveToFile(file);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
	}

	public static Settings read() throws SettingsReadException {
		File file = ServerInitializer.getResourceFetcher().getFile("settings.xml");
		try {
			return readFromFile(file);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public void setAutoTestClashes(boolean autoTestClashes) {
		this.autoTestClashes = autoTestClashes;
	}

	public boolean isAutoTestClashes() {
		return autoTestClashes;
	}

	public void setIntelligentMerging(boolean intelligentMerging) {
		this.intelligentMerging = intelligentMerging;
	}

	public boolean isIntelligentMerging() {
		return intelligentMerging;
	}

	public String getCustomLogoAddress() {
		return customLogoAddress;
	}

	public void setCustomLogoAddress(String customLogoAddress) {
		this.customLogoAddress = customLogoAddress;
	}

	public void setAllowUsersToCreateTopLevelProjects(boolean allowUsersToCreateTopLevelProjects) {
		this.allowUsersToCreateTopLevelProjects = allowUsersToCreateTopLevelProjects;
	}

	public boolean isAllowUsersToCreateTopLevelProjects() {
		return allowUsersToCreateTopLevelProjects;
	}

	public Set<ResultType> getEnabledExportTypesAsSet() {
		Set<ResultType> resultTypes = new HashSet<ResultType>();
		String[] split = enabledExportTypes.split(",");
		for (String s : split) {
			resultTypes.add(ResultType.valueOf(s));
		}
		return resultTypes;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setCheckinMergingEnabled(boolean checkinMergingEnabled) {
		this.checkinMergingEnabled = checkinMergingEnabled;
	}

	public boolean isCheckinMergingEnabled() {
		return checkinMergingEnabled;
	}
}