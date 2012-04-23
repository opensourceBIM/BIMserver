package nl.tue.buildingsmart.emf;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import nl.tue.buildingsmart.express.parser.SchemaLoader;

import org.bimserver.plugins.schema.AggregationType;
import org.bimserver.plugins.schema.ArrayType;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.BaseType;
import org.bimserver.plugins.schema.BinaryType;
import org.bimserver.plugins.schema.BooleanType;
import org.bimserver.plugins.schema.DefinedType;
import org.bimserver.plugins.schema.DerivedAttribute2;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.EnumerationType;
import org.bimserver.plugins.schema.ExplicitAttribute;
import org.bimserver.plugins.schema.IntegerBound;
import org.bimserver.plugins.schema.IntegerType;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.LogicalType;
import org.bimserver.plugins.schema.NamedType;
import org.bimserver.plugins.schema.NumberType;
import org.bimserver.plugins.schema.RealType;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SelectType;
import org.bimserver.plugins.schema.SimpleType;
import org.bimserver.plugins.schema.StringType;
import org.bimserver.plugins.schema.UnderlyingType;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Express2EMF {
	private static final Logger LOGGER = LoggerFactory.getLogger(Express2EMF.class);
	private final SchemaDefinition schema;
	private final EcoreFactory eFactory;
	private final EcorePackage ePackage;
	private final EPackage schemaPack;
	private final Map<String, EDataType> simpleTypeReplacementMap = new HashMap<String, EDataType>();
	private EClass wrappedValueSuperClass;
	private EEnum tristate;

	public Express2EMF(File schemaFileName, String modelName) {
		schema = new SchemaLoader(schemaFileName.getAbsolutePath()).getSchema();
		eFactory = EcoreFactory.eINSTANCE;
		ePackage = EcorePackage.eINSTANCE;
		schemaPack = eFactory.createEPackage();
		try {
			new DerivedReader(schemaFileName, schema);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
		schemaPack.setName(modelName);
		schemaPack.setNsPrefix("iai");
		schemaPack.setNsURI("http:///buildingsmart.ifc.ecore");

		createTristate();

		addSimpleTypes();
		addDerivedTypes();
		addEnumerations();
		addClasses();
		addSupertypes();
		addHackedTypes();
		addSelects();
		addAttributes();
		addInverses();
		EClass ifcBooleanClass = (EClass) schemaPack.getEClassifier("IfcBoolean");
		ifcBooleanClass.getESuperTypes().add((EClass) schemaPack.getEClassifier("IfcValue"));
		EClass guid = (EClass) schemaPack.getEClassifier("IfcGloballyUniqueId");
		EReference ifcGuidLink = (EReference) ((EClass) schemaPack.getEClassifier("IfcRoot")).getEStructuralFeature("GlobalId");
		EReference ifcRootLink = eFactory.createEReference();
		ifcRootLink.setName("ifcRoot");
		ifcRootLink.setEType(schemaPack.getEClassifier("IfcRoot"));
		ifcRootLink.setEOpposite(ifcGuidLink);
		ifcGuidLink.setEOpposite(ifcRootLink);
		guid.getEStructuralFeatures().add(ifcRootLink);

		doRealDerivedAttributes();
		clean();
	}

	private void addHackedTypes() {
		Iterator<DefinedType> typeIter = schema.getTypes().iterator();
		while (typeIter.hasNext()) {
			DefinedType type = typeIter.next();
			if (type.getName().equals("IfcCompoundPlaneAngleMeasure")) {
				// IfcCompoundPlaneAngleMeasure is a type of LIST [3..4] OF INTEGER (http://www.steptools.com/support/stdev_docs/express/ifc2x3/html/t_ifcco-03.html)
				// We model this by using a wrapper class
				EClass ifcCompoundPlaneAngleMeasure = eFactory.createEClass();
				ifcCompoundPlaneAngleMeasure.setName(type.getName());
				schemaPack.getEClassifiers().add(ifcCompoundPlaneAngleMeasure);
				DefinedType integerType = new DefinedType("Integer");
				integerType.setDomain(new IntegerType());
				EAttribute attribute = modifySimpleType(integerType, ifcCompoundPlaneAngleMeasure);
				attribute.setUpperBound(4);
				ifcCompoundPlaneAngleMeasure.getESuperTypes().add(wrappedValueSuperClass);
			} else if (type.getName().equals("IfcComplexNumber")) {
				// IfcComplexNumber is a type of ARRAY [1..2] OF REAL (http://www.steptools.com/support/stdev_docs/express/ifc2x3/html/t_ifcco-07.html)
				// We model this by using a wrapper class
				EClass ifcComplexNumber = eFactory.createEClass();
				ifcComplexNumber.setName(type.getName());
				schemaPack.getEClassifiers().add(ifcComplexNumber);
				DefinedType realType = new DefinedType("Real");
				realType.setDomain(new RealType());
				EAttribute attribute = modifySimpleType(realType, ifcComplexNumber);
				ifcComplexNumber.getEStructuralFeature("wrappedValueAsString").setUpperBound(2);
				attribute.setUpperBound(2);
				ifcComplexNumber.getESuperTypes().add(wrappedValueSuperClass);
			} else if (type.getName().equals("IfcNullStyle")) {
				// IfcNullStyle is a type of ENUMERATION OF NULL (http://www.steptools.com/support/stdev_docs/express/ifc2x3/html/t_ifcnu-02.html)
				// We cannot simply make this an enum because it is defined as a subtype(select) of IfcPresentationStyleSelect, so we use a wrapper here, both the wrapper and
				EClassifier ifcNullStyleEnum = schemaPack.getEClassifier("IfcNullStyle");
				ifcNullStyleEnum.setName("IfcNullStyleEnum");
				
				EClass ifcNullStyleWrapper = eFactory.createEClass();
				ifcNullStyleWrapper.setName(type.getName());
				schemaPack.getEClassifiers().add(ifcNullStyleWrapper);
				
				EAttribute wrappedValue = eFactory.createEAttribute();
				wrappedValue.setName("wrappedValue");
				wrappedValue.setEType(ifcNullStyleEnum);
				ifcNullStyleWrapper.getEStructuralFeatures().add(wrappedValue);
				
				ifcNullStyleWrapper.getESuperTypes().add(wrappedValueSuperClass);
			}
		}
	}

	private void clean() {
		Iterator<EClassifier> iterator = schemaPack.getEClassifiers().iterator();
		while (iterator.hasNext()) {
			EClassifier eClassifier = iterator.next();
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (wrappedValueSuperClass.isSuperTypeOf(eClass) && !eClass.getName().equals("IfcGloballyUniqueId")) {
					if (eClass.getESuperTypes().size() == 1) {
						iterator.remove();
					}
				}
			}
		}
	}

	private void doRealDerivedAttributes() {
		for (EntityDefinition entityDefinition : schema.getEntities()) {
			for (DerivedAttribute2 attributeName : entityDefinition.getDerivedAttributes().values()) {
				EClass eClass = (EClass) schemaPack.getEClassifier(entityDefinition.getName());
				// EStructuralFeature derivedAttribute =
				// eFactory.createEReference();
				if (attributeName.getType() != null) {
					// if (attributeName.getType() instanceof EntityDefinition)
					// {
					// derivedAttribute.setEType(schemaPack.getEClassifier(((EntityDefinition)
					// attributeName.getType()).getName()));
					// } else if (attributeName.getType() instanceof
					// IntegerType) {
					// derivedAttribute.setEType(schemaPack.getEClassifier("IfcInteger"));
					// } else if (attributeName.getType() instanceof RealType) {
					// derivedAttribute.setEType(schemaPack.getEClassifier("IfcReal"));
					// } else if (attributeName.getType() instanceof
					// LogicalType) {
					// derivedAttribute.setEType(schemaPack.getEClassifier("IfcLogical"));
					if (attributeName.getType() instanceof DefinedType) {
						EClassifier eType = schemaPack.getEClassifier(((DefinedType) attributeName.getType()).getName());
						boolean found = false;
						for (EClass eSuperType : eClass.getESuperTypes()) {
							if (eSuperType.getEStructuralFeature(attributeName.getName()) != null) {
								found = true;
								break;
							}
						}
						if (wrappedValueSuperClass.isSuperTypeOf((EClass) eType) && !eType.getName().equals("IfcGloballyUniqueId")) {
							if (!found) {
								EAttribute eAttribute = eFactory.createEAttribute();
								eAttribute.setDerived(true);
								eAttribute.setName(attributeName.getName());
								if (eAttribute.getName().equals("RefLatitude") || eAttribute.getName().equals("RefLongitude")) {
									eAttribute.setUpperBound(3);
									eAttribute.setUnique(false);
								}
								EClassifier type = ((EClass) eType).getEStructuralFeature("wrappedValue").getEType();
								eAttribute.setEType(type);
								eAttribute.setUnsettable(true); // TODO find out
																// if its
																// optional
								eClass.getEStructuralFeatures().add(eAttribute);
								if (type == EcorePackage.eINSTANCE.getEDouble()) {
									EAttribute doubleStringAttribute = eFactory.createEAttribute();
									doubleStringAttribute.setName(attributeName.getName() + "AsString");
									doubleStringAttribute.setUnsettable(true); // TODO
																				// find
																				// out
																				// if
																				// its
																				// optional
									doubleStringAttribute.setEType(EcorePackage.eINSTANCE.getEString());
									eClass.getEStructuralFeatures().add(doubleStringAttribute);
								}
							}
						} else {
							if (!found) {
								EReference eReference = eFactory.createEReference();
								eReference.setName(attributeName.getName());
								eReference.setDerived(true);
								eReference.setUnsettable(true);
								eReference.setEType(eType);
								eClass.getEStructuralFeatures().add(eReference);
							}
						}
						// derivedAttribute.setEType(eType);
					}
				}
				// derivedAttribute.setName(attributeName.getName());
				// derivedAttribute.setDerived(true);
				// derivedAttribute.setTransient(true);
				// derivedAttribute.setVolatile(true);
				// if (attributeName.isCollection()) {
				// derivedAttribute.setUpperBound(-1);
				// }
				// EAnnotation annotation = eFactory.createEAnnotation();
				// annotation.setSource("http://www.iso.org/iso10303-11/EXPRESS");
				// annotation.getDetails().put("code",
				// attributeName.getExpressCode());
				// derivedAttribute.getEAnnotations().add(annotation);
				// if (eClass.getEStructuralFeature(derivedAttribute.getName())
				// == null) {
				// eClass.getEStructuralFeatures().add(derivedAttribute);
				// }
			}
		}
	}

	private void createTristate() {
		tristate = eFactory.createEEnum();
		tristate.setName("Tristate");
		EEnumLiteral trueLiteral = eFactory.createEEnumLiteral();
		trueLiteral.setName("TRUE");
		trueLiteral.setValue(0);
		EEnumLiteral falseLiteral = eFactory.createEEnumLiteral();
		falseLiteral.setName("FALSE");
		falseLiteral.setValue(1);
		EEnumLiteral undefinedLiteral = eFactory.createEEnumLiteral();
		undefinedLiteral.setName("UNDEFINED");
		undefinedLiteral.setValue(2);
		tristate.getELiterals().add(trueLiteral);
		tristate.getELiterals().add(falseLiteral);
		tristate.getELiterals().add(undefinedLiteral);
		schemaPack.getEClassifiers().add(tristate);
	}

	private void addInverses() {
		Iterator<EntityDefinition> entIter = schema.getEntities().iterator();
		while (entIter.hasNext()) {
			EntityDefinition ent = (EntityDefinition) entIter.next();
			Iterator<Attribute> attribIter = ent.getAttributes(false).iterator();
			EClass cls = (EClass) schemaPack.getEClassifier(ent.getName());
			// if (ent.getName().equals("IfcRepresentation")) {
			// InverseAttribute attrib = new
			// InverseAttribute("LayerAssignments", ent);
			// EntityDefinition entityBN =
			// schema.getEntityBN("IfcPresentationLayerAssignment");
			// attrib.setDomain(entityBN);
			// attrib.setInverted_attr((ExplicitAttribute)entityBN.getAttributeBN
			// ("AssignedItems"));
			// addInverseAttribute(attrib, cls);

			// EClass ifcLayeredItem =
			// (EClass)schemaPack.getEClassifier("IfcLayeredItem");
			// EReference createEReference = eFactory.createEReference();
			// createEReference.setName("LayerAssignments");
			// EClassifier classifier =
			// schemaPack.getEClassifier("IfcPresentationLayerAssignment");
			// createEReference.setEType(classifier);
			// EReference structuralFeature =
			// (EReference)((EClass)classifier).getEStructuralFeature
			// ("AssignedItems");
			// createEReference.setEOpposite(structuralFeature);
			// structuralFeature.setEOpposite(createEReference);
			// ifcLayeredItem.getEStructuralFeatures().add(createEReference);
			// }
			while (attribIter.hasNext()) {
				Attribute attrib = (Attribute) attribIter.next();
				// if (ent.getName().equals("IfcRepresentationItem") &&
				// attrib.getName().equals("LayerAssignments")) {
				//
				// } else {
				if (attrib instanceof InverseAttribute) {
					addInverseAttribute(attrib, cls);
				}
				// }
			}
		}
	}

	private void addInverseAttribute(Attribute attrib, EClass cls) {
		InverseAttribute inverseAttribute = (InverseAttribute) attrib;
		EReference eRef = eFactory.createEReference();
		eRef.setUnsettable(true); // Inverses are always optional?
		eRef.setName(attrib.getName());
		if (inverseAttribute.getMax_cardinality() != null) {
			IntegerBound max_cardinality = (IntegerBound) inverseAttribute.getMax_cardinality();
			if (max_cardinality.getBound_value() == -1) {
				eRef.setUpperBound(max_cardinality.getBound_value());
			} else {
				eRef.setUpperBound(max_cardinality.getBound_value() + 1);
			}
		}
		String type = (inverseAttribute).getDomain().getName();
		EClass classifier = (EClass) schemaPack.getEClassifier(type);
		eRef.setEType(classifier);
		String reverseName = inverseAttribute.getInverted_attr().getName();
		EReference reference = (EReference) classifier.getEStructuralFeature(reverseName);
		if (eRef.getEType() == classifier && reference.getEType() == cls) {
			if (eRef.isMany()) {
				eRef.setUnique(true);
			}
			if (reference.isMany()) {
				reference.setUnique(true);
			}
			reference.setEOpposite(eRef);
			eRef.setEOpposite(reference);
		} else {
			LOGGER.info("Inverse mismatch");
			LOGGER.info(classifier.getName() + "." + reference.getName() + " => " + cls.getName() + "." + eRef.getName());
		}
		cls.getEStructuralFeatures().add(eRef);
	}

	private void addAttributes() {
		Iterator<EntityDefinition> entIter = schema.getEntities().iterator();
		while (entIter.hasNext()) {
			EntityDefinition ent = (EntityDefinition) entIter.next();
			Iterator<Attribute> attribIter = ent.getAttributes(false).iterator();
			while (attribIter.hasNext()) {
				Attribute attrib = (Attribute) attribIter.next();
				if (attrib instanceof ExplicitAttribute) {
					processAttribute(ent, attrib);
				}
			}
		}
	}

	private void processAttribute(EntityDefinition ent, Attribute attrib) {
		ExplicitAttribute expAttrib = (ExplicitAttribute) attrib;
		BaseType domain = expAttrib.getDomain();
		if (domain instanceof NamedType) {
			NamedType nt = (NamedType) domain;
			if (nt instanceof EnumerationType) {
				EAttribute enumAttrib = eFactory.createEAttribute();
				enumAttrib.setUnsettable(expAttrib.isOptional());
				enumAttrib.setName(attrib.getName());
				EClassifier eType = schemaPack.getEClassifier(nt.getName());
				enumAttrib.setEType(eType);
				EClass cls = (EClass) schemaPack.getEClassifier(ent.getName());
				cls.getEStructuralFeatures().add(enumAttrib);
			} else {
				EClassifier eType = schemaPack.getEClassifier(nt.getName());
				EClass cls = (EClass) schemaPack.getEClassifier(ent.getName());
				if (wrappedValueSuperClass.isSuperTypeOf((EClass) eType) && !eType.getName().equals("IfcGloballyUniqueId")) {
					EAttribute eAttribute = eFactory.createEAttribute();
					eAttribute.setUnsettable(expAttrib.isOptional());
					eAttribute.setName(attrib.getName());
					if (eAttribute.getName().equals("RefLatitude") || eAttribute.getName().equals("RefLongitude")) {
						eAttribute.setUpperBound(3);
						eAttribute.setUnique(false);
					}
					EClassifier type = ((EClass) eType).getEStructuralFeature("wrappedValue").getEType();
					eAttribute.setEType(type);
					cls.getEStructuralFeatures().add(eAttribute);
					if (type == EcorePackage.eINSTANCE.getEDouble()) {
						EAttribute doubleStringAttribute = eFactory.createEAttribute();
						doubleStringAttribute.setName(attrib.getName() + "AsString");
						doubleStringAttribute.setEType(EcorePackage.eINSTANCE.getEString());
						doubleStringAttribute.setUnsettable(expAttrib.isOptional());
						cls.getEStructuralFeatures().add(doubleStringAttribute);
					}
				} else {
					EReference eRef = eFactory.createEReference();
					eRef.setName(attrib.getName());
					// Hardcoded hack to fix multiplicity for
					// IfcSpatialStructureElement which references
					// RefLatitude and RefLongitude
					eRef.setUnsettable(expAttrib.isOptional());
					eRef.setEType(eType);
					cls.getEStructuralFeatures().add(eRef);
				}
			}
		} else if (domain instanceof AggregationType) {
			BaseType bt = ((AggregationType) domain).getElement_type();
			EClass cls = (EClass) schemaPack.getEClassifier(ent.getName());
			if (bt instanceof NamedType) {
				NamedType nt = (NamedType) bt;
				EClassifier eType = schemaPack.getEClassifier(nt.getName());
				if (wrappedValueSuperClass.isSuperTypeOf((EClass) eType) && !eType.getName().equals("IfcGloballyUniqueId")) {
					EAttribute eAttribute = eFactory.createEAttribute();
					eAttribute.setName(attrib.getName());
					if (eAttribute.getName().equals("RefLatitude") || eAttribute.getName().equals("RefLongitude")) {
						eAttribute.setUpperBound(3);
					} else {
						eAttribute.setUpperBound(-1);
					}
					EClassifier type = ((EClass) eType).getEStructuralFeature("wrappedValue").getEType();
					eAttribute.setEType(type);
					eAttribute.setUnsettable(expAttrib.isOptional());
					eAttribute.setUnique(false);
					cls.getEStructuralFeatures().add(eAttribute);
					if (type == EcorePackage.eINSTANCE.getEDouble()) {
						EAttribute doubleStringAttribute = eFactory.createEAttribute();
						doubleStringAttribute.setName(attrib.getName() + "AsString");
						doubleStringAttribute.setEType(EcorePackage.eINSTANCE.getEString());
						doubleStringAttribute.setUpperBound(-1);
						doubleStringAttribute.setUnsettable(expAttrib.isOptional());
						doubleStringAttribute.setUpperBound(eAttribute.getUpperBound());
						doubleStringAttribute.setUnique(false);
						cls.getEStructuralFeatures().add(doubleStringAttribute);
					}
				} else if (eType == EcorePackage.eINSTANCE.getEDouble()) {
					EAttribute eAttribute = eFactory.createEAttribute();
					eAttribute.setName(attrib.getName());
					eAttribute.setUnsettable(expAttrib.isOptional());
					eAttribute.setUnique(false);
					eAttribute.setEType(EcorePackage.eINSTANCE.getEAttribute());
					cls.getEStructuralFeatures().add(eAttribute);

					EAttribute doubleStringAttribute = eFactory.createEAttribute();
					doubleStringAttribute.setName(attrib.getName() + "AsString");
					doubleStringAttribute.setUpperBound(-1);
					doubleStringAttribute.setEType(EcorePackage.eINSTANCE.getEString());
					doubleStringAttribute.setUnsettable(expAttrib.isOptional());
					doubleStringAttribute.setUpperBound(eAttribute.getUpperBound());
					doubleStringAttribute.setUnique(false);
					cls.getEStructuralFeatures().add(doubleStringAttribute);
				} else {
					EReference eRef = eFactory.createEReference();
					eRef.setUpperBound(-1);
					eRef.setName(attrib.getName());
					// Hardcoded hack to fix multiplicity for
					// IfcSpatialStructureElement which references
					// RefLatitude and RefLongitude
					eRef.setUnsettable(expAttrib.isOptional());
					eRef.setEType(eType);
					eRef.setUnique(false);
					// EClass cls = (EClass)
					// schemaPack.getEClassifier(ent.getName());
					cls.getEStructuralFeatures().add(eRef);
				}

				// EClassifier eType = schemaPack.getEClassifier(nt.getName());
				// eRef.setEType(eType);
				// cls.getEStructuralFeatures().add(eRef);
			} else if (bt instanceof RealType) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setUnsettable(expAttrib.isOptional());
				eAttribute.setName(attrib.getName());
				eAttribute.setUpperBound(-1);
				eAttribute.setUnique(false);
				eAttribute.setEType(EcorePackage.eINSTANCE.getEDouble());
				cls.getEStructuralFeatures().add(eAttribute);

				EAttribute doubleStringAttribute = eFactory.createEAttribute();
				doubleStringAttribute.setName(attrib.getName() + "AsString");
				doubleStringAttribute.setUpperBound(-1);
				doubleStringAttribute.setEType(EcorePackage.eINSTANCE.getEString());
				doubleStringAttribute.setUnsettable(expAttrib.isOptional());
				doubleStringAttribute.setUpperBound(eAttribute.getUpperBound());
				doubleStringAttribute.setUnique(false);
				cls.getEStructuralFeatures().add(doubleStringAttribute);
			} else if (bt instanceof IntegerType) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setName(attrib.getName());
				eAttribute.setUpperBound(-1);
				eAttribute.setUnique(false);
				eAttribute.setEType(EcorePackage.eINSTANCE.getEInt());
				eAttribute.setUnsettable(expAttrib.isOptional());
				cls.getEStructuralFeatures().add(eAttribute);
			} else if (bt instanceof LogicalType) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setName(attrib.getName());
				eAttribute.setUpperBound(-1);
				eAttribute.setUnique(false);
				eAttribute.setEType(EcorePackage.eINSTANCE.getEBoolean());
				eAttribute.setUnsettable(expAttrib.isOptional());
				cls.getEStructuralFeatures().add(eAttribute);
			}
			if (domain instanceof ArrayType) {
				// TODO this is not yet implmented in simpelSDAI
				// eAttrib.setLowerBound(((nl.tue.buildingsmart.express.dictionary
				// .ArrayType)domain).getLower_index());

				// One fix for this has been implemented in addHackedTypes
			}
		} else {
			EClass cls = (EClass) schemaPack.getEClassifier(ent.getName());
			if (domain == null) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setUnsettable(expAttrib.isOptional());
				eAttribute.setName(attrib.getName());
				eAttribute.setEType(tristate);
				cls.getEStructuralFeatures().add(eAttribute);
			} else if (domain instanceof IntegerType) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setUnsettable(expAttrib.isOptional());
				eAttribute.setName(attrib.getName());
				eAttribute.setEType(EcorePackage.eINSTANCE.getEInt());
				cls.getEStructuralFeatures().add(eAttribute);
			} else if (domain instanceof LogicalType) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setUnsettable(expAttrib.isOptional());
				eAttribute.setName(attrib.getName());
				eAttribute.setEType(EcorePackage.eINSTANCE.getEBoolean());
				cls.getEStructuralFeatures().add(eAttribute);
			} else if (domain instanceof RealType) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setUnsettable(expAttrib.isOptional());
				eAttribute.setName(attrib.getName());
				eAttribute.setEType(EcorePackage.eINSTANCE.getEDouble());
				cls.getEStructuralFeatures().add(eAttribute);
				EAttribute eAttributeAsString = eFactory.createEAttribute();
				eAttributeAsString.setUnsettable(expAttrib.isOptional());
				eAttributeAsString.setName(attrib.getName() + "AsString");
				eAttributeAsString.setEType(EcorePackage.eINSTANCE.getEString());
				cls.getEStructuralFeatures().add(eAttributeAsString);
			} else if (domain instanceof StringType) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setUnsettable(expAttrib.isOptional());
				eAttribute.setName(attrib.getName());
				eAttribute.setEType(EcorePackage.eINSTANCE.getEString());
				cls.getEStructuralFeatures().add(eAttribute);
			} else if (domain instanceof BinaryType) {
				EAttribute eAttribute = eFactory.createEAttribute();
				eAttribute.setUnsettable(expAttrib.isOptional());
				eAttribute.setName(attrib.getName());
				eAttribute.setEType(EcorePackage.eINSTANCE.getEByteArray());
				cls.getEStructuralFeatures().add(eAttribute);
			} else {
				throw new RuntimeException("Unknown type: " + domain);
			}
		}
	}

	private void addClasses() {
		Iterator<EntityDefinition> entIter = schema.getEntities().iterator();
		while (entIter.hasNext()) {
			EntityDefinition ent = entIter.next();
			EClass cls = eFactory.createEClass();
			cls.setName(ent.getName());
			schemaPack.getEClassifiers().add(cls);
		}
	}

	private void addSupertypes() {
		Iterator<EntityDefinition> entIter = schema.getEntities().iterator();
		while (entIter.hasNext()) {
			EntityDefinition ent = entIter.next();
			if (ent.getSupertypes().size() > 0) {
				EClass cls = (EClass) schemaPack.getEClassifier(ent.getName());
				EClass parent = (EClass) schemaPack.getEClassifier(ent.getSupertypes().get(0).getName());
				cls.getESuperTypes().add(parent);
			}
		}
	}

	private void addSelects() {
		Iterator<DefinedType> typeIter = schema.getTypes().iterator();
		while (typeIter.hasNext()) {
			DefinedType type = typeIter.next();
			if (type instanceof SelectType) {
				EClass selectType = eFactory.createEClass();
				selectType.setName(type.getName());
				selectType.setInterface(true);
				selectType.setAbstract(true);
				schemaPack.getEClassifiers().add(selectType);
				Iterator<NamedType> entIter = ((SelectType) type).getSelections().iterator();
				while (entIter.hasNext()) {
					NamedType nt = entIter.next();
					if (nt instanceof EntityDefinition) {
						EClass choice = (EClass) schemaPack.getEClassifier(nt.getName());
						choice.getESuperTypes().add(selectType);
					} else if (nt instanceof DefinedType) {
						UnderlyingType domain = ((DefinedType) nt).getDomain();
						if (domain instanceof RealType || domain instanceof StringType || domain instanceof IntegerType || domain instanceof NumberType
								|| domain instanceof LogicalType) {
							EClass choice = (EClass) schemaPack.getEClassifier(nt.getName());
							choice.getESuperTypes().add(selectType);
						} else if (domain instanceof DefinedType) {
							DefinedType dt2 = (DefinedType) (domain);
							if (dt2.getDomain() instanceof RealType) {
								EClass choice = (EClass) schemaPack.getEClassifier(nt.getName());
								choice.getESuperTypes().add(selectType);
							}
						} else if (nt instanceof SelectType) {
						} else {
							if (nt.getName().equals("IfcComplexNumber") || nt.getName().equals("IfcCompoundPlaneAngleMeasure") || nt.getName().equals("IfcBoolean") || nt.getName().equals("IfcNullStyle")) {
								EClass choice = (EClass) schemaPack.getEClassifier(nt.getName());
								choice.getESuperTypes().add(selectType);
							} else {
								System.out.println("The domain is null for " + selectType.getName() + " " + nt.getName());
							}
						}
					}
				}
			}
		}
		typeIter = schema.getTypes().iterator();
		while (typeIter.hasNext()) {
			DefinedType type = typeIter.next();
			if (type instanceof SelectType) {
				EClass selectType = (EClass) schemaPack.getEClassifier(type.getName());
				Iterator<NamedType> entIter = ((SelectType) type).getSelections().iterator();
				while (entIter.hasNext()) {
					NamedType nt = entIter.next();
					if (nt instanceof SelectType) {
						EClass choice = (EClass) schemaPack.getEClassifier(nt.getName());
						choice.getESuperTypes().add(selectType);
					}
				}
			}
		}
	}

	private EAttribute modifySimpleType(DefinedType type, EClass testType) {
		EAttribute wrapperAttrib = eFactory.createEAttribute();
		wrapperAttrib.setName("wrappedValue");
		if (type.getDomain() instanceof IntegerType) {
			wrapperAttrib.setEType(ePackage.getEInt());
		} else if (type.getDomain() instanceof RealType) {
			wrapperAttrib.setEType(ePackage.getEDouble());
		} else if (type.getDomain() instanceof StringType) {
			wrapperAttrib.setEType(ePackage.getEString());
		} else if (type.getDomain() instanceof BooleanType) {
			wrapperAttrib.setEType(schemaPack.getEClassifier("Tristate"));
		} else if (type.getDomain() instanceof NumberType) {
			wrapperAttrib.setEType(ePackage.getEDouble());
		} else if (type.getDomain() instanceof LogicalType) {
			wrapperAttrib.setEType(schemaPack.getEClassifier("Tristate"));
		}
		wrapperAttrib.setUnsettable(true);
		testType.getEStructuralFeatures().add(wrapperAttrib);
		if (wrapperAttrib.getEType() == ePackage.getEDouble()) {
			EAttribute doubleStringAttribute = eFactory.createEAttribute();
			doubleStringAttribute.setEType(ePackage.getEString());
			doubleStringAttribute.setName("wrappedValueAsString");
			doubleStringAttribute.setUnsettable(true);
			testType.getEStructuralFeatures().add(doubleStringAttribute);
		}
		return wrapperAttrib;
	}

	private void addSimpleTypes() {
		Iterator<DefinedType> typeIter = schema.getTypes().iterator();
		wrappedValueSuperClass = EcoreFactory.eINSTANCE.createEClass();
		wrappedValueSuperClass.setName("WrappedValue");
		wrappedValueSuperClass.setAbstract(true);
		schemaPack.getEClassifiers().add(wrappedValueSuperClass);
		while (typeIter.hasNext()) {
			DefinedType type = typeIter.next();
			if (type.getDomain() instanceof SimpleType) {
				EClass testType = eFactory.createEClass();
				testType.getESuperTypes().add(wrappedValueSuperClass);
				testType.setName(type.getName());
				modifySimpleType(type, testType);
				schemaPack.getEClassifiers().add(testType);
			}
		}
	}

	/**
	 * constructs the EXPRESS TYPEs like IfcPositiveLength measure that are not
	 * simple types but derived types: <code>
	 * TYPE IfcPositiveLengthMeasure = IfcLengthMeasure;
	 * WHERE
	 *  WR1 : SELF > 0.;
	 * END_TYPE;
	 * </code>
	 */
	private void addDerivedTypes() {
		Iterator<DefinedType> typeIter = schema.getTypes().iterator();
		while (typeIter.hasNext()) {
			DefinedType type = typeIter.next();
			// debug (type.getName()+":"+type.getDomain(true).toString());
			// if ((type.getDomain() instanceof SimpleType)==false &&
			// (type instanceof EnumerationType)==false &&
			// (type instanceof SelectType)==false){

			/*
			 * one of the hard things TODO : TYPE IfcCompoundPlaneAngleMeasure =
			 * LIST [3:3] OF INTEGER; WHERE WR1 : { -360 <= SELF[1] < 360 }; WR2
			 * : { -60 <= SELF[2] < 60 }; WR3 : { -60 <= SELF[3] < 60 }; WR4 :
			 * ((SELF[1] >= 0) AND (SELF[2] >= 0) AND (SELF[3] >= 0)) OR
			 * ((SELF[1] <= 0) AND (SELF[2] <= 0) AND (SELF[3] <= 0)); END_TYPE;
			 * 
			 * I am skipping this for now, it only occurs once in the model
			 * future versions should definitely find an answer to this
			 * 
			 * A fix for this has been implemented in addHackedTypes
			 */
			if (type.getName().equalsIgnoreCase("IfcCompoundPlaneAngleMeasure")) {
				EClass testType = eFactory.createEClass();
				testType.setName(type.getName());
				DefinedType type2 = new DefinedType("Integer");
				type2.setDomain(new IntegerType());
				modifySimpleType(type2, testType);
				schemaPack.getEClassifiers().add(testType);
				testType.getESuperTypes().add(wrappedValueSuperClass);
			} else if (type.getDomain() instanceof DefinedType) {
				if (schemaPack.getEClassifier(type.getName()) != null) {
					EClass testType = (EClass) schemaPack.getEClassifier(type.getName());
					DefinedType domain = (DefinedType) type.getDomain();
					EClassifier classifier = schemaPack.getEClassifier(domain.getName());
					testType.getESuperTypes().add((EClass) classifier);
					testType.setInstanceClass(classifier.getInstanceClass());
				} else {
					EClass testType = eFactory.createEClass();
					testType.setName(type.getName());
					DefinedType domain = (DefinedType) type.getDomain();
					if (simpleTypeReplacementMap.containsKey(domain.getName())) {
						// We can't subclass because it's a 'primitive' type
						simpleTypeReplacementMap.put(type.getName(), simpleTypeReplacementMap.get(domain.getName()));
					} else {
						EClassifier classifier = null;
						classifier = schemaPack.getEClassifier(domain.getName());
						schemaPack.getEClassifier(domain.getName());
						testType.getESuperTypes().add((EClass) classifier);
						testType.setInstanceClass(classifier.getInstanceClass());
						schemaPack.getEClassifiers().add(testType);
					}
				}
			}
		}
	}

	private void addEnumerations() {
		Iterator<DefinedType> typeIter = schema.getTypes().iterator();
		while (typeIter.hasNext()) {
			DefinedType type = typeIter.next();
			if (type instanceof EnumerationType) {
				EEnum enumeration = eFactory.createEEnum();
				enumeration.setName(type.getName());

				EEnumLiteral nullValue = eFactory.createEEnumLiteral();
				nullValue.setName("NULL");
				nullValue.setLiteral("NULL");
				nullValue.setValue(0);
				enumeration.getELiterals().add(nullValue);

				int counter = 1;
				Iterator<String> values = ((EnumerationType) type).getElements().iterator();
				while (values.hasNext()) {
					String stringVal = values.next();
					if (!stringVal.equals("NULL")) {
						EEnumLiteral value = eFactory.createEEnumLiteral();
						value.setName(stringVal);
						value.setLiteral(stringVal);
						value.setValue(counter);
						counter++;
						enumeration.getELiterals().add(value);
					}
				}
				schemaPack.getEClassifiers().add(enumeration);
			}
		}
	}

	public void writeEMF(String fileName) {
		ResourceSet metaResourceSet = new ResourceSetImpl();
		metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());

		URI resUri = URI.createURI(fileName);
		Resource metaResource = metaResourceSet.createResource(resUri);
		metaResource.getContents().add(schemaPack);
		try {
			metaResource.save(null);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
}