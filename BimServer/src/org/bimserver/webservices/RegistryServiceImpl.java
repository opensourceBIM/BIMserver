package org.bimserver.webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.endpoints.EndPoint;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.StorePackage;
import org.bimserver.notifications.ChangeProgressTopicOnProjectTopic;
import org.bimserver.notifications.ChangeProgressTopicOnRevisionTopic;
import org.bimserver.notifications.ChangeProgressTopicOnServerTopic;
import org.bimserver.notifications.NewRevisionOnSpecificProjectTopic;
import org.bimserver.notifications.NewRevisionOnSpecificProjectTopicKey;
import org.bimserver.notifications.ProgressOnRevisionTopic;
import org.bimserver.notifications.ProgressTopic;
import org.bimserver.notifications.TopicRegisterException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.RegistryInterface;

public class RegistryServiceImpl extends GenericServiceImpl implements RegistryInterface {
	public RegistryServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public void registerProgressHandler(Long topicId, Long endPointId) throws UserException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		if (endPoint == null) {
			throw new UserException("Endpoint with id " + endPointId + " not found");
		}
		ProgressTopic progressTopic = getBimServer().getNotificationsManager().getProgressTopic(topicId);
		if (progressTopic == null) {
			throw new UserException("Topic with id " + topicId + " not found");
		}
		try {
			progressTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			throw new UserException(e);
		}
	}
	
	@Override
	public void unregisterProgressHandler(Long topicId, Long endPointId) throws UserException, ServerException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		if (endPoint == null) {
			throw new UserException("Endpoint with id " + endPointId + " not found");
		}
		ProgressTopic progressTopic = getBimServer().getNotificationsManager().getProgressTopic(topicId);
		if (progressTopic == null) {
			throw new UserException("Topic with id " + topicId + " not found");
		}
		try {
			progressTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public void updateProgressTopic(Long topicId, SLongActionState state) throws UserException, ServerException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			getBimServer().getNotificationsManager().getProgressTopic(topicId).updateProgress(getBimServer().getSConverter().convertFromSObject(state, session));
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void registerNewRevisionOnSpecificProjectHandler(Long endPointId, Long poid) {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		NewRevisionOnSpecificProjectTopic newRevisionOnSpecificProjectTopic = getBimServer().getNotificationsManager().getOrCreateNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid));
		try {
			newRevisionOnSpecificProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void unregisterNewRevisionOnSpecificProjectHandler(Long endPointId, Long poid) throws ServerException, UserException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewRevisionOnSpecificProjectTopic(new NewRevisionOnSpecificProjectTopicKey(poid)).unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public Long registerProgressTopic(SProgressTopicType type, String description) throws UserException, ServerException {
		return getBimServer().getNotificationsManager().createProgressTopic(getCurrentUser().getOid(), type, description).getKey().getId();
	}

	@Override
	public Long registerProgressOnRevisionTopic(SProgressTopicType type, Long poid, Long roid, String description) throws UserException, ServerException {
		SUser currentUser = getCurrentUser();
		return getBimServer().getNotificationsManager().createProgressOnRevisionTopic(currentUser.getOid(), poid, roid, type, description).getKey().getId();
	}

	@Override
	public Long registerProgressOnProjectTopic(SProgressTopicType type, Long poid, String description) throws UserException, ServerException {
		return getBimServer().getNotificationsManager().createProgressOnProjectTopic(getCurrentUser().getOid(), poid, type, description).getKey().getId();
	}

	@Override
	public void unregisterProgressTopic(Long topicId) {
		getBimServer().getNotificationsManager().unregister(topicId);
	}

	@Override
	public void registerNewProjectHandler(Long endPointId) {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewProjectTopic().register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unregisterNewProjectHandler(Long endPointId) throws ServerException, UserException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewProjectTopic().unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public void registerNewUserHandler(Long endPointId) {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewUserTopic().register(endPoint);
		} catch (TopicRegisterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unregisterNewUserHandler(Long endPointId) throws ServerException, UserException {
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			getBimServer().getNotificationsManager().getNewUserTopic().unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public List<Long> getProgressTopicsOnProject(Long poid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession();
		try {
			List<Long> list = new ArrayList<Long>();
			Project project = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
			List<Long> revisionOids = new ArrayList<Long>();
			for (Revision revision : project.getRevisions()) {
				revisionOids.add(revision.getOid());
			}
			Set<ProgressTopic> progressOnProjectTopics = getBimServer().getNotificationsManager().getProgressOnProjectTopics(poid, revisionOids);
			if (progressOnProjectTopics != null) {
				for (ProgressTopic topic : progressOnProjectTopics) {
					list.add(topic.getKey().getId());
				}
			}
			return list;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Long> getProgressTopicsOnRevision(Long poid, Long roid) {
		List<Long> list = new ArrayList<Long>();
		for (ProgressOnRevisionTopic topic : getBimServer().getNotificationsManager().getProgressOnRevisionTopics(poid, roid)) {
			list.add(topic.getKey().getId());
		}
		return list;
	}
	
	@Override
	public List<Long> getProgressTopicsOnServer() {
		List<Long> list = new ArrayList<Long>();
		for (ProgressTopic topic : getBimServer().getNotificationsManager().getProgressOnServerTopics()) {
			list.add(topic.getKey().getId());
		}
		return list;
	}
	
	@Override
	public SLongActionState getProgress(Long topicId) throws UserException, ServerException {
		ProgressTopic progressTopic = getBimServer().getNotificationsManager().getProgressTopic(topicId);
		if (progressTopic != null) {
			return getBimServer().getSConverter().convertToSObject(progressTopic.getLastProgress());
		}
		return null;
	}
	
	@Override
	public void registerChangeProgressOnProject(Long endPointId, Long poid) throws ServerException, UserException {
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnProjectTopic(poid);
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}

	@Override
	public void registerChangeProgressOnServer(Long endPointId) throws ServerException, UserException {
		ChangeProgressTopicOnServerTopic changeProgressTopicOnServerTopic = getBimServer().getNotificationsManager().getChangeProgressTopicOnServerTopic();
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressTopicOnServerTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void unregisterChangeProgressOnServer(Long endPointId) throws ServerException, UserException {
		ChangeProgressTopicOnServerTopic changeProgressTopicOnServerTopic = getBimServer().getNotificationsManager().getChangeProgressTopicOnServerTopic();
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressTopicOnServerTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void registerChangeProgressOnRevision(Long endPointId, Long poid, Long roid) throws ServerException, UserException {
		ChangeProgressTopicOnRevisionTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnRevisionTopic(poid, roid);
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.register(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void unregisterChangeProgressOnProject(Long endPointId, Long poid) throws ServerException, UserException {
		ChangeProgressTopicOnProjectTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnProjectTopic(poid);
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
	
	@Override
	public void unregisterChangeProgressOnRevision(Long endPointId, Long poid, Long roid) throws ServerException, UserException {
		ChangeProgressTopicOnRevisionTopic changeProgressOnProjectTopic = getBimServer().getNotificationsManager().getChangeProgressOnRevisionTopic(poid, roid);
		EndPoint endPoint = getBimServer().getEndPointManager().get(endPointId);
		try {
			changeProgressOnProjectTopic.unregister(endPoint);
		} catch (TopicRegisterException e) {
			handleException(e);
		}
	}
}
