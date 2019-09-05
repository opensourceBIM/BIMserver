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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.*;
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
public class Ifc4FactoryImpl extends EFactoryImpl implements Ifc4Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ifc4Factory init() {
		try {
			Ifc4Factory theIfc4Factory = (Ifc4Factory) EPackage.Registry.INSTANCE.getEFactory(Ifc4Package.eNS_URI);
			if (theIfc4Factory != null) {
				return theIfc4Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Ifc4FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifc4FactoryImpl() {
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
		case Ifc4Package.IFC_ACTION_REQUEST:
			return (EObject) createIfcActionRequest();
		case Ifc4Package.IFC_ACTOR:
			return (EObject) createIfcActor();
		case Ifc4Package.IFC_ACTOR_ROLE:
			return (EObject) createIfcActorRole();
		case Ifc4Package.IFC_ACTUATOR:
			return (EObject) createIfcActuator();
		case Ifc4Package.IFC_ACTUATOR_TYPE:
			return (EObject) createIfcActuatorType();
		case Ifc4Package.IFC_ADDRESS:
			return (EObject) createIfcAddress();
		case Ifc4Package.IFC_ADVANCED_BREP:
			return (EObject) createIfcAdvancedBrep();
		case Ifc4Package.IFC_ADVANCED_BREP_WITH_VOIDS:
			return (EObject) createIfcAdvancedBrepWithVoids();
		case Ifc4Package.IFC_ADVANCED_FACE:
			return (EObject) createIfcAdvancedFace();
		case Ifc4Package.IFC_AIR_TERMINAL:
			return (EObject) createIfcAirTerminal();
		case Ifc4Package.IFC_AIR_TERMINAL_BOX:
			return (EObject) createIfcAirTerminalBox();
		case Ifc4Package.IFC_AIR_TERMINAL_BOX_TYPE:
			return (EObject) createIfcAirTerminalBoxType();
		case Ifc4Package.IFC_AIR_TERMINAL_TYPE:
			return (EObject) createIfcAirTerminalType();
		case Ifc4Package.IFC_AIR_TO_AIR_HEAT_RECOVERY:
			return (EObject) createIfcAirToAirHeatRecovery();
		case Ifc4Package.IFC_AIR_TO_AIR_HEAT_RECOVERY_TYPE:
			return (EObject) createIfcAirToAirHeatRecoveryType();
		case Ifc4Package.IFC_ALARM:
			return (EObject) createIfcAlarm();
		case Ifc4Package.IFC_ALARM_TYPE:
			return (EObject) createIfcAlarmType();
		case Ifc4Package.IFC_ANNOTATION:
			return (EObject) createIfcAnnotation();
		case Ifc4Package.IFC_ANNOTATION_FILL_AREA:
			return (EObject) createIfcAnnotationFillArea();
		case Ifc4Package.IFC_APPLICATION:
			return (EObject) createIfcApplication();
		case Ifc4Package.IFC_APPLIED_VALUE:
			return (EObject) createIfcAppliedValue();
		case Ifc4Package.IFC_APPROVAL:
			return (EObject) createIfcApproval();
		case Ifc4Package.IFC_APPROVAL_RELATIONSHIP:
			return (EObject) createIfcApprovalRelationship();
		case Ifc4Package.IFC_ARBITRARY_CLOSED_PROFILE_DEF:
			return (EObject) createIfcArbitraryClosedProfileDef();
		case Ifc4Package.IFC_ARBITRARY_OPEN_PROFILE_DEF:
			return (EObject) createIfcArbitraryOpenProfileDef();
		case Ifc4Package.IFC_ARBITRARY_PROFILE_DEF_WITH_VOIDS:
			return (EObject) createIfcArbitraryProfileDefWithVoids();
		case Ifc4Package.IFC_ASSET:
			return (EObject) createIfcAsset();
		case Ifc4Package.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF:
			return (EObject) createIfcAsymmetricIShapeProfileDef();
		case Ifc4Package.IFC_AUDIO_VISUAL_APPLIANCE:
			return (EObject) createIfcAudioVisualAppliance();
		case Ifc4Package.IFC_AUDIO_VISUAL_APPLIANCE_TYPE:
			return (EObject) createIfcAudioVisualApplianceType();
		case Ifc4Package.IFC_AXIS1_PLACEMENT:
			return (EObject) createIfcAxis1Placement();
		case Ifc4Package.IFC_AXIS2_PLACEMENT2_D:
			return (EObject) createIfcAxis2Placement2D();
		case Ifc4Package.IFC_AXIS2_PLACEMENT3_D:
			return (EObject) createIfcAxis2Placement3D();
		case Ifc4Package.IFC_BSPLINE_CURVE:
			return (EObject) createIfcBSplineCurve();
		case Ifc4Package.IFC_BSPLINE_CURVE_WITH_KNOTS:
			return (EObject) createIfcBSplineCurveWithKnots();
		case Ifc4Package.IFC_BSPLINE_SURFACE:
			return (EObject) createIfcBSplineSurface();
		case Ifc4Package.IFC_BSPLINE_SURFACE_WITH_KNOTS:
			return (EObject) createIfcBSplineSurfaceWithKnots();
		case Ifc4Package.IFC_BEAM:
			return (EObject) createIfcBeam();
		case Ifc4Package.IFC_BEAM_STANDARD_CASE:
			return (EObject) createIfcBeamStandardCase();
		case Ifc4Package.IFC_BEAM_TYPE:
			return (EObject) createIfcBeamType();
		case Ifc4Package.IFC_BLOB_TEXTURE:
			return (EObject) createIfcBlobTexture();
		case Ifc4Package.IFC_BLOCK:
			return (EObject) createIfcBlock();
		case Ifc4Package.IFC_BOILER:
			return (EObject) createIfcBoiler();
		case Ifc4Package.IFC_BOILER_TYPE:
			return (EObject) createIfcBoilerType();
		case Ifc4Package.IFC_BOOLEAN_CLIPPING_RESULT:
			return (EObject) createIfcBooleanClippingResult();
		case Ifc4Package.IFC_BOOLEAN_RESULT:
			return (EObject) createIfcBooleanResult();
		case Ifc4Package.IFC_BOUNDARY_CONDITION:
			return (EObject) createIfcBoundaryCondition();
		case Ifc4Package.IFC_BOUNDARY_CURVE:
			return (EObject) createIfcBoundaryCurve();
		case Ifc4Package.IFC_BOUNDARY_EDGE_CONDITION:
			return (EObject) createIfcBoundaryEdgeCondition();
		case Ifc4Package.IFC_BOUNDARY_FACE_CONDITION:
			return (EObject) createIfcBoundaryFaceCondition();
		case Ifc4Package.IFC_BOUNDARY_NODE_CONDITION:
			return (EObject) createIfcBoundaryNodeCondition();
		case Ifc4Package.IFC_BOUNDARY_NODE_CONDITION_WARPING:
			return (EObject) createIfcBoundaryNodeConditionWarping();
		case Ifc4Package.IFC_BOUNDED_CURVE:
			return (EObject) createIfcBoundedCurve();
		case Ifc4Package.IFC_BOUNDED_SURFACE:
			return (EObject) createIfcBoundedSurface();
		case Ifc4Package.IFC_BOUNDING_BOX:
			return (EObject) createIfcBoundingBox();
		case Ifc4Package.IFC_BOXED_HALF_SPACE:
			return (EObject) createIfcBoxedHalfSpace();
		case Ifc4Package.IFC_BUILDING:
			return (EObject) createIfcBuilding();
		case Ifc4Package.IFC_BUILDING_ELEMENT:
			return (EObject) createIfcBuildingElement();
		case Ifc4Package.IFC_BUILDING_ELEMENT_PART:
			return (EObject) createIfcBuildingElementPart();
		case Ifc4Package.IFC_BUILDING_ELEMENT_PART_TYPE:
			return (EObject) createIfcBuildingElementPartType();
		case Ifc4Package.IFC_BUILDING_ELEMENT_PROXY:
			return (EObject) createIfcBuildingElementProxy();
		case Ifc4Package.IFC_BUILDING_ELEMENT_PROXY_TYPE:
			return (EObject) createIfcBuildingElementProxyType();
		case Ifc4Package.IFC_BUILDING_ELEMENT_TYPE:
			return (EObject) createIfcBuildingElementType();
		case Ifc4Package.IFC_BUILDING_STOREY:
			return (EObject) createIfcBuildingStorey();
		case Ifc4Package.IFC_BUILDING_SYSTEM:
			return (EObject) createIfcBuildingSystem();
		case Ifc4Package.IFC_BURNER:
			return (EObject) createIfcBurner();
		case Ifc4Package.IFC_BURNER_TYPE:
			return (EObject) createIfcBurnerType();
		case Ifc4Package.IFC_CSHAPE_PROFILE_DEF:
			return (EObject) createIfcCShapeProfileDef();
		case Ifc4Package.IFC_CABLE_CARRIER_FITTING:
			return (EObject) createIfcCableCarrierFitting();
		case Ifc4Package.IFC_CABLE_CARRIER_FITTING_TYPE:
			return (EObject) createIfcCableCarrierFittingType();
		case Ifc4Package.IFC_CABLE_CARRIER_SEGMENT:
			return (EObject) createIfcCableCarrierSegment();
		case Ifc4Package.IFC_CABLE_CARRIER_SEGMENT_TYPE:
			return (EObject) createIfcCableCarrierSegmentType();
		case Ifc4Package.IFC_CABLE_FITTING:
			return (EObject) createIfcCableFitting();
		case Ifc4Package.IFC_CABLE_FITTING_TYPE:
			return (EObject) createIfcCableFittingType();
		case Ifc4Package.IFC_CABLE_SEGMENT:
			return (EObject) createIfcCableSegment();
		case Ifc4Package.IFC_CABLE_SEGMENT_TYPE:
			return (EObject) createIfcCableSegmentType();
		case Ifc4Package.IFC_CARTESIAN_POINT:
			return (EObject) createIfcCartesianPoint();
		case Ifc4Package.IFC_CARTESIAN_POINT_LIST:
			return (EObject) createIfcCartesianPointList();
		case Ifc4Package.IFC_CARTESIAN_POINT_LIST2_D:
			return (EObject) createIfcCartesianPointList2D();
		case Ifc4Package.IFC_CARTESIAN_POINT_LIST3_D:
			return (EObject) createIfcCartesianPointList3D();
		case Ifc4Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR:
			return (EObject) createIfcCartesianTransformationOperator();
		case Ifc4Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_D:
			return (EObject) createIfcCartesianTransformationOperator2D();
		case Ifc4Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM:
			return (EObject) createIfcCartesianTransformationOperator2DnonUniform();
		case Ifc4Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR3_D:
			return (EObject) createIfcCartesianTransformationOperator3D();
		case Ifc4Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR3_DNON_UNIFORM:
			return (EObject) createIfcCartesianTransformationOperator3DnonUniform();
		case Ifc4Package.IFC_CENTER_LINE_PROFILE_DEF:
			return (EObject) createIfcCenterLineProfileDef();
		case Ifc4Package.IFC_CHILLER:
			return (EObject) createIfcChiller();
		case Ifc4Package.IFC_CHILLER_TYPE:
			return (EObject) createIfcChillerType();
		case Ifc4Package.IFC_CHIMNEY:
			return (EObject) createIfcChimney();
		case Ifc4Package.IFC_CHIMNEY_TYPE:
			return (EObject) createIfcChimneyType();
		case Ifc4Package.IFC_CIRCLE:
			return (EObject) createIfcCircle();
		case Ifc4Package.IFC_CIRCLE_HOLLOW_PROFILE_DEF:
			return (EObject) createIfcCircleHollowProfileDef();
		case Ifc4Package.IFC_CIRCLE_PROFILE_DEF:
			return (EObject) createIfcCircleProfileDef();
		case Ifc4Package.IFC_CIVIL_ELEMENT:
			return (EObject) createIfcCivilElement();
		case Ifc4Package.IFC_CIVIL_ELEMENT_TYPE:
			return (EObject) createIfcCivilElementType();
		case Ifc4Package.IFC_CLASSIFICATION:
			return (EObject) createIfcClassification();
		case Ifc4Package.IFC_CLASSIFICATION_REFERENCE:
			return (EObject) createIfcClassificationReference();
		case Ifc4Package.IFC_CLOSED_SHELL:
			return (EObject) createIfcClosedShell();
		case Ifc4Package.IFC_COIL:
			return (EObject) createIfcCoil();
		case Ifc4Package.IFC_COIL_TYPE:
			return (EObject) createIfcCoilType();
		case Ifc4Package.IFC_COLOUR_RGB:
			return (EObject) createIfcColourRgb();
		case Ifc4Package.IFC_COLOUR_RGB_LIST:
			return (EObject) createIfcColourRgbList();
		case Ifc4Package.IFC_COLOUR_SPECIFICATION:
			return (EObject) createIfcColourSpecification();
		case Ifc4Package.IFC_COLUMN:
			return (EObject) createIfcColumn();
		case Ifc4Package.IFC_COLUMN_STANDARD_CASE:
			return (EObject) createIfcColumnStandardCase();
		case Ifc4Package.IFC_COLUMN_TYPE:
			return (EObject) createIfcColumnType();
		case Ifc4Package.IFC_COMMUNICATIONS_APPLIANCE:
			return (EObject) createIfcCommunicationsAppliance();
		case Ifc4Package.IFC_COMMUNICATIONS_APPLIANCE_TYPE:
			return (EObject) createIfcCommunicationsApplianceType();
		case Ifc4Package.IFC_COMPLEX_PROPERTY:
			return (EObject) createIfcComplexProperty();
		case Ifc4Package.IFC_COMPLEX_PROPERTY_TEMPLATE:
			return (EObject) createIfcComplexPropertyTemplate();
		case Ifc4Package.IFC_COMPOSITE_CURVE:
			return (EObject) createIfcCompositeCurve();
		case Ifc4Package.IFC_COMPOSITE_CURVE_ON_SURFACE:
			return (EObject) createIfcCompositeCurveOnSurface();
		case Ifc4Package.IFC_COMPOSITE_CURVE_SEGMENT:
			return (EObject) createIfcCompositeCurveSegment();
		case Ifc4Package.IFC_COMPOSITE_PROFILE_DEF:
			return (EObject) createIfcCompositeProfileDef();
		case Ifc4Package.IFC_COMPRESSOR:
			return (EObject) createIfcCompressor();
		case Ifc4Package.IFC_COMPRESSOR_TYPE:
			return (EObject) createIfcCompressorType();
		case Ifc4Package.IFC_CONDENSER:
			return (EObject) createIfcCondenser();
		case Ifc4Package.IFC_CONDENSER_TYPE:
			return (EObject) createIfcCondenserType();
		case Ifc4Package.IFC_CONIC:
			return (EObject) createIfcConic();
		case Ifc4Package.IFC_CONNECTED_FACE_SET:
			return (EObject) createIfcConnectedFaceSet();
		case Ifc4Package.IFC_CONNECTION_CURVE_GEOMETRY:
			return (EObject) createIfcConnectionCurveGeometry();
		case Ifc4Package.IFC_CONNECTION_GEOMETRY:
			return (EObject) createIfcConnectionGeometry();
		case Ifc4Package.IFC_CONNECTION_POINT_ECCENTRICITY:
			return (EObject) createIfcConnectionPointEccentricity();
		case Ifc4Package.IFC_CONNECTION_POINT_GEOMETRY:
			return (EObject) createIfcConnectionPointGeometry();
		case Ifc4Package.IFC_CONNECTION_SURFACE_GEOMETRY:
			return (EObject) createIfcConnectionSurfaceGeometry();
		case Ifc4Package.IFC_CONNECTION_VOLUME_GEOMETRY:
			return (EObject) createIfcConnectionVolumeGeometry();
		case Ifc4Package.IFC_CONSTRAINT:
			return (EObject) createIfcConstraint();
		case Ifc4Package.IFC_CONSTRUCTION_EQUIPMENT_RESOURCE:
			return (EObject) createIfcConstructionEquipmentResource();
		case Ifc4Package.IFC_CONSTRUCTION_EQUIPMENT_RESOURCE_TYPE:
			return (EObject) createIfcConstructionEquipmentResourceType();
		case Ifc4Package.IFC_CONSTRUCTION_MATERIAL_RESOURCE:
			return (EObject) createIfcConstructionMaterialResource();
		case Ifc4Package.IFC_CONSTRUCTION_MATERIAL_RESOURCE_TYPE:
			return (EObject) createIfcConstructionMaterialResourceType();
		case Ifc4Package.IFC_CONSTRUCTION_PRODUCT_RESOURCE:
			return (EObject) createIfcConstructionProductResource();
		case Ifc4Package.IFC_CONSTRUCTION_PRODUCT_RESOURCE_TYPE:
			return (EObject) createIfcConstructionProductResourceType();
		case Ifc4Package.IFC_CONSTRUCTION_RESOURCE:
			return (EObject) createIfcConstructionResource();
		case Ifc4Package.IFC_CONSTRUCTION_RESOURCE_TYPE:
			return (EObject) createIfcConstructionResourceType();
		case Ifc4Package.IFC_CONTEXT:
			return (EObject) createIfcContext();
		case Ifc4Package.IFC_CONTEXT_DEPENDENT_UNIT:
			return (EObject) createIfcContextDependentUnit();
		case Ifc4Package.IFC_CONTROL:
			return (EObject) createIfcControl();
		case Ifc4Package.IFC_CONTROLLER:
			return (EObject) createIfcController();
		case Ifc4Package.IFC_CONTROLLER_TYPE:
			return (EObject) createIfcControllerType();
		case Ifc4Package.IFC_CONVERSION_BASED_UNIT:
			return (EObject) createIfcConversionBasedUnit();
		case Ifc4Package.IFC_CONVERSION_BASED_UNIT_WITH_OFFSET:
			return (EObject) createIfcConversionBasedUnitWithOffset();
		case Ifc4Package.IFC_COOLED_BEAM:
			return (EObject) createIfcCooledBeam();
		case Ifc4Package.IFC_COOLED_BEAM_TYPE:
			return (EObject) createIfcCooledBeamType();
		case Ifc4Package.IFC_COOLING_TOWER:
			return (EObject) createIfcCoolingTower();
		case Ifc4Package.IFC_COOLING_TOWER_TYPE:
			return (EObject) createIfcCoolingTowerType();
		case Ifc4Package.IFC_COORDINATE_OPERATION:
			return (EObject) createIfcCoordinateOperation();
		case Ifc4Package.IFC_COORDINATE_REFERENCE_SYSTEM:
			return (EObject) createIfcCoordinateReferenceSystem();
		case Ifc4Package.IFC_COST_ITEM:
			return (EObject) createIfcCostItem();
		case Ifc4Package.IFC_COST_SCHEDULE:
			return (EObject) createIfcCostSchedule();
		case Ifc4Package.IFC_COST_VALUE:
			return (EObject) createIfcCostValue();
		case Ifc4Package.IFC_COVERING:
			return (EObject) createIfcCovering();
		case Ifc4Package.IFC_COVERING_TYPE:
			return (EObject) createIfcCoveringType();
		case Ifc4Package.IFC_CREW_RESOURCE:
			return (EObject) createIfcCrewResource();
		case Ifc4Package.IFC_CREW_RESOURCE_TYPE:
			return (EObject) createIfcCrewResourceType();
		case Ifc4Package.IFC_CSG_PRIMITIVE3_D:
			return (EObject) createIfcCsgPrimitive3D();
		case Ifc4Package.IFC_CSG_SOLID:
			return (EObject) createIfcCsgSolid();
		case Ifc4Package.IFC_CURRENCY_RELATIONSHIP:
			return (EObject) createIfcCurrencyRelationship();
		case Ifc4Package.IFC_CURTAIN_WALL:
			return (EObject) createIfcCurtainWall();
		case Ifc4Package.IFC_CURTAIN_WALL_TYPE:
			return (EObject) createIfcCurtainWallType();
		case Ifc4Package.IFC_CURVE:
			return (EObject) createIfcCurve();
		case Ifc4Package.IFC_CURVE_BOUNDED_PLANE:
			return (EObject) createIfcCurveBoundedPlane();
		case Ifc4Package.IFC_CURVE_BOUNDED_SURFACE:
			return (EObject) createIfcCurveBoundedSurface();
		case Ifc4Package.IFC_CURVE_STYLE:
			return (EObject) createIfcCurveStyle();
		case Ifc4Package.IFC_CURVE_STYLE_FONT:
			return (EObject) createIfcCurveStyleFont();
		case Ifc4Package.IFC_CURVE_STYLE_FONT_AND_SCALING:
			return (EObject) createIfcCurveStyleFontAndScaling();
		case Ifc4Package.IFC_CURVE_STYLE_FONT_PATTERN:
			return (EObject) createIfcCurveStyleFontPattern();
		case Ifc4Package.IFC_CYLINDRICAL_SURFACE:
			return (EObject) createIfcCylindricalSurface();
		case Ifc4Package.IFC_DAMPER:
			return (EObject) createIfcDamper();
		case Ifc4Package.IFC_DAMPER_TYPE:
			return (EObject) createIfcDamperType();
		case Ifc4Package.IFC_DERIVED_PROFILE_DEF:
			return (EObject) createIfcDerivedProfileDef();
		case Ifc4Package.IFC_DERIVED_UNIT:
			return (EObject) createIfcDerivedUnit();
		case Ifc4Package.IFC_DERIVED_UNIT_ELEMENT:
			return (EObject) createIfcDerivedUnitElement();
		case Ifc4Package.IFC_DIMENSIONAL_EXPONENTS:
			return (EObject) createIfcDimensionalExponents();
		case Ifc4Package.IFC_DIRECTION:
			return (EObject) createIfcDirection();
		case Ifc4Package.IFC_DISCRETE_ACCESSORY:
			return (EObject) createIfcDiscreteAccessory();
		case Ifc4Package.IFC_DISCRETE_ACCESSORY_TYPE:
			return (EObject) createIfcDiscreteAccessoryType();
		case Ifc4Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT:
			return (EObject) createIfcDistributionChamberElement();
		case Ifc4Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT_TYPE:
			return (EObject) createIfcDistributionChamberElementType();
		case Ifc4Package.IFC_DISTRIBUTION_CIRCUIT:
			return (EObject) createIfcDistributionCircuit();
		case Ifc4Package.IFC_DISTRIBUTION_CONTROL_ELEMENT:
			return (EObject) createIfcDistributionControlElement();
		case Ifc4Package.IFC_DISTRIBUTION_CONTROL_ELEMENT_TYPE:
			return (EObject) createIfcDistributionControlElementType();
		case Ifc4Package.IFC_DISTRIBUTION_ELEMENT:
			return (EObject) createIfcDistributionElement();
		case Ifc4Package.IFC_DISTRIBUTION_ELEMENT_TYPE:
			return (EObject) createIfcDistributionElementType();
		case Ifc4Package.IFC_DISTRIBUTION_FLOW_ELEMENT:
			return (EObject) createIfcDistributionFlowElement();
		case Ifc4Package.IFC_DISTRIBUTION_FLOW_ELEMENT_TYPE:
			return (EObject) createIfcDistributionFlowElementType();
		case Ifc4Package.IFC_DISTRIBUTION_PORT:
			return (EObject) createIfcDistributionPort();
		case Ifc4Package.IFC_DISTRIBUTION_SYSTEM:
			return (EObject) createIfcDistributionSystem();
		case Ifc4Package.IFC_DOCUMENT_INFORMATION:
			return (EObject) createIfcDocumentInformation();
		case Ifc4Package.IFC_DOCUMENT_INFORMATION_RELATIONSHIP:
			return (EObject) createIfcDocumentInformationRelationship();
		case Ifc4Package.IFC_DOCUMENT_REFERENCE:
			return (EObject) createIfcDocumentReference();
		case Ifc4Package.IFC_DOOR:
			return (EObject) createIfcDoor();
		case Ifc4Package.IFC_DOOR_LINING_PROPERTIES:
			return (EObject) createIfcDoorLiningProperties();
		case Ifc4Package.IFC_DOOR_PANEL_PROPERTIES:
			return (EObject) createIfcDoorPanelProperties();
		case Ifc4Package.IFC_DOOR_STANDARD_CASE:
			return (EObject) createIfcDoorStandardCase();
		case Ifc4Package.IFC_DOOR_STYLE:
			return (EObject) createIfcDoorStyle();
		case Ifc4Package.IFC_DOOR_TYPE:
			return (EObject) createIfcDoorType();
		case Ifc4Package.IFC_DRAUGHTING_PRE_DEFINED_COLOUR:
			return (EObject) createIfcDraughtingPreDefinedColour();
		case Ifc4Package.IFC_DRAUGHTING_PRE_DEFINED_CURVE_FONT:
			return (EObject) createIfcDraughtingPreDefinedCurveFont();
		case Ifc4Package.IFC_DUCT_FITTING:
			return (EObject) createIfcDuctFitting();
		case Ifc4Package.IFC_DUCT_FITTING_TYPE:
			return (EObject) createIfcDuctFittingType();
		case Ifc4Package.IFC_DUCT_SEGMENT:
			return (EObject) createIfcDuctSegment();
		case Ifc4Package.IFC_DUCT_SEGMENT_TYPE:
			return (EObject) createIfcDuctSegmentType();
		case Ifc4Package.IFC_DUCT_SILENCER:
			return (EObject) createIfcDuctSilencer();
		case Ifc4Package.IFC_DUCT_SILENCER_TYPE:
			return (EObject) createIfcDuctSilencerType();
		case Ifc4Package.IFC_EDGE:
			return (EObject) createIfcEdge();
		case Ifc4Package.IFC_EDGE_CURVE:
			return (EObject) createIfcEdgeCurve();
		case Ifc4Package.IFC_EDGE_LOOP:
			return (EObject) createIfcEdgeLoop();
		case Ifc4Package.IFC_ELECTRIC_APPLIANCE:
			return (EObject) createIfcElectricAppliance();
		case Ifc4Package.IFC_ELECTRIC_APPLIANCE_TYPE:
			return (EObject) createIfcElectricApplianceType();
		case Ifc4Package.IFC_ELECTRIC_DISTRIBUTION_BOARD:
			return (EObject) createIfcElectricDistributionBoard();
		case Ifc4Package.IFC_ELECTRIC_DISTRIBUTION_BOARD_TYPE:
			return (EObject) createIfcElectricDistributionBoardType();
		case Ifc4Package.IFC_ELECTRIC_FLOW_STORAGE_DEVICE:
			return (EObject) createIfcElectricFlowStorageDevice();
		case Ifc4Package.IFC_ELECTRIC_FLOW_STORAGE_DEVICE_TYPE:
			return (EObject) createIfcElectricFlowStorageDeviceType();
		case Ifc4Package.IFC_ELECTRIC_GENERATOR:
			return (EObject) createIfcElectricGenerator();
		case Ifc4Package.IFC_ELECTRIC_GENERATOR_TYPE:
			return (EObject) createIfcElectricGeneratorType();
		case Ifc4Package.IFC_ELECTRIC_MOTOR:
			return (EObject) createIfcElectricMotor();
		case Ifc4Package.IFC_ELECTRIC_MOTOR_TYPE:
			return (EObject) createIfcElectricMotorType();
		case Ifc4Package.IFC_ELECTRIC_TIME_CONTROL:
			return (EObject) createIfcElectricTimeControl();
		case Ifc4Package.IFC_ELECTRIC_TIME_CONTROL_TYPE:
			return (EObject) createIfcElectricTimeControlType();
		case Ifc4Package.IFC_ELEMENT:
			return (EObject) createIfcElement();
		case Ifc4Package.IFC_ELEMENT_ASSEMBLY:
			return (EObject) createIfcElementAssembly();
		case Ifc4Package.IFC_ELEMENT_ASSEMBLY_TYPE:
			return (EObject) createIfcElementAssemblyType();
		case Ifc4Package.IFC_ELEMENT_COMPONENT:
			return (EObject) createIfcElementComponent();
		case Ifc4Package.IFC_ELEMENT_COMPONENT_TYPE:
			return (EObject) createIfcElementComponentType();
		case Ifc4Package.IFC_ELEMENT_QUANTITY:
			return (EObject) createIfcElementQuantity();
		case Ifc4Package.IFC_ELEMENT_TYPE:
			return (EObject) createIfcElementType();
		case Ifc4Package.IFC_ELEMENTARY_SURFACE:
			return (EObject) createIfcElementarySurface();
		case Ifc4Package.IFC_ELLIPSE:
			return (EObject) createIfcEllipse();
		case Ifc4Package.IFC_ELLIPSE_PROFILE_DEF:
			return (EObject) createIfcEllipseProfileDef();
		case Ifc4Package.IFC_ENERGY_CONVERSION_DEVICE:
			return (EObject) createIfcEnergyConversionDevice();
		case Ifc4Package.IFC_ENERGY_CONVERSION_DEVICE_TYPE:
			return (EObject) createIfcEnergyConversionDeviceType();
		case Ifc4Package.IFC_ENGINE:
			return (EObject) createIfcEngine();
		case Ifc4Package.IFC_ENGINE_TYPE:
			return (EObject) createIfcEngineType();
		case Ifc4Package.IFC_EVAPORATIVE_COOLER:
			return (EObject) createIfcEvaporativeCooler();
		case Ifc4Package.IFC_EVAPORATIVE_COOLER_TYPE:
			return (EObject) createIfcEvaporativeCoolerType();
		case Ifc4Package.IFC_EVAPORATOR:
			return (EObject) createIfcEvaporator();
		case Ifc4Package.IFC_EVAPORATOR_TYPE:
			return (EObject) createIfcEvaporatorType();
		case Ifc4Package.IFC_EVENT:
			return (EObject) createIfcEvent();
		case Ifc4Package.IFC_EVENT_TIME:
			return (EObject) createIfcEventTime();
		case Ifc4Package.IFC_EVENT_TYPE:
			return (EObject) createIfcEventType();
		case Ifc4Package.IFC_EXTENDED_PROPERTIES:
			return (EObject) createIfcExtendedProperties();
		case Ifc4Package.IFC_EXTERNAL_INFORMATION:
			return (EObject) createIfcExternalInformation();
		case Ifc4Package.IFC_EXTERNAL_REFERENCE:
			return (EObject) createIfcExternalReference();
		case Ifc4Package.IFC_EXTERNAL_REFERENCE_RELATIONSHIP:
			return (EObject) createIfcExternalReferenceRelationship();
		case Ifc4Package.IFC_EXTERNAL_SPATIAL_ELEMENT:
			return (EObject) createIfcExternalSpatialElement();
		case Ifc4Package.IFC_EXTERNAL_SPATIAL_STRUCTURE_ELEMENT:
			return (EObject) createIfcExternalSpatialStructureElement();
		case Ifc4Package.IFC_EXTERNALLY_DEFINED_HATCH_STYLE:
			return (EObject) createIfcExternallyDefinedHatchStyle();
		case Ifc4Package.IFC_EXTERNALLY_DEFINED_SURFACE_STYLE:
			return (EObject) createIfcExternallyDefinedSurfaceStyle();
		case Ifc4Package.IFC_EXTERNALLY_DEFINED_TEXT_FONT:
			return (EObject) createIfcExternallyDefinedTextFont();
		case Ifc4Package.IFC_EXTRUDED_AREA_SOLID:
			return (EObject) createIfcExtrudedAreaSolid();
		case Ifc4Package.IFC_EXTRUDED_AREA_SOLID_TAPERED:
			return (EObject) createIfcExtrudedAreaSolidTapered();
		case Ifc4Package.IFC_FACE:
			return (EObject) createIfcFace();
		case Ifc4Package.IFC_FACE_BASED_SURFACE_MODEL:
			return (EObject) createIfcFaceBasedSurfaceModel();
		case Ifc4Package.IFC_FACE_BOUND:
			return (EObject) createIfcFaceBound();
		case Ifc4Package.IFC_FACE_OUTER_BOUND:
			return (EObject) createIfcFaceOuterBound();
		case Ifc4Package.IFC_FACE_SURFACE:
			return (EObject) createIfcFaceSurface();
		case Ifc4Package.IFC_FACETED_BREP:
			return (EObject) createIfcFacetedBrep();
		case Ifc4Package.IFC_FACETED_BREP_WITH_VOIDS:
			return (EObject) createIfcFacetedBrepWithVoids();
		case Ifc4Package.IFC_FAILURE_CONNECTION_CONDITION:
			return (EObject) createIfcFailureConnectionCondition();
		case Ifc4Package.IFC_FAN:
			return (EObject) createIfcFan();
		case Ifc4Package.IFC_FAN_TYPE:
			return (EObject) createIfcFanType();
		case Ifc4Package.IFC_FASTENER:
			return (EObject) createIfcFastener();
		case Ifc4Package.IFC_FASTENER_TYPE:
			return (EObject) createIfcFastenerType();
		case Ifc4Package.IFC_FEATURE_ELEMENT:
			return (EObject) createIfcFeatureElement();
		case Ifc4Package.IFC_FEATURE_ELEMENT_ADDITION:
			return (EObject) createIfcFeatureElementAddition();
		case Ifc4Package.IFC_FEATURE_ELEMENT_SUBTRACTION:
			return (EObject) createIfcFeatureElementSubtraction();
		case Ifc4Package.IFC_FILL_AREA_STYLE:
			return (EObject) createIfcFillAreaStyle();
		case Ifc4Package.IFC_FILL_AREA_STYLE_HATCHING:
			return (EObject) createIfcFillAreaStyleHatching();
		case Ifc4Package.IFC_FILL_AREA_STYLE_TILES:
			return (EObject) createIfcFillAreaStyleTiles();
		case Ifc4Package.IFC_FILTER:
			return (EObject) createIfcFilter();
		case Ifc4Package.IFC_FILTER_TYPE:
			return (EObject) createIfcFilterType();
		case Ifc4Package.IFC_FIRE_SUPPRESSION_TERMINAL:
			return (EObject) createIfcFireSuppressionTerminal();
		case Ifc4Package.IFC_FIRE_SUPPRESSION_TERMINAL_TYPE:
			return (EObject) createIfcFireSuppressionTerminalType();
		case Ifc4Package.IFC_FIXED_REFERENCE_SWEPT_AREA_SOLID:
			return (EObject) createIfcFixedReferenceSweptAreaSolid();
		case Ifc4Package.IFC_FLOW_CONTROLLER:
			return (EObject) createIfcFlowController();
		case Ifc4Package.IFC_FLOW_CONTROLLER_TYPE:
			return (EObject) createIfcFlowControllerType();
		case Ifc4Package.IFC_FLOW_FITTING:
			return (EObject) createIfcFlowFitting();
		case Ifc4Package.IFC_FLOW_FITTING_TYPE:
			return (EObject) createIfcFlowFittingType();
		case Ifc4Package.IFC_FLOW_INSTRUMENT:
			return (EObject) createIfcFlowInstrument();
		case Ifc4Package.IFC_FLOW_INSTRUMENT_TYPE:
			return (EObject) createIfcFlowInstrumentType();
		case Ifc4Package.IFC_FLOW_METER:
			return (EObject) createIfcFlowMeter();
		case Ifc4Package.IFC_FLOW_METER_TYPE:
			return (EObject) createIfcFlowMeterType();
		case Ifc4Package.IFC_FLOW_MOVING_DEVICE:
			return (EObject) createIfcFlowMovingDevice();
		case Ifc4Package.IFC_FLOW_MOVING_DEVICE_TYPE:
			return (EObject) createIfcFlowMovingDeviceType();
		case Ifc4Package.IFC_FLOW_SEGMENT:
			return (EObject) createIfcFlowSegment();
		case Ifc4Package.IFC_FLOW_SEGMENT_TYPE:
			return (EObject) createIfcFlowSegmentType();
		case Ifc4Package.IFC_FLOW_STORAGE_DEVICE:
			return (EObject) createIfcFlowStorageDevice();
		case Ifc4Package.IFC_FLOW_STORAGE_DEVICE_TYPE:
			return (EObject) createIfcFlowStorageDeviceType();
		case Ifc4Package.IFC_FLOW_TERMINAL:
			return (EObject) createIfcFlowTerminal();
		case Ifc4Package.IFC_FLOW_TERMINAL_TYPE:
			return (EObject) createIfcFlowTerminalType();
		case Ifc4Package.IFC_FLOW_TREATMENT_DEVICE:
			return (EObject) createIfcFlowTreatmentDevice();
		case Ifc4Package.IFC_FLOW_TREATMENT_DEVICE_TYPE:
			return (EObject) createIfcFlowTreatmentDeviceType();
		case Ifc4Package.IFC_FOOTING:
			return (EObject) createIfcFooting();
		case Ifc4Package.IFC_FOOTING_TYPE:
			return (EObject) createIfcFootingType();
		case Ifc4Package.IFC_FURNISHING_ELEMENT:
			return (EObject) createIfcFurnishingElement();
		case Ifc4Package.IFC_FURNISHING_ELEMENT_TYPE:
			return (EObject) createIfcFurnishingElementType();
		case Ifc4Package.IFC_FURNITURE:
			return (EObject) createIfcFurniture();
		case Ifc4Package.IFC_FURNITURE_TYPE:
			return (EObject) createIfcFurnitureType();
		case Ifc4Package.IFC_GEOGRAPHIC_ELEMENT:
			return (EObject) createIfcGeographicElement();
		case Ifc4Package.IFC_GEOGRAPHIC_ELEMENT_TYPE:
			return (EObject) createIfcGeographicElementType();
		case Ifc4Package.IFC_GEOMETRIC_CURVE_SET:
			return (EObject) createIfcGeometricCurveSet();
		case Ifc4Package.IFC_GEOMETRIC_REPRESENTATION_CONTEXT:
			return (EObject) createIfcGeometricRepresentationContext();
		case Ifc4Package.IFC_GEOMETRIC_REPRESENTATION_ITEM:
			return (EObject) createIfcGeometricRepresentationItem();
		case Ifc4Package.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT:
			return (EObject) createIfcGeometricRepresentationSubContext();
		case Ifc4Package.IFC_GEOMETRIC_SET:
			return (EObject) createIfcGeometricSet();
		case Ifc4Package.IFC_GRID:
			return (EObject) createIfcGrid();
		case Ifc4Package.IFC_GRID_AXIS:
			return (EObject) createIfcGridAxis();
		case Ifc4Package.IFC_GRID_PLACEMENT:
			return (EObject) createIfcGridPlacement();
		case Ifc4Package.IFC_GROUP:
			return (EObject) createIfcGroup();
		case Ifc4Package.IFC_HALF_SPACE_SOLID:
			return (EObject) createIfcHalfSpaceSolid();
		case Ifc4Package.IFC_HEAT_EXCHANGER:
			return (EObject) createIfcHeatExchanger();
		case Ifc4Package.IFC_HEAT_EXCHANGER_TYPE:
			return (EObject) createIfcHeatExchangerType();
		case Ifc4Package.IFC_HUMIDIFIER:
			return (EObject) createIfcHumidifier();
		case Ifc4Package.IFC_HUMIDIFIER_TYPE:
			return (EObject) createIfcHumidifierType();
		case Ifc4Package.IFC_ISHAPE_PROFILE_DEF:
			return (EObject) createIfcIShapeProfileDef();
		case Ifc4Package.IFC_IMAGE_TEXTURE:
			return (EObject) createIfcImageTexture();
		case Ifc4Package.IFC_INDEXED_COLOUR_MAP:
			return (EObject) createIfcIndexedColourMap();
		case Ifc4Package.IFC_INDEXED_POLY_CURVE:
			return (EObject) createIfcIndexedPolyCurve();
		case Ifc4Package.IFC_INDEXED_POLYGONAL_FACE:
			return (EObject) createIfcIndexedPolygonalFace();
		case Ifc4Package.IFC_INDEXED_POLYGONAL_FACE_WITH_VOIDS:
			return (EObject) createIfcIndexedPolygonalFaceWithVoids();
		case Ifc4Package.IFC_INDEXED_TEXTURE_MAP:
			return (EObject) createIfcIndexedTextureMap();
		case Ifc4Package.IFC_INDEXED_TRIANGLE_TEXTURE_MAP:
			return (EObject) createIfcIndexedTriangleTextureMap();
		case Ifc4Package.IFC_INTERCEPTOR:
			return (EObject) createIfcInterceptor();
		case Ifc4Package.IFC_INTERCEPTOR_TYPE:
			return (EObject) createIfcInterceptorType();
		case Ifc4Package.IFC_INTERSECTION_CURVE:
			return (EObject) createIfcIntersectionCurve();
		case Ifc4Package.IFC_INVENTORY:
			return (EObject) createIfcInventory();
		case Ifc4Package.IFC_IRREGULAR_TIME_SERIES:
			return (EObject) createIfcIrregularTimeSeries();
		case Ifc4Package.IFC_IRREGULAR_TIME_SERIES_VALUE:
			return (EObject) createIfcIrregularTimeSeriesValue();
		case Ifc4Package.IFC_JUNCTION_BOX:
			return (EObject) createIfcJunctionBox();
		case Ifc4Package.IFC_JUNCTION_BOX_TYPE:
			return (EObject) createIfcJunctionBoxType();
		case Ifc4Package.IFC_LSHAPE_PROFILE_DEF:
			return (EObject) createIfcLShapeProfileDef();
		case Ifc4Package.IFC_LABOR_RESOURCE:
			return (EObject) createIfcLaborResource();
		case Ifc4Package.IFC_LABOR_RESOURCE_TYPE:
			return (EObject) createIfcLaborResourceType();
		case Ifc4Package.IFC_LAG_TIME:
			return (EObject) createIfcLagTime();
		case Ifc4Package.IFC_LAMP:
			return (EObject) createIfcLamp();
		case Ifc4Package.IFC_LAMP_TYPE:
			return (EObject) createIfcLampType();
		case Ifc4Package.IFC_LIBRARY_INFORMATION:
			return (EObject) createIfcLibraryInformation();
		case Ifc4Package.IFC_LIBRARY_REFERENCE:
			return (EObject) createIfcLibraryReference();
		case Ifc4Package.IFC_LIGHT_DISTRIBUTION_DATA:
			return (EObject) createIfcLightDistributionData();
		case Ifc4Package.IFC_LIGHT_FIXTURE:
			return (EObject) createIfcLightFixture();
		case Ifc4Package.IFC_LIGHT_FIXTURE_TYPE:
			return (EObject) createIfcLightFixtureType();
		case Ifc4Package.IFC_LIGHT_INTENSITY_DISTRIBUTION:
			return (EObject) createIfcLightIntensityDistribution();
		case Ifc4Package.IFC_LIGHT_SOURCE:
			return (EObject) createIfcLightSource();
		case Ifc4Package.IFC_LIGHT_SOURCE_AMBIENT:
			return (EObject) createIfcLightSourceAmbient();
		case Ifc4Package.IFC_LIGHT_SOURCE_DIRECTIONAL:
			return (EObject) createIfcLightSourceDirectional();
		case Ifc4Package.IFC_LIGHT_SOURCE_GONIOMETRIC:
			return (EObject) createIfcLightSourceGoniometric();
		case Ifc4Package.IFC_LIGHT_SOURCE_POSITIONAL:
			return (EObject) createIfcLightSourcePositional();
		case Ifc4Package.IFC_LIGHT_SOURCE_SPOT:
			return (EObject) createIfcLightSourceSpot();
		case Ifc4Package.IFC_LINE:
			return (EObject) createIfcLine();
		case Ifc4Package.IFC_LOCAL_PLACEMENT:
			return (EObject) createIfcLocalPlacement();
		case Ifc4Package.IFC_LOOP:
			return (EObject) createIfcLoop();
		case Ifc4Package.IFC_MANIFOLD_SOLID_BREP:
			return (EObject) createIfcManifoldSolidBrep();
		case Ifc4Package.IFC_MAP_CONVERSION:
			return (EObject) createIfcMapConversion();
		case Ifc4Package.IFC_MAPPED_ITEM:
			return (EObject) createIfcMappedItem();
		case Ifc4Package.IFC_MATERIAL:
			return (EObject) createIfcMaterial();
		case Ifc4Package.IFC_MATERIAL_CLASSIFICATION_RELATIONSHIP:
			return (EObject) createIfcMaterialClassificationRelationship();
		case Ifc4Package.IFC_MATERIAL_CONSTITUENT:
			return (EObject) createIfcMaterialConstituent();
		case Ifc4Package.IFC_MATERIAL_CONSTITUENT_SET:
			return (EObject) createIfcMaterialConstituentSet();
		case Ifc4Package.IFC_MATERIAL_DEFINITION:
			return (EObject) createIfcMaterialDefinition();
		case Ifc4Package.IFC_MATERIAL_DEFINITION_REPRESENTATION:
			return (EObject) createIfcMaterialDefinitionRepresentation();
		case Ifc4Package.IFC_MATERIAL_LAYER:
			return (EObject) createIfcMaterialLayer();
		case Ifc4Package.IFC_MATERIAL_LAYER_SET:
			return (EObject) createIfcMaterialLayerSet();
		case Ifc4Package.IFC_MATERIAL_LAYER_SET_USAGE:
			return (EObject) createIfcMaterialLayerSetUsage();
		case Ifc4Package.IFC_MATERIAL_LAYER_WITH_OFFSETS:
			return (EObject) createIfcMaterialLayerWithOffsets();
		case Ifc4Package.IFC_MATERIAL_LIST:
			return (EObject) createIfcMaterialList();
		case Ifc4Package.IFC_MATERIAL_PROFILE:
			return (EObject) createIfcMaterialProfile();
		case Ifc4Package.IFC_MATERIAL_PROFILE_SET:
			return (EObject) createIfcMaterialProfileSet();
		case Ifc4Package.IFC_MATERIAL_PROFILE_SET_USAGE:
			return (EObject) createIfcMaterialProfileSetUsage();
		case Ifc4Package.IFC_MATERIAL_PROFILE_SET_USAGE_TAPERING:
			return (EObject) createIfcMaterialProfileSetUsageTapering();
		case Ifc4Package.IFC_MATERIAL_PROFILE_WITH_OFFSETS:
			return (EObject) createIfcMaterialProfileWithOffsets();
		case Ifc4Package.IFC_MATERIAL_PROPERTIES:
			return (EObject) createIfcMaterialProperties();
		case Ifc4Package.IFC_MATERIAL_RELATIONSHIP:
			return (EObject) createIfcMaterialRelationship();
		case Ifc4Package.IFC_MATERIAL_USAGE_DEFINITION:
			return (EObject) createIfcMaterialUsageDefinition();
		case Ifc4Package.IFC_MEASURE_WITH_UNIT:
			return (EObject) createIfcMeasureWithUnit();
		case Ifc4Package.IFC_MECHANICAL_FASTENER:
			return (EObject) createIfcMechanicalFastener();
		case Ifc4Package.IFC_MECHANICAL_FASTENER_TYPE:
			return (EObject) createIfcMechanicalFastenerType();
		case Ifc4Package.IFC_MEDICAL_DEVICE:
			return (EObject) createIfcMedicalDevice();
		case Ifc4Package.IFC_MEDICAL_DEVICE_TYPE:
			return (EObject) createIfcMedicalDeviceType();
		case Ifc4Package.IFC_MEMBER:
			return (EObject) createIfcMember();
		case Ifc4Package.IFC_MEMBER_STANDARD_CASE:
			return (EObject) createIfcMemberStandardCase();
		case Ifc4Package.IFC_MEMBER_TYPE:
			return (EObject) createIfcMemberType();
		case Ifc4Package.IFC_METRIC:
			return (EObject) createIfcMetric();
		case Ifc4Package.IFC_MIRRORED_PROFILE_DEF:
			return (EObject) createIfcMirroredProfileDef();
		case Ifc4Package.IFC_MONETARY_UNIT:
			return (EObject) createIfcMonetaryUnit();
		case Ifc4Package.IFC_MOTOR_CONNECTION:
			return (EObject) createIfcMotorConnection();
		case Ifc4Package.IFC_MOTOR_CONNECTION_TYPE:
			return (EObject) createIfcMotorConnectionType();
		case Ifc4Package.IFC_NAMED_UNIT:
			return (EObject) createIfcNamedUnit();
		case Ifc4Package.IFC_OBJECT:
			return (EObject) createIfcObject();
		case Ifc4Package.IFC_OBJECT_DEFINITION:
			return (EObject) createIfcObjectDefinition();
		case Ifc4Package.IFC_OBJECT_PLACEMENT:
			return (EObject) createIfcObjectPlacement();
		case Ifc4Package.IFC_OBJECTIVE:
			return (EObject) createIfcObjective();
		case Ifc4Package.IFC_OCCUPANT:
			return (EObject) createIfcOccupant();
		case Ifc4Package.IFC_OFFSET_CURVE2_D:
			return (EObject) createIfcOffsetCurve2D();
		case Ifc4Package.IFC_OFFSET_CURVE3_D:
			return (EObject) createIfcOffsetCurve3D();
		case Ifc4Package.IFC_OPEN_SHELL:
			return (EObject) createIfcOpenShell();
		case Ifc4Package.IFC_OPENING_ELEMENT:
			return (EObject) createIfcOpeningElement();
		case Ifc4Package.IFC_OPENING_STANDARD_CASE:
			return (EObject) createIfcOpeningStandardCase();
		case Ifc4Package.IFC_ORGANIZATION:
			return (EObject) createIfcOrganization();
		case Ifc4Package.IFC_ORGANIZATION_RELATIONSHIP:
			return (EObject) createIfcOrganizationRelationship();
		case Ifc4Package.IFC_ORIENTED_EDGE:
			return (EObject) createIfcOrientedEdge();
		case Ifc4Package.IFC_OUTER_BOUNDARY_CURVE:
			return (EObject) createIfcOuterBoundaryCurve();
		case Ifc4Package.IFC_OUTLET:
			return (EObject) createIfcOutlet();
		case Ifc4Package.IFC_OUTLET_TYPE:
			return (EObject) createIfcOutletType();
		case Ifc4Package.IFC_OWNER_HISTORY:
			return (EObject) createIfcOwnerHistory();
		case Ifc4Package.IFC_PARAMETERIZED_PROFILE_DEF:
			return (EObject) createIfcParameterizedProfileDef();
		case Ifc4Package.IFC_PATH:
			return (EObject) createIfcPath();
		case Ifc4Package.IFC_PCURVE:
			return (EObject) createIfcPcurve();
		case Ifc4Package.IFC_PERFORMANCE_HISTORY:
			return (EObject) createIfcPerformanceHistory();
		case Ifc4Package.IFC_PERMEABLE_COVERING_PROPERTIES:
			return (EObject) createIfcPermeableCoveringProperties();
		case Ifc4Package.IFC_PERMIT:
			return (EObject) createIfcPermit();
		case Ifc4Package.IFC_PERSON:
			return (EObject) createIfcPerson();
		case Ifc4Package.IFC_PERSON_AND_ORGANIZATION:
			return (EObject) createIfcPersonAndOrganization();
		case Ifc4Package.IFC_PHYSICAL_COMPLEX_QUANTITY:
			return (EObject) createIfcPhysicalComplexQuantity();
		case Ifc4Package.IFC_PHYSICAL_QUANTITY:
			return (EObject) createIfcPhysicalQuantity();
		case Ifc4Package.IFC_PHYSICAL_SIMPLE_QUANTITY:
			return (EObject) createIfcPhysicalSimpleQuantity();
		case Ifc4Package.IFC_PILE:
			return (EObject) createIfcPile();
		case Ifc4Package.IFC_PILE_TYPE:
			return (EObject) createIfcPileType();
		case Ifc4Package.IFC_PIPE_FITTING:
			return (EObject) createIfcPipeFitting();
		case Ifc4Package.IFC_PIPE_FITTING_TYPE:
			return (EObject) createIfcPipeFittingType();
		case Ifc4Package.IFC_PIPE_SEGMENT:
			return (EObject) createIfcPipeSegment();
		case Ifc4Package.IFC_PIPE_SEGMENT_TYPE:
			return (EObject) createIfcPipeSegmentType();
		case Ifc4Package.IFC_PIXEL_TEXTURE:
			return (EObject) createIfcPixelTexture();
		case Ifc4Package.IFC_PLACEMENT:
			return (EObject) createIfcPlacement();
		case Ifc4Package.IFC_PLANAR_BOX:
			return (EObject) createIfcPlanarBox();
		case Ifc4Package.IFC_PLANAR_EXTENT:
			return (EObject) createIfcPlanarExtent();
		case Ifc4Package.IFC_PLANE:
			return (EObject) createIfcPlane();
		case Ifc4Package.IFC_PLATE:
			return (EObject) createIfcPlate();
		case Ifc4Package.IFC_PLATE_STANDARD_CASE:
			return (EObject) createIfcPlateStandardCase();
		case Ifc4Package.IFC_PLATE_TYPE:
			return (EObject) createIfcPlateType();
		case Ifc4Package.IFC_POINT:
			return (EObject) createIfcPoint();
		case Ifc4Package.IFC_POINT_ON_CURVE:
			return (EObject) createIfcPointOnCurve();
		case Ifc4Package.IFC_POINT_ON_SURFACE:
			return (EObject) createIfcPointOnSurface();
		case Ifc4Package.IFC_POLY_LOOP:
			return (EObject) createIfcPolyLoop();
		case Ifc4Package.IFC_POLYGONAL_BOUNDED_HALF_SPACE:
			return (EObject) createIfcPolygonalBoundedHalfSpace();
		case Ifc4Package.IFC_POLYGONAL_FACE_SET:
			return (EObject) createIfcPolygonalFaceSet();
		case Ifc4Package.IFC_POLYLINE:
			return (EObject) createIfcPolyline();
		case Ifc4Package.IFC_PORT:
			return (EObject) createIfcPort();
		case Ifc4Package.IFC_POSTAL_ADDRESS:
			return (EObject) createIfcPostalAddress();
		case Ifc4Package.IFC_PRE_DEFINED_COLOUR:
			return (EObject) createIfcPreDefinedColour();
		case Ifc4Package.IFC_PRE_DEFINED_CURVE_FONT:
			return (EObject) createIfcPreDefinedCurveFont();
		case Ifc4Package.IFC_PRE_DEFINED_ITEM:
			return (EObject) createIfcPreDefinedItem();
		case Ifc4Package.IFC_PRE_DEFINED_PROPERTIES:
			return (EObject) createIfcPreDefinedProperties();
		case Ifc4Package.IFC_PRE_DEFINED_PROPERTY_SET:
			return (EObject) createIfcPreDefinedPropertySet();
		case Ifc4Package.IFC_PRE_DEFINED_TEXT_FONT:
			return (EObject) createIfcPreDefinedTextFont();
		case Ifc4Package.IFC_PRESENTATION_ITEM:
			return (EObject) createIfcPresentationItem();
		case Ifc4Package.IFC_PRESENTATION_LAYER_ASSIGNMENT:
			return (EObject) createIfcPresentationLayerAssignment();
		case Ifc4Package.IFC_PRESENTATION_LAYER_WITH_STYLE:
			return (EObject) createIfcPresentationLayerWithStyle();
		case Ifc4Package.IFC_PRESENTATION_STYLE:
			return (EObject) createIfcPresentationStyle();
		case Ifc4Package.IFC_PRESENTATION_STYLE_ASSIGNMENT:
			return (EObject) createIfcPresentationStyleAssignment();
		case Ifc4Package.IFC_PROCEDURE:
			return (EObject) createIfcProcedure();
		case Ifc4Package.IFC_PROCEDURE_TYPE:
			return (EObject) createIfcProcedureType();
		case Ifc4Package.IFC_PROCESS:
			return (EObject) createIfcProcess();
		case Ifc4Package.IFC_PRODUCT:
			return (EObject) createIfcProduct();
		case Ifc4Package.IFC_PRODUCT_DEFINITION_SHAPE:
			return (EObject) createIfcProductDefinitionShape();
		case Ifc4Package.IFC_PRODUCT_REPRESENTATION:
			return (EObject) createIfcProductRepresentation();
		case Ifc4Package.IFC_PROFILE_DEF:
			return (EObject) createIfcProfileDef();
		case Ifc4Package.IFC_PROFILE_PROPERTIES:
			return (EObject) createIfcProfileProperties();
		case Ifc4Package.IFC_PROJECT:
			return (EObject) createIfcProject();
		case Ifc4Package.IFC_PROJECT_LIBRARY:
			return (EObject) createIfcProjectLibrary();
		case Ifc4Package.IFC_PROJECT_ORDER:
			return (EObject) createIfcProjectOrder();
		case Ifc4Package.IFC_PROJECTED_CRS:
			return (EObject) createIfcProjectedCRS();
		case Ifc4Package.IFC_PROJECTION_ELEMENT:
			return (EObject) createIfcProjectionElement();
		case Ifc4Package.IFC_PROPERTY:
			return (EObject) createIfcProperty();
		case Ifc4Package.IFC_PROPERTY_ABSTRACTION:
			return (EObject) createIfcPropertyAbstraction();
		case Ifc4Package.IFC_PROPERTY_BOUNDED_VALUE:
			return (EObject) createIfcPropertyBoundedValue();
		case Ifc4Package.IFC_PROPERTY_DEFINITION:
			return (EObject) createIfcPropertyDefinition();
		case Ifc4Package.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP:
			return (EObject) createIfcPropertyDependencyRelationship();
		case Ifc4Package.IFC_PROPERTY_ENUMERATED_VALUE:
			return (EObject) createIfcPropertyEnumeratedValue();
		case Ifc4Package.IFC_PROPERTY_ENUMERATION:
			return (EObject) createIfcPropertyEnumeration();
		case Ifc4Package.IFC_PROPERTY_LIST_VALUE:
			return (EObject) createIfcPropertyListValue();
		case Ifc4Package.IFC_PROPERTY_REFERENCE_VALUE:
			return (EObject) createIfcPropertyReferenceValue();
		case Ifc4Package.IFC_PROPERTY_SET:
			return (EObject) createIfcPropertySet();
		case Ifc4Package.IFC_PROPERTY_SET_DEFINITION:
			return (EObject) createIfcPropertySetDefinition();
		case Ifc4Package.IFC_PROPERTY_SET_TEMPLATE:
			return (EObject) createIfcPropertySetTemplate();
		case Ifc4Package.IFC_PROPERTY_SINGLE_VALUE:
			return (EObject) createIfcPropertySingleValue();
		case Ifc4Package.IFC_PROPERTY_TABLE_VALUE:
			return (EObject) createIfcPropertyTableValue();
		case Ifc4Package.IFC_PROPERTY_TEMPLATE:
			return (EObject) createIfcPropertyTemplate();
		case Ifc4Package.IFC_PROPERTY_TEMPLATE_DEFINITION:
			return (EObject) createIfcPropertyTemplateDefinition();
		case Ifc4Package.IFC_PROTECTIVE_DEVICE:
			return (EObject) createIfcProtectiveDevice();
		case Ifc4Package.IFC_PROTECTIVE_DEVICE_TRIPPING_UNIT:
			return (EObject) createIfcProtectiveDeviceTrippingUnit();
		case Ifc4Package.IFC_PROTECTIVE_DEVICE_TRIPPING_UNIT_TYPE:
			return (EObject) createIfcProtectiveDeviceTrippingUnitType();
		case Ifc4Package.IFC_PROTECTIVE_DEVICE_TYPE:
			return (EObject) createIfcProtectiveDeviceType();
		case Ifc4Package.IFC_PROXY:
			return (EObject) createIfcProxy();
		case Ifc4Package.IFC_PUMP:
			return (EObject) createIfcPump();
		case Ifc4Package.IFC_PUMP_TYPE:
			return (EObject) createIfcPumpType();
		case Ifc4Package.IFC_QUANTITY_AREA:
			return (EObject) createIfcQuantityArea();
		case Ifc4Package.IFC_QUANTITY_COUNT:
			return (EObject) createIfcQuantityCount();
		case Ifc4Package.IFC_QUANTITY_LENGTH:
			return (EObject) createIfcQuantityLength();
		case Ifc4Package.IFC_QUANTITY_SET:
			return (EObject) createIfcQuantitySet();
		case Ifc4Package.IFC_QUANTITY_TIME:
			return (EObject) createIfcQuantityTime();
		case Ifc4Package.IFC_QUANTITY_VOLUME:
			return (EObject) createIfcQuantityVolume();
		case Ifc4Package.IFC_QUANTITY_WEIGHT:
			return (EObject) createIfcQuantityWeight();
		case Ifc4Package.IFC_RAILING:
			return (EObject) createIfcRailing();
		case Ifc4Package.IFC_RAILING_TYPE:
			return (EObject) createIfcRailingType();
		case Ifc4Package.IFC_RAMP:
			return (EObject) createIfcRamp();
		case Ifc4Package.IFC_RAMP_FLIGHT:
			return (EObject) createIfcRampFlight();
		case Ifc4Package.IFC_RAMP_FLIGHT_TYPE:
			return (EObject) createIfcRampFlightType();
		case Ifc4Package.IFC_RAMP_TYPE:
			return (EObject) createIfcRampType();
		case Ifc4Package.IFC_RATIONAL_BSPLINE_CURVE_WITH_KNOTS:
			return (EObject) createIfcRationalBSplineCurveWithKnots();
		case Ifc4Package.IFC_RATIONAL_BSPLINE_SURFACE_WITH_KNOTS:
			return (EObject) createIfcRationalBSplineSurfaceWithKnots();
		case Ifc4Package.IFC_RECTANGLE_HOLLOW_PROFILE_DEF:
			return (EObject) createIfcRectangleHollowProfileDef();
		case Ifc4Package.IFC_RECTANGLE_PROFILE_DEF:
			return (EObject) createIfcRectangleProfileDef();
		case Ifc4Package.IFC_RECTANGULAR_PYRAMID:
			return (EObject) createIfcRectangularPyramid();
		case Ifc4Package.IFC_RECTANGULAR_TRIMMED_SURFACE:
			return (EObject) createIfcRectangularTrimmedSurface();
		case Ifc4Package.IFC_RECURRENCE_PATTERN:
			return (EObject) createIfcRecurrencePattern();
		case Ifc4Package.IFC_REFERENCE:
			return (EObject) createIfcReference();
		case Ifc4Package.IFC_REGULAR_TIME_SERIES:
			return (EObject) createIfcRegularTimeSeries();
		case Ifc4Package.IFC_REINFORCEMENT_BAR_PROPERTIES:
			return (EObject) createIfcReinforcementBarProperties();
		case Ifc4Package.IFC_REINFORCEMENT_DEFINITION_PROPERTIES:
			return (EObject) createIfcReinforcementDefinitionProperties();
		case Ifc4Package.IFC_REINFORCING_BAR:
			return (EObject) createIfcReinforcingBar();
		case Ifc4Package.IFC_REINFORCING_BAR_TYPE:
			return (EObject) createIfcReinforcingBarType();
		case Ifc4Package.IFC_REINFORCING_ELEMENT:
			return (EObject) createIfcReinforcingElement();
		case Ifc4Package.IFC_REINFORCING_ELEMENT_TYPE:
			return (EObject) createIfcReinforcingElementType();
		case Ifc4Package.IFC_REINFORCING_MESH:
			return (EObject) createIfcReinforcingMesh();
		case Ifc4Package.IFC_REINFORCING_MESH_TYPE:
			return (EObject) createIfcReinforcingMeshType();
		case Ifc4Package.IFC_REL_AGGREGATES:
			return (EObject) createIfcRelAggregates();
		case Ifc4Package.IFC_REL_ASSIGNS:
			return (EObject) createIfcRelAssigns();
		case Ifc4Package.IFC_REL_ASSIGNS_TO_ACTOR:
			return (EObject) createIfcRelAssignsToActor();
		case Ifc4Package.IFC_REL_ASSIGNS_TO_CONTROL:
			return (EObject) createIfcRelAssignsToControl();
		case Ifc4Package.IFC_REL_ASSIGNS_TO_GROUP:
			return (EObject) createIfcRelAssignsToGroup();
		case Ifc4Package.IFC_REL_ASSIGNS_TO_GROUP_BY_FACTOR:
			return (EObject) createIfcRelAssignsToGroupByFactor();
		case Ifc4Package.IFC_REL_ASSIGNS_TO_PROCESS:
			return (EObject) createIfcRelAssignsToProcess();
		case Ifc4Package.IFC_REL_ASSIGNS_TO_PRODUCT:
			return (EObject) createIfcRelAssignsToProduct();
		case Ifc4Package.IFC_REL_ASSIGNS_TO_RESOURCE:
			return (EObject) createIfcRelAssignsToResource();
		case Ifc4Package.IFC_REL_ASSOCIATES:
			return (EObject) createIfcRelAssociates();
		case Ifc4Package.IFC_REL_ASSOCIATES_APPROVAL:
			return (EObject) createIfcRelAssociatesApproval();
		case Ifc4Package.IFC_REL_ASSOCIATES_CLASSIFICATION:
			return (EObject) createIfcRelAssociatesClassification();
		case Ifc4Package.IFC_REL_ASSOCIATES_CONSTRAINT:
			return (EObject) createIfcRelAssociatesConstraint();
		case Ifc4Package.IFC_REL_ASSOCIATES_DOCUMENT:
			return (EObject) createIfcRelAssociatesDocument();
		case Ifc4Package.IFC_REL_ASSOCIATES_LIBRARY:
			return (EObject) createIfcRelAssociatesLibrary();
		case Ifc4Package.IFC_REL_ASSOCIATES_MATERIAL:
			return (EObject) createIfcRelAssociatesMaterial();
		case Ifc4Package.IFC_REL_CONNECTS:
			return (EObject) createIfcRelConnects();
		case Ifc4Package.IFC_REL_CONNECTS_ELEMENTS:
			return (EObject) createIfcRelConnectsElements();
		case Ifc4Package.IFC_REL_CONNECTS_PATH_ELEMENTS:
			return (EObject) createIfcRelConnectsPathElements();
		case Ifc4Package.IFC_REL_CONNECTS_PORT_TO_ELEMENT:
			return (EObject) createIfcRelConnectsPortToElement();
		case Ifc4Package.IFC_REL_CONNECTS_PORTS:
			return (EObject) createIfcRelConnectsPorts();
		case Ifc4Package.IFC_REL_CONNECTS_STRUCTURAL_ACTIVITY:
			return (EObject) createIfcRelConnectsStructuralActivity();
		case Ifc4Package.IFC_REL_CONNECTS_STRUCTURAL_MEMBER:
			return (EObject) createIfcRelConnectsStructuralMember();
		case Ifc4Package.IFC_REL_CONNECTS_WITH_ECCENTRICITY:
			return (EObject) createIfcRelConnectsWithEccentricity();
		case Ifc4Package.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS:
			return (EObject) createIfcRelConnectsWithRealizingElements();
		case Ifc4Package.IFC_REL_CONTAINED_IN_SPATIAL_STRUCTURE:
			return (EObject) createIfcRelContainedInSpatialStructure();
		case Ifc4Package.IFC_REL_COVERS_BLDG_ELEMENTS:
			return (EObject) createIfcRelCoversBldgElements();
		case Ifc4Package.IFC_REL_COVERS_SPACES:
			return (EObject) createIfcRelCoversSpaces();
		case Ifc4Package.IFC_REL_DECLARES:
			return (EObject) createIfcRelDeclares();
		case Ifc4Package.IFC_REL_DECOMPOSES:
			return (EObject) createIfcRelDecomposes();
		case Ifc4Package.IFC_REL_DEFINES:
			return (EObject) createIfcRelDefines();
		case Ifc4Package.IFC_REL_DEFINES_BY_OBJECT:
			return (EObject) createIfcRelDefinesByObject();
		case Ifc4Package.IFC_REL_DEFINES_BY_PROPERTIES:
			return (EObject) createIfcRelDefinesByProperties();
		case Ifc4Package.IFC_REL_DEFINES_BY_TEMPLATE:
			return (EObject) createIfcRelDefinesByTemplate();
		case Ifc4Package.IFC_REL_DEFINES_BY_TYPE:
			return (EObject) createIfcRelDefinesByType();
		case Ifc4Package.IFC_REL_FILLS_ELEMENT:
			return (EObject) createIfcRelFillsElement();
		case Ifc4Package.IFC_REL_FLOW_CONTROL_ELEMENTS:
			return (EObject) createIfcRelFlowControlElements();
		case Ifc4Package.IFC_REL_INTERFERES_ELEMENTS:
			return (EObject) createIfcRelInterferesElements();
		case Ifc4Package.IFC_REL_NESTS:
			return (EObject) createIfcRelNests();
		case Ifc4Package.IFC_REL_PROJECTS_ELEMENT:
			return (EObject) createIfcRelProjectsElement();
		case Ifc4Package.IFC_REL_REFERENCED_IN_SPATIAL_STRUCTURE:
			return (EObject) createIfcRelReferencedInSpatialStructure();
		case Ifc4Package.IFC_REL_SEQUENCE:
			return (EObject) createIfcRelSequence();
		case Ifc4Package.IFC_REL_SERVICES_BUILDINGS:
			return (EObject) createIfcRelServicesBuildings();
		case Ifc4Package.IFC_REL_SPACE_BOUNDARY:
			return (EObject) createIfcRelSpaceBoundary();
		case Ifc4Package.IFC_REL_SPACE_BOUNDARY1ST_LEVEL:
			return (EObject) createIfcRelSpaceBoundary1stLevel();
		case Ifc4Package.IFC_REL_SPACE_BOUNDARY2ND_LEVEL:
			return (EObject) createIfcRelSpaceBoundary2ndLevel();
		case Ifc4Package.IFC_REL_VOIDS_ELEMENT:
			return (EObject) createIfcRelVoidsElement();
		case Ifc4Package.IFC_RELATIONSHIP:
			return (EObject) createIfcRelationship();
		case Ifc4Package.IFC_REPARAMETRISED_COMPOSITE_CURVE_SEGMENT:
			return (EObject) createIfcReparametrisedCompositeCurveSegment();
		case Ifc4Package.IFC_REPRESENTATION:
			return (EObject) createIfcRepresentation();
		case Ifc4Package.IFC_REPRESENTATION_CONTEXT:
			return (EObject) createIfcRepresentationContext();
		case Ifc4Package.IFC_REPRESENTATION_ITEM:
			return (EObject) createIfcRepresentationItem();
		case Ifc4Package.IFC_REPRESENTATION_MAP:
			return (EObject) createIfcRepresentationMap();
		case Ifc4Package.IFC_RESOURCE:
			return (EObject) createIfcResource();
		case Ifc4Package.IFC_RESOURCE_APPROVAL_RELATIONSHIP:
			return (EObject) createIfcResourceApprovalRelationship();
		case Ifc4Package.IFC_RESOURCE_CONSTRAINT_RELATIONSHIP:
			return (EObject) createIfcResourceConstraintRelationship();
		case Ifc4Package.IFC_RESOURCE_LEVEL_RELATIONSHIP:
			return (EObject) createIfcResourceLevelRelationship();
		case Ifc4Package.IFC_RESOURCE_TIME:
			return (EObject) createIfcResourceTime();
		case Ifc4Package.IFC_REVOLVED_AREA_SOLID:
			return (EObject) createIfcRevolvedAreaSolid();
		case Ifc4Package.IFC_REVOLVED_AREA_SOLID_TAPERED:
			return (EObject) createIfcRevolvedAreaSolidTapered();
		case Ifc4Package.IFC_RIGHT_CIRCULAR_CONE:
			return (EObject) createIfcRightCircularCone();
		case Ifc4Package.IFC_RIGHT_CIRCULAR_CYLINDER:
			return (EObject) createIfcRightCircularCylinder();
		case Ifc4Package.IFC_ROOF:
			return (EObject) createIfcRoof();
		case Ifc4Package.IFC_ROOF_TYPE:
			return (EObject) createIfcRoofType();
		case Ifc4Package.IFC_ROOT:
			return (EObject) createIfcRoot();
		case Ifc4Package.IFC_ROUNDED_RECTANGLE_PROFILE_DEF:
			return (EObject) createIfcRoundedRectangleProfileDef();
		case Ifc4Package.IFC_SI_UNIT:
			return (EObject) createIfcSIUnit();
		case Ifc4Package.IFC_SANITARY_TERMINAL:
			return (EObject) createIfcSanitaryTerminal();
		case Ifc4Package.IFC_SANITARY_TERMINAL_TYPE:
			return (EObject) createIfcSanitaryTerminalType();
		case Ifc4Package.IFC_SCHEDULING_TIME:
			return (EObject) createIfcSchedulingTime();
		case Ifc4Package.IFC_SEAM_CURVE:
			return (EObject) createIfcSeamCurve();
		case Ifc4Package.IFC_SECTION_PROPERTIES:
			return (EObject) createIfcSectionProperties();
		case Ifc4Package.IFC_SECTION_REINFORCEMENT_PROPERTIES:
			return (EObject) createIfcSectionReinforcementProperties();
		case Ifc4Package.IFC_SECTIONED_SPINE:
			return (EObject) createIfcSectionedSpine();
		case Ifc4Package.IFC_SENSOR:
			return (EObject) createIfcSensor();
		case Ifc4Package.IFC_SENSOR_TYPE:
			return (EObject) createIfcSensorType();
		case Ifc4Package.IFC_SHADING_DEVICE:
			return (EObject) createIfcShadingDevice();
		case Ifc4Package.IFC_SHADING_DEVICE_TYPE:
			return (EObject) createIfcShadingDeviceType();
		case Ifc4Package.IFC_SHAPE_ASPECT:
			return (EObject) createIfcShapeAspect();
		case Ifc4Package.IFC_SHAPE_MODEL:
			return (EObject) createIfcShapeModel();
		case Ifc4Package.IFC_SHAPE_REPRESENTATION:
			return (EObject) createIfcShapeRepresentation();
		case Ifc4Package.IFC_SHELL_BASED_SURFACE_MODEL:
			return (EObject) createIfcShellBasedSurfaceModel();
		case Ifc4Package.IFC_SIMPLE_PROPERTY:
			return (EObject) createIfcSimpleProperty();
		case Ifc4Package.IFC_SIMPLE_PROPERTY_TEMPLATE:
			return (EObject) createIfcSimplePropertyTemplate();
		case Ifc4Package.IFC_SITE:
			return (EObject) createIfcSite();
		case Ifc4Package.IFC_SLAB:
			return (EObject) createIfcSlab();
		case Ifc4Package.IFC_SLAB_ELEMENTED_CASE:
			return (EObject) createIfcSlabElementedCase();
		case Ifc4Package.IFC_SLAB_STANDARD_CASE:
			return (EObject) createIfcSlabStandardCase();
		case Ifc4Package.IFC_SLAB_TYPE:
			return (EObject) createIfcSlabType();
		case Ifc4Package.IFC_SLIPPAGE_CONNECTION_CONDITION:
			return (EObject) createIfcSlippageConnectionCondition();
		case Ifc4Package.IFC_SOLAR_DEVICE:
			return (EObject) createIfcSolarDevice();
		case Ifc4Package.IFC_SOLAR_DEVICE_TYPE:
			return (EObject) createIfcSolarDeviceType();
		case Ifc4Package.IFC_SOLID_MODEL:
			return (EObject) createIfcSolidModel();
		case Ifc4Package.IFC_SPACE:
			return (EObject) createIfcSpace();
		case Ifc4Package.IFC_SPACE_HEATER:
			return (EObject) createIfcSpaceHeater();
		case Ifc4Package.IFC_SPACE_HEATER_TYPE:
			return (EObject) createIfcSpaceHeaterType();
		case Ifc4Package.IFC_SPACE_TYPE:
			return (EObject) createIfcSpaceType();
		case Ifc4Package.IFC_SPATIAL_ELEMENT:
			return (EObject) createIfcSpatialElement();
		case Ifc4Package.IFC_SPATIAL_ELEMENT_TYPE:
			return (EObject) createIfcSpatialElementType();
		case Ifc4Package.IFC_SPATIAL_STRUCTURE_ELEMENT:
			return (EObject) createIfcSpatialStructureElement();
		case Ifc4Package.IFC_SPATIAL_STRUCTURE_ELEMENT_TYPE:
			return (EObject) createIfcSpatialStructureElementType();
		case Ifc4Package.IFC_SPATIAL_ZONE:
			return (EObject) createIfcSpatialZone();
		case Ifc4Package.IFC_SPATIAL_ZONE_TYPE:
			return (EObject) createIfcSpatialZoneType();
		case Ifc4Package.IFC_SPHERE:
			return (EObject) createIfcSphere();
		case Ifc4Package.IFC_SPHERICAL_SURFACE:
			return (EObject) createIfcSphericalSurface();
		case Ifc4Package.IFC_STACK_TERMINAL:
			return (EObject) createIfcStackTerminal();
		case Ifc4Package.IFC_STACK_TERMINAL_TYPE:
			return (EObject) createIfcStackTerminalType();
		case Ifc4Package.IFC_STAIR:
			return (EObject) createIfcStair();
		case Ifc4Package.IFC_STAIR_FLIGHT:
			return (EObject) createIfcStairFlight();
		case Ifc4Package.IFC_STAIR_FLIGHT_TYPE:
			return (EObject) createIfcStairFlightType();
		case Ifc4Package.IFC_STAIR_TYPE:
			return (EObject) createIfcStairType();
		case Ifc4Package.IFC_STRUCTURAL_ACTION:
			return (EObject) createIfcStructuralAction();
		case Ifc4Package.IFC_STRUCTURAL_ACTIVITY:
			return (EObject) createIfcStructuralActivity();
		case Ifc4Package.IFC_STRUCTURAL_ANALYSIS_MODEL:
			return (EObject) createIfcStructuralAnalysisModel();
		case Ifc4Package.IFC_STRUCTURAL_CONNECTION:
			return (EObject) createIfcStructuralConnection();
		case Ifc4Package.IFC_STRUCTURAL_CONNECTION_CONDITION:
			return (EObject) createIfcStructuralConnectionCondition();
		case Ifc4Package.IFC_STRUCTURAL_CURVE_ACTION:
			return (EObject) createIfcStructuralCurveAction();
		case Ifc4Package.IFC_STRUCTURAL_CURVE_CONNECTION:
			return (EObject) createIfcStructuralCurveConnection();
		case Ifc4Package.IFC_STRUCTURAL_CURVE_MEMBER:
			return (EObject) createIfcStructuralCurveMember();
		case Ifc4Package.IFC_STRUCTURAL_CURVE_MEMBER_VARYING:
			return (EObject) createIfcStructuralCurveMemberVarying();
		case Ifc4Package.IFC_STRUCTURAL_CURVE_REACTION:
			return (EObject) createIfcStructuralCurveReaction();
		case Ifc4Package.IFC_STRUCTURAL_ITEM:
			return (EObject) createIfcStructuralItem();
		case Ifc4Package.IFC_STRUCTURAL_LINEAR_ACTION:
			return (EObject) createIfcStructuralLinearAction();
		case Ifc4Package.IFC_STRUCTURAL_LOAD:
			return (EObject) createIfcStructuralLoad();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_CASE:
			return (EObject) createIfcStructuralLoadCase();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_CONFIGURATION:
			return (EObject) createIfcStructuralLoadConfiguration();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_GROUP:
			return (EObject) createIfcStructuralLoadGroup();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_LINEAR_FORCE:
			return (EObject) createIfcStructuralLoadLinearForce();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_OR_RESULT:
			return (EObject) createIfcStructuralLoadOrResult();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_PLANAR_FORCE:
			return (EObject) createIfcStructuralLoadPlanarForce();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT:
			return (EObject) createIfcStructuralLoadSingleDisplacement();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION:
			return (EObject) createIfcStructuralLoadSingleDisplacementDistortion();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_SINGLE_FORCE:
			return (EObject) createIfcStructuralLoadSingleForce();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING:
			return (EObject) createIfcStructuralLoadSingleForceWarping();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_STATIC:
			return (EObject) createIfcStructuralLoadStatic();
		case Ifc4Package.IFC_STRUCTURAL_LOAD_TEMPERATURE:
			return (EObject) createIfcStructuralLoadTemperature();
		case Ifc4Package.IFC_STRUCTURAL_MEMBER:
			return (EObject) createIfcStructuralMember();
		case Ifc4Package.IFC_STRUCTURAL_PLANAR_ACTION:
			return (EObject) createIfcStructuralPlanarAction();
		case Ifc4Package.IFC_STRUCTURAL_POINT_ACTION:
			return (EObject) createIfcStructuralPointAction();
		case Ifc4Package.IFC_STRUCTURAL_POINT_CONNECTION:
			return (EObject) createIfcStructuralPointConnection();
		case Ifc4Package.IFC_STRUCTURAL_POINT_REACTION:
			return (EObject) createIfcStructuralPointReaction();
		case Ifc4Package.IFC_STRUCTURAL_REACTION:
			return (EObject) createIfcStructuralReaction();
		case Ifc4Package.IFC_STRUCTURAL_RESULT_GROUP:
			return (EObject) createIfcStructuralResultGroup();
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_ACTION:
			return (EObject) createIfcStructuralSurfaceAction();
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_CONNECTION:
			return (EObject) createIfcStructuralSurfaceConnection();
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_MEMBER:
			return (EObject) createIfcStructuralSurfaceMember();
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_MEMBER_VARYING:
			return (EObject) createIfcStructuralSurfaceMemberVarying();
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_REACTION:
			return (EObject) createIfcStructuralSurfaceReaction();
		case Ifc4Package.IFC_STYLE_MODEL:
			return (EObject) createIfcStyleModel();
		case Ifc4Package.IFC_STYLED_ITEM:
			return (EObject) createIfcStyledItem();
		case Ifc4Package.IFC_STYLED_REPRESENTATION:
			return (EObject) createIfcStyledRepresentation();
		case Ifc4Package.IFC_SUB_CONTRACT_RESOURCE:
			return (EObject) createIfcSubContractResource();
		case Ifc4Package.IFC_SUB_CONTRACT_RESOURCE_TYPE:
			return (EObject) createIfcSubContractResourceType();
		case Ifc4Package.IFC_SUBEDGE:
			return (EObject) createIfcSubedge();
		case Ifc4Package.IFC_SURFACE:
			return (EObject) createIfcSurface();
		case Ifc4Package.IFC_SURFACE_CURVE:
			return (EObject) createIfcSurfaceCurve();
		case Ifc4Package.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID:
			return (EObject) createIfcSurfaceCurveSweptAreaSolid();
		case Ifc4Package.IFC_SURFACE_FEATURE:
			return (EObject) createIfcSurfaceFeature();
		case Ifc4Package.IFC_SURFACE_OF_LINEAR_EXTRUSION:
			return (EObject) createIfcSurfaceOfLinearExtrusion();
		case Ifc4Package.IFC_SURFACE_OF_REVOLUTION:
			return (EObject) createIfcSurfaceOfRevolution();
		case Ifc4Package.IFC_SURFACE_REINFORCEMENT_AREA:
			return (EObject) createIfcSurfaceReinforcementArea();
		case Ifc4Package.IFC_SURFACE_STYLE:
			return (EObject) createIfcSurfaceStyle();
		case Ifc4Package.IFC_SURFACE_STYLE_LIGHTING:
			return (EObject) createIfcSurfaceStyleLighting();
		case Ifc4Package.IFC_SURFACE_STYLE_REFRACTION:
			return (EObject) createIfcSurfaceStyleRefraction();
		case Ifc4Package.IFC_SURFACE_STYLE_RENDERING:
			return (EObject) createIfcSurfaceStyleRendering();
		case Ifc4Package.IFC_SURFACE_STYLE_SHADING:
			return (EObject) createIfcSurfaceStyleShading();
		case Ifc4Package.IFC_SURFACE_STYLE_WITH_TEXTURES:
			return (EObject) createIfcSurfaceStyleWithTextures();
		case Ifc4Package.IFC_SURFACE_TEXTURE:
			return (EObject) createIfcSurfaceTexture();
		case Ifc4Package.IFC_SWEPT_AREA_SOLID:
			return (EObject) createIfcSweptAreaSolid();
		case Ifc4Package.IFC_SWEPT_DISK_SOLID:
			return (EObject) createIfcSweptDiskSolid();
		case Ifc4Package.IFC_SWEPT_DISK_SOLID_POLYGONAL:
			return (EObject) createIfcSweptDiskSolidPolygonal();
		case Ifc4Package.IFC_SWEPT_SURFACE:
			return (EObject) createIfcSweptSurface();
		case Ifc4Package.IFC_SWITCHING_DEVICE:
			return (EObject) createIfcSwitchingDevice();
		case Ifc4Package.IFC_SWITCHING_DEVICE_TYPE:
			return (EObject) createIfcSwitchingDeviceType();
		case Ifc4Package.IFC_SYSTEM:
			return (EObject) createIfcSystem();
		case Ifc4Package.IFC_SYSTEM_FURNITURE_ELEMENT:
			return (EObject) createIfcSystemFurnitureElement();
		case Ifc4Package.IFC_SYSTEM_FURNITURE_ELEMENT_TYPE:
			return (EObject) createIfcSystemFurnitureElementType();
		case Ifc4Package.IFC_TSHAPE_PROFILE_DEF:
			return (EObject) createIfcTShapeProfileDef();
		case Ifc4Package.IFC_TABLE:
			return (EObject) createIfcTable();
		case Ifc4Package.IFC_TABLE_COLUMN:
			return (EObject) createIfcTableColumn();
		case Ifc4Package.IFC_TABLE_ROW:
			return (EObject) createIfcTableRow();
		case Ifc4Package.IFC_TANK:
			return (EObject) createIfcTank();
		case Ifc4Package.IFC_TANK_TYPE:
			return (EObject) createIfcTankType();
		case Ifc4Package.IFC_TASK:
			return (EObject) createIfcTask();
		case Ifc4Package.IFC_TASK_TIME:
			return (EObject) createIfcTaskTime();
		case Ifc4Package.IFC_TASK_TIME_RECURRING:
			return (EObject) createIfcTaskTimeRecurring();
		case Ifc4Package.IFC_TASK_TYPE:
			return (EObject) createIfcTaskType();
		case Ifc4Package.IFC_TELECOM_ADDRESS:
			return (EObject) createIfcTelecomAddress();
		case Ifc4Package.IFC_TENDON:
			return (EObject) createIfcTendon();
		case Ifc4Package.IFC_TENDON_ANCHOR:
			return (EObject) createIfcTendonAnchor();
		case Ifc4Package.IFC_TENDON_ANCHOR_TYPE:
			return (EObject) createIfcTendonAnchorType();
		case Ifc4Package.IFC_TENDON_TYPE:
			return (EObject) createIfcTendonType();
		case Ifc4Package.IFC_TESSELLATED_FACE_SET:
			return (EObject) createIfcTessellatedFaceSet();
		case Ifc4Package.IFC_TESSELLATED_ITEM:
			return (EObject) createIfcTessellatedItem();
		case Ifc4Package.IFC_TEXT_LITERAL:
			return (EObject) createIfcTextLiteral();
		case Ifc4Package.IFC_TEXT_LITERAL_WITH_EXTENT:
			return (EObject) createIfcTextLiteralWithExtent();
		case Ifc4Package.IFC_TEXT_STYLE:
			return (EObject) createIfcTextStyle();
		case Ifc4Package.IFC_TEXT_STYLE_FONT_MODEL:
			return (EObject) createIfcTextStyleFontModel();
		case Ifc4Package.IFC_TEXT_STYLE_FOR_DEFINED_FONT:
			return (EObject) createIfcTextStyleForDefinedFont();
		case Ifc4Package.IFC_TEXT_STYLE_TEXT_MODEL:
			return (EObject) createIfcTextStyleTextModel();
		case Ifc4Package.IFC_TEXTURE_COORDINATE:
			return (EObject) createIfcTextureCoordinate();
		case Ifc4Package.IFC_TEXTURE_COORDINATE_GENERATOR:
			return (EObject) createIfcTextureCoordinateGenerator();
		case Ifc4Package.IFC_TEXTURE_MAP:
			return (EObject) createIfcTextureMap();
		case Ifc4Package.IFC_TEXTURE_VERTEX:
			return (EObject) createIfcTextureVertex();
		case Ifc4Package.IFC_TEXTURE_VERTEX_LIST:
			return (EObject) createIfcTextureVertexList();
		case Ifc4Package.IFC_TIME_PERIOD:
			return (EObject) createIfcTimePeriod();
		case Ifc4Package.IFC_TIME_SERIES:
			return (EObject) createIfcTimeSeries();
		case Ifc4Package.IFC_TIME_SERIES_VALUE:
			return (EObject) createIfcTimeSeriesValue();
		case Ifc4Package.IFC_TOPOLOGICAL_REPRESENTATION_ITEM:
			return (EObject) createIfcTopologicalRepresentationItem();
		case Ifc4Package.IFC_TOPOLOGY_REPRESENTATION:
			return (EObject) createIfcTopologyRepresentation();
		case Ifc4Package.IFC_TOROIDAL_SURFACE:
			return (EObject) createIfcToroidalSurface();
		case Ifc4Package.IFC_TRANSFORMER:
			return (EObject) createIfcTransformer();
		case Ifc4Package.IFC_TRANSFORMER_TYPE:
			return (EObject) createIfcTransformerType();
		case Ifc4Package.IFC_TRANSPORT_ELEMENT:
			return (EObject) createIfcTransportElement();
		case Ifc4Package.IFC_TRANSPORT_ELEMENT_TYPE:
			return (EObject) createIfcTransportElementType();
		case Ifc4Package.IFC_TRAPEZIUM_PROFILE_DEF:
			return (EObject) createIfcTrapeziumProfileDef();
		case Ifc4Package.IFC_TRIANGULATED_FACE_SET:
			return (EObject) createIfcTriangulatedFaceSet();
		case Ifc4Package.IFC_TRIMMED_CURVE:
			return (EObject) createIfcTrimmedCurve();
		case Ifc4Package.IFC_TUBE_BUNDLE:
			return (EObject) createIfcTubeBundle();
		case Ifc4Package.IFC_TUBE_BUNDLE_TYPE:
			return (EObject) createIfcTubeBundleType();
		case Ifc4Package.IFC_TYPE_OBJECT:
			return (EObject) createIfcTypeObject();
		case Ifc4Package.IFC_TYPE_PROCESS:
			return (EObject) createIfcTypeProcess();
		case Ifc4Package.IFC_TYPE_PRODUCT:
			return (EObject) createIfcTypeProduct();
		case Ifc4Package.IFC_TYPE_RESOURCE:
			return (EObject) createIfcTypeResource();
		case Ifc4Package.IFC_USHAPE_PROFILE_DEF:
			return (EObject) createIfcUShapeProfileDef();
		case Ifc4Package.IFC_UNIT_ASSIGNMENT:
			return (EObject) createIfcUnitAssignment();
		case Ifc4Package.IFC_UNITARY_CONTROL_ELEMENT:
			return (EObject) createIfcUnitaryControlElement();
		case Ifc4Package.IFC_UNITARY_CONTROL_ELEMENT_TYPE:
			return (EObject) createIfcUnitaryControlElementType();
		case Ifc4Package.IFC_UNITARY_EQUIPMENT:
			return (EObject) createIfcUnitaryEquipment();
		case Ifc4Package.IFC_UNITARY_EQUIPMENT_TYPE:
			return (EObject) createIfcUnitaryEquipmentType();
		case Ifc4Package.IFC_VALVE:
			return (EObject) createIfcValve();
		case Ifc4Package.IFC_VALVE_TYPE:
			return (EObject) createIfcValveType();
		case Ifc4Package.IFC_VECTOR:
			return (EObject) createIfcVector();
		case Ifc4Package.IFC_VERTEX:
			return (EObject) createIfcVertex();
		case Ifc4Package.IFC_VERTEX_LOOP:
			return (EObject) createIfcVertexLoop();
		case Ifc4Package.IFC_VERTEX_POINT:
			return (EObject) createIfcVertexPoint();
		case Ifc4Package.IFC_VIBRATION_ISOLATOR:
			return (EObject) createIfcVibrationIsolator();
		case Ifc4Package.IFC_VIBRATION_ISOLATOR_TYPE:
			return (EObject) createIfcVibrationIsolatorType();
		case Ifc4Package.IFC_VIRTUAL_ELEMENT:
			return (EObject) createIfcVirtualElement();
		case Ifc4Package.IFC_VIRTUAL_GRID_INTERSECTION:
			return (EObject) createIfcVirtualGridIntersection();
		case Ifc4Package.IFC_VOIDING_FEATURE:
			return (EObject) createIfcVoidingFeature();
		case Ifc4Package.IFC_WALL:
			return (EObject) createIfcWall();
		case Ifc4Package.IFC_WALL_ELEMENTED_CASE:
			return (EObject) createIfcWallElementedCase();
		case Ifc4Package.IFC_WALL_STANDARD_CASE:
			return (EObject) createIfcWallStandardCase();
		case Ifc4Package.IFC_WALL_TYPE:
			return (EObject) createIfcWallType();
		case Ifc4Package.IFC_WASTE_TERMINAL:
			return (EObject) createIfcWasteTerminal();
		case Ifc4Package.IFC_WASTE_TERMINAL_TYPE:
			return (EObject) createIfcWasteTerminalType();
		case Ifc4Package.IFC_WINDOW:
			return (EObject) createIfcWindow();
		case Ifc4Package.IFC_WINDOW_LINING_PROPERTIES:
			return (EObject) createIfcWindowLiningProperties();
		case Ifc4Package.IFC_WINDOW_PANEL_PROPERTIES:
			return (EObject) createIfcWindowPanelProperties();
		case Ifc4Package.IFC_WINDOW_STANDARD_CASE:
			return (EObject) createIfcWindowStandardCase();
		case Ifc4Package.IFC_WINDOW_STYLE:
			return (EObject) createIfcWindowStyle();
		case Ifc4Package.IFC_WINDOW_TYPE:
			return (EObject) createIfcWindowType();
		case Ifc4Package.IFC_WORK_CALENDAR:
			return (EObject) createIfcWorkCalendar();
		case Ifc4Package.IFC_WORK_CONTROL:
			return (EObject) createIfcWorkControl();
		case Ifc4Package.IFC_WORK_PLAN:
			return (EObject) createIfcWorkPlan();
		case Ifc4Package.IFC_WORK_SCHEDULE:
			return (EObject) createIfcWorkSchedule();
		case Ifc4Package.IFC_WORK_TIME:
			return (EObject) createIfcWorkTime();
		case Ifc4Package.IFC_ZSHAPE_PROFILE_DEF:
			return (EObject) createIfcZShapeProfileDef();
		case Ifc4Package.IFC_ZONE:
			return (EObject) createIfcZone();
		case Ifc4Package.IFC_STRIPPED_OPTIONAL:
			return (EObject) createIfcStrippedOptional();
		case Ifc4Package.IFC_ABSORBED_DOSE_MEASURE:
			return (EObject) createIfcAbsorbedDoseMeasure();
		case Ifc4Package.IFC_ACCELERATION_MEASURE:
			return (EObject) createIfcAccelerationMeasure();
		case Ifc4Package.IFC_AMOUNT_OF_SUBSTANCE_MEASURE:
			return (EObject) createIfcAmountOfSubstanceMeasure();
		case Ifc4Package.IFC_ANGULAR_VELOCITY_MEASURE:
			return (EObject) createIfcAngularVelocityMeasure();
		case Ifc4Package.IFC_AREA_DENSITY_MEASURE:
			return (EObject) createIfcAreaDensityMeasure();
		case Ifc4Package.IFC_AREA_MEASURE:
			return (EObject) createIfcAreaMeasure();
		case Ifc4Package.IFC_BINARY:
			return (EObject) createIfcBinary();
		case Ifc4Package.IFC_BOOLEAN:
			return (EObject) createIfcBoolean();
		case Ifc4Package.IFC_CARDINAL_POINT_REFERENCE:
			return (EObject) createIfcCardinalPointReference();
		case Ifc4Package.IFC_CONTEXT_DEPENDENT_MEASURE:
			return (EObject) createIfcContextDependentMeasure();
		case Ifc4Package.IFC_COUNT_MEASURE:
			return (EObject) createIfcCountMeasure();
		case Ifc4Package.IFC_CURVATURE_MEASURE:
			return (EObject) createIfcCurvatureMeasure();
		case Ifc4Package.IFC_DATE:
			return (EObject) createIfcDate();
		case Ifc4Package.IFC_DATE_TIME:
			return (EObject) createIfcDateTime();
		case Ifc4Package.IFC_DAY_IN_MONTH_NUMBER:
			return (EObject) createIfcDayInMonthNumber();
		case Ifc4Package.IFC_DAY_IN_WEEK_NUMBER:
			return (EObject) createIfcDayInWeekNumber();
		case Ifc4Package.IFC_DESCRIPTIVE_MEASURE:
			return (EObject) createIfcDescriptiveMeasure();
		case Ifc4Package.IFC_DIMENSION_COUNT:
			return (EObject) createIfcDimensionCount();
		case Ifc4Package.IFC_DOSE_EQUIVALENT_MEASURE:
			return (EObject) createIfcDoseEquivalentMeasure();
		case Ifc4Package.IFC_DURATION:
			return (EObject) createIfcDuration();
		case Ifc4Package.IFC_DYNAMIC_VISCOSITY_MEASURE:
			return (EObject) createIfcDynamicViscosityMeasure();
		case Ifc4Package.IFC_ELECTRIC_CAPACITANCE_MEASURE:
			return (EObject) createIfcElectricCapacitanceMeasure();
		case Ifc4Package.IFC_ELECTRIC_CHARGE_MEASURE:
			return (EObject) createIfcElectricChargeMeasure();
		case Ifc4Package.IFC_ELECTRIC_CONDUCTANCE_MEASURE:
			return (EObject) createIfcElectricConductanceMeasure();
		case Ifc4Package.IFC_ELECTRIC_CURRENT_MEASURE:
			return (EObject) createIfcElectricCurrentMeasure();
		case Ifc4Package.IFC_ELECTRIC_RESISTANCE_MEASURE:
			return (EObject) createIfcElectricResistanceMeasure();
		case Ifc4Package.IFC_ELECTRIC_VOLTAGE_MEASURE:
			return (EObject) createIfcElectricVoltageMeasure();
		case Ifc4Package.IFC_ENERGY_MEASURE:
			return (EObject) createIfcEnergyMeasure();
		case Ifc4Package.IFC_FONT_STYLE:
			return (EObject) createIfcFontStyle();
		case Ifc4Package.IFC_FONT_VARIANT:
			return (EObject) createIfcFontVariant();
		case Ifc4Package.IFC_FONT_WEIGHT:
			return (EObject) createIfcFontWeight();
		case Ifc4Package.IFC_FORCE_MEASURE:
			return (EObject) createIfcForceMeasure();
		case Ifc4Package.IFC_FREQUENCY_MEASURE:
			return (EObject) createIfcFrequencyMeasure();
		case Ifc4Package.IFC_GLOBALLY_UNIQUE_ID:
			return (EObject) createIfcGloballyUniqueId();
		case Ifc4Package.IFC_HEAT_FLUX_DENSITY_MEASURE:
			return (EObject) createIfcHeatFluxDensityMeasure();
		case Ifc4Package.IFC_HEATING_VALUE_MEASURE:
			return (EObject) createIfcHeatingValueMeasure();
		case Ifc4Package.IFC_IDENTIFIER:
			return (EObject) createIfcIdentifier();
		case Ifc4Package.IFC_ILLUMINANCE_MEASURE:
			return (EObject) createIfcIlluminanceMeasure();
		case Ifc4Package.IFC_INDUCTANCE_MEASURE:
			return (EObject) createIfcInductanceMeasure();
		case Ifc4Package.IFC_INTEGER:
			return (EObject) createIfcInteger();
		case Ifc4Package.IFC_INTEGER_COUNT_RATE_MEASURE:
			return (EObject) createIfcIntegerCountRateMeasure();
		case Ifc4Package.IFC_ION_CONCENTRATION_MEASURE:
			return (EObject) createIfcIonConcentrationMeasure();
		case Ifc4Package.IFC_ISOTHERMAL_MOISTURE_CAPACITY_MEASURE:
			return (EObject) createIfcIsothermalMoistureCapacityMeasure();
		case Ifc4Package.IFC_KINEMATIC_VISCOSITY_MEASURE:
			return (EObject) createIfcKinematicViscosityMeasure();
		case Ifc4Package.IFC_LABEL:
			return (EObject) createIfcLabel();
		case Ifc4Package.IFC_LENGTH_MEASURE:
			return (EObject) createIfcLengthMeasure();
		case Ifc4Package.IFC_LINEAR_FORCE_MEASURE:
			return (EObject) createIfcLinearForceMeasure();
		case Ifc4Package.IFC_LINEAR_MOMENT_MEASURE:
			return (EObject) createIfcLinearMomentMeasure();
		case Ifc4Package.IFC_LINEAR_STIFFNESS_MEASURE:
			return (EObject) createIfcLinearStiffnessMeasure();
		case Ifc4Package.IFC_LINEAR_VELOCITY_MEASURE:
			return (EObject) createIfcLinearVelocityMeasure();
		case Ifc4Package.IFC_LOGICAL:
			return (EObject) createIfcLogical();
		case Ifc4Package.IFC_LUMINOUS_FLUX_MEASURE:
			return (EObject) createIfcLuminousFluxMeasure();
		case Ifc4Package.IFC_LUMINOUS_INTENSITY_DISTRIBUTION_MEASURE:
			return (EObject) createIfcLuminousIntensityDistributionMeasure();
		case Ifc4Package.IFC_LUMINOUS_INTENSITY_MEASURE:
			return (EObject) createIfcLuminousIntensityMeasure();
		case Ifc4Package.IFC_MAGNETIC_FLUX_DENSITY_MEASURE:
			return (EObject) createIfcMagneticFluxDensityMeasure();
		case Ifc4Package.IFC_MAGNETIC_FLUX_MEASURE:
			return (EObject) createIfcMagneticFluxMeasure();
		case Ifc4Package.IFC_MASS_DENSITY_MEASURE:
			return (EObject) createIfcMassDensityMeasure();
		case Ifc4Package.IFC_MASS_FLOW_RATE_MEASURE:
			return (EObject) createIfcMassFlowRateMeasure();
		case Ifc4Package.IFC_MASS_MEASURE:
			return (EObject) createIfcMassMeasure();
		case Ifc4Package.IFC_MASS_PER_LENGTH_MEASURE:
			return (EObject) createIfcMassPerLengthMeasure();
		case Ifc4Package.IFC_MODULUS_OF_ELASTICITY_MEASURE:
			return (EObject) createIfcModulusOfElasticityMeasure();
		case Ifc4Package.IFC_MODULUS_OF_LINEAR_SUBGRADE_REACTION_MEASURE:
			return (EObject) createIfcModulusOfLinearSubgradeReactionMeasure();
		case Ifc4Package.IFC_MODULUS_OF_ROTATIONAL_SUBGRADE_REACTION_MEASURE:
			return (EObject) createIfcModulusOfRotationalSubgradeReactionMeasure();
		case Ifc4Package.IFC_MODULUS_OF_SUBGRADE_REACTION_MEASURE:
			return (EObject) createIfcModulusOfSubgradeReactionMeasure();
		case Ifc4Package.IFC_MOISTURE_DIFFUSIVITY_MEASURE:
			return (EObject) createIfcMoistureDiffusivityMeasure();
		case Ifc4Package.IFC_MOLECULAR_WEIGHT_MEASURE:
			return (EObject) createIfcMolecularWeightMeasure();
		case Ifc4Package.IFC_MOMENT_OF_INERTIA_MEASURE:
			return (EObject) createIfcMomentOfInertiaMeasure();
		case Ifc4Package.IFC_MONETARY_MEASURE:
			return (EObject) createIfcMonetaryMeasure();
		case Ifc4Package.IFC_MONTH_IN_YEAR_NUMBER:
			return (EObject) createIfcMonthInYearNumber();
		case Ifc4Package.IFC_NUMERIC_MEASURE:
			return (EObject) createIfcNumericMeasure();
		case Ifc4Package.IFC_PH_MEASURE:
			return (EObject) createIfcPHMeasure();
		case Ifc4Package.IFC_PARAMETER_VALUE:
			return (EObject) createIfcParameterValue();
		case Ifc4Package.IFC_PLANAR_FORCE_MEASURE:
			return (EObject) createIfcPlanarForceMeasure();
		case Ifc4Package.IFC_PLANE_ANGLE_MEASURE:
			return (EObject) createIfcPlaneAngleMeasure();
		case Ifc4Package.IFC_POWER_MEASURE:
			return (EObject) createIfcPowerMeasure();
		case Ifc4Package.IFC_PRESENTABLE_TEXT:
			return (EObject) createIfcPresentableText();
		case Ifc4Package.IFC_PRESSURE_MEASURE:
			return (EObject) createIfcPressureMeasure();
		case Ifc4Package.IFC_RADIO_ACTIVITY_MEASURE:
			return (EObject) createIfcRadioActivityMeasure();
		case Ifc4Package.IFC_RATIO_MEASURE:
			return (EObject) createIfcRatioMeasure();
		case Ifc4Package.IFC_REAL:
			return (EObject) createIfcReal();
		case Ifc4Package.IFC_ROTATIONAL_FREQUENCY_MEASURE:
			return (EObject) createIfcRotationalFrequencyMeasure();
		case Ifc4Package.IFC_ROTATIONAL_MASS_MEASURE:
			return (EObject) createIfcRotationalMassMeasure();
		case Ifc4Package.IFC_ROTATIONAL_STIFFNESS_MEASURE:
			return (EObject) createIfcRotationalStiffnessMeasure();
		case Ifc4Package.IFC_SECTION_MODULUS_MEASURE:
			return (EObject) createIfcSectionModulusMeasure();
		case Ifc4Package.IFC_SECTIONAL_AREA_INTEGRAL_MEASURE:
			return (EObject) createIfcSectionalAreaIntegralMeasure();
		case Ifc4Package.IFC_SHEAR_MODULUS_MEASURE:
			return (EObject) createIfcShearModulusMeasure();
		case Ifc4Package.IFC_SOLID_ANGLE_MEASURE:
			return (EObject) createIfcSolidAngleMeasure();
		case Ifc4Package.IFC_SOUND_POWER_LEVEL_MEASURE:
			return (EObject) createIfcSoundPowerLevelMeasure();
		case Ifc4Package.IFC_SOUND_POWER_MEASURE:
			return (EObject) createIfcSoundPowerMeasure();
		case Ifc4Package.IFC_SOUND_PRESSURE_LEVEL_MEASURE:
			return (EObject) createIfcSoundPressureLevelMeasure();
		case Ifc4Package.IFC_SOUND_PRESSURE_MEASURE:
			return (EObject) createIfcSoundPressureMeasure();
		case Ifc4Package.IFC_SPECIFIC_HEAT_CAPACITY_MEASURE:
			return (EObject) createIfcSpecificHeatCapacityMeasure();
		case Ifc4Package.IFC_SPECULAR_EXPONENT:
			return (EObject) createIfcSpecularExponent();
		case Ifc4Package.IFC_SPECULAR_ROUGHNESS:
			return (EObject) createIfcSpecularRoughness();
		case Ifc4Package.IFC_TEMPERATURE_GRADIENT_MEASURE:
			return (EObject) createIfcTemperatureGradientMeasure();
		case Ifc4Package.IFC_TEMPERATURE_RATE_OF_CHANGE_MEASURE:
			return (EObject) createIfcTemperatureRateOfChangeMeasure();
		case Ifc4Package.IFC_TEXT:
			return (EObject) createIfcText();
		case Ifc4Package.IFC_TEXT_ALIGNMENT:
			return (EObject) createIfcTextAlignment();
		case Ifc4Package.IFC_TEXT_DECORATION:
			return (EObject) createIfcTextDecoration();
		case Ifc4Package.IFC_TEXT_FONT_NAME:
			return (EObject) createIfcTextFontName();
		case Ifc4Package.IFC_TEXT_TRANSFORMATION:
			return (EObject) createIfcTextTransformation();
		case Ifc4Package.IFC_THERMAL_ADMITTANCE_MEASURE:
			return (EObject) createIfcThermalAdmittanceMeasure();
		case Ifc4Package.IFC_THERMAL_CONDUCTIVITY_MEASURE:
			return (EObject) createIfcThermalConductivityMeasure();
		case Ifc4Package.IFC_THERMAL_EXPANSION_COEFFICIENT_MEASURE:
			return (EObject) createIfcThermalExpansionCoefficientMeasure();
		case Ifc4Package.IFC_THERMAL_RESISTANCE_MEASURE:
			return (EObject) createIfcThermalResistanceMeasure();
		case Ifc4Package.IFC_THERMAL_TRANSMITTANCE_MEASURE:
			return (EObject) createIfcThermalTransmittanceMeasure();
		case Ifc4Package.IFC_THERMODYNAMIC_TEMPERATURE_MEASURE:
			return (EObject) createIfcThermodynamicTemperatureMeasure();
		case Ifc4Package.IFC_TIME:
			return (EObject) createIfcTime();
		case Ifc4Package.IFC_TIME_MEASURE:
			return (EObject) createIfcTimeMeasure();
		case Ifc4Package.IFC_TIME_STAMP:
			return (EObject) createIfcTimeStamp();
		case Ifc4Package.IFC_TORQUE_MEASURE:
			return (EObject) createIfcTorqueMeasure();
		case Ifc4Package.IFC_URI_REFERENCE:
			return (EObject) createIfcURIReference();
		case Ifc4Package.IFC_VAPOR_PERMEABILITY_MEASURE:
			return (EObject) createIfcVaporPermeabilityMeasure();
		case Ifc4Package.IFC_VOLUME_MEASURE:
			return (EObject) createIfcVolumeMeasure();
		case Ifc4Package.IFC_VOLUMETRIC_FLOW_RATE_MEASURE:
			return (EObject) createIfcVolumetricFlowRateMeasure();
		case Ifc4Package.IFC_WARPING_CONSTANT_MEASURE:
			return (EObject) createIfcWarpingConstantMeasure();
		case Ifc4Package.IFC_WARPING_MOMENT_MEASURE:
			return (EObject) createIfcWarpingMomentMeasure();
		case Ifc4Package.IFC_BOX_ALIGNMENT:
			return (EObject) createIfcBoxAlignment();
		case Ifc4Package.IFC_COMPOUND_PLANE_ANGLE_MEASURE:
			return (EObject) createIfcCompoundPlaneAngleMeasure();
		case Ifc4Package.IFC_LANGUAGE_ID:
			return (EObject) createIfcLanguageId();
		case Ifc4Package.IFC_NON_NEGATIVE_LENGTH_MEASURE:
			return (EObject) createIfcNonNegativeLengthMeasure();
		case Ifc4Package.IFC_NORMALISED_RATIO_MEASURE:
			return (EObject) createIfcNormalisedRatioMeasure();
		case Ifc4Package.IFC_POSITIVE_INTEGER:
			return (EObject) createIfcPositiveInteger();
		case Ifc4Package.IFC_POSITIVE_LENGTH_MEASURE:
			return (EObject) createIfcPositiveLengthMeasure();
		case Ifc4Package.IFC_POSITIVE_PLANE_ANGLE_MEASURE:
			return (EObject) createIfcPositivePlaneAngleMeasure();
		case Ifc4Package.IFC_POSITIVE_RATIO_MEASURE:
			return (EObject) createIfcPositiveRatioMeasure();
		case Ifc4Package.IFC_ARC_INDEX:
			return (EObject) createIfcArcIndex();
		case Ifc4Package.IFC_COMPLEX_NUMBER:
			return (EObject) createIfcComplexNumber();
		case Ifc4Package.IFC_LINE_INDEX:
			return (EObject) createIfcLineIndex();
		case Ifc4Package.IFC_NULL_STYLE:
			return (EObject) createIfcNullStyle();
		case Ifc4Package.LIST_OF_IFC_CARTESIAN_POINT:
			return (EObject) createListOfIfcCartesianPoint();
		case Ifc4Package.LIST_OF_IFC_LENGTH_MEASURE:
			return (EObject) createListOfIfcLengthMeasure();
		case Ifc4Package.LIST_OF_IFC_NORMALISED_RATIO_MEASURE:
			return (EObject) createListOfIfcNormalisedRatioMeasure();
		case Ifc4Package.LIST_OF_ELONG:
			return (EObject) createListOfELong();
		case Ifc4Package.LIST_OF_EDOUBLE:
			return (EObject) createListOfEDouble();
		case Ifc4Package.LIST_OF_IFC_PARAMETER_VALUE:
			return (EObject) createListOfIfcParameterValue();
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
		case Ifc4Package.TRISTATE:
			return createTristateFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ACTION_REQUEST_TYPE_ENUM:
			return createIfcActionRequestTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ACTION_SOURCE_TYPE_ENUM:
			return createIfcActionSourceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ACTION_TYPE_ENUM:
			return createIfcActionTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ACTUATOR_TYPE_ENUM:
			return createIfcActuatorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ADDRESS_TYPE_ENUM:
			return createIfcAddressTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_AIR_TERMINAL_BOX_TYPE_ENUM:
			return createIfcAirTerminalBoxTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_AIR_TERMINAL_TYPE_ENUM:
			return createIfcAirTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_AIR_TO_AIR_HEAT_RECOVERY_TYPE_ENUM:
			return createIfcAirToAirHeatRecoveryTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ALARM_TYPE_ENUM:
			return createIfcAlarmTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ANALYSIS_MODEL_TYPE_ENUM:
			return createIfcAnalysisModelTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ANALYSIS_THEORY_TYPE_ENUM:
			return createIfcAnalysisTheoryTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ARITHMETIC_OPERATOR_ENUM:
			return createIfcArithmeticOperatorEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ASSEMBLY_PLACE_ENUM:
			return createIfcAssemblyPlaceEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_AUDIO_VISUAL_APPLIANCE_TYPE_ENUM:
			return createIfcAudioVisualApplianceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BSPLINE_CURVE_FORM:
			return createIfcBSplineCurveFormFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BSPLINE_SURFACE_FORM:
			return createIfcBSplineSurfaceFormFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BEAM_TYPE_ENUM:
			return createIfcBeamTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BENCHMARK_ENUM:
			return createIfcBenchmarkEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BOILER_TYPE_ENUM:
			return createIfcBoilerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BOOLEAN_OPERATOR:
			return createIfcBooleanOperatorFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BUILDING_ELEMENT_PART_TYPE_ENUM:
			return createIfcBuildingElementPartTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BUILDING_ELEMENT_PROXY_TYPE_ENUM:
			return createIfcBuildingElementProxyTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BUILDING_SYSTEM_TYPE_ENUM:
			return createIfcBuildingSystemTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_BURNER_TYPE_ENUM:
			return createIfcBurnerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CABLE_CARRIER_FITTING_TYPE_ENUM:
			return createIfcCableCarrierFittingTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CABLE_CARRIER_SEGMENT_TYPE_ENUM:
			return createIfcCableCarrierSegmentTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CABLE_FITTING_TYPE_ENUM:
			return createIfcCableFittingTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CABLE_SEGMENT_TYPE_ENUM:
			return createIfcCableSegmentTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CHANGE_ACTION_ENUM:
			return createIfcChangeActionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CHILLER_TYPE_ENUM:
			return createIfcChillerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CHIMNEY_TYPE_ENUM:
			return createIfcChimneyTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COIL_TYPE_ENUM:
			return createIfcCoilTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COLUMN_TYPE_ENUM:
			return createIfcColumnTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COMMUNICATIONS_APPLIANCE_TYPE_ENUM:
			return createIfcCommunicationsApplianceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COMPLEX_PROPERTY_TEMPLATE_TYPE_ENUM:
			return createIfcComplexPropertyTemplateTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COMPRESSOR_TYPE_ENUM:
			return createIfcCompressorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CONDENSER_TYPE_ENUM:
			return createIfcCondenserTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CONNECTION_TYPE_ENUM:
			return createIfcConnectionTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CONSTRAINT_ENUM:
			return createIfcConstraintEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CONSTRUCTION_EQUIPMENT_RESOURCE_TYPE_ENUM:
			return createIfcConstructionEquipmentResourceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CONSTRUCTION_MATERIAL_RESOURCE_TYPE_ENUM:
			return createIfcConstructionMaterialResourceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CONSTRUCTION_PRODUCT_RESOURCE_TYPE_ENUM:
			return createIfcConstructionProductResourceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CONTROLLER_TYPE_ENUM:
			return createIfcControllerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COOLED_BEAM_TYPE_ENUM:
			return createIfcCooledBeamTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COOLING_TOWER_TYPE_ENUM:
			return createIfcCoolingTowerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COST_ITEM_TYPE_ENUM:
			return createIfcCostItemTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COST_SCHEDULE_TYPE_ENUM:
			return createIfcCostScheduleTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_COVERING_TYPE_ENUM:
			return createIfcCoveringTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CREW_RESOURCE_TYPE_ENUM:
			return createIfcCrewResourceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CURTAIN_WALL_TYPE_ENUM:
			return createIfcCurtainWallTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_CURVE_INTERPOLATION_ENUM:
			return createIfcCurveInterpolationEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DAMPER_TYPE_ENUM:
			return createIfcDamperTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DATA_ORIGIN_ENUM:
			return createIfcDataOriginEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DERIVED_UNIT_ENUM:
			return createIfcDerivedUnitEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DIRECTION_SENSE_ENUM:
			return createIfcDirectionSenseEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DISCRETE_ACCESSORY_TYPE_ENUM:
			return createIfcDiscreteAccessoryTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT_TYPE_ENUM:
			return createIfcDistributionChamberElementTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DISTRIBUTION_PORT_TYPE_ENUM:
			return createIfcDistributionPortTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DISTRIBUTION_SYSTEM_ENUM:
			return createIfcDistributionSystemEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DOCUMENT_CONFIDENTIALITY_ENUM:
			return createIfcDocumentConfidentialityEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DOCUMENT_STATUS_ENUM:
			return createIfcDocumentStatusEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DOOR_PANEL_OPERATION_ENUM:
			return createIfcDoorPanelOperationEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DOOR_PANEL_POSITION_ENUM:
			return createIfcDoorPanelPositionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DOOR_STYLE_CONSTRUCTION_ENUM:
			return createIfcDoorStyleConstructionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DOOR_STYLE_OPERATION_ENUM:
			return createIfcDoorStyleOperationEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DOOR_TYPE_ENUM:
			return createIfcDoorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DOOR_TYPE_OPERATION_ENUM:
			return createIfcDoorTypeOperationEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DUCT_FITTING_TYPE_ENUM:
			return createIfcDuctFittingTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DUCT_SEGMENT_TYPE_ENUM:
			return createIfcDuctSegmentTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_DUCT_SILENCER_TYPE_ENUM:
			return createIfcDuctSilencerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ELECTRIC_APPLIANCE_TYPE_ENUM:
			return createIfcElectricApplianceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ELECTRIC_DISTRIBUTION_BOARD_TYPE_ENUM:
			return createIfcElectricDistributionBoardTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ELECTRIC_FLOW_STORAGE_DEVICE_TYPE_ENUM:
			return createIfcElectricFlowStorageDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ELECTRIC_GENERATOR_TYPE_ENUM:
			return createIfcElectricGeneratorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ELECTRIC_MOTOR_TYPE_ENUM:
			return createIfcElectricMotorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ELECTRIC_TIME_CONTROL_TYPE_ENUM:
			return createIfcElectricTimeControlTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ELEMENT_ASSEMBLY_TYPE_ENUM:
			return createIfcElementAssemblyTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ELEMENT_COMPOSITION_ENUM:
			return createIfcElementCompositionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ENGINE_TYPE_ENUM:
			return createIfcEngineTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_EVAPORATIVE_COOLER_TYPE_ENUM:
			return createIfcEvaporativeCoolerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_EVAPORATOR_TYPE_ENUM:
			return createIfcEvaporatorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_EVENT_TRIGGER_TYPE_ENUM:
			return createIfcEventTriggerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_EVENT_TYPE_ENUM:
			return createIfcEventTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_EXTERNAL_SPATIAL_ELEMENT_TYPE_ENUM:
			return createIfcExternalSpatialElementTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FAN_TYPE_ENUM:
			return createIfcFanTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FASTENER_TYPE_ENUM:
			return createIfcFastenerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FILTER_TYPE_ENUM:
			return createIfcFilterTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FIRE_SUPPRESSION_TERMINAL_TYPE_ENUM:
			return createIfcFireSuppressionTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FLOW_DIRECTION_ENUM:
			return createIfcFlowDirectionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FLOW_INSTRUMENT_TYPE_ENUM:
			return createIfcFlowInstrumentTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FLOW_METER_TYPE_ENUM:
			return createIfcFlowMeterTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FOOTING_TYPE_ENUM:
			return createIfcFootingTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_FURNITURE_TYPE_ENUM:
			return createIfcFurnitureTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_GEOGRAPHIC_ELEMENT_TYPE_ENUM:
			return createIfcGeographicElementTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_GEOMETRIC_PROJECTION_ENUM:
			return createIfcGeometricProjectionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_GLOBAL_OR_LOCAL_ENUM:
			return createIfcGlobalOrLocalEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_GRID_TYPE_ENUM:
			return createIfcGridTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_HEAT_EXCHANGER_TYPE_ENUM:
			return createIfcHeatExchangerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_HUMIDIFIER_TYPE_ENUM:
			return createIfcHumidifierTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_INTERCEPTOR_TYPE_ENUM:
			return createIfcInterceptorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_INTERNAL_OR_EXTERNAL_ENUM:
			return createIfcInternalOrExternalEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_INVENTORY_TYPE_ENUM:
			return createIfcInventoryTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_JUNCTION_BOX_TYPE_ENUM:
			return createIfcJunctionBoxTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_KNOT_TYPE:
			return createIfcKnotTypeFromString(eDataType, initialValue);
		case Ifc4Package.IFC_LABOR_RESOURCE_TYPE_ENUM:
			return createIfcLaborResourceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_LAMP_TYPE_ENUM:
			return createIfcLampTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_LAYER_SET_DIRECTION_ENUM:
			return createIfcLayerSetDirectionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_LIGHT_DISTRIBUTION_CURVE_ENUM:
			return createIfcLightDistributionCurveEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_LIGHT_EMISSION_SOURCE_ENUM:
			return createIfcLightEmissionSourceEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_LIGHT_FIXTURE_TYPE_ENUM:
			return createIfcLightFixtureTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_LOAD_GROUP_TYPE_ENUM:
			return createIfcLoadGroupTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_LOGICAL_OPERATOR_ENUM:
			return createIfcLogicalOperatorEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_MECHANICAL_FASTENER_TYPE_ENUM:
			return createIfcMechanicalFastenerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_MEDICAL_DEVICE_TYPE_ENUM:
			return createIfcMedicalDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_MEMBER_TYPE_ENUM:
			return createIfcMemberTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_MOTOR_CONNECTION_TYPE_ENUM:
			return createIfcMotorConnectionTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_NULL_STYLE_ENUM:
			return createIfcNullStyleEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_OBJECT_TYPE_ENUM:
			return createIfcObjectTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_OBJECTIVE_ENUM:
			return createIfcObjectiveEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_OCCUPANT_TYPE_ENUM:
			return createIfcOccupantTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_OPENING_ELEMENT_TYPE_ENUM:
			return createIfcOpeningElementTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_OUTLET_TYPE_ENUM:
			return createIfcOutletTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PERFORMANCE_HISTORY_TYPE_ENUM:
			return createIfcPerformanceHistoryTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PERMEABLE_COVERING_OPERATION_ENUM:
			return createIfcPermeableCoveringOperationEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PERMIT_TYPE_ENUM:
			return createIfcPermitTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PHYSICAL_OR_VIRTUAL_ENUM:
			return createIfcPhysicalOrVirtualEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PILE_CONSTRUCTION_ENUM:
			return createIfcPileConstructionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PILE_TYPE_ENUM:
			return createIfcPileTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PIPE_FITTING_TYPE_ENUM:
			return createIfcPipeFittingTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PIPE_SEGMENT_TYPE_ENUM:
			return createIfcPipeSegmentTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PLATE_TYPE_ENUM:
			return createIfcPlateTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PREFERRED_SURFACE_CURVE_REPRESENTATION:
			return createIfcPreferredSurfaceCurveRepresentationFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PROCEDURE_TYPE_ENUM:
			return createIfcProcedureTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PROFILE_TYPE_ENUM:
			return createIfcProfileTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PROJECT_ORDER_TYPE_ENUM:
			return createIfcProjectOrderTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PROJECTED_OR_TRUE_LENGTH_ENUM:
			return createIfcProjectedOrTrueLengthEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PROJECTION_ELEMENT_TYPE_ENUM:
			return createIfcProjectionElementTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PROPERTY_SET_TEMPLATE_TYPE_ENUM:
			return createIfcPropertySetTemplateTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PROTECTIVE_DEVICE_TRIPPING_UNIT_TYPE_ENUM:
			return createIfcProtectiveDeviceTrippingUnitTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PROTECTIVE_DEVICE_TYPE_ENUM:
			return createIfcProtectiveDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_PUMP_TYPE_ENUM:
			return createIfcPumpTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_RAILING_TYPE_ENUM:
			return createIfcRailingTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_RAMP_FLIGHT_TYPE_ENUM:
			return createIfcRampFlightTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_RAMP_TYPE_ENUM:
			return createIfcRampTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_RECURRENCE_TYPE_ENUM:
			return createIfcRecurrenceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_REFLECTANCE_METHOD_ENUM:
			return createIfcReflectanceMethodEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_REINFORCING_BAR_ROLE_ENUM:
			return createIfcReinforcingBarRoleEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_REINFORCING_BAR_SURFACE_ENUM:
			return createIfcReinforcingBarSurfaceEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_REINFORCING_BAR_TYPE_ENUM:
			return createIfcReinforcingBarTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_REINFORCING_MESH_TYPE_ENUM:
			return createIfcReinforcingMeshTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ROLE_ENUM:
			return createIfcRoleEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_ROOF_TYPE_ENUM:
			return createIfcRoofTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SI_PREFIX:
			return createIfcSIPrefixFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SI_UNIT_NAME:
			return createIfcSIUnitNameFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SANITARY_TERMINAL_TYPE_ENUM:
			return createIfcSanitaryTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SECTION_TYPE_ENUM:
			return createIfcSectionTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SENSOR_TYPE_ENUM:
			return createIfcSensorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SEQUENCE_ENUM:
			return createIfcSequenceEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SHADING_DEVICE_TYPE_ENUM:
			return createIfcShadingDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SIMPLE_PROPERTY_TEMPLATE_TYPE_ENUM:
			return createIfcSimplePropertyTemplateTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SLAB_TYPE_ENUM:
			return createIfcSlabTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SOLAR_DEVICE_TYPE_ENUM:
			return createIfcSolarDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SPACE_HEATER_TYPE_ENUM:
			return createIfcSpaceHeaterTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SPACE_TYPE_ENUM:
			return createIfcSpaceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SPATIAL_ZONE_TYPE_ENUM:
			return createIfcSpatialZoneTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_STACK_TERMINAL_TYPE_ENUM:
			return createIfcStackTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_STAIR_FLIGHT_TYPE_ENUM:
			return createIfcStairFlightTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_STAIR_TYPE_ENUM:
			return createIfcStairTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_STATE_ENUM:
			return createIfcStateEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_STRUCTURAL_CURVE_ACTIVITY_TYPE_ENUM:
			return createIfcStructuralCurveActivityTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_STRUCTURAL_CURVE_MEMBER_TYPE_ENUM:
			return createIfcStructuralCurveMemberTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_ACTIVITY_TYPE_ENUM:
			return createIfcStructuralSurfaceActivityTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_MEMBER_TYPE_ENUM:
			return createIfcStructuralSurfaceMemberTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SUB_CONTRACT_RESOURCE_TYPE_ENUM:
			return createIfcSubContractResourceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SURFACE_FEATURE_TYPE_ENUM:
			return createIfcSurfaceFeatureTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SURFACE_SIDE:
			return createIfcSurfaceSideFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SWITCHING_DEVICE_TYPE_ENUM:
			return createIfcSwitchingDeviceTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_SYSTEM_FURNITURE_ELEMENT_TYPE_ENUM:
			return createIfcSystemFurnitureElementTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TANK_TYPE_ENUM:
			return createIfcTankTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TASK_DURATION_ENUM:
			return createIfcTaskDurationEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TASK_TYPE_ENUM:
			return createIfcTaskTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TENDON_ANCHOR_TYPE_ENUM:
			return createIfcTendonAnchorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TENDON_TYPE_ENUM:
			return createIfcTendonTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TEXT_PATH:
			return createIfcTextPathFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TIME_SERIES_DATA_TYPE_ENUM:
			return createIfcTimeSeriesDataTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TRANSFORMER_TYPE_ENUM:
			return createIfcTransformerTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TRANSITION_CODE:
			return createIfcTransitionCodeFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TRANSPORT_ELEMENT_TYPE_ENUM:
			return createIfcTransportElementTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TRIMMING_PREFERENCE:
			return createIfcTrimmingPreferenceFromString(eDataType, initialValue);
		case Ifc4Package.IFC_TUBE_BUNDLE_TYPE_ENUM:
			return createIfcTubeBundleTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_UNIT_ENUM:
			return createIfcUnitEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_UNITARY_CONTROL_ELEMENT_TYPE_ENUM:
			return createIfcUnitaryControlElementTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_UNITARY_EQUIPMENT_TYPE_ENUM:
			return createIfcUnitaryEquipmentTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_VALVE_TYPE_ENUM:
			return createIfcValveTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_VIBRATION_ISOLATOR_TYPE_ENUM:
			return createIfcVibrationIsolatorTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_VOIDING_FEATURE_TYPE_ENUM:
			return createIfcVoidingFeatureTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WALL_TYPE_ENUM:
			return createIfcWallTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WASTE_TERMINAL_TYPE_ENUM:
			return createIfcWasteTerminalTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WINDOW_PANEL_OPERATION_ENUM:
			return createIfcWindowPanelOperationEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WINDOW_PANEL_POSITION_ENUM:
			return createIfcWindowPanelPositionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WINDOW_STYLE_CONSTRUCTION_ENUM:
			return createIfcWindowStyleConstructionEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WINDOW_STYLE_OPERATION_ENUM:
			return createIfcWindowStyleOperationEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WINDOW_TYPE_ENUM:
			return createIfcWindowTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WINDOW_TYPE_PARTITIONING_ENUM:
			return createIfcWindowTypePartitioningEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WORK_CALENDAR_TYPE_ENUM:
			return createIfcWorkCalendarTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WORK_PLAN_TYPE_ENUM:
			return createIfcWorkPlanTypeEnumFromString(eDataType, initialValue);
		case Ifc4Package.IFC_WORK_SCHEDULE_TYPE_ENUM:
			return createIfcWorkScheduleTypeEnumFromString(eDataType, initialValue);
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
		case Ifc4Package.TRISTATE:
			return convertTristateToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ACTION_REQUEST_TYPE_ENUM:
			return convertIfcActionRequestTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ACTION_SOURCE_TYPE_ENUM:
			return convertIfcActionSourceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ACTION_TYPE_ENUM:
			return convertIfcActionTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ACTUATOR_TYPE_ENUM:
			return convertIfcActuatorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ADDRESS_TYPE_ENUM:
			return convertIfcAddressTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_AIR_TERMINAL_BOX_TYPE_ENUM:
			return convertIfcAirTerminalBoxTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_AIR_TERMINAL_TYPE_ENUM:
			return convertIfcAirTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_AIR_TO_AIR_HEAT_RECOVERY_TYPE_ENUM:
			return convertIfcAirToAirHeatRecoveryTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ALARM_TYPE_ENUM:
			return convertIfcAlarmTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ANALYSIS_MODEL_TYPE_ENUM:
			return convertIfcAnalysisModelTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ANALYSIS_THEORY_TYPE_ENUM:
			return convertIfcAnalysisTheoryTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ARITHMETIC_OPERATOR_ENUM:
			return convertIfcArithmeticOperatorEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ASSEMBLY_PLACE_ENUM:
			return convertIfcAssemblyPlaceEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_AUDIO_VISUAL_APPLIANCE_TYPE_ENUM:
			return convertIfcAudioVisualApplianceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BSPLINE_CURVE_FORM:
			return convertIfcBSplineCurveFormToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BSPLINE_SURFACE_FORM:
			return convertIfcBSplineSurfaceFormToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BEAM_TYPE_ENUM:
			return convertIfcBeamTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BENCHMARK_ENUM:
			return convertIfcBenchmarkEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BOILER_TYPE_ENUM:
			return convertIfcBoilerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BOOLEAN_OPERATOR:
			return convertIfcBooleanOperatorToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BUILDING_ELEMENT_PART_TYPE_ENUM:
			return convertIfcBuildingElementPartTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BUILDING_ELEMENT_PROXY_TYPE_ENUM:
			return convertIfcBuildingElementProxyTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BUILDING_SYSTEM_TYPE_ENUM:
			return convertIfcBuildingSystemTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_BURNER_TYPE_ENUM:
			return convertIfcBurnerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CABLE_CARRIER_FITTING_TYPE_ENUM:
			return convertIfcCableCarrierFittingTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CABLE_CARRIER_SEGMENT_TYPE_ENUM:
			return convertIfcCableCarrierSegmentTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CABLE_FITTING_TYPE_ENUM:
			return convertIfcCableFittingTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CABLE_SEGMENT_TYPE_ENUM:
			return convertIfcCableSegmentTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CHANGE_ACTION_ENUM:
			return convertIfcChangeActionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CHILLER_TYPE_ENUM:
			return convertIfcChillerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CHIMNEY_TYPE_ENUM:
			return convertIfcChimneyTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COIL_TYPE_ENUM:
			return convertIfcCoilTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COLUMN_TYPE_ENUM:
			return convertIfcColumnTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COMMUNICATIONS_APPLIANCE_TYPE_ENUM:
			return convertIfcCommunicationsApplianceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COMPLEX_PROPERTY_TEMPLATE_TYPE_ENUM:
			return convertIfcComplexPropertyTemplateTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COMPRESSOR_TYPE_ENUM:
			return convertIfcCompressorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CONDENSER_TYPE_ENUM:
			return convertIfcCondenserTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CONNECTION_TYPE_ENUM:
			return convertIfcConnectionTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CONSTRAINT_ENUM:
			return convertIfcConstraintEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CONSTRUCTION_EQUIPMENT_RESOURCE_TYPE_ENUM:
			return convertIfcConstructionEquipmentResourceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CONSTRUCTION_MATERIAL_RESOURCE_TYPE_ENUM:
			return convertIfcConstructionMaterialResourceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CONSTRUCTION_PRODUCT_RESOURCE_TYPE_ENUM:
			return convertIfcConstructionProductResourceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CONTROLLER_TYPE_ENUM:
			return convertIfcControllerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COOLED_BEAM_TYPE_ENUM:
			return convertIfcCooledBeamTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COOLING_TOWER_TYPE_ENUM:
			return convertIfcCoolingTowerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COST_ITEM_TYPE_ENUM:
			return convertIfcCostItemTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COST_SCHEDULE_TYPE_ENUM:
			return convertIfcCostScheduleTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_COVERING_TYPE_ENUM:
			return convertIfcCoveringTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CREW_RESOURCE_TYPE_ENUM:
			return convertIfcCrewResourceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CURTAIN_WALL_TYPE_ENUM:
			return convertIfcCurtainWallTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_CURVE_INTERPOLATION_ENUM:
			return convertIfcCurveInterpolationEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DAMPER_TYPE_ENUM:
			return convertIfcDamperTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DATA_ORIGIN_ENUM:
			return convertIfcDataOriginEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DERIVED_UNIT_ENUM:
			return convertIfcDerivedUnitEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DIRECTION_SENSE_ENUM:
			return convertIfcDirectionSenseEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DISCRETE_ACCESSORY_TYPE_ENUM:
			return convertIfcDiscreteAccessoryTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT_TYPE_ENUM:
			return convertIfcDistributionChamberElementTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DISTRIBUTION_PORT_TYPE_ENUM:
			return convertIfcDistributionPortTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DISTRIBUTION_SYSTEM_ENUM:
			return convertIfcDistributionSystemEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DOCUMENT_CONFIDENTIALITY_ENUM:
			return convertIfcDocumentConfidentialityEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DOCUMENT_STATUS_ENUM:
			return convertIfcDocumentStatusEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DOOR_PANEL_OPERATION_ENUM:
			return convertIfcDoorPanelOperationEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DOOR_PANEL_POSITION_ENUM:
			return convertIfcDoorPanelPositionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DOOR_STYLE_CONSTRUCTION_ENUM:
			return convertIfcDoorStyleConstructionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DOOR_STYLE_OPERATION_ENUM:
			return convertIfcDoorStyleOperationEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DOOR_TYPE_ENUM:
			return convertIfcDoorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DOOR_TYPE_OPERATION_ENUM:
			return convertIfcDoorTypeOperationEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DUCT_FITTING_TYPE_ENUM:
			return convertIfcDuctFittingTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DUCT_SEGMENT_TYPE_ENUM:
			return convertIfcDuctSegmentTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_DUCT_SILENCER_TYPE_ENUM:
			return convertIfcDuctSilencerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ELECTRIC_APPLIANCE_TYPE_ENUM:
			return convertIfcElectricApplianceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ELECTRIC_DISTRIBUTION_BOARD_TYPE_ENUM:
			return convertIfcElectricDistributionBoardTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ELECTRIC_FLOW_STORAGE_DEVICE_TYPE_ENUM:
			return convertIfcElectricFlowStorageDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ELECTRIC_GENERATOR_TYPE_ENUM:
			return convertIfcElectricGeneratorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ELECTRIC_MOTOR_TYPE_ENUM:
			return convertIfcElectricMotorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ELECTRIC_TIME_CONTROL_TYPE_ENUM:
			return convertIfcElectricTimeControlTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ELEMENT_ASSEMBLY_TYPE_ENUM:
			return convertIfcElementAssemblyTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ELEMENT_COMPOSITION_ENUM:
			return convertIfcElementCompositionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ENGINE_TYPE_ENUM:
			return convertIfcEngineTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_EVAPORATIVE_COOLER_TYPE_ENUM:
			return convertIfcEvaporativeCoolerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_EVAPORATOR_TYPE_ENUM:
			return convertIfcEvaporatorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_EVENT_TRIGGER_TYPE_ENUM:
			return convertIfcEventTriggerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_EVENT_TYPE_ENUM:
			return convertIfcEventTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_EXTERNAL_SPATIAL_ELEMENT_TYPE_ENUM:
			return convertIfcExternalSpatialElementTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FAN_TYPE_ENUM:
			return convertIfcFanTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FASTENER_TYPE_ENUM:
			return convertIfcFastenerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FILTER_TYPE_ENUM:
			return convertIfcFilterTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FIRE_SUPPRESSION_TERMINAL_TYPE_ENUM:
			return convertIfcFireSuppressionTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FLOW_DIRECTION_ENUM:
			return convertIfcFlowDirectionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FLOW_INSTRUMENT_TYPE_ENUM:
			return convertIfcFlowInstrumentTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FLOW_METER_TYPE_ENUM:
			return convertIfcFlowMeterTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FOOTING_TYPE_ENUM:
			return convertIfcFootingTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_FURNITURE_TYPE_ENUM:
			return convertIfcFurnitureTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_GEOGRAPHIC_ELEMENT_TYPE_ENUM:
			return convertIfcGeographicElementTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_GEOMETRIC_PROJECTION_ENUM:
			return convertIfcGeometricProjectionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_GLOBAL_OR_LOCAL_ENUM:
			return convertIfcGlobalOrLocalEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_GRID_TYPE_ENUM:
			return convertIfcGridTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_HEAT_EXCHANGER_TYPE_ENUM:
			return convertIfcHeatExchangerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_HUMIDIFIER_TYPE_ENUM:
			return convertIfcHumidifierTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_INTERCEPTOR_TYPE_ENUM:
			return convertIfcInterceptorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_INTERNAL_OR_EXTERNAL_ENUM:
			return convertIfcInternalOrExternalEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_INVENTORY_TYPE_ENUM:
			return convertIfcInventoryTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_JUNCTION_BOX_TYPE_ENUM:
			return convertIfcJunctionBoxTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_KNOT_TYPE:
			return convertIfcKnotTypeToString(eDataType, instanceValue);
		case Ifc4Package.IFC_LABOR_RESOURCE_TYPE_ENUM:
			return convertIfcLaborResourceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_LAMP_TYPE_ENUM:
			return convertIfcLampTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_LAYER_SET_DIRECTION_ENUM:
			return convertIfcLayerSetDirectionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_LIGHT_DISTRIBUTION_CURVE_ENUM:
			return convertIfcLightDistributionCurveEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_LIGHT_EMISSION_SOURCE_ENUM:
			return convertIfcLightEmissionSourceEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_LIGHT_FIXTURE_TYPE_ENUM:
			return convertIfcLightFixtureTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_LOAD_GROUP_TYPE_ENUM:
			return convertIfcLoadGroupTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_LOGICAL_OPERATOR_ENUM:
			return convertIfcLogicalOperatorEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_MECHANICAL_FASTENER_TYPE_ENUM:
			return convertIfcMechanicalFastenerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_MEDICAL_DEVICE_TYPE_ENUM:
			return convertIfcMedicalDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_MEMBER_TYPE_ENUM:
			return convertIfcMemberTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_MOTOR_CONNECTION_TYPE_ENUM:
			return convertIfcMotorConnectionTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_NULL_STYLE_ENUM:
			return convertIfcNullStyleEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_OBJECT_TYPE_ENUM:
			return convertIfcObjectTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_OBJECTIVE_ENUM:
			return convertIfcObjectiveEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_OCCUPANT_TYPE_ENUM:
			return convertIfcOccupantTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_OPENING_ELEMENT_TYPE_ENUM:
			return convertIfcOpeningElementTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_OUTLET_TYPE_ENUM:
			return convertIfcOutletTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PERFORMANCE_HISTORY_TYPE_ENUM:
			return convertIfcPerformanceHistoryTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PERMEABLE_COVERING_OPERATION_ENUM:
			return convertIfcPermeableCoveringOperationEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PERMIT_TYPE_ENUM:
			return convertIfcPermitTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PHYSICAL_OR_VIRTUAL_ENUM:
			return convertIfcPhysicalOrVirtualEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PILE_CONSTRUCTION_ENUM:
			return convertIfcPileConstructionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PILE_TYPE_ENUM:
			return convertIfcPileTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PIPE_FITTING_TYPE_ENUM:
			return convertIfcPipeFittingTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PIPE_SEGMENT_TYPE_ENUM:
			return convertIfcPipeSegmentTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PLATE_TYPE_ENUM:
			return convertIfcPlateTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PREFERRED_SURFACE_CURVE_REPRESENTATION:
			return convertIfcPreferredSurfaceCurveRepresentationToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PROCEDURE_TYPE_ENUM:
			return convertIfcProcedureTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PROFILE_TYPE_ENUM:
			return convertIfcProfileTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PROJECT_ORDER_TYPE_ENUM:
			return convertIfcProjectOrderTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PROJECTED_OR_TRUE_LENGTH_ENUM:
			return convertIfcProjectedOrTrueLengthEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PROJECTION_ELEMENT_TYPE_ENUM:
			return convertIfcProjectionElementTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PROPERTY_SET_TEMPLATE_TYPE_ENUM:
			return convertIfcPropertySetTemplateTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PROTECTIVE_DEVICE_TRIPPING_UNIT_TYPE_ENUM:
			return convertIfcProtectiveDeviceTrippingUnitTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PROTECTIVE_DEVICE_TYPE_ENUM:
			return convertIfcProtectiveDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_PUMP_TYPE_ENUM:
			return convertIfcPumpTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_RAILING_TYPE_ENUM:
			return convertIfcRailingTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_RAMP_FLIGHT_TYPE_ENUM:
			return convertIfcRampFlightTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_RAMP_TYPE_ENUM:
			return convertIfcRampTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_RECURRENCE_TYPE_ENUM:
			return convertIfcRecurrenceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_REFLECTANCE_METHOD_ENUM:
			return convertIfcReflectanceMethodEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_REINFORCING_BAR_ROLE_ENUM:
			return convertIfcReinforcingBarRoleEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_REINFORCING_BAR_SURFACE_ENUM:
			return convertIfcReinforcingBarSurfaceEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_REINFORCING_BAR_TYPE_ENUM:
			return convertIfcReinforcingBarTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_REINFORCING_MESH_TYPE_ENUM:
			return convertIfcReinforcingMeshTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ROLE_ENUM:
			return convertIfcRoleEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_ROOF_TYPE_ENUM:
			return convertIfcRoofTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SI_PREFIX:
			return convertIfcSIPrefixToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SI_UNIT_NAME:
			return convertIfcSIUnitNameToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SANITARY_TERMINAL_TYPE_ENUM:
			return convertIfcSanitaryTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SECTION_TYPE_ENUM:
			return convertIfcSectionTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SENSOR_TYPE_ENUM:
			return convertIfcSensorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SEQUENCE_ENUM:
			return convertIfcSequenceEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SHADING_DEVICE_TYPE_ENUM:
			return convertIfcShadingDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SIMPLE_PROPERTY_TEMPLATE_TYPE_ENUM:
			return convertIfcSimplePropertyTemplateTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SLAB_TYPE_ENUM:
			return convertIfcSlabTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SOLAR_DEVICE_TYPE_ENUM:
			return convertIfcSolarDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SPACE_HEATER_TYPE_ENUM:
			return convertIfcSpaceHeaterTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SPACE_TYPE_ENUM:
			return convertIfcSpaceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SPATIAL_ZONE_TYPE_ENUM:
			return convertIfcSpatialZoneTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_STACK_TERMINAL_TYPE_ENUM:
			return convertIfcStackTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_STAIR_FLIGHT_TYPE_ENUM:
			return convertIfcStairFlightTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_STAIR_TYPE_ENUM:
			return convertIfcStairTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_STATE_ENUM:
			return convertIfcStateEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_STRUCTURAL_CURVE_ACTIVITY_TYPE_ENUM:
			return convertIfcStructuralCurveActivityTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_STRUCTURAL_CURVE_MEMBER_TYPE_ENUM:
			return convertIfcStructuralCurveMemberTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_ACTIVITY_TYPE_ENUM:
			return convertIfcStructuralSurfaceActivityTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_STRUCTURAL_SURFACE_MEMBER_TYPE_ENUM:
			return convertIfcStructuralSurfaceMemberTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SUB_CONTRACT_RESOURCE_TYPE_ENUM:
			return convertIfcSubContractResourceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SURFACE_FEATURE_TYPE_ENUM:
			return convertIfcSurfaceFeatureTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SURFACE_SIDE:
			return convertIfcSurfaceSideToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SWITCHING_DEVICE_TYPE_ENUM:
			return convertIfcSwitchingDeviceTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_SYSTEM_FURNITURE_ELEMENT_TYPE_ENUM:
			return convertIfcSystemFurnitureElementTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TANK_TYPE_ENUM:
			return convertIfcTankTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TASK_DURATION_ENUM:
			return convertIfcTaskDurationEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TASK_TYPE_ENUM:
			return convertIfcTaskTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TENDON_ANCHOR_TYPE_ENUM:
			return convertIfcTendonAnchorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TENDON_TYPE_ENUM:
			return convertIfcTendonTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TEXT_PATH:
			return convertIfcTextPathToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TIME_SERIES_DATA_TYPE_ENUM:
			return convertIfcTimeSeriesDataTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TRANSFORMER_TYPE_ENUM:
			return convertIfcTransformerTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TRANSITION_CODE:
			return convertIfcTransitionCodeToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TRANSPORT_ELEMENT_TYPE_ENUM:
			return convertIfcTransportElementTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TRIMMING_PREFERENCE:
			return convertIfcTrimmingPreferenceToString(eDataType, instanceValue);
		case Ifc4Package.IFC_TUBE_BUNDLE_TYPE_ENUM:
			return convertIfcTubeBundleTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_UNIT_ENUM:
			return convertIfcUnitEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_UNITARY_CONTROL_ELEMENT_TYPE_ENUM:
			return convertIfcUnitaryControlElementTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_UNITARY_EQUIPMENT_TYPE_ENUM:
			return convertIfcUnitaryEquipmentTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_VALVE_TYPE_ENUM:
			return convertIfcValveTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_VIBRATION_ISOLATOR_TYPE_ENUM:
			return convertIfcVibrationIsolatorTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_VOIDING_FEATURE_TYPE_ENUM:
			return convertIfcVoidingFeatureTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WALL_TYPE_ENUM:
			return convertIfcWallTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WASTE_TERMINAL_TYPE_ENUM:
			return convertIfcWasteTerminalTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WINDOW_PANEL_OPERATION_ENUM:
			return convertIfcWindowPanelOperationEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WINDOW_PANEL_POSITION_ENUM:
			return convertIfcWindowPanelPositionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WINDOW_STYLE_CONSTRUCTION_ENUM:
			return convertIfcWindowStyleConstructionEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WINDOW_STYLE_OPERATION_ENUM:
			return convertIfcWindowStyleOperationEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WINDOW_TYPE_ENUM:
			return convertIfcWindowTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WINDOW_TYPE_PARTITIONING_ENUM:
			return convertIfcWindowTypePartitioningEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WORK_CALENDAR_TYPE_ENUM:
			return convertIfcWorkCalendarTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WORK_PLAN_TYPE_ENUM:
			return convertIfcWorkPlanTypeEnumToString(eDataType, instanceValue);
		case Ifc4Package.IFC_WORK_SCHEDULE_TYPE_ENUM:
			return convertIfcWorkScheduleTypeEnumToString(eDataType, instanceValue);
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
	public IfcActionRequest createIfcActionRequest() {
		IfcActionRequestImpl ifcActionRequest = new IfcActionRequestImpl();
		return ifcActionRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActor createIfcActor() {
		IfcActorImpl ifcActor = new IfcActorImpl();
		return ifcActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActorRole createIfcActorRole() {
		IfcActorRoleImpl ifcActorRole = new IfcActorRoleImpl();
		return ifcActorRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActuator createIfcActuator() {
		IfcActuatorImpl ifcActuator = new IfcActuatorImpl();
		return ifcActuator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcActuatorType createIfcActuatorType() {
		IfcActuatorTypeImpl ifcActuatorType = new IfcActuatorTypeImpl();
		return ifcActuatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAddress createIfcAddress() {
		IfcAddressImpl ifcAddress = new IfcAddressImpl();
		return ifcAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAdvancedBrep createIfcAdvancedBrep() {
		IfcAdvancedBrepImpl ifcAdvancedBrep = new IfcAdvancedBrepImpl();
		return ifcAdvancedBrep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAdvancedBrepWithVoids createIfcAdvancedBrepWithVoids() {
		IfcAdvancedBrepWithVoidsImpl ifcAdvancedBrepWithVoids = new IfcAdvancedBrepWithVoidsImpl();
		return ifcAdvancedBrepWithVoids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAdvancedFace createIfcAdvancedFace() {
		IfcAdvancedFaceImpl ifcAdvancedFace = new IfcAdvancedFaceImpl();
		return ifcAdvancedFace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAirTerminal createIfcAirTerminal() {
		IfcAirTerminalImpl ifcAirTerminal = new IfcAirTerminalImpl();
		return ifcAirTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAirTerminalBox createIfcAirTerminalBox() {
		IfcAirTerminalBoxImpl ifcAirTerminalBox = new IfcAirTerminalBoxImpl();
		return ifcAirTerminalBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAirTerminalBoxType createIfcAirTerminalBoxType() {
		IfcAirTerminalBoxTypeImpl ifcAirTerminalBoxType = new IfcAirTerminalBoxTypeImpl();
		return ifcAirTerminalBoxType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAirTerminalType createIfcAirTerminalType() {
		IfcAirTerminalTypeImpl ifcAirTerminalType = new IfcAirTerminalTypeImpl();
		return ifcAirTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAirToAirHeatRecovery createIfcAirToAirHeatRecovery() {
		IfcAirToAirHeatRecoveryImpl ifcAirToAirHeatRecovery = new IfcAirToAirHeatRecoveryImpl();
		return ifcAirToAirHeatRecovery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAirToAirHeatRecoveryType createIfcAirToAirHeatRecoveryType() {
		IfcAirToAirHeatRecoveryTypeImpl ifcAirToAirHeatRecoveryType = new IfcAirToAirHeatRecoveryTypeImpl();
		return ifcAirToAirHeatRecoveryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAlarm createIfcAlarm() {
		IfcAlarmImpl ifcAlarm = new IfcAlarmImpl();
		return ifcAlarm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAlarmType createIfcAlarmType() {
		IfcAlarmTypeImpl ifcAlarmType = new IfcAlarmTypeImpl();
		return ifcAlarmType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAnnotation createIfcAnnotation() {
		IfcAnnotationImpl ifcAnnotation = new IfcAnnotationImpl();
		return ifcAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAnnotationFillArea createIfcAnnotationFillArea() {
		IfcAnnotationFillAreaImpl ifcAnnotationFillArea = new IfcAnnotationFillAreaImpl();
		return ifcAnnotationFillArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcApplication createIfcApplication() {
		IfcApplicationImpl ifcApplication = new IfcApplicationImpl();
		return ifcApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAppliedValue createIfcAppliedValue() {
		IfcAppliedValueImpl ifcAppliedValue = new IfcAppliedValueImpl();
		return ifcAppliedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcApproval createIfcApproval() {
		IfcApprovalImpl ifcApproval = new IfcApprovalImpl();
		return ifcApproval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcApprovalRelationship createIfcApprovalRelationship() {
		IfcApprovalRelationshipImpl ifcApprovalRelationship = new IfcApprovalRelationshipImpl();
		return ifcApprovalRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcArbitraryClosedProfileDef createIfcArbitraryClosedProfileDef() {
		IfcArbitraryClosedProfileDefImpl ifcArbitraryClosedProfileDef = new IfcArbitraryClosedProfileDefImpl();
		return ifcArbitraryClosedProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcArbitraryOpenProfileDef createIfcArbitraryOpenProfileDef() {
		IfcArbitraryOpenProfileDefImpl ifcArbitraryOpenProfileDef = new IfcArbitraryOpenProfileDefImpl();
		return ifcArbitraryOpenProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcArbitraryProfileDefWithVoids createIfcArbitraryProfileDefWithVoids() {
		IfcArbitraryProfileDefWithVoidsImpl ifcArbitraryProfileDefWithVoids = new IfcArbitraryProfileDefWithVoidsImpl();
		return ifcArbitraryProfileDefWithVoids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAsset createIfcAsset() {
		IfcAssetImpl ifcAsset = new IfcAssetImpl();
		return ifcAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAsymmetricIShapeProfileDef createIfcAsymmetricIShapeProfileDef() {
		IfcAsymmetricIShapeProfileDefImpl ifcAsymmetricIShapeProfileDef = new IfcAsymmetricIShapeProfileDefImpl();
		return ifcAsymmetricIShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAudioVisualAppliance createIfcAudioVisualAppliance() {
		IfcAudioVisualApplianceImpl ifcAudioVisualAppliance = new IfcAudioVisualApplianceImpl();
		return ifcAudioVisualAppliance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAudioVisualApplianceType createIfcAudioVisualApplianceType() {
		IfcAudioVisualApplianceTypeImpl ifcAudioVisualApplianceType = new IfcAudioVisualApplianceTypeImpl();
		return ifcAudioVisualApplianceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAxis1Placement createIfcAxis1Placement() {
		IfcAxis1PlacementImpl ifcAxis1Placement = new IfcAxis1PlacementImpl();
		return ifcAxis1Placement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAxis2Placement2D createIfcAxis2Placement2D() {
		IfcAxis2Placement2DImpl ifcAxis2Placement2D = new IfcAxis2Placement2DImpl();
		return ifcAxis2Placement2D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAxis2Placement3D createIfcAxis2Placement3D() {
		IfcAxis2Placement3DImpl ifcAxis2Placement3D = new IfcAxis2Placement3DImpl();
		return ifcAxis2Placement3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBSplineCurve createIfcBSplineCurve() {
		IfcBSplineCurveImpl ifcBSplineCurve = new IfcBSplineCurveImpl();
		return ifcBSplineCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBSplineCurveWithKnots createIfcBSplineCurveWithKnots() {
		IfcBSplineCurveWithKnotsImpl ifcBSplineCurveWithKnots = new IfcBSplineCurveWithKnotsImpl();
		return ifcBSplineCurveWithKnots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBSplineSurface createIfcBSplineSurface() {
		IfcBSplineSurfaceImpl ifcBSplineSurface = new IfcBSplineSurfaceImpl();
		return ifcBSplineSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBSplineSurfaceWithKnots createIfcBSplineSurfaceWithKnots() {
		IfcBSplineSurfaceWithKnotsImpl ifcBSplineSurfaceWithKnots = new IfcBSplineSurfaceWithKnotsImpl();
		return ifcBSplineSurfaceWithKnots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBeam createIfcBeam() {
		IfcBeamImpl ifcBeam = new IfcBeamImpl();
		return ifcBeam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBeamStandardCase createIfcBeamStandardCase() {
		IfcBeamStandardCaseImpl ifcBeamStandardCase = new IfcBeamStandardCaseImpl();
		return ifcBeamStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBeamType createIfcBeamType() {
		IfcBeamTypeImpl ifcBeamType = new IfcBeamTypeImpl();
		return ifcBeamType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBlobTexture createIfcBlobTexture() {
		IfcBlobTextureImpl ifcBlobTexture = new IfcBlobTextureImpl();
		return ifcBlobTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBlock createIfcBlock() {
		IfcBlockImpl ifcBlock = new IfcBlockImpl();
		return ifcBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoiler createIfcBoiler() {
		IfcBoilerImpl ifcBoiler = new IfcBoilerImpl();
		return ifcBoiler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoilerType createIfcBoilerType() {
		IfcBoilerTypeImpl ifcBoilerType = new IfcBoilerTypeImpl();
		return ifcBoilerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBooleanClippingResult createIfcBooleanClippingResult() {
		IfcBooleanClippingResultImpl ifcBooleanClippingResult = new IfcBooleanClippingResultImpl();
		return ifcBooleanClippingResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBooleanResult createIfcBooleanResult() {
		IfcBooleanResultImpl ifcBooleanResult = new IfcBooleanResultImpl();
		return ifcBooleanResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundaryCondition createIfcBoundaryCondition() {
		IfcBoundaryConditionImpl ifcBoundaryCondition = new IfcBoundaryConditionImpl();
		return ifcBoundaryCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundaryCurve createIfcBoundaryCurve() {
		IfcBoundaryCurveImpl ifcBoundaryCurve = new IfcBoundaryCurveImpl();
		return ifcBoundaryCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundaryEdgeCondition createIfcBoundaryEdgeCondition() {
		IfcBoundaryEdgeConditionImpl ifcBoundaryEdgeCondition = new IfcBoundaryEdgeConditionImpl();
		return ifcBoundaryEdgeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundaryFaceCondition createIfcBoundaryFaceCondition() {
		IfcBoundaryFaceConditionImpl ifcBoundaryFaceCondition = new IfcBoundaryFaceConditionImpl();
		return ifcBoundaryFaceCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundaryNodeCondition createIfcBoundaryNodeCondition() {
		IfcBoundaryNodeConditionImpl ifcBoundaryNodeCondition = new IfcBoundaryNodeConditionImpl();
		return ifcBoundaryNodeCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundaryNodeConditionWarping createIfcBoundaryNodeConditionWarping() {
		IfcBoundaryNodeConditionWarpingImpl ifcBoundaryNodeConditionWarping = new IfcBoundaryNodeConditionWarpingImpl();
		return ifcBoundaryNodeConditionWarping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundedCurve createIfcBoundedCurve() {
		IfcBoundedCurveImpl ifcBoundedCurve = new IfcBoundedCurveImpl();
		return ifcBoundedCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundedSurface createIfcBoundedSurface() {
		IfcBoundedSurfaceImpl ifcBoundedSurface = new IfcBoundedSurfaceImpl();
		return ifcBoundedSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoundingBox createIfcBoundingBox() {
		IfcBoundingBoxImpl ifcBoundingBox = new IfcBoundingBoxImpl();
		return ifcBoundingBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoxedHalfSpace createIfcBoxedHalfSpace() {
		IfcBoxedHalfSpaceImpl ifcBoxedHalfSpace = new IfcBoxedHalfSpaceImpl();
		return ifcBoxedHalfSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuilding createIfcBuilding() {
		IfcBuildingImpl ifcBuilding = new IfcBuildingImpl();
		return ifcBuilding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuildingElement createIfcBuildingElement() {
		IfcBuildingElementImpl ifcBuildingElement = new IfcBuildingElementImpl();
		return ifcBuildingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuildingElementPart createIfcBuildingElementPart() {
		IfcBuildingElementPartImpl ifcBuildingElementPart = new IfcBuildingElementPartImpl();
		return ifcBuildingElementPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuildingElementPartType createIfcBuildingElementPartType() {
		IfcBuildingElementPartTypeImpl ifcBuildingElementPartType = new IfcBuildingElementPartTypeImpl();
		return ifcBuildingElementPartType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuildingElementProxy createIfcBuildingElementProxy() {
		IfcBuildingElementProxyImpl ifcBuildingElementProxy = new IfcBuildingElementProxyImpl();
		return ifcBuildingElementProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuildingElementProxyType createIfcBuildingElementProxyType() {
		IfcBuildingElementProxyTypeImpl ifcBuildingElementProxyType = new IfcBuildingElementProxyTypeImpl();
		return ifcBuildingElementProxyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuildingElementType createIfcBuildingElementType() {
		IfcBuildingElementTypeImpl ifcBuildingElementType = new IfcBuildingElementTypeImpl();
		return ifcBuildingElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuildingStorey createIfcBuildingStorey() {
		IfcBuildingStoreyImpl ifcBuildingStorey = new IfcBuildingStoreyImpl();
		return ifcBuildingStorey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBuildingSystem createIfcBuildingSystem() {
		IfcBuildingSystemImpl ifcBuildingSystem = new IfcBuildingSystemImpl();
		return ifcBuildingSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBurner createIfcBurner() {
		IfcBurnerImpl ifcBurner = new IfcBurnerImpl();
		return ifcBurner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBurnerType createIfcBurnerType() {
		IfcBurnerTypeImpl ifcBurnerType = new IfcBurnerTypeImpl();
		return ifcBurnerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCShapeProfileDef createIfcCShapeProfileDef() {
		IfcCShapeProfileDefImpl ifcCShapeProfileDef = new IfcCShapeProfileDefImpl();
		return ifcCShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCableCarrierFitting createIfcCableCarrierFitting() {
		IfcCableCarrierFittingImpl ifcCableCarrierFitting = new IfcCableCarrierFittingImpl();
		return ifcCableCarrierFitting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCableCarrierFittingType createIfcCableCarrierFittingType() {
		IfcCableCarrierFittingTypeImpl ifcCableCarrierFittingType = new IfcCableCarrierFittingTypeImpl();
		return ifcCableCarrierFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCableCarrierSegment createIfcCableCarrierSegment() {
		IfcCableCarrierSegmentImpl ifcCableCarrierSegment = new IfcCableCarrierSegmentImpl();
		return ifcCableCarrierSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCableCarrierSegmentType createIfcCableCarrierSegmentType() {
		IfcCableCarrierSegmentTypeImpl ifcCableCarrierSegmentType = new IfcCableCarrierSegmentTypeImpl();
		return ifcCableCarrierSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCableFitting createIfcCableFitting() {
		IfcCableFittingImpl ifcCableFitting = new IfcCableFittingImpl();
		return ifcCableFitting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCableFittingType createIfcCableFittingType() {
		IfcCableFittingTypeImpl ifcCableFittingType = new IfcCableFittingTypeImpl();
		return ifcCableFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCableSegment createIfcCableSegment() {
		IfcCableSegmentImpl ifcCableSegment = new IfcCableSegmentImpl();
		return ifcCableSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCableSegmentType createIfcCableSegmentType() {
		IfcCableSegmentTypeImpl ifcCableSegmentType = new IfcCableSegmentTypeImpl();
		return ifcCableSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPoint createIfcCartesianPoint() {
		IfcCartesianPointImpl ifcCartesianPoint = new IfcCartesianPointImpl();
		return ifcCartesianPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPointList createIfcCartesianPointList() {
		IfcCartesianPointListImpl ifcCartesianPointList = new IfcCartesianPointListImpl();
		return ifcCartesianPointList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPointList2D createIfcCartesianPointList2D() {
		IfcCartesianPointList2DImpl ifcCartesianPointList2D = new IfcCartesianPointList2DImpl();
		return ifcCartesianPointList2D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPointList3D createIfcCartesianPointList3D() {
		IfcCartesianPointList3DImpl ifcCartesianPointList3D = new IfcCartesianPointList3DImpl();
		return ifcCartesianPointList3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianTransformationOperator createIfcCartesianTransformationOperator() {
		IfcCartesianTransformationOperatorImpl ifcCartesianTransformationOperator = new IfcCartesianTransformationOperatorImpl();
		return ifcCartesianTransformationOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianTransformationOperator2D createIfcCartesianTransformationOperator2D() {
		IfcCartesianTransformationOperator2DImpl ifcCartesianTransformationOperator2D = new IfcCartesianTransformationOperator2DImpl();
		return ifcCartesianTransformationOperator2D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianTransformationOperator2DnonUniform createIfcCartesianTransformationOperator2DnonUniform() {
		IfcCartesianTransformationOperator2DnonUniformImpl ifcCartesianTransformationOperator2DnonUniform = new IfcCartesianTransformationOperator2DnonUniformImpl();
		return ifcCartesianTransformationOperator2DnonUniform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianTransformationOperator3D createIfcCartesianTransformationOperator3D() {
		IfcCartesianTransformationOperator3DImpl ifcCartesianTransformationOperator3D = new IfcCartesianTransformationOperator3DImpl();
		return ifcCartesianTransformationOperator3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianTransformationOperator3DnonUniform createIfcCartesianTransformationOperator3DnonUniform() {
		IfcCartesianTransformationOperator3DnonUniformImpl ifcCartesianTransformationOperator3DnonUniform = new IfcCartesianTransformationOperator3DnonUniformImpl();
		return ifcCartesianTransformationOperator3DnonUniform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCenterLineProfileDef createIfcCenterLineProfileDef() {
		IfcCenterLineProfileDefImpl ifcCenterLineProfileDef = new IfcCenterLineProfileDefImpl();
		return ifcCenterLineProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcChiller createIfcChiller() {
		IfcChillerImpl ifcChiller = new IfcChillerImpl();
		return ifcChiller;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcChillerType createIfcChillerType() {
		IfcChillerTypeImpl ifcChillerType = new IfcChillerTypeImpl();
		return ifcChillerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcChimney createIfcChimney() {
		IfcChimneyImpl ifcChimney = new IfcChimneyImpl();
		return ifcChimney;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcChimneyType createIfcChimneyType() {
		IfcChimneyTypeImpl ifcChimneyType = new IfcChimneyTypeImpl();
		return ifcChimneyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCircle createIfcCircle() {
		IfcCircleImpl ifcCircle = new IfcCircleImpl();
		return ifcCircle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCircleHollowProfileDef createIfcCircleHollowProfileDef() {
		IfcCircleHollowProfileDefImpl ifcCircleHollowProfileDef = new IfcCircleHollowProfileDefImpl();
		return ifcCircleHollowProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCircleProfileDef createIfcCircleProfileDef() {
		IfcCircleProfileDefImpl ifcCircleProfileDef = new IfcCircleProfileDefImpl();
		return ifcCircleProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCivilElement createIfcCivilElement() {
		IfcCivilElementImpl ifcCivilElement = new IfcCivilElementImpl();
		return ifcCivilElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCivilElementType createIfcCivilElementType() {
		IfcCivilElementTypeImpl ifcCivilElementType = new IfcCivilElementTypeImpl();
		return ifcCivilElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcClassification createIfcClassification() {
		IfcClassificationImpl ifcClassification = new IfcClassificationImpl();
		return ifcClassification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcClassificationReference createIfcClassificationReference() {
		IfcClassificationReferenceImpl ifcClassificationReference = new IfcClassificationReferenceImpl();
		return ifcClassificationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcClosedShell createIfcClosedShell() {
		IfcClosedShellImpl ifcClosedShell = new IfcClosedShellImpl();
		return ifcClosedShell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCoil createIfcCoil() {
		IfcCoilImpl ifcCoil = new IfcCoilImpl();
		return ifcCoil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCoilType createIfcCoilType() {
		IfcCoilTypeImpl ifcCoilType = new IfcCoilTypeImpl();
		return ifcCoilType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgb createIfcColourRgb() {
		IfcColourRgbImpl ifcColourRgb = new IfcColourRgbImpl();
		return ifcColourRgb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourRgbList createIfcColourRgbList() {
		IfcColourRgbListImpl ifcColourRgbList = new IfcColourRgbListImpl();
		return ifcColourRgbList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColourSpecification createIfcColourSpecification() {
		IfcColourSpecificationImpl ifcColourSpecification = new IfcColourSpecificationImpl();
		return ifcColourSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColumn createIfcColumn() {
		IfcColumnImpl ifcColumn = new IfcColumnImpl();
		return ifcColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColumnStandardCase createIfcColumnStandardCase() {
		IfcColumnStandardCaseImpl ifcColumnStandardCase = new IfcColumnStandardCaseImpl();
		return ifcColumnStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcColumnType createIfcColumnType() {
		IfcColumnTypeImpl ifcColumnType = new IfcColumnTypeImpl();
		return ifcColumnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCommunicationsAppliance createIfcCommunicationsAppliance() {
		IfcCommunicationsApplianceImpl ifcCommunicationsAppliance = new IfcCommunicationsApplianceImpl();
		return ifcCommunicationsAppliance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCommunicationsApplianceType createIfcCommunicationsApplianceType() {
		IfcCommunicationsApplianceTypeImpl ifcCommunicationsApplianceType = new IfcCommunicationsApplianceTypeImpl();
		return ifcCommunicationsApplianceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcComplexProperty createIfcComplexProperty() {
		IfcComplexPropertyImpl ifcComplexProperty = new IfcComplexPropertyImpl();
		return ifcComplexProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcComplexPropertyTemplate createIfcComplexPropertyTemplate() {
		IfcComplexPropertyTemplateImpl ifcComplexPropertyTemplate = new IfcComplexPropertyTemplateImpl();
		return ifcComplexPropertyTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCompositeCurve createIfcCompositeCurve() {
		IfcCompositeCurveImpl ifcCompositeCurve = new IfcCompositeCurveImpl();
		return ifcCompositeCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCompositeCurveOnSurface createIfcCompositeCurveOnSurface() {
		IfcCompositeCurveOnSurfaceImpl ifcCompositeCurveOnSurface = new IfcCompositeCurveOnSurfaceImpl();
		return ifcCompositeCurveOnSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCompositeCurveSegment createIfcCompositeCurveSegment() {
		IfcCompositeCurveSegmentImpl ifcCompositeCurveSegment = new IfcCompositeCurveSegmentImpl();
		return ifcCompositeCurveSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCompositeProfileDef createIfcCompositeProfileDef() {
		IfcCompositeProfileDefImpl ifcCompositeProfileDef = new IfcCompositeProfileDefImpl();
		return ifcCompositeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCompressor createIfcCompressor() {
		IfcCompressorImpl ifcCompressor = new IfcCompressorImpl();
		return ifcCompressor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCompressorType createIfcCompressorType() {
		IfcCompressorTypeImpl ifcCompressorType = new IfcCompressorTypeImpl();
		return ifcCompressorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCondenser createIfcCondenser() {
		IfcCondenserImpl ifcCondenser = new IfcCondenserImpl();
		return ifcCondenser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCondenserType createIfcCondenserType() {
		IfcCondenserTypeImpl ifcCondenserType = new IfcCondenserTypeImpl();
		return ifcCondenserType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConic createIfcConic() {
		IfcConicImpl ifcConic = new IfcConicImpl();
		return ifcConic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectedFaceSet createIfcConnectedFaceSet() {
		IfcConnectedFaceSetImpl ifcConnectedFaceSet = new IfcConnectedFaceSetImpl();
		return ifcConnectedFaceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionCurveGeometry createIfcConnectionCurveGeometry() {
		IfcConnectionCurveGeometryImpl ifcConnectionCurveGeometry = new IfcConnectionCurveGeometryImpl();
		return ifcConnectionCurveGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionGeometry createIfcConnectionGeometry() {
		IfcConnectionGeometryImpl ifcConnectionGeometry = new IfcConnectionGeometryImpl();
		return ifcConnectionGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionPointEccentricity createIfcConnectionPointEccentricity() {
		IfcConnectionPointEccentricityImpl ifcConnectionPointEccentricity = new IfcConnectionPointEccentricityImpl();
		return ifcConnectionPointEccentricity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionPointGeometry createIfcConnectionPointGeometry() {
		IfcConnectionPointGeometryImpl ifcConnectionPointGeometry = new IfcConnectionPointGeometryImpl();
		return ifcConnectionPointGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionSurfaceGeometry createIfcConnectionSurfaceGeometry() {
		IfcConnectionSurfaceGeometryImpl ifcConnectionSurfaceGeometry = new IfcConnectionSurfaceGeometryImpl();
		return ifcConnectionSurfaceGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConnectionVolumeGeometry createIfcConnectionVolumeGeometry() {
		IfcConnectionVolumeGeometryImpl ifcConnectionVolumeGeometry = new IfcConnectionVolumeGeometryImpl();
		return ifcConnectionVolumeGeometry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstraint createIfcConstraint() {
		IfcConstraintImpl ifcConstraint = new IfcConstraintImpl();
		return ifcConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstructionEquipmentResource createIfcConstructionEquipmentResource() {
		IfcConstructionEquipmentResourceImpl ifcConstructionEquipmentResource = new IfcConstructionEquipmentResourceImpl();
		return ifcConstructionEquipmentResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstructionEquipmentResourceType createIfcConstructionEquipmentResourceType() {
		IfcConstructionEquipmentResourceTypeImpl ifcConstructionEquipmentResourceType = new IfcConstructionEquipmentResourceTypeImpl();
		return ifcConstructionEquipmentResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstructionMaterialResource createIfcConstructionMaterialResource() {
		IfcConstructionMaterialResourceImpl ifcConstructionMaterialResource = new IfcConstructionMaterialResourceImpl();
		return ifcConstructionMaterialResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstructionMaterialResourceType createIfcConstructionMaterialResourceType() {
		IfcConstructionMaterialResourceTypeImpl ifcConstructionMaterialResourceType = new IfcConstructionMaterialResourceTypeImpl();
		return ifcConstructionMaterialResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstructionProductResource createIfcConstructionProductResource() {
		IfcConstructionProductResourceImpl ifcConstructionProductResource = new IfcConstructionProductResourceImpl();
		return ifcConstructionProductResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstructionProductResourceType createIfcConstructionProductResourceType() {
		IfcConstructionProductResourceTypeImpl ifcConstructionProductResourceType = new IfcConstructionProductResourceTypeImpl();
		return ifcConstructionProductResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstructionResource createIfcConstructionResource() {
		IfcConstructionResourceImpl ifcConstructionResource = new IfcConstructionResourceImpl();
		return ifcConstructionResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConstructionResourceType createIfcConstructionResourceType() {
		IfcConstructionResourceTypeImpl ifcConstructionResourceType = new IfcConstructionResourceTypeImpl();
		return ifcConstructionResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcContext createIfcContext() {
		IfcContextImpl ifcContext = new IfcContextImpl();
		return ifcContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcContextDependentUnit createIfcContextDependentUnit() {
		IfcContextDependentUnitImpl ifcContextDependentUnit = new IfcContextDependentUnitImpl();
		return ifcContextDependentUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcControl createIfcControl() {
		IfcControlImpl ifcControl = new IfcControlImpl();
		return ifcControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcController createIfcController() {
		IfcControllerImpl ifcController = new IfcControllerImpl();
		return ifcController;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcControllerType createIfcControllerType() {
		IfcControllerTypeImpl ifcControllerType = new IfcControllerTypeImpl();
		return ifcControllerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConversionBasedUnit createIfcConversionBasedUnit() {
		IfcConversionBasedUnitImpl ifcConversionBasedUnit = new IfcConversionBasedUnitImpl();
		return ifcConversionBasedUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcConversionBasedUnitWithOffset createIfcConversionBasedUnitWithOffset() {
		IfcConversionBasedUnitWithOffsetImpl ifcConversionBasedUnitWithOffset = new IfcConversionBasedUnitWithOffsetImpl();
		return ifcConversionBasedUnitWithOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCooledBeam createIfcCooledBeam() {
		IfcCooledBeamImpl ifcCooledBeam = new IfcCooledBeamImpl();
		return ifcCooledBeam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCooledBeamType createIfcCooledBeamType() {
		IfcCooledBeamTypeImpl ifcCooledBeamType = new IfcCooledBeamTypeImpl();
		return ifcCooledBeamType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCoolingTower createIfcCoolingTower() {
		IfcCoolingTowerImpl ifcCoolingTower = new IfcCoolingTowerImpl();
		return ifcCoolingTower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCoolingTowerType createIfcCoolingTowerType() {
		IfcCoolingTowerTypeImpl ifcCoolingTowerType = new IfcCoolingTowerTypeImpl();
		return ifcCoolingTowerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCoordinateOperation createIfcCoordinateOperation() {
		IfcCoordinateOperationImpl ifcCoordinateOperation = new IfcCoordinateOperationImpl();
		return ifcCoordinateOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCoordinateReferenceSystem createIfcCoordinateReferenceSystem() {
		IfcCoordinateReferenceSystemImpl ifcCoordinateReferenceSystem = new IfcCoordinateReferenceSystemImpl();
		return ifcCoordinateReferenceSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostItem createIfcCostItem() {
		IfcCostItemImpl ifcCostItem = new IfcCostItemImpl();
		return ifcCostItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostSchedule createIfcCostSchedule() {
		IfcCostScheduleImpl ifcCostSchedule = new IfcCostScheduleImpl();
		return ifcCostSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCostValue createIfcCostValue() {
		IfcCostValueImpl ifcCostValue = new IfcCostValueImpl();
		return ifcCostValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCovering createIfcCovering() {
		IfcCoveringImpl ifcCovering = new IfcCoveringImpl();
		return ifcCovering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCoveringType createIfcCoveringType() {
		IfcCoveringTypeImpl ifcCoveringType = new IfcCoveringTypeImpl();
		return ifcCoveringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCrewResource createIfcCrewResource() {
		IfcCrewResourceImpl ifcCrewResource = new IfcCrewResourceImpl();
		return ifcCrewResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCrewResourceType createIfcCrewResourceType() {
		IfcCrewResourceTypeImpl ifcCrewResourceType = new IfcCrewResourceTypeImpl();
		return ifcCrewResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCsgPrimitive3D createIfcCsgPrimitive3D() {
		IfcCsgPrimitive3DImpl ifcCsgPrimitive3D = new IfcCsgPrimitive3DImpl();
		return ifcCsgPrimitive3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCsgSolid createIfcCsgSolid() {
		IfcCsgSolidImpl ifcCsgSolid = new IfcCsgSolidImpl();
		return ifcCsgSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurrencyRelationship createIfcCurrencyRelationship() {
		IfcCurrencyRelationshipImpl ifcCurrencyRelationship = new IfcCurrencyRelationshipImpl();
		return ifcCurrencyRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurtainWall createIfcCurtainWall() {
		IfcCurtainWallImpl ifcCurtainWall = new IfcCurtainWallImpl();
		return ifcCurtainWall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurtainWallType createIfcCurtainWallType() {
		IfcCurtainWallTypeImpl ifcCurtainWallType = new IfcCurtainWallTypeImpl();
		return ifcCurtainWallType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve createIfcCurve() {
		IfcCurveImpl ifcCurve = new IfcCurveImpl();
		return ifcCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveBoundedPlane createIfcCurveBoundedPlane() {
		IfcCurveBoundedPlaneImpl ifcCurveBoundedPlane = new IfcCurveBoundedPlaneImpl();
		return ifcCurveBoundedPlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveBoundedSurface createIfcCurveBoundedSurface() {
		IfcCurveBoundedSurfaceImpl ifcCurveBoundedSurface = new IfcCurveBoundedSurfaceImpl();
		return ifcCurveBoundedSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveStyle createIfcCurveStyle() {
		IfcCurveStyleImpl ifcCurveStyle = new IfcCurveStyleImpl();
		return ifcCurveStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveStyleFont createIfcCurveStyleFont() {
		IfcCurveStyleFontImpl ifcCurveStyleFont = new IfcCurveStyleFontImpl();
		return ifcCurveStyleFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveStyleFontAndScaling createIfcCurveStyleFontAndScaling() {
		IfcCurveStyleFontAndScalingImpl ifcCurveStyleFontAndScaling = new IfcCurveStyleFontAndScalingImpl();
		return ifcCurveStyleFontAndScaling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurveStyleFontPattern createIfcCurveStyleFontPattern() {
		IfcCurveStyleFontPatternImpl ifcCurveStyleFontPattern = new IfcCurveStyleFontPatternImpl();
		return ifcCurveStyleFontPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCylindricalSurface createIfcCylindricalSurface() {
		IfcCylindricalSurfaceImpl ifcCylindricalSurface = new IfcCylindricalSurfaceImpl();
		return ifcCylindricalSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDamper createIfcDamper() {
		IfcDamperImpl ifcDamper = new IfcDamperImpl();
		return ifcDamper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDamperType createIfcDamperType() {
		IfcDamperTypeImpl ifcDamperType = new IfcDamperTypeImpl();
		return ifcDamperType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDerivedProfileDef createIfcDerivedProfileDef() {
		IfcDerivedProfileDefImpl ifcDerivedProfileDef = new IfcDerivedProfileDefImpl();
		return ifcDerivedProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDerivedUnit createIfcDerivedUnit() {
		IfcDerivedUnitImpl ifcDerivedUnit = new IfcDerivedUnitImpl();
		return ifcDerivedUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDerivedUnitElement createIfcDerivedUnitElement() {
		IfcDerivedUnitElementImpl ifcDerivedUnitElement = new IfcDerivedUnitElementImpl();
		return ifcDerivedUnitElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDimensionalExponents createIfcDimensionalExponents() {
		IfcDimensionalExponentsImpl ifcDimensionalExponents = new IfcDimensionalExponentsImpl();
		return ifcDimensionalExponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDirection createIfcDirection() {
		IfcDirectionImpl ifcDirection = new IfcDirectionImpl();
		return ifcDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDiscreteAccessory createIfcDiscreteAccessory() {
		IfcDiscreteAccessoryImpl ifcDiscreteAccessory = new IfcDiscreteAccessoryImpl();
		return ifcDiscreteAccessory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDiscreteAccessoryType createIfcDiscreteAccessoryType() {
		IfcDiscreteAccessoryTypeImpl ifcDiscreteAccessoryType = new IfcDiscreteAccessoryTypeImpl();
		return ifcDiscreteAccessoryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionChamberElement createIfcDistributionChamberElement() {
		IfcDistributionChamberElementImpl ifcDistributionChamberElement = new IfcDistributionChamberElementImpl();
		return ifcDistributionChamberElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionChamberElementType createIfcDistributionChamberElementType() {
		IfcDistributionChamberElementTypeImpl ifcDistributionChamberElementType = new IfcDistributionChamberElementTypeImpl();
		return ifcDistributionChamberElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionCircuit createIfcDistributionCircuit() {
		IfcDistributionCircuitImpl ifcDistributionCircuit = new IfcDistributionCircuitImpl();
		return ifcDistributionCircuit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionControlElement createIfcDistributionControlElement() {
		IfcDistributionControlElementImpl ifcDistributionControlElement = new IfcDistributionControlElementImpl();
		return ifcDistributionControlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionControlElementType createIfcDistributionControlElementType() {
		IfcDistributionControlElementTypeImpl ifcDistributionControlElementType = new IfcDistributionControlElementTypeImpl();
		return ifcDistributionControlElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionElement createIfcDistributionElement() {
		IfcDistributionElementImpl ifcDistributionElement = new IfcDistributionElementImpl();
		return ifcDistributionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionElementType createIfcDistributionElementType() {
		IfcDistributionElementTypeImpl ifcDistributionElementType = new IfcDistributionElementTypeImpl();
		return ifcDistributionElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionFlowElement createIfcDistributionFlowElement() {
		IfcDistributionFlowElementImpl ifcDistributionFlowElement = new IfcDistributionFlowElementImpl();
		return ifcDistributionFlowElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionFlowElementType createIfcDistributionFlowElementType() {
		IfcDistributionFlowElementTypeImpl ifcDistributionFlowElementType = new IfcDistributionFlowElementTypeImpl();
		return ifcDistributionFlowElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionPort createIfcDistributionPort() {
		IfcDistributionPortImpl ifcDistributionPort = new IfcDistributionPortImpl();
		return ifcDistributionPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDistributionSystem createIfcDistributionSystem() {
		IfcDistributionSystemImpl ifcDistributionSystem = new IfcDistributionSystemImpl();
		return ifcDistributionSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDocumentInformation createIfcDocumentInformation() {
		IfcDocumentInformationImpl ifcDocumentInformation = new IfcDocumentInformationImpl();
		return ifcDocumentInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDocumentInformationRelationship createIfcDocumentInformationRelationship() {
		IfcDocumentInformationRelationshipImpl ifcDocumentInformationRelationship = new IfcDocumentInformationRelationshipImpl();
		return ifcDocumentInformationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDocumentReference createIfcDocumentReference() {
		IfcDocumentReferenceImpl ifcDocumentReference = new IfcDocumentReferenceImpl();
		return ifcDocumentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoor createIfcDoor() {
		IfcDoorImpl ifcDoor = new IfcDoorImpl();
		return ifcDoor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorLiningProperties createIfcDoorLiningProperties() {
		IfcDoorLiningPropertiesImpl ifcDoorLiningProperties = new IfcDoorLiningPropertiesImpl();
		return ifcDoorLiningProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorPanelProperties createIfcDoorPanelProperties() {
		IfcDoorPanelPropertiesImpl ifcDoorPanelProperties = new IfcDoorPanelPropertiesImpl();
		return ifcDoorPanelProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorStandardCase createIfcDoorStandardCase() {
		IfcDoorStandardCaseImpl ifcDoorStandardCase = new IfcDoorStandardCaseImpl();
		return ifcDoorStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorStyle createIfcDoorStyle() {
		IfcDoorStyleImpl ifcDoorStyle = new IfcDoorStyleImpl();
		return ifcDoorStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoorType createIfcDoorType() {
		IfcDoorTypeImpl ifcDoorType = new IfcDoorTypeImpl();
		return ifcDoorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDraughtingPreDefinedColour createIfcDraughtingPreDefinedColour() {
		IfcDraughtingPreDefinedColourImpl ifcDraughtingPreDefinedColour = new IfcDraughtingPreDefinedColourImpl();
		return ifcDraughtingPreDefinedColour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDraughtingPreDefinedCurveFont createIfcDraughtingPreDefinedCurveFont() {
		IfcDraughtingPreDefinedCurveFontImpl ifcDraughtingPreDefinedCurveFont = new IfcDraughtingPreDefinedCurveFontImpl();
		return ifcDraughtingPreDefinedCurveFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDuctFitting createIfcDuctFitting() {
		IfcDuctFittingImpl ifcDuctFitting = new IfcDuctFittingImpl();
		return ifcDuctFitting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDuctFittingType createIfcDuctFittingType() {
		IfcDuctFittingTypeImpl ifcDuctFittingType = new IfcDuctFittingTypeImpl();
		return ifcDuctFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDuctSegment createIfcDuctSegment() {
		IfcDuctSegmentImpl ifcDuctSegment = new IfcDuctSegmentImpl();
		return ifcDuctSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDuctSegmentType createIfcDuctSegmentType() {
		IfcDuctSegmentTypeImpl ifcDuctSegmentType = new IfcDuctSegmentTypeImpl();
		return ifcDuctSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDuctSilencer createIfcDuctSilencer() {
		IfcDuctSilencerImpl ifcDuctSilencer = new IfcDuctSilencerImpl();
		return ifcDuctSilencer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDuctSilencerType createIfcDuctSilencerType() {
		IfcDuctSilencerTypeImpl ifcDuctSilencerType = new IfcDuctSilencerTypeImpl();
		return ifcDuctSilencerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEdge createIfcEdge() {
		IfcEdgeImpl ifcEdge = new IfcEdgeImpl();
		return ifcEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEdgeCurve createIfcEdgeCurve() {
		IfcEdgeCurveImpl ifcEdgeCurve = new IfcEdgeCurveImpl();
		return ifcEdgeCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEdgeLoop createIfcEdgeLoop() {
		IfcEdgeLoopImpl ifcEdgeLoop = new IfcEdgeLoopImpl();
		return ifcEdgeLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricAppliance createIfcElectricAppliance() {
		IfcElectricApplianceImpl ifcElectricAppliance = new IfcElectricApplianceImpl();
		return ifcElectricAppliance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricApplianceType createIfcElectricApplianceType() {
		IfcElectricApplianceTypeImpl ifcElectricApplianceType = new IfcElectricApplianceTypeImpl();
		return ifcElectricApplianceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricDistributionBoard createIfcElectricDistributionBoard() {
		IfcElectricDistributionBoardImpl ifcElectricDistributionBoard = new IfcElectricDistributionBoardImpl();
		return ifcElectricDistributionBoard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricDistributionBoardType createIfcElectricDistributionBoardType() {
		IfcElectricDistributionBoardTypeImpl ifcElectricDistributionBoardType = new IfcElectricDistributionBoardTypeImpl();
		return ifcElectricDistributionBoardType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricFlowStorageDevice createIfcElectricFlowStorageDevice() {
		IfcElectricFlowStorageDeviceImpl ifcElectricFlowStorageDevice = new IfcElectricFlowStorageDeviceImpl();
		return ifcElectricFlowStorageDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricFlowStorageDeviceType createIfcElectricFlowStorageDeviceType() {
		IfcElectricFlowStorageDeviceTypeImpl ifcElectricFlowStorageDeviceType = new IfcElectricFlowStorageDeviceTypeImpl();
		return ifcElectricFlowStorageDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricGenerator createIfcElectricGenerator() {
		IfcElectricGeneratorImpl ifcElectricGenerator = new IfcElectricGeneratorImpl();
		return ifcElectricGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricGeneratorType createIfcElectricGeneratorType() {
		IfcElectricGeneratorTypeImpl ifcElectricGeneratorType = new IfcElectricGeneratorTypeImpl();
		return ifcElectricGeneratorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricMotor createIfcElectricMotor() {
		IfcElectricMotorImpl ifcElectricMotor = new IfcElectricMotorImpl();
		return ifcElectricMotor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricMotorType createIfcElectricMotorType() {
		IfcElectricMotorTypeImpl ifcElectricMotorType = new IfcElectricMotorTypeImpl();
		return ifcElectricMotorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricTimeControl createIfcElectricTimeControl() {
		IfcElectricTimeControlImpl ifcElectricTimeControl = new IfcElectricTimeControlImpl();
		return ifcElectricTimeControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricTimeControlType createIfcElectricTimeControlType() {
		IfcElectricTimeControlTypeImpl ifcElectricTimeControlType = new IfcElectricTimeControlTypeImpl();
		return ifcElectricTimeControlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElement createIfcElement() {
		IfcElementImpl ifcElement = new IfcElementImpl();
		return ifcElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElementAssembly createIfcElementAssembly() {
		IfcElementAssemblyImpl ifcElementAssembly = new IfcElementAssemblyImpl();
		return ifcElementAssembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElementAssemblyType createIfcElementAssemblyType() {
		IfcElementAssemblyTypeImpl ifcElementAssemblyType = new IfcElementAssemblyTypeImpl();
		return ifcElementAssemblyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElementComponent createIfcElementComponent() {
		IfcElementComponentImpl ifcElementComponent = new IfcElementComponentImpl();
		return ifcElementComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElementComponentType createIfcElementComponentType() {
		IfcElementComponentTypeImpl ifcElementComponentType = new IfcElementComponentTypeImpl();
		return ifcElementComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElementQuantity createIfcElementQuantity() {
		IfcElementQuantityImpl ifcElementQuantity = new IfcElementQuantityImpl();
		return ifcElementQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElementType createIfcElementType() {
		IfcElementTypeImpl ifcElementType = new IfcElementTypeImpl();
		return ifcElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElementarySurface createIfcElementarySurface() {
		IfcElementarySurfaceImpl ifcElementarySurface = new IfcElementarySurfaceImpl();
		return ifcElementarySurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEllipse createIfcEllipse() {
		IfcEllipseImpl ifcEllipse = new IfcEllipseImpl();
		return ifcEllipse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEllipseProfileDef createIfcEllipseProfileDef() {
		IfcEllipseProfileDefImpl ifcEllipseProfileDef = new IfcEllipseProfileDefImpl();
		return ifcEllipseProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEnergyConversionDevice createIfcEnergyConversionDevice() {
		IfcEnergyConversionDeviceImpl ifcEnergyConversionDevice = new IfcEnergyConversionDeviceImpl();
		return ifcEnergyConversionDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEnergyConversionDeviceType createIfcEnergyConversionDeviceType() {
		IfcEnergyConversionDeviceTypeImpl ifcEnergyConversionDeviceType = new IfcEnergyConversionDeviceTypeImpl();
		return ifcEnergyConversionDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEngine createIfcEngine() {
		IfcEngineImpl ifcEngine = new IfcEngineImpl();
		return ifcEngine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEngineType createIfcEngineType() {
		IfcEngineTypeImpl ifcEngineType = new IfcEngineTypeImpl();
		return ifcEngineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEvaporativeCooler createIfcEvaporativeCooler() {
		IfcEvaporativeCoolerImpl ifcEvaporativeCooler = new IfcEvaporativeCoolerImpl();
		return ifcEvaporativeCooler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEvaporativeCoolerType createIfcEvaporativeCoolerType() {
		IfcEvaporativeCoolerTypeImpl ifcEvaporativeCoolerType = new IfcEvaporativeCoolerTypeImpl();
		return ifcEvaporativeCoolerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEvaporator createIfcEvaporator() {
		IfcEvaporatorImpl ifcEvaporator = new IfcEvaporatorImpl();
		return ifcEvaporator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEvaporatorType createIfcEvaporatorType() {
		IfcEvaporatorTypeImpl ifcEvaporatorType = new IfcEvaporatorTypeImpl();
		return ifcEvaporatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEvent createIfcEvent() {
		IfcEventImpl ifcEvent = new IfcEventImpl();
		return ifcEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEventTime createIfcEventTime() {
		IfcEventTimeImpl ifcEventTime = new IfcEventTimeImpl();
		return ifcEventTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEventType createIfcEventType() {
		IfcEventTypeImpl ifcEventType = new IfcEventTypeImpl();
		return ifcEventType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExtendedProperties createIfcExtendedProperties() {
		IfcExtendedPropertiesImpl ifcExtendedProperties = new IfcExtendedPropertiesImpl();
		return ifcExtendedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExternalInformation createIfcExternalInformation() {
		IfcExternalInformationImpl ifcExternalInformation = new IfcExternalInformationImpl();
		return ifcExternalInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExternalReference createIfcExternalReference() {
		IfcExternalReferenceImpl ifcExternalReference = new IfcExternalReferenceImpl();
		return ifcExternalReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExternalReferenceRelationship createIfcExternalReferenceRelationship() {
		IfcExternalReferenceRelationshipImpl ifcExternalReferenceRelationship = new IfcExternalReferenceRelationshipImpl();
		return ifcExternalReferenceRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExternalSpatialElement createIfcExternalSpatialElement() {
		IfcExternalSpatialElementImpl ifcExternalSpatialElement = new IfcExternalSpatialElementImpl();
		return ifcExternalSpatialElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExternalSpatialStructureElement createIfcExternalSpatialStructureElement() {
		IfcExternalSpatialStructureElementImpl ifcExternalSpatialStructureElement = new IfcExternalSpatialStructureElementImpl();
		return ifcExternalSpatialStructureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExternallyDefinedHatchStyle createIfcExternallyDefinedHatchStyle() {
		IfcExternallyDefinedHatchStyleImpl ifcExternallyDefinedHatchStyle = new IfcExternallyDefinedHatchStyleImpl();
		return ifcExternallyDefinedHatchStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExternallyDefinedSurfaceStyle createIfcExternallyDefinedSurfaceStyle() {
		IfcExternallyDefinedSurfaceStyleImpl ifcExternallyDefinedSurfaceStyle = new IfcExternallyDefinedSurfaceStyleImpl();
		return ifcExternallyDefinedSurfaceStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExternallyDefinedTextFont createIfcExternallyDefinedTextFont() {
		IfcExternallyDefinedTextFontImpl ifcExternallyDefinedTextFont = new IfcExternallyDefinedTextFontImpl();
		return ifcExternallyDefinedTextFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExtrudedAreaSolid createIfcExtrudedAreaSolid() {
		IfcExtrudedAreaSolidImpl ifcExtrudedAreaSolid = new IfcExtrudedAreaSolidImpl();
		return ifcExtrudedAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcExtrudedAreaSolidTapered createIfcExtrudedAreaSolidTapered() {
		IfcExtrudedAreaSolidTaperedImpl ifcExtrudedAreaSolidTapered = new IfcExtrudedAreaSolidTaperedImpl();
		return ifcExtrudedAreaSolidTapered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFace createIfcFace() {
		IfcFaceImpl ifcFace = new IfcFaceImpl();
		return ifcFace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFaceBasedSurfaceModel createIfcFaceBasedSurfaceModel() {
		IfcFaceBasedSurfaceModelImpl ifcFaceBasedSurfaceModel = new IfcFaceBasedSurfaceModelImpl();
		return ifcFaceBasedSurfaceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFaceBound createIfcFaceBound() {
		IfcFaceBoundImpl ifcFaceBound = new IfcFaceBoundImpl();
		return ifcFaceBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFaceOuterBound createIfcFaceOuterBound() {
		IfcFaceOuterBoundImpl ifcFaceOuterBound = new IfcFaceOuterBoundImpl();
		return ifcFaceOuterBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFaceSurface createIfcFaceSurface() {
		IfcFaceSurfaceImpl ifcFaceSurface = new IfcFaceSurfaceImpl();
		return ifcFaceSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFacetedBrep createIfcFacetedBrep() {
		IfcFacetedBrepImpl ifcFacetedBrep = new IfcFacetedBrepImpl();
		return ifcFacetedBrep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFacetedBrepWithVoids createIfcFacetedBrepWithVoids() {
		IfcFacetedBrepWithVoidsImpl ifcFacetedBrepWithVoids = new IfcFacetedBrepWithVoidsImpl();
		return ifcFacetedBrepWithVoids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFailureConnectionCondition createIfcFailureConnectionCondition() {
		IfcFailureConnectionConditionImpl ifcFailureConnectionCondition = new IfcFailureConnectionConditionImpl();
		return ifcFailureConnectionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFan createIfcFan() {
		IfcFanImpl ifcFan = new IfcFanImpl();
		return ifcFan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFanType createIfcFanType() {
		IfcFanTypeImpl ifcFanType = new IfcFanTypeImpl();
		return ifcFanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFastener createIfcFastener() {
		IfcFastenerImpl ifcFastener = new IfcFastenerImpl();
		return ifcFastener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFastenerType createIfcFastenerType() {
		IfcFastenerTypeImpl ifcFastenerType = new IfcFastenerTypeImpl();
		return ifcFastenerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFeatureElement createIfcFeatureElement() {
		IfcFeatureElementImpl ifcFeatureElement = new IfcFeatureElementImpl();
		return ifcFeatureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFeatureElementAddition createIfcFeatureElementAddition() {
		IfcFeatureElementAdditionImpl ifcFeatureElementAddition = new IfcFeatureElementAdditionImpl();
		return ifcFeatureElementAddition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFeatureElementSubtraction createIfcFeatureElementSubtraction() {
		IfcFeatureElementSubtractionImpl ifcFeatureElementSubtraction = new IfcFeatureElementSubtractionImpl();
		return ifcFeatureElementSubtraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFillAreaStyle createIfcFillAreaStyle() {
		IfcFillAreaStyleImpl ifcFillAreaStyle = new IfcFillAreaStyleImpl();
		return ifcFillAreaStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFillAreaStyleHatching createIfcFillAreaStyleHatching() {
		IfcFillAreaStyleHatchingImpl ifcFillAreaStyleHatching = new IfcFillAreaStyleHatchingImpl();
		return ifcFillAreaStyleHatching;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFillAreaStyleTiles createIfcFillAreaStyleTiles() {
		IfcFillAreaStyleTilesImpl ifcFillAreaStyleTiles = new IfcFillAreaStyleTilesImpl();
		return ifcFillAreaStyleTiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFilter createIfcFilter() {
		IfcFilterImpl ifcFilter = new IfcFilterImpl();
		return ifcFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFilterType createIfcFilterType() {
		IfcFilterTypeImpl ifcFilterType = new IfcFilterTypeImpl();
		return ifcFilterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFireSuppressionTerminal createIfcFireSuppressionTerminal() {
		IfcFireSuppressionTerminalImpl ifcFireSuppressionTerminal = new IfcFireSuppressionTerminalImpl();
		return ifcFireSuppressionTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFireSuppressionTerminalType createIfcFireSuppressionTerminalType() {
		IfcFireSuppressionTerminalTypeImpl ifcFireSuppressionTerminalType = new IfcFireSuppressionTerminalTypeImpl();
		return ifcFireSuppressionTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFixedReferenceSweptAreaSolid createIfcFixedReferenceSweptAreaSolid() {
		IfcFixedReferenceSweptAreaSolidImpl ifcFixedReferenceSweptAreaSolid = new IfcFixedReferenceSweptAreaSolidImpl();
		return ifcFixedReferenceSweptAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowController createIfcFlowController() {
		IfcFlowControllerImpl ifcFlowController = new IfcFlowControllerImpl();
		return ifcFlowController;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowControllerType createIfcFlowControllerType() {
		IfcFlowControllerTypeImpl ifcFlowControllerType = new IfcFlowControllerTypeImpl();
		return ifcFlowControllerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowFitting createIfcFlowFitting() {
		IfcFlowFittingImpl ifcFlowFitting = new IfcFlowFittingImpl();
		return ifcFlowFitting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowFittingType createIfcFlowFittingType() {
		IfcFlowFittingTypeImpl ifcFlowFittingType = new IfcFlowFittingTypeImpl();
		return ifcFlowFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowInstrument createIfcFlowInstrument() {
		IfcFlowInstrumentImpl ifcFlowInstrument = new IfcFlowInstrumentImpl();
		return ifcFlowInstrument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowInstrumentType createIfcFlowInstrumentType() {
		IfcFlowInstrumentTypeImpl ifcFlowInstrumentType = new IfcFlowInstrumentTypeImpl();
		return ifcFlowInstrumentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowMeter createIfcFlowMeter() {
		IfcFlowMeterImpl ifcFlowMeter = new IfcFlowMeterImpl();
		return ifcFlowMeter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowMeterType createIfcFlowMeterType() {
		IfcFlowMeterTypeImpl ifcFlowMeterType = new IfcFlowMeterTypeImpl();
		return ifcFlowMeterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowMovingDevice createIfcFlowMovingDevice() {
		IfcFlowMovingDeviceImpl ifcFlowMovingDevice = new IfcFlowMovingDeviceImpl();
		return ifcFlowMovingDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowMovingDeviceType createIfcFlowMovingDeviceType() {
		IfcFlowMovingDeviceTypeImpl ifcFlowMovingDeviceType = new IfcFlowMovingDeviceTypeImpl();
		return ifcFlowMovingDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowSegment createIfcFlowSegment() {
		IfcFlowSegmentImpl ifcFlowSegment = new IfcFlowSegmentImpl();
		return ifcFlowSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowSegmentType createIfcFlowSegmentType() {
		IfcFlowSegmentTypeImpl ifcFlowSegmentType = new IfcFlowSegmentTypeImpl();
		return ifcFlowSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowStorageDevice createIfcFlowStorageDevice() {
		IfcFlowStorageDeviceImpl ifcFlowStorageDevice = new IfcFlowStorageDeviceImpl();
		return ifcFlowStorageDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowStorageDeviceType createIfcFlowStorageDeviceType() {
		IfcFlowStorageDeviceTypeImpl ifcFlowStorageDeviceType = new IfcFlowStorageDeviceTypeImpl();
		return ifcFlowStorageDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowTerminal createIfcFlowTerminal() {
		IfcFlowTerminalImpl ifcFlowTerminal = new IfcFlowTerminalImpl();
		return ifcFlowTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowTerminalType createIfcFlowTerminalType() {
		IfcFlowTerminalTypeImpl ifcFlowTerminalType = new IfcFlowTerminalTypeImpl();
		return ifcFlowTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowTreatmentDevice createIfcFlowTreatmentDevice() {
		IfcFlowTreatmentDeviceImpl ifcFlowTreatmentDevice = new IfcFlowTreatmentDeviceImpl();
		return ifcFlowTreatmentDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFlowTreatmentDeviceType createIfcFlowTreatmentDeviceType() {
		IfcFlowTreatmentDeviceTypeImpl ifcFlowTreatmentDeviceType = new IfcFlowTreatmentDeviceTypeImpl();
		return ifcFlowTreatmentDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFooting createIfcFooting() {
		IfcFootingImpl ifcFooting = new IfcFootingImpl();
		return ifcFooting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFootingType createIfcFootingType() {
		IfcFootingTypeImpl ifcFootingType = new IfcFootingTypeImpl();
		return ifcFootingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFurnishingElement createIfcFurnishingElement() {
		IfcFurnishingElementImpl ifcFurnishingElement = new IfcFurnishingElementImpl();
		return ifcFurnishingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFurnishingElementType createIfcFurnishingElementType() {
		IfcFurnishingElementTypeImpl ifcFurnishingElementType = new IfcFurnishingElementTypeImpl();
		return ifcFurnishingElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFurniture createIfcFurniture() {
		IfcFurnitureImpl ifcFurniture = new IfcFurnitureImpl();
		return ifcFurniture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFurnitureType createIfcFurnitureType() {
		IfcFurnitureTypeImpl ifcFurnitureType = new IfcFurnitureTypeImpl();
		return ifcFurnitureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGeographicElement createIfcGeographicElement() {
		IfcGeographicElementImpl ifcGeographicElement = new IfcGeographicElementImpl();
		return ifcGeographicElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGeographicElementType createIfcGeographicElementType() {
		IfcGeographicElementTypeImpl ifcGeographicElementType = new IfcGeographicElementTypeImpl();
		return ifcGeographicElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGeometricCurveSet createIfcGeometricCurveSet() {
		IfcGeometricCurveSetImpl ifcGeometricCurveSet = new IfcGeometricCurveSetImpl();
		return ifcGeometricCurveSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGeometricRepresentationContext createIfcGeometricRepresentationContext() {
		IfcGeometricRepresentationContextImpl ifcGeometricRepresentationContext = new IfcGeometricRepresentationContextImpl();
		return ifcGeometricRepresentationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGeometricRepresentationItem createIfcGeometricRepresentationItem() {
		IfcGeometricRepresentationItemImpl ifcGeometricRepresentationItem = new IfcGeometricRepresentationItemImpl();
		return ifcGeometricRepresentationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGeometricRepresentationSubContext createIfcGeometricRepresentationSubContext() {
		IfcGeometricRepresentationSubContextImpl ifcGeometricRepresentationSubContext = new IfcGeometricRepresentationSubContextImpl();
		return ifcGeometricRepresentationSubContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGeometricSet createIfcGeometricSet() {
		IfcGeometricSetImpl ifcGeometricSet = new IfcGeometricSetImpl();
		return ifcGeometricSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGrid createIfcGrid() {
		IfcGridImpl ifcGrid = new IfcGridImpl();
		return ifcGrid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGridAxis createIfcGridAxis() {
		IfcGridAxisImpl ifcGridAxis = new IfcGridAxisImpl();
		return ifcGridAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGridPlacement createIfcGridPlacement() {
		IfcGridPlacementImpl ifcGridPlacement = new IfcGridPlacementImpl();
		return ifcGridPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGroup createIfcGroup() {
		IfcGroupImpl ifcGroup = new IfcGroupImpl();
		return ifcGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHalfSpaceSolid createIfcHalfSpaceSolid() {
		IfcHalfSpaceSolidImpl ifcHalfSpaceSolid = new IfcHalfSpaceSolidImpl();
		return ifcHalfSpaceSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHeatExchanger createIfcHeatExchanger() {
		IfcHeatExchangerImpl ifcHeatExchanger = new IfcHeatExchangerImpl();
		return ifcHeatExchanger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHeatExchangerType createIfcHeatExchangerType() {
		IfcHeatExchangerTypeImpl ifcHeatExchangerType = new IfcHeatExchangerTypeImpl();
		return ifcHeatExchangerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHumidifier createIfcHumidifier() {
		IfcHumidifierImpl ifcHumidifier = new IfcHumidifierImpl();
		return ifcHumidifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHumidifierType createIfcHumidifierType() {
		IfcHumidifierTypeImpl ifcHumidifierType = new IfcHumidifierTypeImpl();
		return ifcHumidifierType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIShapeProfileDef createIfcIShapeProfileDef() {
		IfcIShapeProfileDefImpl ifcIShapeProfileDef = new IfcIShapeProfileDefImpl();
		return ifcIShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcImageTexture createIfcImageTexture() {
		IfcImageTextureImpl ifcImageTexture = new IfcImageTextureImpl();
		return ifcImageTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIndexedColourMap createIfcIndexedColourMap() {
		IfcIndexedColourMapImpl ifcIndexedColourMap = new IfcIndexedColourMapImpl();
		return ifcIndexedColourMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIndexedPolyCurve createIfcIndexedPolyCurve() {
		IfcIndexedPolyCurveImpl ifcIndexedPolyCurve = new IfcIndexedPolyCurveImpl();
		return ifcIndexedPolyCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIndexedPolygonalFace createIfcIndexedPolygonalFace() {
		IfcIndexedPolygonalFaceImpl ifcIndexedPolygonalFace = new IfcIndexedPolygonalFaceImpl();
		return ifcIndexedPolygonalFace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIndexedPolygonalFaceWithVoids createIfcIndexedPolygonalFaceWithVoids() {
		IfcIndexedPolygonalFaceWithVoidsImpl ifcIndexedPolygonalFaceWithVoids = new IfcIndexedPolygonalFaceWithVoidsImpl();
		return ifcIndexedPolygonalFaceWithVoids;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIndexedTextureMap createIfcIndexedTextureMap() {
		IfcIndexedTextureMapImpl ifcIndexedTextureMap = new IfcIndexedTextureMapImpl();
		return ifcIndexedTextureMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIndexedTriangleTextureMap createIfcIndexedTriangleTextureMap() {
		IfcIndexedTriangleTextureMapImpl ifcIndexedTriangleTextureMap = new IfcIndexedTriangleTextureMapImpl();
		return ifcIndexedTriangleTextureMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInterceptor createIfcInterceptor() {
		IfcInterceptorImpl ifcInterceptor = new IfcInterceptorImpl();
		return ifcInterceptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInterceptorType createIfcInterceptorType() {
		IfcInterceptorTypeImpl ifcInterceptorType = new IfcInterceptorTypeImpl();
		return ifcInterceptorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIntersectionCurve createIfcIntersectionCurve() {
		IfcIntersectionCurveImpl ifcIntersectionCurve = new IfcIntersectionCurveImpl();
		return ifcIntersectionCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInventory createIfcInventory() {
		IfcInventoryImpl ifcInventory = new IfcInventoryImpl();
		return ifcInventory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIrregularTimeSeries createIfcIrregularTimeSeries() {
		IfcIrregularTimeSeriesImpl ifcIrregularTimeSeries = new IfcIrregularTimeSeriesImpl();
		return ifcIrregularTimeSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIrregularTimeSeriesValue createIfcIrregularTimeSeriesValue() {
		IfcIrregularTimeSeriesValueImpl ifcIrregularTimeSeriesValue = new IfcIrregularTimeSeriesValueImpl();
		return ifcIrregularTimeSeriesValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcJunctionBox createIfcJunctionBox() {
		IfcJunctionBoxImpl ifcJunctionBox = new IfcJunctionBoxImpl();
		return ifcJunctionBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcJunctionBoxType createIfcJunctionBoxType() {
		IfcJunctionBoxTypeImpl ifcJunctionBoxType = new IfcJunctionBoxTypeImpl();
		return ifcJunctionBoxType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLShapeProfileDef createIfcLShapeProfileDef() {
		IfcLShapeProfileDefImpl ifcLShapeProfileDef = new IfcLShapeProfileDefImpl();
		return ifcLShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLaborResource createIfcLaborResource() {
		IfcLaborResourceImpl ifcLaborResource = new IfcLaborResourceImpl();
		return ifcLaborResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLaborResourceType createIfcLaborResourceType() {
		IfcLaborResourceTypeImpl ifcLaborResourceType = new IfcLaborResourceTypeImpl();
		return ifcLaborResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLagTime createIfcLagTime() {
		IfcLagTimeImpl ifcLagTime = new IfcLagTimeImpl();
		return ifcLagTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLamp createIfcLamp() {
		IfcLampImpl ifcLamp = new IfcLampImpl();
		return ifcLamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLampType createIfcLampType() {
		IfcLampTypeImpl ifcLampType = new IfcLampTypeImpl();
		return ifcLampType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLibraryInformation createIfcLibraryInformation() {
		IfcLibraryInformationImpl ifcLibraryInformation = new IfcLibraryInformationImpl();
		return ifcLibraryInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLibraryReference createIfcLibraryReference() {
		IfcLibraryReferenceImpl ifcLibraryReference = new IfcLibraryReferenceImpl();
		return ifcLibraryReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightDistributionData createIfcLightDistributionData() {
		IfcLightDistributionDataImpl ifcLightDistributionData = new IfcLightDistributionDataImpl();
		return ifcLightDistributionData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightFixture createIfcLightFixture() {
		IfcLightFixtureImpl ifcLightFixture = new IfcLightFixtureImpl();
		return ifcLightFixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightFixtureType createIfcLightFixtureType() {
		IfcLightFixtureTypeImpl ifcLightFixtureType = new IfcLightFixtureTypeImpl();
		return ifcLightFixtureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightIntensityDistribution createIfcLightIntensityDistribution() {
		IfcLightIntensityDistributionImpl ifcLightIntensityDistribution = new IfcLightIntensityDistributionImpl();
		return ifcLightIntensityDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightSource createIfcLightSource() {
		IfcLightSourceImpl ifcLightSource = new IfcLightSourceImpl();
		return ifcLightSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightSourceAmbient createIfcLightSourceAmbient() {
		IfcLightSourceAmbientImpl ifcLightSourceAmbient = new IfcLightSourceAmbientImpl();
		return ifcLightSourceAmbient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightSourceDirectional createIfcLightSourceDirectional() {
		IfcLightSourceDirectionalImpl ifcLightSourceDirectional = new IfcLightSourceDirectionalImpl();
		return ifcLightSourceDirectional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightSourceGoniometric createIfcLightSourceGoniometric() {
		IfcLightSourceGoniometricImpl ifcLightSourceGoniometric = new IfcLightSourceGoniometricImpl();
		return ifcLightSourceGoniometric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightSourcePositional createIfcLightSourcePositional() {
		IfcLightSourcePositionalImpl ifcLightSourcePositional = new IfcLightSourcePositionalImpl();
		return ifcLightSourcePositional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLightSourceSpot createIfcLightSourceSpot() {
		IfcLightSourceSpotImpl ifcLightSourceSpot = new IfcLightSourceSpotImpl();
		return ifcLightSourceSpot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLine createIfcLine() {
		IfcLineImpl ifcLine = new IfcLineImpl();
		return ifcLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLocalPlacement createIfcLocalPlacement() {
		IfcLocalPlacementImpl ifcLocalPlacement = new IfcLocalPlacementImpl();
		return ifcLocalPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLoop createIfcLoop() {
		IfcLoopImpl ifcLoop = new IfcLoopImpl();
		return ifcLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcManifoldSolidBrep createIfcManifoldSolidBrep() {
		IfcManifoldSolidBrepImpl ifcManifoldSolidBrep = new IfcManifoldSolidBrepImpl();
		return ifcManifoldSolidBrep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMapConversion createIfcMapConversion() {
		IfcMapConversionImpl ifcMapConversion = new IfcMapConversionImpl();
		return ifcMapConversion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMappedItem createIfcMappedItem() {
		IfcMappedItemImpl ifcMappedItem = new IfcMappedItemImpl();
		return ifcMappedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterial createIfcMaterial() {
		IfcMaterialImpl ifcMaterial = new IfcMaterialImpl();
		return ifcMaterial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialClassificationRelationship createIfcMaterialClassificationRelationship() {
		IfcMaterialClassificationRelationshipImpl ifcMaterialClassificationRelationship = new IfcMaterialClassificationRelationshipImpl();
		return ifcMaterialClassificationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialConstituent createIfcMaterialConstituent() {
		IfcMaterialConstituentImpl ifcMaterialConstituent = new IfcMaterialConstituentImpl();
		return ifcMaterialConstituent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialConstituentSet createIfcMaterialConstituentSet() {
		IfcMaterialConstituentSetImpl ifcMaterialConstituentSet = new IfcMaterialConstituentSetImpl();
		return ifcMaterialConstituentSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialDefinition createIfcMaterialDefinition() {
		IfcMaterialDefinitionImpl ifcMaterialDefinition = new IfcMaterialDefinitionImpl();
		return ifcMaterialDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialDefinitionRepresentation createIfcMaterialDefinitionRepresentation() {
		IfcMaterialDefinitionRepresentationImpl ifcMaterialDefinitionRepresentation = new IfcMaterialDefinitionRepresentationImpl();
		return ifcMaterialDefinitionRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialLayer createIfcMaterialLayer() {
		IfcMaterialLayerImpl ifcMaterialLayer = new IfcMaterialLayerImpl();
		return ifcMaterialLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialLayerSet createIfcMaterialLayerSet() {
		IfcMaterialLayerSetImpl ifcMaterialLayerSet = new IfcMaterialLayerSetImpl();
		return ifcMaterialLayerSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialLayerSetUsage createIfcMaterialLayerSetUsage() {
		IfcMaterialLayerSetUsageImpl ifcMaterialLayerSetUsage = new IfcMaterialLayerSetUsageImpl();
		return ifcMaterialLayerSetUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialLayerWithOffsets createIfcMaterialLayerWithOffsets() {
		IfcMaterialLayerWithOffsetsImpl ifcMaterialLayerWithOffsets = new IfcMaterialLayerWithOffsetsImpl();
		return ifcMaterialLayerWithOffsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialList createIfcMaterialList() {
		IfcMaterialListImpl ifcMaterialList = new IfcMaterialListImpl();
		return ifcMaterialList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialProfile createIfcMaterialProfile() {
		IfcMaterialProfileImpl ifcMaterialProfile = new IfcMaterialProfileImpl();
		return ifcMaterialProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialProfileSet createIfcMaterialProfileSet() {
		IfcMaterialProfileSetImpl ifcMaterialProfileSet = new IfcMaterialProfileSetImpl();
		return ifcMaterialProfileSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialProfileSetUsage createIfcMaterialProfileSetUsage() {
		IfcMaterialProfileSetUsageImpl ifcMaterialProfileSetUsage = new IfcMaterialProfileSetUsageImpl();
		return ifcMaterialProfileSetUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialProfileSetUsageTapering createIfcMaterialProfileSetUsageTapering() {
		IfcMaterialProfileSetUsageTaperingImpl ifcMaterialProfileSetUsageTapering = new IfcMaterialProfileSetUsageTaperingImpl();
		return ifcMaterialProfileSetUsageTapering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialProfileWithOffsets createIfcMaterialProfileWithOffsets() {
		IfcMaterialProfileWithOffsetsImpl ifcMaterialProfileWithOffsets = new IfcMaterialProfileWithOffsetsImpl();
		return ifcMaterialProfileWithOffsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialProperties createIfcMaterialProperties() {
		IfcMaterialPropertiesImpl ifcMaterialProperties = new IfcMaterialPropertiesImpl();
		return ifcMaterialProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialRelationship createIfcMaterialRelationship() {
		IfcMaterialRelationshipImpl ifcMaterialRelationship = new IfcMaterialRelationshipImpl();
		return ifcMaterialRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMaterialUsageDefinition createIfcMaterialUsageDefinition() {
		IfcMaterialUsageDefinitionImpl ifcMaterialUsageDefinition = new IfcMaterialUsageDefinitionImpl();
		return ifcMaterialUsageDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMeasureWithUnit createIfcMeasureWithUnit() {
		IfcMeasureWithUnitImpl ifcMeasureWithUnit = new IfcMeasureWithUnitImpl();
		return ifcMeasureWithUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMechanicalFastener createIfcMechanicalFastener() {
		IfcMechanicalFastenerImpl ifcMechanicalFastener = new IfcMechanicalFastenerImpl();
		return ifcMechanicalFastener;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMechanicalFastenerType createIfcMechanicalFastenerType() {
		IfcMechanicalFastenerTypeImpl ifcMechanicalFastenerType = new IfcMechanicalFastenerTypeImpl();
		return ifcMechanicalFastenerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMedicalDevice createIfcMedicalDevice() {
		IfcMedicalDeviceImpl ifcMedicalDevice = new IfcMedicalDeviceImpl();
		return ifcMedicalDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMedicalDeviceType createIfcMedicalDeviceType() {
		IfcMedicalDeviceTypeImpl ifcMedicalDeviceType = new IfcMedicalDeviceTypeImpl();
		return ifcMedicalDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMember createIfcMember() {
		IfcMemberImpl ifcMember = new IfcMemberImpl();
		return ifcMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMemberStandardCase createIfcMemberStandardCase() {
		IfcMemberStandardCaseImpl ifcMemberStandardCase = new IfcMemberStandardCaseImpl();
		return ifcMemberStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMemberType createIfcMemberType() {
		IfcMemberTypeImpl ifcMemberType = new IfcMemberTypeImpl();
		return ifcMemberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMetric createIfcMetric() {
		IfcMetricImpl ifcMetric = new IfcMetricImpl();
		return ifcMetric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMirroredProfileDef createIfcMirroredProfileDef() {
		IfcMirroredProfileDefImpl ifcMirroredProfileDef = new IfcMirroredProfileDefImpl();
		return ifcMirroredProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMonetaryUnit createIfcMonetaryUnit() {
		IfcMonetaryUnitImpl ifcMonetaryUnit = new IfcMonetaryUnitImpl();
		return ifcMonetaryUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMotorConnection createIfcMotorConnection() {
		IfcMotorConnectionImpl ifcMotorConnection = new IfcMotorConnectionImpl();
		return ifcMotorConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMotorConnectionType createIfcMotorConnectionType() {
		IfcMotorConnectionTypeImpl ifcMotorConnectionType = new IfcMotorConnectionTypeImpl();
		return ifcMotorConnectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcNamedUnit createIfcNamedUnit() {
		IfcNamedUnitImpl ifcNamedUnit = new IfcNamedUnitImpl();
		return ifcNamedUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcObject createIfcObject() {
		IfcObjectImpl ifcObject = new IfcObjectImpl();
		return ifcObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcObjectDefinition createIfcObjectDefinition() {
		IfcObjectDefinitionImpl ifcObjectDefinition = new IfcObjectDefinitionImpl();
		return ifcObjectDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcObjectPlacement createIfcObjectPlacement() {
		IfcObjectPlacementImpl ifcObjectPlacement = new IfcObjectPlacementImpl();
		return ifcObjectPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcObjective createIfcObjective() {
		IfcObjectiveImpl ifcObjective = new IfcObjectiveImpl();
		return ifcObjective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOccupant createIfcOccupant() {
		IfcOccupantImpl ifcOccupant = new IfcOccupantImpl();
		return ifcOccupant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOffsetCurve2D createIfcOffsetCurve2D() {
		IfcOffsetCurve2DImpl ifcOffsetCurve2D = new IfcOffsetCurve2DImpl();
		return ifcOffsetCurve2D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOffsetCurve3D createIfcOffsetCurve3D() {
		IfcOffsetCurve3DImpl ifcOffsetCurve3D = new IfcOffsetCurve3DImpl();
		return ifcOffsetCurve3D;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOpenShell createIfcOpenShell() {
		IfcOpenShellImpl ifcOpenShell = new IfcOpenShellImpl();
		return ifcOpenShell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOpeningElement createIfcOpeningElement() {
		IfcOpeningElementImpl ifcOpeningElement = new IfcOpeningElementImpl();
		return ifcOpeningElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOpeningStandardCase createIfcOpeningStandardCase() {
		IfcOpeningStandardCaseImpl ifcOpeningStandardCase = new IfcOpeningStandardCaseImpl();
		return ifcOpeningStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOrganization createIfcOrganization() {
		IfcOrganizationImpl ifcOrganization = new IfcOrganizationImpl();
		return ifcOrganization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOrganizationRelationship createIfcOrganizationRelationship() {
		IfcOrganizationRelationshipImpl ifcOrganizationRelationship = new IfcOrganizationRelationshipImpl();
		return ifcOrganizationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOrientedEdge createIfcOrientedEdge() {
		IfcOrientedEdgeImpl ifcOrientedEdge = new IfcOrientedEdgeImpl();
		return ifcOrientedEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOuterBoundaryCurve createIfcOuterBoundaryCurve() {
		IfcOuterBoundaryCurveImpl ifcOuterBoundaryCurve = new IfcOuterBoundaryCurveImpl();
		return ifcOuterBoundaryCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOutlet createIfcOutlet() {
		IfcOutletImpl ifcOutlet = new IfcOutletImpl();
		return ifcOutlet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOutletType createIfcOutletType() {
		IfcOutletTypeImpl ifcOutletType = new IfcOutletTypeImpl();
		return ifcOutletType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcOwnerHistory createIfcOwnerHistory() {
		IfcOwnerHistoryImpl ifcOwnerHistory = new IfcOwnerHistoryImpl();
		return ifcOwnerHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcParameterizedProfileDef createIfcParameterizedProfileDef() {
		IfcParameterizedProfileDefImpl ifcParameterizedProfileDef = new IfcParameterizedProfileDefImpl();
		return ifcParameterizedProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPath createIfcPath() {
		IfcPathImpl ifcPath = new IfcPathImpl();
		return ifcPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPcurve createIfcPcurve() {
		IfcPcurveImpl ifcPcurve = new IfcPcurveImpl();
		return ifcPcurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPerformanceHistory createIfcPerformanceHistory() {
		IfcPerformanceHistoryImpl ifcPerformanceHistory = new IfcPerformanceHistoryImpl();
		return ifcPerformanceHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPermeableCoveringProperties createIfcPermeableCoveringProperties() {
		IfcPermeableCoveringPropertiesImpl ifcPermeableCoveringProperties = new IfcPermeableCoveringPropertiesImpl();
		return ifcPermeableCoveringProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPermit createIfcPermit() {
		IfcPermitImpl ifcPermit = new IfcPermitImpl();
		return ifcPermit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPerson createIfcPerson() {
		IfcPersonImpl ifcPerson = new IfcPersonImpl();
		return ifcPerson;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPersonAndOrganization createIfcPersonAndOrganization() {
		IfcPersonAndOrganizationImpl ifcPersonAndOrganization = new IfcPersonAndOrganizationImpl();
		return ifcPersonAndOrganization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPhysicalComplexQuantity createIfcPhysicalComplexQuantity() {
		IfcPhysicalComplexQuantityImpl ifcPhysicalComplexQuantity = new IfcPhysicalComplexQuantityImpl();
		return ifcPhysicalComplexQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPhysicalQuantity createIfcPhysicalQuantity() {
		IfcPhysicalQuantityImpl ifcPhysicalQuantity = new IfcPhysicalQuantityImpl();
		return ifcPhysicalQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPhysicalSimpleQuantity createIfcPhysicalSimpleQuantity() {
		IfcPhysicalSimpleQuantityImpl ifcPhysicalSimpleQuantity = new IfcPhysicalSimpleQuantityImpl();
		return ifcPhysicalSimpleQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPile createIfcPile() {
		IfcPileImpl ifcPile = new IfcPileImpl();
		return ifcPile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPileType createIfcPileType() {
		IfcPileTypeImpl ifcPileType = new IfcPileTypeImpl();
		return ifcPileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPipeFitting createIfcPipeFitting() {
		IfcPipeFittingImpl ifcPipeFitting = new IfcPipeFittingImpl();
		return ifcPipeFitting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPipeFittingType createIfcPipeFittingType() {
		IfcPipeFittingTypeImpl ifcPipeFittingType = new IfcPipeFittingTypeImpl();
		return ifcPipeFittingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPipeSegment createIfcPipeSegment() {
		IfcPipeSegmentImpl ifcPipeSegment = new IfcPipeSegmentImpl();
		return ifcPipeSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPipeSegmentType createIfcPipeSegmentType() {
		IfcPipeSegmentTypeImpl ifcPipeSegmentType = new IfcPipeSegmentTypeImpl();
		return ifcPipeSegmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPixelTexture createIfcPixelTexture() {
		IfcPixelTextureImpl ifcPixelTexture = new IfcPixelTextureImpl();
		return ifcPixelTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlacement createIfcPlacement() {
		IfcPlacementImpl ifcPlacement = new IfcPlacementImpl();
		return ifcPlacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlanarBox createIfcPlanarBox() {
		IfcPlanarBoxImpl ifcPlanarBox = new IfcPlanarBoxImpl();
		return ifcPlanarBox;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlanarExtent createIfcPlanarExtent() {
		IfcPlanarExtentImpl ifcPlanarExtent = new IfcPlanarExtentImpl();
		return ifcPlanarExtent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlane createIfcPlane() {
		IfcPlaneImpl ifcPlane = new IfcPlaneImpl();
		return ifcPlane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlate createIfcPlate() {
		IfcPlateImpl ifcPlate = new IfcPlateImpl();
		return ifcPlate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlateStandardCase createIfcPlateStandardCase() {
		IfcPlateStandardCaseImpl ifcPlateStandardCase = new IfcPlateStandardCaseImpl();
		return ifcPlateStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlateType createIfcPlateType() {
		IfcPlateTypeImpl ifcPlateType = new IfcPlateTypeImpl();
		return ifcPlateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPoint createIfcPoint() {
		IfcPointImpl ifcPoint = new IfcPointImpl();
		return ifcPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPointOnCurve createIfcPointOnCurve() {
		IfcPointOnCurveImpl ifcPointOnCurve = new IfcPointOnCurveImpl();
		return ifcPointOnCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPointOnSurface createIfcPointOnSurface() {
		IfcPointOnSurfaceImpl ifcPointOnSurface = new IfcPointOnSurfaceImpl();
		return ifcPointOnSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPolyLoop createIfcPolyLoop() {
		IfcPolyLoopImpl ifcPolyLoop = new IfcPolyLoopImpl();
		return ifcPolyLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPolygonalBoundedHalfSpace createIfcPolygonalBoundedHalfSpace() {
		IfcPolygonalBoundedHalfSpaceImpl ifcPolygonalBoundedHalfSpace = new IfcPolygonalBoundedHalfSpaceImpl();
		return ifcPolygonalBoundedHalfSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPolygonalFaceSet createIfcPolygonalFaceSet() {
		IfcPolygonalFaceSetImpl ifcPolygonalFaceSet = new IfcPolygonalFaceSetImpl();
		return ifcPolygonalFaceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPolyline createIfcPolyline() {
		IfcPolylineImpl ifcPolyline = new IfcPolylineImpl();
		return ifcPolyline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPort createIfcPort() {
		IfcPortImpl ifcPort = new IfcPortImpl();
		return ifcPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPostalAddress createIfcPostalAddress() {
		IfcPostalAddressImpl ifcPostalAddress = new IfcPostalAddressImpl();
		return ifcPostalAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPreDefinedColour createIfcPreDefinedColour() {
		IfcPreDefinedColourImpl ifcPreDefinedColour = new IfcPreDefinedColourImpl();
		return ifcPreDefinedColour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPreDefinedCurveFont createIfcPreDefinedCurveFont() {
		IfcPreDefinedCurveFontImpl ifcPreDefinedCurveFont = new IfcPreDefinedCurveFontImpl();
		return ifcPreDefinedCurveFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPreDefinedItem createIfcPreDefinedItem() {
		IfcPreDefinedItemImpl ifcPreDefinedItem = new IfcPreDefinedItemImpl();
		return ifcPreDefinedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPreDefinedProperties createIfcPreDefinedProperties() {
		IfcPreDefinedPropertiesImpl ifcPreDefinedProperties = new IfcPreDefinedPropertiesImpl();
		return ifcPreDefinedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPreDefinedPropertySet createIfcPreDefinedPropertySet() {
		IfcPreDefinedPropertySetImpl ifcPreDefinedPropertySet = new IfcPreDefinedPropertySetImpl();
		return ifcPreDefinedPropertySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPreDefinedTextFont createIfcPreDefinedTextFont() {
		IfcPreDefinedTextFontImpl ifcPreDefinedTextFont = new IfcPreDefinedTextFontImpl();
		return ifcPreDefinedTextFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPresentationItem createIfcPresentationItem() {
		IfcPresentationItemImpl ifcPresentationItem = new IfcPresentationItemImpl();
		return ifcPresentationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPresentationLayerAssignment createIfcPresentationLayerAssignment() {
		IfcPresentationLayerAssignmentImpl ifcPresentationLayerAssignment = new IfcPresentationLayerAssignmentImpl();
		return ifcPresentationLayerAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPresentationLayerWithStyle createIfcPresentationLayerWithStyle() {
		IfcPresentationLayerWithStyleImpl ifcPresentationLayerWithStyle = new IfcPresentationLayerWithStyleImpl();
		return ifcPresentationLayerWithStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPresentationStyle createIfcPresentationStyle() {
		IfcPresentationStyleImpl ifcPresentationStyle = new IfcPresentationStyleImpl();
		return ifcPresentationStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPresentationStyleAssignment createIfcPresentationStyleAssignment() {
		IfcPresentationStyleAssignmentImpl ifcPresentationStyleAssignment = new IfcPresentationStyleAssignmentImpl();
		return ifcPresentationStyleAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProcedure createIfcProcedure() {
		IfcProcedureImpl ifcProcedure = new IfcProcedureImpl();
		return ifcProcedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProcedureType createIfcProcedureType() {
		IfcProcedureTypeImpl ifcProcedureType = new IfcProcedureTypeImpl();
		return ifcProcedureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProcess createIfcProcess() {
		IfcProcessImpl ifcProcess = new IfcProcessImpl();
		return ifcProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProduct createIfcProduct() {
		IfcProductImpl ifcProduct = new IfcProductImpl();
		return ifcProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProductDefinitionShape createIfcProductDefinitionShape() {
		IfcProductDefinitionShapeImpl ifcProductDefinitionShape = new IfcProductDefinitionShapeImpl();
		return ifcProductDefinitionShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProductRepresentation createIfcProductRepresentation() {
		IfcProductRepresentationImpl ifcProductRepresentation = new IfcProductRepresentationImpl();
		return ifcProductRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProfileDef createIfcProfileDef() {
		IfcProfileDefImpl ifcProfileDef = new IfcProfileDefImpl();
		return ifcProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProfileProperties createIfcProfileProperties() {
		IfcProfilePropertiesImpl ifcProfileProperties = new IfcProfilePropertiesImpl();
		return ifcProfileProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProject createIfcProject() {
		IfcProjectImpl ifcProject = new IfcProjectImpl();
		return ifcProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProjectLibrary createIfcProjectLibrary() {
		IfcProjectLibraryImpl ifcProjectLibrary = new IfcProjectLibraryImpl();
		return ifcProjectLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProjectOrder createIfcProjectOrder() {
		IfcProjectOrderImpl ifcProjectOrder = new IfcProjectOrderImpl();
		return ifcProjectOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProjectedCRS createIfcProjectedCRS() {
		IfcProjectedCRSImpl ifcProjectedCRS = new IfcProjectedCRSImpl();
		return ifcProjectedCRS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProjectionElement createIfcProjectionElement() {
		IfcProjectionElementImpl ifcProjectionElement = new IfcProjectionElementImpl();
		return ifcProjectionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProperty createIfcProperty() {
		IfcPropertyImpl ifcProperty = new IfcPropertyImpl();
		return ifcProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyAbstraction createIfcPropertyAbstraction() {
		IfcPropertyAbstractionImpl ifcPropertyAbstraction = new IfcPropertyAbstractionImpl();
		return ifcPropertyAbstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyBoundedValue createIfcPropertyBoundedValue() {
		IfcPropertyBoundedValueImpl ifcPropertyBoundedValue = new IfcPropertyBoundedValueImpl();
		return ifcPropertyBoundedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyDefinition createIfcPropertyDefinition() {
		IfcPropertyDefinitionImpl ifcPropertyDefinition = new IfcPropertyDefinitionImpl();
		return ifcPropertyDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyDependencyRelationship createIfcPropertyDependencyRelationship() {
		IfcPropertyDependencyRelationshipImpl ifcPropertyDependencyRelationship = new IfcPropertyDependencyRelationshipImpl();
		return ifcPropertyDependencyRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyEnumeratedValue createIfcPropertyEnumeratedValue() {
		IfcPropertyEnumeratedValueImpl ifcPropertyEnumeratedValue = new IfcPropertyEnumeratedValueImpl();
		return ifcPropertyEnumeratedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyEnumeration createIfcPropertyEnumeration() {
		IfcPropertyEnumerationImpl ifcPropertyEnumeration = new IfcPropertyEnumerationImpl();
		return ifcPropertyEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyListValue createIfcPropertyListValue() {
		IfcPropertyListValueImpl ifcPropertyListValue = new IfcPropertyListValueImpl();
		return ifcPropertyListValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyReferenceValue createIfcPropertyReferenceValue() {
		IfcPropertyReferenceValueImpl ifcPropertyReferenceValue = new IfcPropertyReferenceValueImpl();
		return ifcPropertyReferenceValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertySet createIfcPropertySet() {
		IfcPropertySetImpl ifcPropertySet = new IfcPropertySetImpl();
		return ifcPropertySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertySetDefinition createIfcPropertySetDefinition() {
		IfcPropertySetDefinitionImpl ifcPropertySetDefinition = new IfcPropertySetDefinitionImpl();
		return ifcPropertySetDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertySetTemplate createIfcPropertySetTemplate() {
		IfcPropertySetTemplateImpl ifcPropertySetTemplate = new IfcPropertySetTemplateImpl();
		return ifcPropertySetTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertySingleValue createIfcPropertySingleValue() {
		IfcPropertySingleValueImpl ifcPropertySingleValue = new IfcPropertySingleValueImpl();
		return ifcPropertySingleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyTableValue createIfcPropertyTableValue() {
		IfcPropertyTableValueImpl ifcPropertyTableValue = new IfcPropertyTableValueImpl();
		return ifcPropertyTableValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyTemplate createIfcPropertyTemplate() {
		IfcPropertyTemplateImpl ifcPropertyTemplate = new IfcPropertyTemplateImpl();
		return ifcPropertyTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPropertyTemplateDefinition createIfcPropertyTemplateDefinition() {
		IfcPropertyTemplateDefinitionImpl ifcPropertyTemplateDefinition = new IfcPropertyTemplateDefinitionImpl();
		return ifcPropertyTemplateDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProtectiveDevice createIfcProtectiveDevice() {
		IfcProtectiveDeviceImpl ifcProtectiveDevice = new IfcProtectiveDeviceImpl();
		return ifcProtectiveDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProtectiveDeviceTrippingUnit createIfcProtectiveDeviceTrippingUnit() {
		IfcProtectiveDeviceTrippingUnitImpl ifcProtectiveDeviceTrippingUnit = new IfcProtectiveDeviceTrippingUnitImpl();
		return ifcProtectiveDeviceTrippingUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProtectiveDeviceTrippingUnitType createIfcProtectiveDeviceTrippingUnitType() {
		IfcProtectiveDeviceTrippingUnitTypeImpl ifcProtectiveDeviceTrippingUnitType = new IfcProtectiveDeviceTrippingUnitTypeImpl();
		return ifcProtectiveDeviceTrippingUnitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProtectiveDeviceType createIfcProtectiveDeviceType() {
		IfcProtectiveDeviceTypeImpl ifcProtectiveDeviceType = new IfcProtectiveDeviceTypeImpl();
		return ifcProtectiveDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcProxy createIfcProxy() {
		IfcProxyImpl ifcProxy = new IfcProxyImpl();
		return ifcProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPump createIfcPump() {
		IfcPumpImpl ifcPump = new IfcPumpImpl();
		return ifcPump;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPumpType createIfcPumpType() {
		IfcPumpTypeImpl ifcPumpType = new IfcPumpTypeImpl();
		return ifcPumpType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcQuantityArea createIfcQuantityArea() {
		IfcQuantityAreaImpl ifcQuantityArea = new IfcQuantityAreaImpl();
		return ifcQuantityArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcQuantityCount createIfcQuantityCount() {
		IfcQuantityCountImpl ifcQuantityCount = new IfcQuantityCountImpl();
		return ifcQuantityCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcQuantityLength createIfcQuantityLength() {
		IfcQuantityLengthImpl ifcQuantityLength = new IfcQuantityLengthImpl();
		return ifcQuantityLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcQuantitySet createIfcQuantitySet() {
		IfcQuantitySetImpl ifcQuantitySet = new IfcQuantitySetImpl();
		return ifcQuantitySet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcQuantityTime createIfcQuantityTime() {
		IfcQuantityTimeImpl ifcQuantityTime = new IfcQuantityTimeImpl();
		return ifcQuantityTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcQuantityVolume createIfcQuantityVolume() {
		IfcQuantityVolumeImpl ifcQuantityVolume = new IfcQuantityVolumeImpl();
		return ifcQuantityVolume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcQuantityWeight createIfcQuantityWeight() {
		IfcQuantityWeightImpl ifcQuantityWeight = new IfcQuantityWeightImpl();
		return ifcQuantityWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRailing createIfcRailing() {
		IfcRailingImpl ifcRailing = new IfcRailingImpl();
		return ifcRailing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRailingType createIfcRailingType() {
		IfcRailingTypeImpl ifcRailingType = new IfcRailingTypeImpl();
		return ifcRailingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRamp createIfcRamp() {
		IfcRampImpl ifcRamp = new IfcRampImpl();
		return ifcRamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRampFlight createIfcRampFlight() {
		IfcRampFlightImpl ifcRampFlight = new IfcRampFlightImpl();
		return ifcRampFlight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRampFlightType createIfcRampFlightType() {
		IfcRampFlightTypeImpl ifcRampFlightType = new IfcRampFlightTypeImpl();
		return ifcRampFlightType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRampType createIfcRampType() {
		IfcRampTypeImpl ifcRampType = new IfcRampTypeImpl();
		return ifcRampType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRationalBSplineCurveWithKnots createIfcRationalBSplineCurveWithKnots() {
		IfcRationalBSplineCurveWithKnotsImpl ifcRationalBSplineCurveWithKnots = new IfcRationalBSplineCurveWithKnotsImpl();
		return ifcRationalBSplineCurveWithKnots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRationalBSplineSurfaceWithKnots createIfcRationalBSplineSurfaceWithKnots() {
		IfcRationalBSplineSurfaceWithKnotsImpl ifcRationalBSplineSurfaceWithKnots = new IfcRationalBSplineSurfaceWithKnotsImpl();
		return ifcRationalBSplineSurfaceWithKnots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRectangleHollowProfileDef createIfcRectangleHollowProfileDef() {
		IfcRectangleHollowProfileDefImpl ifcRectangleHollowProfileDef = new IfcRectangleHollowProfileDefImpl();
		return ifcRectangleHollowProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRectangleProfileDef createIfcRectangleProfileDef() {
		IfcRectangleProfileDefImpl ifcRectangleProfileDef = new IfcRectangleProfileDefImpl();
		return ifcRectangleProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRectangularPyramid createIfcRectangularPyramid() {
		IfcRectangularPyramidImpl ifcRectangularPyramid = new IfcRectangularPyramidImpl();
		return ifcRectangularPyramid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRectangularTrimmedSurface createIfcRectangularTrimmedSurface() {
		IfcRectangularTrimmedSurfaceImpl ifcRectangularTrimmedSurface = new IfcRectangularTrimmedSurfaceImpl();
		return ifcRectangularTrimmedSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRecurrencePattern createIfcRecurrencePattern() {
		IfcRecurrencePatternImpl ifcRecurrencePattern = new IfcRecurrencePatternImpl();
		return ifcRecurrencePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReference createIfcReference() {
		IfcReferenceImpl ifcReference = new IfcReferenceImpl();
		return ifcReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRegularTimeSeries createIfcRegularTimeSeries() {
		IfcRegularTimeSeriesImpl ifcRegularTimeSeries = new IfcRegularTimeSeriesImpl();
		return ifcRegularTimeSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcementBarProperties createIfcReinforcementBarProperties() {
		IfcReinforcementBarPropertiesImpl ifcReinforcementBarProperties = new IfcReinforcementBarPropertiesImpl();
		return ifcReinforcementBarProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcementDefinitionProperties createIfcReinforcementDefinitionProperties() {
		IfcReinforcementDefinitionPropertiesImpl ifcReinforcementDefinitionProperties = new IfcReinforcementDefinitionPropertiesImpl();
		return ifcReinforcementDefinitionProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBar createIfcReinforcingBar() {
		IfcReinforcingBarImpl ifcReinforcingBar = new IfcReinforcingBarImpl();
		return ifcReinforcingBar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBarType createIfcReinforcingBarType() {
		IfcReinforcingBarTypeImpl ifcReinforcingBarType = new IfcReinforcingBarTypeImpl();
		return ifcReinforcingBarType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingElement createIfcReinforcingElement() {
		IfcReinforcingElementImpl ifcReinforcingElement = new IfcReinforcingElementImpl();
		return ifcReinforcingElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingElementType createIfcReinforcingElementType() {
		IfcReinforcingElementTypeImpl ifcReinforcingElementType = new IfcReinforcingElementTypeImpl();
		return ifcReinforcingElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingMesh createIfcReinforcingMesh() {
		IfcReinforcingMeshImpl ifcReinforcingMesh = new IfcReinforcingMeshImpl();
		return ifcReinforcingMesh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingMeshType createIfcReinforcingMeshType() {
		IfcReinforcingMeshTypeImpl ifcReinforcingMeshType = new IfcReinforcingMeshTypeImpl();
		return ifcReinforcingMeshType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAggregates createIfcRelAggregates() {
		IfcRelAggregatesImpl ifcRelAggregates = new IfcRelAggregatesImpl();
		return ifcRelAggregates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssigns createIfcRelAssigns() {
		IfcRelAssignsImpl ifcRelAssigns = new IfcRelAssignsImpl();
		return ifcRelAssigns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssignsToActor createIfcRelAssignsToActor() {
		IfcRelAssignsToActorImpl ifcRelAssignsToActor = new IfcRelAssignsToActorImpl();
		return ifcRelAssignsToActor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssignsToControl createIfcRelAssignsToControl() {
		IfcRelAssignsToControlImpl ifcRelAssignsToControl = new IfcRelAssignsToControlImpl();
		return ifcRelAssignsToControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssignsToGroup createIfcRelAssignsToGroup() {
		IfcRelAssignsToGroupImpl ifcRelAssignsToGroup = new IfcRelAssignsToGroupImpl();
		return ifcRelAssignsToGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssignsToGroupByFactor createIfcRelAssignsToGroupByFactor() {
		IfcRelAssignsToGroupByFactorImpl ifcRelAssignsToGroupByFactor = new IfcRelAssignsToGroupByFactorImpl();
		return ifcRelAssignsToGroupByFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssignsToProcess createIfcRelAssignsToProcess() {
		IfcRelAssignsToProcessImpl ifcRelAssignsToProcess = new IfcRelAssignsToProcessImpl();
		return ifcRelAssignsToProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssignsToProduct createIfcRelAssignsToProduct() {
		IfcRelAssignsToProductImpl ifcRelAssignsToProduct = new IfcRelAssignsToProductImpl();
		return ifcRelAssignsToProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssignsToResource createIfcRelAssignsToResource() {
		IfcRelAssignsToResourceImpl ifcRelAssignsToResource = new IfcRelAssignsToResourceImpl();
		return ifcRelAssignsToResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssociates createIfcRelAssociates() {
		IfcRelAssociatesImpl ifcRelAssociates = new IfcRelAssociatesImpl();
		return ifcRelAssociates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssociatesApproval createIfcRelAssociatesApproval() {
		IfcRelAssociatesApprovalImpl ifcRelAssociatesApproval = new IfcRelAssociatesApprovalImpl();
		return ifcRelAssociatesApproval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssociatesClassification createIfcRelAssociatesClassification() {
		IfcRelAssociatesClassificationImpl ifcRelAssociatesClassification = new IfcRelAssociatesClassificationImpl();
		return ifcRelAssociatesClassification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssociatesConstraint createIfcRelAssociatesConstraint() {
		IfcRelAssociatesConstraintImpl ifcRelAssociatesConstraint = new IfcRelAssociatesConstraintImpl();
		return ifcRelAssociatesConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssociatesDocument createIfcRelAssociatesDocument() {
		IfcRelAssociatesDocumentImpl ifcRelAssociatesDocument = new IfcRelAssociatesDocumentImpl();
		return ifcRelAssociatesDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssociatesLibrary createIfcRelAssociatesLibrary() {
		IfcRelAssociatesLibraryImpl ifcRelAssociatesLibrary = new IfcRelAssociatesLibraryImpl();
		return ifcRelAssociatesLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelAssociatesMaterial createIfcRelAssociatesMaterial() {
		IfcRelAssociatesMaterialImpl ifcRelAssociatesMaterial = new IfcRelAssociatesMaterialImpl();
		return ifcRelAssociatesMaterial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnects createIfcRelConnects() {
		IfcRelConnectsImpl ifcRelConnects = new IfcRelConnectsImpl();
		return ifcRelConnects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnectsElements createIfcRelConnectsElements() {
		IfcRelConnectsElementsImpl ifcRelConnectsElements = new IfcRelConnectsElementsImpl();
		return ifcRelConnectsElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnectsPathElements createIfcRelConnectsPathElements() {
		IfcRelConnectsPathElementsImpl ifcRelConnectsPathElements = new IfcRelConnectsPathElementsImpl();
		return ifcRelConnectsPathElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnectsPortToElement createIfcRelConnectsPortToElement() {
		IfcRelConnectsPortToElementImpl ifcRelConnectsPortToElement = new IfcRelConnectsPortToElementImpl();
		return ifcRelConnectsPortToElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnectsPorts createIfcRelConnectsPorts() {
		IfcRelConnectsPortsImpl ifcRelConnectsPorts = new IfcRelConnectsPortsImpl();
		return ifcRelConnectsPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnectsStructuralActivity createIfcRelConnectsStructuralActivity() {
		IfcRelConnectsStructuralActivityImpl ifcRelConnectsStructuralActivity = new IfcRelConnectsStructuralActivityImpl();
		return ifcRelConnectsStructuralActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnectsStructuralMember createIfcRelConnectsStructuralMember() {
		IfcRelConnectsStructuralMemberImpl ifcRelConnectsStructuralMember = new IfcRelConnectsStructuralMemberImpl();
		return ifcRelConnectsStructuralMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnectsWithEccentricity createIfcRelConnectsWithEccentricity() {
		IfcRelConnectsWithEccentricityImpl ifcRelConnectsWithEccentricity = new IfcRelConnectsWithEccentricityImpl();
		return ifcRelConnectsWithEccentricity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelConnectsWithRealizingElements createIfcRelConnectsWithRealizingElements() {
		IfcRelConnectsWithRealizingElementsImpl ifcRelConnectsWithRealizingElements = new IfcRelConnectsWithRealizingElementsImpl();
		return ifcRelConnectsWithRealizingElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelContainedInSpatialStructure createIfcRelContainedInSpatialStructure() {
		IfcRelContainedInSpatialStructureImpl ifcRelContainedInSpatialStructure = new IfcRelContainedInSpatialStructureImpl();
		return ifcRelContainedInSpatialStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelCoversBldgElements createIfcRelCoversBldgElements() {
		IfcRelCoversBldgElementsImpl ifcRelCoversBldgElements = new IfcRelCoversBldgElementsImpl();
		return ifcRelCoversBldgElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelCoversSpaces createIfcRelCoversSpaces() {
		IfcRelCoversSpacesImpl ifcRelCoversSpaces = new IfcRelCoversSpacesImpl();
		return ifcRelCoversSpaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelDeclares createIfcRelDeclares() {
		IfcRelDeclaresImpl ifcRelDeclares = new IfcRelDeclaresImpl();
		return ifcRelDeclares;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelDecomposes createIfcRelDecomposes() {
		IfcRelDecomposesImpl ifcRelDecomposes = new IfcRelDecomposesImpl();
		return ifcRelDecomposes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelDefines createIfcRelDefines() {
		IfcRelDefinesImpl ifcRelDefines = new IfcRelDefinesImpl();
		return ifcRelDefines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelDefinesByObject createIfcRelDefinesByObject() {
		IfcRelDefinesByObjectImpl ifcRelDefinesByObject = new IfcRelDefinesByObjectImpl();
		return ifcRelDefinesByObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelDefinesByProperties createIfcRelDefinesByProperties() {
		IfcRelDefinesByPropertiesImpl ifcRelDefinesByProperties = new IfcRelDefinesByPropertiesImpl();
		return ifcRelDefinesByProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelDefinesByTemplate createIfcRelDefinesByTemplate() {
		IfcRelDefinesByTemplateImpl ifcRelDefinesByTemplate = new IfcRelDefinesByTemplateImpl();
		return ifcRelDefinesByTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelDefinesByType createIfcRelDefinesByType() {
		IfcRelDefinesByTypeImpl ifcRelDefinesByType = new IfcRelDefinesByTypeImpl();
		return ifcRelDefinesByType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelFillsElement createIfcRelFillsElement() {
		IfcRelFillsElementImpl ifcRelFillsElement = new IfcRelFillsElementImpl();
		return ifcRelFillsElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelFlowControlElements createIfcRelFlowControlElements() {
		IfcRelFlowControlElementsImpl ifcRelFlowControlElements = new IfcRelFlowControlElementsImpl();
		return ifcRelFlowControlElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelInterferesElements createIfcRelInterferesElements() {
		IfcRelInterferesElementsImpl ifcRelInterferesElements = new IfcRelInterferesElementsImpl();
		return ifcRelInterferesElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelNests createIfcRelNests() {
		IfcRelNestsImpl ifcRelNests = new IfcRelNestsImpl();
		return ifcRelNests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelProjectsElement createIfcRelProjectsElement() {
		IfcRelProjectsElementImpl ifcRelProjectsElement = new IfcRelProjectsElementImpl();
		return ifcRelProjectsElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelReferencedInSpatialStructure createIfcRelReferencedInSpatialStructure() {
		IfcRelReferencedInSpatialStructureImpl ifcRelReferencedInSpatialStructure = new IfcRelReferencedInSpatialStructureImpl();
		return ifcRelReferencedInSpatialStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelSequence createIfcRelSequence() {
		IfcRelSequenceImpl ifcRelSequence = new IfcRelSequenceImpl();
		return ifcRelSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelServicesBuildings createIfcRelServicesBuildings() {
		IfcRelServicesBuildingsImpl ifcRelServicesBuildings = new IfcRelServicesBuildingsImpl();
		return ifcRelServicesBuildings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelSpaceBoundary createIfcRelSpaceBoundary() {
		IfcRelSpaceBoundaryImpl ifcRelSpaceBoundary = new IfcRelSpaceBoundaryImpl();
		return ifcRelSpaceBoundary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelSpaceBoundary1stLevel createIfcRelSpaceBoundary1stLevel() {
		IfcRelSpaceBoundary1stLevelImpl ifcRelSpaceBoundary1stLevel = new IfcRelSpaceBoundary1stLevelImpl();
		return ifcRelSpaceBoundary1stLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelSpaceBoundary2ndLevel createIfcRelSpaceBoundary2ndLevel() {
		IfcRelSpaceBoundary2ndLevelImpl ifcRelSpaceBoundary2ndLevel = new IfcRelSpaceBoundary2ndLevelImpl();
		return ifcRelSpaceBoundary2ndLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelVoidsElement createIfcRelVoidsElement() {
		IfcRelVoidsElementImpl ifcRelVoidsElement = new IfcRelVoidsElementImpl();
		return ifcRelVoidsElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRelationship createIfcRelationship() {
		IfcRelationshipImpl ifcRelationship = new IfcRelationshipImpl();
		return ifcRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReparametrisedCompositeCurveSegment createIfcReparametrisedCompositeCurveSegment() {
		IfcReparametrisedCompositeCurveSegmentImpl ifcReparametrisedCompositeCurveSegment = new IfcReparametrisedCompositeCurveSegmentImpl();
		return ifcReparametrisedCompositeCurveSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRepresentation createIfcRepresentation() {
		IfcRepresentationImpl ifcRepresentation = new IfcRepresentationImpl();
		return ifcRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRepresentationContext createIfcRepresentationContext() {
		IfcRepresentationContextImpl ifcRepresentationContext = new IfcRepresentationContextImpl();
		return ifcRepresentationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRepresentationItem createIfcRepresentationItem() {
		IfcRepresentationItemImpl ifcRepresentationItem = new IfcRepresentationItemImpl();
		return ifcRepresentationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRepresentationMap createIfcRepresentationMap() {
		IfcRepresentationMapImpl ifcRepresentationMap = new IfcRepresentationMapImpl();
		return ifcRepresentationMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcResource createIfcResource() {
		IfcResourceImpl ifcResource = new IfcResourceImpl();
		return ifcResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcResourceApprovalRelationship createIfcResourceApprovalRelationship() {
		IfcResourceApprovalRelationshipImpl ifcResourceApprovalRelationship = new IfcResourceApprovalRelationshipImpl();
		return ifcResourceApprovalRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcResourceConstraintRelationship createIfcResourceConstraintRelationship() {
		IfcResourceConstraintRelationshipImpl ifcResourceConstraintRelationship = new IfcResourceConstraintRelationshipImpl();
		return ifcResourceConstraintRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcResourceLevelRelationship createIfcResourceLevelRelationship() {
		IfcResourceLevelRelationshipImpl ifcResourceLevelRelationship = new IfcResourceLevelRelationshipImpl();
		return ifcResourceLevelRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcResourceTime createIfcResourceTime() {
		IfcResourceTimeImpl ifcResourceTime = new IfcResourceTimeImpl();
		return ifcResourceTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRevolvedAreaSolid createIfcRevolvedAreaSolid() {
		IfcRevolvedAreaSolidImpl ifcRevolvedAreaSolid = new IfcRevolvedAreaSolidImpl();
		return ifcRevolvedAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRevolvedAreaSolidTapered createIfcRevolvedAreaSolidTapered() {
		IfcRevolvedAreaSolidTaperedImpl ifcRevolvedAreaSolidTapered = new IfcRevolvedAreaSolidTaperedImpl();
		return ifcRevolvedAreaSolidTapered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRightCircularCone createIfcRightCircularCone() {
		IfcRightCircularConeImpl ifcRightCircularCone = new IfcRightCircularConeImpl();
		return ifcRightCircularCone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRightCircularCylinder createIfcRightCircularCylinder() {
		IfcRightCircularCylinderImpl ifcRightCircularCylinder = new IfcRightCircularCylinderImpl();
		return ifcRightCircularCylinder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRoof createIfcRoof() {
		IfcRoofImpl ifcRoof = new IfcRoofImpl();
		return ifcRoof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRoofType createIfcRoofType() {
		IfcRoofTypeImpl ifcRoofType = new IfcRoofTypeImpl();
		return ifcRoofType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRoot createIfcRoot() {
		IfcRootImpl ifcRoot = new IfcRootImpl();
		return ifcRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRoundedRectangleProfileDef createIfcRoundedRectangleProfileDef() {
		IfcRoundedRectangleProfileDefImpl ifcRoundedRectangleProfileDef = new IfcRoundedRectangleProfileDefImpl();
		return ifcRoundedRectangleProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSIUnit createIfcSIUnit() {
		IfcSIUnitImpl ifcSIUnit = new IfcSIUnitImpl();
		return ifcSIUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSanitaryTerminal createIfcSanitaryTerminal() {
		IfcSanitaryTerminalImpl ifcSanitaryTerminal = new IfcSanitaryTerminalImpl();
		return ifcSanitaryTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSanitaryTerminalType createIfcSanitaryTerminalType() {
		IfcSanitaryTerminalTypeImpl ifcSanitaryTerminalType = new IfcSanitaryTerminalTypeImpl();
		return ifcSanitaryTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSchedulingTime createIfcSchedulingTime() {
		IfcSchedulingTimeImpl ifcSchedulingTime = new IfcSchedulingTimeImpl();
		return ifcSchedulingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSeamCurve createIfcSeamCurve() {
		IfcSeamCurveImpl ifcSeamCurve = new IfcSeamCurveImpl();
		return ifcSeamCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSectionProperties createIfcSectionProperties() {
		IfcSectionPropertiesImpl ifcSectionProperties = new IfcSectionPropertiesImpl();
		return ifcSectionProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSectionReinforcementProperties createIfcSectionReinforcementProperties() {
		IfcSectionReinforcementPropertiesImpl ifcSectionReinforcementProperties = new IfcSectionReinforcementPropertiesImpl();
		return ifcSectionReinforcementProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSectionedSpine createIfcSectionedSpine() {
		IfcSectionedSpineImpl ifcSectionedSpine = new IfcSectionedSpineImpl();
		return ifcSectionedSpine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSensor createIfcSensor() {
		IfcSensorImpl ifcSensor = new IfcSensorImpl();
		return ifcSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSensorType createIfcSensorType() {
		IfcSensorTypeImpl ifcSensorType = new IfcSensorTypeImpl();
		return ifcSensorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShadingDevice createIfcShadingDevice() {
		IfcShadingDeviceImpl ifcShadingDevice = new IfcShadingDeviceImpl();
		return ifcShadingDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShadingDeviceType createIfcShadingDeviceType() {
		IfcShadingDeviceTypeImpl ifcShadingDeviceType = new IfcShadingDeviceTypeImpl();
		return ifcShadingDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeAspect createIfcShapeAspect() {
		IfcShapeAspectImpl ifcShapeAspect = new IfcShapeAspectImpl();
		return ifcShapeAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeModel createIfcShapeModel() {
		IfcShapeModelImpl ifcShapeModel = new IfcShapeModelImpl();
		return ifcShapeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShapeRepresentation createIfcShapeRepresentation() {
		IfcShapeRepresentationImpl ifcShapeRepresentation = new IfcShapeRepresentationImpl();
		return ifcShapeRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShellBasedSurfaceModel createIfcShellBasedSurfaceModel() {
		IfcShellBasedSurfaceModelImpl ifcShellBasedSurfaceModel = new IfcShellBasedSurfaceModelImpl();
		return ifcShellBasedSurfaceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSimpleProperty createIfcSimpleProperty() {
		IfcSimplePropertyImpl ifcSimpleProperty = new IfcSimplePropertyImpl();
		return ifcSimpleProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSimplePropertyTemplate createIfcSimplePropertyTemplate() {
		IfcSimplePropertyTemplateImpl ifcSimplePropertyTemplate = new IfcSimplePropertyTemplateImpl();
		return ifcSimplePropertyTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSite createIfcSite() {
		IfcSiteImpl ifcSite = new IfcSiteImpl();
		return ifcSite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSlab createIfcSlab() {
		IfcSlabImpl ifcSlab = new IfcSlabImpl();
		return ifcSlab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSlabElementedCase createIfcSlabElementedCase() {
		IfcSlabElementedCaseImpl ifcSlabElementedCase = new IfcSlabElementedCaseImpl();
		return ifcSlabElementedCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSlabStandardCase createIfcSlabStandardCase() {
		IfcSlabStandardCaseImpl ifcSlabStandardCase = new IfcSlabStandardCaseImpl();
		return ifcSlabStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSlabType createIfcSlabType() {
		IfcSlabTypeImpl ifcSlabType = new IfcSlabTypeImpl();
		return ifcSlabType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSlippageConnectionCondition createIfcSlippageConnectionCondition() {
		IfcSlippageConnectionConditionImpl ifcSlippageConnectionCondition = new IfcSlippageConnectionConditionImpl();
		return ifcSlippageConnectionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSolarDevice createIfcSolarDevice() {
		IfcSolarDeviceImpl ifcSolarDevice = new IfcSolarDeviceImpl();
		return ifcSolarDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSolarDeviceType createIfcSolarDeviceType() {
		IfcSolarDeviceTypeImpl ifcSolarDeviceType = new IfcSolarDeviceTypeImpl();
		return ifcSolarDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSolidModel createIfcSolidModel() {
		IfcSolidModelImpl ifcSolidModel = new IfcSolidModelImpl();
		return ifcSolidModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpace createIfcSpace() {
		IfcSpaceImpl ifcSpace = new IfcSpaceImpl();
		return ifcSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpaceHeater createIfcSpaceHeater() {
		IfcSpaceHeaterImpl ifcSpaceHeater = new IfcSpaceHeaterImpl();
		return ifcSpaceHeater;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpaceHeaterType createIfcSpaceHeaterType() {
		IfcSpaceHeaterTypeImpl ifcSpaceHeaterType = new IfcSpaceHeaterTypeImpl();
		return ifcSpaceHeaterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpaceType createIfcSpaceType() {
		IfcSpaceTypeImpl ifcSpaceType = new IfcSpaceTypeImpl();
		return ifcSpaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpatialElement createIfcSpatialElement() {
		IfcSpatialElementImpl ifcSpatialElement = new IfcSpatialElementImpl();
		return ifcSpatialElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpatialElementType createIfcSpatialElementType() {
		IfcSpatialElementTypeImpl ifcSpatialElementType = new IfcSpatialElementTypeImpl();
		return ifcSpatialElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpatialStructureElement createIfcSpatialStructureElement() {
		IfcSpatialStructureElementImpl ifcSpatialStructureElement = new IfcSpatialStructureElementImpl();
		return ifcSpatialStructureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpatialStructureElementType createIfcSpatialStructureElementType() {
		IfcSpatialStructureElementTypeImpl ifcSpatialStructureElementType = new IfcSpatialStructureElementTypeImpl();
		return ifcSpatialStructureElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpatialZone createIfcSpatialZone() {
		IfcSpatialZoneImpl ifcSpatialZone = new IfcSpatialZoneImpl();
		return ifcSpatialZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpatialZoneType createIfcSpatialZoneType() {
		IfcSpatialZoneTypeImpl ifcSpatialZoneType = new IfcSpatialZoneTypeImpl();
		return ifcSpatialZoneType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSphere createIfcSphere() {
		IfcSphereImpl ifcSphere = new IfcSphereImpl();
		return ifcSphere;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSphericalSurface createIfcSphericalSurface() {
		IfcSphericalSurfaceImpl ifcSphericalSurface = new IfcSphericalSurfaceImpl();
		return ifcSphericalSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStackTerminal createIfcStackTerminal() {
		IfcStackTerminalImpl ifcStackTerminal = new IfcStackTerminalImpl();
		return ifcStackTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStackTerminalType createIfcStackTerminalType() {
		IfcStackTerminalTypeImpl ifcStackTerminalType = new IfcStackTerminalTypeImpl();
		return ifcStackTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStair createIfcStair() {
		IfcStairImpl ifcStair = new IfcStairImpl();
		return ifcStair;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStairFlight createIfcStairFlight() {
		IfcStairFlightImpl ifcStairFlight = new IfcStairFlightImpl();
		return ifcStairFlight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStairFlightType createIfcStairFlightType() {
		IfcStairFlightTypeImpl ifcStairFlightType = new IfcStairFlightTypeImpl();
		return ifcStairFlightType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStairType createIfcStairType() {
		IfcStairTypeImpl ifcStairType = new IfcStairTypeImpl();
		return ifcStairType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralAction createIfcStructuralAction() {
		IfcStructuralActionImpl ifcStructuralAction = new IfcStructuralActionImpl();
		return ifcStructuralAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralActivity createIfcStructuralActivity() {
		IfcStructuralActivityImpl ifcStructuralActivity = new IfcStructuralActivityImpl();
		return ifcStructuralActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralAnalysisModel createIfcStructuralAnalysisModel() {
		IfcStructuralAnalysisModelImpl ifcStructuralAnalysisModel = new IfcStructuralAnalysisModelImpl();
		return ifcStructuralAnalysisModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralConnection createIfcStructuralConnection() {
		IfcStructuralConnectionImpl ifcStructuralConnection = new IfcStructuralConnectionImpl();
		return ifcStructuralConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralConnectionCondition createIfcStructuralConnectionCondition() {
		IfcStructuralConnectionConditionImpl ifcStructuralConnectionCondition = new IfcStructuralConnectionConditionImpl();
		return ifcStructuralConnectionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralCurveAction createIfcStructuralCurveAction() {
		IfcStructuralCurveActionImpl ifcStructuralCurveAction = new IfcStructuralCurveActionImpl();
		return ifcStructuralCurveAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralCurveConnection createIfcStructuralCurveConnection() {
		IfcStructuralCurveConnectionImpl ifcStructuralCurveConnection = new IfcStructuralCurveConnectionImpl();
		return ifcStructuralCurveConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralCurveMember createIfcStructuralCurveMember() {
		IfcStructuralCurveMemberImpl ifcStructuralCurveMember = new IfcStructuralCurveMemberImpl();
		return ifcStructuralCurveMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralCurveMemberVarying createIfcStructuralCurveMemberVarying() {
		IfcStructuralCurveMemberVaryingImpl ifcStructuralCurveMemberVarying = new IfcStructuralCurveMemberVaryingImpl();
		return ifcStructuralCurveMemberVarying;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralCurveReaction createIfcStructuralCurveReaction() {
		IfcStructuralCurveReactionImpl ifcStructuralCurveReaction = new IfcStructuralCurveReactionImpl();
		return ifcStructuralCurveReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralItem createIfcStructuralItem() {
		IfcStructuralItemImpl ifcStructuralItem = new IfcStructuralItemImpl();
		return ifcStructuralItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLinearAction createIfcStructuralLinearAction() {
		IfcStructuralLinearActionImpl ifcStructuralLinearAction = new IfcStructuralLinearActionImpl();
		return ifcStructuralLinearAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoad createIfcStructuralLoad() {
		IfcStructuralLoadImpl ifcStructuralLoad = new IfcStructuralLoadImpl();
		return ifcStructuralLoad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadCase createIfcStructuralLoadCase() {
		IfcStructuralLoadCaseImpl ifcStructuralLoadCase = new IfcStructuralLoadCaseImpl();
		return ifcStructuralLoadCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadConfiguration createIfcStructuralLoadConfiguration() {
		IfcStructuralLoadConfigurationImpl ifcStructuralLoadConfiguration = new IfcStructuralLoadConfigurationImpl();
		return ifcStructuralLoadConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadGroup createIfcStructuralLoadGroup() {
		IfcStructuralLoadGroupImpl ifcStructuralLoadGroup = new IfcStructuralLoadGroupImpl();
		return ifcStructuralLoadGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadLinearForce createIfcStructuralLoadLinearForce() {
		IfcStructuralLoadLinearForceImpl ifcStructuralLoadLinearForce = new IfcStructuralLoadLinearForceImpl();
		return ifcStructuralLoadLinearForce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadOrResult createIfcStructuralLoadOrResult() {
		IfcStructuralLoadOrResultImpl ifcStructuralLoadOrResult = new IfcStructuralLoadOrResultImpl();
		return ifcStructuralLoadOrResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadPlanarForce createIfcStructuralLoadPlanarForce() {
		IfcStructuralLoadPlanarForceImpl ifcStructuralLoadPlanarForce = new IfcStructuralLoadPlanarForceImpl();
		return ifcStructuralLoadPlanarForce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadSingleDisplacement createIfcStructuralLoadSingleDisplacement() {
		IfcStructuralLoadSingleDisplacementImpl ifcStructuralLoadSingleDisplacement = new IfcStructuralLoadSingleDisplacementImpl();
		return ifcStructuralLoadSingleDisplacement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadSingleDisplacementDistortion createIfcStructuralLoadSingleDisplacementDistortion() {
		IfcStructuralLoadSingleDisplacementDistortionImpl ifcStructuralLoadSingleDisplacementDistortion = new IfcStructuralLoadSingleDisplacementDistortionImpl();
		return ifcStructuralLoadSingleDisplacementDistortion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadSingleForce createIfcStructuralLoadSingleForce() {
		IfcStructuralLoadSingleForceImpl ifcStructuralLoadSingleForce = new IfcStructuralLoadSingleForceImpl();
		return ifcStructuralLoadSingleForce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadSingleForceWarping createIfcStructuralLoadSingleForceWarping() {
		IfcStructuralLoadSingleForceWarpingImpl ifcStructuralLoadSingleForceWarping = new IfcStructuralLoadSingleForceWarpingImpl();
		return ifcStructuralLoadSingleForceWarping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadStatic createIfcStructuralLoadStatic() {
		IfcStructuralLoadStaticImpl ifcStructuralLoadStatic = new IfcStructuralLoadStaticImpl();
		return ifcStructuralLoadStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralLoadTemperature createIfcStructuralLoadTemperature() {
		IfcStructuralLoadTemperatureImpl ifcStructuralLoadTemperature = new IfcStructuralLoadTemperatureImpl();
		return ifcStructuralLoadTemperature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralMember createIfcStructuralMember() {
		IfcStructuralMemberImpl ifcStructuralMember = new IfcStructuralMemberImpl();
		return ifcStructuralMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralPlanarAction createIfcStructuralPlanarAction() {
		IfcStructuralPlanarActionImpl ifcStructuralPlanarAction = new IfcStructuralPlanarActionImpl();
		return ifcStructuralPlanarAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralPointAction createIfcStructuralPointAction() {
		IfcStructuralPointActionImpl ifcStructuralPointAction = new IfcStructuralPointActionImpl();
		return ifcStructuralPointAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralPointConnection createIfcStructuralPointConnection() {
		IfcStructuralPointConnectionImpl ifcStructuralPointConnection = new IfcStructuralPointConnectionImpl();
		return ifcStructuralPointConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralPointReaction createIfcStructuralPointReaction() {
		IfcStructuralPointReactionImpl ifcStructuralPointReaction = new IfcStructuralPointReactionImpl();
		return ifcStructuralPointReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralReaction createIfcStructuralReaction() {
		IfcStructuralReactionImpl ifcStructuralReaction = new IfcStructuralReactionImpl();
		return ifcStructuralReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralResultGroup createIfcStructuralResultGroup() {
		IfcStructuralResultGroupImpl ifcStructuralResultGroup = new IfcStructuralResultGroupImpl();
		return ifcStructuralResultGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralSurfaceAction createIfcStructuralSurfaceAction() {
		IfcStructuralSurfaceActionImpl ifcStructuralSurfaceAction = new IfcStructuralSurfaceActionImpl();
		return ifcStructuralSurfaceAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralSurfaceConnection createIfcStructuralSurfaceConnection() {
		IfcStructuralSurfaceConnectionImpl ifcStructuralSurfaceConnection = new IfcStructuralSurfaceConnectionImpl();
		return ifcStructuralSurfaceConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralSurfaceMember createIfcStructuralSurfaceMember() {
		IfcStructuralSurfaceMemberImpl ifcStructuralSurfaceMember = new IfcStructuralSurfaceMemberImpl();
		return ifcStructuralSurfaceMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralSurfaceMemberVarying createIfcStructuralSurfaceMemberVarying() {
		IfcStructuralSurfaceMemberVaryingImpl ifcStructuralSurfaceMemberVarying = new IfcStructuralSurfaceMemberVaryingImpl();
		return ifcStructuralSurfaceMemberVarying;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStructuralSurfaceReaction createIfcStructuralSurfaceReaction() {
		IfcStructuralSurfaceReactionImpl ifcStructuralSurfaceReaction = new IfcStructuralSurfaceReactionImpl();
		return ifcStructuralSurfaceReaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStyleModel createIfcStyleModel() {
		IfcStyleModelImpl ifcStyleModel = new IfcStyleModelImpl();
		return ifcStyleModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStyledItem createIfcStyledItem() {
		IfcStyledItemImpl ifcStyledItem = new IfcStyledItemImpl();
		return ifcStyledItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStyledRepresentation createIfcStyledRepresentation() {
		IfcStyledRepresentationImpl ifcStyledRepresentation = new IfcStyledRepresentationImpl();
		return ifcStyledRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSubContractResource createIfcSubContractResource() {
		IfcSubContractResourceImpl ifcSubContractResource = new IfcSubContractResourceImpl();
		return ifcSubContractResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSubContractResourceType createIfcSubContractResourceType() {
		IfcSubContractResourceTypeImpl ifcSubContractResourceType = new IfcSubContractResourceTypeImpl();
		return ifcSubContractResourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSubedge createIfcSubedge() {
		IfcSubedgeImpl ifcSubedge = new IfcSubedgeImpl();
		return ifcSubedge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurface createIfcSurface() {
		IfcSurfaceImpl ifcSurface = new IfcSurfaceImpl();
		return ifcSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceCurve createIfcSurfaceCurve() {
		IfcSurfaceCurveImpl ifcSurfaceCurve = new IfcSurfaceCurveImpl();
		return ifcSurfaceCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceCurveSweptAreaSolid createIfcSurfaceCurveSweptAreaSolid() {
		IfcSurfaceCurveSweptAreaSolidImpl ifcSurfaceCurveSweptAreaSolid = new IfcSurfaceCurveSweptAreaSolidImpl();
		return ifcSurfaceCurveSweptAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceFeature createIfcSurfaceFeature() {
		IfcSurfaceFeatureImpl ifcSurfaceFeature = new IfcSurfaceFeatureImpl();
		return ifcSurfaceFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceOfLinearExtrusion createIfcSurfaceOfLinearExtrusion() {
		IfcSurfaceOfLinearExtrusionImpl ifcSurfaceOfLinearExtrusion = new IfcSurfaceOfLinearExtrusionImpl();
		return ifcSurfaceOfLinearExtrusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceOfRevolution createIfcSurfaceOfRevolution() {
		IfcSurfaceOfRevolutionImpl ifcSurfaceOfRevolution = new IfcSurfaceOfRevolutionImpl();
		return ifcSurfaceOfRevolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceReinforcementArea createIfcSurfaceReinforcementArea() {
		IfcSurfaceReinforcementAreaImpl ifcSurfaceReinforcementArea = new IfcSurfaceReinforcementAreaImpl();
		return ifcSurfaceReinforcementArea;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceStyle createIfcSurfaceStyle() {
		IfcSurfaceStyleImpl ifcSurfaceStyle = new IfcSurfaceStyleImpl();
		return ifcSurfaceStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceStyleLighting createIfcSurfaceStyleLighting() {
		IfcSurfaceStyleLightingImpl ifcSurfaceStyleLighting = new IfcSurfaceStyleLightingImpl();
		return ifcSurfaceStyleLighting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceStyleRefraction createIfcSurfaceStyleRefraction() {
		IfcSurfaceStyleRefractionImpl ifcSurfaceStyleRefraction = new IfcSurfaceStyleRefractionImpl();
		return ifcSurfaceStyleRefraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceStyleRendering createIfcSurfaceStyleRendering() {
		IfcSurfaceStyleRenderingImpl ifcSurfaceStyleRendering = new IfcSurfaceStyleRenderingImpl();
		return ifcSurfaceStyleRendering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceStyleShading createIfcSurfaceStyleShading() {
		IfcSurfaceStyleShadingImpl ifcSurfaceStyleShading = new IfcSurfaceStyleShadingImpl();
		return ifcSurfaceStyleShading;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceStyleWithTextures createIfcSurfaceStyleWithTextures() {
		IfcSurfaceStyleWithTexturesImpl ifcSurfaceStyleWithTextures = new IfcSurfaceStyleWithTexturesImpl();
		return ifcSurfaceStyleWithTextures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSurfaceTexture createIfcSurfaceTexture() {
		IfcSurfaceTextureImpl ifcSurfaceTexture = new IfcSurfaceTextureImpl();
		return ifcSurfaceTexture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSweptAreaSolid createIfcSweptAreaSolid() {
		IfcSweptAreaSolidImpl ifcSweptAreaSolid = new IfcSweptAreaSolidImpl();
		return ifcSweptAreaSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSweptDiskSolid createIfcSweptDiskSolid() {
		IfcSweptDiskSolidImpl ifcSweptDiskSolid = new IfcSweptDiskSolidImpl();
		return ifcSweptDiskSolid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSweptDiskSolidPolygonal createIfcSweptDiskSolidPolygonal() {
		IfcSweptDiskSolidPolygonalImpl ifcSweptDiskSolidPolygonal = new IfcSweptDiskSolidPolygonalImpl();
		return ifcSweptDiskSolidPolygonal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSweptSurface createIfcSweptSurface() {
		IfcSweptSurfaceImpl ifcSweptSurface = new IfcSweptSurfaceImpl();
		return ifcSweptSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSwitchingDevice createIfcSwitchingDevice() {
		IfcSwitchingDeviceImpl ifcSwitchingDevice = new IfcSwitchingDeviceImpl();
		return ifcSwitchingDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSwitchingDeviceType createIfcSwitchingDeviceType() {
		IfcSwitchingDeviceTypeImpl ifcSwitchingDeviceType = new IfcSwitchingDeviceTypeImpl();
		return ifcSwitchingDeviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSystem createIfcSystem() {
		IfcSystemImpl ifcSystem = new IfcSystemImpl();
		return ifcSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSystemFurnitureElement createIfcSystemFurnitureElement() {
		IfcSystemFurnitureElementImpl ifcSystemFurnitureElement = new IfcSystemFurnitureElementImpl();
		return ifcSystemFurnitureElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSystemFurnitureElementType createIfcSystemFurnitureElementType() {
		IfcSystemFurnitureElementTypeImpl ifcSystemFurnitureElementType = new IfcSystemFurnitureElementTypeImpl();
		return ifcSystemFurnitureElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTShapeProfileDef createIfcTShapeProfileDef() {
		IfcTShapeProfileDefImpl ifcTShapeProfileDef = new IfcTShapeProfileDefImpl();
		return ifcTShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTable createIfcTable() {
		IfcTableImpl ifcTable = new IfcTableImpl();
		return ifcTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTableColumn createIfcTableColumn() {
		IfcTableColumnImpl ifcTableColumn = new IfcTableColumnImpl();
		return ifcTableColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTableRow createIfcTableRow() {
		IfcTableRowImpl ifcTableRow = new IfcTableRowImpl();
		return ifcTableRow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTank createIfcTank() {
		IfcTankImpl ifcTank = new IfcTankImpl();
		return ifcTank;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTankType createIfcTankType() {
		IfcTankTypeImpl ifcTankType = new IfcTankTypeImpl();
		return ifcTankType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTask createIfcTask() {
		IfcTaskImpl ifcTask = new IfcTaskImpl();
		return ifcTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskTime createIfcTaskTime() {
		IfcTaskTimeImpl ifcTaskTime = new IfcTaskTimeImpl();
		return ifcTaskTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskTimeRecurring createIfcTaskTimeRecurring() {
		IfcTaskTimeRecurringImpl ifcTaskTimeRecurring = new IfcTaskTimeRecurringImpl();
		return ifcTaskTimeRecurring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTaskType createIfcTaskType() {
		IfcTaskTypeImpl ifcTaskType = new IfcTaskTypeImpl();
		return ifcTaskType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTelecomAddress createIfcTelecomAddress() {
		IfcTelecomAddressImpl ifcTelecomAddress = new IfcTelecomAddressImpl();
		return ifcTelecomAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTendon createIfcTendon() {
		IfcTendonImpl ifcTendon = new IfcTendonImpl();
		return ifcTendon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTendonAnchor createIfcTendonAnchor() {
		IfcTendonAnchorImpl ifcTendonAnchor = new IfcTendonAnchorImpl();
		return ifcTendonAnchor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTendonAnchorType createIfcTendonAnchorType() {
		IfcTendonAnchorTypeImpl ifcTendonAnchorType = new IfcTendonAnchorTypeImpl();
		return ifcTendonAnchorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTendonType createIfcTendonType() {
		IfcTendonTypeImpl ifcTendonType = new IfcTendonTypeImpl();
		return ifcTendonType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTessellatedFaceSet createIfcTessellatedFaceSet() {
		IfcTessellatedFaceSetImpl ifcTessellatedFaceSet = new IfcTessellatedFaceSetImpl();
		return ifcTessellatedFaceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTessellatedItem createIfcTessellatedItem() {
		IfcTessellatedItemImpl ifcTessellatedItem = new IfcTessellatedItemImpl();
		return ifcTessellatedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextLiteral createIfcTextLiteral() {
		IfcTextLiteralImpl ifcTextLiteral = new IfcTextLiteralImpl();
		return ifcTextLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextLiteralWithExtent createIfcTextLiteralWithExtent() {
		IfcTextLiteralWithExtentImpl ifcTextLiteralWithExtent = new IfcTextLiteralWithExtentImpl();
		return ifcTextLiteralWithExtent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextStyle createIfcTextStyle() {
		IfcTextStyleImpl ifcTextStyle = new IfcTextStyleImpl();
		return ifcTextStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextStyleFontModel createIfcTextStyleFontModel() {
		IfcTextStyleFontModelImpl ifcTextStyleFontModel = new IfcTextStyleFontModelImpl();
		return ifcTextStyleFontModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextStyleForDefinedFont createIfcTextStyleForDefinedFont() {
		IfcTextStyleForDefinedFontImpl ifcTextStyleForDefinedFont = new IfcTextStyleForDefinedFontImpl();
		return ifcTextStyleForDefinedFont;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextStyleTextModel createIfcTextStyleTextModel() {
		IfcTextStyleTextModelImpl ifcTextStyleTextModel = new IfcTextStyleTextModelImpl();
		return ifcTextStyleTextModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextureCoordinate createIfcTextureCoordinate() {
		IfcTextureCoordinateImpl ifcTextureCoordinate = new IfcTextureCoordinateImpl();
		return ifcTextureCoordinate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextureCoordinateGenerator createIfcTextureCoordinateGenerator() {
		IfcTextureCoordinateGeneratorImpl ifcTextureCoordinateGenerator = new IfcTextureCoordinateGeneratorImpl();
		return ifcTextureCoordinateGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextureMap createIfcTextureMap() {
		IfcTextureMapImpl ifcTextureMap = new IfcTextureMapImpl();
		return ifcTextureMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextureVertex createIfcTextureVertex() {
		IfcTextureVertexImpl ifcTextureVertex = new IfcTextureVertexImpl();
		return ifcTextureVertex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextureVertexList createIfcTextureVertexList() {
		IfcTextureVertexListImpl ifcTextureVertexList = new IfcTextureVertexListImpl();
		return ifcTextureVertexList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTimePeriod createIfcTimePeriod() {
		IfcTimePeriodImpl ifcTimePeriod = new IfcTimePeriodImpl();
		return ifcTimePeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTimeSeries createIfcTimeSeries() {
		IfcTimeSeriesImpl ifcTimeSeries = new IfcTimeSeriesImpl();
		return ifcTimeSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTimeSeriesValue createIfcTimeSeriesValue() {
		IfcTimeSeriesValueImpl ifcTimeSeriesValue = new IfcTimeSeriesValueImpl();
		return ifcTimeSeriesValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTopologicalRepresentationItem createIfcTopologicalRepresentationItem() {
		IfcTopologicalRepresentationItemImpl ifcTopologicalRepresentationItem = new IfcTopologicalRepresentationItemImpl();
		return ifcTopologicalRepresentationItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTopologyRepresentation createIfcTopologyRepresentation() {
		IfcTopologyRepresentationImpl ifcTopologyRepresentation = new IfcTopologyRepresentationImpl();
		return ifcTopologyRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcToroidalSurface createIfcToroidalSurface() {
		IfcToroidalSurfaceImpl ifcToroidalSurface = new IfcToroidalSurfaceImpl();
		return ifcToroidalSurface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTransformer createIfcTransformer() {
		IfcTransformerImpl ifcTransformer = new IfcTransformerImpl();
		return ifcTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTransformerType createIfcTransformerType() {
		IfcTransformerTypeImpl ifcTransformerType = new IfcTransformerTypeImpl();
		return ifcTransformerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTransportElement createIfcTransportElement() {
		IfcTransportElementImpl ifcTransportElement = new IfcTransportElementImpl();
		return ifcTransportElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTransportElementType createIfcTransportElementType() {
		IfcTransportElementTypeImpl ifcTransportElementType = new IfcTransportElementTypeImpl();
		return ifcTransportElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTrapeziumProfileDef createIfcTrapeziumProfileDef() {
		IfcTrapeziumProfileDefImpl ifcTrapeziumProfileDef = new IfcTrapeziumProfileDefImpl();
		return ifcTrapeziumProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTriangulatedFaceSet createIfcTriangulatedFaceSet() {
		IfcTriangulatedFaceSetImpl ifcTriangulatedFaceSet = new IfcTriangulatedFaceSetImpl();
		return ifcTriangulatedFaceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTrimmedCurve createIfcTrimmedCurve() {
		IfcTrimmedCurveImpl ifcTrimmedCurve = new IfcTrimmedCurveImpl();
		return ifcTrimmedCurve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTubeBundle createIfcTubeBundle() {
		IfcTubeBundleImpl ifcTubeBundle = new IfcTubeBundleImpl();
		return ifcTubeBundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTubeBundleType createIfcTubeBundleType() {
		IfcTubeBundleTypeImpl ifcTubeBundleType = new IfcTubeBundleTypeImpl();
		return ifcTubeBundleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTypeObject createIfcTypeObject() {
		IfcTypeObjectImpl ifcTypeObject = new IfcTypeObjectImpl();
		return ifcTypeObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTypeProcess createIfcTypeProcess() {
		IfcTypeProcessImpl ifcTypeProcess = new IfcTypeProcessImpl();
		return ifcTypeProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTypeProduct createIfcTypeProduct() {
		IfcTypeProductImpl ifcTypeProduct = new IfcTypeProductImpl();
		return ifcTypeProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTypeResource createIfcTypeResource() {
		IfcTypeResourceImpl ifcTypeResource = new IfcTypeResourceImpl();
		return ifcTypeResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUShapeProfileDef createIfcUShapeProfileDef() {
		IfcUShapeProfileDefImpl ifcUShapeProfileDef = new IfcUShapeProfileDefImpl();
		return ifcUShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnitAssignment createIfcUnitAssignment() {
		IfcUnitAssignmentImpl ifcUnitAssignment = new IfcUnitAssignmentImpl();
		return ifcUnitAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnitaryControlElement createIfcUnitaryControlElement() {
		IfcUnitaryControlElementImpl ifcUnitaryControlElement = new IfcUnitaryControlElementImpl();
		return ifcUnitaryControlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnitaryControlElementType createIfcUnitaryControlElementType() {
		IfcUnitaryControlElementTypeImpl ifcUnitaryControlElementType = new IfcUnitaryControlElementTypeImpl();
		return ifcUnitaryControlElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnitaryEquipment createIfcUnitaryEquipment() {
		IfcUnitaryEquipmentImpl ifcUnitaryEquipment = new IfcUnitaryEquipmentImpl();
		return ifcUnitaryEquipment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcUnitaryEquipmentType createIfcUnitaryEquipmentType() {
		IfcUnitaryEquipmentTypeImpl ifcUnitaryEquipmentType = new IfcUnitaryEquipmentTypeImpl();
		return ifcUnitaryEquipmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcValve createIfcValve() {
		IfcValveImpl ifcValve = new IfcValveImpl();
		return ifcValve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcValveType createIfcValveType() {
		IfcValveTypeImpl ifcValveType = new IfcValveTypeImpl();
		return ifcValveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVector createIfcVector() {
		IfcVectorImpl ifcVector = new IfcVectorImpl();
		return ifcVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVertex createIfcVertex() {
		IfcVertexImpl ifcVertex = new IfcVertexImpl();
		return ifcVertex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVertexLoop createIfcVertexLoop() {
		IfcVertexLoopImpl ifcVertexLoop = new IfcVertexLoopImpl();
		return ifcVertexLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVertexPoint createIfcVertexPoint() {
		IfcVertexPointImpl ifcVertexPoint = new IfcVertexPointImpl();
		return ifcVertexPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVibrationIsolator createIfcVibrationIsolator() {
		IfcVibrationIsolatorImpl ifcVibrationIsolator = new IfcVibrationIsolatorImpl();
		return ifcVibrationIsolator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVibrationIsolatorType createIfcVibrationIsolatorType() {
		IfcVibrationIsolatorTypeImpl ifcVibrationIsolatorType = new IfcVibrationIsolatorTypeImpl();
		return ifcVibrationIsolatorType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVirtualElement createIfcVirtualElement() {
		IfcVirtualElementImpl ifcVirtualElement = new IfcVirtualElementImpl();
		return ifcVirtualElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVirtualGridIntersection createIfcVirtualGridIntersection() {
		IfcVirtualGridIntersectionImpl ifcVirtualGridIntersection = new IfcVirtualGridIntersectionImpl();
		return ifcVirtualGridIntersection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVoidingFeature createIfcVoidingFeature() {
		IfcVoidingFeatureImpl ifcVoidingFeature = new IfcVoidingFeatureImpl();
		return ifcVoidingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWall createIfcWall() {
		IfcWallImpl ifcWall = new IfcWallImpl();
		return ifcWall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWallElementedCase createIfcWallElementedCase() {
		IfcWallElementedCaseImpl ifcWallElementedCase = new IfcWallElementedCaseImpl();
		return ifcWallElementedCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWallStandardCase createIfcWallStandardCase() {
		IfcWallStandardCaseImpl ifcWallStandardCase = new IfcWallStandardCaseImpl();
		return ifcWallStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWallType createIfcWallType() {
		IfcWallTypeImpl ifcWallType = new IfcWallTypeImpl();
		return ifcWallType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWasteTerminal createIfcWasteTerminal() {
		IfcWasteTerminalImpl ifcWasteTerminal = new IfcWasteTerminalImpl();
		return ifcWasteTerminal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWasteTerminalType createIfcWasteTerminalType() {
		IfcWasteTerminalTypeImpl ifcWasteTerminalType = new IfcWasteTerminalTypeImpl();
		return ifcWasteTerminalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindow createIfcWindow() {
		IfcWindowImpl ifcWindow = new IfcWindowImpl();
		return ifcWindow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowLiningProperties createIfcWindowLiningProperties() {
		IfcWindowLiningPropertiesImpl ifcWindowLiningProperties = new IfcWindowLiningPropertiesImpl();
		return ifcWindowLiningProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowPanelProperties createIfcWindowPanelProperties() {
		IfcWindowPanelPropertiesImpl ifcWindowPanelProperties = new IfcWindowPanelPropertiesImpl();
		return ifcWindowPanelProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowStandardCase createIfcWindowStandardCase() {
		IfcWindowStandardCaseImpl ifcWindowStandardCase = new IfcWindowStandardCaseImpl();
		return ifcWindowStandardCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowStyle createIfcWindowStyle() {
		IfcWindowStyleImpl ifcWindowStyle = new IfcWindowStyleImpl();
		return ifcWindowStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWindowType createIfcWindowType() {
		IfcWindowTypeImpl ifcWindowType = new IfcWindowTypeImpl();
		return ifcWindowType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWorkCalendar createIfcWorkCalendar() {
		IfcWorkCalendarImpl ifcWorkCalendar = new IfcWorkCalendarImpl();
		return ifcWorkCalendar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWorkControl createIfcWorkControl() {
		IfcWorkControlImpl ifcWorkControl = new IfcWorkControlImpl();
		return ifcWorkControl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWorkPlan createIfcWorkPlan() {
		IfcWorkPlanImpl ifcWorkPlan = new IfcWorkPlanImpl();
		return ifcWorkPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWorkSchedule createIfcWorkSchedule() {
		IfcWorkScheduleImpl ifcWorkSchedule = new IfcWorkScheduleImpl();
		return ifcWorkSchedule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWorkTime createIfcWorkTime() {
		IfcWorkTimeImpl ifcWorkTime = new IfcWorkTimeImpl();
		return ifcWorkTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcZShapeProfileDef createIfcZShapeProfileDef() {
		IfcZShapeProfileDefImpl ifcZShapeProfileDef = new IfcZShapeProfileDefImpl();
		return ifcZShapeProfileDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcZone createIfcZone() {
		IfcZoneImpl ifcZone = new IfcZoneImpl();
		return ifcZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcStrippedOptional createIfcStrippedOptional() {
		IfcStrippedOptionalImpl ifcStrippedOptional = new IfcStrippedOptionalImpl();
		return ifcStrippedOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAbsorbedDoseMeasure createIfcAbsorbedDoseMeasure() {
		IfcAbsorbedDoseMeasureImpl ifcAbsorbedDoseMeasure = new IfcAbsorbedDoseMeasureImpl();
		return ifcAbsorbedDoseMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAccelerationMeasure createIfcAccelerationMeasure() {
		IfcAccelerationMeasureImpl ifcAccelerationMeasure = new IfcAccelerationMeasureImpl();
		return ifcAccelerationMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAmountOfSubstanceMeasure createIfcAmountOfSubstanceMeasure() {
		IfcAmountOfSubstanceMeasureImpl ifcAmountOfSubstanceMeasure = new IfcAmountOfSubstanceMeasureImpl();
		return ifcAmountOfSubstanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAngularVelocityMeasure createIfcAngularVelocityMeasure() {
		IfcAngularVelocityMeasureImpl ifcAngularVelocityMeasure = new IfcAngularVelocityMeasureImpl();
		return ifcAngularVelocityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAreaDensityMeasure createIfcAreaDensityMeasure() {
		IfcAreaDensityMeasureImpl ifcAreaDensityMeasure = new IfcAreaDensityMeasureImpl();
		return ifcAreaDensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAreaMeasure createIfcAreaMeasure() {
		IfcAreaMeasureImpl ifcAreaMeasure = new IfcAreaMeasureImpl();
		return ifcAreaMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBinary createIfcBinary() {
		IfcBinaryImpl ifcBinary = new IfcBinaryImpl();
		return ifcBinary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoolean createIfcBoolean() {
		IfcBooleanImpl ifcBoolean = new IfcBooleanImpl();
		return ifcBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCardinalPointReference createIfcCardinalPointReference() {
		IfcCardinalPointReferenceImpl ifcCardinalPointReference = new IfcCardinalPointReferenceImpl();
		return ifcCardinalPointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcContextDependentMeasure createIfcContextDependentMeasure() {
		IfcContextDependentMeasureImpl ifcContextDependentMeasure = new IfcContextDependentMeasureImpl();
		return ifcContextDependentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCountMeasure createIfcCountMeasure() {
		IfcCountMeasureImpl ifcCountMeasure = new IfcCountMeasureImpl();
		return ifcCountMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurvatureMeasure createIfcCurvatureMeasure() {
		IfcCurvatureMeasureImpl ifcCurvatureMeasure = new IfcCurvatureMeasureImpl();
		return ifcCurvatureMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDate createIfcDate() {
		IfcDateImpl ifcDate = new IfcDateImpl();
		return ifcDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDateTime createIfcDateTime() {
		IfcDateTimeImpl ifcDateTime = new IfcDateTimeImpl();
		return ifcDateTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDayInMonthNumber createIfcDayInMonthNumber() {
		IfcDayInMonthNumberImpl ifcDayInMonthNumber = new IfcDayInMonthNumberImpl();
		return ifcDayInMonthNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDayInWeekNumber createIfcDayInWeekNumber() {
		IfcDayInWeekNumberImpl ifcDayInWeekNumber = new IfcDayInWeekNumberImpl();
		return ifcDayInWeekNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDescriptiveMeasure createIfcDescriptiveMeasure() {
		IfcDescriptiveMeasureImpl ifcDescriptiveMeasure = new IfcDescriptiveMeasureImpl();
		return ifcDescriptiveMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDimensionCount createIfcDimensionCount() {
		IfcDimensionCountImpl ifcDimensionCount = new IfcDimensionCountImpl();
		return ifcDimensionCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDoseEquivalentMeasure createIfcDoseEquivalentMeasure() {
		IfcDoseEquivalentMeasureImpl ifcDoseEquivalentMeasure = new IfcDoseEquivalentMeasureImpl();
		return ifcDoseEquivalentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDuration createIfcDuration() {
		IfcDurationImpl ifcDuration = new IfcDurationImpl();
		return ifcDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcDynamicViscosityMeasure createIfcDynamicViscosityMeasure() {
		IfcDynamicViscosityMeasureImpl ifcDynamicViscosityMeasure = new IfcDynamicViscosityMeasureImpl();
		return ifcDynamicViscosityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricCapacitanceMeasure createIfcElectricCapacitanceMeasure() {
		IfcElectricCapacitanceMeasureImpl ifcElectricCapacitanceMeasure = new IfcElectricCapacitanceMeasureImpl();
		return ifcElectricCapacitanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricChargeMeasure createIfcElectricChargeMeasure() {
		IfcElectricChargeMeasureImpl ifcElectricChargeMeasure = new IfcElectricChargeMeasureImpl();
		return ifcElectricChargeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricConductanceMeasure createIfcElectricConductanceMeasure() {
		IfcElectricConductanceMeasureImpl ifcElectricConductanceMeasure = new IfcElectricConductanceMeasureImpl();
		return ifcElectricConductanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricCurrentMeasure createIfcElectricCurrentMeasure() {
		IfcElectricCurrentMeasureImpl ifcElectricCurrentMeasure = new IfcElectricCurrentMeasureImpl();
		return ifcElectricCurrentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricResistanceMeasure createIfcElectricResistanceMeasure() {
		IfcElectricResistanceMeasureImpl ifcElectricResistanceMeasure = new IfcElectricResistanceMeasureImpl();
		return ifcElectricResistanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcElectricVoltageMeasure createIfcElectricVoltageMeasure() {
		IfcElectricVoltageMeasureImpl ifcElectricVoltageMeasure = new IfcElectricVoltageMeasureImpl();
		return ifcElectricVoltageMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcEnergyMeasure createIfcEnergyMeasure() {
		IfcEnergyMeasureImpl ifcEnergyMeasure = new IfcEnergyMeasureImpl();
		return ifcEnergyMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFontStyle createIfcFontStyle() {
		IfcFontStyleImpl ifcFontStyle = new IfcFontStyleImpl();
		return ifcFontStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFontVariant createIfcFontVariant() {
		IfcFontVariantImpl ifcFontVariant = new IfcFontVariantImpl();
		return ifcFontVariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFontWeight createIfcFontWeight() {
		IfcFontWeightImpl ifcFontWeight = new IfcFontWeightImpl();
		return ifcFontWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcForceMeasure createIfcForceMeasure() {
		IfcForceMeasureImpl ifcForceMeasure = new IfcForceMeasureImpl();
		return ifcForceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcFrequencyMeasure createIfcFrequencyMeasure() {
		IfcFrequencyMeasureImpl ifcFrequencyMeasure = new IfcFrequencyMeasureImpl();
		return ifcFrequencyMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcGloballyUniqueId createIfcGloballyUniqueId() {
		IfcGloballyUniqueIdImpl ifcGloballyUniqueId = new IfcGloballyUniqueIdImpl();
		return ifcGloballyUniqueId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHeatFluxDensityMeasure createIfcHeatFluxDensityMeasure() {
		IfcHeatFluxDensityMeasureImpl ifcHeatFluxDensityMeasure = new IfcHeatFluxDensityMeasureImpl();
		return ifcHeatFluxDensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcHeatingValueMeasure createIfcHeatingValueMeasure() {
		IfcHeatingValueMeasureImpl ifcHeatingValueMeasure = new IfcHeatingValueMeasureImpl();
		return ifcHeatingValueMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIdentifier createIfcIdentifier() {
		IfcIdentifierImpl ifcIdentifier = new IfcIdentifierImpl();
		return ifcIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIlluminanceMeasure createIfcIlluminanceMeasure() {
		IfcIlluminanceMeasureImpl ifcIlluminanceMeasure = new IfcIlluminanceMeasureImpl();
		return ifcIlluminanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInductanceMeasure createIfcInductanceMeasure() {
		IfcInductanceMeasureImpl ifcInductanceMeasure = new IfcInductanceMeasureImpl();
		return ifcInductanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcInteger createIfcInteger() {
		IfcIntegerImpl ifcInteger = new IfcIntegerImpl();
		return ifcInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIntegerCountRateMeasure createIfcIntegerCountRateMeasure() {
		IfcIntegerCountRateMeasureImpl ifcIntegerCountRateMeasure = new IfcIntegerCountRateMeasureImpl();
		return ifcIntegerCountRateMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIonConcentrationMeasure createIfcIonConcentrationMeasure() {
		IfcIonConcentrationMeasureImpl ifcIonConcentrationMeasure = new IfcIonConcentrationMeasureImpl();
		return ifcIonConcentrationMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcIsothermalMoistureCapacityMeasure createIfcIsothermalMoistureCapacityMeasure() {
		IfcIsothermalMoistureCapacityMeasureImpl ifcIsothermalMoistureCapacityMeasure = new IfcIsothermalMoistureCapacityMeasureImpl();
		return ifcIsothermalMoistureCapacityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcKinematicViscosityMeasure createIfcKinematicViscosityMeasure() {
		IfcKinematicViscosityMeasureImpl ifcKinematicViscosityMeasure = new IfcKinematicViscosityMeasureImpl();
		return ifcKinematicViscosityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLabel createIfcLabel() {
		IfcLabelImpl ifcLabel = new IfcLabelImpl();
		return ifcLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLengthMeasure createIfcLengthMeasure() {
		IfcLengthMeasureImpl ifcLengthMeasure = new IfcLengthMeasureImpl();
		return ifcLengthMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLinearForceMeasure createIfcLinearForceMeasure() {
		IfcLinearForceMeasureImpl ifcLinearForceMeasure = new IfcLinearForceMeasureImpl();
		return ifcLinearForceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLinearMomentMeasure createIfcLinearMomentMeasure() {
		IfcLinearMomentMeasureImpl ifcLinearMomentMeasure = new IfcLinearMomentMeasureImpl();
		return ifcLinearMomentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLinearStiffnessMeasure createIfcLinearStiffnessMeasure() {
		IfcLinearStiffnessMeasureImpl ifcLinearStiffnessMeasure = new IfcLinearStiffnessMeasureImpl();
		return ifcLinearStiffnessMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLinearVelocityMeasure createIfcLinearVelocityMeasure() {
		IfcLinearVelocityMeasureImpl ifcLinearVelocityMeasure = new IfcLinearVelocityMeasureImpl();
		return ifcLinearVelocityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLogical createIfcLogical() {
		IfcLogicalImpl ifcLogical = new IfcLogicalImpl();
		return ifcLogical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLuminousFluxMeasure createIfcLuminousFluxMeasure() {
		IfcLuminousFluxMeasureImpl ifcLuminousFluxMeasure = new IfcLuminousFluxMeasureImpl();
		return ifcLuminousFluxMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLuminousIntensityDistributionMeasure createIfcLuminousIntensityDistributionMeasure() {
		IfcLuminousIntensityDistributionMeasureImpl ifcLuminousIntensityDistributionMeasure = new IfcLuminousIntensityDistributionMeasureImpl();
		return ifcLuminousIntensityDistributionMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLuminousIntensityMeasure createIfcLuminousIntensityMeasure() {
		IfcLuminousIntensityMeasureImpl ifcLuminousIntensityMeasure = new IfcLuminousIntensityMeasureImpl();
		return ifcLuminousIntensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMagneticFluxDensityMeasure createIfcMagneticFluxDensityMeasure() {
		IfcMagneticFluxDensityMeasureImpl ifcMagneticFluxDensityMeasure = new IfcMagneticFluxDensityMeasureImpl();
		return ifcMagneticFluxDensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMagneticFluxMeasure createIfcMagneticFluxMeasure() {
		IfcMagneticFluxMeasureImpl ifcMagneticFluxMeasure = new IfcMagneticFluxMeasureImpl();
		return ifcMagneticFluxMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMassDensityMeasure createIfcMassDensityMeasure() {
		IfcMassDensityMeasureImpl ifcMassDensityMeasure = new IfcMassDensityMeasureImpl();
		return ifcMassDensityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMassFlowRateMeasure createIfcMassFlowRateMeasure() {
		IfcMassFlowRateMeasureImpl ifcMassFlowRateMeasure = new IfcMassFlowRateMeasureImpl();
		return ifcMassFlowRateMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMassMeasure createIfcMassMeasure() {
		IfcMassMeasureImpl ifcMassMeasure = new IfcMassMeasureImpl();
		return ifcMassMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMassPerLengthMeasure createIfcMassPerLengthMeasure() {
		IfcMassPerLengthMeasureImpl ifcMassPerLengthMeasure = new IfcMassPerLengthMeasureImpl();
		return ifcMassPerLengthMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfElasticityMeasure createIfcModulusOfElasticityMeasure() {
		IfcModulusOfElasticityMeasureImpl ifcModulusOfElasticityMeasure = new IfcModulusOfElasticityMeasureImpl();
		return ifcModulusOfElasticityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfLinearSubgradeReactionMeasure createIfcModulusOfLinearSubgradeReactionMeasure() {
		IfcModulusOfLinearSubgradeReactionMeasureImpl ifcModulusOfLinearSubgradeReactionMeasure = new IfcModulusOfLinearSubgradeReactionMeasureImpl();
		return ifcModulusOfLinearSubgradeReactionMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfRotationalSubgradeReactionMeasure createIfcModulusOfRotationalSubgradeReactionMeasure() {
		IfcModulusOfRotationalSubgradeReactionMeasureImpl ifcModulusOfRotationalSubgradeReactionMeasure = new IfcModulusOfRotationalSubgradeReactionMeasureImpl();
		return ifcModulusOfRotationalSubgradeReactionMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcModulusOfSubgradeReactionMeasure createIfcModulusOfSubgradeReactionMeasure() {
		IfcModulusOfSubgradeReactionMeasureImpl ifcModulusOfSubgradeReactionMeasure = new IfcModulusOfSubgradeReactionMeasureImpl();
		return ifcModulusOfSubgradeReactionMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMoistureDiffusivityMeasure createIfcMoistureDiffusivityMeasure() {
		IfcMoistureDiffusivityMeasureImpl ifcMoistureDiffusivityMeasure = new IfcMoistureDiffusivityMeasureImpl();
		return ifcMoistureDiffusivityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMolecularWeightMeasure createIfcMolecularWeightMeasure() {
		IfcMolecularWeightMeasureImpl ifcMolecularWeightMeasure = new IfcMolecularWeightMeasureImpl();
		return ifcMolecularWeightMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMomentOfInertiaMeasure createIfcMomentOfInertiaMeasure() {
		IfcMomentOfInertiaMeasureImpl ifcMomentOfInertiaMeasure = new IfcMomentOfInertiaMeasureImpl();
		return ifcMomentOfInertiaMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMonetaryMeasure createIfcMonetaryMeasure() {
		IfcMonetaryMeasureImpl ifcMonetaryMeasure = new IfcMonetaryMeasureImpl();
		return ifcMonetaryMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcMonthInYearNumber createIfcMonthInYearNumber() {
		IfcMonthInYearNumberImpl ifcMonthInYearNumber = new IfcMonthInYearNumberImpl();
		return ifcMonthInYearNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcNumericMeasure createIfcNumericMeasure() {
		IfcNumericMeasureImpl ifcNumericMeasure = new IfcNumericMeasureImpl();
		return ifcNumericMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPHMeasure createIfcPHMeasure() {
		IfcPHMeasureImpl ifcPHMeasure = new IfcPHMeasureImpl();
		return ifcPHMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcParameterValue createIfcParameterValue() {
		IfcParameterValueImpl ifcParameterValue = new IfcParameterValueImpl();
		return ifcParameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlanarForceMeasure createIfcPlanarForceMeasure() {
		IfcPlanarForceMeasureImpl ifcPlanarForceMeasure = new IfcPlanarForceMeasureImpl();
		return ifcPlanarForceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPlaneAngleMeasure createIfcPlaneAngleMeasure() {
		IfcPlaneAngleMeasureImpl ifcPlaneAngleMeasure = new IfcPlaneAngleMeasureImpl();
		return ifcPlaneAngleMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPowerMeasure createIfcPowerMeasure() {
		IfcPowerMeasureImpl ifcPowerMeasure = new IfcPowerMeasureImpl();
		return ifcPowerMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPresentableText createIfcPresentableText() {
		IfcPresentableTextImpl ifcPresentableText = new IfcPresentableTextImpl();
		return ifcPresentableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPressureMeasure createIfcPressureMeasure() {
		IfcPressureMeasureImpl ifcPressureMeasure = new IfcPressureMeasureImpl();
		return ifcPressureMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRadioActivityMeasure createIfcRadioActivityMeasure() {
		IfcRadioActivityMeasureImpl ifcRadioActivityMeasure = new IfcRadioActivityMeasureImpl();
		return ifcRadioActivityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRatioMeasure createIfcRatioMeasure() {
		IfcRatioMeasureImpl ifcRatioMeasure = new IfcRatioMeasureImpl();
		return ifcRatioMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReal createIfcReal() {
		IfcRealImpl ifcReal = new IfcRealImpl();
		return ifcReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalFrequencyMeasure createIfcRotationalFrequencyMeasure() {
		IfcRotationalFrequencyMeasureImpl ifcRotationalFrequencyMeasure = new IfcRotationalFrequencyMeasureImpl();
		return ifcRotationalFrequencyMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalMassMeasure createIfcRotationalMassMeasure() {
		IfcRotationalMassMeasureImpl ifcRotationalMassMeasure = new IfcRotationalMassMeasureImpl();
		return ifcRotationalMassMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcRotationalStiffnessMeasure createIfcRotationalStiffnessMeasure() {
		IfcRotationalStiffnessMeasureImpl ifcRotationalStiffnessMeasure = new IfcRotationalStiffnessMeasureImpl();
		return ifcRotationalStiffnessMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSectionModulusMeasure createIfcSectionModulusMeasure() {
		IfcSectionModulusMeasureImpl ifcSectionModulusMeasure = new IfcSectionModulusMeasureImpl();
		return ifcSectionModulusMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSectionalAreaIntegralMeasure createIfcSectionalAreaIntegralMeasure() {
		IfcSectionalAreaIntegralMeasureImpl ifcSectionalAreaIntegralMeasure = new IfcSectionalAreaIntegralMeasureImpl();
		return ifcSectionalAreaIntegralMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcShearModulusMeasure createIfcShearModulusMeasure() {
		IfcShearModulusMeasureImpl ifcShearModulusMeasure = new IfcShearModulusMeasureImpl();
		return ifcShearModulusMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSolidAngleMeasure createIfcSolidAngleMeasure() {
		IfcSolidAngleMeasureImpl ifcSolidAngleMeasure = new IfcSolidAngleMeasureImpl();
		return ifcSolidAngleMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSoundPowerLevelMeasure createIfcSoundPowerLevelMeasure() {
		IfcSoundPowerLevelMeasureImpl ifcSoundPowerLevelMeasure = new IfcSoundPowerLevelMeasureImpl();
		return ifcSoundPowerLevelMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSoundPowerMeasure createIfcSoundPowerMeasure() {
		IfcSoundPowerMeasureImpl ifcSoundPowerMeasure = new IfcSoundPowerMeasureImpl();
		return ifcSoundPowerMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSoundPressureLevelMeasure createIfcSoundPressureLevelMeasure() {
		IfcSoundPressureLevelMeasureImpl ifcSoundPressureLevelMeasure = new IfcSoundPressureLevelMeasureImpl();
		return ifcSoundPressureLevelMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSoundPressureMeasure createIfcSoundPressureMeasure() {
		IfcSoundPressureMeasureImpl ifcSoundPressureMeasure = new IfcSoundPressureMeasureImpl();
		return ifcSoundPressureMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpecificHeatCapacityMeasure createIfcSpecificHeatCapacityMeasure() {
		IfcSpecificHeatCapacityMeasureImpl ifcSpecificHeatCapacityMeasure = new IfcSpecificHeatCapacityMeasureImpl();
		return ifcSpecificHeatCapacityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpecularExponent createIfcSpecularExponent() {
		IfcSpecularExponentImpl ifcSpecularExponent = new IfcSpecularExponentImpl();
		return ifcSpecularExponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcSpecularRoughness createIfcSpecularRoughness() {
		IfcSpecularRoughnessImpl ifcSpecularRoughness = new IfcSpecularRoughnessImpl();
		return ifcSpecularRoughness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTemperatureGradientMeasure createIfcTemperatureGradientMeasure() {
		IfcTemperatureGradientMeasureImpl ifcTemperatureGradientMeasure = new IfcTemperatureGradientMeasureImpl();
		return ifcTemperatureGradientMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTemperatureRateOfChangeMeasure createIfcTemperatureRateOfChangeMeasure() {
		IfcTemperatureRateOfChangeMeasureImpl ifcTemperatureRateOfChangeMeasure = new IfcTemperatureRateOfChangeMeasureImpl();
		return ifcTemperatureRateOfChangeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcText createIfcText() {
		IfcTextImpl ifcText = new IfcTextImpl();
		return ifcText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextAlignment createIfcTextAlignment() {
		IfcTextAlignmentImpl ifcTextAlignment = new IfcTextAlignmentImpl();
		return ifcTextAlignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextDecoration createIfcTextDecoration() {
		IfcTextDecorationImpl ifcTextDecoration = new IfcTextDecorationImpl();
		return ifcTextDecoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextFontName createIfcTextFontName() {
		IfcTextFontNameImpl ifcTextFontName = new IfcTextFontNameImpl();
		return ifcTextFontName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTextTransformation createIfcTextTransformation() {
		IfcTextTransformationImpl ifcTextTransformation = new IfcTextTransformationImpl();
		return ifcTextTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcThermalAdmittanceMeasure createIfcThermalAdmittanceMeasure() {
		IfcThermalAdmittanceMeasureImpl ifcThermalAdmittanceMeasure = new IfcThermalAdmittanceMeasureImpl();
		return ifcThermalAdmittanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcThermalConductivityMeasure createIfcThermalConductivityMeasure() {
		IfcThermalConductivityMeasureImpl ifcThermalConductivityMeasure = new IfcThermalConductivityMeasureImpl();
		return ifcThermalConductivityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcThermalExpansionCoefficientMeasure createIfcThermalExpansionCoefficientMeasure() {
		IfcThermalExpansionCoefficientMeasureImpl ifcThermalExpansionCoefficientMeasure = new IfcThermalExpansionCoefficientMeasureImpl();
		return ifcThermalExpansionCoefficientMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcThermalResistanceMeasure createIfcThermalResistanceMeasure() {
		IfcThermalResistanceMeasureImpl ifcThermalResistanceMeasure = new IfcThermalResistanceMeasureImpl();
		return ifcThermalResistanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcThermalTransmittanceMeasure createIfcThermalTransmittanceMeasure() {
		IfcThermalTransmittanceMeasureImpl ifcThermalTransmittanceMeasure = new IfcThermalTransmittanceMeasureImpl();
		return ifcThermalTransmittanceMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcThermodynamicTemperatureMeasure createIfcThermodynamicTemperatureMeasure() {
		IfcThermodynamicTemperatureMeasureImpl ifcThermodynamicTemperatureMeasure = new IfcThermodynamicTemperatureMeasureImpl();
		return ifcThermodynamicTemperatureMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTime createIfcTime() {
		IfcTimeImpl ifcTime = new IfcTimeImpl();
		return ifcTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTimeMeasure createIfcTimeMeasure() {
		IfcTimeMeasureImpl ifcTimeMeasure = new IfcTimeMeasureImpl();
		return ifcTimeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTimeStamp createIfcTimeStamp() {
		IfcTimeStampImpl ifcTimeStamp = new IfcTimeStampImpl();
		return ifcTimeStamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcTorqueMeasure createIfcTorqueMeasure() {
		IfcTorqueMeasureImpl ifcTorqueMeasure = new IfcTorqueMeasureImpl();
		return ifcTorqueMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcURIReference createIfcURIReference() {
		IfcURIReferenceImpl ifcURIReference = new IfcURIReferenceImpl();
		return ifcURIReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVaporPermeabilityMeasure createIfcVaporPermeabilityMeasure() {
		IfcVaporPermeabilityMeasureImpl ifcVaporPermeabilityMeasure = new IfcVaporPermeabilityMeasureImpl();
		return ifcVaporPermeabilityMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVolumeMeasure createIfcVolumeMeasure() {
		IfcVolumeMeasureImpl ifcVolumeMeasure = new IfcVolumeMeasureImpl();
		return ifcVolumeMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcVolumetricFlowRateMeasure createIfcVolumetricFlowRateMeasure() {
		IfcVolumetricFlowRateMeasureImpl ifcVolumetricFlowRateMeasure = new IfcVolumetricFlowRateMeasureImpl();
		return ifcVolumetricFlowRateMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWarpingConstantMeasure createIfcWarpingConstantMeasure() {
		IfcWarpingConstantMeasureImpl ifcWarpingConstantMeasure = new IfcWarpingConstantMeasureImpl();
		return ifcWarpingConstantMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcWarpingMomentMeasure createIfcWarpingMomentMeasure() {
		IfcWarpingMomentMeasureImpl ifcWarpingMomentMeasure = new IfcWarpingMomentMeasureImpl();
		return ifcWarpingMomentMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBoxAlignment createIfcBoxAlignment() {
		IfcBoxAlignmentImpl ifcBoxAlignment = new IfcBoxAlignmentImpl();
		return ifcBoxAlignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCompoundPlaneAngleMeasure createIfcCompoundPlaneAngleMeasure() {
		IfcCompoundPlaneAngleMeasureImpl ifcCompoundPlaneAngleMeasure = new IfcCompoundPlaneAngleMeasureImpl();
		return ifcCompoundPlaneAngleMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLanguageId createIfcLanguageId() {
		IfcLanguageIdImpl ifcLanguageId = new IfcLanguageIdImpl();
		return ifcLanguageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcNonNegativeLengthMeasure createIfcNonNegativeLengthMeasure() {
		IfcNonNegativeLengthMeasureImpl ifcNonNegativeLengthMeasure = new IfcNonNegativeLengthMeasureImpl();
		return ifcNonNegativeLengthMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcNormalisedRatioMeasure createIfcNormalisedRatioMeasure() {
		IfcNormalisedRatioMeasureImpl ifcNormalisedRatioMeasure = new IfcNormalisedRatioMeasureImpl();
		return ifcNormalisedRatioMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPositiveInteger createIfcPositiveInteger() {
		IfcPositiveIntegerImpl ifcPositiveInteger = new IfcPositiveIntegerImpl();
		return ifcPositiveInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPositiveLengthMeasure createIfcPositiveLengthMeasure() {
		IfcPositiveLengthMeasureImpl ifcPositiveLengthMeasure = new IfcPositiveLengthMeasureImpl();
		return ifcPositiveLengthMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPositivePlaneAngleMeasure createIfcPositivePlaneAngleMeasure() {
		IfcPositivePlaneAngleMeasureImpl ifcPositivePlaneAngleMeasure = new IfcPositivePlaneAngleMeasureImpl();
		return ifcPositivePlaneAngleMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcPositiveRatioMeasure createIfcPositiveRatioMeasure() {
		IfcPositiveRatioMeasureImpl ifcPositiveRatioMeasure = new IfcPositiveRatioMeasureImpl();
		return ifcPositiveRatioMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcArcIndex createIfcArcIndex() {
		IfcArcIndexImpl ifcArcIndex = new IfcArcIndexImpl();
		return ifcArcIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcComplexNumber createIfcComplexNumber() {
		IfcComplexNumberImpl ifcComplexNumber = new IfcComplexNumberImpl();
		return ifcComplexNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcLineIndex createIfcLineIndex() {
		IfcLineIndexImpl ifcLineIndex = new IfcLineIndexImpl();
		return ifcLineIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcNullStyle createIfcNullStyle() {
		IfcNullStyleImpl ifcNullStyle = new IfcNullStyleImpl();
		return ifcNullStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListOfIfcCartesianPoint createListOfIfcCartesianPoint() {
		ListOfIfcCartesianPointImpl listOfIfcCartesianPoint = new ListOfIfcCartesianPointImpl();
		return listOfIfcCartesianPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListOfIfcLengthMeasure createListOfIfcLengthMeasure() {
		ListOfIfcLengthMeasureImpl listOfIfcLengthMeasure = new ListOfIfcLengthMeasureImpl();
		return listOfIfcLengthMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListOfIfcNormalisedRatioMeasure createListOfIfcNormalisedRatioMeasure() {
		ListOfIfcNormalisedRatioMeasureImpl listOfIfcNormalisedRatioMeasure = new ListOfIfcNormalisedRatioMeasureImpl();
		return listOfIfcNormalisedRatioMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListOfELong createListOfELong() {
		ListOfELongImpl listOfELong = new ListOfELongImpl();
		return listOfELong;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListOfEDouble createListOfEDouble() {
		ListOfEDoubleImpl listOfEDouble = new ListOfEDoubleImpl();
		return listOfEDouble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ListOfIfcParameterValue createListOfIfcParameterValue() {
		ListOfIfcParameterValueImpl listOfIfcParameterValue = new ListOfIfcParameterValueImpl();
		return listOfIfcParameterValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate createTristateFromString(EDataType eDataType, String initialValue) {
		Tristate result = Tristate.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcActionRequestTypeEnum createIfcActionRequestTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcActionRequestTypeEnum result = IfcActionRequestTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcActionRequestTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcAirTerminalBoxTypeEnum createIfcAirTerminalBoxTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcAirTerminalBoxTypeEnum result = IfcAirTerminalBoxTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcAirToAirHeatRecoveryTypeEnum createIfcAirToAirHeatRecoveryTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcAirToAirHeatRecoveryTypeEnum result = IfcAirToAirHeatRecoveryTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcAnalysisTheoryTypeEnum createIfcAnalysisTheoryTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcAnalysisTheoryTypeEnum result = IfcAnalysisTheoryTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcArithmeticOperatorEnum createIfcArithmeticOperatorEnumFromString(EDataType eDataType, String initialValue) {
		IfcArithmeticOperatorEnum result = IfcArithmeticOperatorEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcAudioVisualApplianceTypeEnum createIfcAudioVisualApplianceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcAudioVisualApplianceTypeEnum result = IfcAudioVisualApplianceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcAudioVisualApplianceTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcBSplineSurfaceForm createIfcBSplineSurfaceFormFromString(EDataType eDataType, String initialValue) {
		IfcBSplineSurfaceForm result = IfcBSplineSurfaceForm.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBSplineSurfaceFormToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcBuildingElementPartTypeEnum createIfcBuildingElementPartTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcBuildingElementPartTypeEnum result = IfcBuildingElementPartTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBuildingElementPartTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElementProxyTypeEnum createIfcBuildingElementProxyTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcBuildingElementProxyTypeEnum result = IfcBuildingElementProxyTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcBuildingSystemTypeEnum createIfcBuildingSystemTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcBuildingSystemTypeEnum result = IfcBuildingSystemTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBuildingSystemTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBurnerTypeEnum createIfcBurnerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcBurnerTypeEnum result = IfcBurnerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcBurnerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCableCarrierFittingTypeEnum createIfcCableCarrierFittingTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCableCarrierFittingTypeEnum result = IfcCableCarrierFittingTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcCableCarrierSegmentTypeEnum createIfcCableCarrierSegmentTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCableCarrierSegmentTypeEnum result = IfcCableCarrierSegmentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcCableFittingTypeEnum createIfcCableFittingTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCableFittingTypeEnum result = IfcCableFittingTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCableFittingTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcChimneyTypeEnum createIfcChimneyTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcChimneyTypeEnum result = IfcChimneyTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcChimneyTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcCommunicationsApplianceTypeEnum createIfcCommunicationsApplianceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCommunicationsApplianceTypeEnum result = IfcCommunicationsApplianceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCommunicationsApplianceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcComplexPropertyTemplateTypeEnum createIfcComplexPropertyTemplateTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcComplexPropertyTemplateTypeEnum result = IfcComplexPropertyTemplateTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcComplexPropertyTemplateTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcConstructionEquipmentResourceTypeEnum createIfcConstructionEquipmentResourceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcConstructionEquipmentResourceTypeEnum result = IfcConstructionEquipmentResourceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcConstructionEquipmentResourceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstructionMaterialResourceTypeEnum createIfcConstructionMaterialResourceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcConstructionMaterialResourceTypeEnum result = IfcConstructionMaterialResourceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcConstructionMaterialResourceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstructionProductResourceTypeEnum createIfcConstructionProductResourceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcConstructionProductResourceTypeEnum result = IfcConstructionProductResourceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcConstructionProductResourceTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcCostItemTypeEnum createIfcCostItemTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCostItemTypeEnum result = IfcCostItemTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCostItemTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcCrewResourceTypeEnum createIfcCrewResourceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcCrewResourceTypeEnum result = IfcCrewResourceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCrewResourceTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcCurveInterpolationEnum createIfcCurveInterpolationEnumFromString(EDataType eDataType, String initialValue) {
		IfcCurveInterpolationEnum result = IfcCurveInterpolationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcCurveInterpolationEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcDirectionSenseEnum createIfcDirectionSenseEnumFromString(EDataType eDataType, String initialValue) {
		IfcDirectionSenseEnum result = IfcDirectionSenseEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcDiscreteAccessoryTypeEnum createIfcDiscreteAccessoryTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcDiscreteAccessoryTypeEnum result = IfcDiscreteAccessoryTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDiscreteAccessoryTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionChamberElementTypeEnum createIfcDistributionChamberElementTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcDistributionChamberElementTypeEnum result = IfcDistributionChamberElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcDistributionPortTypeEnum createIfcDistributionPortTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcDistributionPortTypeEnum result = IfcDistributionPortTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDistributionPortTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionSystemEnum createIfcDistributionSystemEnumFromString(EDataType eDataType, String initialValue) {
		IfcDistributionSystemEnum result = IfcDistributionSystemEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDistributionSystemEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDocumentConfidentialityEnum createIfcDocumentConfidentialityEnumFromString(EDataType eDataType, String initialValue) {
		IfcDocumentConfidentialityEnum result = IfcDocumentConfidentialityEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcDoorPanelOperationEnum createIfcDoorPanelOperationEnumFromString(EDataType eDataType, String initialValue) {
		IfcDoorPanelOperationEnum result = IfcDoorPanelOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcDoorStyleConstructionEnum createIfcDoorStyleConstructionEnumFromString(EDataType eDataType, String initialValue) {
		IfcDoorStyleConstructionEnum result = IfcDoorStyleConstructionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcDoorStyleOperationEnum createIfcDoorStyleOperationEnumFromString(EDataType eDataType, String initialValue) {
		IfcDoorStyleOperationEnum result = IfcDoorStyleOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcDoorTypeEnum createIfcDoorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcDoorTypeEnum result = IfcDoorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDoorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDoorTypeOperationEnum createIfcDoorTypeOperationEnumFromString(EDataType eDataType, String initialValue) {
		IfcDoorTypeOperationEnum result = IfcDoorTypeOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcDoorTypeOperationEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcElectricApplianceTypeEnum createIfcElectricApplianceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcElectricApplianceTypeEnum result = IfcElectricApplianceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcElectricDistributionBoardTypeEnum createIfcElectricDistributionBoardTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcElectricDistributionBoardTypeEnum result = IfcElectricDistributionBoardTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcElectricDistributionBoardTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElectricFlowStorageDeviceTypeEnum createIfcElectricFlowStorageDeviceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcElectricFlowStorageDeviceTypeEnum result = IfcElectricFlowStorageDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcElectricGeneratorTypeEnum createIfcElectricGeneratorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcElectricGeneratorTypeEnum result = IfcElectricGeneratorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcElectricMotorTypeEnum createIfcElectricMotorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcElectricMotorTypeEnum result = IfcElectricMotorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcElectricTimeControlTypeEnum createIfcElectricTimeControlTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcElectricTimeControlTypeEnum result = IfcElectricTimeControlTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcElementAssemblyTypeEnum createIfcElementAssemblyTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcElementAssemblyTypeEnum result = IfcElementAssemblyTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcElementCompositionEnum createIfcElementCompositionEnumFromString(EDataType eDataType, String initialValue) {
		IfcElementCompositionEnum result = IfcElementCompositionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcEngineTypeEnum createIfcEngineTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcEngineTypeEnum result = IfcEngineTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcEngineTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEvaporativeCoolerTypeEnum createIfcEvaporativeCoolerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcEvaporativeCoolerTypeEnum result = IfcEvaporativeCoolerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcEventTriggerTypeEnum createIfcEventTriggerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcEventTriggerTypeEnum result = IfcEventTriggerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcEventTriggerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEventTypeEnum createIfcEventTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcEventTypeEnum result = IfcEventTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcEventTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcExternalSpatialElementTypeEnum createIfcExternalSpatialElementTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcExternalSpatialElementTypeEnum result = IfcExternalSpatialElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcExternalSpatialElementTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcFastenerTypeEnum createIfcFastenerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcFastenerTypeEnum result = IfcFastenerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFastenerTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcFireSuppressionTerminalTypeEnum createIfcFireSuppressionTerminalTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcFireSuppressionTerminalTypeEnum result = IfcFireSuppressionTerminalTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcFlowInstrumentTypeEnum createIfcFlowInstrumentTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcFlowInstrumentTypeEnum result = IfcFlowInstrumentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcFurnitureTypeEnum createIfcFurnitureTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcFurnitureTypeEnum result = IfcFurnitureTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcFurnitureTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeographicElementTypeEnum createIfcGeographicElementTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcGeographicElementTypeEnum result = IfcGeographicElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcGeographicElementTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricProjectionEnum createIfcGeometricProjectionEnumFromString(EDataType eDataType, String initialValue) {
		IfcGeometricProjectionEnum result = IfcGeometricProjectionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcGridTypeEnum createIfcGridTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcGridTypeEnum result = IfcGridTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcGridTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcInterceptorTypeEnum createIfcInterceptorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcInterceptorTypeEnum result = IfcInterceptorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcInterceptorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInternalOrExternalEnum createIfcInternalOrExternalEnumFromString(EDataType eDataType, String initialValue) {
		IfcInternalOrExternalEnum result = IfcInternalOrExternalEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcKnotType createIfcKnotTypeFromString(EDataType eDataType, String initialValue) {
		IfcKnotType result = IfcKnotType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcKnotTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLaborResourceTypeEnum createIfcLaborResourceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcLaborResourceTypeEnum result = IfcLaborResourceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcLaborResourceTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcLightDistributionCurveEnum createIfcLightDistributionCurveEnumFromString(EDataType eDataType, String initialValue) {
		IfcLightDistributionCurveEnum result = IfcLightDistributionCurveEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcLightEmissionSourceEnum createIfcLightEmissionSourceEnumFromString(EDataType eDataType, String initialValue) {
		IfcLightEmissionSourceEnum result = IfcLightEmissionSourceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcMechanicalFastenerTypeEnum createIfcMechanicalFastenerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcMechanicalFastenerTypeEnum result = IfcMechanicalFastenerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcMechanicalFastenerTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMedicalDeviceTypeEnum createIfcMedicalDeviceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcMedicalDeviceTypeEnum result = IfcMedicalDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcMedicalDeviceTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcMotorConnectionTypeEnum createIfcMotorConnectionTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcMotorConnectionTypeEnum result = IfcMotorConnectionTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcOpeningElementTypeEnum createIfcOpeningElementTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcOpeningElementTypeEnum result = IfcOpeningElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcOpeningElementTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcPerformanceHistoryTypeEnum createIfcPerformanceHistoryTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcPerformanceHistoryTypeEnum result = IfcPerformanceHistoryTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPerformanceHistoryTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPermeableCoveringOperationEnum createIfcPermeableCoveringOperationEnumFromString(EDataType eDataType, String initialValue) {
		IfcPermeableCoveringOperationEnum result = IfcPermeableCoveringOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcPermitTypeEnum createIfcPermitTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcPermitTypeEnum result = IfcPermitTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPermitTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcPreferredSurfaceCurveRepresentation createIfcPreferredSurfaceCurveRepresentationFromString(EDataType eDataType, String initialValue) {
		IfcPreferredSurfaceCurveRepresentation result = IfcPreferredSurfaceCurveRepresentation.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPreferredSurfaceCurveRepresentationToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcProjectOrderTypeEnum createIfcProjectOrderTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcProjectOrderTypeEnum result = IfcProjectOrderTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcProjectedOrTrueLengthEnum createIfcProjectedOrTrueLengthEnumFromString(EDataType eDataType, String initialValue) {
		IfcProjectedOrTrueLengthEnum result = IfcProjectedOrTrueLengthEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcProjectionElementTypeEnum createIfcProjectionElementTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcProjectionElementTypeEnum result = IfcProjectionElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcProjectionElementTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPropertySetTemplateTypeEnum createIfcPropertySetTemplateTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcPropertySetTemplateTypeEnum result = IfcPropertySetTemplateTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcPropertySetTemplateTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProtectiveDeviceTrippingUnitTypeEnum createIfcProtectiveDeviceTrippingUnitTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcProtectiveDeviceTrippingUnitTypeEnum result = IfcProtectiveDeviceTrippingUnitTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcProtectiveDeviceTrippingUnitTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProtectiveDeviceTypeEnum createIfcProtectiveDeviceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcProtectiveDeviceTypeEnum result = IfcProtectiveDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcRecurrenceTypeEnum createIfcRecurrenceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcRecurrenceTypeEnum result = IfcRecurrenceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcRecurrenceTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcReinforcingBarRoleEnum createIfcReinforcingBarRoleEnumFromString(EDataType eDataType, String initialValue) {
		IfcReinforcingBarRoleEnum result = IfcReinforcingBarRoleEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcReinforcingBarSurfaceEnum createIfcReinforcingBarSurfaceEnumFromString(EDataType eDataType, String initialValue) {
		IfcReinforcingBarSurfaceEnum result = IfcReinforcingBarSurfaceEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcReinforcingBarTypeEnum createIfcReinforcingBarTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcReinforcingBarTypeEnum result = IfcReinforcingBarTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcReinforcingBarTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingMeshTypeEnum createIfcReinforcingMeshTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcReinforcingMeshTypeEnum result = IfcReinforcingMeshTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcReinforcingMeshTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcSanitaryTerminalTypeEnum createIfcSanitaryTerminalTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSanitaryTerminalTypeEnum result = IfcSanitaryTerminalTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcShadingDeviceTypeEnum createIfcShadingDeviceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcShadingDeviceTypeEnum result = IfcShadingDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcShadingDeviceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSimplePropertyTemplateTypeEnum createIfcSimplePropertyTemplateTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSimplePropertyTemplateTypeEnum result = IfcSimplePropertyTemplateTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSimplePropertyTemplateTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcSolarDeviceTypeEnum createIfcSolarDeviceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSolarDeviceTypeEnum result = IfcSolarDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSolarDeviceTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcSpatialZoneTypeEnum createIfcSpatialZoneTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSpatialZoneTypeEnum result = IfcSpatialZoneTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSpatialZoneTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcStructuralCurveActivityTypeEnum createIfcStructuralCurveActivityTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcStructuralCurveActivityTypeEnum result = IfcStructuralCurveActivityTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStructuralCurveActivityTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralCurveMemberTypeEnum createIfcStructuralCurveMemberTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcStructuralCurveMemberTypeEnum result = IfcStructuralCurveMemberTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStructuralCurveMemberTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralSurfaceActivityTypeEnum createIfcStructuralSurfaceActivityTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcStructuralSurfaceActivityTypeEnum result = IfcStructuralSurfaceActivityTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStructuralSurfaceActivityTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralSurfaceMemberTypeEnum createIfcStructuralSurfaceMemberTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcStructuralSurfaceMemberTypeEnum result = IfcStructuralSurfaceMemberTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcStructuralSurfaceMemberTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSubContractResourceTypeEnum createIfcSubContractResourceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSubContractResourceTypeEnum result = IfcSubContractResourceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSubContractResourceTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceFeatureTypeEnum createIfcSurfaceFeatureTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSurfaceFeatureTypeEnum result = IfcSurfaceFeatureTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSurfaceFeatureTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcSwitchingDeviceTypeEnum createIfcSwitchingDeviceTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSwitchingDeviceTypeEnum result = IfcSwitchingDeviceTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcSystemFurnitureElementTypeEnum createIfcSystemFurnitureElementTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcSystemFurnitureElementTypeEnum result = IfcSystemFurnitureElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcSystemFurnitureElementTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcTaskDurationEnum createIfcTaskDurationEnumFromString(EDataType eDataType, String initialValue) {
		IfcTaskDurationEnum result = IfcTaskDurationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTaskDurationEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTaskTypeEnum createIfcTaskTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTaskTypeEnum result = IfcTaskTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTaskTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTendonAnchorTypeEnum createIfcTendonAnchorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTendonAnchorTypeEnum result = IfcTendonAnchorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcTendonAnchorTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcTimeSeriesDataTypeEnum createIfcTimeSeriesDataTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTimeSeriesDataTypeEnum result = IfcTimeSeriesDataTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcTransformerTypeEnum createIfcTransformerTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTransformerTypeEnum result = IfcTransformerTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcTransportElementTypeEnum createIfcTransportElementTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcTransportElementTypeEnum result = IfcTransportElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcUnitaryControlElementTypeEnum createIfcUnitaryControlElementTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcUnitaryControlElementTypeEnum result = IfcUnitaryControlElementTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcUnitaryControlElementTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnitaryEquipmentTypeEnum createIfcUnitaryEquipmentTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcUnitaryEquipmentTypeEnum result = IfcUnitaryEquipmentTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcVibrationIsolatorTypeEnum createIfcVibrationIsolatorTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcVibrationIsolatorTypeEnum result = IfcVibrationIsolatorTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcVoidingFeatureTypeEnum createIfcVoidingFeatureTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcVoidingFeatureTypeEnum result = IfcVoidingFeatureTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcVoidingFeatureTypeEnumToString(EDataType eDataType, Object instanceValue) {
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcWindowPanelOperationEnum createIfcWindowPanelOperationEnumFromString(EDataType eDataType, String initialValue) {
		IfcWindowPanelOperationEnum result = IfcWindowPanelOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcWindowPanelPositionEnum createIfcWindowPanelPositionEnumFromString(EDataType eDataType, String initialValue) {
		IfcWindowPanelPositionEnum result = IfcWindowPanelPositionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcWindowStyleConstructionEnum createIfcWindowStyleConstructionEnumFromString(EDataType eDataType, String initialValue) {
		IfcWindowStyleConstructionEnum result = IfcWindowStyleConstructionEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcWindowStyleOperationEnum createIfcWindowStyleOperationEnumFromString(EDataType eDataType, String initialValue) {
		IfcWindowStyleOperationEnum result = IfcWindowStyleOperationEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public IfcWindowTypeEnum createIfcWindowTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcWindowTypeEnum result = IfcWindowTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWindowTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowTypePartitioningEnum createIfcWindowTypePartitioningEnumFromString(EDataType eDataType, String initialValue) {
		IfcWindowTypePartitioningEnum result = IfcWindowTypePartitioningEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWindowTypePartitioningEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkCalendarTypeEnum createIfcWorkCalendarTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcWorkCalendarTypeEnum result = IfcWorkCalendarTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWorkCalendarTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkPlanTypeEnum createIfcWorkPlanTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcWorkPlanTypeEnum result = IfcWorkPlanTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWorkPlanTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWorkScheduleTypeEnum createIfcWorkScheduleTypeEnumFromString(EDataType eDataType, String initialValue) {
		IfcWorkScheduleTypeEnum result = IfcWorkScheduleTypeEnum.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIfcWorkScheduleTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Ifc4Package getIfc4Package() {
		return (Ifc4Package) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Ifc4Package getPackage() {
		return Ifc4Package.eINSTANCE;
	}

} //Ifc4FactoryImpl
