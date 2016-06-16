package org.bimserver.webservices.impl;

import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
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
import org.bimserver.interfaces.objects.SAuthorization;
import org.bimserver.interfaces.objects.SOAuthAuthorizationCode;
import org.bimserver.interfaces.objects.SOAuthServer;
import org.bimserver.interfaces.objects.SSingleProjectAuthorization;
import org.bimserver.models.store.Authorization;
import org.bimserver.models.store.OAuthAuthorizationCode;
import org.bimserver.models.store.OAuthServer;
import org.bimserver.models.store.ServerSettings;
import org.bimserver.models.store.SingleProjectAuthorization;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.OAuthInterface;
import org.bimserver.utils.NetUtils;
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
        		
				String redirectUrl = getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/oauth";
				OAuthClientRequest request = OAuthClientRegistrationRequest
				    .location(registrationEndpoint, OAuthRegistration.Type.PUSH)
				    .setName(serverSettings.getName())
				    .setUrl(redirectUrl)
				    .setDescription(serverSettings.getDescription())
				    .setIcon(serverSettings.getIcon())
				    .setRedirectURL(redirectUrl)
				    .buildJSONMessage();
				OAuthRegistrationClient oauthclient = new OAuthRegistrationClient(new URLConnectionClient());
				OAuthClientRegistrationResponse response = oauthclient.clientInfo(request);

				oAuthServer = session.create(OAuthServer.class);
				oAuthServer.setApiUrl(apiUrl);
				oAuthServer.setClientId(response.getClientId());
				oAuthServer.setClientSecret(response.getClientSecret());
				
				oAuthServer.setIssuedAt(new Date(response.getIssuedAt()));
				
				GregorianCalendar expiresAt = new GregorianCalendar();
				expiresAt.setTimeInMillis(expiresAt.getTimeInMillis() + response.getExpiresIn());
				
				oAuthServer.setExpiresAt(expiresAt.getTime());
				oAuthServer.setRegistrationEndpoint(registrationEndpoint);
				oAuthServer.setClientDescription(serverSettings.getDescription());
				oAuthServer.setClientName(serverSettings.getName());
				
				if (serverSettings.getIcon() != null) {
					byte[] icon = NetUtils.getContentAsBytes(new URL(serverSettings.getIcon()), 500);
					oAuthServer.setClientIcon(icon);
				}
				
				oAuthServer.setIncoming(false);
				oAuthServer.setRedirectUrl(redirectUrl);
				
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
    		Iterator<OAuthServer> iterator = allOfType.iterator();
    		while (iterator.hasNext()) {
    			OAuthServer next = iterator.next();
    			if (next.isIncoming()) {
    				iterator.remove();
    			}
    		}
    		return getBimServer().getSConverter().convertToSListOAuthServer(allOfType);
    	} catch (BimserverDatabaseException e) {
    		return handleException(e);
		}
	}

	@Override
	public List<SOAuthServer> listRegisteredServersLocal() throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			List<OAuthServer> allOfType = session.getAllOfType(StorePackage.eINSTANCE.getOAuthServer(), OAuthServer.class, OldQuery.getDefault());
			Iterator<OAuthServer> iterator = allOfType.iterator();
			while (iterator.hasNext()) {
				OAuthServer next = iterator.next();
				if (!next.isIncoming()) {
					iterator.remove();
				}
			}
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
	public List<SOAuthAuthorizationCode> listIssuedAuthorizationCodes() throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSListOAuthAuthorizationCode(user.getOAuthIssuedAuthorizationCodes());
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

	@Override
	public void revokeApplication(Long oid) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			OAuthServer oAuthServer = session.get(oid, OldQuery.getDefault());
			session.delete(oAuthServer, -1);
			session.commit();
		} catch (Exception e) {
			handleException(e);
		}
	}
	
	@Override
	public void revokeAuthorization(Long oid) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			OAuthAuthorizationCode code = session.get(oid, OldQuery.getDefault());
			User user = session.get(getCurrentUser().getOid(), OldQuery.getDefault());
			user.getOAuthIssuedAuthorizationCodes().remove(code);
			session.store(user);
			session.delete(code, -1);
			session.commit();
		} catch (Exception e) {
			handleException(e);
		}
	}

	@Override
	public String authorize(Long oAuthServerOid, SAuthorization authorization) throws ServerException, UserException {
		OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());

		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			if (authorization instanceof SSingleProjectAuthorization) {
				User user = session.get(getCurrentUser().getOid(), OldQuery.getDefault());
				SSingleProjectAuthorization sSingleProjectAuthorization = (SSingleProjectAuthorization)authorization;
				
				SingleProjectAuthorization singleProjectAuthorization = session.create(SingleProjectAuthorization.class);
				singleProjectAuthorization.setProject(session.get(sSingleProjectAuthorization.getProjectId(), OldQuery.getDefault()));
				
				OAuthAuthorizationCode code = session.create(OAuthAuthorizationCode.class);
				code.setCode(oauthIssuerImpl.authorizationCode());
//				code.setOauthServer(session.get(oAuthServerOid, OldQuery.getDefault()));
				code.setAuthorization(singleProjectAuthorization);
				
				user.getOAuthIssuedAuthorizationCodes().add(code);
				
				session.store(user);
				
				session.commit();
				
				return code.getCode();
			} else {
				throw new UserException("Unimplemented type of authorization " + authorization.getClass().getSimpleName());
			}
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public SAuthorization getAuthorizationById(Long oid) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			return getBimServer().getSConverter().convertToSObject(((Authorization)session.get(oid, OldQuery.getDefault())));
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public SOAuthServer getOAuthServerByClientId(String clientId) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			OAuthServer oAuthServer = session.querySingle(StorePackage.eINSTANCE.getOAuthServer_ClientId(), clientId);
			return getBimServer().getSConverter().convertToSObject(oAuthServer);
		} catch (Exception e) {
			return handleException(e);
		}
	}
}