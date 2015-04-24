package org.bimserver.demoplugins.service;

import java.util.Date;

import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
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
import org.bimserver.plugins.services.BimServerClientException;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractModifyRevisionService extends ServicePlugin {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoServicePlugin1.class);
	private boolean initialized;
	private String name;
	private String description;

	public AbstractModifyRevisionService(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		super.init(pluginManager);
		initialized = true;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getDefaultName() {
		return name;
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
		return name;
	}

	public enum ProgressType {
		UNKNOWN,
		KNOWN
	}
	
	public abstract void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException, PublicInterfaceNotFoundException, BimServerClientException;
	public abstract ProgressType getProgressType();

	public class RunningService {
		private long topicId;
		private BimServerClientInterface bimServerClientInterface;
		private Date startDate;

		public RunningService(long topicId, BimServerClientInterface bimServerClientInterface) {
			this.startDate = new Date();
			this.topicId = topicId;
			this.bimServerClientInterface = bimServerClientInterface;
		}

		public Date getStartDate() {
			return startDate;
		}
		
		public void updateProgress(int progress) {
			SLongActionState state = new SLongActionState();
			state.setProgress(progress);
			state.setTitle(name);
			state.setState(SActionState.FINISHED);
			state.setStart(startDate);
			state.setEnd(new Date());
			try {
				bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
			} catch (UserException e) {
				LOGGER.error("", e);
			} catch (ServerException e) {
				LOGGER.error("", e);
			} catch (PublicInterfaceNotFoundException e) {
				LOGGER.error("", e);
			}
		}
	}
	
	@Override
	public void register(long uoid, SInternalServicePluginConfiguration internalService, PluginConfiguration pluginConfiguration) {
		System.out.println(internalService.getOid());
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier("" + internalService.getOid());
		serviceDescriptor.setName(name);
		serviceDescriptor.setDescription(description);
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		serviceDescriptor.setWriteRevision(true);
		serviceDescriptor.setReadRevision(true);
		registerNewRevisionHandler(uoid, serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running " + name);
					RunningService runningService = new RunningService(topicId, bimServerClientInterface);
					try {
						SLongActionState state = new SLongActionState();
						state.setProgress(getProgressType() == ProgressType.KNOWN ? 0 : -1);
						state.setTitle(name);
						state.setState(SActionState.STARTED);
						state.setStart(runningService.getStartDate());
						bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
						
						AbstractModifyRevisionService.this.newRevision(runningService, bimServerClientInterface, poid, roid, userToken, soid, settings);
						
						state = new SLongActionState();
						state.setProgress(100);
						state.setTitle(name);
						state.setState(SActionState.FINISHED);
						state.setStart(runningService.getStartDate());
						state.setEnd(new Date());
						bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					} catch (BimServerClientException e) {
						LOGGER.error("", e);
					} finally {
						bimServerClientInterface.getRegistry().unregisterProgressTopic(topicId);
					}
				} catch (PublicInterfaceNotFoundException e) {
					LOGGER.error("", e);
				}
			}
		});
	}

	@Override
	public void unregister(SInternalServicePluginConfiguration internalService) {
		// TODO
	}
}
