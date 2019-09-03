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
import org.bimserver.shared.interfaces.NewServicesInterface;

public class AsyncNewServicesInterface {

	private final ExecutorService executorService;
	private final NewServicesInterface syncService;

	public AsyncNewServicesInterface(NewServicesInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface ListAllServiceDescriptorsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SNewServiceDescriptor> result);
		void error(Throwable e);
	}
	
	public interface ListAvailableOutputFormatsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SFormatSerializerMap> result);
		void error(Throwable e);
	}
	


	public void listAllServiceDescriptors(final ListAllServiceDescriptorsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listAllServiceDescriptors());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void listAvailableOutputFormats(final java.lang.Long poid, final ListAvailableOutputFormatsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listAvailableOutputFormats(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}