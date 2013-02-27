package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.bimserver.BimServer;
import org.bimserver.client.ChannelConnectionException;
import org.bimserver.client.JsonChannel;
import org.bimserver.client.JsonSocketReflectorFactory;
import org.bimserver.client.SimpleTokenHolder;
import org.bimserver.client.channels.Channel;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.plugins.NotificationsManagerInterface;
import org.bimserver.plugins.services.NewRevisionHandler;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterfaceAdaptor;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsManager extends Thread implements NotificationsManagerInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);

	private final NewRevisionTopic newRevisionTopic = new NewRevisionTopic();
	private final NewProjectTopic newProjectTopic = new NewProjectTopic();
	private final NewUserTopic newUserTopic = new NewUserTopic();
	private final Map<NewRevisionOnSpecificProjectTopicKey, NewRevisionOnSpecificProjectTopic> newRevisionOnSpecificProjectTopics = new HashMap<NewRevisionOnSpecificProjectTopicKey, NewRevisionOnSpecificProjectTopic>();
	private final Map<Long, ProgressTopic> progressTopicsById = new HashMap<Long, ProgressTopic>();
	private final Map<ProgressOnRevisionTopicKey, Set<ProgressOnRevisionTopic>> progressOnRevisionTopics = new HashMap<ProgressOnRevisionTopicKey, Set<ProgressOnRevisionTopic>>();
	private final Map<ProgressOnProjectTopicKey, Set<ProgressOnProjectTopic>> progressOnProjectTopics = new HashMap<ProgressOnProjectTopicKey, Set<ProgressOnProjectTopic>>();
	private final BlockingQueue<Notification> queue = new ArrayBlockingQueue<Notification>(10000);
	private final Map<String, ServiceDescriptor> internalServices = new HashMap<String, ServiceDescriptor>();
	private final Map<String, RemoteServiceInterface> internalRemoteServiceInterfaces = new HashMap<String, RemoteServiceInterface>();
	private final JsonSocketReflectorFactory jsonSocketReflectorFactory;
	private final BimServer bimServer;
	private volatile boolean running;
	private String url;

	public NotificationsManager(BimServer bimServer, JsonSocketReflectorFactory jsonSocketReflectorFactory) {
		setName("NotificationsManager");
		this.jsonSocketReflectorFactory = jsonSocketReflectorFactory;
		this.bimServer = bimServer;
	}

	public void notify(Notification notification) {
		queue.add(notification);
	}
	
	public void notify(SLogAction logAction) {
		queue.add(new LogActionNotification(logAction));
	}

	@Override
	public void run() {
		running = true;
		try {
			while (running) {
				try {
					Notification notification = queue.take();
					DatabaseSession session = bimServer.getDatabase().createSession();
					try {
						notification.process(bimServer, session, this);
					} finally {
						session.close();
					}
				} catch (InterruptedException e) {
					throw e;
				} catch (Exception e) {
					LOGGER.error("", e);
				}
			}
		} catch (InterruptedException e) {
			if (running) {
				LOGGER.error("", e);
			}
		}
	}

	public void init() {
		ServerSettings serverSettings = bimServer.getServerSettingsCache().getServerSettings();
		this.url = serverSettings.getSiteAddress() + "/json";
		for (String s : internalServices.keySet()) {
			internalServices.get(s).setUrl(url);
		}
	}

	public Channel getChannel(Service service) throws ChannelConnectionException {
		if (service.getInternalService() != null) {
			// Overrule definition
			return new InternalChannel(internalRemoteServiceInterfaces.get(service.getServiceIdentifier()));
		}
		switch (service.getNotificationProtocol()) {
		case JSON:
			JsonChannel jsonChannel = new JsonChannel(bimServer.getReflectorFactory(), jsonSocketReflectorFactory, service.getUrl());
			jsonChannel.connect(new SimpleTokenHolder());
			return jsonChannel;
		case INTERNAL:
			return new InternalChannel(internalRemoteServiceInterfaces.get(service.getServiceIdentifier()));
		default: 
			LOGGER.error("Unimplemented AccessMethod: " + service.getNotificationProtocol());
			return null;
		}
	}
	
	public void shutdown() {
		running = false;
		this.interrupt();
	}

	@Override
	public void register(ServiceDescriptor serviceDescriptor, RemoteServiceInterface remoteServiceInterface) {
		serviceDescriptor.setUrl(url);
		internalServices.put(serviceDescriptor.getName(), serviceDescriptor);
		internalRemoteServiceInterfaces.put(serviceDescriptor.getIdentifier(), remoteServiceInterface);
	}
	
	public Map<String, ServiceDescriptor> getInternalServices() {
		return internalServices;
	}

	@Override
	public void registerInternalNewRevisionHandler(ServiceDescriptor serviceDescriptor, final NewRevisionHandler newRevisionHandler) {
		register(serviceDescriptor, new RemoteServiceInterfaceAdaptor(){
			@Override
			public void newRevision(Long poid, Long roid, String serviceIdentifier, String profileIdentifier, String token, String apiUrl) throws UserException, ServerException {
				InternalChannel internalChannel = new InternalChannel(internalRemoteServiceInterfaces.get(serviceIdentifier));
				ServiceInterface serviceInterfaceImpl = bimServer.getServiceFactory().getService(ServiceInterface.class, token, AccessMethod.JSON);
				internalChannel.addServiceInterface(ServiceInterface.class, serviceInterfaceImpl);
				ServiceInterface serviceInterface = internalChannel.getServiceInterface();
				SService service = serviceInterface.getService(Long.parseLong(profileIdentifier));
				SObjectType settings = serviceInterface.getPluginSettings(service.getInternalServiceId());
				newRevisionHandler.newRevision(serviceInterface, poid, roid, settings);
			}
		});
	}
	
	public NewRevisionTopic getNewRevisionTopic() {
		return newRevisionTopic;
	}
	
	public NewProjectTopic getNewProjectTopic() {
		return newProjectTopic;
	}
	
	public NewRevisionOnSpecificProjectTopic getNewRevisionOnSpecificProjectTopic(NewRevisionOnSpecificProjectTopicKey key) {
		return newRevisionOnSpecificProjectTopics.get(key);
	}
	
	public NewRevisionOnSpecificProjectTopic getOrCreateNewRevisionOnSpecificProjectTopic(NewRevisionOnSpecificProjectTopicKey key) {
		if (!newRevisionOnSpecificProjectTopics.containsKey(key)) {
			newRevisionOnSpecificProjectTopics.put(key, new NewRevisionOnSpecificProjectTopic(key.getPoid()));
		}
		return newRevisionOnSpecificProjectTopics.get(key);
	}

	public ProgressTopic getProgressTopic(long topicId) {
		return progressTopicsById.get(topicId);
	}
	
