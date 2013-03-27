package org.bimserver.demoplugins.service;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.Trigger;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public class DemoServicePlugin2 extends ServicePlugin {

	private boolean initialized;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return "Demo Service 2";
	}

	@Override
	public String getDefaultName() {
		return "Demo Service 2";
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
		return "Demo Service 2";
	}

	@Override
	public void register(PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier(getClass().getName());
		serviceDescriptor.setName("Demo Service 2");
		serviceDescriptor.setDescription("Demo Service 2");
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		registerNewRevisionHandler(serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(ServiceHolder serviceHolder, long poid, long roid, SObjectType settings) throws ServerException, UserException {
				try {
					Long topicId = serviceHolder.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running Demo Service");
					SLongActionState state = new SLongActionState();
					state.setTitle("Doing absolutely nothing...");
					state.setState(SActionState.STARTED);
					state.setProgress(-1);
					serviceHolder.getRegistry().updateProgressTopic(topicId, state);
					for (int i=0; i<100; i++) {
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					state = new SLongActionState();
					state.setProgress(100);
					state.setTitle("Done");
					state.setState(SActionState.FINISHED);
					serviceHolder.getRegistry().updateProgressTopic(topicId, state);
					
					serviceHolder.getRegistry().unregisterProgressTopic(topicId);
				} catch (PublicInterfaceNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}