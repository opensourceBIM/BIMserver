package org.bimserver.demoplugins.service.planner;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Set;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StringType;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.services.AbstractAddExtendedDataService;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPlanningConsultService extends AbstractAddExtendedDataService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPlanningConsultService.class);
	
	public AbstractPlanningConsultService(String name, String description, String namespace) {
		super(name, description, namespace);
	}

	protected abstract void createExtendedData(Planner planner, IfcModelInterface model, BimServerClientInterface bimServerClientInterface, long roid);
	
	@Override
	public void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException, PublicInterfaceNotFoundException, BimServerClientException {
		try {
			SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
			IfcModelInterface model = bimServerClientInterface.getModel(project, roid, true, false, false);

			byte[] eventLogBytes = runningService.getPluginConfiguration().getByteArray("EventLog");

			PluginConfiguration pluginConfiguration = new org.bimserver.plugins.PluginConfiguration(settings);

			String materialType = pluginConfiguration.getString("material");

			Planner planner = new Planner(materialType);
			if (eventLogBytes != null) {
				Set<String> materialAggregators = new HashSet<>();

				for (int i = 1; i <= 5; i++) {
					materialAggregators.add(pluginConfiguration.getString("materialaggregator" + i));
				}

				EventLog eventLog = new EventLog(new ByteArrayInputStream(eventLogBytes), materialAggregators);
				planner.feedTrainingData(eventLog);
				planner.analyze(materialAggregators);
			}

			createExtendedData(planner, model, bimServerClientInterface, roid);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();
		
		PrimitiveDefinition typeDefinition = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		typeDefinition.setType(PrimitiveEnum.BYTE_ARRAY);
		
		PrimitiveDefinition stringType = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		stringType.setType(PrimitiveEnum.STRING);
		
		ParameterDefinition eventlog = StoreFactory.eINSTANCE.createParameterDefinition();
		eventlog.setName("EventLog");
		eventlog.setDescription("Upload an eventlog here that will be used to come up with a planning advice");
		eventlog.setType(typeDefinition);

		StringType nlsfbDefaultValue = StoreFactory.eINSTANCE.createStringType();
		nlsfbDefaultValue.setValue("[ArchiCADProperties]Layer");

		StringType materialDefaultValue = StoreFactory.eINSTANCE.createStringType();
		materialDefaultValue.setValue("[ArchiCADProperties]Building Material / Composite / Profile / Fill");
		
		ParameterDefinition nlsfb = StoreFactory.eINSTANCE.createParameterDefinition();
		nlsfb.setName("nlsfb");
		nlsfb.setDefaultValue(nlsfbDefaultValue);
		nlsfb.setType(stringType);

		ParameterDefinition material = StoreFactory.eINSTANCE.createParameterDefinition();
		material.setName("material");
		material.setDefaultValue(materialDefaultValue);
		material.setType(stringType);
		
		objectDefinition.getParameters().add(eventlog);

		objectDefinition.getParameters().add(nlsfb);
		objectDefinition.getParameters().add(material);
		
		for (int i=1; i<=5; i++) {
			ParameterDefinition materialMatching = StoreFactory.eINSTANCE.createParameterDefinition();
			materialMatching.setName("materialaggregator" + i);
			materialMatching.setDescription("A string that is used to aggregate materials by prefixing/postfixing with a wildcard");
			materialMatching.setType(stringType);
			objectDefinition.getParameters().add(materialMatching);
		}

		return objectDefinition;
	}

}
