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
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;

public class Step0020 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass metricsClass = schema.createEClass("store", "Metrics");
		EClass interfaceMetricClass = schema.createEClass("store", "InterfaceMetric");
		EClass methodMetricClass = schema.createEClass("store", "MethodMetric");

		schema.createEReference(metricsClass, "interfaces", interfaceMetricClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		
		schema.createEReference(interfaceMetricClass, "methods", methodMetricClass, Multiplicity.MANY).getEAnnotations().add(createEmbedsReferenceAnnotation());
		schema.createEAttribute(interfaceMetricClass, "name", EcorePackage.eINSTANCE.getEString());

		schema.createEAttribute(methodMetricClass, "name", EcorePackage.eINSTANCE.getEString());
		schema.createEAttribute(methodMetricClass, "nrCalls", EcorePackage.eINSTANCE.getELongObject());
		schema.createEAttribute(methodMetricClass, "lastCall", EcorePackage.eINSTANCE.getEDate());
		schema.createEAttribute(methodMetricClass, "averageMs", EcorePackage.eINSTANCE.getELongObject());
		schema.createEAttribute(methodMetricClass, "shortestMs", EcorePackage.eINSTANCE.getELongObject());
		schema.createEAttribute(methodMetricClass, "longestMs", EcorePackage.eINSTANCE.getELongObject());
	}

	@Override
	public String getDescription() {
		return "Adding metrics objects";
	}
}