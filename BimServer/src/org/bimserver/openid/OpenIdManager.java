package org.bimserver.openid;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserType;
import org.bimserver.webservices.authorization.AdminAuthorization;
import org.bimserver.webservices.authorization.Authorization;
import org.bimserver.webservices.authorization.UserAuthorization;
import org.openid4java.OpenIDException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.consumer.VerificationResult;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.ParameterList;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenIdManager {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OpenIdManager.class);
	public ConsumerManager manager;
	private BimServer bimServer;

	public OpenIdManager(BimServer bimServer) {
		this.bimServer = bimServer;
		// instantiate a ConsumerManager object
		manager = new ConsumerManager();
	}

	// --- placing the authentication request ---
	public String authRequest(String userSuppliedString, String returnToUrl) throws IOException {
		try {
			// configure the return_to URL where your application will receive
			// the authentication responses from the OpenID provider

			// --- Forward proxy setup (only if needed) ---
			// ProxyProperties proxyProps = new ProxyProperties();
			// proxyProps.setProxyName("proxy.example.com");
			// proxyProps.setProxyPort(8080);
			// HttpClientFactory.setProxyProperties(proxyProps);

			// perform discovery on the user-supplied identifier
			List<?> discoveries = manager.discover(userSuppliedString);

			// attempt to associate with the OpenID provider
			// and retrieve one service endpoint for authentication
			DiscoveryInformation discovered = manager.associate(discoveries);

			// store the discovery information in the user's session
//			httpReq.getSession().setAttribute("openid-disc", discovered);

			// obtain a AuthRequest message to be sent to the OpenID provider
			AuthRequest authReq = manager.authenticate(discovered, bimServer.getServerSettingsCache().getServerSettings().getSiteAddress() + "/openid");

			// Attribute Exchange example: fetching the 'email' attribute
			FetchRequest fetch = FetchRequest.createFetchRequest();
			fetch.addAttribute("email",
			// attribute alias
					"http://schema.openid.net/contact/email", // type URI
					true); // required

			// attach the extension to the authentication request
			authReq.addExtension(fetch);

			if (!discovered.isVersion2()) {
				// Option 1: GET HTTP-redirect to the OpenID Provider endpoint
				// The only method supported in OpenID 1.x
				// redirect-URL usually limited ~2048 bytes
				return authReq.getDestinationUrl(true);
//				httpResp.sendRedirect(authReq.getDestinationUrl(true));
//				return null;
			} else {
				// Option 2: HTML FORM Redirection (Allows payloads >2048 bytes)

//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("formredirection.jsp");
//				httpReq.setAttribute("parameterMap", authReq.getParameterMap());
//				httpReq.setAttribute("destinationUrl", authReq.getDestinationUrl(false));
//				dispatcher.forward(httpReq, httpResp);
				return authReq.getDestinationUrl(true);
			}
		} catch (OpenIDException e) {
			LOGGER.error("", e);
			// present error to the user
		}

		return null;
	}

	// --- processing the authentication response ---
	public Identifier verifyResponse(HttpServletRequest httpReq, HttpServletResponse response2) {
		try {
			// extract the parameters from the authentication response
			// (which comes in as a HTTP request from the OpenID provider)
			ParameterList response = new ParameterList(httpReq.getParameterMap());

			// retrieve the previously stored discovery information
			DiscoveryInformation discovered = (DiscoveryInformation) httpReq.getSession().getAttribute("openid-disc");

			// extract the receiving URL from the HTTP request
			StringBuffer receivingURL = httpReq.getRequestURL();
			String queryString = httpReq.getQueryString();
			if (queryString != null && queryString.length() > 0)
				receivingURL.append("?").append(httpReq.getQueryString());

			// verify the response; ConsumerManager needs to be the same
			// (static) instance used to place the authentication request
			VerificationResult verification = manager.verify(receivingURL.toString(), response, discovered);

			// examine the verification result and extract the verified
			// identifier
			Identifier verified = verification.getVerifiedId();
			if (verified != null) {
				AuthSuccess authSuccess = (AuthSuccess) verification.getAuthResponse();

				if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX)) {
					FetchResponse fetchResp = (FetchResponse) authSuccess.getExtension(AxMessage.OPENID_NS_AX);

					List<?> emails = fetchResp.getAttributeValues("email");
					String email = (String) emails.get(0);
					
					DatabaseSession session = bimServer.getDatabase().createSession();
					try {
						Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Username(), new StringLiteral(email));
						User user = session.querySingle(condition, User.class, Query.getDefault());
						if (user != null) {
							if (user.getState() == ObjectState.DELETED) {
//								throw new UserException("User account has been deleted");
							} else if (user.getUserType() == UserType.SYSTEM) {
//								throw new UserException("System user cannot login");
							}
							Authorization authorization = null;
							if (user.getUserType() == UserType.ADMIN) {
								authorization = new AdminAuthorization(1, TimeUnit.DAYS);
							} else {
								authorization = new UserAuthorization(1, TimeUnit.DAYS);
							}
							authorization.setUoid(user.getOid());
							String asHexToken = authorization.asHexToken(bimServer.getEncryptionKey());
							
							user.setLastSeen(new Date());
							session.store(user);
							response2.addCookie(new Cookie("token", asHexToken));
						}
					} catch (BimserverDatabaseException e) {
						e.printStackTrace();
					} finally {
						session.close();
					}
				}
				return verified; // success
			}
		} catch (OpenIDException e) {
			// present error to the user
		}

		return null;
	}
}