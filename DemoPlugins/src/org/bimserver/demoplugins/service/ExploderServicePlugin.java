package org.bimserver.demoplugins.service;
import java.util.Date;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExploderServicePlugin extends ServicePlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExploderServicePlugin.class);
	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "Exploder";
	}

	@Override
	public String getDefaultName() {
		return "Exploder";
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
		return "Exploder";
	}

	@Override
	public void register(PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier(getClass().getName());
		serviceDescriptor.setName("Exploder");
		serviceDescriptor.setDescription("Exploder");
		serviceDescriptor.setWriteRevision(true);
		serviceDescriptor.setReadRevision(true);
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Date startDate = new Date();
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running Exploder");

					SLongActionState state = new SLongActionState();
					state.setTitle("Exploder");
					state.setState(SActionState.STARTED);
					state.setProgress(0);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					IfcModelInterface model = bimServerClientInterface.getModel(poid, roid, false);

					long total = 0;
					int calls = 0;
					int c = 0;
					List<IfcCartesianPoint> cartesianPoints = model.getAllWithSubTypes(IfcCartesianPoint.class);
					for (IfcCartesianPoint ifcCartesianPoint : cartesianPoints) {
						EList<Double> coordinates = ifcCartesianPoint.getCoordinates();
						for (int i=0; i<coordinates.size(); i++) {
							long s = System.nanoTime();
							coordinates.set(i, coordinates.get(i) * 2);
							long e = System.nanoTime();
							calls++;
							total += (e - s);
						}
						
						state = new SLongActionState();
						state.setTitle("Exploder");
						state.setState(SActionState.STARTED);
						state.setProgress((int)((double)c++ / cartesianPoints.size() * 50.0));
						state.setStart(startDate);
						bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					}
					System.out.println("Nr Calls: " + calls);
					System.out.println("Total Time (ms): " + total / 1000000);
					System.out.println("Avg/Call (ms): " + (total / 1000000) / calls);

					state = new SLongActionState();
					state.setTitle("Exploder");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					state.setStart(startDate);
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					model.commit("Exploded model");
					
					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Exploder");
					state.setState(SActionState.FINISHED);
					state.setStart(startDate);
					state.setEnd(new Date());
					bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					
					bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		});
	}
}