package org.bimserver.servlets;

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
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.store.Authorization;
import org.bimserver.models.store.OAuthAuthorizationCode;
import org.bimserver.models.store.SingleProjectAuthorization;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;

public class OAuthAuthorizationServlet extends SubServlet {

	public OAuthAuthorizationServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		OAuthAuthzRequest oauthRequest = null;

		String authType = request.getParameter("auth_type");
		if (request.getParameter("token") == null) {
			httpServletResponse.sendRedirect("/apps/bimviews/?page=OAuth&auth_type=" + authType + "&client_id=" + request.getParameter("client_id") + "&response_type=" + request.getParameter("response_type") + "&redirect_uri=" + request.getParameter("redirect_uri"));
			return;
		}

		OAuthAuthorizationCode oauthCode = null;
		org.bimserver.models.store.Authorization authorization = null;
		
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
//			OAuthServer oAuthServer = session.querySingle(StorePackage.eINSTANCE.getOAuthServer_ClientId(), request.getParameter("client_id")));

			if (request.getParameter("code") != null) {
				String code = (String) request.getParameter("code");
				oauthCode = session.querySingle(StorePackage.eINSTANCE.getOAuthAuthorizationCode_Code(), code);
				authorization = oauthCode.getAuthorization();
				authorization.load();
//			} else {
//				String token = request.getParameter("token");
//				authorization = Authorization.fromToken(getBimServer().getEncryptionKey(), token);
//				long uoid = authorization.getUoid();
//				User user = session.get(uoid, OldQuery.getDefault());
//				for (OAuthAuthorizationCode oAuthAuthorizationCode : user.getOAuthIssuedAuthorizationCodes()) {
//					if (oAuthAuthorizationCode.getOauthServer() == oAuthServer) {
//						// This issuing user has already authorized this application
//					}
//				}
			}
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		}
		
		try {
			oauthRequest = new OAuthAuthzRequest(request);

			String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);

			OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND);

			if (responseType.equals(ResponseType.CODE.toString())) {
				builder.setCode(oauthCode.getCode());
//			} else if (responseType.equals(ResponseType.TOKEN))) {
//				builder.setAccessToken(oauthCode.get)
			}
//			if (responseType.equals(ResponseType.TOKEN.toString())) {
//				builder.setAccessToken(oauthIssuerImpl.accessToken());
////				builder.setTokenType(OAuth.DEFAULT_TOKEN_TYPE.toString());
//				builder.setExpiresIn(3600l);
//			}

			String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);

			OAuthAuthorizationResponseBuilder build = builder.location(redirectURI).setParam("address", getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/json");
			if (authorization instanceof SingleProjectAuthorization) {
				SingleProjectAuthorization singleProjectAuthorization = (SingleProjectAuthorization)authorization;
				build.setParam("poid", "" + singleProjectAuthorization.getProject().getOid());
			}
			final OAuthResponse response = build.buildQueryMessage();
			String locationUri = response.getLocationUri();
			URI url = new URI(locationUri);

			System.out.println("Redirecting to " + url);
			
			httpServletResponse.sendRedirect(locationUri);
		} catch (OAuthProblemException e) {
			final Response.ResponseBuilder responseBuilder = Response.status(HttpServletResponse.SC_FOUND);

			String redirectUri = e.getRedirectUri();

			if (OAuthUtils.isEmpty(redirectUri)) {
				throw new WebApplicationException(
						responseBuilder.entity("OAuth callback url needs to be provided by client!!!").build());
			}
			try {
				OAuthResponse response = OAuthASResponse.errorResponse(HttpServletResponse.SC_FOUND).error(e)
						.location(redirectUri).buildQueryMessage();
//				final URI location = new URI(response.getLocationUri());
				httpServletResponse.sendRedirect(response.getLocationUri());
			} catch (OAuthSystemException e1) {
				e1.printStackTrace();
			}
		} catch (OAuthSystemException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}