package org.bimserver.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuer;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.bimserver.BimServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OAuthAccessTokenServlet extends SubServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(OAuthAccessTokenServlet.class);
	
	public OAuthAccessTokenServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OAuthTokenRequest oauthRequest = null;

		OAuthIssuer oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());

		if (!request.getContentType().equals("application/x-www-form-urlencoded")) {
			response.setStatus(405);
			PrintWriter pw = response.getWriter();
			pw.print("ContentType must be application/x-www-form-urlencoded");
			pw.flush();
			pw.close();
			return;
		}
		try {
			oauthRequest = new OAuthTokenRequest(request);

			validateClient(oauthRequest);

			String authzCode = oauthRequest.getCode();

			String accessToken = oauthIssuerImpl.accessToken();
			String refreshToken = oauthIssuerImpl.refreshToken();

			OAuthResponse r = OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setAccessToken(accessToken).setExpiresIn("3600").setRefreshToken(refreshToken).buildJSONMessage();

			response.setStatus(r.getResponseStatus());
			PrintWriter pw = response.getWriter();
			pw.print(r.getBody());
			pw.flush();
			pw.close();
		} catch (OAuthProblemException ex) {
			LOGGER.error("", ex);
			try {
				OAuthResponse r = OAuthResponse.errorResponse(401).error(ex).buildJSONMessage();
				response.setStatus(r.getResponseStatus());
				
				PrintWriter pw = response.getWriter();
				pw.print(r.getBody());
				pw.flush();
				pw.close();
			} catch (OAuthSystemException e) {
				LOGGER.error("", ex);
			}
		} catch (OAuthSystemException e) {
			LOGGER.error("", e);
		}
	}

	private void validateClient(OAuthTokenRequest oauthRequest) {
	}
}
