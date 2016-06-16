package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0024 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass oAuthServer = schema.createEClass("store", "OAuthServer");
		schema.createEAttribute(oAuthServer, "registrationUrl", EcorePackage.eINSTANCE.getEString());
		schema.addIndex(schema.createEAttribute(oAuthServer, "clientId", EcorePackage.eINSTANCE.getEString()));
		schema.createEAttribute(oAuthServer, "clientSecret", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(oAuthServer, "clientName", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(oAuthServer, "clientIcon", EcorePackage.eINSTANCE.getEByteArray());
		schema.createEAttribute(oAuthServer, "clientUrl", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(oAuthServer, "clientDescription", EcorePackage.eINSTANCE.getEString());
		schema.addIndex(schema.createEAttribute(oAuthServer, "redirectUrl", EcorePackage.eINSTANCE.getEString()));
		schema.createEAttribute(oAuthServer, "expiresAt", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(oAuthServer, "issuedAt", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(oAuthServer, "incoming", EcorePackage.eINSTANCE.getEBoolean());
		schema.addIndex(schema.createEAttribute(oAuthServer, "apiUrl", EcorePackage.eINSTANCE.getEString()));
		schema.addIndex(schema.createEAttribute(oAuthServer, "registrationEndpoint", EcorePackage.eINSTANCE.getEString()));
		
		EClass serverSettings = schema.getEClass("store", "ServerSettings");
		schema.createEAttribute(serverSettings, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(serverSettings, "description", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(serverSettings, "icon", EcorePackage.eINSTANCE.getEString());
		
		EClass oauthAuthorizationCode = schema.createEClass("store", "OAuthAuthorizationCode");
		schema.createEReference(oauthAuthorizationCode, "oauthServer", oAuthServer, Multiplicity.SINGLE);
		schema.addIndex(schema.createEAttribute(oauthAuthorizationCode, "code", EcorePackage.eINSTANCE.getEString()));
		
		EClass user = schema.getEClass("store", "User");
		schema.createEReference(user, "oAuthAuthorizationCodes", oauthAuthorizationCode, Multiplicity.MANY);
		schema.createEReference(user, "oAuthIssuedAuthorizationCodes", oauthAuthorizationCode, Multiplicity.MANY);
		
		EClass authorization = schema.createEClass("store", "Authorization");

		EClass singleProjectAuthorization = schema.createEClass("store", "SingleProjectAuthorization", authorization);
		schema.createEReference(singleProjectAuthorization, "project", schema.getEClass("store", "Project"), Multiplicity.SINGLE);
		
		schema.createEReference(oauthAuthorizationCode, "authorization", authorization, Multiplicity.SINGLE);
	}

	@Override
	public String getDescription() {
		return "OAuth classes";
	}
}