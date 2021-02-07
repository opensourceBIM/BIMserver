package org.bimserver.webservices.impl;

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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.actions.AddDeserializerDatabaseAction;
import org.bimserver.database.actions.AddInternalServiceDatabaseAction;
import org.bimserver.database.actions.AddModelCompareDatabaseAction;
import org.bimserver.database.actions.AddModelMergerDatabaseAction;
import org.bimserver.database.actions.AddQueryEngineDatabaseAction;
import org.bimserver.database.actions.AddRenderEngineDatabaseAction;
import org.bimserver.database.actions.AddSerializerDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DeleteDeserializerDatabaseAction;
import org.bimserver.database.actions.DeleteInternalServiceDatabaseAction;
import org.bimserver.database.actions.DeleteModelCompareDatabaseAction;
import org.bimserver.database.actions.DeleteModelMergerDatabaseAction;
import org.bimserver.database.actions.DeletePluginConfigurationDatabaseAction;
import org.bimserver.database.actions.DeleteQueryEngineDatabaseAction;
import org.bimserver.database.actions.DeleteRenderEngineDatabaseAction;
import org.bimserver.database.actions.DeleteSerializerDatabaseAction;
import org.bimserver.database.actions.GetAllInternalServicesOfService;
import org.bimserver.database.actions.GetAllPluginDescriptorsDatabaseAction;
import org.bimserver.database.actions.GetAvailablePluginBundles;
import org.bimserver.database.actions.GetByIdDatabaseAction;
import org.bimserver.database.actions.GetInstalledPluginBundle;
import org.bimserver.database.actions.GetInstalledPluginBundles;
import org.bimserver.database.actions.GetModelCompareByIdDatabaseAction;
import org.bimserver.database.actions.GetModelCompareByNameDatabaseAction;
import org.bimserver.database.actions.GetModelMergerByIdDatabaseAction;
import org.bimserver.database.actions.GetModelMergerByNameDatabaseAction;
import org.bimserver.database.actions.GetPluginBundle;
import org.bimserver.database.actions.GetPluginBundleVersionById;
import org.bimserver.database.actions.GetPluginInformation;
import org.bimserver.database.actions.GetRenderEngineByIdDatabaseAction;
import org.bimserver.database.actions.GetRenderEngineByNameDatabaseAction;
import org.bimserver.database.actions.GetSerializerByPluginClassNameDatabaseAction;
import org.bimserver.database.actions.GetWebModuleByIdDatabaseAction;
import org.bimserver.database.actions.GetWebModuleByNameDatabaseAction;
import org.bimserver.database.actions.InstallPluginBundle;
import org.bimserver.database.actions.InstallPluginBundleFromBytes;
import org.bimserver.database.actions.ListPluginsInBundle;
import org.bimserver.database.actions.ListWebModulesDatabaseAction;
import org.bimserver.database.actions.SetPluginSettingsDatabaseAction;
import org.bimserver.database.actions.SetPluginSystemSettingsDatabaseAction;
import org.bimserver.database.actions.SetUserSettingDatabaseAction;
import org.bimserver.database.actions.UninstallPluginBundle;
import org.bimserver.database.actions.UpdateDatabaseAction;
import org.bimserver.database.actions.UpdateDeserializerDatabaseAction;
import org.bimserver.database.actions.UpdateModelCompareDatabaseAction;
import org.bimserver.database.actions.UpdateModelMergerDatabaseAction;
import org.bimserver.database.actions.UpdatePluginBundle;
import org.bimserver.database.actions.UpdateQueryEngineDatabaseAction;
import org.bimserver.database.actions.UpdateRenderEngineDatabaseAction;
import org.bimserver.database.actions.UpdateSerializerDatabaseAction;
import org.bimserver.database.actions.UserSettingsSetter;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.Schema;
import org.bimserver.interfaces.objects.*;
import org.bimserver.models.store.*;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.ResourceFetcher;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.StreamingDeserializerPlugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.schemaconverter.SchemaConverterFactory;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.utils.ByteArrayDataSource;
import org.bimserver.utils.NetUtils;
import org.bimserver.webservices.SPluginConfigurationComparator;
import org.bimserver.webservices.ServiceMap;
import org.eclipse.emf.common.util.EList;

