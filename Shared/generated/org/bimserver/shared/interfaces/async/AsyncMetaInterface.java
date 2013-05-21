package org.bimserver.shared.interfaces.async;

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
import java.util.concurrent.ExecutorService;
import org.bimserver.shared.interfaces.MetaInterface;

public class AsyncMetaInterface {

	private final ExecutorService executorService;
	private final MetaInterface syncService;

	public AsyncMetaInterface(MetaInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface GetEnumLiteralsCallback {
		void success(java.util.List<java.lang.String> result);
		void error(Exception e);
	}
	
	public interface GetServiceInterfaceCallback {
		void success(org.bimserver.interfaces.objects.SServiceInterface result);
		void error(Exception e);
	}
	
	public interface GetServiceInterfacesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SServiceInterface> result);
		void error(Exception e);
	}
	
	public interface GetServiceMethodCallback {
		void success(org.bimserver.interfaces.objects.SServiceMethod result);
		void error(Exception e);
	}
	
	public interface GetServiceMethodParametersCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SServiceParameter> result);
		void error(Exception e);
	}
	
	public interface GetServiceMethodsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SServiceMethod> result);
		void error(Exception e);
	}
	
	public interface GetServiceTypesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SServiceType> result);
		void error(Exception e);
	}
	


	public void getEnumLiterals(final java.lang.String enumName, final GetEnumLiteralsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getEnumLiterals(enumName));
				} catch (Exception e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServiceInterface(final java.lang.String getServiceInterface, final GetServiceInterfaceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServiceInterface(getServiceInterface));
				} catch (Exception e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServiceInterfaces(final GetServiceInterfacesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServiceInterfaces());
				} catch (Exception e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServiceMethod(final java.lang.String serviceInterfaceName, final java.lang.String methodName, final GetServiceMethodCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServiceMethod(serviceInterfaceName, methodName));
				} catch (Exception e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServiceMethodParameters(final java.lang.String serviceInterfaceName, final java.lang.String serviceMethodName, final GetServiceMethodParametersCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServiceMethodParameters(serviceInterfaceName, serviceMethodName));
				} catch (Exception e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServiceMethods(final java.lang.String serviceInterfaceName, final GetServiceMethodsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServiceMethods(serviceInterfaceName));
				} catch (Exception e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getServiceTypes(final java.lang.String serviceInterfaceName, final GetServiceTypesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getServiceTypes(serviceInterfaceName));
				} catch (Exception e) {
					callback.error(e);
				}
			}
		});
	}
	
}