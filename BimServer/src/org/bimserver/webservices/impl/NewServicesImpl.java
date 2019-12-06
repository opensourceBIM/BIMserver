package org.bimserver.webservices.impl;

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

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.emf.Schema;
import org.bimserver.interfaces.objects.SFormatSerializerMap;
import org.bimserver.interfaces.objects.SNewServiceDescriptor;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.Project;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NewServicesInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.utils.NetUtils;
import org.bimserver.webservices.ServiceMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class NewServicesImpl extends GenericServiceImpl implements NewServicesInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewServicesImpl.class);

	public NewServicesImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public List<SNewServiceDescriptor> listAllServiceDescriptors() throws ServerException, UserException {
		// TODO cache results
		try {
			String data = NetUtils.getContent(new URL(getBimServer().getServerSettingsCache().getServerSettings().getServiceRepositoryUrl() + "/serviceproviders.json"), 5000);
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode servicesJson = objectMapper.readValue(data, ObjectNode.class);
			ArrayNode activeServices = (ArrayNode) servicesJson.get("active");
			List<SNewServiceDescriptor> list = Collections.synchronizedList(new ArrayList<>());
			ThreadPoolExecutor executor = new ThreadPoolExecutor(activeServices.size(), activeServices.size(), 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(activeServices.size()));
			for (JsonNode activeService : activeServices) {
				String providerListUrl = activeService.get("listUrl").asText();
				executor.submit(new Runnable(){

					@Override
					public void run() {
						try {
							String providerData = NetUtils.getContent(new URL(providerListUrl), 5000);
							ObjectNode provider = objectMapper.readValue(providerData, ObjectNode.class);
							
							ArrayNode arryaNode = (ArrayNode) provider.get("services");
							for (JsonNode jsonNode : arryaNode) {
								SNewServiceDescriptor serviceDescriptor = new SNewServiceDescriptor();
								
								if (jsonNode.has("oauth")) {
									ObjectNode oauth = (ObjectNode)jsonNode.get("oauth");
									serviceDescriptor.setRegisterUrl(oauth.get("registerUrl").asText());
									serviceDescriptor.setTokenUrl(oauth.get("tokenUrl").asText());
									serviceDescriptor.setAuthorizationUrl(oauth.get("authorizationUrl").asText());
								}
								serviceDescriptor.setOid(jsonNode.get("id").asLong());
								serviceDescriptor.setDescription(jsonNode.get("description").asText());
								serviceDescriptor.setName(jsonNode.get("name").asText());
								serviceDescriptor.setProvider(jsonNode.get("provider").asText());
								serviceDescriptor.setResourceUrl(jsonNode.get("resourceUrl").asText());
								ArrayNode inputs = (ArrayNode) jsonNode.get("inputs");
								ArrayNode outputs = (ArrayNode) jsonNode.get("outputs");
								for (JsonNode inputNode : inputs) {
									serviceDescriptor.getInputs().add(inputNode.asText());
								}
								for (JsonNode outputNode : outputs) {
									serviceDescriptor.getOutputs().add(outputNode.asText());
								}
								list.add(serviceDescriptor);
							}
						} catch (MalformedURLException e) {
							LOGGER.error("", e);
						} catch (ConnectException e) {
							// Host probably not up, no errors to be logged
						} catch (IOException e) {
							e.printStackTrace();
						}
					}});
			}
			executor.shutdown();
			executor.awaitTermination(10, TimeUnit.SECONDS);
			return list;
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new UserException(e);
		}
	}

	@Override
	public List<SFormatSerializerMap> listAvailableOutputFormats(Long poid) throws ServerException, UserException {
		Map<String, SFormatSerializerMap> outputs = new HashMap<>();
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			Project project = session.get(poid, OldQuery.getDefault());
			try {
				List<SSerializerPluginConfiguration> allSerializersForPoids = getServiceMap().get(PluginInterface.class).getAllSerializersForPoids(true, Collections.singleton(poid));
				for (SSerializerPluginConfiguration pluginConfiguration : allSerializersForPoids) {
					PluginDescriptor pluginDescriptor = session.get(pluginConfiguration.getPluginDescriptorId(), OldQuery.getDefault());
					Plugin plugin = getBimServer().getPluginManager().getPlugin(pluginDescriptor.getIdentifier(), true);
					String outputFormat = null;
					
					// TODO For now only streaming serializers
					if (plugin instanceof StreamingSerializerPlugin) {
						outputFormat = ((StreamingSerializerPlugin)plugin).getOutputFormat(Schema.valueOf(project.getSchema().toUpperCase()));
					}

					if (outputFormat != null) {
						SFormatSerializerMap map = outputs.get(outputFormat);
						if (map == null) {
							map = new SFormatSerializerMap();
							map.setFormat(outputFormat);
							outputs.put(outputFormat, map);
						}
						map.getSerializers().add(pluginConfiguration);
					}
				}
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			}
			return new ArrayList<>(outputs.values());
		} catch (BimserverDatabaseException e) {
			return handleException(e);
		}
	}
}