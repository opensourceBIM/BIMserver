package org.bimserver;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Set;

import org.bimserver.plugins.guidanceproviders.FieldIgnoreMap;
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
					generalSet.add(new StructuralFeatureIdentifier(entity.getName(), attribute.getName()));
				}
			}
		}
	}
}