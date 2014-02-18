package org.bimserver.shared.interfaces.async;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import java.util.concurrent.ExecutorService;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;

public class AsyncBimsie1ServiceInterface {

	private final ExecutorService executorService;
	private final Bimsie1ServiceInterface syncService;

	public AsyncBimsie1ServiceInterface(Bimsie1ServiceInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface AddExtendedDataToRevisionCallback {
		void success();
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
	
	public interface BranchToExistingProjectCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface BranchToNewProjectCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CheckinCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CheckinFromUrlCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CheckoutCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface DeleteProjectCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface DownloadCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface DownloadByGuidsCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface DownloadByNamesCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface DownloadByOidsCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface DownloadByTypesCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface DownloadQueryCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface DownloadRevisionsCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetAllExtendedDataOfRevisionCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SExtendedData> result);
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
	
	public interface GetAllRevisionsOfProjectCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SRevision> result);
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
	
	public interface GetExtendedDataSchemaByNamespaceCallback {
		void success(org.bimserver.interfaces.objects.SExtendedDataSchema result);
		void error(Throwable e);
	}
	
	public interface GetProjectByPoidCallback {
		void success(org.bimserver.interfaces.objects.SProject result);
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
	
	public interface GetRevisionCallback {
		void success(org.bimserver.interfaces.objects.SRevision result);
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
	
	public interface GetSubProjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProject> result);
		void error(Throwable e);
	}
	
	public interface GetSuggestedDeserializerForExtensionCallback {
		void success(org.bimserver.interfaces.objects.SDeserializerPluginConfiguration result);
		void error(Throwable e);
	}
	
	public interface UndeleteProjectCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
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
	
	public void addProject(final java.lang.String projectName, final AddProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addProject(projectName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addProjectAsSubProject(final java.lang.String projectName, final java.lang.Long parentPoid, final AddProjectAsSubProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.addProjectAsSubProject(projectName, parentPoid));
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
	
	public void checkin(final java.lang.Long poid, final java.lang.String comment, final java.lang.Long deserializerOid, final java.lang.Long fileSize, final java.lang.String fileName, final javax.activation.DataHandler data, final java.lang.Boolean sync, final CheckinCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkin(poid, comment, deserializerOid, fileSize, fileName, data, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void checkinFromUrl(final java.lang.Long poid, final java.lang.String comment, final java.lang.Long deserializerOid, final java.lang.String fileName, final java.lang.String url, final java.lang.Boolean sync, final CheckinFromUrlCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.checkinFromUrl(poid, comment, deserializerOid, fileName, url, sync));
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
	
	public void download(final java.lang.Long roid, final java.lang.Long serializerOid, final java.lang.Boolean showOwn, final java.lang.Boolean sync, final DownloadCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.download(roid, serializerOid, showOwn, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void downloadByGuids(final java.util.Set<java.lang.Long> roids, final java.util.Set<java.lang.String> guids, final java.lang.Long serializerOid, final java.lang.Boolean deep, final java.lang.Boolean sync, final DownloadByGuidsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.downloadByGuids(roids, guids, serializerOid, deep, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void downloadByNames(final java.util.Set<java.lang.Long> roids, final java.util.Set<java.lang.String> names, final java.lang.Long serializerOid, final java.lang.Boolean deep, final java.lang.Boolean sync, final DownloadByNamesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.downloadByNames(roids, names, serializerOid, deep, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void downloadByOids(final java.util.Set<java.lang.Long> roids, final java.util.Set<java.lang.Long> oids, final java.lang.Long serializerOid, final java.lang.Boolean sync, final java.lang.Boolean deep, final DownloadByOidsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.downloadByOids(roids, oids, serializerOid, sync, deep));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void downloadByTypes(final java.util.Set<java.lang.Long> roids, final java.util.Set<java.lang.String> classNames, final java.lang.Long serializerOid, final java.lang.Boolean includeAllSubtypes, final java.lang.Boolean useObjectIDM, final java.lang.Boolean deep, final java.lang.Boolean sync, final DownloadByTypesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.downloadByTypes(roids, classNames, serializerOid, includeAllSubtypes, useObjectIDM, deep, sync));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void downloadQuery(final java.lang.Long roid, final java.lang.Long qeid, final java.lang.String code, final java.lang.Boolean sync, final java.lang.Long serializerOid, final DownloadQueryCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.downloadQuery(roid, qeid, code, sync, serializerOid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void downloadRevisions(final java.util.Set<java.lang.Long> roids, final java.lang.Long serializerOid, final java.lang.Boolean sync, final DownloadRevisionsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.downloadRevisions(roids, serializerOid, sync));
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
	
	public void getDownloadData(final java.lang.Long actionId, final GetDownloadDataCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDownloadData(actionId));
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
	
	public void getExtendedDataSchemaByNamespace(final java.lang.String namespace, final GetExtendedDataSchemaByNamespaceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getExtendedDataSchemaByNamespace(namespace));
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
	
	public void getSuggestedDeserializerForExtension(final java.lang.String extension, final GetSuggestedDeserializerForExtensionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getSuggestedDeserializerForExtension(extension));
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
	
}