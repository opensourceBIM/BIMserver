package org.bimserver.webservices;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.interfaces.objects.SImmediateNotificationResult;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.webservices.authorization.Authorization;

public class NotificationImpl implements NotificationInterface {

	private BimServer bimServer;
	private Authorization authorization;

	public NotificationImpl(BimServer bimServer, Authorization authorization) {
		this.bimServer = bimServer;
		this.authorization = authorization;
	}

	@Override
	public SImmediateNotificationResult newLogAction(String uuid, SLogAction logAction, String serviceIdentifier, String profileIdentifier, String token, String apiUrl) throws UserException, ServerException {
		return bimServer.getNotificationsManager().notify(logAction, serviceIdentifier, profileIdentifier, token, apiUrl);
	}

	@Override
	public void progress(Long topicId, SLongActionState state) throws UserException, ServerException {
	}

	@Override
	public List<SProfileDescriptor> getPublicProfiles(String serviceIdentifier) throws UserException, ServerException {
		return new ArrayList<SProfileDescriptor>();
	}

	@Override
	public List<SProfileDescriptor> getPrivateProfiles(String serviceIdentifier, String token) throws UserException, ServerException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		List<SProfileDescriptor> descriptors = new ArrayList<SProfileDescriptor>();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Token(), new StringLiteral(token));
			User user = session.querySingle(condition, User.class, false, null);
			if (user != null) {
				for (InternalServicePluginConfiguration internalServicePluginConfiguration : user.getUserSettings().getServices()) {
					if (internalServicePluginConfiguration.getClassName().equals(serviceIdentifier)) {
						SProfileDescriptor sProfileDescriptor = new SProfileDescriptor();
						descriptors.add(sProfileDescriptor);
						
						sProfileDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
						sProfileDescriptor.setName(internalServicePluginConfiguration.getName());
						sProfileDescriptor.setDescription(internalServicePluginConfiguration.getDescription());
						sProfileDescriptor.setPublicProfile(false);
					}
				}
			}
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return descriptors;
	}

	@Override
	public SServiceDescriptor getService(String name) throws UserException, ServerException {
		return null;
	}

	@Override
	public void setToken(String token) throws ServerException, UserException {
	}

	@Override
	public String getCurrentToken() throws ServerException, UserException {
		return null;
	}
}