//	public ProgressTopicKey register(ProgressTopic topic) {
//		ProgressTopicKey key = new ProgressTopicKey();
//		progressTopicsById.put(key.getId(), topic);
//		return key;
//	}
//
//	public ProgressOnRevisionTopicKey register(ProgressOnRevisionTopic topic) {
//		ProgressOnRevisionTopicKey key = new ProgressOnRevisionTopicKey(topic.getPoid(), topic.getRoid());
//		progressOnRevisionTopics.put(key, topic);
//		return key;
//	}
	
	public void unregister(long topicId) {
//		ProgressTopic topic = progressTopicsById.get(topicId);
//		if (topic != null) {
//			topic.close();
//			progressTopicsById.remove(topicId);
//		}
	}
	
	public NewUserTopic getNewUserTopic() {
		return newUserTopic;
	}

	public String getSiteAddress() {
		return url;
	}

	public ProgressTopic createProgressTopic(long uoid, SProgressTopicType type, String description) {
		ProgressTopicKey key = new ProgressTopicKey();
		ProgressTopic topic = new ProgressTopic(key, uoid, type, description);
		progressTopicsById.put(key.getId(), topic);
		return topic;
	}

	public ProgressOnProjectTopic createProgressOnProjectTopic(long uoid, long poid, SProgressTopicType type, String description) {
		ProgressOnProjectTopicKey key = new ProgressOnProjectTopicKey(poid);
		Set<ProgressOnProjectTopic> topics = null;
		if (progressOnProjectTopics.containsKey(key)) {
			topics = progressOnProjectTopics.get(key);
		} else {
			topics = new HashSet<ProgressOnProjectTopic>();
			progressOnProjectTopics.put(key, topics);
		}
		ProgressOnProjectTopic topic = new ProgressOnProjectTopic(key, uoid, poid, type, description);
		progressTopicsById.put(key.getId(), topic);
		topics.add(topic);
		return topic;
	}

	public ProgressOnRevisionTopic createProgressOnRevisionTopic(long uoid, long poid, long roid, SProgressTopicType type, String description) {
		ProgressOnRevisionTopicKey key = new ProgressOnRevisionTopicKey(poid, roid);
		Set<ProgressOnRevisionTopic> topics = null;
		if (progressOnRevisionTopics.containsKey(key)) {
			topics = progressOnRevisionTopics.get(key);
		} else {
			topics = new HashSet<ProgressOnRevisionTopic>();
			progressOnRevisionTopics.put(key, topics);
		}
		ProgressOnRevisionTopic topic = new ProgressOnRevisionTopic(key, uoid, poid, roid, type, description);
		progressTopicsById.put(key.getId(), topic);
		topics.add(topic);
		return topic;
	}
	
	public Set<ProgressTopic> getProgressOnProjectTopics(long poid, List<Long> roids) {
		Set<ProgressTopic> topics = new HashSet<ProgressTopic>();
		Set<ProgressOnProjectTopic> set = progressOnProjectTopics.get(new ProgressOnProjectTopicKey(poid));
		if (set != null) {
			for (ProgressOnProjectTopic progressOnProjectTopic : set) {
				topics.add(progressOnProjectTopic);
			}
		}
		for (Long roid : roids) {
			Set<ProgressOnRevisionTopic> progressOnRevisionTopics2 = getProgressOnRevisionTopics(poid, roid);
			if (progressOnRevisionTopics2 != null) {
				topics.addAll(progressOnRevisionTopics2);
			}
		}
		return topics;
	}

	public Set<ProgressOnRevisionTopic> getProgressOnRevisionTopics(long poid, long roid) {
		return progressOnRevisionTopics.get(new ProgressOnRevisionTopicKey(poid, roid));
	}

	public Collection<ProgressTopic> getProgressOnServerTopics() {
		// TODO filter by rights
		return progressTopicsById.values();
	}
}