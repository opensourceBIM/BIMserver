package org.bimserver.demoplugins.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;

import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StringType;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UserTokenAuthentication;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.InputStreamDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloneService extends ServicePlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(CloneService.class);
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Service that will just store all models sent to it locally";
	}

	@Override
	public String getDefaultName() {
		return "Clone Service";
	}

	@Override
	public String getVersion() {
		return "0.1";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();
		
		PrimitiveDefinition stringType = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		stringType.setType(PrimitiveEnum.STRING);
		
		StringType defaultProjectName = StoreFactory.eINSTANCE.createStringType();
		defaultProjectName.setValue("");
		
		ParameterDefinition projectNameParameter = StoreFactory.eINSTANCE.createParameterDefinition();
		projectNameParameter.setName("projectName");
		projectNameParameter.setDescription("Name of the local project to put the revisions in");
		projectNameParameter.setRequired(true);
		projectNameParameter.setType(stringType);
		projectNameParameter.setDefaultValue(defaultProjectName);
		
		objectDefinition.getParameters().add(projectNameParameter);
		
		return objectDefinition;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getTitle() {
		return "Clone Service";
	}

	@Override
	public void register(final PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier(getClass().getName());
		serviceDescriptor.setName("Clone Service");
		serviceDescriptor.setDescription("Clone Service");
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				Date startDate = new Date();
				Long topicId = null;
				try {
					topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid,
							"Running Clone Service");
					SLongActionState state = new SLongActionState();
					state.setTitle("Clone Service");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);

					SSerializerPluginConfiguration stepSerializerRemote = bimServerClientInterface.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
					
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					bimServerClientInterface.download(roid, stepSerializerRemote.getOid(), outputStream);
					
					BimServerClientInterface localClient = getLocalBimServerClientInterface(new UserTokenAuthentication(userToken));

					PluginConfiguration pluginConfiguration = new org.bimserver.plugins.PluginConfiguration(settings);
					
					String localProjectName = pluginConfiguration.getString("projectName");
					
					List<SProject> projectsByName = localClient.getBimsie1ServiceInterface().getProjectsByName(localProjectName);
					if (projectsByName.isEmpty()) {
						throw new UserException("No project with name \"" + localProjectName + "\" was found");
					}
					SProject localProject = projectsByName.get(0);
					
					SDeserializerPluginConfiguration localDeserializer = localClient.getBimsie1ServiceInterface().getDeserializerByName("IfcStepDeserializer");
					localClient.getBimsie1ServiceInterface().checkin(localProject.getOid(), "Blaat", localDeserializer.getOid(), (long) outputStream.size(), "filename.ifc", new DataHandler(new InputStreamDataSource(new ByteArrayInputStream(outputStream.toByteArray()))), true);
				} catch (PublicInterfaceNotFoundException e) {
					LOGGER.error("", e);
				} catch (ServiceException e) {
					LOGGER.error("", e);
				} catch (ChannelConnectionException e) {
					LOGGER.error("", e);
				} finally {
					SLongActionState state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Clone Service");
					state.setState(SActionState.FINISHED);
					state.setStart(startDate);
					state.setEnd(new Date());
					try {
						bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
						bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
					} catch (PublicInterfaceNotFoundException e) {
						LOGGER.error("", e);
					}
				}
			}
		});
	}
}