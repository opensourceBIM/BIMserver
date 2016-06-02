package org.bimserver.webservices.impl;

import java.util.List;

import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.ext.dynamicreg.client.OAuthRegistrationClient;
import org.apache.oltu.oauth2.ext.dynamicreg.client.request.OAuthClientRegistrationRequest;
import org.apache.oltu.oauth2.ext.dynamicreg.client.response.OAuthClientRegistrationResponse;
import org.apache.oltu.oauth2.ext.dynamicreg.common.OAuthRegistration;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.interfaces.objects.SOAuthAuthorizationCode;
import org.bimserver.interfaces.objects.SOAuthServer;
import org.bimserver.models.store.OAuthAuthorizationCode;
import org.bimserver.models.store.OAuthServer;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.OAuthInterface;
import org.bimserver.webservices.ServiceMap;

public class OAuthServiceImpl extends GenericServiceImpl implements OAuthInterface {

	public OAuthServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public Long registerApplication(String registrationEndpoint, String apiUrl) throws UserException, ServerException {
        try {
        	try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
        		OAuthServer oAuthServer = session.querySingle(StorePackage.eINSTANCE.getOAuthServer_RegistrationEndpoint(), registrationEndpoint);
        		
        		if (oAuthServer != null) {
        			return oAuthServer.getOid();
        		}
        		
        		ServerSettings serverSettings = getBimServer().getServerSettingsCache().getServerSettings();
        		
				OAuthClientRequest request = OAuthClientRegistrationRequest
				    .location(registrationEndpoint, OAuthRegistration.Type.PUSH)
				    .setName(serverSettings.getName())
				    .setUrl(getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/oauth")
				    .setDescription(serverSettings.getDescription())
				    .setIcon(serverSettings.getIcon())
				    .setRedirectURL(getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/oauth")
				    .buildJSONMessage();
				OAuthRegistrationClient oauthclient = new OAuthRegistrationClient(new URLConnectionClient());
				OAuthClientRegistrationResponse response = oauthclient.clientInfo(request);

				oAuthServer = session.create(OAuthServer.class);
				oAuthServer.setApiUrl(apiUrl);
				oAuthServer.setClientId(response.getClientId());
				oAuthServer.setClientSecret(response.getClientSecret());
				oAuthServer.setIssuedAt(response.getIssuedAt());
				oAuthServer.setExpiresIn(response.getExpiresIn());
				oAuthServer.setRegistrationEndpoint(registrationEndpoint);
				
				session.commit();
				return oAuthServer.getOid();
			}
		} catch (Exception e) {
			return handleException(e);
		}
	}
	
	public String generateForwardUrl(String registrationEndpoint, String authorizeUrl, String returnUrl) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			OAuthServer oAuthServer = session.querySingle(StorePackage.eINSTANCE.getOAuthServer_RegistrationEndpoint(), registrationEndpoint);
			if (oAuthServer == null) {
				throw new UserException("Application not registered");
			}
			OAuthClientRequest request2 = OAuthClientRequest.authorizationLocation(authorizeUrl).setClientId(oAuthServer.getClientId()).setRedirectURI(returnUrl).setResponseType(ResponseType.CODE.toString()).setState("state").buildQueryMessage();
			return request2.getLocationUri();
		} catch (Exception e) {
			return handleException(e);
		}
	}
	
	@Override
	public List<SOAuthServer> listRegisteredServers() throws ServerException, UserException {
    	try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
    		List<OAuthServer> allOfType = session.getAllOfType(StorePackage.eINSTANCE.getOAuthServer(), OAuthServer.class, OldQuery.getDefault());
    		return getBimServer().getSConverter().convertToSListOAuthServer(allOfType);
    	} catch (BimserverDatabaseException e) {
    		return handleException(e);
		}
	}

	@Override
	public void setAuthorizationCode(Long applicationId, String code) throws UserException, ServerException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			OAuthAuthorizationCode oAuthAuthorizationCode = session.create(OAuthAuthorizationCode.class);
			OAuthServer server = session.get(applicationId, OldQuery.getDefault());
			oAuthAuthorizationCode.setOauthServer(server);
			oAuthAuthorizationCode.setCode(code);
			User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			user.getOAuthAuthorizationCodes().add(oAuthAuthorizationCode);
			session.store(user);
			session.commit();
    	} catch (Exception e) {
    		handleException(e);
		}
	}
	
	@Override
	public List<SOAuthAuthorizationCode> listAuthorizationCodes() throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSListOAuthAuthorizationCode(user.getOAuthAuthorizationCodes());
    	} catch (Exception e) {
    		return handleException(e);
		}
	}
	
	@Override
	public SOAuthServer getOAuthServerById(Long oid) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			OAuthServer oAuthServer = session.get(oid, OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(oAuthServer);
		} catch (Exception e) {
			return handleException(e);
		}
	}
}