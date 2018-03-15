package org.bimserver.plugins.services;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.Collections;
import java.util.Set;

import org.bimserver.bimbots.BimBotsException;
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
		try {
			BimBotsInput input = new BimBotsInput(SchemaName.IFC_STEP_2X3TC1, null);
			SProject project = bimServerClientInterface.getServiceInterface().getProjectByPoid(poid);
			input.setIfcModel(bimServerClientInterface.getModel(project, roid, false, false, true));
			BimBotsOutput output = runBimBot(input, settings);
			SFile file = new SFile();
			
			SExtendedData extendedData = new SExtendedData();
			extendedData.setTitle(output.getTitle());
			extendedData.setSize(output.getData().length);
			file.setFilename(output.getContentDisposition());
			SExtendedDataSchema extendedDataSchemaByName = null;
			try {
				extendedDataSchemaByName = bimServerClientInterface.getServiceInterface().getExtendedDataSchemaByName(output.getSchemaName());
			} catch (Exception e) {
				extendedDataSchemaByName = new SExtendedDataSchema();
				extendedDataSchemaByName.setContentType(output.getContentType());
				extendedDataSchemaByName.setName(output.getSchemaName());
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
		serviceDescriptor.setWriteExtendedData(getOutputSchema());
	}

	@Override
	public Set<String> getAvailableOutputs() throws BimBotsException {
		String outputSchema = getOutputSchema();
		if (outputSchema == null) {
			throw new BimBotsException("No output schema provided");
		}
		return Collections.singleton(outputSchema);
	}
	
	@Override
	public Set<String> getAvailableInputs() throws BimBotsException {
		String input = SchemaName.IFC_STEP_2X3TC1.name();
		if (input == null) {
			throw new BimBotsException("No input schema provided");
		}
		return Collections.singleton(input);
	}

	public abstract String getOutputSchema();
}