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
import org.bimserver.shared.interfaces.AdminInterface;

public class AsyncAdminInterface {

	private final ExecutorService executorService;
	private final AdminInterface syncService;

	public AsyncAdminInterface(AdminInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface ClearOutputFileCacheCallback {
		void success(java.lang.Integer result);
		void error(Throwable e);
	}
	
	public interface DisablePluginCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface EnablePluginCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface GcCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface GetAllPluginsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetBimServerInfoCallback {
		void success(org.bimserver.interfaces.objects.SBimServerInfo result);
		void error(Throwable e);
	}
	
	public interface GetDatabaseInformationCallback {
		void success(org.bimserver.interfaces.objects.SDatabaseInformation result);
		void error(Throwable e);
	}
	
	public interface GetJavaInfoCallback {
		void success(org.bimserver.interfaces.objects.SJavaInfo result);
		void error(Throwable e);
	}
	
	public interface GetLastDatabaseResetCallback {
		void success(java.util.Date result);
		void error(Throwable e);
	}
	
	public interface GetLatestVersionCallback {
		void success(org.bimserver.interfaces.objects.SVersion result);
		void error(Throwable e);
	}
	
	public interface GetLogsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SLogAction> result);
		void error(Throwable e);
	}
	
	public interface GetMetricsCallback {
		void success(org.bimserver.interfaces.objects.SMetrics result);
		void error(Throwable e);
	}
	
	public interface GetMigrationsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SMigration> result);
		void error(Throwable e);
	}
	
	public interface GetProtocolBuffersFileCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetServerInfoCallback {
		void success(org.bimserver.interfaces.objects.SServerInfo result);
		void error(Throwable e);
	}
	
	public interface GetServerLogCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetServerStartTimeCallback {
		void success(java.util.Date result);
		void error(Throwable e);
	}
	
	public interface GetSystemInfoCallback {
		void success(org.bimserver.interfaces.objects.SSystemInfo result);
		void error(Throwable e);
	}
	
	public interface GetVersionCallback {
		void success(org.bimserver.interfaces.objects.SVersion result);
		void error(Throwable e);
	}
	
	public interface MigrateDatabaseCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RegenerateGeometryCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetupCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface ShutdownCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpgradePossibleCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	


	public void clearOutputFileCache(final ClearOutputFileCacheCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.clearOutputFileCache());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void disablePlugin(final java.lang.String name, final DisablePluginCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.disablePlugin(name);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void enablePlugin(final java.lang.String name, final EnablePluginCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.enablePlugin(name);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void gc(final GcCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.gc();
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllPlugins(final GetAllPluginsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllPlugins());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getBimServerInfo(final GetBimServerInfoCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getBimServerInfo());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDatabaseInformation(final GetDatabaseInformationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDatabaseInformation());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getJavaInfo(final GetJavaInfoCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getJavaInfo());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getLastDatabaseReset(final GetLastDatabaseResetCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getLastDatabaseReset());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getLatestVersion(final GetLatestVersionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getLatestVersion());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getLogs(final GetLogsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getLogs());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getMetrics(final GetMetricsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getMetrics());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getMigrations(final GetMigrationsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getMigrations());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getProtocolBuffersFile(final java.lang.String interfaceName, final GetProtocolBuffersFileCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getProtocolBuffersFile(interfaceName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServerInfo(final GetServerInfoCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServerInfo());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServerLog(final GetServerLogCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServerLog());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServerStartTime(final GetServerStartTimeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServerStartTime());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSystemInfo(final GetSystemInfoCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSystemInfo());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getVersion(final GetVersionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getVersion());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void migrateDatabase(final MigrateDatabaseCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.migrateDatabase();
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void regenerateGeometry(final java.lang.Long croid, final RegenerateGeometryCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.regenerateGeometry(croid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setup(final java.lang.String siteAddress, final java.lang.String serverName, final java.lang.String serverDescription, final java.lang.String serverIcon, final java.lang.String adminName, final java.lang.String adminUsername, final java.lang.String adminPassword, final SetupCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setup(siteAddress, serverName, serverDescription, serverIcon, adminName, adminUsername, adminPassword);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void shutdown(final ShutdownCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.shutdown();
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void upgradePossible(final UpgradePossibleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.upgradePossible());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}