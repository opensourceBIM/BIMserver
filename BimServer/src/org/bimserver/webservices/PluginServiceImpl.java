package org.bimserver.webservices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.actions.AddDeserializerDatabaseAction;
import org.bimserver.database.actions.AddInternalServiceDatabaseAction;
import org.bimserver.database.actions.AddModelCompareDatabaseAction;
import org.bimserver.database.actions.AddModelMergerDatabaseAction;
import org.bimserver.database.actions.AddObjectIDMDatabaseAction;
import org.bimserver.database.actions.AddQueryEngineDatabaseAction;
import org.bimserver.database.actions.AddRenderEngineDatabaseAction;
import org.bimserver.database.actions.AddSerializerDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DeleteDeserializerDatabaseAction;
import org.bimserver.database.actions.DeleteInternalServiceDatabaseAction;
import org.bimserver.database.actions.DeleteModelCompareDatabaseAction;
import org.bimserver.database.actions.DeleteModelMergerDatabaseAction;
import org.bimserver.database.actions.DeleteObjectIDMDatabaseAction;
import org.bimserver.database.actions.DeleteQueryEngineDatabaseAction;
import org.bimserver.database.actions.DeleteRenderEngineDatabaseAction;
import org.bimserver.database.actions.DeleteSerializerDatabaseAction;
import org.bimserver.database.actions.GetByIdDatabaseAction;
import org.bimserver.database.actions.GetDeserializerByIdDatabaseAction;
import org.bimserver.database.actions.GetDeserializerByNameDatabaseAction;
import org.bimserver.database.actions.GetModelCompareByIdDatabaseAction;
import org.bimserver.database.actions.GetModelCompareByNameDatabaseAction;
import org.bimserver.database.actions.GetModelMergerByIdDatabaseAction;
import org.bimserver.database.actions.GetModelMergerByNameDatabaseAction;
import org.bimserver.database.actions.GetObjectIDMByIdDatabaseAction;
import org.bimserver.database.actions.GetObjectIDMByNameDatabaseAction;
import org.bimserver.database.actions.GetQueryEngineByIdDatabaseAction;
import org.bimserver.database.actions.GetQueryEngineByNameDatabaseAction;
import org.bimserver.database.actions.GetRenderEngineByIdDatabaseAction;
import org.bimserver.database.actions.GetRenderEngineByNameDatabaseAction;
import org.bimserver.database.actions.GetSerializerByContentTypeDatabaseAction;
import org.bimserver.database.actions.GetSerializerByIdDatabaseAction;
import org.bimserver.database.actions.GetSerializerByNameDatabaseAction;
import org.bimserver.database.actions.GetSerializerByPluginClassNameDatabaseAction;
import org.bimserver.database.actions.SetPluginSettingsDatabaseAction;
import org.bimserver.database.actions.SetUserSettingDatabaseAction;
import org.bimserver.database.actions.UpdateDatabaseAction;
import org.bimserver.database.actions.UpdateDeserializerDatabaseAction;
import org.bimserver.database.actions.UpdateModelCompareDatabaseAction;
import org.bimserver.database.actions.UpdateModelMergerDatabaseAction;
import org.bimserver.database.actions.UpdateObjectIDMDatabaseAction;
import org.bimserver.database.actions.UpdateQueryEngineDatabaseAction;
import org.bimserver.database.actions.UpdateRenderEngineDatabaseAction;
import org.bimserver.database.actions.UpdateSerializerDatabaseAction;
import org.bimserver.database.actions.UserSettingsSetter;
import org.bimserver.emf.IdEObject;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDeserializerPluginDescriptor;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginDescriptor;
import org.bimserver.interfaces.objects.SModelMergerPluginConfiguration;
import org.bimserver.interfaces.objects.SModelMergerPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectDefinition;
import org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRenderEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SServicePluginDescriptor;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ModelComparePluginConfiguration;
import org.bimserver.models.store.ModelMergerPluginConfiguration;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.QueryEnginePluginConfiguration;
import org.bimserver.models.store.RenderEnginePluginConfiguration;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.PluginInterface;
import org.eclipse.emf.common.util.EList;

