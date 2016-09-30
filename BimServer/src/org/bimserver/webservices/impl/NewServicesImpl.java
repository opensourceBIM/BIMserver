package org.bimserver.webservices.impl;

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
import org.bimserver.webservices.ServiceMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewServicesImpl extends GenericServiceImpl implements NewServicesInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewServicesImpl.class);

	public NewServicesImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public List<SNewServiceDescriptor> listAllServiceDescriptors() throws ServerException, UserException {
		List<SNewServiceDescriptor> list = new ArrayList<>();
		SNewServiceDescriptor sNewServiceDescriptor = new SNewServiceDescriptor();
		sNewServiceDescriptor.setName("Generates a few statistics about model as CSV");
		sNewServiceDescriptor.setDescription("Test Service");
		sNewServiceDescriptor.setProvider("Test Service");
		sNewServiceDescriptor.getInputs().add("IFC_JSON_2x3TC1");
		sNewServiceDescriptor.getInputs().add("IFC_JSON_4");
		sNewServiceDescriptor.getOutputs().add("text/csv");
		sNewServiceDescriptor.setUrl("https://test.logic-labs.nl/stats.php");
		list.add(sNewServiceDescriptor);

		sNewServiceDescriptor = new SNewServiceDescriptor();
		sNewServiceDescriptor.setName("Fake clashdetection service");
		sNewServiceDescriptor.setDescription("Test Service 2");
		sNewServiceDescriptor.setProvider("Test Service 2");
		sNewServiceDescriptor.getInputs().add("IFC_STEP_2X3TC1");
		sNewServiceDescriptor.getInputs().add("IFC_STEP_4");
		sNewServiceDescriptor.getOutputs().add("BCF_1.0");
		sNewServiceDescriptor.getOutputs().add("BCF_2.0");
		sNewServiceDescriptor.setUrl("https://test.logic-labs.nl/clashdetection.php");
		list.add(sNewServiceDescriptor);

		sNewServiceDescriptor = new SNewServiceDescriptor();
		sNewServiceDescriptor.setName("Test Service 3");
		sNewServiceDescriptor.setDescription("Test Service 3");
		sNewServiceDescriptor.setProvider("Test Service 3");
		sNewServiceDescriptor.getInputs().add("DOES_NOT_EXIST");
		sNewServiceDescriptor.getOutputs().add("BCF_2.0");
		sNewServiceDescriptor.setUrl("https://test.logic-labs.nl/services.php");
		list.add(sNewServiceDescriptor);
		return list;
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