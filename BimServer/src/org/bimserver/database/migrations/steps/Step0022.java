package org.bimserver.database.migrations.steps;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0022 extends Migration {

	@Override
	public void migrate(Schema schema) {
		EClass serviceInterface = schema.createEClass("store", "ServiceInterface");
		serviceInterface.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(serviceInterface, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		EClass serviceMethod = schema.createEClass("store", "ServiceMethod");
		serviceMethod.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(serviceMethod, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceMethod, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceMethod, "returnDoc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);

		EClass serviceField = schema.createEClass("store", "ServiceField");
		serviceField.getEAnnotations().add(createNoDatabaseAnnotation());
		EClass serviceType = schema.createEClass("store", "ServiceType");

		schema.createEAttribute(serviceField, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceField, "type", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(serviceField, "genericType", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEAttribute(serviceField, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		
		schema.createEAttribute(serviceType, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceType, "simpleName", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceType, "fields", serviceField, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());

		EClass serviceParameter = schema.createEClass("store", "ServiceParameter");
		serviceParameter.getEAnnotations().add(createNoDatabaseAnnotation());
		schema.createEAttribute(serviceParameter, "name", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEAttribute(serviceParameter, "doc", EcorePackage.eINSTANCE.getEString(), Multiplicity.SINGLE);
		schema.createEReference(serviceParameter, "type", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEReference(serviceParameter, "genericType", serviceType, Multiplicity.SINGLE).getEAnnotations().add(createEmbedsReferenceAnnotation());
	}

	@Override
	public String getDescription() {
		return "Provides meta data";
	}
}