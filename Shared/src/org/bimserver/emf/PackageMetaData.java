package org.bimserver.emf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class PackageMetaData {
	private final Map<String, Set<EClass>> directSubClasses = new TreeMap<String, Set<EClass>>();
	private final Map<String, Set<EClass>> allSubClasses = new TreeMap<String, Set<EClass>>();
	private final Map<String, EClassifier> caseInsensitive = new TreeMap<String, EClassifier>();
	private final Map<String, EClassifier> caseSensitive = new TreeMap<String, EClassifier>();
	private final Map<EClassifier, String> upperCases = new HashMap<>();
	private final BiMap<EClass, Class<?>> eClassClassMap = HashBiMap.create();
	private final Map<EStructuralFeature, Boolean> inverseCache = new HashMap<EStructuralFeature, Boolean>();
	private EPackage ePackage;
	private SchemaDefinition schemaDefinition;
	private Schema schema;

	public PackageMetaData(MetaDataManager metaDataManager, EPackage ePackage, Schema schema) {
		this.ePackage = ePackage;
		this.schema = schema;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			caseInsensitive.put(eClassifier.getName().toLowerCase(), eClassifier);
			caseSensitive.put(eClassifier.getName(), eClassifier);
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				if (!allSubClasses.containsKey(eClass.getName())) {
					allSubClasses.put(eClass.getName(), new HashSet<EClass>());
				}
				if (!directSubClasses.containsKey(eClass.getName())) {
					directSubClasses.put(eClass.getName(), new HashSet<EClass>());
				}
				for (EClass superClass : eClass.getEAllSuperTypes()) {
					if (!allSubClasses.containsKey(superClass.getName())) {
						allSubClasses.put(superClass.getName(), new HashSet<EClass>());
					}
					allSubClasses.get(superClass.getName()).add(eClass);
				}
				for (EClass superClass : eClass.getESuperTypes()) {
					if (!directSubClasses.containsKey(superClass.getName())) {
						directSubClasses.put(superClass.getName(), new HashSet<EClass>());
					}
					directSubClasses.get(superClass.getName()).add(eClass);
				}
			}
		}
		initUpperCases();
		initEClassClassMap();
		try {
			if (metaDataManager != null && metaDataManager.getPluginManager() != null) {
				schemaDefinition = metaDataManager.getPluginManager().requireSchemaDefinition(ePackage.getName().toLowerCase());
			}
		} catch (PluginException e) {
		}
	}
	
	public EClass getEClass(Class<?> clazz) {
		return eClassClassMap.inverse().get(clazz);
	}

	public EClass getEClass(String name) {
		return (EClass) ePackage.getEClassifier(name);
	}
	
	public Set<EClass> getEClasses() {
		return eClassClassMap.keySet();
	}
	
	private void initEClassClassMap() {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				if (eClassifier.getInstanceClass() != null) {
					EClass eClass = (EClass) eClassifier;
					eClassClassMap.put(eClass, eClass.getInstanceClass());
				}
			}
		}
	}
	
	private void initUpperCases() {
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			upperCases.put(classifier, classifier.getName().toUpperCase());
		}
	}
	
	public String getUpperCase(EClass eClass) {
		return upperCases.get(eClass);
	}

	public boolean isInverse(EStructuralFeature feature) throws SerializerException {
		if (inverseCache.containsKey(feature)) {
			return inverseCache.get(feature);
		}
		EntityDefinition entityBN = schemaDefinition.getEntityBNNoCaseConvert(upperCases.get(feature.getEContainingClass()));
		if (entityBN == null) {
			return false;
		}
		Attribute attributeBNWithSuper = entityBN.getAttributeBNWithSuper(feature.getName());
		boolean isInverse = entityBN != null && attributeBNWithSuper instanceof InverseAttribute;
		inverseCache.put(feature, isInverse);
		return isInverse;
	}


	public Set<EClass> getDirectSubClasses(EClass superClass) {
		return directSubClasses.get(superClass.getName());
	}
	
	public Set<EClass> getAllSubClasses(EClass superClass) {
		return allSubClasses.get(superClass.getName());
	}

	public EClassifier getEClassifier(String type) {
		return caseSensitive.get(type);
	}

	public EClassifier getEClassifierCaseInsensitive(String type) {
		return caseInsensitive.get(type.toLowerCase());
	}
	
	public EAttribute getEAttribute(String className, String attributeName) {
		EClassifier eClassifier = ePackage.getEClassifier(className);
		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass)eClassifier;
			EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(attributeName);
			if (eStructuralFeature instanceof EAttribute) {
				return (EAttribute) eStructuralFeature;
			}
		}
		return null;
	}
	
	public EReference getEReference(String className, String referenceName) {
		EClassifier eClassifier = ePackage.getEClassifier(className);
		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass)eClassifier;
			EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(referenceName);
			if (eStructuralFeature instanceof EReference) {
				return (EReference) eStructuralFeature;
			}
		}
		return null;
	}

	public EEnumLiteral getEEnumLiteral(String enumName, String literalName) {
		EClassifier eClassifier = ePackage.getEClassifier(enumName);
		if (eClassifier == null) {
			throw new RuntimeException("Classifier " + enumName + " not found in package " + ePackage.getName());
		}
		if (eClassifier instanceof EEnum) {
			EEnum eEnum = (EEnum)eClassifier;
			EEnumLiteral literal = eEnum.getEEnumLiteral(literalName);
			if (literal == null) {
				throw new RuntimeException("No enum literal " + literalName + " found on " + ePackage.getName() + "." + enumName);
			}
			return literal;
		} else {
			throw new RuntimeException("Classifier " + enumName + " is not of type enum");
		}
	}

	public EPackage getEPackage() {
		return ePackage;
	}

	public EObject create(EClass eClass) {
		return ePackage.getEFactoryInstance().create(eClass);
	}

	public EObject create(Class<?> clazz) {
		return ePackage.getEFactoryInstance().create(getEClass(clazz));
	}

	public SchemaDefinition getSchemaDefinition() {
		return schemaDefinition;
	}
	
	public Schema getSchema() {
		return schema;
	}
}