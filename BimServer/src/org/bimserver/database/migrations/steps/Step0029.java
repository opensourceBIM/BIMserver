package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Step0029 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass oAuthAuthorizationCodeClass = schema.getEClass("store", "OAuthAuthorizationCode");
		EClass userClass = schema.getEClass("store", "User");

		EReference codeToUser = schema.createEReference(oAuthAuthorizationCodeClass, "user", userClass);
		EReference codes = (EReference) userClass.getEStructuralFeature("oAuthIssuedAuthorizationCodes");
		codeToUser.setEOpposite(codes);
		codes.setEOpposite(codeToUser);
	}

	@Override
	public String getDescription() {
		return "Add back-reference to oauth code/user";
	}
}
