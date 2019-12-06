package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.as.response.OAuthASResponse.OAuthAuthorizationResponseBuilder;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.models.store.OAuthAuthorizationCode;
import org.bimserver.models.store.OAuthServer;
import org.bimserver.models.store.RunServiceAuthorization;
import org.bimserver.models.store.SingleProjectAuthorization;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.webservices.authorization.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.UrlEscapers;

public class OAuthAuthorizationServlet extends SubServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(OAuthAuthorizationServlet.class);

	public OAuthAuthorizationServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		OAuthAuthzRequest oauthRequest = null;

		String authType = request.getParameter("auth_type");
		if (request.getParameter("token") == null) {
			String location = "/apps/bimviews/?page=OAuth&auth_type=" + authType + "&client_id=" + request.getParameter("client_id") + "&response_type=" + request.getParameter("response_type") + "&redirect_uri="
					+ request.getParameter("redirect_uri");
			if (request.getParameter("state") != null) {
				String state = request.getParameter("state");
				LOGGER.info("Incoming state: " + state);
				String encodedState = UrlEscapers.urlFragmentEscaper().escape(state);
				LOGGER.info("Encoded state: " + encodedState);
				location += "&state=" + encodedState;
			}
			LOGGER.info("Redirecting to " + location);
			httpServletResponse.sendRedirect(location);
			return;
		}

		OAuthAuthorizationCode oauthCode = null;

		String token = request.getParameter("token");
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			OAuthServer oAuthServer = session.querySingle(StorePackage.eINSTANCE.getOAuthServer_ClientId(), request.getParameter("client_id"));

			org.bimserver.webservices.authorization.Authorization realAuth = org.bimserver.webservices.authorization.Authorization.fromToken(getBimServer().getEncryptionKey(), token);
			long uoid = realAuth.getUoid();
			User user = session.get(uoid, OldQuery.getDefault());
			for (OAuthAuthorizationCode oAuthAuthorizationCode : user.getOAuthIssuedAuthorizationCodes()) {
				if (oAuthAuthorizationCode.getOauthServer() == oAuthServer) {
					if (oAuthAuthorizationCode.getAuthorization() != null) {
						oauthCode = oAuthAuthorizationCode;
					}
				}
			}

			try {
				if (oauthCode == null) {
					throw new ServletException("No auth found for token " + token);
				}
				oauthRequest = new OAuthAuthzRequest(request);

				String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);

				OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND);

				if (responseType.equals(ResponseType.CODE.toString())) {
					builder.setCode(oauthCode.getCode());
					// } else if (responseType.equals(ResponseType.TOKEN))) {
					// builder.setAccessToken(oauthCode.get)
				}
				// if (responseType.equals(ResponseType.TOKEN.toString())) {
				// builder.setAccessToken(oauthIssuerImpl.accessToken());
				//// builder.setTokenType(OAuth.DEFAULT_TOKEN_TYPE.toString());
				// builder.setExpiresIn(3600l);
				// }

				String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);

				if (redirectURI != null && !redirectURI.equals("")) {
					if (redirectURI.equals("SHOW_CODE")) {
						httpServletResponse.getWriter().write("Service token (copy&paste this into your application): <br/><br/><input type=\"text\" style=\"width: 1000px\" value=\"" + oauthCode.getCode() + "\"/><br/><br/>");
						
						RunServiceAuthorization auth = (RunServiceAuthorization) oauthCode.getAuthorization();
						String siteAddress = getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress();
						
						httpServletResponse.getWriter().write("Service address: <br/><br/><input type=\"text\" style=\"width: 1000px\" value=\"" + siteAddress + "/services/" + auth.getService().getOid()  + "\"/><br/><br/>");
					} else {
						URI uri = makeUrl(redirectURI, oauthCode, builder);
						LOGGER.info("Redirecting to " + uri);
						httpServletResponse.sendRedirect(uri.toString());
					}
				} else {
					URI uri = makeUrl("http://fakeaddress", oauthCode, builder);
					httpServletResponse.getWriter().println("No redirectURI provided");
					httpServletResponse.getWriter().println("Would have redirected to: " + uri);
				}
			} catch (OAuthProblemException e) {
				final Response.ResponseBuilder responseBuilder = Response.status(HttpServletResponse.SC_FOUND);

				String redirectUri = e.getRedirectUri();

				if (OAuthUtils.isEmpty(redirectUri)) {
					throw new WebApplicationException(responseBuilder.entity("OAuth callback url needs to be provided by client!!!").build());
				}
				try {
					OAuthResponse response = OAuthASResponse.errorResponse(HttpServletResponse.SC_FOUND).error(e).location(redirectUri).buildQueryMessage();
					// final URI location = new URI(response.getLocationUri());
					httpServletResponse.sendRedirect(response.getLocationUri());
				} catch (OAuthSystemException e1) {
					e1.printStackTrace();
				}
			}
		} catch (OAuthSystemException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (BimserverLockConflictException e2) {
			e2.printStackTrace();
		} catch (BimserverDatabaseException e2) {
			e2.printStackTrace();
		} catch (AuthenticationException e2) {
			e2.printStackTrace();
		}
	}

	private URI makeUrl(String redirectURI, OAuthAuthorizationCode oauthCode, OAuthAuthorizationResponseBuilder builder) throws OAuthSystemException, URISyntaxException {
		String siteAddress = getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress();
		OAuthAuthorizationResponseBuilder build = builder.location(redirectURI).setParam("address", siteAddress + "/json");
		build.setParam("serviceaddress", siteAddress + "/services");
		build.setParam("websocketUrl", siteAddress.replace("http://", "ws://").replace("https://", "wss://") + "/stream");
		if (oauthCode.getAuthorization() instanceof SingleProjectAuthorization) {
			SingleProjectAuthorization singleProjectAuthorization = (SingleProjectAuthorization) oauthCode.getAuthorization();
			build.setParam("poid", "" + singleProjectAuthorization.getProject().getOid());
		} else if (oauthCode.getAuthorization() instanceof RunServiceAuthorization) {
			RunServiceAuthorization auth = (RunServiceAuthorization) oauthCode.getAuthorization();
			build.setParam("soid", "" + auth.getService().getOid());
		}
		final OAuthResponse response = build.buildQueryMessage();
		String locationUri = response.getLocationUri();
		URI url = new URI(locationUri);
		return url;
	}
}