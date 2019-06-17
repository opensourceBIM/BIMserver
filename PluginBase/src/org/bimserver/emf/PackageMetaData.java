package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
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

import nl.tue.buildingsmart.emf.SchemaLoader;
import nl.tue.buildingsmart.schema.Attribute;
import nl.tue.buildingsmart.schema.EntityDefinition;
import nl.tue.buildingsmart.schema.ExplicitAttribute;
import nl.tue.buildingsmart.schema.InverseAttribute;
import nl.tue.buildingsmart.schema.SchemaDefinition;

public class PackageMetaData implements ObjectFactory, Comparable<PackageMetaData> {
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
	private final Set<PackageMetaData> dependencies = new TreeSet<>();
	private SchemaDefinition schemaDefinition;
	private final Map<EClass, Set<EStructuralFeature>> useForSerialization = new HashMap<>();
	private final Map<EClass, Set<EStructuralFeature>> useForDatabaseStorage = new HashMap<>();
	private final Map<EClass, OppositeInfo> oppositeInfos = new HashMap<>();
	private final Map<EClass, Integer> unsettedLengths = new HashMap<EClass, Integer>();
	private Path schemaPath;

	public PackageMetaData(EPackage ePackage, Schema schema, Path tempDir) {
		LOGGER.info("Initializing " + schema + " with " + ePackage.getName());
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
				if (schema == Schema.IFC2X3TC1) {
					schemaDefinition = SchemaLoader.loadIfc2x3tc1();
				} else if (schema == Schema.IFC4) {
					schemaDefinition = SchemaLoader.loadIfc4();
				} else {
					LOGGER.error("Unimplemented schema: " + schema);
				}
				for (EClassifier eClassifier : ePackage.getEClassifiers()) {
					if (eClassifier instanceof EClass) {
						EClass eClass = (EClass)eClassifier;
						buildUseForSerializationSet(eClass);
						buildUseForDatabaseStorage(eClass);
					}
				}
				schemaPath = tempDir.resolve(schema.name() + ".exp");
				if (!Files.exists(schemaPath)) {
					if (!Files.exists(tempDir)) {
						Files.createDirectories(tempDir);
					}
					Files.write(schemaPath, schemaDefinition.getSchemaData());
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		}
		
		try {
			initUnsettedLengths();
			if (ePackage == Ifc2x3tc1Package.eINSTANCE || ePackage == Ifc4Package.eINSTANCE) {
				// Only do this for IFC schemas, other schemas do not have inverses (since that's an express concept)
				initInverses();
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	private void initInverses() {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EReference eReference : eClass.getEReferences()) {
					initIsInverse(eReference);
				}
			}
		}
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				for (EReference eReference : eClass.getEReferences()) {
					initHasInverse(eReference);
				}
			}
		}
	}
	
	private void initHasInverse(EReference eReference) {
		/*
		 * This has been implemented manually, but with the assistance of the output of Express2Emf (which dumps all the mismatched inverses in the schema).
		 * Code has been updated for IFC4_ADD2
		 * 
		 */
		boolean hasInverse = false;
		if (eReference.getEOpposite() != null) {
			hasInverse = isInverse(eReference.getEOpposite());
		}
		if (!hasInverse) {
			if (eReference.getEContainingClass().getEPackage() == Ifc2x3tc1Package.eINSTANCE) {
				if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements()) {
					hasInverse = true;
				} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcPresentationLayerAssignment_AssignedItems()) {
					hasInverse = true;
				} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRelAssociates_RelatedObjects()) {
					hasInverse = true;
				} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcTerminatorSymbol_AnnotatedCurve()) {
					hasInverse = true;
				} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRelReferencedInSpatialStructure_RelatedElements()) {
					hasInverse = true;
				} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcProduct_Representation()) {
					hasInverse = true;
				} else if (eReference == Ifc2x3tc1Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement()) {
					hasInverse = true;
				}
			} else if (eReference.getEContainingClass().getEPackage() == Ifc4Package.eINSTANCE) {
				if (eReference == Ifc4Package.eINSTANCE.getIfcExternalReferenceRelationship_RelatedResourceObjects()) {
					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements()) {
					hasInverse = true;
					// Removed in IFC4 _after_ IFC4-final
//				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelCoversBldgElements_RelatingBuildingElement()) {
//					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssociatesClassification_RelatingClassification()) {
					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcClassificationReference_ReferencedSource()) {
					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelDefinesByProperties_RelatedObjects()) {
					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssociatesDocument_RelatingDocument()) {
					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelReferencedInSpatialStructure_RelatedElements()) {
					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelSpaceBoundary_RelatingSpace()) {
					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssociatesLibrary_RelatingLibrary()) {
					hasInverse = true;
				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssociatesMaterial_RelatingMaterial()) {
					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelDeclares_RelatedDefinitions()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssociates_RelatedObjects()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssignsToProcess_RelatingProcess()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssignsToProduct_RelatingProduct()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcProduct_Representation()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcShapeAspect_PartOfProductDefinitionShape()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelDefinesByProperties_RelatingPropertyDefinition()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcPresentationLayerAssignment_AssignedItems()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssignsToResource_RelatingResource()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement()) {
 					hasInverse = true;

 				// New in IFC4 _after_ IFC4-final
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcCoordinateOperation_SourceCRS()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssignsToProduct_RelatingProduct()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcResourceConstraintRelationship_RelatedResourceObjects()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcResourceApprovalRelationship_RelatedResourceObjects()) {
 					hasInverse = true;
 				} else if (eReference == Ifc4Package.eINSTANCE.getIfcRelAssignsToProduct_RelatingProduct()) {
 					hasInverse = true;
 				}			
			} 
		}
		hasInverseCache.put(eReference, hasInverse);
	}
	
	private void initIsInverse(EReference eReference) {
		EntityDefinition entityBN = schemaDefinition.getEntityBNNoCaseConvert(upperCases.get(eReference.getEContainingClass()));
		if (entityBN == null) {
			return;
		}
		Attribute attributeBNWithSuper = entityBN.getAttributeBNWithSuper(eReference.getName());
		boolean isInverse = entityBN != null && attributeBNWithSuper instanceof InverseAttribute;
		
		// TODO seems like IFC4 needs to be added as well here?
		
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
	}

	private void initUnsettedLengths() {
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				calculateUnsettedLength(eClass, null);
			}
		}
	}

	private int calculateUnsettedLength(EClass eClass, EAttribute skipAttribute) {
		int fieldCounter = 0;
		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (feature == skipAttribute) {
				continue;
			}
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
		return useForSerialization.get(eClass).contains(eStructuralFeature);
	}

	public boolean useForDatabaseStorage(EClass eClass, EStructuralFeature eStructuralFeature) {
		if (this.getSchemaDefinition() == null) {
			return true;
		}
		Set<EStructuralFeature> set = useForDatabaseStorage.get(eClass);
		if (set == null) {
			return true;
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
		throw new RuntimeException("Inverse cache not initialized for " + eReference.getName());
	}

	// This is a slow method, but only used in code generators
	@SuppressWarnings("unchecked")
	public Set<EClass> getDirectSubClasses(EClass superClass) {
		if (!directSubClasses.containsKey(superClass.getName())) {
			return java.util.Collections.EMPTY_SET;
		}
		// Converting to TreeSet in order to make the orders stable, this way the generated source will be more stable (not change all the time)
		Set<EClass> result = new TreeSet<EClass>(new Comparator<EClass>() {
			@Override
			public int compare(EClass o1, EClass o2) {
				return o1.getName().compareTo(o2.getName());
			}});
		result.addAll(directSubClasses.get(superClass.getName()));
		return result;
	}
	
	public Set<EClass> getAllSubClasses(EClass superClass) {
		Set<EClass> set = allSubClasses.get(superClass.getName());
		if (set == null) {
			for (PackageMetaData dep : getDependencies()) {
				Set<EClass> allSubClasses2 = dep.getAllSubClasses(superClass);
				if (allSubClasses2 != null) {
					return allSubClasses2;
				}
			}
		}
		return set;
	}

	public Set<EClass> getAllSubClassesIncludingSelf(EClass superClass) {
		Set<EClass> set = new TreeSet<>(getAllSubClasses(superClass));
		set.add(superClass);
		return set;
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
		if (eClass.getEPackage() == ePackage) {
			return (T) ePackage.getEFactoryInstance().create(eClass);
		} else {
			for (PackageMetaData dep : dependencies) {
				if (dep.has(eClass)) {
					return dep.create(eClass);
				}
			}
		}
		throw new RuntimeException("Mismatch");
	}

	private boolean has(EClass eClass) {
		return eClass.getEPackage() == ePackage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IdEObject> T create(Class<T> clazz) {
		EClass eClassIncludingDependencies = getEClassIncludingDependencies(clazz);
		return (T) eClassIncludingDependencies.getEPackage().getEFactoryInstance().create(eClassIncludingDependencies);
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
		return useForSerialization.get(eClass).size();
	}

	public int getNrDatabaseFeatures(EClass eClass) {
		return useForDatabaseStorage.get(eClass).size();
	}

	private void buildUseForSerializationSet(EClass eClass) {
		if (this.getSchemaDefinition() != null) {
			if (!useForSerialization.containsKey(eClass)) {
				Set<EStructuralFeature> set = new HashSet<>();
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
					if (entityBN != null) {
						Attribute attribute = entityBN.getAttributeBNWithSuper(eStructuralFeature.getName());
						if (attribute != null && attribute instanceof ExplicitAttribute) {
							if (!entityBN.isDerived(eStructuralFeature.getName()) || entityBN.isDerivedOverride(eStructuralFeature.getName())) {
								set.add(eStructuralFeature);
							}
						}
					}
				}
				useForSerialization.put(eClass, set);
			}
		}
	}

	private void buildUseForDatabaseStorage(EClass eClass) {
		if (this.getSchemaDefinition() != null) {
			Set<EStructuralFeature> set = new HashSet<>();
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
		}
	}

	public int getUnsettedLength(EClass eClass) {
		return getUnsettedLength(eClass, null);
	}

	public int getUnsettedLength(EClass eClass, EAttribute skipAttribute) {
		Integer integer = unsettedLengths.get(eClass);
		if (integer == null) {
			return calculateUnsettedLength(eClass, skipAttribute);
		}
		return integer;
	}
	
	public boolean hasInverse(EReference eReference) {
		if (hasInverseCache.containsKey(eReference)) {
			return hasInverseCache.get(eReference);
		}
		throw new RuntimeException("Has inverse cache not initialized for " + eReference.getName());
	}
	
	public EReference getInverseOrOpposite(EClass eClassOfOtherEnd, EStructuralFeature eStructuralFeature) {
		/*
		 * This has been implemented manually, but with the assistance of the output of Express2Emf (which dumps all the mismatched inverses in the schema).
		 * Code has been updated for IFC4_ADD2
		 * 
		 */
		if (eStructuralFeature instanceof EAttribute) {
			return null;
		}
		EReference eReference = (EReference)eStructuralFeature;
		if (eReference.getEOpposite() != null) {
			return eReference.getEOpposite();
		}
		if (eReference.getEContainingClass().getEPackage() == Ifc2x3tc1Package.eINSTANCE) {
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
			
			// The other way around, is this really necessary? Aren't those defined as inverses anyways?
			
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
		} else if (eStructuralFeature.getEContainingClass().getEPackage() == Ifc4Package.eINSTANCE) {
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelContainedInSpatialStructure_RelatedElements()) {
				if (Ifc4Package.eINSTANCE.getIfcElement().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcElement_ContainedInStructure();
				} else if (Ifc4Package.eINSTANCE.getIfcAnnotation().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcAnnotation_ContainedInStructure();
				} else if (Ifc4Package.eINSTANCE.getIfcGrid().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcGrid_ContainedInStructure();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcPresentationLayerAssignment_AssignedItems()) {
				if (Ifc4Package.eINSTANCE.getIfcRepresentation().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcRepresentation_LayerAssignments();
				} else if (Ifc4Package.eINSTANCE.getIfcRepresentationItem().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcRepresentationItem_LayerAssignment();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssociates_RelatedObjects()) {
				if (Ifc4Package.eINSTANCE.getIfcObjectDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcObjectDefinition_HasAssociations();
				} else if (Ifc4Package.eINSTANCE.getIfcPropertyDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcPropertyDefinition_HasAssociations();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelReferencedInSpatialStructure_RelatedElements()) {
				if (Ifc4Package.eINSTANCE.getIfcElement().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcElement_ReferencedInStructures();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcProduct_Representation()) {
				if (Ifc4Package.eINSTANCE.getIfcProductDefinitionShape().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcProductDefinitionShape_ShapeOfProduct();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement()) {
				if (Ifc4Package.eINSTANCE.getIfcStructuralItem().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcStructuralItem_AssignedStructuralActivity();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcExternalReferenceRelationship_RelatedResourceObjects()) {
				if (Ifc4Package.eINSTANCE.getIfcActorRole().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcActorRole_HasExternalReference();
				} else if (Ifc4Package.eINSTANCE.getIfcAppliedValue().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcAppliedValue_HasExternalReference();
				} else if (Ifc4Package.eINSTANCE.getIfcApproval().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcApproval_HasExternalReferences();
				} else if (Ifc4Package.eINSTANCE.getIfcConstraint().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcConstraint_HasExternalReferences();
				} else if (Ifc4Package.eINSTANCE.getIfcContextDependentUnit().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcContextDependentUnit_HasExternalReference();
				} else if (Ifc4Package.eINSTANCE.getIfcConversionBasedUnit().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcConversionBasedUnit_HasExternalReference();
				} else if (Ifc4Package.eINSTANCE.getIfcMaterialDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcMaterialDefinition_HasExternalReferences();
				} else if (Ifc4Package.eINSTANCE.getIfcPhysicalQuantity().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcPhysicalQuantity_HasExternalReferences();
				} else if (Ifc4Package.eINSTANCE.getIfcProfileDef().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcProfileDef_HasExternalReference();
				} else if (Ifc4Package.eINSTANCE.getIfcPropertyAbstraction().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcPropertyAbstraction_HasExternalReferences();
				} else if (Ifc4Package.eINSTANCE.getIfcTimeSeries().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcTimeSeries_HasExternalReference();
				}
			}
			// Removed in IFC4 _after_ IFC4-final
//			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelCoversBldgElements_RelatingBuildingElement()) {
//				if (Ifc4Package.eINSTANCE.getIfcBuildingElement().isSuperTypeOf(eClassOfOtherEnd)) {
//					return Ifc4Package.eINSTANCE.getIfcBuildingElement_HasCoverings();
//				}
//			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssociatesClassification_RelatingClassification()) {
				if (Ifc4Package.eINSTANCE.getIfcClassification().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcClassification_ClassificationForObjects();
				} else if (Ifc4Package.eINSTANCE.getIfcClassificationReference().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcClassificationReference_ClassificationRefForObjects();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcClassificationReference_ReferencedSource()) {
				if (Ifc4Package.eINSTANCE.getIfcClassification().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcClassification_HasReferences();
				} else if (Ifc4Package.eINSTANCE.getIfcClassificationReference().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcClassificationReference_HasReferences();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelDefinesByProperties_RelatedObjects()) {
				if (Ifc4Package.eINSTANCE.getIfcContext().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcContext_IsDefinedBy();
				} else if (Ifc4Package.eINSTANCE.getIfcObject().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcObject_IsDefinedBy();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssociatesDocument_RelatingDocument()) {
				if (Ifc4Package.eINSTANCE.getIfcDocumentInformation().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcDocumentInformation_DocumentInfoForObjects();
				} else if (Ifc4Package.eINSTANCE.getIfcDocumentReference().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcDocumentReference_DocumentRefForObjects();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelSpaceBoundary_RelatingSpace()) {
				if (Ifc4Package.eINSTANCE.getIfcExternalSpatialElement().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcExternalSpatialElement_BoundedBy();
				} else if (Ifc4Package.eINSTANCE.getIfcSpace().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcSpace_BoundedBy();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssociatesLibrary_RelatingLibrary()) {
				if (Ifc4Package.eINSTANCE.getIfcLibraryInformation().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcLibraryInformation_LibraryInfoForObjects();
				} else if (Ifc4Package.eINSTANCE.getIfcLibraryReference().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcLibraryReference_LibraryRefForObjects();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssociatesMaterial_RelatingMaterial()) {
				if (Ifc4Package.eINSTANCE.getIfcMaterialDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcMaterialDefinition_AssociatedTo();
				} else if (Ifc4Package.eINSTANCE.getIfcMaterialUsageDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcMaterialUsageDefinition_AssociatedTo();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelDeclares_RelatedDefinitions()) {
				if (Ifc4Package.eINSTANCE.getIfcObjectDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcObjectDefinition_HasContext();
				} else if (Ifc4Package.eINSTANCE.getIfcPropertyDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcPropertyDefinition_HasContext();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssignsToProcess_RelatingProcess()) {
				if (Ifc4Package.eINSTANCE.getIfcProcess().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcProcess_OperatesOn();
					
				// Removed in IFC4 _after_ IFC4-final
//				} else if (Ifc4Package.eINSTANCE.getIfcProduct().isSuperTypeOf(eClassOfOtherEnd)) {
//					return Ifc4Package.eINSTANCE.getIfcProduct_ReferencedBy();
//				} else if (Ifc4Package.eINSTANCE.getIfcTypeProduct().isSuperTypeOf(eClassOfOtherEnd)) {
//					return Ifc4Package.eINSTANCE.getIfcTypeProduct_ReferencedBy();
				} else if (Ifc4Package.eINSTANCE.getIfcTypeProcess().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcTypeProcess_OperatesOn();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcShapeAspect_PartOfProductDefinitionShape()) {
				if (Ifc4Package.eINSTANCE.getIfcProductDefinitionShape().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcProductDefinitionShape_HasShapeAspects();
				} else if (Ifc4Package.eINSTANCE.getIfcRepresentationMap().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcRepresentationMap_HasShapeAspects();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelDefinesByProperties_RelatingPropertyDefinition()) {
				if (Ifc4Package.eINSTANCE.getIfcPropertySetDefinition().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcPropertySetDefinition_DefinesOccurrence();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssignsToResource_RelatingResource()) {
				if (Ifc4Package.eINSTANCE.getIfcResource().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcResource_ResourceOf();
				} else if (Ifc4Package.eINSTANCE.getIfcTypeResource().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcTypeResource_ResourceOf();
				}
			}
			// New in IFC4 _after_ IFC4-final
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcCoordinateOperation_SourceCRS()) {
				if (Ifc4Package.eINSTANCE.getIfcCoordinateReferenceSystem().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcCoordinateReferenceSystem_HasCoordinateOperation();
				} else if (Ifc4Package.eINSTANCE.getIfcGeometricRepresentationContext().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcGeometricRepresentationContext_HasCoordinateOperation();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssignsToProduct_RelatingProduct()) {
				if (Ifc4Package.eINSTANCE.getIfcProduct().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcProduct_ReferencedBy();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcResourceConstraintRelationship_RelatedResourceObjects()) {
				if (Ifc4Package.eINSTANCE.getIfcProperty().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcProperty_HasConstraints();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcResourceApprovalRelationship_RelatedResourceObjects()) {
				if (Ifc4Package.eINSTANCE.getIfcProperty().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcProperty_HasApprovals();
				}
			}
			if (eStructuralFeature == Ifc4Package.eINSTANCE.getIfcRelAssignsToProduct_RelatingProduct()) {
				if (Ifc4Package.eINSTANCE.getIfcTypeProduct().isSuperTypeOf(eClassOfOtherEnd)) {
					return Ifc4Package.eINSTANCE.getIfcTypeProduct_ReferencedBy();
				}
			}
		}
		
 		return null;
	}
	
	public Set<EClass> getAllEClassesThatHaveInverses() {
		// TODO cache
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
		// TODO cache
		Set<EReference> result = new HashSet<>();
		for (EReference eReference : eClass.getEAllReferences()) {
			if (isInverse(eReference)) {
				result.add(eReference);
			}
		}
		return result;
	}

	public Set<EReference> getAllHasInverseReferences(EClass eClass) {
		// TODO cache
		Set<EReference> result = new HashSet<>();
		for (EReference eReference : eClass.getEAllReferences()) {
			if (hasInverse(eReference)) {
				result.add(eReference);
			}
		}
		return result;
	}

	public boolean hasInverses(EClass eClass) {
		for (EReference eReference : eClass.getEAllReferences()) {
			if (hasInverse(eReference)) {
				return true;
			}
		}
		return false;
	}

	public SchemaDefinition getSchemaDefinition() {
		return schemaDefinition;
	}

	public Path getSchemaPath() {
		return schemaPath;
	}

	public List<EClass> getAllClasses() {
		List<EClass> result = new ArrayList<>();
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				result.add((EClass)eClassifier);
			}
		}
		return result;
	}

	@Override
	public int compareTo(PackageMetaData o) {
		return getSchema().compareTo(o.getSchema());
	}
}