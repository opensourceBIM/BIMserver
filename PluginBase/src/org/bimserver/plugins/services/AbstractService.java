package org.bimserver.plugins.services;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractService extends ServicePlugin {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);
	private String name;
	private PluginContext pluginContext;

	public AbstractService(String title) {
		this.name = title;
	}
	
	@Override
	public void init(PluginContext pluginContext) throws PluginException {
		this.pluginContext = pluginContext;
		super.init(pluginContext);
	}

	public PluginContext getPluginContext() {
		return pluginContext;
	}
	
	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}

	@Override
	public String getTitle() {
		return name;
	}

	public enum ProgressType {
		UNKNOWN,
		KNOWN
	}
	
	/**
	 * This method gets called when there is a new revision
	 * 
	 * @param runningService A reference to the RunningService, you can use it to update the progress if you know it
	 * @param bimServerClientInterface A client with the proper authorization on this or a remote BIMserver to fetch the revision, and write extended data to
	 * @param poid ProjectID of the project
	 * @param roid RevisionID of the new revision
	 * @param userToken Optional token, unused at the moment
	 * @param soid ServiceID
	 * @param settings Optional settings a user might have given in the InternalService settings
	 * @throws Exception 
	 */
	public abstract void newRevision(RunningService runningService, BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws Exception;

	/**
	 * Should return whether this service can report progress (as a percentage) or not
	 * @return ProgressType.UNKNOWN when the progress is not known, or KNOWN when it is
	 */
	public ProgressType getProgressType() {
		return ProgressType.UNKNOWN;
	}

	public class RunningService {
		private long topicId;
		private BimServerClientInterface bimServerClientInterface;
		private Date startDate;
		private PluginConfiguration pluginConfiguration;

		public RunningService(long topicId, BimServerClientInterface bimServerClientInterface, PluginConfiguration pluginConfiguration) {
			this.pluginConfiguration = pluginConfiguration;
			this.startDate = new Date();
			this.topicId = topicId;
			this.bimServerClientInterface = bimServerClientInterface;
		}
		
		public PluginConfiguration getPluginConfiguration() {
			return pluginConfiguration;
		}

		public Date getStartDate() {
			return startDate;
		}
		
		/**
		 * Update progress
		 * @param progress Between 0 and 100 inclusive
		 */
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
	
	public abstract void addRequiredRights(ServiceDescriptor serviceDescriptor);
	
	@Override
	public void register(long uoid, SInternalServicePluginConfiguration internalService, final PluginConfiguration pluginConfiguration) {
		ServiceDescriptor serviceDescriptor = StoreFactory.eINSTANCE.createServiceDescriptor();
		serviceDescriptor.setProviderName("BIMserver");
		serviceDescriptor.setIdentifier("" + internalService.getOid());
		serviceDescriptor.setName(name);
		serviceDescriptor.setNotificationProtocol(AccessMethod.INTERNAL);
		serviceDescriptor.setTrigger(Trigger.NEW_REVISION);
		addRequiredRights(serviceDescriptor);
		serviceDescriptor.setReadRevision(true);
		registerNewRevisionHandler(uoid, serviceDescriptor, new NewRevisionHandler() {
			@Override
			public void newRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, String userToken, long soid, SObjectType settings) throws ServerException, UserException {
				try {
					Long topicId = bimServerClientInterface.getRegistry().registerProgressOnRevisionTopic(SProgressTopicType.RUNNING_SERVICE, poid, roid, "Running " + name);
					RunningService runningService = new RunningService(topicId, bimServerClientInterface, pluginConfiguration);
					try {
						SLongActionState state = new SLongActionState();
						state.setProgress(getProgressType() == ProgressType.KNOWN ? 0 : -1);
						state.setTitle(name);
						state.setState(SActionState.STARTED);
						state.setStart(runningService.getStartDate());
						bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
						
						AbstractService.this.newRevision(runningService, bimServerClientInterface, poid, roid, userToken, soid, settings);
						
						state = new SLongActionState();
						state.setProgress(100);
						state.setTitle(name);
						state.setState(SActionState.FINISHED);
						state.setStart(runningService.getStartDate());
						state.setEnd(new Date());
						bimServerClientInterface.getRegistry().updateProgressTopic(topicId, state);
					} catch (BimServerClientException e) {
						LOGGER.error("", e);
					} catch (Exception e) {
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