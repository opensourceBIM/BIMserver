package org.bimserver.database.migrations.steps;

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

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

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
