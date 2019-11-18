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
import org.bimserver.shared.interfaces.ServiceInterface;

public class AsyncServiceInterface {

	private final ExecutorService executorService;
	private final ServiceInterface syncService;

	public AsyncServiceInterface(ServiceInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface AddExtendedDataSchemaCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddExtendedDataToProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddExtendedDataToRevisionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddLocalServiceToProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddModelCheckerCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddModelCheckerToProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddNewServiceToProjectCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddProjectCallback {
		void success(org.bimserver.interfaces.objects.SProject result);
		void error(Throwable e);
	}
	
	public interface AddProjectAsSubProjectCallback {
		void success(org.bimserver.interfaces.objects.SProject result);
		void error(Throwable e);
	}
	
	public interface AddServiceToProjectCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface AddUserCallback {
		void success(org.bimserver.interfaces.objects.SUser result);
		void error(Throwable e);
	}
	
	public interface AddUserToExtendedDataSchemaCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddUserToProjectCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface AddUserWithPasswordCallback {
		void success(org.bimserver.interfaces.objects.SUser result);
		void error(Throwable e);
	}
	
	public interface BcfToJsonCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface BranchToExistingProjectCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface BranchToNewProjectCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface ChangeUserTypeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface CheckInternetConnectionCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface CheckinAsyncCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CheckinFromUrlAsyncCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CheckinFromUrlSyncCallback {
		void success(org.bimserver.interfaces.objects.SLongCheckinActionState result);
		void error(Throwable e);
	}
	
	public interface CheckinInitiatedAsyncCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CheckinInitiatedSyncCallback {
		void success(org.bimserver.interfaces.objects.SLongCheckinActionState result);
		void error(Throwable e);
	}
	
	public interface CheckinSyncCallback {
		void success(org.bimserver.interfaces.objects.SLongCheckinActionState result);
		void error(Throwable e);
	}
	
	public interface CheckoutCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CleanupLongActionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface CloneCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CompareCallback {
		void success(org.bimserver.interfaces.objects.SCompareResult result);
		void error(Throwable e);
	}
	
	public interface DeleteProjectCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface DeleteServiceCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface DeleteUserCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface DetermineIfcVersionCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface DownloadCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface DownloadCompareResultsCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetAllAuthorizedUsersOfProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SUser> result);
		void error(Throwable e);
	}
	
	public interface GetAllCheckoutsByUserCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SCheckout> result);
		void error(Throwable e);
	}
	
	public interface GetAllCheckoutsOfProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SCheckout> result);
		void error(Throwable e);
	}
	
	public interface GetAllCheckoutsOfProjectAndSubProjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SCheckout> result);
		void error(Throwable e);
	}
	
	public interface GetAllCheckoutsOfRevisionCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SCheckout> result);
		void error(Throwable e);
	}
	
	public interface GetAllExtendedDataOfRevisionCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SExtendedData> result);
		void error(Throwable e);
	}
	
	public interface GetAllExtendedDataOfRevisionAndSchemaCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SExtendedData> result);
		void error(Throwable e);
	}
	
	public interface GetAllExtendedDataSchemasCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SExtendedDataSchema> result);
		void error(Throwable e);
	}
	
	public interface GetAllLocalProfilesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllLocalServiceDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SServiceDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllModelCheckersCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SModelCheckerInstance> result);
		void error(Throwable e);
	}
	
	public interface GetAllModelCheckersOfProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SModelCheckerInstance> result);
		void error(Throwable e);
	}
	
	public interface GetAllNewServicesOfProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SNewService> result);
		void error(Throwable e);
	}
	
	public interface GetAllNonAuthorizedProjectsOfUserCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProject> result);
		void error(Throwable e);
	}
	
	public interface GetAllNonAuthorizedUsersOfProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SUser> result);
		void error(Throwable e);
	}
	
	public interface GetAllPrivateProfilesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllProjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProject> result);
		void error(Throwable e);
	}
	
	public interface GetAllProjectsSmallCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProjectSmall> result);
		void error(Throwable e);
	}
	
	public interface GetAllPublicProfilesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllReadableProjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProject> result);
		void error(Throwable e);
	}
	
	public interface GetAllRelatedProjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProjectSmall> result);
		void error(Throwable e);
	}
	
	public interface GetAllRepositoryExtendedDataSchemasCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SExtendedDataSchema> result);
		void error(Throwable e);
	}
	
	public interface GetAllRepositoryModelCheckersCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SModelCheckerInstance> result);
		void error(Throwable e);
	}
	
	public interface GetAllRevisionsByUserCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SRevision> result);
		void error(Throwable e);
	}
	
	public interface GetAllRevisionsOfProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SRevision> result);
		void error(Throwable e);
	}
	
	public interface GetAllServiceDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SServiceDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetAllServicesOfProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SService> result);
		void error(Throwable e);
	}
	
	public interface GetAllUsersCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SUser> result);
		void error(Throwable e);
	}
	
	public interface GetAllWritableProjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProject> result);
		void error(Throwable e);
	}
	
	public interface GetAreaCallback {
		void success(java.lang.Double result);
		void error(Throwable e);
	}
	
	public interface GetAvailableClassesCallback {
		void success(java.util.List<java.lang.String> result);
		void error(Throwable e);
	}
	
	public interface GetAvailableClassesInRevisionCallback {
		void success(java.util.List<java.lang.String> result);
		void error(Throwable e);
	}
	
	public interface GetCheckinWarningsCallback {
		void success(java.util.Set<java.lang.String> result);
		void error(Throwable e);
	}
	
	public interface GetCheckoutWarningsCallback {
		void success(java.util.Set<java.lang.String> result);
		void error(Throwable e);
	}
	
	public interface GetDensityThresholdCallback {
		void success(org.bimserver.interfaces.objects.SDensity result);
		void error(Throwable e);
	}
	
	public interface GetDeserializerByIdCallback {
		void success(org.bimserver.interfaces.objects.SDeserializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetDeserializerByNameCallback {
		void success(org.bimserver.interfaces.objects.SDeserializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetDownloadDataCallback {
		void success(org.bimserver.interfaces.objects.SDownloadResult result);
		void error(Throwable e);
	}
	
	public interface GetExtendedDataCallback {
		void success(org.bimserver.interfaces.objects.SExtendedData result);
		void error(Throwable e);
	}
	
	public interface GetExtendedDataSchemaByIdCallback {
		void success(org.bimserver.interfaces.objects.SExtendedDataSchema result);
		void error(Throwable e);
	}
	
	public interface GetExtendedDataSchemaByNameCallback {
		void success(org.bimserver.interfaces.objects.SExtendedDataSchema result);
		void error(Throwable e);
	}
	
	public interface GetExtendedDataSchemaFromRepositoryCallback {
		void success(org.bimserver.interfaces.objects.SExtendedDataSchema result);
		void error(Throwable e);
	}
	
	public interface GetFileCallback {
		void success(org.bimserver.interfaces.objects.SFile result);
		void error(Throwable e);
	}
	
	public interface GetFileMetaCallback {
		void success(org.bimserver.interfaces.objects.SFile result);
		void error(Throwable e);
	}
	
	public interface GetGeoTagCallback {
		void success(org.bimserver.interfaces.objects.SGeoTag result);
		void error(Throwable e);
	}
	
	public interface GetGeometryDataToReuseCallback {
		void success(java.util.Set<java.lang.Long> result);
		void error(Throwable e);
	}
	
	public interface GetGeometryInfoCallback {
		void success(org.bimserver.interfaces.objects.SGeometryInfo result);
		void error(Throwable e);
	}
	
	public interface GetIfcHeaderCallback {
		void success(org.bimserver.interfaces.objects.SIfcHeader result);
		void error(Throwable e);
	}
	
	public interface GetLastExtendedDataOfRevisionAndSchemaCallback {
		void success(org.bimserver.interfaces.objects.SExtendedData result);
		void error(Throwable e);
	}
	
	public interface GetModelBoundsCallback {
		void success(org.bimserver.interfaces.objects.SBounds result);
		void error(Throwable e);
	}
	
	public interface GetModelBoundsForConcreteRevisionCallback {
		void success(org.bimserver.interfaces.objects.SBounds result);
		void error(Throwable e);
	}
	
	public interface GetModelBoundsUntransformedCallback {
		void success(org.bimserver.interfaces.objects.SBounds result);
		void error(Throwable e);
	}
	
	public interface GetModelBoundsUntransformedForConcreteRevisionCallback {
		void success(org.bimserver.interfaces.objects.SBounds result);
		void error(Throwable e);
	}
	
	public interface GetModelCheckerInstanceCallback {
		void success(org.bimserver.interfaces.objects.SModelCheckerInstance result);
		void error(Throwable e);
	}
	
	public interface GetModelMaxBoundsCallback {
		void success(org.bimserver.interfaces.objects.SVector3f result);
		void error(Throwable e);
	}
	
	public interface GetModelMinBoundsCallback {
		void success(org.bimserver.interfaces.objects.SVector3f result);
		void error(Throwable e);
	}
	
	public interface GetNewServiceCallback {
		void success(org.bimserver.interfaces.objects.SNewService result);
		void error(Throwable e);
	}
	
	public interface GetNrPrimitivesCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetNrPrimitivesTotalCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetOidByGuidCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetProjectByPoidCallback {
		void success(org.bimserver.interfaces.objects.SProject result);
		void error(Throwable e);
	}
	
	public interface GetProjectByUuidCallback {
		void success(org.bimserver.interfaces.objects.SProject result);
		void error(Throwable e);
	}
	
	public interface GetProjectSmallByPoidCallback {
		void success(org.bimserver.interfaces.objects.SProjectSmall result);
		void error(Throwable e);
	}
	
	public interface GetProjectsByNameCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProject> result);
		void error(Throwable e);
	}
	
	public interface GetQueryEngineByIdCallback {
		void success(org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetQueryEngineByNameCallback {
		void success(org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetQueryEngineExampleCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetQueryEngineExampleKeysCallback {
		void success(java.util.List<java.lang.String> result);
		void error(Throwable e);
	}
	
	public interface GetRevisionCallback {
		void success(org.bimserver.interfaces.objects.SRevision result);
		void error(Throwable e);
	}
	
	public interface GetRevisionSummaryCallback {
		void success(org.bimserver.interfaces.objects.SRevisionSummary result);
		void error(Throwable e);
	}
	
	public interface GetSerializerByContentTypeCallback {
		void success(org.bimserver.interfaces.objects.SSerializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetSerializerByIdCallback {
		void success(org.bimserver.interfaces.objects.SSerializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetSerializerByNameCallback {
		void success(org.bimserver.interfaces.objects.SSerializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetServiceCallback {
		void success(org.bimserver.interfaces.objects.SService result);
		void error(Throwable e);
	}
	
	public interface GetServiceDescriptorCallback {
		void success(org.bimserver.interfaces.objects.SServiceDescriptor result);
		void error(Throwable e);
	}
	
	public interface GetSubProjectByNameCallback {
		void success(org.bimserver.interfaces.objects.SProject result);
		void error(Throwable e);
	}
	
	public interface GetSubProjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProject> result);
		void error(Throwable e);
	}
	
	public interface GetSuggestedDeserializerForExtensionCallback {
		void success(org.bimserver.interfaces.objects.SDeserializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface GetTileCountsCallback {
		void success(java.util.List<java.lang.Number> result);
		void error(Throwable e);
	}
	
	public interface GetTilesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.STile> result);
		void error(Throwable e);
	}
	
	public interface GetTopLevelProjectByNameCallback {
		void success(org.bimserver.interfaces.objects.SProject result);
		void error(Throwable e);
	}
	
	public interface GetTotalBoundsCallback {
		void success(org.bimserver.interfaces.objects.SBounds result);
		void error(Throwable e);
	}
	
	public interface GetTotalUntransformedBoundsCallback {
		void success(org.bimserver.interfaces.objects.SBounds result);
		void error(Throwable e);
	}
	
	public interface GetUserByUoidCallback {
		void success(org.bimserver.interfaces.objects.SUser result);
		void error(Throwable e);
	}
	
	public interface GetUserByUserNameCallback {
		void success(org.bimserver.interfaces.objects.SUser result);
		void error(Throwable e);
	}
	
	public interface GetUserRelatedLogsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SLogAction> result);
		void error(Throwable e);
	}
	
	public interface GetUserSettingsCallback {
		void success(org.bimserver.interfaces.objects.SUserSettings result);
		void error(Throwable e);
	}
	
	public interface GetUsersProjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProject> result);
		void error(Throwable e);
	}
	
	public interface GetVolumeCallback {
		void success(java.lang.Double result);
		void error(Throwable e);
	}
	
	public interface ImportDataCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface InitiateCheckinCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface ListBoundingBoxesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SBounds> result);
		void error(Throwable e);
	}
	
	public interface RegenerateGeometryCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface RemoveModelCheckerFromProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RemoveNewServiceFromProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RemoveServiceFromProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RemoveUserFromExtendedDataSchemaCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RemoveUserFromProjectCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface SendCompareEmailCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetRevisionTagCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface ShareRevisionCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface TerminateLongRunningActionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface TriggerNewExtendedDataCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface TriggerNewRevisionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface TriggerRevisionServiceCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UndeleteProjectCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface UndeleteUserCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface UpdateGeoTagCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateModelCheckerCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UpdateRevisionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UploadFileCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface UserHasCheckinRightsCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface UserHasRightsCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface ValidateModelCheckerCallback {
		void success();
		void error(Throwable e);
	}
	


	public void addExtendedDataSchema(final org.bimserver.interfaces.objects.SExtendedDataSchema extendedDataSchema, final AddExtendedDataSchemaCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addExtendedDataSchema(extendedDataSchema));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addExtendedDataToProject(final java.lang.Long poid, final org.bimserver.interfaces.objects.SExtendedData extendedData, final AddExtendedDataToProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addExtendedDataToProject(poid, extendedData);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addExtendedDataToRevision(final java.lang.Long roid, final org.bimserver.interfaces.objects.SExtendedData extendedData, final AddExtendedDataToRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addExtendedDataToRevision(roid, extendedData);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addLocalServiceToProject(final java.lang.Long poid, final org.bimserver.interfaces.objects.SService sService, final java.lang.Long internalServiceOid, final AddLocalServiceToProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addLocalServiceToProject(poid, sService, internalServiceOid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addModelChecker(final org.bimserver.interfaces.objects.SModelCheckerInstance modelCheckerInstance, final AddModelCheckerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addModelChecker(modelCheckerInstance));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addModelCheckerToProject(final java.lang.Long poid, final java.lang.Long modelCheckerOid, final AddModelCheckerToProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addModelCheckerToProject(poid, modelCheckerOid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addNewServiceToProject(final java.lang.Long poid, final org.bimserver.interfaces.objects.SNewService sService, final org.bimserver.interfaces.objects.SAction sAction, final AddNewServiceToProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addNewServiceToProject(poid, sService, sAction));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addProject(final java.lang.String projectName, final java.lang.String schema, final AddProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addProject(projectName, schema));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addProjectAsSubProject(final java.lang.String projectName, final java.lang.Long parentPoid, final java.lang.String schema, final AddProjectAsSubProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addProjectAsSubProject(projectName, parentPoid, schema));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addServiceToProject(final java.lang.Long poid, final org.bimserver.interfaces.objects.SService sService, final AddServiceToProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addServiceToProject(poid, sService));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addUser(final java.lang.String username, final java.lang.String name, final org.bimserver.interfaces.objects.SUserType type, final java.lang.Boolean selfRegistration, final java.lang.String resetUrl, final AddUserCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addUser(username, name, type, selfRegistration, resetUrl));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addUserToExtendedDataSchema(final java.lang.Long uoid, final java.lang.Long edsid, final AddUserToExtendedDataSchemaCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addUserToExtendedDataSchema(uoid, edsid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addUserToProject(final java.lang.Long uoid, final java.lang.Long poid, final AddUserToProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addUserToProject(uoid, poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addUserWithPassword(final java.lang.String username, final java.lang.String password, final java.lang.String name, final org.bimserver.interfaces.objects.SUserType type, final java.lang.Boolean selfRegistration, final java.lang.String resetUrl, final AddUserWithPasswordCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addUserWithPassword(username, password, name, type, selfRegistration, resetUrl));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void bcfToJson(final java.lang.Long extendedDataId, final BcfToJsonCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.bcfToJson(extendedDataId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void branchToExistingProject(final java.lang.Long roid, final java.lang.Long destPoid, final java.lang.String comment, final java.lang.Boolean sync, final BranchToExistingProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.branchToExistingProject(roid, destPoid, comment, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void branchToNewProject(final java.lang.Long roid, final java.lang.String projectName, final java.lang.String comment, final java.lang.Boolean sync, final BranchToNewProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.branchToNewProject(roid, projectName, comment, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void changeUserType(final java.lang.Long uoid, final org.bimserver.interfaces.objects.SUserType userType, final ChangeUserTypeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.changeUserType(uoid, userType);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkInternetConnection(final CheckInternetConnectionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkInternetConnection());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkinAsync(final java.lang.Long poid, final java.lang.String comment, final java.lang.Long deserializerOid, final java.lang.Long fileSize, final java.lang.String fileName, final javax.activation.DataHandler data, final java.lang.Boolean merge, final CheckinAsyncCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkinAsync(poid, comment, deserializerOid, fileSize, fileName, data, merge));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkinFromUrlAsync(final java.lang.Long poid, final java.lang.String comment, final java.lang.Long deserializerOid, final java.lang.String fileName, final java.lang.String url, final java.lang.Boolean merge, final CheckinFromUrlAsyncCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkinFromUrlAsync(poid, comment, deserializerOid, fileName, url, merge));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkinFromUrlSync(final java.lang.Long poid, final java.lang.String comment, final java.lang.Long deserializerOid, final java.lang.String fileName, final java.lang.String url, final java.lang.Boolean merge, final CheckinFromUrlSyncCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkinFromUrlSync(poid, comment, deserializerOid, fileName, url, merge));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkinInitiatedAsync(final java.lang.Long topicId, final java.lang.Long poid, final java.lang.String comment, final java.lang.Long deserializerOid, final java.lang.Long fileSize, final java.lang.String fileName, final javax.activation.DataHandler data, final java.lang.Boolean merge, final CheckinInitiatedAsyncCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkinInitiatedAsync(topicId, poid, comment, deserializerOid, fileSize, fileName, data, merge));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkinInitiatedSync(final java.lang.Long topicId, final java.lang.Long poid, final java.lang.String comment, final java.lang.Long deserializerOid, final java.lang.Long fileSize, final java.lang.String fileName, final javax.activation.DataHandler data, final java.lang.Boolean merge, final CheckinInitiatedSyncCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkinInitiatedSync(topicId, poid, comment, deserializerOid, fileSize, fileName, data, merge));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkinSync(final java.lang.Long poid, final java.lang.String comment, final java.lang.Long deserializerOid, final java.lang.Long fileSize, final java.lang.String fileName, final javax.activation.DataHandler data, final java.lang.Boolean merge, final CheckinSyncCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkinSync(poid, comment, deserializerOid, fileSize, fileName, data, merge));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkout(final java.lang.Long roid, final java.lang.Long serializerOid, final java.lang.Boolean sync, final CheckoutCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkout(roid, serializerOid, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void cleanupLongAction(final java.lang.Long topicId, final CleanupLongActionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.cleanupLongAction(topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void clone(final java.lang.Long roid, final java.lang.String projectName, final java.lang.String comment, final java.lang.Boolean sync, final CloneCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.clone(roid, projectName, comment, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void compare(final java.lang.Long roid1, final java.lang.Long roid2, final org.bimserver.interfaces.objects.SCompareType sCompareType, final java.lang.Long mcid, final CompareCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.compare(roid1, roid2, sCompareType, mcid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteProject(final java.lang.Long poid, final DeleteProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.deleteProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteService(final java.lang.Long oid, final DeleteServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.deleteService(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void deleteUser(final java.lang.Long uoid, final DeleteUserCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.deleteUser(uoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void determineIfcVersion(final byte[] head, final java.lang.Boolean zipped, final DetermineIfcVersionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.determineIfcVersion(head, zipped));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void download(final java.util.Set<java.lang.Long> roids, final java.lang.String query, final java.lang.Long serializerOid, final java.lang.Boolean sync, final DownloadCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.download(roids, query, serializerOid, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void downloadCompareResults(final java.lang.Long serializerOid, final java.lang.Long roid1, final java.lang.Long roid2, final java.lang.Long mcid, final org.bimserver.interfaces.objects.SCompareType type, final java.lang.Boolean sync, final DownloadCompareResultsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.downloadCompareResults(serializerOid, roid1, roid2, mcid, type, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllAuthorizedUsersOfProject(final java.lang.Long poid, final GetAllAuthorizedUsersOfProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllAuthorizedUsersOfProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllCheckoutsByUser(final java.lang.Long uoid, final GetAllCheckoutsByUserCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllCheckoutsByUser(uoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllCheckoutsOfProject(final java.lang.Long poid, final GetAllCheckoutsOfProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllCheckoutsOfProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllCheckoutsOfProjectAndSubProjects(final java.lang.Long poid, final GetAllCheckoutsOfProjectAndSubProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllCheckoutsOfProjectAndSubProjects(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllCheckoutsOfRevision(final java.lang.Long roid, final GetAllCheckoutsOfRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllCheckoutsOfRevision(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllExtendedDataOfRevision(final java.lang.Long roid, final GetAllExtendedDataOfRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllExtendedDataOfRevision(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllExtendedDataOfRevisionAndSchema(final java.lang.Long roid, final java.lang.Long schemaId, final GetAllExtendedDataOfRevisionAndSchemaCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllExtendedDataOfRevisionAndSchema(roid, schemaId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllExtendedDataSchemas(final GetAllExtendedDataSchemasCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllExtendedDataSchemas());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllLocalProfiles(final java.lang.String serviceIdentifier, final GetAllLocalProfilesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllLocalProfiles(serviceIdentifier));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllLocalServiceDescriptors(final GetAllLocalServiceDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllLocalServiceDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllModelCheckers(final GetAllModelCheckersCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllModelCheckers());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllModelCheckersOfProject(final java.lang.Long poid, final GetAllModelCheckersOfProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllModelCheckersOfProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllNewServicesOfProject(final java.lang.Long poid, final GetAllNewServicesOfProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllNewServicesOfProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllNonAuthorizedProjectsOfUser(final java.lang.Long uoid, final GetAllNonAuthorizedProjectsOfUserCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllNonAuthorizedProjectsOfUser(uoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllNonAuthorizedUsersOfProject(final java.lang.Long poid, final GetAllNonAuthorizedUsersOfProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllNonAuthorizedUsersOfProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllPrivateProfiles(final java.lang.String notificationsUrl, final java.lang.String serviceIdentifier, final GetAllPrivateProfilesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllPrivateProfiles(notificationsUrl, serviceIdentifier));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllProjects(final java.lang.Boolean onlyTopLevel, final java.lang.Boolean onlyActive, final GetAllProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllProjects(onlyTopLevel, onlyActive));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllProjectsSmall(final GetAllProjectsSmallCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllProjectsSmall());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllPublicProfiles(final java.lang.String notificationsUrl, final java.lang.String serviceIdentifier, final GetAllPublicProfilesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllPublicProfiles(notificationsUrl, serviceIdentifier));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllReadableProjects(final GetAllReadableProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllReadableProjects());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllRelatedProjects(final java.lang.Long poid, final GetAllRelatedProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllRelatedProjects(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllRepositoryExtendedDataSchemas(final java.lang.Boolean usePre, final GetAllRepositoryExtendedDataSchemasCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllRepositoryExtendedDataSchemas(usePre));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllRepositoryModelCheckers(final GetAllRepositoryModelCheckersCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllRepositoryModelCheckers());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllRevisionsByUser(final java.lang.Long uoid, final GetAllRevisionsByUserCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllRevisionsByUser(uoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllRevisionsOfProject(final java.lang.Long poid, final GetAllRevisionsOfProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllRevisionsOfProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllServiceDescriptors(final GetAllServiceDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllServiceDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllServicesOfProject(final java.lang.Long poid, final GetAllServicesOfProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllServicesOfProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllUsers(final GetAllUsersCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllUsers());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAllWritableProjects(final GetAllWritableProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAllWritableProjects());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getArea(final java.lang.Long roid, final java.lang.Long oid, final GetAreaCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getArea(roid, oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAvailableClasses(final GetAvailableClassesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAvailableClasses());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAvailableClassesInRevision(final java.lang.Long roid, final GetAvailableClassesInRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAvailableClassesInRevision(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getCheckinWarnings(final java.lang.Long poid, final GetCheckinWarningsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getCheckinWarnings(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getCheckoutWarnings(final java.lang.Long poid, final GetCheckoutWarningsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getCheckoutWarnings(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDensityThreshold(final java.util.Set<java.lang.Long> roids, final java.lang.Long nrTriangles, final java.util.Set<java.lang.String> excludedTypes, final GetDensityThresholdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDensityThreshold(roids, nrTriangles, excludedTypes));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDeserializerById(final java.lang.Long oid, final GetDeserializerByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDeserializerById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDeserializerByName(final java.lang.String deserializerName, final GetDeserializerByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDeserializerByName(deserializerName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDownloadData(final java.lang.Long topicId, final GetDownloadDataCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDownloadData(topicId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getExtendedData(final java.lang.Long oid, final GetExtendedDataCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getExtendedData(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getExtendedDataSchemaById(final java.lang.Long oid, final GetExtendedDataSchemaByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getExtendedDataSchemaById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getExtendedDataSchemaByName(final java.lang.String name, final GetExtendedDataSchemaByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getExtendedDataSchemaByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getExtendedDataSchemaFromRepository(final java.lang.String namespace, final GetExtendedDataSchemaFromRepositoryCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getExtendedDataSchemaFromRepository(namespace));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getFile(final java.lang.Long fileId, final GetFileCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getFile(fileId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getFileMeta(final java.lang.Long fileId, final GetFileMetaCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getFileMeta(fileId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getGeoTag(final java.lang.Long goid, final GetGeoTagCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getGeoTag(goid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getGeometryDataToReuse(final java.util.Set<java.lang.Long> roids, final java.util.Set<java.lang.String> excludedTypes, final java.lang.Integer trianglesToSave, final GetGeometryDataToReuseCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getGeometryDataToReuse(roids, excludedTypes, trianglesToSave));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getGeometryInfo(final java.lang.Long roid, final java.lang.Long oid, final GetGeometryInfoCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getGeometryInfo(roid, oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getIfcHeader(final java.lang.Long croid, final GetIfcHeaderCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getIfcHeader(croid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getLastExtendedDataOfRevisionAndSchema(final java.lang.Long roid, final java.lang.Long schemaId, final GetLastExtendedDataOfRevisionAndSchemaCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getLastExtendedDataOfRevisionAndSchema(roid, schemaId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelBounds(final java.lang.Long roid, final GetModelBoundsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelBounds(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelBoundsForConcreteRevision(final java.lang.Long croid, final GetModelBoundsForConcreteRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelBoundsForConcreteRevision(croid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelBoundsUntransformed(final java.lang.Long roid, final GetModelBoundsUntransformedCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelBoundsUntransformed(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelBoundsUntransformedForConcreteRevision(final java.lang.Long croid, final GetModelBoundsUntransformedForConcreteRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelBoundsUntransformedForConcreteRevision(croid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelCheckerInstance(final java.lang.Long mcioid, final GetModelCheckerInstanceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelCheckerInstance(mcioid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelMaxBounds(final java.lang.Long roid, final GetModelMaxBoundsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelMaxBounds(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getModelMinBounds(final java.lang.Long roid, final GetModelMinBoundsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getModelMinBounds(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getNewService(final java.lang.Long soid, final GetNewServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getNewService(soid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getNrPrimitives(final java.lang.Long roid, final GetNrPrimitivesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getNrPrimitives(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getNrPrimitivesTotal(final java.util.Set<java.lang.Long> roids, final GetNrPrimitivesTotalCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getNrPrimitivesTotal(roids));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getOidByGuid(final java.lang.Long roid, final java.lang.String guid, final GetOidByGuidCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getOidByGuid(roid, guid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getProjectByPoid(final java.lang.Long poid, final GetProjectByPoidCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getProjectByPoid(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getProjectByUuid(final java.lang.String uuid, final GetProjectByUuidCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getProjectByUuid(uuid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getProjectSmallByPoid(final java.lang.Long poid, final GetProjectSmallByPoidCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getProjectSmallByPoid(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getProjectsByName(final java.lang.String name, final GetProjectsByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getProjectsByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getQueryEngineById(final java.lang.Long oid, final GetQueryEngineByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getQueryEngineById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getQueryEngineByName(final java.lang.String name, final GetQueryEngineByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getQueryEngineByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getQueryEngineExample(final java.lang.Long qeid, final java.lang.String key, final GetQueryEngineExampleCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getQueryEngineExample(qeid, key));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getQueryEngineExampleKeys(final java.lang.Long qeid, final GetQueryEngineExampleKeysCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getQueryEngineExampleKeys(qeid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getRevision(final java.lang.Long roid, final GetRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getRevision(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getRevisionSummary(final java.lang.Long roid, final GetRevisionSummaryCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getRevisionSummary(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSerializerByContentType(final java.lang.String contentType, final GetSerializerByContentTypeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSerializerByContentType(contentType));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSerializerById(final java.lang.Long oid, final GetSerializerByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSerializerById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSerializerByName(final java.lang.String serializerName, final GetSerializerByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSerializerByName(serializerName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getService(final java.lang.Long soid, final GetServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getService(soid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServiceDescriptor(final java.lang.String baseUrl, final java.lang.String serviceIdentifier, final GetServiceDescriptorCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServiceDescriptor(baseUrl, serviceIdentifier));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSubProjectByName(final java.lang.Long parentProjectId, final java.lang.String name, final GetSubProjectByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSubProjectByName(parentProjectId, name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSubProjects(final java.lang.Long poid, final GetSubProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSubProjects(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getSuggestedDeserializerForExtension(final java.lang.String extension, final java.lang.Long poid, final GetSuggestedDeserializerForExtensionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSuggestedDeserializerForExtension(extension, poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getTileCounts(final java.util.Set<java.lang.Long> roids, final java.util.Set<java.lang.String> excludedTypes, final java.util.Set<java.lang.Long> geometryIdsToReuse, final java.lang.Float minimumThreshold, final java.lang.Float maximumThreshold, final java.lang.Integer depth, final GetTileCountsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getTileCounts(roids, excludedTypes, geometryIdsToReuse, minimumThreshold, maximumThreshold, depth));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getTiles(final java.util.Set<java.lang.Long> roids, final java.util.Set<java.lang.String> excludedTypes, final java.util.Set<java.lang.Long> geometryIdsToReuse, final java.lang.Float minimumThreshold, final java.lang.Float maximumThreshold, final java.lang.Integer depth, final GetTilesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getTiles(roids, excludedTypes, geometryIdsToReuse, minimumThreshold, maximumThreshold, depth));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getTopLevelProjectByName(final java.lang.String name, final GetTopLevelProjectByNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getTopLevelProjectByName(name));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getTotalBounds(final java.util.Set<java.lang.Long> roids, final GetTotalBoundsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getTotalBounds(roids));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getTotalUntransformedBounds(final java.util.Set<java.lang.Long> roids, final GetTotalUntransformedBoundsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getTotalUntransformedBounds(roids));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getUserByUoid(final java.lang.Long uoid, final GetUserByUoidCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getUserByUoid(uoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getUserByUserName(final java.lang.String username, final GetUserByUserNameCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getUserByUserName(username));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getUserRelatedLogs(final java.lang.Long uoid, final GetUserRelatedLogsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getUserRelatedLogs(uoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getUserSettings(final GetUserSettingsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getUserSettings());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getUsersProjects(final java.lang.Long uoid, final GetUsersProjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getUsersProjects(uoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getVolume(final java.lang.Long roid, final java.lang.Long oid, final GetVolumeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getVolume(roid, oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void importData(final java.lang.String address, final java.lang.String username, final java.lang.String password, final java.lang.String path, final ImportDataCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.importData(address, username, password, path);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void initiateCheckin(final java.lang.Long poid, final java.lang.Long deserializerOid, final InitiateCheckinCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.initiateCheckin(poid, deserializerOid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void listBoundingBoxes(final java.util.Set<java.lang.Long> roids, final ListBoundingBoxesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listBoundingBoxes(roids));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void regenerateGeometry(final java.lang.Long roid, final java.lang.Long eoid, final RegenerateGeometryCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.regenerateGeometry(roid, eoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeModelCheckerFromProject(final java.lang.Long poid, final java.lang.Long modelCheckerOid, final RemoveModelCheckerFromProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeModelCheckerFromProject(poid, modelCheckerOid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeNewServiceFromProject(final java.lang.Long poid, final java.lang.Long serviceOid, final RemoveNewServiceFromProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeNewServiceFromProject(poid, serviceOid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeServiceFromProject(final java.lang.Long poid, final java.lang.Long serviceOid, final RemoveServiceFromProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeServiceFromProject(poid, serviceOid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeUserFromExtendedDataSchema(final java.lang.Long uoid, final java.lang.Long edsid, final RemoveUserFromExtendedDataSchemaCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeUserFromExtendedDataSchema(uoid, edsid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeUserFromProject(final java.lang.Long uoid, final java.lang.Long poid, final RemoveUserFromProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.removeUserFromProject(uoid, poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void sendCompareEmail(final org.bimserver.interfaces.objects.SCompareType sCompareType, final java.lang.Long mcid, final java.lang.Long poid, final java.lang.Long roid1, final java.lang.Long roid2, final java.lang.String address, final SendCompareEmailCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.sendCompareEmail(sCompareType, mcid, poid, roid1, roid2, address);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setRevisionTag(final java.lang.Long roid, final java.lang.String tag, final SetRevisionTagCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setRevisionTag(roid, tag);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void shareRevision(final java.lang.Long roid, final ShareRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.shareRevision(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void terminateLongRunningAction(final java.lang.Long topicId, final TerminateLongRunningActionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.terminateLongRunningAction(topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void triggerNewExtendedData(final java.lang.Long edid, final java.lang.Long soid, final TriggerNewExtendedDataCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.triggerNewExtendedData(edid, soid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void triggerNewRevision(final java.lang.Long roid, final java.lang.Long soid, final TriggerNewRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.triggerNewRevision(roid, soid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void triggerRevisionService(final java.lang.Long roid, final java.lang.Long soid, final TriggerRevisionServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.triggerRevisionService(roid, soid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void undeleteProject(final java.lang.Long poid, final UndeleteProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.undeleteProject(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void undeleteUser(final java.lang.Long uoid, final UndeleteUserCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.undeleteUser(uoid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateGeoTag(final org.bimserver.interfaces.objects.SGeoTag sGeoTag, final UpdateGeoTagCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateGeoTag(sGeoTag);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateModelChecker(final org.bimserver.interfaces.objects.SModelCheckerInstance modelCheckerInstance, final UpdateModelCheckerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateModelChecker(modelCheckerInstance);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateProject(final org.bimserver.interfaces.objects.SProject sProject, final UpdateProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateProject(sProject);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void updateRevision(final org.bimserver.interfaces.objects.SRevision sRevision, final UpdateRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.updateRevision(sRevision);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void uploadFile(final org.bimserver.interfaces.objects.SFile file, final UploadFileCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.uploadFile(file));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void userHasCheckinRights(final java.lang.Long uoid, final java.lang.Long poid, final UserHasCheckinRightsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.userHasCheckinRights(uoid, poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void userHasRights(final java.lang.Long poid, final UserHasRightsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.userHasRights(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void validateModelChecker(final java.lang.Long oid, final ValidateModelCheckerCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.validateModelChecker(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}