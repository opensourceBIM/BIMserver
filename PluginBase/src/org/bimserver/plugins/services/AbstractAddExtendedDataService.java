package org.bimserver.plugins.services;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.models.store.ServiceDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractAddExtendedDataService extends AbstractService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAddExtendedDataService.class);
	private String namespace;

	public AbstractAddExtendedDataService(String name, String namespace) {
		super(name);
		this.namespace = namespace;
	}
	
	public void addExtendedData(byte[] data, String filename, String title, String mime, BimServerClientInterface bimServerClientInterface, long roid) {
		try {
			SFile file = new SFile();
			
			SExtendedData extendedData = new SExtendedData();
			extendedData.setTitle(title);
			file.setFilename(filename);
			SExtendedDataSchema extendedDataSchemaByNamespace = bimServerClientInterface.getBimsie1ServiceInterface().getExtendedDataSchemaByNamespace(namespace);
			
			extendedData.setSchemaId(extendedDataSchemaByNamespace.getOid());
			file.setData(data);
			file.setMime(mime);

			long fileId = bimServerClientInterface.getServiceInterface().uploadFile(file);
			extendedData.setFileId(fileId);

			bimServerClientInterface.getBimsie1ServiceInterface().addExtendedDataToRevision(roid, extendedData);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	@Override
	public void addRequiredRights(ServiceDescriptor serviceDescriptor) {
		serviceDescriptor.setWriteExtendedData(namespace);
	}
}
