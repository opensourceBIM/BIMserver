package org.bimserver.demoplugins.service;

import java.util.Date;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceInvadersService extends ServicePlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpaceInvadersService.class);
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "Service that will invade all spaces";
	}

	@Override
	public String getDefaultName() {
		return "Space Invaders Service";
	}

	@Override
	public String getVersion() {
		return "0.1";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getTitle() {
		return "Space Invaders Service";
	}

	@Override
	public void register(final PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier(getClass().getName());
		serviceDescriptor.setName("Space Invaders Service");
		serviceDescriptor.setDescription("Space Invaders Service");
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running Space Invaders Service");
					SLongActionState state = new SLongActionState();
					state.setTitle("Space Invaders Service");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);

//					SSerializerPluginConfiguration stepSerializerRemote = bimServerClientInterface.getBimsie1ServiceInterface().getSerializerByContentType("application/ifc");
					
					try {
						IfcModelInterface model = bimServerClientInterface.getModel(poid, roid, true);
						for (IfcSpace ifcSpace : model.getAllWithSubTypes(IfcSpace.class)) {
//							GeometryInfo geometry = ifcSpace.getGeometry();
							bimServerClientInterface.getGeometry(roid, ifcSpace);
						}
					} catch (BimServerClientException e) {
						e.printStackTrace();
					}
					
					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Space Invaders Service");
					state.setState(SActionState.FINISHED);
					state.setStart(startDate);
					state.setEnd(new Date());
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);

					bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
				} catch (PublicInterfaceNotFoundException e) {
					LOGGER.error("", e);
				} catch (ServiceException e) {
					LOGGER.error("", e);
				}
			}
		});
	}
}