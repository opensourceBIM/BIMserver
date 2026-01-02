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
import org.eclipse.emf.ecore.*;

public class Step0057 extends Migration {
    @Override
    public void migrate(Schema schema, DatabaseSession databaseSession) {
        schema.loadEcore("ifc4x3.ecore", getClass().getResourceAsStream("IFC4X3_ADD2.ecore"));

        for (EClassifier eClassifier : schema.getEPackage("ifc4x3").getEClassifiers()) {
            if (eClassifier instanceof EClass) {
                EClass eClass = (EClass)eClassifier;
                for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
                    // A hack because not every "Name" field inherits from IfcRoot.Name, is not true for GlobalId though
                    if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEString()) {
                        if (eStructuralFeature.getName().equals("Name") || eStructuralFeature.getName().equals("GlobalId")) {
                            schema.addIndex(eStructuralFeature);
                        }
                    }
                }
            }
        }

        EClass ifc4x3Product = schema.getEClass("ifc4x3", "IfcProduct");
        EClass geometryInfo = schema.getEClass("geometry", "GeometryInfo");
        EReference ifc4x3Geometry = schema.createEReference(ifc4x3Product, "geometry", geometryInfo);
        ifc4x3Geometry.setUnsettable(true);
        ifc4x3Geometry.getEAnnotations().add(createHiddenAnnotation());
    }

    @Override
    public String getDescription() {
        return "Initial IFC4X3 model";
    }
}
