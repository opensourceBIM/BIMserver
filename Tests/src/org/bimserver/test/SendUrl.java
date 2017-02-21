package org.bimserver.test;

import java.io.IOException;

import org.apache.oltu.oauth2.client.URLConnectionClient;
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
			OAuthClientRequest request = OAuthClientRegistrationRequest.location("http://localhost:8080/oauth/register/", OAuthRegistration.Type.PUSH).setName("Zapier").setUrl("https://zapier.com/dashboard/auth/oauth/return/App56192API").setDescription("App Description")
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
