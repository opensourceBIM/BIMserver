package org.bimserver.ifc;

import java.util.HashMap;
import java.util.Map;

import nl.tue.buildingsmart.express.dictionary.Attribute;
import nl.tue.buildingsmart.express.dictionary.EntityDefinition;
import nl.tue.buildingsmart.express.dictionary.InverseAttribute;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class IfcSerializer extends EmfSerializer {

	protected static final Ifc2x3Package IFC_PACKAGE_INSTANCE = Ifc2x3Package.eINSTANCE;
	protected static final Map<EClassifier, String> upperCases = initUpperCases();
	private static final Map<EStructuralFeature, Boolean> inverseCache = new HashMap<EStructuralFeature, Boolean>();
	protected final SchemaDefinition schema;

	public IfcSerializer(String fileName, IfcModel model, SchemaDefinition schema) {
		super(fileName, model);
		this.schema = schema;
	}

	private static Map<EClassifier, String> initUpperCases() {
		Map<EClassifier, String> upperCases = new HashMap<EClassifier, String>();
		for (EClassifier classifier : IFC_PACKAGE_INSTANCE.getEClassifiers()) {
			upperCases.put(classifier, classifier.getName().toUpperCase());
		}
		return upperCases;
	}

	protected boolean isInverse(EStructuralFeature feature) {
		if (inverseCache.containsKey(feature)) {
			return inverseCache.get(feature);
		}
		EntityDefinition entityBN = schema.getEntityBNNoCaseConvert(upperCases.get(feature.getEContainingClass()));
		if (entityBN == null) {
			return false;
		}
		Attribute attributeBNWithSuper = entityBN.getAttributeBNWithSuper(feature.getName());
		boolean isInverse = entityBN != null && attributeBNWithSuper instanceof InverseAttribute;
		inverseCache.put(feature, isInverse);
		return isInverse;
	}
}