package org.bimserver.webservices.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.emf.Schema;
import org.bimserver.interfaces.objects.SFormatSerializerMap;
import org.bimserver.interfaces.objects.SNewServiceDescriptor;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.Project;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.serializers.SerializerPlugin;
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
		try {
			String data = NetUtils.getContent(new URL("https://raw.githubusercontent.com/opensourceBIM/BIMserver-Repository/master/servicesnew.json"), 5000);
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode servicesJson = objectMapper.readValue(data, ObjectNode.class);
			ArrayNode arryaNode = (ArrayNode) servicesJson.get("services");
			List<SNewServiceDescriptor> list = new ArrayList<>();
			for (JsonNode jsonNode : arryaNode) {
				SNewServiceDescriptor serviceDescriptor = new SNewServiceDescriptor();
				serviceDescriptor.setAuthorizationUrl(jsonNode.get("authorizationUrl").asText());
				serviceDescriptor.setDescription(jsonNode.get("description").asText());
				serviceDescriptor.setName(jsonNode.get("name").asText());
				serviceDescriptor.setProvider(jsonNode.get("provider").asText());
				serviceDescriptor.setRegisterUrl(jsonNode.get("registerUrl").asText());
				serviceDescriptor.setResourceUrl(jsonNode.get("resourceUrl").asText());
				serviceDescriptor.setTokenUrl(jsonNode.get("tokenUrl").asText());
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
			return list;
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new UserException(e);
		}
	}

	@Override
	public List<SFormatSerializerMap> listAvailableOutputFormats(Long poid) throws ServerException, UserException {
		Map<String, SFormatSerializerMap> outputs = new HashMap<>();
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			Project project = session.get(poid, OldQuery.getDefault());
			try {
				List<SSerializerPluginConfiguration> allSerializersForPoids = getServiceMap().get(PluginInterface.class).getAllSerializersForPoids(true, Collections.singleton(poid));
				for (SSerializerPluginConfiguration pluginConfiguration : allSerializersForPoids) {
					PluginDescriptor pluginDescriptor = session.get(pluginConfiguration.getPluginDescriptorId(), OldQuery.getDefault());
					Plugin plugin = getBimServer().getPluginManager().getPlugin(pluginDescriptor.getIdentifier(), true);
					String outputFormat = null;
					if (plugin instanceof SerializerPlugin) {
						outputFormat = ((SerializerPlugin)plugin).getOutputFormat(Schema.valueOf(project.getSchema().toUpperCase()));
					} else if (plugin instanceof StreamingSerializerPlugin) {
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