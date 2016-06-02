package org.bimserver.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.ext.dynamicreg.server.request.JSONHttpServletRequestWrapper;
import org.apache.oltu.oauth2.ext.dynamicreg.server.request.OAuthServerRegistrationRequest;
import org.apache.oltu.oauth2.ext.dynamicreg.server.response.OAuthServerRegistrationResponse;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.store.OAuthServer;
import org.bimserver.shared.exceptions.ServiceException;

public class OAuthRegistrationServlet extends SubServlet {

	public OAuthRegistrationServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse httpResponse) throws ServletException, IOException {
		OAuthServerRegistrationRequest oauthRequest = null;
        try {
            oauthRequest = new OAuthServerRegistrationRequest(new JSONHttpServletRequestWrapper(request));
            oauthRequest.discover();
            oauthRequest.getClientUrl();
            oauthRequest.getClientDescription();
            oauthRequest.getRedirectURI();

            try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
            	OAuthServer oAuthServer = session.create(OAuthServer.class);
            	oAuthServer.setClientName(oauthRequest.getClientName());
            	oAuthServer.setClientUrl(oauthRequest.getClientUrl());
            	oAuthServer.setClientDescription(oauthRequest.getClientDescription());
            	oAuthServer.setRedirectUrl(oauthRequest.getRedirectURI());
            	oAuthServer.setClientSecret("secret");
            	oAuthServer.setClientId("testid");
            	oAuthServer.setIncoming(true);
            	session.commit();
            	OAuthResponse response = OAuthServerRegistrationResponse
            			.status(HttpServletResponse.SC_OK)
            			.setClientId(oAuthServer.getClientId())
            			.setClientSecret(oAuthServer.getClientSecret())
            			.setIssuedAt(oAuthServer.getIssuedAt())
            			.setExpiresIn(oAuthServer.getExpiresIn())
            			.buildJSONMessage();
            	httpResponse.setStatus(response.getResponseStatus());
            	httpResponse.getWriter().write(response.getBody());
            } catch (BimserverDatabaseException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
        } catch (OAuthProblemException e) {
            OAuthResponse response;
			try {
				response = OAuthServerRegistrationResponse
				    .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
				    .error(e)
				    .buildJSONMessage();
				httpResponse.setStatus(response.getResponseStatus());
				httpResponse.getWriter().write(response.getBody());
			} catch (OAuthSystemException e1) {
				e1.printStackTrace();
			}
        } catch (OAuthSystemException e) {
			e.printStackTrace();
		}
	}
}