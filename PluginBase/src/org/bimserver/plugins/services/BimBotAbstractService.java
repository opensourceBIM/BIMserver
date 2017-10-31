package org.bimserver.plugins.services;

import java.util.Collections;
import java.util.Set;

import org.bimserver.bimbots.BimBotsInput;
import org.bimserver.bimbots.BimBotsOutput;
import org.bimserver.bimbots.BimBotsServiceInterface;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.SchemaName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BimBotAbstractService extends AbstractService implements BimBotsServiceInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimBotAbstractService.class);

	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception {
		BimBotsInput input = new BimBotsInput(SchemaName.IFC_STEP_2X3TC1, null);
		SProject project = bimServerClientInterface.getServiceInterface().getProjectByPoid(poid);
		input.setIfcModel(bimServerClientInterface.getModel(project, roid, false, false, true));
		BimBotsOutput output = runBimBot(input, settings);
		
		try {
			SFile file = new SFile();
			
			SExtendedData extendedData = new SExtendedData();
			extendedData.setTitle(output.getTitle());
			extendedData.setSize(output.getData().length);
			file.setFilename(output.getContentDisposition());
			SExtendedDataSchema extendedDataSchemaByName = null;
			try {
				extendedDataSchemaByName = bimServerClientInterface.getServiceInterface().getExtendedDataSchemaByName(output.getSchemaName().name());
			} catch (Exception e) {
				extendedDataSchemaByName = new SExtendedDataSchema();
				extendedDataSchemaByName.setContentType(output.getContentType());
				extendedDataSchemaByName.setName(output.getSchemaName().name());
				bimServerClientInterface.getServiceInterface().addExtendedDataSchema(extendedDataSchemaByName);
			}
			
			extendedData.setSchemaId(extendedDataSchemaByName.getOid());
			file.setData(output.getData());
			file.setSize(output.getData().length);
			file.setMime(output.getContentType());

			long fileId = bimServerClientInterface.getServiceInterface().uploadFile(file);
			extendedData.setFileId(fileId);

			bimServerClientInterface.getServiceInterface().addExtendedDataToRevision(roid, extendedData);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public void addRequiredRights(ServiceDescriptor serviceDescriptor) {
		serviceDescriptor.setWriteExtendedData(getOutputSchema().name());
	}

	@Override
	public Set<SchemaName> getAvailableOutputs() {
		return Collections.singleton(getOutputSchema());
	}
	
	@Override
	public Set<SchemaName> getAvailableInputs() {
		return Collections.singleton(SchemaName.IFC_STEP_2X3TC1);
	}

	public abstract SchemaName getOutputSchema();
}
