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
import org.bimserver.shared.interfaces.PluginInterface;

public class AsyncPluginInterface {

	private final ExecutorService executorService;
	private final PluginInterface syncService;

	public AsyncPluginInterface(PluginInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface AddDeserializerCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddInternalServiceCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddModelCompareCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddModelMergerCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddQueryEngineCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddRenderEngineCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddSerializerCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface ClearMavenCacheCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteDeserializerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteInternalServiceCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteModelCheckerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteModelCompareCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteModelMergerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeletePluginConfigurationCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteQueryEngineCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteRenderEngineCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteSerializerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface GetAllDeserializerPluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllDeserializersCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllDeserializersForProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllInternalServicesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SInternalServicePluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllInternalServicesOfServiceCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SInternalServicePluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllModelCheckerPluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllModelComparePluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllModelComparesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SModelComparePluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllModelMergerPluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllModelMergersCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SModelMergerPluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllQueryEnginePluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllQueryEnginesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllRenderEnginePluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllRenderEnginesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllSerializerPluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllSerializersCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SSerializerPluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllSerializersForPoidsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SSerializerPluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllSerializersForRoidsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SSerializerPluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAllServicePluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllWebModulePluginDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllWebModulesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SWebModulePluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface GetAvailablePluginBundlesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginBundle> result);
		void error(Throwable e);
	}
	
	public interface GetDefaultModelCompareCallback {
		void success(org.bimserver.interfaces.objects.SModelComparePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetDefaultModelMergerCallback {
		void success(org.bimserver.interfaces.objects.SModelMergerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetDefaultQueryEngineCallback {
		void success(org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetDefaultRenderEngineCallback {
		void success(org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetDefaultRenderEnginePluginDescriptorCallback {
		void success(org.bimserver.interfaces.objects.SPluginDescriptor result);
		void error(Throwable e);
	}
	
	public interface GetDefaultSerializerCallback {
		void success(org.bimserver.interfaces.objects.SSerializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetDefaultWebModuleCallback {
		void success(org.bimserver.interfaces.objects.SWebModulePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetInstalledPluginBundleCallback {
		void success(org.bimserver.interfaces.objects.SPluginBundleVersion result);
		void error(Throwable e);
	}
	
	public interface GetInstalledPluginBundlesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginBundle> result);
		void error(Throwable e);
	}
	
	public interface GetInternalServiceByIdCallback {
		void success(org.bimserver.interfaces.objects.SInternalServicePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetModelCompareByIdCallback {
		void success(org.bimserver.interfaces.objects.SModelComparePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetModelCompareByNameCallback {
		void success(org.bimserver.interfaces.objects.SModelComparePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetModelMergerByIdCallback {
		void success(org.bimserver.interfaces.objects.SModelMergerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetModelMergerByNameCallback {
		void success(org.bimserver.interfaces.objects.SModelMergerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetPluginBundleCallback {
		void success(org.bimserver.interfaces.objects.SPluginBundle result);
		void error(Throwable e);
	}
	
	public interface GetPluginBundleVersionByIdCallback {
		void success(org.bimserver.interfaces.objects.SPluginBundleVersion result);
		void error(Throwable e);
	}
	
	public interface GetPluginDescriptorCallback {
		void success(org.bimserver.interfaces.objects.SPluginDescriptor result);
		void error(Throwable e);
	}
	
	public interface GetPluginDescriptorByNameCallback {
		void success(org.bimserver.interfaces.objects.SPluginDescriptor result);
		void error(Throwable e);
	}
	
	public interface GetPluginInformationCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginInformation> result);
		void error(Throwable e);
	}
	
	public interface GetPluginObjectDefinitionCallback {
		void success(org.bimserver.interfaces.objects.SObjectDefinition result);
		void error(Throwable e);
	}
	
	public interface GetPluginSettingsCallback {
		void success(org.bimserver.interfaces.objects.SObjectType result);
		void error(Throwable e);
	}
	
	public interface GetPluginSystemObjectDefinitionCallback {
		void success(org.bimserver.interfaces.objects.SObjectDefinition result);
		void error(Throwable e);
	}
	
	public interface GetPluginSystemSettingsCallback {
		void success(org.bimserver.interfaces.objects.SObjectType result);
		void error(Throwable e);
	}
	
	public interface GetRenderEngineByIdCallback {
		void success(org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetRenderEngineByNameCallback {
		void success(org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetSerializerByPluginClassNameCallback {
		void success(org.bimserver.interfaces.objects.SSerializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetWebModuleByIdCallback {
		void success(org.bimserver.interfaces.objects.SWebModulePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetWebModuleByNameCallback {
		void success(org.bimserver.interfaces.objects.SWebModulePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface HasActiveSerializerCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface HasPreBuiltPluginsCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface InstallPluginBundleCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface InstallPluginBundleFromFileCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface InstallPluginBundleFromUrlCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface InstallPreBuiltPluginsCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface ListAllWebModulesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SWebModulePluginConfiguration> result);
		void error(Throwable e);
	}
	
	public interface ListPluginsInBundleCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> result);
		void error(Throwable e);
	}
	
	public interface SetDefaultModelCompareCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetDefaultModelMergerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetDefaultQueryEngineCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetDefaultRenderEngineCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetDefaultSerializerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetDefaultWebModuleCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetPluginSettingsCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetPluginSystemSettingsCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UninstallPluginBundleCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateDeserializerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateInternalServiceCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateModelCompareCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateModelMergerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdatePluginBundleCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateQueryEngineCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateRenderEngineCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateSerializerCallback {
		void success();
		void error(Throwable e);
	}
	


	public void addDeserializer(final org.bimserver.interfaces.objects.SDeserializerPluginConfiguration deserializer, final AddDeserializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addDeserializer(deserializer));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addInternalService(final org.bimserver.interfaces.objects.SInternalServicePluginConfiguration internalService, final AddInternalServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addInternalService(internalService));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addModelCompare(final org.bimserver.interfaces.objects.SModelComparePluginConfiguration modelCompare, final AddModelCompareCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addModelCompare(modelCompare));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addModelMerger(final org.bimserver.interfaces.objects.SModelMergerPluginConfiguration modelMerger, final AddModelMergerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addModelMerger(modelMerger));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addQueryEngine(final org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration queryEngine, final AddQueryEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addQueryEngine(queryEngine));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addRenderEngine(final org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration renderEngine, final AddRenderEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addRenderEngine(renderEngine));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addSerializer(final org.bimserver.interfaces.objects.SSerializerPluginConfiguration serializer, final AddSerializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addSerializer(serializer));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void clearMavenCache(final ClearMavenCacheCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.clearMavenCache();
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteDeserializer(final java.lang.Long sid, final DeleteDeserializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteDeserializer(sid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteInternalService(final java.lang.Long oid, final DeleteInternalServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteInternalService(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteModelChecker(final java.lang.Long iid, final DeleteModelCheckerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteModelChecker(iid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteModelCompare(final java.lang.Long iid, final DeleteModelCompareCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteModelCompare(iid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteModelMerger(final java.lang.Long iid, final DeleteModelMergerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteModelMerger(iid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deletePluginConfiguration(final java.lang.Long oid, final DeletePluginConfigurationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deletePluginConfiguration(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteQueryEngine(final java.lang.Long iid, final DeleteQueryEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteQueryEngine(iid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteRenderEngine(final java.lang.Long iid, final DeleteRenderEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteRenderEngine(iid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteSerializer(final java.lang.Long sid, final DeleteSerializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteSerializer(sid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllDeserializerPluginDescriptors(final GetAllDeserializerPluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllDeserializerPluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllDeserializers(final java.lang.Boolean onlyEnabled, final GetAllDeserializersCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllDeserializers(onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllDeserializersForProject(final java.lang.Boolean onlyEnabled, final java.lang.Long poid, final GetAllDeserializersForProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllDeserializersForProject(onlyEnabled, poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllInternalServices(final java.lang.Boolean onlyEnabled, final GetAllInternalServicesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllInternalServices(onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllInternalServicesOfService(final java.lang.String name, final java.lang.Boolean onlyEnabled, final GetAllInternalServicesOfServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllInternalServicesOfService(name, onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllModelCheckerPluginDescriptors(final GetAllModelCheckerPluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllModelCheckerPluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllModelComparePluginDescriptors(final GetAllModelComparePluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllModelComparePluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllModelCompares(final java.lang.Boolean onlyEnabled, final GetAllModelComparesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllModelCompares(onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllModelMergerPluginDescriptors(final GetAllModelMergerPluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllModelMergerPluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllModelMergers(final java.lang.Boolean onlyEnabled, final GetAllModelMergersCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllModelMergers(onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllQueryEnginePluginDescriptors(final GetAllQueryEnginePluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllQueryEnginePluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllQueryEngines(final java.lang.Boolean onlyEnabled, final GetAllQueryEnginesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllQueryEngines(onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllRenderEnginePluginDescriptors(final GetAllRenderEnginePluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllRenderEnginePluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllRenderEngines(final java.lang.Boolean onlyEnabled, final GetAllRenderEnginesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllRenderEngines(onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllSerializerPluginDescriptors(final GetAllSerializerPluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllSerializerPluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllSerializers(final java.lang.Boolean onlyEnabled, final GetAllSerializersCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllSerializers(onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllSerializersForPoids(final java.lang.Boolean onlyEnabled, final java.util.Set<java.lang.Long> poids, final GetAllSerializersForPoidsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllSerializersForPoids(onlyEnabled, poids));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllSerializersForRoids(final java.lang.Boolean onlyEnabled, final java.util.Set<java.lang.Long> roids, final GetAllSerializersForRoidsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllSerializersForRoids(onlyEnabled, roids));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllServicePluginDescriptors(final GetAllServicePluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllServicePluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllWebModulePluginDescriptors(final GetAllWebModulePluginDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllWebModulePluginDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllWebModules(final java.lang.Boolean onlyEnabled, final GetAllWebModulesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllWebModules(onlyEnabled));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAvailablePluginBundles(final GetAvailablePluginBundlesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAvailablePluginBundles());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDefaultModelCompare(final GetDefaultModelCompareCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDefaultModelCompare());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDefaultModelMerger(final GetDefaultModelMergerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDefaultModelMerger());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDefaultQueryEngine(final GetDefaultQueryEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDefaultQueryEngine());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDefaultRenderEngine(final GetDefaultRenderEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDefaultRenderEngine());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDefaultRenderEnginePluginDescriptor(final GetDefaultRenderEnginePluginDescriptorCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDefaultRenderEnginePluginDescriptor());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDefaultSerializer(final GetDefaultSerializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDefaultSerializer());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDefaultWebModule(final GetDefaultWebModuleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDefaultWebModule());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getInstalledPluginBundle(final java.lang.Long oid, final GetInstalledPluginBundleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getInstalledPluginBundle(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getInstalledPluginBundles(final GetInstalledPluginBundlesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getInstalledPluginBundles());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getInternalServiceById(final java.lang.Long oid, final GetInternalServiceByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getInternalServiceById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelCompareById(final java.lang.Long oid, final GetModelCompareByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelCompareById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelCompareByName(final java.lang.String name, final GetModelCompareByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelCompareByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelMergerById(final java.lang.Long oid, final GetModelMergerByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelMergerById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelMergerByName(final java.lang.String name, final GetModelMergerByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelMergerByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginBundle(final java.lang.String repository, final java.lang.String groupId, final java.lang.String artifactId, final GetPluginBundleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginBundle(repository, groupId, artifactId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginBundleVersionById(final java.lang.Long pbid, final GetPluginBundleVersionByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginBundleVersionById(pbid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginDescriptor(final java.lang.Long oid, final GetPluginDescriptorCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginDescriptor(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginDescriptorByName(final java.lang.String name, final GetPluginDescriptorByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginDescriptorByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginInformation(final java.lang.String repository, final java.lang.String groupId, final java.lang.String artifactId, final java.lang.String version, final GetPluginInformationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginInformation(repository, groupId, artifactId, version));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginObjectDefinition(final java.lang.Long oid, final GetPluginObjectDefinitionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginObjectDefinition(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginSettings(final java.lang.Long poid, final GetPluginSettingsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginSettings(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginSystemObjectDefinition(final java.lang.Long oid, final GetPluginSystemObjectDefinitionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginSystemObjectDefinition(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPluginSystemSettings(final java.lang.Long poid, final GetPluginSystemSettingsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPluginSystemSettings(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getRenderEngineById(final java.lang.Long oid, final GetRenderEngineByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getRenderEngineById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getRenderEngineByName(final java.lang.String name, final GetRenderEngineByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getRenderEngineByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSerializerByPluginClassName(final java.lang.String pluginClassName, final GetSerializerByPluginClassNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSerializerByPluginClassName(pluginClassName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getWebModuleById(final java.lang.Long oid, final GetWebModuleByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getWebModuleById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getWebModuleByName(final java.lang.String name, final GetWebModuleByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getWebModuleByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void hasActiveSerializer(final java.lang.String contentType, final HasActiveSerializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.hasActiveSerializer(contentType));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void hasPreBuiltPlugins(final HasPreBuiltPluginsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.hasPreBuiltPlugins());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void installPluginBundle(final java.lang.String repository, final java.lang.String groupId, final java.lang.String artifactId, final java.lang.String version, final java.util.List<org.bimserver.interfaces.objects.SPluginInformation> plugins, final InstallPluginBundleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.installPluginBundle(repository, groupId, artifactId, version, plugins);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void installPluginBundleFromFile(final javax.activation.DataHandler data, final java.lang.Boolean installAllPluginsForAllUsers, final java.lang.Boolean installAllPluginsForNewUsers, final InstallPluginBundleFromFileCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.installPluginBundleFromFile(data, installAllPluginsForAllUsers, installAllPluginsForNewUsers);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void installPluginBundleFromUrl(final java.lang.String url, final java.lang.Boolean installAllPluginsForAllUsers, final java.lang.Boolean installAllPluginsForNewUsers, final InstallPluginBundleFromUrlCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.installPluginBundleFromUrl(url, installAllPluginsForAllUsers, installAllPluginsForNewUsers);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void installPreBuiltPlugins(final java.util.List<java.lang.String> artifacts, final InstallPreBuiltPluginsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.installPreBuiltPlugins(artifacts);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void listAllWebModules(final ListAllWebModulesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listAllWebModules());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void listPluginsInBundle(final java.lang.Long pluginBundleVersionOid, final ListPluginsInBundleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listPluginsInBundle(pluginBundleVersionOid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDefaultModelCompare(final java.lang.Long oid, final SetDefaultModelCompareCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDefaultModelCompare(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDefaultModelMerger(final java.lang.Long oid, final SetDefaultModelMergerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDefaultModelMerger(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDefaultQueryEngine(final java.lang.Long oid, final SetDefaultQueryEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDefaultQueryEngine(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDefaultRenderEngine(final java.lang.Long oid, final SetDefaultRenderEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDefaultRenderEngine(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDefaultSerializer(final java.lang.Long oid, final SetDefaultSerializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDefaultSerializer(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDefaultWebModule(final java.lang.Long oid, final SetDefaultWebModuleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDefaultWebModule(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setPluginSettings(final java.lang.Long poid, final org.bimserver.interfaces.objects.SObjectType settings, final SetPluginSettingsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setPluginSettings(poid, settings);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setPluginSystemSettings(final java.lang.Long poid, final org.bimserver.interfaces.objects.SObjectType settings, final SetPluginSystemSettingsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setPluginSystemSettings(poid, settings);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void uninstallPluginBundle(final java.lang.String repository, final java.lang.String groupId, final java.lang.String artifactId, final java.lang.String version, final UninstallPluginBundleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.uninstallPluginBundle(repository, groupId, artifactId, version);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateDeserializer(final org.bimserver.interfaces.objects.SDeserializerPluginConfiguration deserializer, final UpdateDeserializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateDeserializer(deserializer);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateInternalService(final org.bimserver.interfaces.objects.SInternalServicePluginConfiguration internalService, final UpdateInternalServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateInternalService(internalService);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateModelCompare(final org.bimserver.interfaces.objects.SModelComparePluginConfiguration modelCompare, final UpdateModelCompareCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateModelCompare(modelCompare);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateModelMerger(final org.bimserver.interfaces.objects.SModelMergerPluginConfiguration modelMerger, final UpdateModelMergerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateModelMerger(modelMerger);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updatePluginBundle(final java.lang.String repository, final java.lang.String groupId, final java.lang.String artifactId, final java.lang.String version, final UpdatePluginBundleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updatePluginBundle(repository, groupId, artifactId, version);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateQueryEngine(final org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration queryEngine, final UpdateQueryEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateQueryEngine(queryEngine);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateRenderEngine(final org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration renderEngine, final UpdateRenderEngineCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateRenderEngine(renderEngine);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateSerializer(final org.bimserver.interfaces.objects.SSerializerPluginConfiguration serializer, final UpdateSerializerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateSerializer(serializer);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}