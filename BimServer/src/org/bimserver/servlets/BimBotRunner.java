package org.bimserver.servlets;

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

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.activation.DataHandler;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.bimbots.BimBotContext;
import org.bimserver.bimbots.BimBotDefaultErrorCode;
import org.bimserver.bimbots.BimBotsException;
import org.bimserver.bimbots.BimBotsOutput;
import org.bimserver.bimbots.BimBotsServiceInterface;
import org.bimserver.bimbots.BimServerBimBotsInput;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OldQuery.Deep;
import org.bimserver.database.OperationType;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.endpoints.VirtualEndPoint;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.notifications.ProgressTopic;
import org.bimserver.notifications.TopicRegisterException;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.SchemaName;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.StreamingSocketInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.NotificationInterfaceAdaptor;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.utils.ByteUtils;
import org.bimserver.utils.InputStreamDataSource;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;

public class BimBotRunner implements Runnable {
	private static final Logger LOGGER = LoggerFactory.getLogger(BimBotRunner.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private BimServer bimServer;
	private InputStream inputStream;
	private String inputType;
	private Authorization authorization;
	private InternalServicePluginConfiguration foundService;
	private BimBotsServiceInterface bimBotsServiceInterface;
	private String contextId;
	private StreamingSocketInterface streamingSocketInterface;
	private Long topicId;
	private final ObjectMapper objectMapper = new ObjectMapper();
	private Long endPointId;
	private PluginConfiguration settings;

	public BimBotRunner(BimServer bimServer, InputStream inputStream, String contextId, String inputType, Authorization authorization,
			InternalServicePluginConfiguration foundService, BimBotsServiceInterface bimBotsServiceInterface) {
		this(bimServer, inputStream, contextId, inputType, authorization, foundService, bimBotsServiceInterface, null, null, null);
	}
	
	public BimBotRunner(BimServer bimServer, InputStream inputStream, String contextId, String inputType, Authorization authorization,
			InternalServicePluginConfiguration foundService, BimBotsServiceInterface bimBotsServiceInterface, StreamingSocketInterface streamingSocketInterface, Long topicId, Long endPointId) {
		this.bimServer = bimServer;
		this.inputStream = inputStream;
		this.contextId = contextId;
		this.inputType = inputType;
		this.authorization = authorization;
		this.foundService = foundService;
		this.bimBotsServiceInterface = bimBotsServiceInterface;
		this.streamingSocketInterface = streamingSocketInterface;
		this.topicId = topicId;
		this.endPointId = endPointId;
		this.settings = new PluginConfiguration(foundService.getSettings());
	}
	
	public BimBotsOutput runBimBot() throws UserException, IOException {
		BimBotContext bimBotContext = new BimBotContext() {
			@Override
			public void updateProgress(String label, int percentage) {
				if (streamingSocketInterface != null) {
					ObjectNode message = objectMapper.createObjectNode();
					message.put("type", "progress");
					message.put("topicId", topicId);
					ObjectNode payload = objectMapper.createObjectNode();
					payload.put("progress", percentage);
					payload.put("label", label);
					message.set("payload", payload);
					streamingSocketInterface.send(message);
				}
			}
			
			public String getCurrentUser() {
				return authorization.getUsername();
			}
			
			public String getContextId() {
				return contextId;
			}
		};

		try (DatabaseSession session = bimServer.getDatabase().createSession(OperationType.READ_ONLY)) {
			ServiceMap serviceMap = bimServer.getServiceFactory().get(authorization, AccessMethod.INTERNAL);
			ServiceInterface serviceInterface = serviceMap.get(ServiceInterface.class);
			if (bimServer.getServerSettingsCache().getServerSettings().isStoreServiceRuns()) {
				long start = System.nanoTime();
				// When we store service runs, we can just use the streaming deserializer to stream directly to the database, after that we'll trigger the actual service
				
				// Create or find project and link user and service to project
				// Checkin stream into project
				// Trigger service
				
				byte[] data = null;
				if (bimBotsServiceInterface.needsRawInput()) {
					// We need the raw input later on, lets just get it now
					data = ByteStreams.toByteArray(inputStream);
					// Make a clean inputstream that uses the data as the original won't be available after this
					inputStream = new ByteArrayInputStream(data);
				}
				
				SchemaName schema = SchemaName.valueOf(inputType);
				String projectSchema = getProjectSchema(serviceInterface, schema);

				SProject project = null;
				String uuid = contextId;
				if (uuid != null) {
					project = serviceInterface.getProjectByUuid(uuid);
				} else {
					project = serviceInterface.addProject("tmp-" + new Random().nextInt(), projectSchema);							
				}

				SDeserializerPluginConfiguration deserializer = serviceInterface.getSuggestedDeserializerForExtension("ifc", project.getOid());
				if (deserializer == null) {
					throw new BimBotsException("No deserializer found", BimBotDefaultErrorCode.NO_DESERIALIZER);
				}
				Long topicId = serviceInterface.initiateCheckin(project.getOid(), deserializer.getOid());
				ProgressTopic progressTopic = null;
				VirtualEndPoint virtualEndpoint = null;
				try {
					progressTopic = bimServer.getNotificationsManager().getProgressTopic(topicId);
					virtualEndpoint = new VirtualEndPoint(){
						@Override
						public NotificationInterface getNotificationInterface() {
							return new NotificationInterfaceAdaptor(){
								@Override
								public void progress(Long topicId, SLongActionState state) throws UserException, ServerException {
									bimBotContext.updateProgress(state.getTitle(), state.getProgress());
								}
							};
						}
					};
					progressTopic.register(virtualEndpoint);
				} catch (TopicRegisterException e1) {
					e1.printStackTrace();
				}
				serviceInterface.checkinInitiatedSync(topicId, project.getOid(), "Auto checkin", deserializer.getOid(), -1L, "s", new DataHandler(new InputStreamDataSource(inputStream)), false);
				project = serviceInterface.getProjectByPoid(project.getOid());
				
				PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(project.getSchema());
				BasicIfcModel model = new BasicIfcModel(packageMetaData, null);
				model.setPluginClassLoaderProvider(bimServer.getPluginManager());
				try {
					Revision revision = session.get(project.getLastRevisionId(), OldQuery.getDefault());
					session.getMap(model, new OldQuery(packageMetaData, project.getId(), revision.getId(), revision.getOid(), Deep.NO));
					model.getModelMetaData().setIfcHeader(revision.getLastConcreteRevision().getIfcHeader());
				} catch (BimserverDatabaseException e) {
					e.printStackTrace();
				}
				
				BimServerBimBotsInput input = new BimServerBimBotsInput(bimServer, authorization.getUoid(), inputType, data, model, false);
				BimBotsOutput output = bimBotsServiceInterface.runBimBot(input, bimBotContext, settings);
				long end = System.nanoTime();
				
				if (output.getModel() != null) {
					SerializerPlugin plugin = bimServer.getPluginManager().getSerializerPlugin("org.bimserver.ifc.step.serializer.Ifc2x3tc1StepSerializerPlugin");
					Serializer serializer = plugin.createSerializer(new PluginConfiguration());
					serializer.init(output.getModel(), new ProjectInfo(), true);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					serializer.writeToOutputStream(baos, null);
					output.setData(baos.toByteArray());
					output.setContentType("application/ifc");
				}
				
				SExtendedData extendedData = new SExtendedData();
				SFile file = new SFile();
				file.setData(output.getData());
				file.setFilename(output.getContentDisposition());
				file.setMime(output.getContentType());
				file.setSize(output.getData().length);
				Long fileId = serviceInterface.uploadFile(file);
				long ms = (end - start) / 1000000;
				extendedData.setTimeToGenerate(ms);
				extendedData.setFileId(fileId);
				extendedData.setTitle(output.getTitle());
				SExtendedDataSchema extendedDataSchema = null;
				try {
					extendedDataSchema = serviceInterface.getExtendedDataSchemaByName(output.getSchemaName());
				} catch (UserException e) {
					extendedDataSchema = new SExtendedDataSchema();
					extendedDataSchema.setContentType(output.getContentType());
					extendedDataSchema.setName(output.getSchemaName());
					serviceInterface.addExtendedDataSchema(extendedDataSchema);
				}
				extendedData.setSchemaId(extendedDataSchema.getOid());
				serviceInterface.addExtendedDataToRevision(project.getLastRevisionId(), extendedData);
				
				output.setContextId(project.getUuid().toString());
				
				if (progressTopic != null) {
					try {
						progressTopic.unregister(virtualEndpoint);
					} catch (TopicRegisterException e) {
						e.printStackTrace();
					}
				}
				
				return output;
			} else {
				// When we don't store the service runs, there is no other way than to just use the old deserializer and run the service from the EMF model
				LOGGER.info("NOT Storing intermediate results");

				String projectSchema = getProjectSchema(serviceInterface, SchemaName.valueOf(inputType));

				Schema schema = Schema.valueOf(projectSchema.toUpperCase());
				DeserializerPlugin deserializerPlugin = bimServer.getPluginManager().getFirstDeserializer("ifc", schema, true);
				if (deserializerPlugin == null) {
					throw new BimBotsException("No deserializer plugin found", BimBotDefaultErrorCode.NO_DESERIALIZER);
				}
				
				byte[] data = IOUtils.toByteArray(inputStream);
				
				Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
				PackageMetaData packageMetaData = bimServer.getMetaDataManager().getPackageMetaData(schema.name());
				deserializer.init(packageMetaData);
				IfcModelInterface model = deserializer.read(new ByteArrayInputStream(data), inputType, data.length, null);
				
				BimServerBimBotsInput input = new BimServerBimBotsInput(bimServer, authorization.getUoid(), inputType, data, model, true);
				BimBotsOutput output = bimBotsServiceInterface.runBimBot(input, bimBotContext, new PluginConfiguration(foundService.getSettings()));
				
				return output;
			}
		} catch (BimBotsException e) {
			ObjectNode errorNode = OBJECT_MAPPER.createObjectNode();
			errorNode.put("code", e.getErrorCode());
			errorNode.put("message", e.getMessage());
			BimBotsOutput bimBotsOutput = new BimBotsOutput("ERROR", errorNode.toString().getBytes(Charsets.UTF_8));
			return bimBotsOutput;
		} catch (Throwable e) {
			LOGGER.error("", e);
			ObjectNode errorNode = OBJECT_MAPPER.createObjectNode();
			errorNode.put("code", 500);

			// TODO should not leak this much info to called, but for now this is useful debugging info
			errorNode.put("message", "Unknown error: " + e.getMessage());
			BimBotsOutput bimBotsOutput = new BimBotsOutput("ERROR", errorNode.toString().getBytes(Charsets.UTF_8));
			return bimBotsOutput;
		}
	}

	private String getProjectSchema(ServiceInterface serviceInterface, SchemaName schema) throws IOException, UserException, ServiceException {
		if (schema == SchemaName.IFC_STEP) {
			// We need to determine the schema used by reading the header
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			byte[] initialBytes = ByteUtils.extractHead(bufferedInputStream, 4096);
			
			inputStream = bufferedInputStream;
			return serviceInterface.determineIfcVersion(initialBytes, false);
		} else if (schema == SchemaName.IFC_STEP_2X3TC1) {
			return "ifc2x3tc1";
		} else if (schema == SchemaName.IFC_JSON_4) {
			return "ifc4";
		}
		return null;
	}

	@Override
	public void run() {
		try {
			Thread.currentThread().setName("BIMbot [" + foundService.getName() + "]");
			BimBotsOutput bimBotsOutput = runBimBot();
			ObjectNode message = objectMapper.createObjectNode();
			message.put("topicId", topicId);
			message.put("type", "output");
			message.set("payload", bimBotsOutput.toJson());
			streamingSocketInterface.send(message);
			byte[] data = bimBotsOutput.getData();
			streamingSocketInterface.send(data, 0, data.length);
		} catch (Throwable e) {
			LOGGER.error("", e);
		}
	}
}