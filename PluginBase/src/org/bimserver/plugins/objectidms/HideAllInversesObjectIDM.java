package org.bimserver.plugins.objectidms;

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
import org.eclipse.emf.ecore.EPackage;

import nl.tue.buildingsmart.schema.Attribute;
import nl.tue.buildingsmart.schema.EntityDefinition;
import nl.tue.buildingsmart.schema.InverseAttribute;

public class HideAllInversesObjectIDM extends FieldIgnoreMap {

	public HideAllInversesObjectIDM(Set<? extends EPackage> packages, PackageMetaData packageMetaData) {
		super(packages);
		ArrayList<EntityDefinition> entities = packageMetaData.getSchemaDefinition().getEntities();
		for (EntityDefinition entity : entities) {
			for (Attribute attribute : entity.getAttributes(true)) {
				if (attribute instanceof InverseAttribute) {
					addToGeneralIgnoreSet(new StructuralFeatureIdentifier(entity.getName(), attribute.getName()));
				}
			}
		}
	}
}
