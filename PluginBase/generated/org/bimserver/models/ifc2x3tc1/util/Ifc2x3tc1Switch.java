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
package org.bimserver.models.ifc2x3tc1.util;

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package
 * @generated
 */
public class Ifc2x3tc1Switch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Ifc2x3tc1Package modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifc2x3tc1Switch() {
		if (modelPackage == null) {
			modelPackage = Ifc2x3tc1Package.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case Ifc2x3tc1Package.IFC2_DCOMPOSITE_CURVE: {
			Ifc2DCompositeCurve ifc2DCompositeCurve = (Ifc2DCompositeCurve) theEObject;
			T result = caseIfc2DCompositeCurve(ifc2DCompositeCurve);
			if (result == null)
				result = caseIfcCompositeCurve(ifc2DCompositeCurve);
			if (result == null)
				result = caseIfcBoundedCurve(ifc2DCompositeCurve);
			if (result == null)
				result = caseIfcCurve(ifc2DCompositeCurve);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifc2DCompositeCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifc2DCompositeCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifc2DCompositeCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifc2DCompositeCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifc2DCompositeCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ACTION_REQUEST: {
			IfcActionRequest ifcActionRequest = (IfcActionRequest) theEObject;
			T result = caseIfcActionRequest(ifcActionRequest);
			if (result == null)
				result = caseIfcControl(ifcActionRequest);
			if (result == null)
				result = caseIfcObject(ifcActionRequest);
			if (result == null)
				result = caseIfcObjectDefinition(ifcActionRequest);
			if (result == null)
				result = caseIfcRoot(ifcActionRequest);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ACTOR: {
			IfcActor ifcActor = (IfcActor) theEObject;
			T result = caseIfcActor(ifcActor);
			if (result == null)
				result = caseIfcObject(ifcActor);
			if (result == null)
				result = caseIfcObjectDefinition(ifcActor);
			if (result == null)
				result = caseIfcRoot(ifcActor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ACTOR_ROLE: {
			IfcActorRole ifcActorRole = (IfcActorRole) theEObject;
			T result = caseIfcActorRole(ifcActorRole);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ACTUATOR_TYPE: {
			IfcActuatorType ifcActuatorType = (IfcActuatorType) theEObject;
			T result = caseIfcActuatorType(ifcActuatorType);
			if (result == null)
				result = caseIfcDistributionControlElementType(ifcActuatorType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcActuatorType);
			if (result == null)
				result = caseIfcElementType(ifcActuatorType);
			if (result == null)
				result = caseIfcTypeProduct(ifcActuatorType);
			if (result == null)
				result = caseIfcTypeObject(ifcActuatorType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcActuatorType);
			if (result == null)
				result = caseIfcRoot(ifcActuatorType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ADDRESS: {
			IfcAddress ifcAddress = (IfcAddress) theEObject;
			T result = caseIfcAddress(ifcAddress);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcAddress);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AIR_TERMINAL_BOX_TYPE: {
			IfcAirTerminalBoxType ifcAirTerminalBoxType = (IfcAirTerminalBoxType) theEObject;
			T result = caseIfcAirTerminalBoxType(ifcAirTerminalBoxType);
			if (result == null)
				result = caseIfcFlowControllerType(ifcAirTerminalBoxType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcAirTerminalBoxType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcAirTerminalBoxType);
			if (result == null)
				result = caseIfcElementType(ifcAirTerminalBoxType);
			if (result == null)
				result = caseIfcTypeProduct(ifcAirTerminalBoxType);
			if (result == null)
				result = caseIfcTypeObject(ifcAirTerminalBoxType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcAirTerminalBoxType);
			if (result == null)
				result = caseIfcRoot(ifcAirTerminalBoxType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AIR_TERMINAL_TYPE: {
			IfcAirTerminalType ifcAirTerminalType = (IfcAirTerminalType) theEObject;
			T result = caseIfcAirTerminalType(ifcAirTerminalType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcAirTerminalType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcAirTerminalType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcAirTerminalType);
			if (result == null)
				result = caseIfcElementType(ifcAirTerminalType);
			if (result == null)
				result = caseIfcTypeProduct(ifcAirTerminalType);
			if (result == null)
				result = caseIfcTypeObject(ifcAirTerminalType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcAirTerminalType);
			if (result == null)
				result = caseIfcRoot(ifcAirTerminalType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AIR_TO_AIR_HEAT_RECOVERY_TYPE: {
			IfcAirToAirHeatRecoveryType ifcAirToAirHeatRecoveryType = (IfcAirToAirHeatRecoveryType) theEObject;
			T result = caseIfcAirToAirHeatRecoveryType(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = caseIfcElementType(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = caseIfcTypeProduct(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = caseIfcTypeObject(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = caseIfcRoot(ifcAirToAirHeatRecoveryType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ALARM_TYPE: {
			IfcAlarmType ifcAlarmType = (IfcAlarmType) theEObject;
			T result = caseIfcAlarmType(ifcAlarmType);
			if (result == null)
				result = caseIfcDistributionControlElementType(ifcAlarmType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcAlarmType);
			if (result == null)
				result = caseIfcElementType(ifcAlarmType);
			if (result == null)
				result = caseIfcTypeProduct(ifcAlarmType);
			if (result == null)
				result = caseIfcTypeObject(ifcAlarmType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcAlarmType);
			if (result == null)
				result = caseIfcRoot(ifcAlarmType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANGULAR_DIMENSION: {
			IfcAngularDimension ifcAngularDimension = (IfcAngularDimension) theEObject;
			T result = caseIfcAngularDimension(ifcAngularDimension);
			if (result == null)
				result = caseIfcDimensionCurveDirectedCallout(ifcAngularDimension);
			if (result == null)
				result = caseIfcDraughtingCallout(ifcAngularDimension);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcAngularDimension);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAngularDimension);
			if (result == null)
				result = caseIfcLayeredItem(ifcAngularDimension);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION: {
			IfcAnnotation ifcAnnotation = (IfcAnnotation) theEObject;
			T result = caseIfcAnnotation(ifcAnnotation);
			if (result == null)
				result = caseIfcProduct(ifcAnnotation);
			if (result == null)
				result = caseIfcObject(ifcAnnotation);
			if (result == null)
				result = caseIfcObjectDefinition(ifcAnnotation);
			if (result == null)
				result = caseIfcRoot(ifcAnnotation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION_CURVE_OCCURRENCE: {
			IfcAnnotationCurveOccurrence ifcAnnotationCurveOccurrence = (IfcAnnotationCurveOccurrence) theEObject;
			T result = caseIfcAnnotationCurveOccurrence(ifcAnnotationCurveOccurrence);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcAnnotationCurveOccurrence);
			if (result == null)
				result = caseIfcDraughtingCalloutElement(ifcAnnotationCurveOccurrence);
			if (result == null)
				result = caseIfcStyledItem(ifcAnnotationCurveOccurrence);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAnnotationCurveOccurrence);
			if (result == null)
				result = caseIfcLayeredItem(ifcAnnotationCurveOccurrence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION_FILL_AREA: {
			IfcAnnotationFillArea ifcAnnotationFillArea = (IfcAnnotationFillArea) theEObject;
			T result = caseIfcAnnotationFillArea(ifcAnnotationFillArea);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcAnnotationFillArea);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAnnotationFillArea);
			if (result == null)
				result = caseIfcLayeredItem(ifcAnnotationFillArea);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION_FILL_AREA_OCCURRENCE: {
			IfcAnnotationFillAreaOccurrence ifcAnnotationFillAreaOccurrence = (IfcAnnotationFillAreaOccurrence) theEObject;
			T result = caseIfcAnnotationFillAreaOccurrence(ifcAnnotationFillAreaOccurrence);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcAnnotationFillAreaOccurrence);
			if (result == null)
				result = caseIfcStyledItem(ifcAnnotationFillAreaOccurrence);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAnnotationFillAreaOccurrence);
			if (result == null)
				result = caseIfcLayeredItem(ifcAnnotationFillAreaOccurrence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION_OCCURRENCE: {
			IfcAnnotationOccurrence ifcAnnotationOccurrence = (IfcAnnotationOccurrence) theEObject;
			T result = caseIfcAnnotationOccurrence(ifcAnnotationOccurrence);
			if (result == null)
				result = caseIfcStyledItem(ifcAnnotationOccurrence);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAnnotationOccurrence);
			if (result == null)
				result = caseIfcLayeredItem(ifcAnnotationOccurrence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION_SURFACE: {
			IfcAnnotationSurface ifcAnnotationSurface = (IfcAnnotationSurface) theEObject;
			T result = caseIfcAnnotationSurface(ifcAnnotationSurface);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcAnnotationSurface);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAnnotationSurface);
			if (result == null)
				result = caseIfcLayeredItem(ifcAnnotationSurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION_SURFACE_OCCURRENCE: {
			IfcAnnotationSurfaceOccurrence ifcAnnotationSurfaceOccurrence = (IfcAnnotationSurfaceOccurrence) theEObject;
			T result = caseIfcAnnotationSurfaceOccurrence(ifcAnnotationSurfaceOccurrence);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcAnnotationSurfaceOccurrence);
			if (result == null)
				result = caseIfcStyledItem(ifcAnnotationSurfaceOccurrence);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAnnotationSurfaceOccurrence);
			if (result == null)
				result = caseIfcLayeredItem(ifcAnnotationSurfaceOccurrence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION_SYMBOL_OCCURRENCE: {
			IfcAnnotationSymbolOccurrence ifcAnnotationSymbolOccurrence = (IfcAnnotationSymbolOccurrence) theEObject;
			T result = caseIfcAnnotationSymbolOccurrence(ifcAnnotationSymbolOccurrence);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcAnnotationSymbolOccurrence);
			if (result == null)
				result = caseIfcDraughtingCalloutElement(ifcAnnotationSymbolOccurrence);
			if (result == null)
				result = caseIfcStyledItem(ifcAnnotationSymbolOccurrence);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAnnotationSymbolOccurrence);
			if (result == null)
				result = caseIfcLayeredItem(ifcAnnotationSymbolOccurrence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANNOTATION_TEXT_OCCURRENCE: {
			IfcAnnotationTextOccurrence ifcAnnotationTextOccurrence = (IfcAnnotationTextOccurrence) theEObject;
			T result = caseIfcAnnotationTextOccurrence(ifcAnnotationTextOccurrence);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcAnnotationTextOccurrence);
			if (result == null)
				result = caseIfcDraughtingCalloutElement(ifcAnnotationTextOccurrence);
			if (result == null)
				result = caseIfcStyledItem(ifcAnnotationTextOccurrence);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAnnotationTextOccurrence);
			if (result == null)
				result = caseIfcLayeredItem(ifcAnnotationTextOccurrence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_APPLICATION: {
			IfcApplication ifcApplication = (IfcApplication) theEObject;
			T result = caseIfcApplication(ifcApplication);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_APPLIED_VALUE: {
			IfcAppliedValue ifcAppliedValue = (IfcAppliedValue) theEObject;
			T result = caseIfcAppliedValue(ifcAppliedValue);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcAppliedValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_APPLIED_VALUE_RELATIONSHIP: {
			IfcAppliedValueRelationship ifcAppliedValueRelationship = (IfcAppliedValueRelationship) theEObject;
			T result = caseIfcAppliedValueRelationship(ifcAppliedValueRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_APPROVAL: {
			IfcApproval ifcApproval = (IfcApproval) theEObject;
			T result = caseIfcApproval(ifcApproval);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_APPROVAL_ACTOR_RELATIONSHIP: {
			IfcApprovalActorRelationship ifcApprovalActorRelationship = (IfcApprovalActorRelationship) theEObject;
			T result = caseIfcApprovalActorRelationship(ifcApprovalActorRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_APPROVAL_PROPERTY_RELATIONSHIP: {
			IfcApprovalPropertyRelationship ifcApprovalPropertyRelationship = (IfcApprovalPropertyRelationship) theEObject;
			T result = caseIfcApprovalPropertyRelationship(ifcApprovalPropertyRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_APPROVAL_RELATIONSHIP: {
			IfcApprovalRelationship ifcApprovalRelationship = (IfcApprovalRelationship) theEObject;
			T result = caseIfcApprovalRelationship(ifcApprovalRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ARBITRARY_CLOSED_PROFILE_DEF: {
			IfcArbitraryClosedProfileDef ifcArbitraryClosedProfileDef = (IfcArbitraryClosedProfileDef) theEObject;
			T result = caseIfcArbitraryClosedProfileDef(ifcArbitraryClosedProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcArbitraryClosedProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ARBITRARY_OPEN_PROFILE_DEF: {
			IfcArbitraryOpenProfileDef ifcArbitraryOpenProfileDef = (IfcArbitraryOpenProfileDef) theEObject;
			T result = caseIfcArbitraryOpenProfileDef(ifcArbitraryOpenProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcArbitraryOpenProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ARBITRARY_PROFILE_DEF_WITH_VOIDS: {
			IfcArbitraryProfileDefWithVoids ifcArbitraryProfileDefWithVoids = (IfcArbitraryProfileDefWithVoids) theEObject;
			T result = caseIfcArbitraryProfileDefWithVoids(ifcArbitraryProfileDefWithVoids);
			if (result == null)
				result = caseIfcArbitraryClosedProfileDef(ifcArbitraryProfileDefWithVoids);
			if (result == null)
				result = caseIfcProfileDef(ifcArbitraryProfileDefWithVoids);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ASSET: {
			IfcAsset ifcAsset = (IfcAsset) theEObject;
			T result = caseIfcAsset(ifcAsset);
			if (result == null)
				result = caseIfcGroup(ifcAsset);
			if (result == null)
				result = caseIfcObject(ifcAsset);
			if (result == null)
				result = caseIfcObjectDefinition(ifcAsset);
			if (result == null)
				result = caseIfcRoot(ifcAsset);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ASYMMETRIC_ISHAPE_PROFILE_DEF: {
			IfcAsymmetricIShapeProfileDef ifcAsymmetricIShapeProfileDef = (IfcAsymmetricIShapeProfileDef) theEObject;
			T result = caseIfcAsymmetricIShapeProfileDef(ifcAsymmetricIShapeProfileDef);
			if (result == null)
				result = caseIfcIShapeProfileDef(ifcAsymmetricIShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcAsymmetricIShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcAsymmetricIShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AXIS1_PLACEMENT: {
			IfcAxis1Placement ifcAxis1Placement = (IfcAxis1Placement) theEObject;
			T result = caseIfcAxis1Placement(ifcAxis1Placement);
			if (result == null)
				result = caseIfcPlacement(ifcAxis1Placement);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcAxis1Placement);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAxis1Placement);
			if (result == null)
				result = caseIfcLayeredItem(ifcAxis1Placement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AXIS2_PLACEMENT2_D: {
			IfcAxis2Placement2D ifcAxis2Placement2D = (IfcAxis2Placement2D) theEObject;
			T result = caseIfcAxis2Placement2D(ifcAxis2Placement2D);
			if (result == null)
				result = caseIfcPlacement(ifcAxis2Placement2D);
			if (result == null)
				result = caseIfcAxis2Placement(ifcAxis2Placement2D);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcAxis2Placement2D);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAxis2Placement2D);
			if (result == null)
				result = caseIfcLayeredItem(ifcAxis2Placement2D);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AXIS2_PLACEMENT3_D: {
			IfcAxis2Placement3D ifcAxis2Placement3D = (IfcAxis2Placement3D) theEObject;
			T result = caseIfcAxis2Placement3D(ifcAxis2Placement3D);
			if (result == null)
				result = caseIfcPlacement(ifcAxis2Placement3D);
			if (result == null)
				result = caseIfcAxis2Placement(ifcAxis2Placement3D);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcAxis2Placement3D);
			if (result == null)
				result = caseIfcRepresentationItem(ifcAxis2Placement3D);
			if (result == null)
				result = caseIfcLayeredItem(ifcAxis2Placement3D);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BSPLINE_CURVE: {
			IfcBSplineCurve ifcBSplineCurve = (IfcBSplineCurve) theEObject;
			T result = caseIfcBSplineCurve(ifcBSplineCurve);
			if (result == null)
				result = caseIfcBoundedCurve(ifcBSplineCurve);
			if (result == null)
				result = caseIfcCurve(ifcBSplineCurve);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifcBSplineCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBSplineCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcBSplineCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBSplineCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcBSplineCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BEAM: {
			IfcBeam ifcBeam = (IfcBeam) theEObject;
			T result = caseIfcBeam(ifcBeam);
			if (result == null)
				result = caseIfcBuildingElement(ifcBeam);
			if (result == null)
				result = caseIfcElement(ifcBeam);
			if (result == null)
				result = caseIfcProduct(ifcBeam);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcBeam);
			if (result == null)
				result = caseIfcObject(ifcBeam);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBeam);
			if (result == null)
				result = caseIfcRoot(ifcBeam);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BEAM_TYPE: {
			IfcBeamType ifcBeamType = (IfcBeamType) theEObject;
			T result = caseIfcBeamType(ifcBeamType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcBeamType);
			if (result == null)
				result = caseIfcElementType(ifcBeamType);
			if (result == null)
				result = caseIfcTypeProduct(ifcBeamType);
			if (result == null)
				result = caseIfcTypeObject(ifcBeamType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBeamType);
			if (result == null)
				result = caseIfcRoot(ifcBeamType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BEZIER_CURVE: {
			IfcBezierCurve ifcBezierCurve = (IfcBezierCurve) theEObject;
			T result = caseIfcBezierCurve(ifcBezierCurve);
			if (result == null)
				result = caseIfcBSplineCurve(ifcBezierCurve);
			if (result == null)
				result = caseIfcBoundedCurve(ifcBezierCurve);
			if (result == null)
				result = caseIfcCurve(ifcBezierCurve);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifcBezierCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBezierCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcBezierCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBezierCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcBezierCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BLOB_TEXTURE: {
			IfcBlobTexture ifcBlobTexture = (IfcBlobTexture) theEObject;
			T result = caseIfcBlobTexture(ifcBlobTexture);
			if (result == null)
				result = caseIfcSurfaceTexture(ifcBlobTexture);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BLOCK: {
			IfcBlock ifcBlock = (IfcBlock) theEObject;
			T result = caseIfcBlock(ifcBlock);
			if (result == null)
				result = caseIfcCsgPrimitive3D(ifcBlock);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBlock);
			if (result == null)
				result = caseIfcBooleanOperand(ifcBlock);
			if (result == null)
				result = caseIfcCsgSelect(ifcBlock);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBlock);
			if (result == null)
				result = caseIfcLayeredItem(ifcBlock);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOILER_TYPE: {
			IfcBoilerType ifcBoilerType = (IfcBoilerType) theEObject;
			T result = caseIfcBoilerType(ifcBoilerType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcBoilerType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcBoilerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcBoilerType);
			if (result == null)
				result = caseIfcElementType(ifcBoilerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcBoilerType);
			if (result == null)
				result = caseIfcTypeObject(ifcBoilerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBoilerType);
			if (result == null)
				result = caseIfcRoot(ifcBoilerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOOLEAN_CLIPPING_RESULT: {
			IfcBooleanClippingResult ifcBooleanClippingResult = (IfcBooleanClippingResult) theEObject;
			T result = caseIfcBooleanClippingResult(ifcBooleanClippingResult);
			if (result == null)
				result = caseIfcBooleanResult(ifcBooleanClippingResult);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBooleanClippingResult);
			if (result == null)
				result = caseIfcBooleanOperand(ifcBooleanClippingResult);
			if (result == null)
				result = caseIfcCsgSelect(ifcBooleanClippingResult);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBooleanClippingResult);
			if (result == null)
				result = caseIfcLayeredItem(ifcBooleanClippingResult);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOOLEAN_RESULT: {
			IfcBooleanResult ifcBooleanResult = (IfcBooleanResult) theEObject;
			T result = caseIfcBooleanResult(ifcBooleanResult);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBooleanResult);
			if (result == null)
				result = caseIfcBooleanOperand(ifcBooleanResult);
			if (result == null)
				result = caseIfcCsgSelect(ifcBooleanResult);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBooleanResult);
			if (result == null)
				result = caseIfcLayeredItem(ifcBooleanResult);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOUNDARY_CONDITION: {
			IfcBoundaryCondition ifcBoundaryCondition = (IfcBoundaryCondition) theEObject;
			T result = caseIfcBoundaryCondition(ifcBoundaryCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOUNDARY_EDGE_CONDITION: {
			IfcBoundaryEdgeCondition ifcBoundaryEdgeCondition = (IfcBoundaryEdgeCondition) theEObject;
			T result = caseIfcBoundaryEdgeCondition(ifcBoundaryEdgeCondition);
			if (result == null)
				result = caseIfcBoundaryCondition(ifcBoundaryEdgeCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOUNDARY_FACE_CONDITION: {
			IfcBoundaryFaceCondition ifcBoundaryFaceCondition = (IfcBoundaryFaceCondition) theEObject;
			T result = caseIfcBoundaryFaceCondition(ifcBoundaryFaceCondition);
			if (result == null)
				result = caseIfcBoundaryCondition(ifcBoundaryFaceCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOUNDARY_NODE_CONDITION: {
			IfcBoundaryNodeCondition ifcBoundaryNodeCondition = (IfcBoundaryNodeCondition) theEObject;
			T result = caseIfcBoundaryNodeCondition(ifcBoundaryNodeCondition);
			if (result == null)
				result = caseIfcBoundaryCondition(ifcBoundaryNodeCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOUNDARY_NODE_CONDITION_WARPING: {
			IfcBoundaryNodeConditionWarping ifcBoundaryNodeConditionWarping = (IfcBoundaryNodeConditionWarping) theEObject;
			T result = caseIfcBoundaryNodeConditionWarping(ifcBoundaryNodeConditionWarping);
			if (result == null)
				result = caseIfcBoundaryNodeCondition(ifcBoundaryNodeConditionWarping);
			if (result == null)
				result = caseIfcBoundaryCondition(ifcBoundaryNodeConditionWarping);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOUNDED_CURVE: {
			IfcBoundedCurve ifcBoundedCurve = (IfcBoundedCurve) theEObject;
			T result = caseIfcBoundedCurve(ifcBoundedCurve);
			if (result == null)
				result = caseIfcCurve(ifcBoundedCurve);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifcBoundedCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBoundedCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcBoundedCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBoundedCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcBoundedCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOUNDED_SURFACE: {
			IfcBoundedSurface ifcBoundedSurface = (IfcBoundedSurface) theEObject;
			T result = caseIfcBoundedSurface(ifcBoundedSurface);
			if (result == null)
				result = caseIfcSurface(ifcBoundedSurface);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBoundedSurface);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcBoundedSurface);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcBoundedSurface);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBoundedSurface);
			if (result == null)
				result = caseIfcLayeredItem(ifcBoundedSurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOUNDING_BOX: {
			IfcBoundingBox ifcBoundingBox = (IfcBoundingBox) theEObject;
			T result = caseIfcBoundingBox(ifcBoundingBox);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBoundingBox);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBoundingBox);
			if (result == null)
				result = caseIfcLayeredItem(ifcBoundingBox);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOXED_HALF_SPACE: {
			IfcBoxedHalfSpace ifcBoxedHalfSpace = (IfcBoxedHalfSpace) theEObject;
			T result = caseIfcBoxedHalfSpace(ifcBoxedHalfSpace);
			if (result == null)
				result = caseIfcHalfSpaceSolid(ifcBoxedHalfSpace);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcBoxedHalfSpace);
			if (result == null)
				result = caseIfcBooleanOperand(ifcBoxedHalfSpace);
			if (result == null)
				result = caseIfcRepresentationItem(ifcBoxedHalfSpace);
			if (result == null)
				result = caseIfcLayeredItem(ifcBoxedHalfSpace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BUILDING: {
			IfcBuilding ifcBuilding = (IfcBuilding) theEObject;
			T result = caseIfcBuilding(ifcBuilding);
			if (result == null)
				result = caseIfcSpatialStructureElement(ifcBuilding);
			if (result == null)
				result = caseIfcProduct(ifcBuilding);
			if (result == null)
				result = caseIfcObject(ifcBuilding);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBuilding);
			if (result == null)
				result = caseIfcRoot(ifcBuilding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT: {
			IfcBuildingElement ifcBuildingElement = (IfcBuildingElement) theEObject;
			T result = caseIfcBuildingElement(ifcBuildingElement);
			if (result == null)
				result = caseIfcElement(ifcBuildingElement);
			if (result == null)
				result = caseIfcProduct(ifcBuildingElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcBuildingElement);
			if (result == null)
				result = caseIfcObject(ifcBuildingElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBuildingElement);
			if (result == null)
				result = caseIfcRoot(ifcBuildingElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_COMPONENT: {
			IfcBuildingElementComponent ifcBuildingElementComponent = (IfcBuildingElementComponent) theEObject;
			T result = caseIfcBuildingElementComponent(ifcBuildingElementComponent);
			if (result == null)
				result = caseIfcBuildingElement(ifcBuildingElementComponent);
			if (result == null)
				result = caseIfcElement(ifcBuildingElementComponent);
			if (result == null)
				result = caseIfcProduct(ifcBuildingElementComponent);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcBuildingElementComponent);
			if (result == null)
				result = caseIfcObject(ifcBuildingElementComponent);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBuildingElementComponent);
			if (result == null)
				result = caseIfcRoot(ifcBuildingElementComponent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_PART: {
			IfcBuildingElementPart ifcBuildingElementPart = (IfcBuildingElementPart) theEObject;
			T result = caseIfcBuildingElementPart(ifcBuildingElementPart);
			if (result == null)
				result = caseIfcBuildingElementComponent(ifcBuildingElementPart);
			if (result == null)
				result = caseIfcBuildingElement(ifcBuildingElementPart);
			if (result == null)
				result = caseIfcElement(ifcBuildingElementPart);
			if (result == null)
				result = caseIfcProduct(ifcBuildingElementPart);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcBuildingElementPart);
			if (result == null)
				result = caseIfcObject(ifcBuildingElementPart);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBuildingElementPart);
			if (result == null)
				result = caseIfcRoot(ifcBuildingElementPart);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_PROXY: {
			IfcBuildingElementProxy ifcBuildingElementProxy = (IfcBuildingElementProxy) theEObject;
			T result = caseIfcBuildingElementProxy(ifcBuildingElementProxy);
			if (result == null)
				result = caseIfcBuildingElement(ifcBuildingElementProxy);
			if (result == null)
				result = caseIfcElement(ifcBuildingElementProxy);
			if (result == null)
				result = caseIfcProduct(ifcBuildingElementProxy);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcBuildingElementProxy);
			if (result == null)
				result = caseIfcObject(ifcBuildingElementProxy);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBuildingElementProxy);
			if (result == null)
				result = caseIfcRoot(ifcBuildingElementProxy);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_PROXY_TYPE: {
			IfcBuildingElementProxyType ifcBuildingElementProxyType = (IfcBuildingElementProxyType) theEObject;
			T result = caseIfcBuildingElementProxyType(ifcBuildingElementProxyType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcBuildingElementProxyType);
			if (result == null)
				result = caseIfcElementType(ifcBuildingElementProxyType);
			if (result == null)
				result = caseIfcTypeProduct(ifcBuildingElementProxyType);
			if (result == null)
				result = caseIfcTypeObject(ifcBuildingElementProxyType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBuildingElementProxyType);
			if (result == null)
				result = caseIfcRoot(ifcBuildingElementProxyType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BUILDING_ELEMENT_TYPE: {
			IfcBuildingElementType ifcBuildingElementType = (IfcBuildingElementType) theEObject;
			T result = caseIfcBuildingElementType(ifcBuildingElementType);
			if (result == null)
				result = caseIfcElementType(ifcBuildingElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcBuildingElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcBuildingElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBuildingElementType);
			if (result == null)
				result = caseIfcRoot(ifcBuildingElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BUILDING_STOREY: {
			IfcBuildingStorey ifcBuildingStorey = (IfcBuildingStorey) theEObject;
			T result = caseIfcBuildingStorey(ifcBuildingStorey);
			if (result == null)
				result = caseIfcSpatialStructureElement(ifcBuildingStorey);
			if (result == null)
				result = caseIfcProduct(ifcBuildingStorey);
			if (result == null)
				result = caseIfcObject(ifcBuildingStorey);
			if (result == null)
				result = caseIfcObjectDefinition(ifcBuildingStorey);
			if (result == null)
				result = caseIfcRoot(ifcBuildingStorey);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CSHAPE_PROFILE_DEF: {
			IfcCShapeProfileDef ifcCShapeProfileDef = (IfcCShapeProfileDef) theEObject;
			T result = caseIfcCShapeProfileDef(ifcCShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcCShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcCShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CABLE_CARRIER_FITTING_TYPE: {
			IfcCableCarrierFittingType ifcCableCarrierFittingType = (IfcCableCarrierFittingType) theEObject;
			T result = caseIfcCableCarrierFittingType(ifcCableCarrierFittingType);
			if (result == null)
				result = caseIfcFlowFittingType(ifcCableCarrierFittingType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcCableCarrierFittingType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcCableCarrierFittingType);
			if (result == null)
				result = caseIfcElementType(ifcCableCarrierFittingType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCableCarrierFittingType);
			if (result == null)
				result = caseIfcTypeObject(ifcCableCarrierFittingType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCableCarrierFittingType);
			if (result == null)
				result = caseIfcRoot(ifcCableCarrierFittingType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CABLE_CARRIER_SEGMENT_TYPE: {
			IfcCableCarrierSegmentType ifcCableCarrierSegmentType = (IfcCableCarrierSegmentType) theEObject;
			T result = caseIfcCableCarrierSegmentType(ifcCableCarrierSegmentType);
			if (result == null)
				result = caseIfcFlowSegmentType(ifcCableCarrierSegmentType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcCableCarrierSegmentType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcCableCarrierSegmentType);
			if (result == null)
				result = caseIfcElementType(ifcCableCarrierSegmentType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCableCarrierSegmentType);
			if (result == null)
				result = caseIfcTypeObject(ifcCableCarrierSegmentType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCableCarrierSegmentType);
			if (result == null)
				result = caseIfcRoot(ifcCableCarrierSegmentType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CABLE_SEGMENT_TYPE: {
			IfcCableSegmentType ifcCableSegmentType = (IfcCableSegmentType) theEObject;
			T result = caseIfcCableSegmentType(ifcCableSegmentType);
			if (result == null)
				result = caseIfcFlowSegmentType(ifcCableSegmentType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcCableSegmentType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcCableSegmentType);
			if (result == null)
				result = caseIfcElementType(ifcCableSegmentType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCableSegmentType);
			if (result == null)
				result = caseIfcTypeObject(ifcCableSegmentType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCableSegmentType);
			if (result == null)
				result = caseIfcRoot(ifcCableSegmentType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CALENDAR_DATE: {
			IfcCalendarDate ifcCalendarDate = (IfcCalendarDate) theEObject;
			T result = caseIfcCalendarDate(ifcCalendarDate);
			if (result == null)
				result = caseIfcDateTimeSelect(ifcCalendarDate);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcCalendarDate);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcCalendarDate);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CARTESIAN_POINT: {
			IfcCartesianPoint ifcCartesianPoint = (IfcCartesianPoint) theEObject;
			T result = caseIfcCartesianPoint(ifcCartesianPoint);
			if (result == null)
				result = caseIfcPoint(ifcCartesianPoint);
			if (result == null)
				result = caseIfcTrimmingSelect(ifcCartesianPoint);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCartesianPoint);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcCartesianPoint);
			if (result == null)
				result = caseIfcPointOrVertexPoint(ifcCartesianPoint);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCartesianPoint);
			if (result == null)
				result = caseIfcLayeredItem(ifcCartesianPoint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR: {
			IfcCartesianTransformationOperator ifcCartesianTransformationOperator = (IfcCartesianTransformationOperator) theEObject;
			T result = caseIfcCartesianTransformationOperator(ifcCartesianTransformationOperator);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCartesianTransformationOperator);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCartesianTransformationOperator);
			if (result == null)
				result = caseIfcLayeredItem(ifcCartesianTransformationOperator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_D: {
			IfcCartesianTransformationOperator2D ifcCartesianTransformationOperator2D = (IfcCartesianTransformationOperator2D) theEObject;
			T result = caseIfcCartesianTransformationOperator2D(ifcCartesianTransformationOperator2D);
			if (result == null)
				result = caseIfcCartesianTransformationOperator(ifcCartesianTransformationOperator2D);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCartesianTransformationOperator2D);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCartesianTransformationOperator2D);
			if (result == null)
				result = caseIfcLayeredItem(ifcCartesianTransformationOperator2D);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR2_DNON_UNIFORM: {
			IfcCartesianTransformationOperator2DnonUniform ifcCartesianTransformationOperator2DnonUniform = (IfcCartesianTransformationOperator2DnonUniform) theEObject;
			T result = caseIfcCartesianTransformationOperator2DnonUniform(
					ifcCartesianTransformationOperator2DnonUniform);
			if (result == null)
				result = caseIfcCartesianTransformationOperator2D(ifcCartesianTransformationOperator2DnonUniform);
			if (result == null)
				result = caseIfcCartesianTransformationOperator(ifcCartesianTransformationOperator2DnonUniform);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCartesianTransformationOperator2DnonUniform);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCartesianTransformationOperator2DnonUniform);
			if (result == null)
				result = caseIfcLayeredItem(ifcCartesianTransformationOperator2DnonUniform);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR3_D: {
			IfcCartesianTransformationOperator3D ifcCartesianTransformationOperator3D = (IfcCartesianTransformationOperator3D) theEObject;
			T result = caseIfcCartesianTransformationOperator3D(ifcCartesianTransformationOperator3D);
			if (result == null)
				result = caseIfcCartesianTransformationOperator(ifcCartesianTransformationOperator3D);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCartesianTransformationOperator3D);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCartesianTransformationOperator3D);
			if (result == null)
				result = caseIfcLayeredItem(ifcCartesianTransformationOperator3D);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CARTESIAN_TRANSFORMATION_OPERATOR3_DNON_UNIFORM: {
			IfcCartesianTransformationOperator3DnonUniform ifcCartesianTransformationOperator3DnonUniform = (IfcCartesianTransformationOperator3DnonUniform) theEObject;
			T result = caseIfcCartesianTransformationOperator3DnonUniform(
					ifcCartesianTransformationOperator3DnonUniform);
			if (result == null)
				result = caseIfcCartesianTransformationOperator3D(ifcCartesianTransformationOperator3DnonUniform);
			if (result == null)
				result = caseIfcCartesianTransformationOperator(ifcCartesianTransformationOperator3DnonUniform);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCartesianTransformationOperator3DnonUniform);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCartesianTransformationOperator3DnonUniform);
			if (result == null)
				result = caseIfcLayeredItem(ifcCartesianTransformationOperator3DnonUniform);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CENTER_LINE_PROFILE_DEF: {
			IfcCenterLineProfileDef ifcCenterLineProfileDef = (IfcCenterLineProfileDef) theEObject;
			T result = caseIfcCenterLineProfileDef(ifcCenterLineProfileDef);
			if (result == null)
				result = caseIfcArbitraryOpenProfileDef(ifcCenterLineProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcCenterLineProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CHAMFER_EDGE_FEATURE: {
			IfcChamferEdgeFeature ifcChamferEdgeFeature = (IfcChamferEdgeFeature) theEObject;
			T result = caseIfcChamferEdgeFeature(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcEdgeFeature(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcFeatureElementSubtraction(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcFeatureElement(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcElement(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcProduct(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcObject(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcObjectDefinition(ifcChamferEdgeFeature);
			if (result == null)
				result = caseIfcRoot(ifcChamferEdgeFeature);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CHILLER_TYPE: {
			IfcChillerType ifcChillerType = (IfcChillerType) theEObject;
			T result = caseIfcChillerType(ifcChillerType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcChillerType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcChillerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcChillerType);
			if (result == null)
				result = caseIfcElementType(ifcChillerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcChillerType);
			if (result == null)
				result = caseIfcTypeObject(ifcChillerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcChillerType);
			if (result == null)
				result = caseIfcRoot(ifcChillerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CIRCLE: {
			IfcCircle ifcCircle = (IfcCircle) theEObject;
			T result = caseIfcCircle(ifcCircle);
			if (result == null)
				result = caseIfcConic(ifcCircle);
			if (result == null)
				result = caseIfcCurve(ifcCircle);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCircle);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcCircle);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCircle);
			if (result == null)
				result = caseIfcLayeredItem(ifcCircle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CIRCLE_HOLLOW_PROFILE_DEF: {
			IfcCircleHollowProfileDef ifcCircleHollowProfileDef = (IfcCircleHollowProfileDef) theEObject;
			T result = caseIfcCircleHollowProfileDef(ifcCircleHollowProfileDef);
			if (result == null)
				result = caseIfcCircleProfileDef(ifcCircleHollowProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcCircleHollowProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcCircleHollowProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CIRCLE_PROFILE_DEF: {
			IfcCircleProfileDef ifcCircleProfileDef = (IfcCircleProfileDef) theEObject;
			T result = caseIfcCircleProfileDef(ifcCircleProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcCircleProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcCircleProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CLASSIFICATION: {
			IfcClassification ifcClassification = (IfcClassification) theEObject;
			T result = caseIfcClassification(ifcClassification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_ITEM: {
			IfcClassificationItem ifcClassificationItem = (IfcClassificationItem) theEObject;
			T result = caseIfcClassificationItem(ifcClassificationItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_ITEM_RELATIONSHIP: {
			IfcClassificationItemRelationship ifcClassificationItemRelationship = (IfcClassificationItemRelationship) theEObject;
			T result = caseIfcClassificationItemRelationship(ifcClassificationItemRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_NOTATION: {
			IfcClassificationNotation ifcClassificationNotation = (IfcClassificationNotation) theEObject;
			T result = caseIfcClassificationNotation(ifcClassificationNotation);
			if (result == null)
				result = caseIfcClassificationNotationSelect(ifcClassificationNotation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_NOTATION_FACET: {
			IfcClassificationNotationFacet ifcClassificationNotationFacet = (IfcClassificationNotationFacet) theEObject;
			T result = caseIfcClassificationNotationFacet(ifcClassificationNotationFacet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_REFERENCE: {
			IfcClassificationReference ifcClassificationReference = (IfcClassificationReference) theEObject;
			T result = caseIfcClassificationReference(ifcClassificationReference);
			if (result == null)
				result = caseIfcExternalReference(ifcClassificationReference);
			if (result == null)
				result = caseIfcClassificationNotationSelect(ifcClassificationReference);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcClassificationReference);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcClassificationReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CLOSED_SHELL: {
			IfcClosedShell ifcClosedShell = (IfcClosedShell) theEObject;
			T result = caseIfcClosedShell(ifcClosedShell);
			if (result == null)
				result = caseIfcConnectedFaceSet(ifcClosedShell);
			if (result == null)
				result = caseIfcShell(ifcClosedShell);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcClosedShell);
			if (result == null)
				result = caseIfcRepresentationItem(ifcClosedShell);
			if (result == null)
				result = caseIfcLayeredItem(ifcClosedShell);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COIL_TYPE: {
			IfcCoilType ifcCoilType = (IfcCoilType) theEObject;
			T result = caseIfcCoilType(ifcCoilType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcCoilType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcCoilType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcCoilType);
			if (result == null)
				result = caseIfcElementType(ifcCoilType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCoilType);
			if (result == null)
				result = caseIfcTypeObject(ifcCoilType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCoilType);
			if (result == null)
				result = caseIfcRoot(ifcCoilType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COLOUR_RGB: {
			IfcColourRgb ifcColourRgb = (IfcColourRgb) theEObject;
			T result = caseIfcColourRgb(ifcColourRgb);
			if (result == null)
				result = caseIfcColourSpecification(ifcColourRgb);
			if (result == null)
				result = caseIfcColourOrFactor(ifcColourRgb);
			if (result == null)
				result = caseIfcColour(ifcColourRgb);
			if (result == null)
				result = caseIfcFillStyleSelect(ifcColourRgb);
			if (result == null)
				result = caseIfcSymbolStyleSelect(ifcColourRgb);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COLOUR_SPECIFICATION: {
			IfcColourSpecification ifcColourSpecification = (IfcColourSpecification) theEObject;
			T result = caseIfcColourSpecification(ifcColourSpecification);
			if (result == null)
				result = caseIfcColour(ifcColourSpecification);
			if (result == null)
				result = caseIfcFillStyleSelect(ifcColourSpecification);
			if (result == null)
				result = caseIfcSymbolStyleSelect(ifcColourSpecification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COLUMN: {
			IfcColumn ifcColumn = (IfcColumn) theEObject;
			T result = caseIfcColumn(ifcColumn);
			if (result == null)
				result = caseIfcBuildingElement(ifcColumn);
			if (result == null)
				result = caseIfcElement(ifcColumn);
			if (result == null)
				result = caseIfcProduct(ifcColumn);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcColumn);
			if (result == null)
				result = caseIfcObject(ifcColumn);
			if (result == null)
				result = caseIfcObjectDefinition(ifcColumn);
			if (result == null)
				result = caseIfcRoot(ifcColumn);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COLUMN_TYPE: {
			IfcColumnType ifcColumnType = (IfcColumnType) theEObject;
			T result = caseIfcColumnType(ifcColumnType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcColumnType);
			if (result == null)
				result = caseIfcElementType(ifcColumnType);
			if (result == null)
				result = caseIfcTypeProduct(ifcColumnType);
			if (result == null)
				result = caseIfcTypeObject(ifcColumnType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcColumnType);
			if (result == null)
				result = caseIfcRoot(ifcColumnType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COMPLEX_PROPERTY: {
			IfcComplexProperty ifcComplexProperty = (IfcComplexProperty) theEObject;
			T result = caseIfcComplexProperty(ifcComplexProperty);
			if (result == null)
				result = caseIfcProperty(ifcComplexProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COMPOSITE_CURVE: {
			IfcCompositeCurve ifcCompositeCurve = (IfcCompositeCurve) theEObject;
			T result = caseIfcCompositeCurve(ifcCompositeCurve);
			if (result == null)
				result = caseIfcBoundedCurve(ifcCompositeCurve);
			if (result == null)
				result = caseIfcCurve(ifcCompositeCurve);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifcCompositeCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCompositeCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcCompositeCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCompositeCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcCompositeCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COMPOSITE_CURVE_SEGMENT: {
			IfcCompositeCurveSegment ifcCompositeCurveSegment = (IfcCompositeCurveSegment) theEObject;
			T result = caseIfcCompositeCurveSegment(ifcCompositeCurveSegment);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCompositeCurveSegment);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCompositeCurveSegment);
			if (result == null)
				result = caseIfcLayeredItem(ifcCompositeCurveSegment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COMPOSITE_PROFILE_DEF: {
			IfcCompositeProfileDef ifcCompositeProfileDef = (IfcCompositeProfileDef) theEObject;
			T result = caseIfcCompositeProfileDef(ifcCompositeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcCompositeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COMPRESSOR_TYPE: {
			IfcCompressorType ifcCompressorType = (IfcCompressorType) theEObject;
			T result = caseIfcCompressorType(ifcCompressorType);
			if (result == null)
				result = caseIfcFlowMovingDeviceType(ifcCompressorType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcCompressorType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcCompressorType);
			if (result == null)
				result = caseIfcElementType(ifcCompressorType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCompressorType);
			if (result == null)
				result = caseIfcTypeObject(ifcCompressorType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCompressorType);
			if (result == null)
				result = caseIfcRoot(ifcCompressorType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONDENSER_TYPE: {
			IfcCondenserType ifcCondenserType = (IfcCondenserType) theEObject;
			T result = caseIfcCondenserType(ifcCondenserType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcCondenserType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcCondenserType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcCondenserType);
			if (result == null)
				result = caseIfcElementType(ifcCondenserType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCondenserType);
			if (result == null)
				result = caseIfcTypeObject(ifcCondenserType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCondenserType);
			if (result == null)
				result = caseIfcRoot(ifcCondenserType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONDITION: {
			IfcCondition ifcCondition = (IfcCondition) theEObject;
			T result = caseIfcCondition(ifcCondition);
			if (result == null)
				result = caseIfcGroup(ifcCondition);
			if (result == null)
				result = caseIfcObject(ifcCondition);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCondition);
			if (result == null)
				result = caseIfcRoot(ifcCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONDITION_CRITERION: {
			IfcConditionCriterion ifcConditionCriterion = (IfcConditionCriterion) theEObject;
			T result = caseIfcConditionCriterion(ifcConditionCriterion);
			if (result == null)
				result = caseIfcControl(ifcConditionCriterion);
			if (result == null)
				result = caseIfcObject(ifcConditionCriterion);
			if (result == null)
				result = caseIfcObjectDefinition(ifcConditionCriterion);
			if (result == null)
				result = caseIfcRoot(ifcConditionCriterion);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONIC: {
			IfcConic ifcConic = (IfcConic) theEObject;
			T result = caseIfcConic(ifcConic);
			if (result == null)
				result = caseIfcCurve(ifcConic);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcConic);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcConic);
			if (result == null)
				result = caseIfcRepresentationItem(ifcConic);
			if (result == null)
				result = caseIfcLayeredItem(ifcConic);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONNECTED_FACE_SET: {
			IfcConnectedFaceSet ifcConnectedFaceSet = (IfcConnectedFaceSet) theEObject;
			T result = caseIfcConnectedFaceSet(ifcConnectedFaceSet);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcConnectedFaceSet);
			if (result == null)
				result = caseIfcRepresentationItem(ifcConnectedFaceSet);
			if (result == null)
				result = caseIfcLayeredItem(ifcConnectedFaceSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONNECTION_CURVE_GEOMETRY: {
			IfcConnectionCurveGeometry ifcConnectionCurveGeometry = (IfcConnectionCurveGeometry) theEObject;
			T result = caseIfcConnectionCurveGeometry(ifcConnectionCurveGeometry);
			if (result == null)
				result = caseIfcConnectionGeometry(ifcConnectionCurveGeometry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONNECTION_GEOMETRY: {
			IfcConnectionGeometry ifcConnectionGeometry = (IfcConnectionGeometry) theEObject;
			T result = caseIfcConnectionGeometry(ifcConnectionGeometry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONNECTION_POINT_ECCENTRICITY: {
			IfcConnectionPointEccentricity ifcConnectionPointEccentricity = (IfcConnectionPointEccentricity) theEObject;
			T result = caseIfcConnectionPointEccentricity(ifcConnectionPointEccentricity);
			if (result == null)
				result = caseIfcConnectionPointGeometry(ifcConnectionPointEccentricity);
			if (result == null)
				result = caseIfcConnectionGeometry(ifcConnectionPointEccentricity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONNECTION_POINT_GEOMETRY: {
			IfcConnectionPointGeometry ifcConnectionPointGeometry = (IfcConnectionPointGeometry) theEObject;
			T result = caseIfcConnectionPointGeometry(ifcConnectionPointGeometry);
			if (result == null)
				result = caseIfcConnectionGeometry(ifcConnectionPointGeometry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONNECTION_PORT_GEOMETRY: {
			IfcConnectionPortGeometry ifcConnectionPortGeometry = (IfcConnectionPortGeometry) theEObject;
			T result = caseIfcConnectionPortGeometry(ifcConnectionPortGeometry);
			if (result == null)
				result = caseIfcConnectionGeometry(ifcConnectionPortGeometry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONNECTION_SURFACE_GEOMETRY: {
			IfcConnectionSurfaceGeometry ifcConnectionSurfaceGeometry = (IfcConnectionSurfaceGeometry) theEObject;
			T result = caseIfcConnectionSurfaceGeometry(ifcConnectionSurfaceGeometry);
			if (result == null)
				result = caseIfcConnectionGeometry(ifcConnectionSurfaceGeometry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONSTRAINT: {
			IfcConstraint ifcConstraint = (IfcConstraint) theEObject;
			T result = caseIfcConstraint(ifcConstraint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONSTRAINT_AGGREGATION_RELATIONSHIP: {
			IfcConstraintAggregationRelationship ifcConstraintAggregationRelationship = (IfcConstraintAggregationRelationship) theEObject;
			T result = caseIfcConstraintAggregationRelationship(ifcConstraintAggregationRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONSTRAINT_CLASSIFICATION_RELATIONSHIP: {
			IfcConstraintClassificationRelationship ifcConstraintClassificationRelationship = (IfcConstraintClassificationRelationship) theEObject;
			T result = caseIfcConstraintClassificationRelationship(ifcConstraintClassificationRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONSTRAINT_RELATIONSHIP: {
			IfcConstraintRelationship ifcConstraintRelationship = (IfcConstraintRelationship) theEObject;
			T result = caseIfcConstraintRelationship(ifcConstraintRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONSTRUCTION_EQUIPMENT_RESOURCE: {
			IfcConstructionEquipmentResource ifcConstructionEquipmentResource = (IfcConstructionEquipmentResource) theEObject;
			T result = caseIfcConstructionEquipmentResource(ifcConstructionEquipmentResource);
			if (result == null)
				result = caseIfcConstructionResource(ifcConstructionEquipmentResource);
			if (result == null)
				result = caseIfcResource(ifcConstructionEquipmentResource);
			if (result == null)
				result = caseIfcObject(ifcConstructionEquipmentResource);
			if (result == null)
				result = caseIfcObjectDefinition(ifcConstructionEquipmentResource);
			if (result == null)
				result = caseIfcRoot(ifcConstructionEquipmentResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONSTRUCTION_MATERIAL_RESOURCE: {
			IfcConstructionMaterialResource ifcConstructionMaterialResource = (IfcConstructionMaterialResource) theEObject;
			T result = caseIfcConstructionMaterialResource(ifcConstructionMaterialResource);
			if (result == null)
				result = caseIfcConstructionResource(ifcConstructionMaterialResource);
			if (result == null)
				result = caseIfcResource(ifcConstructionMaterialResource);
			if (result == null)
				result = caseIfcObject(ifcConstructionMaterialResource);
			if (result == null)
				result = caseIfcObjectDefinition(ifcConstructionMaterialResource);
			if (result == null)
				result = caseIfcRoot(ifcConstructionMaterialResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONSTRUCTION_PRODUCT_RESOURCE: {
			IfcConstructionProductResource ifcConstructionProductResource = (IfcConstructionProductResource) theEObject;
			T result = caseIfcConstructionProductResource(ifcConstructionProductResource);
			if (result == null)
				result = caseIfcConstructionResource(ifcConstructionProductResource);
			if (result == null)
				result = caseIfcResource(ifcConstructionProductResource);
			if (result == null)
				result = caseIfcObject(ifcConstructionProductResource);
			if (result == null)
				result = caseIfcObjectDefinition(ifcConstructionProductResource);
			if (result == null)
				result = caseIfcRoot(ifcConstructionProductResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONSTRUCTION_RESOURCE: {
			IfcConstructionResource ifcConstructionResource = (IfcConstructionResource) theEObject;
			T result = caseIfcConstructionResource(ifcConstructionResource);
			if (result == null)
				result = caseIfcResource(ifcConstructionResource);
			if (result == null)
				result = caseIfcObject(ifcConstructionResource);
			if (result == null)
				result = caseIfcObjectDefinition(ifcConstructionResource);
			if (result == null)
				result = caseIfcRoot(ifcConstructionResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONTEXT_DEPENDENT_UNIT: {
			IfcContextDependentUnit ifcContextDependentUnit = (IfcContextDependentUnit) theEObject;
			T result = caseIfcContextDependentUnit(ifcContextDependentUnit);
			if (result == null)
				result = caseIfcNamedUnit(ifcContextDependentUnit);
			if (result == null)
				result = caseIfcUnit(ifcContextDependentUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONTROL: {
			IfcControl ifcControl = (IfcControl) theEObject;
			T result = caseIfcControl(ifcControl);
			if (result == null)
				result = caseIfcObject(ifcControl);
			if (result == null)
				result = caseIfcObjectDefinition(ifcControl);
			if (result == null)
				result = caseIfcRoot(ifcControl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONTROLLER_TYPE: {
			IfcControllerType ifcControllerType = (IfcControllerType) theEObject;
			T result = caseIfcControllerType(ifcControllerType);
			if (result == null)
				result = caseIfcDistributionControlElementType(ifcControllerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcControllerType);
			if (result == null)
				result = caseIfcElementType(ifcControllerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcControllerType);
			if (result == null)
				result = caseIfcTypeObject(ifcControllerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcControllerType);
			if (result == null)
				result = caseIfcRoot(ifcControllerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONVERSION_BASED_UNIT: {
			IfcConversionBasedUnit ifcConversionBasedUnit = (IfcConversionBasedUnit) theEObject;
			T result = caseIfcConversionBasedUnit(ifcConversionBasedUnit);
			if (result == null)
				result = caseIfcNamedUnit(ifcConversionBasedUnit);
			if (result == null)
				result = caseIfcUnit(ifcConversionBasedUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COOLED_BEAM_TYPE: {
			IfcCooledBeamType ifcCooledBeamType = (IfcCooledBeamType) theEObject;
			T result = caseIfcCooledBeamType(ifcCooledBeamType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcCooledBeamType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcCooledBeamType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcCooledBeamType);
			if (result == null)
				result = caseIfcElementType(ifcCooledBeamType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCooledBeamType);
			if (result == null)
				result = caseIfcTypeObject(ifcCooledBeamType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCooledBeamType);
			if (result == null)
				result = caseIfcRoot(ifcCooledBeamType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COOLING_TOWER_TYPE: {
			IfcCoolingTowerType ifcCoolingTowerType = (IfcCoolingTowerType) theEObject;
			T result = caseIfcCoolingTowerType(ifcCoolingTowerType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcCoolingTowerType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcCoolingTowerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcCoolingTowerType);
			if (result == null)
				result = caseIfcElementType(ifcCoolingTowerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCoolingTowerType);
			if (result == null)
				result = caseIfcTypeObject(ifcCoolingTowerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCoolingTowerType);
			if (result == null)
				result = caseIfcRoot(ifcCoolingTowerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COORDINATED_UNIVERSAL_TIME_OFFSET: {
			IfcCoordinatedUniversalTimeOffset ifcCoordinatedUniversalTimeOffset = (IfcCoordinatedUniversalTimeOffset) theEObject;
			T result = caseIfcCoordinatedUniversalTimeOffset(ifcCoordinatedUniversalTimeOffset);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COST_ITEM: {
			IfcCostItem ifcCostItem = (IfcCostItem) theEObject;
			T result = caseIfcCostItem(ifcCostItem);
			if (result == null)
				result = caseIfcControl(ifcCostItem);
			if (result == null)
				result = caseIfcObject(ifcCostItem);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCostItem);
			if (result == null)
				result = caseIfcRoot(ifcCostItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COST_SCHEDULE: {
			IfcCostSchedule ifcCostSchedule = (IfcCostSchedule) theEObject;
			T result = caseIfcCostSchedule(ifcCostSchedule);
			if (result == null)
				result = caseIfcControl(ifcCostSchedule);
			if (result == null)
				result = caseIfcObject(ifcCostSchedule);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCostSchedule);
			if (result == null)
				result = caseIfcRoot(ifcCostSchedule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COST_VALUE: {
			IfcCostValue ifcCostValue = (IfcCostValue) theEObject;
			T result = caseIfcCostValue(ifcCostValue);
			if (result == null)
				result = caseIfcAppliedValue(ifcCostValue);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcCostValue);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcCostValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COVERING: {
			IfcCovering ifcCovering = (IfcCovering) theEObject;
			T result = caseIfcCovering(ifcCovering);
			if (result == null)
				result = caseIfcBuildingElement(ifcCovering);
			if (result == null)
				result = caseIfcElement(ifcCovering);
			if (result == null)
				result = caseIfcProduct(ifcCovering);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcCovering);
			if (result == null)
				result = caseIfcObject(ifcCovering);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCovering);
			if (result == null)
				result = caseIfcRoot(ifcCovering);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COVERING_TYPE: {
			IfcCoveringType ifcCoveringType = (IfcCoveringType) theEObject;
			T result = caseIfcCoveringType(ifcCoveringType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcCoveringType);
			if (result == null)
				result = caseIfcElementType(ifcCoveringType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCoveringType);
			if (result == null)
				result = caseIfcTypeObject(ifcCoveringType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCoveringType);
			if (result == null)
				result = caseIfcRoot(ifcCoveringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CRANE_RAIL_ASHAPE_PROFILE_DEF: {
			IfcCraneRailAShapeProfileDef ifcCraneRailAShapeProfileDef = (IfcCraneRailAShapeProfileDef) theEObject;
			T result = caseIfcCraneRailAShapeProfileDef(ifcCraneRailAShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcCraneRailAShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcCraneRailAShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CRANE_RAIL_FSHAPE_PROFILE_DEF: {
			IfcCraneRailFShapeProfileDef ifcCraneRailFShapeProfileDef = (IfcCraneRailFShapeProfileDef) theEObject;
			T result = caseIfcCraneRailFShapeProfileDef(ifcCraneRailFShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcCraneRailFShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcCraneRailFShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CREW_RESOURCE: {
			IfcCrewResource ifcCrewResource = (IfcCrewResource) theEObject;
			T result = caseIfcCrewResource(ifcCrewResource);
			if (result == null)
				result = caseIfcConstructionResource(ifcCrewResource);
			if (result == null)
				result = caseIfcResource(ifcCrewResource);
			if (result == null)
				result = caseIfcObject(ifcCrewResource);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCrewResource);
			if (result == null)
				result = caseIfcRoot(ifcCrewResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CSG_PRIMITIVE3_D: {
			IfcCsgPrimitive3D ifcCsgPrimitive3D = (IfcCsgPrimitive3D) theEObject;
			T result = caseIfcCsgPrimitive3D(ifcCsgPrimitive3D);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCsgPrimitive3D);
			if (result == null)
				result = caseIfcBooleanOperand(ifcCsgPrimitive3D);
			if (result == null)
				result = caseIfcCsgSelect(ifcCsgPrimitive3D);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCsgPrimitive3D);
			if (result == null)
				result = caseIfcLayeredItem(ifcCsgPrimitive3D);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CSG_SOLID: {
			IfcCsgSolid ifcCsgSolid = (IfcCsgSolid) theEObject;
			T result = caseIfcCsgSolid(ifcCsgSolid);
			if (result == null)
				result = caseIfcSolidModel(ifcCsgSolid);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCsgSolid);
			if (result == null)
				result = caseIfcBooleanOperand(ifcCsgSolid);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCsgSolid);
			if (result == null)
				result = caseIfcLayeredItem(ifcCsgSolid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURRENCY_RELATIONSHIP: {
			IfcCurrencyRelationship ifcCurrencyRelationship = (IfcCurrencyRelationship) theEObject;
			T result = caseIfcCurrencyRelationship(ifcCurrencyRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURTAIN_WALL: {
			IfcCurtainWall ifcCurtainWall = (IfcCurtainWall) theEObject;
			T result = caseIfcCurtainWall(ifcCurtainWall);
			if (result == null)
				result = caseIfcBuildingElement(ifcCurtainWall);
			if (result == null)
				result = caseIfcElement(ifcCurtainWall);
			if (result == null)
				result = caseIfcProduct(ifcCurtainWall);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcCurtainWall);
			if (result == null)
				result = caseIfcObject(ifcCurtainWall);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCurtainWall);
			if (result == null)
				result = caseIfcRoot(ifcCurtainWall);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURTAIN_WALL_TYPE: {
			IfcCurtainWallType ifcCurtainWallType = (IfcCurtainWallType) theEObject;
			T result = caseIfcCurtainWallType(ifcCurtainWallType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcCurtainWallType);
			if (result == null)
				result = caseIfcElementType(ifcCurtainWallType);
			if (result == null)
				result = caseIfcTypeProduct(ifcCurtainWallType);
			if (result == null)
				result = caseIfcTypeObject(ifcCurtainWallType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcCurtainWallType);
			if (result == null)
				result = caseIfcRoot(ifcCurtainWallType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE: {
			IfcCurve ifcCurve = (IfcCurve) theEObject;
			T result = caseIfcCurve(ifcCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE_BOUNDED_PLANE: {
			IfcCurveBoundedPlane ifcCurveBoundedPlane = (IfcCurveBoundedPlane) theEObject;
			T result = caseIfcCurveBoundedPlane(ifcCurveBoundedPlane);
			if (result == null)
				result = caseIfcBoundedSurface(ifcCurveBoundedPlane);
			if (result == null)
				result = caseIfcSurface(ifcCurveBoundedPlane);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcCurveBoundedPlane);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcCurveBoundedPlane);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcCurveBoundedPlane);
			if (result == null)
				result = caseIfcRepresentationItem(ifcCurveBoundedPlane);
			if (result == null)
				result = caseIfcLayeredItem(ifcCurveBoundedPlane);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE_STYLE: {
			IfcCurveStyle ifcCurveStyle = (IfcCurveStyle) theEObject;
			T result = caseIfcCurveStyle(ifcCurveStyle);
			if (result == null)
				result = caseIfcPresentationStyle(ifcCurveStyle);
			if (result == null)
				result = caseIfcPresentationStyleSelect(ifcCurveStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE_STYLE_FONT: {
			IfcCurveStyleFont ifcCurveStyleFont = (IfcCurveStyleFont) theEObject;
			T result = caseIfcCurveStyleFont(ifcCurveStyleFont);
			if (result == null)
				result = caseIfcCurveStyleFontSelect(ifcCurveStyleFont);
			if (result == null)
				result = caseIfcCurveFontOrScaledCurveFontSelect(ifcCurveStyleFont);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE_STYLE_FONT_AND_SCALING: {
			IfcCurveStyleFontAndScaling ifcCurveStyleFontAndScaling = (IfcCurveStyleFontAndScaling) theEObject;
			T result = caseIfcCurveStyleFontAndScaling(ifcCurveStyleFontAndScaling);
			if (result == null)
				result = caseIfcCurveFontOrScaledCurveFontSelect(ifcCurveStyleFontAndScaling);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE_STYLE_FONT_PATTERN: {
			IfcCurveStyleFontPattern ifcCurveStyleFontPattern = (IfcCurveStyleFontPattern) theEObject;
			T result = caseIfcCurveStyleFontPattern(ifcCurveStyleFontPattern);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DAMPER_TYPE: {
			IfcDamperType ifcDamperType = (IfcDamperType) theEObject;
			T result = caseIfcDamperType(ifcDamperType);
			if (result == null)
				result = caseIfcFlowControllerType(ifcDamperType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcDamperType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcDamperType);
			if (result == null)
				result = caseIfcElementType(ifcDamperType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDamperType);
			if (result == null)
				result = caseIfcTypeObject(ifcDamperType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDamperType);
			if (result == null)
				result = caseIfcRoot(ifcDamperType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DATE_AND_TIME: {
			IfcDateAndTime ifcDateAndTime = (IfcDateAndTime) theEObject;
			T result = caseIfcDateAndTime(ifcDateAndTime);
			if (result == null)
				result = caseIfcDateTimeSelect(ifcDateAndTime);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcDateAndTime);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcDateAndTime);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DEFINED_SYMBOL: {
			IfcDefinedSymbol ifcDefinedSymbol = (IfcDefinedSymbol) theEObject;
			T result = caseIfcDefinedSymbol(ifcDefinedSymbol);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcDefinedSymbol);
			if (result == null)
				result = caseIfcRepresentationItem(ifcDefinedSymbol);
			if (result == null)
				result = caseIfcLayeredItem(ifcDefinedSymbol);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DERIVED_PROFILE_DEF: {
			IfcDerivedProfileDef ifcDerivedProfileDef = (IfcDerivedProfileDef) theEObject;
			T result = caseIfcDerivedProfileDef(ifcDerivedProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcDerivedProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DERIVED_UNIT: {
			IfcDerivedUnit ifcDerivedUnit = (IfcDerivedUnit) theEObject;
			T result = caseIfcDerivedUnit(ifcDerivedUnit);
			if (result == null)
				result = caseIfcUnit(ifcDerivedUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DERIVED_UNIT_ELEMENT: {
			IfcDerivedUnitElement ifcDerivedUnitElement = (IfcDerivedUnitElement) theEObject;
			T result = caseIfcDerivedUnitElement(ifcDerivedUnitElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIAMETER_DIMENSION: {
			IfcDiameterDimension ifcDiameterDimension = (IfcDiameterDimension) theEObject;
			T result = caseIfcDiameterDimension(ifcDiameterDimension);
			if (result == null)
				result = caseIfcDimensionCurveDirectedCallout(ifcDiameterDimension);
			if (result == null)
				result = caseIfcDraughtingCallout(ifcDiameterDimension);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcDiameterDimension);
			if (result == null)
				result = caseIfcRepresentationItem(ifcDiameterDimension);
			if (result == null)
				result = caseIfcLayeredItem(ifcDiameterDimension);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIMENSION_CALLOUT_RELATIONSHIP: {
			IfcDimensionCalloutRelationship ifcDimensionCalloutRelationship = (IfcDimensionCalloutRelationship) theEObject;
			T result = caseIfcDimensionCalloutRelationship(ifcDimensionCalloutRelationship);
			if (result == null)
				result = caseIfcDraughtingCalloutRelationship(ifcDimensionCalloutRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIMENSION_CURVE: {
			IfcDimensionCurve ifcDimensionCurve = (IfcDimensionCurve) theEObject;
			T result = caseIfcDimensionCurve(ifcDimensionCurve);
			if (result == null)
				result = caseIfcAnnotationCurveOccurrence(ifcDimensionCurve);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcDimensionCurve);
			if (result == null)
				result = caseIfcDraughtingCalloutElement(ifcDimensionCurve);
			if (result == null)
				result = caseIfcStyledItem(ifcDimensionCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcDimensionCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcDimensionCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIMENSION_CURVE_DIRECTED_CALLOUT: {
			IfcDimensionCurveDirectedCallout ifcDimensionCurveDirectedCallout = (IfcDimensionCurveDirectedCallout) theEObject;
			T result = caseIfcDimensionCurveDirectedCallout(ifcDimensionCurveDirectedCallout);
			if (result == null)
				result = caseIfcDraughtingCallout(ifcDimensionCurveDirectedCallout);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcDimensionCurveDirectedCallout);
			if (result == null)
				result = caseIfcRepresentationItem(ifcDimensionCurveDirectedCallout);
			if (result == null)
				result = caseIfcLayeredItem(ifcDimensionCurveDirectedCallout);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIMENSION_CURVE_TERMINATOR: {
			IfcDimensionCurveTerminator ifcDimensionCurveTerminator = (IfcDimensionCurveTerminator) theEObject;
			T result = caseIfcDimensionCurveTerminator(ifcDimensionCurveTerminator);
			if (result == null)
				result = caseIfcTerminatorSymbol(ifcDimensionCurveTerminator);
			if (result == null)
				result = caseIfcAnnotationSymbolOccurrence(ifcDimensionCurveTerminator);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcDimensionCurveTerminator);
			if (result == null)
				result = caseIfcDraughtingCalloutElement(ifcDimensionCurveTerminator);
			if (result == null)
				result = caseIfcStyledItem(ifcDimensionCurveTerminator);
			if (result == null)
				result = caseIfcRepresentationItem(ifcDimensionCurveTerminator);
			if (result == null)
				result = caseIfcLayeredItem(ifcDimensionCurveTerminator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIMENSION_PAIR: {
			IfcDimensionPair ifcDimensionPair = (IfcDimensionPair) theEObject;
			T result = caseIfcDimensionPair(ifcDimensionPair);
			if (result == null)
				result = caseIfcDraughtingCalloutRelationship(ifcDimensionPair);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIMENSIONAL_EXPONENTS: {
			IfcDimensionalExponents ifcDimensionalExponents = (IfcDimensionalExponents) theEObject;
			T result = caseIfcDimensionalExponents(ifcDimensionalExponents);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIRECTION: {
			IfcDirection ifcDirection = (IfcDirection) theEObject;
			T result = caseIfcDirection(ifcDirection);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcDirection);
			if (result == null)
				result = caseIfcOrientationSelect(ifcDirection);
			if (result == null)
				result = caseIfcVectorOrDirection(ifcDirection);
			if (result == null)
				result = caseIfcRepresentationItem(ifcDirection);
			if (result == null)
				result = caseIfcLayeredItem(ifcDirection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISCRETE_ACCESSORY: {
			IfcDiscreteAccessory ifcDiscreteAccessory = (IfcDiscreteAccessory) theEObject;
			T result = caseIfcDiscreteAccessory(ifcDiscreteAccessory);
			if (result == null)
				result = caseIfcElementComponent(ifcDiscreteAccessory);
			if (result == null)
				result = caseIfcElement(ifcDiscreteAccessory);
			if (result == null)
				result = caseIfcProduct(ifcDiscreteAccessory);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcDiscreteAccessory);
			if (result == null)
				result = caseIfcObject(ifcDiscreteAccessory);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDiscreteAccessory);
			if (result == null)
				result = caseIfcRoot(ifcDiscreteAccessory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISCRETE_ACCESSORY_TYPE: {
			IfcDiscreteAccessoryType ifcDiscreteAccessoryType = (IfcDiscreteAccessoryType) theEObject;
			T result = caseIfcDiscreteAccessoryType(ifcDiscreteAccessoryType);
			if (result == null)
				result = caseIfcElementComponentType(ifcDiscreteAccessoryType);
			if (result == null)
				result = caseIfcElementType(ifcDiscreteAccessoryType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDiscreteAccessoryType);
			if (result == null)
				result = caseIfcTypeObject(ifcDiscreteAccessoryType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDiscreteAccessoryType);
			if (result == null)
				result = caseIfcRoot(ifcDiscreteAccessoryType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT: {
			IfcDistributionChamberElement ifcDistributionChamberElement = (IfcDistributionChamberElement) theEObject;
			T result = caseIfcDistributionChamberElement(ifcDistributionChamberElement);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcDistributionChamberElement);
			if (result == null)
				result = caseIfcDistributionElement(ifcDistributionChamberElement);
			if (result == null)
				result = caseIfcElement(ifcDistributionChamberElement);
			if (result == null)
				result = caseIfcProduct(ifcDistributionChamberElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcDistributionChamberElement);
			if (result == null)
				result = caseIfcObject(ifcDistributionChamberElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionChamberElement);
			if (result == null)
				result = caseIfcRoot(ifcDistributionChamberElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CHAMBER_ELEMENT_TYPE: {
			IfcDistributionChamberElementType ifcDistributionChamberElementType = (IfcDistributionChamberElementType) theEObject;
			T result = caseIfcDistributionChamberElementType(ifcDistributionChamberElementType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcDistributionChamberElementType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcDistributionChamberElementType);
			if (result == null)
				result = caseIfcElementType(ifcDistributionChamberElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDistributionChamberElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcDistributionChamberElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionChamberElementType);
			if (result == null)
				result = caseIfcRoot(ifcDistributionChamberElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CONTROL_ELEMENT: {
			IfcDistributionControlElement ifcDistributionControlElement = (IfcDistributionControlElement) theEObject;
			T result = caseIfcDistributionControlElement(ifcDistributionControlElement);
			if (result == null)
				result = caseIfcDistributionElement(ifcDistributionControlElement);
			if (result == null)
				result = caseIfcElement(ifcDistributionControlElement);
			if (result == null)
				result = caseIfcProduct(ifcDistributionControlElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcDistributionControlElement);
			if (result == null)
				result = caseIfcObject(ifcDistributionControlElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionControlElement);
			if (result == null)
				result = caseIfcRoot(ifcDistributionControlElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_CONTROL_ELEMENT_TYPE: {
			IfcDistributionControlElementType ifcDistributionControlElementType = (IfcDistributionControlElementType) theEObject;
			T result = caseIfcDistributionControlElementType(ifcDistributionControlElementType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcDistributionControlElementType);
			if (result == null)
				result = caseIfcElementType(ifcDistributionControlElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDistributionControlElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcDistributionControlElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionControlElementType);
			if (result == null)
				result = caseIfcRoot(ifcDistributionControlElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_ELEMENT: {
			IfcDistributionElement ifcDistributionElement = (IfcDistributionElement) theEObject;
			T result = caseIfcDistributionElement(ifcDistributionElement);
			if (result == null)
				result = caseIfcElement(ifcDistributionElement);
			if (result == null)
				result = caseIfcProduct(ifcDistributionElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcDistributionElement);
			if (result == null)
				result = caseIfcObject(ifcDistributionElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionElement);
			if (result == null)
				result = caseIfcRoot(ifcDistributionElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_ELEMENT_TYPE: {
			IfcDistributionElementType ifcDistributionElementType = (IfcDistributionElementType) theEObject;
			T result = caseIfcDistributionElementType(ifcDistributionElementType);
			if (result == null)
				result = caseIfcElementType(ifcDistributionElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDistributionElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcDistributionElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionElementType);
			if (result == null)
				result = caseIfcRoot(ifcDistributionElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_FLOW_ELEMENT: {
			IfcDistributionFlowElement ifcDistributionFlowElement = (IfcDistributionFlowElement) theEObject;
			T result = caseIfcDistributionFlowElement(ifcDistributionFlowElement);
			if (result == null)
				result = caseIfcDistributionElement(ifcDistributionFlowElement);
			if (result == null)
				result = caseIfcElement(ifcDistributionFlowElement);
			if (result == null)
				result = caseIfcProduct(ifcDistributionFlowElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcDistributionFlowElement);
			if (result == null)
				result = caseIfcObject(ifcDistributionFlowElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionFlowElement);
			if (result == null)
				result = caseIfcRoot(ifcDistributionFlowElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_FLOW_ELEMENT_TYPE: {
			IfcDistributionFlowElementType ifcDistributionFlowElementType = (IfcDistributionFlowElementType) theEObject;
			T result = caseIfcDistributionFlowElementType(ifcDistributionFlowElementType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcDistributionFlowElementType);
			if (result == null)
				result = caseIfcElementType(ifcDistributionFlowElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDistributionFlowElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcDistributionFlowElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionFlowElementType);
			if (result == null)
				result = caseIfcRoot(ifcDistributionFlowElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DISTRIBUTION_PORT: {
			IfcDistributionPort ifcDistributionPort = (IfcDistributionPort) theEObject;
			T result = caseIfcDistributionPort(ifcDistributionPort);
			if (result == null)
				result = caseIfcPort(ifcDistributionPort);
			if (result == null)
				result = caseIfcProduct(ifcDistributionPort);
			if (result == null)
				result = caseIfcObject(ifcDistributionPort);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDistributionPort);
			if (result == null)
				result = caseIfcRoot(ifcDistributionPort);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOCUMENT_ELECTRONIC_FORMAT: {
			IfcDocumentElectronicFormat ifcDocumentElectronicFormat = (IfcDocumentElectronicFormat) theEObject;
			T result = caseIfcDocumentElectronicFormat(ifcDocumentElectronicFormat);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOCUMENT_INFORMATION: {
			IfcDocumentInformation ifcDocumentInformation = (IfcDocumentInformation) theEObject;
			T result = caseIfcDocumentInformation(ifcDocumentInformation);
			if (result == null)
				result = caseIfcDocumentSelect(ifcDocumentInformation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOCUMENT_INFORMATION_RELATIONSHIP: {
			IfcDocumentInformationRelationship ifcDocumentInformationRelationship = (IfcDocumentInformationRelationship) theEObject;
			T result = caseIfcDocumentInformationRelationship(ifcDocumentInformationRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOCUMENT_REFERENCE: {
			IfcDocumentReference ifcDocumentReference = (IfcDocumentReference) theEObject;
			T result = caseIfcDocumentReference(ifcDocumentReference);
			if (result == null)
				result = caseIfcExternalReference(ifcDocumentReference);
			if (result == null)
				result = caseIfcDocumentSelect(ifcDocumentReference);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcDocumentReference);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcDocumentReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOOR: {
			IfcDoor ifcDoor = (IfcDoor) theEObject;
			T result = caseIfcDoor(ifcDoor);
			if (result == null)
				result = caseIfcBuildingElement(ifcDoor);
			if (result == null)
				result = caseIfcElement(ifcDoor);
			if (result == null)
				result = caseIfcProduct(ifcDoor);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcDoor);
			if (result == null)
				result = caseIfcObject(ifcDoor);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDoor);
			if (result == null)
				result = caseIfcRoot(ifcDoor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOOR_LINING_PROPERTIES: {
			IfcDoorLiningProperties ifcDoorLiningProperties = (IfcDoorLiningProperties) theEObject;
			T result = caseIfcDoorLiningProperties(ifcDoorLiningProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcDoorLiningProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcDoorLiningProperties);
			if (result == null)
				result = caseIfcRoot(ifcDoorLiningProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOOR_PANEL_PROPERTIES: {
			IfcDoorPanelProperties ifcDoorPanelProperties = (IfcDoorPanelProperties) theEObject;
			T result = caseIfcDoorPanelProperties(ifcDoorPanelProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcDoorPanelProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcDoorPanelProperties);
			if (result == null)
				result = caseIfcRoot(ifcDoorPanelProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOOR_STYLE: {
			IfcDoorStyle ifcDoorStyle = (IfcDoorStyle) theEObject;
			T result = caseIfcDoorStyle(ifcDoorStyle);
			if (result == null)
				result = caseIfcTypeProduct(ifcDoorStyle);
			if (result == null)
				result = caseIfcTypeObject(ifcDoorStyle);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDoorStyle);
			if (result == null)
				result = caseIfcRoot(ifcDoorStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DRAUGHTING_CALLOUT: {
			IfcDraughtingCallout ifcDraughtingCallout = (IfcDraughtingCallout) theEObject;
			T result = caseIfcDraughtingCallout(ifcDraughtingCallout);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcDraughtingCallout);
			if (result == null)
				result = caseIfcRepresentationItem(ifcDraughtingCallout);
			if (result == null)
				result = caseIfcLayeredItem(ifcDraughtingCallout);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DRAUGHTING_CALLOUT_RELATIONSHIP: {
			IfcDraughtingCalloutRelationship ifcDraughtingCalloutRelationship = (IfcDraughtingCalloutRelationship) theEObject;
			T result = caseIfcDraughtingCalloutRelationship(ifcDraughtingCalloutRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DRAUGHTING_PRE_DEFINED_COLOUR: {
			IfcDraughtingPreDefinedColour ifcDraughtingPreDefinedColour = (IfcDraughtingPreDefinedColour) theEObject;
			T result = caseIfcDraughtingPreDefinedColour(ifcDraughtingPreDefinedColour);
			if (result == null)
				result = caseIfcPreDefinedColour(ifcDraughtingPreDefinedColour);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcDraughtingPreDefinedColour);
			if (result == null)
				result = caseIfcColour(ifcDraughtingPreDefinedColour);
			if (result == null)
				result = caseIfcFillStyleSelect(ifcDraughtingPreDefinedColour);
			if (result == null)
				result = caseIfcSymbolStyleSelect(ifcDraughtingPreDefinedColour);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DRAUGHTING_PRE_DEFINED_CURVE_FONT: {
			IfcDraughtingPreDefinedCurveFont ifcDraughtingPreDefinedCurveFont = (IfcDraughtingPreDefinedCurveFont) theEObject;
			T result = caseIfcDraughtingPreDefinedCurveFont(ifcDraughtingPreDefinedCurveFont);
			if (result == null)
				result = caseIfcPreDefinedCurveFont(ifcDraughtingPreDefinedCurveFont);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcDraughtingPreDefinedCurveFont);
			if (result == null)
				result = caseIfcCurveStyleFontSelect(ifcDraughtingPreDefinedCurveFont);
			if (result == null)
				result = caseIfcCurveFontOrScaledCurveFontSelect(ifcDraughtingPreDefinedCurveFont);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DRAUGHTING_PRE_DEFINED_TEXT_FONT: {
			IfcDraughtingPreDefinedTextFont ifcDraughtingPreDefinedTextFont = (IfcDraughtingPreDefinedTextFont) theEObject;
			T result = caseIfcDraughtingPreDefinedTextFont(ifcDraughtingPreDefinedTextFont);
			if (result == null)
				result = caseIfcPreDefinedTextFont(ifcDraughtingPreDefinedTextFont);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcDraughtingPreDefinedTextFont);
			if (result == null)
				result = caseIfcTextFontSelect(ifcDraughtingPreDefinedTextFont);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DUCT_FITTING_TYPE: {
			IfcDuctFittingType ifcDuctFittingType = (IfcDuctFittingType) theEObject;
			T result = caseIfcDuctFittingType(ifcDuctFittingType);
			if (result == null)
				result = caseIfcFlowFittingType(ifcDuctFittingType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcDuctFittingType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcDuctFittingType);
			if (result == null)
				result = caseIfcElementType(ifcDuctFittingType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDuctFittingType);
			if (result == null)
				result = caseIfcTypeObject(ifcDuctFittingType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDuctFittingType);
			if (result == null)
				result = caseIfcRoot(ifcDuctFittingType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DUCT_SEGMENT_TYPE: {
			IfcDuctSegmentType ifcDuctSegmentType = (IfcDuctSegmentType) theEObject;
			T result = caseIfcDuctSegmentType(ifcDuctSegmentType);
			if (result == null)
				result = caseIfcFlowSegmentType(ifcDuctSegmentType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcDuctSegmentType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcDuctSegmentType);
			if (result == null)
				result = caseIfcElementType(ifcDuctSegmentType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDuctSegmentType);
			if (result == null)
				result = caseIfcTypeObject(ifcDuctSegmentType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDuctSegmentType);
			if (result == null)
				result = caseIfcRoot(ifcDuctSegmentType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DUCT_SILENCER_TYPE: {
			IfcDuctSilencerType ifcDuctSilencerType = (IfcDuctSilencerType) theEObject;
			T result = caseIfcDuctSilencerType(ifcDuctSilencerType);
			if (result == null)
				result = caseIfcFlowTreatmentDeviceType(ifcDuctSilencerType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcDuctSilencerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcDuctSilencerType);
			if (result == null)
				result = caseIfcElementType(ifcDuctSilencerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcDuctSilencerType);
			if (result == null)
				result = caseIfcTypeObject(ifcDuctSilencerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcDuctSilencerType);
			if (result == null)
				result = caseIfcRoot(ifcDuctSilencerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EDGE: {
			IfcEdge ifcEdge = (IfcEdge) theEObject;
			T result = caseIfcEdge(ifcEdge);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcEdge);
			if (result == null)
				result = caseIfcRepresentationItem(ifcEdge);
			if (result == null)
				result = caseIfcLayeredItem(ifcEdge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EDGE_CURVE: {
			IfcEdgeCurve ifcEdgeCurve = (IfcEdgeCurve) theEObject;
			T result = caseIfcEdgeCurve(ifcEdgeCurve);
			if (result == null)
				result = caseIfcEdge(ifcEdgeCurve);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifcEdgeCurve);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcEdgeCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcEdgeCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcEdgeCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EDGE_FEATURE: {
			IfcEdgeFeature ifcEdgeFeature = (IfcEdgeFeature) theEObject;
			T result = caseIfcEdgeFeature(ifcEdgeFeature);
			if (result == null)
				result = caseIfcFeatureElementSubtraction(ifcEdgeFeature);
			if (result == null)
				result = caseIfcFeatureElement(ifcEdgeFeature);
			if (result == null)
				result = caseIfcElement(ifcEdgeFeature);
			if (result == null)
				result = caseIfcProduct(ifcEdgeFeature);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcEdgeFeature);
			if (result == null)
				result = caseIfcObject(ifcEdgeFeature);
			if (result == null)
				result = caseIfcObjectDefinition(ifcEdgeFeature);
			if (result == null)
				result = caseIfcRoot(ifcEdgeFeature);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EDGE_LOOP: {
			IfcEdgeLoop ifcEdgeLoop = (IfcEdgeLoop) theEObject;
			T result = caseIfcEdgeLoop(ifcEdgeLoop);
			if (result == null)
				result = caseIfcLoop(ifcEdgeLoop);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcEdgeLoop);
			if (result == null)
				result = caseIfcRepresentationItem(ifcEdgeLoop);
			if (result == null)
				result = caseIfcLayeredItem(ifcEdgeLoop);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_APPLIANCE_TYPE: {
			IfcElectricApplianceType ifcElectricApplianceType = (IfcElectricApplianceType) theEObject;
			T result = caseIfcElectricApplianceType(ifcElectricApplianceType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcElectricApplianceType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcElectricApplianceType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcElectricApplianceType);
			if (result == null)
				result = caseIfcElementType(ifcElectricApplianceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcElectricApplianceType);
			if (result == null)
				result = caseIfcTypeObject(ifcElectricApplianceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricApplianceType);
			if (result == null)
				result = caseIfcRoot(ifcElectricApplianceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_DISTRIBUTION_POINT: {
			IfcElectricDistributionPoint ifcElectricDistributionPoint = (IfcElectricDistributionPoint) theEObject;
			T result = caseIfcElectricDistributionPoint(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcFlowController(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcDistributionElement(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcElement(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcProduct(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcObject(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricDistributionPoint);
			if (result == null)
				result = caseIfcRoot(ifcElectricDistributionPoint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_FLOW_STORAGE_DEVICE_TYPE: {
			IfcElectricFlowStorageDeviceType ifcElectricFlowStorageDeviceType = (IfcElectricFlowStorageDeviceType) theEObject;
			T result = caseIfcElectricFlowStorageDeviceType(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = caseIfcFlowStorageDeviceType(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = caseIfcElementType(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = caseIfcTypeObject(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = caseIfcRoot(ifcElectricFlowStorageDeviceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_GENERATOR_TYPE: {
			IfcElectricGeneratorType ifcElectricGeneratorType = (IfcElectricGeneratorType) theEObject;
			T result = caseIfcElectricGeneratorType(ifcElectricGeneratorType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcElectricGeneratorType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcElectricGeneratorType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcElectricGeneratorType);
			if (result == null)
				result = caseIfcElementType(ifcElectricGeneratorType);
			if (result == null)
				result = caseIfcTypeProduct(ifcElectricGeneratorType);
			if (result == null)
				result = caseIfcTypeObject(ifcElectricGeneratorType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricGeneratorType);
			if (result == null)
				result = caseIfcRoot(ifcElectricGeneratorType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_HEATER_TYPE: {
			IfcElectricHeaterType ifcElectricHeaterType = (IfcElectricHeaterType) theEObject;
			T result = caseIfcElectricHeaterType(ifcElectricHeaterType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcElectricHeaterType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcElectricHeaterType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcElectricHeaterType);
			if (result == null)
				result = caseIfcElementType(ifcElectricHeaterType);
			if (result == null)
				result = caseIfcTypeProduct(ifcElectricHeaterType);
			if (result == null)
				result = caseIfcTypeObject(ifcElectricHeaterType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricHeaterType);
			if (result == null)
				result = caseIfcRoot(ifcElectricHeaterType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_MOTOR_TYPE: {
			IfcElectricMotorType ifcElectricMotorType = (IfcElectricMotorType) theEObject;
			T result = caseIfcElectricMotorType(ifcElectricMotorType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcElectricMotorType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcElectricMotorType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcElectricMotorType);
			if (result == null)
				result = caseIfcElementType(ifcElectricMotorType);
			if (result == null)
				result = caseIfcTypeProduct(ifcElectricMotorType);
			if (result == null)
				result = caseIfcTypeObject(ifcElectricMotorType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricMotorType);
			if (result == null)
				result = caseIfcRoot(ifcElectricMotorType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_TIME_CONTROL_TYPE: {
			IfcElectricTimeControlType ifcElectricTimeControlType = (IfcElectricTimeControlType) theEObject;
			T result = caseIfcElectricTimeControlType(ifcElectricTimeControlType);
			if (result == null)
				result = caseIfcFlowControllerType(ifcElectricTimeControlType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcElectricTimeControlType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcElectricTimeControlType);
			if (result == null)
				result = caseIfcElementType(ifcElectricTimeControlType);
			if (result == null)
				result = caseIfcTypeProduct(ifcElectricTimeControlType);
			if (result == null)
				result = caseIfcTypeObject(ifcElectricTimeControlType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricTimeControlType);
			if (result == null)
				result = caseIfcRoot(ifcElectricTimeControlType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRICAL_BASE_PROPERTIES: {
			IfcElectricalBaseProperties ifcElectricalBaseProperties = (IfcElectricalBaseProperties) theEObject;
			T result = caseIfcElectricalBaseProperties(ifcElectricalBaseProperties);
			if (result == null)
				result = caseIfcEnergyProperties(ifcElectricalBaseProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcElectricalBaseProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcElectricalBaseProperties);
			if (result == null)
				result = caseIfcRoot(ifcElectricalBaseProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRICAL_CIRCUIT: {
			IfcElectricalCircuit ifcElectricalCircuit = (IfcElectricalCircuit) theEObject;
			T result = caseIfcElectricalCircuit(ifcElectricalCircuit);
			if (result == null)
				result = caseIfcSystem(ifcElectricalCircuit);
			if (result == null)
				result = caseIfcGroup(ifcElectricalCircuit);
			if (result == null)
				result = caseIfcObject(ifcElectricalCircuit);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricalCircuit);
			if (result == null)
				result = caseIfcRoot(ifcElectricalCircuit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRICAL_ELEMENT: {
			IfcElectricalElement ifcElectricalElement = (IfcElectricalElement) theEObject;
			T result = caseIfcElectricalElement(ifcElectricalElement);
			if (result == null)
				result = caseIfcElement(ifcElectricalElement);
			if (result == null)
				result = caseIfcProduct(ifcElectricalElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcElectricalElement);
			if (result == null)
				result = caseIfcObject(ifcElectricalElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElectricalElement);
			if (result == null)
				result = caseIfcRoot(ifcElectricalElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELEMENT: {
			IfcElement ifcElement = (IfcElement) theEObject;
			T result = caseIfcElement(ifcElement);
			if (result == null)
				result = caseIfcProduct(ifcElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcElement);
			if (result == null)
				result = caseIfcObject(ifcElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElement);
			if (result == null)
				result = caseIfcRoot(ifcElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELEMENT_ASSEMBLY: {
			IfcElementAssembly ifcElementAssembly = (IfcElementAssembly) theEObject;
			T result = caseIfcElementAssembly(ifcElementAssembly);
			if (result == null)
				result = caseIfcElement(ifcElementAssembly);
			if (result == null)
				result = caseIfcProduct(ifcElementAssembly);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcElementAssembly);
			if (result == null)
				result = caseIfcObject(ifcElementAssembly);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElementAssembly);
			if (result == null)
				result = caseIfcRoot(ifcElementAssembly);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELEMENT_COMPONENT: {
			IfcElementComponent ifcElementComponent = (IfcElementComponent) theEObject;
			T result = caseIfcElementComponent(ifcElementComponent);
			if (result == null)
				result = caseIfcElement(ifcElementComponent);
			if (result == null)
				result = caseIfcProduct(ifcElementComponent);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcElementComponent);
			if (result == null)
				result = caseIfcObject(ifcElementComponent);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElementComponent);
			if (result == null)
				result = caseIfcRoot(ifcElementComponent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELEMENT_COMPONENT_TYPE: {
			IfcElementComponentType ifcElementComponentType = (IfcElementComponentType) theEObject;
			T result = caseIfcElementComponentType(ifcElementComponentType);
			if (result == null)
				result = caseIfcElementType(ifcElementComponentType);
			if (result == null)
				result = caseIfcTypeProduct(ifcElementComponentType);
			if (result == null)
				result = caseIfcTypeObject(ifcElementComponentType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElementComponentType);
			if (result == null)
				result = caseIfcRoot(ifcElementComponentType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELEMENT_QUANTITY: {
			IfcElementQuantity ifcElementQuantity = (IfcElementQuantity) theEObject;
			T result = caseIfcElementQuantity(ifcElementQuantity);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcElementQuantity);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcElementQuantity);
			if (result == null)
				result = caseIfcRoot(ifcElementQuantity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELEMENT_TYPE: {
			IfcElementType ifcElementType = (IfcElementType) theEObject;
			T result = caseIfcElementType(ifcElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcElementType);
			if (result == null)
				result = caseIfcRoot(ifcElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELEMENTARY_SURFACE: {
			IfcElementarySurface ifcElementarySurface = (IfcElementarySurface) theEObject;
			T result = caseIfcElementarySurface(ifcElementarySurface);
			if (result == null)
				result = caseIfcSurface(ifcElementarySurface);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcElementarySurface);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcElementarySurface);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcElementarySurface);
			if (result == null)
				result = caseIfcRepresentationItem(ifcElementarySurface);
			if (result == null)
				result = caseIfcLayeredItem(ifcElementarySurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELLIPSE: {
			IfcEllipse ifcEllipse = (IfcEllipse) theEObject;
			T result = caseIfcEllipse(ifcEllipse);
			if (result == null)
				result = caseIfcConic(ifcEllipse);
			if (result == null)
				result = caseIfcCurve(ifcEllipse);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcEllipse);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcEllipse);
			if (result == null)
				result = caseIfcRepresentationItem(ifcEllipse);
			if (result == null)
				result = caseIfcLayeredItem(ifcEllipse);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELLIPSE_PROFILE_DEF: {
			IfcEllipseProfileDef ifcEllipseProfileDef = (IfcEllipseProfileDef) theEObject;
			T result = caseIfcEllipseProfileDef(ifcEllipseProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcEllipseProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcEllipseProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ENERGY_CONVERSION_DEVICE: {
			IfcEnergyConversionDevice ifcEnergyConversionDevice = (IfcEnergyConversionDevice) theEObject;
			T result = caseIfcEnergyConversionDevice(ifcEnergyConversionDevice);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcEnergyConversionDevice);
			if (result == null)
				result = caseIfcDistributionElement(ifcEnergyConversionDevice);
			if (result == null)
				result = caseIfcElement(ifcEnergyConversionDevice);
			if (result == null)
				result = caseIfcProduct(ifcEnergyConversionDevice);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcEnergyConversionDevice);
			if (result == null)
				result = caseIfcObject(ifcEnergyConversionDevice);
			if (result == null)
				result = caseIfcObjectDefinition(ifcEnergyConversionDevice);
			if (result == null)
				result = caseIfcRoot(ifcEnergyConversionDevice);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ENERGY_CONVERSION_DEVICE_TYPE: {
			IfcEnergyConversionDeviceType ifcEnergyConversionDeviceType = (IfcEnergyConversionDeviceType) theEObject;
			T result = caseIfcEnergyConversionDeviceType(ifcEnergyConversionDeviceType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcEnergyConversionDeviceType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcEnergyConversionDeviceType);
			if (result == null)
				result = caseIfcElementType(ifcEnergyConversionDeviceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcEnergyConversionDeviceType);
			if (result == null)
				result = caseIfcTypeObject(ifcEnergyConversionDeviceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcEnergyConversionDeviceType);
			if (result == null)
				result = caseIfcRoot(ifcEnergyConversionDeviceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ENERGY_PROPERTIES: {
			IfcEnergyProperties ifcEnergyProperties = (IfcEnergyProperties) theEObject;
			T result = caseIfcEnergyProperties(ifcEnergyProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcEnergyProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcEnergyProperties);
			if (result == null)
				result = caseIfcRoot(ifcEnergyProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ENVIRONMENTAL_IMPACT_VALUE: {
			IfcEnvironmentalImpactValue ifcEnvironmentalImpactValue = (IfcEnvironmentalImpactValue) theEObject;
			T result = caseIfcEnvironmentalImpactValue(ifcEnvironmentalImpactValue);
			if (result == null)
				result = caseIfcAppliedValue(ifcEnvironmentalImpactValue);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcEnvironmentalImpactValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EQUIPMENT_ELEMENT: {
			IfcEquipmentElement ifcEquipmentElement = (IfcEquipmentElement) theEObject;
			T result = caseIfcEquipmentElement(ifcEquipmentElement);
			if (result == null)
				result = caseIfcElement(ifcEquipmentElement);
			if (result == null)
				result = caseIfcProduct(ifcEquipmentElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcEquipmentElement);
			if (result == null)
				result = caseIfcObject(ifcEquipmentElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcEquipmentElement);
			if (result == null)
				result = caseIfcRoot(ifcEquipmentElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EQUIPMENT_STANDARD: {
			IfcEquipmentStandard ifcEquipmentStandard = (IfcEquipmentStandard) theEObject;
			T result = caseIfcEquipmentStandard(ifcEquipmentStandard);
			if (result == null)
				result = caseIfcControl(ifcEquipmentStandard);
			if (result == null)
				result = caseIfcObject(ifcEquipmentStandard);
			if (result == null)
				result = caseIfcObjectDefinition(ifcEquipmentStandard);
			if (result == null)
				result = caseIfcRoot(ifcEquipmentStandard);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EVAPORATIVE_COOLER_TYPE: {
			IfcEvaporativeCoolerType ifcEvaporativeCoolerType = (IfcEvaporativeCoolerType) theEObject;
			T result = caseIfcEvaporativeCoolerType(ifcEvaporativeCoolerType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcEvaporativeCoolerType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcEvaporativeCoolerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcEvaporativeCoolerType);
			if (result == null)
				result = caseIfcElementType(ifcEvaporativeCoolerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcEvaporativeCoolerType);
			if (result == null)
				result = caseIfcTypeObject(ifcEvaporativeCoolerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcEvaporativeCoolerType);
			if (result == null)
				result = caseIfcRoot(ifcEvaporativeCoolerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EVAPORATOR_TYPE: {
			IfcEvaporatorType ifcEvaporatorType = (IfcEvaporatorType) theEObject;
			T result = caseIfcEvaporatorType(ifcEvaporatorType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcEvaporatorType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcEvaporatorType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcEvaporatorType);
			if (result == null)
				result = caseIfcElementType(ifcEvaporatorType);
			if (result == null)
				result = caseIfcTypeProduct(ifcEvaporatorType);
			if (result == null)
				result = caseIfcTypeObject(ifcEvaporatorType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcEvaporatorType);
			if (result == null)
				result = caseIfcRoot(ifcEvaporatorType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EXTENDED_MATERIAL_PROPERTIES: {
			IfcExtendedMaterialProperties ifcExtendedMaterialProperties = (IfcExtendedMaterialProperties) theEObject;
			T result = caseIfcExtendedMaterialProperties(ifcExtendedMaterialProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcExtendedMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EXTERNAL_REFERENCE: {
			IfcExternalReference ifcExternalReference = (IfcExternalReference) theEObject;
			T result = caseIfcExternalReference(ifcExternalReference);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcExternalReference);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcExternalReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EXTERNALLY_DEFINED_HATCH_STYLE: {
			IfcExternallyDefinedHatchStyle ifcExternallyDefinedHatchStyle = (IfcExternallyDefinedHatchStyle) theEObject;
			T result = caseIfcExternallyDefinedHatchStyle(ifcExternallyDefinedHatchStyle);
			if (result == null)
				result = caseIfcExternalReference(ifcExternallyDefinedHatchStyle);
			if (result == null)
				result = caseIfcFillStyleSelect(ifcExternallyDefinedHatchStyle);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcExternallyDefinedHatchStyle);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcExternallyDefinedHatchStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EXTERNALLY_DEFINED_SURFACE_STYLE: {
			IfcExternallyDefinedSurfaceStyle ifcExternallyDefinedSurfaceStyle = (IfcExternallyDefinedSurfaceStyle) theEObject;
			T result = caseIfcExternallyDefinedSurfaceStyle(ifcExternallyDefinedSurfaceStyle);
			if (result == null)
				result = caseIfcExternalReference(ifcExternallyDefinedSurfaceStyle);
			if (result == null)
				result = caseIfcSurfaceStyleElementSelect(ifcExternallyDefinedSurfaceStyle);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcExternallyDefinedSurfaceStyle);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcExternallyDefinedSurfaceStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EXTERNALLY_DEFINED_SYMBOL: {
			IfcExternallyDefinedSymbol ifcExternallyDefinedSymbol = (IfcExternallyDefinedSymbol) theEObject;
			T result = caseIfcExternallyDefinedSymbol(ifcExternallyDefinedSymbol);
			if (result == null)
				result = caseIfcExternalReference(ifcExternallyDefinedSymbol);
			if (result == null)
				result = caseIfcDefinedSymbolSelect(ifcExternallyDefinedSymbol);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcExternallyDefinedSymbol);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcExternallyDefinedSymbol);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EXTERNALLY_DEFINED_TEXT_FONT: {
			IfcExternallyDefinedTextFont ifcExternallyDefinedTextFont = (IfcExternallyDefinedTextFont) theEObject;
			T result = caseIfcExternallyDefinedTextFont(ifcExternallyDefinedTextFont);
			if (result == null)
				result = caseIfcExternalReference(ifcExternallyDefinedTextFont);
			if (result == null)
				result = caseIfcTextFontSelect(ifcExternallyDefinedTextFont);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcExternallyDefinedTextFont);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcExternallyDefinedTextFont);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_EXTRUDED_AREA_SOLID: {
			IfcExtrudedAreaSolid ifcExtrudedAreaSolid = (IfcExtrudedAreaSolid) theEObject;
			T result = caseIfcExtrudedAreaSolid(ifcExtrudedAreaSolid);
			if (result == null)
				result = caseIfcSweptAreaSolid(ifcExtrudedAreaSolid);
			if (result == null)
				result = caseIfcSolidModel(ifcExtrudedAreaSolid);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcExtrudedAreaSolid);
			if (result == null)
				result = caseIfcBooleanOperand(ifcExtrudedAreaSolid);
			if (result == null)
				result = caseIfcRepresentationItem(ifcExtrudedAreaSolid);
			if (result == null)
				result = caseIfcLayeredItem(ifcExtrudedAreaSolid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FACE: {
			IfcFace ifcFace = (IfcFace) theEObject;
			T result = caseIfcFace(ifcFace);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcFace);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFace);
			if (result == null)
				result = caseIfcLayeredItem(ifcFace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FACE_BASED_SURFACE_MODEL: {
			IfcFaceBasedSurfaceModel ifcFaceBasedSurfaceModel = (IfcFaceBasedSurfaceModel) theEObject;
			T result = caseIfcFaceBasedSurfaceModel(ifcFaceBasedSurfaceModel);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcFaceBasedSurfaceModel);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcFaceBasedSurfaceModel);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFaceBasedSurfaceModel);
			if (result == null)
				result = caseIfcLayeredItem(ifcFaceBasedSurfaceModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FACE_BOUND: {
			IfcFaceBound ifcFaceBound = (IfcFaceBound) theEObject;
			T result = caseIfcFaceBound(ifcFaceBound);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcFaceBound);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFaceBound);
			if (result == null)
				result = caseIfcLayeredItem(ifcFaceBound);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FACE_OUTER_BOUND: {
			IfcFaceOuterBound ifcFaceOuterBound = (IfcFaceOuterBound) theEObject;
			T result = caseIfcFaceOuterBound(ifcFaceOuterBound);
			if (result == null)
				result = caseIfcFaceBound(ifcFaceOuterBound);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcFaceOuterBound);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFaceOuterBound);
			if (result == null)
				result = caseIfcLayeredItem(ifcFaceOuterBound);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FACE_SURFACE: {
			IfcFaceSurface ifcFaceSurface = (IfcFaceSurface) theEObject;
			T result = caseIfcFaceSurface(ifcFaceSurface);
			if (result == null)
				result = caseIfcFace(ifcFaceSurface);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcFaceSurface);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcFaceSurface);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFaceSurface);
			if (result == null)
				result = caseIfcLayeredItem(ifcFaceSurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FACETED_BREP: {
			IfcFacetedBrep ifcFacetedBrep = (IfcFacetedBrep) theEObject;
			T result = caseIfcFacetedBrep(ifcFacetedBrep);
			if (result == null)
				result = caseIfcManifoldSolidBrep(ifcFacetedBrep);
			if (result == null)
				result = caseIfcSolidModel(ifcFacetedBrep);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcFacetedBrep);
			if (result == null)
				result = caseIfcBooleanOperand(ifcFacetedBrep);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFacetedBrep);
			if (result == null)
				result = caseIfcLayeredItem(ifcFacetedBrep);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FACETED_BREP_WITH_VOIDS: {
			IfcFacetedBrepWithVoids ifcFacetedBrepWithVoids = (IfcFacetedBrepWithVoids) theEObject;
			T result = caseIfcFacetedBrepWithVoids(ifcFacetedBrepWithVoids);
			if (result == null)
				result = caseIfcManifoldSolidBrep(ifcFacetedBrepWithVoids);
			if (result == null)
				result = caseIfcSolidModel(ifcFacetedBrepWithVoids);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcFacetedBrepWithVoids);
			if (result == null)
				result = caseIfcBooleanOperand(ifcFacetedBrepWithVoids);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFacetedBrepWithVoids);
			if (result == null)
				result = caseIfcLayeredItem(ifcFacetedBrepWithVoids);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FAILURE_CONNECTION_CONDITION: {
			IfcFailureConnectionCondition ifcFailureConnectionCondition = (IfcFailureConnectionCondition) theEObject;
			T result = caseIfcFailureConnectionCondition(ifcFailureConnectionCondition);
			if (result == null)
				result = caseIfcStructuralConnectionCondition(ifcFailureConnectionCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FAN_TYPE: {
			IfcFanType ifcFanType = (IfcFanType) theEObject;
			T result = caseIfcFanType(ifcFanType);
			if (result == null)
				result = caseIfcFlowMovingDeviceType(ifcFanType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFanType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFanType);
			if (result == null)
				result = caseIfcElementType(ifcFanType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFanType);
			if (result == null)
				result = caseIfcTypeObject(ifcFanType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFanType);
			if (result == null)
				result = caseIfcRoot(ifcFanType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FASTENER: {
			IfcFastener ifcFastener = (IfcFastener) theEObject;
			T result = caseIfcFastener(ifcFastener);
			if (result == null)
				result = caseIfcElementComponent(ifcFastener);
			if (result == null)
				result = caseIfcElement(ifcFastener);
			if (result == null)
				result = caseIfcProduct(ifcFastener);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFastener);
			if (result == null)
				result = caseIfcObject(ifcFastener);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFastener);
			if (result == null)
				result = caseIfcRoot(ifcFastener);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FASTENER_TYPE: {
			IfcFastenerType ifcFastenerType = (IfcFastenerType) theEObject;
			T result = caseIfcFastenerType(ifcFastenerType);
			if (result == null)
				result = caseIfcElementComponentType(ifcFastenerType);
			if (result == null)
				result = caseIfcElementType(ifcFastenerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFastenerType);
			if (result == null)
				result = caseIfcTypeObject(ifcFastenerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFastenerType);
			if (result == null)
				result = caseIfcRoot(ifcFastenerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FEATURE_ELEMENT: {
			IfcFeatureElement ifcFeatureElement = (IfcFeatureElement) theEObject;
			T result = caseIfcFeatureElement(ifcFeatureElement);
			if (result == null)
				result = caseIfcElement(ifcFeatureElement);
			if (result == null)
				result = caseIfcProduct(ifcFeatureElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFeatureElement);
			if (result == null)
				result = caseIfcObject(ifcFeatureElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFeatureElement);
			if (result == null)
				result = caseIfcRoot(ifcFeatureElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FEATURE_ELEMENT_ADDITION: {
			IfcFeatureElementAddition ifcFeatureElementAddition = (IfcFeatureElementAddition) theEObject;
			T result = caseIfcFeatureElementAddition(ifcFeatureElementAddition);
			if (result == null)
				result = caseIfcFeatureElement(ifcFeatureElementAddition);
			if (result == null)
				result = caseIfcElement(ifcFeatureElementAddition);
			if (result == null)
				result = caseIfcProduct(ifcFeatureElementAddition);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFeatureElementAddition);
			if (result == null)
				result = caseIfcObject(ifcFeatureElementAddition);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFeatureElementAddition);
			if (result == null)
				result = caseIfcRoot(ifcFeatureElementAddition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FEATURE_ELEMENT_SUBTRACTION: {
			IfcFeatureElementSubtraction ifcFeatureElementSubtraction = (IfcFeatureElementSubtraction) theEObject;
			T result = caseIfcFeatureElementSubtraction(ifcFeatureElementSubtraction);
			if (result == null)
				result = caseIfcFeatureElement(ifcFeatureElementSubtraction);
			if (result == null)
				result = caseIfcElement(ifcFeatureElementSubtraction);
			if (result == null)
				result = caseIfcProduct(ifcFeatureElementSubtraction);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFeatureElementSubtraction);
			if (result == null)
				result = caseIfcObject(ifcFeatureElementSubtraction);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFeatureElementSubtraction);
			if (result == null)
				result = caseIfcRoot(ifcFeatureElementSubtraction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE: {
			IfcFillAreaStyle ifcFillAreaStyle = (IfcFillAreaStyle) theEObject;
			T result = caseIfcFillAreaStyle(ifcFillAreaStyle);
			if (result == null)
				result = caseIfcPresentationStyle(ifcFillAreaStyle);
			if (result == null)
				result = caseIfcPresentationStyleSelect(ifcFillAreaStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE_HATCHING: {
			IfcFillAreaStyleHatching ifcFillAreaStyleHatching = (IfcFillAreaStyleHatching) theEObject;
			T result = caseIfcFillAreaStyleHatching(ifcFillAreaStyleHatching);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcFillAreaStyleHatching);
			if (result == null)
				result = caseIfcFillStyleSelect(ifcFillAreaStyleHatching);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFillAreaStyleHatching);
			if (result == null)
				result = caseIfcLayeredItem(ifcFillAreaStyleHatching);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE_TILE_SYMBOL_WITH_STYLE: {
			IfcFillAreaStyleTileSymbolWithStyle ifcFillAreaStyleTileSymbolWithStyle = (IfcFillAreaStyleTileSymbolWithStyle) theEObject;
			T result = caseIfcFillAreaStyleTileSymbolWithStyle(ifcFillAreaStyleTileSymbolWithStyle);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcFillAreaStyleTileSymbolWithStyle);
			if (result == null)
				result = caseIfcFillAreaStyleTileShapeSelect(ifcFillAreaStyleTileSymbolWithStyle);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFillAreaStyleTileSymbolWithStyle);
			if (result == null)
				result = caseIfcLayeredItem(ifcFillAreaStyleTileSymbolWithStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE_TILES: {
			IfcFillAreaStyleTiles ifcFillAreaStyleTiles = (IfcFillAreaStyleTiles) theEObject;
			T result = caseIfcFillAreaStyleTiles(ifcFillAreaStyleTiles);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcFillAreaStyleTiles);
			if (result == null)
				result = caseIfcFillStyleSelect(ifcFillAreaStyleTiles);
			if (result == null)
				result = caseIfcRepresentationItem(ifcFillAreaStyleTiles);
			if (result == null)
				result = caseIfcLayeredItem(ifcFillAreaStyleTiles);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FILTER_TYPE: {
			IfcFilterType ifcFilterType = (IfcFilterType) theEObject;
			T result = caseIfcFilterType(ifcFilterType);
			if (result == null)
				result = caseIfcFlowTreatmentDeviceType(ifcFilterType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFilterType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFilterType);
			if (result == null)
				result = caseIfcElementType(ifcFilterType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFilterType);
			if (result == null)
				result = caseIfcTypeObject(ifcFilterType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFilterType);
			if (result == null)
				result = caseIfcRoot(ifcFilterType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FIRE_SUPPRESSION_TERMINAL_TYPE: {
			IfcFireSuppressionTerminalType ifcFireSuppressionTerminalType = (IfcFireSuppressionTerminalType) theEObject;
			T result = caseIfcFireSuppressionTerminalType(ifcFireSuppressionTerminalType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcFireSuppressionTerminalType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFireSuppressionTerminalType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFireSuppressionTerminalType);
			if (result == null)
				result = caseIfcElementType(ifcFireSuppressionTerminalType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFireSuppressionTerminalType);
			if (result == null)
				result = caseIfcTypeObject(ifcFireSuppressionTerminalType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFireSuppressionTerminalType);
			if (result == null)
				result = caseIfcRoot(ifcFireSuppressionTerminalType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_CONTROLLER: {
			IfcFlowController ifcFlowController = (IfcFlowController) theEObject;
			T result = caseIfcFlowController(ifcFlowController);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcFlowController);
			if (result == null)
				result = caseIfcDistributionElement(ifcFlowController);
			if (result == null)
				result = caseIfcElement(ifcFlowController);
			if (result == null)
				result = caseIfcProduct(ifcFlowController);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFlowController);
			if (result == null)
				result = caseIfcObject(ifcFlowController);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowController);
			if (result == null)
				result = caseIfcRoot(ifcFlowController);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_CONTROLLER_TYPE: {
			IfcFlowControllerType ifcFlowControllerType = (IfcFlowControllerType) theEObject;
			T result = caseIfcFlowControllerType(ifcFlowControllerType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFlowControllerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowControllerType);
			if (result == null)
				result = caseIfcElementType(ifcFlowControllerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowControllerType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowControllerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowControllerType);
			if (result == null)
				result = caseIfcRoot(ifcFlowControllerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_FITTING: {
			IfcFlowFitting ifcFlowFitting = (IfcFlowFitting) theEObject;
			T result = caseIfcFlowFitting(ifcFlowFitting);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcFlowFitting);
			if (result == null)
				result = caseIfcDistributionElement(ifcFlowFitting);
			if (result == null)
				result = caseIfcElement(ifcFlowFitting);
			if (result == null)
				result = caseIfcProduct(ifcFlowFitting);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFlowFitting);
			if (result == null)
				result = caseIfcObject(ifcFlowFitting);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowFitting);
			if (result == null)
				result = caseIfcRoot(ifcFlowFitting);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_FITTING_TYPE: {
			IfcFlowFittingType ifcFlowFittingType = (IfcFlowFittingType) theEObject;
			T result = caseIfcFlowFittingType(ifcFlowFittingType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFlowFittingType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowFittingType);
			if (result == null)
				result = caseIfcElementType(ifcFlowFittingType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowFittingType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowFittingType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowFittingType);
			if (result == null)
				result = caseIfcRoot(ifcFlowFittingType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_INSTRUMENT_TYPE: {
			IfcFlowInstrumentType ifcFlowInstrumentType = (IfcFlowInstrumentType) theEObject;
			T result = caseIfcFlowInstrumentType(ifcFlowInstrumentType);
			if (result == null)
				result = caseIfcDistributionControlElementType(ifcFlowInstrumentType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowInstrumentType);
			if (result == null)
				result = caseIfcElementType(ifcFlowInstrumentType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowInstrumentType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowInstrumentType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowInstrumentType);
			if (result == null)
				result = caseIfcRoot(ifcFlowInstrumentType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_METER_TYPE: {
			IfcFlowMeterType ifcFlowMeterType = (IfcFlowMeterType) theEObject;
			T result = caseIfcFlowMeterType(ifcFlowMeterType);
			if (result == null)
				result = caseIfcFlowControllerType(ifcFlowMeterType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFlowMeterType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowMeterType);
			if (result == null)
				result = caseIfcElementType(ifcFlowMeterType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowMeterType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowMeterType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowMeterType);
			if (result == null)
				result = caseIfcRoot(ifcFlowMeterType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_MOVING_DEVICE: {
			IfcFlowMovingDevice ifcFlowMovingDevice = (IfcFlowMovingDevice) theEObject;
			T result = caseIfcFlowMovingDevice(ifcFlowMovingDevice);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcFlowMovingDevice);
			if (result == null)
				result = caseIfcDistributionElement(ifcFlowMovingDevice);
			if (result == null)
				result = caseIfcElement(ifcFlowMovingDevice);
			if (result == null)
				result = caseIfcProduct(ifcFlowMovingDevice);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFlowMovingDevice);
			if (result == null)
				result = caseIfcObject(ifcFlowMovingDevice);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowMovingDevice);
			if (result == null)
				result = caseIfcRoot(ifcFlowMovingDevice);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_MOVING_DEVICE_TYPE: {
			IfcFlowMovingDeviceType ifcFlowMovingDeviceType = (IfcFlowMovingDeviceType) theEObject;
			T result = caseIfcFlowMovingDeviceType(ifcFlowMovingDeviceType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFlowMovingDeviceType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowMovingDeviceType);
			if (result == null)
				result = caseIfcElementType(ifcFlowMovingDeviceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowMovingDeviceType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowMovingDeviceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowMovingDeviceType);
			if (result == null)
				result = caseIfcRoot(ifcFlowMovingDeviceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_SEGMENT: {
			IfcFlowSegment ifcFlowSegment = (IfcFlowSegment) theEObject;
			T result = caseIfcFlowSegment(ifcFlowSegment);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcFlowSegment);
			if (result == null)
				result = caseIfcDistributionElement(ifcFlowSegment);
			if (result == null)
				result = caseIfcElement(ifcFlowSegment);
			if (result == null)
				result = caseIfcProduct(ifcFlowSegment);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFlowSegment);
			if (result == null)
				result = caseIfcObject(ifcFlowSegment);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowSegment);
			if (result == null)
				result = caseIfcRoot(ifcFlowSegment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_SEGMENT_TYPE: {
			IfcFlowSegmentType ifcFlowSegmentType = (IfcFlowSegmentType) theEObject;
			T result = caseIfcFlowSegmentType(ifcFlowSegmentType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFlowSegmentType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowSegmentType);
			if (result == null)
				result = caseIfcElementType(ifcFlowSegmentType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowSegmentType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowSegmentType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowSegmentType);
			if (result == null)
				result = caseIfcRoot(ifcFlowSegmentType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_STORAGE_DEVICE: {
			IfcFlowStorageDevice ifcFlowStorageDevice = (IfcFlowStorageDevice) theEObject;
			T result = caseIfcFlowStorageDevice(ifcFlowStorageDevice);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcFlowStorageDevice);
			if (result == null)
				result = caseIfcDistributionElement(ifcFlowStorageDevice);
			if (result == null)
				result = caseIfcElement(ifcFlowStorageDevice);
			if (result == null)
				result = caseIfcProduct(ifcFlowStorageDevice);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFlowStorageDevice);
			if (result == null)
				result = caseIfcObject(ifcFlowStorageDevice);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowStorageDevice);
			if (result == null)
				result = caseIfcRoot(ifcFlowStorageDevice);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_STORAGE_DEVICE_TYPE: {
			IfcFlowStorageDeviceType ifcFlowStorageDeviceType = (IfcFlowStorageDeviceType) theEObject;
			T result = caseIfcFlowStorageDeviceType(ifcFlowStorageDeviceType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFlowStorageDeviceType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowStorageDeviceType);
			if (result == null)
				result = caseIfcElementType(ifcFlowStorageDeviceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowStorageDeviceType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowStorageDeviceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowStorageDeviceType);
			if (result == null)
				result = caseIfcRoot(ifcFlowStorageDeviceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_TERMINAL: {
			IfcFlowTerminal ifcFlowTerminal = (IfcFlowTerminal) theEObject;
			T result = caseIfcFlowTerminal(ifcFlowTerminal);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcFlowTerminal);
			if (result == null)
				result = caseIfcDistributionElement(ifcFlowTerminal);
			if (result == null)
				result = caseIfcElement(ifcFlowTerminal);
			if (result == null)
				result = caseIfcProduct(ifcFlowTerminal);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFlowTerminal);
			if (result == null)
				result = caseIfcObject(ifcFlowTerminal);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowTerminal);
			if (result == null)
				result = caseIfcRoot(ifcFlowTerminal);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_TERMINAL_TYPE: {
			IfcFlowTerminalType ifcFlowTerminalType = (IfcFlowTerminalType) theEObject;
			T result = caseIfcFlowTerminalType(ifcFlowTerminalType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFlowTerminalType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowTerminalType);
			if (result == null)
				result = caseIfcElementType(ifcFlowTerminalType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowTerminalType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowTerminalType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowTerminalType);
			if (result == null)
				result = caseIfcRoot(ifcFlowTerminalType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_TREATMENT_DEVICE: {
			IfcFlowTreatmentDevice ifcFlowTreatmentDevice = (IfcFlowTreatmentDevice) theEObject;
			T result = caseIfcFlowTreatmentDevice(ifcFlowTreatmentDevice);
			if (result == null)
				result = caseIfcDistributionFlowElement(ifcFlowTreatmentDevice);
			if (result == null)
				result = caseIfcDistributionElement(ifcFlowTreatmentDevice);
			if (result == null)
				result = caseIfcElement(ifcFlowTreatmentDevice);
			if (result == null)
				result = caseIfcProduct(ifcFlowTreatmentDevice);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFlowTreatmentDevice);
			if (result == null)
				result = caseIfcObject(ifcFlowTreatmentDevice);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowTreatmentDevice);
			if (result == null)
				result = caseIfcRoot(ifcFlowTreatmentDevice);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLOW_TREATMENT_DEVICE_TYPE: {
			IfcFlowTreatmentDeviceType ifcFlowTreatmentDeviceType = (IfcFlowTreatmentDeviceType) theEObject;
			T result = caseIfcFlowTreatmentDeviceType(ifcFlowTreatmentDeviceType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcFlowTreatmentDeviceType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcFlowTreatmentDeviceType);
			if (result == null)
				result = caseIfcElementType(ifcFlowTreatmentDeviceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFlowTreatmentDeviceType);
			if (result == null)
				result = caseIfcTypeObject(ifcFlowTreatmentDeviceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFlowTreatmentDeviceType);
			if (result == null)
				result = caseIfcRoot(ifcFlowTreatmentDeviceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FLUID_FLOW_PROPERTIES: {
			IfcFluidFlowProperties ifcFluidFlowProperties = (IfcFluidFlowProperties) theEObject;
			T result = caseIfcFluidFlowProperties(ifcFluidFlowProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcFluidFlowProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcFluidFlowProperties);
			if (result == null)
				result = caseIfcRoot(ifcFluidFlowProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FOOTING: {
			IfcFooting ifcFooting = (IfcFooting) theEObject;
			T result = caseIfcFooting(ifcFooting);
			if (result == null)
				result = caseIfcBuildingElement(ifcFooting);
			if (result == null)
				result = caseIfcElement(ifcFooting);
			if (result == null)
				result = caseIfcProduct(ifcFooting);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFooting);
			if (result == null)
				result = caseIfcObject(ifcFooting);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFooting);
			if (result == null)
				result = caseIfcRoot(ifcFooting);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FUEL_PROPERTIES: {
			IfcFuelProperties ifcFuelProperties = (IfcFuelProperties) theEObject;
			T result = caseIfcFuelProperties(ifcFuelProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcFuelProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FURNISHING_ELEMENT: {
			IfcFurnishingElement ifcFurnishingElement = (IfcFurnishingElement) theEObject;
			T result = caseIfcFurnishingElement(ifcFurnishingElement);
			if (result == null)
				result = caseIfcElement(ifcFurnishingElement);
			if (result == null)
				result = caseIfcProduct(ifcFurnishingElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcFurnishingElement);
			if (result == null)
				result = caseIfcObject(ifcFurnishingElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFurnishingElement);
			if (result == null)
				result = caseIfcRoot(ifcFurnishingElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FURNISHING_ELEMENT_TYPE: {
			IfcFurnishingElementType ifcFurnishingElementType = (IfcFurnishingElementType) theEObject;
			T result = caseIfcFurnishingElementType(ifcFurnishingElementType);
			if (result == null)
				result = caseIfcElementType(ifcFurnishingElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFurnishingElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcFurnishingElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFurnishingElementType);
			if (result == null)
				result = caseIfcRoot(ifcFurnishingElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FURNITURE_STANDARD: {
			IfcFurnitureStandard ifcFurnitureStandard = (IfcFurnitureStandard) theEObject;
			T result = caseIfcFurnitureStandard(ifcFurnitureStandard);
			if (result == null)
				result = caseIfcControl(ifcFurnitureStandard);
			if (result == null)
				result = caseIfcObject(ifcFurnitureStandard);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFurnitureStandard);
			if (result == null)
				result = caseIfcRoot(ifcFurnitureStandard);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FURNITURE_TYPE: {
			IfcFurnitureType ifcFurnitureType = (IfcFurnitureType) theEObject;
			T result = caseIfcFurnitureType(ifcFurnitureType);
			if (result == null)
				result = caseIfcFurnishingElementType(ifcFurnitureType);
			if (result == null)
				result = caseIfcElementType(ifcFurnitureType);
			if (result == null)
				result = caseIfcTypeProduct(ifcFurnitureType);
			if (result == null)
				result = caseIfcTypeObject(ifcFurnitureType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcFurnitureType);
			if (result == null)
				result = caseIfcRoot(ifcFurnitureType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GAS_TERMINAL_TYPE: {
			IfcGasTerminalType ifcGasTerminalType = (IfcGasTerminalType) theEObject;
			T result = caseIfcGasTerminalType(ifcGasTerminalType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcGasTerminalType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcGasTerminalType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcGasTerminalType);
			if (result == null)
				result = caseIfcElementType(ifcGasTerminalType);
			if (result == null)
				result = caseIfcTypeProduct(ifcGasTerminalType);
			if (result == null)
				result = caseIfcTypeObject(ifcGasTerminalType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcGasTerminalType);
			if (result == null)
				result = caseIfcRoot(ifcGasTerminalType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GENERAL_MATERIAL_PROPERTIES: {
			IfcGeneralMaterialProperties ifcGeneralMaterialProperties = (IfcGeneralMaterialProperties) theEObject;
			T result = caseIfcGeneralMaterialProperties(ifcGeneralMaterialProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcGeneralMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GENERAL_PROFILE_PROPERTIES: {
			IfcGeneralProfileProperties ifcGeneralProfileProperties = (IfcGeneralProfileProperties) theEObject;
			T result = caseIfcGeneralProfileProperties(ifcGeneralProfileProperties);
			if (result == null)
				result = caseIfcProfileProperties(ifcGeneralProfileProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GEOMETRIC_CURVE_SET: {
			IfcGeometricCurveSet ifcGeometricCurveSet = (IfcGeometricCurveSet) theEObject;
			T result = caseIfcGeometricCurveSet(ifcGeometricCurveSet);
			if (result == null)
				result = caseIfcGeometricSet(ifcGeometricCurveSet);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcGeometricCurveSet);
			if (result == null)
				result = caseIfcRepresentationItem(ifcGeometricCurveSet);
			if (result == null)
				result = caseIfcLayeredItem(ifcGeometricCurveSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GEOMETRIC_REPRESENTATION_CONTEXT: {
			IfcGeometricRepresentationContext ifcGeometricRepresentationContext = (IfcGeometricRepresentationContext) theEObject;
			T result = caseIfcGeometricRepresentationContext(ifcGeometricRepresentationContext);
			if (result == null)
				result = caseIfcRepresentationContext(ifcGeometricRepresentationContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GEOMETRIC_REPRESENTATION_ITEM: {
			IfcGeometricRepresentationItem ifcGeometricRepresentationItem = (IfcGeometricRepresentationItem) theEObject;
			T result = caseIfcGeometricRepresentationItem(ifcGeometricRepresentationItem);
			if (result == null)
				result = caseIfcRepresentationItem(ifcGeometricRepresentationItem);
			if (result == null)
				result = caseIfcLayeredItem(ifcGeometricRepresentationItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GEOMETRIC_REPRESENTATION_SUB_CONTEXT: {
			IfcGeometricRepresentationSubContext ifcGeometricRepresentationSubContext = (IfcGeometricRepresentationSubContext) theEObject;
			T result = caseIfcGeometricRepresentationSubContext(ifcGeometricRepresentationSubContext);
			if (result == null)
				result = caseIfcGeometricRepresentationContext(ifcGeometricRepresentationSubContext);
			if (result == null)
				result = caseIfcRepresentationContext(ifcGeometricRepresentationSubContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GEOMETRIC_SET: {
			IfcGeometricSet ifcGeometricSet = (IfcGeometricSet) theEObject;
			T result = caseIfcGeometricSet(ifcGeometricSet);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcGeometricSet);
			if (result == null)
				result = caseIfcRepresentationItem(ifcGeometricSet);
			if (result == null)
				result = caseIfcLayeredItem(ifcGeometricSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GRID: {
			IfcGrid ifcGrid = (IfcGrid) theEObject;
			T result = caseIfcGrid(ifcGrid);
			if (result == null)
				result = caseIfcProduct(ifcGrid);
			if (result == null)
				result = caseIfcObject(ifcGrid);
			if (result == null)
				result = caseIfcObjectDefinition(ifcGrid);
			if (result == null)
				result = caseIfcRoot(ifcGrid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GRID_AXIS: {
			IfcGridAxis ifcGridAxis = (IfcGridAxis) theEObject;
			T result = caseIfcGridAxis(ifcGridAxis);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GRID_PLACEMENT: {
			IfcGridPlacement ifcGridPlacement = (IfcGridPlacement) theEObject;
			T result = caseIfcGridPlacement(ifcGridPlacement);
			if (result == null)
				result = caseIfcObjectPlacement(ifcGridPlacement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GROUP: {
			IfcGroup ifcGroup = (IfcGroup) theEObject;
			T result = caseIfcGroup(ifcGroup);
			if (result == null)
				result = caseIfcObject(ifcGroup);
			if (result == null)
				result = caseIfcObjectDefinition(ifcGroup);
			if (result == null)
				result = caseIfcRoot(ifcGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_HALF_SPACE_SOLID: {
			IfcHalfSpaceSolid ifcHalfSpaceSolid = (IfcHalfSpaceSolid) theEObject;
			T result = caseIfcHalfSpaceSolid(ifcHalfSpaceSolid);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcHalfSpaceSolid);
			if (result == null)
				result = caseIfcBooleanOperand(ifcHalfSpaceSolid);
			if (result == null)
				result = caseIfcRepresentationItem(ifcHalfSpaceSolid);
			if (result == null)
				result = caseIfcLayeredItem(ifcHalfSpaceSolid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_HEAT_EXCHANGER_TYPE: {
			IfcHeatExchangerType ifcHeatExchangerType = (IfcHeatExchangerType) theEObject;
			T result = caseIfcHeatExchangerType(ifcHeatExchangerType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcHeatExchangerType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcHeatExchangerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcHeatExchangerType);
			if (result == null)
				result = caseIfcElementType(ifcHeatExchangerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcHeatExchangerType);
			if (result == null)
				result = caseIfcTypeObject(ifcHeatExchangerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcHeatExchangerType);
			if (result == null)
				result = caseIfcRoot(ifcHeatExchangerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_HUMIDIFIER_TYPE: {
			IfcHumidifierType ifcHumidifierType = (IfcHumidifierType) theEObject;
			T result = caseIfcHumidifierType(ifcHumidifierType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcHumidifierType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcHumidifierType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcHumidifierType);
			if (result == null)
				result = caseIfcElementType(ifcHumidifierType);
			if (result == null)
				result = caseIfcTypeProduct(ifcHumidifierType);
			if (result == null)
				result = caseIfcTypeObject(ifcHumidifierType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcHumidifierType);
			if (result == null)
				result = caseIfcRoot(ifcHumidifierType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_HYGROSCOPIC_MATERIAL_PROPERTIES: {
			IfcHygroscopicMaterialProperties ifcHygroscopicMaterialProperties = (IfcHygroscopicMaterialProperties) theEObject;
			T result = caseIfcHygroscopicMaterialProperties(ifcHygroscopicMaterialProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcHygroscopicMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ISHAPE_PROFILE_DEF: {
			IfcIShapeProfileDef ifcIShapeProfileDef = (IfcIShapeProfileDef) theEObject;
			T result = caseIfcIShapeProfileDef(ifcIShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcIShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcIShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_IMAGE_TEXTURE: {
			IfcImageTexture ifcImageTexture = (IfcImageTexture) theEObject;
			T result = caseIfcImageTexture(ifcImageTexture);
			if (result == null)
				result = caseIfcSurfaceTexture(ifcImageTexture);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_INVENTORY: {
			IfcInventory ifcInventory = (IfcInventory) theEObject;
			T result = caseIfcInventory(ifcInventory);
			if (result == null)
				result = caseIfcGroup(ifcInventory);
			if (result == null)
				result = caseIfcObject(ifcInventory);
			if (result == null)
				result = caseIfcObjectDefinition(ifcInventory);
			if (result == null)
				result = caseIfcRoot(ifcInventory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_IRREGULAR_TIME_SERIES: {
			IfcIrregularTimeSeries ifcIrregularTimeSeries = (IfcIrregularTimeSeries) theEObject;
			T result = caseIfcIrregularTimeSeries(ifcIrregularTimeSeries);
			if (result == null)
				result = caseIfcTimeSeries(ifcIrregularTimeSeries);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcIrregularTimeSeries);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcIrregularTimeSeries);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_IRREGULAR_TIME_SERIES_VALUE: {
			IfcIrregularTimeSeriesValue ifcIrregularTimeSeriesValue = (IfcIrregularTimeSeriesValue) theEObject;
			T result = caseIfcIrregularTimeSeriesValue(ifcIrregularTimeSeriesValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_JUNCTION_BOX_TYPE: {
			IfcJunctionBoxType ifcJunctionBoxType = (IfcJunctionBoxType) theEObject;
			T result = caseIfcJunctionBoxType(ifcJunctionBoxType);
			if (result == null)
				result = caseIfcFlowFittingType(ifcJunctionBoxType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcJunctionBoxType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcJunctionBoxType);
			if (result == null)
				result = caseIfcElementType(ifcJunctionBoxType);
			if (result == null)
				result = caseIfcTypeProduct(ifcJunctionBoxType);
			if (result == null)
				result = caseIfcTypeObject(ifcJunctionBoxType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcJunctionBoxType);
			if (result == null)
				result = caseIfcRoot(ifcJunctionBoxType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LSHAPE_PROFILE_DEF: {
			IfcLShapeProfileDef ifcLShapeProfileDef = (IfcLShapeProfileDef) theEObject;
			T result = caseIfcLShapeProfileDef(ifcLShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcLShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcLShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LABOR_RESOURCE: {
			IfcLaborResource ifcLaborResource = (IfcLaborResource) theEObject;
			T result = caseIfcLaborResource(ifcLaborResource);
			if (result == null)
				result = caseIfcConstructionResource(ifcLaborResource);
			if (result == null)
				result = caseIfcResource(ifcLaborResource);
			if (result == null)
				result = caseIfcObject(ifcLaborResource);
			if (result == null)
				result = caseIfcObjectDefinition(ifcLaborResource);
			if (result == null)
				result = caseIfcRoot(ifcLaborResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LAMP_TYPE: {
			IfcLampType ifcLampType = (IfcLampType) theEObject;
			T result = caseIfcLampType(ifcLampType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcLampType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcLampType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcLampType);
			if (result == null)
				result = caseIfcElementType(ifcLampType);
			if (result == null)
				result = caseIfcTypeProduct(ifcLampType);
			if (result == null)
				result = caseIfcTypeObject(ifcLampType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcLampType);
			if (result == null)
				result = caseIfcRoot(ifcLampType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIBRARY_INFORMATION: {
			IfcLibraryInformation ifcLibraryInformation = (IfcLibraryInformation) theEObject;
			T result = caseIfcLibraryInformation(ifcLibraryInformation);
			if (result == null)
				result = caseIfcLibrarySelect(ifcLibraryInformation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIBRARY_REFERENCE: {
			IfcLibraryReference ifcLibraryReference = (IfcLibraryReference) theEObject;
			T result = caseIfcLibraryReference(ifcLibraryReference);
			if (result == null)
				result = caseIfcExternalReference(ifcLibraryReference);
			if (result == null)
				result = caseIfcLibrarySelect(ifcLibraryReference);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcLibraryReference);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcLibraryReference);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_DISTRIBUTION_DATA: {
			IfcLightDistributionData ifcLightDistributionData = (IfcLightDistributionData) theEObject;
			T result = caseIfcLightDistributionData(ifcLightDistributionData);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_FIXTURE_TYPE: {
			IfcLightFixtureType ifcLightFixtureType = (IfcLightFixtureType) theEObject;
			T result = caseIfcLightFixtureType(ifcLightFixtureType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcLightFixtureType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcLightFixtureType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcLightFixtureType);
			if (result == null)
				result = caseIfcElementType(ifcLightFixtureType);
			if (result == null)
				result = caseIfcTypeProduct(ifcLightFixtureType);
			if (result == null)
				result = caseIfcTypeObject(ifcLightFixtureType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcLightFixtureType);
			if (result == null)
				result = caseIfcRoot(ifcLightFixtureType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_INTENSITY_DISTRIBUTION: {
			IfcLightIntensityDistribution ifcLightIntensityDistribution = (IfcLightIntensityDistribution) theEObject;
			T result = caseIfcLightIntensityDistribution(ifcLightIntensityDistribution);
			if (result == null)
				result = caseIfcLightDistributionDataSourceSelect(ifcLightIntensityDistribution);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE: {
			IfcLightSource ifcLightSource = (IfcLightSource) theEObject;
			T result = caseIfcLightSource(ifcLightSource);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcLightSource);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLightSource);
			if (result == null)
				result = caseIfcLayeredItem(ifcLightSource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_AMBIENT: {
			IfcLightSourceAmbient ifcLightSourceAmbient = (IfcLightSourceAmbient) theEObject;
			T result = caseIfcLightSourceAmbient(ifcLightSourceAmbient);
			if (result == null)
				result = caseIfcLightSource(ifcLightSourceAmbient);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcLightSourceAmbient);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLightSourceAmbient);
			if (result == null)
				result = caseIfcLayeredItem(ifcLightSourceAmbient);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_DIRECTIONAL: {
			IfcLightSourceDirectional ifcLightSourceDirectional = (IfcLightSourceDirectional) theEObject;
			T result = caseIfcLightSourceDirectional(ifcLightSourceDirectional);
			if (result == null)
				result = caseIfcLightSource(ifcLightSourceDirectional);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcLightSourceDirectional);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLightSourceDirectional);
			if (result == null)
				result = caseIfcLayeredItem(ifcLightSourceDirectional);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_GONIOMETRIC: {
			IfcLightSourceGoniometric ifcLightSourceGoniometric = (IfcLightSourceGoniometric) theEObject;
			T result = caseIfcLightSourceGoniometric(ifcLightSourceGoniometric);
			if (result == null)
				result = caseIfcLightSource(ifcLightSourceGoniometric);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcLightSourceGoniometric);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLightSourceGoniometric);
			if (result == null)
				result = caseIfcLayeredItem(ifcLightSourceGoniometric);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_POSITIONAL: {
			IfcLightSourcePositional ifcLightSourcePositional = (IfcLightSourcePositional) theEObject;
			T result = caseIfcLightSourcePositional(ifcLightSourcePositional);
			if (result == null)
				result = caseIfcLightSource(ifcLightSourcePositional);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcLightSourcePositional);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLightSourcePositional);
			if (result == null)
				result = caseIfcLayeredItem(ifcLightSourcePositional);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_SOURCE_SPOT: {
			IfcLightSourceSpot ifcLightSourceSpot = (IfcLightSourceSpot) theEObject;
			T result = caseIfcLightSourceSpot(ifcLightSourceSpot);
			if (result == null)
				result = caseIfcLightSourcePositional(ifcLightSourceSpot);
			if (result == null)
				result = caseIfcLightSource(ifcLightSourceSpot);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcLightSourceSpot);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLightSourceSpot);
			if (result == null)
				result = caseIfcLayeredItem(ifcLightSourceSpot);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LINE: {
			IfcLine ifcLine = (IfcLine) theEObject;
			T result = caseIfcLine(ifcLine);
			if (result == null)
				result = caseIfcCurve(ifcLine);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcLine);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcLine);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLine);
			if (result == null)
				result = caseIfcLayeredItem(ifcLine);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LINEAR_DIMENSION: {
			IfcLinearDimension ifcLinearDimension = (IfcLinearDimension) theEObject;
			T result = caseIfcLinearDimension(ifcLinearDimension);
			if (result == null)
				result = caseIfcDimensionCurveDirectedCallout(ifcLinearDimension);
			if (result == null)
				result = caseIfcDraughtingCallout(ifcLinearDimension);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcLinearDimension);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLinearDimension);
			if (result == null)
				result = caseIfcLayeredItem(ifcLinearDimension);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LOCAL_PLACEMENT: {
			IfcLocalPlacement ifcLocalPlacement = (IfcLocalPlacement) theEObject;
			T result = caseIfcLocalPlacement(ifcLocalPlacement);
			if (result == null)
				result = caseIfcObjectPlacement(ifcLocalPlacement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LOCAL_TIME: {
			IfcLocalTime ifcLocalTime = (IfcLocalTime) theEObject;
			T result = caseIfcLocalTime(ifcLocalTime);
			if (result == null)
				result = caseIfcDateTimeSelect(ifcLocalTime);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcLocalTime);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcLocalTime);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LOOP: {
			IfcLoop ifcLoop = (IfcLoop) theEObject;
			T result = caseIfcLoop(ifcLoop);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcLoop);
			if (result == null)
				result = caseIfcRepresentationItem(ifcLoop);
			if (result == null)
				result = caseIfcLayeredItem(ifcLoop);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MANIFOLD_SOLID_BREP: {
			IfcManifoldSolidBrep ifcManifoldSolidBrep = (IfcManifoldSolidBrep) theEObject;
			T result = caseIfcManifoldSolidBrep(ifcManifoldSolidBrep);
			if (result == null)
				result = caseIfcSolidModel(ifcManifoldSolidBrep);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcManifoldSolidBrep);
			if (result == null)
				result = caseIfcBooleanOperand(ifcManifoldSolidBrep);
			if (result == null)
				result = caseIfcRepresentationItem(ifcManifoldSolidBrep);
			if (result == null)
				result = caseIfcLayeredItem(ifcManifoldSolidBrep);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MAPPED_ITEM: {
			IfcMappedItem ifcMappedItem = (IfcMappedItem) theEObject;
			T result = caseIfcMappedItem(ifcMappedItem);
			if (result == null)
				result = caseIfcRepresentationItem(ifcMappedItem);
			if (result == null)
				result = caseIfcLayeredItem(ifcMappedItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL: {
			IfcMaterial ifcMaterial = (IfcMaterial) theEObject;
			T result = caseIfcMaterial(ifcMaterial);
			if (result == null)
				result = caseIfcMaterialSelect(ifcMaterial);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcMaterial);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL_CLASSIFICATION_RELATIONSHIP: {
			IfcMaterialClassificationRelationship ifcMaterialClassificationRelationship = (IfcMaterialClassificationRelationship) theEObject;
			T result = caseIfcMaterialClassificationRelationship(ifcMaterialClassificationRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL_DEFINITION_REPRESENTATION: {
			IfcMaterialDefinitionRepresentation ifcMaterialDefinitionRepresentation = (IfcMaterialDefinitionRepresentation) theEObject;
			T result = caseIfcMaterialDefinitionRepresentation(ifcMaterialDefinitionRepresentation);
			if (result == null)
				result = caseIfcProductRepresentation(ifcMaterialDefinitionRepresentation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL_LAYER: {
			IfcMaterialLayer ifcMaterialLayer = (IfcMaterialLayer) theEObject;
			T result = caseIfcMaterialLayer(ifcMaterialLayer);
			if (result == null)
				result = caseIfcMaterialSelect(ifcMaterialLayer);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcMaterialLayer);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL_LAYER_SET: {
			IfcMaterialLayerSet ifcMaterialLayerSet = (IfcMaterialLayerSet) theEObject;
			T result = caseIfcMaterialLayerSet(ifcMaterialLayerSet);
			if (result == null)
				result = caseIfcMaterialSelect(ifcMaterialLayerSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL_LAYER_SET_USAGE: {
			IfcMaterialLayerSetUsage ifcMaterialLayerSetUsage = (IfcMaterialLayerSetUsage) theEObject;
			T result = caseIfcMaterialLayerSetUsage(ifcMaterialLayerSetUsage);
			if (result == null)
				result = caseIfcMaterialSelect(ifcMaterialLayerSetUsage);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL_LIST: {
			IfcMaterialList ifcMaterialList = (IfcMaterialList) theEObject;
			T result = caseIfcMaterialList(ifcMaterialList);
			if (result == null)
				result = caseIfcMaterialSelect(ifcMaterialList);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcMaterialList);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL_PROPERTIES: {
			IfcMaterialProperties ifcMaterialProperties = (IfcMaterialProperties) theEObject;
			T result = caseIfcMaterialProperties(ifcMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MEASURE_WITH_UNIT: {
			IfcMeasureWithUnit ifcMeasureWithUnit = (IfcMeasureWithUnit) theEObject;
			T result = caseIfcMeasureWithUnit(ifcMeasureWithUnit);
			if (result == null)
				result = caseIfcAppliedValueSelect(ifcMeasureWithUnit);
			if (result == null)
				result = caseIfcConditionCriterionSelect(ifcMeasureWithUnit);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcMeasureWithUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MECHANICAL_CONCRETE_MATERIAL_PROPERTIES: {
			IfcMechanicalConcreteMaterialProperties ifcMechanicalConcreteMaterialProperties = (IfcMechanicalConcreteMaterialProperties) theEObject;
			T result = caseIfcMechanicalConcreteMaterialProperties(ifcMechanicalConcreteMaterialProperties);
			if (result == null)
				result = caseIfcMechanicalMaterialProperties(ifcMechanicalConcreteMaterialProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcMechanicalConcreteMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MECHANICAL_FASTENER: {
			IfcMechanicalFastener ifcMechanicalFastener = (IfcMechanicalFastener) theEObject;
			T result = caseIfcMechanicalFastener(ifcMechanicalFastener);
			if (result == null)
				result = caseIfcFastener(ifcMechanicalFastener);
			if (result == null)
				result = caseIfcElementComponent(ifcMechanicalFastener);
			if (result == null)
				result = caseIfcElement(ifcMechanicalFastener);
			if (result == null)
				result = caseIfcProduct(ifcMechanicalFastener);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcMechanicalFastener);
			if (result == null)
				result = caseIfcObject(ifcMechanicalFastener);
			if (result == null)
				result = caseIfcObjectDefinition(ifcMechanicalFastener);
			if (result == null)
				result = caseIfcRoot(ifcMechanicalFastener);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MECHANICAL_FASTENER_TYPE: {
			IfcMechanicalFastenerType ifcMechanicalFastenerType = (IfcMechanicalFastenerType) theEObject;
			T result = caseIfcMechanicalFastenerType(ifcMechanicalFastenerType);
			if (result == null)
				result = caseIfcFastenerType(ifcMechanicalFastenerType);
			if (result == null)
				result = caseIfcElementComponentType(ifcMechanicalFastenerType);
			if (result == null)
				result = caseIfcElementType(ifcMechanicalFastenerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcMechanicalFastenerType);
			if (result == null)
				result = caseIfcTypeObject(ifcMechanicalFastenerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcMechanicalFastenerType);
			if (result == null)
				result = caseIfcRoot(ifcMechanicalFastenerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MECHANICAL_MATERIAL_PROPERTIES: {
			IfcMechanicalMaterialProperties ifcMechanicalMaterialProperties = (IfcMechanicalMaterialProperties) theEObject;
			T result = caseIfcMechanicalMaterialProperties(ifcMechanicalMaterialProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcMechanicalMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MECHANICAL_STEEL_MATERIAL_PROPERTIES: {
			IfcMechanicalSteelMaterialProperties ifcMechanicalSteelMaterialProperties = (IfcMechanicalSteelMaterialProperties) theEObject;
			T result = caseIfcMechanicalSteelMaterialProperties(ifcMechanicalSteelMaterialProperties);
			if (result == null)
				result = caseIfcMechanicalMaterialProperties(ifcMechanicalSteelMaterialProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcMechanicalSteelMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MEMBER: {
			IfcMember ifcMember = (IfcMember) theEObject;
			T result = caseIfcMember(ifcMember);
			if (result == null)
				result = caseIfcBuildingElement(ifcMember);
			if (result == null)
				result = caseIfcElement(ifcMember);
			if (result == null)
				result = caseIfcProduct(ifcMember);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcMember);
			if (result == null)
				result = caseIfcObject(ifcMember);
			if (result == null)
				result = caseIfcObjectDefinition(ifcMember);
			if (result == null)
				result = caseIfcRoot(ifcMember);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MEMBER_TYPE: {
			IfcMemberType ifcMemberType = (IfcMemberType) theEObject;
			T result = caseIfcMemberType(ifcMemberType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcMemberType);
			if (result == null)
				result = caseIfcElementType(ifcMemberType);
			if (result == null)
				result = caseIfcTypeProduct(ifcMemberType);
			if (result == null)
				result = caseIfcTypeObject(ifcMemberType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcMemberType);
			if (result == null)
				result = caseIfcRoot(ifcMemberType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_METRIC: {
			IfcMetric ifcMetric = (IfcMetric) theEObject;
			T result = caseIfcMetric(ifcMetric);
			if (result == null)
				result = caseIfcConstraint(ifcMetric);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MONETARY_UNIT: {
			IfcMonetaryUnit ifcMonetaryUnit = (IfcMonetaryUnit) theEObject;
			T result = caseIfcMonetaryUnit(ifcMonetaryUnit);
			if (result == null)
				result = caseIfcUnit(ifcMonetaryUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MOTOR_CONNECTION_TYPE: {
			IfcMotorConnectionType ifcMotorConnectionType = (IfcMotorConnectionType) theEObject;
			T result = caseIfcMotorConnectionType(ifcMotorConnectionType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcMotorConnectionType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcMotorConnectionType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcMotorConnectionType);
			if (result == null)
				result = caseIfcElementType(ifcMotorConnectionType);
			if (result == null)
				result = caseIfcTypeProduct(ifcMotorConnectionType);
			if (result == null)
				result = caseIfcTypeObject(ifcMotorConnectionType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcMotorConnectionType);
			if (result == null)
				result = caseIfcRoot(ifcMotorConnectionType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MOVE: {
			IfcMove ifcMove = (IfcMove) theEObject;
			T result = caseIfcMove(ifcMove);
			if (result == null)
				result = caseIfcTask(ifcMove);
			if (result == null)
				result = caseIfcProcess(ifcMove);
			if (result == null)
				result = caseIfcObject(ifcMove);
			if (result == null)
				result = caseIfcObjectDefinition(ifcMove);
			if (result == null)
				result = caseIfcRoot(ifcMove);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_NAMED_UNIT: {
			IfcNamedUnit ifcNamedUnit = (IfcNamedUnit) theEObject;
			T result = caseIfcNamedUnit(ifcNamedUnit);
			if (result == null)
				result = caseIfcUnit(ifcNamedUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OBJECT: {
			IfcObject ifcObject = (IfcObject) theEObject;
			T result = caseIfcObject(ifcObject);
			if (result == null)
				result = caseIfcObjectDefinition(ifcObject);
			if (result == null)
				result = caseIfcRoot(ifcObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OBJECT_DEFINITION: {
			IfcObjectDefinition ifcObjectDefinition = (IfcObjectDefinition) theEObject;
			T result = caseIfcObjectDefinition(ifcObjectDefinition);
			if (result == null)
				result = caseIfcRoot(ifcObjectDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OBJECT_PLACEMENT: {
			IfcObjectPlacement ifcObjectPlacement = (IfcObjectPlacement) theEObject;
			T result = caseIfcObjectPlacement(ifcObjectPlacement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OBJECTIVE: {
			IfcObjective ifcObjective = (IfcObjective) theEObject;
			T result = caseIfcObjective(ifcObjective);
			if (result == null)
				result = caseIfcConstraint(ifcObjective);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OCCUPANT: {
			IfcOccupant ifcOccupant = (IfcOccupant) theEObject;
			T result = caseIfcOccupant(ifcOccupant);
			if (result == null)
				result = caseIfcActor(ifcOccupant);
			if (result == null)
				result = caseIfcObject(ifcOccupant);
			if (result == null)
				result = caseIfcObjectDefinition(ifcOccupant);
			if (result == null)
				result = caseIfcRoot(ifcOccupant);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OFFSET_CURVE2_D: {
			IfcOffsetCurve2D ifcOffsetCurve2D = (IfcOffsetCurve2D) theEObject;
			T result = caseIfcOffsetCurve2D(ifcOffsetCurve2D);
			if (result == null)
				result = caseIfcCurve(ifcOffsetCurve2D);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcOffsetCurve2D);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcOffsetCurve2D);
			if (result == null)
				result = caseIfcRepresentationItem(ifcOffsetCurve2D);
			if (result == null)
				result = caseIfcLayeredItem(ifcOffsetCurve2D);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OFFSET_CURVE3_D: {
			IfcOffsetCurve3D ifcOffsetCurve3D = (IfcOffsetCurve3D) theEObject;
			T result = caseIfcOffsetCurve3D(ifcOffsetCurve3D);
			if (result == null)
				result = caseIfcCurve(ifcOffsetCurve3D);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcOffsetCurve3D);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcOffsetCurve3D);
			if (result == null)
				result = caseIfcRepresentationItem(ifcOffsetCurve3D);
			if (result == null)
				result = caseIfcLayeredItem(ifcOffsetCurve3D);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ONE_DIRECTION_REPEAT_FACTOR: {
			IfcOneDirectionRepeatFactor ifcOneDirectionRepeatFactor = (IfcOneDirectionRepeatFactor) theEObject;
			T result = caseIfcOneDirectionRepeatFactor(ifcOneDirectionRepeatFactor);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcOneDirectionRepeatFactor);
			if (result == null)
				result = caseIfcHatchLineDistanceSelect(ifcOneDirectionRepeatFactor);
			if (result == null)
				result = caseIfcRepresentationItem(ifcOneDirectionRepeatFactor);
			if (result == null)
				result = caseIfcLayeredItem(ifcOneDirectionRepeatFactor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OPEN_SHELL: {
			IfcOpenShell ifcOpenShell = (IfcOpenShell) theEObject;
			T result = caseIfcOpenShell(ifcOpenShell);
			if (result == null)
				result = caseIfcConnectedFaceSet(ifcOpenShell);
			if (result == null)
				result = caseIfcShell(ifcOpenShell);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcOpenShell);
			if (result == null)
				result = caseIfcRepresentationItem(ifcOpenShell);
			if (result == null)
				result = caseIfcLayeredItem(ifcOpenShell);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OPENING_ELEMENT: {
			IfcOpeningElement ifcOpeningElement = (IfcOpeningElement) theEObject;
			T result = caseIfcOpeningElement(ifcOpeningElement);
			if (result == null)
				result = caseIfcFeatureElementSubtraction(ifcOpeningElement);
			if (result == null)
				result = caseIfcFeatureElement(ifcOpeningElement);
			if (result == null)
				result = caseIfcElement(ifcOpeningElement);
			if (result == null)
				result = caseIfcProduct(ifcOpeningElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcOpeningElement);
			if (result == null)
				result = caseIfcObject(ifcOpeningElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcOpeningElement);
			if (result == null)
				result = caseIfcRoot(ifcOpeningElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OPTICAL_MATERIAL_PROPERTIES: {
			IfcOpticalMaterialProperties ifcOpticalMaterialProperties = (IfcOpticalMaterialProperties) theEObject;
			T result = caseIfcOpticalMaterialProperties(ifcOpticalMaterialProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcOpticalMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ORDER_ACTION: {
			IfcOrderAction ifcOrderAction = (IfcOrderAction) theEObject;
			T result = caseIfcOrderAction(ifcOrderAction);
			if (result == null)
				result = caseIfcTask(ifcOrderAction);
			if (result == null)
				result = caseIfcProcess(ifcOrderAction);
			if (result == null)
				result = caseIfcObject(ifcOrderAction);
			if (result == null)
				result = caseIfcObjectDefinition(ifcOrderAction);
			if (result == null)
				result = caseIfcRoot(ifcOrderAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ORGANIZATION: {
			IfcOrganization ifcOrganization = (IfcOrganization) theEObject;
			T result = caseIfcOrganization(ifcOrganization);
			if (result == null)
				result = caseIfcActorSelect(ifcOrganization);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcOrganization);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ORGANIZATION_RELATIONSHIP: {
			IfcOrganizationRelationship ifcOrganizationRelationship = (IfcOrganizationRelationship) theEObject;
			T result = caseIfcOrganizationRelationship(ifcOrganizationRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ORIENTED_EDGE: {
			IfcOrientedEdge ifcOrientedEdge = (IfcOrientedEdge) theEObject;
			T result = caseIfcOrientedEdge(ifcOrientedEdge);
			if (result == null)
				result = caseIfcEdge(ifcOrientedEdge);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcOrientedEdge);
			if (result == null)
				result = caseIfcRepresentationItem(ifcOrientedEdge);
			if (result == null)
				result = caseIfcLayeredItem(ifcOrientedEdge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OUTLET_TYPE: {
			IfcOutletType ifcOutletType = (IfcOutletType) theEObject;
			T result = caseIfcOutletType(ifcOutletType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcOutletType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcOutletType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcOutletType);
			if (result == null)
				result = caseIfcElementType(ifcOutletType);
			if (result == null)
				result = caseIfcTypeProduct(ifcOutletType);
			if (result == null)
				result = caseIfcTypeObject(ifcOutletType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcOutletType);
			if (result == null)
				result = caseIfcRoot(ifcOutletType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OWNER_HISTORY: {
			IfcOwnerHistory ifcOwnerHistory = (IfcOwnerHistory) theEObject;
			T result = caseIfcOwnerHistory(ifcOwnerHistory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PARAMETERIZED_PROFILE_DEF: {
			IfcParameterizedProfileDef ifcParameterizedProfileDef = (IfcParameterizedProfileDef) theEObject;
			T result = caseIfcParameterizedProfileDef(ifcParameterizedProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcParameterizedProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PATH: {
			IfcPath ifcPath = (IfcPath) theEObject;
			T result = caseIfcPath(ifcPath);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcPath);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPath);
			if (result == null)
				result = caseIfcLayeredItem(ifcPath);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PERFORMANCE_HISTORY: {
			IfcPerformanceHistory ifcPerformanceHistory = (IfcPerformanceHistory) theEObject;
			T result = caseIfcPerformanceHistory(ifcPerformanceHistory);
			if (result == null)
				result = caseIfcControl(ifcPerformanceHistory);
			if (result == null)
				result = caseIfcObject(ifcPerformanceHistory);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPerformanceHistory);
			if (result == null)
				result = caseIfcRoot(ifcPerformanceHistory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PERMEABLE_COVERING_PROPERTIES: {
			IfcPermeableCoveringProperties ifcPermeableCoveringProperties = (IfcPermeableCoveringProperties) theEObject;
			T result = caseIfcPermeableCoveringProperties(ifcPermeableCoveringProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcPermeableCoveringProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcPermeableCoveringProperties);
			if (result == null)
				result = caseIfcRoot(ifcPermeableCoveringProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PERMIT: {
			IfcPermit ifcPermit = (IfcPermit) theEObject;
			T result = caseIfcPermit(ifcPermit);
			if (result == null)
				result = caseIfcControl(ifcPermit);
			if (result == null)
				result = caseIfcObject(ifcPermit);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPermit);
			if (result == null)
				result = caseIfcRoot(ifcPermit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PERSON: {
			IfcPerson ifcPerson = (IfcPerson) theEObject;
			T result = caseIfcPerson(ifcPerson);
			if (result == null)
				result = caseIfcActorSelect(ifcPerson);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcPerson);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PERSON_AND_ORGANIZATION: {
			IfcPersonAndOrganization ifcPersonAndOrganization = (IfcPersonAndOrganization) theEObject;
			T result = caseIfcPersonAndOrganization(ifcPersonAndOrganization);
			if (result == null)
				result = caseIfcActorSelect(ifcPersonAndOrganization);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcPersonAndOrganization);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PHYSICAL_COMPLEX_QUANTITY: {
			IfcPhysicalComplexQuantity ifcPhysicalComplexQuantity = (IfcPhysicalComplexQuantity) theEObject;
			T result = caseIfcPhysicalComplexQuantity(ifcPhysicalComplexQuantity);
			if (result == null)
				result = caseIfcPhysicalQuantity(ifcPhysicalComplexQuantity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PHYSICAL_QUANTITY: {
			IfcPhysicalQuantity ifcPhysicalQuantity = (IfcPhysicalQuantity) theEObject;
			T result = caseIfcPhysicalQuantity(ifcPhysicalQuantity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PHYSICAL_SIMPLE_QUANTITY: {
			IfcPhysicalSimpleQuantity ifcPhysicalSimpleQuantity = (IfcPhysicalSimpleQuantity) theEObject;
			T result = caseIfcPhysicalSimpleQuantity(ifcPhysicalSimpleQuantity);
			if (result == null)
				result = caseIfcPhysicalQuantity(ifcPhysicalSimpleQuantity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PILE: {
			IfcPile ifcPile = (IfcPile) theEObject;
			T result = caseIfcPile(ifcPile);
			if (result == null)
				result = caseIfcBuildingElement(ifcPile);
			if (result == null)
				result = caseIfcElement(ifcPile);
			if (result == null)
				result = caseIfcProduct(ifcPile);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcPile);
			if (result == null)
				result = caseIfcObject(ifcPile);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPile);
			if (result == null)
				result = caseIfcRoot(ifcPile);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PIPE_FITTING_TYPE: {
			IfcPipeFittingType ifcPipeFittingType = (IfcPipeFittingType) theEObject;
			T result = caseIfcPipeFittingType(ifcPipeFittingType);
			if (result == null)
				result = caseIfcFlowFittingType(ifcPipeFittingType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcPipeFittingType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcPipeFittingType);
			if (result == null)
				result = caseIfcElementType(ifcPipeFittingType);
			if (result == null)
				result = caseIfcTypeProduct(ifcPipeFittingType);
			if (result == null)
				result = caseIfcTypeObject(ifcPipeFittingType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPipeFittingType);
			if (result == null)
				result = caseIfcRoot(ifcPipeFittingType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PIPE_SEGMENT_TYPE: {
			IfcPipeSegmentType ifcPipeSegmentType = (IfcPipeSegmentType) theEObject;
			T result = caseIfcPipeSegmentType(ifcPipeSegmentType);
			if (result == null)
				result = caseIfcFlowSegmentType(ifcPipeSegmentType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcPipeSegmentType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcPipeSegmentType);
			if (result == null)
				result = caseIfcElementType(ifcPipeSegmentType);
			if (result == null)
				result = caseIfcTypeProduct(ifcPipeSegmentType);
			if (result == null)
				result = caseIfcTypeObject(ifcPipeSegmentType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPipeSegmentType);
			if (result == null)
				result = caseIfcRoot(ifcPipeSegmentType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PIXEL_TEXTURE: {
			IfcPixelTexture ifcPixelTexture = (IfcPixelTexture) theEObject;
			T result = caseIfcPixelTexture(ifcPixelTexture);
			if (result == null)
				result = caseIfcSurfaceTexture(ifcPixelTexture);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PLACEMENT: {
			IfcPlacement ifcPlacement = (IfcPlacement) theEObject;
			T result = caseIfcPlacement(ifcPlacement);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPlacement);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPlacement);
			if (result == null)
				result = caseIfcLayeredItem(ifcPlacement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PLANAR_BOX: {
			IfcPlanarBox ifcPlanarBox = (IfcPlanarBox) theEObject;
			T result = caseIfcPlanarBox(ifcPlanarBox);
			if (result == null)
				result = caseIfcPlanarExtent(ifcPlanarBox);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPlanarBox);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPlanarBox);
			if (result == null)
				result = caseIfcLayeredItem(ifcPlanarBox);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PLANAR_EXTENT: {
			IfcPlanarExtent ifcPlanarExtent = (IfcPlanarExtent) theEObject;
			T result = caseIfcPlanarExtent(ifcPlanarExtent);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPlanarExtent);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPlanarExtent);
			if (result == null)
				result = caseIfcLayeredItem(ifcPlanarExtent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PLANE: {
			IfcPlane ifcPlane = (IfcPlane) theEObject;
			T result = caseIfcPlane(ifcPlane);
			if (result == null)
				result = caseIfcElementarySurface(ifcPlane);
			if (result == null)
				result = caseIfcSurface(ifcPlane);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPlane);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcPlane);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcPlane);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPlane);
			if (result == null)
				result = caseIfcLayeredItem(ifcPlane);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PLATE: {
			IfcPlate ifcPlate = (IfcPlate) theEObject;
			T result = caseIfcPlate(ifcPlate);
			if (result == null)
				result = caseIfcBuildingElement(ifcPlate);
			if (result == null)
				result = caseIfcElement(ifcPlate);
			if (result == null)
				result = caseIfcProduct(ifcPlate);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcPlate);
			if (result == null)
				result = caseIfcObject(ifcPlate);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPlate);
			if (result == null)
				result = caseIfcRoot(ifcPlate);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PLATE_TYPE: {
			IfcPlateType ifcPlateType = (IfcPlateType) theEObject;
			T result = caseIfcPlateType(ifcPlateType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcPlateType);
			if (result == null)
				result = caseIfcElementType(ifcPlateType);
			if (result == null)
				result = caseIfcTypeProduct(ifcPlateType);
			if (result == null)
				result = caseIfcTypeObject(ifcPlateType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPlateType);
			if (result == null)
				result = caseIfcRoot(ifcPlateType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POINT: {
			IfcPoint ifcPoint = (IfcPoint) theEObject;
			T result = caseIfcPoint(ifcPoint);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPoint);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcPoint);
			if (result == null)
				result = caseIfcPointOrVertexPoint(ifcPoint);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPoint);
			if (result == null)
				result = caseIfcLayeredItem(ifcPoint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POINT_ON_CURVE: {
			IfcPointOnCurve ifcPointOnCurve = (IfcPointOnCurve) theEObject;
			T result = caseIfcPointOnCurve(ifcPointOnCurve);
			if (result == null)
				result = caseIfcPoint(ifcPointOnCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPointOnCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcPointOnCurve);
			if (result == null)
				result = caseIfcPointOrVertexPoint(ifcPointOnCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPointOnCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcPointOnCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POINT_ON_SURFACE: {
			IfcPointOnSurface ifcPointOnSurface = (IfcPointOnSurface) theEObject;
			T result = caseIfcPointOnSurface(ifcPointOnSurface);
			if (result == null)
				result = caseIfcPoint(ifcPointOnSurface);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPointOnSurface);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcPointOnSurface);
			if (result == null)
				result = caseIfcPointOrVertexPoint(ifcPointOnSurface);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPointOnSurface);
			if (result == null)
				result = caseIfcLayeredItem(ifcPointOnSurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POLY_LOOP: {
			IfcPolyLoop ifcPolyLoop = (IfcPolyLoop) theEObject;
			T result = caseIfcPolyLoop(ifcPolyLoop);
			if (result == null)
				result = caseIfcLoop(ifcPolyLoop);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcPolyLoop);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPolyLoop);
			if (result == null)
				result = caseIfcLayeredItem(ifcPolyLoop);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POLYGONAL_BOUNDED_HALF_SPACE: {
			IfcPolygonalBoundedHalfSpace ifcPolygonalBoundedHalfSpace = (IfcPolygonalBoundedHalfSpace) theEObject;
			T result = caseIfcPolygonalBoundedHalfSpace(ifcPolygonalBoundedHalfSpace);
			if (result == null)
				result = caseIfcHalfSpaceSolid(ifcPolygonalBoundedHalfSpace);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPolygonalBoundedHalfSpace);
			if (result == null)
				result = caseIfcBooleanOperand(ifcPolygonalBoundedHalfSpace);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPolygonalBoundedHalfSpace);
			if (result == null)
				result = caseIfcLayeredItem(ifcPolygonalBoundedHalfSpace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POLYLINE: {
			IfcPolyline ifcPolyline = (IfcPolyline) theEObject;
			T result = caseIfcPolyline(ifcPolyline);
			if (result == null)
				result = caseIfcBoundedCurve(ifcPolyline);
			if (result == null)
				result = caseIfcCurve(ifcPolyline);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifcPolyline);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcPolyline);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcPolyline);
			if (result == null)
				result = caseIfcRepresentationItem(ifcPolyline);
			if (result == null)
				result = caseIfcLayeredItem(ifcPolyline);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PORT: {
			IfcPort ifcPort = (IfcPort) theEObject;
			T result = caseIfcPort(ifcPort);
			if (result == null)
				result = caseIfcProduct(ifcPort);
			if (result == null)
				result = caseIfcObject(ifcPort);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPort);
			if (result == null)
				result = caseIfcRoot(ifcPort);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POSTAL_ADDRESS: {
			IfcPostalAddress ifcPostalAddress = (IfcPostalAddress) theEObject;
			T result = caseIfcPostalAddress(ifcPostalAddress);
			if (result == null)
				result = caseIfcAddress(ifcPostalAddress);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcPostalAddress);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_COLOUR: {
			IfcPreDefinedColour ifcPreDefinedColour = (IfcPreDefinedColour) theEObject;
			T result = caseIfcPreDefinedColour(ifcPreDefinedColour);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcPreDefinedColour);
			if (result == null)
				result = caseIfcColour(ifcPreDefinedColour);
			if (result == null)
				result = caseIfcFillStyleSelect(ifcPreDefinedColour);
			if (result == null)
				result = caseIfcSymbolStyleSelect(ifcPreDefinedColour);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_CURVE_FONT: {
			IfcPreDefinedCurveFont ifcPreDefinedCurveFont = (IfcPreDefinedCurveFont) theEObject;
			T result = caseIfcPreDefinedCurveFont(ifcPreDefinedCurveFont);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcPreDefinedCurveFont);
			if (result == null)
				result = caseIfcCurveStyleFontSelect(ifcPreDefinedCurveFont);
			if (result == null)
				result = caseIfcCurveFontOrScaledCurveFontSelect(ifcPreDefinedCurveFont);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_DIMENSION_SYMBOL: {
			IfcPreDefinedDimensionSymbol ifcPreDefinedDimensionSymbol = (IfcPreDefinedDimensionSymbol) theEObject;
			T result = caseIfcPreDefinedDimensionSymbol(ifcPreDefinedDimensionSymbol);
			if (result == null)
				result = caseIfcPreDefinedSymbol(ifcPreDefinedDimensionSymbol);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcPreDefinedDimensionSymbol);
			if (result == null)
				result = caseIfcDefinedSymbolSelect(ifcPreDefinedDimensionSymbol);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_ITEM: {
			IfcPreDefinedItem ifcPreDefinedItem = (IfcPreDefinedItem) theEObject;
			T result = caseIfcPreDefinedItem(ifcPreDefinedItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_POINT_MARKER_SYMBOL: {
			IfcPreDefinedPointMarkerSymbol ifcPreDefinedPointMarkerSymbol = (IfcPreDefinedPointMarkerSymbol) theEObject;
			T result = caseIfcPreDefinedPointMarkerSymbol(ifcPreDefinedPointMarkerSymbol);
			if (result == null)
				result = caseIfcPreDefinedSymbol(ifcPreDefinedPointMarkerSymbol);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcPreDefinedPointMarkerSymbol);
			if (result == null)
				result = caseIfcDefinedSymbolSelect(ifcPreDefinedPointMarkerSymbol);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_SYMBOL: {
			IfcPreDefinedSymbol ifcPreDefinedSymbol = (IfcPreDefinedSymbol) theEObject;
			T result = caseIfcPreDefinedSymbol(ifcPreDefinedSymbol);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcPreDefinedSymbol);
			if (result == null)
				result = caseIfcDefinedSymbolSelect(ifcPreDefinedSymbol);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_TERMINATOR_SYMBOL: {
			IfcPreDefinedTerminatorSymbol ifcPreDefinedTerminatorSymbol = (IfcPreDefinedTerminatorSymbol) theEObject;
			T result = caseIfcPreDefinedTerminatorSymbol(ifcPreDefinedTerminatorSymbol);
			if (result == null)
				result = caseIfcPreDefinedSymbol(ifcPreDefinedTerminatorSymbol);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcPreDefinedTerminatorSymbol);
			if (result == null)
				result = caseIfcDefinedSymbolSelect(ifcPreDefinedTerminatorSymbol);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRE_DEFINED_TEXT_FONT: {
			IfcPreDefinedTextFont ifcPreDefinedTextFont = (IfcPreDefinedTextFont) theEObject;
			T result = caseIfcPreDefinedTextFont(ifcPreDefinedTextFont);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcPreDefinedTextFont);
			if (result == null)
				result = caseIfcTextFontSelect(ifcPreDefinedTextFont);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRESENTATION_LAYER_ASSIGNMENT: {
			IfcPresentationLayerAssignment ifcPresentationLayerAssignment = (IfcPresentationLayerAssignment) theEObject;
			T result = caseIfcPresentationLayerAssignment(ifcPresentationLayerAssignment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRESENTATION_LAYER_WITH_STYLE: {
			IfcPresentationLayerWithStyle ifcPresentationLayerWithStyle = (IfcPresentationLayerWithStyle) theEObject;
			T result = caseIfcPresentationLayerWithStyle(ifcPresentationLayerWithStyle);
			if (result == null)
				result = caseIfcPresentationLayerAssignment(ifcPresentationLayerWithStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRESENTATION_STYLE: {
			IfcPresentationStyle ifcPresentationStyle = (IfcPresentationStyle) theEObject;
			T result = caseIfcPresentationStyle(ifcPresentationStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRESENTATION_STYLE_ASSIGNMENT: {
			IfcPresentationStyleAssignment ifcPresentationStyleAssignment = (IfcPresentationStyleAssignment) theEObject;
			T result = caseIfcPresentationStyleAssignment(ifcPresentationStyleAssignment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROCEDURE: {
			IfcProcedure ifcProcedure = (IfcProcedure) theEObject;
			T result = caseIfcProcedure(ifcProcedure);
			if (result == null)
				result = caseIfcProcess(ifcProcedure);
			if (result == null)
				result = caseIfcObject(ifcProcedure);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProcedure);
			if (result == null)
				result = caseIfcRoot(ifcProcedure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROCESS: {
			IfcProcess ifcProcess = (IfcProcess) theEObject;
			T result = caseIfcProcess(ifcProcess);
			if (result == null)
				result = caseIfcObject(ifcProcess);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProcess);
			if (result == null)
				result = caseIfcRoot(ifcProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRODUCT: {
			IfcProduct ifcProduct = (IfcProduct) theEObject;
			T result = caseIfcProduct(ifcProduct);
			if (result == null)
				result = caseIfcObject(ifcProduct);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProduct);
			if (result == null)
				result = caseIfcRoot(ifcProduct);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRODUCT_DEFINITION_SHAPE: {
			IfcProductDefinitionShape ifcProductDefinitionShape = (IfcProductDefinitionShape) theEObject;
			T result = caseIfcProductDefinitionShape(ifcProductDefinitionShape);
			if (result == null)
				result = caseIfcProductRepresentation(ifcProductDefinitionShape);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRODUCT_REPRESENTATION: {
			IfcProductRepresentation ifcProductRepresentation = (IfcProductRepresentation) theEObject;
			T result = caseIfcProductRepresentation(ifcProductRepresentation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRODUCTS_OF_COMBUSTION_PROPERTIES: {
			IfcProductsOfCombustionProperties ifcProductsOfCombustionProperties = (IfcProductsOfCombustionProperties) theEObject;
			T result = caseIfcProductsOfCombustionProperties(ifcProductsOfCombustionProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcProductsOfCombustionProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROFILE_DEF: {
			IfcProfileDef ifcProfileDef = (IfcProfileDef) theEObject;
			T result = caseIfcProfileDef(ifcProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROFILE_PROPERTIES: {
			IfcProfileProperties ifcProfileProperties = (IfcProfileProperties) theEObject;
			T result = caseIfcProfileProperties(ifcProfileProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROJECT: {
			IfcProject ifcProject = (IfcProject) theEObject;
			T result = caseIfcProject(ifcProject);
			if (result == null)
				result = caseIfcObject(ifcProject);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProject);
			if (result == null)
				result = caseIfcRoot(ifcProject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROJECT_ORDER: {
			IfcProjectOrder ifcProjectOrder = (IfcProjectOrder) theEObject;
			T result = caseIfcProjectOrder(ifcProjectOrder);
			if (result == null)
				result = caseIfcControl(ifcProjectOrder);
			if (result == null)
				result = caseIfcObject(ifcProjectOrder);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProjectOrder);
			if (result == null)
				result = caseIfcRoot(ifcProjectOrder);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROJECT_ORDER_RECORD: {
			IfcProjectOrderRecord ifcProjectOrderRecord = (IfcProjectOrderRecord) theEObject;
			T result = caseIfcProjectOrderRecord(ifcProjectOrderRecord);
			if (result == null)
				result = caseIfcControl(ifcProjectOrderRecord);
			if (result == null)
				result = caseIfcObject(ifcProjectOrderRecord);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProjectOrderRecord);
			if (result == null)
				result = caseIfcRoot(ifcProjectOrderRecord);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROJECTION_CURVE: {
			IfcProjectionCurve ifcProjectionCurve = (IfcProjectionCurve) theEObject;
			T result = caseIfcProjectionCurve(ifcProjectionCurve);
			if (result == null)
				result = caseIfcAnnotationCurveOccurrence(ifcProjectionCurve);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcProjectionCurve);
			if (result == null)
				result = caseIfcDraughtingCalloutElement(ifcProjectionCurve);
			if (result == null)
				result = caseIfcStyledItem(ifcProjectionCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcProjectionCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcProjectionCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROJECTION_ELEMENT: {
			IfcProjectionElement ifcProjectionElement = (IfcProjectionElement) theEObject;
			T result = caseIfcProjectionElement(ifcProjectionElement);
			if (result == null)
				result = caseIfcFeatureElementAddition(ifcProjectionElement);
			if (result == null)
				result = caseIfcFeatureElement(ifcProjectionElement);
			if (result == null)
				result = caseIfcElement(ifcProjectionElement);
			if (result == null)
				result = caseIfcProduct(ifcProjectionElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcProjectionElement);
			if (result == null)
				result = caseIfcObject(ifcProjectionElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProjectionElement);
			if (result == null)
				result = caseIfcRoot(ifcProjectionElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY: {
			IfcProperty ifcProperty = (IfcProperty) theEObject;
			T result = caseIfcProperty(ifcProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_BOUNDED_VALUE: {
			IfcPropertyBoundedValue ifcPropertyBoundedValue = (IfcPropertyBoundedValue) theEObject;
			T result = caseIfcPropertyBoundedValue(ifcPropertyBoundedValue);
			if (result == null)
				result = caseIfcSimpleProperty(ifcPropertyBoundedValue);
			if (result == null)
				result = caseIfcProperty(ifcPropertyBoundedValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_CONSTRAINT_RELATIONSHIP: {
			IfcPropertyConstraintRelationship ifcPropertyConstraintRelationship = (IfcPropertyConstraintRelationship) theEObject;
			T result = caseIfcPropertyConstraintRelationship(ifcPropertyConstraintRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_DEFINITION: {
			IfcPropertyDefinition ifcPropertyDefinition = (IfcPropertyDefinition) theEObject;
			T result = caseIfcPropertyDefinition(ifcPropertyDefinition);
			if (result == null)
				result = caseIfcRoot(ifcPropertyDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_DEPENDENCY_RELATIONSHIP: {
			IfcPropertyDependencyRelationship ifcPropertyDependencyRelationship = (IfcPropertyDependencyRelationship) theEObject;
			T result = caseIfcPropertyDependencyRelationship(ifcPropertyDependencyRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_ENUMERATED_VALUE: {
			IfcPropertyEnumeratedValue ifcPropertyEnumeratedValue = (IfcPropertyEnumeratedValue) theEObject;
			T result = caseIfcPropertyEnumeratedValue(ifcPropertyEnumeratedValue);
			if (result == null)
				result = caseIfcSimpleProperty(ifcPropertyEnumeratedValue);
			if (result == null)
				result = caseIfcProperty(ifcPropertyEnumeratedValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_ENUMERATION: {
			IfcPropertyEnumeration ifcPropertyEnumeration = (IfcPropertyEnumeration) theEObject;
			T result = caseIfcPropertyEnumeration(ifcPropertyEnumeration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_LIST_VALUE: {
			IfcPropertyListValue ifcPropertyListValue = (IfcPropertyListValue) theEObject;
			T result = caseIfcPropertyListValue(ifcPropertyListValue);
			if (result == null)
				result = caseIfcSimpleProperty(ifcPropertyListValue);
			if (result == null)
				result = caseIfcProperty(ifcPropertyListValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_REFERENCE_VALUE: {
			IfcPropertyReferenceValue ifcPropertyReferenceValue = (IfcPropertyReferenceValue) theEObject;
			T result = caseIfcPropertyReferenceValue(ifcPropertyReferenceValue);
			if (result == null)
				result = caseIfcSimpleProperty(ifcPropertyReferenceValue);
			if (result == null)
				result = caseIfcProperty(ifcPropertyReferenceValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_SET: {
			IfcPropertySet ifcPropertySet = (IfcPropertySet) theEObject;
			T result = caseIfcPropertySet(ifcPropertySet);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcPropertySet);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcPropertySet);
			if (result == null)
				result = caseIfcRoot(ifcPropertySet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_SET_DEFINITION: {
			IfcPropertySetDefinition ifcPropertySetDefinition = (IfcPropertySetDefinition) theEObject;
			T result = caseIfcPropertySetDefinition(ifcPropertySetDefinition);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcPropertySetDefinition);
			if (result == null)
				result = caseIfcRoot(ifcPropertySetDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_SINGLE_VALUE: {
			IfcPropertySingleValue ifcPropertySingleValue = (IfcPropertySingleValue) theEObject;
			T result = caseIfcPropertySingleValue(ifcPropertySingleValue);
			if (result == null)
				result = caseIfcSimpleProperty(ifcPropertySingleValue);
			if (result == null)
				result = caseIfcProperty(ifcPropertySingleValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROPERTY_TABLE_VALUE: {
			IfcPropertyTableValue ifcPropertyTableValue = (IfcPropertyTableValue) theEObject;
			T result = caseIfcPropertyTableValue(ifcPropertyTableValue);
			if (result == null)
				result = caseIfcSimpleProperty(ifcPropertyTableValue);
			if (result == null)
				result = caseIfcProperty(ifcPropertyTableValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROTECTIVE_DEVICE_TYPE: {
			IfcProtectiveDeviceType ifcProtectiveDeviceType = (IfcProtectiveDeviceType) theEObject;
			T result = caseIfcProtectiveDeviceType(ifcProtectiveDeviceType);
			if (result == null)
				result = caseIfcFlowControllerType(ifcProtectiveDeviceType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcProtectiveDeviceType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcProtectiveDeviceType);
			if (result == null)
				result = caseIfcElementType(ifcProtectiveDeviceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcProtectiveDeviceType);
			if (result == null)
				result = caseIfcTypeObject(ifcProtectiveDeviceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProtectiveDeviceType);
			if (result == null)
				result = caseIfcRoot(ifcProtectiveDeviceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PROXY: {
			IfcProxy ifcProxy = (IfcProxy) theEObject;
			T result = caseIfcProxy(ifcProxy);
			if (result == null)
				result = caseIfcProduct(ifcProxy);
			if (result == null)
				result = caseIfcObject(ifcProxy);
			if (result == null)
				result = caseIfcObjectDefinition(ifcProxy);
			if (result == null)
				result = caseIfcRoot(ifcProxy);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PUMP_TYPE: {
			IfcPumpType ifcPumpType = (IfcPumpType) theEObject;
			T result = caseIfcPumpType(ifcPumpType);
			if (result == null)
				result = caseIfcFlowMovingDeviceType(ifcPumpType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcPumpType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcPumpType);
			if (result == null)
				result = caseIfcElementType(ifcPumpType);
			if (result == null)
				result = caseIfcTypeProduct(ifcPumpType);
			if (result == null)
				result = caseIfcTypeObject(ifcPumpType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcPumpType);
			if (result == null)
				result = caseIfcRoot(ifcPumpType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_QUANTITY_AREA: {
			IfcQuantityArea ifcQuantityArea = (IfcQuantityArea) theEObject;
			T result = caseIfcQuantityArea(ifcQuantityArea);
			if (result == null)
				result = caseIfcPhysicalSimpleQuantity(ifcQuantityArea);
			if (result == null)
				result = caseIfcPhysicalQuantity(ifcQuantityArea);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_QUANTITY_COUNT: {
			IfcQuantityCount ifcQuantityCount = (IfcQuantityCount) theEObject;
			T result = caseIfcQuantityCount(ifcQuantityCount);
			if (result == null)
				result = caseIfcPhysicalSimpleQuantity(ifcQuantityCount);
			if (result == null)
				result = caseIfcPhysicalQuantity(ifcQuantityCount);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_QUANTITY_LENGTH: {
			IfcQuantityLength ifcQuantityLength = (IfcQuantityLength) theEObject;
			T result = caseIfcQuantityLength(ifcQuantityLength);
			if (result == null)
				result = caseIfcPhysicalSimpleQuantity(ifcQuantityLength);
			if (result == null)
				result = caseIfcPhysicalQuantity(ifcQuantityLength);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_QUANTITY_TIME: {
			IfcQuantityTime ifcQuantityTime = (IfcQuantityTime) theEObject;
			T result = caseIfcQuantityTime(ifcQuantityTime);
			if (result == null)
				result = caseIfcPhysicalSimpleQuantity(ifcQuantityTime);
			if (result == null)
				result = caseIfcPhysicalQuantity(ifcQuantityTime);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_QUANTITY_VOLUME: {
			IfcQuantityVolume ifcQuantityVolume = (IfcQuantityVolume) theEObject;
			T result = caseIfcQuantityVolume(ifcQuantityVolume);
			if (result == null)
				result = caseIfcPhysicalSimpleQuantity(ifcQuantityVolume);
			if (result == null)
				result = caseIfcPhysicalQuantity(ifcQuantityVolume);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_QUANTITY_WEIGHT: {
			IfcQuantityWeight ifcQuantityWeight = (IfcQuantityWeight) theEObject;
			T result = caseIfcQuantityWeight(ifcQuantityWeight);
			if (result == null)
				result = caseIfcPhysicalSimpleQuantity(ifcQuantityWeight);
			if (result == null)
				result = caseIfcPhysicalQuantity(ifcQuantityWeight);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RADIUS_DIMENSION: {
			IfcRadiusDimension ifcRadiusDimension = (IfcRadiusDimension) theEObject;
			T result = caseIfcRadiusDimension(ifcRadiusDimension);
			if (result == null)
				result = caseIfcDimensionCurveDirectedCallout(ifcRadiusDimension);
			if (result == null)
				result = caseIfcDraughtingCallout(ifcRadiusDimension);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcRadiusDimension);
			if (result == null)
				result = caseIfcRepresentationItem(ifcRadiusDimension);
			if (result == null)
				result = caseIfcLayeredItem(ifcRadiusDimension);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RAILING: {
			IfcRailing ifcRailing = (IfcRailing) theEObject;
			T result = caseIfcRailing(ifcRailing);
			if (result == null)
				result = caseIfcBuildingElement(ifcRailing);
			if (result == null)
				result = caseIfcElement(ifcRailing);
			if (result == null)
				result = caseIfcProduct(ifcRailing);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcRailing);
			if (result == null)
				result = caseIfcObject(ifcRailing);
			if (result == null)
				result = caseIfcObjectDefinition(ifcRailing);
			if (result == null)
				result = caseIfcRoot(ifcRailing);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RAILING_TYPE: {
			IfcRailingType ifcRailingType = (IfcRailingType) theEObject;
			T result = caseIfcRailingType(ifcRailingType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcRailingType);
			if (result == null)
				result = caseIfcElementType(ifcRailingType);
			if (result == null)
				result = caseIfcTypeProduct(ifcRailingType);
			if (result == null)
				result = caseIfcTypeObject(ifcRailingType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcRailingType);
			if (result == null)
				result = caseIfcRoot(ifcRailingType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RAMP: {
			IfcRamp ifcRamp = (IfcRamp) theEObject;
			T result = caseIfcRamp(ifcRamp);
			if (result == null)
				result = caseIfcBuildingElement(ifcRamp);
			if (result == null)
				result = caseIfcElement(ifcRamp);
			if (result == null)
				result = caseIfcProduct(ifcRamp);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcRamp);
			if (result == null)
				result = caseIfcObject(ifcRamp);
			if (result == null)
				result = caseIfcObjectDefinition(ifcRamp);
			if (result == null)
				result = caseIfcRoot(ifcRamp);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RAMP_FLIGHT: {
			IfcRampFlight ifcRampFlight = (IfcRampFlight) theEObject;
			T result = caseIfcRampFlight(ifcRampFlight);
			if (result == null)
				result = caseIfcBuildingElement(ifcRampFlight);
			if (result == null)
				result = caseIfcElement(ifcRampFlight);
			if (result == null)
				result = caseIfcProduct(ifcRampFlight);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcRampFlight);
			if (result == null)
				result = caseIfcObject(ifcRampFlight);
			if (result == null)
				result = caseIfcObjectDefinition(ifcRampFlight);
			if (result == null)
				result = caseIfcRoot(ifcRampFlight);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RAMP_FLIGHT_TYPE: {
			IfcRampFlightType ifcRampFlightType = (IfcRampFlightType) theEObject;
			T result = caseIfcRampFlightType(ifcRampFlightType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcRampFlightType);
			if (result == null)
				result = caseIfcElementType(ifcRampFlightType);
			if (result == null)
				result = caseIfcTypeProduct(ifcRampFlightType);
			if (result == null)
				result = caseIfcTypeObject(ifcRampFlightType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcRampFlightType);
			if (result == null)
				result = caseIfcRoot(ifcRampFlightType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RATIONAL_BEZIER_CURVE: {
			IfcRationalBezierCurve ifcRationalBezierCurve = (IfcRationalBezierCurve) theEObject;
			T result = caseIfcRationalBezierCurve(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcBezierCurve(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcBSplineCurve(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcBoundedCurve(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcCurve(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcRationalBezierCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcRationalBezierCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RECTANGLE_HOLLOW_PROFILE_DEF: {
			IfcRectangleHollowProfileDef ifcRectangleHollowProfileDef = (IfcRectangleHollowProfileDef) theEObject;
			T result = caseIfcRectangleHollowProfileDef(ifcRectangleHollowProfileDef);
			if (result == null)
				result = caseIfcRectangleProfileDef(ifcRectangleHollowProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcRectangleHollowProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcRectangleHollowProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RECTANGLE_PROFILE_DEF: {
			IfcRectangleProfileDef ifcRectangleProfileDef = (IfcRectangleProfileDef) theEObject;
			T result = caseIfcRectangleProfileDef(ifcRectangleProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcRectangleProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcRectangleProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RECTANGULAR_PYRAMID: {
			IfcRectangularPyramid ifcRectangularPyramid = (IfcRectangularPyramid) theEObject;
			T result = caseIfcRectangularPyramid(ifcRectangularPyramid);
			if (result == null)
				result = caseIfcCsgPrimitive3D(ifcRectangularPyramid);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcRectangularPyramid);
			if (result == null)
				result = caseIfcBooleanOperand(ifcRectangularPyramid);
			if (result == null)
				result = caseIfcCsgSelect(ifcRectangularPyramid);
			if (result == null)
				result = caseIfcRepresentationItem(ifcRectangularPyramid);
			if (result == null)
				result = caseIfcLayeredItem(ifcRectangularPyramid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RECTANGULAR_TRIMMED_SURFACE: {
			IfcRectangularTrimmedSurface ifcRectangularTrimmedSurface = (IfcRectangularTrimmedSurface) theEObject;
			T result = caseIfcRectangularTrimmedSurface(ifcRectangularTrimmedSurface);
			if (result == null)
				result = caseIfcBoundedSurface(ifcRectangularTrimmedSurface);
			if (result == null)
				result = caseIfcSurface(ifcRectangularTrimmedSurface);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcRectangularTrimmedSurface);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcRectangularTrimmedSurface);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcRectangularTrimmedSurface);
			if (result == null)
				result = caseIfcRepresentationItem(ifcRectangularTrimmedSurface);
			if (result == null)
				result = caseIfcLayeredItem(ifcRectangularTrimmedSurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REFERENCES_VALUE_DOCUMENT: {
			IfcReferencesValueDocument ifcReferencesValueDocument = (IfcReferencesValueDocument) theEObject;
			T result = caseIfcReferencesValueDocument(ifcReferencesValueDocument);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REGULAR_TIME_SERIES: {
			IfcRegularTimeSeries ifcRegularTimeSeries = (IfcRegularTimeSeries) theEObject;
			T result = caseIfcRegularTimeSeries(ifcRegularTimeSeries);
			if (result == null)
				result = caseIfcTimeSeries(ifcRegularTimeSeries);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcRegularTimeSeries);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcRegularTimeSeries);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REINFORCEMENT_BAR_PROPERTIES: {
			IfcReinforcementBarProperties ifcReinforcementBarProperties = (IfcReinforcementBarProperties) theEObject;
			T result = caseIfcReinforcementBarProperties(ifcReinforcementBarProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REINFORCEMENT_DEFINITION_PROPERTIES: {
			IfcReinforcementDefinitionProperties ifcReinforcementDefinitionProperties = (IfcReinforcementDefinitionProperties) theEObject;
			T result = caseIfcReinforcementDefinitionProperties(ifcReinforcementDefinitionProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcReinforcementDefinitionProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcReinforcementDefinitionProperties);
			if (result == null)
				result = caseIfcRoot(ifcReinforcementDefinitionProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REINFORCING_BAR: {
			IfcReinforcingBar ifcReinforcingBar = (IfcReinforcingBar) theEObject;
			T result = caseIfcReinforcingBar(ifcReinforcingBar);
			if (result == null)
				result = caseIfcReinforcingElement(ifcReinforcingBar);
			if (result == null)
				result = caseIfcBuildingElementComponent(ifcReinforcingBar);
			if (result == null)
				result = caseIfcBuildingElement(ifcReinforcingBar);
			if (result == null)
				result = caseIfcElement(ifcReinforcingBar);
			if (result == null)
				result = caseIfcProduct(ifcReinforcingBar);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcReinforcingBar);
			if (result == null)
				result = caseIfcObject(ifcReinforcingBar);
			if (result == null)
				result = caseIfcObjectDefinition(ifcReinforcingBar);
			if (result == null)
				result = caseIfcRoot(ifcReinforcingBar);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REINFORCING_ELEMENT: {
			IfcReinforcingElement ifcReinforcingElement = (IfcReinforcingElement) theEObject;
			T result = caseIfcReinforcingElement(ifcReinforcingElement);
			if (result == null)
				result = caseIfcBuildingElementComponent(ifcReinforcingElement);
			if (result == null)
				result = caseIfcBuildingElement(ifcReinforcingElement);
			if (result == null)
				result = caseIfcElement(ifcReinforcingElement);
			if (result == null)
				result = caseIfcProduct(ifcReinforcingElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcReinforcingElement);
			if (result == null)
				result = caseIfcObject(ifcReinforcingElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcReinforcingElement);
			if (result == null)
				result = caseIfcRoot(ifcReinforcingElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REINFORCING_MESH: {
			IfcReinforcingMesh ifcReinforcingMesh = (IfcReinforcingMesh) theEObject;
			T result = caseIfcReinforcingMesh(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcReinforcingElement(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcBuildingElementComponent(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcBuildingElement(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcElement(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcProduct(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcObject(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcObjectDefinition(ifcReinforcingMesh);
			if (result == null)
				result = caseIfcRoot(ifcReinforcingMesh);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_AGGREGATES: {
			IfcRelAggregates ifcRelAggregates = (IfcRelAggregates) theEObject;
			T result = caseIfcRelAggregates(ifcRelAggregates);
			if (result == null)
				result = caseIfcRelDecomposes(ifcRelAggregates);
			if (result == null)
				result = caseIfcRelationship(ifcRelAggregates);
			if (result == null)
				result = caseIfcRoot(ifcRelAggregates);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS: {
			IfcRelAssigns ifcRelAssigns = (IfcRelAssigns) theEObject;
			T result = caseIfcRelAssigns(ifcRelAssigns);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssigns);
			if (result == null)
				result = caseIfcRoot(ifcRelAssigns);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TASKS: {
			IfcRelAssignsTasks ifcRelAssignsTasks = (IfcRelAssignsTasks) theEObject;
			T result = caseIfcRelAssignsTasks(ifcRelAssignsTasks);
			if (result == null)
				result = caseIfcRelAssignsToControl(ifcRelAssignsTasks);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelAssignsTasks);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssignsTasks);
			if (result == null)
				result = caseIfcRoot(ifcRelAssignsTasks);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_ACTOR: {
			IfcRelAssignsToActor ifcRelAssignsToActor = (IfcRelAssignsToActor) theEObject;
			T result = caseIfcRelAssignsToActor(ifcRelAssignsToActor);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelAssignsToActor);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssignsToActor);
			if (result == null)
				result = caseIfcRoot(ifcRelAssignsToActor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_CONTROL: {
			IfcRelAssignsToControl ifcRelAssignsToControl = (IfcRelAssignsToControl) theEObject;
			T result = caseIfcRelAssignsToControl(ifcRelAssignsToControl);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelAssignsToControl);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssignsToControl);
			if (result == null)
				result = caseIfcRoot(ifcRelAssignsToControl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_GROUP: {
			IfcRelAssignsToGroup ifcRelAssignsToGroup = (IfcRelAssignsToGroup) theEObject;
			T result = caseIfcRelAssignsToGroup(ifcRelAssignsToGroup);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelAssignsToGroup);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssignsToGroup);
			if (result == null)
				result = caseIfcRoot(ifcRelAssignsToGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_PROCESS: {
			IfcRelAssignsToProcess ifcRelAssignsToProcess = (IfcRelAssignsToProcess) theEObject;
			T result = caseIfcRelAssignsToProcess(ifcRelAssignsToProcess);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelAssignsToProcess);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssignsToProcess);
			if (result == null)
				result = caseIfcRoot(ifcRelAssignsToProcess);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_PRODUCT: {
			IfcRelAssignsToProduct ifcRelAssignsToProduct = (IfcRelAssignsToProduct) theEObject;
			T result = caseIfcRelAssignsToProduct(ifcRelAssignsToProduct);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelAssignsToProduct);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssignsToProduct);
			if (result == null)
				result = caseIfcRoot(ifcRelAssignsToProduct);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_PROJECT_ORDER: {
			IfcRelAssignsToProjectOrder ifcRelAssignsToProjectOrder = (IfcRelAssignsToProjectOrder) theEObject;
			T result = caseIfcRelAssignsToProjectOrder(ifcRelAssignsToProjectOrder);
			if (result == null)
				result = caseIfcRelAssignsToControl(ifcRelAssignsToProjectOrder);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelAssignsToProjectOrder);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssignsToProjectOrder);
			if (result == null)
				result = caseIfcRoot(ifcRelAssignsToProjectOrder);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSIGNS_TO_RESOURCE: {
			IfcRelAssignsToResource ifcRelAssignsToResource = (IfcRelAssignsToResource) theEObject;
			T result = caseIfcRelAssignsToResource(ifcRelAssignsToResource);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelAssignsToResource);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssignsToResource);
			if (result == null)
				result = caseIfcRoot(ifcRelAssignsToResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES: {
			IfcRelAssociates ifcRelAssociates = (IfcRelAssociates) theEObject;
			T result = caseIfcRelAssociates(ifcRelAssociates);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociates);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociates);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_APPLIED_VALUE: {
			IfcRelAssociatesAppliedValue ifcRelAssociatesAppliedValue = (IfcRelAssociatesAppliedValue) theEObject;
			T result = caseIfcRelAssociatesAppliedValue(ifcRelAssociatesAppliedValue);
			if (result == null)
				result = caseIfcRelAssociates(ifcRelAssociatesAppliedValue);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociatesAppliedValue);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociatesAppliedValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_APPROVAL: {
			IfcRelAssociatesApproval ifcRelAssociatesApproval = (IfcRelAssociatesApproval) theEObject;
			T result = caseIfcRelAssociatesApproval(ifcRelAssociatesApproval);
			if (result == null)
				result = caseIfcRelAssociates(ifcRelAssociatesApproval);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociatesApproval);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociatesApproval);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_CLASSIFICATION: {
			IfcRelAssociatesClassification ifcRelAssociatesClassification = (IfcRelAssociatesClassification) theEObject;
			T result = caseIfcRelAssociatesClassification(ifcRelAssociatesClassification);
			if (result == null)
				result = caseIfcRelAssociates(ifcRelAssociatesClassification);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociatesClassification);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociatesClassification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_CONSTRAINT: {
			IfcRelAssociatesConstraint ifcRelAssociatesConstraint = (IfcRelAssociatesConstraint) theEObject;
			T result = caseIfcRelAssociatesConstraint(ifcRelAssociatesConstraint);
			if (result == null)
				result = caseIfcRelAssociates(ifcRelAssociatesConstraint);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociatesConstraint);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociatesConstraint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_DOCUMENT: {
			IfcRelAssociatesDocument ifcRelAssociatesDocument = (IfcRelAssociatesDocument) theEObject;
			T result = caseIfcRelAssociatesDocument(ifcRelAssociatesDocument);
			if (result == null)
				result = caseIfcRelAssociates(ifcRelAssociatesDocument);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociatesDocument);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociatesDocument);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_LIBRARY: {
			IfcRelAssociatesLibrary ifcRelAssociatesLibrary = (IfcRelAssociatesLibrary) theEObject;
			T result = caseIfcRelAssociatesLibrary(ifcRelAssociatesLibrary);
			if (result == null)
				result = caseIfcRelAssociates(ifcRelAssociatesLibrary);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociatesLibrary);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociatesLibrary);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_MATERIAL: {
			IfcRelAssociatesMaterial ifcRelAssociatesMaterial = (IfcRelAssociatesMaterial) theEObject;
			T result = caseIfcRelAssociatesMaterial(ifcRelAssociatesMaterial);
			if (result == null)
				result = caseIfcRelAssociates(ifcRelAssociatesMaterial);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociatesMaterial);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociatesMaterial);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_ASSOCIATES_PROFILE_PROPERTIES: {
			IfcRelAssociatesProfileProperties ifcRelAssociatesProfileProperties = (IfcRelAssociatesProfileProperties) theEObject;
			T result = caseIfcRelAssociatesProfileProperties(ifcRelAssociatesProfileProperties);
			if (result == null)
				result = caseIfcRelAssociates(ifcRelAssociatesProfileProperties);
			if (result == null)
				result = caseIfcRelationship(ifcRelAssociatesProfileProperties);
			if (result == null)
				result = caseIfcRoot(ifcRelAssociatesProfileProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS: {
			IfcRelConnects ifcRelConnects = (IfcRelConnects) theEObject;
			T result = caseIfcRelConnects(ifcRelConnects);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnects);
			if (result == null)
				result = caseIfcRoot(ifcRelConnects);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_ELEMENTS: {
			IfcRelConnectsElements ifcRelConnectsElements = (IfcRelConnectsElements) theEObject;
			T result = caseIfcRelConnectsElements(ifcRelConnectsElements);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsElements);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsElements);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsElements);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_PATH_ELEMENTS: {
			IfcRelConnectsPathElements ifcRelConnectsPathElements = (IfcRelConnectsPathElements) theEObject;
			T result = caseIfcRelConnectsPathElements(ifcRelConnectsPathElements);
			if (result == null)
				result = caseIfcRelConnectsElements(ifcRelConnectsPathElements);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsPathElements);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsPathElements);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsPathElements);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_PORT_TO_ELEMENT: {
			IfcRelConnectsPortToElement ifcRelConnectsPortToElement = (IfcRelConnectsPortToElement) theEObject;
			T result = caseIfcRelConnectsPortToElement(ifcRelConnectsPortToElement);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsPortToElement);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsPortToElement);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsPortToElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_PORTS: {
			IfcRelConnectsPorts ifcRelConnectsPorts = (IfcRelConnectsPorts) theEObject;
			T result = caseIfcRelConnectsPorts(ifcRelConnectsPorts);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsPorts);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsPorts);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsPorts);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_STRUCTURAL_ACTIVITY: {
			IfcRelConnectsStructuralActivity ifcRelConnectsStructuralActivity = (IfcRelConnectsStructuralActivity) theEObject;
			T result = caseIfcRelConnectsStructuralActivity(ifcRelConnectsStructuralActivity);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsStructuralActivity);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsStructuralActivity);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsStructuralActivity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_STRUCTURAL_ELEMENT: {
			IfcRelConnectsStructuralElement ifcRelConnectsStructuralElement = (IfcRelConnectsStructuralElement) theEObject;
			T result = caseIfcRelConnectsStructuralElement(ifcRelConnectsStructuralElement);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsStructuralElement);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsStructuralElement);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsStructuralElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_STRUCTURAL_MEMBER: {
			IfcRelConnectsStructuralMember ifcRelConnectsStructuralMember = (IfcRelConnectsStructuralMember) theEObject;
			T result = caseIfcRelConnectsStructuralMember(ifcRelConnectsStructuralMember);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsStructuralMember);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsStructuralMember);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsStructuralMember);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_WITH_ECCENTRICITY: {
			IfcRelConnectsWithEccentricity ifcRelConnectsWithEccentricity = (IfcRelConnectsWithEccentricity) theEObject;
			T result = caseIfcRelConnectsWithEccentricity(ifcRelConnectsWithEccentricity);
			if (result == null)
				result = caseIfcRelConnectsStructuralMember(ifcRelConnectsWithEccentricity);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsWithEccentricity);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsWithEccentricity);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsWithEccentricity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONNECTS_WITH_REALIZING_ELEMENTS: {
			IfcRelConnectsWithRealizingElements ifcRelConnectsWithRealizingElements = (IfcRelConnectsWithRealizingElements) theEObject;
			T result = caseIfcRelConnectsWithRealizingElements(ifcRelConnectsWithRealizingElements);
			if (result == null)
				result = caseIfcRelConnectsElements(ifcRelConnectsWithRealizingElements);
			if (result == null)
				result = caseIfcRelConnects(ifcRelConnectsWithRealizingElements);
			if (result == null)
				result = caseIfcRelationship(ifcRelConnectsWithRealizingElements);
			if (result == null)
				result = caseIfcRoot(ifcRelConnectsWithRealizingElements);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_CONTAINED_IN_SPATIAL_STRUCTURE: {
			IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure = (IfcRelContainedInSpatialStructure) theEObject;
			T result = caseIfcRelContainedInSpatialStructure(ifcRelContainedInSpatialStructure);
			if (result == null)
				result = caseIfcRelConnects(ifcRelContainedInSpatialStructure);
			if (result == null)
				result = caseIfcRelationship(ifcRelContainedInSpatialStructure);
			if (result == null)
				result = caseIfcRoot(ifcRelContainedInSpatialStructure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_COVERS_BLDG_ELEMENTS: {
			IfcRelCoversBldgElements ifcRelCoversBldgElements = (IfcRelCoversBldgElements) theEObject;
			T result = caseIfcRelCoversBldgElements(ifcRelCoversBldgElements);
			if (result == null)
				result = caseIfcRelConnects(ifcRelCoversBldgElements);
			if (result == null)
				result = caseIfcRelationship(ifcRelCoversBldgElements);
			if (result == null)
				result = caseIfcRoot(ifcRelCoversBldgElements);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_COVERS_SPACES: {
			IfcRelCoversSpaces ifcRelCoversSpaces = (IfcRelCoversSpaces) theEObject;
			T result = caseIfcRelCoversSpaces(ifcRelCoversSpaces);
			if (result == null)
				result = caseIfcRelConnects(ifcRelCoversSpaces);
			if (result == null)
				result = caseIfcRelationship(ifcRelCoversSpaces);
			if (result == null)
				result = caseIfcRoot(ifcRelCoversSpaces);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_DECOMPOSES: {
			IfcRelDecomposes ifcRelDecomposes = (IfcRelDecomposes) theEObject;
			T result = caseIfcRelDecomposes(ifcRelDecomposes);
			if (result == null)
				result = caseIfcRelationship(ifcRelDecomposes);
			if (result == null)
				result = caseIfcRoot(ifcRelDecomposes);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_DEFINES: {
			IfcRelDefines ifcRelDefines = (IfcRelDefines) theEObject;
			T result = caseIfcRelDefines(ifcRelDefines);
			if (result == null)
				result = caseIfcRelationship(ifcRelDefines);
			if (result == null)
				result = caseIfcRoot(ifcRelDefines);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_DEFINES_BY_PROPERTIES: {
			IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) theEObject;
			T result = caseIfcRelDefinesByProperties(ifcRelDefinesByProperties);
			if (result == null)
				result = caseIfcRelDefines(ifcRelDefinesByProperties);
			if (result == null)
				result = caseIfcRelationship(ifcRelDefinesByProperties);
			if (result == null)
				result = caseIfcRoot(ifcRelDefinesByProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_DEFINES_BY_TYPE: {
			IfcRelDefinesByType ifcRelDefinesByType = (IfcRelDefinesByType) theEObject;
			T result = caseIfcRelDefinesByType(ifcRelDefinesByType);
			if (result == null)
				result = caseIfcRelDefines(ifcRelDefinesByType);
			if (result == null)
				result = caseIfcRelationship(ifcRelDefinesByType);
			if (result == null)
				result = caseIfcRoot(ifcRelDefinesByType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_FILLS_ELEMENT: {
			IfcRelFillsElement ifcRelFillsElement = (IfcRelFillsElement) theEObject;
			T result = caseIfcRelFillsElement(ifcRelFillsElement);
			if (result == null)
				result = caseIfcRelConnects(ifcRelFillsElement);
			if (result == null)
				result = caseIfcRelationship(ifcRelFillsElement);
			if (result == null)
				result = caseIfcRoot(ifcRelFillsElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_FLOW_CONTROL_ELEMENTS: {
			IfcRelFlowControlElements ifcRelFlowControlElements = (IfcRelFlowControlElements) theEObject;
			T result = caseIfcRelFlowControlElements(ifcRelFlowControlElements);
			if (result == null)
				result = caseIfcRelConnects(ifcRelFlowControlElements);
			if (result == null)
				result = caseIfcRelationship(ifcRelFlowControlElements);
			if (result == null)
				result = caseIfcRoot(ifcRelFlowControlElements);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_INTERACTION_REQUIREMENTS: {
			IfcRelInteractionRequirements ifcRelInteractionRequirements = (IfcRelInteractionRequirements) theEObject;
			T result = caseIfcRelInteractionRequirements(ifcRelInteractionRequirements);
			if (result == null)
				result = caseIfcRelConnects(ifcRelInteractionRequirements);
			if (result == null)
				result = caseIfcRelationship(ifcRelInteractionRequirements);
			if (result == null)
				result = caseIfcRoot(ifcRelInteractionRequirements);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_NESTS: {
			IfcRelNests ifcRelNests = (IfcRelNests) theEObject;
			T result = caseIfcRelNests(ifcRelNests);
			if (result == null)
				result = caseIfcRelDecomposes(ifcRelNests);
			if (result == null)
				result = caseIfcRelationship(ifcRelNests);
			if (result == null)
				result = caseIfcRoot(ifcRelNests);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_OCCUPIES_SPACES: {
			IfcRelOccupiesSpaces ifcRelOccupiesSpaces = (IfcRelOccupiesSpaces) theEObject;
			T result = caseIfcRelOccupiesSpaces(ifcRelOccupiesSpaces);
			if (result == null)
				result = caseIfcRelAssignsToActor(ifcRelOccupiesSpaces);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelOccupiesSpaces);
			if (result == null)
				result = caseIfcRelationship(ifcRelOccupiesSpaces);
			if (result == null)
				result = caseIfcRoot(ifcRelOccupiesSpaces);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_OVERRIDES_PROPERTIES: {
			IfcRelOverridesProperties ifcRelOverridesProperties = (IfcRelOverridesProperties) theEObject;
			T result = caseIfcRelOverridesProperties(ifcRelOverridesProperties);
			if (result == null)
				result = caseIfcRelDefinesByProperties(ifcRelOverridesProperties);
			if (result == null)
				result = caseIfcRelDefines(ifcRelOverridesProperties);
			if (result == null)
				result = caseIfcRelationship(ifcRelOverridesProperties);
			if (result == null)
				result = caseIfcRoot(ifcRelOverridesProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_PROJECTS_ELEMENT: {
			IfcRelProjectsElement ifcRelProjectsElement = (IfcRelProjectsElement) theEObject;
			T result = caseIfcRelProjectsElement(ifcRelProjectsElement);
			if (result == null)
				result = caseIfcRelConnects(ifcRelProjectsElement);
			if (result == null)
				result = caseIfcRelationship(ifcRelProjectsElement);
			if (result == null)
				result = caseIfcRoot(ifcRelProjectsElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_REFERENCED_IN_SPATIAL_STRUCTURE: {
			IfcRelReferencedInSpatialStructure ifcRelReferencedInSpatialStructure = (IfcRelReferencedInSpatialStructure) theEObject;
			T result = caseIfcRelReferencedInSpatialStructure(ifcRelReferencedInSpatialStructure);
			if (result == null)
				result = caseIfcRelConnects(ifcRelReferencedInSpatialStructure);
			if (result == null)
				result = caseIfcRelationship(ifcRelReferencedInSpatialStructure);
			if (result == null)
				result = caseIfcRoot(ifcRelReferencedInSpatialStructure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_SCHEDULES_COST_ITEMS: {
			IfcRelSchedulesCostItems ifcRelSchedulesCostItems = (IfcRelSchedulesCostItems) theEObject;
			T result = caseIfcRelSchedulesCostItems(ifcRelSchedulesCostItems);
			if (result == null)
				result = caseIfcRelAssignsToControl(ifcRelSchedulesCostItems);
			if (result == null)
				result = caseIfcRelAssigns(ifcRelSchedulesCostItems);
			if (result == null)
				result = caseIfcRelationship(ifcRelSchedulesCostItems);
			if (result == null)
				result = caseIfcRoot(ifcRelSchedulesCostItems);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_SEQUENCE: {
			IfcRelSequence ifcRelSequence = (IfcRelSequence) theEObject;
			T result = caseIfcRelSequence(ifcRelSequence);
			if (result == null)
				result = caseIfcRelConnects(ifcRelSequence);
			if (result == null)
				result = caseIfcRelationship(ifcRelSequence);
			if (result == null)
				result = caseIfcRoot(ifcRelSequence);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_SERVICES_BUILDINGS: {
			IfcRelServicesBuildings ifcRelServicesBuildings = (IfcRelServicesBuildings) theEObject;
			T result = caseIfcRelServicesBuildings(ifcRelServicesBuildings);
			if (result == null)
				result = caseIfcRelConnects(ifcRelServicesBuildings);
			if (result == null)
				result = caseIfcRelationship(ifcRelServicesBuildings);
			if (result == null)
				result = caseIfcRoot(ifcRelServicesBuildings);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_SPACE_BOUNDARY: {
			IfcRelSpaceBoundary ifcRelSpaceBoundary = (IfcRelSpaceBoundary) theEObject;
			T result = caseIfcRelSpaceBoundary(ifcRelSpaceBoundary);
			if (result == null)
				result = caseIfcRelConnects(ifcRelSpaceBoundary);
			if (result == null)
				result = caseIfcRelationship(ifcRelSpaceBoundary);
			if (result == null)
				result = caseIfcRoot(ifcRelSpaceBoundary);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REL_VOIDS_ELEMENT: {
			IfcRelVoidsElement ifcRelVoidsElement = (IfcRelVoidsElement) theEObject;
			T result = caseIfcRelVoidsElement(ifcRelVoidsElement);
			if (result == null)
				result = caseIfcRelConnects(ifcRelVoidsElement);
			if (result == null)
				result = caseIfcRelationship(ifcRelVoidsElement);
			if (result == null)
				result = caseIfcRoot(ifcRelVoidsElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RELATIONSHIP: {
			IfcRelationship ifcRelationship = (IfcRelationship) theEObject;
			T result = caseIfcRelationship(ifcRelationship);
			if (result == null)
				result = caseIfcRoot(ifcRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RELAXATION: {
			IfcRelaxation ifcRelaxation = (IfcRelaxation) theEObject;
			T result = caseIfcRelaxation(ifcRelaxation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REPRESENTATION: {
			IfcRepresentation ifcRepresentation = (IfcRepresentation) theEObject;
			T result = caseIfcRepresentation(ifcRepresentation);
			if (result == null)
				result = caseIfcLayeredItem(ifcRepresentation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REPRESENTATION_CONTEXT: {
			IfcRepresentationContext ifcRepresentationContext = (IfcRepresentationContext) theEObject;
			T result = caseIfcRepresentationContext(ifcRepresentationContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REPRESENTATION_ITEM: {
			IfcRepresentationItem ifcRepresentationItem = (IfcRepresentationItem) theEObject;
			T result = caseIfcRepresentationItem(ifcRepresentationItem);
			if (result == null)
				result = caseIfcLayeredItem(ifcRepresentationItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REPRESENTATION_MAP: {
			IfcRepresentationMap ifcRepresentationMap = (IfcRepresentationMap) theEObject;
			T result = caseIfcRepresentationMap(ifcRepresentationMap);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RESOURCE: {
			IfcResource ifcResource = (IfcResource) theEObject;
			T result = caseIfcResource(ifcResource);
			if (result == null)
				result = caseIfcObject(ifcResource);
			if (result == null)
				result = caseIfcObjectDefinition(ifcResource);
			if (result == null)
				result = caseIfcRoot(ifcResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REVOLVED_AREA_SOLID: {
			IfcRevolvedAreaSolid ifcRevolvedAreaSolid = (IfcRevolvedAreaSolid) theEObject;
			T result = caseIfcRevolvedAreaSolid(ifcRevolvedAreaSolid);
			if (result == null)
				result = caseIfcSweptAreaSolid(ifcRevolvedAreaSolid);
			if (result == null)
				result = caseIfcSolidModel(ifcRevolvedAreaSolid);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcRevolvedAreaSolid);
			if (result == null)
				result = caseIfcBooleanOperand(ifcRevolvedAreaSolid);
			if (result == null)
				result = caseIfcRepresentationItem(ifcRevolvedAreaSolid);
			if (result == null)
				result = caseIfcLayeredItem(ifcRevolvedAreaSolid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RIB_PLATE_PROFILE_PROPERTIES: {
			IfcRibPlateProfileProperties ifcRibPlateProfileProperties = (IfcRibPlateProfileProperties) theEObject;
			T result = caseIfcRibPlateProfileProperties(ifcRibPlateProfileProperties);
			if (result == null)
				result = caseIfcProfileProperties(ifcRibPlateProfileProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RIGHT_CIRCULAR_CONE: {
			IfcRightCircularCone ifcRightCircularCone = (IfcRightCircularCone) theEObject;
			T result = caseIfcRightCircularCone(ifcRightCircularCone);
			if (result == null)
				result = caseIfcCsgPrimitive3D(ifcRightCircularCone);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcRightCircularCone);
			if (result == null)
				result = caseIfcBooleanOperand(ifcRightCircularCone);
			if (result == null)
				result = caseIfcCsgSelect(ifcRightCircularCone);
			if (result == null)
				result = caseIfcRepresentationItem(ifcRightCircularCone);
			if (result == null)
				result = caseIfcLayeredItem(ifcRightCircularCone);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RIGHT_CIRCULAR_CYLINDER: {
			IfcRightCircularCylinder ifcRightCircularCylinder = (IfcRightCircularCylinder) theEObject;
			T result = caseIfcRightCircularCylinder(ifcRightCircularCylinder);
			if (result == null)
				result = caseIfcCsgPrimitive3D(ifcRightCircularCylinder);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcRightCircularCylinder);
			if (result == null)
				result = caseIfcBooleanOperand(ifcRightCircularCylinder);
			if (result == null)
				result = caseIfcCsgSelect(ifcRightCircularCylinder);
			if (result == null)
				result = caseIfcRepresentationItem(ifcRightCircularCylinder);
			if (result == null)
				result = caseIfcLayeredItem(ifcRightCircularCylinder);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ROOF: {
			IfcRoof ifcRoof = (IfcRoof) theEObject;
			T result = caseIfcRoof(ifcRoof);
			if (result == null)
				result = caseIfcBuildingElement(ifcRoof);
			if (result == null)
				result = caseIfcElement(ifcRoof);
			if (result == null)
				result = caseIfcProduct(ifcRoof);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcRoof);
			if (result == null)
				result = caseIfcObject(ifcRoof);
			if (result == null)
				result = caseIfcObjectDefinition(ifcRoof);
			if (result == null)
				result = caseIfcRoot(ifcRoof);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ROOT: {
			IfcRoot ifcRoot = (IfcRoot) theEObject;
			T result = caseIfcRoot(ifcRoot);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ROUNDED_EDGE_FEATURE: {
			IfcRoundedEdgeFeature ifcRoundedEdgeFeature = (IfcRoundedEdgeFeature) theEObject;
			T result = caseIfcRoundedEdgeFeature(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcEdgeFeature(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcFeatureElementSubtraction(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcFeatureElement(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcElement(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcProduct(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcObject(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcObjectDefinition(ifcRoundedEdgeFeature);
			if (result == null)
				result = caseIfcRoot(ifcRoundedEdgeFeature);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ROUNDED_RECTANGLE_PROFILE_DEF: {
			IfcRoundedRectangleProfileDef ifcRoundedRectangleProfileDef = (IfcRoundedRectangleProfileDef) theEObject;
			T result = caseIfcRoundedRectangleProfileDef(ifcRoundedRectangleProfileDef);
			if (result == null)
				result = caseIfcRectangleProfileDef(ifcRoundedRectangleProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcRoundedRectangleProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcRoundedRectangleProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SI_UNIT: {
			IfcSIUnit ifcSIUnit = (IfcSIUnit) theEObject;
			T result = caseIfcSIUnit(ifcSIUnit);
			if (result == null)
				result = caseIfcNamedUnit(ifcSIUnit);
			if (result == null)
				result = caseIfcUnit(ifcSIUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SANITARY_TERMINAL_TYPE: {
			IfcSanitaryTerminalType ifcSanitaryTerminalType = (IfcSanitaryTerminalType) theEObject;
			T result = caseIfcSanitaryTerminalType(ifcSanitaryTerminalType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcSanitaryTerminalType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcSanitaryTerminalType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcSanitaryTerminalType);
			if (result == null)
				result = caseIfcElementType(ifcSanitaryTerminalType);
			if (result == null)
				result = caseIfcTypeProduct(ifcSanitaryTerminalType);
			if (result == null)
				result = caseIfcTypeObject(ifcSanitaryTerminalType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSanitaryTerminalType);
			if (result == null)
				result = caseIfcRoot(ifcSanitaryTerminalType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SCHEDULE_TIME_CONTROL: {
			IfcScheduleTimeControl ifcScheduleTimeControl = (IfcScheduleTimeControl) theEObject;
			T result = caseIfcScheduleTimeControl(ifcScheduleTimeControl);
			if (result == null)
				result = caseIfcControl(ifcScheduleTimeControl);
			if (result == null)
				result = caseIfcObject(ifcScheduleTimeControl);
			if (result == null)
				result = caseIfcObjectDefinition(ifcScheduleTimeControl);
			if (result == null)
				result = caseIfcRoot(ifcScheduleTimeControl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SECTION_PROPERTIES: {
			IfcSectionProperties ifcSectionProperties = (IfcSectionProperties) theEObject;
			T result = caseIfcSectionProperties(ifcSectionProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SECTION_REINFORCEMENT_PROPERTIES: {
			IfcSectionReinforcementProperties ifcSectionReinforcementProperties = (IfcSectionReinforcementProperties) theEObject;
			T result = caseIfcSectionReinforcementProperties(ifcSectionReinforcementProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SECTIONED_SPINE: {
			IfcSectionedSpine ifcSectionedSpine = (IfcSectionedSpine) theEObject;
			T result = caseIfcSectionedSpine(ifcSectionedSpine);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSectionedSpine);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSectionedSpine);
			if (result == null)
				result = caseIfcLayeredItem(ifcSectionedSpine);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SENSOR_TYPE: {
			IfcSensorType ifcSensorType = (IfcSensorType) theEObject;
			T result = caseIfcSensorType(ifcSensorType);
			if (result == null)
				result = caseIfcDistributionControlElementType(ifcSensorType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcSensorType);
			if (result == null)
				result = caseIfcElementType(ifcSensorType);
			if (result == null)
				result = caseIfcTypeProduct(ifcSensorType);
			if (result == null)
				result = caseIfcTypeObject(ifcSensorType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSensorType);
			if (result == null)
				result = caseIfcRoot(ifcSensorType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SERVICE_LIFE: {
			IfcServiceLife ifcServiceLife = (IfcServiceLife) theEObject;
			T result = caseIfcServiceLife(ifcServiceLife);
			if (result == null)
				result = caseIfcControl(ifcServiceLife);
			if (result == null)
				result = caseIfcObject(ifcServiceLife);
			if (result == null)
				result = caseIfcObjectDefinition(ifcServiceLife);
			if (result == null)
				result = caseIfcRoot(ifcServiceLife);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SERVICE_LIFE_FACTOR: {
			IfcServiceLifeFactor ifcServiceLifeFactor = (IfcServiceLifeFactor) theEObject;
			T result = caseIfcServiceLifeFactor(ifcServiceLifeFactor);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcServiceLifeFactor);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcServiceLifeFactor);
			if (result == null)
				result = caseIfcRoot(ifcServiceLifeFactor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SHAPE_ASPECT: {
			IfcShapeAspect ifcShapeAspect = (IfcShapeAspect) theEObject;
			T result = caseIfcShapeAspect(ifcShapeAspect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SHAPE_MODEL: {
			IfcShapeModel ifcShapeModel = (IfcShapeModel) theEObject;
			T result = caseIfcShapeModel(ifcShapeModel);
			if (result == null)
				result = caseIfcRepresentation(ifcShapeModel);
			if (result == null)
				result = caseIfcLayeredItem(ifcShapeModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SHAPE_REPRESENTATION: {
			IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation) theEObject;
			T result = caseIfcShapeRepresentation(ifcShapeRepresentation);
			if (result == null)
				result = caseIfcShapeModel(ifcShapeRepresentation);
			if (result == null)
				result = caseIfcRepresentation(ifcShapeRepresentation);
			if (result == null)
				result = caseIfcLayeredItem(ifcShapeRepresentation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SHELL_BASED_SURFACE_MODEL: {
			IfcShellBasedSurfaceModel ifcShellBasedSurfaceModel = (IfcShellBasedSurfaceModel) theEObject;
			T result = caseIfcShellBasedSurfaceModel(ifcShellBasedSurfaceModel);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcShellBasedSurfaceModel);
			if (result == null)
				result = caseIfcRepresentationItem(ifcShellBasedSurfaceModel);
			if (result == null)
				result = caseIfcLayeredItem(ifcShellBasedSurfaceModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SIMPLE_PROPERTY: {
			IfcSimpleProperty ifcSimpleProperty = (IfcSimpleProperty) theEObject;
			T result = caseIfcSimpleProperty(ifcSimpleProperty);
			if (result == null)
				result = caseIfcProperty(ifcSimpleProperty);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SITE: {
			IfcSite ifcSite = (IfcSite) theEObject;
			T result = caseIfcSite(ifcSite);
			if (result == null)
				result = caseIfcSpatialStructureElement(ifcSite);
			if (result == null)
				result = caseIfcProduct(ifcSite);
			if (result == null)
				result = caseIfcObject(ifcSite);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSite);
			if (result == null)
				result = caseIfcRoot(ifcSite);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SLAB: {
			IfcSlab ifcSlab = (IfcSlab) theEObject;
			T result = caseIfcSlab(ifcSlab);
			if (result == null)
				result = caseIfcBuildingElement(ifcSlab);
			if (result == null)
				result = caseIfcElement(ifcSlab);
			if (result == null)
				result = caseIfcProduct(ifcSlab);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcSlab);
			if (result == null)
				result = caseIfcObject(ifcSlab);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSlab);
			if (result == null)
				result = caseIfcRoot(ifcSlab);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SLAB_TYPE: {
			IfcSlabType ifcSlabType = (IfcSlabType) theEObject;
			T result = caseIfcSlabType(ifcSlabType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcSlabType);
			if (result == null)
				result = caseIfcElementType(ifcSlabType);
			if (result == null)
				result = caseIfcTypeProduct(ifcSlabType);
			if (result == null)
				result = caseIfcTypeObject(ifcSlabType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSlabType);
			if (result == null)
				result = caseIfcRoot(ifcSlabType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SLIPPAGE_CONNECTION_CONDITION: {
			IfcSlippageConnectionCondition ifcSlippageConnectionCondition = (IfcSlippageConnectionCondition) theEObject;
			T result = caseIfcSlippageConnectionCondition(ifcSlippageConnectionCondition);
			if (result == null)
				result = caseIfcStructuralConnectionCondition(ifcSlippageConnectionCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SOLID_MODEL: {
			IfcSolidModel ifcSolidModel = (IfcSolidModel) theEObject;
			T result = caseIfcSolidModel(ifcSolidModel);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSolidModel);
			if (result == null)
				result = caseIfcBooleanOperand(ifcSolidModel);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSolidModel);
			if (result == null)
				result = caseIfcLayeredItem(ifcSolidModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SOUND_PROPERTIES: {
			IfcSoundProperties ifcSoundProperties = (IfcSoundProperties) theEObject;
			T result = caseIfcSoundProperties(ifcSoundProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcSoundProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcSoundProperties);
			if (result == null)
				result = caseIfcRoot(ifcSoundProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SOUND_VALUE: {
			IfcSoundValue ifcSoundValue = (IfcSoundValue) theEObject;
			T result = caseIfcSoundValue(ifcSoundValue);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcSoundValue);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcSoundValue);
			if (result == null)
				result = caseIfcRoot(ifcSoundValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPACE: {
			IfcSpace ifcSpace = (IfcSpace) theEObject;
			T result = caseIfcSpace(ifcSpace);
			if (result == null)
				result = caseIfcSpatialStructureElement(ifcSpace);
			if (result == null)
				result = caseIfcProduct(ifcSpace);
			if (result == null)
				result = caseIfcObject(ifcSpace);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSpace);
			if (result == null)
				result = caseIfcRoot(ifcSpace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPACE_HEATER_TYPE: {
			IfcSpaceHeaterType ifcSpaceHeaterType = (IfcSpaceHeaterType) theEObject;
			T result = caseIfcSpaceHeaterType(ifcSpaceHeaterType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcSpaceHeaterType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcSpaceHeaterType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcSpaceHeaterType);
			if (result == null)
				result = caseIfcElementType(ifcSpaceHeaterType);
			if (result == null)
				result = caseIfcTypeProduct(ifcSpaceHeaterType);
			if (result == null)
				result = caseIfcTypeObject(ifcSpaceHeaterType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSpaceHeaterType);
			if (result == null)
				result = caseIfcRoot(ifcSpaceHeaterType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPACE_PROGRAM: {
			IfcSpaceProgram ifcSpaceProgram = (IfcSpaceProgram) theEObject;
			T result = caseIfcSpaceProgram(ifcSpaceProgram);
			if (result == null)
				result = caseIfcControl(ifcSpaceProgram);
			if (result == null)
				result = caseIfcObject(ifcSpaceProgram);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSpaceProgram);
			if (result == null)
				result = caseIfcRoot(ifcSpaceProgram);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPACE_THERMAL_LOAD_PROPERTIES: {
			IfcSpaceThermalLoadProperties ifcSpaceThermalLoadProperties = (IfcSpaceThermalLoadProperties) theEObject;
			T result = caseIfcSpaceThermalLoadProperties(ifcSpaceThermalLoadProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcSpaceThermalLoadProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcSpaceThermalLoadProperties);
			if (result == null)
				result = caseIfcRoot(ifcSpaceThermalLoadProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPACE_TYPE: {
			IfcSpaceType ifcSpaceType = (IfcSpaceType) theEObject;
			T result = caseIfcSpaceType(ifcSpaceType);
			if (result == null)
				result = caseIfcSpatialStructureElementType(ifcSpaceType);
			if (result == null)
				result = caseIfcElementType(ifcSpaceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcSpaceType);
			if (result == null)
				result = caseIfcTypeObject(ifcSpaceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSpaceType);
			if (result == null)
				result = caseIfcRoot(ifcSpaceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPATIAL_STRUCTURE_ELEMENT: {
			IfcSpatialStructureElement ifcSpatialStructureElement = (IfcSpatialStructureElement) theEObject;
			T result = caseIfcSpatialStructureElement(ifcSpatialStructureElement);
			if (result == null)
				result = caseIfcProduct(ifcSpatialStructureElement);
			if (result == null)
				result = caseIfcObject(ifcSpatialStructureElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSpatialStructureElement);
			if (result == null)
				result = caseIfcRoot(ifcSpatialStructureElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPATIAL_STRUCTURE_ELEMENT_TYPE: {
			IfcSpatialStructureElementType ifcSpatialStructureElementType = (IfcSpatialStructureElementType) theEObject;
			T result = caseIfcSpatialStructureElementType(ifcSpatialStructureElementType);
			if (result == null)
				result = caseIfcElementType(ifcSpatialStructureElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcSpatialStructureElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcSpatialStructureElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSpatialStructureElementType);
			if (result == null)
				result = caseIfcRoot(ifcSpatialStructureElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPHERE: {
			IfcSphere ifcSphere = (IfcSphere) theEObject;
			T result = caseIfcSphere(ifcSphere);
			if (result == null)
				result = caseIfcCsgPrimitive3D(ifcSphere);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSphere);
			if (result == null)
				result = caseIfcBooleanOperand(ifcSphere);
			if (result == null)
				result = caseIfcCsgSelect(ifcSphere);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSphere);
			if (result == null)
				result = caseIfcLayeredItem(ifcSphere);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STACK_TERMINAL_TYPE: {
			IfcStackTerminalType ifcStackTerminalType = (IfcStackTerminalType) theEObject;
			T result = caseIfcStackTerminalType(ifcStackTerminalType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcStackTerminalType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcStackTerminalType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcStackTerminalType);
			if (result == null)
				result = caseIfcElementType(ifcStackTerminalType);
			if (result == null)
				result = caseIfcTypeProduct(ifcStackTerminalType);
			if (result == null)
				result = caseIfcTypeObject(ifcStackTerminalType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStackTerminalType);
			if (result == null)
				result = caseIfcRoot(ifcStackTerminalType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STAIR: {
			IfcStair ifcStair = (IfcStair) theEObject;
			T result = caseIfcStair(ifcStair);
			if (result == null)
				result = caseIfcBuildingElement(ifcStair);
			if (result == null)
				result = caseIfcElement(ifcStair);
			if (result == null)
				result = caseIfcProduct(ifcStair);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStair);
			if (result == null)
				result = caseIfcObject(ifcStair);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStair);
			if (result == null)
				result = caseIfcRoot(ifcStair);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STAIR_FLIGHT: {
			IfcStairFlight ifcStairFlight = (IfcStairFlight) theEObject;
			T result = caseIfcStairFlight(ifcStairFlight);
			if (result == null)
				result = caseIfcBuildingElement(ifcStairFlight);
			if (result == null)
				result = caseIfcElement(ifcStairFlight);
			if (result == null)
				result = caseIfcProduct(ifcStairFlight);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStairFlight);
			if (result == null)
				result = caseIfcObject(ifcStairFlight);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStairFlight);
			if (result == null)
				result = caseIfcRoot(ifcStairFlight);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STAIR_FLIGHT_TYPE: {
			IfcStairFlightType ifcStairFlightType = (IfcStairFlightType) theEObject;
			T result = caseIfcStairFlightType(ifcStairFlightType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcStairFlightType);
			if (result == null)
				result = caseIfcElementType(ifcStairFlightType);
			if (result == null)
				result = caseIfcTypeProduct(ifcStairFlightType);
			if (result == null)
				result = caseIfcTypeObject(ifcStairFlightType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStairFlightType);
			if (result == null)
				result = caseIfcRoot(ifcStairFlightType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ACTION: {
			IfcStructuralAction ifcStructuralAction = (IfcStructuralAction) theEObject;
			T result = caseIfcStructuralAction(ifcStructuralAction);
			if (result == null)
				result = caseIfcStructuralActivity(ifcStructuralAction);
			if (result == null)
				result = caseIfcProduct(ifcStructuralAction);
			if (result == null)
				result = caseIfcObject(ifcStructuralAction);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralAction);
			if (result == null)
				result = caseIfcRoot(ifcStructuralAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ACTIVITY: {
			IfcStructuralActivity ifcStructuralActivity = (IfcStructuralActivity) theEObject;
			T result = caseIfcStructuralActivity(ifcStructuralActivity);
			if (result == null)
				result = caseIfcProduct(ifcStructuralActivity);
			if (result == null)
				result = caseIfcObject(ifcStructuralActivity);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralActivity);
			if (result == null)
				result = caseIfcRoot(ifcStructuralActivity);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ANALYSIS_MODEL: {
			IfcStructuralAnalysisModel ifcStructuralAnalysisModel = (IfcStructuralAnalysisModel) theEObject;
			T result = caseIfcStructuralAnalysisModel(ifcStructuralAnalysisModel);
			if (result == null)
				result = caseIfcSystem(ifcStructuralAnalysisModel);
			if (result == null)
				result = caseIfcGroup(ifcStructuralAnalysisModel);
			if (result == null)
				result = caseIfcObject(ifcStructuralAnalysisModel);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralAnalysisModel);
			if (result == null)
				result = caseIfcRoot(ifcStructuralAnalysisModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CONNECTION: {
			IfcStructuralConnection ifcStructuralConnection = (IfcStructuralConnection) theEObject;
			T result = caseIfcStructuralConnection(ifcStructuralConnection);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralConnection);
			if (result == null)
				result = caseIfcProduct(ifcStructuralConnection);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralConnection);
			if (result == null)
				result = caseIfcObject(ifcStructuralConnection);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralConnection);
			if (result == null)
				result = caseIfcRoot(ifcStructuralConnection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CONNECTION_CONDITION: {
			IfcStructuralConnectionCondition ifcStructuralConnectionCondition = (IfcStructuralConnectionCondition) theEObject;
			T result = caseIfcStructuralConnectionCondition(ifcStructuralConnectionCondition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CURVE_CONNECTION: {
			IfcStructuralCurveConnection ifcStructuralCurveConnection = (IfcStructuralCurveConnection) theEObject;
			T result = caseIfcStructuralCurveConnection(ifcStructuralCurveConnection);
			if (result == null)
				result = caseIfcStructuralConnection(ifcStructuralCurveConnection);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralCurveConnection);
			if (result == null)
				result = caseIfcProduct(ifcStructuralCurveConnection);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralCurveConnection);
			if (result == null)
				result = caseIfcObject(ifcStructuralCurveConnection);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralCurveConnection);
			if (result == null)
				result = caseIfcRoot(ifcStructuralCurveConnection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CURVE_MEMBER: {
			IfcStructuralCurveMember ifcStructuralCurveMember = (IfcStructuralCurveMember) theEObject;
			T result = caseIfcStructuralCurveMember(ifcStructuralCurveMember);
			if (result == null)
				result = caseIfcStructuralMember(ifcStructuralCurveMember);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralCurveMember);
			if (result == null)
				result = caseIfcProduct(ifcStructuralCurveMember);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralCurveMember);
			if (result == null)
				result = caseIfcObject(ifcStructuralCurveMember);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralCurveMember);
			if (result == null)
				result = caseIfcRoot(ifcStructuralCurveMember);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_CURVE_MEMBER_VARYING: {
			IfcStructuralCurveMemberVarying ifcStructuralCurveMemberVarying = (IfcStructuralCurveMemberVarying) theEObject;
			T result = caseIfcStructuralCurveMemberVarying(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = caseIfcStructuralCurveMember(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = caseIfcStructuralMember(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = caseIfcProduct(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = caseIfcObject(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = caseIfcRoot(ifcStructuralCurveMemberVarying);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ITEM: {
			IfcStructuralItem ifcStructuralItem = (IfcStructuralItem) theEObject;
			T result = caseIfcStructuralItem(ifcStructuralItem);
			if (result == null)
				result = caseIfcProduct(ifcStructuralItem);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralItem);
			if (result == null)
				result = caseIfcObject(ifcStructuralItem);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralItem);
			if (result == null)
				result = caseIfcRoot(ifcStructuralItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LINEAR_ACTION: {
			IfcStructuralLinearAction ifcStructuralLinearAction = (IfcStructuralLinearAction) theEObject;
			T result = caseIfcStructuralLinearAction(ifcStructuralLinearAction);
			if (result == null)
				result = caseIfcStructuralAction(ifcStructuralLinearAction);
			if (result == null)
				result = caseIfcStructuralActivity(ifcStructuralLinearAction);
			if (result == null)
				result = caseIfcProduct(ifcStructuralLinearAction);
			if (result == null)
				result = caseIfcObject(ifcStructuralLinearAction);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralLinearAction);
			if (result == null)
				result = caseIfcRoot(ifcStructuralLinearAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LINEAR_ACTION_VARYING: {
			IfcStructuralLinearActionVarying ifcStructuralLinearActionVarying = (IfcStructuralLinearActionVarying) theEObject;
			T result = caseIfcStructuralLinearActionVarying(ifcStructuralLinearActionVarying);
			if (result == null)
				result = caseIfcStructuralLinearAction(ifcStructuralLinearActionVarying);
			if (result == null)
				result = caseIfcStructuralAction(ifcStructuralLinearActionVarying);
			if (result == null)
				result = caseIfcStructuralActivity(ifcStructuralLinearActionVarying);
			if (result == null)
				result = caseIfcProduct(ifcStructuralLinearActionVarying);
			if (result == null)
				result = caseIfcObject(ifcStructuralLinearActionVarying);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralLinearActionVarying);
			if (result == null)
				result = caseIfcRoot(ifcStructuralLinearActionVarying);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD: {
			IfcStructuralLoad ifcStructuralLoad = (IfcStructuralLoad) theEObject;
			T result = caseIfcStructuralLoad(ifcStructuralLoad);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_GROUP: {
			IfcStructuralLoadGroup ifcStructuralLoadGroup = (IfcStructuralLoadGroup) theEObject;
			T result = caseIfcStructuralLoadGroup(ifcStructuralLoadGroup);
			if (result == null)
				result = caseIfcGroup(ifcStructuralLoadGroup);
			if (result == null)
				result = caseIfcObject(ifcStructuralLoadGroup);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralLoadGroup);
			if (result == null)
				result = caseIfcRoot(ifcStructuralLoadGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_LINEAR_FORCE: {
			IfcStructuralLoadLinearForce ifcStructuralLoadLinearForce = (IfcStructuralLoadLinearForce) theEObject;
			T result = caseIfcStructuralLoadLinearForce(ifcStructuralLoadLinearForce);
			if (result == null)
				result = caseIfcStructuralLoadStatic(ifcStructuralLoadLinearForce);
			if (result == null)
				result = caseIfcStructuralLoad(ifcStructuralLoadLinearForce);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_PLANAR_FORCE: {
			IfcStructuralLoadPlanarForce ifcStructuralLoadPlanarForce = (IfcStructuralLoadPlanarForce) theEObject;
			T result = caseIfcStructuralLoadPlanarForce(ifcStructuralLoadPlanarForce);
			if (result == null)
				result = caseIfcStructuralLoadStatic(ifcStructuralLoadPlanarForce);
			if (result == null)
				result = caseIfcStructuralLoad(ifcStructuralLoadPlanarForce);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT: {
			IfcStructuralLoadSingleDisplacement ifcStructuralLoadSingleDisplacement = (IfcStructuralLoadSingleDisplacement) theEObject;
			T result = caseIfcStructuralLoadSingleDisplacement(ifcStructuralLoadSingleDisplacement);
			if (result == null)
				result = caseIfcStructuralLoadStatic(ifcStructuralLoadSingleDisplacement);
			if (result == null)
				result = caseIfcStructuralLoad(ifcStructuralLoadSingleDisplacement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_SINGLE_DISPLACEMENT_DISTORTION: {
			IfcStructuralLoadSingleDisplacementDistortion ifcStructuralLoadSingleDisplacementDistortion = (IfcStructuralLoadSingleDisplacementDistortion) theEObject;
			T result = caseIfcStructuralLoadSingleDisplacementDistortion(ifcStructuralLoadSingleDisplacementDistortion);
			if (result == null)
				result = caseIfcStructuralLoadSingleDisplacement(ifcStructuralLoadSingleDisplacementDistortion);
			if (result == null)
				result = caseIfcStructuralLoadStatic(ifcStructuralLoadSingleDisplacementDistortion);
			if (result == null)
				result = caseIfcStructuralLoad(ifcStructuralLoadSingleDisplacementDistortion);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_SINGLE_FORCE: {
			IfcStructuralLoadSingleForce ifcStructuralLoadSingleForce = (IfcStructuralLoadSingleForce) theEObject;
			T result = caseIfcStructuralLoadSingleForce(ifcStructuralLoadSingleForce);
			if (result == null)
				result = caseIfcStructuralLoadStatic(ifcStructuralLoadSingleForce);
			if (result == null)
				result = caseIfcStructuralLoad(ifcStructuralLoadSingleForce);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_SINGLE_FORCE_WARPING: {
			IfcStructuralLoadSingleForceWarping ifcStructuralLoadSingleForceWarping = (IfcStructuralLoadSingleForceWarping) theEObject;
			T result = caseIfcStructuralLoadSingleForceWarping(ifcStructuralLoadSingleForceWarping);
			if (result == null)
				result = caseIfcStructuralLoadSingleForce(ifcStructuralLoadSingleForceWarping);
			if (result == null)
				result = caseIfcStructuralLoadStatic(ifcStructuralLoadSingleForceWarping);
			if (result == null)
				result = caseIfcStructuralLoad(ifcStructuralLoadSingleForceWarping);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_STATIC: {
			IfcStructuralLoadStatic ifcStructuralLoadStatic = (IfcStructuralLoadStatic) theEObject;
			T result = caseIfcStructuralLoadStatic(ifcStructuralLoadStatic);
			if (result == null)
				result = caseIfcStructuralLoad(ifcStructuralLoadStatic);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_LOAD_TEMPERATURE: {
			IfcStructuralLoadTemperature ifcStructuralLoadTemperature = (IfcStructuralLoadTemperature) theEObject;
			T result = caseIfcStructuralLoadTemperature(ifcStructuralLoadTemperature);
			if (result == null)
				result = caseIfcStructuralLoadStatic(ifcStructuralLoadTemperature);
			if (result == null)
				result = caseIfcStructuralLoad(ifcStructuralLoadTemperature);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_MEMBER: {
			IfcStructuralMember ifcStructuralMember = (IfcStructuralMember) theEObject;
			T result = caseIfcStructuralMember(ifcStructuralMember);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralMember);
			if (result == null)
				result = caseIfcProduct(ifcStructuralMember);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralMember);
			if (result == null)
				result = caseIfcObject(ifcStructuralMember);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralMember);
			if (result == null)
				result = caseIfcRoot(ifcStructuralMember);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_PLANAR_ACTION: {
			IfcStructuralPlanarAction ifcStructuralPlanarAction = (IfcStructuralPlanarAction) theEObject;
			T result = caseIfcStructuralPlanarAction(ifcStructuralPlanarAction);
			if (result == null)
				result = caseIfcStructuralAction(ifcStructuralPlanarAction);
			if (result == null)
				result = caseIfcStructuralActivity(ifcStructuralPlanarAction);
			if (result == null)
				result = caseIfcProduct(ifcStructuralPlanarAction);
			if (result == null)
				result = caseIfcObject(ifcStructuralPlanarAction);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralPlanarAction);
			if (result == null)
				result = caseIfcRoot(ifcStructuralPlanarAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_PLANAR_ACTION_VARYING: {
			IfcStructuralPlanarActionVarying ifcStructuralPlanarActionVarying = (IfcStructuralPlanarActionVarying) theEObject;
			T result = caseIfcStructuralPlanarActionVarying(ifcStructuralPlanarActionVarying);
			if (result == null)
				result = caseIfcStructuralPlanarAction(ifcStructuralPlanarActionVarying);
			if (result == null)
				result = caseIfcStructuralAction(ifcStructuralPlanarActionVarying);
			if (result == null)
				result = caseIfcStructuralActivity(ifcStructuralPlanarActionVarying);
			if (result == null)
				result = caseIfcProduct(ifcStructuralPlanarActionVarying);
			if (result == null)
				result = caseIfcObject(ifcStructuralPlanarActionVarying);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralPlanarActionVarying);
			if (result == null)
				result = caseIfcRoot(ifcStructuralPlanarActionVarying);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_POINT_ACTION: {
			IfcStructuralPointAction ifcStructuralPointAction = (IfcStructuralPointAction) theEObject;
			T result = caseIfcStructuralPointAction(ifcStructuralPointAction);
			if (result == null)
				result = caseIfcStructuralAction(ifcStructuralPointAction);
			if (result == null)
				result = caseIfcStructuralActivity(ifcStructuralPointAction);
			if (result == null)
				result = caseIfcProduct(ifcStructuralPointAction);
			if (result == null)
				result = caseIfcObject(ifcStructuralPointAction);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralPointAction);
			if (result == null)
				result = caseIfcRoot(ifcStructuralPointAction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_POINT_CONNECTION: {
			IfcStructuralPointConnection ifcStructuralPointConnection = (IfcStructuralPointConnection) theEObject;
			T result = caseIfcStructuralPointConnection(ifcStructuralPointConnection);
			if (result == null)
				result = caseIfcStructuralConnection(ifcStructuralPointConnection);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralPointConnection);
			if (result == null)
				result = caseIfcProduct(ifcStructuralPointConnection);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralPointConnection);
			if (result == null)
				result = caseIfcObject(ifcStructuralPointConnection);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralPointConnection);
			if (result == null)
				result = caseIfcRoot(ifcStructuralPointConnection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_POINT_REACTION: {
			IfcStructuralPointReaction ifcStructuralPointReaction = (IfcStructuralPointReaction) theEObject;
			T result = caseIfcStructuralPointReaction(ifcStructuralPointReaction);
			if (result == null)
				result = caseIfcStructuralReaction(ifcStructuralPointReaction);
			if (result == null)
				result = caseIfcStructuralActivity(ifcStructuralPointReaction);
			if (result == null)
				result = caseIfcProduct(ifcStructuralPointReaction);
			if (result == null)
				result = caseIfcObject(ifcStructuralPointReaction);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralPointReaction);
			if (result == null)
				result = caseIfcRoot(ifcStructuralPointReaction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_PROFILE_PROPERTIES: {
			IfcStructuralProfileProperties ifcStructuralProfileProperties = (IfcStructuralProfileProperties) theEObject;
			T result = caseIfcStructuralProfileProperties(ifcStructuralProfileProperties);
			if (result == null)
				result = caseIfcGeneralProfileProperties(ifcStructuralProfileProperties);
			if (result == null)
				result = caseIfcProfileProperties(ifcStructuralProfileProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_REACTION: {
			IfcStructuralReaction ifcStructuralReaction = (IfcStructuralReaction) theEObject;
			T result = caseIfcStructuralReaction(ifcStructuralReaction);
			if (result == null)
				result = caseIfcStructuralActivity(ifcStructuralReaction);
			if (result == null)
				result = caseIfcProduct(ifcStructuralReaction);
			if (result == null)
				result = caseIfcObject(ifcStructuralReaction);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralReaction);
			if (result == null)
				result = caseIfcRoot(ifcStructuralReaction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_RESULT_GROUP: {
			IfcStructuralResultGroup ifcStructuralResultGroup = (IfcStructuralResultGroup) theEObject;
			T result = caseIfcStructuralResultGroup(ifcStructuralResultGroup);
			if (result == null)
				result = caseIfcGroup(ifcStructuralResultGroup);
			if (result == null)
				result = caseIfcObject(ifcStructuralResultGroup);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralResultGroup);
			if (result == null)
				result = caseIfcRoot(ifcStructuralResultGroup);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_STEEL_PROFILE_PROPERTIES: {
			IfcStructuralSteelProfileProperties ifcStructuralSteelProfileProperties = (IfcStructuralSteelProfileProperties) theEObject;
			T result = caseIfcStructuralSteelProfileProperties(ifcStructuralSteelProfileProperties);
			if (result == null)
				result = caseIfcStructuralProfileProperties(ifcStructuralSteelProfileProperties);
			if (result == null)
				result = caseIfcGeneralProfileProperties(ifcStructuralSteelProfileProperties);
			if (result == null)
				result = caseIfcProfileProperties(ifcStructuralSteelProfileProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_SURFACE_CONNECTION: {
			IfcStructuralSurfaceConnection ifcStructuralSurfaceConnection = (IfcStructuralSurfaceConnection) theEObject;
			T result = caseIfcStructuralSurfaceConnection(ifcStructuralSurfaceConnection);
			if (result == null)
				result = caseIfcStructuralConnection(ifcStructuralSurfaceConnection);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralSurfaceConnection);
			if (result == null)
				result = caseIfcProduct(ifcStructuralSurfaceConnection);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralSurfaceConnection);
			if (result == null)
				result = caseIfcObject(ifcStructuralSurfaceConnection);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralSurfaceConnection);
			if (result == null)
				result = caseIfcRoot(ifcStructuralSurfaceConnection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_SURFACE_MEMBER: {
			IfcStructuralSurfaceMember ifcStructuralSurfaceMember = (IfcStructuralSurfaceMember) theEObject;
			T result = caseIfcStructuralSurfaceMember(ifcStructuralSurfaceMember);
			if (result == null)
				result = caseIfcStructuralMember(ifcStructuralSurfaceMember);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralSurfaceMember);
			if (result == null)
				result = caseIfcProduct(ifcStructuralSurfaceMember);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralSurfaceMember);
			if (result == null)
				result = caseIfcObject(ifcStructuralSurfaceMember);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralSurfaceMember);
			if (result == null)
				result = caseIfcRoot(ifcStructuralSurfaceMember);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_SURFACE_MEMBER_VARYING: {
			IfcStructuralSurfaceMemberVarying ifcStructuralSurfaceMemberVarying = (IfcStructuralSurfaceMemberVarying) theEObject;
			T result = caseIfcStructuralSurfaceMemberVarying(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = caseIfcStructuralSurfaceMember(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = caseIfcStructuralMember(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = caseIfcStructuralItem(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = caseIfcProduct(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = caseIfcObject(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = caseIfcObjectDefinition(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = caseIfcRoot(ifcStructuralSurfaceMemberVarying);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURED_DIMENSION_CALLOUT: {
			IfcStructuredDimensionCallout ifcStructuredDimensionCallout = (IfcStructuredDimensionCallout) theEObject;
			T result = caseIfcStructuredDimensionCallout(ifcStructuredDimensionCallout);
			if (result == null)
				result = caseIfcDraughtingCallout(ifcStructuredDimensionCallout);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcStructuredDimensionCallout);
			if (result == null)
				result = caseIfcRepresentationItem(ifcStructuredDimensionCallout);
			if (result == null)
				result = caseIfcLayeredItem(ifcStructuredDimensionCallout);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STYLE_MODEL: {
			IfcStyleModel ifcStyleModel = (IfcStyleModel) theEObject;
			T result = caseIfcStyleModel(ifcStyleModel);
			if (result == null)
				result = caseIfcRepresentation(ifcStyleModel);
			if (result == null)
				result = caseIfcLayeredItem(ifcStyleModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STYLED_ITEM: {
			IfcStyledItem ifcStyledItem = (IfcStyledItem) theEObject;
			T result = caseIfcStyledItem(ifcStyledItem);
			if (result == null)
				result = caseIfcRepresentationItem(ifcStyledItem);
			if (result == null)
				result = caseIfcLayeredItem(ifcStyledItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STYLED_REPRESENTATION: {
			IfcStyledRepresentation ifcStyledRepresentation = (IfcStyledRepresentation) theEObject;
			T result = caseIfcStyledRepresentation(ifcStyledRepresentation);
			if (result == null)
				result = caseIfcStyleModel(ifcStyledRepresentation);
			if (result == null)
				result = caseIfcRepresentation(ifcStyledRepresentation);
			if (result == null)
				result = caseIfcLayeredItem(ifcStyledRepresentation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SUB_CONTRACT_RESOURCE: {
			IfcSubContractResource ifcSubContractResource = (IfcSubContractResource) theEObject;
			T result = caseIfcSubContractResource(ifcSubContractResource);
			if (result == null)
				result = caseIfcConstructionResource(ifcSubContractResource);
			if (result == null)
				result = caseIfcResource(ifcSubContractResource);
			if (result == null)
				result = caseIfcObject(ifcSubContractResource);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSubContractResource);
			if (result == null)
				result = caseIfcRoot(ifcSubContractResource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SUBEDGE: {
			IfcSubedge ifcSubedge = (IfcSubedge) theEObject;
			T result = caseIfcSubedge(ifcSubedge);
			if (result == null)
				result = caseIfcEdge(ifcSubedge);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcSubedge);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSubedge);
			if (result == null)
				result = caseIfcLayeredItem(ifcSubedge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE: {
			IfcSurface ifcSurface = (IfcSurface) theEObject;
			T result = caseIfcSurface(ifcSurface);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSurface);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcSurface);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcSurface);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSurface);
			if (result == null)
				result = caseIfcLayeredItem(ifcSurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_CURVE_SWEPT_AREA_SOLID: {
			IfcSurfaceCurveSweptAreaSolid ifcSurfaceCurveSweptAreaSolid = (IfcSurfaceCurveSweptAreaSolid) theEObject;
			T result = caseIfcSurfaceCurveSweptAreaSolid(ifcSurfaceCurveSweptAreaSolid);
			if (result == null)
				result = caseIfcSweptAreaSolid(ifcSurfaceCurveSweptAreaSolid);
			if (result == null)
				result = caseIfcSolidModel(ifcSurfaceCurveSweptAreaSolid);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSurfaceCurveSweptAreaSolid);
			if (result == null)
				result = caseIfcBooleanOperand(ifcSurfaceCurveSweptAreaSolid);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSurfaceCurveSweptAreaSolid);
			if (result == null)
				result = caseIfcLayeredItem(ifcSurfaceCurveSweptAreaSolid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_OF_LINEAR_EXTRUSION: {
			IfcSurfaceOfLinearExtrusion ifcSurfaceOfLinearExtrusion = (IfcSurfaceOfLinearExtrusion) theEObject;
			T result = caseIfcSurfaceOfLinearExtrusion(ifcSurfaceOfLinearExtrusion);
			if (result == null)
				result = caseIfcSweptSurface(ifcSurfaceOfLinearExtrusion);
			if (result == null)
				result = caseIfcSurface(ifcSurfaceOfLinearExtrusion);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSurfaceOfLinearExtrusion);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcSurfaceOfLinearExtrusion);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcSurfaceOfLinearExtrusion);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSurfaceOfLinearExtrusion);
			if (result == null)
				result = caseIfcLayeredItem(ifcSurfaceOfLinearExtrusion);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_OF_REVOLUTION: {
			IfcSurfaceOfRevolution ifcSurfaceOfRevolution = (IfcSurfaceOfRevolution) theEObject;
			T result = caseIfcSurfaceOfRevolution(ifcSurfaceOfRevolution);
			if (result == null)
				result = caseIfcSweptSurface(ifcSurfaceOfRevolution);
			if (result == null)
				result = caseIfcSurface(ifcSurfaceOfRevolution);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSurfaceOfRevolution);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcSurfaceOfRevolution);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcSurfaceOfRevolution);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSurfaceOfRevolution);
			if (result == null)
				result = caseIfcLayeredItem(ifcSurfaceOfRevolution);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE: {
			IfcSurfaceStyle ifcSurfaceStyle = (IfcSurfaceStyle) theEObject;
			T result = caseIfcSurfaceStyle(ifcSurfaceStyle);
			if (result == null)
				result = caseIfcPresentationStyle(ifcSurfaceStyle);
			if (result == null)
				result = caseIfcPresentationStyleSelect(ifcSurfaceStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_LIGHTING: {
			IfcSurfaceStyleLighting ifcSurfaceStyleLighting = (IfcSurfaceStyleLighting) theEObject;
			T result = caseIfcSurfaceStyleLighting(ifcSurfaceStyleLighting);
			if (result == null)
				result = caseIfcSurfaceStyleElementSelect(ifcSurfaceStyleLighting);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_REFRACTION: {
			IfcSurfaceStyleRefraction ifcSurfaceStyleRefraction = (IfcSurfaceStyleRefraction) theEObject;
			T result = caseIfcSurfaceStyleRefraction(ifcSurfaceStyleRefraction);
			if (result == null)
				result = caseIfcSurfaceStyleElementSelect(ifcSurfaceStyleRefraction);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_RENDERING: {
			IfcSurfaceStyleRendering ifcSurfaceStyleRendering = (IfcSurfaceStyleRendering) theEObject;
			T result = caseIfcSurfaceStyleRendering(ifcSurfaceStyleRendering);
			if (result == null)
				result = caseIfcSurfaceStyleShading(ifcSurfaceStyleRendering);
			if (result == null)
				result = caseIfcSurfaceStyleElementSelect(ifcSurfaceStyleRendering);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_SHADING: {
			IfcSurfaceStyleShading ifcSurfaceStyleShading = (IfcSurfaceStyleShading) theEObject;
			T result = caseIfcSurfaceStyleShading(ifcSurfaceStyleShading);
			if (result == null)
				result = caseIfcSurfaceStyleElementSelect(ifcSurfaceStyleShading);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_WITH_TEXTURES: {
			IfcSurfaceStyleWithTextures ifcSurfaceStyleWithTextures = (IfcSurfaceStyleWithTextures) theEObject;
			T result = caseIfcSurfaceStyleWithTextures(ifcSurfaceStyleWithTextures);
			if (result == null)
				result = caseIfcSurfaceStyleElementSelect(ifcSurfaceStyleWithTextures);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_TEXTURE: {
			IfcSurfaceTexture ifcSurfaceTexture = (IfcSurfaceTexture) theEObject;
			T result = caseIfcSurfaceTexture(ifcSurfaceTexture);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SWEPT_AREA_SOLID: {
			IfcSweptAreaSolid ifcSweptAreaSolid = (IfcSweptAreaSolid) theEObject;
			T result = caseIfcSweptAreaSolid(ifcSweptAreaSolid);
			if (result == null)
				result = caseIfcSolidModel(ifcSweptAreaSolid);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSweptAreaSolid);
			if (result == null)
				result = caseIfcBooleanOperand(ifcSweptAreaSolid);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSweptAreaSolid);
			if (result == null)
				result = caseIfcLayeredItem(ifcSweptAreaSolid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SWEPT_DISK_SOLID: {
			IfcSweptDiskSolid ifcSweptDiskSolid = (IfcSweptDiskSolid) theEObject;
			T result = caseIfcSweptDiskSolid(ifcSweptDiskSolid);
			if (result == null)
				result = caseIfcSolidModel(ifcSweptDiskSolid);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSweptDiskSolid);
			if (result == null)
				result = caseIfcBooleanOperand(ifcSweptDiskSolid);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSweptDiskSolid);
			if (result == null)
				result = caseIfcLayeredItem(ifcSweptDiskSolid);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SWEPT_SURFACE: {
			IfcSweptSurface ifcSweptSurface = (IfcSweptSurface) theEObject;
			T result = caseIfcSweptSurface(ifcSweptSurface);
			if (result == null)
				result = caseIfcSurface(ifcSweptSurface);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcSweptSurface);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcSweptSurface);
			if (result == null)
				result = caseIfcSurfaceOrFaceSurface(ifcSweptSurface);
			if (result == null)
				result = caseIfcRepresentationItem(ifcSweptSurface);
			if (result == null)
				result = caseIfcLayeredItem(ifcSweptSurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SWITCHING_DEVICE_TYPE: {
			IfcSwitchingDeviceType ifcSwitchingDeviceType = (IfcSwitchingDeviceType) theEObject;
			T result = caseIfcSwitchingDeviceType(ifcSwitchingDeviceType);
			if (result == null)
				result = caseIfcFlowControllerType(ifcSwitchingDeviceType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcSwitchingDeviceType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcSwitchingDeviceType);
			if (result == null)
				result = caseIfcElementType(ifcSwitchingDeviceType);
			if (result == null)
				result = caseIfcTypeProduct(ifcSwitchingDeviceType);
			if (result == null)
				result = caseIfcTypeObject(ifcSwitchingDeviceType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSwitchingDeviceType);
			if (result == null)
				result = caseIfcRoot(ifcSwitchingDeviceType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SYMBOL_STYLE: {
			IfcSymbolStyle ifcSymbolStyle = (IfcSymbolStyle) theEObject;
			T result = caseIfcSymbolStyle(ifcSymbolStyle);
			if (result == null)
				result = caseIfcPresentationStyle(ifcSymbolStyle);
			if (result == null)
				result = caseIfcPresentationStyleSelect(ifcSymbolStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SYSTEM: {
			IfcSystem ifcSystem = (IfcSystem) theEObject;
			T result = caseIfcSystem(ifcSystem);
			if (result == null)
				result = caseIfcGroup(ifcSystem);
			if (result == null)
				result = caseIfcObject(ifcSystem);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSystem);
			if (result == null)
				result = caseIfcRoot(ifcSystem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SYSTEM_FURNITURE_ELEMENT_TYPE: {
			IfcSystemFurnitureElementType ifcSystemFurnitureElementType = (IfcSystemFurnitureElementType) theEObject;
			T result = caseIfcSystemFurnitureElementType(ifcSystemFurnitureElementType);
			if (result == null)
				result = caseIfcFurnishingElementType(ifcSystemFurnitureElementType);
			if (result == null)
				result = caseIfcElementType(ifcSystemFurnitureElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcSystemFurnitureElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcSystemFurnitureElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcSystemFurnitureElementType);
			if (result == null)
				result = caseIfcRoot(ifcSystemFurnitureElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TSHAPE_PROFILE_DEF: {
			IfcTShapeProfileDef ifcTShapeProfileDef = (IfcTShapeProfileDef) theEObject;
			T result = caseIfcTShapeProfileDef(ifcTShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcTShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcTShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TABLE: {
			IfcTable ifcTable = (IfcTable) theEObject;
			T result = caseIfcTable(ifcTable);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcTable);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TABLE_ROW: {
			IfcTableRow ifcTableRow = (IfcTableRow) theEObject;
			T result = caseIfcTableRow(ifcTableRow);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TANK_TYPE: {
			IfcTankType ifcTankType = (IfcTankType) theEObject;
			T result = caseIfcTankType(ifcTankType);
			if (result == null)
				result = caseIfcFlowStorageDeviceType(ifcTankType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcTankType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcTankType);
			if (result == null)
				result = caseIfcElementType(ifcTankType);
			if (result == null)
				result = caseIfcTypeProduct(ifcTankType);
			if (result == null)
				result = caseIfcTypeObject(ifcTankType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTankType);
			if (result == null)
				result = caseIfcRoot(ifcTankType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TASK: {
			IfcTask ifcTask = (IfcTask) theEObject;
			T result = caseIfcTask(ifcTask);
			if (result == null)
				result = caseIfcProcess(ifcTask);
			if (result == null)
				result = caseIfcObject(ifcTask);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTask);
			if (result == null)
				result = caseIfcRoot(ifcTask);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TELECOM_ADDRESS: {
			IfcTelecomAddress ifcTelecomAddress = (IfcTelecomAddress) theEObject;
			T result = caseIfcTelecomAddress(ifcTelecomAddress);
			if (result == null)
				result = caseIfcAddress(ifcTelecomAddress);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcTelecomAddress);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TENDON: {
			IfcTendon ifcTendon = (IfcTendon) theEObject;
			T result = caseIfcTendon(ifcTendon);
			if (result == null)
				result = caseIfcReinforcingElement(ifcTendon);
			if (result == null)
				result = caseIfcBuildingElementComponent(ifcTendon);
			if (result == null)
				result = caseIfcBuildingElement(ifcTendon);
			if (result == null)
				result = caseIfcElement(ifcTendon);
			if (result == null)
				result = caseIfcProduct(ifcTendon);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcTendon);
			if (result == null)
				result = caseIfcObject(ifcTendon);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTendon);
			if (result == null)
				result = caseIfcRoot(ifcTendon);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TENDON_ANCHOR: {
			IfcTendonAnchor ifcTendonAnchor = (IfcTendonAnchor) theEObject;
			T result = caseIfcTendonAnchor(ifcTendonAnchor);
			if (result == null)
				result = caseIfcReinforcingElement(ifcTendonAnchor);
			if (result == null)
				result = caseIfcBuildingElementComponent(ifcTendonAnchor);
			if (result == null)
				result = caseIfcBuildingElement(ifcTendonAnchor);
			if (result == null)
				result = caseIfcElement(ifcTendonAnchor);
			if (result == null)
				result = caseIfcProduct(ifcTendonAnchor);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcTendonAnchor);
			if (result == null)
				result = caseIfcObject(ifcTendonAnchor);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTendonAnchor);
			if (result == null)
				result = caseIfcRoot(ifcTendonAnchor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TERMINATOR_SYMBOL: {
			IfcTerminatorSymbol ifcTerminatorSymbol = (IfcTerminatorSymbol) theEObject;
			T result = caseIfcTerminatorSymbol(ifcTerminatorSymbol);
			if (result == null)
				result = caseIfcAnnotationSymbolOccurrence(ifcTerminatorSymbol);
			if (result == null)
				result = caseIfcAnnotationOccurrence(ifcTerminatorSymbol);
			if (result == null)
				result = caseIfcDraughtingCalloutElement(ifcTerminatorSymbol);
			if (result == null)
				result = caseIfcStyledItem(ifcTerminatorSymbol);
			if (result == null)
				result = caseIfcRepresentationItem(ifcTerminatorSymbol);
			if (result == null)
				result = caseIfcLayeredItem(ifcTerminatorSymbol);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_LITERAL: {
			IfcTextLiteral ifcTextLiteral = (IfcTextLiteral) theEObject;
			T result = caseIfcTextLiteral(ifcTextLiteral);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcTextLiteral);
			if (result == null)
				result = caseIfcRepresentationItem(ifcTextLiteral);
			if (result == null)
				result = caseIfcLayeredItem(ifcTextLiteral);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_LITERAL_WITH_EXTENT: {
			IfcTextLiteralWithExtent ifcTextLiteralWithExtent = (IfcTextLiteralWithExtent) theEObject;
			T result = caseIfcTextLiteralWithExtent(ifcTextLiteralWithExtent);
			if (result == null)
				result = caseIfcTextLiteral(ifcTextLiteralWithExtent);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcTextLiteralWithExtent);
			if (result == null)
				result = caseIfcRepresentationItem(ifcTextLiteralWithExtent);
			if (result == null)
				result = caseIfcLayeredItem(ifcTextLiteralWithExtent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_STYLE: {
			IfcTextStyle ifcTextStyle = (IfcTextStyle) theEObject;
			T result = caseIfcTextStyle(ifcTextStyle);
			if (result == null)
				result = caseIfcPresentationStyle(ifcTextStyle);
			if (result == null)
				result = caseIfcPresentationStyleSelect(ifcTextStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_FONT_MODEL: {
			IfcTextStyleFontModel ifcTextStyleFontModel = (IfcTextStyleFontModel) theEObject;
			T result = caseIfcTextStyleFontModel(ifcTextStyleFontModel);
			if (result == null)
				result = caseIfcPreDefinedTextFont(ifcTextStyleFontModel);
			if (result == null)
				result = caseIfcPreDefinedItem(ifcTextStyleFontModel);
			if (result == null)
				result = caseIfcTextFontSelect(ifcTextStyleFontModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_FOR_DEFINED_FONT: {
			IfcTextStyleForDefinedFont ifcTextStyleForDefinedFont = (IfcTextStyleForDefinedFont) theEObject;
			T result = caseIfcTextStyleForDefinedFont(ifcTextStyleForDefinedFont);
			if (result == null)
				result = caseIfcCharacterStyleSelect(ifcTextStyleForDefinedFont);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_TEXT_MODEL: {
			IfcTextStyleTextModel ifcTextStyleTextModel = (IfcTextStyleTextModel) theEObject;
			T result = caseIfcTextStyleTextModel(ifcTextStyleTextModel);
			if (result == null)
				result = caseIfcTextStyleSelect(ifcTextStyleTextModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_WITH_BOX_CHARACTERISTICS: {
			IfcTextStyleWithBoxCharacteristics ifcTextStyleWithBoxCharacteristics = (IfcTextStyleWithBoxCharacteristics) theEObject;
			T result = caseIfcTextStyleWithBoxCharacteristics(ifcTextStyleWithBoxCharacteristics);
			if (result == null)
				result = caseIfcTextStyleSelect(ifcTextStyleWithBoxCharacteristics);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXTURE_COORDINATE: {
			IfcTextureCoordinate ifcTextureCoordinate = (IfcTextureCoordinate) theEObject;
			T result = caseIfcTextureCoordinate(ifcTextureCoordinate);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXTURE_COORDINATE_GENERATOR: {
			IfcTextureCoordinateGenerator ifcTextureCoordinateGenerator = (IfcTextureCoordinateGenerator) theEObject;
			T result = caseIfcTextureCoordinateGenerator(ifcTextureCoordinateGenerator);
			if (result == null)
				result = caseIfcTextureCoordinate(ifcTextureCoordinateGenerator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXTURE_MAP: {
			IfcTextureMap ifcTextureMap = (IfcTextureMap) theEObject;
			T result = caseIfcTextureMap(ifcTextureMap);
			if (result == null)
				result = caseIfcTextureCoordinate(ifcTextureMap);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXTURE_VERTEX: {
			IfcTextureVertex ifcTextureVertex = (IfcTextureVertex) theEObject;
			T result = caseIfcTextureVertex(ifcTextureVertex);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_THERMAL_MATERIAL_PROPERTIES: {
			IfcThermalMaterialProperties ifcThermalMaterialProperties = (IfcThermalMaterialProperties) theEObject;
			T result = caseIfcThermalMaterialProperties(ifcThermalMaterialProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcThermalMaterialProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TIME_SERIES: {
			IfcTimeSeries ifcTimeSeries = (IfcTimeSeries) theEObject;
			T result = caseIfcTimeSeries(ifcTimeSeries);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcTimeSeries);
			if (result == null)
				result = caseIfcObjectReferenceSelect(ifcTimeSeries);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TIME_SERIES_REFERENCE_RELATIONSHIP: {
			IfcTimeSeriesReferenceRelationship ifcTimeSeriesReferenceRelationship = (IfcTimeSeriesReferenceRelationship) theEObject;
			T result = caseIfcTimeSeriesReferenceRelationship(ifcTimeSeriesReferenceRelationship);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TIME_SERIES_SCHEDULE: {
			IfcTimeSeriesSchedule ifcTimeSeriesSchedule = (IfcTimeSeriesSchedule) theEObject;
			T result = caseIfcTimeSeriesSchedule(ifcTimeSeriesSchedule);
			if (result == null)
				result = caseIfcControl(ifcTimeSeriesSchedule);
			if (result == null)
				result = caseIfcObject(ifcTimeSeriesSchedule);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTimeSeriesSchedule);
			if (result == null)
				result = caseIfcRoot(ifcTimeSeriesSchedule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TIME_SERIES_VALUE: {
			IfcTimeSeriesValue ifcTimeSeriesValue = (IfcTimeSeriesValue) theEObject;
			T result = caseIfcTimeSeriesValue(ifcTimeSeriesValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TOPOLOGICAL_REPRESENTATION_ITEM: {
			IfcTopologicalRepresentationItem ifcTopologicalRepresentationItem = (IfcTopologicalRepresentationItem) theEObject;
			T result = caseIfcTopologicalRepresentationItem(ifcTopologicalRepresentationItem);
			if (result == null)
				result = caseIfcRepresentationItem(ifcTopologicalRepresentationItem);
			if (result == null)
				result = caseIfcLayeredItem(ifcTopologicalRepresentationItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TOPOLOGY_REPRESENTATION: {
			IfcTopologyRepresentation ifcTopologyRepresentation = (IfcTopologyRepresentation) theEObject;
			T result = caseIfcTopologyRepresentation(ifcTopologyRepresentation);
			if (result == null)
				result = caseIfcShapeModel(ifcTopologyRepresentation);
			if (result == null)
				result = caseIfcRepresentation(ifcTopologyRepresentation);
			if (result == null)
				result = caseIfcLayeredItem(ifcTopologyRepresentation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TRANSFORMER_TYPE: {
			IfcTransformerType ifcTransformerType = (IfcTransformerType) theEObject;
			T result = caseIfcTransformerType(ifcTransformerType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcTransformerType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcTransformerType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcTransformerType);
			if (result == null)
				result = caseIfcElementType(ifcTransformerType);
			if (result == null)
				result = caseIfcTypeProduct(ifcTransformerType);
			if (result == null)
				result = caseIfcTypeObject(ifcTransformerType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTransformerType);
			if (result == null)
				result = caseIfcRoot(ifcTransformerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TRANSPORT_ELEMENT: {
			IfcTransportElement ifcTransportElement = (IfcTransportElement) theEObject;
			T result = caseIfcTransportElement(ifcTransportElement);
			if (result == null)
				result = caseIfcElement(ifcTransportElement);
			if (result == null)
				result = caseIfcProduct(ifcTransportElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcTransportElement);
			if (result == null)
				result = caseIfcObject(ifcTransportElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTransportElement);
			if (result == null)
				result = caseIfcRoot(ifcTransportElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TRANSPORT_ELEMENT_TYPE: {
			IfcTransportElementType ifcTransportElementType = (IfcTransportElementType) theEObject;
			T result = caseIfcTransportElementType(ifcTransportElementType);
			if (result == null)
				result = caseIfcElementType(ifcTransportElementType);
			if (result == null)
				result = caseIfcTypeProduct(ifcTransportElementType);
			if (result == null)
				result = caseIfcTypeObject(ifcTransportElementType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTransportElementType);
			if (result == null)
				result = caseIfcRoot(ifcTransportElementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TRAPEZIUM_PROFILE_DEF: {
			IfcTrapeziumProfileDef ifcTrapeziumProfileDef = (IfcTrapeziumProfileDef) theEObject;
			T result = caseIfcTrapeziumProfileDef(ifcTrapeziumProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcTrapeziumProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcTrapeziumProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TRIMMED_CURVE: {
			IfcTrimmedCurve ifcTrimmedCurve = (IfcTrimmedCurve) theEObject;
			T result = caseIfcTrimmedCurve(ifcTrimmedCurve);
			if (result == null)
				result = caseIfcBoundedCurve(ifcTrimmedCurve);
			if (result == null)
				result = caseIfcCurve(ifcTrimmedCurve);
			if (result == null)
				result = caseIfcCurveOrEdgeCurve(ifcTrimmedCurve);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcTrimmedCurve);
			if (result == null)
				result = caseIfcGeometricSetSelect(ifcTrimmedCurve);
			if (result == null)
				result = caseIfcRepresentationItem(ifcTrimmedCurve);
			if (result == null)
				result = caseIfcLayeredItem(ifcTrimmedCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TUBE_BUNDLE_TYPE: {
			IfcTubeBundleType ifcTubeBundleType = (IfcTubeBundleType) theEObject;
			T result = caseIfcTubeBundleType(ifcTubeBundleType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcTubeBundleType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcTubeBundleType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcTubeBundleType);
			if (result == null)
				result = caseIfcElementType(ifcTubeBundleType);
			if (result == null)
				result = caseIfcTypeProduct(ifcTubeBundleType);
			if (result == null)
				result = caseIfcTypeObject(ifcTubeBundleType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTubeBundleType);
			if (result == null)
				result = caseIfcRoot(ifcTubeBundleType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TWO_DIRECTION_REPEAT_FACTOR: {
			IfcTwoDirectionRepeatFactor ifcTwoDirectionRepeatFactor = (IfcTwoDirectionRepeatFactor) theEObject;
			T result = caseIfcTwoDirectionRepeatFactor(ifcTwoDirectionRepeatFactor);
			if (result == null)
				result = caseIfcOneDirectionRepeatFactor(ifcTwoDirectionRepeatFactor);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcTwoDirectionRepeatFactor);
			if (result == null)
				result = caseIfcHatchLineDistanceSelect(ifcTwoDirectionRepeatFactor);
			if (result == null)
				result = caseIfcRepresentationItem(ifcTwoDirectionRepeatFactor);
			if (result == null)
				result = caseIfcLayeredItem(ifcTwoDirectionRepeatFactor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TYPE_OBJECT: {
			IfcTypeObject ifcTypeObject = (IfcTypeObject) theEObject;
			T result = caseIfcTypeObject(ifcTypeObject);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTypeObject);
			if (result == null)
				result = caseIfcRoot(ifcTypeObject);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TYPE_PRODUCT: {
			IfcTypeProduct ifcTypeProduct = (IfcTypeProduct) theEObject;
			T result = caseIfcTypeProduct(ifcTypeProduct);
			if (result == null)
				result = caseIfcTypeObject(ifcTypeProduct);
			if (result == null)
				result = caseIfcObjectDefinition(ifcTypeProduct);
			if (result == null)
				result = caseIfcRoot(ifcTypeProduct);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_USHAPE_PROFILE_DEF: {
			IfcUShapeProfileDef ifcUShapeProfileDef = (IfcUShapeProfileDef) theEObject;
			T result = caseIfcUShapeProfileDef(ifcUShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcUShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcUShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_UNIT_ASSIGNMENT: {
			IfcUnitAssignment ifcUnitAssignment = (IfcUnitAssignment) theEObject;
			T result = caseIfcUnitAssignment(ifcUnitAssignment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_UNITARY_EQUIPMENT_TYPE: {
			IfcUnitaryEquipmentType ifcUnitaryEquipmentType = (IfcUnitaryEquipmentType) theEObject;
			T result = caseIfcUnitaryEquipmentType(ifcUnitaryEquipmentType);
			if (result == null)
				result = caseIfcEnergyConversionDeviceType(ifcUnitaryEquipmentType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcUnitaryEquipmentType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcUnitaryEquipmentType);
			if (result == null)
				result = caseIfcElementType(ifcUnitaryEquipmentType);
			if (result == null)
				result = caseIfcTypeProduct(ifcUnitaryEquipmentType);
			if (result == null)
				result = caseIfcTypeObject(ifcUnitaryEquipmentType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcUnitaryEquipmentType);
			if (result == null)
				result = caseIfcRoot(ifcUnitaryEquipmentType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VALVE_TYPE: {
			IfcValveType ifcValveType = (IfcValveType) theEObject;
			T result = caseIfcValveType(ifcValveType);
			if (result == null)
				result = caseIfcFlowControllerType(ifcValveType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcValveType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcValveType);
			if (result == null)
				result = caseIfcElementType(ifcValveType);
			if (result == null)
				result = caseIfcTypeProduct(ifcValveType);
			if (result == null)
				result = caseIfcTypeObject(ifcValveType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcValveType);
			if (result == null)
				result = caseIfcRoot(ifcValveType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VECTOR: {
			IfcVector ifcVector = (IfcVector) theEObject;
			T result = caseIfcVector(ifcVector);
			if (result == null)
				result = caseIfcGeometricRepresentationItem(ifcVector);
			if (result == null)
				result = caseIfcVectorOrDirection(ifcVector);
			if (result == null)
				result = caseIfcRepresentationItem(ifcVector);
			if (result == null)
				result = caseIfcLayeredItem(ifcVector);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VERTEX: {
			IfcVertex ifcVertex = (IfcVertex) theEObject;
			T result = caseIfcVertex(ifcVertex);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcVertex);
			if (result == null)
				result = caseIfcRepresentationItem(ifcVertex);
			if (result == null)
				result = caseIfcLayeredItem(ifcVertex);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VERTEX_BASED_TEXTURE_MAP: {
			IfcVertexBasedTextureMap ifcVertexBasedTextureMap = (IfcVertexBasedTextureMap) theEObject;
			T result = caseIfcVertexBasedTextureMap(ifcVertexBasedTextureMap);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VERTEX_LOOP: {
			IfcVertexLoop ifcVertexLoop = (IfcVertexLoop) theEObject;
			T result = caseIfcVertexLoop(ifcVertexLoop);
			if (result == null)
				result = caseIfcLoop(ifcVertexLoop);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcVertexLoop);
			if (result == null)
				result = caseIfcRepresentationItem(ifcVertexLoop);
			if (result == null)
				result = caseIfcLayeredItem(ifcVertexLoop);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VERTEX_POINT: {
			IfcVertexPoint ifcVertexPoint = (IfcVertexPoint) theEObject;
			T result = caseIfcVertexPoint(ifcVertexPoint);
			if (result == null)
				result = caseIfcVertex(ifcVertexPoint);
			if (result == null)
				result = caseIfcPointOrVertexPoint(ifcVertexPoint);
			if (result == null)
				result = caseIfcTopologicalRepresentationItem(ifcVertexPoint);
			if (result == null)
				result = caseIfcRepresentationItem(ifcVertexPoint);
			if (result == null)
				result = caseIfcLayeredItem(ifcVertexPoint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VIBRATION_ISOLATOR_TYPE: {
			IfcVibrationIsolatorType ifcVibrationIsolatorType = (IfcVibrationIsolatorType) theEObject;
			T result = caseIfcVibrationIsolatorType(ifcVibrationIsolatorType);
			if (result == null)
				result = caseIfcDiscreteAccessoryType(ifcVibrationIsolatorType);
			if (result == null)
				result = caseIfcElementComponentType(ifcVibrationIsolatorType);
			if (result == null)
				result = caseIfcElementType(ifcVibrationIsolatorType);
			if (result == null)
				result = caseIfcTypeProduct(ifcVibrationIsolatorType);
			if (result == null)
				result = caseIfcTypeObject(ifcVibrationIsolatorType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcVibrationIsolatorType);
			if (result == null)
				result = caseIfcRoot(ifcVibrationIsolatorType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VIRTUAL_ELEMENT: {
			IfcVirtualElement ifcVirtualElement = (IfcVirtualElement) theEObject;
			T result = caseIfcVirtualElement(ifcVirtualElement);
			if (result == null)
				result = caseIfcElement(ifcVirtualElement);
			if (result == null)
				result = caseIfcProduct(ifcVirtualElement);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcVirtualElement);
			if (result == null)
				result = caseIfcObject(ifcVirtualElement);
			if (result == null)
				result = caseIfcObjectDefinition(ifcVirtualElement);
			if (result == null)
				result = caseIfcRoot(ifcVirtualElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VIRTUAL_GRID_INTERSECTION: {
			IfcVirtualGridIntersection ifcVirtualGridIntersection = (IfcVirtualGridIntersection) theEObject;
			T result = caseIfcVirtualGridIntersection(ifcVirtualGridIntersection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WALL: {
			IfcWall ifcWall = (IfcWall) theEObject;
			T result = caseIfcWall(ifcWall);
			if (result == null)
				result = caseIfcBuildingElement(ifcWall);
			if (result == null)
				result = caseIfcElement(ifcWall);
			if (result == null)
				result = caseIfcProduct(ifcWall);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcWall);
			if (result == null)
				result = caseIfcObject(ifcWall);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWall);
			if (result == null)
				result = caseIfcRoot(ifcWall);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WALL_STANDARD_CASE: {
			IfcWallStandardCase ifcWallStandardCase = (IfcWallStandardCase) theEObject;
			T result = caseIfcWallStandardCase(ifcWallStandardCase);
			if (result == null)
				result = caseIfcWall(ifcWallStandardCase);
			if (result == null)
				result = caseIfcBuildingElement(ifcWallStandardCase);
			if (result == null)
				result = caseIfcElement(ifcWallStandardCase);
			if (result == null)
				result = caseIfcProduct(ifcWallStandardCase);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcWallStandardCase);
			if (result == null)
				result = caseIfcObject(ifcWallStandardCase);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWallStandardCase);
			if (result == null)
				result = caseIfcRoot(ifcWallStandardCase);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WALL_TYPE: {
			IfcWallType ifcWallType = (IfcWallType) theEObject;
			T result = caseIfcWallType(ifcWallType);
			if (result == null)
				result = caseIfcBuildingElementType(ifcWallType);
			if (result == null)
				result = caseIfcElementType(ifcWallType);
			if (result == null)
				result = caseIfcTypeProduct(ifcWallType);
			if (result == null)
				result = caseIfcTypeObject(ifcWallType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWallType);
			if (result == null)
				result = caseIfcRoot(ifcWallType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WASTE_TERMINAL_TYPE: {
			IfcWasteTerminalType ifcWasteTerminalType = (IfcWasteTerminalType) theEObject;
			T result = caseIfcWasteTerminalType(ifcWasteTerminalType);
			if (result == null)
				result = caseIfcFlowTerminalType(ifcWasteTerminalType);
			if (result == null)
				result = caseIfcDistributionFlowElementType(ifcWasteTerminalType);
			if (result == null)
				result = caseIfcDistributionElementType(ifcWasteTerminalType);
			if (result == null)
				result = caseIfcElementType(ifcWasteTerminalType);
			if (result == null)
				result = caseIfcTypeProduct(ifcWasteTerminalType);
			if (result == null)
				result = caseIfcTypeObject(ifcWasteTerminalType);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWasteTerminalType);
			if (result == null)
				result = caseIfcRoot(ifcWasteTerminalType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WATER_PROPERTIES: {
			IfcWaterProperties ifcWaterProperties = (IfcWaterProperties) theEObject;
			T result = caseIfcWaterProperties(ifcWaterProperties);
			if (result == null)
				result = caseIfcMaterialProperties(ifcWaterProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WINDOW: {
			IfcWindow ifcWindow = (IfcWindow) theEObject;
			T result = caseIfcWindow(ifcWindow);
			if (result == null)
				result = caseIfcBuildingElement(ifcWindow);
			if (result == null)
				result = caseIfcElement(ifcWindow);
			if (result == null)
				result = caseIfcProduct(ifcWindow);
			if (result == null)
				result = caseIfcStructuralActivityAssignmentSelect(ifcWindow);
			if (result == null)
				result = caseIfcObject(ifcWindow);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWindow);
			if (result == null)
				result = caseIfcRoot(ifcWindow);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WINDOW_LINING_PROPERTIES: {
			IfcWindowLiningProperties ifcWindowLiningProperties = (IfcWindowLiningProperties) theEObject;
			T result = caseIfcWindowLiningProperties(ifcWindowLiningProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcWindowLiningProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcWindowLiningProperties);
			if (result == null)
				result = caseIfcRoot(ifcWindowLiningProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WINDOW_PANEL_PROPERTIES: {
			IfcWindowPanelProperties ifcWindowPanelProperties = (IfcWindowPanelProperties) theEObject;
			T result = caseIfcWindowPanelProperties(ifcWindowPanelProperties);
			if (result == null)
				result = caseIfcPropertySetDefinition(ifcWindowPanelProperties);
			if (result == null)
				result = caseIfcPropertyDefinition(ifcWindowPanelProperties);
			if (result == null)
				result = caseIfcRoot(ifcWindowPanelProperties);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WINDOW_STYLE: {
			IfcWindowStyle ifcWindowStyle = (IfcWindowStyle) theEObject;
			T result = caseIfcWindowStyle(ifcWindowStyle);
			if (result == null)
				result = caseIfcTypeProduct(ifcWindowStyle);
			if (result == null)
				result = caseIfcTypeObject(ifcWindowStyle);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWindowStyle);
			if (result == null)
				result = caseIfcRoot(ifcWindowStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WORK_CONTROL: {
			IfcWorkControl ifcWorkControl = (IfcWorkControl) theEObject;
			T result = caseIfcWorkControl(ifcWorkControl);
			if (result == null)
				result = caseIfcControl(ifcWorkControl);
			if (result == null)
				result = caseIfcObject(ifcWorkControl);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWorkControl);
			if (result == null)
				result = caseIfcRoot(ifcWorkControl);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WORK_PLAN: {
			IfcWorkPlan ifcWorkPlan = (IfcWorkPlan) theEObject;
			T result = caseIfcWorkPlan(ifcWorkPlan);
			if (result == null)
				result = caseIfcWorkControl(ifcWorkPlan);
			if (result == null)
				result = caseIfcControl(ifcWorkPlan);
			if (result == null)
				result = caseIfcObject(ifcWorkPlan);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWorkPlan);
			if (result == null)
				result = caseIfcRoot(ifcWorkPlan);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WORK_SCHEDULE: {
			IfcWorkSchedule ifcWorkSchedule = (IfcWorkSchedule) theEObject;
			T result = caseIfcWorkSchedule(ifcWorkSchedule);
			if (result == null)
				result = caseIfcWorkControl(ifcWorkSchedule);
			if (result == null)
				result = caseIfcControl(ifcWorkSchedule);
			if (result == null)
				result = caseIfcObject(ifcWorkSchedule);
			if (result == null)
				result = caseIfcObjectDefinition(ifcWorkSchedule);
			if (result == null)
				result = caseIfcRoot(ifcWorkSchedule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ZSHAPE_PROFILE_DEF: {
			IfcZShapeProfileDef ifcZShapeProfileDef = (IfcZShapeProfileDef) theEObject;
			T result = caseIfcZShapeProfileDef(ifcZShapeProfileDef);
			if (result == null)
				result = caseIfcParameterizedProfileDef(ifcZShapeProfileDef);
			if (result == null)
				result = caseIfcProfileDef(ifcZShapeProfileDef);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ZONE: {
			IfcZone ifcZone = (IfcZone) theEObject;
			T result = caseIfcZone(ifcZone);
			if (result == null)
				result = caseIfcGroup(ifcZone);
			if (result == null)
				result = caseIfcObject(ifcZone);
			if (result == null)
				result = caseIfcObjectDefinition(ifcZone);
			if (result == null)
				result = caseIfcRoot(ifcZone);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ABSORBED_DOSE_MEASURE: {
			IfcAbsorbedDoseMeasure ifcAbsorbedDoseMeasure = (IfcAbsorbedDoseMeasure) theEObject;
			T result = caseIfcAbsorbedDoseMeasure(ifcAbsorbedDoseMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcAbsorbedDoseMeasure);
			if (result == null)
				result = caseIfcValue(ifcAbsorbedDoseMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ACCELERATION_MEASURE: {
			IfcAccelerationMeasure ifcAccelerationMeasure = (IfcAccelerationMeasure) theEObject;
			T result = caseIfcAccelerationMeasure(ifcAccelerationMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcAccelerationMeasure);
			if (result == null)
				result = caseIfcValue(ifcAccelerationMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AMOUNT_OF_SUBSTANCE_MEASURE: {
			IfcAmountOfSubstanceMeasure ifcAmountOfSubstanceMeasure = (IfcAmountOfSubstanceMeasure) theEObject;
			T result = caseIfcAmountOfSubstanceMeasure(ifcAmountOfSubstanceMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcAmountOfSubstanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcAmountOfSubstanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ANGULAR_VELOCITY_MEASURE: {
			IfcAngularVelocityMeasure ifcAngularVelocityMeasure = (IfcAngularVelocityMeasure) theEObject;
			T result = caseIfcAngularVelocityMeasure(ifcAngularVelocityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcAngularVelocityMeasure);
			if (result == null)
				result = caseIfcValue(ifcAngularVelocityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AREA_MEASURE: {
			IfcAreaMeasure ifcAreaMeasure = (IfcAreaMeasure) theEObject;
			T result = caseIfcAreaMeasure(ifcAreaMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcAreaMeasure);
			if (result == null)
				result = caseIfcValue(ifcAreaMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOOLEAN: {
			IfcBoolean ifcBoolean = (IfcBoolean) theEObject;
			T result = caseIfcBoolean(ifcBoolean);
			if (result == null)
				result = caseIfcSimpleValue(ifcBoolean);
			if (result == null)
				result = caseIfcValue(ifcBoolean);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONTEXT_DEPENDENT_MEASURE: {
			IfcContextDependentMeasure ifcContextDependentMeasure = (IfcContextDependentMeasure) theEObject;
			T result = caseIfcContextDependentMeasure(ifcContextDependentMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcContextDependentMeasure);
			if (result == null)
				result = caseIfcValue(ifcContextDependentMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COUNT_MEASURE: {
			IfcCountMeasure ifcCountMeasure = (IfcCountMeasure) theEObject;
			T result = caseIfcCountMeasure(ifcCountMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcCountMeasure);
			if (result == null)
				result = caseIfcValue(ifcCountMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVATURE_MEASURE: {
			IfcCurvatureMeasure ifcCurvatureMeasure = (IfcCurvatureMeasure) theEObject;
			T result = caseIfcCurvatureMeasure(ifcCurvatureMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcCurvatureMeasure);
			if (result == null)
				result = caseIfcValue(ifcCurvatureMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DAY_IN_MONTH_NUMBER: {
			IfcDayInMonthNumber ifcDayInMonthNumber = (IfcDayInMonthNumber) theEObject;
			T result = caseIfcDayInMonthNumber(ifcDayInMonthNumber);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DAYLIGHT_SAVING_HOUR: {
			IfcDaylightSavingHour ifcDaylightSavingHour = (IfcDaylightSavingHour) theEObject;
			T result = caseIfcDaylightSavingHour(ifcDaylightSavingHour);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DESCRIPTIVE_MEASURE: {
			IfcDescriptiveMeasure ifcDescriptiveMeasure = (IfcDescriptiveMeasure) theEObject;
			T result = caseIfcDescriptiveMeasure(ifcDescriptiveMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcDescriptiveMeasure);
			if (result == null)
				result = caseIfcSizeSelect(ifcDescriptiveMeasure);
			if (result == null)
				result = caseIfcValue(ifcDescriptiveMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DIMENSION_COUNT: {
			IfcDimensionCount ifcDimensionCount = (IfcDimensionCount) theEObject;
			T result = caseIfcDimensionCount(ifcDimensionCount);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOSE_EQUIVALENT_MEASURE: {
			IfcDoseEquivalentMeasure ifcDoseEquivalentMeasure = (IfcDoseEquivalentMeasure) theEObject;
			T result = caseIfcDoseEquivalentMeasure(ifcDoseEquivalentMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcDoseEquivalentMeasure);
			if (result == null)
				result = caseIfcValue(ifcDoseEquivalentMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DYNAMIC_VISCOSITY_MEASURE: {
			IfcDynamicViscosityMeasure ifcDynamicViscosityMeasure = (IfcDynamicViscosityMeasure) theEObject;
			T result = caseIfcDynamicViscosityMeasure(ifcDynamicViscosityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcDynamicViscosityMeasure);
			if (result == null)
				result = caseIfcValue(ifcDynamicViscosityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_CAPACITANCE_MEASURE: {
			IfcElectricCapacitanceMeasure ifcElectricCapacitanceMeasure = (IfcElectricCapacitanceMeasure) theEObject;
			T result = caseIfcElectricCapacitanceMeasure(ifcElectricCapacitanceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcElectricCapacitanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcElectricCapacitanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_CHARGE_MEASURE: {
			IfcElectricChargeMeasure ifcElectricChargeMeasure = (IfcElectricChargeMeasure) theEObject;
			T result = caseIfcElectricChargeMeasure(ifcElectricChargeMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcElectricChargeMeasure);
			if (result == null)
				result = caseIfcValue(ifcElectricChargeMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_CONDUCTANCE_MEASURE: {
			IfcElectricConductanceMeasure ifcElectricConductanceMeasure = (IfcElectricConductanceMeasure) theEObject;
			T result = caseIfcElectricConductanceMeasure(ifcElectricConductanceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcElectricConductanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcElectricConductanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_CURRENT_MEASURE: {
			IfcElectricCurrentMeasure ifcElectricCurrentMeasure = (IfcElectricCurrentMeasure) theEObject;
			T result = caseIfcElectricCurrentMeasure(ifcElectricCurrentMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcElectricCurrentMeasure);
			if (result == null)
				result = caseIfcValue(ifcElectricCurrentMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_RESISTANCE_MEASURE: {
			IfcElectricResistanceMeasure ifcElectricResistanceMeasure = (IfcElectricResistanceMeasure) theEObject;
			T result = caseIfcElectricResistanceMeasure(ifcElectricResistanceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcElectricResistanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcElectricResistanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ELECTRIC_VOLTAGE_MEASURE: {
			IfcElectricVoltageMeasure ifcElectricVoltageMeasure = (IfcElectricVoltageMeasure) theEObject;
			T result = caseIfcElectricVoltageMeasure(ifcElectricVoltageMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcElectricVoltageMeasure);
			if (result == null)
				result = caseIfcValue(ifcElectricVoltageMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ENERGY_MEASURE: {
			IfcEnergyMeasure ifcEnergyMeasure = (IfcEnergyMeasure) theEObject;
			T result = caseIfcEnergyMeasure(ifcEnergyMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcEnergyMeasure);
			if (result == null)
				result = caseIfcValue(ifcEnergyMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FONT_STYLE: {
			IfcFontStyle ifcFontStyle = (IfcFontStyle) theEObject;
			T result = caseIfcFontStyle(ifcFontStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FONT_VARIANT: {
			IfcFontVariant ifcFontVariant = (IfcFontVariant) theEObject;
			T result = caseIfcFontVariant(ifcFontVariant);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FONT_WEIGHT: {
			IfcFontWeight ifcFontWeight = (IfcFontWeight) theEObject;
			T result = caseIfcFontWeight(ifcFontWeight);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FORCE_MEASURE: {
			IfcForceMeasure ifcForceMeasure = (IfcForceMeasure) theEObject;
			T result = caseIfcForceMeasure(ifcForceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcForceMeasure);
			if (result == null)
				result = caseIfcValue(ifcForceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FREQUENCY_MEASURE: {
			IfcFrequencyMeasure ifcFrequencyMeasure = (IfcFrequencyMeasure) theEObject;
			T result = caseIfcFrequencyMeasure(ifcFrequencyMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcFrequencyMeasure);
			if (result == null)
				result = caseIfcValue(ifcFrequencyMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GLOBALLY_UNIQUE_ID: {
			IfcGloballyUniqueId ifcGloballyUniqueId = (IfcGloballyUniqueId) theEObject;
			T result = caseIfcGloballyUniqueId(ifcGloballyUniqueId);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_HEAT_FLUX_DENSITY_MEASURE: {
			IfcHeatFluxDensityMeasure ifcHeatFluxDensityMeasure = (IfcHeatFluxDensityMeasure) theEObject;
			T result = caseIfcHeatFluxDensityMeasure(ifcHeatFluxDensityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcHeatFluxDensityMeasure);
			if (result == null)
				result = caseIfcValue(ifcHeatFluxDensityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_HEATING_VALUE_MEASURE: {
			IfcHeatingValueMeasure ifcHeatingValueMeasure = (IfcHeatingValueMeasure) theEObject;
			T result = caseIfcHeatingValueMeasure(ifcHeatingValueMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcHeatingValueMeasure);
			if (result == null)
				result = caseIfcValue(ifcHeatingValueMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_HOUR_IN_DAY: {
			IfcHourInDay ifcHourInDay = (IfcHourInDay) theEObject;
			T result = caseIfcHourInDay(ifcHourInDay);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_IDENTIFIER: {
			IfcIdentifier ifcIdentifier = (IfcIdentifier) theEObject;
			T result = caseIfcIdentifier(ifcIdentifier);
			if (result == null)
				result = caseIfcSimpleValue(ifcIdentifier);
			if (result == null)
				result = caseIfcValue(ifcIdentifier);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ILLUMINANCE_MEASURE: {
			IfcIlluminanceMeasure ifcIlluminanceMeasure = (IfcIlluminanceMeasure) theEObject;
			T result = caseIfcIlluminanceMeasure(ifcIlluminanceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcIlluminanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcIlluminanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_INDUCTANCE_MEASURE: {
			IfcInductanceMeasure ifcInductanceMeasure = (IfcInductanceMeasure) theEObject;
			T result = caseIfcInductanceMeasure(ifcInductanceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcInductanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcInductanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_INTEGER: {
			IfcInteger ifcInteger = (IfcInteger) theEObject;
			T result = caseIfcInteger(ifcInteger);
			if (result == null)
				result = caseIfcSimpleValue(ifcInteger);
			if (result == null)
				result = caseIfcValue(ifcInteger);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_INTEGER_COUNT_RATE_MEASURE: {
			IfcIntegerCountRateMeasure ifcIntegerCountRateMeasure = (IfcIntegerCountRateMeasure) theEObject;
			T result = caseIfcIntegerCountRateMeasure(ifcIntegerCountRateMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcIntegerCountRateMeasure);
			if (result == null)
				result = caseIfcValue(ifcIntegerCountRateMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ION_CONCENTRATION_MEASURE: {
			IfcIonConcentrationMeasure ifcIonConcentrationMeasure = (IfcIonConcentrationMeasure) theEObject;
			T result = caseIfcIonConcentrationMeasure(ifcIonConcentrationMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcIonConcentrationMeasure);
			if (result == null)
				result = caseIfcValue(ifcIonConcentrationMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ISOTHERMAL_MOISTURE_CAPACITY_MEASURE: {
			IfcIsothermalMoistureCapacityMeasure ifcIsothermalMoistureCapacityMeasure = (IfcIsothermalMoistureCapacityMeasure) theEObject;
			T result = caseIfcIsothermalMoistureCapacityMeasure(ifcIsothermalMoistureCapacityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcIsothermalMoistureCapacityMeasure);
			if (result == null)
				result = caseIfcValue(ifcIsothermalMoistureCapacityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_KINEMATIC_VISCOSITY_MEASURE: {
			IfcKinematicViscosityMeasure ifcKinematicViscosityMeasure = (IfcKinematicViscosityMeasure) theEObject;
			T result = caseIfcKinematicViscosityMeasure(ifcKinematicViscosityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcKinematicViscosityMeasure);
			if (result == null)
				result = caseIfcValue(ifcKinematicViscosityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LABEL: {
			IfcLabel ifcLabel = (IfcLabel) theEObject;
			T result = caseIfcLabel(ifcLabel);
			if (result == null)
				result = caseIfcConditionCriterionSelect(ifcLabel);
			if (result == null)
				result = caseIfcSimpleValue(ifcLabel);
			if (result == null)
				result = caseIfcValue(ifcLabel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LENGTH_MEASURE: {
			IfcLengthMeasure ifcLengthMeasure = (IfcLengthMeasure) theEObject;
			T result = caseIfcLengthMeasure(ifcLengthMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcLengthMeasure);
			if (result == null)
				result = caseIfcSizeSelect(ifcLengthMeasure);
			if (result == null)
				result = caseIfcValue(ifcLengthMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LINEAR_FORCE_MEASURE: {
			IfcLinearForceMeasure ifcLinearForceMeasure = (IfcLinearForceMeasure) theEObject;
			T result = caseIfcLinearForceMeasure(ifcLinearForceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcLinearForceMeasure);
			if (result == null)
				result = caseIfcValue(ifcLinearForceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LINEAR_MOMENT_MEASURE: {
			IfcLinearMomentMeasure ifcLinearMomentMeasure = (IfcLinearMomentMeasure) theEObject;
			T result = caseIfcLinearMomentMeasure(ifcLinearMomentMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcLinearMomentMeasure);
			if (result == null)
				result = caseIfcValue(ifcLinearMomentMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LINEAR_STIFFNESS_MEASURE: {
			IfcLinearStiffnessMeasure ifcLinearStiffnessMeasure = (IfcLinearStiffnessMeasure) theEObject;
			T result = caseIfcLinearStiffnessMeasure(ifcLinearStiffnessMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcLinearStiffnessMeasure);
			if (result == null)
				result = caseIfcValue(ifcLinearStiffnessMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LINEAR_VELOCITY_MEASURE: {
			IfcLinearVelocityMeasure ifcLinearVelocityMeasure = (IfcLinearVelocityMeasure) theEObject;
			T result = caseIfcLinearVelocityMeasure(ifcLinearVelocityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcLinearVelocityMeasure);
			if (result == null)
				result = caseIfcValue(ifcLinearVelocityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LOGICAL: {
			IfcLogical ifcLogical = (IfcLogical) theEObject;
			T result = caseIfcLogical(ifcLogical);
			if (result == null)
				result = caseIfcSimpleValue(ifcLogical);
			if (result == null)
				result = caseIfcValue(ifcLogical);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LUMINOUS_FLUX_MEASURE: {
			IfcLuminousFluxMeasure ifcLuminousFluxMeasure = (IfcLuminousFluxMeasure) theEObject;
			T result = caseIfcLuminousFluxMeasure(ifcLuminousFluxMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcLuminousFluxMeasure);
			if (result == null)
				result = caseIfcValue(ifcLuminousFluxMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LUMINOUS_INTENSITY_DISTRIBUTION_MEASURE: {
			IfcLuminousIntensityDistributionMeasure ifcLuminousIntensityDistributionMeasure = (IfcLuminousIntensityDistributionMeasure) theEObject;
			T result = caseIfcLuminousIntensityDistributionMeasure(ifcLuminousIntensityDistributionMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcLuminousIntensityDistributionMeasure);
			if (result == null)
				result = caseIfcValue(ifcLuminousIntensityDistributionMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LUMINOUS_INTENSITY_MEASURE: {
			IfcLuminousIntensityMeasure ifcLuminousIntensityMeasure = (IfcLuminousIntensityMeasure) theEObject;
			T result = caseIfcLuminousIntensityMeasure(ifcLuminousIntensityMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcLuminousIntensityMeasure);
			if (result == null)
				result = caseIfcValue(ifcLuminousIntensityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MAGNETIC_FLUX_DENSITY_MEASURE: {
			IfcMagneticFluxDensityMeasure ifcMagneticFluxDensityMeasure = (IfcMagneticFluxDensityMeasure) theEObject;
			T result = caseIfcMagneticFluxDensityMeasure(ifcMagneticFluxDensityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMagneticFluxDensityMeasure);
			if (result == null)
				result = caseIfcValue(ifcMagneticFluxDensityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MAGNETIC_FLUX_MEASURE: {
			IfcMagneticFluxMeasure ifcMagneticFluxMeasure = (IfcMagneticFluxMeasure) theEObject;
			T result = caseIfcMagneticFluxMeasure(ifcMagneticFluxMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMagneticFluxMeasure);
			if (result == null)
				result = caseIfcValue(ifcMagneticFluxMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MASS_DENSITY_MEASURE: {
			IfcMassDensityMeasure ifcMassDensityMeasure = (IfcMassDensityMeasure) theEObject;
			T result = caseIfcMassDensityMeasure(ifcMassDensityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMassDensityMeasure);
			if (result == null)
				result = caseIfcValue(ifcMassDensityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MASS_FLOW_RATE_MEASURE: {
			IfcMassFlowRateMeasure ifcMassFlowRateMeasure = (IfcMassFlowRateMeasure) theEObject;
			T result = caseIfcMassFlowRateMeasure(ifcMassFlowRateMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMassFlowRateMeasure);
			if (result == null)
				result = caseIfcValue(ifcMassFlowRateMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MASS_MEASURE: {
			IfcMassMeasure ifcMassMeasure = (IfcMassMeasure) theEObject;
			T result = caseIfcMassMeasure(ifcMassMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcMassMeasure);
			if (result == null)
				result = caseIfcValue(ifcMassMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MASS_PER_LENGTH_MEASURE: {
			IfcMassPerLengthMeasure ifcMassPerLengthMeasure = (IfcMassPerLengthMeasure) theEObject;
			T result = caseIfcMassPerLengthMeasure(ifcMassPerLengthMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMassPerLengthMeasure);
			if (result == null)
				result = caseIfcValue(ifcMassPerLengthMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MINUTE_IN_HOUR: {
			IfcMinuteInHour ifcMinuteInHour = (IfcMinuteInHour) theEObject;
			T result = caseIfcMinuteInHour(ifcMinuteInHour);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MODULUS_OF_ELASTICITY_MEASURE: {
			IfcModulusOfElasticityMeasure ifcModulusOfElasticityMeasure = (IfcModulusOfElasticityMeasure) theEObject;
			T result = caseIfcModulusOfElasticityMeasure(ifcModulusOfElasticityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcModulusOfElasticityMeasure);
			if (result == null)
				result = caseIfcValue(ifcModulusOfElasticityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MODULUS_OF_LINEAR_SUBGRADE_REACTION_MEASURE: {
			IfcModulusOfLinearSubgradeReactionMeasure ifcModulusOfLinearSubgradeReactionMeasure = (IfcModulusOfLinearSubgradeReactionMeasure) theEObject;
			T result = caseIfcModulusOfLinearSubgradeReactionMeasure(ifcModulusOfLinearSubgradeReactionMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcModulusOfLinearSubgradeReactionMeasure);
			if (result == null)
				result = caseIfcValue(ifcModulusOfLinearSubgradeReactionMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MODULUS_OF_ROTATIONAL_SUBGRADE_REACTION_MEASURE: {
			IfcModulusOfRotationalSubgradeReactionMeasure ifcModulusOfRotationalSubgradeReactionMeasure = (IfcModulusOfRotationalSubgradeReactionMeasure) theEObject;
			T result = caseIfcModulusOfRotationalSubgradeReactionMeasure(ifcModulusOfRotationalSubgradeReactionMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcModulusOfRotationalSubgradeReactionMeasure);
			if (result == null)
				result = caseIfcValue(ifcModulusOfRotationalSubgradeReactionMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MODULUS_OF_SUBGRADE_REACTION_MEASURE: {
			IfcModulusOfSubgradeReactionMeasure ifcModulusOfSubgradeReactionMeasure = (IfcModulusOfSubgradeReactionMeasure) theEObject;
			T result = caseIfcModulusOfSubgradeReactionMeasure(ifcModulusOfSubgradeReactionMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcModulusOfSubgradeReactionMeasure);
			if (result == null)
				result = caseIfcValue(ifcModulusOfSubgradeReactionMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MOISTURE_DIFFUSIVITY_MEASURE: {
			IfcMoistureDiffusivityMeasure ifcMoistureDiffusivityMeasure = (IfcMoistureDiffusivityMeasure) theEObject;
			T result = caseIfcMoistureDiffusivityMeasure(ifcMoistureDiffusivityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMoistureDiffusivityMeasure);
			if (result == null)
				result = caseIfcValue(ifcMoistureDiffusivityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MOLECULAR_WEIGHT_MEASURE: {
			IfcMolecularWeightMeasure ifcMolecularWeightMeasure = (IfcMolecularWeightMeasure) theEObject;
			T result = caseIfcMolecularWeightMeasure(ifcMolecularWeightMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMolecularWeightMeasure);
			if (result == null)
				result = caseIfcValue(ifcMolecularWeightMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MOMENT_OF_INERTIA_MEASURE: {
			IfcMomentOfInertiaMeasure ifcMomentOfInertiaMeasure = (IfcMomentOfInertiaMeasure) theEObject;
			T result = caseIfcMomentOfInertiaMeasure(ifcMomentOfInertiaMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMomentOfInertiaMeasure);
			if (result == null)
				result = caseIfcValue(ifcMomentOfInertiaMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MONETARY_MEASURE: {
			IfcMonetaryMeasure ifcMonetaryMeasure = (IfcMonetaryMeasure) theEObject;
			T result = caseIfcMonetaryMeasure(ifcMonetaryMeasure);
			if (result == null)
				result = caseIfcAppliedValueSelect(ifcMonetaryMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcMonetaryMeasure);
			if (result == null)
				result = caseIfcValue(ifcMonetaryMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MONTH_IN_YEAR_NUMBER: {
			IfcMonthInYearNumber ifcMonthInYearNumber = (IfcMonthInYearNumber) theEObject;
			T result = caseIfcMonthInYearNumber(ifcMonthInYearNumber);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_NUMERIC_MEASURE: {
			IfcNumericMeasure ifcNumericMeasure = (IfcNumericMeasure) theEObject;
			T result = caseIfcNumericMeasure(ifcNumericMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcNumericMeasure);
			if (result == null)
				result = caseIfcValue(ifcNumericMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PH_MEASURE: {
			IfcPHMeasure ifcPHMeasure = (IfcPHMeasure) theEObject;
			T result = caseIfcPHMeasure(ifcPHMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcPHMeasure);
			if (result == null)
				result = caseIfcValue(ifcPHMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PARAMETER_VALUE: {
			IfcParameterValue ifcParameterValue = (IfcParameterValue) theEObject;
			T result = caseIfcParameterValue(ifcParameterValue);
			if (result == null)
				result = caseIfcMeasureValue(ifcParameterValue);
			if (result == null)
				result = caseIfcTrimmingSelect(ifcParameterValue);
			if (result == null)
				result = caseIfcValue(ifcParameterValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PLANAR_FORCE_MEASURE: {
			IfcPlanarForceMeasure ifcPlanarForceMeasure = (IfcPlanarForceMeasure) theEObject;
			T result = caseIfcPlanarForceMeasure(ifcPlanarForceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcPlanarForceMeasure);
			if (result == null)
				result = caseIfcValue(ifcPlanarForceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PLANE_ANGLE_MEASURE: {
			IfcPlaneAngleMeasure ifcPlaneAngleMeasure = (IfcPlaneAngleMeasure) theEObject;
			T result = caseIfcPlaneAngleMeasure(ifcPlaneAngleMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcPlaneAngleMeasure);
			if (result == null)
				result = caseIfcOrientationSelect(ifcPlaneAngleMeasure);
			if (result == null)
				result = caseIfcValue(ifcPlaneAngleMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POWER_MEASURE: {
			IfcPowerMeasure ifcPowerMeasure = (IfcPowerMeasure) theEObject;
			T result = caseIfcPowerMeasure(ifcPowerMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcPowerMeasure);
			if (result == null)
				result = caseIfcValue(ifcPowerMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRESENTABLE_TEXT: {
			IfcPresentableText ifcPresentableText = (IfcPresentableText) theEObject;
			T result = caseIfcPresentableText(ifcPresentableText);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRESSURE_MEASURE: {
			IfcPressureMeasure ifcPressureMeasure = (IfcPressureMeasure) theEObject;
			T result = caseIfcPressureMeasure(ifcPressureMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcPressureMeasure);
			if (result == null)
				result = caseIfcValue(ifcPressureMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RADIO_ACTIVITY_MEASURE: {
			IfcRadioActivityMeasure ifcRadioActivityMeasure = (IfcRadioActivityMeasure) theEObject;
			T result = caseIfcRadioActivityMeasure(ifcRadioActivityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcRadioActivityMeasure);
			if (result == null)
				result = caseIfcValue(ifcRadioActivityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_RATIO_MEASURE: {
			IfcRatioMeasure ifcRatioMeasure = (IfcRatioMeasure) theEObject;
			T result = caseIfcRatioMeasure(ifcRatioMeasure);
			if (result == null)
				result = caseIfcAppliedValueSelect(ifcRatioMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcRatioMeasure);
			if (result == null)
				result = caseIfcSizeSelect(ifcRatioMeasure);
			if (result == null)
				result = caseIfcValue(ifcRatioMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_REAL: {
			IfcReal ifcReal = (IfcReal) theEObject;
			T result = caseIfcReal(ifcReal);
			if (result == null)
				result = caseIfcSimpleValue(ifcReal);
			if (result == null)
				result = caseIfcValue(ifcReal);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ROTATIONAL_FREQUENCY_MEASURE: {
			IfcRotationalFrequencyMeasure ifcRotationalFrequencyMeasure = (IfcRotationalFrequencyMeasure) theEObject;
			T result = caseIfcRotationalFrequencyMeasure(ifcRotationalFrequencyMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcRotationalFrequencyMeasure);
			if (result == null)
				result = caseIfcValue(ifcRotationalFrequencyMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ROTATIONAL_MASS_MEASURE: {
			IfcRotationalMassMeasure ifcRotationalMassMeasure = (IfcRotationalMassMeasure) theEObject;
			T result = caseIfcRotationalMassMeasure(ifcRotationalMassMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcRotationalMassMeasure);
			if (result == null)
				result = caseIfcValue(ifcRotationalMassMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ROTATIONAL_STIFFNESS_MEASURE: {
			IfcRotationalStiffnessMeasure ifcRotationalStiffnessMeasure = (IfcRotationalStiffnessMeasure) theEObject;
			T result = caseIfcRotationalStiffnessMeasure(ifcRotationalStiffnessMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcRotationalStiffnessMeasure);
			if (result == null)
				result = caseIfcValue(ifcRotationalStiffnessMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SECOND_IN_MINUTE: {
			IfcSecondInMinute ifcSecondInMinute = (IfcSecondInMinute) theEObject;
			T result = caseIfcSecondInMinute(ifcSecondInMinute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SECTION_MODULUS_MEASURE: {
			IfcSectionModulusMeasure ifcSectionModulusMeasure = (IfcSectionModulusMeasure) theEObject;
			T result = caseIfcSectionModulusMeasure(ifcSectionModulusMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcSectionModulusMeasure);
			if (result == null)
				result = caseIfcValue(ifcSectionModulusMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SECTIONAL_AREA_INTEGRAL_MEASURE: {
			IfcSectionalAreaIntegralMeasure ifcSectionalAreaIntegralMeasure = (IfcSectionalAreaIntegralMeasure) theEObject;
			T result = caseIfcSectionalAreaIntegralMeasure(ifcSectionalAreaIntegralMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcSectionalAreaIntegralMeasure);
			if (result == null)
				result = caseIfcValue(ifcSectionalAreaIntegralMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SHEAR_MODULUS_MEASURE: {
			IfcShearModulusMeasure ifcShearModulusMeasure = (IfcShearModulusMeasure) theEObject;
			T result = caseIfcShearModulusMeasure(ifcShearModulusMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcShearModulusMeasure);
			if (result == null)
				result = caseIfcValue(ifcShearModulusMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SOLID_ANGLE_MEASURE: {
			IfcSolidAngleMeasure ifcSolidAngleMeasure = (IfcSolidAngleMeasure) theEObject;
			T result = caseIfcSolidAngleMeasure(ifcSolidAngleMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcSolidAngleMeasure);
			if (result == null)
				result = caseIfcValue(ifcSolidAngleMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SOUND_POWER_MEASURE: {
			IfcSoundPowerMeasure ifcSoundPowerMeasure = (IfcSoundPowerMeasure) theEObject;
			T result = caseIfcSoundPowerMeasure(ifcSoundPowerMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcSoundPowerMeasure);
			if (result == null)
				result = caseIfcValue(ifcSoundPowerMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SOUND_PRESSURE_MEASURE: {
			IfcSoundPressureMeasure ifcSoundPressureMeasure = (IfcSoundPressureMeasure) theEObject;
			T result = caseIfcSoundPressureMeasure(ifcSoundPressureMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcSoundPressureMeasure);
			if (result == null)
				result = caseIfcValue(ifcSoundPressureMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPECIFIC_HEAT_CAPACITY_MEASURE: {
			IfcSpecificHeatCapacityMeasure ifcSpecificHeatCapacityMeasure = (IfcSpecificHeatCapacityMeasure) theEObject;
			T result = caseIfcSpecificHeatCapacityMeasure(ifcSpecificHeatCapacityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcSpecificHeatCapacityMeasure);
			if (result == null)
				result = caseIfcValue(ifcSpecificHeatCapacityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPECULAR_EXPONENT: {
			IfcSpecularExponent ifcSpecularExponent = (IfcSpecularExponent) theEObject;
			T result = caseIfcSpecularExponent(ifcSpecularExponent);
			if (result == null)
				result = caseIfcSpecularHighlightSelect(ifcSpecularExponent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPECULAR_ROUGHNESS: {
			IfcSpecularRoughness ifcSpecularRoughness = (IfcSpecularRoughness) theEObject;
			T result = caseIfcSpecularRoughness(ifcSpecularRoughness);
			if (result == null)
				result = caseIfcSpecularHighlightSelect(ifcSpecularRoughness);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEMPERATURE_GRADIENT_MEASURE: {
			IfcTemperatureGradientMeasure ifcTemperatureGradientMeasure = (IfcTemperatureGradientMeasure) theEObject;
			T result = caseIfcTemperatureGradientMeasure(ifcTemperatureGradientMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcTemperatureGradientMeasure);
			if (result == null)
				result = caseIfcValue(ifcTemperatureGradientMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT: {
			IfcText ifcText = (IfcText) theEObject;
			T result = caseIfcText(ifcText);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcText);
			if (result == null)
				result = caseIfcSimpleValue(ifcText);
			if (result == null)
				result = caseIfcValue(ifcText);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_ALIGNMENT: {
			IfcTextAlignment ifcTextAlignment = (IfcTextAlignment) theEObject;
			T result = caseIfcTextAlignment(ifcTextAlignment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_DECORATION: {
			IfcTextDecoration ifcTextDecoration = (IfcTextDecoration) theEObject;
			T result = caseIfcTextDecoration(ifcTextDecoration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_FONT_NAME: {
			IfcTextFontName ifcTextFontName = (IfcTextFontName) theEObject;
			T result = caseIfcTextFontName(ifcTextFontName);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_TRANSFORMATION: {
			IfcTextTransformation ifcTextTransformation = (IfcTextTransformation) theEObject;
			T result = caseIfcTextTransformation(ifcTextTransformation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_THERMAL_ADMITTANCE_MEASURE: {
			IfcThermalAdmittanceMeasure ifcThermalAdmittanceMeasure = (IfcThermalAdmittanceMeasure) theEObject;
			T result = caseIfcThermalAdmittanceMeasure(ifcThermalAdmittanceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcThermalAdmittanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcThermalAdmittanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_THERMAL_CONDUCTIVITY_MEASURE: {
			IfcThermalConductivityMeasure ifcThermalConductivityMeasure = (IfcThermalConductivityMeasure) theEObject;
			T result = caseIfcThermalConductivityMeasure(ifcThermalConductivityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcThermalConductivityMeasure);
			if (result == null)
				result = caseIfcValue(ifcThermalConductivityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_THERMAL_EXPANSION_COEFFICIENT_MEASURE: {
			IfcThermalExpansionCoefficientMeasure ifcThermalExpansionCoefficientMeasure = (IfcThermalExpansionCoefficientMeasure) theEObject;
			T result = caseIfcThermalExpansionCoefficientMeasure(ifcThermalExpansionCoefficientMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcThermalExpansionCoefficientMeasure);
			if (result == null)
				result = caseIfcValue(ifcThermalExpansionCoefficientMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_THERMAL_RESISTANCE_MEASURE: {
			IfcThermalResistanceMeasure ifcThermalResistanceMeasure = (IfcThermalResistanceMeasure) theEObject;
			T result = caseIfcThermalResistanceMeasure(ifcThermalResistanceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcThermalResistanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcThermalResistanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_THERMAL_TRANSMITTANCE_MEASURE: {
			IfcThermalTransmittanceMeasure ifcThermalTransmittanceMeasure = (IfcThermalTransmittanceMeasure) theEObject;
			T result = caseIfcThermalTransmittanceMeasure(ifcThermalTransmittanceMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcThermalTransmittanceMeasure);
			if (result == null)
				result = caseIfcValue(ifcThermalTransmittanceMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_THERMODYNAMIC_TEMPERATURE_MEASURE: {
			IfcThermodynamicTemperatureMeasure ifcThermodynamicTemperatureMeasure = (IfcThermodynamicTemperatureMeasure) theEObject;
			T result = caseIfcThermodynamicTemperatureMeasure(ifcThermodynamicTemperatureMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcThermodynamicTemperatureMeasure);
			if (result == null)
				result = caseIfcValue(ifcThermodynamicTemperatureMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TIME_MEASURE: {
			IfcTimeMeasure ifcTimeMeasure = (IfcTimeMeasure) theEObject;
			T result = caseIfcTimeMeasure(ifcTimeMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcTimeMeasure);
			if (result == null)
				result = caseIfcValue(ifcTimeMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TIME_STAMP: {
			IfcTimeStamp ifcTimeStamp = (IfcTimeStamp) theEObject;
			T result = caseIfcTimeStamp(ifcTimeStamp);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcTimeStamp);
			if (result == null)
				result = caseIfcValue(ifcTimeStamp);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TORQUE_MEASURE: {
			IfcTorqueMeasure ifcTorqueMeasure = (IfcTorqueMeasure) theEObject;
			T result = caseIfcTorqueMeasure(ifcTorqueMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcTorqueMeasure);
			if (result == null)
				result = caseIfcValue(ifcTorqueMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VAPOR_PERMEABILITY_MEASURE: {
			IfcVaporPermeabilityMeasure ifcVaporPermeabilityMeasure = (IfcVaporPermeabilityMeasure) theEObject;
			T result = caseIfcVaporPermeabilityMeasure(ifcVaporPermeabilityMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcVaporPermeabilityMeasure);
			if (result == null)
				result = caseIfcValue(ifcVaporPermeabilityMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VOLUME_MEASURE: {
			IfcVolumeMeasure ifcVolumeMeasure = (IfcVolumeMeasure) theEObject;
			T result = caseIfcVolumeMeasure(ifcVolumeMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcVolumeMeasure);
			if (result == null)
				result = caseIfcValue(ifcVolumeMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VOLUMETRIC_FLOW_RATE_MEASURE: {
			IfcVolumetricFlowRateMeasure ifcVolumetricFlowRateMeasure = (IfcVolumetricFlowRateMeasure) theEObject;
			T result = caseIfcVolumetricFlowRateMeasure(ifcVolumetricFlowRateMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcVolumetricFlowRateMeasure);
			if (result == null)
				result = caseIfcValue(ifcVolumetricFlowRateMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WARPING_CONSTANT_MEASURE: {
			IfcWarpingConstantMeasure ifcWarpingConstantMeasure = (IfcWarpingConstantMeasure) theEObject;
			T result = caseIfcWarpingConstantMeasure(ifcWarpingConstantMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcWarpingConstantMeasure);
			if (result == null)
				result = caseIfcValue(ifcWarpingConstantMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_WARPING_MOMENT_MEASURE: {
			IfcWarpingMomentMeasure ifcWarpingMomentMeasure = (IfcWarpingMomentMeasure) theEObject;
			T result = caseIfcWarpingMomentMeasure(ifcWarpingMomentMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcWarpingMomentMeasure);
			if (result == null)
				result = caseIfcValue(ifcWarpingMomentMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_YEAR_NUMBER: {
			IfcYearNumber ifcYearNumber = (IfcYearNumber) theEObject;
			T result = caseIfcYearNumber(ifcYearNumber);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOX_ALIGNMENT: {
			IfcBoxAlignment ifcBoxAlignment = (IfcBoxAlignment) theEObject;
			T result = caseIfcBoxAlignment(ifcBoxAlignment);
			if (result == null)
				result = caseIfcLabel(ifcBoxAlignment);
			if (result == null)
				result = caseIfcConditionCriterionSelect(ifcBoxAlignment);
			if (result == null)
				result = caseIfcSimpleValue(ifcBoxAlignment);
			if (result == null)
				result = caseIfcValue(ifcBoxAlignment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COMPOUND_PLANE_ANGLE_MEASURE: {
			IfcCompoundPlaneAngleMeasure ifcCompoundPlaneAngleMeasure = (IfcCompoundPlaneAngleMeasure) theEObject;
			T result = caseIfcCompoundPlaneAngleMeasure(ifcCompoundPlaneAngleMeasure);
			if (result == null)
				result = caseIfcDerivedMeasureValue(ifcCompoundPlaneAngleMeasure);
			if (result == null)
				result = caseIfcValue(ifcCompoundPlaneAngleMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_NORMALISED_RATIO_MEASURE: {
			IfcNormalisedRatioMeasure ifcNormalisedRatioMeasure = (IfcNormalisedRatioMeasure) theEObject;
			T result = caseIfcNormalisedRatioMeasure(ifcNormalisedRatioMeasure);
			if (result == null)
				result = caseIfcRatioMeasure(ifcNormalisedRatioMeasure);
			if (result == null)
				result = caseIfcColourOrFactor(ifcNormalisedRatioMeasure);
			if (result == null)
				result = caseIfcAppliedValueSelect(ifcNormalisedRatioMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcNormalisedRatioMeasure);
			if (result == null)
				result = caseIfcSizeSelect(ifcNormalisedRatioMeasure);
			if (result == null)
				result = caseIfcValue(ifcNormalisedRatioMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POSITIVE_LENGTH_MEASURE: {
			IfcPositiveLengthMeasure ifcPositiveLengthMeasure = (IfcPositiveLengthMeasure) theEObject;
			T result = caseIfcPositiveLengthMeasure(ifcPositiveLengthMeasure);
			if (result == null)
				result = caseIfcLengthMeasure(ifcPositiveLengthMeasure);
			if (result == null)
				result = caseIfcHatchLineDistanceSelect(ifcPositiveLengthMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcPositiveLengthMeasure);
			if (result == null)
				result = caseIfcSizeSelect(ifcPositiveLengthMeasure);
			if (result == null)
				result = caseIfcValue(ifcPositiveLengthMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POSITIVE_PLANE_ANGLE_MEASURE: {
			IfcPositivePlaneAngleMeasure ifcPositivePlaneAngleMeasure = (IfcPositivePlaneAngleMeasure) theEObject;
			T result = caseIfcPositivePlaneAngleMeasure(ifcPositivePlaneAngleMeasure);
			if (result == null)
				result = caseIfcPlaneAngleMeasure(ifcPositivePlaneAngleMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcPositivePlaneAngleMeasure);
			if (result == null)
				result = caseIfcOrientationSelect(ifcPositivePlaneAngleMeasure);
			if (result == null)
				result = caseIfcValue(ifcPositivePlaneAngleMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POSITIVE_RATIO_MEASURE: {
			IfcPositiveRatioMeasure ifcPositiveRatioMeasure = (IfcPositiveRatioMeasure) theEObject;
			T result = caseIfcPositiveRatioMeasure(ifcPositiveRatioMeasure);
			if (result == null)
				result = caseIfcRatioMeasure(ifcPositiveRatioMeasure);
			if (result == null)
				result = caseIfcAppliedValueSelect(ifcPositiveRatioMeasure);
			if (result == null)
				result = caseIfcMeasureValue(ifcPositiveRatioMeasure);
			if (result == null)
				result = caseIfcSizeSelect(ifcPositiveRatioMeasure);
			if (result == null)
				result = caseIfcValue(ifcPositiveRatioMeasure);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COMPLEX_NUMBER: {
			IfcComplexNumber ifcComplexNumber = (IfcComplexNumber) theEObject;
			T result = caseIfcComplexNumber(ifcComplexNumber);
			if (result == null)
				result = caseIfcMeasureValue(ifcComplexNumber);
			if (result == null)
				result = caseIfcValue(ifcComplexNumber);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_NULL_STYLE: {
			IfcNullStyle ifcNullStyle = (IfcNullStyle) theEObject;
			T result = caseIfcNullStyle(ifcNullStyle);
			if (result == null)
				result = caseIfcPresentationStyleSelect(ifcNullStyle);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ACTOR_SELECT: {
			IfcActorSelect ifcActorSelect = (IfcActorSelect) theEObject;
			T result = caseIfcActorSelect(ifcActorSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_APPLIED_VALUE_SELECT: {
			IfcAppliedValueSelect ifcAppliedValueSelect = (IfcAppliedValueSelect) theEObject;
			T result = caseIfcAppliedValueSelect(ifcAppliedValueSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_AXIS2_PLACEMENT: {
			IfcAxis2Placement ifcAxis2Placement = (IfcAxis2Placement) theEObject;
			T result = caseIfcAxis2Placement(ifcAxis2Placement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_BOOLEAN_OPERAND: {
			IfcBooleanOperand ifcBooleanOperand = (IfcBooleanOperand) theEObject;
			T result = caseIfcBooleanOperand(ifcBooleanOperand);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CHARACTER_STYLE_SELECT: {
			IfcCharacterStyleSelect ifcCharacterStyleSelect = (IfcCharacterStyleSelect) theEObject;
			T result = caseIfcCharacterStyleSelect(ifcCharacterStyleSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CLASSIFICATION_NOTATION_SELECT: {
			IfcClassificationNotationSelect ifcClassificationNotationSelect = (IfcClassificationNotationSelect) theEObject;
			T result = caseIfcClassificationNotationSelect(ifcClassificationNotationSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COLOUR: {
			IfcColour ifcColour = (IfcColour) theEObject;
			T result = caseIfcColour(ifcColour);
			if (result == null)
				result = caseIfcFillStyleSelect(ifcColour);
			if (result == null)
				result = caseIfcSymbolStyleSelect(ifcColour);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_COLOUR_OR_FACTOR: {
			IfcColourOrFactor ifcColourOrFactor = (IfcColourOrFactor) theEObject;
			T result = caseIfcColourOrFactor(ifcColourOrFactor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CONDITION_CRITERION_SELECT: {
			IfcConditionCriterionSelect ifcConditionCriterionSelect = (IfcConditionCriterionSelect) theEObject;
			T result = caseIfcConditionCriterionSelect(ifcConditionCriterionSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CSG_SELECT: {
			IfcCsgSelect ifcCsgSelect = (IfcCsgSelect) theEObject;
			T result = caseIfcCsgSelect(ifcCsgSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE_FONT_OR_SCALED_CURVE_FONT_SELECT: {
			IfcCurveFontOrScaledCurveFontSelect ifcCurveFontOrScaledCurveFontSelect = (IfcCurveFontOrScaledCurveFontSelect) theEObject;
			T result = caseIfcCurveFontOrScaledCurveFontSelect(ifcCurveFontOrScaledCurveFontSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE_OR_EDGE_CURVE: {
			IfcCurveOrEdgeCurve ifcCurveOrEdgeCurve = (IfcCurveOrEdgeCurve) theEObject;
			T result = caseIfcCurveOrEdgeCurve(ifcCurveOrEdgeCurve);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_CURVE_STYLE_FONT_SELECT: {
			IfcCurveStyleFontSelect ifcCurveStyleFontSelect = (IfcCurveStyleFontSelect) theEObject;
			T result = caseIfcCurveStyleFontSelect(ifcCurveStyleFontSelect);
			if (result == null)
				result = caseIfcCurveFontOrScaledCurveFontSelect(ifcCurveStyleFontSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DATE_TIME_SELECT: {
			IfcDateTimeSelect ifcDateTimeSelect = (IfcDateTimeSelect) theEObject;
			T result = caseIfcDateTimeSelect(ifcDateTimeSelect);
			if (result == null)
				result = caseIfcMetricValueSelect(ifcDateTimeSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DEFINED_SYMBOL_SELECT: {
			IfcDefinedSymbolSelect ifcDefinedSymbolSelect = (IfcDefinedSymbolSelect) theEObject;
			T result = caseIfcDefinedSymbolSelect(ifcDefinedSymbolSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DERIVED_MEASURE_VALUE: {
			IfcDerivedMeasureValue ifcDerivedMeasureValue = (IfcDerivedMeasureValue) theEObject;
			T result = caseIfcDerivedMeasureValue(ifcDerivedMeasureValue);
			if (result == null)
				result = caseIfcValue(ifcDerivedMeasureValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DOCUMENT_SELECT: {
			IfcDocumentSelect ifcDocumentSelect = (IfcDocumentSelect) theEObject;
			T result = caseIfcDocumentSelect(ifcDocumentSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_DRAUGHTING_CALLOUT_ELEMENT: {
			IfcDraughtingCalloutElement ifcDraughtingCalloutElement = (IfcDraughtingCalloutElement) theEObject;
			T result = caseIfcDraughtingCalloutElement(ifcDraughtingCalloutElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FILL_AREA_STYLE_TILE_SHAPE_SELECT: {
			IfcFillAreaStyleTileShapeSelect ifcFillAreaStyleTileShapeSelect = (IfcFillAreaStyleTileShapeSelect) theEObject;
			T result = caseIfcFillAreaStyleTileShapeSelect(ifcFillAreaStyleTileShapeSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_FILL_STYLE_SELECT: {
			IfcFillStyleSelect ifcFillStyleSelect = (IfcFillStyleSelect) theEObject;
			T result = caseIfcFillStyleSelect(ifcFillStyleSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_GEOMETRIC_SET_SELECT: {
			IfcGeometricSetSelect ifcGeometricSetSelect = (IfcGeometricSetSelect) theEObject;
			T result = caseIfcGeometricSetSelect(ifcGeometricSetSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_HATCH_LINE_DISTANCE_SELECT: {
			IfcHatchLineDistanceSelect ifcHatchLineDistanceSelect = (IfcHatchLineDistanceSelect) theEObject;
			T result = caseIfcHatchLineDistanceSelect(ifcHatchLineDistanceSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LAYERED_ITEM: {
			IfcLayeredItem ifcLayeredItem = (IfcLayeredItem) theEObject;
			T result = caseIfcLayeredItem(ifcLayeredItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIBRARY_SELECT: {
			IfcLibrarySelect ifcLibrarySelect = (IfcLibrarySelect) theEObject;
			T result = caseIfcLibrarySelect(ifcLibrarySelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_LIGHT_DISTRIBUTION_DATA_SOURCE_SELECT: {
			IfcLightDistributionDataSourceSelect ifcLightDistributionDataSourceSelect = (IfcLightDistributionDataSourceSelect) theEObject;
			T result = caseIfcLightDistributionDataSourceSelect(ifcLightDistributionDataSourceSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MATERIAL_SELECT: {
			IfcMaterialSelect ifcMaterialSelect = (IfcMaterialSelect) theEObject;
			T result = caseIfcMaterialSelect(ifcMaterialSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_MEASURE_VALUE: {
			IfcMeasureValue ifcMeasureValue = (IfcMeasureValue) theEObject;
			T result = caseIfcMeasureValue(ifcMeasureValue);
			if (result == null)
				result = caseIfcValue(ifcMeasureValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_METRIC_VALUE_SELECT: {
			IfcMetricValueSelect ifcMetricValueSelect = (IfcMetricValueSelect) theEObject;
			T result = caseIfcMetricValueSelect(ifcMetricValueSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_OBJECT_REFERENCE_SELECT: {
			IfcObjectReferenceSelect ifcObjectReferenceSelect = (IfcObjectReferenceSelect) theEObject;
			T result = caseIfcObjectReferenceSelect(ifcObjectReferenceSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_ORIENTATION_SELECT: {
			IfcOrientationSelect ifcOrientationSelect = (IfcOrientationSelect) theEObject;
			T result = caseIfcOrientationSelect(ifcOrientationSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_POINT_OR_VERTEX_POINT: {
			IfcPointOrVertexPoint ifcPointOrVertexPoint = (IfcPointOrVertexPoint) theEObject;
			T result = caseIfcPointOrVertexPoint(ifcPointOrVertexPoint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_PRESENTATION_STYLE_SELECT: {
			IfcPresentationStyleSelect ifcPresentationStyleSelect = (IfcPresentationStyleSelect) theEObject;
			T result = caseIfcPresentationStyleSelect(ifcPresentationStyleSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SHELL: {
			IfcShell ifcShell = (IfcShell) theEObject;
			T result = caseIfcShell(ifcShell);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SIMPLE_VALUE: {
			IfcSimpleValue ifcSimpleValue = (IfcSimpleValue) theEObject;
			T result = caseIfcSimpleValue(ifcSimpleValue);
			if (result == null)
				result = caseIfcValue(ifcSimpleValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SIZE_SELECT: {
			IfcSizeSelect ifcSizeSelect = (IfcSizeSelect) theEObject;
			T result = caseIfcSizeSelect(ifcSizeSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SPECULAR_HIGHLIGHT_SELECT: {
			IfcSpecularHighlightSelect ifcSpecularHighlightSelect = (IfcSpecularHighlightSelect) theEObject;
			T result = caseIfcSpecularHighlightSelect(ifcSpecularHighlightSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_STRUCTURAL_ACTIVITY_ASSIGNMENT_SELECT: {
			IfcStructuralActivityAssignmentSelect ifcStructuralActivityAssignmentSelect = (IfcStructuralActivityAssignmentSelect) theEObject;
			T result = caseIfcStructuralActivityAssignmentSelect(ifcStructuralActivityAssignmentSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_OR_FACE_SURFACE: {
			IfcSurfaceOrFaceSurface ifcSurfaceOrFaceSurface = (IfcSurfaceOrFaceSurface) theEObject;
			T result = caseIfcSurfaceOrFaceSurface(ifcSurfaceOrFaceSurface);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SURFACE_STYLE_ELEMENT_SELECT: {
			IfcSurfaceStyleElementSelect ifcSurfaceStyleElementSelect = (IfcSurfaceStyleElementSelect) theEObject;
			T result = caseIfcSurfaceStyleElementSelect(ifcSurfaceStyleElementSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_SYMBOL_STYLE_SELECT: {
			IfcSymbolStyleSelect ifcSymbolStyleSelect = (IfcSymbolStyleSelect) theEObject;
			T result = caseIfcSymbolStyleSelect(ifcSymbolStyleSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_FONT_SELECT: {
			IfcTextFontSelect ifcTextFontSelect = (IfcTextFontSelect) theEObject;
			T result = caseIfcTextFontSelect(ifcTextFontSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TEXT_STYLE_SELECT: {
			IfcTextStyleSelect ifcTextStyleSelect = (IfcTextStyleSelect) theEObject;
			T result = caseIfcTextStyleSelect(ifcTextStyleSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_TRIMMING_SELECT: {
			IfcTrimmingSelect ifcTrimmingSelect = (IfcTrimmingSelect) theEObject;
			T result = caseIfcTrimmingSelect(ifcTrimmingSelect);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_UNIT: {
			IfcUnit ifcUnit = (IfcUnit) theEObject;
			T result = caseIfcUnit(ifcUnit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VALUE: {
			IfcValue ifcValue = (IfcValue) theEObject;
			T result = caseIfcValue(ifcValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Ifc2x3tc1Package.IFC_VECTOR_OR_DIRECTION: {
			IfcVectorOrDirection ifcVectorOrDirection = (IfcVectorOrDirection) theEObject;
			T result = caseIfcVectorOrDirection(ifcVectorOrDirection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc2 DComposite Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc2 DComposite Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfc2DCompositeCurve(Ifc2DCompositeCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Action Request</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Action Request</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcActionRequest(IfcActionRequest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcActor(IfcActor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Actor Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Actor Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcActorRole(IfcActorRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Actuator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Actuator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcActuatorType(IfcActuatorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAddress(IfcAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Air Terminal Box Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Air Terminal Box Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAirTerminalBoxType(IfcAirTerminalBoxType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Air Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Air Terminal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAirTerminalType(IfcAirTerminalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Air To Air Heat Recovery Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Air To Air Heat Recovery Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAirToAirHeatRecoveryType(IfcAirToAirHeatRecoveryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Alarm Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Alarm Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAlarmType(IfcAlarmType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Angular Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Angular Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAngularDimension(IfcAngularDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotation(IfcAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation Curve Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation Curve Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotationCurveOccurrence(IfcAnnotationCurveOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation Fill Area</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation Fill Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotationFillArea(IfcAnnotationFillArea object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation Fill Area Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation Fill Area Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotationFillAreaOccurrence(IfcAnnotationFillAreaOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotationOccurrence(IfcAnnotationOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotationSurface(IfcAnnotationSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation Surface Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation Surface Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotationSurfaceOccurrence(IfcAnnotationSurfaceOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation Symbol Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation Symbol Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotationSymbolOccurrence(IfcAnnotationSymbolOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Annotation Text Occurrence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Annotation Text Occurrence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAnnotationTextOccurrence(IfcAnnotationTextOccurrence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcApplication(IfcApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Applied Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Applied Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAppliedValue(IfcAppliedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Applied Value Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Applied Value Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAppliedValueRelationship(IfcAppliedValueRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Approval</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Approval</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcApproval(IfcApproval object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Approval Actor Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Approval Actor Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcApprovalActorRelationship(IfcApprovalActorRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Approval Property Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Approval Property Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcApprovalPropertyRelationship(IfcApprovalPropertyRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Approval Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Approval Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcApprovalRelationship(IfcApprovalRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Arbitrary Closed Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Arbitrary Closed Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcArbitraryClosedProfileDef(IfcArbitraryClosedProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Arbitrary Open Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Arbitrary Open Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcArbitraryOpenProfileDef(IfcArbitraryOpenProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Arbitrary Profile Def With Voids</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Arbitrary Profile Def With Voids</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcArbitraryProfileDefWithVoids(IfcArbitraryProfileDefWithVoids object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Asset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Asset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAsset(IfcAsset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Asymmetric IShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Asymmetric IShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAsymmetricIShapeProfileDef(IfcAsymmetricIShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Axis1 Placement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Axis1 Placement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAxis1Placement(IfcAxis1Placement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Axis2 Placement2 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Axis2 Placement2 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAxis2Placement2D(IfcAxis2Placement2D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Axis2 Placement3 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Axis2 Placement3 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAxis2Placement3D(IfcAxis2Placement3D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc BSpline Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc BSpline Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBSplineCurve(IfcBSplineCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Beam</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Beam</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBeam(IfcBeam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Beam Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Beam Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBeamType(IfcBeamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Bezier Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Bezier Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBezierCurve(IfcBezierCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Blob Texture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Blob Texture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBlobTexture(IfcBlobTexture object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBlock(IfcBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boiler Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boiler Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoilerType(IfcBoilerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boolean Clipping Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boolean Clipping Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBooleanClippingResult(IfcBooleanClippingResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boolean Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boolean Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBooleanResult(IfcBooleanResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boundary Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boundary Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoundaryCondition(IfcBoundaryCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boundary Edge Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boundary Edge Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoundaryEdgeCondition(IfcBoundaryEdgeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boundary Face Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boundary Face Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoundaryFaceCondition(IfcBoundaryFaceCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boundary Node Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boundary Node Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoundaryNodeCondition(IfcBoundaryNodeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boundary Node Condition Warping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boundary Node Condition Warping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoundaryNodeConditionWarping(IfcBoundaryNodeConditionWarping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Bounded Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Bounded Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoundedCurve(IfcBoundedCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Bounded Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Bounded Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoundedSurface(IfcBoundedSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Bounding Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Bounding Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoundingBox(IfcBoundingBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boxed Half Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boxed Half Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoxedHalfSpace(IfcBoxedHalfSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Building</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Building</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBuilding(IfcBuilding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Building Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Building Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBuildingElement(IfcBuildingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Building Element Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Building Element Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBuildingElementComponent(IfcBuildingElementComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Building Element Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Building Element Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBuildingElementPart(IfcBuildingElementPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Building Element Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Building Element Proxy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBuildingElementProxy(IfcBuildingElementProxy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Building Element Proxy Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Building Element Proxy Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBuildingElementProxyType(IfcBuildingElementProxyType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Building Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Building Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBuildingElementType(IfcBuildingElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Building Storey</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Building Storey</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBuildingStorey(IfcBuildingStorey object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc CShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc CShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCShapeProfileDef(IfcCShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cable Carrier Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cable Carrier Fitting Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCableCarrierFittingType(IfcCableCarrierFittingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cable Carrier Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cable Carrier Segment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCableCarrierSegmentType(IfcCableCarrierSegmentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cable Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cable Segment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCableSegmentType(IfcCableSegmentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Calendar Date</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Calendar Date</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCalendarDate(IfcCalendarDate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cartesian Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cartesian Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCartesianPoint(IfcCartesianPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCartesianTransformationOperator(IfcCartesianTransformationOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator2 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator2 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCartesianTransformationOperator2D(IfcCartesianTransformationOperator2D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator2 Dnon Uniform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator2 Dnon Uniform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCartesianTransformationOperator2DnonUniform(IfcCartesianTransformationOperator2DnonUniform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator3 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator3 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCartesianTransformationOperator3D(IfcCartesianTransformationOperator3D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator3 Dnon Uniform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cartesian Transformation Operator3 Dnon Uniform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCartesianTransformationOperator3DnonUniform(IfcCartesianTransformationOperator3DnonUniform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Center Line Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Center Line Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCenterLineProfileDef(IfcCenterLineProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Chamfer Edge Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Chamfer Edge Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcChamferEdgeFeature(IfcChamferEdgeFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Chiller Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Chiller Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcChillerType(IfcChillerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Circle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Circle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCircle(IfcCircle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Circle Hollow Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Circle Hollow Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCircleHollowProfileDef(IfcCircleHollowProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Circle Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Circle Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCircleProfileDef(IfcCircleProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Classification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Classification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcClassification(IfcClassification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Classification Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Classification Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcClassificationItem(IfcClassificationItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Classification Item Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Classification Item Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcClassificationItemRelationship(IfcClassificationItemRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Classification Notation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Classification Notation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcClassificationNotation(IfcClassificationNotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Classification Notation Facet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Classification Notation Facet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcClassificationNotationFacet(IfcClassificationNotationFacet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Classification Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Classification Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcClassificationReference(IfcClassificationReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Closed Shell</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Closed Shell</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcClosedShell(IfcClosedShell object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Coil Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Coil Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCoilType(IfcCoilType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Colour Rgb</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Colour Rgb</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcColourRgb(IfcColourRgb object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Colour Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Colour Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcColourSpecification(IfcColourSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcColumn(IfcColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Column Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Column Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcColumnType(IfcColumnType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Complex Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Complex Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcComplexProperty(IfcComplexProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Composite Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Composite Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCompositeCurve(IfcCompositeCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Composite Curve Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Composite Curve Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCompositeCurveSegment(IfcCompositeCurveSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Composite Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Composite Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCompositeProfileDef(IfcCompositeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Compressor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Compressor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCompressorType(IfcCompressorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Condenser Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Condenser Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCondenserType(IfcCondenserType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCondition(IfcCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Condition Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Condition Criterion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConditionCriterion(IfcConditionCriterion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Conic</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Conic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConic(IfcConic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Connected Face Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Connected Face Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConnectedFaceSet(IfcConnectedFaceSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Connection Curve Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Connection Curve Geometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConnectionCurveGeometry(IfcConnectionCurveGeometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Connection Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Connection Geometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConnectionGeometry(IfcConnectionGeometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Connection Point Eccentricity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Connection Point Eccentricity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConnectionPointEccentricity(IfcConnectionPointEccentricity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Connection Point Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Connection Point Geometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConnectionPointGeometry(IfcConnectionPointGeometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Connection Port Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Connection Port Geometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConnectionPortGeometry(IfcConnectionPortGeometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Connection Surface Geometry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Connection Surface Geometry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConnectionSurfaceGeometry(IfcConnectionSurfaceGeometry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConstraint(IfcConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Constraint Aggregation Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Constraint Aggregation Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConstraintAggregationRelationship(IfcConstraintAggregationRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Constraint Classification Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Constraint Classification Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConstraintClassificationRelationship(IfcConstraintClassificationRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Constraint Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Constraint Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConstraintRelationship(IfcConstraintRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Construction Equipment Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Construction Equipment Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConstructionEquipmentResource(IfcConstructionEquipmentResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Construction Material Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Construction Material Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConstructionMaterialResource(IfcConstructionMaterialResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Construction Product Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Construction Product Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConstructionProductResource(IfcConstructionProductResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Construction Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Construction Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConstructionResource(IfcConstructionResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Context Dependent Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Context Dependent Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcContextDependentUnit(IfcContextDependentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcControl(IfcControl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Controller Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Controller Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcControllerType(IfcControllerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Conversion Based Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Conversion Based Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConversionBasedUnit(IfcConversionBasedUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cooled Beam Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cooled Beam Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCooledBeamType(IfcCooledBeamType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cooling Tower Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cooling Tower Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCoolingTowerType(IfcCoolingTowerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Coordinated Universal Time Offset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Coordinated Universal Time Offset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCoordinatedUniversalTimeOffset(IfcCoordinatedUniversalTimeOffset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cost Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cost Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCostItem(IfcCostItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cost Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cost Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCostSchedule(IfcCostSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Cost Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Cost Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCostValue(IfcCostValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Covering</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Covering</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCovering(IfcCovering object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Covering Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Covering Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCoveringType(IfcCoveringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Crane Rail AShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Crane Rail AShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCraneRailAShapeProfileDef(IfcCraneRailAShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Crane Rail FShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Crane Rail FShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCraneRailFShapeProfileDef(IfcCraneRailFShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Crew Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Crew Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCrewResource(IfcCrewResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Csg Primitive3 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Csg Primitive3 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCsgPrimitive3D(IfcCsgPrimitive3D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Csg Solid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Csg Solid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCsgSolid(IfcCsgSolid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Currency Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Currency Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurrencyRelationship(IfcCurrencyRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curtain Wall</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curtain Wall</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurtainWall(IfcCurtainWall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curtain Wall Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curtain Wall Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurtainWallType(IfcCurtainWallType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurve(IfcCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve Bounded Plane</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve Bounded Plane</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurveBoundedPlane(IfcCurveBoundedPlane object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurveStyle(IfcCurveStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve Style Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve Style Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurveStyleFont(IfcCurveStyleFont object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve Style Font And Scaling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve Style Font And Scaling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurveStyleFontAndScaling(IfcCurveStyleFontAndScaling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve Style Font Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve Style Font Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurveStyleFontPattern(IfcCurveStyleFontPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Damper Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Damper Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDamperType(IfcDamperType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Date And Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Date And Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDateAndTime(IfcDateAndTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Defined Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Defined Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDefinedSymbol(IfcDefinedSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Derived Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Derived Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDerivedProfileDef(IfcDerivedProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Derived Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Derived Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDerivedUnit(IfcDerivedUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Derived Unit Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Derived Unit Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDerivedUnitElement(IfcDerivedUnitElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Diameter Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Diameter Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDiameterDimension(IfcDiameterDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dimension Callout Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dimension Callout Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDimensionCalloutRelationship(IfcDimensionCalloutRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dimension Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dimension Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDimensionCurve(IfcDimensionCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dimension Curve Directed Callout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dimension Curve Directed Callout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDimensionCurveDirectedCallout(IfcDimensionCurveDirectedCallout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dimension Curve Terminator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dimension Curve Terminator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDimensionCurveTerminator(IfcDimensionCurveTerminator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dimension Pair</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dimension Pair</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDimensionPair(IfcDimensionPair object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dimensional Exponents</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dimensional Exponents</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDimensionalExponents(IfcDimensionalExponents object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Direction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Direction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDirection(IfcDirection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Discrete Accessory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Discrete Accessory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDiscreteAccessory(IfcDiscreteAccessory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Discrete Accessory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Discrete Accessory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDiscreteAccessoryType(IfcDiscreteAccessoryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Chamber Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Chamber Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionChamberElement(IfcDistributionChamberElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Chamber Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Chamber Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionChamberElementType(IfcDistributionChamberElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Control Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Control Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionControlElement(IfcDistributionControlElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Control Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Control Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionControlElementType(IfcDistributionControlElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionElement(IfcDistributionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionElementType(IfcDistributionElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Flow Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Flow Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionFlowElement(IfcDistributionFlowElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Flow Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Flow Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionFlowElementType(IfcDistributionFlowElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Distribution Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Distribution Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDistributionPort(IfcDistributionPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Document Electronic Format</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Document Electronic Format</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDocumentElectronicFormat(IfcDocumentElectronicFormat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Document Information</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Document Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDocumentInformation(IfcDocumentInformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Document Information Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Document Information Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDocumentInformationRelationship(IfcDocumentInformationRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Document Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Document Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDocumentReference(IfcDocumentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Door</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Door</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDoor(IfcDoor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Door Lining Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Door Lining Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDoorLiningProperties(IfcDoorLiningProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Door Panel Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Door Panel Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDoorPanelProperties(IfcDoorPanelProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Door Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Door Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDoorStyle(IfcDoorStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Draughting Callout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Draughting Callout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDraughtingCallout(IfcDraughtingCallout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Draughting Callout Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Draughting Callout Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDraughtingCalloutRelationship(IfcDraughtingCalloutRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Draughting Pre Defined Colour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Draughting Pre Defined Colour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDraughtingPreDefinedColour(IfcDraughtingPreDefinedColour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Draughting Pre Defined Curve Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Draughting Pre Defined Curve Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDraughtingPreDefinedCurveFont(IfcDraughtingPreDefinedCurveFont object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Draughting Pre Defined Text Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Draughting Pre Defined Text Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDraughtingPreDefinedTextFont(IfcDraughtingPreDefinedTextFont object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Duct Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Duct Fitting Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDuctFittingType(IfcDuctFittingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Duct Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Duct Segment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDuctSegmentType(IfcDuctSegmentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Duct Silencer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Duct Silencer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDuctSilencerType(IfcDuctSilencerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEdge(IfcEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Edge Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Edge Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEdgeCurve(IfcEdgeCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Edge Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Edge Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEdgeFeature(IfcEdgeFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Edge Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Edge Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEdgeLoop(IfcEdgeLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Appliance Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Appliance Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricApplianceType(IfcElectricApplianceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Distribution Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Distribution Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricDistributionPoint(IfcElectricDistributionPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Flow Storage Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Flow Storage Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricFlowStorageDeviceType(IfcElectricFlowStorageDeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Generator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Generator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricGeneratorType(IfcElectricGeneratorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Heater Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Heater Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricHeaterType(IfcElectricHeaterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Motor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Motor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricMotorType(IfcElectricMotorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Time Control Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Time Control Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricTimeControlType(IfcElectricTimeControlType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electrical Base Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electrical Base Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricalBaseProperties(IfcElectricalBaseProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electrical Circuit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electrical Circuit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricalCircuit(IfcElectricalCircuit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electrical Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electrical Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricalElement(IfcElectricalElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElement(IfcElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Element Assembly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Element Assembly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElementAssembly(IfcElementAssembly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Element Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Element Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElementComponent(IfcElementComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Element Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Element Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElementComponentType(IfcElementComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Element Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Element Quantity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElementQuantity(IfcElementQuantity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElementType(IfcElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Elementary Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Elementary Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElementarySurface(IfcElementarySurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Ellipse</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Ellipse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEllipse(IfcEllipse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Ellipse Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Ellipse Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEllipseProfileDef(IfcEllipseProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Energy Conversion Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Energy Conversion Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEnergyConversionDevice(IfcEnergyConversionDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Energy Conversion Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Energy Conversion Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEnergyConversionDeviceType(IfcEnergyConversionDeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Energy Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Energy Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEnergyProperties(IfcEnergyProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Environmental Impact Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Environmental Impact Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEnvironmentalImpactValue(IfcEnvironmentalImpactValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Equipment Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Equipment Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEquipmentElement(IfcEquipmentElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Equipment Standard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Equipment Standard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEquipmentStandard(IfcEquipmentStandard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Evaporative Cooler Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Evaporative Cooler Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEvaporativeCoolerType(IfcEvaporativeCoolerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Evaporator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Evaporator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEvaporatorType(IfcEvaporatorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Extended Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Extended Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcExtendedMaterialProperties(IfcExtendedMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc External Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc External Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcExternalReference(IfcExternalReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Externally Defined Hatch Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Externally Defined Hatch Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcExternallyDefinedHatchStyle(IfcExternallyDefinedHatchStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Externally Defined Surface Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Externally Defined Surface Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcExternallyDefinedSurfaceStyle(IfcExternallyDefinedSurfaceStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Externally Defined Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Externally Defined Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcExternallyDefinedSymbol(IfcExternallyDefinedSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Externally Defined Text Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Externally Defined Text Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcExternallyDefinedTextFont(IfcExternallyDefinedTextFont object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Extruded Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Extruded Area Solid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcExtrudedAreaSolid(IfcExtrudedAreaSolid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Face</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Face</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFace(IfcFace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Face Based Surface Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Face Based Surface Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFaceBasedSurfaceModel(IfcFaceBasedSurfaceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Face Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Face Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFaceBound(IfcFaceBound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Face Outer Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Face Outer Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFaceOuterBound(IfcFaceOuterBound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Face Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Face Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFaceSurface(IfcFaceSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Faceted Brep</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Faceted Brep</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFacetedBrep(IfcFacetedBrep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Faceted Brep With Voids</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Faceted Brep With Voids</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFacetedBrepWithVoids(IfcFacetedBrepWithVoids object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Failure Connection Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Failure Connection Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFailureConnectionCondition(IfcFailureConnectionCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fan Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fan Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFanType(IfcFanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fastener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fastener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFastener(IfcFastener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fastener Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fastener Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFastenerType(IfcFastenerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Feature Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Feature Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFeatureElement(IfcFeatureElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Feature Element Addition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Feature Element Addition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFeatureElementAddition(IfcFeatureElementAddition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Feature Element Subtraction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Feature Element Subtraction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFeatureElementSubtraction(IfcFeatureElementSubtraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fill Area Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fill Area Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFillAreaStyle(IfcFillAreaStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fill Area Style Hatching</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fill Area Style Hatching</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFillAreaStyleHatching(IfcFillAreaStyleHatching object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fill Area Style Tile Symbol With Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fill Area Style Tile Symbol With Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFillAreaStyleTileSymbolWithStyle(IfcFillAreaStyleTileSymbolWithStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fill Area Style Tiles</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fill Area Style Tiles</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFillAreaStyleTiles(IfcFillAreaStyleTiles object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Filter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Filter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFilterType(IfcFilterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fire Suppression Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fire Suppression Terminal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFireSuppressionTerminalType(IfcFireSuppressionTerminalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Controller</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Controller</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowController(IfcFlowController object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Controller Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Controller Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowControllerType(IfcFlowControllerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Fitting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Fitting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowFitting(IfcFlowFitting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Fitting Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowFittingType(IfcFlowFittingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Instrument Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Instrument Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowInstrumentType(IfcFlowInstrumentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Meter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Meter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowMeterType(IfcFlowMeterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Moving Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Moving Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowMovingDevice(IfcFlowMovingDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Moving Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Moving Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowMovingDeviceType(IfcFlowMovingDeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowSegment(IfcFlowSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Segment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowSegmentType(IfcFlowSegmentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Storage Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Storage Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowStorageDevice(IfcFlowStorageDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Storage Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Storage Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowStorageDeviceType(IfcFlowStorageDeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Terminal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowTerminal(IfcFlowTerminal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Terminal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowTerminalType(IfcFlowTerminalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Treatment Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Treatment Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowTreatmentDevice(IfcFlowTreatmentDevice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Flow Treatment Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Flow Treatment Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFlowTreatmentDeviceType(IfcFlowTreatmentDeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fluid Flow Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fluid Flow Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFluidFlowProperties(IfcFluidFlowProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Footing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Footing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFooting(IfcFooting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fuel Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fuel Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFuelProperties(IfcFuelProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Furnishing Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Furnishing Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFurnishingElement(IfcFurnishingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Furnishing Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Furnishing Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFurnishingElementType(IfcFurnishingElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Furniture Standard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Furniture Standard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFurnitureStandard(IfcFurnitureStandard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Furniture Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Furniture Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFurnitureType(IfcFurnitureType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Gas Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Gas Terminal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGasTerminalType(IfcGasTerminalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc General Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc General Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGeneralMaterialProperties(IfcGeneralMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc General Profile Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc General Profile Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGeneralProfileProperties(IfcGeneralProfileProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Geometric Curve Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Geometric Curve Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGeometricCurveSet(IfcGeometricCurveSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Geometric Representation Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Geometric Representation Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGeometricRepresentationContext(IfcGeometricRepresentationContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Geometric Representation Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Geometric Representation Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGeometricRepresentationItem(IfcGeometricRepresentationItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Geometric Representation Sub Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Geometric Representation Sub Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGeometricRepresentationSubContext(IfcGeometricRepresentationSubContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Geometric Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Geometric Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGeometricSet(IfcGeometricSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Grid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Grid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGrid(IfcGrid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Grid Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Grid Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGridAxis(IfcGridAxis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Grid Placement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Grid Placement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGridPlacement(IfcGridPlacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGroup(IfcGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Half Space Solid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Half Space Solid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcHalfSpaceSolid(IfcHalfSpaceSolid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Heat Exchanger Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Heat Exchanger Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcHeatExchangerType(IfcHeatExchangerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Humidifier Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Humidifier Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcHumidifierType(IfcHumidifierType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Hygroscopic Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Hygroscopic Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcHygroscopicMaterialProperties(IfcHygroscopicMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc IShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc IShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcIShapeProfileDef(IfcIShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Image Texture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Image Texture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcImageTexture(IfcImageTexture object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Inventory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Inventory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcInventory(IfcInventory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Irregular Time Series</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Irregular Time Series</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcIrregularTimeSeries(IfcIrregularTimeSeries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Irregular Time Series Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Irregular Time Series Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcIrregularTimeSeriesValue(IfcIrregularTimeSeriesValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Junction Box Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Junction Box Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcJunctionBoxType(IfcJunctionBoxType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc LShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc LShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLShapeProfileDef(IfcLShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Labor Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Labor Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLaborResource(IfcLaborResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Lamp Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Lamp Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLampType(IfcLampType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Library Information</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Library Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLibraryInformation(IfcLibraryInformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Library Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Library Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLibraryReference(IfcLibraryReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Distribution Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Distribution Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightDistributionData(IfcLightDistributionData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Fixture Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Fixture Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightFixtureType(IfcLightFixtureType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Intensity Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Intensity Distribution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightIntensityDistribution(IfcLightIntensityDistribution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightSource(IfcLightSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Source Ambient</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Source Ambient</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightSourceAmbient(IfcLightSourceAmbient object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Source Directional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Source Directional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightSourceDirectional(IfcLightSourceDirectional object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Source Goniometric</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Source Goniometric</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightSourceGoniometric(IfcLightSourceGoniometric object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Source Positional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Source Positional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightSourcePositional(IfcLightSourcePositional object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Source Spot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Source Spot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightSourceSpot(IfcLightSourceSpot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLine(IfcLine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Linear Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Linear Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLinearDimension(IfcLinearDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Local Placement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Local Placement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLocalPlacement(IfcLocalPlacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Local Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Local Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLocalTime(IfcLocalTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLoop(IfcLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Manifold Solid Brep</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Manifold Solid Brep</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcManifoldSolidBrep(IfcManifoldSolidBrep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mapped Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mapped Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMappedItem(IfcMappedItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterial(IfcMaterial object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material Classification Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material Classification Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterialClassificationRelationship(IfcMaterialClassificationRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material Definition Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material Definition Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterialDefinitionRepresentation(IfcMaterialDefinitionRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterialLayer(IfcMaterialLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material Layer Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material Layer Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterialLayerSet(IfcMaterialLayerSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material Layer Set Usage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material Layer Set Usage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterialLayerSetUsage(IfcMaterialLayerSetUsage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterialList(IfcMaterialList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterialProperties(IfcMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Measure With Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Measure With Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMeasureWithUnit(IfcMeasureWithUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mechanical Concrete Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mechanical Concrete Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMechanicalConcreteMaterialProperties(IfcMechanicalConcreteMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mechanical Fastener</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mechanical Fastener</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMechanicalFastener(IfcMechanicalFastener object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mechanical Fastener Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mechanical Fastener Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMechanicalFastenerType(IfcMechanicalFastenerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mechanical Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mechanical Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMechanicalMaterialProperties(IfcMechanicalMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mechanical Steel Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mechanical Steel Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMechanicalSteelMaterialProperties(IfcMechanicalSteelMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMember(IfcMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Member Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Member Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMemberType(IfcMemberType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Metric</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Metric</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMetric(IfcMetric object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Monetary Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Monetary Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMonetaryUnit(IfcMonetaryUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Motor Connection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Motor Connection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMotorConnectionType(IfcMotorConnectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Move</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Move</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMove(IfcMove object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Named Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Named Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcNamedUnit(IfcNamedUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcObject(IfcObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Object Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Object Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcObjectDefinition(IfcObjectDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Object Placement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Object Placement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcObjectPlacement(IfcObjectPlacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Objective</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Objective</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcObjective(IfcObjective object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Occupant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Occupant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOccupant(IfcOccupant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Offset Curve2 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Offset Curve2 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOffsetCurve2D(IfcOffsetCurve2D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Offset Curve3 D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Offset Curve3 D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOffsetCurve3D(IfcOffsetCurve3D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc One Direction Repeat Factor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc One Direction Repeat Factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOneDirectionRepeatFactor(IfcOneDirectionRepeatFactor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Open Shell</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Open Shell</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOpenShell(IfcOpenShell object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Opening Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Opening Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOpeningElement(IfcOpeningElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Optical Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Optical Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOpticalMaterialProperties(IfcOpticalMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Order Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Order Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOrderAction(IfcOrderAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Organization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Organization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOrganization(IfcOrganization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Organization Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Organization Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOrganizationRelationship(IfcOrganizationRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Oriented Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Oriented Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOrientedEdge(IfcOrientedEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Outlet Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Outlet Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOutletType(IfcOutletType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Owner History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Owner History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOwnerHistory(IfcOwnerHistory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Parameterized Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Parameterized Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcParameterizedProfileDef(IfcParameterizedProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPath(IfcPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Performance History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Performance History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPerformanceHistory(IfcPerformanceHistory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Permeable Covering Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Permeable Covering Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPermeableCoveringProperties(IfcPermeableCoveringProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Permit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Permit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPermit(IfcPermit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Person</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Person</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPerson(IfcPerson object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Person And Organization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Person And Organization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPersonAndOrganization(IfcPersonAndOrganization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Physical Complex Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Physical Complex Quantity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPhysicalComplexQuantity(IfcPhysicalComplexQuantity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Physical Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Physical Quantity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPhysicalQuantity(IfcPhysicalQuantity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Physical Simple Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Physical Simple Quantity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPhysicalSimpleQuantity(IfcPhysicalSimpleQuantity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPile(IfcPile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pipe Fitting Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pipe Fitting Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPipeFittingType(IfcPipeFittingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pipe Segment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pipe Segment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPipeSegmentType(IfcPipeSegmentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pixel Texture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pixel Texture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPixelTexture(IfcPixelTexture object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Placement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Placement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPlacement(IfcPlacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Planar Box</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Planar Box</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPlanarBox(IfcPlanarBox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Planar Extent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Planar Extent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPlanarExtent(IfcPlanarExtent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Plane</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Plane</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPlane(IfcPlane object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Plate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Plate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPlate(IfcPlate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Plate Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Plate Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPlateType(IfcPlateType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPoint(IfcPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Point On Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Point On Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPointOnCurve(IfcPointOnCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Point On Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Point On Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPointOnSurface(IfcPointOnSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Poly Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Poly Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPolyLoop(IfcPolyLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Polygonal Bounded Half Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Polygonal Bounded Half Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPolygonalBoundedHalfSpace(IfcPolygonalBoundedHalfSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Polyline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Polyline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPolyline(IfcPolyline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPort(IfcPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Postal Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Postal Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPostalAddress(IfcPostalAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pre Defined Colour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pre Defined Colour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPreDefinedColour(IfcPreDefinedColour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pre Defined Curve Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pre Defined Curve Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPreDefinedCurveFont(IfcPreDefinedCurveFont object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pre Defined Dimension Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pre Defined Dimension Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPreDefinedDimensionSymbol(IfcPreDefinedDimensionSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pre Defined Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pre Defined Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPreDefinedItem(IfcPreDefinedItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pre Defined Point Marker Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pre Defined Point Marker Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPreDefinedPointMarkerSymbol(IfcPreDefinedPointMarkerSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pre Defined Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pre Defined Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPreDefinedSymbol(IfcPreDefinedSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pre Defined Terminator Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pre Defined Terminator Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPreDefinedTerminatorSymbol(IfcPreDefinedTerminatorSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pre Defined Text Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pre Defined Text Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPreDefinedTextFont(IfcPreDefinedTextFont object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Presentation Layer Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Presentation Layer Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPresentationLayerAssignment(IfcPresentationLayerAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Presentation Layer With Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Presentation Layer With Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPresentationLayerWithStyle(IfcPresentationLayerWithStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Presentation Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Presentation Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPresentationStyle(IfcPresentationStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Presentation Style Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Presentation Style Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPresentationStyleAssignment(IfcPresentationStyleAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProcedure(IfcProcedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProcess(IfcProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProduct(IfcProduct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Product Definition Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Product Definition Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProductDefinitionShape(IfcProductDefinitionShape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Product Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Product Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProductRepresentation(IfcProductRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Products Of Combustion Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Products Of Combustion Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProductsOfCombustionProperties(IfcProductsOfCombustionProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProfileDef(IfcProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Profile Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Profile Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProfileProperties(IfcProfileProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProject(IfcProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Project Order</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Project Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProjectOrder(IfcProjectOrder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Project Order Record</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Project Order Record</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProjectOrderRecord(IfcProjectOrderRecord object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Projection Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Projection Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProjectionCurve(IfcProjectionCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Projection Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Projection Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProjectionElement(IfcProjectionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProperty(IfcProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Bounded Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Bounded Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyBoundedValue(IfcPropertyBoundedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Constraint Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Constraint Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyConstraintRelationship(IfcPropertyConstraintRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyDefinition(IfcPropertyDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Dependency Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Dependency Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyDependencyRelationship(IfcPropertyDependencyRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Enumerated Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Enumerated Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyEnumeratedValue(IfcPropertyEnumeratedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyEnumeration(IfcPropertyEnumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property List Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property List Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyListValue(IfcPropertyListValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Reference Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Reference Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyReferenceValue(IfcPropertyReferenceValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertySet(IfcPropertySet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Set Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Set Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertySetDefinition(IfcPropertySetDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Single Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Single Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertySingleValue(IfcPropertySingleValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Property Table Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Property Table Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPropertyTableValue(IfcPropertyTableValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Protective Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Protective Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProtectiveDeviceType(IfcProtectiveDeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Proxy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcProxy(IfcProxy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pump Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pump Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPumpType(IfcPumpType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Quantity Area</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Quantity Area</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcQuantityArea(IfcQuantityArea object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Quantity Count</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Quantity Count</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcQuantityCount(IfcQuantityCount object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Quantity Length</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Quantity Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcQuantityLength(IfcQuantityLength object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Quantity Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Quantity Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcQuantityTime(IfcQuantityTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Quantity Volume</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Quantity Volume</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcQuantityVolume(IfcQuantityVolume object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Quantity Weight</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Quantity Weight</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcQuantityWeight(IfcQuantityWeight object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Radius Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Radius Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRadiusDimension(IfcRadiusDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Railing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Railing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRailing(IfcRailing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Railing Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Railing Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRailingType(IfcRailingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Ramp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Ramp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRamp(IfcRamp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Ramp Flight</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Ramp Flight</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRampFlight(IfcRampFlight object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Ramp Flight Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Ramp Flight Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRampFlightType(IfcRampFlightType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rational Bezier Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rational Bezier Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRationalBezierCurve(IfcRationalBezierCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rectangle Hollow Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rectangle Hollow Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRectangleHollowProfileDef(IfcRectangleHollowProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rectangle Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rectangle Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRectangleProfileDef(IfcRectangleProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rectangular Pyramid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rectangular Pyramid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRectangularPyramid(IfcRectangularPyramid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rectangular Trimmed Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rectangular Trimmed Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRectangularTrimmedSurface(IfcRectangularTrimmedSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc References Value Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc References Value Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcReferencesValueDocument(IfcReferencesValueDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Regular Time Series</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Regular Time Series</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRegularTimeSeries(IfcRegularTimeSeries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Reinforcement Bar Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Reinforcement Bar Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcReinforcementBarProperties(IfcReinforcementBarProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Reinforcement Definition Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Reinforcement Definition Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcReinforcementDefinitionProperties(IfcReinforcementDefinitionProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Reinforcing Bar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Reinforcing Bar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcReinforcingBar(IfcReinforcingBar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Reinforcing Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Reinforcing Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcReinforcingElement(IfcReinforcingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Reinforcing Mesh</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Reinforcing Mesh</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcReinforcingMesh(IfcReinforcingMesh object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Aggregates</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Aggregates</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAggregates(IfcRelAggregates object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssigns(IfcRelAssigns object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns Tasks</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns Tasks</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssignsTasks(IfcRelAssignsTasks object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Actor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Actor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssignsToActor(IfcRelAssignsToActor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssignsToControl(IfcRelAssignsToControl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssignsToGroup(IfcRelAssignsToGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssignsToProcess(IfcRelAssignsToProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssignsToProduct(IfcRelAssignsToProduct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Project Order</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Project Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssignsToProjectOrder(IfcRelAssignsToProjectOrder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Assigns To Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssignsToResource(IfcRelAssignsToResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociates(IfcRelAssociates object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates Applied Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates Applied Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociatesAppliedValue(IfcRelAssociatesAppliedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates Approval</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates Approval</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociatesApproval(IfcRelAssociatesApproval object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates Classification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates Classification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociatesClassification(IfcRelAssociatesClassification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociatesConstraint(IfcRelAssociatesConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates Document</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates Document</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociatesDocument(IfcRelAssociatesDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociatesLibrary(IfcRelAssociatesLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates Material</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates Material</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociatesMaterial(IfcRelAssociatesMaterial object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Associates Profile Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Associates Profile Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelAssociatesProfileProperties(IfcRelAssociatesProfileProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnects(IfcRelConnects object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsElements(IfcRelConnectsElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects Path Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects Path Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsPathElements(IfcRelConnectsPathElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects Port To Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects Port To Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsPortToElement(IfcRelConnectsPortToElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects Ports</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects Ports</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsPorts(IfcRelConnectsPorts object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects Structural Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects Structural Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsStructuralActivity(IfcRelConnectsStructuralActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects Structural Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects Structural Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsStructuralElement(IfcRelConnectsStructuralElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects Structural Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects Structural Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsStructuralMember(IfcRelConnectsStructuralMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects With Eccentricity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects With Eccentricity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsWithEccentricity(IfcRelConnectsWithEccentricity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Connects With Realizing Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Connects With Realizing Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelConnectsWithRealizingElements(IfcRelConnectsWithRealizingElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Contained In Spatial Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Contained In Spatial Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelContainedInSpatialStructure(IfcRelContainedInSpatialStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Covers Bldg Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Covers Bldg Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelCoversBldgElements(IfcRelCoversBldgElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Covers Spaces</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Covers Spaces</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelCoversSpaces(IfcRelCoversSpaces object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Decomposes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Decomposes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelDecomposes(IfcRelDecomposes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Defines</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Defines</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelDefines(IfcRelDefines object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Defines By Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Defines By Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelDefinesByProperties(IfcRelDefinesByProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Defines By Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Defines By Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelDefinesByType(IfcRelDefinesByType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Fills Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Fills Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelFillsElement(IfcRelFillsElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Flow Control Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Flow Control Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelFlowControlElements(IfcRelFlowControlElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Interaction Requirements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Interaction Requirements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelInteractionRequirements(IfcRelInteractionRequirements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Nests</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Nests</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelNests(IfcRelNests object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Occupies Spaces</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Occupies Spaces</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelOccupiesSpaces(IfcRelOccupiesSpaces object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Overrides Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Overrides Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelOverridesProperties(IfcRelOverridesProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Projects Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Projects Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelProjectsElement(IfcRelProjectsElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Referenced In Spatial Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Referenced In Spatial Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelReferencedInSpatialStructure(IfcRelReferencedInSpatialStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Schedules Cost Items</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Schedules Cost Items</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelSchedulesCostItems(IfcRelSchedulesCostItems object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelSequence(IfcRelSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Services Buildings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Services Buildings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelServicesBuildings(IfcRelServicesBuildings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Space Boundary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Space Boundary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelSpaceBoundary(IfcRelSpaceBoundary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rel Voids Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rel Voids Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelVoidsElement(IfcRelVoidsElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelationship(IfcRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Relaxation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Relaxation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRelaxation(IfcRelaxation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRepresentation(IfcRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Representation Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Representation Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRepresentationContext(IfcRepresentationContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Representation Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Representation Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRepresentationItem(IfcRepresentationItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Representation Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Representation Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRepresentationMap(IfcRepresentationMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcResource(IfcResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Revolved Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Revolved Area Solid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRevolvedAreaSolid(IfcRevolvedAreaSolid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rib Plate Profile Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rib Plate Profile Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRibPlateProfileProperties(IfcRibPlateProfileProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Right Circular Cone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Right Circular Cone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRightCircularCone(IfcRightCircularCone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Right Circular Cylinder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Right Circular Cylinder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRightCircularCylinder(IfcRightCircularCylinder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Roof</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Roof</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRoof(IfcRoof object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRoot(IfcRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rounded Edge Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rounded Edge Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRoundedEdgeFeature(IfcRoundedEdgeFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rounded Rectangle Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rounded Rectangle Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRoundedRectangleProfileDef(IfcRoundedRectangleProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc SI Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc SI Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSIUnit(IfcSIUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sanitary Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sanitary Terminal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSanitaryTerminalType(IfcSanitaryTerminalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Schedule Time Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Schedule Time Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcScheduleTimeControl(IfcScheduleTimeControl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Section Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Section Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSectionProperties(IfcSectionProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Section Reinforcement Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Section Reinforcement Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSectionReinforcementProperties(IfcSectionReinforcementProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sectioned Spine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sectioned Spine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSectionedSpine(IfcSectionedSpine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sensor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sensor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSensorType(IfcSensorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Service Life</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Service Life</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcServiceLife(IfcServiceLife object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Service Life Factor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Service Life Factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcServiceLifeFactor(IfcServiceLifeFactor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Shape Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Shape Aspect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcShapeAspect(IfcShapeAspect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Shape Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Shape Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcShapeModel(IfcShapeModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Shape Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Shape Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcShapeRepresentation(IfcShapeRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Shell Based Surface Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Shell Based Surface Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcShellBasedSurfaceModel(IfcShellBasedSurfaceModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Simple Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Simple Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSimpleProperty(IfcSimpleProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Site</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Site</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSite(IfcSite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Slab</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Slab</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSlab(IfcSlab object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Slab Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Slab Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSlabType(IfcSlabType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Slippage Connection Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Slippage Connection Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSlippageConnectionCondition(IfcSlippageConnectionCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Solid Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Solid Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSolidModel(IfcSolidModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sound Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sound Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSoundProperties(IfcSoundProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sound Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sound Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSoundValue(IfcSoundValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpace(IfcSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Space Heater Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Space Heater Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpaceHeaterType(IfcSpaceHeaterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Space Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Space Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpaceProgram(IfcSpaceProgram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Space Thermal Load Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Space Thermal Load Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpaceThermalLoadProperties(IfcSpaceThermalLoadProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Space Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Space Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpaceType(IfcSpaceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Spatial Structure Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Spatial Structure Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpatialStructureElement(IfcSpatialStructureElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Spatial Structure Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Spatial Structure Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpatialStructureElementType(IfcSpatialStructureElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sphere</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sphere</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSphere(IfcSphere object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Stack Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Stack Terminal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStackTerminalType(IfcStackTerminalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Stair</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Stair</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStair(IfcStair object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Stair Flight</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Stair Flight</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStairFlight(IfcStairFlight object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Stair Flight Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Stair Flight Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStairFlightType(IfcStairFlightType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralAction(IfcStructuralAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralActivity(IfcStructuralActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Analysis Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Analysis Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralAnalysisModel(IfcStructuralAnalysisModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralConnection(IfcStructuralConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Connection Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Connection Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralConnectionCondition(IfcStructuralConnectionCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Curve Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Curve Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralCurveConnection(IfcStructuralCurveConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Curve Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Curve Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralCurveMember(IfcStructuralCurveMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Curve Member Varying</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Curve Member Varying</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralCurveMemberVarying(IfcStructuralCurveMemberVarying object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralItem(IfcStructuralItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Linear Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Linear Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLinearAction(IfcStructuralLinearAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Linear Action Varying</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Linear Action Varying</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLinearActionVarying(IfcStructuralLinearActionVarying object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoad(IfcStructuralLoad object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadGroup(IfcStructuralLoadGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Linear Force</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Linear Force</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadLinearForce(IfcStructuralLoadLinearForce object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Planar Force</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Planar Force</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadPlanarForce(IfcStructuralLoadPlanarForce object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Single Displacement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Single Displacement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadSingleDisplacement(IfcStructuralLoadSingleDisplacement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Single Displacement Distortion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Single Displacement Distortion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadSingleDisplacementDistortion(IfcStructuralLoadSingleDisplacementDistortion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Single Force</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Single Force</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadSingleForce(IfcStructuralLoadSingleForce object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Single Force Warping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Single Force Warping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadSingleForceWarping(IfcStructuralLoadSingleForceWarping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Static</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Static</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadStatic(IfcStructuralLoadStatic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Load Temperature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Load Temperature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralLoadTemperature(IfcStructuralLoadTemperature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralMember(IfcStructuralMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Planar Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Planar Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralPlanarAction(IfcStructuralPlanarAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Planar Action Varying</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Planar Action Varying</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralPlanarActionVarying(IfcStructuralPlanarActionVarying object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Point Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Point Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralPointAction(IfcStructuralPointAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Point Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Point Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralPointConnection(IfcStructuralPointConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Point Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Point Reaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralPointReaction(IfcStructuralPointReaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Profile Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Profile Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralProfileProperties(IfcStructuralProfileProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Reaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralReaction(IfcStructuralReaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Result Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Result Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralResultGroup(IfcStructuralResultGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Steel Profile Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Steel Profile Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralSteelProfileProperties(IfcStructuralSteelProfileProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Surface Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Surface Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralSurfaceConnection(IfcStructuralSurfaceConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Surface Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Surface Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralSurfaceMember(IfcStructuralSurfaceMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Surface Member Varying</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Surface Member Varying</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralSurfaceMemberVarying(IfcStructuralSurfaceMemberVarying object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structured Dimension Callout</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structured Dimension Callout</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuredDimensionCallout(IfcStructuredDimensionCallout object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Style Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Style Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStyleModel(IfcStyleModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Styled Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Styled Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStyledItem(IfcStyledItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Styled Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Styled Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStyledRepresentation(IfcStyledRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sub Contract Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sub Contract Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSubContractResource(IfcSubContractResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Subedge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Subedge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSubedge(IfcSubedge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurface(IfcSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Curve Swept Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Curve Swept Area Solid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceCurveSweptAreaSolid(IfcSurfaceCurveSweptAreaSolid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Of Linear Extrusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Of Linear Extrusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceOfLinearExtrusion(IfcSurfaceOfLinearExtrusion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Of Revolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Of Revolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceOfRevolution(IfcSurfaceOfRevolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceStyle(IfcSurfaceStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Style Lighting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Style Lighting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceStyleLighting(IfcSurfaceStyleLighting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Style Refraction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Style Refraction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceStyleRefraction(IfcSurfaceStyleRefraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Style Rendering</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Style Rendering</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceStyleRendering(IfcSurfaceStyleRendering object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Style Shading</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Style Shading</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceStyleShading(IfcSurfaceStyleShading object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Style With Textures</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Style With Textures</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceStyleWithTextures(IfcSurfaceStyleWithTextures object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Texture</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Texture</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceTexture(IfcSurfaceTexture object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Swept Area Solid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Swept Area Solid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSweptAreaSolid(IfcSweptAreaSolid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Swept Disk Solid</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Swept Disk Solid</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSweptDiskSolid(IfcSweptDiskSolid object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Swept Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Swept Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSweptSurface(IfcSweptSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Switching Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Switching Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSwitchingDeviceType(IfcSwitchingDeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Symbol Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Symbol Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSymbolStyle(IfcSymbolStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSystem(IfcSystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc System Furniture Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc System Furniture Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSystemFurnitureElementType(IfcSystemFurnitureElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc TShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc TShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTShapeProfileDef(IfcTShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Table</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTable(IfcTable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Table Row</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Table Row</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTableRow(IfcTableRow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Tank Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Tank Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTankType(IfcTankType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTask(IfcTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Telecom Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Telecom Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTelecomAddress(IfcTelecomAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Tendon</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Tendon</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTendon(IfcTendon object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Tendon Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Tendon Anchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTendonAnchor(IfcTendonAnchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Terminator Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Terminator Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTerminatorSymbol(IfcTerminatorSymbol object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextLiteral(IfcTextLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Literal With Extent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Literal With Extent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextLiteralWithExtent(IfcTextLiteralWithExtent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextStyle(IfcTextStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Style Font Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Style Font Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextStyleFontModel(IfcTextStyleFontModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Style For Defined Font</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Style For Defined Font</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextStyleForDefinedFont(IfcTextStyleForDefinedFont object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Style Text Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Style Text Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextStyleTextModel(IfcTextStyleTextModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Style With Box Characteristics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Style With Box Characteristics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextStyleWithBoxCharacteristics(IfcTextStyleWithBoxCharacteristics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Texture Coordinate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Texture Coordinate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextureCoordinate(IfcTextureCoordinate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Texture Coordinate Generator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Texture Coordinate Generator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextureCoordinateGenerator(IfcTextureCoordinateGenerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Texture Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Texture Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextureMap(IfcTextureMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Texture Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Texture Vertex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextureVertex(IfcTextureVertex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Thermal Material Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Thermal Material Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcThermalMaterialProperties(IfcThermalMaterialProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Time Series</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Time Series</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTimeSeries(IfcTimeSeries object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Time Series Reference Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Time Series Reference Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTimeSeriesReferenceRelationship(IfcTimeSeriesReferenceRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Time Series Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Time Series Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTimeSeriesSchedule(IfcTimeSeriesSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Time Series Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Time Series Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTimeSeriesValue(IfcTimeSeriesValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Topological Representation Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Topological Representation Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTopologicalRepresentationItem(IfcTopologicalRepresentationItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Topology Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Topology Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTopologyRepresentation(IfcTopologyRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Transformer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Transformer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTransformerType(IfcTransformerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Transport Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Transport Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTransportElement(IfcTransportElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Transport Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Transport Element Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTransportElementType(IfcTransportElementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Trapezium Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Trapezium Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTrapeziumProfileDef(IfcTrapeziumProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Trimmed Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Trimmed Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTrimmedCurve(IfcTrimmedCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Tube Bundle Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Tube Bundle Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTubeBundleType(IfcTubeBundleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Two Direction Repeat Factor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Two Direction Repeat Factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTwoDirectionRepeatFactor(IfcTwoDirectionRepeatFactor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Type Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Type Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTypeObject(IfcTypeObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Type Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Type Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTypeProduct(IfcTypeProduct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc UShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc UShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcUShapeProfileDef(IfcUShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Unit Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Unit Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcUnitAssignment(IfcUnitAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Unitary Equipment Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Unitary Equipment Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcUnitaryEquipmentType(IfcUnitaryEquipmentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Valve Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Valve Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcValveType(IfcValveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Vector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Vector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVector(IfcVector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Vertex</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Vertex</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVertex(IfcVertex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Vertex Based Texture Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Vertex Based Texture Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVertexBasedTextureMap(IfcVertexBasedTextureMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Vertex Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Vertex Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVertexLoop(IfcVertexLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Vertex Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Vertex Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVertexPoint(IfcVertexPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Vibration Isolator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Vibration Isolator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVibrationIsolatorType(IfcVibrationIsolatorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Virtual Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Virtual Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVirtualElement(IfcVirtualElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Virtual Grid Intersection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Virtual Grid Intersection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVirtualGridIntersection(IfcVirtualGridIntersection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Wall</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Wall</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWall(IfcWall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Wall Standard Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Wall Standard Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWallStandardCase(IfcWallStandardCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Wall Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Wall Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWallType(IfcWallType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Waste Terminal Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Waste Terminal Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWasteTerminalType(IfcWasteTerminalType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Water Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Water Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWaterProperties(IfcWaterProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Window</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Window</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWindow(IfcWindow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Window Lining Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Window Lining Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWindowLiningProperties(IfcWindowLiningProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Window Panel Properties</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Window Panel Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWindowPanelProperties(IfcWindowPanelProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Window Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Window Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWindowStyle(IfcWindowStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Work Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Work Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWorkControl(IfcWorkControl object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Work Plan</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Work Plan</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWorkPlan(IfcWorkPlan object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Work Schedule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Work Schedule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWorkSchedule(IfcWorkSchedule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc ZShape Profile Def</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc ZShape Profile Def</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcZShapeProfileDef(IfcZShapeProfileDef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Zone</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Zone</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcZone(IfcZone object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Absorbed Dose Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Absorbed Dose Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAbsorbedDoseMeasure(IfcAbsorbedDoseMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Acceleration Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Acceleration Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAccelerationMeasure(IfcAccelerationMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Amount Of Substance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Amount Of Substance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAmountOfSubstanceMeasure(IfcAmountOfSubstanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Angular Velocity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Angular Velocity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAngularVelocityMeasure(IfcAngularVelocityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Area Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Area Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAreaMeasure(IfcAreaMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoolean(IfcBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Context Dependent Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Context Dependent Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcContextDependentMeasure(IfcContextDependentMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Count Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Count Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCountMeasure(IfcCountMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curvature Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curvature Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurvatureMeasure(IfcCurvatureMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Day In Month Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Day In Month Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDayInMonthNumber(IfcDayInMonthNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Daylight Saving Hour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Daylight Saving Hour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDaylightSavingHour(IfcDaylightSavingHour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Descriptive Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Descriptive Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDescriptiveMeasure(IfcDescriptiveMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dimension Count</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dimension Count</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDimensionCount(IfcDimensionCount object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dose Equivalent Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dose Equivalent Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDoseEquivalentMeasure(IfcDoseEquivalentMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Dynamic Viscosity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Dynamic Viscosity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDynamicViscosityMeasure(IfcDynamicViscosityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Capacitance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Capacitance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricCapacitanceMeasure(IfcElectricCapacitanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Charge Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Charge Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricChargeMeasure(IfcElectricChargeMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Conductance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Conductance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricConductanceMeasure(IfcElectricConductanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Current Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Current Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricCurrentMeasure(IfcElectricCurrentMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Resistance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Resistance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricResistanceMeasure(IfcElectricResistanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Electric Voltage Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Electric Voltage Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcElectricVoltageMeasure(IfcElectricVoltageMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Energy Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Energy Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcEnergyMeasure(IfcEnergyMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Font Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Font Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFontStyle(IfcFontStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Font Variant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Font Variant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFontVariant(IfcFontVariant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Font Weight</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Font Weight</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFontWeight(IfcFontWeight object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Force Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Force Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcForceMeasure(IfcForceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Frequency Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Frequency Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFrequencyMeasure(IfcFrequencyMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Globally Unique Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Globally Unique Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGloballyUniqueId(IfcGloballyUniqueId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Heat Flux Density Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Heat Flux Density Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcHeatFluxDensityMeasure(IfcHeatFluxDensityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Heating Value Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Heating Value Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcHeatingValueMeasure(IfcHeatingValueMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Hour In Day</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Hour In Day</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcHourInDay(IfcHourInDay object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcIdentifier(IfcIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Illuminance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Illuminance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcIlluminanceMeasure(IfcIlluminanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Inductance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Inductance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcInductanceMeasure(IfcInductanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcInteger(IfcInteger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Integer Count Rate Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Integer Count Rate Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcIntegerCountRateMeasure(IfcIntegerCountRateMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Ion Concentration Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Ion Concentration Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcIonConcentrationMeasure(IfcIonConcentrationMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Isothermal Moisture Capacity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Isothermal Moisture Capacity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcIsothermalMoistureCapacityMeasure(IfcIsothermalMoistureCapacityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Kinematic Viscosity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Kinematic Viscosity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcKinematicViscosityMeasure(IfcKinematicViscosityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLabel(IfcLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Length Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Length Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLengthMeasure(IfcLengthMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Linear Force Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Linear Force Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLinearForceMeasure(IfcLinearForceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Linear Moment Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Linear Moment Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLinearMomentMeasure(IfcLinearMomentMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Linear Stiffness Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Linear Stiffness Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLinearStiffnessMeasure(IfcLinearStiffnessMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Linear Velocity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Linear Velocity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLinearVelocityMeasure(IfcLinearVelocityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Logical</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Logical</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLogical(IfcLogical object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Luminous Flux Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Luminous Flux Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLuminousFluxMeasure(IfcLuminousFluxMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Luminous Intensity Distribution Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Luminous Intensity Distribution Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLuminousIntensityDistributionMeasure(IfcLuminousIntensityDistributionMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Luminous Intensity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Luminous Intensity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLuminousIntensityMeasure(IfcLuminousIntensityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Magnetic Flux Density Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Magnetic Flux Density Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMagneticFluxDensityMeasure(IfcMagneticFluxDensityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Magnetic Flux Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Magnetic Flux Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMagneticFluxMeasure(IfcMagneticFluxMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mass Density Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mass Density Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMassDensityMeasure(IfcMassDensityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mass Flow Rate Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mass Flow Rate Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMassFlowRateMeasure(IfcMassFlowRateMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mass Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mass Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMassMeasure(IfcMassMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Mass Per Length Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Mass Per Length Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMassPerLengthMeasure(IfcMassPerLengthMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Minute In Hour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Minute In Hour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMinuteInHour(IfcMinuteInHour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Modulus Of Elasticity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Modulus Of Elasticity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcModulusOfElasticityMeasure(IfcModulusOfElasticityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Modulus Of Linear Subgrade Reaction Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Modulus Of Linear Subgrade Reaction Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcModulusOfLinearSubgradeReactionMeasure(IfcModulusOfLinearSubgradeReactionMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Modulus Of Rotational Subgrade Reaction Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Modulus Of Rotational Subgrade Reaction Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcModulusOfRotationalSubgradeReactionMeasure(IfcModulusOfRotationalSubgradeReactionMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Modulus Of Subgrade Reaction Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Modulus Of Subgrade Reaction Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcModulusOfSubgradeReactionMeasure(IfcModulusOfSubgradeReactionMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Moisture Diffusivity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Moisture Diffusivity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMoistureDiffusivityMeasure(IfcMoistureDiffusivityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Molecular Weight Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Molecular Weight Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMolecularWeightMeasure(IfcMolecularWeightMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Moment Of Inertia Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Moment Of Inertia Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMomentOfInertiaMeasure(IfcMomentOfInertiaMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Monetary Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Monetary Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMonetaryMeasure(IfcMonetaryMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Month In Year Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Month In Year Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMonthInYearNumber(IfcMonthInYearNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Numeric Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Numeric Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcNumericMeasure(IfcNumericMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc PH Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc PH Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPHMeasure(IfcPHMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Parameter Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Parameter Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcParameterValue(IfcParameterValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Planar Force Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Planar Force Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPlanarForceMeasure(IfcPlanarForceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Plane Angle Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Plane Angle Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPlaneAngleMeasure(IfcPlaneAngleMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Power Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Power Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPowerMeasure(IfcPowerMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Presentable Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Presentable Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPresentableText(IfcPresentableText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Pressure Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Pressure Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPressureMeasure(IfcPressureMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Radio Activity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Radio Activity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRadioActivityMeasure(IfcRadioActivityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Ratio Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRatioMeasure(IfcRatioMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Real</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Real</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcReal(IfcReal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rotational Frequency Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rotational Frequency Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRotationalFrequencyMeasure(IfcRotationalFrequencyMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rotational Mass Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rotational Mass Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRotationalMassMeasure(IfcRotationalMassMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Rotational Stiffness Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Rotational Stiffness Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcRotationalStiffnessMeasure(IfcRotationalStiffnessMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Second In Minute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Second In Minute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSecondInMinute(IfcSecondInMinute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Section Modulus Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Section Modulus Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSectionModulusMeasure(IfcSectionModulusMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sectional Area Integral Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sectional Area Integral Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSectionalAreaIntegralMeasure(IfcSectionalAreaIntegralMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Shear Modulus Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Shear Modulus Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcShearModulusMeasure(IfcShearModulusMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Solid Angle Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Solid Angle Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSolidAngleMeasure(IfcSolidAngleMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sound Power Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sound Power Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSoundPowerMeasure(IfcSoundPowerMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Sound Pressure Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Sound Pressure Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSoundPressureMeasure(IfcSoundPressureMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Specific Heat Capacity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Specific Heat Capacity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpecificHeatCapacityMeasure(IfcSpecificHeatCapacityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Specular Exponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Specular Exponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpecularExponent(IfcSpecularExponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Specular Roughness</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Specular Roughness</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpecularRoughness(IfcSpecularRoughness object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Temperature Gradient Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Temperature Gradient Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTemperatureGradientMeasure(IfcTemperatureGradientMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcText(IfcText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Alignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Alignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextAlignment(IfcTextAlignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Decoration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Decoration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextDecoration(IfcTextDecoration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Font Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Font Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextFontName(IfcTextFontName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextTransformation(IfcTextTransformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Thermal Admittance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Thermal Admittance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcThermalAdmittanceMeasure(IfcThermalAdmittanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Thermal Conductivity Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Thermal Conductivity Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcThermalConductivityMeasure(IfcThermalConductivityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Thermal Expansion Coefficient Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Thermal Expansion Coefficient Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcThermalExpansionCoefficientMeasure(IfcThermalExpansionCoefficientMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Thermal Resistance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Thermal Resistance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcThermalResistanceMeasure(IfcThermalResistanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Thermal Transmittance Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Thermal Transmittance Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcThermalTransmittanceMeasure(IfcThermalTransmittanceMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Thermodynamic Temperature Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Thermodynamic Temperature Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcThermodynamicTemperatureMeasure(IfcThermodynamicTemperatureMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Time Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Time Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTimeMeasure(IfcTimeMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Time Stamp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Time Stamp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTimeStamp(IfcTimeStamp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Torque Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Torque Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTorqueMeasure(IfcTorqueMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Vapor Permeability Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Vapor Permeability Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVaporPermeabilityMeasure(IfcVaporPermeabilityMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Volume Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Volume Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVolumeMeasure(IfcVolumeMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Volumetric Flow Rate Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Volumetric Flow Rate Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVolumetricFlowRateMeasure(IfcVolumetricFlowRateMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Warping Constant Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Warping Constant Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWarpingConstantMeasure(IfcWarpingConstantMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Warping Moment Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Warping Moment Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcWarpingMomentMeasure(IfcWarpingMomentMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Year Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Year Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcYearNumber(IfcYearNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Box Alignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Box Alignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBoxAlignment(IfcBoxAlignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Compound Plane Angle Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Compound Plane Angle Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCompoundPlaneAngleMeasure(IfcCompoundPlaneAngleMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Normalised Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Normalised Ratio Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcNormalisedRatioMeasure(IfcNormalisedRatioMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Positive Length Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Positive Length Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPositiveLengthMeasure(IfcPositiveLengthMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Positive Plane Angle Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Positive Plane Angle Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPositivePlaneAngleMeasure(IfcPositivePlaneAngleMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Positive Ratio Measure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Positive Ratio Measure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPositiveRatioMeasure(IfcPositiveRatioMeasure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Complex Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Complex Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcComplexNumber(IfcComplexNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Null Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Null Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcNullStyle(IfcNullStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Actor Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Actor Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcActorSelect(IfcActorSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Applied Value Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Applied Value Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAppliedValueSelect(IfcAppliedValueSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Axis2 Placement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Axis2 Placement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcAxis2Placement(IfcAxis2Placement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Boolean Operand</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Boolean Operand</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcBooleanOperand(IfcBooleanOperand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Character Style Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Character Style Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCharacterStyleSelect(IfcCharacterStyleSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Classification Notation Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Classification Notation Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcClassificationNotationSelect(IfcClassificationNotationSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Colour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Colour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcColour(IfcColour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Colour Or Factor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Colour Or Factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcColourOrFactor(IfcColourOrFactor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Condition Criterion Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Condition Criterion Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcConditionCriterionSelect(IfcConditionCriterionSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Csg Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Csg Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCsgSelect(IfcCsgSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve Font Or Scaled Curve Font Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve Font Or Scaled Curve Font Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurveFontOrScaledCurveFontSelect(IfcCurveFontOrScaledCurveFontSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve Or Edge Curve</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve Or Edge Curve</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurveOrEdgeCurve(IfcCurveOrEdgeCurve object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Curve Style Font Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Curve Style Font Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcCurveStyleFontSelect(IfcCurveStyleFontSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Date Time Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Date Time Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDateTimeSelect(IfcDateTimeSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Defined Symbol Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Defined Symbol Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDefinedSymbolSelect(IfcDefinedSymbolSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Derived Measure Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Derived Measure Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDerivedMeasureValue(IfcDerivedMeasureValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Document Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Document Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDocumentSelect(IfcDocumentSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Draughting Callout Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Draughting Callout Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcDraughtingCalloutElement(IfcDraughtingCalloutElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fill Area Style Tile Shape Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fill Area Style Tile Shape Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFillAreaStyleTileShapeSelect(IfcFillAreaStyleTileShapeSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Fill Style Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Fill Style Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcFillStyleSelect(IfcFillStyleSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Geometric Set Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Geometric Set Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcGeometricSetSelect(IfcGeometricSetSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Hatch Line Distance Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Hatch Line Distance Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcHatchLineDistanceSelect(IfcHatchLineDistanceSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Layered Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Layered Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLayeredItem(IfcLayeredItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Library Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Library Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLibrarySelect(IfcLibrarySelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Light Distribution Data Source Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Light Distribution Data Source Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcLightDistributionDataSourceSelect(IfcLightDistributionDataSourceSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Material Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Material Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMaterialSelect(IfcMaterialSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Measure Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Measure Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMeasureValue(IfcMeasureValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Metric Value Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Metric Value Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcMetricValueSelect(IfcMetricValueSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Object Reference Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Object Reference Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcObjectReferenceSelect(IfcObjectReferenceSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Orientation Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Orientation Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcOrientationSelect(IfcOrientationSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Point Or Vertex Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Point Or Vertex Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPointOrVertexPoint(IfcPointOrVertexPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Presentation Style Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Presentation Style Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcPresentationStyleSelect(IfcPresentationStyleSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Shell</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Shell</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcShell(IfcShell object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Simple Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Simple Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSimpleValue(IfcSimpleValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Size Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Size Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSizeSelect(IfcSizeSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Specular Highlight Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Specular Highlight Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSpecularHighlightSelect(IfcSpecularHighlightSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Structural Activity Assignment Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Structural Activity Assignment Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcStructuralActivityAssignmentSelect(IfcStructuralActivityAssignmentSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Or Face Surface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Or Face Surface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceOrFaceSurface(IfcSurfaceOrFaceSurface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Surface Style Element Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Surface Style Element Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSurfaceStyleElementSelect(IfcSurfaceStyleElementSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Symbol Style Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Symbol Style Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcSymbolStyleSelect(IfcSymbolStyleSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Font Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Font Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextFontSelect(IfcTextFontSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Text Style Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Text Style Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTextStyleSelect(IfcTextStyleSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Trimming Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Trimming Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcTrimmingSelect(IfcTrimmingSelect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcUnit(IfcUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcValue(IfcValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ifc Vector Or Direction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ifc Vector Or Direction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfcVectorOrDirection(IfcVectorOrDirection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Ifc2x3tc1Switch