public class PluginServiceImpl extends GenericServiceImpl implements PluginInterface {
	public PluginServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public Long addDeserializer(SDeserializerPluginConfiguration deserializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			DeserializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(deserializer, session);
			return session.executeAndCommitAction(new AddDeserializerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateSerializer(SSerializerPluginConfiguration serializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			SerializerPluginConfiguration convert = session.get(serializer.getOid(), OldQuery.getDefault());
			getBimServer().getSConverter().convertFromSObject(serializer, convert, session);
			session.executeAndCommitAction(new UpdateSerializerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateDeserializer(SDeserializerPluginConfiguration deserializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			DeserializerPluginConfiguration convert = session.get(deserializer.getOid(), OldQuery.getDefault());
			getBimServer().getSConverter().convertFromSObject(deserializer, convert, session);
			session.executeAndCommitAction(new UpdateDeserializerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllSerializerPluginDescriptors() throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.SERIALIZER));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllWebModulePluginDescriptors() throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.WEB_MODULE));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteSerializer(Long sid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeleteSerializerDatabaseAction(session, getInternalAccessMethod(), sid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deletePluginConfiguration(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeletePluginConfigurationDatabaseAction(session, getInternalAccessMethod(), oid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteDeserializer(Long sid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeleteDeserializerDatabaseAction(session, getInternalAccessMethod(), sid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SWebModulePluginConfiguration getWebModuleByName(String name) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetWebModuleByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SWebModulePluginConfiguration> listAllWebModules() throws ServerException, UserException {
		requireAtLeastAnonymousAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			List<SWebModulePluginConfiguration> list = getBimServer().getSConverter()
					.convertToSListWebModulePluginConfiguration(session.executeAndCommitAction(new ListWebModulesDatabaseAction(session, getInternalAccessMethod())));
			Collections.sort(list, new Comparator<SWebModulePluginConfiguration>() {
				@Override
				public int compare(SWebModulePluginConfiguration o1, SWebModulePluginConfiguration o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			return list;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			SPluginType type =  SPluginType.DESERIALIZER; // change signature of GetAllPluginDescriptor to use type
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.DESERIALIZER));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllRenderEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.RENDER_ENGINE));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.QUERY_ENGINE));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllServicePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.SERVICE));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.MODEL_COMPARE));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllModelCheckerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.MODEL_CHECKER));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetAllPluginDescriptorsDatabaseAction(session, getInternalAccessMethod(), getBimServer(), SPluginType.MODEL_MERGER));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRenderEnginePluginConfiguration> getAllRenderEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings userSettings = getUserSettings(session);
			List<SRenderEnginePluginConfiguration> renderEngines = getBimServer().getSConverter().convertToSListRenderEnginePluginConfiguration(userSettings.getRenderEngines());
			Collections.sort(renderEngines, new SPluginConfigurationComparator());
			return renderEngines;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SQueryEnginePluginConfiguration> getAllQueryEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings userSettings = getUserSettings(session);
			List<SQueryEnginePluginConfiguration> queryEngines = getBimServer().getSConverter().convertToSListQueryEnginePluginConfiguration(userSettings.getQueryEngines());
			Collections.sort(queryEngines, new SPluginConfigurationComparator());
			return queryEngines;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SModelComparePluginConfiguration> getAllModelCompares(Boolean onlyEnabled) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings userSettings = getUserSettings(session);
			List<SModelComparePluginConfiguration> modelCompares = getBimServer().getSConverter().convertToSListModelComparePluginConfiguration(userSettings.getModelCompares());
			Collections.sort(modelCompares, new SPluginConfigurationComparator());
			return modelCompares;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SModelMergerPluginConfiguration> getAllModelMergers(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings userSettings = getUserSettings(session);
			List<SModelMergerPluginConfiguration> modelMergers = getBimServer().getSConverter().convertToSListModelMergerPluginConfiguration(userSettings.getModelMergers());
			Collections.sort(modelMergers, new SPluginConfigurationComparator());
			return modelMergers;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRenderEngine(SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			RenderEnginePluginConfiguration convert = session.get(renderEngine.getOid(), OldQuery.getDefault());
			getBimServer().getSConverter().convertFromSObject(renderEngine, convert, session);
			session.executeAndCommitAction(new UpdateRenderEngineDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateQueryEngine(SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			QueryEnginePluginConfiguration convert = session.get(queryEngine.getOid(), OldQuery.getDefault());
			getBimServer().getSConverter().convertFromSObject(queryEngine, convert, session);
			session.executeAndCommitAction(new UpdateQueryEngineDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelCompare(SModelComparePluginConfiguration modelCompare) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ModelComparePluginConfiguration convert = session.get(modelCompare.getOid(), OldQuery.getDefault());
			getBimServer().getSConverter().convertFromSObject(modelCompare, convert, session);
			session.executeAndCommitAction(new UpdateModelCompareDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelMerger(SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ModelMergerPluginConfiguration convert = session.get(modelMerger.getOid(), OldQuery.getDefault());
			getBimServer().getSConverter().convertFromSObject(modelMerger, convert, session);
			session.executeAndCommitAction(new UpdateModelMergerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteRenderEngine(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeleteRenderEngineDatabaseAction(session, getInternalAccessMethod(), iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteQueryEngine(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeleteQueryEngineDatabaseAction(session, getInternalAccessMethod(), iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteModelCompare(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeleteModelCompareDatabaseAction(session, getInternalAccessMethod(), iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteModelChecker(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeleteModelCompareDatabaseAction(session, getInternalAccessMethod(), iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteModelMerger(Long iid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeleteModelMergerDatabaseAction(session, getInternalAccessMethod(), iid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRenderEnginePluginConfiguration getRenderEngineByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetRenderEngineByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelMergerPluginConfiguration getModelMergerById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelMergerByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelComparePluginConfiguration getModelCompareById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelCompareByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelComparePluginConfiguration getModelCompareByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelCompareByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelMergerPluginConfiguration getModelMergerByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetModelMergerByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRenderEnginePluginConfiguration getRenderEngineById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetRenderEngineByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long addRenderEngine(SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			RenderEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(renderEngine, session);
			return session.executeAndCommitAction(new AddRenderEngineDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long addQueryEngine(SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			QueryEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(queryEngine, session);
			return session.executeAndCommitAction(new AddQueryEngineDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long addModelCompare(SModelComparePluginConfiguration modelCompare) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ModelComparePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelCompare, session);
			return session.executeAndCommitAction(new AddModelCompareDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long addModelMerger(SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ModelMergerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelMerger, session);
			return session.executeAndCommitAction(new AddModelMergerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SObjectDefinition getPluginObjectDefinition(Long oid) throws ServerException, UserException {
		if (oid == -1) {
			return null;
		}
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			PluginDescriptor pluginDescriptor = session.get(oid, OldQuery.getDefault());
			if (pluginDescriptor == null) {
				throw new UserException("No PluginDescriptor found with oid " + oid);
			}
			Plugin plugin = getBimServer().getPluginManager().getPlugin(pluginDescriptor.getPluginClassName(), false);
			if (plugin == null) {
				throw new UserException("No plugin with class name " + pluginDescriptor.getPluginClassName() + " found");
			}
			ObjectDefinition settingsDefinition = plugin.getUserSettingsDefinition();
			return getBimServer().getSConverter().convertToSObject(settingsDefinition);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public SObjectDefinition getPluginSystemObjectDefinition(Long oid) throws ServerException, UserException {
		if (oid == -1) {
			return null;
		}
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			PluginDescriptor pluginDescriptor = session.get(oid, OldQuery.getDefault());
			if (pluginDescriptor == null) {
				throw new UserException("No PluginDescriptor found with oid " + oid);
			}
			Plugin plugin = getBimServer().getPluginManager().getPlugin(pluginDescriptor.getPluginClassName(), false);
			if (plugin == null) {
				throw new UserException("No plugin with class name " + pluginDescriptor.getPluginClassName() + " found");
			}
			ObjectDefinition settingsDefinition = plugin.getSystemSettingsDefinition();
			return getBimServer().getSConverter().convertToSObject(settingsDefinition);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public void setPluginSettings(Long poid, SObjectType settings) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
			ObjectType convertedSettings = getBimServer().getSConverter().convertFromSObject(settings, session);
			SetPluginSettingsDatabaseAction action = new SetPluginSettingsDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, convertedSettings);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		}

		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
			PluginConfiguration pluginConfiguration = session.get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, OldQuery.getDefault());
			if (pluginConfiguration instanceof InternalServicePluginConfiguration) {
				ServicePlugin servicePlugin = getBimServer().getPluginManager().getServicePlugin(pluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				SInternalServicePluginConfiguration sInternalService = (SInternalServicePluginConfiguration) getBimServer().getSConverter().convertToSObject(pluginConfiguration);

				servicePlugin.unregister(sInternalService);
				servicePlugin.register(getAuthorization().getUoid(), sInternalService, new org.bimserver.plugins.PluginConfiguration(settings));
			}
		} catch (BimserverDatabaseException e) {
			handleException(e);
		}
	}

	@Override
	public void setPluginSystemSettings(Long poid, SObjectType settings) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
			ObjectType convertedSettings = getBimServer().getSConverter().convertFromSObject(settings, session);
			SetPluginSystemSettingsDatabaseAction action = new SetPluginSystemSettingsDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, convertedSettings);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		}

		// TODO maybe also restart some things...
//		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
//			PluginConfiguration pluginConfiguration = session.get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, OldQuery.getDefault());
//			if (pluginConfiguration instanceof InternalServicePluginConfiguration) {
//				ServicePlugin servicePlugin = getBimServer().getPluginManager().getServicePlugin(pluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
//				SInternalServicePluginConfiguration sInternalService = (SInternalServicePluginConfiguration) getBimServer().getSConverter().convertToSObject(pluginConfiguration);
//				
//				servicePlugin.unregister(sInternalService);
//				servicePlugin.register(getAuthorization().getUoid(), sInternalService, new org.bimserver.plugins.PluginConfiguration(settings));
//			}
//		} catch (BimserverDatabaseException e) {
//			handleException(e);
//		}
	}

	@Override
	public List<SSerializerPluginConfiguration> getAllSerializers(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings userSettings = getUserSettings(session);
			List<SSerializerPluginConfiguration> sSerializers = new ArrayList<SSerializerPluginConfiguration>();
			for (SerializerPluginConfiguration serializerPluginConfiguration : userSettings.getSerializers()) {
				if (!onlyEnabled || (serializerPluginConfiguration.getEnabled() && serializerPluginConfiguration.getPluginDescriptor().getEnabled())) {
					sSerializers.add(getBimServer().getSConverter().convertToSObject(serializerPluginConfiguration));
				}
			}
			Collections.sort(sSerializers, new SPluginConfigurationComparator());
			return sSerializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SWebModulePluginConfiguration> getAllWebModules(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			EList<WebModulePluginConfiguration> webModules = getBimServer().getServerSettingsCache().getServerSettings().getWebModules();
			List<SWebModulePluginConfiguration> serializers = getBimServer().getSConverter().convertToSListWebModulePluginConfiguration(webModules);
			Collections.sort(serializers, new SPluginConfigurationComparator());
			return serializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Long addSerializer(SSerializerPluginConfiguration serializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			SerializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(serializer, session);
			return session.executeAndCommitAction(new AddSerializerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SRenderEnginePluginConfiguration getDefaultRenderEngine() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultRenderEngine());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SQueryEnginePluginConfiguration getDefaultQueryEngine() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultQueryEngine());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SModelComparePluginConfiguration getDefaultModelCompare() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultModelCompare());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SModelMergerPluginConfiguration getDefaultModelMerger() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultModelMerger());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SSerializerPluginConfiguration getDefaultSerializer() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultSerializer());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SWebModulePluginConfiguration getDefaultWebModule() throws ServerException, UserException {
		requireRealUserAuthentication();
		WebModulePluginConfiguration defaultWebModule = getBimServer().getServerSettingsCache().getServerSettings().getWebModule();
		return getBimServer().getSConverter().convertToSObject(defaultWebModule);
	}

	public SObjectIDMPluginConfiguration getDefaultObjectIDM() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultObjectIDM());
		} catch (BimserverDatabaseException e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SObjectType getPluginSettings(Long poid) throws ServerException, UserException {
		// TODO possibly use PluginSettingsCache
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			PluginConfiguration pluginConfiguration = session.get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, OldQuery.getDefault());
			ObjectType settings = pluginConfiguration.getSettings();
			return getBimServer().getSConverter().convertToSObject(settings);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SObjectType getPluginSystemSettings(Long poid) throws ServerException, UserException {
		// TODO possibly use PluginSettingsCache
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			PluginDescriptor pluginDescriptor = session.get(StorePackage.eINSTANCE.getPluginDescriptor(), poid, OldQuery.getDefault());
			ObjectType settings = pluginDescriptor.getSettings();
			return getBimServer().getSConverter().convertToSObject(settings);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	public void setDefaultRenderEngine(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultRenderEngine(find(userSettings.getRenderEngines(), oid));
				}
			});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultQueryEngine(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultQueryEngine(find(userSettings.getQueryEngines(), oid));
				}
			});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultWebModule(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			getBimServer().getWebModuleManager().setDefault(oid);
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Override
	public List<SSerializerPluginConfiguration> getAllSerializersForPoids(Boolean onlyEnabled, Set<Long> poids) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Set<Schema> uniqueSchemas = new HashSet<>();
			for (Long poid : poids) {
				Project project = session.get(poid, OldQuery.getDefault());
				uniqueSchemas.add(Schema.valueOf(project.getSchema().toUpperCase()));
			}

			Set<Schema> schemaOr = new HashSet<>();

			if (uniqueSchemas.size() == 0) {
				// Weird, no schemas
			} else if (uniqueSchemas.size() == 1) {
				// Easy, just add it, and see if there are converter targets and
				// add those too
				Schema schema = uniqueSchemas.iterator().next();
				schemaOr.add(schema);
				// TODO make recursive
				for (Schema target : getBimServer().getSchemaConverterManager().getSchemaTargets(schema)) {
					schemaOr.add(target);
				}
			} else if (uniqueSchemas.size() == 2) {
				// This is harder, if we have 2 schema, we must figure out a way
				// to convert to 1 schema, and then filter the allowed source
				// schemas
				Iterator<Schema> iterator = uniqueSchemas.iterator();
				Schema schema1 = iterator.next();
				Schema schema2 = iterator.next();
				SchemaConverterFactory converter1 = getBimServer().getSchemaConverterManager().getSchemaConverterFactory(schema1, schema2);
				SchemaConverterFactory converter2 = getBimServer().getSchemaConverterManager().getSchemaConverterFactory(schema2, schema1);
				if (converter1 != null) {
					schemaOr.add(schema1);
				}
				if (converter2 != null) {
					schemaOr.add(schema2);
				}
			} else {
				throw new ServerException("Unimplemented, no support for > 2 schemas");
			}

			UserSettings userSettings = getUserSettings(session);
			List<SSerializerPluginConfiguration> sSerializers = new ArrayList<SSerializerPluginConfiguration>();
			for (SerializerPluginConfiguration serializerPluginConfiguration : userSettings.getSerializers()) {
				Plugin plugin = getBimServer().getPluginManager().getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				if (plugin instanceof SerializerPlugin) {
					SerializerPlugin serializerPlugin = getBimServer().getPluginManager().getSerializerPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
					for (Schema schema : serializerPlugin.getSupportedSchemas()) {
						if (schemaOr.contains(schema)) {
							if (!onlyEnabled || (serializerPluginConfiguration.getEnabled() && serializerPluginConfiguration.getPluginDescriptor().getEnabled())) {
								sSerializers.add(getBimServer().getSConverter().convertToSObject(serializerPluginConfiguration));
								break;
							}
						}
					}
				} else if (plugin instanceof StreamingSerializerPlugin) {
					StreamingSerializerPlugin streamingSerializerPlugin = (StreamingSerializerPlugin) plugin;
					for (Schema schema : streamingSerializerPlugin.getSupportedSchemas()) {
						if (schemaOr.contains(schema)) {
							if (!onlyEnabled || (serializerPluginConfiguration.getEnabled() && serializerPluginConfiguration.getPluginDescriptor().getEnabled())) {
								sSerializers.add(getBimServer().getSConverter().convertToSObject(serializerPluginConfiguration));
								break;
							}
						}
					}
				}
			}
			Collections.sort(sSerializers, new SPluginConfigurationComparator());
			return sSerializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SSerializerPluginConfiguration> getAllSerializersForRoids(Boolean onlyEnabled, Set<Long> roids) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Set<Long> poids = new HashSet<>();
			for (Long roid : roids) {
				Revision revision = session.get(roid, OldQuery.getDefault());
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					poids.add(concreteRevision.getProject().getOid());
				}
			}
			return getAllSerializersForPoids(onlyEnabled, poids);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	public void setDefaultModelCompare(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultModelCompare(find(userSettings.getModelCompares(), oid));
				}
			});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultModelMerger(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultModelMerger(find(userSettings.getModelMergers(), oid));
				}
			});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	private <T extends IdEObject> T find(List<T> list, long oid) {
		for (T t : list) {
			if (t.getOid() == oid) {
				return t;
			}
		}
		return null;
	}

	public void setDefaultSerializer(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultSerializer(find(userSettings.getSerializers(), oid));
				}
			});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SDeserializerPluginConfiguration> getAllDeserializers(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings userSettings = getUserSettings(session);
			EList<DeserializerPluginConfiguration> deserializers = userSettings.getDeserializers();
			List<SDeserializerPluginConfiguration> sDeserializers = new ArrayList<SDeserializerPluginConfiguration>();
			for (DeserializerPluginConfiguration deserializerPluginConfiguration : deserializers) {
				if (!onlyEnabled || (deserializerPluginConfiguration.getEnabled() && deserializerPluginConfiguration.getPluginDescriptor().getEnabled())) {
					sDeserializers.add(getBimServer().getSConverter().convertToSObject(deserializerPluginConfiguration));
				}
			}
			Collections.sort(sDeserializers, new SPluginConfigurationComparator());
			return sDeserializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SWebModulePluginConfiguration getWebModuleById(Long oid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetWebModuleByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializerPluginConfiguration getSerializerByPluginClassName(String pluginClassName) throws ServerException, UserException {
		// Not checking for real authentication here because a remote service
		// should be able to use a serializer for download call
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter()
					.convertToSObject(session.executeAndCommitAction(new GetSerializerByPluginClassNameDatabaseAction(session, getAuthorization(), getInternalAccessMethod(), pluginClassName)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean hasActiveSerializer(String contentType) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			SSerializerPluginConfiguration serializer = getServiceMap().getServiceInterface().getSerializerByContentType(contentType);
			if (serializer != null) {
				if (serializer.getEnabled()) {
					SPluginDescriptor pluginDescriptor = getServiceMap().getPluginInterface().getPluginDescriptor(serializer.getPluginDescriptorId());
					if (pluginDescriptor.getEnabled()) {
						return getBimServer().getPluginManager().isEnabled(pluginDescriptor.getPluginClassName());
					}
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public SInternalServicePluginConfiguration getInternalServiceById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			InternalServicePluginConfiguration internalPlugin = session.executeAndCommitAction(
					new GetByIdDatabaseAction<InternalServicePluginConfiguration>(session, getInternalAccessMethod(), oid, StorePackage.eINSTANCE.getInternalServicePluginConfiguration()));
			if (internalPlugin == null) {
				throw new UserException("No InternalServicePluginConfiguration found for id " + oid);
			}
			SInternalServicePluginConfiguration convertToSObject = getBimServer().getSConverter().convertToSObject(internalPlugin);
			return convertToSObject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateInternalService(SInternalServicePluginConfiguration internalService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			InternalServicePluginConfiguration convertFromSObject = session.get(internalService.getOid(), OldQuery.getDefault());
			getBimServer().getSConverter().convertFromSObject(internalService, convertFromSObject, session);
			session.executeAndCommitAction(new UpdateDatabaseAction<InternalServicePluginConfiguration>(session, getInternalAccessMethod(), convertFromSObject));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long addInternalService(SInternalServicePluginConfiguration internalService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			return session.executeAndCommitAction(new AddInternalServiceDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(),
					getBimServer().getSConverter().convertFromSObject(internalService, session)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteInternalService(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			session.executeAndCommitAction(new DeleteInternalServiceDatabaseAction(session, getInternalAccessMethod(), oid));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SInternalServicePluginConfiguration> getAllInternalServices(Boolean onlyEnabled) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			UserSettings userSettings = getUserSettings(session);
			EList<InternalServicePluginConfiguration> services2 = userSettings.getServices();
			List<SInternalServicePluginConfiguration> services = getBimServer().getSConverter().convertToSListInternalServicePluginConfiguration(services2);
			Collections.sort(services, new SPluginConfigurationComparator());
			return services;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SPluginDescriptor getPluginDescriptor(Long oid) throws ServerException, UserException {
		if (oid == -1) {
			return null;
		}
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			PluginDescriptor pluginDescriptor = session.get(oid, OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(pluginDescriptor);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SPluginDescriptor getPluginDescriptorByName(String name) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			List<PluginDescriptor> pluginDescriptors = session.getAllOfType(StorePackage.eINSTANCE.getPluginDescriptor(), PluginDescriptor.class, OldQuery.getDefault());
			for (PluginDescriptor pluginDescriptor : pluginDescriptors) {
				if (pluginDescriptor.getName().equals(name)) {
					return getBimServer().getSConverter().convertToSObject(pluginDescriptor);
				}
			}
			return null;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SDeserializerPluginConfiguration> getAllDeserializersForProject(Boolean onlyEnabled, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Project project = session.get(poid, OldQuery.getDefault());

			UserSettings userSettings = getUserSettings(session);
			EList<DeserializerPluginConfiguration> deserializers = userSettings.getDeserializers();
			List<SDeserializerPluginConfiguration> sDeserializers = new ArrayList<SDeserializerPluginConfiguration>();
			for (DeserializerPluginConfiguration deserializerPluginConfiguration : deserializers) {
				DeserializerPlugin plugin = getBimServer().getPluginManager().getDeserializerPlugin(deserializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				if (plugin == null) {
					StreamingDeserializerPlugin streamingPlugin = getBimServer().getPluginManager()
							.getStreamingDeserializerPlugin(deserializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
					if (streamingPlugin != null) {
						if (streamingPlugin.getSupportedSchemas().contains(Schema.valueOf(project.getSchema().toUpperCase()))) {
							if (!onlyEnabled || (deserializerPluginConfiguration.getEnabled() && deserializerPluginConfiguration.getPluginDescriptor().getEnabled())) {
								sDeserializers.add(getBimServer().getSConverter().convertToSObject(deserializerPluginConfiguration));
							}
						}
					}
				} else {
					if (plugin.getSupportedSchemas().contains(Schema.valueOf(project.getSchema().toUpperCase()))) {
						if (!onlyEnabled || (deserializerPluginConfiguration.getEnabled() && deserializerPluginConfiguration.getPluginDescriptor().getEnabled())) {
							sDeserializers.add(getBimServer().getSConverter().convertToSObject(deserializerPluginConfiguration));
						}
					}
				}
			}
			Collections.sort(sDeserializers, new SPluginConfigurationComparator());
			return sDeserializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SPluginBundle> getAvailablePluginBundles() throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(
					new GetAvailablePluginBundles(session, getInternalAccessMethod(), getBimServer(), getBimServer().getServerSettingsCache().getServerSettings().isPluginStrictVersionChecking()));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public void installPluginBundle(String repository, String groupId, String artifactId, String version, List<SPluginInformation> plugins) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			session.executeAndCommitAction(new InstallPluginBundle(session, getInternalAccessMethod(), getBimServer(), repository, groupId, artifactId, version, plugins));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void installPluginBundleFromFile(DataHandler file, Boolean installAllPluginsForAllUsers, Boolean installAllPluginsForNewUsers) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			IOUtils.copy(file.getInputStream(), byteArrayOutputStream);
			session.executeAndCommitAction(new InstallPluginBundleFromBytes(session, getInternalAccessMethod(), getBimServer(), byteArrayOutputStream.toByteArray(), installAllPluginsForAllUsers,
					installAllPluginsForNewUsers));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void installPluginBundleFromUrl(String url, Boolean installAllPluginsForAllUsers, Boolean installAllPluginsForNewUsers) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			byte[] data = NetUtils.getContentAsBytes(new URL(url), 5000);
			session.executeAndCommitAction(new InstallPluginBundleFromBytes(session, getInternalAccessMethod(), getBimServer(), data, installAllPluginsForAllUsers, installAllPluginsForNewUsers));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void updatePluginBundle(String repository, String groupId, String artifactId, String version) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			session.executeAndCommitAction(new UpdatePluginBundle(session, getInternalAccessMethod(), getBimServer(), repository, groupId, artifactId, version));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginBundle> getInstalledPluginBundles() throws UserException, ServerException {
		// TODO make sure the database oid's are also coming in with this
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(
					new GetInstalledPluginBundles(session, getInternalAccessMethod(), getBimServer(), getBimServer().getServerSettingsCache().getServerSettings().isPluginStrictVersionChecking()));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void uninstallPluginBundle(String repository, String groupId, String artifactId, String version) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			session.executeAndCommitAction(new UninstallPluginBundle(session, getInternalAccessMethod(), getBimServer(), repository, groupId, artifactId, version));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SPluginInformation> getPluginInformation(String repository, String groupId, String artifactId, String version) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetPluginInformation(session, getInternalAccessMethod(), getBimServer(), repository, groupId, artifactId, version));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SPluginBundleVersion getInstalledPluginBundle(Long oid) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetInstalledPluginBundle(session, getInternalAccessMethod(), getBimServer(), oid));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SPluginBundle getPluginBundle(String repository, String groupId, String artifactId) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetPluginBundle(session, getInternalAccessMethod(), getBimServer(), repository, groupId, artifactId,
					getBimServer().getServerSettingsCache().getServerSettings().isPluginStrictVersionChecking()));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SPluginBundleVersion getPluginBundleVersionById(Long pbid) throws UserException, ServerException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return session.executeAndCommitAction(new GetPluginBundleVersionById(session, getInternalAccessMethod(), getBimServer(), pbid));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public void clearMavenCache() throws UserException, ServerException {
		try {
			getBimServer().getMavenPluginRepository().clearCache();
		} catch (IOException e) {
			throw new ServerException(e);
		}
	}

	@Override
	public List<SPluginDescriptor> listPluginsInBundle(Long pluginBundleVersionOid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter()
					.convertToSListPluginDescriptor(session.executeAndCommitAction(new ListPluginsInBundle(session, getInternalAccessMethod(), getBimServer(), pluginBundleVersionOid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SInternalServicePluginConfiguration> getAllInternalServicesOfService(String name, Boolean onlyEnabled) throws UserException, ServerException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSListInternalServicePluginConfiguration(
					session.executeAndCommitAction(new GetAllInternalServicesOfService(session, getInternalAccessMethod(), getBimServer(), getCurrentUser(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean hasPreBuiltPlugins() throws UserException {
		return getBimServer().getResourceFetcher().isDirectory("pre");
	}

	@Override
	public void installPreBuiltPlugins(List<String> artifacts) throws UserException {
		Set<String> set = new HashSet<>(artifacts);
		ResourceFetcher resourceFetcher = getBimServer().getResourceFetcher();
		Set<String> listKeys = resourceFetcher.listKeys("pre");
		try {
			for (String filename : listKeys) {
				if (filename.endsWith(".jar")) {
					if (filename.contains("-")) {
						if (set.contains(filename.substring(0, filename.indexOf("-")))) {
							DataHandler dataHandler;
							dataHandler = new DataHandler(new ByteArrayDataSource(filename, resourceFetcher.getData("pre/" + filename)));
							getServiceMap().getPluginInterface().installPluginBundleFromFile(dataHandler, true, true);
						}
					}
				}
			}
		} catch (IOException e) {
			throw new UserException(e);
		} catch (UserException e) {
			throw new UserException(e);
		} catch (ServerException e) {
			throw new UserException(e);
		}
	}

	@Override
	public SPluginDescriptor getDefaultRenderEnginePluginDescriptor() throws ServerException, UserException {
		return getBimServer().getSConverter().convertToSObject(getBimServer().getServerSettingsCache().getServerSettings().getDefaultRenderEnginePlugin());
	}
}