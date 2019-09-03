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
import org.bimserver.shared.interfaces.RemoteServiceInterface;

public class AsyncRemoteServiceInterface {

	private final ExecutorService executorService;
	private final RemoteServiceInterface syncService;

	public AsyncRemoteServiceInterface(RemoteServiceInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface GetPrivateProfilesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetPublicProfilesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SProfileDescriptor> result);
		void error(Throwable e);
	}
	
	public interface GetServiceCallback {
		void success(org.bimserver.interfaces.objects.SServiceDescriptor result);
		void error(Throwable e);
	}
	
	public interface NewExtendedDataOnProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewExtendedDataOnRevisionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewRevisionCallback {
		void success();
		void error(Throwable e);
	}
	


	public void getPrivateProfiles(final java.lang.String serviceIdentifier, final java.lang.String token, final GetPrivateProfilesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPrivateProfiles(serviceIdentifier, token));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getPublicProfiles(final java.lang.String serviceIdentifier, final GetPublicProfilesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getPublicProfiles(serviceIdentifier));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getService(final java.lang.String serviceIdentifier, final GetServiceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getService(serviceIdentifier));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newExtendedDataOnProject(final java.lang.Long poid, final java.lang.Long edid, final java.lang.Long soid, final java.lang.String serviceIdentifier, final java.lang.String profileIdentifier, final java.lang.String userToken, final java.lang.String token, final java.lang.String apiUrl, final NewExtendedDataOnProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newExtendedDataOnProject(poid, edid, soid, serviceIdentifier, profileIdentifier, userToken, token, apiUrl);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newExtendedDataOnRevision(final java.lang.Long poid, final java.lang.Long roid, final java.lang.Long edid, final java.lang.Long soid, final java.lang.String serviceIdentifier, final java.lang.String profileIdentifier, final java.lang.String userToken, final java.lang.String token, final java.lang.String apiUrl, final NewExtendedDataOnRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newExtendedDataOnRevision(poid, roid, edid, soid, serviceIdentifier, profileIdentifier, userToken, token, apiUrl);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newRevision(final java.lang.Long poid, final java.lang.Long roid, final java.lang.Long soid, final java.lang.String serviceIdentifier, final java.lang.String profileIdentifier, final java.lang.String userToken, final java.lang.String token, final java.lang.String apiUrl, final NewRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newRevision(poid, roid, soid, serviceIdentifier, profileIdentifier, userToken, token, apiUrl);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}