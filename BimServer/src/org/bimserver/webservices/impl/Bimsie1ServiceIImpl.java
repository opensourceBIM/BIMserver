package org.bimserver.webservices.impl;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.actions.AddExtendedDataToRevisionDatabaseAction;
import org.bimserver.database.actions.AddProjectDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.BranchToExistingProjectDatabaseAction;
import org.bimserver.database.actions.BranchToNewProjectDatabaseAction;
import org.bimserver.database.actions.DeleteProjectDatabaseAction;
import org.bimserver.database.actions.GetAllProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllRevisionsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetDeserializerByIdDatabaseAction;
import org.bimserver.database.actions.GetDeserializerByNameDatabaseAction;
import org.bimserver.database.actions.GetExtendedDataByIdDatabaseAction;
import org.bimserver.database.actions.GetExtendedDataSchemaByIdDatabaseAction;
import org.bimserver.database.actions.GetExtendedDataSchemaByNamespaceDatabaseAction;
import org.bimserver.database.actions.GetProjectByPoidDatabaseAction;
import org.bimserver.database.actions.GetProjectsByNameDatabaseAction;
import org.bimserver.database.actions.GetQueryEngineByIdDatabaseAction;
import org.bimserver.database.actions.GetQueryEngineByNameDatabaseAction;
import org.bimserver.database.actions.GetRevisionDatabaseAction;
import org.bimserver.database.actions.GetSerializerByContentTypeDatabaseAction;
import org.bimserver.database.actions.GetSerializerByIdDatabaseAction;
import org.bimserver.database.actions.GetSerializerByNameDatabaseAction;
import org.bimserver.database.actions.GetSubProjectsDatabaseAction;
import org.bimserver.database.actions.UndeleteProjectDatabaseAction;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.longaction.CannotBeScheduledException;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.longaction.LongBranchAction;
import org.bimserver.longaction.LongCheckoutAction;
import org.bimserver.longaction.LongDownloadAction;
import org.bimserver.longaction.LongDownloadOrCheckoutAction;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
import org.bimserver.webservices.SProjectComparator;
import org.bimserver.webservices.SRevisionComparator;
import org.bimserver.webservices.ServiceMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bimsie1ServiceIImpl extends GenericServiceImpl implements Bimsie1ServiceInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(Bimsie1ServiceInterface.class);

	public Bimsie1ServiceIImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public Long checkin(final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler data, Boolean sync) throws ServerException, UserException {
		return getServiceMap().get(ServiceInterface.class).checkin(poid, comment, deserializerOid, fileSize, fileName, data, false, sync);
	}
	
	@Override
	public Long checkout(Long roid, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		getAuthorization().canDownload(roid);
		DatabaseSession session = getBimServer().getDatabase().createSession();
		User user = null;
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = (SerializerPluginConfiguration) session.get(serializerOid, Query.getDefault());
//			org.bimserver.plugins.serializers.Serializer serializer = getBimServer().getEmfSerializerFactory().get(serializerOid).createSerializer(new org.bimserver.plugins.serializers.PluginConfiguration());
			if (serializerPluginConfiguration == null) {
				throw new UserException("No serializer with id " + serializerOid + " could be found");
			}
			if (!serializerPluginConfiguration.getPluginDescriptor().getPluginClassName().equals("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin") && !serializerPluginConfiguration.getPluginDescriptor().getPluginClassName().equals("org.bimserver.ifc.xml.serializer.IfcXmlSerializerPlugin")) {
				throw new UserException("Only IFC or IFCXML allowed when checking out");
			}
			DownloadParameters downloadParameters = DownloadParameters.fromRoids(getBimServer(), Collections.singleton(roid), serializerOid);
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			LongDownloadOrCheckoutAction longDownloadAction = new LongCheckoutAction(getBimServer(), user.getName(), user.getUsername(), downloadParameters, getAuthorization(), getInternalAccessMethod());
			try {
				getBimServer().getLongActionManager().start(longDownloadAction);
			} catch (CannotBeScheduledException e) {
				LOGGER.error("", e);
			}
			if (sync) {
				longDownloadAction.waitForCompletion();
			}
			return longDownloadAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Long checkinFromUrl(Long poid, String comment, Long deserializerOid, String fileName, String url, Boolean sync) throws ServerException, UserException {
		return getServiceMap().get(ServiceInterface.class).checkinFromUrl(poid, comment, deserializerOid, fileName, url, false, sync);
	}
	
	@Override
	public SDownloadResult getDownloadData(final Long actionId) throws ServerException, UserException {
		LongDownloadOrCheckoutAction longAction = (LongDownloadOrCheckoutAction) getBimServer().getLongActionManager().getLongAction(actionId);
		if (longAction != null) {
			longAction.waitForCompletion();
			SCheckoutResult result = longAction.getCheckoutResult();
			return result;
		} else {
			throw new UserException("No data found for laid " + actionId);
		}
	}
	
	public Long download(DownloadParameters downloadParameters, Boolean sync) throws ServerException, UserException {
		User user = null;
		for (long roid : downloadParameters.getRoids()) {
			getAuthorization().canDownload(roid);
		}
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
		} catch (BimserverDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
		LongDownloadOrCheckoutAction longDownloadAction = new LongDownloadAction(getBimServer(), user == null ? "Unknown" : user.getName(), user == null ? "Unknown" : user.getUsername(), downloadParameters, getAuthorization(), getInternalAccessMethod());
		try {
			getBimServer().getLongActionManager().start(longDownloadAction);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		if (sync) {
			longDownloadAction.waitForCompletion();
		}
		return longDownloadAction.getProgressTopic().getKey().getId();
	}
	
	public Long download(Long roid, Long serializerOid, Boolean showOwn, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromRoids(getBimServer(), Collections.singleton(roid), serializerOid), sync);
	}

	@Override
	public Long downloadByOids(Set<Long> roids, Set<Long> oids, Long serializerOid, Boolean sync, Boolean deep) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromOids(getBimServer(), serializerOid, roids, oids, deep), sync);
	}

	@Override
	public Long downloadByTypes(Set<Long> roids, Set<String> classNames, Long serializerOid, Boolean includeAllSubtypes, Boolean useObjectIDM, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DownloadParameters fromClassNames = DownloadParameters.fromClassNames(getBimServer(), roids, classNames, includeAllSubtypes, serializerOid, deep);
		fromClassNames.setUseObjectIDM(useObjectIDM);
		return download(fromClassNames, sync);
	}

	@Override
	public Long downloadByGuids(Set<Long> roids, Set<String> guids, Long serializerOid, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromGuids(getBimServer(), roids, guids, serializerOid, deep), sync);
	}

	@Override
	public Long downloadByNames(Set<Long> roids, Set<String> names, Long serializerOid, Boolean deep, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromNames(getBimServer(), roids, names, serializerOid, deep), sync);
	}

	@Override
	public Long downloadRevisions(Set<Long> roids, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromRoids(getBimServer(), roids, serializerOid), sync);
	}

	@Override
	public Long downloadQuery(Long roid, Long qeid, String code, Boolean sync, Long serializerOid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		return download(DownloadParameters.fromQuery(getBimServer(), roid, qeid, code, serializerOid), sync);
	}
	
	@Override
	public SSerializerPluginConfiguration getSerializerByName(String serializerName) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByNameDatabaseAction(session, getInternalAccessMethod(), serializerName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
	

	@Override
	public SDeserializerPluginConfiguration getDeserializerByName(String deserializerName) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetDeserializerByNameDatabaseAction(session, getInternalAccessMethod(), deserializerName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
	
	
	@Override
	public SDeserializerPluginConfiguration getDeserializerById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetDeserializerByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
	

	@Override
	public SQueryEnginePluginConfiguration getQueryEngineByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetQueryEngineByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	

	@Override
	public SQueryEnginePluginConfiguration getQueryEngineById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetQueryEngineByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SSerializerPluginConfiguration getSerializerById(Long oid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SSerializerPluginConfiguration getSerializerByContentType(String contentType) throws ServerException, UserException {
		// Not checking for real authentication here because a remote service should be able to use a serializer for download call
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByContentTypeDatabaseAction(session, getInternalAccessMethod(), contentType)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public SDeserializerPluginConfiguration getSuggestedDeserializerForExtension(String extension) throws ServerException, UserException {
		// Token authenticated users should also be able to call this method
		try {
			requireAuthenticationAndRunningServer();
			for (DeserializerPlugin deserializerPlugin : getBimServer().getPluginManager().getAllDeserializerPlugins(true)) {
				if (deserializerPlugin.canHandleExtension(extension)) {
					DatabaseSession session = getBimServer().getDatabase().createSession();
					try {
						UserSettings userSettings = getUserSettings(session);
						for (DeserializerPluginConfiguration deserializer : userSettings.getDeserializers()) {
							if (deserializer.getPluginDescriptor().getPluginClassName().equals(deserializerPlugin.getClass().getName())) {
								return getBimServer().getSConverter().convertToSObject(deserializer);
							}
						}
					} catch (BimserverDatabaseException e) {
						LOGGER.error("", e);
					} finally {
						session.close();
					}
				}
			}
		} catch (Exception e) {
			handleException(e);
		}
		return null;
	}

	@Override
	public void addExtendedDataToRevision(Long roid, SExtendedData extendedData) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ExtendedData convert = getBimServer().getSConverter().convertFromSObject(extendedData, session);
			session.executeAndCommitAction(new AddExtendedDataToRevisionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SExtendedDataSchema getExtendedDataSchemaById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SExtendedData getExtendedData(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataByIdDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public SRevision getRevision(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(session, getInternalAccessMethod(), roid, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SProject addProjectAsSubProject(String projectName, Long parentPoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), projectName, parentPoid, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long branchToNewProject(Long roid, String projectName, String comment, Boolean sync) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BranchToNewProjectDatabaseAction action = new BranchToNewProjectDatabaseAction(session, getInternalAccessMethod(), getBimServer(), getAuthorization(), roid, projectName, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongBranchAction longAction = new LongBranchAction(getBimServer(), username, userUsername, getAuthorization(), action);
			getBimServer().getLongActionManager().start(longAction);
			if (sync) {
				longAction.waitForCompletion();
			}
			return longAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long branchToExistingProject(Long roid, Long destPoid, String comment, Boolean sync) throws UserException, ServerException {
		requireRealUserAuthentication();
		final DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BranchToExistingProjectDatabaseAction action = new BranchToExistingProjectDatabaseAction(session, getInternalAccessMethod(), getBimServer(), getAuthorization(), roid, destPoid, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), Query.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongBranchAction longBranchAction = new LongBranchAction(getBimServer(), username, userUsername, getAuthorization(), action);
			getBimServer().getLongActionManager().start(longBranchAction);
			if (sync) {
				longBranchAction.waitForCompletion();
			}
			return longBranchAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			GetProjectByPoidDatabaseAction action = new GetProjectByPoidDatabaseAction(session, getInternalAccessMethod(), poid, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<SProject> getProjectsByName(String name) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			GetProjectsByNameDatabaseAction action = new GetProjectsByNameDatabaseAction(session, getInternalAccessMethod(), name, getAuthorization());
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<SProject> getSubProjects(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetSubProjectsDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), poid);
			List<SProject> convertToSListProject = getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
			Collections.sort(convertToSListProject, new SProjectComparator());
			return convertToSListProject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<SExtendedData> getAllExtendedDataOfRevision(Long roid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			Revision revision = (Revision)session.get(StorePackage.eINSTANCE.getRevision(), roid, Query.getDefault());
			return getBimServer().getSConverter().convertToSListExtendedData(revision.getExtendedData());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Boolean undeleteProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean deleteProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	

	@Override
	public List<SRevision> getAllRevisionsOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			List<SRevision> convertToSListRevision = getBimServer().getSConverter().convertToSListRevision(session.executeAndCommitAction(action));
			Collections.sort(convertToSListRevision, new SRevisionComparator(true));
			return convertToSListRevision;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	

	@Override
	public List<SProject> getAllProjects(Boolean onlyTopLevel, Boolean onlyActive) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(session, getInternalAccessMethod(), onlyTopLevel, onlyActive, getAuthorization());
			List<SProject> convertToSListProject = getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
			Collections.sort(convertToSListProject, new SProjectComparator());
			return convertToSListProject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	

	@Override
	public SProject addProject(String projectName) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), projectName, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	public SExtendedDataSchema getExtendedDataSchemaByNamespace(String nameSpace) throws UserException, ServerException {
		// Not checking for real authentication here because a remote service should be able to use an exs
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByNamespaceDatabaseAction(session, getInternalAccessMethod(), nameSpace)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
}