package org.bimserver.notifications;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import org.bimserver.BimServer;
import org.bimserver.client.Channel;
import org.bimserver.client.DirectChannel;
import org.bimserver.client.SimpleTokenHolder;
import org.bimserver.client.json.JsonChannel;
import org.bimserver.client.json.JsonSocketReflectorFactory;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.Service;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationsManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsManager.class);

	private final NewRevisionTopic newRevisionTopic = new NewRevisionTopic(this);
	private final NewProjectTopic newProjectTopic = new NewProjectTopic(this);
	private final NewUserTopic newUserTopic = new NewUserTopic(this);
	private final Map<NewExtendedDataOnRevisionTopicKey, NewExtendedDataOnRevisionTopic> newExtendedDataOnRevisionTopics = new HashMap<NewExtendedDataOnRevisionTopicKey, NewExtendedDataOnRevisionTopic>();
	private final Map<NewRevisionOnSpecificProjectTopicKey, NewRevisionOnSpecificProjectTopic> newRevisionOnSpecificProjectTopics = new HashMap<NewRevisionOnSpecificProjectTopicKey, NewRevisionOnSpecificProjectTopic>();

	// These are for keeping track of new/removed progress topics
	private final Map<ChangeProgressTopicOnProjectTopicKey, ChangeProgressTopicOnProjectTopic> changeProgressTopicOnProjectTopics = new HashMap<ChangeProgressTopicOnProjectTopicKey, ChangeProgressTopicOnProjectTopic>();
	private final Map<ChangeProgressTopicOnRevisionTopicKey, ChangeProgressTopicOnRevisionTopic> changeProgressTopicOnRevisionTopics = new HashMap<ChangeProgressTopicOnRevisionTopicKey, ChangeProgressTopicOnRevisionTopic>();
	private final ChangeProgressTopicOnServerTopic changeProgressTopicOnServerTopic = new ChangeProgressTopicOnServerTopic(this);

	// All progress topics have an id for easy referencing
	private final Map<Long, ProgressTopic> progressTopicsById = new HashMap<Long, ProgressTopic>();
	
	// These are for keeping track of actual progress on projects/revisions
	private final Map<ProgressOnRevisionTopicKey, Set<ProgressOnRevisionTopic>> progressOnRevisionTopics = new HashMap<ProgressOnRevisionTopicKey, Set<ProgressOnRevisionTopic>>();
	private final Map<ProgressOnProjectTopicKey, Set<ProgressOnProjectTopic>> progressOnProjectTopics = new HashMap<ProgressOnProjectTopicKey, Set<ProgressOnProjectTopic>>();

	private final JsonSocketReflectorFactory jsonSocketReflectorFactory;
	private final BimServer bimServer;
	private String url;
	private final NotificationsProcessor notificationsProcessor;

	public NotificationsManager(BimServer bimServer, JsonSocketReflectorFactory jsonSocketReflectorFactory) {
		this.jsonSocketReflectorFactory = jsonSocketReflectorFactory;
		this.bimServer = bimServer;
		notificationsProcessor = new NotificationsProcessor(bimServer);
		notificationsProcessor.start();
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}

	public void notify(Notification notification) {
		addToQueue(notification);
	}
	
	public void notify(SLogAction logAction) {
		addToQueue(new LogActionNotification(bimServer, logAction));
	}

	public void addToQueue(Notification notification) {
		notificationsProcessor.queue(notification);
	}
	
	public void init() {
		ServerSettings serverSettings = bimServer.getServerSettingsCache().getServerSettings();
		this.url = serverSettings.getSiteAddress() + "/json";
	}

	public Channel getChannel(Service service) throws ChannelConnectionException {
		switch (service.getNotificationProtocol()) {
		case JSON:
			JsonChannel jsonChannel = new JsonChannel(null, bimServer.getReflectorFactory(), jsonSocketReflectorFactory, service.getUrl() + "/json", bimServer.getServicesMap());
			jsonChannel.connect(new SimpleTokenHolder());
			return jsonChannel;
		case INTERNAL:
			DirectChannel directChannel = new DirectChannel(null, bimServer.getServiceFactory(), bimServer.getServicesMap());
			try {
				directChannel.connect();
			} catch (UserException e) {
				LOGGER.error("", e);
			}
			return directChannel;
		default: 
			LOGGER.error("Unimplemented AccessMethod: " + service.getNotificationProtocol());
			return null;
		}
	}
	
	public void shutdown() {
		notificationsProcessor.termintate();
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
	
	public NewExtendedDataOnRevisionTopic getOrCreateNewExtendedDataOnRevisionTopic(NewExtendedDataOnRevisionTopicKey key) {
		if (!newExtendedDataOnRevisionTopics.containsKey(key)) {
			newExtendedDataOnRevisionTopics.put(key, new NewExtendedDataOnRevisionTopic(this, key));
		}
		return newExtendedDataOnRevisionTopics.get(key);
	}
	
	public NewRevisionOnSpecificProjectTopic getOrCreateNewRevisionOnSpecificProjectTopic(NewRevisionOnSpecificProjectTopicKey key) {
		if (!newRevisionOnSpecificProjectTopics.containsKey(key)) {
			newRevisionOnSpecificProjectTopics.put(key, new NewRevisionOnSpecificProjectTopic(this, key));
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

	public synchronized ProgressTopic createProgressTopic(SProgressTopicType type, String description) {
		ProgressTopicKey key = new ProgressTopicKey();
		ProgressTopic topic = new ProgressTopic(this, key, type, description);
		progressTopicsById.put(key.getId(), topic);
		addToQueue(new NewProgressTopicOnServerNotification(bimServer, key.getId()));
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
		ProgressOnProjectTopic topic = new ProgressOnProjectTopic(this, key, poid, type, description);
		progressTopicsById.put(key.getId(), topic);
		topics.add(topic);
		addToQueue(new NewProgressTopicOnProjectNotification(bimServer, poid, key.getId()));
		return topic;
	}

	public ProgressOnRevisionTopic createProgressOnRevisionTopic(long poid, long roid, SProgressTopicType type, String description) {
		ProgressOnRevisionTopicKey key = new ProgressOnRevisionTopicKey(poid, roid);
		Set<ProgressOnRevisionTopic> topics = null;
		if (progressOnRevisionTopics.containsKey(key)) {
			topics = progressOnRevisionTopics.get(key);
		} else {
			topics = new HashSet<ProgressOnRevisionTopic>();
			progressOnRevisionTopics.put(key, topics);
		}
		ProgressOnRevisionTopic topic = new ProgressOnRevisionTopic(this, key, poid, roid, type, description);
		progressTopicsById.put(key.getId(), topic);
		topics.add(topic);
		addToQueue(new NewProgressTopicOnRevisionNotification(bimServer, poid, roid, key.getId()));
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

	public ChangeProgressTopicOnProjectTopic getChangeProgressOnProjectTopic(Long poid) {
		ChangeProgressTopicOnProjectTopicKey key = new ChangeProgressTopicOnProjectTopicKey(poid);
		ChangeProgressTopicOnProjectTopic topic = changeProgressTopicOnProjectTopics.get(key);
		if (topic == null) {
			topic = new ChangeProgressTopicOnProjectTopic(this, key);
			changeProgressTopicOnProjectTopics.put(key, topic);
		}
		return topic;
	}

	public ChangeProgressTopicOnServerTopic getChangeProgressTopicOnServerTopic() {
		return changeProgressTopicOnServerTopic;
	}
	
	public ChangeProgressTopicOnRevisionTopic getChangeProgressOnRevisionTopic(Long poid, Long roid) {
		ChangeProgressTopicOnRevisionTopicKey key = new ChangeProgressTopicOnRevisionTopicKey(poid, roid);
		ChangeProgressTopicOnRevisionTopic topic = changeProgressTopicOnRevisionTopics.get(key);
		if (topic == null) {
			topic = new ChangeProgressTopicOnRevisionTopic(this, key);
			changeProgressTopicOnRevisionTopics.put(key, topic);
		}
		return topic;
	}

	public NewExtendedDataOnRevisionTopic getNewExtendedDataOnRevisionTopic(NewExtendedDataOnRevisionTopicKey key) {
		return newExtendedDataOnRevisionTopics.get(key);
	}

	public void removeChangeProgressTopicOnProject(ChangeProgressTopicOnProjectTopicKey key) {
		this.changeProgressTopicOnProjectTopics.remove(key);
	}

	public void removeChangeProgressTopicOnRevision(ChangeProgressTopicOnRevisionTopicKey key) {
		this.changeProgressTopicOnRevisionTopics.remove(key);
	}

	public void removeNewExtendedDataOnRevisionTopic(NewExtendedDataOnRevisionTopicKey key) {
		this.newExtendedDataOnRevisionTopics.remove(key);
	}

	public void removeNewRevisionOnSpecificProjectTopic(NewRevisionOnSpecificProjectTopicKey key) {
		this.newRevisionOnSpecificProjectTopics.remove(key);
	}

	public void removeProgressTopic(ProgressTopicKey key) {
		if (key instanceof ProgressOnProjectTopicKey) {
			progressOnProjectTopics.remove((ProgressOnProjectTopicKey)key);
		} else if (key instanceof ProgressOnRevisionTopicKey) {
			progressOnRevisionTopics.remove((ProgressOnRevisionTopicKey)key);
		}
 		progressTopicsById.remove(key.getId());
	}
}