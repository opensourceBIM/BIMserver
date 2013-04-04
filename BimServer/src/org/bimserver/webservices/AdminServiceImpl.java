package org.bimserver.webservices;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.client.protocolbuffers.ProtocolBuffersBimServerClientFactory;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.GetDatabaseInformationAction;
import org.bimserver.database.actions.GetLogsDatabaseAction;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.database.migrations.MigrationException;
import org.bimserver.database.migrations.Migrator;
import org.bimserver.interfaces.objects.SBimServerInfo;
import org.bimserver.interfaces.objects.SDatabaseInformation;
import org.bimserver.interfaces.objects.SJavaInfo;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SMigration;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SServerInfo;
import org.bimserver.interfaces.objects.SSystemInfo;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.store.DatabaseInformation;
import org.bimserver.models.store.UserType;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.utils.Formatters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminServiceImpl extends GenericServiceImpl implements AdminInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

	public AdminServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public Integer clearOutputFileCache() {
		return getBimServer().getDiskCacheManager().cleanup();
	}

	@Override
	public SSystemInfo getSystemInfo() {
		SSystemInfo systemInfo = new SSystemInfo();
		systemInfo.setCpucores(Runtime.getRuntime().availableProcessors());
		systemInfo.setDatetime(new GregorianCalendar().getTime());
		systemInfo.setOsname(System.getProperty("os.name"));
		systemInfo.setOsversion(System.getProperty("os.version"));
		systemInfo.setUserName(System.getProperty("user.name"));
		systemInfo.setUserHome(System.getProperty("user.home"));
		systemInfo.setUserDir(System.getProperty("user.dir"));
		return systemInfo;
	}

	@Override
	public SJavaInfo getJavaInfo() {
		SJavaInfo javaInfo = new SJavaInfo();
		javaInfo.setHeapTotal(Runtime.getRuntime().totalMemory());
		javaInfo.setHeapUsed(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
		javaInfo.setHeapFree(Runtime.getRuntime().freeMemory());
		javaInfo.setHeapMax(Runtime.getRuntime().maxMemory());
		javaInfo.setThreads(Thread.activeCount());
		javaInfo.setJavaHome(System.getProperty("java.home"));
		javaInfo.setJavaVersion(System.getProperty("java.version"));
		javaInfo.setJavaVendor(System.getProperty("java.vendor"));
		javaInfo.setJavaVendorurl(System.getProperty("java.vendor.url"));
		javaInfo.setJavavmVersion(System.getProperty("java.vm.version"));
		javaInfo.setJavavmVendor(System.getProperty("java.vm.vendor"));
		javaInfo.setJavavmName(System.getProperty("java.vm.name"));
		javaInfo.setJavaspecVersion(System.getProperty("java.specification.version"));
		javaInfo.setJavaspecVendor(System.getProperty("java.specification.vendor"));
		javaInfo.setJavaspecName(System.getProperty("java.specification.name"));
		javaInfo.setJavaClassVersion(System.getProperty("java.class.version"));
		
		for (String classp : System.getProperty("java.class.path").split(File.pathSeparator)) {
			javaInfo.getJavaClasspath().add(classp);
		}
		for (String classp : System.getProperty("java.library.path").split(File.pathSeparator)) {
			javaInfo.getJavaLibrarypath().add(classp);
		}
		javaInfo.setJavaIoTmp(System.getProperty("java.io.tmpdir"));
		javaInfo.setJavaCompiler(System.getProperty("java.compiler"));
		javaInfo.setJavaExtdir(System.getProperty("java.ext.dirs"));
		javaInfo.setJavaFileSeparator(System.getProperty("file.separator"));
		javaInfo.setJavaPathSeparator(System.getProperty("path.separator"));
		javaInfo.setJavaLineSeparator(System.getProperty("line.separator"));
		
		return javaInfo;
	}

	@Override
	public SBimServerInfo getBimServerInfo() throws ServerException, UserException {
		SBimServerInfo bimServerInfo = new SBimServerInfo();
		SVersion version = getBimServer().getVersionChecker().getLocalVersion();
		SVersion latestVersion = getBimServer().getVersionChecker().getOnlineVersion();
		
		SDatabaseInformation databaseInformation = getDatabaseInformation();
		
		bimServerInfo.setCurrentVersion(version.getMajor() + "." + version.getMinor() + "." + version.getRevision());
		bimServerInfo.setCurrentDate(version.getDate());
		bimServerInfo.setLatestVersion(latestVersion.getMajor() + "." + latestVersion.getMinor() + "." + latestVersion.getRevision());
		bimServerInfo.setLatestDate(latestVersion.getDate());
		bimServerInfo.setCheckouts(databaseInformation.getNumberOfCheckouts());
		bimServerInfo.setRevisions(databaseInformation.getNumberOfRevisions());
		bimServerInfo.setUsers(databaseInformation.getNumberOfUsers());
		bimServerInfo.setProjects(databaseInformation.getNumberOfProjects());
		bimServerInfo.setSchemaVersion(databaseInformation.getSchemaVersion());
		bimServerInfo.setServerLogUrl(getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/download?action=getfile&file=serverlog");
		bimServerInfo.setStarted(getServerStartTime());
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(getServerStartTime());
		bimServerInfo.setUptime(Formatters.timeSpanToString(gc, new GregorianCalendar()));
		
		return bimServerInfo;
	}

	@Override
	public String getServerLog() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		try {
			return FileUtils.readFileToString(new File(getBimServer().getHomeDir(), "logs/getBimServer().log"));
		} catch (IOException e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		}
	}

	@Override
	public String getProtocolBuffersFile(String interfaceName) throws ServerException, UserException {
		InputStream resourceAsStream = ProtocolBuffersBimServerClientFactory.class.getResourceAsStream(interfaceName + ".proto");
		StringWriter stringWriter = new StringWriter();
		try {
			IOUtils.copy(resourceAsStream, stringWriter);
		} catch (IOException e) {
			throw new ServerException(e);
		}
		return stringWriter.toString();
	}

	@Override
	public SServerInfo getServerInfo() {
		return getBimServer().getSConverter().convertToSObject(getBimServer().getServerInfo());
	}

	@Override
	public SVersion getVersion() throws ServerException, UserException {
		return getBimServer().getVersionChecker().getLocalVersion();
	}

	@Override
	public SVersion getLatestVersion() throws ServerException, UserException {
		return getBimServer().getVersionChecker().getOnlineVersion();
	}

	@Override
	public Boolean upgradePossible() {
		return getBimServer().getVersionChecker().updateNeeded();
	}
	

	@Override
	public void disablePlugin(String name) throws UserException {
		requireAdminAuthenticationAndRunningServer();
		getBimServer().getPluginManager().disablePlugin(name);
	}

	@Override
	public void enablePlugin(String name) throws UserException {
		requireAdminAuthenticationAndRunningServer();
		getBimServer().getPluginManager().enablePlugin(name);
	}


	@Override
	public Date getServerStartTime() {
		return getBimServer().getServerStartTime().getTime();
	}
	

	@Override
	public Date getLastDatabaseReset() throws ServerException, UserException {
		requireRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return session.getCreatedDate();
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void setup(String siteAddress, String smtpServer, String smtpSender, String adminName, String adminUsername, String adminPassword) throws ServerException, UserException {
		SettingsInterface settingsInterface = getServiceMap().get(SettingsInterface.class);
		settingsInterface.setSmtpServer(smtpServer);
		settingsInterface.setSiteAddress(siteAddress);
		settingsInterface.setEmailSenderAddress(smtpSender);

		if (adminUsername.trim().isEmpty()) {
			throw new UserException("Admin Username cannot be empty");
		}

		if (adminPassword.trim().isEmpty()) {
			throw new UserException("Admin Password cannot be empty");
		}

		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			AddUserDatabaseAction addUserDatabaseAction = new AddUserDatabaseAction(getBimServer(), session, AccessMethod.INTERNAL, adminUsername, adminPassword, adminName, UserType.ADMIN, getAuthorization(), false);
			session.executeAndCommitAction(addUserDatabaseAction);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
		getBimServer().getServerInfoManager().update();
	}

	@Override
	public List<SMigration> getMigrations() throws UserException {
		Migrator migrator = getBimServer().getDatabase().getMigrator();
		List<SMigration> list = new ArrayList<SMigration>(getBimServer().getSConverter().convertToSSetMigration(migrator.getMigrations()));
		Collections.sort(list, new SMigrationComparator());
		return list;
	}

	@Override
	public void migrateDatabase() throws ServerException, UserException {
		try {
			getBimServer().getDatabase().getMigrator().migrate();
			getBimServer().getServerInfoManager().update();
		} catch (MigrationException e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		} catch (InconsistentModelsException e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		}
	}

	@Override
	public List<SLogAction> getLogs() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<List<LogAction>> action = new GetLogsDatabaseAction(session, getInternalAccessMethod(), getAuthorization());
			List<LogAction> logs = session.executeAndCommitAction(action);
			List<SLogAction> convertToSListLogAction = getBimServer().getSConverter().convertToSListLogAction(logs);
			Collections.sort(convertToSListLogAction, new SLogComparator(true));
			return convertToSListLogAction;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SDatabaseInformation getDatabaseInformation() throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<DatabaseInformation> action = new GetDatabaseInformationAction(session, getInternalAccessMethod());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<SPluginDescriptor> getAllPlugins() throws UserException {
		requireRealUserAuthentication();
		List<SPluginDescriptor> result = new ArrayList<SPluginDescriptor>();
		Collection<Plugin> plugins = getBimServer().getPluginManager().getAllPlugins(false);
		for (Plugin plugin : plugins) {
			SPluginDescriptor sPluginDescriptor = new SPluginDescriptor();
			sPluginDescriptor.setSimpleName(plugin.getClass().getSimpleName());
			sPluginDescriptor.setDefaultName(plugin.getClass().getName());
			PluginContext pluginContext = getBimServer().getPluginManager().getPluginContext(plugin);
			sPluginDescriptor.setLocation(pluginContext.getLocation());
			sPluginDescriptor.setDescription(plugin.getDescription());
			sPluginDescriptor.setEnabled(pluginContext.isEnabled());
			result.add(sPluginDescriptor);
		}
		Collections.sort(result, new SPluginDescriptorComparator());
		return result;
	}
}