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
import org.bimserver.plugins.schema.ExplicitAttribute;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.SchemaDefinition;
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
	private final Map<EReference, Boolean> isInverseCache = new HashMap<EReference, Boolean>();
	private final Map<EReference, Boolean> hasInverseCache = new HashMap<EReference, Boolean>();
	private final EPackage ePackage;
	private final Schema schema;
	private final Set<PackageMetaData> dependencies = new HashSet<>();
	private SchemaDefinition schemaDefinition;
	private final Map<EClass, Set<EStructuralFeature>> useForSerialization = new HashMap<>();
	private final Map<EClass, Set<EStructuralFeature>> useForDatabaseStorage = new HashMap<>();
	private final Map<EClass, OppositeInfo> oppositeInfos = new HashMap<>();
	private final Map<EClass, Integer> unsettedLengths = new HashMap<EClass, Integer>();

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
			initOppositeInfo();
			try {
				schemaDefinition = metaDataManager.getPluginManager().requireSchemaDefinition(ePackage.getName().toLowerCase());
			} catch (PluginException e) {
				LOGGER.error("", e);
			}
		}
		initUnsettedLengths();
	}
	
	private void initUnsettedLengths() {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				calculateUnsettedLength(eClass);
			}
		}
	}

	private int calculateUnsettedLength(EClass eClass) {
		int fieldCounter = 0;
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (this.useForDatabaseStorage(eClass, feature)) {
				fieldCounter++;
			}
		}
		int unsettedLength = (int) Math.ceil(fieldCounter / 8.0);
		unsettedLengths.put(eClass, unsettedLength);
		return unsettedLength;
	}

	private void initOppositeInfo() {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				boolean hasOpposites = false;
				boolean hasManyOpposites = false;
				for (EReference eReference : eClass.getEAllReferences()) {
					if (eReference.getEOpposite() != null) {
						hasOpposites = true;
						if (eReference.isMany()) {
							hasManyOpposites = true;
						}
					}
				}
				oppositeInfos.put(eClass, new OppositeInfo(hasOpposites, hasManyOpposites));
			}
		}
	}
	
	public OppositeInfo getOppositeInfo(EClass eClass) {
		return oppositeInfos.get(eClass);
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
	
	public boolean useForSerialization(EClass eClass, EStructuralFeature eStructuralFeature) {
		if (this.getSchemaDefinition() == null) {
			return true;
		}
		Set<EStructuralFeature> set = useForSerialization.get(eClass);
		if (set == null) {
			set = buildUseForSerializationSet(eClass);
		}
		return set.contains(eStructuralFeature);
	}

	public boolean useForDatabaseStorage(EClass eClass, EStructuralFeature eStructuralFeature) {
		if (this.getSchemaDefinition() == null) {
			return true;
		}
		Set<EStructuralFeature> set = useForDatabaseStorage.get(eClass);
		if (set == null) {
			set = buildUseForDatabaseStorage(eClass);
		}
		return set.contains(eStructuralFeature);
	}
	
	private void initUpperCases() {
		for (EClassifier classifier : ePackage.getEClassifiers()) {
			upperCases.put(classifier, classifier.getName().toUpperCase());
		}
	}
	
	public String getUpperCase(EClass eClass) {
		return upperCases.get(eClass);
	}

	public boolean isInverse(EReference eReference) {
		if (isInverseCache.containsKey(eReference)) {
			return isInverseCache.get(eReference);
		}
		EntityDefinition entityBN = schemaDefinition.getEntityBNNoCaseConvert(upperCases.get(eReference.getEContainingClass()));
		if (entityBN == null) {
			return false;
		}
		Attribute attributeBNWithSuper = entityBN.getAttributeBNWithSuper(eReference.getName());
		boolean isInverse = entityBN != null && attributeBNWithSuper instanceof InverseAttribute;
		
		if (!isInverse) {
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcElement_ContainedInStructure()) {
				isInverse = true;
			} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcAnnotation_ContainedInStructure()) {
				isInverse = true;
			} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcGrid_ContainedInStructure()) {
				isInverse = true;
			}
			
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRepresentation_LayerAssignments()) {
				isInverse = true;
			} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRepresentationItem_LayerAssignments()) {
				isInverse = true;
			}
			
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcObjectDefinition_HasAssociations()) {
				isInverse = true;
			} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcPropertyDefinition_HasAssociations()) {
				isInverse = true;
			}
			
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcDimensionCurve_AnnotatedBySymbols()) {
				isInverse = true;
			}
			
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcElement_ReferencedInStructures()) {
				isInverse = true;
			}
			
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcProductDefinitionShape_ShapeOfProduct()) {
				isInverse = true;
			}
			
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcStructuralItem_AssignedStructuralActivity()) {
				isInverse = true;
			}
		}
		
		isInverseCache.put(eReference, isInverse);
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

	public int getNrSerializableFeatures(EClass eClass) {
		Set<EStructuralFeature> set = useForSerialization.get(eClass);
		if (set == null) {
			set = buildUseForSerializationSet(eClass);
		}
		return set.size();
	}

	public int getNrDatabaseFeatures(EClass eClass) {
		Set<EStructuralFeature> set = useForDatabaseStorage.get(eClass);
		if (set == null) {
			set = buildUseForDatabaseStorage(eClass);
		}
		return set.size();
	}

	private synchronized Set<EStructuralFeature> buildUseForSerializationSet(EClass eClass) {
		if (this.getSchemaDefinition() != null) {
			if (!useForSerialization.containsKey(eClass)) {
				if (eClass.getName().equals("IfcAxis2Placement3D")) {
					System.out.println();
				}
				HashSet<EStructuralFeature> set = new HashSet<>();
				for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
					EntityDefinition entityBN = this.getSchemaDefinition().getEntityBN(eClass.getName());
//					if (eStructuralFeature.getEAnnotation("hidden") != null) {
						
//						if (eStructuralFeature.getEAnnotation("asstring") == null) {
//						} else {
//							if (entityBN.isDerived(eStructuralFeature.getName().substring(0, eStructuralFeature.getName().length() - 8))) {
//							} else {
//								set.add(eStructuralFeature);
//							}
//						}
//					}
					Attribute attribute = entityBN.getAttributeBNWithSuper(eStructuralFeature.getName());
					if (attribute != null && attribute instanceof ExplicitAttribute) {
						if (!entityBN.isDerived(eStructuralFeature.getName()) || entityBN.isDerivedOverride(eStructuralFeature.getName())) {
							set.add(eStructuralFeature);
						}
					}
				}
				useForSerialization.put(eClass, set);
				return set;
			}
		}
		return null;
	}

	private synchronized Set<EStructuralFeature> buildUseForDatabaseStorage(EClass eClass) {
		if (this.getSchemaDefinition() != null) {
			HashSet<EStructuralFeature> set = new HashSet<>();
			for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
				EntityDefinition entityBN = this.getSchemaDefinition().getEntityBN(eClass.getName());
				if (entityBN == null) {
					set.add(eStructuralFeature);
				} else {
					if (!entityBN.isDerived(eStructuralFeature.getName())) {
						boolean derived = false;
						if (eStructuralFeature.getEAnnotation("hidden") != null) {
							if (eStructuralFeature.getEAnnotation("asstring") == null) {
							} else {
								if (entityBN.isDerived(eStructuralFeature.getName().substring(0, eStructuralFeature.getName().length() - 8))) {
									derived = true;
								} else {
									set.add(eStructuralFeature);
								}
							}
						}
						Attribute attribute = entityBN.getAttributeBNWithSuper(eStructuralFeature.getName());
						if (attribute == null) {
							// geometry, *AsString
							if (!derived) {
								set.add(eStructuralFeature);
							}
						} else {
							if (attribute instanceof ExplicitAttribute || attribute instanceof InverseAttribute) {
								if (!entityBN.isDerived(attribute.getName())) {
									set.add(eStructuralFeature);
								}
							}
						}
					}
				}
			}
			useForDatabaseStorage.put(eClass, set);
			return set;
		}
		return null;
	}

	public int getUnsettedLength(EClass eClass) {
		Integer integer = unsettedLengths.get(eClass);
		if (integer == null) {
			return calculateUnsettedLength(eClass);
		}
		return integer;
	}
	
	public boolean hasInverse(EReference eReference) {
		if (hasInverseCache.containsKey(eReference)) {
			return hasInverseCache.get(eReference);
		}
		boolean hasInverse = false;
		if (eReference.getEOpposite() != null) {
			hasInverse = isInverse(eReference.getEOpposite());
		}
		if (!hasInverse) {
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements()) {
				hasInverse = true;
			}
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcPresentationLayerAssignment_AssignedItems()) {
				hasInverse = true;
			}
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRelAssociates_RelatedObjects()) {
				hasInverse = true;
			}
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcTerminatorSymbol_AnnotatedCurve()) {
				hasInverse = true;
			}
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRelReferencedInSpatialStructure_RelatedElements()) {
				hasInverse = true;
			}
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcProduct_Representation()) {
				hasInverse = true;
			}
			if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement()) {
				hasInverse = true;
			}
		}
		hasInverseCache.put(eReference, hasInverse);
		return hasInverse;
	}
	
	public EReference getInverseOrOpposite(EClass eClassOfOtherEnd, EStructuralFeature eStructuralFeature) {
		if (eStructuralFeature instanceof EAttribute) {
			return null;
		}
		EReference eReference = (EReference)eStructuralFeature;
		if (eReference.getEOpposite() != null) {
			return eReference.getEOpposite();
		}
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements()) {
			if (Ifc2x3tc1Package.eINSTANCE.getIfcElement().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcElement_ContainedInStructure();
			} else if (Ifc2x3tc1Package.eINSTANCE.getIfcAnnotation().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcAnnotation_ContainedInStructure();
			} else if (Ifc2x3tc1Package.eINSTANCE.getIfcGrid().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcGrid_ContainedInStructure();
			}
		}
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcPresentationLayerAssignment_AssignedItems()) {
			if (Ifc2x3tc1Package.eINSTANCE.getIfcRepresentation().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcRepresentation_LayerAssignments();
			} else if (Ifc2x3tc1Package.eINSTANCE.getIfcRepresentationItem().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcRepresentationItem_LayerAssignments();
			}
		}
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcRelAssociates_RelatedObjects()) {
			if (Ifc2x3tc1Package.eINSTANCE.getIfcObjectDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcObjectDefinition_HasAssociations();
			} else if (Ifc2x3tc1Package.eINSTANCE.getIfcPropertyDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcPropertyDefinition_HasAssociations();
			}
		}
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcTerminatorSymbol_AnnotatedCurve()) {
			if (Ifc2x3tc1Package.eINSTANCE.getIfcDimensionCurve().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcDimensionCurve_AnnotatedBySymbols();
			}
		}
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcRelReferencedInSpatialStructure_RelatedElements()) {
			if (Ifc2x3tc1Package.eINSTANCE.getIfcElement().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcElement_ReferencedInStructures();
			}
		}
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcProduct_Representation()) {
			if (Ifc2x3tc1Package.eINSTANCE.getIfcProductDefinitionShape().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcProductDefinitionShape_ShapeOfProduct();
			}
		}
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement()) {
			if (Ifc2x3tc1Package.eINSTANCE.getIfcStructuralItem().isSuperTypeOf(eClassOfOtherEnd)) {
				return Ifc2x3tc1Package.eINSTANCE.getIfcStructuralItem_AssignedStructuralActivity();
			}
		}
		
		// The other way around
		
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcElement_ContainedInStructure()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements();
		} else if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcAnnotation_ContainedInStructure()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements();
		} else if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcGrid_ContainedInStructure()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements();
		}
		
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcRepresentation_LayerAssignments()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcPresentationLayerAssignment_AssignedItems();
		} else if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcRepresentationItem_LayerAssignments()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcPresentationLayerAssignment_AssignedItems();
		}
		
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcObjectDefinition_HasAssociations()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcRelAssociates_RelatedObjects();
		} else if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcPropertyDefinition_HasAssociations()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcRelAssociates_RelatedObjects();
		}
		
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcStyledItem_Item()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcTerminatorSymbol_AnnotatedCurve();
		}
		
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcElement_ReferencedInStructures()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcRelReferencedInSpatialStructure_RelatedElements();
		}
		
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcProductDefinitionShape_ShapeOfProduct()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcProduct_Representation();
		}
		
		if (eStructuralFeature == Ifc2x3tc1Package.eINSTANCE.getIfcStructuralItem_AssignedStructuralActivity()) {
			return Ifc2x3tc1Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement();
		}
		
 		return null;
	}
	
	public Set<EClass> getAllEClassesThatHaveInverses() {
		Set<EClass> result = new HashSet<>();
		for (EClassifier eClassifier : getEPackage().getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EReference eReference : eClass.getEReferences()) {
					if (hasInverse(eReference)) {
						result.add(eClass);
						continue;
					}
				}
			}
		}
		return result;
	}

	public Set<EReference> getAllInverseReferences(EClass eClass) {
		Set<EReference> result = new HashSet<>();
		for (EReference eReference : eClass.getEAllReferences()) {
			if (isInverse(eReference)) {
				result.add(eReference);
			}
		}
		return result;
	}

	public Set<EReference> getAllHasInverseReferences(EClass eClass) {
		Set<EReference> result = new HashSet<>();
		for (EReference eReference : eClass.getEAllReferences()) {
			if (hasInverse(eReference)) {
				result.add(eReference);
			}
		}
		return result;
	}
}