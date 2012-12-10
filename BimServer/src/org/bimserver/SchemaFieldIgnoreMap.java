package org.bimserver;

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

import java.util.ArrayList;
import java.util.Set;

import org.bimserver.plugins.objectidms.FieldIgnoreMap;
import org.bimserver.plugins.objectidms.StructuralFeatureIdentifier;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EPackage;

public class SchemaFieldIgnoreMap extends FieldIgnoreMap {

	public SchemaFieldIgnoreMap(Set<? extends EPackage> packages, SchemaDefinition schema) {
		super(packages);
		ArrayList<EntityDefinition> entities = schema.getEntities();
		for (EntityDefinition entity : entities) {
			for (Attribute attribute : entity.getAttributes(true)) {
				if (attribute instanceof InverseAttribute) {
					if (attribute.getName().equals("HasOpenings") || attribute.getName().equals("ContainsElements") || attribute.getName().equals("IsDecomposedBy")) {
						// || attribute.getName().equals("IsDecomposedBy") || attribute.getName().equals("ContainedInStructure") || attribute.getName().equals("FillsVoids") || attribute.getName().equals("VoidsElements")
						// Exception: http://code.google.com/p/bimserver/issues/detail?id=303
						// Addition: Leon says this should be done for all types
					} else {
						addToGeneralIgnoreSet(new StructuralFeatureIdentifier(entity.getName(), attribute.getName()));
					}
				}
			}
		}
	}
}