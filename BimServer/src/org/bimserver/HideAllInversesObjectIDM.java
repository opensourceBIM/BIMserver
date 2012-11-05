package org.bimserver;

import java.util.ArrayList;
import java.util.Set;

import org.bimserver.plugins.objectidms.FieldIgnoreMap;
import org.bimserver.plugins.objectidms.StructuralFeatureIdentifier;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EPackage;

public class HideAllInversesObjectIDM extends FieldIgnoreMap {

	public HideAllInversesObjectIDM(Set<? extends EPackage> packages, SchemaDefinition schema) {
		super(packages);
		ArrayList<EntityDefinition> entities = schema.getEntities();
		for (EntityDefinition entity : entities) {
			for (Attribute attribute : entity.getAttributes(true)) {
				if (attribute instanceof InverseAttribute) {
					addToGeneralIgnoreSet(new StructuralFeatureIdentifier(entity.getName(), attribute.getName()));
				}
			}
		}
	}
}
