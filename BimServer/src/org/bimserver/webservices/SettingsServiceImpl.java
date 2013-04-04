package org.bimserver.webservices;

import java.util.List;

import javax.jws.WebMethod;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.actions.ServerSettingsSetter;
import org.bimserver.database.actions.SetServerSettingDatabaseAction;
import org.bimserver.database.actions.SetServerSettingsDatabaseAction;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SServerSettings;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.ServerState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.SettingsInterface;

public class SettingsServiceImpl extends GenericServiceImpl implements SettingsInterface {
	public SettingsServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public String getEmailSenderAddress() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return getBimServer().getServerSettingsCache().getServerSettings().getEmailSenderAddress();
	}

	@Override
	public String getServiceRepositoryUrl() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return getBimServer().getServerSettingsCache().getServerSettings().getServiceRepositoryUrl();
	}

	@Override
	public void setServiceRepositoryUrl(final String url) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setServiceRepositoryUrl(url);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setProtocolBuffersPort(final Integer port) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setProtocolBuffersPort(port);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Integer getProtocolBuffersPort() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return getBimServer().getServerSettingsCache().getServerSettings().getProtocolBuffersPort();
	}

	@Override
	public void setEmailSenderAddress(final String emailSenderAddress) throws ServerException, UserException {
		if (getBimServer().getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		if (emailSenderAddress.trim().isEmpty()) {
			throw new UserException("Email sender address cannot be empty");
		}
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setEmailSenderAddress(emailSenderAddress);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSiteAddress() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress();
	}

	@Override
	public void setSiteAddress(final String siteAddress) throws ServerException, UserException {
		if (getBimServer().getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		if (siteAddress.trim().isEmpty()) {
			throw new UserException("Site Address cannot be empty");
		} else if (!siteAddress.startsWith("http://") && !(siteAddress.startsWith("https://"))) {
			throw new UserException("Site Address must start with either \"http://\" or \"https://\"");
		}
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setSiteAddress(siteAddress);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getSmtpServer() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return getBimServer().getServerSettingsCache().getServerSettings().getSmtpServer();
	}

	@Override
	public void setSmtpServer(final String smtpServer) throws ServerException, UserException {
		if (getBimServer().getServerInfo().getServerState() != ServerState.NOT_SETUP) {
			requireAdminAuthentication();
		}
		if (smtpServer.trim().isEmpty()) {
			throw new UserException("SMTP server address cannot be empty");
		}
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setSmtpServer(smtpServer);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isAllowSelfRegistration() throws ServerException, UserException {
		return getBimServer().getServerSettingsCache().getServerSettings().getAllowSelfRegistration();
	}

	@Override
	public Boolean isHideUserListForNonAdmin() throws ServerException, UserException {
		requireAuthentication();
		return getBimServer().getServerSettingsCache().getServerSettings().getHideUserListForNonAdmin();
	}

	@Override
	public void setHideUserListForNonAdmin(final Boolean hideUserListForNonAdmin) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setHideUserListForNonAdmin(hideUserListForNonAdmin);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setAllowSelfRegistration(final Boolean allowSelfRegistration) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setAllowSelfRegistration(allowSelfRegistration);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isAllowUsersToCreateTopLevelProjects() throws ServerException, UserException {
		requireAuthentication();
		return getBimServer().getServerSettingsCache().getServerSettings().isAllowUsersToCreateTopLevelProjects();
	}

	@Override
	public void setAllowUsersToCreateTopLevelProjects(final Boolean allowUsersToCreateTopLevelProjects) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setAllowUsersToCreateTopLevelProjects(allowUsersToCreateTopLevelProjects);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isCheckinMergingEnabled() throws ServerException, UserException {
		requireAuthentication();
		return getBimServer().getServerSettingsCache().getServerSettings().getCheckinMergingEnabled();
	}

	@Override
	public void setCheckinMergingEnabled(final Boolean checkinMergingEnabled) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setCheckinMergingEnabled(checkinMergingEnabled);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isSendConfirmationEmailAfterRegistration() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return getBimServer().getServerSettingsCache().getServerSettings().isSendConfirmationEmailAfterRegistration();
	}

	@Override
	public void setSendConfirmationEmailAfterRegistration(final Boolean sendConfirmationEmailAfterRegistration) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setSendConfirmationEmailAfterRegistration(sendConfirmationEmailAfterRegistration);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean isCacheOutputFiles() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return getBimServer().getServerSettingsCache().getServerSettings().getCacheOutputFiles();
	}

	@Override
	public Boolean isGenerateGeometryOnCheckin() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		return getBimServer().getServerSettingsCache().getServerSettings().isGenerateGeometryOnCheckin();
	}
	
	@Override
	public void setCacheOutputFiles(final Boolean cacheOutputFiles) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setCacheOutputFiles(cacheOutputFiles);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void setGenerateGeometryOnCheckin(final Boolean generateGeometryOnCheckin) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter(){
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.setGenerateGeometryOnCheckin(generateGeometryOnCheckin);
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	
	@Override
	@WebMethod(action = "getServerSettings")
	public SServerSettings getServerSettings() throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			IfcModelInterface allOfType = session.getAllOfType(StorePackage.eINSTANCE.getServerSettings(), Query.getDefault());
			return getBimServer().getSConverter().convertToSObject(allOfType.getAll(ServerSettings.class).get(0));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	

	@Override
	public void setWhiteListedDomains(final List<String> domains) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingDatabaseAction action = new SetServerSettingDatabaseAction(getBimServer(), session, getInternalAccessMethod(), new ServerSettingsSetter() {
				@Override
				public void set(ServerSettings serverSettings) {
					serverSettings.getWhitelistedDomains().clear();
					serverSettings.getWhitelistedDomains().addAll(domains);
				}
			});
			session.executeAndCommitAction(action);
			getBimServer().getServerSettingsCache().updateCache();
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void setServerSettings(SServerSettings serverSettings) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetServerSettingsDatabaseAction action = new SetServerSettingsDatabaseAction(session, getInternalAccessMethod(), serverSettings);
			session.executeAndCommitAction(action);
			getBimServer().getServerSettingsCache().updateCache();
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
}