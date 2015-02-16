package org.bimserver.demoplugins.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
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
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.LoggerFactory;

public class GuidFixerService extends ServicePlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "GUID fixer";
	}

	@Override
	public String getDefaultName() {
		return "GUID fixer";
	}

	@Override
	public String getVersion() {
		return "1.0";
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
		return "GUID fixer";
	}

	@Override
	public void register(long uoid, SInternalServicePluginConfiguration internalServicePluginConfiguration, PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
		serviceDescriptor.setName("GUID fixer");
		serviceDescriptor.setDescription("This service will make sure no double GUIDs exist in the model. This is done by appending an incrementing number.");
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setWriteRevision(true);
		registerNewRevisionHandler(uoid, serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running GUID fixer");
					
					SLongActionState state = new SLongActionState();
					state.setTitle("GUID fixer");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);

					SProject project = bimServerClientInterface.getBimsie1ServiceInterface().getProjectByPoid(poid);
					IfcModelInterface model = bimServerClientInterface.getModel(project, roid, false, false);
					Map<String, List<IfcRoot>> guids = new HashMap<String, List<IfcRoot>>();
					int fixed = 0;
					// Iterate over all objects that can have a GUID
					for (IfcRoot ifcRoot : model.getAllWithSubTypes(IfcRoot.class)) {
						if (ifcRoot.getGlobalId() != null) {
							if (!guids.containsKey(ifcRoot.getGlobalId())) {
								guids.put(ifcRoot.getGlobalId(), new ArrayList<IfcRoot>());
							}
							guids.get(ifcRoot.getGlobalId()).add(ifcRoot);
						}
					}
					for (String guid : guids.keySet()) {
						List<IfcRoot> list = guids.get(guid);
						if (list.size() > 1) {
							int c = 1;
							for (int i=1; i<list.size(); i++) {
								String newGuid = guid + "." + c;
								while (guids.containsKey(newGuid)) {
									c++;
									newGuid = guid + "." + c;
								}
								fixed++;
								list.get(i).setGlobalId(newGuid);
							}
						}
					}
					if (fixed > 0) {
						model.commit("Fixed " + fixed + " GUIDs");
					}

					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("GUID fixer");
					state.setState(SActionState.FINISHED);
					state.setStart(startDate);
					state.setEnd(new Date());
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
				} catch (PublicInterfaceNotFoundException e) {
					LoggerFactory.getLogger(GuidFixerService.class).error("", e);
				} catch (BimServerClientException e) {
					LoggerFactory.getLogger(GuidFixerService.class).error("", e);
				}
			}
		});
	}

	@Override
	public void unregister(SInternalServicePluginConfiguration internalService) {
	}
}