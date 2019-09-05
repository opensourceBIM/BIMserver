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
package org.bimserver.models.ifc4;

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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package
 * @generated
 */
public interface Ifc4Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Ifc4Factory eINSTANCE = org.bimserver.models.ifc4.impl.Ifc4FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ifc Action Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Action Request</em>'.
	 * @generated
	 */
	IfcActionRequest createIfcActionRequest();

	/**
	 * Returns a new object of class '<em>Ifc Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Actor</em>'.
	 * @generated
	 */
	IfcActor createIfcActor();

	/**
	 * Returns a new object of class '<em>Ifc Actor Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Actor Role</em>'.
	 * @generated
	 */
	IfcActorRole createIfcActorRole();

	/**
	 * Returns a new object of class '<em>Ifc Actuator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Actuator</em>'.
	 * @generated
	 */
	IfcActuator createIfcActuator();

	/**
	 * Returns a new object of class '<em>Ifc Actuator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Actuator Type</em>'.
	 * @generated
	 */
	IfcActuatorType createIfcActuatorType();

	/**
	 * Returns a new object of class '<em>Ifc Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Address</em>'.
	 * @generated
	 */
	IfcAddress createIfcAddress();

	/**
	 * Returns a new object of class '<em>Ifc Advanced Brep</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Advanced Brep</em>'.
	 * @generated
	 */
	IfcAdvancedBrep createIfcAdvancedBrep();

	/**
	 * Returns a new object of class '<em>Ifc Advanced Brep With Voids</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Advanced Brep With Voids</em>'.
	 * @generated
	 */
	IfcAdvancedBrepWithVoids createIfcAdvancedBrepWithVoids();

	/**
	 * Returns a new object of class '<em>Ifc Advanced Face</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Advanced Face</em>'.
	 * @generated
	 */
	IfcAdvancedFace createIfcAdvancedFace();

	/**
	 * Returns a new object of class '<em>Ifc Air Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Air Terminal</em>'.
	 * @generated
	 */
	IfcAirTerminal createIfcAirTerminal();

	/**
	 * Returns a new object of class '<em>Ifc Air Terminal Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Air Terminal Box</em>'.
	 * @generated
	 */
	IfcAirTerminalBox createIfcAirTerminalBox();

	/**
	 * Returns a new object of class '<em>Ifc Air Terminal Box Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Air Terminal Box Type</em>'.
	 * @generated
	 */
	IfcAirTerminalBoxType createIfcAirTerminalBoxType();

	/**
	 * Returns a new object of class '<em>Ifc Air Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Air Terminal Type</em>'.
	 * @generated
	 */
	IfcAirTerminalType createIfcAirTerminalType();

	/**
	 * Returns a new object of class '<em>Ifc Air To Air Heat Recovery</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Air To Air Heat Recovery</em>'.
	 * @generated
	 */
	IfcAirToAirHeatRecovery createIfcAirToAirHeatRecovery();

	/**
	 * Returns a new object of class '<em>Ifc Air To Air Heat Recovery Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Air To Air Heat Recovery Type</em>'.
	 * @generated
	 */
	IfcAirToAirHeatRecoveryType createIfcAirToAirHeatRecoveryType();

	/**
	 * Returns a new object of class '<em>Ifc Alarm</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Alarm</em>'.
	 * @generated
	 */
	IfcAlarm createIfcAlarm();

	/**
	 * Returns a new object of class '<em>Ifc Alarm Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Alarm Type</em>'.
	 * @generated
	 */
	IfcAlarmType createIfcAlarmType();

	/**
	 * Returns a new object of class '<em>Ifc Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Annotation</em>'.
	 * @generated
	 */
	IfcAnnotation createIfcAnnotation();

	/**
	 * Returns a new object of class '<em>Ifc Annotation Fill Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Annotation Fill Area</em>'.
	 * @generated
	 */
	IfcAnnotationFillArea createIfcAnnotationFillArea();

	/**
	 * Returns a new object of class '<em>Ifc Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Application</em>'.
	 * @generated
	 */
	IfcApplication createIfcApplication();

	/**
	 * Returns a new object of class '<em>Ifc Applied Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Applied Value</em>'.
	 * @generated
	 */
	IfcAppliedValue createIfcAppliedValue();

	/**
	 * Returns a new object of class '<em>Ifc Approval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Approval</em>'.
	 * @generated
	 */
	IfcApproval createIfcApproval();

	/**
	 * Returns a new object of class '<em>Ifc Approval Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Approval Relationship</em>'.
	 * @generated
	 */
	IfcApprovalRelationship createIfcApprovalRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Arbitrary Closed Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Arbitrary Closed Profile Def</em>'.
	 * @generated
	 */
	IfcArbitraryClosedProfileDef createIfcArbitraryClosedProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Arbitrary Open Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Arbitrary Open Profile Def</em>'.
	 * @generated
	 */
	IfcArbitraryOpenProfileDef createIfcArbitraryOpenProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Arbitrary Profile Def With Voids</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Arbitrary Profile Def With Voids</em>'.
	 * @generated
	 */
	IfcArbitraryProfileDefWithVoids createIfcArbitraryProfileDefWithVoids();

	/**
	 * Returns a new object of class '<em>Ifc Asset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Asset</em>'.
	 * @generated
	 */
	IfcAsset createIfcAsset();

	/**
	 * Returns a new object of class '<em>Ifc Asymmetric IShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Asymmetric IShape Profile Def</em>'.
	 * @generated
	 */
	IfcAsymmetricIShapeProfileDef createIfcAsymmetricIShapeProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Audio Visual Appliance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Audio Visual Appliance</em>'.
	 * @generated
	 */
	IfcAudioVisualAppliance createIfcAudioVisualAppliance();

	/**
	 * Returns a new object of class '<em>Ifc Audio Visual Appliance Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Audio Visual Appliance Type</em>'.
	 * @generated
	 */
	IfcAudioVisualApplianceType createIfcAudioVisualApplianceType();

	/**
	 * Returns a new object of class '<em>Ifc Axis1 Placement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Axis1 Placement</em>'.
	 * @generated
	 */
	IfcAxis1Placement createIfcAxis1Placement();

	/**
	 * Returns a new object of class '<em>Ifc Axis2 Placement2 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Axis2 Placement2 D</em>'.
	 * @generated
	 */
	IfcAxis2Placement2D createIfcAxis2Placement2D();

	/**
	 * Returns a new object of class '<em>Ifc Axis2 Placement3 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Axis2 Placement3 D</em>'.
	 * @generated
	 */
	IfcAxis2Placement3D createIfcAxis2Placement3D();

	/**
	 * Returns a new object of class '<em>Ifc BSpline Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc BSpline Curve</em>'.
	 * @generated
	 */
	IfcBSplineCurve createIfcBSplineCurve();

	/**
	 * Returns a new object of class '<em>Ifc BSpline Curve With Knots</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc BSpline Curve With Knots</em>'.
	 * @generated
	 */
	IfcBSplineCurveWithKnots createIfcBSplineCurveWithKnots();

	/**
	 * Returns a new object of class '<em>Ifc BSpline Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc BSpline Surface</em>'.
	 * @generated
	 */
	IfcBSplineSurface createIfcBSplineSurface();

	/**
	 * Returns a new object of class '<em>Ifc BSpline Surface With Knots</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc BSpline Surface With Knots</em>'.
	 * @generated
	 */
	IfcBSplineSurfaceWithKnots createIfcBSplineSurfaceWithKnots();

	/**
	 * Returns a new object of class '<em>Ifc Beam</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Beam</em>'.
	 * @generated
	 */
	IfcBeam createIfcBeam();

	/**
	 * Returns a new object of class '<em>Ifc Beam Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Beam Standard Case</em>'.
	 * @generated
	 */
	IfcBeamStandardCase createIfcBeamStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Beam Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Beam Type</em>'.
	 * @generated
	 */
	IfcBeamType createIfcBeamType();

	/**
	 * Returns a new object of class '<em>Ifc Blob Texture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Blob Texture</em>'.
	 * @generated
	 */
	IfcBlobTexture createIfcBlobTexture();

	/**
	 * Returns a new object of class '<em>Ifc Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Block</em>'.
	 * @generated
	 */
	IfcBlock createIfcBlock();

	/**
	 * Returns a new object of class '<em>Ifc Boiler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boiler</em>'.
	 * @generated
	 */
	IfcBoiler createIfcBoiler();

	/**
	 * Returns a new object of class '<em>Ifc Boiler Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boiler Type</em>'.
	 * @generated
	 */
	IfcBoilerType createIfcBoilerType();

	/**
	 * Returns a new object of class '<em>Ifc Boolean Clipping Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boolean Clipping Result</em>'.
	 * @generated
	 */
	IfcBooleanClippingResult createIfcBooleanClippingResult();

	/**
	 * Returns a new object of class '<em>Ifc Boolean Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boolean Result</em>'.
	 * @generated
	 */
	IfcBooleanResult createIfcBooleanResult();

	/**
	 * Returns a new object of class '<em>Ifc Boundary Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boundary Condition</em>'.
	 * @generated
	 */
	IfcBoundaryCondition createIfcBoundaryCondition();

	/**
	 * Returns a new object of class '<em>Ifc Boundary Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boundary Curve</em>'.
	 * @generated
	 */
	IfcBoundaryCurve createIfcBoundaryCurve();

	/**
	 * Returns a new object of class '<em>Ifc Boundary Edge Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boundary Edge Condition</em>'.
	 * @generated
	 */
	IfcBoundaryEdgeCondition createIfcBoundaryEdgeCondition();

	/**
	 * Returns a new object of class '<em>Ifc Boundary Face Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boundary Face Condition</em>'.
	 * @generated
	 */
	IfcBoundaryFaceCondition createIfcBoundaryFaceCondition();

	/**
	 * Returns a new object of class '<em>Ifc Boundary Node Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boundary Node Condition</em>'.
	 * @generated
	 */
	IfcBoundaryNodeCondition createIfcBoundaryNodeCondition();

	/**
	 * Returns a new object of class '<em>Ifc Boundary Node Condition Warping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boundary Node Condition Warping</em>'.
	 * @generated
	 */
	IfcBoundaryNodeConditionWarping createIfcBoundaryNodeConditionWarping();

	/**
	 * Returns a new object of class '<em>Ifc Bounded Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Bounded Curve</em>'.
	 * @generated
	 */
	IfcBoundedCurve createIfcBoundedCurve();

	/**
	 * Returns a new object of class '<em>Ifc Bounded Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Bounded Surface</em>'.
	 * @generated
	 */
	IfcBoundedSurface createIfcBoundedSurface();

	/**
	 * Returns a new object of class '<em>Ifc Bounding Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Bounding Box</em>'.
	 * @generated
	 */
	IfcBoundingBox createIfcBoundingBox();

	/**
	 * Returns a new object of class '<em>Ifc Boxed Half Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boxed Half Space</em>'.
	 * @generated
	 */
	IfcBoxedHalfSpace createIfcBoxedHalfSpace();

	/**
	 * Returns a new object of class '<em>Ifc Building</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building</em>'.
	 * @generated
	 */
	IfcBuilding createIfcBuilding();

	/**
	 * Returns a new object of class '<em>Ifc Building Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building Element</em>'.
	 * @generated
	 */
	IfcBuildingElement createIfcBuildingElement();

	/**
	 * Returns a new object of class '<em>Ifc Building Element Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building Element Part</em>'.
	 * @generated
	 */
	IfcBuildingElementPart createIfcBuildingElementPart();

	/**
	 * Returns a new object of class '<em>Ifc Building Element Part Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building Element Part Type</em>'.
	 * @generated
	 */
	IfcBuildingElementPartType createIfcBuildingElementPartType();

	/**
	 * Returns a new object of class '<em>Ifc Building Element Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building Element Proxy</em>'.
	 * @generated
	 */
	IfcBuildingElementProxy createIfcBuildingElementProxy();

	/**
	 * Returns a new object of class '<em>Ifc Building Element Proxy Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building Element Proxy Type</em>'.
	 * @generated
	 */
	IfcBuildingElementProxyType createIfcBuildingElementProxyType();

	/**
	 * Returns a new object of class '<em>Ifc Building Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building Element Type</em>'.
	 * @generated
	 */
	IfcBuildingElementType createIfcBuildingElementType();

	/**
	 * Returns a new object of class '<em>Ifc Building Storey</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building Storey</em>'.
	 * @generated
	 */
	IfcBuildingStorey createIfcBuildingStorey();

	/**
	 * Returns a new object of class '<em>Ifc Building System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Building System</em>'.
	 * @generated
	 */
	IfcBuildingSystem createIfcBuildingSystem();

	/**
	 * Returns a new object of class '<em>Ifc Burner</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Burner</em>'.
	 * @generated
	 */
	IfcBurner createIfcBurner();

	/**
	 * Returns a new object of class '<em>Ifc Burner Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Burner Type</em>'.
	 * @generated
	 */
	IfcBurnerType createIfcBurnerType();

	/**
	 * Returns a new object of class '<em>Ifc CShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc CShape Profile Def</em>'.
	 * @generated
	 */
	IfcCShapeProfileDef createIfcCShapeProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Cable Carrier Fitting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cable Carrier Fitting</em>'.
	 * @generated
	 */
	IfcCableCarrierFitting createIfcCableCarrierFitting();

	/**
	 * Returns a new object of class '<em>Ifc Cable Carrier Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cable Carrier Fitting Type</em>'.
	 * @generated
	 */
	IfcCableCarrierFittingType createIfcCableCarrierFittingType();

	/**
	 * Returns a new object of class '<em>Ifc Cable Carrier Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cable Carrier Segment</em>'.
	 * @generated
	 */
	IfcCableCarrierSegment createIfcCableCarrierSegment();

	/**
	 * Returns a new object of class '<em>Ifc Cable Carrier Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cable Carrier Segment Type</em>'.
	 * @generated
	 */
	IfcCableCarrierSegmentType createIfcCableCarrierSegmentType();

	/**
	 * Returns a new object of class '<em>Ifc Cable Fitting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cable Fitting</em>'.
	 * @generated
	 */
	IfcCableFitting createIfcCableFitting();

	/**
	 * Returns a new object of class '<em>Ifc Cable Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cable Fitting Type</em>'.
	 * @generated
	 */
	IfcCableFittingType createIfcCableFittingType();

	/**
	 * Returns a new object of class '<em>Ifc Cable Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cable Segment</em>'.
	 * @generated
	 */
	IfcCableSegment createIfcCableSegment();

	/**
	 * Returns a new object of class '<em>Ifc Cable Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cable Segment Type</em>'.
	 * @generated
	 */
	IfcCableSegmentType createIfcCableSegmentType();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Point</em>'.
	 * @generated
	 */
	IfcCartesianPoint createIfcCartesianPoint();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Point List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Point List</em>'.
	 * @generated
	 */
	IfcCartesianPointList createIfcCartesianPointList();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Point List2 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Point List2 D</em>'.
	 * @generated
	 */
	IfcCartesianPointList2D createIfcCartesianPointList2D();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Point List3 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Point List3 D</em>'.
	 * @generated
	 */
	IfcCartesianPointList3D createIfcCartesianPointList3D();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Transformation Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Transformation Operator</em>'.
	 * @generated
	 */
	IfcCartesianTransformationOperator createIfcCartesianTransformationOperator();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Transformation Operator2 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Transformation Operator2 D</em>'.
	 * @generated
	 */
	IfcCartesianTransformationOperator2D createIfcCartesianTransformationOperator2D();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Transformation Operator2 Dnon Uniform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Transformation Operator2 Dnon Uniform</em>'.
	 * @generated
	 */
	IfcCartesianTransformationOperator2DnonUniform createIfcCartesianTransformationOperator2DnonUniform();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Transformation Operator3 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Transformation Operator3 D</em>'.
	 * @generated
	 */
	IfcCartesianTransformationOperator3D createIfcCartesianTransformationOperator3D();

	/**
	 * Returns a new object of class '<em>Ifc Cartesian Transformation Operator3 Dnon Uniform</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cartesian Transformation Operator3 Dnon Uniform</em>'.
	 * @generated
	 */
	IfcCartesianTransformationOperator3DnonUniform createIfcCartesianTransformationOperator3DnonUniform();

	/**
	 * Returns a new object of class '<em>Ifc Center Line Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Center Line Profile Def</em>'.
	 * @generated
	 */
	IfcCenterLineProfileDef createIfcCenterLineProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Chiller</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Chiller</em>'.
	 * @generated
	 */
	IfcChiller createIfcChiller();

	/**
	 * Returns a new object of class '<em>Ifc Chiller Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Chiller Type</em>'.
	 * @generated
	 */
	IfcChillerType createIfcChillerType();

	/**
	 * Returns a new object of class '<em>Ifc Chimney</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Chimney</em>'.
	 * @generated
	 */
	IfcChimney createIfcChimney();

	/**
	 * Returns a new object of class '<em>Ifc Chimney Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Chimney Type</em>'.
	 * @generated
	 */
	IfcChimneyType createIfcChimneyType();

	/**
	 * Returns a new object of class '<em>Ifc Circle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Circle</em>'.
	 * @generated
	 */
	IfcCircle createIfcCircle();

	/**
	 * Returns a new object of class '<em>Ifc Circle Hollow Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Circle Hollow Profile Def</em>'.
	 * @generated
	 */
	IfcCircleHollowProfileDef createIfcCircleHollowProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Circle Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Circle Profile Def</em>'.
	 * @generated
	 */
	IfcCircleProfileDef createIfcCircleProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Civil Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Civil Element</em>'.
	 * @generated
	 */
	IfcCivilElement createIfcCivilElement();

	/**
	 * Returns a new object of class '<em>Ifc Civil Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Civil Element Type</em>'.
	 * @generated
	 */
	IfcCivilElementType createIfcCivilElementType();

	/**
	 * Returns a new object of class '<em>Ifc Classification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Classification</em>'.
	 * @generated
	 */
	IfcClassification createIfcClassification();

	/**
	 * Returns a new object of class '<em>Ifc Classification Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Classification Reference</em>'.
	 * @generated
	 */
	IfcClassificationReference createIfcClassificationReference();

	/**
	 * Returns a new object of class '<em>Ifc Closed Shell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Closed Shell</em>'.
	 * @generated
	 */
	IfcClosedShell createIfcClosedShell();

	/**
	 * Returns a new object of class '<em>Ifc Coil</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Coil</em>'.
	 * @generated
	 */
	IfcCoil createIfcCoil();

	/**
	 * Returns a new object of class '<em>Ifc Coil Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Coil Type</em>'.
	 * @generated
	 */
	IfcCoilType createIfcCoilType();

	/**
	 * Returns a new object of class '<em>Ifc Colour Rgb</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Colour Rgb</em>'.
	 * @generated
	 */
	IfcColourRgb createIfcColourRgb();

	/**
	 * Returns a new object of class '<em>Ifc Colour Rgb List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Colour Rgb List</em>'.
	 * @generated
	 */
	IfcColourRgbList createIfcColourRgbList();

	/**
	 * Returns a new object of class '<em>Ifc Colour Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Colour Specification</em>'.
	 * @generated
	 */
	IfcColourSpecification createIfcColourSpecification();

	/**
	 * Returns a new object of class '<em>Ifc Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Column</em>'.
	 * @generated
	 */
	IfcColumn createIfcColumn();

	/**
	 * Returns a new object of class '<em>Ifc Column Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Column Standard Case</em>'.
	 * @generated
	 */
	IfcColumnStandardCase createIfcColumnStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Column Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Column Type</em>'.
	 * @generated
	 */
	IfcColumnType createIfcColumnType();

	/**
	 * Returns a new object of class '<em>Ifc Communications Appliance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Communications Appliance</em>'.
	 * @generated
	 */
	IfcCommunicationsAppliance createIfcCommunicationsAppliance();

	/**
	 * Returns a new object of class '<em>Ifc Communications Appliance Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Communications Appliance Type</em>'.
	 * @generated
	 */
	IfcCommunicationsApplianceType createIfcCommunicationsApplianceType();

	/**
	 * Returns a new object of class '<em>Ifc Complex Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Complex Property</em>'.
	 * @generated
	 */
	IfcComplexProperty createIfcComplexProperty();

	/**
	 * Returns a new object of class '<em>Ifc Complex Property Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Complex Property Template</em>'.
	 * @generated
	 */
	IfcComplexPropertyTemplate createIfcComplexPropertyTemplate();

	/**
	 * Returns a new object of class '<em>Ifc Composite Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Composite Curve</em>'.
	 * @generated
	 */
	IfcCompositeCurve createIfcCompositeCurve();

	/**
	 * Returns a new object of class '<em>Ifc Composite Curve On Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Composite Curve On Surface</em>'.
	 * @generated
	 */
	IfcCompositeCurveOnSurface createIfcCompositeCurveOnSurface();

	/**
	 * Returns a new object of class '<em>Ifc Composite Curve Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Composite Curve Segment</em>'.
	 * @generated
	 */
	IfcCompositeCurveSegment createIfcCompositeCurveSegment();

	/**
	 * Returns a new object of class '<em>Ifc Composite Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Composite Profile Def</em>'.
	 * @generated
	 */
	IfcCompositeProfileDef createIfcCompositeProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Compressor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Compressor</em>'.
	 * @generated
	 */
	IfcCompressor createIfcCompressor();

	/**
	 * Returns a new object of class '<em>Ifc Compressor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Compressor Type</em>'.
	 * @generated
	 */
	IfcCompressorType createIfcCompressorType();

	/**
	 * Returns a new object of class '<em>Ifc Condenser</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Condenser</em>'.
	 * @generated
	 */
	IfcCondenser createIfcCondenser();

	/**
	 * Returns a new object of class '<em>Ifc Condenser Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Condenser Type</em>'.
	 * @generated
	 */
	IfcCondenserType createIfcCondenserType();

	/**
	 * Returns a new object of class '<em>Ifc Conic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Conic</em>'.
	 * @generated
	 */
	IfcConic createIfcConic();

	/**
	 * Returns a new object of class '<em>Ifc Connected Face Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Connected Face Set</em>'.
	 * @generated
	 */
	IfcConnectedFaceSet createIfcConnectedFaceSet();

	/**
	 * Returns a new object of class '<em>Ifc Connection Curve Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Connection Curve Geometry</em>'.
	 * @generated
	 */
	IfcConnectionCurveGeometry createIfcConnectionCurveGeometry();

	/**
	 * Returns a new object of class '<em>Ifc Connection Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Connection Geometry</em>'.
	 * @generated
	 */
	IfcConnectionGeometry createIfcConnectionGeometry();

	/**
	 * Returns a new object of class '<em>Ifc Connection Point Eccentricity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Connection Point Eccentricity</em>'.
	 * @generated
	 */
	IfcConnectionPointEccentricity createIfcConnectionPointEccentricity();

	/**
	 * Returns a new object of class '<em>Ifc Connection Point Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Connection Point Geometry</em>'.
	 * @generated
	 */
	IfcConnectionPointGeometry createIfcConnectionPointGeometry();

	/**
	 * Returns a new object of class '<em>Ifc Connection Surface Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Connection Surface Geometry</em>'.
	 * @generated
	 */
	IfcConnectionSurfaceGeometry createIfcConnectionSurfaceGeometry();

	/**
	 * Returns a new object of class '<em>Ifc Connection Volume Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Connection Volume Geometry</em>'.
	 * @generated
	 */
	IfcConnectionVolumeGeometry createIfcConnectionVolumeGeometry();

	/**
	 * Returns a new object of class '<em>Ifc Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Constraint</em>'.
	 * @generated
	 */
	IfcConstraint createIfcConstraint();

	/**
	 * Returns a new object of class '<em>Ifc Construction Equipment Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Construction Equipment Resource</em>'.
	 * @generated
	 */
	IfcConstructionEquipmentResource createIfcConstructionEquipmentResource();

	/**
	 * Returns a new object of class '<em>Ifc Construction Equipment Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Construction Equipment Resource Type</em>'.
	 * @generated
	 */
	IfcConstructionEquipmentResourceType createIfcConstructionEquipmentResourceType();

	/**
	 * Returns a new object of class '<em>Ifc Construction Material Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Construction Material Resource</em>'.
	 * @generated
	 */
	IfcConstructionMaterialResource createIfcConstructionMaterialResource();

	/**
	 * Returns a new object of class '<em>Ifc Construction Material Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Construction Material Resource Type</em>'.
	 * @generated
	 */
	IfcConstructionMaterialResourceType createIfcConstructionMaterialResourceType();

	/**
	 * Returns a new object of class '<em>Ifc Construction Product Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Construction Product Resource</em>'.
	 * @generated
	 */
	IfcConstructionProductResource createIfcConstructionProductResource();

	/**
	 * Returns a new object of class '<em>Ifc Construction Product Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Construction Product Resource Type</em>'.
	 * @generated
	 */
	IfcConstructionProductResourceType createIfcConstructionProductResourceType();

	/**
	 * Returns a new object of class '<em>Ifc Construction Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Construction Resource</em>'.
	 * @generated
	 */
	IfcConstructionResource createIfcConstructionResource();

	/**
	 * Returns a new object of class '<em>Ifc Construction Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Construction Resource Type</em>'.
	 * @generated
	 */
	IfcConstructionResourceType createIfcConstructionResourceType();

	/**
	 * Returns a new object of class '<em>Ifc Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Context</em>'.
	 * @generated
	 */
	IfcContext createIfcContext();

	/**
	 * Returns a new object of class '<em>Ifc Context Dependent Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Context Dependent Unit</em>'.
	 * @generated
	 */
	IfcContextDependentUnit createIfcContextDependentUnit();

	/**
	 * Returns a new object of class '<em>Ifc Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Control</em>'.
	 * @generated
	 */
	IfcControl createIfcControl();

	/**
	 * Returns a new object of class '<em>Ifc Controller</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Controller</em>'.
	 * @generated
	 */
	IfcController createIfcController();

	/**
	 * Returns a new object of class '<em>Ifc Controller Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Controller Type</em>'.
	 * @generated
	 */
	IfcControllerType createIfcControllerType();

	/**
	 * Returns a new object of class '<em>Ifc Conversion Based Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Conversion Based Unit</em>'.
	 * @generated
	 */
	IfcConversionBasedUnit createIfcConversionBasedUnit();

	/**
	 * Returns a new object of class '<em>Ifc Conversion Based Unit With Offset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Conversion Based Unit With Offset</em>'.
	 * @generated
	 */
	IfcConversionBasedUnitWithOffset createIfcConversionBasedUnitWithOffset();

	/**
	 * Returns a new object of class '<em>Ifc Cooled Beam</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cooled Beam</em>'.
	 * @generated
	 */
	IfcCooledBeam createIfcCooledBeam();

	/**
	 * Returns a new object of class '<em>Ifc Cooled Beam Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cooled Beam Type</em>'.
	 * @generated
	 */
	IfcCooledBeamType createIfcCooledBeamType();

	/**
	 * Returns a new object of class '<em>Ifc Cooling Tower</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cooling Tower</em>'.
	 * @generated
	 */
	IfcCoolingTower createIfcCoolingTower();

	/**
	 * Returns a new object of class '<em>Ifc Cooling Tower Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cooling Tower Type</em>'.
	 * @generated
	 */
	IfcCoolingTowerType createIfcCoolingTowerType();

	/**
	 * Returns a new object of class '<em>Ifc Coordinate Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Coordinate Operation</em>'.
	 * @generated
	 */
	IfcCoordinateOperation createIfcCoordinateOperation();

	/**
	 * Returns a new object of class '<em>Ifc Coordinate Reference System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Coordinate Reference System</em>'.
	 * @generated
	 */
	IfcCoordinateReferenceSystem createIfcCoordinateReferenceSystem();

	/**
	 * Returns a new object of class '<em>Ifc Cost Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cost Item</em>'.
	 * @generated
	 */
	IfcCostItem createIfcCostItem();

	/**
	 * Returns a new object of class '<em>Ifc Cost Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cost Schedule</em>'.
	 * @generated
	 */
	IfcCostSchedule createIfcCostSchedule();

	/**
	 * Returns a new object of class '<em>Ifc Cost Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cost Value</em>'.
	 * @generated
	 */
	IfcCostValue createIfcCostValue();

	/**
	 * Returns a new object of class '<em>Ifc Covering</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Covering</em>'.
	 * @generated
	 */
	IfcCovering createIfcCovering();

	/**
	 * Returns a new object of class '<em>Ifc Covering Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Covering Type</em>'.
	 * @generated
	 */
	IfcCoveringType createIfcCoveringType();

	/**
	 * Returns a new object of class '<em>Ifc Crew Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Crew Resource</em>'.
	 * @generated
	 */
	IfcCrewResource createIfcCrewResource();

	/**
	 * Returns a new object of class '<em>Ifc Crew Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Crew Resource Type</em>'.
	 * @generated
	 */
	IfcCrewResourceType createIfcCrewResourceType();

	/**
	 * Returns a new object of class '<em>Ifc Csg Primitive3 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Csg Primitive3 D</em>'.
	 * @generated
	 */
	IfcCsgPrimitive3D createIfcCsgPrimitive3D();

	/**
	 * Returns a new object of class '<em>Ifc Csg Solid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Csg Solid</em>'.
	 * @generated
	 */
	IfcCsgSolid createIfcCsgSolid();

	/**
	 * Returns a new object of class '<em>Ifc Currency Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Currency Relationship</em>'.
	 * @generated
	 */
	IfcCurrencyRelationship createIfcCurrencyRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Curtain Wall</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curtain Wall</em>'.
	 * @generated
	 */
	IfcCurtainWall createIfcCurtainWall();

	/**
	 * Returns a new object of class '<em>Ifc Curtain Wall Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curtain Wall Type</em>'.
	 * @generated
	 */
	IfcCurtainWallType createIfcCurtainWallType();

	/**
	 * Returns a new object of class '<em>Ifc Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curve</em>'.
	 * @generated
	 */
	IfcCurve createIfcCurve();

	/**
	 * Returns a new object of class '<em>Ifc Curve Bounded Plane</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curve Bounded Plane</em>'.
	 * @generated
	 */
	IfcCurveBoundedPlane createIfcCurveBoundedPlane();

	/**
	 * Returns a new object of class '<em>Ifc Curve Bounded Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curve Bounded Surface</em>'.
	 * @generated
	 */
	IfcCurveBoundedSurface createIfcCurveBoundedSurface();

	/**
	 * Returns a new object of class '<em>Ifc Curve Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curve Style</em>'.
	 * @generated
	 */
	IfcCurveStyle createIfcCurveStyle();

	/**
	 * Returns a new object of class '<em>Ifc Curve Style Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curve Style Font</em>'.
	 * @generated
	 */
	IfcCurveStyleFont createIfcCurveStyleFont();

	/**
	 * Returns a new object of class '<em>Ifc Curve Style Font And Scaling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curve Style Font And Scaling</em>'.
	 * @generated
	 */
	IfcCurveStyleFontAndScaling createIfcCurveStyleFontAndScaling();

	/**
	 * Returns a new object of class '<em>Ifc Curve Style Font Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curve Style Font Pattern</em>'.
	 * @generated
	 */
	IfcCurveStyleFontPattern createIfcCurveStyleFontPattern();

	/**
	 * Returns a new object of class '<em>Ifc Cylindrical Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cylindrical Surface</em>'.
	 * @generated
	 */
	IfcCylindricalSurface createIfcCylindricalSurface();

	/**
	 * Returns a new object of class '<em>Ifc Damper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Damper</em>'.
	 * @generated
	 */
	IfcDamper createIfcDamper();

	/**
	 * Returns a new object of class '<em>Ifc Damper Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Damper Type</em>'.
	 * @generated
	 */
	IfcDamperType createIfcDamperType();

	/**
	 * Returns a new object of class '<em>Ifc Derived Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Derived Profile Def</em>'.
	 * @generated
	 */
	IfcDerivedProfileDef createIfcDerivedProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Derived Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Derived Unit</em>'.
	 * @generated
	 */
	IfcDerivedUnit createIfcDerivedUnit();

	/**
	 * Returns a new object of class '<em>Ifc Derived Unit Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Derived Unit Element</em>'.
	 * @generated
	 */
	IfcDerivedUnitElement createIfcDerivedUnitElement();

	/**
	 * Returns a new object of class '<em>Ifc Dimensional Exponents</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Dimensional Exponents</em>'.
	 * @generated
	 */
	IfcDimensionalExponents createIfcDimensionalExponents();

	/**
	 * Returns a new object of class '<em>Ifc Direction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Direction</em>'.
	 * @generated
	 */
	IfcDirection createIfcDirection();

	/**
	 * Returns a new object of class '<em>Ifc Discrete Accessory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Discrete Accessory</em>'.
	 * @generated
	 */
	IfcDiscreteAccessory createIfcDiscreteAccessory();

	/**
	 * Returns a new object of class '<em>Ifc Discrete Accessory Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Discrete Accessory Type</em>'.
	 * @generated
	 */
	IfcDiscreteAccessoryType createIfcDiscreteAccessoryType();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Chamber Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Chamber Element</em>'.
	 * @generated
	 */
	IfcDistributionChamberElement createIfcDistributionChamberElement();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Chamber Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Chamber Element Type</em>'.
	 * @generated
	 */
	IfcDistributionChamberElementType createIfcDistributionChamberElementType();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Circuit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Circuit</em>'.
	 * @generated
	 */
	IfcDistributionCircuit createIfcDistributionCircuit();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Control Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Control Element</em>'.
	 * @generated
	 */
	IfcDistributionControlElement createIfcDistributionControlElement();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Control Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Control Element Type</em>'.
	 * @generated
	 */
	IfcDistributionControlElementType createIfcDistributionControlElementType();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Element</em>'.
	 * @generated
	 */
	IfcDistributionElement createIfcDistributionElement();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Element Type</em>'.
	 * @generated
	 */
	IfcDistributionElementType createIfcDistributionElementType();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Flow Element</em>'.
	 * @generated
	 */
	IfcDistributionFlowElement createIfcDistributionFlowElement();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Flow Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Flow Element Type</em>'.
	 * @generated
	 */
	IfcDistributionFlowElementType createIfcDistributionFlowElementType();

	/**
	 * Returns a new object of class '<em>Ifc Distribution Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution Port</em>'.
	 * @generated
	 */
	IfcDistributionPort createIfcDistributionPort();

	/**
	 * Returns a new object of class '<em>Ifc Distribution System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Distribution System</em>'.
	 * @generated
	 */
	IfcDistributionSystem createIfcDistributionSystem();

	/**
	 * Returns a new object of class '<em>Ifc Document Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Document Information</em>'.
	 * @generated
	 */
	IfcDocumentInformation createIfcDocumentInformation();

	/**
	 * Returns a new object of class '<em>Ifc Document Information Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Document Information Relationship</em>'.
	 * @generated
	 */
	IfcDocumentInformationRelationship createIfcDocumentInformationRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Document Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Document Reference</em>'.
	 * @generated
	 */
	IfcDocumentReference createIfcDocumentReference();

	/**
	 * Returns a new object of class '<em>Ifc Door</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Door</em>'.
	 * @generated
	 */
	IfcDoor createIfcDoor();

	/**
	 * Returns a new object of class '<em>Ifc Door Lining Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Door Lining Properties</em>'.
	 * @generated
	 */
	IfcDoorLiningProperties createIfcDoorLiningProperties();

	/**
	 * Returns a new object of class '<em>Ifc Door Panel Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Door Panel Properties</em>'.
	 * @generated
	 */
	IfcDoorPanelProperties createIfcDoorPanelProperties();

	/**
	 * Returns a new object of class '<em>Ifc Door Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Door Standard Case</em>'.
	 * @generated
	 */
	IfcDoorStandardCase createIfcDoorStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Door Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Door Style</em>'.
	 * @generated
	 */
	IfcDoorStyle createIfcDoorStyle();

	/**
	 * Returns a new object of class '<em>Ifc Door Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Door Type</em>'.
	 * @generated
	 */
	IfcDoorType createIfcDoorType();

	/**
	 * Returns a new object of class '<em>Ifc Draughting Pre Defined Colour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Draughting Pre Defined Colour</em>'.
	 * @generated
	 */
	IfcDraughtingPreDefinedColour createIfcDraughtingPreDefinedColour();

	/**
	 * Returns a new object of class '<em>Ifc Draughting Pre Defined Curve Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Draughting Pre Defined Curve Font</em>'.
	 * @generated
	 */
	IfcDraughtingPreDefinedCurveFont createIfcDraughtingPreDefinedCurveFont();

	/**
	 * Returns a new object of class '<em>Ifc Duct Fitting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Duct Fitting</em>'.
	 * @generated
	 */
	IfcDuctFitting createIfcDuctFitting();

	/**
	 * Returns a new object of class '<em>Ifc Duct Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Duct Fitting Type</em>'.
	 * @generated
	 */
	IfcDuctFittingType createIfcDuctFittingType();

	/**
	 * Returns a new object of class '<em>Ifc Duct Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Duct Segment</em>'.
	 * @generated
	 */
	IfcDuctSegment createIfcDuctSegment();

	/**
	 * Returns a new object of class '<em>Ifc Duct Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Duct Segment Type</em>'.
	 * @generated
	 */
	IfcDuctSegmentType createIfcDuctSegmentType();

	/**
	 * Returns a new object of class '<em>Ifc Duct Silencer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Duct Silencer</em>'.
	 * @generated
	 */
	IfcDuctSilencer createIfcDuctSilencer();

	/**
	 * Returns a new object of class '<em>Ifc Duct Silencer Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Duct Silencer Type</em>'.
	 * @generated
	 */
	IfcDuctSilencerType createIfcDuctSilencerType();

	/**
	 * Returns a new object of class '<em>Ifc Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Edge</em>'.
	 * @generated
	 */
	IfcEdge createIfcEdge();

	/**
	 * Returns a new object of class '<em>Ifc Edge Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Edge Curve</em>'.
	 * @generated
	 */
	IfcEdgeCurve createIfcEdgeCurve();

	/**
	 * Returns a new object of class '<em>Ifc Edge Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Edge Loop</em>'.
	 * @generated
	 */
	IfcEdgeLoop createIfcEdgeLoop();

	/**
	 * Returns a new object of class '<em>Ifc Electric Appliance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Appliance</em>'.
	 * @generated
	 */
	IfcElectricAppliance createIfcElectricAppliance();

	/**
	 * Returns a new object of class '<em>Ifc Electric Appliance Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Appliance Type</em>'.
	 * @generated
	 */
	IfcElectricApplianceType createIfcElectricApplianceType();

	/**
	 * Returns a new object of class '<em>Ifc Electric Distribution Board</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Distribution Board</em>'.
	 * @generated
	 */
	IfcElectricDistributionBoard createIfcElectricDistributionBoard();

	/**
	 * Returns a new object of class '<em>Ifc Electric Distribution Board Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Distribution Board Type</em>'.
	 * @generated
	 */
	IfcElectricDistributionBoardType createIfcElectricDistributionBoardType();

	/**
	 * Returns a new object of class '<em>Ifc Electric Flow Storage Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Flow Storage Device</em>'.
	 * @generated
	 */
	IfcElectricFlowStorageDevice createIfcElectricFlowStorageDevice();

	/**
	 * Returns a new object of class '<em>Ifc Electric Flow Storage Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Flow Storage Device Type</em>'.
	 * @generated
	 */
	IfcElectricFlowStorageDeviceType createIfcElectricFlowStorageDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Electric Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Generator</em>'.
	 * @generated
	 */
	IfcElectricGenerator createIfcElectricGenerator();

	/**
	 * Returns a new object of class '<em>Ifc Electric Generator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Generator Type</em>'.
	 * @generated
	 */
	IfcElectricGeneratorType createIfcElectricGeneratorType();

	/**
	 * Returns a new object of class '<em>Ifc Electric Motor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Motor</em>'.
	 * @generated
	 */
	IfcElectricMotor createIfcElectricMotor();

	/**
	 * Returns a new object of class '<em>Ifc Electric Motor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Motor Type</em>'.
	 * @generated
	 */
	IfcElectricMotorType createIfcElectricMotorType();

	/**
	 * Returns a new object of class '<em>Ifc Electric Time Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Time Control</em>'.
	 * @generated
	 */
	IfcElectricTimeControl createIfcElectricTimeControl();

	/**
	 * Returns a new object of class '<em>Ifc Electric Time Control Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Time Control Type</em>'.
	 * @generated
	 */
	IfcElectricTimeControlType createIfcElectricTimeControlType();

	/**
	 * Returns a new object of class '<em>Ifc Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Element</em>'.
	 * @generated
	 */
	IfcElement createIfcElement();

	/**
	 * Returns a new object of class '<em>Ifc Element Assembly</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Element Assembly</em>'.
	 * @generated
	 */
	IfcElementAssembly createIfcElementAssembly();

	/**
	 * Returns a new object of class '<em>Ifc Element Assembly Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Element Assembly Type</em>'.
	 * @generated
	 */
	IfcElementAssemblyType createIfcElementAssemblyType();

	/**
	 * Returns a new object of class '<em>Ifc Element Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Element Component</em>'.
	 * @generated
	 */
	IfcElementComponent createIfcElementComponent();

	/**
	 * Returns a new object of class '<em>Ifc Element Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Element Component Type</em>'.
	 * @generated
	 */
	IfcElementComponentType createIfcElementComponentType();

	/**
	 * Returns a new object of class '<em>Ifc Element Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Element Quantity</em>'.
	 * @generated
	 */
	IfcElementQuantity createIfcElementQuantity();

	/**
	 * Returns a new object of class '<em>Ifc Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Element Type</em>'.
	 * @generated
	 */
	IfcElementType createIfcElementType();

	/**
	 * Returns a new object of class '<em>Ifc Elementary Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Elementary Surface</em>'.
	 * @generated
	 */
	IfcElementarySurface createIfcElementarySurface();

	/**
	 * Returns a new object of class '<em>Ifc Ellipse</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Ellipse</em>'.
	 * @generated
	 */
	IfcEllipse createIfcEllipse();

	/**
	 * Returns a new object of class '<em>Ifc Ellipse Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Ellipse Profile Def</em>'.
	 * @generated
	 */
	IfcEllipseProfileDef createIfcEllipseProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Energy Conversion Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Energy Conversion Device</em>'.
	 * @generated
	 */
	IfcEnergyConversionDevice createIfcEnergyConversionDevice();

	/**
	 * Returns a new object of class '<em>Ifc Energy Conversion Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Energy Conversion Device Type</em>'.
	 * @generated
	 */
	IfcEnergyConversionDeviceType createIfcEnergyConversionDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Engine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Engine</em>'.
	 * @generated
	 */
	IfcEngine createIfcEngine();

	/**
	 * Returns a new object of class '<em>Ifc Engine Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Engine Type</em>'.
	 * @generated
	 */
	IfcEngineType createIfcEngineType();

	/**
	 * Returns a new object of class '<em>Ifc Evaporative Cooler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Evaporative Cooler</em>'.
	 * @generated
	 */
	IfcEvaporativeCooler createIfcEvaporativeCooler();

	/**
	 * Returns a new object of class '<em>Ifc Evaporative Cooler Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Evaporative Cooler Type</em>'.
	 * @generated
	 */
	IfcEvaporativeCoolerType createIfcEvaporativeCoolerType();

	/**
	 * Returns a new object of class '<em>Ifc Evaporator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Evaporator</em>'.
	 * @generated
	 */
	IfcEvaporator createIfcEvaporator();

	/**
	 * Returns a new object of class '<em>Ifc Evaporator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Evaporator Type</em>'.
	 * @generated
	 */
	IfcEvaporatorType createIfcEvaporatorType();

	/**
	 * Returns a new object of class '<em>Ifc Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Event</em>'.
	 * @generated
	 */
	IfcEvent createIfcEvent();

	/**
	 * Returns a new object of class '<em>Ifc Event Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Event Time</em>'.
	 * @generated
	 */
	IfcEventTime createIfcEventTime();

	/**
	 * Returns a new object of class '<em>Ifc Event Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Event Type</em>'.
	 * @generated
	 */
	IfcEventType createIfcEventType();

	/**
	 * Returns a new object of class '<em>Ifc Extended Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Extended Properties</em>'.
	 * @generated
	 */
	IfcExtendedProperties createIfcExtendedProperties();

	/**
	 * Returns a new object of class '<em>Ifc External Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc External Information</em>'.
	 * @generated
	 */
	IfcExternalInformation createIfcExternalInformation();

	/**
	 * Returns a new object of class '<em>Ifc External Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc External Reference</em>'.
	 * @generated
	 */
	IfcExternalReference createIfcExternalReference();

	/**
	 * Returns a new object of class '<em>Ifc External Reference Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc External Reference Relationship</em>'.
	 * @generated
	 */
	IfcExternalReferenceRelationship createIfcExternalReferenceRelationship();

	/**
	 * Returns a new object of class '<em>Ifc External Spatial Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc External Spatial Element</em>'.
	 * @generated
	 */
	IfcExternalSpatialElement createIfcExternalSpatialElement();

	/**
	 * Returns a new object of class '<em>Ifc External Spatial Structure Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc External Spatial Structure Element</em>'.
	 * @generated
	 */
	IfcExternalSpatialStructureElement createIfcExternalSpatialStructureElement();

	/**
	 * Returns a new object of class '<em>Ifc Externally Defined Hatch Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Externally Defined Hatch Style</em>'.
	 * @generated
	 */
	IfcExternallyDefinedHatchStyle createIfcExternallyDefinedHatchStyle();

	/**
	 * Returns a new object of class '<em>Ifc Externally Defined Surface Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Externally Defined Surface Style</em>'.
	 * @generated
	 */
	IfcExternallyDefinedSurfaceStyle createIfcExternallyDefinedSurfaceStyle();

	/**
	 * Returns a new object of class '<em>Ifc Externally Defined Text Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Externally Defined Text Font</em>'.
	 * @generated
	 */
	IfcExternallyDefinedTextFont createIfcExternallyDefinedTextFont();

	/**
	 * Returns a new object of class '<em>Ifc Extruded Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Extruded Area Solid</em>'.
	 * @generated
	 */
	IfcExtrudedAreaSolid createIfcExtrudedAreaSolid();

	/**
	 * Returns a new object of class '<em>Ifc Extruded Area Solid Tapered</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Extruded Area Solid Tapered</em>'.
	 * @generated
	 */
	IfcExtrudedAreaSolidTapered createIfcExtrudedAreaSolidTapered();

	/**
	 * Returns a new object of class '<em>Ifc Face</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Face</em>'.
	 * @generated
	 */
	IfcFace createIfcFace();

	/**
	 * Returns a new object of class '<em>Ifc Face Based Surface Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Face Based Surface Model</em>'.
	 * @generated
	 */
	IfcFaceBasedSurfaceModel createIfcFaceBasedSurfaceModel();

	/**
	 * Returns a new object of class '<em>Ifc Face Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Face Bound</em>'.
	 * @generated
	 */
	IfcFaceBound createIfcFaceBound();

	/**
	 * Returns a new object of class '<em>Ifc Face Outer Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Face Outer Bound</em>'.
	 * @generated
	 */
	IfcFaceOuterBound createIfcFaceOuterBound();

	/**
	 * Returns a new object of class '<em>Ifc Face Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Face Surface</em>'.
	 * @generated
	 */
	IfcFaceSurface createIfcFaceSurface();

	/**
	 * Returns a new object of class '<em>Ifc Faceted Brep</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Faceted Brep</em>'.
	 * @generated
	 */
	IfcFacetedBrep createIfcFacetedBrep();

	/**
	 * Returns a new object of class '<em>Ifc Faceted Brep With Voids</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Faceted Brep With Voids</em>'.
	 * @generated
	 */
	IfcFacetedBrepWithVoids createIfcFacetedBrepWithVoids();

	/**
	 * Returns a new object of class '<em>Ifc Failure Connection Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Failure Connection Condition</em>'.
	 * @generated
	 */
	IfcFailureConnectionCondition createIfcFailureConnectionCondition();

	/**
	 * Returns a new object of class '<em>Ifc Fan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fan</em>'.
	 * @generated
	 */
	IfcFan createIfcFan();

	/**
	 * Returns a new object of class '<em>Ifc Fan Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fan Type</em>'.
	 * @generated
	 */
	IfcFanType createIfcFanType();

	/**
	 * Returns a new object of class '<em>Ifc Fastener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fastener</em>'.
	 * @generated
	 */
	IfcFastener createIfcFastener();

	/**
	 * Returns a new object of class '<em>Ifc Fastener Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fastener Type</em>'.
	 * @generated
	 */
	IfcFastenerType createIfcFastenerType();

	/**
	 * Returns a new object of class '<em>Ifc Feature Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Feature Element</em>'.
	 * @generated
	 */
	IfcFeatureElement createIfcFeatureElement();

	/**
	 * Returns a new object of class '<em>Ifc Feature Element Addition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Feature Element Addition</em>'.
	 * @generated
	 */
	IfcFeatureElementAddition createIfcFeatureElementAddition();

	/**
	 * Returns a new object of class '<em>Ifc Feature Element Subtraction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Feature Element Subtraction</em>'.
	 * @generated
	 */
	IfcFeatureElementSubtraction createIfcFeatureElementSubtraction();

	/**
	 * Returns a new object of class '<em>Ifc Fill Area Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fill Area Style</em>'.
	 * @generated
	 */
	IfcFillAreaStyle createIfcFillAreaStyle();

	/**
	 * Returns a new object of class '<em>Ifc Fill Area Style Hatching</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fill Area Style Hatching</em>'.
	 * @generated
	 */
	IfcFillAreaStyleHatching createIfcFillAreaStyleHatching();

	/**
	 * Returns a new object of class '<em>Ifc Fill Area Style Tiles</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fill Area Style Tiles</em>'.
	 * @generated
	 */
	IfcFillAreaStyleTiles createIfcFillAreaStyleTiles();

	/**
	 * Returns a new object of class '<em>Ifc Filter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Filter</em>'.
	 * @generated
	 */
	IfcFilter createIfcFilter();

	/**
	 * Returns a new object of class '<em>Ifc Filter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Filter Type</em>'.
	 * @generated
	 */
	IfcFilterType createIfcFilterType();

	/**
	 * Returns a new object of class '<em>Ifc Fire Suppression Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fire Suppression Terminal</em>'.
	 * @generated
	 */
	IfcFireSuppressionTerminal createIfcFireSuppressionTerminal();

	/**
	 * Returns a new object of class '<em>Ifc Fire Suppression Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fire Suppression Terminal Type</em>'.
	 * @generated
	 */
	IfcFireSuppressionTerminalType createIfcFireSuppressionTerminalType();

	/**
	 * Returns a new object of class '<em>Ifc Fixed Reference Swept Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Fixed Reference Swept Area Solid</em>'.
	 * @generated
	 */
	IfcFixedReferenceSweptAreaSolid createIfcFixedReferenceSweptAreaSolid();

	/**
	 * Returns a new object of class '<em>Ifc Flow Controller</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Controller</em>'.
	 * @generated
	 */
	IfcFlowController createIfcFlowController();

	/**
	 * Returns a new object of class '<em>Ifc Flow Controller Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Controller Type</em>'.
	 * @generated
	 */
	IfcFlowControllerType createIfcFlowControllerType();

	/**
	 * Returns a new object of class '<em>Ifc Flow Fitting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Fitting</em>'.
	 * @generated
	 */
	IfcFlowFitting createIfcFlowFitting();

	/**
	 * Returns a new object of class '<em>Ifc Flow Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Fitting Type</em>'.
	 * @generated
	 */
	IfcFlowFittingType createIfcFlowFittingType();

	/**
	 * Returns a new object of class '<em>Ifc Flow Instrument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Instrument</em>'.
	 * @generated
	 */
	IfcFlowInstrument createIfcFlowInstrument();

	/**
	 * Returns a new object of class '<em>Ifc Flow Instrument Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Instrument Type</em>'.
	 * @generated
	 */
	IfcFlowInstrumentType createIfcFlowInstrumentType();

	/**
	 * Returns a new object of class '<em>Ifc Flow Meter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Meter</em>'.
	 * @generated
	 */
	IfcFlowMeter createIfcFlowMeter();

	/**
	 * Returns a new object of class '<em>Ifc Flow Meter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Meter Type</em>'.
	 * @generated
	 */
	IfcFlowMeterType createIfcFlowMeterType();

	/**
	 * Returns a new object of class '<em>Ifc Flow Moving Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Moving Device</em>'.
	 * @generated
	 */
	IfcFlowMovingDevice createIfcFlowMovingDevice();

	/**
	 * Returns a new object of class '<em>Ifc Flow Moving Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Moving Device Type</em>'.
	 * @generated
	 */
	IfcFlowMovingDeviceType createIfcFlowMovingDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Flow Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Segment</em>'.
	 * @generated
	 */
	IfcFlowSegment createIfcFlowSegment();

	/**
	 * Returns a new object of class '<em>Ifc Flow Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Segment Type</em>'.
	 * @generated
	 */
	IfcFlowSegmentType createIfcFlowSegmentType();

	/**
	 * Returns a new object of class '<em>Ifc Flow Storage Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Storage Device</em>'.
	 * @generated
	 */
	IfcFlowStorageDevice createIfcFlowStorageDevice();

	/**
	 * Returns a new object of class '<em>Ifc Flow Storage Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Storage Device Type</em>'.
	 * @generated
	 */
	IfcFlowStorageDeviceType createIfcFlowStorageDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Flow Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Terminal</em>'.
	 * @generated
	 */
	IfcFlowTerminal createIfcFlowTerminal();

	/**
	 * Returns a new object of class '<em>Ifc Flow Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Terminal Type</em>'.
	 * @generated
	 */
	IfcFlowTerminalType createIfcFlowTerminalType();

	/**
	 * Returns a new object of class '<em>Ifc Flow Treatment Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Treatment Device</em>'.
	 * @generated
	 */
	IfcFlowTreatmentDevice createIfcFlowTreatmentDevice();

	/**
	 * Returns a new object of class '<em>Ifc Flow Treatment Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Flow Treatment Device Type</em>'.
	 * @generated
	 */
	IfcFlowTreatmentDeviceType createIfcFlowTreatmentDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Footing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Footing</em>'.
	 * @generated
	 */
	IfcFooting createIfcFooting();

	/**
	 * Returns a new object of class '<em>Ifc Footing Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Footing Type</em>'.
	 * @generated
	 */
	IfcFootingType createIfcFootingType();

	/**
	 * Returns a new object of class '<em>Ifc Furnishing Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Furnishing Element</em>'.
	 * @generated
	 */
	IfcFurnishingElement createIfcFurnishingElement();

	/**
	 * Returns a new object of class '<em>Ifc Furnishing Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Furnishing Element Type</em>'.
	 * @generated
	 */
	IfcFurnishingElementType createIfcFurnishingElementType();

	/**
	 * Returns a new object of class '<em>Ifc Furniture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Furniture</em>'.
	 * @generated
	 */
	IfcFurniture createIfcFurniture();

	/**
	 * Returns a new object of class '<em>Ifc Furniture Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Furniture Type</em>'.
	 * @generated
	 */
	IfcFurnitureType createIfcFurnitureType();

	/**
	 * Returns a new object of class '<em>Ifc Geographic Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Geographic Element</em>'.
	 * @generated
	 */
	IfcGeographicElement createIfcGeographicElement();

	/**
	 * Returns a new object of class '<em>Ifc Geographic Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Geographic Element Type</em>'.
	 * @generated
	 */
	IfcGeographicElementType createIfcGeographicElementType();

	/**
	 * Returns a new object of class '<em>Ifc Geometric Curve Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Geometric Curve Set</em>'.
	 * @generated
	 */
	IfcGeometricCurveSet createIfcGeometricCurveSet();

	/**
	 * Returns a new object of class '<em>Ifc Geometric Representation Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Geometric Representation Context</em>'.
	 * @generated
	 */
	IfcGeometricRepresentationContext createIfcGeometricRepresentationContext();

	/**
	 * Returns a new object of class '<em>Ifc Geometric Representation Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Geometric Representation Item</em>'.
	 * @generated
	 */
	IfcGeometricRepresentationItem createIfcGeometricRepresentationItem();

	/**
	 * Returns a new object of class '<em>Ifc Geometric Representation Sub Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Geometric Representation Sub Context</em>'.
	 * @generated
	 */
	IfcGeometricRepresentationSubContext createIfcGeometricRepresentationSubContext();

	/**
	 * Returns a new object of class '<em>Ifc Geometric Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Geometric Set</em>'.
	 * @generated
	 */
	IfcGeometricSet createIfcGeometricSet();

	/**
	 * Returns a new object of class '<em>Ifc Grid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Grid</em>'.
	 * @generated
	 */
	IfcGrid createIfcGrid();

	/**
	 * Returns a new object of class '<em>Ifc Grid Axis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Grid Axis</em>'.
	 * @generated
	 */
	IfcGridAxis createIfcGridAxis();

	/**
	 * Returns a new object of class '<em>Ifc Grid Placement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Grid Placement</em>'.
	 * @generated
	 */
	IfcGridPlacement createIfcGridPlacement();

	/**
	 * Returns a new object of class '<em>Ifc Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Group</em>'.
	 * @generated
	 */
	IfcGroup createIfcGroup();

	/**
	 * Returns a new object of class '<em>Ifc Half Space Solid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Half Space Solid</em>'.
	 * @generated
	 */
	IfcHalfSpaceSolid createIfcHalfSpaceSolid();

	/**
	 * Returns a new object of class '<em>Ifc Heat Exchanger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Heat Exchanger</em>'.
	 * @generated
	 */
	IfcHeatExchanger createIfcHeatExchanger();

	/**
	 * Returns a new object of class '<em>Ifc Heat Exchanger Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Heat Exchanger Type</em>'.
	 * @generated
	 */
	IfcHeatExchangerType createIfcHeatExchangerType();

	/**
	 * Returns a new object of class '<em>Ifc Humidifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Humidifier</em>'.
	 * @generated
	 */
	IfcHumidifier createIfcHumidifier();

	/**
	 * Returns a new object of class '<em>Ifc Humidifier Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Humidifier Type</em>'.
	 * @generated
	 */
	IfcHumidifierType createIfcHumidifierType();

	/**
	 * Returns a new object of class '<em>Ifc IShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc IShape Profile Def</em>'.
	 * @generated
	 */
	IfcIShapeProfileDef createIfcIShapeProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Image Texture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Image Texture</em>'.
	 * @generated
	 */
	IfcImageTexture createIfcImageTexture();

	/**
	 * Returns a new object of class '<em>Ifc Indexed Colour Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Indexed Colour Map</em>'.
	 * @generated
	 */
	IfcIndexedColourMap createIfcIndexedColourMap();

	/**
	 * Returns a new object of class '<em>Ifc Indexed Poly Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Indexed Poly Curve</em>'.
	 * @generated
	 */
	IfcIndexedPolyCurve createIfcIndexedPolyCurve();

	/**
	 * Returns a new object of class '<em>Ifc Indexed Polygonal Face</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Indexed Polygonal Face</em>'.
	 * @generated
	 */
	IfcIndexedPolygonalFace createIfcIndexedPolygonalFace();

	/**
	 * Returns a new object of class '<em>Ifc Indexed Polygonal Face With Voids</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Indexed Polygonal Face With Voids</em>'.
	 * @generated
	 */
	IfcIndexedPolygonalFaceWithVoids createIfcIndexedPolygonalFaceWithVoids();

	/**
	 * Returns a new object of class '<em>Ifc Indexed Texture Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Indexed Texture Map</em>'.
	 * @generated
	 */
	IfcIndexedTextureMap createIfcIndexedTextureMap();

	/**
	 * Returns a new object of class '<em>Ifc Indexed Triangle Texture Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Indexed Triangle Texture Map</em>'.
	 * @generated
	 */
	IfcIndexedTriangleTextureMap createIfcIndexedTriangleTextureMap();

	/**
	 * Returns a new object of class '<em>Ifc Interceptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Interceptor</em>'.
	 * @generated
	 */
	IfcInterceptor createIfcInterceptor();

	/**
	 * Returns a new object of class '<em>Ifc Interceptor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Interceptor Type</em>'.
	 * @generated
	 */
	IfcInterceptorType createIfcInterceptorType();

	/**
	 * Returns a new object of class '<em>Ifc Intersection Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Intersection Curve</em>'.
	 * @generated
	 */
	IfcIntersectionCurve createIfcIntersectionCurve();

	/**
	 * Returns a new object of class '<em>Ifc Inventory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Inventory</em>'.
	 * @generated
	 */
	IfcInventory createIfcInventory();

	/**
	 * Returns a new object of class '<em>Ifc Irregular Time Series</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Irregular Time Series</em>'.
	 * @generated
	 */
	IfcIrregularTimeSeries createIfcIrregularTimeSeries();

	/**
	 * Returns a new object of class '<em>Ifc Irregular Time Series Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Irregular Time Series Value</em>'.
	 * @generated
	 */
	IfcIrregularTimeSeriesValue createIfcIrregularTimeSeriesValue();

	/**
	 * Returns a new object of class '<em>Ifc Junction Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Junction Box</em>'.
	 * @generated
	 */
	IfcJunctionBox createIfcJunctionBox();

	/**
	 * Returns a new object of class '<em>Ifc Junction Box Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Junction Box Type</em>'.
	 * @generated
	 */
	IfcJunctionBoxType createIfcJunctionBoxType();

	/**
	 * Returns a new object of class '<em>Ifc LShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc LShape Profile Def</em>'.
	 * @generated
	 */
	IfcLShapeProfileDef createIfcLShapeProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Labor Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Labor Resource</em>'.
	 * @generated
	 */
	IfcLaborResource createIfcLaborResource();

	/**
	 * Returns a new object of class '<em>Ifc Labor Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Labor Resource Type</em>'.
	 * @generated
	 */
	IfcLaborResourceType createIfcLaborResourceType();

	/**
	 * Returns a new object of class '<em>Ifc Lag Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Lag Time</em>'.
	 * @generated
	 */
	IfcLagTime createIfcLagTime();

	/**
	 * Returns a new object of class '<em>Ifc Lamp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Lamp</em>'.
	 * @generated
	 */
	IfcLamp createIfcLamp();

	/**
	 * Returns a new object of class '<em>Ifc Lamp Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Lamp Type</em>'.
	 * @generated
	 */
	IfcLampType createIfcLampType();

	/**
	 * Returns a new object of class '<em>Ifc Library Information</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Library Information</em>'.
	 * @generated
	 */
	IfcLibraryInformation createIfcLibraryInformation();

	/**
	 * Returns a new object of class '<em>Ifc Library Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Library Reference</em>'.
	 * @generated
	 */
	IfcLibraryReference createIfcLibraryReference();

	/**
	 * Returns a new object of class '<em>Ifc Light Distribution Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Distribution Data</em>'.
	 * @generated
	 */
	IfcLightDistributionData createIfcLightDistributionData();

	/**
	 * Returns a new object of class '<em>Ifc Light Fixture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Fixture</em>'.
	 * @generated
	 */
	IfcLightFixture createIfcLightFixture();

	/**
	 * Returns a new object of class '<em>Ifc Light Fixture Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Fixture Type</em>'.
	 * @generated
	 */
	IfcLightFixtureType createIfcLightFixtureType();

	/**
	 * Returns a new object of class '<em>Ifc Light Intensity Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Intensity Distribution</em>'.
	 * @generated
	 */
	IfcLightIntensityDistribution createIfcLightIntensityDistribution();

	/**
	 * Returns a new object of class '<em>Ifc Light Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Source</em>'.
	 * @generated
	 */
	IfcLightSource createIfcLightSource();

	/**
	 * Returns a new object of class '<em>Ifc Light Source Ambient</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Source Ambient</em>'.
	 * @generated
	 */
	IfcLightSourceAmbient createIfcLightSourceAmbient();

	/**
	 * Returns a new object of class '<em>Ifc Light Source Directional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Source Directional</em>'.
	 * @generated
	 */
	IfcLightSourceDirectional createIfcLightSourceDirectional();

	/**
	 * Returns a new object of class '<em>Ifc Light Source Goniometric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Source Goniometric</em>'.
	 * @generated
	 */
	IfcLightSourceGoniometric createIfcLightSourceGoniometric();

	/**
	 * Returns a new object of class '<em>Ifc Light Source Positional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Source Positional</em>'.
	 * @generated
	 */
	IfcLightSourcePositional createIfcLightSourcePositional();

	/**
	 * Returns a new object of class '<em>Ifc Light Source Spot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Light Source Spot</em>'.
	 * @generated
	 */
	IfcLightSourceSpot createIfcLightSourceSpot();

	/**
	 * Returns a new object of class '<em>Ifc Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Line</em>'.
	 * @generated
	 */
	IfcLine createIfcLine();

	/**
	 * Returns a new object of class '<em>Ifc Local Placement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Local Placement</em>'.
	 * @generated
	 */
	IfcLocalPlacement createIfcLocalPlacement();

	/**
	 * Returns a new object of class '<em>Ifc Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Loop</em>'.
	 * @generated
	 */
	IfcLoop createIfcLoop();

	/**
	 * Returns a new object of class '<em>Ifc Manifold Solid Brep</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Manifold Solid Brep</em>'.
	 * @generated
	 */
	IfcManifoldSolidBrep createIfcManifoldSolidBrep();

	/**
	 * Returns a new object of class '<em>Ifc Map Conversion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Map Conversion</em>'.
	 * @generated
	 */
	IfcMapConversion createIfcMapConversion();

	/**
	 * Returns a new object of class '<em>Ifc Mapped Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Mapped Item</em>'.
	 * @generated
	 */
	IfcMappedItem createIfcMappedItem();

	/**
	 * Returns a new object of class '<em>Ifc Material</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material</em>'.
	 * @generated
	 */
	IfcMaterial createIfcMaterial();

	/**
	 * Returns a new object of class '<em>Ifc Material Classification Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Classification Relationship</em>'.
	 * @generated
	 */
	IfcMaterialClassificationRelationship createIfcMaterialClassificationRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Material Constituent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Constituent</em>'.
	 * @generated
	 */
	IfcMaterialConstituent createIfcMaterialConstituent();

	/**
	 * Returns a new object of class '<em>Ifc Material Constituent Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Constituent Set</em>'.
	 * @generated
	 */
	IfcMaterialConstituentSet createIfcMaterialConstituentSet();

	/**
	 * Returns a new object of class '<em>Ifc Material Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Definition</em>'.
	 * @generated
	 */
	IfcMaterialDefinition createIfcMaterialDefinition();

	/**
	 * Returns a new object of class '<em>Ifc Material Definition Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Definition Representation</em>'.
	 * @generated
	 */
	IfcMaterialDefinitionRepresentation createIfcMaterialDefinitionRepresentation();

	/**
	 * Returns a new object of class '<em>Ifc Material Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Layer</em>'.
	 * @generated
	 */
	IfcMaterialLayer createIfcMaterialLayer();

	/**
	 * Returns a new object of class '<em>Ifc Material Layer Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Layer Set</em>'.
	 * @generated
	 */
	IfcMaterialLayerSet createIfcMaterialLayerSet();

	/**
	 * Returns a new object of class '<em>Ifc Material Layer Set Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Layer Set Usage</em>'.
	 * @generated
	 */
	IfcMaterialLayerSetUsage createIfcMaterialLayerSetUsage();

	/**
	 * Returns a new object of class '<em>Ifc Material Layer With Offsets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Layer With Offsets</em>'.
	 * @generated
	 */
	IfcMaterialLayerWithOffsets createIfcMaterialLayerWithOffsets();

	/**
	 * Returns a new object of class '<em>Ifc Material List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material List</em>'.
	 * @generated
	 */
	IfcMaterialList createIfcMaterialList();

	/**
	 * Returns a new object of class '<em>Ifc Material Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Profile</em>'.
	 * @generated
	 */
	IfcMaterialProfile createIfcMaterialProfile();

	/**
	 * Returns a new object of class '<em>Ifc Material Profile Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Profile Set</em>'.
	 * @generated
	 */
	IfcMaterialProfileSet createIfcMaterialProfileSet();

	/**
	 * Returns a new object of class '<em>Ifc Material Profile Set Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Profile Set Usage</em>'.
	 * @generated
	 */
	IfcMaterialProfileSetUsage createIfcMaterialProfileSetUsage();

	/**
	 * Returns a new object of class '<em>Ifc Material Profile Set Usage Tapering</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Profile Set Usage Tapering</em>'.
	 * @generated
	 */
	IfcMaterialProfileSetUsageTapering createIfcMaterialProfileSetUsageTapering();

	/**
	 * Returns a new object of class '<em>Ifc Material Profile With Offsets</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Profile With Offsets</em>'.
	 * @generated
	 */
	IfcMaterialProfileWithOffsets createIfcMaterialProfileWithOffsets();

	/**
	 * Returns a new object of class '<em>Ifc Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Properties</em>'.
	 * @generated
	 */
	IfcMaterialProperties createIfcMaterialProperties();

	/**
	 * Returns a new object of class '<em>Ifc Material Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Relationship</em>'.
	 * @generated
	 */
	IfcMaterialRelationship createIfcMaterialRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Material Usage Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Material Usage Definition</em>'.
	 * @generated
	 */
	IfcMaterialUsageDefinition createIfcMaterialUsageDefinition();

	/**
	 * Returns a new object of class '<em>Ifc Measure With Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Measure With Unit</em>'.
	 * @generated
	 */
	IfcMeasureWithUnit createIfcMeasureWithUnit();

	/**
	 * Returns a new object of class '<em>Ifc Mechanical Fastener</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Mechanical Fastener</em>'.
	 * @generated
	 */
	IfcMechanicalFastener createIfcMechanicalFastener();

	/**
	 * Returns a new object of class '<em>Ifc Mechanical Fastener Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Mechanical Fastener Type</em>'.
	 * @generated
	 */
	IfcMechanicalFastenerType createIfcMechanicalFastenerType();

	/**
	 * Returns a new object of class '<em>Ifc Medical Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Medical Device</em>'.
	 * @generated
	 */
	IfcMedicalDevice createIfcMedicalDevice();

	/**
	 * Returns a new object of class '<em>Ifc Medical Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Medical Device Type</em>'.
	 * @generated
	 */
	IfcMedicalDeviceType createIfcMedicalDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Member</em>'.
	 * @generated
	 */
	IfcMember createIfcMember();

	/**
	 * Returns a new object of class '<em>Ifc Member Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Member Standard Case</em>'.
	 * @generated
	 */
	IfcMemberStandardCase createIfcMemberStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Member Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Member Type</em>'.
	 * @generated
	 */
	IfcMemberType createIfcMemberType();

	/**
	 * Returns a new object of class '<em>Ifc Metric</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Metric</em>'.
	 * @generated
	 */
	IfcMetric createIfcMetric();

	/**
	 * Returns a new object of class '<em>Ifc Mirrored Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Mirrored Profile Def</em>'.
	 * @generated
	 */
	IfcMirroredProfileDef createIfcMirroredProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Monetary Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Monetary Unit</em>'.
	 * @generated
	 */
	IfcMonetaryUnit createIfcMonetaryUnit();

	/**
	 * Returns a new object of class '<em>Ifc Motor Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Motor Connection</em>'.
	 * @generated
	 */
	IfcMotorConnection createIfcMotorConnection();

	/**
	 * Returns a new object of class '<em>Ifc Motor Connection Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Motor Connection Type</em>'.
	 * @generated
	 */
	IfcMotorConnectionType createIfcMotorConnectionType();

	/**
	 * Returns a new object of class '<em>Ifc Named Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Named Unit</em>'.
	 * @generated
	 */
	IfcNamedUnit createIfcNamedUnit();

	/**
	 * Returns a new object of class '<em>Ifc Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Object</em>'.
	 * @generated
	 */
	IfcObject createIfcObject();

	/**
	 * Returns a new object of class '<em>Ifc Object Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Object Definition</em>'.
	 * @generated
	 */
	IfcObjectDefinition createIfcObjectDefinition();

	/**
	 * Returns a new object of class '<em>Ifc Object Placement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Object Placement</em>'.
	 * @generated
	 */
	IfcObjectPlacement createIfcObjectPlacement();

	/**
	 * Returns a new object of class '<em>Ifc Objective</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Objective</em>'.
	 * @generated
	 */
	IfcObjective createIfcObjective();

	/**
	 * Returns a new object of class '<em>Ifc Occupant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Occupant</em>'.
	 * @generated
	 */
	IfcOccupant createIfcOccupant();

	/**
	 * Returns a new object of class '<em>Ifc Offset Curve2 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Offset Curve2 D</em>'.
	 * @generated
	 */
	IfcOffsetCurve2D createIfcOffsetCurve2D();

	/**
	 * Returns a new object of class '<em>Ifc Offset Curve3 D</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Offset Curve3 D</em>'.
	 * @generated
	 */
	IfcOffsetCurve3D createIfcOffsetCurve3D();

	/**
	 * Returns a new object of class '<em>Ifc Open Shell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Open Shell</em>'.
	 * @generated
	 */
	IfcOpenShell createIfcOpenShell();

	/**
	 * Returns a new object of class '<em>Ifc Opening Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Opening Element</em>'.
	 * @generated
	 */
	IfcOpeningElement createIfcOpeningElement();

	/**
	 * Returns a new object of class '<em>Ifc Opening Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Opening Standard Case</em>'.
	 * @generated
	 */
	IfcOpeningStandardCase createIfcOpeningStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Organization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Organization</em>'.
	 * @generated
	 */
	IfcOrganization createIfcOrganization();

	/**
	 * Returns a new object of class '<em>Ifc Organization Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Organization Relationship</em>'.
	 * @generated
	 */
	IfcOrganizationRelationship createIfcOrganizationRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Oriented Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Oriented Edge</em>'.
	 * @generated
	 */
	IfcOrientedEdge createIfcOrientedEdge();

	/**
	 * Returns a new object of class '<em>Ifc Outer Boundary Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Outer Boundary Curve</em>'.
	 * @generated
	 */
	IfcOuterBoundaryCurve createIfcOuterBoundaryCurve();

	/**
	 * Returns a new object of class '<em>Ifc Outlet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Outlet</em>'.
	 * @generated
	 */
	IfcOutlet createIfcOutlet();

	/**
	 * Returns a new object of class '<em>Ifc Outlet Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Outlet Type</em>'.
	 * @generated
	 */
	IfcOutletType createIfcOutletType();

	/**
	 * Returns a new object of class '<em>Ifc Owner History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Owner History</em>'.
	 * @generated
	 */
	IfcOwnerHistory createIfcOwnerHistory();

	/**
	 * Returns a new object of class '<em>Ifc Parameterized Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Parameterized Profile Def</em>'.
	 * @generated
	 */
	IfcParameterizedProfileDef createIfcParameterizedProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Path</em>'.
	 * @generated
	 */
	IfcPath createIfcPath();

	/**
	 * Returns a new object of class '<em>Ifc Pcurve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pcurve</em>'.
	 * @generated
	 */
	IfcPcurve createIfcPcurve();

	/**
	 * Returns a new object of class '<em>Ifc Performance History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Performance History</em>'.
	 * @generated
	 */
	IfcPerformanceHistory createIfcPerformanceHistory();

	/**
	 * Returns a new object of class '<em>Ifc Permeable Covering Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Permeable Covering Properties</em>'.
	 * @generated
	 */
	IfcPermeableCoveringProperties createIfcPermeableCoveringProperties();

	/**
	 * Returns a new object of class '<em>Ifc Permit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Permit</em>'.
	 * @generated
	 */
	IfcPermit createIfcPermit();

	/**
	 * Returns a new object of class '<em>Ifc Person</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Person</em>'.
	 * @generated
	 */
	IfcPerson createIfcPerson();

	/**
	 * Returns a new object of class '<em>Ifc Person And Organization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Person And Organization</em>'.
	 * @generated
	 */
	IfcPersonAndOrganization createIfcPersonAndOrganization();

	/**
	 * Returns a new object of class '<em>Ifc Physical Complex Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Physical Complex Quantity</em>'.
	 * @generated
	 */
	IfcPhysicalComplexQuantity createIfcPhysicalComplexQuantity();

	/**
	 * Returns a new object of class '<em>Ifc Physical Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Physical Quantity</em>'.
	 * @generated
	 */
	IfcPhysicalQuantity createIfcPhysicalQuantity();

	/**
	 * Returns a new object of class '<em>Ifc Physical Simple Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Physical Simple Quantity</em>'.
	 * @generated
	 */
	IfcPhysicalSimpleQuantity createIfcPhysicalSimpleQuantity();

	/**
	 * Returns a new object of class '<em>Ifc Pile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pile</em>'.
	 * @generated
	 */
	IfcPile createIfcPile();

	/**
	 * Returns a new object of class '<em>Ifc Pile Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pile Type</em>'.
	 * @generated
	 */
	IfcPileType createIfcPileType();

	/**
	 * Returns a new object of class '<em>Ifc Pipe Fitting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pipe Fitting</em>'.
	 * @generated
	 */
	IfcPipeFitting createIfcPipeFitting();

	/**
	 * Returns a new object of class '<em>Ifc Pipe Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pipe Fitting Type</em>'.
	 * @generated
	 */
	IfcPipeFittingType createIfcPipeFittingType();

	/**
	 * Returns a new object of class '<em>Ifc Pipe Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pipe Segment</em>'.
	 * @generated
	 */
	IfcPipeSegment createIfcPipeSegment();

	/**
	 * Returns a new object of class '<em>Ifc Pipe Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pipe Segment Type</em>'.
	 * @generated
	 */
	IfcPipeSegmentType createIfcPipeSegmentType();

	/**
	 * Returns a new object of class '<em>Ifc Pixel Texture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pixel Texture</em>'.
	 * @generated
	 */
	IfcPixelTexture createIfcPixelTexture();

	/**
	 * Returns a new object of class '<em>Ifc Placement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Placement</em>'.
	 * @generated
	 */
	IfcPlacement createIfcPlacement();

	/**
	 * Returns a new object of class '<em>Ifc Planar Box</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Planar Box</em>'.
	 * @generated
	 */
	IfcPlanarBox createIfcPlanarBox();

	/**
	 * Returns a new object of class '<em>Ifc Planar Extent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Planar Extent</em>'.
	 * @generated
	 */
	IfcPlanarExtent createIfcPlanarExtent();

	/**
	 * Returns a new object of class '<em>Ifc Plane</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Plane</em>'.
	 * @generated
	 */
	IfcPlane createIfcPlane();

	/**
	 * Returns a new object of class '<em>Ifc Plate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Plate</em>'.
	 * @generated
	 */
	IfcPlate createIfcPlate();

	/**
	 * Returns a new object of class '<em>Ifc Plate Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Plate Standard Case</em>'.
	 * @generated
	 */
	IfcPlateStandardCase createIfcPlateStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Plate Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Plate Type</em>'.
	 * @generated
	 */
	IfcPlateType createIfcPlateType();

	/**
	 * Returns a new object of class '<em>Ifc Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Point</em>'.
	 * @generated
	 */
	IfcPoint createIfcPoint();

	/**
	 * Returns a new object of class '<em>Ifc Point On Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Point On Curve</em>'.
	 * @generated
	 */
	IfcPointOnCurve createIfcPointOnCurve();

	/**
	 * Returns a new object of class '<em>Ifc Point On Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Point On Surface</em>'.
	 * @generated
	 */
	IfcPointOnSurface createIfcPointOnSurface();

	/**
	 * Returns a new object of class '<em>Ifc Poly Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Poly Loop</em>'.
	 * @generated
	 */
	IfcPolyLoop createIfcPolyLoop();

	/**
	 * Returns a new object of class '<em>Ifc Polygonal Bounded Half Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Polygonal Bounded Half Space</em>'.
	 * @generated
	 */
	IfcPolygonalBoundedHalfSpace createIfcPolygonalBoundedHalfSpace();

	/**
	 * Returns a new object of class '<em>Ifc Polygonal Face Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Polygonal Face Set</em>'.
	 * @generated
	 */
	IfcPolygonalFaceSet createIfcPolygonalFaceSet();

	/**
	 * Returns a new object of class '<em>Ifc Polyline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Polyline</em>'.
	 * @generated
	 */
	IfcPolyline createIfcPolyline();

	/**
	 * Returns a new object of class '<em>Ifc Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Port</em>'.
	 * @generated
	 */
	IfcPort createIfcPort();

	/**
	 * Returns a new object of class '<em>Ifc Postal Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Postal Address</em>'.
	 * @generated
	 */
	IfcPostalAddress createIfcPostalAddress();

	/**
	 * Returns a new object of class '<em>Ifc Pre Defined Colour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pre Defined Colour</em>'.
	 * @generated
	 */
	IfcPreDefinedColour createIfcPreDefinedColour();

	/**
	 * Returns a new object of class '<em>Ifc Pre Defined Curve Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pre Defined Curve Font</em>'.
	 * @generated
	 */
	IfcPreDefinedCurveFont createIfcPreDefinedCurveFont();

	/**
	 * Returns a new object of class '<em>Ifc Pre Defined Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pre Defined Item</em>'.
	 * @generated
	 */
	IfcPreDefinedItem createIfcPreDefinedItem();

	/**
	 * Returns a new object of class '<em>Ifc Pre Defined Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pre Defined Properties</em>'.
	 * @generated
	 */
	IfcPreDefinedProperties createIfcPreDefinedProperties();

	/**
	 * Returns a new object of class '<em>Ifc Pre Defined Property Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pre Defined Property Set</em>'.
	 * @generated
	 */
	IfcPreDefinedPropertySet createIfcPreDefinedPropertySet();

	/**
	 * Returns a new object of class '<em>Ifc Pre Defined Text Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pre Defined Text Font</em>'.
	 * @generated
	 */
	IfcPreDefinedTextFont createIfcPreDefinedTextFont();

	/**
	 * Returns a new object of class '<em>Ifc Presentation Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Presentation Item</em>'.
	 * @generated
	 */
	IfcPresentationItem createIfcPresentationItem();

	/**
	 * Returns a new object of class '<em>Ifc Presentation Layer Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Presentation Layer Assignment</em>'.
	 * @generated
	 */
	IfcPresentationLayerAssignment createIfcPresentationLayerAssignment();

	/**
	 * Returns a new object of class '<em>Ifc Presentation Layer With Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Presentation Layer With Style</em>'.
	 * @generated
	 */
	IfcPresentationLayerWithStyle createIfcPresentationLayerWithStyle();

	/**
	 * Returns a new object of class '<em>Ifc Presentation Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Presentation Style</em>'.
	 * @generated
	 */
	IfcPresentationStyle createIfcPresentationStyle();

	/**
	 * Returns a new object of class '<em>Ifc Presentation Style Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Presentation Style Assignment</em>'.
	 * @generated
	 */
	IfcPresentationStyleAssignment createIfcPresentationStyleAssignment();

	/**
	 * Returns a new object of class '<em>Ifc Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Procedure</em>'.
	 * @generated
	 */
	IfcProcedure createIfcProcedure();

	/**
	 * Returns a new object of class '<em>Ifc Procedure Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Procedure Type</em>'.
	 * @generated
	 */
	IfcProcedureType createIfcProcedureType();

	/**
	 * Returns a new object of class '<em>Ifc Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Process</em>'.
	 * @generated
	 */
	IfcProcess createIfcProcess();

	/**
	 * Returns a new object of class '<em>Ifc Product</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Product</em>'.
	 * @generated
	 */
	IfcProduct createIfcProduct();

	/**
	 * Returns a new object of class '<em>Ifc Product Definition Shape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Product Definition Shape</em>'.
	 * @generated
	 */
	IfcProductDefinitionShape createIfcProductDefinitionShape();

	/**
	 * Returns a new object of class '<em>Ifc Product Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Product Representation</em>'.
	 * @generated
	 */
	IfcProductRepresentation createIfcProductRepresentation();

	/**
	 * Returns a new object of class '<em>Ifc Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Profile Def</em>'.
	 * @generated
	 */
	IfcProfileDef createIfcProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Profile Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Profile Properties</em>'.
	 * @generated
	 */
	IfcProfileProperties createIfcProfileProperties();

	/**
	 * Returns a new object of class '<em>Ifc Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Project</em>'.
	 * @generated
	 */
	IfcProject createIfcProject();

	/**
	 * Returns a new object of class '<em>Ifc Project Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Project Library</em>'.
	 * @generated
	 */
	IfcProjectLibrary createIfcProjectLibrary();

	/**
	 * Returns a new object of class '<em>Ifc Project Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Project Order</em>'.
	 * @generated
	 */
	IfcProjectOrder createIfcProjectOrder();

	/**
	 * Returns a new object of class '<em>Ifc Projected CRS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Projected CRS</em>'.
	 * @generated
	 */
	IfcProjectedCRS createIfcProjectedCRS();

	/**
	 * Returns a new object of class '<em>Ifc Projection Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Projection Element</em>'.
	 * @generated
	 */
	IfcProjectionElement createIfcProjectionElement();

	/**
	 * Returns a new object of class '<em>Ifc Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property</em>'.
	 * @generated
	 */
	IfcProperty createIfcProperty();

	/**
	 * Returns a new object of class '<em>Ifc Property Abstraction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Abstraction</em>'.
	 * @generated
	 */
	IfcPropertyAbstraction createIfcPropertyAbstraction();

	/**
	 * Returns a new object of class '<em>Ifc Property Bounded Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Bounded Value</em>'.
	 * @generated
	 */
	IfcPropertyBoundedValue createIfcPropertyBoundedValue();

	/**
	 * Returns a new object of class '<em>Ifc Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Definition</em>'.
	 * @generated
	 */
	IfcPropertyDefinition createIfcPropertyDefinition();

	/**
	 * Returns a new object of class '<em>Ifc Property Dependency Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Dependency Relationship</em>'.
	 * @generated
	 */
	IfcPropertyDependencyRelationship createIfcPropertyDependencyRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Property Enumerated Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Enumerated Value</em>'.
	 * @generated
	 */
	IfcPropertyEnumeratedValue createIfcPropertyEnumeratedValue();

	/**
	 * Returns a new object of class '<em>Ifc Property Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Enumeration</em>'.
	 * @generated
	 */
	IfcPropertyEnumeration createIfcPropertyEnumeration();

	/**
	 * Returns a new object of class '<em>Ifc Property List Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property List Value</em>'.
	 * @generated
	 */
	IfcPropertyListValue createIfcPropertyListValue();

	/**
	 * Returns a new object of class '<em>Ifc Property Reference Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Reference Value</em>'.
	 * @generated
	 */
	IfcPropertyReferenceValue createIfcPropertyReferenceValue();

	/**
	 * Returns a new object of class '<em>Ifc Property Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Set</em>'.
	 * @generated
	 */
	IfcPropertySet createIfcPropertySet();

	/**
	 * Returns a new object of class '<em>Ifc Property Set Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Set Definition</em>'.
	 * @generated
	 */
	IfcPropertySetDefinition createIfcPropertySetDefinition();

	/**
	 * Returns a new object of class '<em>Ifc Property Set Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Set Template</em>'.
	 * @generated
	 */
	IfcPropertySetTemplate createIfcPropertySetTemplate();

	/**
	 * Returns a new object of class '<em>Ifc Property Single Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Single Value</em>'.
	 * @generated
	 */
	IfcPropertySingleValue createIfcPropertySingleValue();

	/**
	 * Returns a new object of class '<em>Ifc Property Table Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Table Value</em>'.
	 * @generated
	 */
	IfcPropertyTableValue createIfcPropertyTableValue();

	/**
	 * Returns a new object of class '<em>Ifc Property Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Template</em>'.
	 * @generated
	 */
	IfcPropertyTemplate createIfcPropertyTemplate();

	/**
	 * Returns a new object of class '<em>Ifc Property Template Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Property Template Definition</em>'.
	 * @generated
	 */
	IfcPropertyTemplateDefinition createIfcPropertyTemplateDefinition();

	/**
	 * Returns a new object of class '<em>Ifc Protective Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Protective Device</em>'.
	 * @generated
	 */
	IfcProtectiveDevice createIfcProtectiveDevice();

	/**
	 * Returns a new object of class '<em>Ifc Protective Device Tripping Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Protective Device Tripping Unit</em>'.
	 * @generated
	 */
	IfcProtectiveDeviceTrippingUnit createIfcProtectiveDeviceTrippingUnit();

	/**
	 * Returns a new object of class '<em>Ifc Protective Device Tripping Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Protective Device Tripping Unit Type</em>'.
	 * @generated
	 */
	IfcProtectiveDeviceTrippingUnitType createIfcProtectiveDeviceTrippingUnitType();

	/**
	 * Returns a new object of class '<em>Ifc Protective Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Protective Device Type</em>'.
	 * @generated
	 */
	IfcProtectiveDeviceType createIfcProtectiveDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Proxy</em>'.
	 * @generated
	 */
	IfcProxy createIfcProxy();

	/**
	 * Returns a new object of class '<em>Ifc Pump</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pump</em>'.
	 * @generated
	 */
	IfcPump createIfcPump();

	/**
	 * Returns a new object of class '<em>Ifc Pump Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pump Type</em>'.
	 * @generated
	 */
	IfcPumpType createIfcPumpType();

	/**
	 * Returns a new object of class '<em>Ifc Quantity Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Quantity Area</em>'.
	 * @generated
	 */
	IfcQuantityArea createIfcQuantityArea();

	/**
	 * Returns a new object of class '<em>Ifc Quantity Count</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Quantity Count</em>'.
	 * @generated
	 */
	IfcQuantityCount createIfcQuantityCount();

	/**
	 * Returns a new object of class '<em>Ifc Quantity Length</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Quantity Length</em>'.
	 * @generated
	 */
	IfcQuantityLength createIfcQuantityLength();

	/**
	 * Returns a new object of class '<em>Ifc Quantity Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Quantity Set</em>'.
	 * @generated
	 */
	IfcQuantitySet createIfcQuantitySet();

	/**
	 * Returns a new object of class '<em>Ifc Quantity Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Quantity Time</em>'.
	 * @generated
	 */
	IfcQuantityTime createIfcQuantityTime();

	/**
	 * Returns a new object of class '<em>Ifc Quantity Volume</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Quantity Volume</em>'.
	 * @generated
	 */
	IfcQuantityVolume createIfcQuantityVolume();

	/**
	 * Returns a new object of class '<em>Ifc Quantity Weight</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Quantity Weight</em>'.
	 * @generated
	 */
	IfcQuantityWeight createIfcQuantityWeight();

	/**
	 * Returns a new object of class '<em>Ifc Railing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Railing</em>'.
	 * @generated
	 */
	IfcRailing createIfcRailing();

	/**
	 * Returns a new object of class '<em>Ifc Railing Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Railing Type</em>'.
	 * @generated
	 */
	IfcRailingType createIfcRailingType();

	/**
	 * Returns a new object of class '<em>Ifc Ramp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Ramp</em>'.
	 * @generated
	 */
	IfcRamp createIfcRamp();

	/**
	 * Returns a new object of class '<em>Ifc Ramp Flight</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Ramp Flight</em>'.
	 * @generated
	 */
	IfcRampFlight createIfcRampFlight();

	/**
	 * Returns a new object of class '<em>Ifc Ramp Flight Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Ramp Flight Type</em>'.
	 * @generated
	 */
	IfcRampFlightType createIfcRampFlightType();

	/**
	 * Returns a new object of class '<em>Ifc Ramp Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Ramp Type</em>'.
	 * @generated
	 */
	IfcRampType createIfcRampType();

	/**
	 * Returns a new object of class '<em>Ifc Rational BSpline Curve With Knots</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rational BSpline Curve With Knots</em>'.
	 * @generated
	 */
	IfcRationalBSplineCurveWithKnots createIfcRationalBSplineCurveWithKnots();

	/**
	 * Returns a new object of class '<em>Ifc Rational BSpline Surface With Knots</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rational BSpline Surface With Knots</em>'.
	 * @generated
	 */
	IfcRationalBSplineSurfaceWithKnots createIfcRationalBSplineSurfaceWithKnots();

	/**
	 * Returns a new object of class '<em>Ifc Rectangle Hollow Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rectangle Hollow Profile Def</em>'.
	 * @generated
	 */
	IfcRectangleHollowProfileDef createIfcRectangleHollowProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Rectangle Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rectangle Profile Def</em>'.
	 * @generated
	 */
	IfcRectangleProfileDef createIfcRectangleProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Rectangular Pyramid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rectangular Pyramid</em>'.
	 * @generated
	 */
	IfcRectangularPyramid createIfcRectangularPyramid();

	/**
	 * Returns a new object of class '<em>Ifc Rectangular Trimmed Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rectangular Trimmed Surface</em>'.
	 * @generated
	 */
	IfcRectangularTrimmedSurface createIfcRectangularTrimmedSurface();

	/**
	 * Returns a new object of class '<em>Ifc Recurrence Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Recurrence Pattern</em>'.
	 * @generated
	 */
	IfcRecurrencePattern createIfcRecurrencePattern();

	/**
	 * Returns a new object of class '<em>Ifc Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reference</em>'.
	 * @generated
	 */
	IfcReference createIfcReference();

	/**
	 * Returns a new object of class '<em>Ifc Regular Time Series</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Regular Time Series</em>'.
	 * @generated
	 */
	IfcRegularTimeSeries createIfcRegularTimeSeries();

	/**
	 * Returns a new object of class '<em>Ifc Reinforcement Bar Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reinforcement Bar Properties</em>'.
	 * @generated
	 */
	IfcReinforcementBarProperties createIfcReinforcementBarProperties();

	/**
	 * Returns a new object of class '<em>Ifc Reinforcement Definition Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reinforcement Definition Properties</em>'.
	 * @generated
	 */
	IfcReinforcementDefinitionProperties createIfcReinforcementDefinitionProperties();

	/**
	 * Returns a new object of class '<em>Ifc Reinforcing Bar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reinforcing Bar</em>'.
	 * @generated
	 */
	IfcReinforcingBar createIfcReinforcingBar();

	/**
	 * Returns a new object of class '<em>Ifc Reinforcing Bar Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reinforcing Bar Type</em>'.
	 * @generated
	 */
	IfcReinforcingBarType createIfcReinforcingBarType();

	/**
	 * Returns a new object of class '<em>Ifc Reinforcing Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reinforcing Element</em>'.
	 * @generated
	 */
	IfcReinforcingElement createIfcReinforcingElement();

	/**
	 * Returns a new object of class '<em>Ifc Reinforcing Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reinforcing Element Type</em>'.
	 * @generated
	 */
	IfcReinforcingElementType createIfcReinforcingElementType();

	/**
	 * Returns a new object of class '<em>Ifc Reinforcing Mesh</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reinforcing Mesh</em>'.
	 * @generated
	 */
	IfcReinforcingMesh createIfcReinforcingMesh();

	/**
	 * Returns a new object of class '<em>Ifc Reinforcing Mesh Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reinforcing Mesh Type</em>'.
	 * @generated
	 */
	IfcReinforcingMeshType createIfcReinforcingMeshType();

	/**
	 * Returns a new object of class '<em>Ifc Rel Aggregates</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Aggregates</em>'.
	 * @generated
	 */
	IfcRelAggregates createIfcRelAggregates();

	/**
	 * Returns a new object of class '<em>Ifc Rel Assigns</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Assigns</em>'.
	 * @generated
	 */
	IfcRelAssigns createIfcRelAssigns();

	/**
	 * Returns a new object of class '<em>Ifc Rel Assigns To Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Assigns To Actor</em>'.
	 * @generated
	 */
	IfcRelAssignsToActor createIfcRelAssignsToActor();

	/**
	 * Returns a new object of class '<em>Ifc Rel Assigns To Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Assigns To Control</em>'.
	 * @generated
	 */
	IfcRelAssignsToControl createIfcRelAssignsToControl();

	/**
	 * Returns a new object of class '<em>Ifc Rel Assigns To Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Assigns To Group</em>'.
	 * @generated
	 */
	IfcRelAssignsToGroup createIfcRelAssignsToGroup();

	/**
	 * Returns a new object of class '<em>Ifc Rel Assigns To Group By Factor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Assigns To Group By Factor</em>'.
	 * @generated
	 */
	IfcRelAssignsToGroupByFactor createIfcRelAssignsToGroupByFactor();

	/**
	 * Returns a new object of class '<em>Ifc Rel Assigns To Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Assigns To Process</em>'.
	 * @generated
	 */
	IfcRelAssignsToProcess createIfcRelAssignsToProcess();

	/**
	 * Returns a new object of class '<em>Ifc Rel Assigns To Product</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Assigns To Product</em>'.
	 * @generated
	 */
	IfcRelAssignsToProduct createIfcRelAssignsToProduct();

	/**
	 * Returns a new object of class '<em>Ifc Rel Assigns To Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Assigns To Resource</em>'.
	 * @generated
	 */
	IfcRelAssignsToResource createIfcRelAssignsToResource();

	/**
	 * Returns a new object of class '<em>Ifc Rel Associates</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Associates</em>'.
	 * @generated
	 */
	IfcRelAssociates createIfcRelAssociates();

	/**
	 * Returns a new object of class '<em>Ifc Rel Associates Approval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Associates Approval</em>'.
	 * @generated
	 */
	IfcRelAssociatesApproval createIfcRelAssociatesApproval();

	/**
	 * Returns a new object of class '<em>Ifc Rel Associates Classification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Associates Classification</em>'.
	 * @generated
	 */
	IfcRelAssociatesClassification createIfcRelAssociatesClassification();

	/**
	 * Returns a new object of class '<em>Ifc Rel Associates Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Associates Constraint</em>'.
	 * @generated
	 */
	IfcRelAssociatesConstraint createIfcRelAssociatesConstraint();

	/**
	 * Returns a new object of class '<em>Ifc Rel Associates Document</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Associates Document</em>'.
	 * @generated
	 */
	IfcRelAssociatesDocument createIfcRelAssociatesDocument();

	/**
	 * Returns a new object of class '<em>Ifc Rel Associates Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Associates Library</em>'.
	 * @generated
	 */
	IfcRelAssociatesLibrary createIfcRelAssociatesLibrary();

	/**
	 * Returns a new object of class '<em>Ifc Rel Associates Material</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Associates Material</em>'.
	 * @generated
	 */
	IfcRelAssociatesMaterial createIfcRelAssociatesMaterial();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects</em>'.
	 * @generated
	 */
	IfcRelConnects createIfcRelConnects();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects Elements</em>'.
	 * @generated
	 */
	IfcRelConnectsElements createIfcRelConnectsElements();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects Path Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects Path Elements</em>'.
	 * @generated
	 */
	IfcRelConnectsPathElements createIfcRelConnectsPathElements();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects Port To Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects Port To Element</em>'.
	 * @generated
	 */
	IfcRelConnectsPortToElement createIfcRelConnectsPortToElement();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects Ports</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects Ports</em>'.
	 * @generated
	 */
	IfcRelConnectsPorts createIfcRelConnectsPorts();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects Structural Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects Structural Activity</em>'.
	 * @generated
	 */
	IfcRelConnectsStructuralActivity createIfcRelConnectsStructuralActivity();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects Structural Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects Structural Member</em>'.
	 * @generated
	 */
	IfcRelConnectsStructuralMember createIfcRelConnectsStructuralMember();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects With Eccentricity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects With Eccentricity</em>'.
	 * @generated
	 */
	IfcRelConnectsWithEccentricity createIfcRelConnectsWithEccentricity();

	/**
	 * Returns a new object of class '<em>Ifc Rel Connects With Realizing Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Connects With Realizing Elements</em>'.
	 * @generated
	 */
	IfcRelConnectsWithRealizingElements createIfcRelConnectsWithRealizingElements();

	/**
	 * Returns a new object of class '<em>Ifc Rel Contained In Spatial Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Contained In Spatial Structure</em>'.
	 * @generated
	 */
	IfcRelContainedInSpatialStructure createIfcRelContainedInSpatialStructure();

	/**
	 * Returns a new object of class '<em>Ifc Rel Covers Bldg Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Covers Bldg Elements</em>'.
	 * @generated
	 */
	IfcRelCoversBldgElements createIfcRelCoversBldgElements();

	/**
	 * Returns a new object of class '<em>Ifc Rel Covers Spaces</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Covers Spaces</em>'.
	 * @generated
	 */
	IfcRelCoversSpaces createIfcRelCoversSpaces();

	/**
	 * Returns a new object of class '<em>Ifc Rel Declares</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Declares</em>'.
	 * @generated
	 */
	IfcRelDeclares createIfcRelDeclares();

	/**
	 * Returns a new object of class '<em>Ifc Rel Decomposes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Decomposes</em>'.
	 * @generated
	 */
	IfcRelDecomposes createIfcRelDecomposes();

	/**
	 * Returns a new object of class '<em>Ifc Rel Defines</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Defines</em>'.
	 * @generated
	 */
	IfcRelDefines createIfcRelDefines();

	/**
	 * Returns a new object of class '<em>Ifc Rel Defines By Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Defines By Object</em>'.
	 * @generated
	 */
	IfcRelDefinesByObject createIfcRelDefinesByObject();

	/**
	 * Returns a new object of class '<em>Ifc Rel Defines By Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Defines By Properties</em>'.
	 * @generated
	 */
	IfcRelDefinesByProperties createIfcRelDefinesByProperties();

	/**
	 * Returns a new object of class '<em>Ifc Rel Defines By Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Defines By Template</em>'.
	 * @generated
	 */
	IfcRelDefinesByTemplate createIfcRelDefinesByTemplate();

	/**
	 * Returns a new object of class '<em>Ifc Rel Defines By Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Defines By Type</em>'.
	 * @generated
	 */
	IfcRelDefinesByType createIfcRelDefinesByType();

	/**
	 * Returns a new object of class '<em>Ifc Rel Fills Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Fills Element</em>'.
	 * @generated
	 */
	IfcRelFillsElement createIfcRelFillsElement();

	/**
	 * Returns a new object of class '<em>Ifc Rel Flow Control Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Flow Control Elements</em>'.
	 * @generated
	 */
	IfcRelFlowControlElements createIfcRelFlowControlElements();

	/**
	 * Returns a new object of class '<em>Ifc Rel Interferes Elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Interferes Elements</em>'.
	 * @generated
	 */
	IfcRelInterferesElements createIfcRelInterferesElements();

	/**
	 * Returns a new object of class '<em>Ifc Rel Nests</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Nests</em>'.
	 * @generated
	 */
	IfcRelNests createIfcRelNests();

	/**
	 * Returns a new object of class '<em>Ifc Rel Projects Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Projects Element</em>'.
	 * @generated
	 */
	IfcRelProjectsElement createIfcRelProjectsElement();

	/**
	 * Returns a new object of class '<em>Ifc Rel Referenced In Spatial Structure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Referenced In Spatial Structure</em>'.
	 * @generated
	 */
	IfcRelReferencedInSpatialStructure createIfcRelReferencedInSpatialStructure();

	/**
	 * Returns a new object of class '<em>Ifc Rel Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Sequence</em>'.
	 * @generated
	 */
	IfcRelSequence createIfcRelSequence();

	/**
	 * Returns a new object of class '<em>Ifc Rel Services Buildings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Services Buildings</em>'.
	 * @generated
	 */
	IfcRelServicesBuildings createIfcRelServicesBuildings();

	/**
	 * Returns a new object of class '<em>Ifc Rel Space Boundary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Space Boundary</em>'.
	 * @generated
	 */
	IfcRelSpaceBoundary createIfcRelSpaceBoundary();

	/**
	 * Returns a new object of class '<em>Ifc Rel Space Boundary1st Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Space Boundary1st Level</em>'.
	 * @generated
	 */
	IfcRelSpaceBoundary1stLevel createIfcRelSpaceBoundary1stLevel();

	/**
	 * Returns a new object of class '<em>Ifc Rel Space Boundary2nd Level</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Space Boundary2nd Level</em>'.
	 * @generated
	 */
	IfcRelSpaceBoundary2ndLevel createIfcRelSpaceBoundary2ndLevel();

	/**
	 * Returns a new object of class '<em>Ifc Rel Voids Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rel Voids Element</em>'.
	 * @generated
	 */
	IfcRelVoidsElement createIfcRelVoidsElement();

	/**
	 * Returns a new object of class '<em>Ifc Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Relationship</em>'.
	 * @generated
	 */
	IfcRelationship createIfcRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Reparametrised Composite Curve Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Reparametrised Composite Curve Segment</em>'.
	 * @generated
	 */
	IfcReparametrisedCompositeCurveSegment createIfcReparametrisedCompositeCurveSegment();

	/**
	 * Returns a new object of class '<em>Ifc Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Representation</em>'.
	 * @generated
	 */
	IfcRepresentation createIfcRepresentation();

	/**
	 * Returns a new object of class '<em>Ifc Representation Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Representation Context</em>'.
	 * @generated
	 */
	IfcRepresentationContext createIfcRepresentationContext();

	/**
	 * Returns a new object of class '<em>Ifc Representation Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Representation Item</em>'.
	 * @generated
	 */
	IfcRepresentationItem createIfcRepresentationItem();

	/**
	 * Returns a new object of class '<em>Ifc Representation Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Representation Map</em>'.
	 * @generated
	 */
	IfcRepresentationMap createIfcRepresentationMap();

	/**
	 * Returns a new object of class '<em>Ifc Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Resource</em>'.
	 * @generated
	 */
	IfcResource createIfcResource();

	/**
	 * Returns a new object of class '<em>Ifc Resource Approval Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Resource Approval Relationship</em>'.
	 * @generated
	 */
	IfcResourceApprovalRelationship createIfcResourceApprovalRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Resource Constraint Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Resource Constraint Relationship</em>'.
	 * @generated
	 */
	IfcResourceConstraintRelationship createIfcResourceConstraintRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Resource Level Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Resource Level Relationship</em>'.
	 * @generated
	 */
	IfcResourceLevelRelationship createIfcResourceLevelRelationship();

	/**
	 * Returns a new object of class '<em>Ifc Resource Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Resource Time</em>'.
	 * @generated
	 */
	IfcResourceTime createIfcResourceTime();

	/**
	 * Returns a new object of class '<em>Ifc Revolved Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Revolved Area Solid</em>'.
	 * @generated
	 */
	IfcRevolvedAreaSolid createIfcRevolvedAreaSolid();

	/**
	 * Returns a new object of class '<em>Ifc Revolved Area Solid Tapered</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Revolved Area Solid Tapered</em>'.
	 * @generated
	 */
	IfcRevolvedAreaSolidTapered createIfcRevolvedAreaSolidTapered();

	/**
	 * Returns a new object of class '<em>Ifc Right Circular Cone</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Right Circular Cone</em>'.
	 * @generated
	 */
	IfcRightCircularCone createIfcRightCircularCone();

	/**
	 * Returns a new object of class '<em>Ifc Right Circular Cylinder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Right Circular Cylinder</em>'.
	 * @generated
	 */
	IfcRightCircularCylinder createIfcRightCircularCylinder();

	/**
	 * Returns a new object of class '<em>Ifc Roof</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Roof</em>'.
	 * @generated
	 */
	IfcRoof createIfcRoof();

	/**
	 * Returns a new object of class '<em>Ifc Roof Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Roof Type</em>'.
	 * @generated
	 */
	IfcRoofType createIfcRoofType();

	/**
	 * Returns a new object of class '<em>Ifc Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Root</em>'.
	 * @generated
	 */
	IfcRoot createIfcRoot();

	/**
	 * Returns a new object of class '<em>Ifc Rounded Rectangle Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rounded Rectangle Profile Def</em>'.
	 * @generated
	 */
	IfcRoundedRectangleProfileDef createIfcRoundedRectangleProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc SI Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc SI Unit</em>'.
	 * @generated
	 */
	IfcSIUnit createIfcSIUnit();

	/**
	 * Returns a new object of class '<em>Ifc Sanitary Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sanitary Terminal</em>'.
	 * @generated
	 */
	IfcSanitaryTerminal createIfcSanitaryTerminal();

	/**
	 * Returns a new object of class '<em>Ifc Sanitary Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sanitary Terminal Type</em>'.
	 * @generated
	 */
	IfcSanitaryTerminalType createIfcSanitaryTerminalType();

	/**
	 * Returns a new object of class '<em>Ifc Scheduling Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Scheduling Time</em>'.
	 * @generated
	 */
	IfcSchedulingTime createIfcSchedulingTime();

	/**
	 * Returns a new object of class '<em>Ifc Seam Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Seam Curve</em>'.
	 * @generated
	 */
	IfcSeamCurve createIfcSeamCurve();

	/**
	 * Returns a new object of class '<em>Ifc Section Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Section Properties</em>'.
	 * @generated
	 */
	IfcSectionProperties createIfcSectionProperties();

	/**
	 * Returns a new object of class '<em>Ifc Section Reinforcement Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Section Reinforcement Properties</em>'.
	 * @generated
	 */
	IfcSectionReinforcementProperties createIfcSectionReinforcementProperties();

	/**
	 * Returns a new object of class '<em>Ifc Sectioned Spine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sectioned Spine</em>'.
	 * @generated
	 */
	IfcSectionedSpine createIfcSectionedSpine();

	/**
	 * Returns a new object of class '<em>Ifc Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sensor</em>'.
	 * @generated
	 */
	IfcSensor createIfcSensor();

	/**
	 * Returns a new object of class '<em>Ifc Sensor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sensor Type</em>'.
	 * @generated
	 */
	IfcSensorType createIfcSensorType();

	/**
	 * Returns a new object of class '<em>Ifc Shading Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Shading Device</em>'.
	 * @generated
	 */
	IfcShadingDevice createIfcShadingDevice();

	/**
	 * Returns a new object of class '<em>Ifc Shading Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Shading Device Type</em>'.
	 * @generated
	 */
	IfcShadingDeviceType createIfcShadingDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Shape Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Shape Aspect</em>'.
	 * @generated
	 */
	IfcShapeAspect createIfcShapeAspect();

	/**
	 * Returns a new object of class '<em>Ifc Shape Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Shape Model</em>'.
	 * @generated
	 */
	IfcShapeModel createIfcShapeModel();

	/**
	 * Returns a new object of class '<em>Ifc Shape Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Shape Representation</em>'.
	 * @generated
	 */
	IfcShapeRepresentation createIfcShapeRepresentation();

	/**
	 * Returns a new object of class '<em>Ifc Shell Based Surface Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Shell Based Surface Model</em>'.
	 * @generated
	 */
	IfcShellBasedSurfaceModel createIfcShellBasedSurfaceModel();

	/**
	 * Returns a new object of class '<em>Ifc Simple Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Simple Property</em>'.
	 * @generated
	 */
	IfcSimpleProperty createIfcSimpleProperty();

	/**
	 * Returns a new object of class '<em>Ifc Simple Property Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Simple Property Template</em>'.
	 * @generated
	 */
	IfcSimplePropertyTemplate createIfcSimplePropertyTemplate();

	/**
	 * Returns a new object of class '<em>Ifc Site</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Site</em>'.
	 * @generated
	 */
	IfcSite createIfcSite();

	/**
	 * Returns a new object of class '<em>Ifc Slab</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Slab</em>'.
	 * @generated
	 */
	IfcSlab createIfcSlab();

	/**
	 * Returns a new object of class '<em>Ifc Slab Elemented Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Slab Elemented Case</em>'.
	 * @generated
	 */
	IfcSlabElementedCase createIfcSlabElementedCase();

	/**
	 * Returns a new object of class '<em>Ifc Slab Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Slab Standard Case</em>'.
	 * @generated
	 */
	IfcSlabStandardCase createIfcSlabStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Slab Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Slab Type</em>'.
	 * @generated
	 */
	IfcSlabType createIfcSlabType();

	/**
	 * Returns a new object of class '<em>Ifc Slippage Connection Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Slippage Connection Condition</em>'.
	 * @generated
	 */
	IfcSlippageConnectionCondition createIfcSlippageConnectionCondition();

	/**
	 * Returns a new object of class '<em>Ifc Solar Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Solar Device</em>'.
	 * @generated
	 */
	IfcSolarDevice createIfcSolarDevice();

	/**
	 * Returns a new object of class '<em>Ifc Solar Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Solar Device Type</em>'.
	 * @generated
	 */
	IfcSolarDeviceType createIfcSolarDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc Solid Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Solid Model</em>'.
	 * @generated
	 */
	IfcSolidModel createIfcSolidModel();

	/**
	 * Returns a new object of class '<em>Ifc Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Space</em>'.
	 * @generated
	 */
	IfcSpace createIfcSpace();

	/**
	 * Returns a new object of class '<em>Ifc Space Heater</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Space Heater</em>'.
	 * @generated
	 */
	IfcSpaceHeater createIfcSpaceHeater();

	/**
	 * Returns a new object of class '<em>Ifc Space Heater Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Space Heater Type</em>'.
	 * @generated
	 */
	IfcSpaceHeaterType createIfcSpaceHeaterType();

	/**
	 * Returns a new object of class '<em>Ifc Space Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Space Type</em>'.
	 * @generated
	 */
	IfcSpaceType createIfcSpaceType();

	/**
	 * Returns a new object of class '<em>Ifc Spatial Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Spatial Element</em>'.
	 * @generated
	 */
	IfcSpatialElement createIfcSpatialElement();

	/**
	 * Returns a new object of class '<em>Ifc Spatial Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Spatial Element Type</em>'.
	 * @generated
	 */
	IfcSpatialElementType createIfcSpatialElementType();

	/**
	 * Returns a new object of class '<em>Ifc Spatial Structure Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Spatial Structure Element</em>'.
	 * @generated
	 */
	IfcSpatialStructureElement createIfcSpatialStructureElement();

	/**
	 * Returns a new object of class '<em>Ifc Spatial Structure Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Spatial Structure Element Type</em>'.
	 * @generated
	 */
	IfcSpatialStructureElementType createIfcSpatialStructureElementType();

	/**
	 * Returns a new object of class '<em>Ifc Spatial Zone</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Spatial Zone</em>'.
	 * @generated
	 */
	IfcSpatialZone createIfcSpatialZone();

	/**
	 * Returns a new object of class '<em>Ifc Spatial Zone Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Spatial Zone Type</em>'.
	 * @generated
	 */
	IfcSpatialZoneType createIfcSpatialZoneType();

	/**
	 * Returns a new object of class '<em>Ifc Sphere</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sphere</em>'.
	 * @generated
	 */
	IfcSphere createIfcSphere();

	/**
	 * Returns a new object of class '<em>Ifc Spherical Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Spherical Surface</em>'.
	 * @generated
	 */
	IfcSphericalSurface createIfcSphericalSurface();

	/**
	 * Returns a new object of class '<em>Ifc Stack Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Stack Terminal</em>'.
	 * @generated
	 */
	IfcStackTerminal createIfcStackTerminal();

	/**
	 * Returns a new object of class '<em>Ifc Stack Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Stack Terminal Type</em>'.
	 * @generated
	 */
	IfcStackTerminalType createIfcStackTerminalType();

	/**
	 * Returns a new object of class '<em>Ifc Stair</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Stair</em>'.
	 * @generated
	 */
	IfcStair createIfcStair();

	/**
	 * Returns a new object of class '<em>Ifc Stair Flight</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Stair Flight</em>'.
	 * @generated
	 */
	IfcStairFlight createIfcStairFlight();

	/**
	 * Returns a new object of class '<em>Ifc Stair Flight Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Stair Flight Type</em>'.
	 * @generated
	 */
	IfcStairFlightType createIfcStairFlightType();

	/**
	 * Returns a new object of class '<em>Ifc Stair Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Stair Type</em>'.
	 * @generated
	 */
	IfcStairType createIfcStairType();

	/**
	 * Returns a new object of class '<em>Ifc Structural Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Action</em>'.
	 * @generated
	 */
	IfcStructuralAction createIfcStructuralAction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Activity</em>'.
	 * @generated
	 */
	IfcStructuralActivity createIfcStructuralActivity();

	/**
	 * Returns a new object of class '<em>Ifc Structural Analysis Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Analysis Model</em>'.
	 * @generated
	 */
	IfcStructuralAnalysisModel createIfcStructuralAnalysisModel();

	/**
	 * Returns a new object of class '<em>Ifc Structural Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Connection</em>'.
	 * @generated
	 */
	IfcStructuralConnection createIfcStructuralConnection();

	/**
	 * Returns a new object of class '<em>Ifc Structural Connection Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Connection Condition</em>'.
	 * @generated
	 */
	IfcStructuralConnectionCondition createIfcStructuralConnectionCondition();

	/**
	 * Returns a new object of class '<em>Ifc Structural Curve Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Curve Action</em>'.
	 * @generated
	 */
	IfcStructuralCurveAction createIfcStructuralCurveAction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Curve Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Curve Connection</em>'.
	 * @generated
	 */
	IfcStructuralCurveConnection createIfcStructuralCurveConnection();

	/**
	 * Returns a new object of class '<em>Ifc Structural Curve Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Curve Member</em>'.
	 * @generated
	 */
	IfcStructuralCurveMember createIfcStructuralCurveMember();

	/**
	 * Returns a new object of class '<em>Ifc Structural Curve Member Varying</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Curve Member Varying</em>'.
	 * @generated
	 */
	IfcStructuralCurveMemberVarying createIfcStructuralCurveMemberVarying();

	/**
	 * Returns a new object of class '<em>Ifc Structural Curve Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Curve Reaction</em>'.
	 * @generated
	 */
	IfcStructuralCurveReaction createIfcStructuralCurveReaction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Item</em>'.
	 * @generated
	 */
	IfcStructuralItem createIfcStructuralItem();

	/**
	 * Returns a new object of class '<em>Ifc Structural Linear Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Linear Action</em>'.
	 * @generated
	 */
	IfcStructuralLinearAction createIfcStructuralLinearAction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load</em>'.
	 * @generated
	 */
	IfcStructuralLoad createIfcStructuralLoad();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Case</em>'.
	 * @generated
	 */
	IfcStructuralLoadCase createIfcStructuralLoadCase();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Configuration</em>'.
	 * @generated
	 */
	IfcStructuralLoadConfiguration createIfcStructuralLoadConfiguration();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Group</em>'.
	 * @generated
	 */
	IfcStructuralLoadGroup createIfcStructuralLoadGroup();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Linear Force</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Linear Force</em>'.
	 * @generated
	 */
	IfcStructuralLoadLinearForce createIfcStructuralLoadLinearForce();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Or Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Or Result</em>'.
	 * @generated
	 */
	IfcStructuralLoadOrResult createIfcStructuralLoadOrResult();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Planar Force</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Planar Force</em>'.
	 * @generated
	 */
	IfcStructuralLoadPlanarForce createIfcStructuralLoadPlanarForce();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Single Displacement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Single Displacement</em>'.
	 * @generated
	 */
	IfcStructuralLoadSingleDisplacement createIfcStructuralLoadSingleDisplacement();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Single Displacement Distortion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Single Displacement Distortion</em>'.
	 * @generated
	 */
	IfcStructuralLoadSingleDisplacementDistortion createIfcStructuralLoadSingleDisplacementDistortion();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Single Force</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Single Force</em>'.
	 * @generated
	 */
	IfcStructuralLoadSingleForce createIfcStructuralLoadSingleForce();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Single Force Warping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Single Force Warping</em>'.
	 * @generated
	 */
	IfcStructuralLoadSingleForceWarping createIfcStructuralLoadSingleForceWarping();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Static</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Static</em>'.
	 * @generated
	 */
	IfcStructuralLoadStatic createIfcStructuralLoadStatic();

	/**
	 * Returns a new object of class '<em>Ifc Structural Load Temperature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Load Temperature</em>'.
	 * @generated
	 */
	IfcStructuralLoadTemperature createIfcStructuralLoadTemperature();

	/**
	 * Returns a new object of class '<em>Ifc Structural Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Member</em>'.
	 * @generated
	 */
	IfcStructuralMember createIfcStructuralMember();

	/**
	 * Returns a new object of class '<em>Ifc Structural Planar Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Planar Action</em>'.
	 * @generated
	 */
	IfcStructuralPlanarAction createIfcStructuralPlanarAction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Point Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Point Action</em>'.
	 * @generated
	 */
	IfcStructuralPointAction createIfcStructuralPointAction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Point Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Point Connection</em>'.
	 * @generated
	 */
	IfcStructuralPointConnection createIfcStructuralPointConnection();

	/**
	 * Returns a new object of class '<em>Ifc Structural Point Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Point Reaction</em>'.
	 * @generated
	 */
	IfcStructuralPointReaction createIfcStructuralPointReaction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Reaction</em>'.
	 * @generated
	 */
	IfcStructuralReaction createIfcStructuralReaction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Result Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Result Group</em>'.
	 * @generated
	 */
	IfcStructuralResultGroup createIfcStructuralResultGroup();

	/**
	 * Returns a new object of class '<em>Ifc Structural Surface Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Surface Action</em>'.
	 * @generated
	 */
	IfcStructuralSurfaceAction createIfcStructuralSurfaceAction();

	/**
	 * Returns a new object of class '<em>Ifc Structural Surface Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Surface Connection</em>'.
	 * @generated
	 */
	IfcStructuralSurfaceConnection createIfcStructuralSurfaceConnection();

	/**
	 * Returns a new object of class '<em>Ifc Structural Surface Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Surface Member</em>'.
	 * @generated
	 */
	IfcStructuralSurfaceMember createIfcStructuralSurfaceMember();

	/**
	 * Returns a new object of class '<em>Ifc Structural Surface Member Varying</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Surface Member Varying</em>'.
	 * @generated
	 */
	IfcStructuralSurfaceMemberVarying createIfcStructuralSurfaceMemberVarying();

	/**
	 * Returns a new object of class '<em>Ifc Structural Surface Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Structural Surface Reaction</em>'.
	 * @generated
	 */
	IfcStructuralSurfaceReaction createIfcStructuralSurfaceReaction();

	/**
	 * Returns a new object of class '<em>Ifc Style Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Style Model</em>'.
	 * @generated
	 */
	IfcStyleModel createIfcStyleModel();

	/**
	 * Returns a new object of class '<em>Ifc Styled Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Styled Item</em>'.
	 * @generated
	 */
	IfcStyledItem createIfcStyledItem();

	/**
	 * Returns a new object of class '<em>Ifc Styled Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Styled Representation</em>'.
	 * @generated
	 */
	IfcStyledRepresentation createIfcStyledRepresentation();

	/**
	 * Returns a new object of class '<em>Ifc Sub Contract Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sub Contract Resource</em>'.
	 * @generated
	 */
	IfcSubContractResource createIfcSubContractResource();

	/**
	 * Returns a new object of class '<em>Ifc Sub Contract Resource Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sub Contract Resource Type</em>'.
	 * @generated
	 */
	IfcSubContractResourceType createIfcSubContractResourceType();

	/**
	 * Returns a new object of class '<em>Ifc Subedge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Subedge</em>'.
	 * @generated
	 */
	IfcSubedge createIfcSubedge();

	/**
	 * Returns a new object of class '<em>Ifc Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface</em>'.
	 * @generated
	 */
	IfcSurface createIfcSurface();

	/**
	 * Returns a new object of class '<em>Ifc Surface Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Curve</em>'.
	 * @generated
	 */
	IfcSurfaceCurve createIfcSurfaceCurve();

	/**
	 * Returns a new object of class '<em>Ifc Surface Curve Swept Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Curve Swept Area Solid</em>'.
	 * @generated
	 */
	IfcSurfaceCurveSweptAreaSolid createIfcSurfaceCurveSweptAreaSolid();

	/**
	 * Returns a new object of class '<em>Ifc Surface Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Feature</em>'.
	 * @generated
	 */
	IfcSurfaceFeature createIfcSurfaceFeature();

	/**
	 * Returns a new object of class '<em>Ifc Surface Of Linear Extrusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Of Linear Extrusion</em>'.
	 * @generated
	 */
	IfcSurfaceOfLinearExtrusion createIfcSurfaceOfLinearExtrusion();

	/**
	 * Returns a new object of class '<em>Ifc Surface Of Revolution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Of Revolution</em>'.
	 * @generated
	 */
	IfcSurfaceOfRevolution createIfcSurfaceOfRevolution();

	/**
	 * Returns a new object of class '<em>Ifc Surface Reinforcement Area</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Reinforcement Area</em>'.
	 * @generated
	 */
	IfcSurfaceReinforcementArea createIfcSurfaceReinforcementArea();

	/**
	 * Returns a new object of class '<em>Ifc Surface Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Style</em>'.
	 * @generated
	 */
	IfcSurfaceStyle createIfcSurfaceStyle();

	/**
	 * Returns a new object of class '<em>Ifc Surface Style Lighting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Style Lighting</em>'.
	 * @generated
	 */
	IfcSurfaceStyleLighting createIfcSurfaceStyleLighting();

	/**
	 * Returns a new object of class '<em>Ifc Surface Style Refraction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Style Refraction</em>'.
	 * @generated
	 */
	IfcSurfaceStyleRefraction createIfcSurfaceStyleRefraction();

	/**
	 * Returns a new object of class '<em>Ifc Surface Style Rendering</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Style Rendering</em>'.
	 * @generated
	 */
	IfcSurfaceStyleRendering createIfcSurfaceStyleRendering();

	/**
	 * Returns a new object of class '<em>Ifc Surface Style Shading</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Style Shading</em>'.
	 * @generated
	 */
	IfcSurfaceStyleShading createIfcSurfaceStyleShading();

	/**
	 * Returns a new object of class '<em>Ifc Surface Style With Textures</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Style With Textures</em>'.
	 * @generated
	 */
	IfcSurfaceStyleWithTextures createIfcSurfaceStyleWithTextures();

	/**
	 * Returns a new object of class '<em>Ifc Surface Texture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Surface Texture</em>'.
	 * @generated
	 */
	IfcSurfaceTexture createIfcSurfaceTexture();

	/**
	 * Returns a new object of class '<em>Ifc Swept Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Swept Area Solid</em>'.
	 * @generated
	 */
	IfcSweptAreaSolid createIfcSweptAreaSolid();

	/**
	 * Returns a new object of class '<em>Ifc Swept Disk Solid</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Swept Disk Solid</em>'.
	 * @generated
	 */
	IfcSweptDiskSolid createIfcSweptDiskSolid();

	/**
	 * Returns a new object of class '<em>Ifc Swept Disk Solid Polygonal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Swept Disk Solid Polygonal</em>'.
	 * @generated
	 */
	IfcSweptDiskSolidPolygonal createIfcSweptDiskSolidPolygonal();

	/**
	 * Returns a new object of class '<em>Ifc Swept Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Swept Surface</em>'.
	 * @generated
	 */
	IfcSweptSurface createIfcSweptSurface();

	/**
	 * Returns a new object of class '<em>Ifc Switching Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Switching Device</em>'.
	 * @generated
	 */
	IfcSwitchingDevice createIfcSwitchingDevice();

	/**
	 * Returns a new object of class '<em>Ifc Switching Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Switching Device Type</em>'.
	 * @generated
	 */
	IfcSwitchingDeviceType createIfcSwitchingDeviceType();

	/**
	 * Returns a new object of class '<em>Ifc System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc System</em>'.
	 * @generated
	 */
	IfcSystem createIfcSystem();

	/**
	 * Returns a new object of class '<em>Ifc System Furniture Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc System Furniture Element</em>'.
	 * @generated
	 */
	IfcSystemFurnitureElement createIfcSystemFurnitureElement();

	/**
	 * Returns a new object of class '<em>Ifc System Furniture Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc System Furniture Element Type</em>'.
	 * @generated
	 */
	IfcSystemFurnitureElementType createIfcSystemFurnitureElementType();

	/**
	 * Returns a new object of class '<em>Ifc TShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc TShape Profile Def</em>'.
	 * @generated
	 */
	IfcTShapeProfileDef createIfcTShapeProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Table</em>'.
	 * @generated
	 */
	IfcTable createIfcTable();

	/**
	 * Returns a new object of class '<em>Ifc Table Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Table Column</em>'.
	 * @generated
	 */
	IfcTableColumn createIfcTableColumn();

	/**
	 * Returns a new object of class '<em>Ifc Table Row</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Table Row</em>'.
	 * @generated
	 */
	IfcTableRow createIfcTableRow();

	/**
	 * Returns a new object of class '<em>Ifc Tank</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tank</em>'.
	 * @generated
	 */
	IfcTank createIfcTank();

	/**
	 * Returns a new object of class '<em>Ifc Tank Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tank Type</em>'.
	 * @generated
	 */
	IfcTankType createIfcTankType();

	/**
	 * Returns a new object of class '<em>Ifc Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Task</em>'.
	 * @generated
	 */
	IfcTask createIfcTask();

	/**
	 * Returns a new object of class '<em>Ifc Task Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Task Time</em>'.
	 * @generated
	 */
	IfcTaskTime createIfcTaskTime();

	/**
	 * Returns a new object of class '<em>Ifc Task Time Recurring</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Task Time Recurring</em>'.
	 * @generated
	 */
	IfcTaskTimeRecurring createIfcTaskTimeRecurring();

	/**
	 * Returns a new object of class '<em>Ifc Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Task Type</em>'.
	 * @generated
	 */
	IfcTaskType createIfcTaskType();

	/**
	 * Returns a new object of class '<em>Ifc Telecom Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Telecom Address</em>'.
	 * @generated
	 */
	IfcTelecomAddress createIfcTelecomAddress();

	/**
	 * Returns a new object of class '<em>Ifc Tendon</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tendon</em>'.
	 * @generated
	 */
	IfcTendon createIfcTendon();

	/**
	 * Returns a new object of class '<em>Ifc Tendon Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tendon Anchor</em>'.
	 * @generated
	 */
	IfcTendonAnchor createIfcTendonAnchor();

	/**
	 * Returns a new object of class '<em>Ifc Tendon Anchor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tendon Anchor Type</em>'.
	 * @generated
	 */
	IfcTendonAnchorType createIfcTendonAnchorType();

	/**
	 * Returns a new object of class '<em>Ifc Tendon Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tendon Type</em>'.
	 * @generated
	 */
	IfcTendonType createIfcTendonType();

	/**
	 * Returns a new object of class '<em>Ifc Tessellated Face Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tessellated Face Set</em>'.
	 * @generated
	 */
	IfcTessellatedFaceSet createIfcTessellatedFaceSet();

	/**
	 * Returns a new object of class '<em>Ifc Tessellated Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tessellated Item</em>'.
	 * @generated
	 */
	IfcTessellatedItem createIfcTessellatedItem();

	/**
	 * Returns a new object of class '<em>Ifc Text Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Literal</em>'.
	 * @generated
	 */
	IfcTextLiteral createIfcTextLiteral();

	/**
	 * Returns a new object of class '<em>Ifc Text Literal With Extent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Literal With Extent</em>'.
	 * @generated
	 */
	IfcTextLiteralWithExtent createIfcTextLiteralWithExtent();

	/**
	 * Returns a new object of class '<em>Ifc Text Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Style</em>'.
	 * @generated
	 */
	IfcTextStyle createIfcTextStyle();

	/**
	 * Returns a new object of class '<em>Ifc Text Style Font Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Style Font Model</em>'.
	 * @generated
	 */
	IfcTextStyleFontModel createIfcTextStyleFontModel();

	/**
	 * Returns a new object of class '<em>Ifc Text Style For Defined Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Style For Defined Font</em>'.
	 * @generated
	 */
	IfcTextStyleForDefinedFont createIfcTextStyleForDefinedFont();

	/**
	 * Returns a new object of class '<em>Ifc Text Style Text Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Style Text Model</em>'.
	 * @generated
	 */
	IfcTextStyleTextModel createIfcTextStyleTextModel();

	/**
	 * Returns a new object of class '<em>Ifc Texture Coordinate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Texture Coordinate</em>'.
	 * @generated
	 */
	IfcTextureCoordinate createIfcTextureCoordinate();

	/**
	 * Returns a new object of class '<em>Ifc Texture Coordinate Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Texture Coordinate Generator</em>'.
	 * @generated
	 */
	IfcTextureCoordinateGenerator createIfcTextureCoordinateGenerator();

	/**
	 * Returns a new object of class '<em>Ifc Texture Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Texture Map</em>'.
	 * @generated
	 */
	IfcTextureMap createIfcTextureMap();

	/**
	 * Returns a new object of class '<em>Ifc Texture Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Texture Vertex</em>'.
	 * @generated
	 */
	IfcTextureVertex createIfcTextureVertex();

	/**
	 * Returns a new object of class '<em>Ifc Texture Vertex List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Texture Vertex List</em>'.
	 * @generated
	 */
	IfcTextureVertexList createIfcTextureVertexList();

	/**
	 * Returns a new object of class '<em>Ifc Time Period</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Time Period</em>'.
	 * @generated
	 */
	IfcTimePeriod createIfcTimePeriod();

	/**
	 * Returns a new object of class '<em>Ifc Time Series</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Time Series</em>'.
	 * @generated
	 */
	IfcTimeSeries createIfcTimeSeries();

	/**
	 * Returns a new object of class '<em>Ifc Time Series Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Time Series Value</em>'.
	 * @generated
	 */
	IfcTimeSeriesValue createIfcTimeSeriesValue();

	/**
	 * Returns a new object of class '<em>Ifc Topological Representation Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Topological Representation Item</em>'.
	 * @generated
	 */
	IfcTopologicalRepresentationItem createIfcTopologicalRepresentationItem();

	/**
	 * Returns a new object of class '<em>Ifc Topology Representation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Topology Representation</em>'.
	 * @generated
	 */
	IfcTopologyRepresentation createIfcTopologyRepresentation();

	/**
	 * Returns a new object of class '<em>Ifc Toroidal Surface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Toroidal Surface</em>'.
	 * @generated
	 */
	IfcToroidalSurface createIfcToroidalSurface();

	/**
	 * Returns a new object of class '<em>Ifc Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Transformer</em>'.
	 * @generated
	 */
	IfcTransformer createIfcTransformer();

	/**
	 * Returns a new object of class '<em>Ifc Transformer Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Transformer Type</em>'.
	 * @generated
	 */
	IfcTransformerType createIfcTransformerType();

	/**
	 * Returns a new object of class '<em>Ifc Transport Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Transport Element</em>'.
	 * @generated
	 */
	IfcTransportElement createIfcTransportElement();

	/**
	 * Returns a new object of class '<em>Ifc Transport Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Transport Element Type</em>'.
	 * @generated
	 */
	IfcTransportElementType createIfcTransportElementType();

	/**
	 * Returns a new object of class '<em>Ifc Trapezium Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Trapezium Profile Def</em>'.
	 * @generated
	 */
	IfcTrapeziumProfileDef createIfcTrapeziumProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Triangulated Face Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Triangulated Face Set</em>'.
	 * @generated
	 */
	IfcTriangulatedFaceSet createIfcTriangulatedFaceSet();

	/**
	 * Returns a new object of class '<em>Ifc Trimmed Curve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Trimmed Curve</em>'.
	 * @generated
	 */
	IfcTrimmedCurve createIfcTrimmedCurve();

	/**
	 * Returns a new object of class '<em>Ifc Tube Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tube Bundle</em>'.
	 * @generated
	 */
	IfcTubeBundle createIfcTubeBundle();

	/**
	 * Returns a new object of class '<em>Ifc Tube Bundle Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Tube Bundle Type</em>'.
	 * @generated
	 */
	IfcTubeBundleType createIfcTubeBundleType();

	/**
	 * Returns a new object of class '<em>Ifc Type Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Type Object</em>'.
	 * @generated
	 */
	IfcTypeObject createIfcTypeObject();

	/**
	 * Returns a new object of class '<em>Ifc Type Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Type Process</em>'.
	 * @generated
	 */
	IfcTypeProcess createIfcTypeProcess();

	/**
	 * Returns a new object of class '<em>Ifc Type Product</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Type Product</em>'.
	 * @generated
	 */
	IfcTypeProduct createIfcTypeProduct();

	/**
	 * Returns a new object of class '<em>Ifc Type Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Type Resource</em>'.
	 * @generated
	 */
	IfcTypeResource createIfcTypeResource();

	/**
	 * Returns a new object of class '<em>Ifc UShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc UShape Profile Def</em>'.
	 * @generated
	 */
	IfcUShapeProfileDef createIfcUShapeProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Unit Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Unit Assignment</em>'.
	 * @generated
	 */
	IfcUnitAssignment createIfcUnitAssignment();

	/**
	 * Returns a new object of class '<em>Ifc Unitary Control Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Unitary Control Element</em>'.
	 * @generated
	 */
	IfcUnitaryControlElement createIfcUnitaryControlElement();

	/**
	 * Returns a new object of class '<em>Ifc Unitary Control Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Unitary Control Element Type</em>'.
	 * @generated
	 */
	IfcUnitaryControlElementType createIfcUnitaryControlElementType();

	/**
	 * Returns a new object of class '<em>Ifc Unitary Equipment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Unitary Equipment</em>'.
	 * @generated
	 */
	IfcUnitaryEquipment createIfcUnitaryEquipment();

	/**
	 * Returns a new object of class '<em>Ifc Unitary Equipment Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Unitary Equipment Type</em>'.
	 * @generated
	 */
	IfcUnitaryEquipmentType createIfcUnitaryEquipmentType();

	/**
	 * Returns a new object of class '<em>Ifc Valve</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Valve</em>'.
	 * @generated
	 */
	IfcValve createIfcValve();

	/**
	 * Returns a new object of class '<em>Ifc Valve Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Valve Type</em>'.
	 * @generated
	 */
	IfcValveType createIfcValveType();

	/**
	 * Returns a new object of class '<em>Ifc Vector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Vector</em>'.
	 * @generated
	 */
	IfcVector createIfcVector();

	/**
	 * Returns a new object of class '<em>Ifc Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Vertex</em>'.
	 * @generated
	 */
	IfcVertex createIfcVertex();

	/**
	 * Returns a new object of class '<em>Ifc Vertex Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Vertex Loop</em>'.
	 * @generated
	 */
	IfcVertexLoop createIfcVertexLoop();

	/**
	 * Returns a new object of class '<em>Ifc Vertex Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Vertex Point</em>'.
	 * @generated
	 */
	IfcVertexPoint createIfcVertexPoint();

	/**
	 * Returns a new object of class '<em>Ifc Vibration Isolator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Vibration Isolator</em>'.
	 * @generated
	 */
	IfcVibrationIsolator createIfcVibrationIsolator();

	/**
	 * Returns a new object of class '<em>Ifc Vibration Isolator Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Vibration Isolator Type</em>'.
	 * @generated
	 */
	IfcVibrationIsolatorType createIfcVibrationIsolatorType();

	/**
	 * Returns a new object of class '<em>Ifc Virtual Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Virtual Element</em>'.
	 * @generated
	 */
	IfcVirtualElement createIfcVirtualElement();

	/**
	 * Returns a new object of class '<em>Ifc Virtual Grid Intersection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Virtual Grid Intersection</em>'.
	 * @generated
	 */
	IfcVirtualGridIntersection createIfcVirtualGridIntersection();

	/**
	 * Returns a new object of class '<em>Ifc Voiding Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Voiding Feature</em>'.
	 * @generated
	 */
	IfcVoidingFeature createIfcVoidingFeature();

	/**
	 * Returns a new object of class '<em>Ifc Wall</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Wall</em>'.
	 * @generated
	 */
	IfcWall createIfcWall();

	/**
	 * Returns a new object of class '<em>Ifc Wall Elemented Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Wall Elemented Case</em>'.
	 * @generated
	 */
	IfcWallElementedCase createIfcWallElementedCase();

	/**
	 * Returns a new object of class '<em>Ifc Wall Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Wall Standard Case</em>'.
	 * @generated
	 */
	IfcWallStandardCase createIfcWallStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Wall Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Wall Type</em>'.
	 * @generated
	 */
	IfcWallType createIfcWallType();

	/**
	 * Returns a new object of class '<em>Ifc Waste Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Waste Terminal</em>'.
	 * @generated
	 */
	IfcWasteTerminal createIfcWasteTerminal();

	/**
	 * Returns a new object of class '<em>Ifc Waste Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Waste Terminal Type</em>'.
	 * @generated
	 */
	IfcWasteTerminalType createIfcWasteTerminalType();

	/**
	 * Returns a new object of class '<em>Ifc Window</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Window</em>'.
	 * @generated
	 */
	IfcWindow createIfcWindow();

	/**
	 * Returns a new object of class '<em>Ifc Window Lining Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Window Lining Properties</em>'.
	 * @generated
	 */
	IfcWindowLiningProperties createIfcWindowLiningProperties();

	/**
	 * Returns a new object of class '<em>Ifc Window Panel Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Window Panel Properties</em>'.
	 * @generated
	 */
	IfcWindowPanelProperties createIfcWindowPanelProperties();

	/**
	 * Returns a new object of class '<em>Ifc Window Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Window Standard Case</em>'.
	 * @generated
	 */
	IfcWindowStandardCase createIfcWindowStandardCase();

	/**
	 * Returns a new object of class '<em>Ifc Window Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Window Style</em>'.
	 * @generated
	 */
	IfcWindowStyle createIfcWindowStyle();

	/**
	 * Returns a new object of class '<em>Ifc Window Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Window Type</em>'.
	 * @generated
	 */
	IfcWindowType createIfcWindowType();

	/**
	 * Returns a new object of class '<em>Ifc Work Calendar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Work Calendar</em>'.
	 * @generated
	 */
	IfcWorkCalendar createIfcWorkCalendar();

	/**
	 * Returns a new object of class '<em>Ifc Work Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Work Control</em>'.
	 * @generated
	 */
	IfcWorkControl createIfcWorkControl();

	/**
	 * Returns a new object of class '<em>Ifc Work Plan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Work Plan</em>'.
	 * @generated
	 */
	IfcWorkPlan createIfcWorkPlan();

	/**
	 * Returns a new object of class '<em>Ifc Work Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Work Schedule</em>'.
	 * @generated
	 */
	IfcWorkSchedule createIfcWorkSchedule();

	/**
	 * Returns a new object of class '<em>Ifc Work Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Work Time</em>'.
	 * @generated
	 */
	IfcWorkTime createIfcWorkTime();

	/**
	 * Returns a new object of class '<em>Ifc ZShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc ZShape Profile Def</em>'.
	 * @generated
	 */
	IfcZShapeProfileDef createIfcZShapeProfileDef();

	/**
	 * Returns a new object of class '<em>Ifc Zone</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Zone</em>'.
	 * @generated
	 */
	IfcZone createIfcZone();

	/**
	 * Returns a new object of class '<em>Ifc Stripped Optional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Stripped Optional</em>'.
	 * @generated
	 */
	IfcStrippedOptional createIfcStrippedOptional();

	/**
	 * Returns a new object of class '<em>Ifc Absorbed Dose Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Absorbed Dose Measure</em>'.
	 * @generated
	 */
	IfcAbsorbedDoseMeasure createIfcAbsorbedDoseMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Acceleration Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Acceleration Measure</em>'.
	 * @generated
	 */
	IfcAccelerationMeasure createIfcAccelerationMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Amount Of Substance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Amount Of Substance Measure</em>'.
	 * @generated
	 */
	IfcAmountOfSubstanceMeasure createIfcAmountOfSubstanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Angular Velocity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Angular Velocity Measure</em>'.
	 * @generated
	 */
	IfcAngularVelocityMeasure createIfcAngularVelocityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Area Density Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Area Density Measure</em>'.
	 * @generated
	 */
	IfcAreaDensityMeasure createIfcAreaDensityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Area Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Area Measure</em>'.
	 * @generated
	 */
	IfcAreaMeasure createIfcAreaMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Binary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Binary</em>'.
	 * @generated
	 */
	IfcBinary createIfcBinary();

	/**
	 * Returns a new object of class '<em>Ifc Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Boolean</em>'.
	 * @generated
	 */
	IfcBoolean createIfcBoolean();

	/**
	 * Returns a new object of class '<em>Ifc Cardinal Point Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Cardinal Point Reference</em>'.
	 * @generated
	 */
	IfcCardinalPointReference createIfcCardinalPointReference();

	/**
	 * Returns a new object of class '<em>Ifc Context Dependent Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Context Dependent Measure</em>'.
	 * @generated
	 */
	IfcContextDependentMeasure createIfcContextDependentMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Count Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Count Measure</em>'.
	 * @generated
	 */
	IfcCountMeasure createIfcCountMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Curvature Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Curvature Measure</em>'.
	 * @generated
	 */
	IfcCurvatureMeasure createIfcCurvatureMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Date</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Date</em>'.
	 * @generated
	 */
	IfcDate createIfcDate();

	/**
	 * Returns a new object of class '<em>Ifc Date Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Date Time</em>'.
	 * @generated
	 */
	IfcDateTime createIfcDateTime();

	/**
	 * Returns a new object of class '<em>Ifc Day In Month Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Day In Month Number</em>'.
	 * @generated
	 */
	IfcDayInMonthNumber createIfcDayInMonthNumber();

	/**
	 * Returns a new object of class '<em>Ifc Day In Week Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Day In Week Number</em>'.
	 * @generated
	 */
	IfcDayInWeekNumber createIfcDayInWeekNumber();

	/**
	 * Returns a new object of class '<em>Ifc Descriptive Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Descriptive Measure</em>'.
	 * @generated
	 */
	IfcDescriptiveMeasure createIfcDescriptiveMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Dimension Count</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Dimension Count</em>'.
	 * @generated
	 */
	IfcDimensionCount createIfcDimensionCount();

	/**
	 * Returns a new object of class '<em>Ifc Dose Equivalent Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Dose Equivalent Measure</em>'.
	 * @generated
	 */
	IfcDoseEquivalentMeasure createIfcDoseEquivalentMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Duration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Duration</em>'.
	 * @generated
	 */
	IfcDuration createIfcDuration();

	/**
	 * Returns a new object of class '<em>Ifc Dynamic Viscosity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Dynamic Viscosity Measure</em>'.
	 * @generated
	 */
	IfcDynamicViscosityMeasure createIfcDynamicViscosityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Electric Capacitance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Capacitance Measure</em>'.
	 * @generated
	 */
	IfcElectricCapacitanceMeasure createIfcElectricCapacitanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Electric Charge Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Charge Measure</em>'.
	 * @generated
	 */
	IfcElectricChargeMeasure createIfcElectricChargeMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Electric Conductance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Conductance Measure</em>'.
	 * @generated
	 */
	IfcElectricConductanceMeasure createIfcElectricConductanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Electric Current Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Current Measure</em>'.
	 * @generated
	 */
	IfcElectricCurrentMeasure createIfcElectricCurrentMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Electric Resistance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Resistance Measure</em>'.
	 * @generated
	 */
	IfcElectricResistanceMeasure createIfcElectricResistanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Electric Voltage Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Electric Voltage Measure</em>'.
	 * @generated
	 */
	IfcElectricVoltageMeasure createIfcElectricVoltageMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Energy Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Energy Measure</em>'.
	 * @generated
	 */
	IfcEnergyMeasure createIfcEnergyMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Font Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Font Style</em>'.
	 * @generated
	 */
	IfcFontStyle createIfcFontStyle();

	/**
	 * Returns a new object of class '<em>Ifc Font Variant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Font Variant</em>'.
	 * @generated
	 */
	IfcFontVariant createIfcFontVariant();

	/**
	 * Returns a new object of class '<em>Ifc Font Weight</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Font Weight</em>'.
	 * @generated
	 */
	IfcFontWeight createIfcFontWeight();

	/**
	 * Returns a new object of class '<em>Ifc Force Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Force Measure</em>'.
	 * @generated
	 */
	IfcForceMeasure createIfcForceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Frequency Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Frequency Measure</em>'.
	 * @generated
	 */
	IfcFrequencyMeasure createIfcFrequencyMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Globally Unique Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Globally Unique Id</em>'.
	 * @generated
	 */
	IfcGloballyUniqueId createIfcGloballyUniqueId();

	/**
	 * Returns a new object of class '<em>Ifc Heat Flux Density Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Heat Flux Density Measure</em>'.
	 * @generated
	 */
	IfcHeatFluxDensityMeasure createIfcHeatFluxDensityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Heating Value Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Heating Value Measure</em>'.
	 * @generated
	 */
	IfcHeatingValueMeasure createIfcHeatingValueMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Identifier</em>'.
	 * @generated
	 */
	IfcIdentifier createIfcIdentifier();

	/**
	 * Returns a new object of class '<em>Ifc Illuminance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Illuminance Measure</em>'.
	 * @generated
	 */
	IfcIlluminanceMeasure createIfcIlluminanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Inductance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Inductance Measure</em>'.
	 * @generated
	 */
	IfcInductanceMeasure createIfcInductanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Integer</em>'.
	 * @generated
	 */
	IfcInteger createIfcInteger();

	/**
	 * Returns a new object of class '<em>Ifc Integer Count Rate Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Integer Count Rate Measure</em>'.
	 * @generated
	 */
	IfcIntegerCountRateMeasure createIfcIntegerCountRateMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Ion Concentration Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Ion Concentration Measure</em>'.
	 * @generated
	 */
	IfcIonConcentrationMeasure createIfcIonConcentrationMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Isothermal Moisture Capacity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Isothermal Moisture Capacity Measure</em>'.
	 * @generated
	 */
	IfcIsothermalMoistureCapacityMeasure createIfcIsothermalMoistureCapacityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Kinematic Viscosity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Kinematic Viscosity Measure</em>'.
	 * @generated
	 */
	IfcKinematicViscosityMeasure createIfcKinematicViscosityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Label</em>'.
	 * @generated
	 */
	IfcLabel createIfcLabel();

	/**
	 * Returns a new object of class '<em>Ifc Length Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Length Measure</em>'.
	 * @generated
	 */
	IfcLengthMeasure createIfcLengthMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Linear Force Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Linear Force Measure</em>'.
	 * @generated
	 */
	IfcLinearForceMeasure createIfcLinearForceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Linear Moment Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Linear Moment Measure</em>'.
	 * @generated
	 */
	IfcLinearMomentMeasure createIfcLinearMomentMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Linear Stiffness Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Linear Stiffness Measure</em>'.
	 * @generated
	 */
	IfcLinearStiffnessMeasure createIfcLinearStiffnessMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Linear Velocity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Linear Velocity Measure</em>'.
	 * @generated
	 */
	IfcLinearVelocityMeasure createIfcLinearVelocityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Logical</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Logical</em>'.
	 * @generated
	 */
	IfcLogical createIfcLogical();

	/**
	 * Returns a new object of class '<em>Ifc Luminous Flux Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Luminous Flux Measure</em>'.
	 * @generated
	 */
	IfcLuminousFluxMeasure createIfcLuminousFluxMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Luminous Intensity Distribution Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Luminous Intensity Distribution Measure</em>'.
	 * @generated
	 */
	IfcLuminousIntensityDistributionMeasure createIfcLuminousIntensityDistributionMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Luminous Intensity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Luminous Intensity Measure</em>'.
	 * @generated
	 */
	IfcLuminousIntensityMeasure createIfcLuminousIntensityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Magnetic Flux Density Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Magnetic Flux Density Measure</em>'.
	 * @generated
	 */
	IfcMagneticFluxDensityMeasure createIfcMagneticFluxDensityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Magnetic Flux Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Magnetic Flux Measure</em>'.
	 * @generated
	 */
	IfcMagneticFluxMeasure createIfcMagneticFluxMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Mass Density Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Mass Density Measure</em>'.
	 * @generated
	 */
	IfcMassDensityMeasure createIfcMassDensityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Mass Flow Rate Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Mass Flow Rate Measure</em>'.
	 * @generated
	 */
	IfcMassFlowRateMeasure createIfcMassFlowRateMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Mass Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Mass Measure</em>'.
	 * @generated
	 */
	IfcMassMeasure createIfcMassMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Mass Per Length Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Mass Per Length Measure</em>'.
	 * @generated
	 */
	IfcMassPerLengthMeasure createIfcMassPerLengthMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Modulus Of Elasticity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Modulus Of Elasticity Measure</em>'.
	 * @generated
	 */
	IfcModulusOfElasticityMeasure createIfcModulusOfElasticityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Modulus Of Linear Subgrade Reaction Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Modulus Of Linear Subgrade Reaction Measure</em>'.
	 * @generated
	 */
	IfcModulusOfLinearSubgradeReactionMeasure createIfcModulusOfLinearSubgradeReactionMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Modulus Of Rotational Subgrade Reaction Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Modulus Of Rotational Subgrade Reaction Measure</em>'.
	 * @generated
	 */
	IfcModulusOfRotationalSubgradeReactionMeasure createIfcModulusOfRotationalSubgradeReactionMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Modulus Of Subgrade Reaction Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Modulus Of Subgrade Reaction Measure</em>'.
	 * @generated
	 */
	IfcModulusOfSubgradeReactionMeasure createIfcModulusOfSubgradeReactionMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Moisture Diffusivity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Moisture Diffusivity Measure</em>'.
	 * @generated
	 */
	IfcMoistureDiffusivityMeasure createIfcMoistureDiffusivityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Molecular Weight Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Molecular Weight Measure</em>'.
	 * @generated
	 */
	IfcMolecularWeightMeasure createIfcMolecularWeightMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Moment Of Inertia Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Moment Of Inertia Measure</em>'.
	 * @generated
	 */
	IfcMomentOfInertiaMeasure createIfcMomentOfInertiaMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Monetary Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Monetary Measure</em>'.
	 * @generated
	 */
	IfcMonetaryMeasure createIfcMonetaryMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Month In Year Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Month In Year Number</em>'.
	 * @generated
	 */
	IfcMonthInYearNumber createIfcMonthInYearNumber();

	/**
	 * Returns a new object of class '<em>Ifc Numeric Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Numeric Measure</em>'.
	 * @generated
	 */
	IfcNumericMeasure createIfcNumericMeasure();

	/**
	 * Returns a new object of class '<em>Ifc PH Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc PH Measure</em>'.
	 * @generated
	 */
	IfcPHMeasure createIfcPHMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Parameter Value</em>'.
	 * @generated
	 */
	IfcParameterValue createIfcParameterValue();

	/**
	 * Returns a new object of class '<em>Ifc Planar Force Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Planar Force Measure</em>'.
	 * @generated
	 */
	IfcPlanarForceMeasure createIfcPlanarForceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Plane Angle Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Plane Angle Measure</em>'.
	 * @generated
	 */
	IfcPlaneAngleMeasure createIfcPlaneAngleMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Power Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Power Measure</em>'.
	 * @generated
	 */
	IfcPowerMeasure createIfcPowerMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Presentable Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Presentable Text</em>'.
	 * @generated
	 */
	IfcPresentableText createIfcPresentableText();

	/**
	 * Returns a new object of class '<em>Ifc Pressure Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Pressure Measure</em>'.
	 * @generated
	 */
	IfcPressureMeasure createIfcPressureMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Radio Activity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Radio Activity Measure</em>'.
	 * @generated
	 */
	IfcRadioActivityMeasure createIfcRadioActivityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Ratio Measure</em>'.
	 * @generated
	 */
	IfcRatioMeasure createIfcRatioMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Real</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Real</em>'.
	 * @generated
	 */
	IfcReal createIfcReal();

	/**
	 * Returns a new object of class '<em>Ifc Rotational Frequency Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rotational Frequency Measure</em>'.
	 * @generated
	 */
	IfcRotationalFrequencyMeasure createIfcRotationalFrequencyMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Rotational Mass Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rotational Mass Measure</em>'.
	 * @generated
	 */
	IfcRotationalMassMeasure createIfcRotationalMassMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Rotational Stiffness Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Rotational Stiffness Measure</em>'.
	 * @generated
	 */
	IfcRotationalStiffnessMeasure createIfcRotationalStiffnessMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Section Modulus Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Section Modulus Measure</em>'.
	 * @generated
	 */
	IfcSectionModulusMeasure createIfcSectionModulusMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Sectional Area Integral Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sectional Area Integral Measure</em>'.
	 * @generated
	 */
	IfcSectionalAreaIntegralMeasure createIfcSectionalAreaIntegralMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Shear Modulus Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Shear Modulus Measure</em>'.
	 * @generated
	 */
	IfcShearModulusMeasure createIfcShearModulusMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Solid Angle Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Solid Angle Measure</em>'.
	 * @generated
	 */
	IfcSolidAngleMeasure createIfcSolidAngleMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Sound Power Level Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sound Power Level Measure</em>'.
	 * @generated
	 */
	IfcSoundPowerLevelMeasure createIfcSoundPowerLevelMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Sound Power Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sound Power Measure</em>'.
	 * @generated
	 */
	IfcSoundPowerMeasure createIfcSoundPowerMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Sound Pressure Level Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sound Pressure Level Measure</em>'.
	 * @generated
	 */
	IfcSoundPressureLevelMeasure createIfcSoundPressureLevelMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Sound Pressure Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Sound Pressure Measure</em>'.
	 * @generated
	 */
	IfcSoundPressureMeasure createIfcSoundPressureMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Specific Heat Capacity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Specific Heat Capacity Measure</em>'.
	 * @generated
	 */
	IfcSpecificHeatCapacityMeasure createIfcSpecificHeatCapacityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Specular Exponent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Specular Exponent</em>'.
	 * @generated
	 */
	IfcSpecularExponent createIfcSpecularExponent();

	/**
	 * Returns a new object of class '<em>Ifc Specular Roughness</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Specular Roughness</em>'.
	 * @generated
	 */
	IfcSpecularRoughness createIfcSpecularRoughness();

	/**
	 * Returns a new object of class '<em>Ifc Temperature Gradient Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Temperature Gradient Measure</em>'.
	 * @generated
	 */
	IfcTemperatureGradientMeasure createIfcTemperatureGradientMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Temperature Rate Of Change Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Temperature Rate Of Change Measure</em>'.
	 * @generated
	 */
	IfcTemperatureRateOfChangeMeasure createIfcTemperatureRateOfChangeMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text</em>'.
	 * @generated
	 */
	IfcText createIfcText();

	/**
	 * Returns a new object of class '<em>Ifc Text Alignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Alignment</em>'.
	 * @generated
	 */
	IfcTextAlignment createIfcTextAlignment();

	/**
	 * Returns a new object of class '<em>Ifc Text Decoration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Decoration</em>'.
	 * @generated
	 */
	IfcTextDecoration createIfcTextDecoration();

	/**
	 * Returns a new object of class '<em>Ifc Text Font Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Font Name</em>'.
	 * @generated
	 */
	IfcTextFontName createIfcTextFontName();

	/**
	 * Returns a new object of class '<em>Ifc Text Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Text Transformation</em>'.
	 * @generated
	 */
	IfcTextTransformation createIfcTextTransformation();

	/**
	 * Returns a new object of class '<em>Ifc Thermal Admittance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Thermal Admittance Measure</em>'.
	 * @generated
	 */
	IfcThermalAdmittanceMeasure createIfcThermalAdmittanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Thermal Conductivity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Thermal Conductivity Measure</em>'.
	 * @generated
	 */
	IfcThermalConductivityMeasure createIfcThermalConductivityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Thermal Expansion Coefficient Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Thermal Expansion Coefficient Measure</em>'.
	 * @generated
	 */
	IfcThermalExpansionCoefficientMeasure createIfcThermalExpansionCoefficientMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Thermal Resistance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Thermal Resistance Measure</em>'.
	 * @generated
	 */
	IfcThermalResistanceMeasure createIfcThermalResistanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Thermal Transmittance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Thermal Transmittance Measure</em>'.
	 * @generated
	 */
	IfcThermalTransmittanceMeasure createIfcThermalTransmittanceMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Thermodynamic Temperature Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Thermodynamic Temperature Measure</em>'.
	 * @generated
	 */
	IfcThermodynamicTemperatureMeasure createIfcThermodynamicTemperatureMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Time</em>'.
	 * @generated
	 */
	IfcTime createIfcTime();

	/**
	 * Returns a new object of class '<em>Ifc Time Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Time Measure</em>'.
	 * @generated
	 */
	IfcTimeMeasure createIfcTimeMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Time Stamp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Time Stamp</em>'.
	 * @generated
	 */
	IfcTimeStamp createIfcTimeStamp();

	/**
	 * Returns a new object of class '<em>Ifc Torque Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Torque Measure</em>'.
	 * @generated
	 */
	IfcTorqueMeasure createIfcTorqueMeasure();

	/**
	 * Returns a new object of class '<em>Ifc URI Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc URI Reference</em>'.
	 * @generated
	 */
	IfcURIReference createIfcURIReference();

	/**
	 * Returns a new object of class '<em>Ifc Vapor Permeability Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Vapor Permeability Measure</em>'.
	 * @generated
	 */
	IfcVaporPermeabilityMeasure createIfcVaporPermeabilityMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Volume Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Volume Measure</em>'.
	 * @generated
	 */
	IfcVolumeMeasure createIfcVolumeMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Volumetric Flow Rate Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Volumetric Flow Rate Measure</em>'.
	 * @generated
	 */
	IfcVolumetricFlowRateMeasure createIfcVolumetricFlowRateMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Warping Constant Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Warping Constant Measure</em>'.
	 * @generated
	 */
	IfcWarpingConstantMeasure createIfcWarpingConstantMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Warping Moment Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Warping Moment Measure</em>'.
	 * @generated
	 */
	IfcWarpingMomentMeasure createIfcWarpingMomentMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Box Alignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Box Alignment</em>'.
	 * @generated
	 */
	IfcBoxAlignment createIfcBoxAlignment();

	/**
	 * Returns a new object of class '<em>Ifc Compound Plane Angle Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Compound Plane Angle Measure</em>'.
	 * @generated
	 */
	IfcCompoundPlaneAngleMeasure createIfcCompoundPlaneAngleMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Language Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Language Id</em>'.
	 * @generated
	 */
	IfcLanguageId createIfcLanguageId();

	/**
	 * Returns a new object of class '<em>Ifc Non Negative Length Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Non Negative Length Measure</em>'.
	 * @generated
	 */
	IfcNonNegativeLengthMeasure createIfcNonNegativeLengthMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Normalised Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Normalised Ratio Measure</em>'.
	 * @generated
	 */
	IfcNormalisedRatioMeasure createIfcNormalisedRatioMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Positive Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Positive Integer</em>'.
	 * @generated
	 */
	IfcPositiveInteger createIfcPositiveInteger();

	/**
	 * Returns a new object of class '<em>Ifc Positive Length Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Positive Length Measure</em>'.
	 * @generated
	 */
	IfcPositiveLengthMeasure createIfcPositiveLengthMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Positive Plane Angle Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Positive Plane Angle Measure</em>'.
	 * @generated
	 */
	IfcPositivePlaneAngleMeasure createIfcPositivePlaneAngleMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Positive Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Positive Ratio Measure</em>'.
	 * @generated
	 */
	IfcPositiveRatioMeasure createIfcPositiveRatioMeasure();

	/**
	 * Returns a new object of class '<em>Ifc Arc Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Arc Index</em>'.
	 * @generated
	 */
	IfcArcIndex createIfcArcIndex();

	/**
	 * Returns a new object of class '<em>Ifc Complex Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Complex Number</em>'.
	 * @generated
	 */
	IfcComplexNumber createIfcComplexNumber();

	/**
	 * Returns a new object of class '<em>Ifc Line Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Line Index</em>'.
	 * @generated
	 */
	IfcLineIndex createIfcLineIndex();

	/**
	 * Returns a new object of class '<em>Ifc Null Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ifc Null Style</em>'.
	 * @generated
	 */
	IfcNullStyle createIfcNullStyle();

	/**
	 * Returns a new object of class '<em>List Of Ifc Cartesian Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Of Ifc Cartesian Point</em>'.
	 * @generated
	 */
	ListOfIfcCartesianPoint createListOfIfcCartesianPoint();

	/**
	 * Returns a new object of class '<em>List Of Ifc Length Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Of Ifc Length Measure</em>'.
	 * @generated
	 */
	ListOfIfcLengthMeasure createListOfIfcLengthMeasure();

	/**
	 * Returns a new object of class '<em>List Of Ifc Normalised Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Of Ifc Normalised Ratio Measure</em>'.
	 * @generated
	 */
	ListOfIfcNormalisedRatioMeasure createListOfIfcNormalisedRatioMeasure();

	/**
	 * Returns a new object of class '<em>List Of ELong</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Of ELong</em>'.
	 * @generated
	 */
	ListOfELong createListOfELong();

	/**
	 * Returns a new object of class '<em>List Of EDouble</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Of EDouble</em>'.
	 * @generated
	 */
	ListOfEDouble createListOfEDouble();

	/**
	 * Returns a new object of class '<em>List Of Ifc Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Of Ifc Parameter Value</em>'.
	 * @generated
	 */
	ListOfIfcParameterValue createListOfIfcParameterValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Ifc4Package getIfc4Package();

} //Ifc4Factory
