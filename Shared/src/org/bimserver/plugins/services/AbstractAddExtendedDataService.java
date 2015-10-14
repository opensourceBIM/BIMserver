package org.bimserver.plugins.services;

import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractAddExtendedDataService extends AbstractService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAddExtendedDataService.class);
	private String namespace;

	public AbstractAddExtendedDataService(String name, String description, String namespace) {
		super(name, description);
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
