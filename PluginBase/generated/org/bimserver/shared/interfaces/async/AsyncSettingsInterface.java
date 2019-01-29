package org.bimserver.shared.interfaces.async;

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
import java.util.concurrent.ExecutorService;
import org.bimserver.shared.interfaces.SettingsInterface;

public class AsyncSettingsInterface {

	private final ExecutorService executorService;
	private final SettingsInterface syncService;

	public AsyncSettingsInterface(SettingsInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface GetEmailSenderAddressCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetProtocolBuffersPortCallback {
		void success(java.lang.Integer result);
		void error(Throwable e);
	}
	
	public interface GetServerSettingsCallback {
		void success(org.bimserver.interfaces.objects.SServerSettings result);
		void error(Throwable e);
	}
	
	public interface GetServiceRepositoryUrlCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetSiteAddressCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetSmtpServerCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface IsAllowSelfRegistrationCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface IsAllowUsersToCreateTopLevelProjectsCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface IsCacheOutputFilesCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface IsCheckinMergingEnabledCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface IsGenerateGeometryOnCheckinCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface IsHideUserListForNonAdminCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface IsPluginStrictVersionCheckingCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface IsSendConfirmationEmailAfterRegistrationCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface SetAllowSelfRegistrationCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetAllowUsersToCreateTopLevelProjectsCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetCacheOutputFilesCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetCheckinMergingEnabledCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetEmailSenderAddressCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetGenerateGeometryOnCheckinCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetHideUserListForNonAdminCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetPluginStrictVersionCheckingCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetProtocolBuffersPortCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetSendConfirmationEmailAfterRegistrationCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetServerDescriptionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetServerIconCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetServerNameCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetServerSettingsCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetServiceRepositoryUrlCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetSiteAddressCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetSmtpServerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetWhiteListedDomainsCallback {
		void success();
		void error(Throwable e);
	}
	


	public void getEmailSenderAddress(final GetEmailSenderAddressCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getEmailSenderAddress());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getProtocolBuffersPort(final GetProtocolBuffersPortCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getProtocolBuffersPort());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServerSettings(final GetServerSettingsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServerSettings());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServiceRepositoryUrl(final GetServiceRepositoryUrlCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServiceRepositoryUrl());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSiteAddress(final GetSiteAddressCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSiteAddress());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSmtpServer(final GetSmtpServerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSmtpServer());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isAllowSelfRegistration(final IsAllowSelfRegistrationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isAllowSelfRegistration());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isAllowUsersToCreateTopLevelProjects(final IsAllowUsersToCreateTopLevelProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isAllowUsersToCreateTopLevelProjects());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isCacheOutputFiles(final IsCacheOutputFilesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isCacheOutputFiles());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isCheckinMergingEnabled(final IsCheckinMergingEnabledCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isCheckinMergingEnabled());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isGenerateGeometryOnCheckin(final IsGenerateGeometryOnCheckinCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isGenerateGeometryOnCheckin());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isHideUserListForNonAdmin(final IsHideUserListForNonAdminCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isHideUserListForNonAdmin());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isPluginStrictVersionChecking(final IsPluginStrictVersionCheckingCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isPluginStrictVersionChecking());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isSendConfirmationEmailAfterRegistration(final IsSendConfirmationEmailAfterRegistrationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isSendConfirmationEmailAfterRegistration());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setAllowSelfRegistration(final java.lang.Boolean allowSelfRegistration, final SetAllowSelfRegistrationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setAllowSelfRegistration(allowSelfRegistration);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setAllowUsersToCreateTopLevelProjects(final java.lang.Boolean allowUsersToCreateTopLevelProjects, final SetAllowUsersToCreateTopLevelProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setAllowUsersToCreateTopLevelProjects(allowUsersToCreateTopLevelProjects);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setCacheOutputFiles(final java.lang.Boolean cacheOutputFiles, final SetCacheOutputFilesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setCacheOutputFiles(cacheOutputFiles);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setCheckinMergingEnabled(final java.lang.Boolean checkinMergingEnabled, final SetCheckinMergingEnabledCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setCheckinMergingEnabled(checkinMergingEnabled);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setEmailSenderAddress(final java.lang.String emailSenderAddress, final SetEmailSenderAddressCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setEmailSenderAddress(emailSenderAddress);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setGenerateGeometryOnCheckin(final java.lang.Boolean generateGeometryOnCheckin, final SetGenerateGeometryOnCheckinCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setGenerateGeometryOnCheckin(generateGeometryOnCheckin);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setHideUserListForNonAdmin(final java.lang.Boolean hideUserListForNonAdmin, final SetHideUserListForNonAdminCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setHideUserListForNonAdmin(hideUserListForNonAdmin);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setPluginStrictVersionChecking(final java.lang.Boolean strict, final SetPluginStrictVersionCheckingCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setPluginStrictVersionChecking(strict);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setProtocolBuffersPort(final java.lang.Integer port, final SetProtocolBuffersPortCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setProtocolBuffersPort(port);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setSendConfirmationEmailAfterRegistration(final java.lang.Boolean sendConfirmationEmailAfterRegistration, final SetSendConfirmationEmailAfterRegistrationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setSendConfirmationEmailAfterRegistration(sendConfirmationEmailAfterRegistration);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setServerDescription(final java.lang.String strict, final SetServerDescriptionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setServerDescription(strict);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setServerIcon(final java.lang.String serverIcon, final SetServerIconCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setServerIcon(serverIcon);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setServerName(final java.lang.String serverName, final SetServerNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setServerName(serverName);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setServerSettings(final org.bimserver.interfaces.objects.SServerSettings serverSettings, final SetServerSettingsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setServerSettings(serverSettings);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setServiceRepositoryUrl(final java.lang.String url, final SetServiceRepositoryUrlCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setServiceRepositoryUrl(url);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setSiteAddress(final java.lang.String siteAddress, final SetSiteAddressCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setSiteAddress(siteAddress);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setSmtpServer(final java.lang.String smtpServer, final SetSmtpServerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setSmtpServer(smtpServer);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setWhiteListedDomains(final java.util.List<java.lang.String> domains, final SetWhiteListedDomainsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setWhiteListedDomains(domains);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}