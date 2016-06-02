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

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.bimserver.BimServer;

public class OAuthAuthorizationServlet extends SubServlet {

	public OAuthAuthorizationServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		OAuthAuthzRequest oauthRequest = null;

		OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());

		try {
			oauthRequest = new OAuthAuthzRequest(request);

			// build response according to response_type
			String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);

			OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse.authorizationResponse(request,
					HttpServletResponse.SC_FOUND);

			if (responseType.equals(ResponseType.CODE.toString())) {
				builder.setCode(oauthIssuerImpl.authorizationCode());
			}
			if (responseType.equals(ResponseType.TOKEN.toString())) {
				builder.setAccessToken(oauthIssuerImpl.accessToken());
//				builder.setTokenType(OAuth.DEFAULT_TOKEN_TYPE.toString());
				builder.setExpiresIn(3600l);
			}

			String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);

			final OAuthResponse response = builder.location(redirectURI).setParam("address", getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/json") .buildQueryMessage();
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
				final URI location = new URI(response.getLocationUri());
				httpServletResponse.sendRedirect(response.getLocationUri());
			} catch (OAuthSystemException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		} catch (OAuthSystemException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}