/**
 * Copyright (C) 2009-2014 BIMserver.org
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
 */
package org.bimserver.models.ifc2x3tc1.impl;

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

import org.bimserver.models.ifc2x3tc1.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Ifc2x3tc1FactoryImpl extends EFactoryImpl implements Ifc2x3tc1Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ifc2x3tc1Factory init() {
		try {
			Ifc2x3tc1Factory theIfc2x3tc1Factory = (Ifc2x3tc1Factory) EPackage.Registry.INSTANCE
					.getEFactory(Ifc2x3tc1Package.eNS_URI);
			if (theIfc2x3tc1Factory != null) {
				return theIfc2x3tc1Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Ifc2x3tc1FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifc2x3tc1FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case Ifc2x3tc1Package.IFC2_DCOMPOSITE_CURVE:
			return (EObject) createIfc2DCompositeCurve();
		case Ifc2x3tc1Package.IFC_ACTION_REQUEST:
			return (EObject) createIfcActionRequest();
		case Ifc2x3tc1Package.IFC_ACTOR:
			return (EObject) createIfcActor();
		case Ifc2x3tc1Package.IFC_ACTOR_ROLE:
			return (EObject) createIfcActorRole();
		case Ifc2x3tc1Package.IFC_ACTUATOR_TYPE:
			return (EObject) createIfcActuatorType();
		case Ifc2x3tc1Package.IFC_ADDRESS:
			return (EObject) createIfcAddress();
		case Ifc2x3tc1Package.IFC_AIR_TERMINAL_BOX_TYPE:
			return (EObject) createIfcAirTerminalBoxType();
		case Ifc2x3tc1Package.IFC_AIR_TERMINAL_TYPE:
			return (EObject) createIfcAirTerminalType();
		case Ifc2x3tc1Package.IFC_AIR_TO_AIR_HEAT_RECOVERY_TYPE:
			return (EObject) createIfcAirToAirHeatRecoveryType();
		case Ifc2x3tc1Package.IFC_ALARM_TYPE:
			return (EObject) createIfcAlarmType();
		case Ifc2x3tc1Package.IFC_ANGULAR_DIMENSION:
			return (EObject) createIfcAngularDimension();
		case Ifc2x3tc1Package.IFC_ANNOTATION:
			return (EObject) createIfcAnnotation();
		case Ifc2x3tc1Package.IFC_ANNOTATION_CURVE_OCCURRENCE:
			return (EObject) createIfcAnnotationCurveOccurrence();
		case Ifc2x3tc1Package.IFC_ANNOTATION_FILL_AREA:
			return (EObject) createIfcAnnotationFillArea();
		case Ifc2x3tc1Package.IFC_ANNOTATION_FILL_AREA_OCCURRENCE:
			return (EObject) createIfcAnnotationFillAreaOccurrence();
		case Ifc2x3tc1Package.IFC_ANNOTATION_OCCURRENCE:
			return (EObject) createIfcAnnotationOccurrence();
		case Ifc2x3tc1Package.IFC_ANNOTATION_SURFACE:
			return (EObject) createIfcAnnotationSurface();
		case Ifc2x3tc1Package.IFC_ANNOTATION_SURFACE_OCCURRENCE:
			return (EObject) createIfcAnnotationSurfaceOccurrence();
		case Ifc2x3tc1Package.IFC_ANNOTATION_SYMBOL_OCCURRENCE:
			return (EObject) createIfcAnnotationSymbolOccurrence();
		case Ifc2x3tc1Package.IFC_ANNOTATION_TEXT_OCCURRENCE:
			return (EObject) createIfcAnnotationTextOccurrence();
		case Ifc2x3tc1Package.IFC_APPLICATION:
			return (EObject) createIfcApplication();
		case Ifc2x3tc1Package.IFC_APPLIED_VALUE:
			return (EObject) createIfcAppliedValue();
		case Ifc2x3tc1Package.IFC_APPLIED_VALUE_RELATIONSHIP:
			return (EObject) createIfcAppliedValueRelationship();
		case Ifc2x3tc1Package.IFC_APPROVAL:
			return (EObject) createIfcApproval();
		case Ifc2x3tc1Package.IFC_APPROVAL_ACTOR_RELATIONSHIP:
			return (EObject) createIfcApprovalActorRelationship();
		case Ifc2x3tc1Package.IFC_APPROVAL_PROPERTY_RELATIONSHIP:
			return (EObject) createIfcApprovalPropertyRelationship();
		case Ifc2x3tc1Package.IFC_APPROVAL_RELATIONSHIP:
			return (EObject) createIfcApprovalRelationship();
		case Ifc2x3tc1Package.IFC_ARBITRARY_CLOSED_PROFILE_DEF:
			return (EObject) createIfcArbitraryClosedProfileDef();
		case Ifc2x3tc1Package.IFC_ARBITRARY_OPEN_PROFILE_DEF:
			return (EObject) createIfcArbitraryOpenProfileDef();
		case Ifc2x3tc1Package.IFC_ARBITRARY_PROFILE_DEF_WITH_VOIDS:
			return (EObject) createIfcArbitraryProfileDefWithVoids();
		case Ifc2x3tc1Package.IFC_ASSET:
			return (EObject) createIfcAsset();
		case Ifc2x3tc1Package.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF:
			return (EObject) createIfcAsymmetricIShapeProfileDef();
		case Ifc2x3tc1Package.IFC_AXIS1_PLACEMENT:
			return (EObject) createIfcAxis1Placement();
		case Ifc2x3tc1Package.IFC_AXIS2_PLACEMENT2_D:
			return (EObject) createIfcAxis2Placement2D();
		case Ifc2x3tc1Package.IFC_AXIS2_PLACEMENT3_D:
			return (EObject) createIfcAxis2Placement3D();
		case Ifc2x3tc1Package.IFC_BSPLINE_CURVE:
			return (EObject) createIfcBSplineCurve();
		case Ifc2x3tc1Package.IFC_BEAM:
			return (EObject) createIfcBeam();
		case Ifc2x3tc1Package.IFC_BEAM_TYPE:
			return (EObject) createIfcBeamType();
		case Ifc2x3tc1Package.IFC_BEZIER_CURVE:
			return (EObject) createIfcBezierCurve();
		case Ifc2x3tc1Package.IFC_BLOB_TEXTURE:
			return (EObject) createIfcBlobTexture();
		case Ifc2x3tc1Package.IFC_BLOCK:
			return (EObject) createIfcBlock();
		case Ifc2x3tc1Package.IFC_BOILER_TYPE:
			return (EObject) createIfcBoilerType();
		case Ifc2x3tc1Package.IFC_BOOLEAN_CLIPPING_RESULT:
			return (EObject) createIfcBooleanClippingResult();
		case Ifc2x3tc1Package.IFC_BOOLEAN_RESULT:
			return (EObject) createIfcBooleanResult();
		case Ifc2x3tc1Package.IFC_BOUNDARY_CONDITION:
			return (EObject) createIfcBoundaryCondition();
		case Ifc2x3tc1Package.IFC_BOUNDARY_EDGE_CONDITION:
			return (EObject) createIfcBoundaryEdgeCondition();
		case Ifc2x3tc1Package.IFC_BOUNDARY_FACE_CONDITION:
			return (EObject) createIfcBoundaryFaceCondition();
		case Ifc2x3tc1Package.IFC_BOUNDARY_NODE_CONDITION:
			return (EObject) createIfcBoundaryNodeCondition();
		case Ifc2x3tc1Package.IFC_BOUNDARY_NODE_CONDITION_WARPING:
			return (EObject) createIfcBoundaryNodeConditionWarping();
		case Ifc2x3tc1Package.IFC_BOUNDED_CURVE:
			return (EObject) createIfcBoundedCurve();
		case Ifc2x3tc1Package.IFC_BOUNDED_SURFACE:
			return (EObject) createIfcBoundedSurface();
		case Ifc2x3tc1Package.IFC_BOUNDING_BOX:
			return (EObject) createIfcBoundingBox();
		case Ifc2x3tc1Package.IFC_BOXED_HALF_SPACE:
			return (EObject) createIfcBoxedHalfSpace();
		case Ifc2x3tc1Package.IFC_BUILDING:
			return (EObject) createIfcBuilding();
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT:
			return (EObject) createIfcBuildingElement();
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_COMPONENT:
			return (EObject) createIfcBuildingElementComponent();
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_PART:
			return (EObject) createIfcBuildingElementPart();
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_PROXY:
			return (EObject) createIfcBuildingElementProxy();
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_PROXY_TYPE:
			return (EObject) createIfcBuildingElementProxyType();
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_TYPE:
			return (EObject) createIfcBuildingElementType();
		case Ifc2x3tc1Package.IFC_BUILDING_STOREY:
			return (EObject) createIfcBuildingStorey();
		case Ifc2x3tc1Package.IFC_CSHAPE_PROFILE_DEF:
			return (EObject) createIfcCShapeProfileDef();
		case Ifc2x3tc1Package.IFC_CABLE_CARRIER_FITTING_TYPE:
			return (EObject) createIfcCableCarrierFittingType();
		case Ifc2x3tc1Package.IFC_CABLE_CARRIER_SEGMENT_TYPE:
			return (EObject) createIfcCableCarrierSegmentType();
		case Ifc2x3tc1Package.IFC_CABLE_SEGMENT_TYPE:
			return (EObject) createIfcCableSegmentType();
		case Ifc2x3tc1Package.IFC_CALENDAR_DATE:
			return (EObject) createIfcCalendarDate();
		case Ifc2x3tc1Package.IFC_CARTESIAN_POINT:
			return (EObject) createIfcCartesianPoint();
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR:
			return (EObject) createIfcCartesianTransformationOperator();
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_D:
			return (EObject) createIfcCartesianTransformationOperator2D();
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM:
			return (EObject) createIfcCartesianTransformationOperator2DnonUniform();
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR3_D:
			return (EObject) createIfcCartesianTransformationOperator3D();
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR3_DNON_UNIFORM:
			return (EObject) createIfcCartesianTransformationOperator3DnonUniform();
		case Ifc2x3tc1Package.IFC_CENTER_LINE_PROFILE_DEF:
			return (EObject) createIfcCenterLineProfileDef();
		case Ifc2x3tc1Package.IFC_CHAMFER_EDGE_FEATURE:
			return (EObject) createIfcChamferEdgeFeature();
		case Ifc2x3tc1Package.IFC_CHILLER_TYPE:
			return (EObject) createIfcChillerType();
		case Ifc2x3tc1Package.IFC_CIRCLE:
			return (EObject) createIfcCircle();
		case Ifc2x3tc1Package.IFC_CIRCLE_HOLLOW_PROFILE_DEF:
			return (EObject) createIfcCircleHollowProfileDef();
		case Ifc2x3tc1Package.IFC_CIRCLE_PROFILE_DEF:
			return (EObject) createIfcCircleProfileDef();
		case Ifc2x3tc1Package.IFC_CLASSIFICATION:
			return (EObject) createIfcClassification();
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_ITEM:
			return (EObject) createIfcClassificationItem();
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_ITEM_RELATIONSHIP:
			return (EObject) createIfcClassificationItemRelationship();
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_NOTATION:
			return (EObject) createIfcClassificationNotation();
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_NOTATION_FACET:
			return (EObject) createIfcClassificationNotationFacet();
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_REFERENCE:
			return (EObject) createIfcClassificationReference();
		case Ifc2x3tc1Package.IFC_CLOSED_SHELL:
			return (EObject) createIfcClosedShell();
		case Ifc2x3tc1Package.IFC_COIL_TYPE:
			return (EObject) createIfcCoilType();
		case Ifc2x3tc1Package.IFC_COLOUR_RGB:
			return (EObject) createIfcColourRgb();
		case Ifc2x3tc1Package.IFC_COLOUR_SPECIFICATION:
			return (EObject) createIfcColourSpecification();
		case Ifc2x3tc1Package.IFC_COLUMN:
			return (EObject) createIfcColumn();
		case Ifc2x3tc1Package.IFC_COLUMN_TYPE:
			return (EObject) createIfcColumnType();
		case Ifc2x3tc1Package.IFC_COMPLEX_PROPERTY:
			return (EObject) createIfcComplexProperty();
		case Ifc2x3tc1Package.IFC_COMPOSITE_CURVE:
			return (EObject) createIfcCompositeCurve();
		case Ifc2x3tc1Package.IFC_COMPOSITE_CURVE_SEGMENT:
			return (EObject) createIfcCompositeCurveSegment();
		case Ifc2x3tc1Package.IFC_COMPOSITE_PROFILE_DEF:
			return (EObject) createIfcCompositeProfileDef();
		case Ifc2x3tc1Package.IFC_COMPRESSOR_TYPE:
			return (EObject) createIfcCompressorType();
		case Ifc2x3tc1Package.IFC_CONDENSER_TYPE:
			return (EObject) createIfcCondenserType();
		case Ifc2x3tc1Package.IFC_CONDITION:
			return (EObject) createIfcCondition();
		case Ifc2x3tc1Package.IFC_CONDITION_CRITERION:
			return (EObject) createIfcConditionCriterion();
		case Ifc2x3tc1Package.IFC_CONIC:
			return (EObject) createIfcConic();
		case Ifc2x3tc1Package.IFC_CONNECTED_FACE_SET:
			return (EObject) createIfcConnectedFaceSet();
		case Ifc2x3tc1Package.IFC_CONNECTION_CURVE_GEOMETRY:
			return (EObject) createIfcConnectionCurveGeometry();
		case Ifc2x3tc1Package.IFC_CONNECTION_GEOMETRY:
			return (EObject) createIfcConnectionGeometry();
		case Ifc2x3tc1Package.IFC_CONNECTION_POINT_ECCENTRICITY:
			return (EObject) createIfcConnectionPointEccentricity();
		case Ifc2x3tc1Package.IFC_CONNECTION_POINT_GEOMETRY:
			return (EObject) createIfcConnectionPointGeometry();
		case Ifc2x3tc1Package.IFC_CONNECTION_PORT_GEOMETRY:
			return (EObject) createIfcConnectionPortGeometry();
		case Ifc2x3tc1Package.IFC_CONNECTION_SURFACE_GEOMETRY:
			return (EObject) createIfcConnectionSurfaceGeometry();
		case Ifc2x3tc1Package.IFC_CONSTRAINT:
			return (EObject) createIfcConstraint();
		case Ifc2x3tc1Package.IFC_CONSTRAINT_AGGREGATION_RELATIONSHIP:
			return (EObject) createIfcConstraintAggregationRelationship();
		case Ifc2x3tc1Package.IFC_CONSTRAINT_CLASSIFICATION_RELATIONSHIP:
			return (EObject) createIfcConstraintClassificationRelationship();
		case Ifc2x3tc1Package.IFC_CONSTRAINT_RELATIONSHIP:
			return (EObject) createIfcConstraintRelationship();
		case Ifc2x3tc1Package.IFC_CONSTRUCTION_EQUIPMENT_RESOURCE:
			return (EObject) createIfcConstructionEquipmentResource();
		case Ifc2x3tc1Package.IFC_CONSTRUCTION_MATERIAL_RESOURCE:
			return (EObject) createIfcConstructionMaterialResource();
		case Ifc2x3tc1Package.IFC_CONSTRUCTION_PRODUCT_RESOURCE:
			return (EObject) createIfcConstructionProductResource();
		case Ifc2x3tc1Package.IFC_CONSTRUCTION_RESOURCE:
			return (EObject) createIfcConstructionResource();
		case Ifc2x3tc1Package.IFC_CONTEXT_DEPENDENT_UNIT:
			return (EObject) createIfcContextDependentUnit();
		case Ifc2x3tc1Package.IFC_CONTROL:
			return (EObject) createIfcControl();
		case Ifc2x3tc1Package.IFC_CONTROLLER_TYPE:
			return (EObject) createIfcControllerType();
		case Ifc2x3tc1Package.IFC_CONVERSION_BASED_UNIT:
			return (EObject) createIfcConversionBasedUnit();
		case Ifc2x3tc1Package.IFC_COOLED_BEAM_TYPE:
			return (EObject) createIfcCooledBeamType();
		case Ifc2x3tc1Package.IFC_COOLING_TOWER_TYPE:
			return (EObject) createIfcCoolingTowerType();
		case Ifc2x3tc1Package.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET:
			return (EObject) createIfcCoordinatedUniversalTimeOffset();
		case Ifc2x3tc1Package.IFC_COST_ITEM:
			return (EObject) createIfcCostItem();
		case Ifc2x3tc1Package.IFC_COST_SCHEDULE:
			return (EObject) createIfcCostSchedule();
		case Ifc2x3tc1Package.IFC_COST_VALUE:
			return (EObject) createIfcCostValue();
		case Ifc2x3tc1Package.IFC_COVERING:
			return (EObject) createIfcCovering();
		case Ifc2x3tc1Package.IFC_COVERING_TYPE:
			return (EObject) createIfcCoveringType();
		case Ifc2x3tc1Package.IFC_CRANE_RAIL_ASHAPE_PROFILE_DEF:
			return (EObject) createIfcCraneRailAShapeProfileDef();
		case Ifc2x3tc1Package.IFC_CRANE_RAIL_FSHAPE_PROFILE_DEF:
			return (EObject) createIfcCraneRailFShapeProfileDef();
		case Ifc2x3tc1Package.IFC_CREW_RESOURCE:
			return (EObject) createIfcCrewResource();
		case Ifc2x3tc1Package.IFC_CSG_PRIMITIVE3_D:
			return (EObject) createIfcCsgPrimitive3D();
		case Ifc2x3tc1Package.IFC_CSG_SOLID:
			return (EObject) createIfcCsgSolid();
		case Ifc2x3tc1Package.IFC_CURRENCY_RELATIONSHIP:
			return (EObject) createIfcCurrencyRelationship();
		case Ifc2x3tc1Package.IFC_CURTAIN_WALL:
			return (EObject) createIfcCurtainWall();
		case Ifc2x3tc1Package.IFC_CURTAIN_WALL_TYPE:
			return (EObject) createIfcCurtainWallType();
		case Ifc2x3tc1Package.IFC_CURVE:
			return (EObject) createIfcCurve();
		case Ifc2x3tc1Package.IFC_CURVE_BOUNDED_PLANE:
			return (EObject) createIfcCurveBoundedPlane();
		case Ifc2x3tc1Package.IFC_CURVE_STYLE:
			return (EObject) createIfcCurveStyle();
		case Ifc2x3tc1Package.IFC_CURVE_STYLE_FONT:
			return (EObject) createIfcCurveStyleFont();
		case Ifc2x3tc1Package.IFC_CURVE_STYLE_FONT_AND_SCALING:
			return (EObject) createIfcCurveStyleFontAndScaling();
		case Ifc2x3tc1Package.IFC_CURVE_STYLE_FONT_PATTERN:
			return (EObject) createIfcCurveStyleFontPattern();
		case Ifc2x3tc1Package.IFC_DAMPER_TYPE:
			return (EObject) createIfcDamperType();
		case Ifc2x3tc1Package.IFC_DATE_AND_TIME:
			return (EObject) createIfcDateAndTime();
		case Ifc2x3tc1Package.IFC_DEFINED_SYMBOL:
			return (EObject) createIfcDefinedSymbol();
		case Ifc2x3tc1Package.IFC_DERIVED_PROFILE_DEF:
			return (EObject) createIfcDerivedProfileDef();
		case Ifc2x3tc1Package.IFC_DERIVED_UNIT:
			return (EObject) createIfcDerivedUnit();
		case Ifc2x3tc1Package.IFC_DERIVED_UNIT_ELEMENT:
			return (EObject) createIfcDerivedUnitElement();
		case Ifc2x3tc1Package.IFC_DIAMETER_DIMENSION:
			return (EObject) createIfcDiameterDimension();
		case Ifc2x3tc1Package.IFC_DIMENSION_CALLOUT_RELATIONSHIP:
			return (EObject) createIfcDimensionCalloutRelationship();
		case Ifc2x3tc1Package.IFC_DIMENSION_CURVE:
			return (EObject) createIfcDimensionCurve();
		case Ifc2x3tc1Package.IFC_DIMENSION_CURVE_DIRECTED_CALLOUT:
			return (EObject) createIfcDimensionCurveDirectedCallout();
		case Ifc2x3tc1Package.IFC_DIMENSION_CURVE_TERMINATOR:
			return (EObject) createIfcDimensionCurveTerminator();
		case Ifc2x3tc1Package.IFC_DIMENSION_PAIR:
			return (EObject) createIfcDimensionPair();
		case Ifc2x3tc1Package.IFC_DIMENSIONAL_EXPONENTS:
			return (EObject) createIfcDimensionalExponents();
		case Ifc2x3tc1Package.IFC_DIRECTION:
			return (EObject) createIfcDirection();
		case Ifc2x3tc1Package.IFC_DISCRETE_ACCESSORY:
			return (EObject) createIfcDiscreteAccessory();
		case Ifc2x3tc1Package.IFC_DISCRETE_ACCESSORY_TYPE:
			return (EObject) createIfcDiscreteAccessoryType();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT:
			return (EObject) createIfcDistributionChamberElement();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT_TYPE:
			return (EObject) createIfcDistributionChamberElementType();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CONTROL_ELEMENT:
			return (EObject) createIfcDistributionControlElement();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CONTROL_ELEMENT_TYPE:
			return (EObject) createIfcDistributionControlElementType();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_ELEMENT:
			return (EObject) createIfcDistributionElement();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_ELEMENT_TYPE:
			return (EObject) createIfcDistributionElementType();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_FLOW_ELEMENT:
			return (EObject) createIfcDistributionFlowElement();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_FLOW_ELEMENT_TYPE:
			return (EObject) createIfcDistributionFlowElementType();
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_PORT:
			return (EObject) createIfcDistributionPort();
		case Ifc2x3tc1Package.IFC_DOCUMENT_ELECTRONIC_FORMAT:
			return (EObject) createIfcDocumentElectronicFormat();
		case Ifc2x3tc1Package.IFC_DOCUMENT_INFORMATION:
			return (EObject) createIfcDocumentInformation();
		case Ifc2x3tc1Package.IFC_DOCUMENT_INFORMATION_RELATIONSHIP:
			return (EObject) createIfcDocumentInformationRelationship();
		case Ifc2x3tc1Package.IFC_DOCUMENT_REFERENCE:
			return (EObject) createIfcDocumentReference();
		case Ifc2x3tc1Package.IFC_DOOR:
			return (EObject) createIfcDoor();
		case Ifc2x3tc1Package.IFC_DOOR_LINING_PROPERTIES:
			return (EObject) createIfcDoorLiningProperties();
		case Ifc2x3tc1Package.IFC_DOOR_PANEL_PROPERTIES:
			return (EObject) createIfcDoorPanelProperties();
		case Ifc2x3tc1Package.IFC_DOOR_STYLE:
			return (EObject) createIfcDoorStyle();
		case Ifc2x3tc1Package.IFC_DRAUGHTING_CALLOUT:
			return (EObject) createIfcDraughtingCallout();
		case Ifc2x3tc1Package.IFC_DRAUGHTING_CALLOUT_RELATIONSHIP:
			return (EObject) createIfcDraughtingCalloutRelationship();
		case Ifc2x3tc1Package.IFC_DRAUGHTING_PRE_DEFINED_COLOUR:
			return (EObject) createIfcDraughtingPreDefinedColour();
		case Ifc2x3tc1Package.IFC_DRAUGHTING_PRE_DEFINED_CURVE_FONT:
			return (EObject) createIfcDraughtingPreDefinedCurveFont();
		case Ifc2x3tc1Package.IFC_DRAUGHTING_PRE_DEFINED_TEXT_FONT:
			return (EObject) createIfcDraughtingPreDefinedTextFont();
		case Ifc2x3tc1Package.IFC_DUCT_FITTING_TYPE:
			return (EObject) createIfcDuctFittingType();
		case Ifc2x3tc1Package.IFC_DUCT_SEGMENT_TYPE:
			return (EObject) createIfcDuctSegmentType();
		case Ifc2x3tc1Package.IFC_DUCT_SILENCER_TYPE:
			return (EObject) createIfcDuctSilencerType();
		case Ifc2x3tc1Package.IFC_EDGE:
			return (EObject) createIfcEdge();
		case Ifc2x3tc1Package.IFC_EDGE_CURVE:
			return (EObject) createIfcEdgeCurve();
		case Ifc2x3tc1Package.IFC_EDGE_FEATURE:
			return (EObject) createIfcEdgeFeature();
		case Ifc2x3tc1Package.IFC_EDGE_LOOP:
			return (EObject) createIfcEdgeLoop();
		case Ifc2x3tc1Package.IFC_ELECTRIC_APPLIANCE_TYPE:
			return (EObject) createIfcElectricApplianceType();
		case Ifc2x3tc1Package.IFC_ELECTRIC_DISTRIBUTION_POINT:
			return (EObject) createIfcElectricDistributionPoint();
		case Ifc2x3tc1Package.IFC_ELECTRIC_FLOW_STORAGE_DEVICE_TYPE:
			return (EObject) createIfcElectricFlowStorageDeviceType();
		case Ifc2x3tc1Package.IFC_ELECTRIC_GENERATOR_TYPE:
			return (EObject) createIfcElectricGeneratorType();
		case Ifc2x3tc1Package.IFC_ELECTRIC_HEATER_TYPE:
			return (EObject) createIfcElectricHeaterType();
		case Ifc2x3tc1Package.IFC_ELECTRIC_MOTOR_TYPE:
			return (EObject) createIfcElectricMotorType();
		case Ifc2x3tc1Package.IFC_ELECTRIC_TIME_CONTROL_TYPE:
			return (EObject) createIfcElectricTimeControlType();
		case Ifc2x3tc1Package.IFC_ELECTRICAL_BASE_PROPERTIES:
			return (EObject) createIfcElectricalBaseProperties();
		case Ifc2x3tc1Package.IFC_ELECTRICAL_CIRCUIT:
			return (EObject) createIfcElectricalCircuit();
		case Ifc2x3tc1Package.IFC_ELECTRICAL_ELEMENT:
			return (EObject) createIfcElectricalElement();
		case Ifc2x3tc1Package.IFC_ELEMENT:
			return (EObject) createIfcElement();
		case Ifc2x3tc1Package.IFC_ELEMENT_ASSEMBLY:
			return (EObject) createIfcElementAssembly();
		case Ifc2x3tc1Package.IFC_ELEMENT_COMPONENT:
			return (EObject) createIfcElementComponent();
		case Ifc2x3tc1Package.IFC_ELEMENT_COMPONENT_TYPE:
			return (EObject) createIfcElementComponentType();
		case Ifc2x3tc1Package.IFC_ELEMENT_QUANTITY:
			return (EObject) createIfcElementQuantity();
		case Ifc2x3tc1Package.IFC_ELEMENT_TYPE:
			return (EObject) createIfcElementType();
		case Ifc2x3tc1Package.IFC_ELEMENTARY_SURFACE:
			return (EObject) createIfcElementarySurface();
		case Ifc2x3tc1Package.IFC_ELLIPSE:
			return (EObject) createIfcEllipse();
		case Ifc2x3tc1Package.IFC_ELLIPSE_PROFILE_DEF:
			return (EObject) createIfcEllipseProfileDef();
		case Ifc2x3tc1Package.IFC_ENERGY_CONVERSION_DEVICE:
			return (EObject) createIfcEnergyConversionDevice();
		case Ifc2x3tc1Package.IFC_ENERGY_CONVERSION_DEVICE_TYPE:
			return (EObject) createIfcEnergyConversionDeviceType();
		case Ifc2x3tc1Package.IFC_ENERGY_PROPERTIES:
			return (EObject) createIfcEnergyProperties();
		case Ifc2x3tc1Package.IFC_ENVIRONMENTAL_IMPACT_VALUE:
			return (EObject) createIfcEnvironmentalImpactValue();
		case Ifc2x3tc1Package.IFC_EQUIPMENT_ELEMENT:
			return (EObject) createIfcEquipmentElement();
		case Ifc2x3tc1Package.IFC_EQUIPMENT_STANDARD:
			return (EObject) createIfcEquipmentStandard();
		case Ifc2x3tc1Package.IFC_EVAPORATIVE_COOLER_TYPE:
			return (EObject) createIfcEvaporativeCoolerType();
		case Ifc2x3tc1Package.IFC_EVAPORATOR_TYPE:
			return (EObject) createIfcEvaporatorType();
		case Ifc2x3tc1Package.IFC_EXTENDED_MATERIAL_PROPERTIES:
			return (EObject) createIfcExtendedMaterialProperties();
		case Ifc2x3tc1Package.IFC_EXTERNAL_REFERENCE:
			return (EObject) createIfcExternalReference();
		case Ifc2x3tc1Package.IFC_EXTERNALLY_DEFINED_HATCH_STYLE:
			return (EObject) createIfcExternallyDefinedHatchStyle();
		case Ifc2x3tc1Package.IFC_EXTERNALLY_DEFINED_SURFACE_STYLE:
			return (EObject) createIfcExternallyDefinedSurfaceStyle();
		case Ifc2x3tc1Package.IFC_EXTERNALLY_DEFINED_SYMBOL:
			return (EObject) createIfcExternallyDefinedSymbol();
		case Ifc2x3tc1Package.IFC_EXTERNALLY_DEFINED_TEXT_FONT:
			return (EObject) createIfcExternallyDefinedTextFont();
		case Ifc2x3tc1Package.IFC_EXTRUDED_AREA_SOLID:
			return (EObject) createIfcExtrudedAreaSolid();
		case Ifc2x3tc1Package.IFC_FACE:
			return (EObject) createIfcFace();
		case Ifc2x3tc1Package.IFC_FACE_BASED_SURFACE_MODEL:
			return (EObject) createIfcFaceBasedSurfaceModel();
		case Ifc2x3tc1Package.IFC_FACE_BOUND:
			return (EObject) createIfcFaceBound();
		case Ifc2x3tc1Package.IFC_FACE_OUTER_BOUND:
			return (EObject) createIfcFaceOuterBound();
		case Ifc2x3tc1Package.IFC_FACE_SURFACE:
			return (EObject) createIfcFaceSurface();
		case Ifc2x3tc1Package.IFC_FACETED_BREP:
			return (EObject) createIfcFacetedBrep();
		case Ifc2x3tc1Package.IFC_FACETED_BREP_WITH_VOIDS:
			return (EObject) createIfcFacetedBrepWithVoids();
		case Ifc2x3tc1Package.IFC_FAILURE_CONNECTION_CONDITION:
			return (EObject) createIfcFailureConnectionCondition();
		case Ifc2x3tc1Package.IFC_FAN_TYPE:
			return (EObject) createIfcFanType();
		case Ifc2x3tc1Package.IFC_FASTENER:
			return (EObject) createIfcFastener();
		case Ifc2x3tc1Package.IFC_FASTENER_TYPE:
			return (EObject) createIfcFastenerType();
		case Ifc2x3tc1Package.IFC_FEATURE_ELEMENT:
			return (EObject) createIfcFeatureElement();
		case Ifc2x3tc1Package.IFC_FEATURE_ELEMENT_ADDITION:
			return (EObject) createIfcFeatureElementAddition();
		case Ifc2x3tc1Package.IFC_FEATURE_ELEMENT_SUBTRACTION:
			return (EObject) createIfcFeatureElementSubtraction();
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE:
			return (EObject) createIfcFillAreaStyle();
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE_HATCHING:
			return (EObject) createIfcFillAreaStyleHatching();
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE_TILE_SYMBOL_WITH_STYLE:
			return (EObject) createIfcFillAreaStyleTileSymbolWithStyle();
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE_TILES:
			return (EObject) createIfcFillAreaStyleTiles();
		case Ifc2x3tc1Package.IFC_FILTER_TYPE:
			return (EObject) createIfcFilterType();
		case Ifc2x3tc1Package.IFC_FIRE_SUPPRESSION_TERMINAL_TYPE:
			return (EObject) createIfcFireSuppressionTerminalType();
		case Ifc2x3tc1Package.IFC_FLOW_CONTROLLER:
			return (EObject) createIfcFlowController();
		case Ifc2x3tc1Package.IFC_FLOW_CONTROLLER_TYPE:
			return (EObject) createIfcFlowControllerType();
		case Ifc2x3tc1Package.IFC_FLOW_FITTING:
			return (EObject) createIfcFlowFitting();
		case Ifc2x3tc1Package.IFC_FLOW_FITTING_TYPE:
			return (EObject) createIfcFlowFittingType();
		case Ifc2x3tc1Package.IFC_FLOW_INSTRUMENT_TYPE:
			return (EObject) createIfcFlowInstrumentType();
		case Ifc2x3tc1Package.IFC_FLOW_METER_TYPE:
			return (EObject) createIfcFlowMeterType();
		case Ifc2x3tc1Package.IFC_FLOW_MOVING_DEVICE:
			return (EObject) createIfcFlowMovingDevice();
		case Ifc2x3tc1Package.IFC_FLOW_MOVING_DEVICE_TYPE:
			return (EObject) createIfcFlowMovingDeviceType();
		case Ifc2x3tc1Package.IFC_FLOW_SEGMENT:
			return (EObject) createIfcFlowSegment();
		case Ifc2x3tc1Package.IFC_FLOW_SEGMENT_TYPE:
			return (EObject) createIfcFlowSegmentType();
		case Ifc2x3tc1Package.IFC_FLOW_STORAGE_DEVICE:
			return (EObject) createIfcFlowStorageDevice();
		case Ifc2x3tc1Package.IFC_FLOW_STORAGE_DEVICE_TYPE:
			return (EObject) createIfcFlowStorageDeviceType();
		case Ifc2x3tc1Package.IFC_FLOW_TERMINAL:
			return (EObject) createIfcFlowTerminal();
		case Ifc2x3tc1Package.IFC_FLOW_TERMINAL_TYPE:
			return (EObject) createIfcFlowTerminalType();
		case Ifc2x3tc1Package.IFC_FLOW_TREATMENT_DEVICE:
			return (EObject) createIfcFlowTreatmentDevice();
		case Ifc2x3tc1Package.IFC_FLOW_TREATMENT_DEVICE_TYPE:
			return (EObject) createIfcFlowTreatmentDeviceType();
		case Ifc2x3tc1Package.IFC_FLUID_FLOW_PROPERTIES:
			return (EObject) createIfcFluidFlowProperties();
		case Ifc2x3tc1Package.IFC_FOOTING:
			return (EObject) createIfcFooting();
		case Ifc2x3tc1Package.IFC_FUEL_PROPERTIES:
			return (EObject) createIfcFuelProperties();
		case Ifc2x3tc1Package.IFC_FURNISHING_ELEMENT:
			return (EObject) createIfcFurnishingElement();
		case Ifc2x3tc1Package.IFC_FURNISHING_ELEMENT_TYPE:
			return (EObject) createIfcFurnishingElementType();
		case Ifc2x3tc1Package.IFC_FURNITURE_STANDARD:
			return (EObject) createIfcFurnitureStandard();
		case Ifc2x3tc1Package.IFC_FURNITURE_TYPE:
			return (EObject) createIfcFurnitureType();
		case Ifc2x3tc1Package.IFC_GAS_TERMINAL_TYPE:
			return (EObject) createIfcGasTerminalType();
		case Ifc2x3tc1Package.IFC_GENERAL_MATERIAL_PROPERTIES:
			return (EObject) createIfcGeneralMaterialProperties();
		case Ifc2x3tc1Package.IFC_GENERAL_PROFILE_PROPERTIES:
			return (EObject) createIfcGeneralProfileProperties();
		case Ifc2x3tc1Package.IFC_GEOMETRIC_CURVE_SET:
			return (EObject) createIfcGeometricCurveSet();
		case Ifc2x3tc1Package.IFC_GEOMETRIC_REPRESENTATION_CONTEXT:
			return (EObject) createIfcGeometricRepresentationContext();
		case Ifc2x3tc1Package.IFC_GEOMETRIC_REPRESENTATION_ITEM:
			return (EObject) createIfcGeometricRepresentationItem();
		case Ifc2x3tc1Package.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT:
			return (EObject) createIfcGeometricRepresentationSubContext();
		case Ifc2x3tc1Package.IFC_GEOMETRIC_SET:
			return (EObject) createIfcGeometricSet();
		case Ifc2x3tc1Package.IFC_GRID:
			return (EObject) createIfcGrid();
		case Ifc2x3tc1Package.IFC_GRID_AXIS:
			return (EObject) createIfcGridAxis();
		case Ifc2x3tc1Package.IFC_GRID_PLACEMENT:
			return (EObject) createIfcGridPlacement();
		case Ifc2x3tc1Package.IFC_GROUP:
			return (EObject) createIfcGroup();
		case Ifc2x3tc1Package.IFC_HALF_SPACE_SOLID:
			return (EObject) createIfcHalfSpaceSolid();
		case Ifc2x3tc1Package.IFC_HEAT_EXCHANGER_TYPE:
			return (EObject) createIfcHeatExchangerType();
		case Ifc2x3tc1Package.IFC_HUMIDIFIER_TYPE:
			return (EObject) createIfcHumidifierType();
		case Ifc2x3tc1Package.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES:
			return (EObject) createIfcHygroscopicMaterialProperties();
		case Ifc2x3tc1Package.IFC_ISHAPE_PROFILE_DEF:
			return (EObject) createIfcIShapeProfileDef();
		case Ifc2x3tc1Package.IFC_IMAGE_TEXTURE:
			return (EObject) createIfcImageTexture();
		case Ifc2x3tc1Package.IFC_INVENTORY:
			return (EObject) createIfcInventory();
		case Ifc2x3tc1Package.IFC_IRREGULAR_TIME_SERIES:
			return (EObject) createIfcIrregularTimeSeries();
		case Ifc2x3tc1Package.IFC_IRREGULAR_TIME_SERIES_VALUE:
			return (EObject) createIfcIrregularTimeSeriesValue();
		case Ifc2x3tc1Package.IFC_JUNCTION_BOX_TYPE:
			return (EObject) createIfcJunctionBoxType();
		case Ifc2x3tc1Package.IFC_LSHAPE_PROFILE_DEF:
			return (EObject) createIfcLShapeProfileDef();
		case Ifc2x3tc1Package.IFC_LABOR_RESOURCE:
			return (EObject) createIfcLaborResource();
		case Ifc2x3tc1Package.IFC_LAMP_TYPE:
			return (EObject) createIfcLampType();
		case Ifc2x3tc1Package.IFC_LIBRARY_INFORMATION:
			return (EObject) createIfcLibraryInformation();
		case Ifc2x3tc1Package.IFC_LIBRARY_REFERENCE:
			return (EObject) createIfcLibraryReference();
		case Ifc2x3tc1Package.IFC_LIGHT_DISTRIBUTION_DATA:
			return (EObject) createIfcLightDistributionData();
		case Ifc2x3tc1Package.IFC_LIGHT_FIXTURE_TYPE:
			return (EObject) createIfcLightFixtureType();
		case Ifc2x3tc1Package.IFC_LIGHT_INTENSITY_DISTRIBUTION:
			return (EObject) createIfcLightIntensityDistribution();
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE:
			return (EObject) createIfcLightSource();
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_AMBIENT:
			return (EObject) createIfcLightSourceAmbient();
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_DIRECTIONAL:
			return (EObject) createIfcLightSourceDirectional();
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_GONIOMETRIC:
			return (EObject) createIfcLightSourceGoniometric();
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_POSITIONAL:
			return (EObject) createIfcLightSourcePositional();
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_SPOT:
			return (EObject) createIfcLightSourceSpot();
		case Ifc2x3tc1Package.IFC_LINE:
			return (EObject) createIfcLine();
		case Ifc2x3tc1Package.IFC_LINEAR_DIMENSION:
			return (EObject) createIfcLinearDimension();
		case Ifc2x3tc1Package.IFC_LOCAL_PLACEMENT:
			return (EObject) createIfcLocalPlacement();
		case Ifc2x3tc1Package.IFC_LOCAL_TIME:
			return (EObject) createIfcLocalTime();
		case Ifc2x3tc1Package.IFC_LOOP:
			return (EObject) createIfcLoop();
		case Ifc2x3tc1Package.IFC_MANIFOLD_SOLID_BREP:
			return (EObject) createIfcManifoldSolidBrep();
		case Ifc2x3tc1Package.IFC_MAPPED_ITEM:
			return (EObject) createIfcMappedItem();
		case Ifc2x3tc1Package.IFC_MATERIAL:
			return (EObject) createIfcMaterial();
		case Ifc2x3tc1Package.IFC_MATERIAL_CLASSIFICATION_RELATIONSHIP:
			return (EObject) createIfcMaterialClassificationRelationship();
		case Ifc2x3tc1Package.IFC_MATERIAL_DEFINITION_REPRESENTATION:
			return (EObject) createIfcMaterialDefinitionRepresentation();
		case Ifc2x3tc1Package.IFC_MATERIAL_LAYER:
			return (EObject) createIfcMaterialLayer();
		case Ifc2x3tc1Package.IFC_MATERIAL_LAYER_SET:
			return (EObject) createIfcMaterialLayerSet();
		case Ifc2x3tc1Package.IFC_MATERIAL_LAYER_SET_USAGE:
			return (EObject) createIfcMaterialLayerSetUsage();
		case Ifc2x3tc1Package.IFC_MATERIAL_LIST:
			return (EObject) createIfcMaterialList();
		case Ifc2x3tc1Package.IFC_MATERIAL_PROPERTIES:
			return (EObject) createIfcMaterialProperties();
		case Ifc2x3tc1Package.IFC_MEASURE_WITH_UNIT:
			return (EObject) createIfcMeasureWithUnit();
		case Ifc2x3tc1Package.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES:
			return (EObject) createIfcMechanicalConcreteMaterialProperties();
		case Ifc2x3tc1Package.IFC_MECHANICAL_FASTENER:
			return (EObject) createIfcMechanicalFastener();
		case Ifc2x3tc1Package.IFC_MECHANICAL_FASTENER_TYPE:
			return (EObject) createIfcMechanicalFastenerType();
		case Ifc2x3tc1Package.IFC_MECHANICAL_MATERIAL_PROPERTIES:
			return (EObject) createIfcMechanicalMaterialProperties();
		case Ifc2x3tc1Package.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES:
			return (EObject) createIfcMechanicalSteelMaterialProperties();
		case Ifc2x3tc1Package.IFC_MEMBER:
			return (EObject) createIfcMember();
		case Ifc2x3tc1Package.IFC_MEMBER_TYPE:
			return (EObject) createIfcMemberType();
		case Ifc2x3tc1Package.IFC_METRIC:
			return (EObject) createIfcMetric();
		case Ifc2x3tc1Package.IFC_MONETARY_UNIT:
			return (EObject) createIfcMonetaryUnit();
		case Ifc2x3tc1Package.IFC_MOTOR_CONNECTION_TYPE:
			return (EObject) createIfcMotorConnectionType();
		case Ifc2x3tc1Package.IFC_MOVE:
			return (EObject) createIfcMove();
		case Ifc2x3tc1Package.IFC_NAMED_UNIT:
			return (EObject) createIfcNamedUnit();
		case Ifc2x3tc1Package.IFC_OBJECT:
			return (EObject) createIfcObject();
		case Ifc2x3tc1Package.IFC_OBJECT_DEFINITION:
			return (EObject) createIfcObjectDefinition();
		case Ifc2x3tc1Package.IFC_OBJECT_PLACEMENT:
			return (EObject) createIfcObjectPlacement();
		case Ifc2x3tc1Package.IFC_OBJECTIVE:
			return (EObject) createIfcObjective();
		case Ifc2x3tc1Package.IFC_OCCUPANT:
			return (EObject) createIfcOccupant();
		case Ifc2x3tc1Package.IFC_OFFSET_CURVE2_D:
			return (EObject) createIfcOffsetCurve2D();
		case Ifc2x3tc1Package.IFC_OFFSET_CURVE3_D:
			return (EObject) createIfcOffsetCurve3D();
		case Ifc2x3tc1Package.IFC_ONE_DIRECTION_REPEAT_FACTOR:
			return (EObject) createIfcOneDirectionRepeatFactor();
		case Ifc2x3tc1Package.IFC_OPEN_SHELL:
			return (EObject) createIfcOpenShell();
		case Ifc2x3tc1Package.IFC_OPENING_ELEMENT:
			return (EObject) createIfcOpeningElement();
		case Ifc2x3tc1Package.IFC_OPTICAL_MATERIAL_PROPERTIES:
			return (EObject) createIfcOpticalMaterialProperties();
		case Ifc2x3tc1Package.IFC_ORDER_ACTION:
			return (EObject) createIfcOrderAction();
		case Ifc2x3tc1Package.IFC_ORGANIZATION:
			return (EObject) createIfcOrganization();
		case Ifc2x3tc1Package.IFC_ORGANIZATION_RELATIONSHIP:
			return (EObject) createIfcOrganizationRelationship();
		case Ifc2x3tc1Package.IFC_ORIENTED_EDGE:
			return (EObject) createIfcOrientedEdge();
		case Ifc2x3tc1Package.IFC_OUTLET_TYPE:
			return (EObject) createIfcOutletType();
		case Ifc2x3tc1Package.IFC_OWNER_HISTORY:
			return (EObject) createIfcOwnerHistory();
		case Ifc2x3tc1Package.IFC_PARAMETERIZED_PROFILE_DEF:
			return (EObject) createIfcParameterizedProfileDef();
		case Ifc2x3tc1Package.IFC_PATH:
			return (EObject) createIfcPath();
		case Ifc2x3tc1Package.IFC_PERFORMANCE_HISTORY:
			return (EObject) createIfcPerformanceHistory();
		case Ifc2x3tc1Package.IFC_PERMEABLE_COVERING_PROPERTIES:
			return (EObject) createIfcPermeableCoveringProperties();
		case Ifc2x3tc1Package.IFC_PERMIT:
			return (EObject) createIfcPermit();
		case Ifc2x3tc1Package.IFC_PERSON:
			return (EObject) createIfcPerson();
		case Ifc2x3tc1Package.IFC_PERSON_AND_ORGANIZATION:
			return (EObject) createIfcPersonAndOrganization();
		case Ifc2x3tc1Package.IFC_PHYSICAL_COMPLEX_QUANTITY:
			return (EObject) createIfcPhysicalComplexQuantity();
		case Ifc2x3tc1Package.IFC_PHYSICAL_QUANTITY:
			return (EObject) createIfcPhysicalQuantity();
		case Ifc2x3tc1Package.IFC_PHYSICAL_SIMPLE_QUANTITY:
			return (EObject) createIfcPhysicalSimpleQuantity();
		case Ifc2x3tc1Package.IFC_PILE:
			return (EObject) createIfcPile();
		case Ifc2x3tc1Package.IFC_PIPE_FITTING_TYPE:
			return (EObject) createIfcPipeFittingType();
		case Ifc2x3tc1Package.IFC_PIPE_SEGMENT_TYPE:
			return (EObject) createIfcPipeSegmentType();
		case Ifc2x3tc1Package.IFC_PIXEL_TEXTURE:
			return (EObject) createIfcPixelTexture();
		case Ifc2x3tc1Package.IFC_PLACEMENT:
			return (EObject) createIfcPlacement();
		case Ifc2x3tc1Package.IFC_PLANAR_BOX:
			return (EObject) createIfcPlanarBox();
		case Ifc2x3tc1Package.IFC_PLANAR_EXTENT:
			return (EObject) createIfcPlanarExtent();
		case Ifc2x3tc1Package.IFC_PLANE:
			return (EObject) createIfcPlane();
		case Ifc2x3tc1Package.IFC_PLATE:
			return (EObject) createIfcPlate();
		case Ifc2x3tc1Package.IFC_PLATE_TYPE:
			return (EObject) createIfcPlateType();
		case Ifc2x3tc1Package.IFC_POINT:
			return (EObject) createIfcPoint();
		case Ifc2x3tc1Package.IFC_POINT_ON_CURVE:
			return (EObject) createIfcPointOnCurve();
		case Ifc2x3tc1Package.IFC_POINT_ON_SURFACE:
			return (EObject) createIfcPointOnSurface();
		case Ifc2x3tc1Package.IFC_POLY_LOOP:
			return (EObject) createIfcPolyLoop();
		case Ifc2x3tc1Package.IFC_POLYGONAL_BOUNDED_HALF_SPACE:
			return (EObject) createIfcPolygonalBoundedHalfSpace();
		case Ifc2x3tc1Package.IFC_POLYLINE:
			return (EObject) createIfcPolyline();
		case Ifc2x3tc1Package.IFC_PORT:
			return (EObject) createIfcPort();
		case Ifc2x3tc1Package.IFC_POSTAL_ADDRESS:
			return (EObject) createIfcPostalAddress();
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_COLOUR:
			return (EObject) createIfcPreDefinedColour();
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_CURVE_FONT:
			return (EObject) createIfcPreDefinedCurveFont();
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_DIMENSION_SYMBOL:
			return (EObject) createIfcPreDefinedDimensionSymbol();
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_ITEM:
			return (EObject) createIfcPreDefinedItem();
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_POINT_MARKER_SYMBOL:
			return (EObject) createIfcPreDefinedPointMarkerSymbol();
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_SYMBOL:
			return (EObject) createIfcPreDefinedSymbol();
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_TERMINATOR_SYMBOL:
			return (EObject) createIfcPreDefinedTerminatorSymbol();
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_TEXT_FONT:
			return (EObject) createIfcPreDefinedTextFont();
		case Ifc2x3tc1Package.IFC_PRESENTATION_LAYER_ASSIGNMENT:
			return (EObject) createIfcPresentationLayerAssignment();
		case Ifc2x3tc1Package.IFC_PRESENTATION_LAYER_WITH_STYLE:
			return (EObject) createIfcPresentationLayerWithStyle();
		case Ifc2x3tc1Package.IFC_PRESENTATION_STYLE:
			return (EObject) createIfcPresentationStyle();
		case Ifc2x3tc1Package.IFC_PRESENTATION_STYLE_ASSIGNMENT:
			return (EObject) createIfcPresentationStyleAssignment();
		case Ifc2x3tc1Package.IFC_PROCEDURE:
			return (EObject) createIfcProcedure();
		case Ifc2x3tc1Package.IFC_PROCESS:
			return (EObject) createIfcProcess();
		case Ifc2x3tc1Package.IFC_PRODUCT:
			return (EObject) createIfcProduct();
		case Ifc2x3tc1Package.IFC_PRODUCT_DEFINITION_SHAPE:
			return (EObject) createIfcProductDefinitionShape();
		case Ifc2x3tc1Package.IFC_PRODUCT_REPRESENTATION:
			return (EObject) createIfcProductRepresentation();
		case Ifc2x3tc1Package.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES:
			return (EObject) createIfcProductsOfCombustionProperties();
		case Ifc2x3tc1Package.IFC_PROFILE_DEF:
			return (EObject) createIfcProfileDef();
		case Ifc2x3tc1Package.IFC_PROFILE_PROPERTIES:
			return (EObject) createIfcProfileProperties();
		case Ifc2x3tc1Package.IFC_PROJECT:
			return (EObject) createIfcProject();
		case Ifc2x3tc1Package.IFC_PROJECT_ORDER:
			return (EObject) createIfcProjectOrder();
		case Ifc2x3tc1Package.IFC_PROJECT_ORDER_RECORD:
			return (EObject) createIfcProjectOrderRecord();
		case Ifc2x3tc1Package.IFC_PROJECTION_CURVE:
			return (EObject) createIfcProjectionCurve();
		case Ifc2x3tc1Package.IFC_PROJECTION_ELEMENT:
			return (EObject) createIfcProjectionElement();
		case Ifc2x3tc1Package.IFC_PROPERTY:
			return (EObject) createIfcProperty();
		case Ifc2x3tc1Package.IFC_PROPERTY_BOUNDED_VALUE:
			return (EObject) createIfcPropertyBoundedValue();
		case Ifc2x3tc1Package.IFC_PROPERTY_CONSTRAINT_RELATIONSHIP:
			return (EObject) createIfcPropertyConstraintRelationship();
		case Ifc2x3tc1Package.IFC_PROPERTY_DEFINITION:
			return (EObject) createIfcPropertyDefinition();
		case Ifc2x3tc1Package.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP:
			return (EObject) createIfcPropertyDependencyRelationship();
		case Ifc2x3tc1Package.IFC_PROPERTY_ENUMERATED_VALUE:
			return (EObject) createIfcPropertyEnumeratedValue();
		case Ifc2x3tc1Package.IFC_PROPERTY_ENUMERATION:
			return (EObject) createIfcPropertyEnumeration();
		case Ifc2x3tc1Package.IFC_PROPERTY_LIST_VALUE:
			return (EObject) createIfcPropertyListValue();
		case Ifc2x3tc1Package.IFC_PROPERTY_REFERENCE_VALUE:
			return (EObject) createIfcPropertyReferenceValue();
		case Ifc2x3tc1Package.IFC_PROPERTY_SET:
			return (EObject) createIfcPropertySet();
		case Ifc2x3tc1Package.IFC_PROPERTY_SET_DEFINITION:
			return (EObject) createIfcPropertySetDefinition();
		case Ifc2x3tc1Package.IFC_PROPERTY_SINGLE_VALUE:
			return (EObject) createIfcPropertySingleValue();
		case Ifc2x3tc1Package.IFC_PROPERTY_TABLE_VALUE:
			return (EObject) createIfcPropertyTableValue();
		case Ifc2x3tc1Package.IFC_PROTECTIVE_DEVICE_TYPE:
			return (EObject) createIfcProtectiveDeviceType();
		case Ifc2x3tc1Package.IFC_PROXY:
			return (EObject) createIfcProxy();
		case Ifc2x3tc1Package.IFC_PUMP_TYPE:
			return (EObject) createIfcPumpType();
		case Ifc2x3tc1Package.IFC_QUANTITY_AREA:
			return (EObject) createIfcQuantityArea();
		case Ifc2x3tc1Package.IFC_QUANTITY_COUNT:
			return (EObject) createIfcQuantityCount();
		case Ifc2x3tc1Package.IFC_QUANTITY_LENGTH:
			return (EObject) createIfcQuantityLength();
		case Ifc2x3tc1Package.IFC_QUANTITY_TIME:
			return (EObject) createIfcQuantityTime();
		case Ifc2x3tc1Package.IFC_QUANTITY_VOLUME:
			return (EObject) createIfcQuantityVolume();
		case Ifc2x3tc1Package.IFC_QUANTITY_WEIGHT:
			return (EObject) createIfcQuantityWeight();
		case Ifc2x3tc1Package.IFC_RADIUS_DIMENSION:
			return (EObject) createIfcRadiusDimension();
		case Ifc2x3tc1Package.IFC_RAILING:
			return (EObject) createIfcRailing();
		case Ifc2x3tc1Package.IFC_RAILING_TYPE:
			return (EObject) createIfcRailingType();
		case Ifc2x3tc1Package.IFC_RAMP:
			return (EObject) createIfcRamp();
		case Ifc2x3tc1Package.IFC_RAMP_FLIGHT:
			return (EObject) createIfcRampFlight();
		case Ifc2x3tc1Package.IFC_RAMP_FLIGHT_TYPE:
			return (EObject) createIfcRampFlightType();
		case Ifc2x3tc1Package.IFC_RATIONAL_BEZIER_CURVE:
			return (EObject) createIfcRationalBezierCurve();
		case Ifc2x3tc1Package.IFC_RECTANGLE_HOLLOW_PROFILE_DEF:
			return (EObject) createIfcRectangleHollowProfileDef();
		case Ifc2x3tc1Package.IFC_RECTANGLE_PROFILE_DEF:
			return (EObject) createIfcRectangleProfileDef();
		case Ifc2x3tc1Package.IFC_RECTANGULAR_PYRAMID:
			return (EObject) createIfcRectangularPyramid();
		case Ifc2x3tc1Package.IFC_RECTANGULAR_TRIMMED_SURFACE:
			return (EObject) createIfcRectangularTrimmedSurface();
		case Ifc2x3tc1Package.IFC_REFERENCES_VALUE_DOCUMENT:
			return (EObject) createIfcReferencesValueDocument();
		case Ifc2x3tc1Package.IFC_REGULAR_TIME_SERIES:
			return (EObject) createIfcRegularTimeSeries();
		case Ifc2x3tc1Package.IFC_REINFORCEMENT_BAR_PROPERTIES:
			return (EObject) createIfcReinforcementBarProperties();
		case Ifc2x3tc1Package.IFC_REINFORCEMENT_DEFINITION_PROPERTIES:
			return (EObject) createIfcReinforcementDefinitionProperties();
		case Ifc2x3tc1Package.IFC_REINFORCING_BAR:
			return (EObject) createIfcReinforcingBar();
		case Ifc2x3tc1Package.IFC_REINFORCING_ELEMENT:
			return (EObject) createIfcReinforcingElement();
		case Ifc2x3tc1Package.IFC_REINFORCING_MESH:
			return (EObject) createIfcReinforcingMesh();
		case Ifc2x3tc1Package.IFC_REL_AGGREGATES:
			return (EObject) createIfcRelAggregates();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS:
			return (EObject) createIfcRelAssigns();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TASKS:
			return (EObject) createIfcRelAssignsTasks();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_ACTOR:
			return (EObject) createIfcRelAssignsToActor();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_CONTROL:
			return (EObject) createIfcRelAssignsToControl();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_GROUP:
			return (EObject) createIfcRelAssignsToGroup();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_PROCESS:
			return (EObject) createIfcRelAssignsToProcess();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_PRODUCT:
			return (EObject) createIfcRelAssignsToProduct();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_PROJECT_ORDER:
			return (EObject) createIfcRelAssignsToProjectOrder();
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_RESOURCE:
			return (EObject) createIfcRelAssignsToResource();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES:
			return (EObject) createIfcRelAssociates();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_APPLIED_VALUE:
			return (EObject) createIfcRelAssociatesAppliedValue();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_APPROVAL:
			return (EObject) createIfcRelAssociatesApproval();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_CLASSIFICATION:
			return (EObject) createIfcRelAssociatesClassification();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_CONSTRAINT:
			return (EObject) createIfcRelAssociatesConstraint();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_DOCUMENT:
			return (EObject) createIfcRelAssociatesDocument();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_LIBRARY:
			return (EObject) createIfcRelAssociatesLibrary();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_MATERIAL:
			return (EObject) createIfcRelAssociatesMaterial();
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES:
			return (EObject) createIfcRelAssociatesProfileProperties();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS:
			return (EObject) createIfcRelConnects();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_ELEMENTS:
			return (EObject) createIfcRelConnectsElements();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_PATH_ELEMENTS:
			return (EObject) createIfcRelConnectsPathElements();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_PORT_TO_ELEMENT:
			return (EObject) createIfcRelConnectsPortToElement();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_PORTS:
			return (EObject) createIfcRelConnectsPorts();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_STRUCTURAL_ACTIVITY:
			return (EObject) createIfcRelConnectsStructuralActivity();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_STRUCTURAL_ELEMENT:
			return (EObject) createIfcRelConnectsStructuralElement();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_STRUCTURAL_MEMBER:
			return (EObject) createIfcRelConnectsStructuralMember();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_WITH_ECCENTRICITY:
			return (EObject) createIfcRelConnectsWithEccentricity();
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS:
			return (EObject) createIfcRelConnectsWithRealizingElements();
		case Ifc2x3tc1Package.IFC_REL_CONTAINED_IN_SPATIAL_STRUCTURE:
			return (EObject) createIfcRelContainedInSpatialStructure();
		case Ifc2x3tc1Package.IFC_REL_COVERS_BLDG_ELEMENTS:
			return (EObject) createIfcRelCoversBldgElements();
		case Ifc2x3tc1Package.IFC_REL_COVERS_SPACES:
			return (EObject) createIfcRelCoversSpaces();
		case Ifc2x3tc1Package.IFC_REL_DECOMPOSES:
			return (EObject) createIfcRelDecomposes();
		case Ifc2x3tc1Package.IFC_REL_DEFINES:
			return (EObject) createIfcRelDefines();
		case Ifc2x3tc1Package.IFC_REL_DEFINES_BY_PROPERTIES:
			return (EObject) createIfcRelDefinesByProperties();
		case Ifc2x3tc1Package.IFC_REL_DEFINES_BY_TYPE:
			return (EObject) createIfcRelDefinesByType();
		case Ifc2x3tc1Package.IFC_REL_FILLS_ELEMENT:
			return (EObject) createIfcRelFillsElement();
		case Ifc2x3tc1Package.IFC_REL_FLOW_CONTROL_ELEMENTS:
			return (EObject) createIfcRelFlowControlElements();
		case Ifc2x3tc1Package.IFC_REL_INTERACTION_REQUIREMENTS:
			return (EObject) createIfcRelInteractionRequirements();
		case Ifc2x3tc1Package.IFC_REL_NESTS:
			return (EObject) createIfcRelNests();
		case Ifc2x3tc1Package.IFC_REL_OCCUPIES_SPACES:
			return (EObject) createIfcRelOccupiesSpaces();
		case Ifc2x3tc1Package.IFC_REL_OVERRIDES_PROPERTIES:
			return (EObject) createIfcRelOverridesProperties();
		case Ifc2x3tc1Package.IFC_REL_PROJECTS_ELEMENT:
			return (EObject) createIfcRelProjectsElement();
		case Ifc2x3tc1Package.IFC_REL_REFERENCED_IN_SPATIAL_STRUCTURE:
			return (EObject) createIfcRelReferencedInSpatialStructure();
		case Ifc2x3tc1Package.IFC_REL_SCHEDULES_COST_ITEMS:
			return (EObject) createIfcRelSchedulesCostItems();
		case Ifc2x3tc1Package.IFC_REL_SEQUENCE:
			return (EObject) createIfcRelSequence();
		case Ifc2x3tc1Package.IFC_REL_SERVICES_BUILDINGS:
			return (EObject) createIfcRelServicesBuildings();
		case Ifc2x3tc1Package.IFC_REL_SPACE_BOUNDARY:
			return (EObject) createIfcRelSpaceBoundary();
		case Ifc2x3tc1Package.IFC_REL_VOIDS_ELEMENT:
			return (EObject) createIfcRelVoidsElement();
		case Ifc2x3tc1Package.IFC_RELATIONSHIP:
			return (EObject) createIfcRelationship();
		case Ifc2x3tc1Package.IFC_RELAXATION:
			return (EObject) createIfcRelaxation();
		case Ifc2x3tc1Package.IFC_REPRESENTATION:
			return (EObject) createIfcRepresentation();
		case Ifc2x3tc1Package.IFC_REPRESENTATION_CONTEXT:
			return (EObject) createIfcRepresentationContext();
		case Ifc2x3tc1Package.IFC_REPRESENTATION_ITEM:
			return (EObject) createIfcRepresentationItem();
		case Ifc2x3tc1Package.IFC_REPRESENTATION_MAP:
			return (EObject) createIfcRepresentationMap();
		case Ifc2x3tc1Package.IFC_RESOURCE:
			return (EObject) createIfcResource();
		case Ifc2x3tc1Package.IFC_REVOLVED_AREA_SOLID:
			return (EObject) createIfcRevolvedAreaSolid();
		case Ifc2x3tc1Package.IFC_RIB_PLATE_PROFILE_PROPERTIES:
			return (EObject) createIfcRibPlateProfileProperties();
		case Ifc2x3tc1Package.IFC_RIGHT_CIRCULAR_CONE:
			return (EObject) createIfcRightCircularCone();
		case Ifc2x3tc1Package.IFC_RIGHT_CIRCULAR_CYLINDER:
			return (EObject) createIfcRightCircularCylinder();
		case Ifc2x3tc1Package.IFC_ROOF:
			return (EObject) createIfcRoof();
		case Ifc2x3tc1Package.IFC_ROOT:
			return (EObject) createIfcRoot();
		case Ifc2x3tc1Package.IFC_ROUNDED_EDGE_FEATURE:
			return (EObject) createIfcRoundedEdgeFeature();
		case Ifc2x3tc1Package.IFC_ROUNDED_RECTANGLE_PROFILE_DEF:
			return (EObject) createIfcRoundedRectangleProfileDef();
		case Ifc2x3tc1Package.IFC_SI_UNIT:
			return (EObject) createIfcSIUnit();
		case Ifc2x3tc1Package.IFC_SANITARY_TERMINAL_TYPE:
			return (EObject) createIfcSanitaryTerminalType();
		case Ifc2x3tc1Package.IFC_SCHEDULE_TIME_CONTROL:
			return (EObject) createIfcScheduleTimeControl();
		case Ifc2x3tc1Package.IFC_SECTION_PROPERTIES:
			return (EObject) createIfcSectionProperties();
		case Ifc2x3tc1Package.IFC_SECTION_REINFORCEMENT_PROPERTIES:
			return (EObject) createIfcSectionReinforcementProperties();
		case Ifc2x3tc1Package.IFC_SECTIONED_SPINE:
			return (EObject) createIfcSectionedSpine();
		case Ifc2x3tc1Package.IFC_SENSOR_TYPE:
			return (EObject) createIfcSensorType();
		case Ifc2x3tc1Package.IFC_SERVICE_LIFE:
			return (EObject) createIfcServiceLife();
		case Ifc2x3tc1Package.IFC_SERVICE_LIFE_FACTOR:
			return (EObject) createIfcServiceLifeFactor();
		case Ifc2x3tc1Package.IFC_SHAPE_ASPECT:
			return (EObject) createIfcShapeAspect();
		case Ifc2x3tc1Package.IFC_SHAPE_MODEL:
			return (EObject) createIfcShapeModel();
		case Ifc2x3tc1Package.IFC_SHAPE_REPRESENTATION:
			return (EObject) createIfcShapeRepresentation();
		case Ifc2x3tc1Package.IFC_SHELL_BASED_SURFACE_MODEL:
			return (EObject) createIfcShellBasedSurfaceModel();
		case Ifc2x3tc1Package.IFC_SIMPLE_PROPERTY:
			return (EObject) createIfcSimpleProperty();
		case Ifc2x3tc1Package.IFC_SITE:
			return (EObject) createIfcSite();
		case Ifc2x3tc1Package.IFC_SLAB:
			return (EObject) createIfcSlab();
		case Ifc2x3tc1Package.IFC_SLAB_TYPE:
			return (EObject) createIfcSlabType();
		case Ifc2x3tc1Package.IFC_SLIPPAGE_CONNECTION_CONDITION:
			return (EObject) createIfcSlippageConnectionCondition();
		case Ifc2x3tc1Package.IFC_SOLID_MODEL:
			return (EObject) createIfcSolidModel();
		case Ifc2x3tc1Package.IFC_SOUND_PROPERTIES:
			return (EObject) createIfcSoundProperties();
		case Ifc2x3tc1Package.IFC_SOUND_VALUE:
			return (EObject) createIfcSoundValue();
		case Ifc2x3tc1Package.IFC_SPACE:
			return (EObject) createIfcSpace();
		case Ifc2x3tc1Package.IFC_SPACE_HEATER_TYPE:
			return (EObject) createIfcSpaceHeaterType();
		case Ifc2x3tc1Package.IFC_SPACE_PROGRAM:
			return (EObject) createIfcSpaceProgram();
		case Ifc2x3tc1Package.IFC_SPACE_THERMAL_LOAD_PROPERTIES:
			return (EObject) createIfcSpaceThermalLoadProperties();
		case Ifc2x3tc1Package.IFC_SPACE_TYPE:
			return (EObject) createIfcSpaceType();
		case Ifc2x3tc1Package.IFC_SPATIAL_STRUCTURE_ELEMENT:
			return (EObject) createIfcSpatialStructureElement();
		case Ifc2x3tc1Package.IFC_SPATIAL_STRUCTURE_ELEMENT_TYPE:
			return (EObject) createIfcSpatialStructureElementType();
		case Ifc2x3tc1Package.IFC_SPHERE:
			return (EObject) createIfcSphere();
		case Ifc2x3tc1Package.IFC_STACK_TERMINAL_TYPE:
			return (EObject) createIfcStackTerminalType();
		case Ifc2x3tc1Package.IFC_STAIR:
			return (EObject) createIfcStair();
		case Ifc2x3tc1Package.IFC_STAIR_FLIGHT:
			return (EObject) createIfcStairFlight();
		case Ifc2x3tc1Package.IFC_STAIR_FLIGHT_TYPE:
			return (EObject) createIfcStairFlightType();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ACTION:
			return (EObject) createIfcStructuralAction();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ACTIVITY:
			return (EObject) createIfcStructuralActivity();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ANALYSIS_MODEL:
			return (EObject) createIfcStructuralAnalysisModel();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CONNECTION:
			return (EObject) createIfcStructuralConnection();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CONNECTION_CONDITION:
			return (EObject) createIfcStructuralConnectionCondition();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CURVE_CONNECTION:
			return (EObject) createIfcStructuralCurveConnection();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CURVE_MEMBER:
			return (EObject) createIfcStructuralCurveMember();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CURVE_MEMBER_VARYING:
			return (EObject) createIfcStructuralCurveMemberVarying();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ITEM:
			return (EObject) createIfcStructuralItem();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LINEAR_ACTION:
			return (EObject) createIfcStructuralLinearAction();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LINEAR_ACTION_VARYING:
			return (EObject) createIfcStructuralLinearActionVarying();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD:
			return (EObject) createIfcStructuralLoad();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_GROUP:
			return (EObject) createIfcStructuralLoadGroup();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_LINEAR_FORCE:
			return (EObject) createIfcStructuralLoadLinearForce();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_PLANAR_FORCE:
			return (EObject) createIfcStructuralLoadPlanarForce();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT:
			return (EObject) createIfcStructuralLoadSingleDisplacement();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION:
			return (EObject) createIfcStructuralLoadSingleDisplacementDistortion();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_SINGLE_FORCE:
			return (EObject) createIfcStructuralLoadSingleForce();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING:
			return (EObject) createIfcStructuralLoadSingleForceWarping();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_STATIC:
			return (EObject) createIfcStructuralLoadStatic();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_TEMPERATURE:
			return (EObject) createIfcStructuralLoadTemperature();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_MEMBER:
			return (EObject) createIfcStructuralMember();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_PLANAR_ACTION:
			return (EObject) createIfcStructuralPlanarAction();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_PLANAR_ACTION_VARYING:
			return (EObject) createIfcStructuralPlanarActionVarying();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_POINT_ACTION:
			return (EObject) createIfcStructuralPointAction();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_POINT_CONNECTION:
			return (EObject) createIfcStructuralPointConnection();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_POINT_REACTION:
			return (EObject) createIfcStructuralPointReaction();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_PROFILE_PROPERTIES:
			return (EObject) createIfcStructuralProfileProperties();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_REACTION:
			return (EObject) createIfcStructuralReaction();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_RESULT_GROUP:
			return (EObject) createIfcStructuralResultGroup();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES:
			return (EObject) createIfcStructuralSteelProfileProperties();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_SURFACE_CONNECTION:
			return (EObject) createIfcStructuralSurfaceConnection();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_SURFACE_MEMBER:
			return (EObject) createIfcStructuralSurfaceMember();
		case Ifc2x3tc1Package.IFC_STRUCTURAL_SURFACE_MEMBER_VARYING:
			return (EObject) createIfcStructuralSurfaceMemberVarying();
		case Ifc2x3tc1Package.IFC_STRUCTURED_DIMENSION_CALLOUT:
			return (EObject) createIfcStructuredDimensionCallout();
		case Ifc2x3tc1Package.IFC_STYLE_MODEL:
			return (EObject) createIfcStyleModel();
		case Ifc2x3tc1Package.IFC_STYLED_ITEM:
			return (EObject) createIfcStyledItem();
		case Ifc2x3tc1Package.IFC_STYLED_REPRESENTATION:
			return (EObject) createIfcStyledRepresentation();
		case Ifc2x3tc1Package.IFC_SUB_CONTRACT_RESOURCE:
			return (EObject) createIfcSubContractResource();
		case Ifc2x3tc1Package.IFC_SUBEDGE:
			return (EObject) createIfcSubedge();
		case Ifc2x3tc1Package.IFC_SURFACE:
			return (EObject) createIfcSurface();
		case Ifc2x3tc1Package.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID:
			return (EObject) createIfcSurfaceCurveSweptAreaSolid();
		case Ifc2x3tc1Package.IFC_SURFACE_OF_LINEAR_EXTRUSION:
			return (EObject) createIfcSurfaceOfLinearExtrusion();
		case Ifc2x3tc1Package.IFC_SURFACE_OF_REVOLUTION:
			return (EObject) createIfcSurfaceOfRevolution();
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE:
			return (EObject) createIfcSurfaceStyle();
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_LIGHTING:
			return (EObject) createIfcSurfaceStyleLighting();
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_REFRACTION:
			return (EObject) createIfcSurfaceStyleRefraction();
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_RENDERING:
			return (EObject) createIfcSurfaceStyleRendering();
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_SHADING:
			return (EObject) createIfcSurfaceStyleShading();
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_WITH_TEXTURES:
			return (EObject) createIfcSurfaceStyleWithTextures();
		case Ifc2x3tc1Package.IFC_SURFACE_TEXTURE:
			return (EObject) createIfcSurfaceTexture();
		case Ifc2x3tc1Package.IFC_SWEPT_AREA_SOLID:
			return (EObject) createIfcSweptAreaSolid();
		case Ifc2x3tc1Package.IFC_SWEPT_DISK_SOLID:
			return (EObject) createIfcSweptDiskSolid();
		case Ifc2x3tc1Package.IFC_SWEPT_SURFACE:
			return (EObject) createIfcSweptSurface();
		case Ifc2x3tc1Package.IFC_SWITCHING_DEVICE_TYPE:
			return (EObject) createIfcSwitchingDeviceType();
		case Ifc2x3tc1Package.IFC_SYMBOL_STYLE:
			return (EObject) createIfcSymbolStyle();
		case Ifc2x3tc1Package.IFC_SYSTEM:
			return (EObject) createIfcSystem();
		case Ifc2x3tc1Package.IFC_SYSTEM_FURNITURE_ELEMENT_TYPE:
			return (EObject) createIfcSystemFurnitureElementType();
		case Ifc2x3tc1Package.IFC_TSHAPE_PROFILE_DEF:
			return (EObject) createIfcTShapeProfileDef();
		case Ifc2x3tc1Package.IFC_TABLE:
			return (EObject) createIfcTable();
		case Ifc2x3tc1Package.IFC_TABLE_ROW:
			return (EObject) createIfcTableRow();
		case Ifc2x3tc1Package.IFC_TANK_TYPE:
			return (EObject) createIfcTankType();
		case Ifc2x3tc1Package.IFC_TASK:
			return (EObject) createIfcTask();
		case Ifc2x3tc1Package.IFC_TELECOM_ADDRESS:
			return (EObject) createIfcTelecomAddress();
		case Ifc2x3tc1Package.IFC_TENDON:
			return (EObject) createIfcTendon();
		case Ifc2x3tc1Package.IFC_TENDON_ANCHOR:
			return (EObject) createIfcTendonAnchor();
		case Ifc2x3tc1Package.IFC_TERMINATOR_SYMBOL:
			return (EObject) createIfcTerminatorSymbol();
		case Ifc2x3tc1Package.IFC_TEXT_LITERAL:
			return (EObject) createIfcTextLiteral();
		case Ifc2x3tc1Package.IFC_TEXT_LITERAL_WITH_EXTENT:
			return (EObject) createIfcTextLiteralWithExtent();
		case Ifc2x3tc1Package.IFC_TEXT_STYLE:
			return (EObject) createIfcTextStyle();
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_FONT_MODEL:
			return (EObject) createIfcTextStyleFontModel();
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_FOR_DEFINED_FONT:
			return (EObject) createIfcTextStyleForDefinedFont();
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_TEXT_MODEL:
			return (EObject) createIfcTextStyleTextModel();
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_WITH_BOX_CHARACTERISTICS:
			return (EObject) createIfcTextStyleWithBoxCharacteristics();
		case Ifc2x3tc1Package.IFC_TEXTURE_COORDINATE:
			return (EObject) createIfcTextureCoordinate();
		case Ifc2x3tc1Package.IFC_TEXTURE_COORDINATE_GENERATOR:
			return (EObject) createIfcTextureCoordinateGenerator();
		case Ifc2x3tc1Package.IFC_TEXTURE_MAP:
			return (EObject) createIfcTextureMap();
		case Ifc2x3tc1Package.IFC_TEXTURE_VERTEX:
			return (EObject) createIfcTextureVertex();
		case Ifc2x3tc1Package.IFC_THERMAL_MATERIAL_PROPERTIES:
			return (EObject) createIfcThermalMaterialProperties();
		case Ifc2x3tc1Package.IFC_TIME_SERIES:
			return (EObject) createIfcTimeSeries();
		case Ifc2x3tc1Package.IFC_TIME_SERIES_REFERENCE_RELATIONSHIP:
			return (EObject) createIfcTimeSeriesReferenceRelationship();
		case Ifc2x3tc1Package.IFC_TIME_SERIES_SCHEDULE:
			return (EObject) createIfcTimeSeriesSchedule();
		case Ifc2x3tc1Package.IFC_TIME_SERIES_VALUE:
			return (EObject) createIfcTimeSeriesValue();
		case Ifc2x3tc1Package.IFC_TOPOLOGICAL_REPRESENTATION_ITEM:
			return (EObject) createIfcTopologicalRepresentationItem();
		case Ifc2x3tc1Package.IFC_TOPOLOGY_REPRESENTATION:
			return (EObject) createIfcTopologyRepresentation();
		case Ifc2x3tc1Package.IFC_TRANSFORMER_TYPE:
			return (EObject) createIfcTransformerType();
		case Ifc2x3tc1Package.IFC_TRANSPORT_ELEMENT:
			return (EObject) createIfcTransportElement();
		case Ifc2x3tc1Package.IFC_TRANSPORT_ELEMENT_TYPE:
			return (EObject) createIfcTransportElementType();
		case Ifc2x3tc1Package.IFC_TRAPEZIUM_PROFILE_DEF:
			return (EObject) createIfcTrapeziumProfileDef();
		case Ifc2x3tc1Package.IFC_TRIMMED_CURVE:
			return (EObject) createIfcTrimmedCurve();
		case Ifc2x3tc1Package.IFC_TUBE_BUNDLE_TYPE:
			return (EObject) createIfcTubeBundleType();
		case Ifc2x3tc1Package.IFC_TWO_DIRECTION_REPEAT_FACTOR:
			return (EObject) createIfcTwoDirectionRepeatFactor();
		case Ifc2x3tc1Package.IFC_TYPE_OBJECT:
			return (EObject) createIfcTypeObject();
		case Ifc2x3tc1Package.IFC_TYPE_PRODUCT:
			return (EObject) createIfcTypeProduct();
		case Ifc2x3tc1Package.IFC_USHAPE_PROFILE_DEF:
			return (EObject) createIfcUShapeProfileDef();
		case Ifc2x3tc1Package.IFC_UNIT_ASSIGNMENT:
			return (EObject) createIfcUnitAssignment();
		case Ifc2x3tc1Package.IFC_UNITARY_EQUIPMENT_TYPE:
			return (EObject) createIfcUnitaryEquipmentType();
		case Ifc2x3tc1Package.IFC_VALVE_TYPE:
			return (EObject) createIfcValveType();
		case Ifc2x3tc1Package.IFC_VECTOR:
			return (EObject) createIfcVector();
		case Ifc2x3tc1Package.IFC_VERTEX:
			return (EObject) createIfcVertex();
		case Ifc2x3tc1Package.IFC_VERTEX_BASED_TEXTURE_MAP:
			return (EObject) createIfcVertexBasedTextureMap();
		case Ifc2x3tc1Package.IFC_VERTEX_LOOP:
			return (EObject) createIfcVertexLoop();
		case Ifc2x3tc1Package.IFC_VERTEX_POINT:
			return (EObject) createIfcVertexPoint();
		case Ifc2x3tc1Package.IFC_VIBRATION_ISOLATOR_TYPE:
			return (EObject) createIfcVibrationIsolatorType();
		case Ifc2x3tc1Package.IFC_VIRTUAL_ELEMENT:
			return (EObject) createIfcVirtualElement();
		case Ifc2x3tc1Package.IFC_VIRTUAL_GRID_INTERSECTION:
			return (EObject) createIfcVirtualGridIntersection();
		case Ifc2x3tc1Package.IFC_WALL:
			return (EObject) createIfcWall();
		case Ifc2x3tc1Package.IFC_WALL_STANDARD_CASE:
			return (EObject) createIfcWallStandardCase();
		case Ifc2x3tc1Package.IFC_WALL_TYPE:
			return (EObject) createIfcWallType();
		case Ifc2x3tc1Package.IFC_WASTE_TERMINAL_TYPE:
			return (EObject) createIfcWasteTerminalType();
		case Ifc2x3tc1Package.IFC_WATER_PROPERTIES:
			return (EObject) createIfcWaterProperties();
		case Ifc2x3tc1Package.IFC_WINDOW:
			return (EObject) createIfcWindow();
		case Ifc2x3tc1Package.IFC_WINDOW_LINING_PROPERTIES:
			return (EObject) createIfcWindowLiningProperties();
		case Ifc2x3tc1Package.IFC_WINDOW_PANEL_PROPERTIES:
			return (EObject) createIfcWindowPanelProperties();
		case Ifc2x3tc1Package.IFC_WINDOW_STYLE:
			return (EObject) createIfcWindowStyle();
		case Ifc2x3tc1Package.IFC_WORK_CONTROL:
			return (EObject) createIfcWorkControl();
		case Ifc2x3tc1Package.IFC_WORK_PLAN:
			return (EObject) createIfcWorkPlan();
		case Ifc2x3tc1Package.IFC_WORK_SCHEDULE:
			return (EObject) createIfcWorkSchedule();
		case Ifc2x3tc1Package.IFC_ZSHAPE_PROFILE_DEF:
			return (EObject) createIfcZShapeProfileDef();
		case Ifc2x3tc1Package.IFC_ZONE:
			return (EObject) createIfcZone();
		case Ifc2x3tc1Package.IFC_ABSORBED_DOSE_MEASURE:
			return (EObject) createIfcAbsorbedDoseMeasure();
		case Ifc2x3tc1Package.IFC_ACCELERATION_MEASURE:
			return (EObject) createIfcAccelerationMeasure();
		case Ifc2x3tc1Package.IFC_AMOUNT_OF_SUBSTANCE_MEASURE:
			return (EObject) createIfcAmountOfSubstanceMeasure();
		case Ifc2x3tc1Package.IFC_ANGULAR_VELOCITY_MEASURE:
			return (EObject) createIfcAngularVelocityMeasure();
		case Ifc2x3tc1Package.IFC_AREA_MEASURE:
			return (EObject) createIfcAreaMeasure();
		case Ifc2x3tc1Package.IFC_BOOLEAN:
			return (EObject) createIfcBoolean();
		case Ifc2x3tc1Package.IFC_CONTEXT_DEPENDENT_MEASURE:
			return (EObject) createIfcContextDependentMeasure();
		case Ifc2x3tc1Package.IFC_COUNT_MEASURE:
			return (EObject) createIfcCountMeasure();
		case Ifc2x3tc1Package.IFC_CURVATURE_MEASURE:
			return (EObject) createIfcCurvatureMeasure();
		case Ifc2x3tc1Package.IFC_DAY_IN_MONTH_NUMBER:
			return (EObject) createIfcDayInMonthNumber();
		case Ifc2x3tc1Package.IFC_DAYLIGHT_SAVING_HOUR:
			return (EObject) createIfcDaylightSavingHour();
		case Ifc2x3tc1Package.IFC_DESCRIPTIVE_MEASURE:
			return (EObject) createIfcDescriptiveMeasure();
		case Ifc2x3tc1Package.IFC_DIMENSION_COUNT:
			return (EObject) createIfcDimensionCount();
		case Ifc2x3tc1Package.IFC_DOSE_EQUIVALENT_MEASURE:
			return (EObject) createIfcDoseEquivalentMeasure();
		case Ifc2x3tc1Package.IFC_DYNAMIC_VISCOSITY_MEASURE:
			return (EObject) createIfcDynamicViscosityMeasure();
		case Ifc2x3tc1Package.IFC_ELECTRIC_CAPACITANCE_MEASURE:
			return (EObject) createIfcElectricCapacitanceMeasure();
		case Ifc2x3tc1Package.IFC_ELECTRIC_CHARGE_MEASURE:
			return (EObject) createIfcElectricChargeMeasure();
		case Ifc2x3tc1Package.IFC_ELECTRIC_CONDUCTANCE_MEASURE:
			return (EObject) createIfcElectricConductanceMeasure();
		case Ifc2x3tc1Package.IFC_ELECTRIC_CURRENT_MEASURE:
			return (EObject) createIfcElectricCurrentMeasure();
		case Ifc2x3tc1Package.IFC_ELECTRIC_RESISTANCE_MEASURE:
			return (EObject) createIfcElectricResistanceMeasure();
		case Ifc2x3tc1Package.IFC_ELECTRIC_VOLTAGE_MEASURE:
			return (EObject) createIfcElectricVoltageMeasure();
		case Ifc2x3tc1Package.IFC_ENERGY_MEASURE:
			return (EObject) createIfcEnergyMeasure();
		case Ifc2x3tc1Package.IFC_FONT_STYLE:
			return (EObject) createIfcFontStyle();
		case Ifc2x3tc1Package.IFC_FONT_VARIANT:
			return (EObject) createIfcFontVariant();
		case Ifc2x3tc1Package.IFC_FONT_WEIGHT:
			return (EObject) createIfcFontWeight();
		case Ifc2x3tc1Package.IFC_FORCE_MEASURE:
			return (EObject) createIfcForceMeasure();
		case Ifc2x3tc1Package.IFC_FREQUENCY_MEASURE:
			return (EObject) createIfcFrequencyMeasure();
		case Ifc2x3tc1Package.IFC_GLOBALLY_UNIQUE_ID:
			return (EObject) createIfcGloballyUniqueId();
		case Ifc2x3tc1Package.IFC_HEAT_FLUX_DENSITY_MEASURE:
			return (EObject) createIfcHeatFluxDensityMeasure();
		case Ifc2x3tc1Package.IFC_HEATING_VALUE_MEASURE:
			return (EObject) createIfcHeatingValueMeasure();
		case Ifc2x3tc1Package.IFC_HOUR_IN_DAY:
			return (EObject) createIfcHourInDay();
		case Ifc2x3tc1Package.IFC_IDENTIFIER:
			return (EObject) createIfcIdentifier();
		case Ifc2x3tc1Package.IFC_ILLUMINANCE_MEASURE:
			return (EObject) createIfcIlluminanceMeasure();
		case Ifc2x3tc1Package.IFC_INDUCTANCE_MEASURE:
			return (EObject) createIfcInductanceMeasure();
		case Ifc2x3tc1Package.IFC_INTEGER:
			return (EObject) createIfcInteger();
		case Ifc2x3tc1Package.IFC_INTEGER_COUNT_RATE_MEASURE:
			return (EObject) createIfcIntegerCountRateMeasure();
		case Ifc2x3tc1Package.IFC_ION_CONCENTRATION_MEASURE:
			return (EObject) createIfcIonConcentrationMeasure();
		case Ifc2x3tc1Package.IFC_ISOTHERMAL_MOISTURE_CAPACITY_MEASURE:
			return (EObject) createIfcIsothermalMoistureCapacityMeasure();
		case Ifc2x3tc1Package.IFC_KINEMATIC_VISCOSITY_MEASURE:
			return (EObject) createIfcKinematicViscosityMeasure();
		case Ifc2x3tc1Package.IFC_LABEL:
			return (EObject) createIfcLabel();
		case Ifc2x3tc1Package.IFC_LENGTH_MEASURE:
			return (EObject) createIfcLengthMeasure();
		case Ifc2x3tc1Package.IFC_LINEAR_FORCE_MEASURE:
			return (EObject) createIfcLinearForceMeasure();
		case Ifc2x3tc1Package.IFC_LINEAR_MOMENT_MEASURE:
			return (EObject) createIfcLinearMomentMeasure();
		case Ifc2x3tc1Package.IFC_LINEAR_STIFFNESS_MEASURE:
			return (EObject) createIfcLinearStiffnessMeasure();
		case Ifc2x3tc1Package.IFC_LINEAR_VELOCITY_MEASURE:
			return (EObject) createIfcLinearVelocityMeasure();
		case Ifc2x3tc1Package.IFC_LOGICAL:
			return (EObject) createIfcLogical();
		case Ifc2x3tc1Package.IFC_LUMINOUS_FLUX_MEASURE:
			return (EObject) createIfcLuminousFluxMeasure();
		case Ifc2x3tc1Package.IFC_LUMINOUS_INTENSITY_DISTRIBUTION_MEASURE:
			return (EObject) createIfcLuminousIntensityDistributionMeasure();
		case Ifc2x3tc1Package.IFC_LUMINOUS_INTENSITY_MEASURE:
			return (EObject) createIfcLuminousIntensityMeasure();
		case Ifc2x3tc1Package.IFC_MAGNETIC_FLUX_DENSITY_MEASURE:
			return (EObject) createIfcMagneticFluxDensityMeasure();
		case Ifc2x3tc1Package.IFC_MAGNETIC_FLUX_MEASURE:
			return (EObject) createIfcMagneticFluxMeasure();
		case Ifc2x3tc1Package.IFC_MASS_DENSITY_MEASURE:
			return (EObject) createIfcMassDensityMeasure();
		case Ifc2x3tc1Package.IFC_MASS_FLOW_RATE_MEASURE:
			return (EObject) createIfcMassFlowRateMeasure();
		case Ifc2x3tc1Package.IFC_MASS_MEASURE:
			return (EObject) createIfcMassMeasure();
		case Ifc2x3tc1Package.IFC_MASS_PER_LENGTH_MEASURE:
			return (EObject) createIfcMassPerLengthMeasure();
		case Ifc2x3tc1Package.IFC_MINUTE_IN_HOUR:
			return (EObject) createIfcMinuteInHour();
		case Ifc2x3tc1Package.IFC_MODULUS_OF_ELASTICITY_MEASURE:
			return (EObject) createIfcModulusOfElasticityMeasure();
		case Ifc2x3tc1Package.IFC_MODULUS_OF_LINEAR_SUBGRADE_REACTION_MEASURE:
			return (EObject) createIfcModulusOfLinearSubgradeReactionMeasure();
		case Ifc2x3tc1Package.IFC_MODULUS_OF_ROTATIONAL_SUBGRADE_REACTION_MEASURE:
			return (EObject) createIfcModulusOfRotationalSubgradeReactionMeasure();
		case Ifc2x3tc1Package.IFC_MODULUS_OF_SUBGRADE_REACTION_MEASURE:
			return (EObject) createIfcModulusOfSubgradeReactionMeasure();
		case Ifc2x3tc1Package.IFC_MOISTURE_DIFFUSIVITY_MEASURE:
			return (EObject) createIfcMoistureDiffusivityMeasure();
		case Ifc2x3tc1Package.IFC_MOLECULAR_WEIGHT_MEASURE:
			return (EObject) createIfcMolecularWeightMeasure();
		case Ifc2x3tc1Package.IFC_MOMENT_OF_INERTIA_MEASURE:
			return (EObject) createIfcMomentOfInertiaMeasure();
		case Ifc2x3tc1Package.IFC_MONETARY_MEASURE:
			return (EObject) createIfcMonetaryMeasure();
		case Ifc2x3tc1Package.IFC_MONTH_IN_YEAR_NUMBER:
			return (EObject) createIfcMonthInYearNumber();
		case Ifc2x3tc1Package.IFC_NUMERIC_MEASURE:
			return (EObject) createIfcNumericMeasure();
		case Ifc2x3tc1Package.IFC_PH_MEASURE:
			return (EObject) createIfcPHMeasure();
		case Ifc2x3tc1Package.IFC_PARAMETER_VALUE:
			return (EObject) createIfcParameterValue();
		case Ifc2x3tc1Package.IFC_PLANAR_FORCE_MEASURE:
			return (EObject) createIfcPlanarForceMeasure();
		case Ifc2x3tc1Package.IFC_PLANE_ANGLE_MEASURE:
			return (EObject) createIfcPlaneAngleMeasure();
		case Ifc2x3tc1Package.IFC_POWER_MEASURE:
			return (EObject) createIfcPowerMeasure();
		case Ifc2x3tc1Package.IFC_PRESENTABLE_TEXT:
			return (EObject) createIfcPresentableText();
		case Ifc2x3tc1Package.IFC_PRESSURE_MEASURE:
			return (EObject) createIfcPressureMeasure();
		case Ifc2x3tc1Package.IFC_RADIO_ACTIVITY_MEASURE:
			return (EObject) createIfcRadioActivityMeasure();
		case Ifc2x3tc1Package.IFC_RATIO_MEASURE:
			return (EObject) createIfcRatioMeasure();
		case Ifc2x3tc1Package.IFC_REAL:
			return (EObject) createIfcReal();
		case Ifc2x3tc1Package.IFC_ROTATIONAL_FREQUENCY_MEASURE:
			return (EObject) createIfcRotationalFrequencyMeasure();
		case Ifc2x3tc1Package.IFC_ROTATIONAL_MASS_MEASURE:
			return (EObject) createIfcRotationalMassMeasure();
		case Ifc2x3tc1Package.IFC_ROTATIONAL_STIFFNESS_MEASURE:
			return (EObject) createIfcRotationalStiffnessMeasure();
		case Ifc2x3tc1Package.IFC_SECOND_IN_MINUTE:
			return (EObject) createIfcSecondInMinute();
		case Ifc2x3tc1Package.IFC_SECTION_MODULUS_MEASURE:
			return (EObject) createIfcSectionModulusMeasure();
		case Ifc2x3tc1Package.IFC_SECTIONAL_AREA_INTEGRAL_MEASURE:
			return (EObject) createIfcSectionalAreaIntegralMeasure();
		case Ifc2x3tc1Package.IFC_SHEAR_MODULUS_MEASURE:
			return (EObject) createIfcShearModulusMeasure();
		case Ifc2x3tc1Package.IFC_SOLID_ANGLE_MEASURE:
			return (EObject) createIfcSolidAngleMeasure();
		case Ifc2x3tc1Package.IFC_SOUND_POWER_MEASURE:
			return (EObject) createIfcSoundPowerMeasure();
		case Ifc2x3tc1Package.IFC_SOUND_PRESSURE_MEASURE:
			return (EObject) createIfcSoundPressureMeasure();
		case Ifc2x3tc1Package.IFC_SPECIFIC_HEAT_CAPACITY_MEASURE:
			return (EObject) createIfcSpecificHeatCapacityMeasure();
		case Ifc2x3tc1Package.IFC_SPECULAR_EXPONENT:
			return (EObject) createIfcSpecularExponent();
		case Ifc2x3tc1Package.IFC_SPECULAR_ROUGHNESS:
			return (EObject) createIfcSpecularRoughness();
		case Ifc2x3tc1Package.IFC_TEMPERATURE_GRADIENT_MEASURE:
			return (EObject) createIfcTemperatureGradientMeasure();
		case Ifc2x3tc1Package.IFC_TEXT:
			return (EObject) createIfcText();
		case Ifc2x3tc1Package.IFC_TEXT_ALIGNMENT:
			return (EObject) createIfcTextAlignment();
		case Ifc2x3tc1Package.IFC_TEXT_DECORATION:
			return (EObject) createIfcTextDecoration();
		case Ifc2x3tc1Package.IFC_TEXT_FONT_NAME:
			return (EObject) createIfcTextFontName();
		case Ifc2x3tc1Package.IFC_TEXT_TRANSFORMATION:
			return (EObject) createIfcTextTransformation();
		case Ifc2x3tc1Package.IFC_THERMAL_ADMITTANCE_MEASURE:
			return (EObject) createIfcThermalAdmittanceMeasure();
		case Ifc2x3tc1Package.IFC_THERMAL_CONDUCTIVITY_MEASURE:
			return (EObject) createIfcThermalConductivityMeasure();
		case Ifc2x3tc1Package.IFC_THERMAL_EXPANSION_COEFFICIENT_MEASURE:
			return (EObject) createIfcThermalExpansionCoefficientMeasure();
		case Ifc2x3tc1Package.IFC_THERMAL_RESISTANCE_MEASURE:
			return (EObject) createIfcThermalResistanceMeasure();
		case Ifc2x3tc1Package.IFC_THERMAL_TRANSMITTANCE_MEASURE:
			return (EObject) createIfcThermalTransmittanceMeasure();
		case Ifc2x3tc1Package.IFC_THERMODYNAMIC_TEMPERATURE_MEASURE:
			return (EObject) createIfcThermodynamicTemperatureMeasure();
		case Ifc2x3tc1Package.IFC_TIME_MEASURE:
			return (EObject) createIfcTimeMeasure();
		case Ifc2x3tc1Package.IFC_TIME_STAMP:
			return (EObject) createIfcTimeStamp();
		case Ifc2x3tc1Package.IFC_TORQUE_MEASURE:
			return (EObject) createIfcTorqueMeasure();
		case Ifc2x3tc1Package.IFC_VAPOR_PERMEABILITY_MEASURE:
			return (EObject) createIfcVaporPermeabilityMeasure();
		case Ifc2x3tc1Package.IFC_VOLUME_MEASURE:
			return (EObject) createIfcVolumeMeasure();
		case Ifc2x3tc1Package.IFC_VOLUMETRIC_FLOW_RATE_MEASURE:
			return (EObject) createIfcVolumetricFlowRateMeasure();
		case Ifc2x3tc1Package.IFC_WARPING_CONSTANT_MEASURE:
			return (EObject) createIfcWarpingConstantMeasure();
		case Ifc2x3tc1Package.IFC_WARPING_MOMENT_MEASURE:
			return (EObject) createIfcWarpingMomentMeasure();
		case Ifc2x3tc1Package.IFC_YEAR_NUMBER:
			return (EObject) createIfcYearNumber();
		case Ifc2x3tc1Package.IFC_BOX_ALIGNMENT:
			return (EObject) createIfcBoxAlignment();
		case Ifc2x3tc1Package.IFC_COMPOUND_PLANE_ANGLE_MEASURE:
			return (EObject) createIfcCompoundPlaneAngleMeasure();
		case Ifc2x3tc1Package.IFC_NORMALISED_RATIO_MEASURE:
			return (EObject) createIfcNormalisedRatioMeasure();
		case Ifc2x3tc1Package.IFC_POSITIVE_LENGTH_MEASURE:
			return (EObject) createIfcPositiveLengthMeasure();
		case Ifc2x3tc1Package.IFC_POSITIVE_PLANE_ANGLE_MEASURE:
			return (EObject) createIfcPositivePlaneAngleMeasure();
		case Ifc2x3tc1Package.IFC_POSITIVE_RATIO_MEASURE:
			return (EObject) createIfcPositiveRatioMeasure();
		case Ifc2x3tc1Package.IFC_COMPLEX_NUMBER:
			return (EObject) createIfcComplexNumber();
		case Ifc2x3tc1Package.IFC_NULL_STYLE:
			return (EObject) createIfcNullStyle();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case Ifc2x3tc1Package.TRISTATE:
			return createTristateFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ACTION_SOURCE_TYPE_ENUM:
			return createIfcActionSourceTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ACTION_TYPE_ENUM:
			return createIfcActionTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ACTUATOR_TYPE_ENUM:
			return createIfcActuatorTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ADDRESS_TYPE_ENUM:
			return createIfcAddressTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_AHEAD_OR_BEHIND:
			return createIfcAheadOrBehindFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_AIR_TERMINAL_BOX_TYPE_ENUM:
			return createIfcAirTerminalBoxTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_AIR_TERMINAL_TYPE_ENUM:
			return createIfcAirTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_AIR_TO_AIR_HEAT_RECOVERY_TYPE_ENUM:
			return createIfcAirToAirHeatRecoveryTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ALARM_TYPE_ENUM:
			return createIfcAlarmTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ANALYSIS_MODEL_TYPE_ENUM:
			return createIfcAnalysisModelTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ANALYSIS_THEORY_TYPE_ENUM:
			return createIfcAnalysisTheoryTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ARITHMETIC_OPERATOR_ENUM:
			return createIfcArithmeticOperatorEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ASSEMBLY_PLACE_ENUM:
			return createIfcAssemblyPlaceEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_BSPLINE_CURVE_FORM:
			return createIfcBSplineCurveFormFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_BEAM_TYPE_ENUM:
			return createIfcBeamTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_BENCHMARK_ENUM:
			return createIfcBenchmarkEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_BOILER_TYPE_ENUM:
			return createIfcBoilerTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_BOOLEAN_OPERATOR:
			return createIfcBooleanOperatorFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_PROXY_TYPE_ENUM:
			return createIfcBuildingElementProxyTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CABLE_CARRIER_FITTING_TYPE_ENUM:
			return createIfcCableCarrierFittingTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CABLE_CARRIER_SEGMENT_TYPE_ENUM:
			return createIfcCableCarrierSegmentTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CABLE_SEGMENT_TYPE_ENUM:
			return createIfcCableSegmentTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CHANGE_ACTION_ENUM:
			return createIfcChangeActionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CHILLER_TYPE_ENUM:
			return createIfcChillerTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_COIL_TYPE_ENUM:
			return createIfcCoilTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_COLUMN_TYPE_ENUM:
			return createIfcColumnTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_COMPRESSOR_TYPE_ENUM:
			return createIfcCompressorTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CONDENSER_TYPE_ENUM:
			return createIfcCondenserTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CONNECTION_TYPE_ENUM:
			return createIfcConnectionTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CONSTRAINT_ENUM:
			return createIfcConstraintEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CONTROLLER_TYPE_ENUM:
			return createIfcControllerTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_COOLED_BEAM_TYPE_ENUM:
			return createIfcCooledBeamTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_COOLING_TOWER_TYPE_ENUM:
			return createIfcCoolingTowerTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_COST_SCHEDULE_TYPE_ENUM:
			return createIfcCostScheduleTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_COVERING_TYPE_ENUM:
			return createIfcCoveringTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CURRENCY_ENUM:
			return createIfcCurrencyEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_CURTAIN_WALL_TYPE_ENUM:
			return createIfcCurtainWallTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DAMPER_TYPE_ENUM:
			return createIfcDamperTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DATA_ORIGIN_ENUM:
			return createIfcDataOriginEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DERIVED_UNIT_ENUM:
			return createIfcDerivedUnitEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DIMENSION_EXTENT_USAGE:
			return createIfcDimensionExtentUsageFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DIRECTION_SENSE_ENUM:
			return createIfcDirectionSenseEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT_TYPE_ENUM:
			return createIfcDistributionChamberElementTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DOCUMENT_CONFIDENTIALITY_ENUM:
			return createIfcDocumentConfidentialityEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DOCUMENT_STATUS_ENUM:
			return createIfcDocumentStatusEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DOOR_PANEL_OPERATION_ENUM:
			return createIfcDoorPanelOperationEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DOOR_PANEL_POSITION_ENUM:
			return createIfcDoorPanelPositionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DOOR_STYLE_CONSTRUCTION_ENUM:
			return createIfcDoorStyleConstructionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DOOR_STYLE_OPERATION_ENUM:
			return createIfcDoorStyleOperationEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DUCT_FITTING_TYPE_ENUM:
			return createIfcDuctFittingTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DUCT_SEGMENT_TYPE_ENUM:
			return createIfcDuctSegmentTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_DUCT_SILENCER_TYPE_ENUM:
			return createIfcDuctSilencerTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_APPLIANCE_TYPE_ENUM:
			return createIfcElectricApplianceTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_CURRENT_ENUM:
			return createIfcElectricCurrentEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_DISTRIBUTION_POINT_FUNCTION_ENUM:
			return createIfcElectricDistributionPointFunctionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_FLOW_STORAGE_DEVICE_TYPE_ENUM:
			return createIfcElectricFlowStorageDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_GENERATOR_TYPE_ENUM:
			return createIfcElectricGeneratorTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_HEATER_TYPE_ENUM:
			return createIfcElectricHeaterTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_MOTOR_TYPE_ENUM:
			return createIfcElectricMotorTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_TIME_CONTROL_TYPE_ENUM:
			return createIfcElectricTimeControlTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELEMENT_ASSEMBLY_TYPE_ENUM:
			return createIfcElementAssemblyTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ELEMENT_COMPOSITION_ENUM:
			return createIfcElementCompositionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ENERGY_SEQUENCE_ENUM:
			return createIfcEnergySequenceEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ENVIRONMENTAL_IMPACT_CATEGORY_ENUM:
			return createIfcEnvironmentalImpactCategoryEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_EVAPORATIVE_COOLER_TYPE_ENUM:
			return createIfcEvaporativeCoolerTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_EVAPORATOR_TYPE_ENUM:
			return createIfcEvaporatorTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_FAN_TYPE_ENUM:
			return createIfcFanTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_FILTER_TYPE_ENUM:
			return createIfcFilterTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_FIRE_SUPPRESSION_TERMINAL_TYPE_ENUM:
			return createIfcFireSuppressionTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_FLOW_DIRECTION_ENUM:
			return createIfcFlowDirectionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_FLOW_INSTRUMENT_TYPE_ENUM:
			return createIfcFlowInstrumentTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_FLOW_METER_TYPE_ENUM:
			return createIfcFlowMeterTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_FOOTING_TYPE_ENUM:
			return createIfcFootingTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_GAS_TERMINAL_TYPE_ENUM:
			return createIfcGasTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_GEOMETRIC_PROJECTION_ENUM:
			return createIfcGeometricProjectionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_GLOBAL_OR_LOCAL_ENUM:
			return createIfcGlobalOrLocalEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_HEAT_EXCHANGER_TYPE_ENUM:
			return createIfcHeatExchangerTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_HUMIDIFIER_TYPE_ENUM:
			return createIfcHumidifierTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_INTERNAL_OR_EXTERNAL_ENUM:
			return createIfcInternalOrExternalEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_INVENTORY_TYPE_ENUM:
			return createIfcInventoryTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_JUNCTION_BOX_TYPE_ENUM:
			return createIfcJunctionBoxTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_LAMP_TYPE_ENUM:
			return createIfcLampTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_LAYER_SET_DIRECTION_ENUM:
			return createIfcLayerSetDirectionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_LIGHT_DISTRIBUTION_CURVE_ENUM:
			return createIfcLightDistributionCurveEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_LIGHT_EMISSION_SOURCE_ENUM:
			return createIfcLightEmissionSourceEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_LIGHT_FIXTURE_TYPE_ENUM:
			return createIfcLightFixtureTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_LOAD_GROUP_TYPE_ENUM:
			return createIfcLoadGroupTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_LOGICAL_OPERATOR_ENUM:
			return createIfcLogicalOperatorEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_MEMBER_TYPE_ENUM:
			return createIfcMemberTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_MOTOR_CONNECTION_TYPE_ENUM:
			return createIfcMotorConnectionTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_NULL_STYLE_ENUM:
			return createIfcNullStyleEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_OBJECT_TYPE_ENUM:
			return createIfcObjectTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_OBJECTIVE_ENUM:
			return createIfcObjectiveEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_OCCUPANT_TYPE_ENUM:
			return createIfcOccupantTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_OUTLET_TYPE_ENUM:
			return createIfcOutletTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PERMEABLE_COVERING_OPERATION_ENUM:
			return createIfcPermeableCoveringOperationEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PHYSICAL_OR_VIRTUAL_ENUM:
			return createIfcPhysicalOrVirtualEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PILE_CONSTRUCTION_ENUM:
			return createIfcPileConstructionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PILE_TYPE_ENUM:
			return createIfcPileTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PIPE_FITTING_TYPE_ENUM:
			return createIfcPipeFittingTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PIPE_SEGMENT_TYPE_ENUM:
			return createIfcPipeSegmentTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PLATE_TYPE_ENUM:
			return createIfcPlateTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PROCEDURE_TYPE_ENUM:
			return createIfcProcedureTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PROFILE_TYPE_ENUM:
			return createIfcProfileTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PROJECT_ORDER_RECORD_TYPE_ENUM:
			return createIfcProjectOrderRecordTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PROJECT_ORDER_TYPE_ENUM:
			return createIfcProjectOrderTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PROJECTED_OR_TRUE_LENGTH_ENUM:
			return createIfcProjectedOrTrueLengthEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PROPERTY_SOURCE_ENUM:
			return createIfcPropertySourceEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PROTECTIVE_DEVICE_TYPE_ENUM:
			return createIfcProtectiveDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_PUMP_TYPE_ENUM:
			return createIfcPumpTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_RAILING_TYPE_ENUM:
			return createIfcRailingTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_RAMP_FLIGHT_TYPE_ENUM:
			return createIfcRampFlightTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_RAMP_TYPE_ENUM:
			return createIfcRampTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_REFLECTANCE_METHOD_ENUM:
			return createIfcReflectanceMethodEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_REINFORCING_BAR_ROLE_ENUM:
			return createIfcReinforcingBarRoleEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_REINFORCING_BAR_SURFACE_ENUM:
			return createIfcReinforcingBarSurfaceEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_RESOURCE_CONSUMPTION_ENUM:
			return createIfcResourceConsumptionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_RIB_PLATE_DIRECTION_ENUM:
			return createIfcRibPlateDirectionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ROLE_ENUM:
			return createIfcRoleEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_ROOF_TYPE_ENUM:
			return createIfcRoofTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SI_PREFIX:
			return createIfcSIPrefixFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SI_UNIT_NAME:
			return createIfcSIUnitNameFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SANITARY_TERMINAL_TYPE_ENUM:
			return createIfcSanitaryTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SECTION_TYPE_ENUM:
			return createIfcSectionTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SENSOR_TYPE_ENUM:
			return createIfcSensorTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SEQUENCE_ENUM:
			return createIfcSequenceEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SERVICE_LIFE_FACTOR_TYPE_ENUM:
			return createIfcServiceLifeFactorTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SERVICE_LIFE_TYPE_ENUM:
			return createIfcServiceLifeTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SLAB_TYPE_ENUM:
			return createIfcSlabTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SOUND_SCALE_ENUM:
			return createIfcSoundScaleEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SPACE_HEATER_TYPE_ENUM:
			return createIfcSpaceHeaterTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SPACE_TYPE_ENUM:
			return createIfcSpaceTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_STACK_TERMINAL_TYPE_ENUM:
			return createIfcStackTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_STAIR_FLIGHT_TYPE_ENUM:
			return createIfcStairFlightTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_STAIR_TYPE_ENUM:
			return createIfcStairTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_STATE_ENUM:
			return createIfcStateEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CURVE_TYPE_ENUM:
			return createIfcStructuralCurveTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_STRUCTURAL_SURFACE_TYPE_ENUM:
			return createIfcStructuralSurfaceTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SURFACE_SIDE:
			return createIfcSurfaceSideFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SURFACE_TEXTURE_ENUM:
			return createIfcSurfaceTextureEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_SWITCHING_DEVICE_TYPE_ENUM:
			return createIfcSwitchingDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TANK_TYPE_ENUM:
			return createIfcTankTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TENDON_TYPE_ENUM:
			return createIfcTendonTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TEXT_PATH:
			return createIfcTextPathFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_THERMAL_LOAD_SOURCE_ENUM:
			return createIfcThermalLoadSourceEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_THERMAL_LOAD_TYPE_ENUM:
			return createIfcThermalLoadTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TIME_SERIES_DATA_TYPE_ENUM:
			return createIfcTimeSeriesDataTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TIME_SERIES_SCHEDULE_TYPE_ENUM:
			return createIfcTimeSeriesScheduleTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TRANSFORMER_TYPE_ENUM:
			return createIfcTransformerTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TRANSITION_CODE:
			return createIfcTransitionCodeFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TRANSPORT_ELEMENT_TYPE_ENUM:
			return createIfcTransportElementTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TRIMMING_PREFERENCE:
			return createIfcTrimmingPreferenceFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_TUBE_BUNDLE_TYPE_ENUM:
			return createIfcTubeBundleTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_UNIT_ENUM:
			return createIfcUnitEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_UNITARY_EQUIPMENT_TYPE_ENUM:
			return createIfcUnitaryEquipmentTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_VALVE_TYPE_ENUM:
			return createIfcValveTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_VIBRATION_ISOLATOR_TYPE_ENUM:
			return createIfcVibrationIsolatorTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_WALL_TYPE_ENUM:
			return createIfcWallTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_WASTE_TERMINAL_TYPE_ENUM:
			return createIfcWasteTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_WINDOW_PANEL_OPERATION_ENUM:
			return createIfcWindowPanelOperationEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_WINDOW_PANEL_POSITION_ENUM:
			return createIfcWindowPanelPositionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_WINDOW_STYLE_CONSTRUCTION_ENUM:
			return createIfcWindowStyleConstructionEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_WINDOW_STYLE_OPERATION_ENUM:
			return createIfcWindowStyleOperationEnumFromString(eDataType, initialValue);
		case Ifc2x3tc1Package.IFC_WORK_CONTROL_TYPE_ENUM:
			return createIfcWorkControlTypeEnumFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case Ifc2x3tc1Package.TRISTATE:
			return convertTristateToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ACTION_SOURCE_TYPE_ENUM:
			return convertIfcActionSourceTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ACTION_TYPE_ENUM:
			return convertIfcActionTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ACTUATOR_TYPE_ENUM:
			return convertIfcActuatorTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ADDRESS_TYPE_ENUM:
			return convertIfcAddressTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_AHEAD_OR_BEHIND:
			return convertIfcAheadOrBehindToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_AIR_TERMINAL_BOX_TYPE_ENUM:
			return convertIfcAirTerminalBoxTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_AIR_TERMINAL_TYPE_ENUM:
			return convertIfcAirTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_AIR_TO_AIR_HEAT_RECOVERY_TYPE_ENUM:
			return convertIfcAirToAirHeatRecoveryTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ALARM_TYPE_ENUM:
			return convertIfcAlarmTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ANALYSIS_MODEL_TYPE_ENUM:
			return convertIfcAnalysisModelTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ANALYSIS_THEORY_TYPE_ENUM:
			return convertIfcAnalysisTheoryTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ARITHMETIC_OPERATOR_ENUM:
			return convertIfcArithmeticOperatorEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ASSEMBLY_PLACE_ENUM:
			return convertIfcAssemblyPlaceEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_BSPLINE_CURVE_FORM:
			return convertIfcBSplineCurveFormToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_BEAM_TYPE_ENUM:
			return convertIfcBeamTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_BENCHMARK_ENUM:
			return convertIfcBenchmarkEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_BOILER_TYPE_ENUM:
			return convertIfcBoilerTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_BOOLEAN_OPERATOR:
			return convertIfcBooleanOperatorToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_PROXY_TYPE_ENUM:
			return convertIfcBuildingElementProxyTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CABLE_CARRIER_FITTING_TYPE_ENUM:
			return convertIfcCableCarrierFittingTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CABLE_CARRIER_SEGMENT_TYPE_ENUM:
			return convertIfcCableCarrierSegmentTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CABLE_SEGMENT_TYPE_ENUM:
			return convertIfcCableSegmentTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CHANGE_ACTION_ENUM:
			return convertIfcChangeActionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CHILLER_TYPE_ENUM:
			return convertIfcChillerTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_COIL_TYPE_ENUM:
			return convertIfcCoilTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_COLUMN_TYPE_ENUM:
			return convertIfcColumnTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_COMPRESSOR_TYPE_ENUM:
			return convertIfcCompressorTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CONDENSER_TYPE_ENUM:
			return convertIfcCondenserTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CONNECTION_TYPE_ENUM:
			return convertIfcConnectionTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CONSTRAINT_ENUM:
			return convertIfcConstraintEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CONTROLLER_TYPE_ENUM:
			return convertIfcControllerTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_COOLED_BEAM_TYPE_ENUM:
			return convertIfcCooledBeamTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_COOLING_TOWER_TYPE_ENUM:
			return convertIfcCoolingTowerTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_COST_SCHEDULE_TYPE_ENUM:
			return convertIfcCostScheduleTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_COVERING_TYPE_ENUM:
			return convertIfcCoveringTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CURRENCY_ENUM:
			return convertIfcCurrencyEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_CURTAIN_WALL_TYPE_ENUM:
			return convertIfcCurtainWallTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DAMPER_TYPE_ENUM:
			return convertIfcDamperTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DATA_ORIGIN_ENUM:
			return convertIfcDataOriginEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DERIVED_UNIT_ENUM:
			return convertIfcDerivedUnitEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DIMENSION_EXTENT_USAGE:
			return convertIfcDimensionExtentUsageToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DIRECTION_SENSE_ENUM:
			return convertIfcDirectionSenseEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT_TYPE_ENUM:
			return convertIfcDistributionChamberElementTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DOCUMENT_CONFIDENTIALITY_ENUM:
			return convertIfcDocumentConfidentialityEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DOCUMENT_STATUS_ENUM:
			return convertIfcDocumentStatusEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DOOR_PANEL_OPERATION_ENUM:
			return convertIfcDoorPanelOperationEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DOOR_PANEL_POSITION_ENUM:
			return convertIfcDoorPanelPositionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DOOR_STYLE_CONSTRUCTION_ENUM:
			return convertIfcDoorStyleConstructionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DOOR_STYLE_OPERATION_ENUM:
			return convertIfcDoorStyleOperationEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DUCT_FITTING_TYPE_ENUM:
			return convertIfcDuctFittingTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DUCT_SEGMENT_TYPE_ENUM:
			return convertIfcDuctSegmentTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_DUCT_SILENCER_TYPE_ENUM:
			return convertIfcDuctSilencerTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_APPLIANCE_TYPE_ENUM:
			return convertIfcElectricApplianceTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_CURRENT_ENUM:
			return convertIfcElectricCurrentEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_DISTRIBUTION_POINT_FUNCTION_ENUM:
			return convertIfcElectricDistributionPointFunctionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_FLOW_STORAGE_DEVICE_TYPE_ENUM:
			return convertIfcElectricFlowStorageDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_GENERATOR_TYPE_ENUM:
			return convertIfcElectricGeneratorTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_HEATER_TYPE_ENUM:
			return convertIfcElectricHeaterTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_MOTOR_TYPE_ENUM:
			return convertIfcElectricMotorTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELECTRIC_TIME_CONTROL_TYPE_ENUM:
			return convertIfcElectricTimeControlTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELEMENT_ASSEMBLY_TYPE_ENUM:
			return convertIfcElementAssemblyTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ELEMENT_COMPOSITION_ENUM:
			return convertIfcElementCompositionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ENERGY_SEQUENCE_ENUM:
			return convertIfcEnergySequenceEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ENVIRONMENTAL_IMPACT_CATEGORY_ENUM:
			return convertIfcEnvironmentalImpactCategoryEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_EVAPORATIVE_COOLER_TYPE_ENUM:
			return convertIfcEvaporativeCoolerTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_EVAPORATOR_TYPE_ENUM:
			return convertIfcEvaporatorTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_FAN_TYPE_ENUM:
			return convertIfcFanTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_FILTER_TYPE_ENUM:
			return convertIfcFilterTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_FIRE_SUPPRESSION_TERMINAL_TYPE_ENUM:
			return convertIfcFireSuppressionTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_FLOW_DIRECTION_ENUM:
			return convertIfcFlowDirectionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_FLOW_INSTRUMENT_TYPE_ENUM:
			return convertIfcFlowInstrumentTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_FLOW_METER_TYPE_ENUM:
			return convertIfcFlowMeterTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_FOOTING_TYPE_ENUM:
			return convertIfcFootingTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_GAS_TERMINAL_TYPE_ENUM:
			return convertIfcGasTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_GEOMETRIC_PROJECTION_ENUM:
			return convertIfcGeometricProjectionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_GLOBAL_OR_LOCAL_ENUM:
			return convertIfcGlobalOrLocalEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_HEAT_EXCHANGER_TYPE_ENUM:
			return convertIfcHeatExchangerTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_HUMIDIFIER_TYPE_ENUM:
			return convertIfcHumidifierTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_INTERNAL_OR_EXTERNAL_ENUM:
			return convertIfcInternalOrExternalEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_INVENTORY_TYPE_ENUM:
			return convertIfcInventoryTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_JUNCTION_BOX_TYPE_ENUM:
			return convertIfcJunctionBoxTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_LAMP_TYPE_ENUM:
			return convertIfcLampTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_LAYER_SET_DIRECTION_ENUM:
			return convertIfcLayerSetDirectionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_LIGHT_DISTRIBUTION_CURVE_ENUM:
			return convertIfcLightDistributionCurveEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_LIGHT_EMISSION_SOURCE_ENUM:
			return convertIfcLightEmissionSourceEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_LIGHT_FIXTURE_TYPE_ENUM:
			return convertIfcLightFixtureTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_LOAD_GROUP_TYPE_ENUM:
			return convertIfcLoadGroupTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_LOGICAL_OPERATOR_ENUM:
			return convertIfcLogicalOperatorEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_MEMBER_TYPE_ENUM:
			return convertIfcMemberTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_MOTOR_CONNECTION_TYPE_ENUM:
			return convertIfcMotorConnectionTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_NULL_STYLE_ENUM:
			return convertIfcNullStyleEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_OBJECT_TYPE_ENUM:
			return convertIfcObjectTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_OBJECTIVE_ENUM:
			return convertIfcObjectiveEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_OCCUPANT_TYPE_ENUM:
			return convertIfcOccupantTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_OUTLET_TYPE_ENUM:
			return convertIfcOutletTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PERMEABLE_COVERING_OPERATION_ENUM:
			return convertIfcPermeableCoveringOperationEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PHYSICAL_OR_VIRTUAL_ENUM:
			return convertIfcPhysicalOrVirtualEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PILE_CONSTRUCTION_ENUM:
			return convertIfcPileConstructionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PILE_TYPE_ENUM:
			return convertIfcPileTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PIPE_FITTING_TYPE_ENUM:
			return convertIfcPipeFittingTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PIPE_SEGMENT_TYPE_ENUM:
			return convertIfcPipeSegmentTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PLATE_TYPE_ENUM:
			return convertIfcPlateTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PROCEDURE_TYPE_ENUM:
			return convertIfcProcedureTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PROFILE_TYPE_ENUM:
			return convertIfcProfileTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PROJECT_ORDER_RECORD_TYPE_ENUM:
			return convertIfcProjectOrderRecordTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PROJECT_ORDER_TYPE_ENUM:
			return convertIfcProjectOrderTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PROJECTED_OR_TRUE_LENGTH_ENUM:
			return convertIfcProjectedOrTrueLengthEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PROPERTY_SOURCE_ENUM:
			return convertIfcPropertySourceEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PROTECTIVE_DEVICE_TYPE_ENUM:
			return convertIfcProtectiveDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_PUMP_TYPE_ENUM:
			return convertIfcPumpTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_RAILING_TYPE_ENUM:
			return convertIfcRailingTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_RAMP_FLIGHT_TYPE_ENUM:
			return convertIfcRampFlightTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_RAMP_TYPE_ENUM:
			return convertIfcRampTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_REFLECTANCE_METHOD_ENUM:
			return convertIfcReflectanceMethodEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_REINFORCING_BAR_ROLE_ENUM:
			return convertIfcReinforcingBarRoleEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_REINFORCING_BAR_SURFACE_ENUM:
			return convertIfcReinforcingBarSurfaceEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_RESOURCE_CONSUMPTION_ENUM:
			return convertIfcResourceConsumptionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_RIB_PLATE_DIRECTION_ENUM:
			return convertIfcRibPlateDirectionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ROLE_ENUM:
			return convertIfcRoleEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_ROOF_TYPE_ENUM:
			return convertIfcRoofTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SI_PREFIX:
			return convertIfcSIPrefixToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SI_UNIT_NAME:
			return convertIfcSIUnitNameToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SANITARY_TERMINAL_TYPE_ENUM:
			return convertIfcSanitaryTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SECTION_TYPE_ENUM:
			return convertIfcSectionTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SENSOR_TYPE_ENUM:
			return convertIfcSensorTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SEQUENCE_ENUM:
			return convertIfcSequenceEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SERVICE_LIFE_FACTOR_TYPE_ENUM:
			return convertIfcServiceLifeFactorTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SERVICE_LIFE_TYPE_ENUM:
			return convertIfcServiceLifeTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SLAB_TYPE_ENUM:
			return convertIfcSlabTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SOUND_SCALE_ENUM:
			return convertIfcSoundScaleEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SPACE_HEATER_TYPE_ENUM:
			return convertIfcSpaceHeaterTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SPACE_TYPE_ENUM:
			return convertIfcSpaceTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_STACK_TERMINAL_TYPE_ENUM:
			return convertIfcStackTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_STAIR_FLIGHT_TYPE_ENUM:
			return convertIfcStairFlightTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_STAIR_TYPE_ENUM:
			return convertIfcStairTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_STATE_ENUM:
			return convertIfcStateEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CURVE_TYPE_ENUM:
			return convertIfcStructuralCurveTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_STRUCTURAL_SURFACE_TYPE_ENUM:
			return convertIfcStructuralSurfaceTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SURFACE_SIDE:
			return convertIfcSurfaceSideToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SURFACE_TEXTURE_ENUM:
			return convertIfcSurfaceTextureEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_SWITCHING_DEVICE_TYPE_ENUM:
			return convertIfcSwitchingDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TANK_TYPE_ENUM:
			return convertIfcTankTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TENDON_TYPE_ENUM:
			return convertIfcTendonTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TEXT_PATH:
			return convertIfcTextPathToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_THERMAL_LOAD_SOURCE_ENUM:
			return convertIfcThermalLoadSourceEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_THERMAL_LOAD_TYPE_ENUM:
			return convertIfcThermalLoadTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TIME_SERIES_DATA_TYPE_ENUM:
			return convertIfcTimeSeriesDataTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TIME_SERIES_SCHEDULE_TYPE_ENUM:
			return convertIfcTimeSeriesScheduleTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TRANSFORMER_TYPE_ENUM:
			return convertIfcTransformerTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TRANSITION_CODE:
			return convertIfcTransitionCodeToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TRANSPORT_ELEMENT_TYPE_ENUM:
			return convertIfcTransportElementTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TRIMMING_PREFERENCE:
			return convertIfcTrimmingPreferenceToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_TUBE_BUNDLE_TYPE_ENUM:
			return convertIfcTubeBundleTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_UNIT_ENUM:
			return convertIfcUnitEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_UNITARY_EQUIPMENT_TYPE_ENUM:
			return convertIfcUnitaryEquipmentTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_VALVE_TYPE_ENUM:
			return convertIfcValveTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_VIBRATION_ISOLATOR_TYPE_ENUM:
			return convertIfcVibrationIsolatorTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_WALL_TYPE_ENUM:
			return convertIfcWallTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_WASTE_TERMINAL_TYPE_ENUM:
			return convertIfcWasteTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_WINDOW_PANEL_OPERATION_ENUM:
			return convertIfcWindowPanelOperationEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_WINDOW_PANEL_POSITION_ENUM:
			return convertIfcWindowPanelPositionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_WINDOW_STYLE_CONSTRUCTION_ENUM:
			return convertIfcWindowStyleConstructionEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_WINDOW_STYLE_OPERATION_ENUM:
			return convertIfcWindowStyleOperationEnumToString(eDataType, instanceValue);
		case Ifc2x3tc1Package.IFC_WORK_CONTROL_TYPE_ENUM:
			return convertIfcWorkControlTypeEnumToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifc2DCompositeCurve createIfc2DCompositeCurve() {
		Ifc2DCompositeCurveImpl ifc2DCompositeCurve = new Ifc2DCompositeCurveImpl();
		return ifc2DCompositeCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActionRequest createIfcActionRequest() {
		IfcActionRequestImpl ifcActionRequest = new IfcActionRequestImpl();
		return ifcActionRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActor createIfcActor() {
		IfcActorImpl ifcActor = new IfcActorImpl();
		return ifcActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorRole createIfcActorRole() {
		IfcActorRoleImpl ifcActorRole = new IfcActorRoleImpl();
		return ifcActorRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActuatorType createIfcActuatorType() {
		IfcActuatorTypeImpl ifcActuatorType = new IfcActuatorTypeImpl();
		return ifcActuatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAddress createIfcAddress() {
		IfcAddressImpl ifcAddress = new IfcAddressImpl();
		return ifcAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAirTerminalBoxType createIfcAirTerminalBoxType() {
		IfcAirTerminalBoxTypeImpl ifcAirTerminalBoxType = new IfcAirTerminalBoxTypeImpl();
		return ifcAirTerminalBoxType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAirTerminalType createIfcAirTerminalType() {
		IfcAirTerminalTypeImpl ifcAirTerminalType = new IfcAirTerminalTypeImpl();
		return ifcAirTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAirToAirHeatRecoveryType createIfcAirToAirHeatRecoveryType() {
		IfcAirToAirHeatRecoveryTypeImpl ifcAirToAirHeatRecoveryType = new IfcAirToAirHeatRecoveryTypeImpl();
		return ifcAirToAirHeatRecoveryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAlarmType createIfcAlarmType() {
		IfcAlarmTypeImpl ifcAlarmType = new IfcAlarmTypeImpl();
		return ifcAlarmType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAngularDimension createIfcAngularDimension() {
		IfcAngularDimensionImpl ifcAngularDimension = new IfcAngularDimensionImpl();
		return ifcAngularDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotation createIfcAnnotation() {
		IfcAnnotationImpl ifcAnnotation = new IfcAnnotationImpl();
		return ifcAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationCurveOccurrence createIfcAnnotationCurveOccurrence() {
		IfcAnnotationCurveOccurrenceImpl ifcAnnotationCurveOccurrence = new IfcAnnotationCurveOccurrenceImpl();
		return ifcAnnotationCurveOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationFillArea createIfcAnnotationFillArea() {
		IfcAnnotationFillAreaImpl ifcAnnotationFillArea = new IfcAnnotationFillAreaImpl();
		return ifcAnnotationFillArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationFillAreaOccurrence createIfcAnnotationFillAreaOccurrence() {
		IfcAnnotationFillAreaOccurrenceImpl ifcAnnotationFillAreaOccurrence = new IfcAnnotationFillAreaOccurrenceImpl();
		return ifcAnnotationFillAreaOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationOccurrence createIfcAnnotationOccurrence() {
		IfcAnnotationOccurrenceImpl ifcAnnotationOccurrence = new IfcAnnotationOccurrenceImpl();
		return ifcAnnotationOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationSurface createIfcAnnotationSurface() {
		IfcAnnotationSurfaceImpl ifcAnnotationSurface = new IfcAnnotationSurfaceImpl();
		return ifcAnnotationSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationSurfaceOccurrence createIfcAnnotationSurfaceOccurrence() {
		IfcAnnotationSurfaceOccurrenceImpl ifcAnnotationSurfaceOccurrence = new IfcAnnotationSurfaceOccurrenceImpl();
		return ifcAnnotationSurfaceOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationSymbolOccurrence createIfcAnnotationSymbolOccurrence() {
		IfcAnnotationSymbolOccurrenceImpl ifcAnnotationSymbolOccurrence = new IfcAnnotationSymbolOccurrenceImpl();
		return ifcAnnotationSymbolOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationTextOccurrence createIfcAnnotationTextOccurrence() {
		IfcAnnotationTextOccurrenceImpl ifcAnnotationTextOccurrence = new IfcAnnotationTextOccurrenceImpl();
		return ifcAnnotationTextOccurrence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApplication createIfcApplication() {
		IfcApplicationImpl ifcApplication = new IfcApplicationImpl();
		return ifcApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAppliedValue createIfcAppliedValue() {
		IfcAppliedValueImpl ifcAppliedValue = new IfcAppliedValueImpl();
		return ifcAppliedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAppliedValueRelationship createIfcAppliedValueRelationship() {
		IfcAppliedValueRelationshipImpl ifcAppliedValueRelationship = new IfcAppliedValueRelationshipImpl();
		return ifcAppliedValueRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApproval createIfcApproval() {
		IfcApprovalImpl ifcApproval = new IfcApprovalImpl();
		return ifcApproval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApprovalActorRelationship createIfcApprovalActorRelationship() {
		IfcApprovalActorRelationshipImpl ifcApprovalActorRelationship = new IfcApprovalActorRelationshipImpl();
		return ifcApprovalActorRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApprovalPropertyRelationship createIfcApprovalPropertyRelationship() {
		IfcApprovalPropertyRelationshipImpl ifcApprovalPropertyRelationship = new IfcApprovalPropertyRelationshipImpl();
		return ifcApprovalPropertyRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcApprovalRelationship createIfcApprovalRelationship() {
		IfcApprovalRelationshipImpl ifcApprovalRelationship = new IfcApprovalRelationshipImpl();
		return ifcApprovalRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcArbitraryClosedProfileDef createIfcArbitraryClosedProfileDef() {
		IfcArbitraryClosedProfileDefImpl ifcArbitraryClosedProfileDef = new IfcArbitraryClosedProfileDefImpl();
		return ifcArbitraryClosedProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcArbitraryOpenProfileDef createIfcArbitraryOpenProfileDef() {
		IfcArbitraryOpenProfileDefImpl ifcArbitraryOpenProfileDef = new IfcArbitraryOpenProfileDefImpl();
		return ifcArbitraryOpenProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcArbitraryProfileDefWithVoids createIfcArbitraryProfileDefWithVoids() {
		IfcArbitraryProfileDefWithVoidsImpl ifcArbitraryProfileDefWithVoids = new IfcArbitraryProfileDefWithVoidsImpl();
		return ifcArbitraryProfileDefWithVoids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAsset createIfcAsset() {
		IfcAssetImpl ifcAsset = new IfcAssetImpl();
		return ifcAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAsymmetricIShapeProfileDef createIfcAsymmetricIShapeProfileDef() {
		IfcAsymmetricIShapeProfileDefImpl ifcAsymmetricIShapeProfileDef = new IfcAsymmetricIShapeProfileDefImpl();
		return ifcAsymmetricIShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis1Placement createIfcAxis1Placement() {
		IfcAxis1PlacementImpl ifcAxis1Placement = new IfcAxis1PlacementImpl();
		return ifcAxis1Placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement2D createIfcAxis2Placement2D() {
		IfcAxis2Placement2DImpl ifcAxis2Placement2D = new IfcAxis2Placement2DImpl();
		return ifcAxis2Placement2D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D createIfcAxis2Placement3D() {
		IfcAxis2Placement3DImpl ifcAxis2Placement3D = new IfcAxis2Placement3DImpl();
		return ifcAxis2Placement3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBSplineCurve createIfcBSplineCurve() {
		IfcBSplineCurveImpl ifcBSplineCurve = new IfcBSplineCurveImpl();
		return ifcBSplineCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBeam createIfcBeam() {
		IfcBeamImpl ifcBeam = new IfcBeamImpl();
		return ifcBeam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBeamType createIfcBeamType() {
		IfcBeamTypeImpl ifcBeamType = new IfcBeamTypeImpl();
		return ifcBeamType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBezierCurve createIfcBezierCurve() {
		IfcBezierCurveImpl ifcBezierCurve = new IfcBezierCurveImpl();
		return ifcBezierCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBlobTexture createIfcBlobTexture() {
		IfcBlobTextureImpl ifcBlobTexture = new IfcBlobTextureImpl();
		return ifcBlobTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBlock createIfcBlock() {
		IfcBlockImpl ifcBlock = new IfcBlockImpl();
		return ifcBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoilerType createIfcBoilerType() {
		IfcBoilerTypeImpl ifcBoilerType = new IfcBoilerTypeImpl();
		return ifcBoilerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBooleanClippingResult createIfcBooleanClippingResult() {
		IfcBooleanClippingResultImpl ifcBooleanClippingResult = new IfcBooleanClippingResultImpl();
		return ifcBooleanClippingResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBooleanResult createIfcBooleanResult() {
		IfcBooleanResultImpl ifcBooleanResult = new IfcBooleanResultImpl();
		return ifcBooleanResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundaryCondition createIfcBoundaryCondition() {
		IfcBoundaryConditionImpl ifcBoundaryCondition = new IfcBoundaryConditionImpl();
		return ifcBoundaryCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundaryEdgeCondition createIfcBoundaryEdgeCondition() {
		IfcBoundaryEdgeConditionImpl ifcBoundaryEdgeCondition = new IfcBoundaryEdgeConditionImpl();
		return ifcBoundaryEdgeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundaryFaceCondition createIfcBoundaryFaceCondition() {
		IfcBoundaryFaceConditionImpl ifcBoundaryFaceCondition = new IfcBoundaryFaceConditionImpl();
		return ifcBoundaryFaceCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundaryNodeCondition createIfcBoundaryNodeCondition() {
		IfcBoundaryNodeConditionImpl ifcBoundaryNodeCondition = new IfcBoundaryNodeConditionImpl();
		return ifcBoundaryNodeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundaryNodeConditionWarping createIfcBoundaryNodeConditionWarping() {
		IfcBoundaryNodeConditionWarpingImpl ifcBoundaryNodeConditionWarping = new IfcBoundaryNodeConditionWarpingImpl();
		return ifcBoundaryNodeConditionWarping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundedCurve createIfcBoundedCurve() {
		IfcBoundedCurveImpl ifcBoundedCurve = new IfcBoundedCurveImpl();
		return ifcBoundedCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundedSurface createIfcBoundedSurface() {
		IfcBoundedSurfaceImpl ifcBoundedSurface = new IfcBoundedSurfaceImpl();
		return ifcBoundedSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoundingBox createIfcBoundingBox() {
		IfcBoundingBoxImpl ifcBoundingBox = new IfcBoundingBoxImpl();
		return ifcBoundingBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoxedHalfSpace createIfcBoxedHalfSpace() {
		IfcBoxedHalfSpaceImpl ifcBoxedHalfSpace = new IfcBoxedHalfSpaceImpl();
		return ifcBoxedHalfSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuilding createIfcBuilding() {
		IfcBuildingImpl ifcBuilding = new IfcBuildingImpl();
		return ifcBuilding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElement createIfcBuildingElement() {
		IfcBuildingElementImpl ifcBuildingElement = new IfcBuildingElementImpl();
		return ifcBuildingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElementComponent createIfcBuildingElementComponent() {
		IfcBuildingElementComponentImpl ifcBuildingElementComponent = new IfcBuildingElementComponentImpl();
		return ifcBuildingElementComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElementPart createIfcBuildingElementPart() {
		IfcBuildingElementPartImpl ifcBuildingElementPart = new IfcBuildingElementPartImpl();
		return ifcBuildingElementPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElementProxy createIfcBuildingElementProxy() {
		IfcBuildingElementProxyImpl ifcBuildingElementProxy = new IfcBuildingElementProxyImpl();
		return ifcBuildingElementProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElementProxyType createIfcBuildingElementProxyType() {
		IfcBuildingElementProxyTypeImpl ifcBuildingElementProxyType = new IfcBuildingElementProxyTypeImpl();
		return ifcBuildingElementProxyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElementType createIfcBuildingElementType() {
		IfcBuildingElementTypeImpl ifcBuildingElementType = new IfcBuildingElementTypeImpl();
		return ifcBuildingElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingStorey createIfcBuildingStorey() {
		IfcBuildingStoreyImpl ifcBuildingStorey = new IfcBuildingStoreyImpl();
		return ifcBuildingStorey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCShapeProfileDef createIfcCShapeProfileDef() {
		IfcCShapeProfileDefImpl ifcCShapeProfileDef = new IfcCShapeProfileDefImpl();
		return ifcCShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableCarrierFittingType createIfcCableCarrierFittingType() {
		IfcCableCarrierFittingTypeImpl ifcCableCarrierFittingType = new IfcCableCarrierFittingTypeImpl();
		return ifcCableCarrierFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableCarrierSegmentType createIfcCableCarrierSegmentType() {
		IfcCableCarrierSegmentTypeImpl ifcCableCarrierSegmentType = new IfcCableCarrierSegmentTypeImpl();
		return ifcCableCarrierSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableSegmentType createIfcCableSegmentType() {
		IfcCableSegmentTypeImpl ifcCableSegmentType = new IfcCableSegmentTypeImpl();
		return ifcCableSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCalendarDate createIfcCalendarDate() {
		IfcCalendarDateImpl ifcCalendarDate = new IfcCalendarDateImpl();
		return ifcCalendarDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint createIfcCartesianPoint() {
		IfcCartesianPointImpl ifcCartesianPoint = new IfcCartesianPointImpl();
		return ifcCartesianPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator createIfcCartesianTransformationOperator() {
		IfcCartesianTransformationOperatorImpl ifcCartesianTransformationOperator = new IfcCartesianTransformationOperatorImpl();
		return ifcCartesianTransformationOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator2D createIfcCartesianTransformationOperator2D() {
		IfcCartesianTransformationOperator2DImpl ifcCartesianTransformationOperator2D = new IfcCartesianTransformationOperator2DImpl();
		return ifcCartesianTransformationOperator2D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator2DnonUniform createIfcCartesianTransformationOperator2DnonUniform() {
		IfcCartesianTransformationOperator2DnonUniformImpl ifcCartesianTransformationOperator2DnonUniform = new IfcCartesianTransformationOperator2DnonUniformImpl();
		return ifcCartesianTransformationOperator2DnonUniform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator3D createIfcCartesianTransformationOperator3D() {
		IfcCartesianTransformationOperator3DImpl ifcCartesianTransformationOperator3D = new IfcCartesianTransformationOperator3DImpl();
		return ifcCartesianTransformationOperator3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianTransformationOperator3DnonUniform createIfcCartesianTransformationOperator3DnonUniform() {
		IfcCartesianTransformationOperator3DnonUniformImpl ifcCartesianTransformationOperator3DnonUniform = new IfcCartesianTransformationOperator3DnonUniformImpl();
		return ifcCartesianTransformationOperator3DnonUniform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCenterLineProfileDef createIfcCenterLineProfileDef() {
		IfcCenterLineProfileDefImpl ifcCenterLineProfileDef = new IfcCenterLineProfileDefImpl();
		return ifcCenterLineProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcChamferEdgeFeature createIfcChamferEdgeFeature() {
		IfcChamferEdgeFeatureImpl ifcChamferEdgeFeature = new IfcChamferEdgeFeatureImpl();
		return ifcChamferEdgeFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcChillerType createIfcChillerType() {
		IfcChillerTypeImpl ifcChillerType = new IfcChillerTypeImpl();
		return ifcChillerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCircle createIfcCircle() {
		IfcCircleImpl ifcCircle = new IfcCircleImpl();
		return ifcCircle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCircleHollowProfileDef createIfcCircleHollowProfileDef() {
		IfcCircleHollowProfileDefImpl ifcCircleHollowProfileDef = new IfcCircleHollowProfileDefImpl();
		return ifcCircleHollowProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCircleProfileDef createIfcCircleProfileDef() {
		IfcCircleProfileDefImpl ifcCircleProfileDef = new IfcCircleProfileDefImpl();
		return ifcCircleProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassification createIfcClassification() {
		IfcClassificationImpl ifcClassification = new IfcClassificationImpl();
		return ifcClassification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassificationItem createIfcClassificationItem() {
		IfcClassificationItemImpl ifcClassificationItem = new IfcClassificationItemImpl();
		return ifcClassificationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassificationItemRelationship createIfcClassificationItemRelationship() {
		IfcClassificationItemRelationshipImpl ifcClassificationItemRelationship = new IfcClassificationItemRelationshipImpl();
		return ifcClassificationItemRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassificationNotation createIfcClassificationNotation() {
		IfcClassificationNotationImpl ifcClassificationNotation = new IfcClassificationNotationImpl();
		return ifcClassificationNotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassificationNotationFacet createIfcClassificationNotationFacet() {
		IfcClassificationNotationFacetImpl ifcClassificationNotationFacet = new IfcClassificationNotationFacetImpl();
		return ifcClassificationNotationFacet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassificationReference createIfcClassificationReference() {
		IfcClassificationReferenceImpl ifcClassificationReference = new IfcClassificationReferenceImpl();
		return ifcClassificationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClosedShell createIfcClosedShell() {
		IfcClosedShellImpl ifcClosedShell = new IfcClosedShellImpl();
		return ifcClosedShell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCoilType createIfcCoilType() {
		IfcCoilTypeImpl ifcCoilType = new IfcCoilTypeImpl();
		return ifcCoilType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourRgb createIfcColourRgb() {
		IfcColourRgbImpl ifcColourRgb = new IfcColourRgbImpl();
		return ifcColourRgb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourSpecification createIfcColourSpecification() {
		IfcColourSpecificationImpl ifcColourSpecification = new IfcColourSpecificationImpl();
		return ifcColourSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColumn createIfcColumn() {
		IfcColumnImpl ifcColumn = new IfcColumnImpl();
		return ifcColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColumnType createIfcColumnType() {
		IfcColumnTypeImpl ifcColumnType = new IfcColumnTypeImpl();
		return ifcColumnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcComplexProperty createIfcComplexProperty() {
		IfcComplexPropertyImpl ifcComplexProperty = new IfcComplexPropertyImpl();
		return ifcComplexProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCompositeCurve createIfcCompositeCurve() {
		IfcCompositeCurveImpl ifcCompositeCurve = new IfcCompositeCurveImpl();
		return ifcCompositeCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCompositeCurveSegment createIfcCompositeCurveSegment() {
		IfcCompositeCurveSegmentImpl ifcCompositeCurveSegment = new IfcCompositeCurveSegmentImpl();
		return ifcCompositeCurveSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCompositeProfileDef createIfcCompositeProfileDef() {
		IfcCompositeProfileDefImpl ifcCompositeProfileDef = new IfcCompositeProfileDefImpl();
		return ifcCompositeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCompressorType createIfcCompressorType() {
		IfcCompressorTypeImpl ifcCompressorType = new IfcCompressorTypeImpl();
		return ifcCompressorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCondenserType createIfcCondenserType() {
		IfcCondenserTypeImpl ifcCondenserType = new IfcCondenserTypeImpl();
		return ifcCondenserType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCondition createIfcCondition() {
		IfcConditionImpl ifcCondition = new IfcConditionImpl();
		return ifcCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConditionCriterion createIfcConditionCriterion() {
		IfcConditionCriterionImpl ifcConditionCriterion = new IfcConditionCriterionImpl();
		return ifcConditionCriterion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConic createIfcConic() {
		IfcConicImpl ifcConic = new IfcConicImpl();
		return ifcConic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectedFaceSet createIfcConnectedFaceSet() {
		IfcConnectedFaceSetImpl ifcConnectedFaceSet = new IfcConnectedFaceSetImpl();
		return ifcConnectedFaceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionCurveGeometry createIfcConnectionCurveGeometry() {
		IfcConnectionCurveGeometryImpl ifcConnectionCurveGeometry = new IfcConnectionCurveGeometryImpl();
		return ifcConnectionCurveGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionGeometry createIfcConnectionGeometry() {
		IfcConnectionGeometryImpl ifcConnectionGeometry = new IfcConnectionGeometryImpl();
		return ifcConnectionGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionPointEccentricity createIfcConnectionPointEccentricity() {
		IfcConnectionPointEccentricityImpl ifcConnectionPointEccentricity = new IfcConnectionPointEccentricityImpl();
		return ifcConnectionPointEccentricity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionPointGeometry createIfcConnectionPointGeometry() {
		IfcConnectionPointGeometryImpl ifcConnectionPointGeometry = new IfcConnectionPointGeometryImpl();
		return ifcConnectionPointGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionPortGeometry createIfcConnectionPortGeometry() {
		IfcConnectionPortGeometryImpl ifcConnectionPortGeometry = new IfcConnectionPortGeometryImpl();
		return ifcConnectionPortGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionSurfaceGeometry createIfcConnectionSurfaceGeometry() {
		IfcConnectionSurfaceGeometryImpl ifcConnectionSurfaceGeometry = new IfcConnectionSurfaceGeometryImpl();
		return ifcConnectionSurfaceGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraint createIfcConstraint() {
		IfcConstraintImpl ifcConstraint = new IfcConstraintImpl();
		return ifcConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraintAggregationRelationship createIfcConstraintAggregationRelationship() {
		IfcConstraintAggregationRelationshipImpl ifcConstraintAggregationRelationship = new IfcConstraintAggregationRelationshipImpl();
		return ifcConstraintAggregationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraintClassificationRelationship createIfcConstraintClassificationRelationship() {
		IfcConstraintClassificationRelationshipImpl ifcConstraintClassificationRelationship = new IfcConstraintClassificationRelationshipImpl();
		return ifcConstraintClassificationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraintRelationship createIfcConstraintRelationship() {
		IfcConstraintRelationshipImpl ifcConstraintRelationship = new IfcConstraintRelationshipImpl();
		return ifcConstraintRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstructionEquipmentResource createIfcConstructionEquipmentResource() {
		IfcConstructionEquipmentResourceImpl ifcConstructionEquipmentResource = new IfcConstructionEquipmentResourceImpl();
		return ifcConstructionEquipmentResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstructionMaterialResource createIfcConstructionMaterialResource() {
		IfcConstructionMaterialResourceImpl ifcConstructionMaterialResource = new IfcConstructionMaterialResourceImpl();
		return ifcConstructionMaterialResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstructionProductResource createIfcConstructionProductResource() {
		IfcConstructionProductResourceImpl ifcConstructionProductResource = new IfcConstructionProductResourceImpl();
		return ifcConstructionProductResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstructionResource createIfcConstructionResource() {
		IfcConstructionResourceImpl ifcConstructionResource = new IfcConstructionResourceImpl();
		return ifcConstructionResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcContextDependentUnit createIfcContextDependentUnit() {
		IfcContextDependentUnitImpl ifcContextDependentUnit = new IfcContextDependentUnitImpl();
		return ifcContextDependentUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcControl createIfcControl() {
		IfcControlImpl ifcControl = new IfcControlImpl();
		return ifcControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcControllerType createIfcControllerType() {
		IfcControllerTypeImpl ifcControllerType = new IfcControllerTypeImpl();
		return ifcControllerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConversionBasedUnit createIfcConversionBasedUnit() {
		IfcConversionBasedUnitImpl ifcConversionBasedUnit = new IfcConversionBasedUnitImpl();
		return ifcConversionBasedUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCooledBeamType createIfcCooledBeamType() {
		IfcCooledBeamTypeImpl ifcCooledBeamType = new IfcCooledBeamTypeImpl();
		return ifcCooledBeamType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCoolingTowerType createIfcCoolingTowerType() {
		IfcCoolingTowerTypeImpl ifcCoolingTowerType = new IfcCoolingTowerTypeImpl();
		return ifcCoolingTowerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCoordinatedUniversalTimeOffset createIfcCoordinatedUniversalTimeOffset() {
		IfcCoordinatedUniversalTimeOffsetImpl ifcCoordinatedUniversalTimeOffset = new IfcCoordinatedUniversalTimeOffsetImpl();
		return ifcCoordinatedUniversalTimeOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostItem createIfcCostItem() {
		IfcCostItemImpl ifcCostItem = new IfcCostItemImpl();
		return ifcCostItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostSchedule createIfcCostSchedule() {
		IfcCostScheduleImpl ifcCostSchedule = new IfcCostScheduleImpl();
		return ifcCostSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostValue createIfcCostValue() {
		IfcCostValueImpl ifcCostValue = new IfcCostValueImpl();
		return ifcCostValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCovering createIfcCovering() {
		IfcCoveringImpl ifcCovering = new IfcCoveringImpl();
		return ifcCovering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCoveringType createIfcCoveringType() {
		IfcCoveringTypeImpl ifcCoveringType = new IfcCoveringTypeImpl();
		return ifcCoveringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCraneRailAShapeProfileDef createIfcCraneRailAShapeProfileDef() {
		IfcCraneRailAShapeProfileDefImpl ifcCraneRailAShapeProfileDef = new IfcCraneRailAShapeProfileDefImpl();
		return ifcCraneRailAShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCraneRailFShapeProfileDef createIfcCraneRailFShapeProfileDef() {
		IfcCraneRailFShapeProfileDefImpl ifcCraneRailFShapeProfileDef = new IfcCraneRailFShapeProfileDefImpl();
		return ifcCraneRailFShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCrewResource createIfcCrewResource() {
		IfcCrewResourceImpl ifcCrewResource = new IfcCrewResourceImpl();
		return ifcCrewResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCsgPrimitive3D createIfcCsgPrimitive3D() {
		IfcCsgPrimitive3DImpl ifcCsgPrimitive3D = new IfcCsgPrimitive3DImpl();
		return ifcCsgPrimitive3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCsgSolid createIfcCsgSolid() {
		IfcCsgSolidImpl ifcCsgSolid = new IfcCsgSolidImpl();
		return ifcCsgSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurrencyRelationship createIfcCurrencyRelationship() {
		IfcCurrencyRelationshipImpl ifcCurrencyRelationship = new IfcCurrencyRelationshipImpl();
		return ifcCurrencyRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurtainWall createIfcCurtainWall() {
		IfcCurtainWallImpl ifcCurtainWall = new IfcCurtainWallImpl();
		return ifcCurtainWall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurtainWallType createIfcCurtainWallType() {
		IfcCurtainWallTypeImpl ifcCurtainWallType = new IfcCurtainWallTypeImpl();
		return ifcCurtainWallType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve createIfcCurve() {
		IfcCurveImpl ifcCurve = new IfcCurveImpl();
		return ifcCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveBoundedPlane createIfcCurveBoundedPlane() {
		IfcCurveBoundedPlaneImpl ifcCurveBoundedPlane = new IfcCurveBoundedPlaneImpl();
		return ifcCurveBoundedPlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveStyle createIfcCurveStyle() {
		IfcCurveStyleImpl ifcCurveStyle = new IfcCurveStyleImpl();
		return ifcCurveStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveStyleFont createIfcCurveStyleFont() {
		IfcCurveStyleFontImpl ifcCurveStyleFont = new IfcCurveStyleFontImpl();
		return ifcCurveStyleFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveStyleFontAndScaling createIfcCurveStyleFontAndScaling() {
		IfcCurveStyleFontAndScalingImpl ifcCurveStyleFontAndScaling = new IfcCurveStyleFontAndScalingImpl();
		return ifcCurveStyleFontAndScaling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurveStyleFontPattern createIfcCurveStyleFontPattern() {
		IfcCurveStyleFontPatternImpl ifcCurveStyleFontPattern = new IfcCurveStyleFontPatternImpl();
		return ifcCurveStyleFontPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDamperType createIfcDamperType() {
		IfcDamperTypeImpl ifcDamperType = new IfcDamperTypeImpl();
		return ifcDamperType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateAndTime createIfcDateAndTime() {
		IfcDateAndTimeImpl ifcDateAndTime = new IfcDateAndTimeImpl();
		return ifcDateAndTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDefinedSymbol createIfcDefinedSymbol() {
		IfcDefinedSymbolImpl ifcDefinedSymbol = new IfcDefinedSymbolImpl();
		return ifcDefinedSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedProfileDef createIfcDerivedProfileDef() {
		IfcDerivedProfileDefImpl ifcDerivedProfileDef = new IfcDerivedProfileDefImpl();
		return ifcDerivedProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedUnit createIfcDerivedUnit() {
		IfcDerivedUnitImpl ifcDerivedUnit = new IfcDerivedUnitImpl();
		return ifcDerivedUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedUnitElement createIfcDerivedUnitElement() {
		IfcDerivedUnitElementImpl ifcDerivedUnitElement = new IfcDerivedUnitElementImpl();
		return ifcDerivedUnitElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDiameterDimension createIfcDiameterDimension() {
		IfcDiameterDimensionImpl ifcDiameterDimension = new IfcDiameterDimensionImpl();
		return ifcDiameterDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionCalloutRelationship createIfcDimensionCalloutRelationship() {
		IfcDimensionCalloutRelationshipImpl ifcDimensionCalloutRelationship = new IfcDimensionCalloutRelationshipImpl();
		return ifcDimensionCalloutRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionCurve createIfcDimensionCurve() {
		IfcDimensionCurveImpl ifcDimensionCurve = new IfcDimensionCurveImpl();
		return ifcDimensionCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionCurveDirectedCallout createIfcDimensionCurveDirectedCallout() {
		IfcDimensionCurveDirectedCalloutImpl ifcDimensionCurveDirectedCallout = new IfcDimensionCurveDirectedCalloutImpl();
		return ifcDimensionCurveDirectedCallout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionCurveTerminator createIfcDimensionCurveTerminator() {
		IfcDimensionCurveTerminatorImpl ifcDimensionCurveTerminator = new IfcDimensionCurveTerminatorImpl();
		return ifcDimensionCurveTerminator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionPair createIfcDimensionPair() {
		IfcDimensionPairImpl ifcDimensionPair = new IfcDimensionPairImpl();
		return ifcDimensionPair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionalExponents createIfcDimensionalExponents() {
		IfcDimensionalExponentsImpl ifcDimensionalExponents = new IfcDimensionalExponentsImpl();
		return ifcDimensionalExponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection createIfcDirection() {
		IfcDirectionImpl ifcDirection = new IfcDirectionImpl();
		return ifcDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDiscreteAccessory createIfcDiscreteAccessory() {
		IfcDiscreteAccessoryImpl ifcDiscreteAccessory = new IfcDiscreteAccessoryImpl();
		return ifcDiscreteAccessory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDiscreteAccessoryType createIfcDiscreteAccessoryType() {
		IfcDiscreteAccessoryTypeImpl ifcDiscreteAccessoryType = new IfcDiscreteAccessoryTypeImpl();
		return ifcDiscreteAccessoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionChamberElement createIfcDistributionChamberElement() {
		IfcDistributionChamberElementImpl ifcDistributionChamberElement = new IfcDistributionChamberElementImpl();
		return ifcDistributionChamberElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionChamberElementType createIfcDistributionChamberElementType() {
		IfcDistributionChamberElementTypeImpl ifcDistributionChamberElementType = new IfcDistributionChamberElementTypeImpl();
		return ifcDistributionChamberElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionControlElement createIfcDistributionControlElement() {
		IfcDistributionControlElementImpl ifcDistributionControlElement = new IfcDistributionControlElementImpl();
		return ifcDistributionControlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionControlElementType createIfcDistributionControlElementType() {
		IfcDistributionControlElementTypeImpl ifcDistributionControlElementType = new IfcDistributionControlElementTypeImpl();
		return ifcDistributionControlElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionElement createIfcDistributionElement() {
		IfcDistributionElementImpl ifcDistributionElement = new IfcDistributionElementImpl();
		return ifcDistributionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionElementType createIfcDistributionElementType() {
		IfcDistributionElementTypeImpl ifcDistributionElementType = new IfcDistributionElementTypeImpl();
		return ifcDistributionElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionFlowElement createIfcDistributionFlowElement() {
		IfcDistributionFlowElementImpl ifcDistributionFlowElement = new IfcDistributionFlowElementImpl();
		return ifcDistributionFlowElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionFlowElementType createIfcDistributionFlowElementType() {
		IfcDistributionFlowElementTypeImpl ifcDistributionFlowElementType = new IfcDistributionFlowElementTypeImpl();
		return ifcDistributionFlowElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionPort createIfcDistributionPort() {
		IfcDistributionPortImpl ifcDistributionPort = new IfcDistributionPortImpl();
		return ifcDistributionPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentElectronicFormat createIfcDocumentElectronicFormat() {
		IfcDocumentElectronicFormatImpl ifcDocumentElectronicFormat = new IfcDocumentElectronicFormatImpl();
		return ifcDocumentElectronicFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentInformation createIfcDocumentInformation() {
		IfcDocumentInformationImpl ifcDocumentInformation = new IfcDocumentInformationImpl();
		return ifcDocumentInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentInformationRelationship createIfcDocumentInformationRelationship() {
		IfcDocumentInformationRelationshipImpl ifcDocumentInformationRelationship = new IfcDocumentInformationRelationshipImpl();
		return ifcDocumentInformationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentReference createIfcDocumentReference() {
		IfcDocumentReferenceImpl ifcDocumentReference = new IfcDocumentReferenceImpl();
		return ifcDocumentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoor createIfcDoor() {
		IfcDoorImpl ifcDoor = new IfcDoorImpl();
		return ifcDoor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoorLiningProperties createIfcDoorLiningProperties() {
		IfcDoorLiningPropertiesImpl ifcDoorLiningProperties = new IfcDoorLiningPropertiesImpl();
		return ifcDoorLiningProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoorPanelProperties createIfcDoorPanelProperties() {
		IfcDoorPanelPropertiesImpl ifcDoorPanelProperties = new IfcDoorPanelPropertiesImpl();
		return ifcDoorPanelProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoorStyle createIfcDoorStyle() {
		IfcDoorStyleImpl ifcDoorStyle = new IfcDoorStyleImpl();
		return ifcDoorStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDraughtingCallout createIfcDraughtingCallout() {
		IfcDraughtingCalloutImpl ifcDraughtingCallout = new IfcDraughtingCalloutImpl();
		return ifcDraughtingCallout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDraughtingCalloutRelationship createIfcDraughtingCalloutRelationship() {
		IfcDraughtingCalloutRelationshipImpl ifcDraughtingCalloutRelationship = new IfcDraughtingCalloutRelationshipImpl();
		return ifcDraughtingCalloutRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDraughtingPreDefinedColour createIfcDraughtingPreDefinedColour() {
		IfcDraughtingPreDefinedColourImpl ifcDraughtingPreDefinedColour = new IfcDraughtingPreDefinedColourImpl();
		return ifcDraughtingPreDefinedColour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDraughtingPreDefinedCurveFont createIfcDraughtingPreDefinedCurveFont() {
		IfcDraughtingPreDefinedCurveFontImpl ifcDraughtingPreDefinedCurveFont = new IfcDraughtingPreDefinedCurveFontImpl();
		return ifcDraughtingPreDefinedCurveFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDraughtingPreDefinedTextFont createIfcDraughtingPreDefinedTextFont() {
		IfcDraughtingPreDefinedTextFontImpl ifcDraughtingPreDefinedTextFont = new IfcDraughtingPreDefinedTextFontImpl();
		return ifcDraughtingPreDefinedTextFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDuctFittingType createIfcDuctFittingType() {
		IfcDuctFittingTypeImpl ifcDuctFittingType = new IfcDuctFittingTypeImpl();
		return ifcDuctFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDuctSegmentType createIfcDuctSegmentType() {
		IfcDuctSegmentTypeImpl ifcDuctSegmentType = new IfcDuctSegmentTypeImpl();
		return ifcDuctSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDuctSilencerType createIfcDuctSilencerType() {
		IfcDuctSilencerTypeImpl ifcDuctSilencerType = new IfcDuctSilencerTypeImpl();
		return ifcDuctSilencerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEdge createIfcEdge() {
		IfcEdgeImpl ifcEdge = new IfcEdgeImpl();
		return ifcEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEdgeCurve createIfcEdgeCurve() {
		IfcEdgeCurveImpl ifcEdgeCurve = new IfcEdgeCurveImpl();
		return ifcEdgeCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEdgeFeature createIfcEdgeFeature() {
		IfcEdgeFeatureImpl ifcEdgeFeature = new IfcEdgeFeatureImpl();
		return ifcEdgeFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEdgeLoop createIfcEdgeLoop() {
		IfcEdgeLoopImpl ifcEdgeLoop = new IfcEdgeLoopImpl();
		return ifcEdgeLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricApplianceType createIfcElectricApplianceType() {
		IfcElectricApplianceTypeImpl ifcElectricApplianceType = new IfcElectricApplianceTypeImpl();
		return ifcElectricApplianceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricDistributionPoint createIfcElectricDistributionPoint() {
		IfcElectricDistributionPointImpl ifcElectricDistributionPoint = new IfcElectricDistributionPointImpl();
		return ifcElectricDistributionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricFlowStorageDeviceType createIfcElectricFlowStorageDeviceType() {
		IfcElectricFlowStorageDeviceTypeImpl ifcElectricFlowStorageDeviceType = new IfcElectricFlowStorageDeviceTypeImpl();
		return ifcElectricFlowStorageDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricGeneratorType createIfcElectricGeneratorType() {
		IfcElectricGeneratorTypeImpl ifcElectricGeneratorType = new IfcElectricGeneratorTypeImpl();
		return ifcElectricGeneratorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricHeaterType createIfcElectricHeaterType() {
		IfcElectricHeaterTypeImpl ifcElectricHeaterType = new IfcElectricHeaterTypeImpl();
		return ifcElectricHeaterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricMotorType createIfcElectricMotorType() {
		IfcElectricMotorTypeImpl ifcElectricMotorType = new IfcElectricMotorTypeImpl();
		return ifcElectricMotorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricTimeControlType createIfcElectricTimeControlType() {
		IfcElectricTimeControlTypeImpl ifcElectricTimeControlType = new IfcElectricTimeControlTypeImpl();
		return ifcElectricTimeControlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricalBaseProperties createIfcElectricalBaseProperties() {
		IfcElectricalBasePropertiesImpl ifcElectricalBaseProperties = new IfcElectricalBasePropertiesImpl();
		return ifcElectricalBaseProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricalCircuit createIfcElectricalCircuit() {
		IfcElectricalCircuitImpl ifcElectricalCircuit = new IfcElectricalCircuitImpl();
		return ifcElectricalCircuit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricalElement createIfcElectricalElement() {
		IfcElectricalElementImpl ifcElectricalElement = new IfcElectricalElementImpl();
		return ifcElectricalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement createIfcElement() {
		IfcElementImpl ifcElement = new IfcElementImpl();
		return ifcElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementAssembly createIfcElementAssembly() {
		IfcElementAssemblyImpl ifcElementAssembly = new IfcElementAssemblyImpl();
		return ifcElementAssembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementComponent createIfcElementComponent() {
		IfcElementComponentImpl ifcElementComponent = new IfcElementComponentImpl();
		return ifcElementComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementComponentType createIfcElementComponentType() {
		IfcElementComponentTypeImpl ifcElementComponentType = new IfcElementComponentTypeImpl();
		return ifcElementComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementQuantity createIfcElementQuantity() {
		IfcElementQuantityImpl ifcElementQuantity = new IfcElementQuantityImpl();
		return ifcElementQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementType createIfcElementType() {
		IfcElementTypeImpl ifcElementType = new IfcElementTypeImpl();
		return ifcElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementarySurface createIfcElementarySurface() {
		IfcElementarySurfaceImpl ifcElementarySurface = new IfcElementarySurfaceImpl();
		return ifcElementarySurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEllipse createIfcEllipse() {
		IfcEllipseImpl ifcEllipse = new IfcEllipseImpl();
		return ifcEllipse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEllipseProfileDef createIfcEllipseProfileDef() {
		IfcEllipseProfileDefImpl ifcEllipseProfileDef = new IfcEllipseProfileDefImpl();
		return ifcEllipseProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnergyConversionDevice createIfcEnergyConversionDevice() {
		IfcEnergyConversionDeviceImpl ifcEnergyConversionDevice = new IfcEnergyConversionDeviceImpl();
		return ifcEnergyConversionDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnergyConversionDeviceType createIfcEnergyConversionDeviceType() {
		IfcEnergyConversionDeviceTypeImpl ifcEnergyConversionDeviceType = new IfcEnergyConversionDeviceTypeImpl();
		return ifcEnergyConversionDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnergyProperties createIfcEnergyProperties() {
		IfcEnergyPropertiesImpl ifcEnergyProperties = new IfcEnergyPropertiesImpl();
		return ifcEnergyProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnvironmentalImpactValue createIfcEnvironmentalImpactValue() {
		IfcEnvironmentalImpactValueImpl ifcEnvironmentalImpactValue = new IfcEnvironmentalImpactValueImpl();
		return ifcEnvironmentalImpactValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEquipmentElement createIfcEquipmentElement() {
		IfcEquipmentElementImpl ifcEquipmentElement = new IfcEquipmentElementImpl();
		return ifcEquipmentElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEquipmentStandard createIfcEquipmentStandard() {
		IfcEquipmentStandardImpl ifcEquipmentStandard = new IfcEquipmentStandardImpl();
		return ifcEquipmentStandard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEvaporativeCoolerType createIfcEvaporativeCoolerType() {
		IfcEvaporativeCoolerTypeImpl ifcEvaporativeCoolerType = new IfcEvaporativeCoolerTypeImpl();
		return ifcEvaporativeCoolerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEvaporatorType createIfcEvaporatorType() {
		IfcEvaporatorTypeImpl ifcEvaporatorType = new IfcEvaporatorTypeImpl();
		return ifcEvaporatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcExtendedMaterialProperties createIfcExtendedMaterialProperties() {
		IfcExtendedMaterialPropertiesImpl ifcExtendedMaterialProperties = new IfcExtendedMaterialPropertiesImpl();
		return ifcExtendedMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcExternalReference createIfcExternalReference() {
		IfcExternalReferenceImpl ifcExternalReference = new IfcExternalReferenceImpl();
		return ifcExternalReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcExternallyDefinedHatchStyle createIfcExternallyDefinedHatchStyle() {
		IfcExternallyDefinedHatchStyleImpl ifcExternallyDefinedHatchStyle = new IfcExternallyDefinedHatchStyleImpl();
		return ifcExternallyDefinedHatchStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcExternallyDefinedSurfaceStyle createIfcExternallyDefinedSurfaceStyle() {
		IfcExternallyDefinedSurfaceStyleImpl ifcExternallyDefinedSurfaceStyle = new IfcExternallyDefinedSurfaceStyleImpl();
		return ifcExternallyDefinedSurfaceStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcExternallyDefinedSymbol createIfcExternallyDefinedSymbol() {
		IfcExternallyDefinedSymbolImpl ifcExternallyDefinedSymbol = new IfcExternallyDefinedSymbolImpl();
		return ifcExternallyDefinedSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcExternallyDefinedTextFont createIfcExternallyDefinedTextFont() {
		IfcExternallyDefinedTextFontImpl ifcExternallyDefinedTextFont = new IfcExternallyDefinedTextFontImpl();
		return ifcExternallyDefinedTextFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcExtrudedAreaSolid createIfcExtrudedAreaSolid() {
		IfcExtrudedAreaSolidImpl ifcExtrudedAreaSolid = new IfcExtrudedAreaSolidImpl();
		return ifcExtrudedAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFace createIfcFace() {
		IfcFaceImpl ifcFace = new IfcFaceImpl();
		return ifcFace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFaceBasedSurfaceModel createIfcFaceBasedSurfaceModel() {
		IfcFaceBasedSurfaceModelImpl ifcFaceBasedSurfaceModel = new IfcFaceBasedSurfaceModelImpl();
		return ifcFaceBasedSurfaceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFaceBound createIfcFaceBound() {
		IfcFaceBoundImpl ifcFaceBound = new IfcFaceBoundImpl();
		return ifcFaceBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFaceOuterBound createIfcFaceOuterBound() {
		IfcFaceOuterBoundImpl ifcFaceOuterBound = new IfcFaceOuterBoundImpl();
		return ifcFaceOuterBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFaceSurface createIfcFaceSurface() {
		IfcFaceSurfaceImpl ifcFaceSurface = new IfcFaceSurfaceImpl();
		return ifcFaceSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFacetedBrep createIfcFacetedBrep() {
		IfcFacetedBrepImpl ifcFacetedBrep = new IfcFacetedBrepImpl();
		return ifcFacetedBrep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFacetedBrepWithVoids createIfcFacetedBrepWithVoids() {
		IfcFacetedBrepWithVoidsImpl ifcFacetedBrepWithVoids = new IfcFacetedBrepWithVoidsImpl();
		return ifcFacetedBrepWithVoids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFailureConnectionCondition createIfcFailureConnectionCondition() {
		IfcFailureConnectionConditionImpl ifcFailureConnectionCondition = new IfcFailureConnectionConditionImpl();
		return ifcFailureConnectionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFanType createIfcFanType() {
		IfcFanTypeImpl ifcFanType = new IfcFanTypeImpl();
		return ifcFanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFastener createIfcFastener() {
		IfcFastenerImpl ifcFastener = new IfcFastenerImpl();
		return ifcFastener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFastenerType createIfcFastenerType() {
		IfcFastenerTypeImpl ifcFastenerType = new IfcFastenerTypeImpl();
		return ifcFastenerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFeatureElement createIfcFeatureElement() {
		IfcFeatureElementImpl ifcFeatureElement = new IfcFeatureElementImpl();
		return ifcFeatureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFeatureElementAddition createIfcFeatureElementAddition() {
		IfcFeatureElementAdditionImpl ifcFeatureElementAddition = new IfcFeatureElementAdditionImpl();
		return ifcFeatureElementAddition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFeatureElementSubtraction createIfcFeatureElementSubtraction() {
		IfcFeatureElementSubtractionImpl ifcFeatureElementSubtraction = new IfcFeatureElementSubtractionImpl();
		return ifcFeatureElementSubtraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFillAreaStyle createIfcFillAreaStyle() {
		IfcFillAreaStyleImpl ifcFillAreaStyle = new IfcFillAreaStyleImpl();
		return ifcFillAreaStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFillAreaStyleHatching createIfcFillAreaStyleHatching() {
		IfcFillAreaStyleHatchingImpl ifcFillAreaStyleHatching = new IfcFillAreaStyleHatchingImpl();
		return ifcFillAreaStyleHatching;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFillAreaStyleTileSymbolWithStyle createIfcFillAreaStyleTileSymbolWithStyle() {
		IfcFillAreaStyleTileSymbolWithStyleImpl ifcFillAreaStyleTileSymbolWithStyle = new IfcFillAreaStyleTileSymbolWithStyleImpl();
		return ifcFillAreaStyleTileSymbolWithStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFillAreaStyleTiles createIfcFillAreaStyleTiles() {
		IfcFillAreaStyleTilesImpl ifcFillAreaStyleTiles = new IfcFillAreaStyleTilesImpl();
		return ifcFillAreaStyleTiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFilterType createIfcFilterType() {
		IfcFilterTypeImpl ifcFilterType = new IfcFilterTypeImpl();
		return ifcFilterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFireSuppressionTerminalType createIfcFireSuppressionTerminalType() {
		IfcFireSuppressionTerminalTypeImpl ifcFireSuppressionTerminalType = new IfcFireSuppressionTerminalTypeImpl();
		return ifcFireSuppressionTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowController createIfcFlowController() {
		IfcFlowControllerImpl ifcFlowController = new IfcFlowControllerImpl();
		return ifcFlowController;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowControllerType createIfcFlowControllerType() {
		IfcFlowControllerTypeImpl ifcFlowControllerType = new IfcFlowControllerTypeImpl();
		return ifcFlowControllerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowFitting createIfcFlowFitting() {
		IfcFlowFittingImpl ifcFlowFitting = new IfcFlowFittingImpl();
		return ifcFlowFitting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowFittingType createIfcFlowFittingType() {
		IfcFlowFittingTypeImpl ifcFlowFittingType = new IfcFlowFittingTypeImpl();
		return ifcFlowFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowInstrumentType createIfcFlowInstrumentType() {
		IfcFlowInstrumentTypeImpl ifcFlowInstrumentType = new IfcFlowInstrumentTypeImpl();
		return ifcFlowInstrumentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowMeterType createIfcFlowMeterType() {
		IfcFlowMeterTypeImpl ifcFlowMeterType = new IfcFlowMeterTypeImpl();
		return ifcFlowMeterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowMovingDevice createIfcFlowMovingDevice() {
		IfcFlowMovingDeviceImpl ifcFlowMovingDevice = new IfcFlowMovingDeviceImpl();
		return ifcFlowMovingDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowMovingDeviceType createIfcFlowMovingDeviceType() {
		IfcFlowMovingDeviceTypeImpl ifcFlowMovingDeviceType = new IfcFlowMovingDeviceTypeImpl();
		return ifcFlowMovingDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowSegment createIfcFlowSegment() {
		IfcFlowSegmentImpl ifcFlowSegment = new IfcFlowSegmentImpl();
		return ifcFlowSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowSegmentType createIfcFlowSegmentType() {
		IfcFlowSegmentTypeImpl ifcFlowSegmentType = new IfcFlowSegmentTypeImpl();
		return ifcFlowSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowStorageDevice createIfcFlowStorageDevice() {
		IfcFlowStorageDeviceImpl ifcFlowStorageDevice = new IfcFlowStorageDeviceImpl();
		return ifcFlowStorageDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowStorageDeviceType createIfcFlowStorageDeviceType() {
		IfcFlowStorageDeviceTypeImpl ifcFlowStorageDeviceType = new IfcFlowStorageDeviceTypeImpl();
		return ifcFlowStorageDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowTerminal createIfcFlowTerminal() {
		IfcFlowTerminalImpl ifcFlowTerminal = new IfcFlowTerminalImpl();
		return ifcFlowTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowTerminalType createIfcFlowTerminalType() {
		IfcFlowTerminalTypeImpl ifcFlowTerminalType = new IfcFlowTerminalTypeImpl();
		return ifcFlowTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowTreatmentDevice createIfcFlowTreatmentDevice() {
		IfcFlowTreatmentDeviceImpl ifcFlowTreatmentDevice = new IfcFlowTreatmentDeviceImpl();
		return ifcFlowTreatmentDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowTreatmentDeviceType createIfcFlowTreatmentDeviceType() {
		IfcFlowTreatmentDeviceTypeImpl ifcFlowTreatmentDeviceType = new IfcFlowTreatmentDeviceTypeImpl();
		return ifcFlowTreatmentDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFluidFlowProperties createIfcFluidFlowProperties() {
		IfcFluidFlowPropertiesImpl ifcFluidFlowProperties = new IfcFluidFlowPropertiesImpl();
		return ifcFluidFlowProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFooting createIfcFooting() {
		IfcFootingImpl ifcFooting = new IfcFootingImpl();
		return ifcFooting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFuelProperties createIfcFuelProperties() {
		IfcFuelPropertiesImpl ifcFuelProperties = new IfcFuelPropertiesImpl();
		return ifcFuelProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFurnishingElement createIfcFurnishingElement() {
		IfcFurnishingElementImpl ifcFurnishingElement = new IfcFurnishingElementImpl();
		return ifcFurnishingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFurnishingElementType createIfcFurnishingElementType() {
		IfcFurnishingElementTypeImpl ifcFurnishingElementType = new IfcFurnishingElementTypeImpl();
		return ifcFurnishingElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFurnitureStandard createIfcFurnitureStandard() {
		IfcFurnitureStandardImpl ifcFurnitureStandard = new IfcFurnitureStandardImpl();
		return ifcFurnitureStandard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFurnitureType createIfcFurnitureType() {
		IfcFurnitureTypeImpl ifcFurnitureType = new IfcFurnitureTypeImpl();
		return ifcFurnitureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGasTerminalType createIfcGasTerminalType() {
		IfcGasTerminalTypeImpl ifcGasTerminalType = new IfcGasTerminalTypeImpl();
		return ifcGasTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeneralMaterialProperties createIfcGeneralMaterialProperties() {
		IfcGeneralMaterialPropertiesImpl ifcGeneralMaterialProperties = new IfcGeneralMaterialPropertiesImpl();
		return ifcGeneralMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeneralProfileProperties createIfcGeneralProfileProperties() {
		IfcGeneralProfilePropertiesImpl ifcGeneralProfileProperties = new IfcGeneralProfilePropertiesImpl();
		return ifcGeneralProfileProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricCurveSet createIfcGeometricCurveSet() {
		IfcGeometricCurveSetImpl ifcGeometricCurveSet = new IfcGeometricCurveSetImpl();
		return ifcGeometricCurveSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricRepresentationContext createIfcGeometricRepresentationContext() {
		IfcGeometricRepresentationContextImpl ifcGeometricRepresentationContext = new IfcGeometricRepresentationContextImpl();
		return ifcGeometricRepresentationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricRepresentationItem createIfcGeometricRepresentationItem() {
		IfcGeometricRepresentationItemImpl ifcGeometricRepresentationItem = new IfcGeometricRepresentationItemImpl();
		return ifcGeometricRepresentationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricRepresentationSubContext createIfcGeometricRepresentationSubContext() {
		IfcGeometricRepresentationSubContextImpl ifcGeometricRepresentationSubContext = new IfcGeometricRepresentationSubContextImpl();
		return ifcGeometricRepresentationSubContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricSet createIfcGeometricSet() {
		IfcGeometricSetImpl ifcGeometricSet = new IfcGeometricSetImpl();
		return ifcGeometricSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGrid createIfcGrid() {
		IfcGridImpl ifcGrid = new IfcGridImpl();
		return ifcGrid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGridAxis createIfcGridAxis() {
		IfcGridAxisImpl ifcGridAxis = new IfcGridAxisImpl();
		return ifcGridAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGridPlacement createIfcGridPlacement() {
		IfcGridPlacementImpl ifcGridPlacement = new IfcGridPlacementImpl();
		return ifcGridPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGroup createIfcGroup() {
		IfcGroupImpl ifcGroup = new IfcGroupImpl();
		return ifcGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHalfSpaceSolid createIfcHalfSpaceSolid() {
		IfcHalfSpaceSolidImpl ifcHalfSpaceSolid = new IfcHalfSpaceSolidImpl();
		return ifcHalfSpaceSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHeatExchangerType createIfcHeatExchangerType() {
		IfcHeatExchangerTypeImpl ifcHeatExchangerType = new IfcHeatExchangerTypeImpl();
		return ifcHeatExchangerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHumidifierType createIfcHumidifierType() {
		IfcHumidifierTypeImpl ifcHumidifierType = new IfcHumidifierTypeImpl();
		return ifcHumidifierType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHygroscopicMaterialProperties createIfcHygroscopicMaterialProperties() {
		IfcHygroscopicMaterialPropertiesImpl ifcHygroscopicMaterialProperties = new IfcHygroscopicMaterialPropertiesImpl();
		return ifcHygroscopicMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcIShapeProfileDef createIfcIShapeProfileDef() {
		IfcIShapeProfileDefImpl ifcIShapeProfileDef = new IfcIShapeProfileDefImpl();
		return ifcIShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcImageTexture createIfcImageTexture() {
		IfcImageTextureImpl ifcImageTexture = new IfcImageTextureImpl();
		return ifcImageTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInventory createIfcInventory() {
		IfcInventoryImpl ifcInventory = new IfcInventoryImpl();
		return ifcInventory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcIrregularTimeSeries createIfcIrregularTimeSeries() {
		IfcIrregularTimeSeriesImpl ifcIrregularTimeSeries = new IfcIrregularTimeSeriesImpl();
		return ifcIrregularTimeSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcIrregularTimeSeriesValue createIfcIrregularTimeSeriesValue() {
		IfcIrregularTimeSeriesValueImpl ifcIrregularTimeSeriesValue = new IfcIrregularTimeSeriesValueImpl();
		return ifcIrregularTimeSeriesValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcJunctionBoxType createIfcJunctionBoxType() {
		IfcJunctionBoxTypeImpl ifcJunctionBoxType = new IfcJunctionBoxTypeImpl();
		return ifcJunctionBoxType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLShapeProfileDef createIfcLShapeProfileDef() {
		IfcLShapeProfileDefImpl ifcLShapeProfileDef = new IfcLShapeProfileDefImpl();
		return ifcLShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLaborResource createIfcLaborResource() {
		IfcLaborResourceImpl ifcLaborResource = new IfcLaborResourceImpl();
		return ifcLaborResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLampType createIfcLampType() {
		IfcLampTypeImpl ifcLampType = new IfcLampTypeImpl();
		return ifcLampType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLibraryInformation createIfcLibraryInformation() {
		IfcLibraryInformationImpl ifcLibraryInformation = new IfcLibraryInformationImpl();
		return ifcLibraryInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLibraryReference createIfcLibraryReference() {
		IfcLibraryReferenceImpl ifcLibraryReference = new IfcLibraryReferenceImpl();
		return ifcLibraryReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightDistributionData createIfcLightDistributionData() {
		IfcLightDistributionDataImpl ifcLightDistributionData = new IfcLightDistributionDataImpl();
		return ifcLightDistributionData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightFixtureType createIfcLightFixtureType() {
		IfcLightFixtureTypeImpl ifcLightFixtureType = new IfcLightFixtureTypeImpl();
		return ifcLightFixtureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightIntensityDistribution createIfcLightIntensityDistribution() {
		IfcLightIntensityDistributionImpl ifcLightIntensityDistribution = new IfcLightIntensityDistributionImpl();
		return ifcLightIntensityDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightSource createIfcLightSource() {
		IfcLightSourceImpl ifcLightSource = new IfcLightSourceImpl();
		return ifcLightSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightSourceAmbient createIfcLightSourceAmbient() {
		IfcLightSourceAmbientImpl ifcLightSourceAmbient = new IfcLightSourceAmbientImpl();
		return ifcLightSourceAmbient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightSourceDirectional createIfcLightSourceDirectional() {
		IfcLightSourceDirectionalImpl ifcLightSourceDirectional = new IfcLightSourceDirectionalImpl();
		return ifcLightSourceDirectional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightSourceGoniometric createIfcLightSourceGoniometric() {
		IfcLightSourceGoniometricImpl ifcLightSourceGoniometric = new IfcLightSourceGoniometricImpl();
		return ifcLightSourceGoniometric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightSourcePositional createIfcLightSourcePositional() {
		IfcLightSourcePositionalImpl ifcLightSourcePositional = new IfcLightSourcePositionalImpl();
		return ifcLightSourcePositional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightSourceSpot createIfcLightSourceSpot() {
		IfcLightSourceSpotImpl ifcLightSourceSpot = new IfcLightSourceSpotImpl();
		return ifcLightSourceSpot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLine createIfcLine() {
		IfcLineImpl ifcLine = new IfcLineImpl();
		return ifcLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLinearDimension createIfcLinearDimension() {
		IfcLinearDimensionImpl ifcLinearDimension = new IfcLinearDimensionImpl();
		return ifcLinearDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLocalPlacement createIfcLocalPlacement() {
		IfcLocalPlacementImpl ifcLocalPlacement = new IfcLocalPlacementImpl();
		return ifcLocalPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLocalTime createIfcLocalTime() {
		IfcLocalTimeImpl ifcLocalTime = new IfcLocalTimeImpl();
		return ifcLocalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLoop createIfcLoop() {
		IfcLoopImpl ifcLoop = new IfcLoopImpl();
		return ifcLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcManifoldSolidBrep createIfcManifoldSolidBrep() {
		IfcManifoldSolidBrepImpl ifcManifoldSolidBrep = new IfcManifoldSolidBrepImpl();
		return ifcManifoldSolidBrep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMappedItem createIfcMappedItem() {
		IfcMappedItemImpl ifcMappedItem = new IfcMappedItemImpl();
		return ifcMappedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterial createIfcMaterial() {
		IfcMaterialImpl ifcMaterial = new IfcMaterialImpl();
		return ifcMaterial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialClassificationRelationship createIfcMaterialClassificationRelationship() {
		IfcMaterialClassificationRelationshipImpl ifcMaterialClassificationRelationship = new IfcMaterialClassificationRelationshipImpl();
		return ifcMaterialClassificationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialDefinitionRepresentation createIfcMaterialDefinitionRepresentation() {
		IfcMaterialDefinitionRepresentationImpl ifcMaterialDefinitionRepresentation = new IfcMaterialDefinitionRepresentationImpl();
		return ifcMaterialDefinitionRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialLayer createIfcMaterialLayer() {
		IfcMaterialLayerImpl ifcMaterialLayer = new IfcMaterialLayerImpl();
		return ifcMaterialLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialLayerSet createIfcMaterialLayerSet() {
		IfcMaterialLayerSetImpl ifcMaterialLayerSet = new IfcMaterialLayerSetImpl();
		return ifcMaterialLayerSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialLayerSetUsage createIfcMaterialLayerSetUsage() {
		IfcMaterialLayerSetUsageImpl ifcMaterialLayerSetUsage = new IfcMaterialLayerSetUsageImpl();
		return ifcMaterialLayerSetUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialList createIfcMaterialList() {
		IfcMaterialListImpl ifcMaterialList = new IfcMaterialListImpl();
		return ifcMaterialList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialProperties createIfcMaterialProperties() {
		IfcMaterialPropertiesImpl ifcMaterialProperties = new IfcMaterialPropertiesImpl();
		return ifcMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureWithUnit createIfcMeasureWithUnit() {
		IfcMeasureWithUnitImpl ifcMeasureWithUnit = new IfcMeasureWithUnitImpl();
		return ifcMeasureWithUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMechanicalConcreteMaterialProperties createIfcMechanicalConcreteMaterialProperties() {
		IfcMechanicalConcreteMaterialPropertiesImpl ifcMechanicalConcreteMaterialProperties = new IfcMechanicalConcreteMaterialPropertiesImpl();
		return ifcMechanicalConcreteMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMechanicalFastener createIfcMechanicalFastener() {
		IfcMechanicalFastenerImpl ifcMechanicalFastener = new IfcMechanicalFastenerImpl();
		return ifcMechanicalFastener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMechanicalFastenerType createIfcMechanicalFastenerType() {
		IfcMechanicalFastenerTypeImpl ifcMechanicalFastenerType = new IfcMechanicalFastenerTypeImpl();
		return ifcMechanicalFastenerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMechanicalMaterialProperties createIfcMechanicalMaterialProperties() {
		IfcMechanicalMaterialPropertiesImpl ifcMechanicalMaterialProperties = new IfcMechanicalMaterialPropertiesImpl();
		return ifcMechanicalMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMechanicalSteelMaterialProperties createIfcMechanicalSteelMaterialProperties() {
		IfcMechanicalSteelMaterialPropertiesImpl ifcMechanicalSteelMaterialProperties = new IfcMechanicalSteelMaterialPropertiesImpl();
		return ifcMechanicalSteelMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMember createIfcMember() {
		IfcMemberImpl ifcMember = new IfcMemberImpl();
		return ifcMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMemberType createIfcMemberType() {
		IfcMemberTypeImpl ifcMemberType = new IfcMemberTypeImpl();
		return ifcMemberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMetric createIfcMetric() {
		IfcMetricImpl ifcMetric = new IfcMetricImpl();
		return ifcMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMonetaryUnit createIfcMonetaryUnit() {
		IfcMonetaryUnitImpl ifcMonetaryUnit = new IfcMonetaryUnitImpl();
		return ifcMonetaryUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMotorConnectionType createIfcMotorConnectionType() {
		IfcMotorConnectionTypeImpl ifcMotorConnectionType = new IfcMotorConnectionTypeImpl();
		return ifcMotorConnectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMove createIfcMove() {
		IfcMoveImpl ifcMove = new IfcMoveImpl();
		return ifcMove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcNamedUnit createIfcNamedUnit() {
		IfcNamedUnitImpl ifcNamedUnit = new IfcNamedUnitImpl();
		return ifcNamedUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObject createIfcObject() {
		IfcObjectImpl ifcObject = new IfcObjectImpl();
		return ifcObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectDefinition createIfcObjectDefinition() {
		IfcObjectDefinitionImpl ifcObjectDefinition = new IfcObjectDefinitionImpl();
		return ifcObjectDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectPlacement createIfcObjectPlacement() {
		IfcObjectPlacementImpl ifcObjectPlacement = new IfcObjectPlacementImpl();
		return ifcObjectPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjective createIfcObjective() {
		IfcObjectiveImpl ifcObjective = new IfcObjectiveImpl();
		return ifcObjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOccupant createIfcOccupant() {
		IfcOccupantImpl ifcOccupant = new IfcOccupantImpl();
		return ifcOccupant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOffsetCurve2D createIfcOffsetCurve2D() {
		IfcOffsetCurve2DImpl ifcOffsetCurve2D = new IfcOffsetCurve2DImpl();
		return ifcOffsetCurve2D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOffsetCurve3D createIfcOffsetCurve3D() {
		IfcOffsetCurve3DImpl ifcOffsetCurve3D = new IfcOffsetCurve3DImpl();
		return ifcOffsetCurve3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOneDirectionRepeatFactor createIfcOneDirectionRepeatFactor() {
		IfcOneDirectionRepeatFactorImpl ifcOneDirectionRepeatFactor = new IfcOneDirectionRepeatFactorImpl();
		return ifcOneDirectionRepeatFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOpenShell createIfcOpenShell() {
		IfcOpenShellImpl ifcOpenShell = new IfcOpenShellImpl();
		return ifcOpenShell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOpeningElement createIfcOpeningElement() {
		IfcOpeningElementImpl ifcOpeningElement = new IfcOpeningElementImpl();
		return ifcOpeningElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOpticalMaterialProperties createIfcOpticalMaterialProperties() {
		IfcOpticalMaterialPropertiesImpl ifcOpticalMaterialProperties = new IfcOpticalMaterialPropertiesImpl();
		return ifcOpticalMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOrderAction createIfcOrderAction() {
		IfcOrderActionImpl ifcOrderAction = new IfcOrderActionImpl();
		return ifcOrderAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOrganization createIfcOrganization() {
		IfcOrganizationImpl ifcOrganization = new IfcOrganizationImpl();
		return ifcOrganization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOrganizationRelationship createIfcOrganizationRelationship() {
		IfcOrganizationRelationshipImpl ifcOrganizationRelationship = new IfcOrganizationRelationshipImpl();
		return ifcOrganizationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOrientedEdge createIfcOrientedEdge() {
		IfcOrientedEdgeImpl ifcOrientedEdge = new IfcOrientedEdgeImpl();
		return ifcOrientedEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOutletType createIfcOutletType() {
		IfcOutletTypeImpl ifcOutletType = new IfcOutletTypeImpl();
		return ifcOutletType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOwnerHistory createIfcOwnerHistory() {
		IfcOwnerHistoryImpl ifcOwnerHistory = new IfcOwnerHistoryImpl();
		return ifcOwnerHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcParameterizedProfileDef createIfcParameterizedProfileDef() {
		IfcParameterizedProfileDefImpl ifcParameterizedProfileDef = new IfcParameterizedProfileDefImpl();
		return ifcParameterizedProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPath createIfcPath() {
		IfcPathImpl ifcPath = new IfcPathImpl();
		return ifcPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPerformanceHistory createIfcPerformanceHistory() {
		IfcPerformanceHistoryImpl ifcPerformanceHistory = new IfcPerformanceHistoryImpl();
		return ifcPerformanceHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPermeableCoveringProperties createIfcPermeableCoveringProperties() {
		IfcPermeableCoveringPropertiesImpl ifcPermeableCoveringProperties = new IfcPermeableCoveringPropertiesImpl();
		return ifcPermeableCoveringProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPermit createIfcPermit() {
		IfcPermitImpl ifcPermit = new IfcPermitImpl();
		return ifcPermit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPerson createIfcPerson() {
		IfcPersonImpl ifcPerson = new IfcPersonImpl();
		return ifcPerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPersonAndOrganization createIfcPersonAndOrganization() {
		IfcPersonAndOrganizationImpl ifcPersonAndOrganization = new IfcPersonAndOrganizationImpl();
		return ifcPersonAndOrganization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPhysicalComplexQuantity createIfcPhysicalComplexQuantity() {
		IfcPhysicalComplexQuantityImpl ifcPhysicalComplexQuantity = new IfcPhysicalComplexQuantityImpl();
		return ifcPhysicalComplexQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPhysicalQuantity createIfcPhysicalQuantity() {
		IfcPhysicalQuantityImpl ifcPhysicalQuantity = new IfcPhysicalQuantityImpl();
		return ifcPhysicalQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPhysicalSimpleQuantity createIfcPhysicalSimpleQuantity() {
		IfcPhysicalSimpleQuantityImpl ifcPhysicalSimpleQuantity = new IfcPhysicalSimpleQuantityImpl();
		return ifcPhysicalSimpleQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPile createIfcPile() {
		IfcPileImpl ifcPile = new IfcPileImpl();
		return ifcPile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPipeFittingType createIfcPipeFittingType() {
		IfcPipeFittingTypeImpl ifcPipeFittingType = new IfcPipeFittingTypeImpl();
		return ifcPipeFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPipeSegmentType createIfcPipeSegmentType() {
		IfcPipeSegmentTypeImpl ifcPipeSegmentType = new IfcPipeSegmentTypeImpl();
		return ifcPipeSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPixelTexture createIfcPixelTexture() {
		IfcPixelTextureImpl ifcPixelTexture = new IfcPixelTextureImpl();
		return ifcPixelTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlacement createIfcPlacement() {
		IfcPlacementImpl ifcPlacement = new IfcPlacementImpl();
		return ifcPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlanarBox createIfcPlanarBox() {
		IfcPlanarBoxImpl ifcPlanarBox = new IfcPlanarBoxImpl();
		return ifcPlanarBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlanarExtent createIfcPlanarExtent() {
		IfcPlanarExtentImpl ifcPlanarExtent = new IfcPlanarExtentImpl();
		return ifcPlanarExtent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlane createIfcPlane() {
		IfcPlaneImpl ifcPlane = new IfcPlaneImpl();
		return ifcPlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlate createIfcPlate() {
		IfcPlateImpl ifcPlate = new IfcPlateImpl();
		return ifcPlate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlateType createIfcPlateType() {
		IfcPlateTypeImpl ifcPlateType = new IfcPlateTypeImpl();
		return ifcPlateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPoint createIfcPoint() {
		IfcPointImpl ifcPoint = new IfcPointImpl();
		return ifcPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPointOnCurve createIfcPointOnCurve() {
		IfcPointOnCurveImpl ifcPointOnCurve = new IfcPointOnCurveImpl();
		return ifcPointOnCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPointOnSurface createIfcPointOnSurface() {
		IfcPointOnSurfaceImpl ifcPointOnSurface = new IfcPointOnSurfaceImpl();
		return ifcPointOnSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPolyLoop createIfcPolyLoop() {
		IfcPolyLoopImpl ifcPolyLoop = new IfcPolyLoopImpl();
		return ifcPolyLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPolygonalBoundedHalfSpace createIfcPolygonalBoundedHalfSpace() {
		IfcPolygonalBoundedHalfSpaceImpl ifcPolygonalBoundedHalfSpace = new IfcPolygonalBoundedHalfSpaceImpl();
		return ifcPolygonalBoundedHalfSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPolyline createIfcPolyline() {
		IfcPolylineImpl ifcPolyline = new IfcPolylineImpl();
		return ifcPolyline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPort createIfcPort() {
		IfcPortImpl ifcPort = new IfcPortImpl();
		return ifcPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPostalAddress createIfcPostalAddress() {
		IfcPostalAddressImpl ifcPostalAddress = new IfcPostalAddressImpl();
		return ifcPostalAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPreDefinedColour createIfcPreDefinedColour() {
		IfcPreDefinedColourImpl ifcPreDefinedColour = new IfcPreDefinedColourImpl();
		return ifcPreDefinedColour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPreDefinedCurveFont createIfcPreDefinedCurveFont() {
		IfcPreDefinedCurveFontImpl ifcPreDefinedCurveFont = new IfcPreDefinedCurveFontImpl();
		return ifcPreDefinedCurveFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPreDefinedDimensionSymbol createIfcPreDefinedDimensionSymbol() {
		IfcPreDefinedDimensionSymbolImpl ifcPreDefinedDimensionSymbol = new IfcPreDefinedDimensionSymbolImpl();
		return ifcPreDefinedDimensionSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPreDefinedItem createIfcPreDefinedItem() {
		IfcPreDefinedItemImpl ifcPreDefinedItem = new IfcPreDefinedItemImpl();
		return ifcPreDefinedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPreDefinedPointMarkerSymbol createIfcPreDefinedPointMarkerSymbol() {
		IfcPreDefinedPointMarkerSymbolImpl ifcPreDefinedPointMarkerSymbol = new IfcPreDefinedPointMarkerSymbolImpl();
		return ifcPreDefinedPointMarkerSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPreDefinedSymbol createIfcPreDefinedSymbol() {
		IfcPreDefinedSymbolImpl ifcPreDefinedSymbol = new IfcPreDefinedSymbolImpl();
		return ifcPreDefinedSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPreDefinedTerminatorSymbol createIfcPreDefinedTerminatorSymbol() {
		IfcPreDefinedTerminatorSymbolImpl ifcPreDefinedTerminatorSymbol = new IfcPreDefinedTerminatorSymbolImpl();
		return ifcPreDefinedTerminatorSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPreDefinedTextFont createIfcPreDefinedTextFont() {
		IfcPreDefinedTextFontImpl ifcPreDefinedTextFont = new IfcPreDefinedTextFontImpl();
		return ifcPreDefinedTextFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPresentationLayerAssignment createIfcPresentationLayerAssignment() {
		IfcPresentationLayerAssignmentImpl ifcPresentationLayerAssignment = new IfcPresentationLayerAssignmentImpl();
		return ifcPresentationLayerAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPresentationLayerWithStyle createIfcPresentationLayerWithStyle() {
		IfcPresentationLayerWithStyleImpl ifcPresentationLayerWithStyle = new IfcPresentationLayerWithStyleImpl();
		return ifcPresentationLayerWithStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPresentationStyle createIfcPresentationStyle() {
		IfcPresentationStyleImpl ifcPresentationStyle = new IfcPresentationStyleImpl();
		return ifcPresentationStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPresentationStyleAssignment createIfcPresentationStyleAssignment() {
		IfcPresentationStyleAssignmentImpl ifcPresentationStyleAssignment = new IfcPresentationStyleAssignmentImpl();
		return ifcPresentationStyleAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcedure createIfcProcedure() {
		IfcProcedureImpl ifcProcedure = new IfcProcedureImpl();
		return ifcProcedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcess createIfcProcess() {
		IfcProcessImpl ifcProcess = new IfcProcessImpl();
		return ifcProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProduct createIfcProduct() {
		IfcProductImpl ifcProduct = new IfcProductImpl();
		return ifcProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProductDefinitionShape createIfcProductDefinitionShape() {
		IfcProductDefinitionShapeImpl ifcProductDefinitionShape = new IfcProductDefinitionShapeImpl();
		return ifcProductDefinitionShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProductRepresentation createIfcProductRepresentation() {
		IfcProductRepresentationImpl ifcProductRepresentation = new IfcProductRepresentationImpl();
		return ifcProductRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProductsOfCombustionProperties createIfcProductsOfCombustionProperties() {
		IfcProductsOfCombustionPropertiesImpl ifcProductsOfCombustionProperties = new IfcProductsOfCombustionPropertiesImpl();
		return ifcProductsOfCombustionProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileDef createIfcProfileDef() {
		IfcProfileDefImpl ifcProfileDef = new IfcProfileDefImpl();
		return ifcProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileProperties createIfcProfileProperties() {
		IfcProfilePropertiesImpl ifcProfileProperties = new IfcProfilePropertiesImpl();
		return ifcProfileProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProject createIfcProject() {
		IfcProjectImpl ifcProject = new IfcProjectImpl();
		return ifcProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectOrder createIfcProjectOrder() {
		IfcProjectOrderImpl ifcProjectOrder = new IfcProjectOrderImpl();
		return ifcProjectOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectOrderRecord createIfcProjectOrderRecord() {
		IfcProjectOrderRecordImpl ifcProjectOrderRecord = new IfcProjectOrderRecordImpl();
		return ifcProjectOrderRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectionCurve createIfcProjectionCurve() {
		IfcProjectionCurveImpl ifcProjectionCurve = new IfcProjectionCurveImpl();
		return ifcProjectionCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectionElement createIfcProjectionElement() {
		IfcProjectionElementImpl ifcProjectionElement = new IfcProjectionElementImpl();
		return ifcProjectionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProperty createIfcProperty() {
		IfcPropertyImpl ifcProperty = new IfcPropertyImpl();
		return ifcProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyBoundedValue createIfcPropertyBoundedValue() {
		IfcPropertyBoundedValueImpl ifcPropertyBoundedValue = new IfcPropertyBoundedValueImpl();
		return ifcPropertyBoundedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyConstraintRelationship createIfcPropertyConstraintRelationship() {
		IfcPropertyConstraintRelationshipImpl ifcPropertyConstraintRelationship = new IfcPropertyConstraintRelationshipImpl();
		return ifcPropertyConstraintRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyDefinition createIfcPropertyDefinition() {
		IfcPropertyDefinitionImpl ifcPropertyDefinition = new IfcPropertyDefinitionImpl();
		return ifcPropertyDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyDependencyRelationship createIfcPropertyDependencyRelationship() {
		IfcPropertyDependencyRelationshipImpl ifcPropertyDependencyRelationship = new IfcPropertyDependencyRelationshipImpl();
		return ifcPropertyDependencyRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyEnumeratedValue createIfcPropertyEnumeratedValue() {
		IfcPropertyEnumeratedValueImpl ifcPropertyEnumeratedValue = new IfcPropertyEnumeratedValueImpl();
		return ifcPropertyEnumeratedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyEnumeration createIfcPropertyEnumeration() {
		IfcPropertyEnumerationImpl ifcPropertyEnumeration = new IfcPropertyEnumerationImpl();
		return ifcPropertyEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyListValue createIfcPropertyListValue() {
		IfcPropertyListValueImpl ifcPropertyListValue = new IfcPropertyListValueImpl();
		return ifcPropertyListValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyReferenceValue createIfcPropertyReferenceValue() {
		IfcPropertyReferenceValueImpl ifcPropertyReferenceValue = new IfcPropertyReferenceValueImpl();
		return ifcPropertyReferenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertySet createIfcPropertySet() {
		IfcPropertySetImpl ifcPropertySet = new IfcPropertySetImpl();
		return ifcPropertySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertySetDefinition createIfcPropertySetDefinition() {
		IfcPropertySetDefinitionImpl ifcPropertySetDefinition = new IfcPropertySetDefinitionImpl();
		return ifcPropertySetDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertySingleValue createIfcPropertySingleValue() {
		IfcPropertySingleValueImpl ifcPropertySingleValue = new IfcPropertySingleValueImpl();
		return ifcPropertySingleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertyTableValue createIfcPropertyTableValue() {
		IfcPropertyTableValueImpl ifcPropertyTableValue = new IfcPropertyTableValueImpl();
		return ifcPropertyTableValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProtectiveDeviceType createIfcProtectiveDeviceType() {
		IfcProtectiveDeviceTypeImpl ifcProtectiveDeviceType = new IfcProtectiveDeviceTypeImpl();
		return ifcProtectiveDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProxy createIfcProxy() {
		IfcProxyImpl ifcProxy = new IfcProxyImpl();
		return ifcProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPumpType createIfcPumpType() {
		IfcPumpTypeImpl ifcPumpType = new IfcPumpTypeImpl();
		return ifcPumpType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcQuantityArea createIfcQuantityArea() {
		IfcQuantityAreaImpl ifcQuantityArea = new IfcQuantityAreaImpl();
		return ifcQuantityArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcQuantityCount createIfcQuantityCount() {
		IfcQuantityCountImpl ifcQuantityCount = new IfcQuantityCountImpl();
		return ifcQuantityCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcQuantityLength createIfcQuantityLength() {
		IfcQuantityLengthImpl ifcQuantityLength = new IfcQuantityLengthImpl();
		return ifcQuantityLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcQuantityTime createIfcQuantityTime() {
		IfcQuantityTimeImpl ifcQuantityTime = new IfcQuantityTimeImpl();
		return ifcQuantityTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcQuantityVolume createIfcQuantityVolume() {
		IfcQuantityVolumeImpl ifcQuantityVolume = new IfcQuantityVolumeImpl();
		return ifcQuantityVolume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcQuantityWeight createIfcQuantityWeight() {
		IfcQuantityWeightImpl ifcQuantityWeight = new IfcQuantityWeightImpl();
		return ifcQuantityWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRadiusDimension createIfcRadiusDimension() {
		IfcRadiusDimensionImpl ifcRadiusDimension = new IfcRadiusDimensionImpl();
		return ifcRadiusDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRailing createIfcRailing() {
		IfcRailingImpl ifcRailing = new IfcRailingImpl();
		return ifcRailing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRailingType createIfcRailingType() {
		IfcRailingTypeImpl ifcRailingType = new IfcRailingTypeImpl();
		return ifcRailingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRamp createIfcRamp() {
		IfcRampImpl ifcRamp = new IfcRampImpl();
		return ifcRamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRampFlight createIfcRampFlight() {
		IfcRampFlightImpl ifcRampFlight = new IfcRampFlightImpl();
		return ifcRampFlight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRampFlightType createIfcRampFlightType() {
		IfcRampFlightTypeImpl ifcRampFlightType = new IfcRampFlightTypeImpl();
		return ifcRampFlightType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRationalBezierCurve createIfcRationalBezierCurve() {
		IfcRationalBezierCurveImpl ifcRationalBezierCurve = new IfcRationalBezierCurveImpl();
		return ifcRationalBezierCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRectangleHollowProfileDef createIfcRectangleHollowProfileDef() {
		IfcRectangleHollowProfileDefImpl ifcRectangleHollowProfileDef = new IfcRectangleHollowProfileDefImpl();
		return ifcRectangleHollowProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRectangleProfileDef createIfcRectangleProfileDef() {
		IfcRectangleProfileDefImpl ifcRectangleProfileDef = new IfcRectangleProfileDefImpl();
		return ifcRectangleProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRectangularPyramid createIfcRectangularPyramid() {
		IfcRectangularPyramidImpl ifcRectangularPyramid = new IfcRectangularPyramidImpl();
		return ifcRectangularPyramid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRectangularTrimmedSurface createIfcRectangularTrimmedSurface() {
		IfcRectangularTrimmedSurfaceImpl ifcRectangularTrimmedSurface = new IfcRectangularTrimmedSurfaceImpl();
		return ifcRectangularTrimmedSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReferencesValueDocument createIfcReferencesValueDocument() {
		IfcReferencesValueDocumentImpl ifcReferencesValueDocument = new IfcReferencesValueDocumentImpl();
		return ifcReferencesValueDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRegularTimeSeries createIfcRegularTimeSeries() {
		IfcRegularTimeSeriesImpl ifcRegularTimeSeries = new IfcRegularTimeSeriesImpl();
		return ifcRegularTimeSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcementBarProperties createIfcReinforcementBarProperties() {
		IfcReinforcementBarPropertiesImpl ifcReinforcementBarProperties = new IfcReinforcementBarPropertiesImpl();
		return ifcReinforcementBarProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcementDefinitionProperties createIfcReinforcementDefinitionProperties() {
		IfcReinforcementDefinitionPropertiesImpl ifcReinforcementDefinitionProperties = new IfcReinforcementDefinitionPropertiesImpl();
		return ifcReinforcementDefinitionProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingBar createIfcReinforcingBar() {
		IfcReinforcingBarImpl ifcReinforcingBar = new IfcReinforcingBarImpl();
		return ifcReinforcingBar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingElement createIfcReinforcingElement() {
		IfcReinforcingElementImpl ifcReinforcingElement = new IfcReinforcingElementImpl();
		return ifcReinforcingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingMesh createIfcReinforcingMesh() {
		IfcReinforcingMeshImpl ifcReinforcingMesh = new IfcReinforcingMeshImpl();
		return ifcReinforcingMesh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAggregates createIfcRelAggregates() {
		IfcRelAggregatesImpl ifcRelAggregates = new IfcRelAggregatesImpl();
		return ifcRelAggregates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssigns createIfcRelAssigns() {
		IfcRelAssignsImpl ifcRelAssigns = new IfcRelAssignsImpl();
		return ifcRelAssigns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsTasks createIfcRelAssignsTasks() {
		IfcRelAssignsTasksImpl ifcRelAssignsTasks = new IfcRelAssignsTasksImpl();
		return ifcRelAssignsTasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsToActor createIfcRelAssignsToActor() {
		IfcRelAssignsToActorImpl ifcRelAssignsToActor = new IfcRelAssignsToActorImpl();
		return ifcRelAssignsToActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsToControl createIfcRelAssignsToControl() {
		IfcRelAssignsToControlImpl ifcRelAssignsToControl = new IfcRelAssignsToControlImpl();
		return ifcRelAssignsToControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsToGroup createIfcRelAssignsToGroup() {
		IfcRelAssignsToGroupImpl ifcRelAssignsToGroup = new IfcRelAssignsToGroupImpl();
		return ifcRelAssignsToGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsToProcess createIfcRelAssignsToProcess() {
		IfcRelAssignsToProcessImpl ifcRelAssignsToProcess = new IfcRelAssignsToProcessImpl();
		return ifcRelAssignsToProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsToProduct createIfcRelAssignsToProduct() {
		IfcRelAssignsToProductImpl ifcRelAssignsToProduct = new IfcRelAssignsToProductImpl();
		return ifcRelAssignsToProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsToProjectOrder createIfcRelAssignsToProjectOrder() {
		IfcRelAssignsToProjectOrderImpl ifcRelAssignsToProjectOrder = new IfcRelAssignsToProjectOrderImpl();
		return ifcRelAssignsToProjectOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssignsToResource createIfcRelAssignsToResource() {
		IfcRelAssignsToResourceImpl ifcRelAssignsToResource = new IfcRelAssignsToResourceImpl();
		return ifcRelAssignsToResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociates createIfcRelAssociates() {
		IfcRelAssociatesImpl ifcRelAssociates = new IfcRelAssociatesImpl();
		return ifcRelAssociates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociatesAppliedValue createIfcRelAssociatesAppliedValue() {
		IfcRelAssociatesAppliedValueImpl ifcRelAssociatesAppliedValue = new IfcRelAssociatesAppliedValueImpl();
		return ifcRelAssociatesAppliedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociatesApproval createIfcRelAssociatesApproval() {
		IfcRelAssociatesApprovalImpl ifcRelAssociatesApproval = new IfcRelAssociatesApprovalImpl();
		return ifcRelAssociatesApproval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociatesClassification createIfcRelAssociatesClassification() {
		IfcRelAssociatesClassificationImpl ifcRelAssociatesClassification = new IfcRelAssociatesClassificationImpl();
		return ifcRelAssociatesClassification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociatesConstraint createIfcRelAssociatesConstraint() {
		IfcRelAssociatesConstraintImpl ifcRelAssociatesConstraint = new IfcRelAssociatesConstraintImpl();
		return ifcRelAssociatesConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociatesDocument createIfcRelAssociatesDocument() {
		IfcRelAssociatesDocumentImpl ifcRelAssociatesDocument = new IfcRelAssociatesDocumentImpl();
		return ifcRelAssociatesDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociatesLibrary createIfcRelAssociatesLibrary() {
		IfcRelAssociatesLibraryImpl ifcRelAssociatesLibrary = new IfcRelAssociatesLibraryImpl();
		return ifcRelAssociatesLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociatesMaterial createIfcRelAssociatesMaterial() {
		IfcRelAssociatesMaterialImpl ifcRelAssociatesMaterial = new IfcRelAssociatesMaterialImpl();
		return ifcRelAssociatesMaterial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelAssociatesProfileProperties createIfcRelAssociatesProfileProperties() {
		IfcRelAssociatesProfilePropertiesImpl ifcRelAssociatesProfileProperties = new IfcRelAssociatesProfilePropertiesImpl();
		return ifcRelAssociatesProfileProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnects createIfcRelConnects() {
		IfcRelConnectsImpl ifcRelConnects = new IfcRelConnectsImpl();
		return ifcRelConnects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsElements createIfcRelConnectsElements() {
		IfcRelConnectsElementsImpl ifcRelConnectsElements = new IfcRelConnectsElementsImpl();
		return ifcRelConnectsElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsPathElements createIfcRelConnectsPathElements() {
		IfcRelConnectsPathElementsImpl ifcRelConnectsPathElements = new IfcRelConnectsPathElementsImpl();
		return ifcRelConnectsPathElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsPortToElement createIfcRelConnectsPortToElement() {
		IfcRelConnectsPortToElementImpl ifcRelConnectsPortToElement = new IfcRelConnectsPortToElementImpl();
		return ifcRelConnectsPortToElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsPorts createIfcRelConnectsPorts() {
		IfcRelConnectsPortsImpl ifcRelConnectsPorts = new IfcRelConnectsPortsImpl();
		return ifcRelConnectsPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsStructuralActivity createIfcRelConnectsStructuralActivity() {
		IfcRelConnectsStructuralActivityImpl ifcRelConnectsStructuralActivity = new IfcRelConnectsStructuralActivityImpl();
		return ifcRelConnectsStructuralActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsStructuralElement createIfcRelConnectsStructuralElement() {
		IfcRelConnectsStructuralElementImpl ifcRelConnectsStructuralElement = new IfcRelConnectsStructuralElementImpl();
		return ifcRelConnectsStructuralElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsStructuralMember createIfcRelConnectsStructuralMember() {
		IfcRelConnectsStructuralMemberImpl ifcRelConnectsStructuralMember = new IfcRelConnectsStructuralMemberImpl();
		return ifcRelConnectsStructuralMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsWithEccentricity createIfcRelConnectsWithEccentricity() {
		IfcRelConnectsWithEccentricityImpl ifcRelConnectsWithEccentricity = new IfcRelConnectsWithEccentricityImpl();
		return ifcRelConnectsWithEccentricity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelConnectsWithRealizingElements createIfcRelConnectsWithRealizingElements() {
		IfcRelConnectsWithRealizingElementsImpl ifcRelConnectsWithRealizingElements = new IfcRelConnectsWithRealizingElementsImpl();
		return ifcRelConnectsWithRealizingElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelContainedInSpatialStructure createIfcRelContainedInSpatialStructure() {
		IfcRelContainedInSpatialStructureImpl ifcRelContainedInSpatialStructure = new IfcRelContainedInSpatialStructureImpl();
		return ifcRelContainedInSpatialStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelCoversBldgElements createIfcRelCoversBldgElements() {
		IfcRelCoversBldgElementsImpl ifcRelCoversBldgElements = new IfcRelCoversBldgElementsImpl();
		return ifcRelCoversBldgElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelCoversSpaces createIfcRelCoversSpaces() {
		IfcRelCoversSpacesImpl ifcRelCoversSpaces = new IfcRelCoversSpacesImpl();
		return ifcRelCoversSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelDecomposes createIfcRelDecomposes() {
		IfcRelDecomposesImpl ifcRelDecomposes = new IfcRelDecomposesImpl();
		return ifcRelDecomposes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelDefines createIfcRelDefines() {
		IfcRelDefinesImpl ifcRelDefines = new IfcRelDefinesImpl();
		return ifcRelDefines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelDefinesByProperties createIfcRelDefinesByProperties() {
		IfcRelDefinesByPropertiesImpl ifcRelDefinesByProperties = new IfcRelDefinesByPropertiesImpl();
		return ifcRelDefinesByProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelDefinesByType createIfcRelDefinesByType() {
		IfcRelDefinesByTypeImpl ifcRelDefinesByType = new IfcRelDefinesByTypeImpl();
		return ifcRelDefinesByType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelFillsElement createIfcRelFillsElement() {
		IfcRelFillsElementImpl ifcRelFillsElement = new IfcRelFillsElementImpl();
		return ifcRelFillsElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelFlowControlElements createIfcRelFlowControlElements() {
		IfcRelFlowControlElementsImpl ifcRelFlowControlElements = new IfcRelFlowControlElementsImpl();
		return ifcRelFlowControlElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelInteractionRequirements createIfcRelInteractionRequirements() {
		IfcRelInteractionRequirementsImpl ifcRelInteractionRequirements = new IfcRelInteractionRequirementsImpl();
		return ifcRelInteractionRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelNests createIfcRelNests() {
		IfcRelNestsImpl ifcRelNests = new IfcRelNestsImpl();
		return ifcRelNests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelOccupiesSpaces createIfcRelOccupiesSpaces() {
		IfcRelOccupiesSpacesImpl ifcRelOccupiesSpaces = new IfcRelOccupiesSpacesImpl();
		return ifcRelOccupiesSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelOverridesProperties createIfcRelOverridesProperties() {
		IfcRelOverridesPropertiesImpl ifcRelOverridesProperties = new IfcRelOverridesPropertiesImpl();
		return ifcRelOverridesProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelProjectsElement createIfcRelProjectsElement() {
		IfcRelProjectsElementImpl ifcRelProjectsElement = new IfcRelProjectsElementImpl();
		return ifcRelProjectsElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelReferencedInSpatialStructure createIfcRelReferencedInSpatialStructure() {
		IfcRelReferencedInSpatialStructureImpl ifcRelReferencedInSpatialStructure = new IfcRelReferencedInSpatialStructureImpl();
		return ifcRelReferencedInSpatialStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelSchedulesCostItems createIfcRelSchedulesCostItems() {
		IfcRelSchedulesCostItemsImpl ifcRelSchedulesCostItems = new IfcRelSchedulesCostItemsImpl();
		return ifcRelSchedulesCostItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelSequence createIfcRelSequence() {
		IfcRelSequenceImpl ifcRelSequence = new IfcRelSequenceImpl();
		return ifcRelSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelServicesBuildings createIfcRelServicesBuildings() {
		IfcRelServicesBuildingsImpl ifcRelServicesBuildings = new IfcRelServicesBuildingsImpl();
		return ifcRelServicesBuildings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelSpaceBoundary createIfcRelSpaceBoundary() {
		IfcRelSpaceBoundaryImpl ifcRelSpaceBoundary = new IfcRelSpaceBoundaryImpl();
		return ifcRelSpaceBoundary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelVoidsElement createIfcRelVoidsElement() {
		IfcRelVoidsElementImpl ifcRelVoidsElement = new IfcRelVoidsElementImpl();
		return ifcRelVoidsElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelationship createIfcRelationship() {
		IfcRelationshipImpl ifcRelationship = new IfcRelationshipImpl();
		return ifcRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelaxation createIfcRelaxation() {
		IfcRelaxationImpl ifcRelaxation = new IfcRelaxationImpl();
		return ifcRelaxation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRepresentation createIfcRepresentation() {
		IfcRepresentationImpl ifcRepresentation = new IfcRepresentationImpl();
		return ifcRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRepresentationContext createIfcRepresentationContext() {
		IfcRepresentationContextImpl ifcRepresentationContext = new IfcRepresentationContextImpl();
		return ifcRepresentationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRepresentationItem createIfcRepresentationItem() {
		IfcRepresentationItemImpl ifcRepresentationItem = new IfcRepresentationItemImpl();
		return ifcRepresentationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRepresentationMap createIfcRepresentationMap() {
		IfcRepresentationMapImpl ifcRepresentationMap = new IfcRepresentationMapImpl();
		return ifcRepresentationMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcResource createIfcResource() {
		IfcResourceImpl ifcResource = new IfcResourceImpl();
		return ifcResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRevolvedAreaSolid createIfcRevolvedAreaSolid() {
		IfcRevolvedAreaSolidImpl ifcRevolvedAreaSolid = new IfcRevolvedAreaSolidImpl();
		return ifcRevolvedAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRibPlateProfileProperties createIfcRibPlateProfileProperties() {
		IfcRibPlateProfilePropertiesImpl ifcRibPlateProfileProperties = new IfcRibPlateProfilePropertiesImpl();
		return ifcRibPlateProfileProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRightCircularCone createIfcRightCircularCone() {
		IfcRightCircularConeImpl ifcRightCircularCone = new IfcRightCircularConeImpl();
		return ifcRightCircularCone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRightCircularCylinder createIfcRightCircularCylinder() {
		IfcRightCircularCylinderImpl ifcRightCircularCylinder = new IfcRightCircularCylinderImpl();
		return ifcRightCircularCylinder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRoof createIfcRoof() {
		IfcRoofImpl ifcRoof = new IfcRoofImpl();
		return ifcRoof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRoot createIfcRoot() {
		IfcRootImpl ifcRoot = new IfcRootImpl();
		return ifcRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRoundedEdgeFeature createIfcRoundedEdgeFeature() {
		IfcRoundedEdgeFeatureImpl ifcRoundedEdgeFeature = new IfcRoundedEdgeFeatureImpl();
		return ifcRoundedEdgeFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRoundedRectangleProfileDef createIfcRoundedRectangleProfileDef() {
		IfcRoundedRectangleProfileDefImpl ifcRoundedRectangleProfileDef = new IfcRoundedRectangleProfileDefImpl();
		return ifcRoundedRectangleProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSIUnit createIfcSIUnit() {
		IfcSIUnitImpl ifcSIUnit = new IfcSIUnitImpl();
		return ifcSIUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSanitaryTerminalType createIfcSanitaryTerminalType() {
		IfcSanitaryTerminalTypeImpl ifcSanitaryTerminalType = new IfcSanitaryTerminalTypeImpl();
		return ifcSanitaryTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcScheduleTimeControl createIfcScheduleTimeControl() {
		IfcScheduleTimeControlImpl ifcScheduleTimeControl = new IfcScheduleTimeControlImpl();
		return ifcScheduleTimeControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSectionProperties createIfcSectionProperties() {
		IfcSectionPropertiesImpl ifcSectionProperties = new IfcSectionPropertiesImpl();
		return ifcSectionProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSectionReinforcementProperties createIfcSectionReinforcementProperties() {
		IfcSectionReinforcementPropertiesImpl ifcSectionReinforcementProperties = new IfcSectionReinforcementPropertiesImpl();
		return ifcSectionReinforcementProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSectionedSpine createIfcSectionedSpine() {
		IfcSectionedSpineImpl ifcSectionedSpine = new IfcSectionedSpineImpl();
		return ifcSectionedSpine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSensorType createIfcSensorType() {
		IfcSensorTypeImpl ifcSensorType = new IfcSensorTypeImpl();
		return ifcSensorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcServiceLife createIfcServiceLife() {
		IfcServiceLifeImpl ifcServiceLife = new IfcServiceLifeImpl();
		return ifcServiceLife;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcServiceLifeFactor createIfcServiceLifeFactor() {
		IfcServiceLifeFactorImpl ifcServiceLifeFactor = new IfcServiceLifeFactorImpl();
		return ifcServiceLifeFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect createIfcShapeAspect() {
		IfcShapeAspectImpl ifcShapeAspect = new IfcShapeAspectImpl();
		return ifcShapeAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeModel createIfcShapeModel() {
		IfcShapeModelImpl ifcShapeModel = new IfcShapeModelImpl();
		return ifcShapeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeRepresentation createIfcShapeRepresentation() {
		IfcShapeRepresentationImpl ifcShapeRepresentation = new IfcShapeRepresentationImpl();
		return ifcShapeRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShellBasedSurfaceModel createIfcShellBasedSurfaceModel() {
		IfcShellBasedSurfaceModelImpl ifcShellBasedSurfaceModel = new IfcShellBasedSurfaceModelImpl();
		return ifcShellBasedSurfaceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSimpleProperty createIfcSimpleProperty() {
		IfcSimplePropertyImpl ifcSimpleProperty = new IfcSimplePropertyImpl();
		return ifcSimpleProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSite createIfcSite() {
		IfcSiteImpl ifcSite = new IfcSiteImpl();
		return ifcSite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSlab createIfcSlab() {
		IfcSlabImpl ifcSlab = new IfcSlabImpl();
		return ifcSlab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSlabType createIfcSlabType() {
		IfcSlabTypeImpl ifcSlabType = new IfcSlabTypeImpl();
		return ifcSlabType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSlippageConnectionCondition createIfcSlippageConnectionCondition() {
		IfcSlippageConnectionConditionImpl ifcSlippageConnectionCondition = new IfcSlippageConnectionConditionImpl();
		return ifcSlippageConnectionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSolidModel createIfcSolidModel() {
		IfcSolidModelImpl ifcSolidModel = new IfcSolidModelImpl();
		return ifcSolidModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSoundProperties createIfcSoundProperties() {
		IfcSoundPropertiesImpl ifcSoundProperties = new IfcSoundPropertiesImpl();
		return ifcSoundProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSoundValue createIfcSoundValue() {
		IfcSoundValueImpl ifcSoundValue = new IfcSoundValueImpl();
		return ifcSoundValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpace createIfcSpace() {
		IfcSpaceImpl ifcSpace = new IfcSpaceImpl();
		return ifcSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpaceHeaterType createIfcSpaceHeaterType() {
		IfcSpaceHeaterTypeImpl ifcSpaceHeaterType = new IfcSpaceHeaterTypeImpl();
		return ifcSpaceHeaterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpaceProgram createIfcSpaceProgram() {
		IfcSpaceProgramImpl ifcSpaceProgram = new IfcSpaceProgramImpl();
		return ifcSpaceProgram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpaceThermalLoadProperties createIfcSpaceThermalLoadProperties() {
		IfcSpaceThermalLoadPropertiesImpl ifcSpaceThermalLoadProperties = new IfcSpaceThermalLoadPropertiesImpl();
		return ifcSpaceThermalLoadProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpaceType createIfcSpaceType() {
		IfcSpaceTypeImpl ifcSpaceType = new IfcSpaceTypeImpl();
		return ifcSpaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement createIfcSpatialStructureElement() {
		IfcSpatialStructureElementImpl ifcSpatialStructureElement = new IfcSpatialStructureElementImpl();
		return ifcSpatialStructureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElementType createIfcSpatialStructureElementType() {
		IfcSpatialStructureElementTypeImpl ifcSpatialStructureElementType = new IfcSpatialStructureElementTypeImpl();
		return ifcSpatialStructureElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSphere createIfcSphere() {
		IfcSphereImpl ifcSphere = new IfcSphereImpl();
		return ifcSphere;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStackTerminalType createIfcStackTerminalType() {
		IfcStackTerminalTypeImpl ifcStackTerminalType = new IfcStackTerminalTypeImpl();
		return ifcStackTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStair createIfcStair() {
		IfcStairImpl ifcStair = new IfcStairImpl();
		return ifcStair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStairFlight createIfcStairFlight() {
		IfcStairFlightImpl ifcStairFlight = new IfcStairFlightImpl();
		return ifcStairFlight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStairFlightType createIfcStairFlightType() {
		IfcStairFlightTypeImpl ifcStairFlightType = new IfcStairFlightTypeImpl();
		return ifcStairFlightType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralAction createIfcStructuralAction() {
		IfcStructuralActionImpl ifcStructuralAction = new IfcStructuralActionImpl();
		return ifcStructuralAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralActivity createIfcStructuralActivity() {
		IfcStructuralActivityImpl ifcStructuralActivity = new IfcStructuralActivityImpl();
		return ifcStructuralActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralAnalysisModel createIfcStructuralAnalysisModel() {
		IfcStructuralAnalysisModelImpl ifcStructuralAnalysisModel = new IfcStructuralAnalysisModelImpl();
		return ifcStructuralAnalysisModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralConnection createIfcStructuralConnection() {
		IfcStructuralConnectionImpl ifcStructuralConnection = new IfcStructuralConnectionImpl();
		return ifcStructuralConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralConnectionCondition createIfcStructuralConnectionCondition() {
		IfcStructuralConnectionConditionImpl ifcStructuralConnectionCondition = new IfcStructuralConnectionConditionImpl();
		return ifcStructuralConnectionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralCurveConnection createIfcStructuralCurveConnection() {
		IfcStructuralCurveConnectionImpl ifcStructuralCurveConnection = new IfcStructuralCurveConnectionImpl();
		return ifcStructuralCurveConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralCurveMember createIfcStructuralCurveMember() {
		IfcStructuralCurveMemberImpl ifcStructuralCurveMember = new IfcStructuralCurveMemberImpl();
		return ifcStructuralCurveMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralCurveMemberVarying createIfcStructuralCurveMemberVarying() {
		IfcStructuralCurveMemberVaryingImpl ifcStructuralCurveMemberVarying = new IfcStructuralCurveMemberVaryingImpl();
		return ifcStructuralCurveMemberVarying;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralItem createIfcStructuralItem() {
		IfcStructuralItemImpl ifcStructuralItem = new IfcStructuralItemImpl();
		return ifcStructuralItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLinearAction createIfcStructuralLinearAction() {
		IfcStructuralLinearActionImpl ifcStructuralLinearAction = new IfcStructuralLinearActionImpl();
		return ifcStructuralLinearAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLinearActionVarying createIfcStructuralLinearActionVarying() {
		IfcStructuralLinearActionVaryingImpl ifcStructuralLinearActionVarying = new IfcStructuralLinearActionVaryingImpl();
		return ifcStructuralLinearActionVarying;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoad createIfcStructuralLoad() {
		IfcStructuralLoadImpl ifcStructuralLoad = new IfcStructuralLoadImpl();
		return ifcStructuralLoad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadGroup createIfcStructuralLoadGroup() {
		IfcStructuralLoadGroupImpl ifcStructuralLoadGroup = new IfcStructuralLoadGroupImpl();
		return ifcStructuralLoadGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadLinearForce createIfcStructuralLoadLinearForce() {
		IfcStructuralLoadLinearForceImpl ifcStructuralLoadLinearForce = new IfcStructuralLoadLinearForceImpl();
		return ifcStructuralLoadLinearForce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadPlanarForce createIfcStructuralLoadPlanarForce() {
		IfcStructuralLoadPlanarForceImpl ifcStructuralLoadPlanarForce = new IfcStructuralLoadPlanarForceImpl();
		return ifcStructuralLoadPlanarForce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadSingleDisplacement createIfcStructuralLoadSingleDisplacement() {
		IfcStructuralLoadSingleDisplacementImpl ifcStructuralLoadSingleDisplacement = new IfcStructuralLoadSingleDisplacementImpl();
		return ifcStructuralLoadSingleDisplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadSingleDisplacementDistortion createIfcStructuralLoadSingleDisplacementDistortion() {
		IfcStructuralLoadSingleDisplacementDistortionImpl ifcStructuralLoadSingleDisplacementDistortion = new IfcStructuralLoadSingleDisplacementDistortionImpl();
		return ifcStructuralLoadSingleDisplacementDistortion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadSingleForce createIfcStructuralLoadSingleForce() {
		IfcStructuralLoadSingleForceImpl ifcStructuralLoadSingleForce = new IfcStructuralLoadSingleForceImpl();
		return ifcStructuralLoadSingleForce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadSingleForceWarping createIfcStructuralLoadSingleForceWarping() {
		IfcStructuralLoadSingleForceWarpingImpl ifcStructuralLoadSingleForceWarping = new IfcStructuralLoadSingleForceWarpingImpl();
		return ifcStructuralLoadSingleForceWarping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadStatic createIfcStructuralLoadStatic() {
		IfcStructuralLoadStaticImpl ifcStructuralLoadStatic = new IfcStructuralLoadStaticImpl();
		return ifcStructuralLoadStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadTemperature createIfcStructuralLoadTemperature() {
		IfcStructuralLoadTemperatureImpl ifcStructuralLoadTemperature = new IfcStructuralLoadTemperatureImpl();
		return ifcStructuralLoadTemperature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralMember createIfcStructuralMember() {
		IfcStructuralMemberImpl ifcStructuralMember = new IfcStructuralMemberImpl();
		return ifcStructuralMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralPlanarAction createIfcStructuralPlanarAction() {
		IfcStructuralPlanarActionImpl ifcStructuralPlanarAction = new IfcStructuralPlanarActionImpl();
		return ifcStructuralPlanarAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralPlanarActionVarying createIfcStructuralPlanarActionVarying() {
		IfcStructuralPlanarActionVaryingImpl ifcStructuralPlanarActionVarying = new IfcStructuralPlanarActionVaryingImpl();
		return ifcStructuralPlanarActionVarying;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralPointAction createIfcStructuralPointAction() {
		IfcStructuralPointActionImpl ifcStructuralPointAction = new IfcStructuralPointActionImpl();
		return ifcStructuralPointAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralPointConnection createIfcStructuralPointConnection() {
		IfcStructuralPointConnectionImpl ifcStructuralPointConnection = new IfcStructuralPointConnectionImpl();
		return ifcStructuralPointConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralPointReaction createIfcStructuralPointReaction() {
		IfcStructuralPointReactionImpl ifcStructuralPointReaction = new IfcStructuralPointReactionImpl();
		return ifcStructuralPointReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralProfileProperties createIfcStructuralProfileProperties() {
		IfcStructuralProfilePropertiesImpl ifcStructuralProfileProperties = new IfcStructuralProfilePropertiesImpl();
		return ifcStructuralProfileProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralReaction createIfcStructuralReaction() {
		IfcStructuralReactionImpl ifcStructuralReaction = new IfcStructuralReactionImpl();
		return ifcStructuralReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralResultGroup createIfcStructuralResultGroup() {
		IfcStructuralResultGroupImpl ifcStructuralResultGroup = new IfcStructuralResultGroupImpl();
		return ifcStructuralResultGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralSteelProfileProperties createIfcStructuralSteelProfileProperties() {
		IfcStructuralSteelProfilePropertiesImpl ifcStructuralSteelProfileProperties = new IfcStructuralSteelProfilePropertiesImpl();
		return ifcStructuralSteelProfileProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralSurfaceConnection createIfcStructuralSurfaceConnection() {
		IfcStructuralSurfaceConnectionImpl ifcStructuralSurfaceConnection = new IfcStructuralSurfaceConnectionImpl();
		return ifcStructuralSurfaceConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralSurfaceMember createIfcStructuralSurfaceMember() {
		IfcStructuralSurfaceMemberImpl ifcStructuralSurfaceMember = new IfcStructuralSurfaceMemberImpl();
		return ifcStructuralSurfaceMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralSurfaceMemberVarying createIfcStructuralSurfaceMemberVarying() {
		IfcStructuralSurfaceMemberVaryingImpl ifcStructuralSurfaceMemberVarying = new IfcStructuralSurfaceMemberVaryingImpl();
		return ifcStructuralSurfaceMemberVarying;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuredDimensionCallout createIfcStructuredDimensionCallout() {
		IfcStructuredDimensionCalloutImpl ifcStructuredDimensionCallout = new IfcStructuredDimensionCalloutImpl();
		return ifcStructuredDimensionCallout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStyleModel createIfcStyleModel() {
		IfcStyleModelImpl ifcStyleModel = new IfcStyleModelImpl();
		return ifcStyleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStyledItem createIfcStyledItem() {
		IfcStyledItemImpl ifcStyledItem = new IfcStyledItemImpl();
		return ifcStyledItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStyledRepresentation createIfcStyledRepresentation() {
		IfcStyledRepresentationImpl ifcStyledRepresentation = new IfcStyledRepresentationImpl();
		return ifcStyledRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSubContractResource createIfcSubContractResource() {
		IfcSubContractResourceImpl ifcSubContractResource = new IfcSubContractResourceImpl();
		return ifcSubContractResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSubedge createIfcSubedge() {
		IfcSubedgeImpl ifcSubedge = new IfcSubedgeImpl();
		return ifcSubedge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface createIfcSurface() {
		IfcSurfaceImpl ifcSurface = new IfcSurfaceImpl();
		return ifcSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceCurveSweptAreaSolid createIfcSurfaceCurveSweptAreaSolid() {
		IfcSurfaceCurveSweptAreaSolidImpl ifcSurfaceCurveSweptAreaSolid = new IfcSurfaceCurveSweptAreaSolidImpl();
		return ifcSurfaceCurveSweptAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceOfLinearExtrusion createIfcSurfaceOfLinearExtrusion() {
		IfcSurfaceOfLinearExtrusionImpl ifcSurfaceOfLinearExtrusion = new IfcSurfaceOfLinearExtrusionImpl();
		return ifcSurfaceOfLinearExtrusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceOfRevolution createIfcSurfaceOfRevolution() {
		IfcSurfaceOfRevolutionImpl ifcSurfaceOfRevolution = new IfcSurfaceOfRevolutionImpl();
		return ifcSurfaceOfRevolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceStyle createIfcSurfaceStyle() {
		IfcSurfaceStyleImpl ifcSurfaceStyle = new IfcSurfaceStyleImpl();
		return ifcSurfaceStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceStyleLighting createIfcSurfaceStyleLighting() {
		IfcSurfaceStyleLightingImpl ifcSurfaceStyleLighting = new IfcSurfaceStyleLightingImpl();
		return ifcSurfaceStyleLighting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceStyleRefraction createIfcSurfaceStyleRefraction() {
		IfcSurfaceStyleRefractionImpl ifcSurfaceStyleRefraction = new IfcSurfaceStyleRefractionImpl();
		return ifcSurfaceStyleRefraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceStyleRendering createIfcSurfaceStyleRendering() {
		IfcSurfaceStyleRenderingImpl ifcSurfaceStyleRendering = new IfcSurfaceStyleRenderingImpl();
		return ifcSurfaceStyleRendering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceStyleShading createIfcSurfaceStyleShading() {
		IfcSurfaceStyleShadingImpl ifcSurfaceStyleShading = new IfcSurfaceStyleShadingImpl();
		return ifcSurfaceStyleShading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceStyleWithTextures createIfcSurfaceStyleWithTextures() {
		IfcSurfaceStyleWithTexturesImpl ifcSurfaceStyleWithTextures = new IfcSurfaceStyleWithTexturesImpl();
		return ifcSurfaceStyleWithTextures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceTexture createIfcSurfaceTexture() {
		IfcSurfaceTextureImpl ifcSurfaceTexture = new IfcSurfaceTextureImpl();
		return ifcSurfaceTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSweptAreaSolid createIfcSweptAreaSolid() {
		IfcSweptAreaSolidImpl ifcSweptAreaSolid = new IfcSweptAreaSolidImpl();
		return ifcSweptAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSweptDiskSolid createIfcSweptDiskSolid() {
		IfcSweptDiskSolidImpl ifcSweptDiskSolid = new IfcSweptDiskSolidImpl();
		return ifcSweptDiskSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSweptSurface createIfcSweptSurface() {
		IfcSweptSurfaceImpl ifcSweptSurface = new IfcSweptSurfaceImpl();
		return ifcSweptSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSwitchingDeviceType createIfcSwitchingDeviceType() {
		IfcSwitchingDeviceTypeImpl ifcSwitchingDeviceType = new IfcSwitchingDeviceTypeImpl();
		return ifcSwitchingDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSymbolStyle createIfcSymbolStyle() {
		IfcSymbolStyleImpl ifcSymbolStyle = new IfcSymbolStyleImpl();
		return ifcSymbolStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSystem createIfcSystem() {
		IfcSystemImpl ifcSystem = new IfcSystemImpl();
		return ifcSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSystemFurnitureElementType createIfcSystemFurnitureElementType() {
		IfcSystemFurnitureElementTypeImpl ifcSystemFurnitureElementType = new IfcSystemFurnitureElementTypeImpl();
		return ifcSystemFurnitureElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTShapeProfileDef createIfcTShapeProfileDef() {
		IfcTShapeProfileDefImpl ifcTShapeProfileDef = new IfcTShapeProfileDefImpl();
		return ifcTShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTable createIfcTable() {
		IfcTableImpl ifcTable = new IfcTableImpl();
		return ifcTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTableRow createIfcTableRow() {
		IfcTableRowImpl ifcTableRow = new IfcTableRowImpl();
		return ifcTableRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTankType createIfcTankType() {
		IfcTankTypeImpl ifcTankType = new IfcTankTypeImpl();
		return ifcTankType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTask createIfcTask() {
		IfcTaskImpl ifcTask = new IfcTaskImpl();
		return ifcTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTelecomAddress createIfcTelecomAddress() {
		IfcTelecomAddressImpl ifcTelecomAddress = new IfcTelecomAddressImpl();
		return ifcTelecomAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTendon createIfcTendon() {
		IfcTendonImpl ifcTendon = new IfcTendonImpl();
		return ifcTendon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTendonAnchor createIfcTendonAnchor() {
		IfcTendonAnchorImpl ifcTendonAnchor = new IfcTendonAnchorImpl();
		return ifcTendonAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTerminatorSymbol createIfcTerminatorSymbol() {
		IfcTerminatorSymbolImpl ifcTerminatorSymbol = new IfcTerminatorSymbolImpl();
		return ifcTerminatorSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextLiteral createIfcTextLiteral() {
		IfcTextLiteralImpl ifcTextLiteral = new IfcTextLiteralImpl();
		return ifcTextLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextLiteralWithExtent createIfcTextLiteralWithExtent() {
		IfcTextLiteralWithExtentImpl ifcTextLiteralWithExtent = new IfcTextLiteralWithExtentImpl();
		return ifcTextLiteralWithExtent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextStyle createIfcTextStyle() {
		IfcTextStyleImpl ifcTextStyle = new IfcTextStyleImpl();
		return ifcTextStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextStyleFontModel createIfcTextStyleFontModel() {
		IfcTextStyleFontModelImpl ifcTextStyleFontModel = new IfcTextStyleFontModelImpl();
		return ifcTextStyleFontModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextStyleForDefinedFont createIfcTextStyleForDefinedFont() {
		IfcTextStyleForDefinedFontImpl ifcTextStyleForDefinedFont = new IfcTextStyleForDefinedFontImpl();
		return ifcTextStyleForDefinedFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextStyleTextModel createIfcTextStyleTextModel() {
		IfcTextStyleTextModelImpl ifcTextStyleTextModel = new IfcTextStyleTextModelImpl();
		return ifcTextStyleTextModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextStyleWithBoxCharacteristics createIfcTextStyleWithBoxCharacteristics() {
		IfcTextStyleWithBoxCharacteristicsImpl ifcTextStyleWithBoxCharacteristics = new IfcTextStyleWithBoxCharacteristicsImpl();
		return ifcTextStyleWithBoxCharacteristics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextureCoordinate createIfcTextureCoordinate() {
		IfcTextureCoordinateImpl ifcTextureCoordinate = new IfcTextureCoordinateImpl();
		return ifcTextureCoordinate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextureCoordinateGenerator createIfcTextureCoordinateGenerator() {
		IfcTextureCoordinateGeneratorImpl ifcTextureCoordinateGenerator = new IfcTextureCoordinateGeneratorImpl();
		return ifcTextureCoordinateGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextureMap createIfcTextureMap() {
		IfcTextureMapImpl ifcTextureMap = new IfcTextureMapImpl();
		return ifcTextureMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextureVertex createIfcTextureVertex() {
		IfcTextureVertexImpl ifcTextureVertex = new IfcTextureVertexImpl();
		return ifcTextureVertex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalMaterialProperties createIfcThermalMaterialProperties() {
		IfcThermalMaterialPropertiesImpl ifcThermalMaterialProperties = new IfcThermalMaterialPropertiesImpl();
		return ifcThermalMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries createIfcTimeSeries() {
		IfcTimeSeriesImpl ifcTimeSeries = new IfcTimeSeriesImpl();
		return ifcTimeSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeriesReferenceRelationship createIfcTimeSeriesReferenceRelationship() {
		IfcTimeSeriesReferenceRelationshipImpl ifcTimeSeriesReferenceRelationship = new IfcTimeSeriesReferenceRelationshipImpl();
		return ifcTimeSeriesReferenceRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeriesSchedule createIfcTimeSeriesSchedule() {
		IfcTimeSeriesScheduleImpl ifcTimeSeriesSchedule = new IfcTimeSeriesScheduleImpl();
		return ifcTimeSeriesSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeriesValue createIfcTimeSeriesValue() {
		IfcTimeSeriesValueImpl ifcTimeSeriesValue = new IfcTimeSeriesValueImpl();
		return ifcTimeSeriesValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTopologicalRepresentationItem createIfcTopologicalRepresentationItem() {
		IfcTopologicalRepresentationItemImpl ifcTopologicalRepresentationItem = new IfcTopologicalRepresentationItemImpl();
		return ifcTopologicalRepresentationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTopologyRepresentation createIfcTopologyRepresentation() {
		IfcTopologyRepresentationImpl ifcTopologyRepresentation = new IfcTopologyRepresentationImpl();
		return ifcTopologyRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTransformerType createIfcTransformerType() {
		IfcTransformerTypeImpl ifcTransformerType = new IfcTransformerTypeImpl();
		return ifcTransformerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTransportElement createIfcTransportElement() {
		IfcTransportElementImpl ifcTransportElement = new IfcTransportElementImpl();
		return ifcTransportElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTransportElementType createIfcTransportElementType() {
		IfcTransportElementTypeImpl ifcTransportElementType = new IfcTransportElementTypeImpl();
		return ifcTransportElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTrapeziumProfileDef createIfcTrapeziumProfileDef() {
		IfcTrapeziumProfileDefImpl ifcTrapeziumProfileDef = new IfcTrapeziumProfileDefImpl();
		return ifcTrapeziumProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTrimmedCurve createIfcTrimmedCurve() {
		IfcTrimmedCurveImpl ifcTrimmedCurve = new IfcTrimmedCurveImpl();
		return ifcTrimmedCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTubeBundleType createIfcTubeBundleType() {
		IfcTubeBundleTypeImpl ifcTubeBundleType = new IfcTubeBundleTypeImpl();
		return ifcTubeBundleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTwoDirectionRepeatFactor createIfcTwoDirectionRepeatFactor() {
		IfcTwoDirectionRepeatFactorImpl ifcTwoDirectionRepeatFactor = new IfcTwoDirectionRepeatFactorImpl();
		return ifcTwoDirectionRepeatFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTypeObject createIfcTypeObject() {
		IfcTypeObjectImpl ifcTypeObject = new IfcTypeObjectImpl();
		return ifcTypeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTypeProduct createIfcTypeProduct() {
		IfcTypeProductImpl ifcTypeProduct = new IfcTypeProductImpl();
		return ifcTypeProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUShapeProfileDef createIfcUShapeProfileDef() {
		IfcUShapeProfileDefImpl ifcUShapeProfileDef = new IfcUShapeProfileDefImpl();
		return ifcUShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnitAssignment createIfcUnitAssignment() {
		IfcUnitAssignmentImpl ifcUnitAssignment = new IfcUnitAssignmentImpl();
		return ifcUnitAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnitaryEquipmentType createIfcUnitaryEquipmentType() {
		IfcUnitaryEquipmentTypeImpl ifcUnitaryEquipmentType = new IfcUnitaryEquipmentTypeImpl();
		return ifcUnitaryEquipmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcValveType createIfcValveType() {
		IfcValveTypeImpl ifcValveType = new IfcValveTypeImpl();
		return ifcValveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVector createIfcVector() {
		IfcVectorImpl ifcVector = new IfcVectorImpl();
		return ifcVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertex createIfcVertex() {
		IfcVertexImpl ifcVertex = new IfcVertexImpl();
		return ifcVertex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertexBasedTextureMap createIfcVertexBasedTextureMap() {
		IfcVertexBasedTextureMapImpl ifcVertexBasedTextureMap = new IfcVertexBasedTextureMapImpl();
		return ifcVertexBasedTextureMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertexLoop createIfcVertexLoop() {
		IfcVertexLoopImpl ifcVertexLoop = new IfcVertexLoopImpl();
		return ifcVertexLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVertexPoint createIfcVertexPoint() {
		IfcVertexPointImpl ifcVertexPoint = new IfcVertexPointImpl();
		return ifcVertexPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVibrationIsolatorType createIfcVibrationIsolatorType() {
		IfcVibrationIsolatorTypeImpl ifcVibrationIsolatorType = new IfcVibrationIsolatorTypeImpl();
		return ifcVibrationIsolatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVirtualElement createIfcVirtualElement() {
		IfcVirtualElementImpl ifcVirtualElement = new IfcVirtualElementImpl();
		return ifcVirtualElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVirtualGridIntersection createIfcVirtualGridIntersection() {
		IfcVirtualGridIntersectionImpl ifcVirtualGridIntersection = new IfcVirtualGridIntersectionImpl();
		return ifcVirtualGridIntersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWall createIfcWall() {
		IfcWallImpl ifcWall = new IfcWallImpl();
		return ifcWall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWallStandardCase createIfcWallStandardCase() {
		IfcWallStandardCaseImpl ifcWallStandardCase = new IfcWallStandardCaseImpl();
		return ifcWallStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWallType createIfcWallType() {
		IfcWallTypeImpl ifcWallType = new IfcWallTypeImpl();
		return ifcWallType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWasteTerminalType createIfcWasteTerminalType() {
		IfcWasteTerminalTypeImpl ifcWasteTerminalType = new IfcWasteTerminalTypeImpl();
		return ifcWasteTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWaterProperties createIfcWaterProperties() {
		IfcWaterPropertiesImpl ifcWaterProperties = new IfcWaterPropertiesImpl();
		return ifcWaterProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindow createIfcWindow() {
		IfcWindowImpl ifcWindow = new IfcWindowImpl();
		return ifcWindow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowLiningProperties createIfcWindowLiningProperties() {
		IfcWindowLiningPropertiesImpl ifcWindowLiningProperties = new IfcWindowLiningPropertiesImpl();
		return ifcWindowLiningProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowPanelProperties createIfcWindowPanelProperties() {
		IfcWindowPanelPropertiesImpl ifcWindowPanelProperties = new IfcWindowPanelPropertiesImpl();
		return ifcWindowPanelProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowStyle createIfcWindowStyle() {
		IfcWindowStyleImpl ifcWindowStyle = new IfcWindowStyleImpl();
		return ifcWindowStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkControl createIfcWorkControl() {
		IfcWorkControlImpl ifcWorkControl = new IfcWorkControlImpl();
		return ifcWorkControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkPlan createIfcWorkPlan() {
		IfcWorkPlanImpl ifcWorkPlan = new IfcWorkPlanImpl();
		return ifcWorkPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkSchedule createIfcWorkSchedule() {
		IfcWorkScheduleImpl ifcWorkSchedule = new IfcWorkScheduleImpl();
		return ifcWorkSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcZShapeProfileDef createIfcZShapeProfileDef() {
		IfcZShapeProfileDefImpl ifcZShapeProfileDef = new IfcZShapeProfileDefImpl();
		return ifcZShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcZone createIfcZone() {
		IfcZoneImpl ifcZone = new IfcZoneImpl();
		return ifcZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAbsorbedDoseMeasure createIfcAbsorbedDoseMeasure() {
		IfcAbsorbedDoseMeasureImpl ifcAbsorbedDoseMeasure = new IfcAbsorbedDoseMeasureImpl();
		return ifcAbsorbedDoseMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAccelerationMeasure createIfcAccelerationMeasure() {
		IfcAccelerationMeasureImpl ifcAccelerationMeasure = new IfcAccelerationMeasureImpl();
		return ifcAccelerationMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAmountOfSubstanceMeasure createIfcAmountOfSubstanceMeasure() {
		IfcAmountOfSubstanceMeasureImpl ifcAmountOfSubstanceMeasure = new IfcAmountOfSubstanceMeasureImpl();
		return ifcAmountOfSubstanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAngularVelocityMeasure createIfcAngularVelocityMeasure() {
		IfcAngularVelocityMeasureImpl ifcAngularVelocityMeasure = new IfcAngularVelocityMeasureImpl();
		return ifcAngularVelocityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAreaMeasure createIfcAreaMeasure() {
		IfcAreaMeasureImpl ifcAreaMeasure = new IfcAreaMeasureImpl();
		return ifcAreaMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoolean createIfcBoolean() {
		IfcBooleanImpl ifcBoolean = new IfcBooleanImpl();
		return ifcBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcContextDependentMeasure createIfcContextDependentMeasure() {
		IfcContextDependentMeasureImpl ifcContextDependentMeasure = new IfcContextDependentMeasureImpl();
		return ifcContextDependentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCountMeasure createIfcCountMeasure() {
		IfcCountMeasureImpl ifcCountMeasure = new IfcCountMeasureImpl();
		return ifcCountMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurvatureMeasure createIfcCurvatureMeasure() {
		IfcCurvatureMeasureImpl ifcCurvatureMeasure = new IfcCurvatureMeasureImpl();
		return ifcCurvatureMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDayInMonthNumber createIfcDayInMonthNumber() {
		IfcDayInMonthNumberImpl ifcDayInMonthNumber = new IfcDayInMonthNumberImpl();
		return ifcDayInMonthNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDaylightSavingHour createIfcDaylightSavingHour() {
		IfcDaylightSavingHourImpl ifcDaylightSavingHour = new IfcDaylightSavingHourImpl();
		return ifcDaylightSavingHour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDescriptiveMeasure createIfcDescriptiveMeasure() {
		IfcDescriptiveMeasureImpl ifcDescriptiveMeasure = new IfcDescriptiveMeasureImpl();
		return ifcDescriptiveMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionCount createIfcDimensionCount() {
		IfcDimensionCountImpl ifcDimensionCount = new IfcDimensionCountImpl();
		return ifcDimensionCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoseEquivalentMeasure createIfcDoseEquivalentMeasure() {
		IfcDoseEquivalentMeasureImpl ifcDoseEquivalentMeasure = new IfcDoseEquivalentMeasureImpl();
		return ifcDoseEquivalentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDynamicViscosityMeasure createIfcDynamicViscosityMeasure() {
		IfcDynamicViscosityMeasureImpl ifcDynamicViscosityMeasure = new IfcDynamicViscosityMeasureImpl();
		return ifcDynamicViscosityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricCapacitanceMeasure createIfcElectricCapacitanceMeasure() {
		IfcElectricCapacitanceMeasureImpl ifcElectricCapacitanceMeasure = new IfcElectricCapacitanceMeasureImpl();
		return ifcElectricCapacitanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricChargeMeasure createIfcElectricChargeMeasure() {
		IfcElectricChargeMeasureImpl ifcElectricChargeMeasure = new IfcElectricChargeMeasureImpl();
		return ifcElectricChargeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricConductanceMeasure createIfcElectricConductanceMeasure() {
		IfcElectricConductanceMeasureImpl ifcElectricConductanceMeasure = new IfcElectricConductanceMeasureImpl();
		return ifcElectricConductanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricCurrentMeasure createIfcElectricCurrentMeasure() {
		IfcElectricCurrentMeasureImpl ifcElectricCurrentMeasure = new IfcElectricCurrentMeasureImpl();
		return ifcElectricCurrentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricResistanceMeasure createIfcElectricResistanceMeasure() {
		IfcElectricResistanceMeasureImpl ifcElectricResistanceMeasure = new IfcElectricResistanceMeasureImpl();
		return ifcElectricResistanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricVoltageMeasure createIfcElectricVoltageMeasure() {
		IfcElectricVoltageMeasureImpl ifcElectricVoltageMeasure = new IfcElectricVoltageMeasureImpl();
		return ifcElectricVoltageMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnergyMeasure createIfcEnergyMeasure() {
		IfcEnergyMeasureImpl ifcEnergyMeasure = new IfcEnergyMeasureImpl();
		return ifcEnergyMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFontStyle createIfcFontStyle() {
		IfcFontStyleImpl ifcFontStyle = new IfcFontStyleImpl();
		return ifcFontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFontVariant createIfcFontVariant() {
		IfcFontVariantImpl ifcFontVariant = new IfcFontVariantImpl();
		return ifcFontVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFontWeight createIfcFontWeight() {
		IfcFontWeightImpl ifcFontWeight = new IfcFontWeightImpl();
		return ifcFontWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcForceMeasure createIfcForceMeasure() {
		IfcForceMeasureImpl ifcForceMeasure = new IfcForceMeasureImpl();
		return ifcForceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFrequencyMeasure createIfcFrequencyMeasure() {
		IfcFrequencyMeasureImpl ifcFrequencyMeasure = new IfcFrequencyMeasureImpl();
		return ifcFrequencyMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGloballyUniqueId createIfcGloballyUniqueId() {
		IfcGloballyUniqueIdImpl ifcGloballyUniqueId = new IfcGloballyUniqueIdImpl();
		return ifcGloballyUniqueId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHeatFluxDensityMeasure createIfcHeatFluxDensityMeasure() {
		IfcHeatFluxDensityMeasureImpl ifcHeatFluxDensityMeasure = new IfcHeatFluxDensityMeasureImpl();
		return ifcHeatFluxDensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHeatingValueMeasure createIfcHeatingValueMeasure() {
		IfcHeatingValueMeasureImpl ifcHeatingValueMeasure = new IfcHeatingValueMeasureImpl();
		return ifcHeatingValueMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHourInDay createIfcHourInDay() {
		IfcHourInDayImpl ifcHourInDay = new IfcHourInDayImpl();
		return ifcHourInDay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcIdentifier createIfcIdentifier() {
		IfcIdentifierImpl ifcIdentifier = new IfcIdentifierImpl();
		return ifcIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcIlluminanceMeasure createIfcIlluminanceMeasure() {
		IfcIlluminanceMeasureImpl ifcIlluminanceMeasure = new IfcIlluminanceMeasureImpl();
		return ifcIlluminanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInductanceMeasure createIfcInductanceMeasure() {
		IfcInductanceMeasureImpl ifcInductanceMeasure = new IfcInductanceMeasureImpl();
		return ifcInductanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInteger createIfcInteger() {
		IfcIntegerImpl ifcInteger = new IfcIntegerImpl();
		return ifcInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcIntegerCountRateMeasure createIfcIntegerCountRateMeasure() {
		IfcIntegerCountRateMeasureImpl ifcIntegerCountRateMeasure = new IfcIntegerCountRateMeasureImpl();
		return ifcIntegerCountRateMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcIonConcentrationMeasure createIfcIonConcentrationMeasure() {
		IfcIonConcentrationMeasureImpl ifcIonConcentrationMeasure = new IfcIonConcentrationMeasureImpl();
		return ifcIonConcentrationMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcIsothermalMoistureCapacityMeasure createIfcIsothermalMoistureCapacityMeasure() {
		IfcIsothermalMoistureCapacityMeasureImpl ifcIsothermalMoistureCapacityMeasure = new IfcIsothermalMoistureCapacityMeasureImpl();
		return ifcIsothermalMoistureCapacityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcKinematicViscosityMeasure createIfcKinematicViscosityMeasure() {
		IfcKinematicViscosityMeasureImpl ifcKinematicViscosityMeasure = new IfcKinematicViscosityMeasureImpl();
		return ifcKinematicViscosityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLabel createIfcLabel() {
		IfcLabelImpl ifcLabel = new IfcLabelImpl();
		return ifcLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLengthMeasure createIfcLengthMeasure() {
		IfcLengthMeasureImpl ifcLengthMeasure = new IfcLengthMeasureImpl();
		return ifcLengthMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLinearForceMeasure createIfcLinearForceMeasure() {
		IfcLinearForceMeasureImpl ifcLinearForceMeasure = new IfcLinearForceMeasureImpl();
		return ifcLinearForceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLinearMomentMeasure createIfcLinearMomentMeasure() {
		IfcLinearMomentMeasureImpl ifcLinearMomentMeasure = new IfcLinearMomentMeasureImpl();
		return ifcLinearMomentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLinearStiffnessMeasure createIfcLinearStiffnessMeasure() {
		IfcLinearStiffnessMeasureImpl ifcLinearStiffnessMeasure = new IfcLinearStiffnessMeasureImpl();
		return ifcLinearStiffnessMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLinearVelocityMeasure createIfcLinearVelocityMeasure() {
		IfcLinearVelocityMeasureImpl ifcLinearVelocityMeasure = new IfcLinearVelocityMeasureImpl();
		return ifcLinearVelocityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLogical createIfcLogical() {
		IfcLogicalImpl ifcLogical = new IfcLogicalImpl();
		return ifcLogical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLuminousFluxMeasure createIfcLuminousFluxMeasure() {
		IfcLuminousFluxMeasureImpl ifcLuminousFluxMeasure = new IfcLuminousFluxMeasureImpl();
		return ifcLuminousFluxMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLuminousIntensityDistributionMeasure createIfcLuminousIntensityDistributionMeasure() {
		IfcLuminousIntensityDistributionMeasureImpl ifcLuminousIntensityDistributionMeasure = new IfcLuminousIntensityDistributionMeasureImpl();
		return ifcLuminousIntensityDistributionMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLuminousIntensityMeasure createIfcLuminousIntensityMeasure() {
		IfcLuminousIntensityMeasureImpl ifcLuminousIntensityMeasure = new IfcLuminousIntensityMeasureImpl();
		return ifcLuminousIntensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMagneticFluxDensityMeasure createIfcMagneticFluxDensityMeasure() {
		IfcMagneticFluxDensityMeasureImpl ifcMagneticFluxDensityMeasure = new IfcMagneticFluxDensityMeasureImpl();
		return ifcMagneticFluxDensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMagneticFluxMeasure createIfcMagneticFluxMeasure() {
		IfcMagneticFluxMeasureImpl ifcMagneticFluxMeasure = new IfcMagneticFluxMeasureImpl();
		return ifcMagneticFluxMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMassDensityMeasure createIfcMassDensityMeasure() {
		IfcMassDensityMeasureImpl ifcMassDensityMeasure = new IfcMassDensityMeasureImpl();
		return ifcMassDensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMassFlowRateMeasure createIfcMassFlowRateMeasure() {
		IfcMassFlowRateMeasureImpl ifcMassFlowRateMeasure = new IfcMassFlowRateMeasureImpl();
		return ifcMassFlowRateMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMassMeasure createIfcMassMeasure() {
		IfcMassMeasureImpl ifcMassMeasure = new IfcMassMeasureImpl();
		return ifcMassMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMassPerLengthMeasure createIfcMassPerLengthMeasure() {
		IfcMassPerLengthMeasureImpl ifcMassPerLengthMeasure = new IfcMassPerLengthMeasureImpl();
		return ifcMassPerLengthMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMinuteInHour createIfcMinuteInHour() {
		IfcMinuteInHourImpl ifcMinuteInHour = new IfcMinuteInHourImpl();
		return ifcMinuteInHour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcModulusOfElasticityMeasure createIfcModulusOfElasticityMeasure() {
		IfcModulusOfElasticityMeasureImpl ifcModulusOfElasticityMeasure = new IfcModulusOfElasticityMeasureImpl();
		return ifcModulusOfElasticityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcModulusOfLinearSubgradeReactionMeasure createIfcModulusOfLinearSubgradeReactionMeasure() {
		IfcModulusOfLinearSubgradeReactionMeasureImpl ifcModulusOfLinearSubgradeReactionMeasure = new IfcModulusOfLinearSubgradeReactionMeasureImpl();
		return ifcModulusOfLinearSubgradeReactionMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcModulusOfRotationalSubgradeReactionMeasure createIfcModulusOfRotationalSubgradeReactionMeasure() {
		IfcModulusOfRotationalSubgradeReactionMeasureImpl ifcModulusOfRotationalSubgradeReactionMeasure = new IfcModulusOfRotationalSubgradeReactionMeasureImpl();
		return ifcModulusOfRotationalSubgradeReactionMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcModulusOfSubgradeReactionMeasure createIfcModulusOfSubgradeReactionMeasure() {
		IfcModulusOfSubgradeReactionMeasureImpl ifcModulusOfSubgradeReactionMeasure = new IfcModulusOfSubgradeReactionMeasureImpl();
		return ifcModulusOfSubgradeReactionMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMoistureDiffusivityMeasure createIfcMoistureDiffusivityMeasure() {
		IfcMoistureDiffusivityMeasureImpl ifcMoistureDiffusivityMeasure = new IfcMoistureDiffusivityMeasureImpl();
		return ifcMoistureDiffusivityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMolecularWeightMeasure createIfcMolecularWeightMeasure() {
		IfcMolecularWeightMeasureImpl ifcMolecularWeightMeasure = new IfcMolecularWeightMeasureImpl();
		return ifcMolecularWeightMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMomentOfInertiaMeasure createIfcMomentOfInertiaMeasure() {
		IfcMomentOfInertiaMeasureImpl ifcMomentOfInertiaMeasure = new IfcMomentOfInertiaMeasureImpl();
		return ifcMomentOfInertiaMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMonetaryMeasure createIfcMonetaryMeasure() {
		IfcMonetaryMeasureImpl ifcMonetaryMeasure = new IfcMonetaryMeasureImpl();
		return ifcMonetaryMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMonthInYearNumber createIfcMonthInYearNumber() {
		IfcMonthInYearNumberImpl ifcMonthInYearNumber = new IfcMonthInYearNumberImpl();
		return ifcMonthInYearNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcNumericMeasure createIfcNumericMeasure() {
		IfcNumericMeasureImpl ifcNumericMeasure = new IfcNumericMeasureImpl();
		return ifcNumericMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPHMeasure createIfcPHMeasure() {
		IfcPHMeasureImpl ifcPHMeasure = new IfcPHMeasureImpl();
		return ifcPHMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcParameterValue createIfcParameterValue() {
		IfcParameterValueImpl ifcParameterValue = new IfcParameterValueImpl();
		return ifcParameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlanarForceMeasure createIfcPlanarForceMeasure() {
		IfcPlanarForceMeasureImpl ifcPlanarForceMeasure = new IfcPlanarForceMeasureImpl();
		return ifcPlanarForceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlaneAngleMeasure createIfcPlaneAngleMeasure() {
		IfcPlaneAngleMeasureImpl ifcPlaneAngleMeasure = new IfcPlaneAngleMeasureImpl();
		return ifcPlaneAngleMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPowerMeasure createIfcPowerMeasure() {
		IfcPowerMeasureImpl ifcPowerMeasure = new IfcPowerMeasureImpl();
		return ifcPowerMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPresentableText createIfcPresentableText() {
		IfcPresentableTextImpl ifcPresentableText = new IfcPresentableTextImpl();
		return ifcPresentableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPressureMeasure createIfcPressureMeasure() {
		IfcPressureMeasureImpl ifcPressureMeasure = new IfcPressureMeasureImpl();
		return ifcPressureMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRadioActivityMeasure createIfcRadioActivityMeasure() {
		IfcRadioActivityMeasureImpl ifcRadioActivityMeasure = new IfcRadioActivityMeasureImpl();
		return ifcRadioActivityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRatioMeasure createIfcRatioMeasure() {
		IfcRatioMeasureImpl ifcRatioMeasure = new IfcRatioMeasureImpl();
		return ifcRatioMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReal createIfcReal() {
		IfcRealImpl ifcReal = new IfcRealImpl();
		return ifcReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRotationalFrequencyMeasure createIfcRotationalFrequencyMeasure() {
		IfcRotationalFrequencyMeasureImpl ifcRotationalFrequencyMeasure = new IfcRotationalFrequencyMeasureImpl();
		return ifcRotationalFrequencyMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRotationalMassMeasure createIfcRotationalMassMeasure() {
		IfcRotationalMassMeasureImpl ifcRotationalMassMeasure = new IfcRotationalMassMeasureImpl();
		return ifcRotationalMassMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRotationalStiffnessMeasure createIfcRotationalStiffnessMeasure() {
		IfcRotationalStiffnessMeasureImpl ifcRotationalStiffnessMeasure = new IfcRotationalStiffnessMeasureImpl();
		return ifcRotationalStiffnessMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSecondInMinute createIfcSecondInMinute() {
		IfcSecondInMinuteImpl ifcSecondInMinute = new IfcSecondInMinuteImpl();
		return ifcSecondInMinute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSectionModulusMeasure createIfcSectionModulusMeasure() {
		IfcSectionModulusMeasureImpl ifcSectionModulusMeasure = new IfcSectionModulusMeasureImpl();
		return ifcSectionModulusMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSectionalAreaIntegralMeasure createIfcSectionalAreaIntegralMeasure() {
		IfcSectionalAreaIntegralMeasureImpl ifcSectionalAreaIntegralMeasure = new IfcSectionalAreaIntegralMeasureImpl();
		return ifcSectionalAreaIntegralMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShearModulusMeasure createIfcShearModulusMeasure() {
		IfcShearModulusMeasureImpl ifcShearModulusMeasure = new IfcShearModulusMeasureImpl();
		return ifcShearModulusMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSolidAngleMeasure createIfcSolidAngleMeasure() {
		IfcSolidAngleMeasureImpl ifcSolidAngleMeasure = new IfcSolidAngleMeasureImpl();
		return ifcSolidAngleMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSoundPowerMeasure createIfcSoundPowerMeasure() {
		IfcSoundPowerMeasureImpl ifcSoundPowerMeasure = new IfcSoundPowerMeasureImpl();
		return ifcSoundPowerMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSoundPressureMeasure createIfcSoundPressureMeasure() {
		IfcSoundPressureMeasureImpl ifcSoundPressureMeasure = new IfcSoundPressureMeasureImpl();
		return ifcSoundPressureMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpecificHeatCapacityMeasure createIfcSpecificHeatCapacityMeasure() {
		IfcSpecificHeatCapacityMeasureImpl ifcSpecificHeatCapacityMeasure = new IfcSpecificHeatCapacityMeasureImpl();
		return ifcSpecificHeatCapacityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpecularExponent createIfcSpecularExponent() {
		IfcSpecularExponentImpl ifcSpecularExponent = new IfcSpecularExponentImpl();
		return ifcSpecularExponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpecularRoughness createIfcSpecularRoughness() {
		IfcSpecularRoughnessImpl ifcSpecularRoughness = new IfcSpecularRoughnessImpl();
		return ifcSpecularRoughness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTemperatureGradientMeasure createIfcTemperatureGradientMeasure() {
		IfcTemperatureGradientMeasureImpl ifcTemperatureGradientMeasure = new IfcTemperatureGradientMeasureImpl();
		return ifcTemperatureGradientMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcText createIfcText() {
		IfcTextImpl ifcText = new IfcTextImpl();
		return ifcText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextAlignment createIfcTextAlignment() {
		IfcTextAlignmentImpl ifcTextAlignment = new IfcTextAlignmentImpl();
		return ifcTextAlignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextDecoration createIfcTextDecoration() {
		IfcTextDecorationImpl ifcTextDecoration = new IfcTextDecorationImpl();
		return ifcTextDecoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextFontName createIfcTextFontName() {
		IfcTextFontNameImpl ifcTextFontName = new IfcTextFontNameImpl();
		return ifcTextFontName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextTransformation createIfcTextTransformation() {
		IfcTextTransformationImpl ifcTextTransformation = new IfcTextTransformationImpl();
		return ifcTextTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalAdmittanceMeasure createIfcThermalAdmittanceMeasure() {
		IfcThermalAdmittanceMeasureImpl ifcThermalAdmittanceMeasure = new IfcThermalAdmittanceMeasureImpl();
		return ifcThermalAdmittanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalConductivityMeasure createIfcThermalConductivityMeasure() {
		IfcThermalConductivityMeasureImpl ifcThermalConductivityMeasure = new IfcThermalConductivityMeasureImpl();
		return ifcThermalConductivityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalExpansionCoefficientMeasure createIfcThermalExpansionCoefficientMeasure() {
		IfcThermalExpansionCoefficientMeasureImpl ifcThermalExpansionCoefficientMeasure = new IfcThermalExpansionCoefficientMeasureImpl();
		return ifcThermalExpansionCoefficientMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalResistanceMeasure createIfcThermalResistanceMeasure() {
		IfcThermalResistanceMeasureImpl ifcThermalResistanceMeasure = new IfcThermalResistanceMeasureImpl();
		return ifcThermalResistanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalTransmittanceMeasure createIfcThermalTransmittanceMeasure() {
		IfcThermalTransmittanceMeasureImpl ifcThermalTransmittanceMeasure = new IfcThermalTransmittanceMeasureImpl();
		return ifcThermalTransmittanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermodynamicTemperatureMeasure createIfcThermodynamicTemperatureMeasure() {
		IfcThermodynamicTemperatureMeasureImpl ifcThermodynamicTemperatureMeasure = new IfcThermodynamicTemperatureMeasureImpl();
		return ifcThermodynamicTemperatureMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeMeasure createIfcTimeMeasure() {
		IfcTimeMeasureImpl ifcTimeMeasure = new IfcTimeMeasureImpl();
		return ifcTimeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeStamp createIfcTimeStamp() {
		IfcTimeStampImpl ifcTimeStamp = new IfcTimeStampImpl();
		return ifcTimeStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTorqueMeasure createIfcTorqueMeasure() {
		IfcTorqueMeasureImpl ifcTorqueMeasure = new IfcTorqueMeasureImpl();
		return ifcTorqueMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVaporPermeabilityMeasure createIfcVaporPermeabilityMeasure() {
		IfcVaporPermeabilityMeasureImpl ifcVaporPermeabilityMeasure = new IfcVaporPermeabilityMeasureImpl();
		return ifcVaporPermeabilityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVolumeMeasure createIfcVolumeMeasure() {
		IfcVolumeMeasureImpl ifcVolumeMeasure = new IfcVolumeMeasureImpl();
		return ifcVolumeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVolumetricFlowRateMeasure createIfcVolumetricFlowRateMeasure() {
		IfcVolumetricFlowRateMeasureImpl ifcVolumetricFlowRateMeasure = new IfcVolumetricFlowRateMeasureImpl();
		return ifcVolumetricFlowRateMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWarpingConstantMeasure createIfcWarpingConstantMeasure() {
		IfcWarpingConstantMeasureImpl ifcWarpingConstantMeasure = new IfcWarpingConstantMeasureImpl();
		return ifcWarpingConstantMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWarpingMomentMeasure createIfcWarpingMomentMeasure() {
		IfcWarpingMomentMeasureImpl ifcWarpingMomentMeasure = new IfcWarpingMomentMeasureImpl();
		return ifcWarpingMomentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcYearNumber createIfcYearNumber() {
		IfcYearNumberImpl ifcYearNumber = new IfcYearNumberImpl();
		return ifcYearNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoxAlignment createIfcBoxAlignment() {
		IfcBoxAlignmentImpl ifcBoxAlignment = new IfcBoxAlignmentImpl();
		return ifcBoxAlignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCompoundPlaneAngleMeasure createIfcCompoundPlaneAngleMeasure() {
		IfcCompoundPlaneAngleMeasureImpl ifcCompoundPlaneAngleMeasure = new IfcCompoundPlaneAngleMeasureImpl();
		return ifcCompoundPlaneAngleMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcNormalisedRatioMeasure createIfcNormalisedRatioMeasure() {
		IfcNormalisedRatioMeasureImpl ifcNormalisedRatioMeasure = new IfcNormalisedRatioMeasureImpl();
		return ifcNormalisedRatioMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositiveLengthMeasure createIfcPositiveLengthMeasure() {
		IfcPositiveLengthMeasureImpl ifcPositiveLengthMeasure = new IfcPositiveLengthMeasureImpl();
		return ifcPositiveLengthMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositivePlaneAngleMeasure createIfcPositivePlaneAngleMeasure() {
		IfcPositivePlaneAngleMeasureImpl ifcPositivePlaneAngleMeasure = new IfcPositivePlaneAngleMeasureImpl();
		return ifcPositivePlaneAngleMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPositiveRatioMeasure createIfcPositiveRatioMeasure() {
		IfcPositiveRatioMeasureImpl ifcPositiveRatioMeasure = new IfcPositiveRatioMeasureImpl();
		return ifcPositiveRatioMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcComplexNumber createIfcComplexNumber() {
		IfcComplexNumberImpl ifcComplexNumber = new IfcComplexNumberImpl();
		return ifcComplexNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcNullStyle createIfcNullStyle() {
		IfcNullStyleImpl ifcNullStyle = new IfcNullStyleImpl();
		return ifcNullStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate createTristateFromString(EDataType eDataType, String initialValue) {
		Tristate result = Tristate.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTristateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActionSourceTypeEnum createIfcActionSourceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcActionSourceTypeEnum result = IfcActionSourceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcActionSourceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActionTypeEnum createIfcActionTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcActionTypeEnum result = IfcActionTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcActionTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActuatorTypeEnum createIfcActuatorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcActuatorTypeEnum result = IfcActuatorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcActuatorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAddressTypeEnum createIfcAddressTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcAddressTypeEnum result = IfcAddressTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAddressTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAheadOrBehind createIfcAheadOrBehindFromString(EDataType eDataType, String initialValue) {
		IfcAheadOrBehind result = IfcAheadOrBehind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAheadOrBehindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAirTerminalBoxTypeEnum createIfcAirTerminalBoxTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcAirTerminalBoxTypeEnum result = IfcAirTerminalBoxTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAirTerminalBoxTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAirTerminalTypeEnum createIfcAirTerminalTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcAirTerminalTypeEnum result = IfcAirTerminalTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAirTerminalTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAirToAirHeatRecoveryTypeEnum createIfcAirToAirHeatRecoveryTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcAirToAirHeatRecoveryTypeEnum result = IfcAirToAirHeatRecoveryTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAirToAirHeatRecoveryTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAlarmTypeEnum createIfcAlarmTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcAlarmTypeEnum result = IfcAlarmTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAlarmTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnalysisModelTypeEnum createIfcAnalysisModelTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcAnalysisModelTypeEnum result = IfcAnalysisModelTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAnalysisModelTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnalysisTheoryTypeEnum createIfcAnalysisTheoryTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcAnalysisTheoryTypeEnum result = IfcAnalysisTheoryTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAnalysisTheoryTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcArithmeticOperatorEnum createIfcArithmeticOperatorEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcArithmeticOperatorEnum result = IfcArithmeticOperatorEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcArithmeticOperatorEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAssemblyPlaceEnum createIfcAssemblyPlaceEnumFromString(EDataType eDataType, String initialValue) {
		IfcAssemblyPlaceEnum result = IfcAssemblyPlaceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAssemblyPlaceEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBSplineCurveForm createIfcBSplineCurveFormFromString(EDataType eDataType, String initialValue) {
		IfcBSplineCurveForm result = IfcBSplineCurveForm.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBSplineCurveFormToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBeamTypeEnum createIfcBeamTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcBeamTypeEnum result = IfcBeamTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBeamTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBenchmarkEnum createIfcBenchmarkEnumFromString(EDataType eDataType, String initialValue) {
		IfcBenchmarkEnum result = IfcBenchmarkEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBenchmarkEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBoilerTypeEnum createIfcBoilerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcBoilerTypeEnum result = IfcBoilerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBoilerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBooleanOperator createIfcBooleanOperatorFromString(EDataType eDataType, String initialValue) {
		IfcBooleanOperator result = IfcBooleanOperator.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBooleanOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElementProxyTypeEnum createIfcBuildingElementProxyTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcBuildingElementProxyTypeEnum result = IfcBuildingElementProxyTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBuildingElementProxyTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableCarrierFittingTypeEnum createIfcCableCarrierFittingTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcCableCarrierFittingTypeEnum result = IfcCableCarrierFittingTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCableCarrierFittingTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableCarrierSegmentTypeEnum createIfcCableCarrierSegmentTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcCableCarrierSegmentTypeEnum result = IfcCableCarrierSegmentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCableCarrierSegmentTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableSegmentTypeEnum createIfcCableSegmentTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCableSegmentTypeEnum result = IfcCableSegmentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCableSegmentTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcChangeActionEnum createIfcChangeActionEnumFromString(EDataType eDataType, String initialValue) {
		IfcChangeActionEnum result = IfcChangeActionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcChangeActionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcChillerTypeEnum createIfcChillerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcChillerTypeEnum result = IfcChillerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcChillerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCoilTypeEnum createIfcCoilTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCoilTypeEnum result = IfcCoilTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCoilTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColumnTypeEnum createIfcColumnTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcColumnTypeEnum result = IfcColumnTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcColumnTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCompressorTypeEnum createIfcCompressorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCompressorTypeEnum result = IfcCompressorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCompressorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCondenserTypeEnum createIfcCondenserTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCondenserTypeEnum result = IfcCondenserTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCondenserTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionTypeEnum createIfcConnectionTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcConnectionTypeEnum result = IfcConnectionTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcConnectionTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraintEnum createIfcConstraintEnumFromString(EDataType eDataType, String initialValue) {
		IfcConstraintEnum result = IfcConstraintEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcConstraintEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcControllerTypeEnum createIfcControllerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcControllerTypeEnum result = IfcControllerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcControllerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCooledBeamTypeEnum createIfcCooledBeamTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCooledBeamTypeEnum result = IfcCooledBeamTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCooledBeamTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCoolingTowerTypeEnum createIfcCoolingTowerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCoolingTowerTypeEnum result = IfcCoolingTowerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCoolingTowerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCostScheduleTypeEnum createIfcCostScheduleTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCostScheduleTypeEnum result = IfcCostScheduleTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCostScheduleTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCoveringTypeEnum createIfcCoveringTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCoveringTypeEnum result = IfcCoveringTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCoveringTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurrencyEnum createIfcCurrencyEnumFromString(EDataType eDataType, String initialValue) {
		IfcCurrencyEnum result = IfcCurrencyEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCurrencyEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurtainWallTypeEnum createIfcCurtainWallTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCurtainWallTypeEnum result = IfcCurtainWallTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCurtainWallTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDamperTypeEnum createIfcDamperTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcDamperTypeEnum result = IfcDamperTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDamperTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDataOriginEnum createIfcDataOriginEnumFromString(EDataType eDataType, String initialValue) {
		IfcDataOriginEnum result = IfcDataOriginEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDataOriginEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDerivedUnitEnum createIfcDerivedUnitEnumFromString(EDataType eDataType, String initialValue) {
		IfcDerivedUnitEnum result = IfcDerivedUnitEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDerivedUnitEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDimensionExtentUsage createIfcDimensionExtentUsageFromString(EDataType eDataType, String initialValue) {
		IfcDimensionExtentUsage result = IfcDimensionExtentUsage.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDimensionExtentUsageToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirectionSenseEnum createIfcDirectionSenseEnumFromString(EDataType eDataType, String initialValue) {
		IfcDirectionSenseEnum result = IfcDirectionSenseEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDirectionSenseEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionChamberElementTypeEnum createIfcDistributionChamberElementTypeEnumFromString(
			EDataType eDataType, String initialValue) {
		IfcDistributionChamberElementTypeEnum result = IfcDistributionChamberElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDistributionChamberElementTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentConfidentialityEnum createIfcDocumentConfidentialityEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcDocumentConfidentialityEnum result = IfcDocumentConfidentialityEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDocumentConfidentialityEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentStatusEnum createIfcDocumentStatusEnumFromString(EDataType eDataType, String initialValue) {
		IfcDocumentStatusEnum result = IfcDocumentStatusEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDocumentStatusEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoorPanelOperationEnum createIfcDoorPanelOperationEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcDoorPanelOperationEnum result = IfcDoorPanelOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDoorPanelOperationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoorPanelPositionEnum createIfcDoorPanelPositionEnumFromString(EDataType eDataType, String initialValue) {
		IfcDoorPanelPositionEnum result = IfcDoorPanelPositionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDoorPanelPositionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoorStyleConstructionEnum createIfcDoorStyleConstructionEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcDoorStyleConstructionEnum result = IfcDoorStyleConstructionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDoorStyleConstructionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoorStyleOperationEnum createIfcDoorStyleOperationEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcDoorStyleOperationEnum result = IfcDoorStyleOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDoorStyleOperationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDuctFittingTypeEnum createIfcDuctFittingTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcDuctFittingTypeEnum result = IfcDuctFittingTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDuctFittingTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDuctSegmentTypeEnum createIfcDuctSegmentTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcDuctSegmentTypeEnum result = IfcDuctSegmentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDuctSegmentTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDuctSilencerTypeEnum createIfcDuctSilencerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcDuctSilencerTypeEnum result = IfcDuctSilencerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDuctSilencerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricApplianceTypeEnum createIfcElectricApplianceTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcElectricApplianceTypeEnum result = IfcElectricApplianceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricApplianceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricCurrentEnum createIfcElectricCurrentEnumFromString(EDataType eDataType, String initialValue) {
		IfcElectricCurrentEnum result = IfcElectricCurrentEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricCurrentEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricDistributionPointFunctionEnum createIfcElectricDistributionPointFunctionEnumFromString(
			EDataType eDataType, String initialValue) {
		IfcElectricDistributionPointFunctionEnum result = IfcElectricDistributionPointFunctionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricDistributionPointFunctionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricFlowStorageDeviceTypeEnum createIfcElectricFlowStorageDeviceTypeEnumFromString(
			EDataType eDataType, String initialValue) {
		IfcElectricFlowStorageDeviceTypeEnum result = IfcElectricFlowStorageDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricFlowStorageDeviceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricGeneratorTypeEnum createIfcElectricGeneratorTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcElectricGeneratorTypeEnum result = IfcElectricGeneratorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricGeneratorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricHeaterTypeEnum createIfcElectricHeaterTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcElectricHeaterTypeEnum result = IfcElectricHeaterTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricHeaterTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricMotorTypeEnum createIfcElectricMotorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcElectricMotorTypeEnum result = IfcElectricMotorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricMotorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricTimeControlTypeEnum createIfcElectricTimeControlTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcElectricTimeControlTypeEnum result = IfcElectricTimeControlTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricTimeControlTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementAssemblyTypeEnum createIfcElementAssemblyTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcElementAssemblyTypeEnum result = IfcElementAssemblyTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElementAssemblyTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementCompositionEnum createIfcElementCompositionEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcElementCompositionEnum result = IfcElementCompositionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElementCompositionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnergySequenceEnum createIfcEnergySequenceEnumFromString(EDataType eDataType, String initialValue) {
		IfcEnergySequenceEnum result = IfcEnergySequenceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcEnergySequenceEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnvironmentalImpactCategoryEnum createIfcEnvironmentalImpactCategoryEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcEnvironmentalImpactCategoryEnum result = IfcEnvironmentalImpactCategoryEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcEnvironmentalImpactCategoryEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEvaporativeCoolerTypeEnum createIfcEvaporativeCoolerTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcEvaporativeCoolerTypeEnum result = IfcEvaporativeCoolerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcEvaporativeCoolerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEvaporatorTypeEnum createIfcEvaporatorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcEvaporatorTypeEnum result = IfcEvaporatorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcEvaporatorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFanTypeEnum createIfcFanTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcFanTypeEnum result = IfcFanTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFanTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFilterTypeEnum createIfcFilterTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcFilterTypeEnum result = IfcFilterTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFilterTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFireSuppressionTerminalTypeEnum createIfcFireSuppressionTerminalTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcFireSuppressionTerminalTypeEnum result = IfcFireSuppressionTerminalTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFireSuppressionTerminalTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowDirectionEnum createIfcFlowDirectionEnumFromString(EDataType eDataType, String initialValue) {
		IfcFlowDirectionEnum result = IfcFlowDirectionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFlowDirectionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowInstrumentTypeEnum createIfcFlowInstrumentTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcFlowInstrumentTypeEnum result = IfcFlowInstrumentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFlowInstrumentTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFlowMeterTypeEnum createIfcFlowMeterTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcFlowMeterTypeEnum result = IfcFlowMeterTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFlowMeterTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFootingTypeEnum createIfcFootingTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcFootingTypeEnum result = IfcFootingTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFootingTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGasTerminalTypeEnum createIfcGasTerminalTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcGasTerminalTypeEnum result = IfcGasTerminalTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcGasTerminalTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricProjectionEnum createIfcGeometricProjectionEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcGeometricProjectionEnum result = IfcGeometricProjectionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcGeometricProjectionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGlobalOrLocalEnum createIfcGlobalOrLocalEnumFromString(EDataType eDataType, String initialValue) {
		IfcGlobalOrLocalEnum result = IfcGlobalOrLocalEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcGlobalOrLocalEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHeatExchangerTypeEnum createIfcHeatExchangerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcHeatExchangerTypeEnum result = IfcHeatExchangerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcHeatExchangerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcHumidifierTypeEnum createIfcHumidifierTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcHumidifierTypeEnum result = IfcHumidifierTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcHumidifierTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInternalOrExternalEnum createIfcInternalOrExternalEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcInternalOrExternalEnum result = IfcInternalOrExternalEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcInternalOrExternalEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInventoryTypeEnum createIfcInventoryTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcInventoryTypeEnum result = IfcInventoryTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcInventoryTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcJunctionBoxTypeEnum createIfcJunctionBoxTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcJunctionBoxTypeEnum result = IfcJunctionBoxTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcJunctionBoxTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLampTypeEnum createIfcLampTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcLampTypeEnum result = IfcLampTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcLampTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLayerSetDirectionEnum createIfcLayerSetDirectionEnumFromString(EDataType eDataType, String initialValue) {
		IfcLayerSetDirectionEnum result = IfcLayerSetDirectionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcLayerSetDirectionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightDistributionCurveEnum createIfcLightDistributionCurveEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcLightDistributionCurveEnum result = IfcLightDistributionCurveEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcLightDistributionCurveEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightEmissionSourceEnum createIfcLightEmissionSourceEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcLightEmissionSourceEnum result = IfcLightEmissionSourceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcLightEmissionSourceEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightFixtureTypeEnum createIfcLightFixtureTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcLightFixtureTypeEnum result = IfcLightFixtureTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcLightFixtureTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLoadGroupTypeEnum createIfcLoadGroupTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcLoadGroupTypeEnum result = IfcLoadGroupTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcLoadGroupTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLogicalOperatorEnum createIfcLogicalOperatorEnumFromString(EDataType eDataType, String initialValue) {
		IfcLogicalOperatorEnum result = IfcLogicalOperatorEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcLogicalOperatorEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMemberTypeEnum createIfcMemberTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcMemberTypeEnum result = IfcMemberTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcMemberTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMotorConnectionTypeEnum createIfcMotorConnectionTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcMotorConnectionTypeEnum result = IfcMotorConnectionTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcMotorConnectionTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcNullStyleEnum createIfcNullStyleEnumFromString(EDataType eDataType, String initialValue) {
		IfcNullStyleEnum result = IfcNullStyleEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcNullStyleEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectTypeEnum createIfcObjectTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcObjectTypeEnum result = IfcObjectTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcObjectTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcObjectiveEnum createIfcObjectiveEnumFromString(EDataType eDataType, String initialValue) {
		IfcObjectiveEnum result = IfcObjectiveEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcObjectiveEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOccupantTypeEnum createIfcOccupantTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcOccupantTypeEnum result = IfcOccupantTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcOccupantTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcOutletTypeEnum createIfcOutletTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcOutletTypeEnum result = IfcOutletTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcOutletTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPermeableCoveringOperationEnum createIfcPermeableCoveringOperationEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcPermeableCoveringOperationEnum result = IfcPermeableCoveringOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPermeableCoveringOperationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPhysicalOrVirtualEnum createIfcPhysicalOrVirtualEnumFromString(EDataType eDataType, String initialValue) {
		IfcPhysicalOrVirtualEnum result = IfcPhysicalOrVirtualEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPhysicalOrVirtualEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPileConstructionEnum createIfcPileConstructionEnumFromString(EDataType eDataType, String initialValue) {
		IfcPileConstructionEnum result = IfcPileConstructionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPileConstructionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPileTypeEnum createIfcPileTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcPileTypeEnum result = IfcPileTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPileTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPipeFittingTypeEnum createIfcPipeFittingTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcPipeFittingTypeEnum result = IfcPipeFittingTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPipeFittingTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPipeSegmentTypeEnum createIfcPipeSegmentTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcPipeSegmentTypeEnum result = IfcPipeSegmentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPipeSegmentTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPlateTypeEnum createIfcPlateTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcPlateTypeEnum result = IfcPlateTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPlateTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcedureTypeEnum createIfcProcedureTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcProcedureTypeEnum result = IfcProcedureTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcProcedureTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProfileTypeEnum createIfcProfileTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcProfileTypeEnum result = IfcProfileTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcProfileTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectOrderRecordTypeEnum createIfcProjectOrderRecordTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcProjectOrderRecordTypeEnum result = IfcProjectOrderRecordTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcProjectOrderRecordTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectOrderTypeEnum createIfcProjectOrderTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcProjectOrderTypeEnum result = IfcProjectOrderTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcProjectOrderTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectedOrTrueLengthEnum createIfcProjectedOrTrueLengthEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcProjectedOrTrueLengthEnum result = IfcProjectedOrTrueLengthEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcProjectedOrTrueLengthEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertySourceEnum createIfcPropertySourceEnumFromString(EDataType eDataType, String initialValue) {
		IfcPropertySourceEnum result = IfcPropertySourceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPropertySourceEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProtectiveDeviceTypeEnum createIfcProtectiveDeviceTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcProtectiveDeviceTypeEnum result = IfcProtectiveDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcProtectiveDeviceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPumpTypeEnum createIfcPumpTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcPumpTypeEnum result = IfcPumpTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPumpTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRailingTypeEnum createIfcRailingTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcRailingTypeEnum result = IfcRailingTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcRailingTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRampFlightTypeEnum createIfcRampFlightTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcRampFlightTypeEnum result = IfcRampFlightTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcRampFlightTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRampTypeEnum createIfcRampTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcRampTypeEnum result = IfcRampTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcRampTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReflectanceMethodEnum createIfcReflectanceMethodEnumFromString(EDataType eDataType, String initialValue) {
		IfcReflectanceMethodEnum result = IfcReflectanceMethodEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcReflectanceMethodEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingBarRoleEnum createIfcReinforcingBarRoleEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcReinforcingBarRoleEnum result = IfcReinforcingBarRoleEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcReinforcingBarRoleEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingBarSurfaceEnum createIfcReinforcingBarSurfaceEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcReinforcingBarSurfaceEnum result = IfcReinforcingBarSurfaceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcReinforcingBarSurfaceEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcResourceConsumptionEnum createIfcResourceConsumptionEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcResourceConsumptionEnum result = IfcResourceConsumptionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcResourceConsumptionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRibPlateDirectionEnum createIfcRibPlateDirectionEnumFromString(EDataType eDataType, String initialValue) {
		IfcRibPlateDirectionEnum result = IfcRibPlateDirectionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcRibPlateDirectionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRoleEnum createIfcRoleEnumFromString(EDataType eDataType, String initialValue) {
		IfcRoleEnum result = IfcRoleEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcRoleEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRoofTypeEnum createIfcRoofTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcRoofTypeEnum result = IfcRoofTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcRoofTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSIPrefix createIfcSIPrefixFromString(EDataType eDataType, String initialValue) {
		IfcSIPrefix result = IfcSIPrefix.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSIPrefixToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSIUnitName createIfcSIUnitNameFromString(EDataType eDataType, String initialValue) {
		IfcSIUnitName result = IfcSIUnitName.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSIUnitNameToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSanitaryTerminalTypeEnum createIfcSanitaryTerminalTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcSanitaryTerminalTypeEnum result = IfcSanitaryTerminalTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSanitaryTerminalTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSectionTypeEnum createIfcSectionTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSectionTypeEnum result = IfcSectionTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSectionTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSensorTypeEnum createIfcSensorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSensorTypeEnum result = IfcSensorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSensorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSequenceEnum createIfcSequenceEnumFromString(EDataType eDataType, String initialValue) {
		IfcSequenceEnum result = IfcSequenceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSequenceEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcServiceLifeFactorTypeEnum createIfcServiceLifeFactorTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcServiceLifeFactorTypeEnum result = IfcServiceLifeFactorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcServiceLifeFactorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcServiceLifeTypeEnum createIfcServiceLifeTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcServiceLifeTypeEnum result = IfcServiceLifeTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcServiceLifeTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSlabTypeEnum createIfcSlabTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSlabTypeEnum result = IfcSlabTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSlabTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSoundScaleEnum createIfcSoundScaleEnumFromString(EDataType eDataType, String initialValue) {
		IfcSoundScaleEnum result = IfcSoundScaleEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSoundScaleEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpaceHeaterTypeEnum createIfcSpaceHeaterTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSpaceHeaterTypeEnum result = IfcSpaceHeaterTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSpaceHeaterTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpaceTypeEnum createIfcSpaceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSpaceTypeEnum result = IfcSpaceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSpaceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStackTerminalTypeEnum createIfcStackTerminalTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcStackTerminalTypeEnum result = IfcStackTerminalTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStackTerminalTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStairFlightTypeEnum createIfcStairFlightTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcStairFlightTypeEnum result = IfcStairFlightTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStairFlightTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStairTypeEnum createIfcStairTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcStairTypeEnum result = IfcStairTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStairTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStateEnum createIfcStateEnumFromString(EDataType eDataType, String initialValue) {
		IfcStateEnum result = IfcStateEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStateEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralCurveTypeEnum createIfcStructuralCurveTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcStructuralCurveTypeEnum result = IfcStructuralCurveTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStructuralCurveTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralSurfaceTypeEnum createIfcStructuralSurfaceTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcStructuralSurfaceTypeEnum result = IfcStructuralSurfaceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStructuralSurfaceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceSide createIfcSurfaceSideFromString(EDataType eDataType, String initialValue) {
		IfcSurfaceSide result = IfcSurfaceSide.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSurfaceSideToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceTextureEnum createIfcSurfaceTextureEnumFromString(EDataType eDataType, String initialValue) {
		IfcSurfaceTextureEnum result = IfcSurfaceTextureEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSurfaceTextureEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSwitchingDeviceTypeEnum createIfcSwitchingDeviceTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcSwitchingDeviceTypeEnum result = IfcSwitchingDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSwitchingDeviceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTankTypeEnum createIfcTankTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTankTypeEnum result = IfcTankTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTankTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTendonTypeEnum createIfcTendonTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTendonTypeEnum result = IfcTendonTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTendonTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextPath createIfcTextPathFromString(EDataType eDataType, String initialValue) {
		IfcTextPath result = IfcTextPath.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTextPathToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalLoadSourceEnum createIfcThermalLoadSourceEnumFromString(EDataType eDataType, String initialValue) {
		IfcThermalLoadSourceEnum result = IfcThermalLoadSourceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcThermalLoadSourceEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcThermalLoadTypeEnum createIfcThermalLoadTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcThermalLoadTypeEnum result = IfcThermalLoadTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcThermalLoadTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeriesDataTypeEnum createIfcTimeSeriesDataTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcTimeSeriesDataTypeEnum result = IfcTimeSeriesDataTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTimeSeriesDataTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeriesScheduleTypeEnum createIfcTimeSeriesScheduleTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcTimeSeriesScheduleTypeEnum result = IfcTimeSeriesScheduleTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTimeSeriesScheduleTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTransformerTypeEnum createIfcTransformerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTransformerTypeEnum result = IfcTransformerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTransformerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTransitionCode createIfcTransitionCodeFromString(EDataType eDataType, String initialValue) {
		IfcTransitionCode result = IfcTransitionCode.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTransitionCodeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTransportElementTypeEnum createIfcTransportElementTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcTransportElementTypeEnum result = IfcTransportElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTransportElementTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTrimmingPreference createIfcTrimmingPreferenceFromString(EDataType eDataType, String initialValue) {
		IfcTrimmingPreference result = IfcTrimmingPreference.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTrimmingPreferenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTubeBundleTypeEnum createIfcTubeBundleTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTubeBundleTypeEnum result = IfcTubeBundleTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTubeBundleTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnitEnum createIfcUnitEnumFromString(EDataType eDataType, String initialValue) {
		IfcUnitEnum result = IfcUnitEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcUnitEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnitaryEquipmentTypeEnum createIfcUnitaryEquipmentTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcUnitaryEquipmentTypeEnum result = IfcUnitaryEquipmentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcUnitaryEquipmentTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcValveTypeEnum createIfcValveTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcValveTypeEnum result = IfcValveTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcValveTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVibrationIsolatorTypeEnum createIfcVibrationIsolatorTypeEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcVibrationIsolatorTypeEnum result = IfcVibrationIsolatorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcVibrationIsolatorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWallTypeEnum createIfcWallTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcWallTypeEnum result = IfcWallTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWallTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWasteTerminalTypeEnum createIfcWasteTerminalTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcWasteTerminalTypeEnum result = IfcWasteTerminalTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWasteTerminalTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowPanelOperationEnum createIfcWindowPanelOperationEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcWindowPanelOperationEnum result = IfcWindowPanelOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWindowPanelOperationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowPanelPositionEnum createIfcWindowPanelPositionEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcWindowPanelPositionEnum result = IfcWindowPanelPositionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWindowPanelPositionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowStyleConstructionEnum createIfcWindowStyleConstructionEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcWindowStyleConstructionEnum result = IfcWindowStyleConstructionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWindowStyleConstructionEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowStyleOperationEnum createIfcWindowStyleOperationEnumFromString(EDataType eDataType,
			String initialValue) {
		IfcWindowStyleOperationEnum result = IfcWindowStyleOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWindowStyleOperationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkControlTypeEnum createIfcWorkControlTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcWorkControlTypeEnum result = IfcWorkControlTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWorkControlTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifc2x3tc1Package getIfc2x3tc1Package() {
		return (Ifc2x3tc1Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Ifc2x3tc1Package getPackage() {
		return Ifc2x3tc1Package.eINSTANCE;
	}

} //Ifc2x3tc1FactoryImpl
