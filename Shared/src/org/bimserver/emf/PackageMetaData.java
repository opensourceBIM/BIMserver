package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class PackageMetaData implements ObjectFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(PackageMetaData.class);
	private final Map<String, Set<EClass>> directSubClasses = new TreeMap<String, Set<EClass>>();
	private final Map<String, Set<EClass>> allSubClasses = new TreeMap<String, Set<EClass>>();
	private final Map<String, EClassifier> caseInsensitive = new TreeMap<String, EClassifier>();
	private final Map<String, EClassifier> caseSensitive = new TreeMap<String, EClassifier>();
	private final Map<EClassifier, String> upperCases = new HashMap<>();
	private final BiMap<EClass, Class<?>> eClassClassMap = HashBiMap.create();
	private final Map<EStructuralFeature, Boolean> inverseCache = new HashMap<EStructuralFeature, Boolean>();
	private final EPackage ePackage;
	private final Schema schema;
	private final Set<PackageMetaData> dependencies = new HashSet<>();
	private SchemaDefinition schemaDefinition;

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
		if (ePackage == Ifc2x3tc1Package.eINSTANCE || ePackage == Ifc4Package.eINSTANCE) {
			try {
				schemaDefinition = metaDataManager.getPluginManager().requireSchemaDefinition(ePackage.getName().toLowerCase());
			} catch (PluginException e) {
				LOGGER.error("", e);
			}
		}
	}
	
	public EClass getEClass(Class<?> clazz) {
		return eClassClassMap.inverse().get(clazz);
	}

	public EClass getEClassIncludingDependencies(String type) {
		EClass eClass = getEClass(type);
		if (eClass == null) {
			for (PackageMetaData packageMetaData : dependencies) {
				EClass eClass2 = packageMetaData.getEClass(type);
				if (eClass2 != null) {
					return eClass2;
				}
			}
		}
		return eClass;
	}
	
	public EClass getEClassIncludingDependencies(Class<?> clazz) {
		EClass eClass = getEClass(clazz);
		if (eClass == null) {
			for (PackageMetaData packageMetaData : dependencies) {
				EClass eClass2 = packageMetaData.getEClass(clazz);
				if (eClass2 != null) {
					return eClass2;
				}
			}
		}
		return eClass;
	}
	
	public EClass getEClass(String name) {
		return (EClass) ePackage.getEClassifier(name);
	}

	public EEnum getEEnum(String name) {
		return (EEnum) ePackage.getEClassifier(name);
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


	@SuppressWarnings("unchecked")
	public Set<EClass> getDirectSubClasses(EClass superClass) {
		if (!directSubClasses.containsKey(superClass.getName())) {
			return java.util.Collections.EMPTY_SET;
		}
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

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(EClass eClass) {
		return (T) ePackage.getEFactoryInstance().create(eClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(Class<T> clazz) {
		EClass eClassIncludingDependencies = getEClassIncludingDependencies(clazz);
		return (T) eClassIncludingDependencies.getEPackage().getEFactoryInstance().create(eClassIncludingDependencies);
	}

	public SchemaDefinition getSchemaDefinition() {
		return schemaDefinition;
	}
	
	public Schema getSchema() {
		return schema;
	}

	public Set<PackageMetaData> getDependencies() {
		return dependencies;
	}
	
	void addDependency(PackageMetaData dependency) {
		dependencies.add(dependency);
	}
}