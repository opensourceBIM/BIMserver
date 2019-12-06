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
import org.apache.oltu.oauth2.as.response.OAuthASResponse.OAuthTokenResponseBuilder;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OperationType;
import org.bimserver.models.store.Authorization;
import org.bimserver.models.store.OAuthAuthorizationCode;
import org.bimserver.models.store.RunServiceAuthorization;
import org.bimserver.models.store.SingleProjectAuthorization;
import org.bimserver.models.store.StorePackage;
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
			
			OAuthAuthorizationCode code = null;
			try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
				String codeAsString = oauthRequest.getCode();
				code = session.querySingle(StorePackage.eINSTANCE.getOAuthAuthorizationCode_Code(), codeAsString);
	
				validateClient(oauthRequest);
	
				String resourceUrl = "";
				Authorization auth = code.getAuthorization();
				org.bimserver.webservices.authorization.Authorization authorization = null;
				if (auth instanceof SingleProjectAuthorization) {
					SingleProjectAuthorization singleProjectAuthorization = (SingleProjectAuthorization)auth;
					authorization = new org.bimserver.webservices.authorization.SingleProjectAuthorization(getBimServer(), code.getUser().getOid(), singleProjectAuthorization.getProject().getOid());
				} else if (auth instanceof RunServiceAuthorization) {
					RunServiceAuthorization runServiceAuthorization = (RunServiceAuthorization)auth;
					authorization = new org.bimserver.webservices.authorization.RunServiceAuthorization(getBimServer(), code.getUser().getOid(), runServiceAuthorization.getService().getOid());
					resourceUrl = getBimServer().getServerSettingsCache().getServerSettings().getSiteAddress() + "/services/" + runServiceAuthorization.getService().getOid();
				} else {
					throw new Exception("Unknown auth");
				}
				
				String accessToken = authorization.asHexToken(getBimServer().getEncryptionKey());
				String refreshToken = oauthIssuerImpl.refreshToken();
	
				OAuthTokenResponseBuilder builder = OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setAccessToken(accessToken).setExpiresIn("3600").setRefreshToken(refreshToken);
				builder.setParam("resource_url", resourceUrl);
				if (auth instanceof SingleProjectAuthorization) {
					builder.setParam("poid", "" + ((SingleProjectAuthorization)code.getAuthorization()).getProject().getOid());
				} else if (auth instanceof RunServiceAuthorization) {
					builder.setParam("soid", "" + ((RunServiceAuthorization)code.getAuthorization()).getService().getOid());
				}
				OAuthResponse r = builder.buildJSONMessage();
				response.setStatus(r.getResponseStatus());
				response.setContentType("application/json");
				PrintWriter pw = response.getWriter();
				pw.print(r.getBody());
				pw.flush();
				pw.close();
			} catch (BimserverDatabaseException e) {
				LOGGER.error("", e);
			}
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
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	private void validateClient(OAuthTokenRequest oauthRequest) {
	}
}
