package org.bimserver.ifc;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.BimModelSerializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

public abstract class IfcSerializer extends BimModelSerializer {

	protected static final Ifc2x3Package IFC_PACKAGE_INSTANCE = Ifc2x3Package.eINSTANCE;
	protected static final Map<EClassifier, String> upperCases = initUpperCases();
	private static final Map<EStructuralFeature, Boolean> inverseCache = new HashMap<EStructuralFeature, Boolean>();

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException {
		super.init(model, projectInfo, pluginManager);
	}

	private static Map<EClassifier, String> initUpperCases() {
		Map<EClassifier, String> upperCases = new HashMap<EClassifier, String>();
		for (EClassifier classifier : IFC_PACKAGE_INSTANCE.getEClassifiers()) {
			upperCases.put(classifier, classifier.getName().toUpperCase());
		}
		return upperCases;
	}

	protected boolean isInverse(EStructuralFeature feature) throws SerializerException {
		if (inverseCache.containsKey(feature)) {
			return inverseCache.get(feature);
		}
		SchemaDefinition schema;
		try {
			schema = getPluginManager().requireSchemaDefinition();
		} catch (PluginException e) {
			throw new SerializerException(e);
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