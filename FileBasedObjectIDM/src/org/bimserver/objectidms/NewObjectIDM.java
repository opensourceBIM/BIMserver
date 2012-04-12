package org.bimserver.objectidms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.MetaDataManager;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

public class NewObjectIDM implements ObjectIDM{

	private final Set<EClass> includedClasses = new HashSet<EClass>();
	private final Map<EClass, Set<EStructuralFeature>> includedFeatures = new HashMap<EClass, Set<EStructuralFeature>>();
	private final MetaDataManager metaDataManager = new MetaDataManager();
	private final SchemaDefinition schema;

	public NewObjectIDM(SchemaDefinition schema) {
		this.schema = schema;
	}
	
	public void includeAllClasses() {
		for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				includedClasses.add((EClass)eClassifier);
			}
		}
	}
	
	public void exclude(EClass eClass) {
		includedClasses.remove(eClass);
		for (EClass subClass : metaDataManager.getDirectSubClasses(eClass)) {
			exclude(subClass);
		}
	}
	
	public SchemaDefinition getSchema() {
		return schema;
	}
	
	public void include(EClass eClass) {
		includedClasses.add(eClass);
		for (EClass subClass : metaDataManager.getDirectSubClasses(eClass)) {
			include(subClass);
		}
	}

	protected boolean isInverse(EStructuralFeature eStructuralFeature) {
		return false;
	}
	
	public void include(EStructuralFeature eStructuralFeature) {
		if (!includedFeatures.containsKey(eStructuralFeature.getEContainingClass())) {
			includedFeatures.put(eStructuralFeature.getEContainingClass(), new HashSet<EStructuralFeature>());
		}
		includedFeatures.get(eStructuralFeature.getEContainingClass()).add(eStructuralFeature);
	}
	
	public void exclude(EStructuralFeature eStructuralFeature) {
		if (includedFeatures.containsKey(eStructuralFeature.getEContainingClass())) {
			includedFeatures.get(eStructuralFeature.getEContainingClass()).remove(eStructuralFeature);
		}
	}
	
	@Override
	public boolean shouldFollowReference(EClass originalClass, EClass eClass, EStructuralFeature eStructuralFeature) {
		return false;
	}

	@Override
	public boolean shouldIncludeClass(EClass eClass) {
		return includedClasses.contains(eClass);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Included classes:\n");
		for (EClass eClass : includedClasses) {
			sb.append("  " + eClass.getName() + "\n");
		}
		sb.append("Included features:\n");
		for (EClass eClass : includedFeatures.keySet()) {
			sb.append("  " + eClass.getName() + "\n");
			for (EStructuralFeature eStructuralFeature : includedFeatures.get(eClass)) {
				sb.append("    " + eStructuralFeature.getName() + "\n");
			}
		}
		return sb.toString();
	}
}