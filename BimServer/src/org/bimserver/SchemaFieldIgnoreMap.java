package org.bimserver;

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

import java.util.ArrayList;
import java.util.Set;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.objectidms.FieldIgnoreMap;
import org.bimserver.plugins.objectidms.StructuralFeatureIdentifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import nl.tue.buildingsmart.schema.Attribute;
import nl.tue.buildingsmart.schema.EntityDefinition;
import nl.tue.buildingsmart.schema.InverseAttribute;

public class SchemaFieldIgnoreMap extends FieldIgnoreMap {

	public SchemaFieldIgnoreMap(Set<? extends EPackage> packages, PackageMetaData packageMetaData) {
		super(packages);
		ArrayList<EntityDefinition> entities = packageMetaData.getSchemaDefinition().getEntities();
		for (EntityDefinition entity : entities) {
			for (Attribute attribute : entity.getAttributes(true)) {
				if (attribute instanceof InverseAttribute) {
					if (attribute.getName().equals("HasOpenings") || attribute.getName().equals("ContainsElements") || attribute.getName().equals("IsDecomposedBy") || attribute.getName().equals("StyledByItem")) {
						// || attribute.getName().equals("IsDecomposedBy") || attribute.getName().equals("ContainedInStructure") || attribute.getName().equals("FillsVoids") || attribute.getName().equals("VoidsElements")
						// Exception: http://code.google.com/p/bimserver/issues/detail?id=303
						// Addition: Leon says this should be done for all types
					} else {
						EStructuralFeature eStructuralFeature = getEClass(entity.getName()).getEStructuralFeature(attribute.getName());
						if (((EReference)eStructuralFeature).getEOpposite() != null) {
							addToGeneralIgnoreSet(new StructuralFeatureIdentifier(entity.getName(), attribute.getName()));
						}
					}
				}
			}
		}
	}
}