public class PluginServiceImpl extends GenericServiceImpl implements PluginInterface {
	public PluginServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public void addDeserializer(SDeserializerPluginConfiguration deserializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			DeserializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new AddDeserializerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateSerializer(SSerializerPluginConfiguration serializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SerializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(serializer, session);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			DeserializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(deserializer, session);
			session.executeAndCommitAction(new UpdateDeserializerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SObjectIDMPluginConfiguration> getAllObjectIDMs(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SObjectIDMPluginConfiguration> objectIdms = getBimServer().getSConverter().convertToSListObjectIDMPluginConfiguration(getUserSettings(session).getObjectIDMs());
			Collections.sort(objectIdms, new SPluginConfigurationComparator());
			return objectIdms;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public void addObjectIDM(SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			session.executeAndCommitAction(new AddObjectIDMDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), getBimServer().getSConverter().convertFromSObject(objectIDM, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateObjectIDM(SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			session.executeAndCommitAction(new UpdateObjectIDMDatabaseAction(session, getInternalAccessMethod(), getBimServer().getSConverter().convertFromSObject(objectIDM, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
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
	public SObjectIDMPluginConfiguration getObjectIDMById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetObjectIDMByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllSerializerPluginDescriptors();
	}

	@Override
	public void deleteObjectIDM(Long ifid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			BimDatabaseAction<Void> action = new DeleteObjectIDMDatabaseAction(session, getInternalAccessMethod(), ifid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteSerializer(Long sid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
	public void deleteDeserializer(Long sid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
	public SObjectIDMPluginConfiguration getObjectIDMByName(String ObjectIDMName) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetObjectIDMByNameDatabaseAction(session, getInternalAccessMethod(), ObjectIDMName)));
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
	public List<SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		List<SDeserializerPluginDescriptor> descriptors = new ArrayList<SDeserializerPluginDescriptor>();
		for (DeserializerPlugin deserializerPlugin : getBimServer().getPluginManager().getAllDeserializerPlugins(true)) {
			SDeserializerPluginDescriptor descriptor = new SDeserializerPluginDescriptor();
			descriptor.setDefaultName(deserializerPlugin.getDefaultName());
			descriptor.setPluginClassName(deserializerPlugin.getClass().getName());
			descriptors.add(descriptor);
		}
		return descriptors;
	}
	
	@Override
	public List<SRenderEnginePluginDescriptor> getAllRenderEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllRenderEnginePluginDescriptors();
	}

	@Override
	public List<SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllQueryEnginePluginDescriptors();
	}

	@Override
	public List<SServicePluginDescriptor> getAllServicePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllServicePluginDescriptors();
	}

	@Override
	public List<SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllModelComparePluginDescriptors();
	}

	@Override
	public List<SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getAllModelMergerPluginDescriptors();
	}

	@Override
	public List<SRenderEnginePluginConfiguration> getAllRenderEngines(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SRenderEnginePluginConfiguration> renderEngines = getBimServer().getSConverter().convertToSListRenderEnginePluginConfiguration(getUserSettings(session).getRenderEngines());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SQueryEnginePluginConfiguration> queryEngines = getBimServer().getSConverter().convertToSListQueryEnginePluginConfiguration(getUserSettings(session).getQueryengines());
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
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SModelComparePluginConfiguration> modelCompares = getBimServer().getSConverter().convertToSListModelComparePluginConfiguration(getUserSettings(session).getModelcompares());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SModelMergerPluginConfiguration> modelMergers = getBimServer().getSConverter().convertToSListModelMergerPluginConfiguration(getUserSettings(session).getModelmergers());
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			RenderEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(renderEngine, session);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			QueryEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(queryEngine, session);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelComparePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelCompare, session);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelMergerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelMerger, session);
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetRenderEngineByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
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
	public SModelMergerPluginConfiguration getModelMergerById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetRenderEngineByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
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
	public void addRenderEngine(SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			RenderEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(renderEngine, session);
			session.executeAndCommitAction(new AddRenderEngineDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addQueryEngine(SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			QueryEnginePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(queryEngine, session);
			session.executeAndCommitAction(new AddQueryEngineDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelCompare(SModelComparePluginConfiguration modelCompare) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelComparePluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelCompare, session);
			session.executeAndCommitAction(new AddModelCompareDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelMerger(SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ModelMergerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(modelMerger, session);
			session.executeAndCommitAction(new AddModelMergerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public SObjectDefinition getPluginObjectDefinition(String className) throws ServerException, UserException {
		return getBimServer().getSConverter().convertToSObject(getBimServer().getPluginManager().getPlugin(className, false).getSettingsDefinition());
	}
	
	@Override
	public void setPluginSettings(Long poid, SObjectType settings) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			ObjectType convertedSettings = getBimServer().getSConverter().convertFromSObject(settings, session);
			SetPluginSettingsDatabaseAction action = new SetPluginSettingsDatabaseAction(session, getInternalAccessMethod(), poid, convertedSettings);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SSerializerPluginConfiguration> getAllSerializers(Boolean onlyEnabled) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SSerializerPluginConfiguration> serializers = getBimServer().getSConverter().convertToSListSerializerPluginConfiguration(getUserSettings(session).getSerializers());
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
	public void addSerializer(SSerializerPluginConfiguration serializer) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SerializerPluginConfiguration convert = getBimServer().getSConverter().convertFromSObject(serializer, session);
			session.executeAndCommitAction(new AddSerializerDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}
	
	public SRenderEnginePluginConfiguration getDefaultRenderEngine() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			UserSettings settings = getUserSettings(session);
			return getBimServer().getSConverter().convertToSObject(settings.getDefaultSerializer());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SObjectIDMPluginConfiguration getDefaultObjectIDM() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			PluginConfiguration pluginConfiguration = session.get(StorePackage.eINSTANCE.getPluginConfiguration(), poid, Query.getDefault());
			ObjectType settings = pluginConfiguration.getSettings();
			return getBimServer().getSConverter().convertToSObject(settings);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	public void setDefaultRenderEngine(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultRenderEngine(find(userSettings.getRenderEngines(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultQueryEngine(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultQueryEngine(find(userSettings.getQueryengines(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultModelCompare(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultModelCompare(find(userSettings.getModelcompares(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultModelMerger(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultModelMerger(find(userSettings.getModelmergers(), oid));
				}});
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultSerializer(find(userSettings.getSerializers(), oid));
				}});
			session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	public void setDefaultObjectIDM(final Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SetUserSettingDatabaseAction action = new SetUserSettingDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), new UserSettingsSetter() {
				@Override
				public void set(UserSettings userSettings) {
					userSettings.setDefaultObjectIDM(find(userSettings.getObjectIDMs(), oid));
				}});
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<SDeserializerPluginConfiguration> deserializers = getBimServer().getSConverter().convertToSListDeserializerPluginConfiguration(getUserSettings(session).getDeserializers());
			Collections.sort(deserializers, new SPluginConfigurationComparator());
			return deserializers;
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
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
	public SSerializerPluginConfiguration getSerializerByPluginClassName(String pluginClassName) throws ServerException, UserException {
		// Not checking for real authentication here because a remote service should be able to use a serializer for download call
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByPluginClassNameDatabaseAction(session, getInternalAccessMethod(), pluginClassName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}
	
	@Override
	public Boolean hasActiveSerializer(String contentType) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			SSerializerPluginConfiguration serializer = getSerializerByContentType(contentType);
			if (serializer != null) {
				if (serializer.getEnabled()) {
					return getBimServer().getPluginManager().isEnabled(serializer.getClassName());
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public SSerializerPluginDescriptor getSerializerPluginDescriptor(String type) throws UserException {
		requireRealUserAuthentication();
		return getBimServer().getSerializerFactory().getSerializerPluginDescriptor(type);
	}
	

	@Override
	public SInternalServicePluginConfiguration getInternalServiceById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			SInternalServicePluginConfiguration convertToSObject = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetByIdDatabaseAction<InternalServicePluginConfiguration>(session, getInternalAccessMethod(), oid, StorePackage.eINSTANCE.getInternalServicePluginConfiguration())));
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			InternalServicePluginConfiguration convertFromSObject = getBimServer().getSConverter().convertFromSObject(internalService, session);
			session.executeAndCommitAction(new UpdateDatabaseAction<InternalServicePluginConfiguration>(session, getInternalAccessMethod(), convertFromSObject));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addInternalService(SInternalServicePluginConfiguration internalService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			session.executeAndCommitAction(new AddInternalServiceDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), getBimServer().getSConverter().convertFromSObject(internalService, session)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteInternalService(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
		DatabaseSession session = getBimServer().getDatabase().createSession();
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
}