package org.bimserver.test;

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

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.ext.dynamicreg.client.OAuthRegistrationClient;
import org.apache.oltu.oauth2.ext.dynamicreg.client.request.OAuthClientRegistrationRequest;
import org.apache.oltu.oauth2.ext.dynamicreg.client.response.OAuthClientRegistrationResponse;
import org.apache.oltu.oauth2.ext.dynamicreg.common.OAuthRegistration;

public class SendUrl {
	public static void main(String[] args) {
		try {
			OAuthClientRequest request = OAuthClientRegistrationRequest.location("https://thisisanexperimentalserver.com/oauth/register/", 
					OAuthRegistration.Type.PUSH).setName("Zapier").setUrl("https://zapier.com/dashboard/auth/oauth/return/App56192API").setDescription("App Description")
					.setRedirectURL("https://zapier.com/dashboard/auth/oauth/return/App56192API").buildJSONMessage();
			OAuthRegistrationClient oauthclient = new OAuthRegistrationClient(new org.bimserver.webservices.impl.URLConnectionClient());
			OAuthClientRegistrationResponse response = oauthclient.clientInfo(request);
			System.out.println(response.getClientId());
			System.out.println(response.getClientSecret());
		} catch (OAuthSystemException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (OAuthProblemException e) {
			e.printStackTrace();
		}
	}
}
