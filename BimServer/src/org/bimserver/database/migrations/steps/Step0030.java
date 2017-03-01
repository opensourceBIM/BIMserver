package org.bimserver.database.migrations.steps;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Migration;
import org.bimserver.database.migrations.Schema;
import org.bimserver.database.migrations.Schema.Multiplicity;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class Step0030 extends Migration {

	@Override
	public void migrate(Schema schema, DatabaseSession databaseSession) {
		EClass geometryInfo = schema.getEClass("geometry", "GeometryInfo");
		EClass vector3f = schema.getEClass("geometry", "Vector3f");
		
		EReference geometryInfoMinBounds = schema.createEReference(geometryInfo, "minBoundsUntranslated", vector3f, Multiplicity.SINGLE);
		geometryInfoMinBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		geometryInfoMinBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		geometryInfoMinBounds.getEAnnotations().add(createHiddenAnnotation());
		
		EReference geometryInfoMaxBounds = schema.createEReference(geometryInfo, "maxBoundsUntranslated", vector3f, Multiplicity.SINGLE);
		geometryInfoMaxBounds.getEAnnotations().add(createDbEmbedReferenceAnnotation());
		geometryInfoMaxBounds.getEAnnotations().add(createEmbedsReferenceAnnotation());
		geometryInfoMaxBounds.getEAnnotations().add(createHiddenAnnotation());
	}

	@Override
	public String getDescription() {
		return "Add untranslated bounds";
	}
}
