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

import java.io.IOException;
import java.net.URL;

import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.geometry.impl.GeometryPackageImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.impl.Ifc4PackageImpl;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.impl.LogPackageImpl;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.impl.StorePackageImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Ifc2x3tc1PackageImpl extends EPackageImpl implements Ifc2x3tc1Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "ifc2x3tc1.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifc2DCompositeCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcActionRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcActorRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcActuatorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAddressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAirTerminalBoxTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAirTerminalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAirToAirHeatRecoveryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAlarmTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAngularDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationCurveOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationFillAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationFillAreaOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationSurfaceOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationSymbolOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAnnotationTextOccurrenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAppliedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAppliedValueRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcApprovalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcApprovalActorRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcApprovalPropertyRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcApprovalRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcArbitraryClosedProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcArbitraryOpenProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcArbitraryProfileDefWithVoidsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAsymmetricIShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAxis1PlacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAxis2Placement2DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAxis2Placement3DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBSplineCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBeamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBeamTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBezierCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBlobTextureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoilerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBooleanClippingResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBooleanResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoundaryConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoundaryEdgeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoundaryFaceConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoundaryNodeConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoundaryNodeConditionWarpingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoundedCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoundedSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoundingBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoxedHalfSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBuildingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBuildingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBuildingElementComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBuildingElementPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBuildingElementProxyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBuildingElementProxyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBuildingElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBuildingStoreyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCableCarrierFittingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCableCarrierSegmentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCableSegmentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCalendarDateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCartesianPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCartesianTransformationOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCartesianTransformationOperator2DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCartesianTransformationOperator2DnonUniformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCartesianTransformationOperator3DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCartesianTransformationOperator3DnonUniformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCenterLineProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcChamferEdgeFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcChillerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCircleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCircleHollowProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCircleProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcClassificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcClassificationItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcClassificationItemRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcClassificationNotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcClassificationNotationFacetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcClassificationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcClosedShellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCoilTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcColourRgbEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcColourSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcColumnTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcComplexPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCompositeCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCompositeCurveSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCompositeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCompressorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCondenserTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConditionCriterionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConnectedFaceSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConnectionCurveGeometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConnectionGeometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConnectionPointEccentricityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConnectionPointGeometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConnectionPortGeometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConnectionSurfaceGeometryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConstraintAggregationRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConstraintClassificationRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConstraintRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConstructionEquipmentResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConstructionMaterialResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConstructionProductResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConstructionResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcContextDependentUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcControllerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConversionBasedUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCooledBeamTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCoolingTowerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCoordinatedUniversalTimeOffsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCostItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCostScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCostValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCoveringEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCoveringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCraneRailAShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCraneRailFShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCrewResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCsgPrimitive3DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCsgSolidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurrencyRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurtainWallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurtainWallTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveBoundedPlaneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveStyleFontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveStyleFontAndScalingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveStyleFontPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDamperTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDateAndTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDefinedSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDerivedProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDerivedUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDerivedUnitElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDiameterDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDimensionCalloutRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDimensionCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDimensionCurveDirectedCalloutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDimensionCurveTerminatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDimensionPairEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDimensionalExponentsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDirectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDiscreteAccessoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDiscreteAccessoryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionChamberElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionChamberElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionControlElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionControlElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionFlowElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionFlowElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDistributionPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDocumentElectronicFormatEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDocumentInformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDocumentInformationRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDocumentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDoorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDoorLiningPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDoorPanelPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDoorStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDraughtingCalloutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDraughtingCalloutRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDraughtingPreDefinedColourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDraughtingPreDefinedCurveFontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDraughtingPreDefinedTextFontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDuctFittingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDuctSegmentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDuctSilencerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEdgeCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEdgeFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEdgeLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricApplianceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricDistributionPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricFlowStorageDeviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricGeneratorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricHeaterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricMotorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricTimeControlTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricalBasePropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricalCircuitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricalElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElementAssemblyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElementComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElementComponentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElementQuantityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElementarySurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEllipseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEllipseProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEnergyConversionDeviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEnergyConversionDeviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEnergyPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEnvironmentalImpactValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEquipmentElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEquipmentStandardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEvaporativeCoolerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEvaporatorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcExtendedMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcExternalReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcExternallyDefinedHatchStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcExternallyDefinedSurfaceStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcExternallyDefinedSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcExternallyDefinedTextFontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcExtrudedAreaSolidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFaceBasedSurfaceModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFaceBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFaceOuterBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFaceSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFacetedBrepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFacetedBrepWithVoidsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFailureConnectionConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFastenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFastenerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFeatureElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFeatureElementAdditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFeatureElementSubtractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFillAreaStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFillAreaStyleHatchingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFillAreaStyleTileSymbolWithStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFillAreaStyleTilesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFilterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFireSuppressionTerminalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowControllerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowControllerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowFittingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowFittingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowInstrumentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowMeterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowMovingDeviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowMovingDeviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowSegmentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowStorageDeviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowStorageDeviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowTerminalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowTerminalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowTreatmentDeviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFlowTreatmentDeviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFluidFlowPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFootingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFuelPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFurnishingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFurnishingElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFurnitureStandardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFurnitureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGasTerminalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGeneralMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGeneralProfilePropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGeometricCurveSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGeometricRepresentationContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGeometricRepresentationItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGeometricRepresentationSubContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGeometricSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGridEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGridAxisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGridPlacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHalfSpaceSolidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHeatExchangerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHumidifierTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHygroscopicMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcImageTextureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcInventoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIrregularTimeSeriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIrregularTimeSeriesValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcJunctionBoxTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLaborResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLampTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLibraryInformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLibraryReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightDistributionDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightFixtureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightIntensityDistributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightSourceAmbientEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightSourceDirectionalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightSourceGoniometricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightSourcePositionalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightSourceSpotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLinearDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLocalPlacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLocalTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcManifoldSolidBrepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMappedItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialClassificationRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialDefinitionRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialLayerSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialLayerSetUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMeasureWithUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMechanicalConcreteMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMechanicalFastenerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMechanicalFastenerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMechanicalMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMechanicalSteelMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMemberTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMetricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMonetaryUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMotorConnectionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMoveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcNamedUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcObjectDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcObjectPlacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcObjectiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOccupantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOffsetCurve2DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOffsetCurve3DEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOneDirectionRepeatFactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOpenShellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOpeningElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOpticalMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOrderActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOrganizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOrganizationRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOrientedEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOutletTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOwnerHistoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcParameterizedProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPerformanceHistoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPermeableCoveringPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPermitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPersonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPersonAndOrganizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPhysicalComplexQuantityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPhysicalQuantityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPhysicalSimpleQuantityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPipeFittingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPipeSegmentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPixelTextureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPlacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPlanarBoxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPlanarExtentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPlaneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPlateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPlateTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPointOnCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPointOnSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPolyLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPolygonalBoundedHalfSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPolylineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPostalAddressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPreDefinedColourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPreDefinedCurveFontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPreDefinedDimensionSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPreDefinedItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPreDefinedPointMarkerSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPreDefinedSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPreDefinedTerminatorSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPreDefinedTextFontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPresentationLayerAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPresentationLayerWithStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPresentationStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPresentationStyleAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProcedureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProductEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProductDefinitionShapeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProductRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProductsOfCombustionPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProfilePropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProjectOrderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProjectOrderRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProjectionCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProjectionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyBoundedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyConstraintRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyDependencyRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyEnumeratedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyEnumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyListValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyReferenceValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertySetDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertySingleValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPropertyTableValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProtectiveDeviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcProxyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPumpTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcQuantityAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcQuantityCountEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcQuantityLengthEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcQuantityTimeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcQuantityVolumeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcQuantityWeightEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRadiusDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRailingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRailingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRampEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRampFlightEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRampFlightTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRationalBezierCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRectangleHollowProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRectangleProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRectangularPyramidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRectangularTrimmedSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcReferencesValueDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRegularTimeSeriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcReinforcementBarPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcReinforcementDefinitionPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcReinforcingBarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcReinforcingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcReinforcingMeshEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAggregatesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsTasksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsToActorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsToControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsToGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsToProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsToProductEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsToProjectOrderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssignsToResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesAppliedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesApprovalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesClassificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesMaterialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelAssociatesProfilePropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsPathElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsPortToElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsPortsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsStructuralActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsStructuralElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsStructuralMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsWithEccentricityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelConnectsWithRealizingElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelContainedInSpatialStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelCoversBldgElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelCoversSpacesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelDecomposesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelDefinesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelDefinesByPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelDefinesByTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelFillsElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelFlowControlElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelInteractionRequirementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelNestsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelOccupiesSpacesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelOverridesPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelProjectsElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelReferencedInSpatialStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelSchedulesCostItemsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelServicesBuildingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelSpaceBoundaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelVoidsElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRelaxationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRepresentationContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRepresentationItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRepresentationMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRevolvedAreaSolidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRibPlateProfilePropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRightCircularConeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRightCircularCylinderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRoofEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRoundedEdgeFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRoundedRectangleProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSIUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSanitaryTerminalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcScheduleTimeControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSectionPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSectionReinforcementPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSectionedSpineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSensorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcServiceLifeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcServiceLifeFactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcShapeAspectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcShapeModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcShapeRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcShellBasedSurfaceModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSimplePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSiteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSlabEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSlabTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSlippageConnectionConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSolidModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSoundPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSoundValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpaceHeaterTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpaceProgramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpaceThermalLoadPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpaceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpatialStructureElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpatialStructureElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSphereEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStackTerminalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStairEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStairFlightEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStairFlightTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralAnalysisModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralConnectionConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralCurveConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralCurveMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralCurveMemberVaryingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLinearActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLinearActionVaryingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadLinearForceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadPlanarForceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadSingleDisplacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadSingleDisplacementDistortionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadSingleForceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadSingleForceWarpingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadStaticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralLoadTemperatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralPlanarActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralPlanarActionVaryingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralPointActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralPointConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralPointReactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralProfilePropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralReactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralResultGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralSteelProfilePropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralSurfaceConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralSurfaceMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralSurfaceMemberVaryingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuredDimensionCalloutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStyleModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStyledItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStyledRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSubContractResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSubedgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceCurveSweptAreaSolidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceOfLinearExtrusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceOfRevolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceStyleLightingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceStyleRefractionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceStyleRenderingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceStyleShadingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceStyleWithTexturesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceTextureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSweptAreaSolidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSweptDiskSolidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSweptSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSwitchingDeviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSymbolStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSystemFurnitureElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTableRowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTankTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTelecomAddressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTendonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTendonAnchorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTerminatorSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextLiteralWithExtentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextStyleFontModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextStyleForDefinedFontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextStyleTextModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextStyleWithBoxCharacteristicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextureCoordinateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextureCoordinateGeneratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextureMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextureVertexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcThermalMaterialPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTimeSeriesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTimeSeriesReferenceRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTimeSeriesScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTimeSeriesValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTopologicalRepresentationItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTopologyRepresentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTransformerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTransportElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTransportElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTrapeziumProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTrimmedCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTubeBundleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTwoDirectionRepeatFactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTypeObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTypeProductEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcUShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcUnitAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcUnitaryEquipmentTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcValveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVertexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVertexBasedTextureMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVertexLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVertexPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVibrationIsolatorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVirtualElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVirtualGridIntersectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWallStandardCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWallTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWasteTerminalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWaterPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWindowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWindowLiningPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWindowPanelPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWindowStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWorkControlEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWorkPlanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWorkScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcZShapeProfileDefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcZoneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAbsorbedDoseMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAccelerationMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAmountOfSubstanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAngularVelocityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAreaMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBooleanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcContextDependentMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCountMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurvatureMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDayInMonthNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDaylightSavingHourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDescriptiveMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDimensionCountEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDoseEquivalentMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDynamicViscosityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricCapacitanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricChargeMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricConductanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricCurrentMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricResistanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcElectricVoltageMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcEnergyMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFontStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFontVariantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFontWeightEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcForceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFrequencyMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGloballyUniqueIdEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHeatFluxDensityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHeatingValueMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHourInDayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIlluminanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcInductanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIntegerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIntegerCountRateMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIonConcentrationMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcIsothermalMoistureCapacityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcKinematicViscosityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLengthMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLinearForceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLinearMomentMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLinearStiffnessMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLinearVelocityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLogicalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLuminousFluxMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLuminousIntensityDistributionMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLuminousIntensityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMagneticFluxDensityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMagneticFluxMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMassDensityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMassFlowRateMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMassMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMassPerLengthMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMinuteInHourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcModulusOfElasticityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcModulusOfLinearSubgradeReactionMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcModulusOfRotationalSubgradeReactionMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcModulusOfSubgradeReactionMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMoistureDiffusivityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMolecularWeightMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMomentOfInertiaMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMonetaryMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMonthInYearNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcNumericMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPHMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcParameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPlanarForceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPlaneAngleMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPowerMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPresentableTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPressureMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRadioActivityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRatioMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRealEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRotationalFrequencyMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRotationalMassMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcRotationalStiffnessMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSecondInMinuteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSectionModulusMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSectionalAreaIntegralMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcShearModulusMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSolidAngleMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSoundPowerMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSoundPressureMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpecificHeatCapacityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpecularExponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpecularRoughnessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTemperatureGradientMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextAlignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextDecorationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextFontNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcThermalAdmittanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcThermalConductivityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcThermalExpansionCoefficientMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcThermalResistanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcThermalTransmittanceMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcThermodynamicTemperatureMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTimeMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTimeStampEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTorqueMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVaporPermeabilityMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVolumeMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVolumetricFlowRateMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWarpingConstantMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcWarpingMomentMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcYearNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBoxAlignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCompoundPlaneAngleMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcNormalisedRatioMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPositiveLengthMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPositivePlaneAngleMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPositiveRatioMeasureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcComplexNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcNullStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcActorSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAppliedValueSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcAxis2PlacementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcBooleanOperandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCharacterStyleSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcClassificationNotationSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcColourEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcColourOrFactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcConditionCriterionSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCsgSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveFontOrScaledCurveFontSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveOrEdgeCurveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcCurveStyleFontSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDateTimeSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDefinedSymbolSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDerivedMeasureValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDocumentSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcDraughtingCalloutElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFillAreaStyleTileShapeSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcFillStyleSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcGeometricSetSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcHatchLineDistanceSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLayeredItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLibrarySelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcLightDistributionDataSourceSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMaterialSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMeasureValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcMetricValueSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcObjectReferenceSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcOrientationSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPointOrVertexPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcPresentationStyleSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcShellEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSimpleValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSizeSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSpecularHighlightSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcStructuralActivityAssignmentSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceOrFaceSurfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSurfaceStyleElementSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcSymbolStyleSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextFontSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTextStyleSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcTrimmingSelectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifcVectorOrDirectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tristateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcActionSourceTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcActionTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcActuatorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAddressTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAheadOrBehindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAirTerminalBoxTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAirTerminalTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAirToAirHeatRecoveryTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAlarmTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAnalysisModelTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAnalysisTheoryTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcArithmeticOperatorEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcAssemblyPlaceEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcBSplineCurveFormEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcBeamTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcBenchmarkEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcBoilerTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcBooleanOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcBuildingElementProxyTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCableCarrierFittingTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCableCarrierSegmentTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCableSegmentTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcChangeActionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcChillerTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCoilTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcColumnTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCompressorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCondenserTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcConnectionTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcConstraintEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcControllerTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCooledBeamTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCoolingTowerTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCostScheduleTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCoveringTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCurrencyEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcCurtainWallTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDamperTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDataOriginEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDerivedUnitEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDimensionExtentUsageEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDirectionSenseEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDistributionChamberElementTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDocumentConfidentialityEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDocumentStatusEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDoorPanelOperationEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDoorPanelPositionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDoorStyleConstructionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDoorStyleOperationEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDuctFittingTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDuctSegmentTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcDuctSilencerTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElectricApplianceTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElectricCurrentEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElectricDistributionPointFunctionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElectricFlowStorageDeviceTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElectricGeneratorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElectricHeaterTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElectricMotorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElectricTimeControlTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElementAssemblyTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcElementCompositionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcEnergySequenceEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcEnvironmentalImpactCategoryEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcEvaporativeCoolerTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcEvaporatorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcFanTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcFilterTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcFireSuppressionTerminalTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcFlowDirectionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcFlowInstrumentTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcFlowMeterTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcFootingTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcGasTerminalTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcGeometricProjectionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcGlobalOrLocalEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcHeatExchangerTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcHumidifierTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcInternalOrExternalEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcInventoryTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcJunctionBoxTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcLampTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcLayerSetDirectionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcLightDistributionCurveEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcLightEmissionSourceEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcLightFixtureTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcLoadGroupTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcLogicalOperatorEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcMemberTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcMotorConnectionTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcNullStyleEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcObjectTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcObjectiveEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcOccupantTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcOutletTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPermeableCoveringOperationEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPhysicalOrVirtualEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPileConstructionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPileTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPipeFittingTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPipeSegmentTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPlateTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcProcedureTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcProfileTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcProjectOrderRecordTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcProjectOrderTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcProjectedOrTrueLengthEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPropertySourceEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcProtectiveDeviceTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcPumpTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcRailingTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcRampFlightTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcRampTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcReflectanceMethodEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcReinforcingBarRoleEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcReinforcingBarSurfaceEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcResourceConsumptionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcRibPlateDirectionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcRoleEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcRoofTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSIPrefixEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSIUnitNameEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSanitaryTerminalTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSectionTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSensorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSequenceEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcServiceLifeFactorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcServiceLifeTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSlabTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSoundScaleEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSpaceHeaterTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSpaceTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcStackTerminalTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcStairFlightTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcStairTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcStateEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcStructuralCurveTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcStructuralSurfaceTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSurfaceSideEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSurfaceTextureEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcSwitchingDeviceTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTankTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTendonTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTextPathEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcThermalLoadSourceEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcThermalLoadTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTimeSeriesDataTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTimeSeriesScheduleTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTransformerTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTransitionCodeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTransportElementTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTrimmingPreferenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcTubeBundleTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcUnitEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcUnitaryEquipmentTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcValveTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcVibrationIsolatorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcWallTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcWasteTerminalTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcWindowPanelOperationEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcWindowPanelPositionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcWindowStyleConstructionEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcWindowStyleOperationEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ifcWorkControlTypeEnumEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Ifc2x3tc1PackageImpl() {
		super(eNS_URI, Ifc2x3tc1Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link Ifc2x3tc1Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static Ifc2x3tc1Package init() {
		if (isInited)
			return (Ifc2x3tc1Package) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI);

		// Obtain or create and register package
		Object registeredIfc2x3tc1Package = EPackage.Registry.INSTANCE.get(eNS_URI);
		Ifc2x3tc1PackageImpl theIfc2x3tc1Package = registeredIfc2x3tc1Package instanceof Ifc2x3tc1PackageImpl
				? (Ifc2x3tc1PackageImpl) registeredIfc2x3tc1Package
				: new Ifc2x3tc1PackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(GeometryPackage.eNS_URI);
		GeometryPackageImpl theGeometryPackage = (GeometryPackageImpl) (registeredPackage instanceof GeometryPackageImpl
				? registeredPackage
				: GeometryPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(Ifc4Package.eNS_URI);
		Ifc4PackageImpl theIfc4Package = (Ifc4PackageImpl) (registeredPackage instanceof Ifc4PackageImpl
				? registeredPackage
				: Ifc4Package.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI);
		LogPackageImpl theLogPackage = (LogPackageImpl) (registeredPackage instanceof LogPackageImpl ? registeredPackage
				: LogPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI);
		StorePackageImpl theStorePackage = (StorePackageImpl) (registeredPackage instanceof StorePackageImpl
				? registeredPackage
				: StorePackage.eINSTANCE);

		// Load packages
		theIfc2x3tc1Package.loadPackage();
		theGeometryPackage.loadPackage();
		theIfc4Package.loadPackage();
		theLogPackage.loadPackage();
		theStorePackage.loadPackage();

		// Fix loaded packages
		theIfc2x3tc1Package.fixPackageContents();
		theGeometryPackage.fixPackageContents();
		theIfc4Package.fixPackageContents();
		theLogPackage.fixPackageContents();
		theStorePackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theIfc2x3tc1Package.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Ifc2x3tc1Package.eNS_URI, theIfc2x3tc1Package);
		return theIfc2x3tc1Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfc2DCompositeCurve() {
		if (ifc2DCompositeCurveEClass == null) {
			ifc2DCompositeCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(1);
		}
		return ifc2DCompositeCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcActionRequest() {
		if (ifcActionRequestEClass == null) {
			ifcActionRequestEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(2);
		}
		return ifcActionRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcActionRequest_RequestID() {
		return (EAttribute) getIfcActionRequest().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcActor() {
		if (ifcActorEClass == null) {
			ifcActorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(3);
		}
		return ifcActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcActor_TheActor() {
		return (EReference) getIfcActor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcActor_IsActingUpon() {
		return (EReference) getIfcActor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcActorRole() {
		if (ifcActorRoleEClass == null) {
			ifcActorRoleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(4);
		}
		return ifcActorRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcActorRole_Role() {
		return (EAttribute) getIfcActorRole().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcActorRole_UserDefinedRole() {
		return (EAttribute) getIfcActorRole().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcActorRole_Description() {
		return (EAttribute) getIfcActorRole().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcActuatorType() {
		if (ifcActuatorTypeEClass == null) {
			ifcActuatorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(5);
		}
		return ifcActuatorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcActuatorType_PredefinedType() {
		return (EAttribute) getIfcActuatorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAddress() {
		if (ifcAddressEClass == null) {
			ifcAddressEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(6);
		}
		return ifcAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAddress_Purpose() {
		return (EAttribute) getIfcAddress().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAddress_Description() {
		return (EAttribute) getIfcAddress().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAddress_UserDefinedPurpose() {
		return (EAttribute) getIfcAddress().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAddress_OfPerson() {
		return (EReference) getIfcAddress().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAddress_OfOrganization() {
		return (EReference) getIfcAddress().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAirTerminalBoxType() {
		if (ifcAirTerminalBoxTypeEClass == null) {
			ifcAirTerminalBoxTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(7);
		}
		return ifcAirTerminalBoxTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAirTerminalBoxType_PredefinedType() {
		return (EAttribute) getIfcAirTerminalBoxType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAirTerminalType() {
		if (ifcAirTerminalTypeEClass == null) {
			ifcAirTerminalTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(8);
		}
		return ifcAirTerminalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAirTerminalType_PredefinedType() {
		return (EAttribute) getIfcAirTerminalType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAirToAirHeatRecoveryType() {
		if (ifcAirToAirHeatRecoveryTypeEClass == null) {
			ifcAirToAirHeatRecoveryTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(9);
		}
		return ifcAirToAirHeatRecoveryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAirToAirHeatRecoveryType_PredefinedType() {
		return (EAttribute) getIfcAirToAirHeatRecoveryType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAlarmType() {
		if (ifcAlarmTypeEClass == null) {
			ifcAlarmTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(10);
		}
		return ifcAlarmTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAlarmType_PredefinedType() {
		return (EAttribute) getIfcAlarmType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAngularDimension() {
		if (ifcAngularDimensionEClass == null) {
			ifcAngularDimensionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(11);
		}
		return ifcAngularDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotation() {
		if (ifcAnnotationEClass == null) {
			ifcAnnotationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(12);
		}
		return ifcAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAnnotation_ContainedInStructure() {
		return (EReference) getIfcAnnotation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotationCurveOccurrence() {
		if (ifcAnnotationCurveOccurrenceEClass == null) {
			ifcAnnotationCurveOccurrenceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(13);
		}
		return ifcAnnotationCurveOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotationFillArea() {
		if (ifcAnnotationFillAreaEClass == null) {
			ifcAnnotationFillAreaEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(14);
		}
		return ifcAnnotationFillAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAnnotationFillArea_OuterBoundary() {
		return (EReference) getIfcAnnotationFillArea().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAnnotationFillArea_InnerBoundaries() {
		return (EReference) getIfcAnnotationFillArea().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotationFillAreaOccurrence() {
		if (ifcAnnotationFillAreaOccurrenceEClass == null) {
			ifcAnnotationFillAreaOccurrenceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(15);
		}
		return ifcAnnotationFillAreaOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAnnotationFillAreaOccurrence_FillStyleTarget() {
		return (EReference) getIfcAnnotationFillAreaOccurrence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAnnotationFillAreaOccurrence_GlobalOrLocal() {
		return (EAttribute) getIfcAnnotationFillAreaOccurrence().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotationOccurrence() {
		if (ifcAnnotationOccurrenceEClass == null) {
			ifcAnnotationOccurrenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(16);
		}
		return ifcAnnotationOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotationSurface() {
		if (ifcAnnotationSurfaceEClass == null) {
			ifcAnnotationSurfaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(17);
		}
		return ifcAnnotationSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAnnotationSurface_Item() {
		return (EReference) getIfcAnnotationSurface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAnnotationSurface_TextureCoordinates() {
		return (EReference) getIfcAnnotationSurface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotationSurfaceOccurrence() {
		if (ifcAnnotationSurfaceOccurrenceEClass == null) {
			ifcAnnotationSurfaceOccurrenceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(18);
		}
		return ifcAnnotationSurfaceOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotationSymbolOccurrence() {
		if (ifcAnnotationSymbolOccurrenceEClass == null) {
			ifcAnnotationSymbolOccurrenceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(19);
		}
		return ifcAnnotationSymbolOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAnnotationTextOccurrence() {
		if (ifcAnnotationTextOccurrenceEClass == null) {
			ifcAnnotationTextOccurrenceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(20);
		}
		return ifcAnnotationTextOccurrenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcApplication() {
		if (ifcApplicationEClass == null) {
			ifcApplicationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(21);
		}
		return ifcApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApplication_ApplicationDeveloper() {
		return (EReference) getIfcApplication().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApplication_Version() {
		return (EAttribute) getIfcApplication().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApplication_ApplicationFullName() {
		return (EAttribute) getIfcApplication().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApplication_ApplicationIdentifier() {
		return (EAttribute) getIfcApplication().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAppliedValue() {
		if (ifcAppliedValueEClass == null) {
			ifcAppliedValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(22);
		}
		return ifcAppliedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAppliedValue_Name() {
		return (EAttribute) getIfcAppliedValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAppliedValue_Description() {
		return (EAttribute) getIfcAppliedValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValue_AppliedValue() {
		return (EReference) getIfcAppliedValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValue_UnitBasis() {
		return (EReference) getIfcAppliedValue().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValue_ApplicableDate() {
		return (EReference) getIfcAppliedValue().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValue_FixedUntilDate() {
		return (EReference) getIfcAppliedValue().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValue_ValuesReferenced() {
		return (EReference) getIfcAppliedValue().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValue_ValueOfComponents() {
		return (EReference) getIfcAppliedValue().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValue_IsComponentIn() {
		return (EReference) getIfcAppliedValue().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAppliedValueRelationship() {
		if (ifcAppliedValueRelationshipEClass == null) {
			ifcAppliedValueRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(23);
		}
		return ifcAppliedValueRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValueRelationship_ComponentOfTotal() {
		return (EReference) getIfcAppliedValueRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAppliedValueRelationship_Components() {
		return (EReference) getIfcAppliedValueRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAppliedValueRelationship_ArithmeticOperator() {
		return (EAttribute) getIfcAppliedValueRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAppliedValueRelationship_Name() {
		return (EAttribute) getIfcAppliedValueRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAppliedValueRelationship_Description() {
		return (EAttribute) getIfcAppliedValueRelationship().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcApproval() {
		if (ifcApprovalEClass == null) {
			ifcApprovalEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(24);
		}
		return ifcApprovalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApproval_Description() {
		return (EAttribute) getIfcApproval().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApproval_ApprovalDateTime() {
		return (EReference) getIfcApproval().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApproval_ApprovalStatus() {
		return (EAttribute) getIfcApproval().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApproval_ApprovalLevel() {
		return (EAttribute) getIfcApproval().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApproval_ApprovalQualifier() {
		return (EAttribute) getIfcApproval().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApproval_Name() {
		return (EAttribute) getIfcApproval().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApproval_Identifier() {
		return (EAttribute) getIfcApproval().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApproval_Actors() {
		return (EReference) getIfcApproval().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApproval_IsRelatedWith() {
		return (EReference) getIfcApproval().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApproval_Relates() {
		return (EReference) getIfcApproval().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcApprovalActorRelationship() {
		if (ifcApprovalActorRelationshipEClass == null) {
			ifcApprovalActorRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(25);
		}
		return ifcApprovalActorRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApprovalActorRelationship_Actor() {
		return (EReference) getIfcApprovalActorRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApprovalActorRelationship_Approval() {
		return (EReference) getIfcApprovalActorRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApprovalActorRelationship_Role() {
		return (EReference) getIfcApprovalActorRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcApprovalPropertyRelationship() {
		if (ifcApprovalPropertyRelationshipEClass == null) {
			ifcApprovalPropertyRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(26);
		}
		return ifcApprovalPropertyRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApprovalPropertyRelationship_ApprovedProperties() {
		return (EReference) getIfcApprovalPropertyRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApprovalPropertyRelationship_Approval() {
		return (EReference) getIfcApprovalPropertyRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcApprovalRelationship() {
		if (ifcApprovalRelationshipEClass == null) {
			ifcApprovalRelationshipEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(27);
		}
		return ifcApprovalRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApprovalRelationship_RelatedApproval() {
		return (EReference) getIfcApprovalRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcApprovalRelationship_RelatingApproval() {
		return (EReference) getIfcApprovalRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApprovalRelationship_Description() {
		return (EAttribute) getIfcApprovalRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcApprovalRelationship_Name() {
		return (EAttribute) getIfcApprovalRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcArbitraryClosedProfileDef() {
		if (ifcArbitraryClosedProfileDefEClass == null) {
			ifcArbitraryClosedProfileDefEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(28);
		}
		return ifcArbitraryClosedProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcArbitraryClosedProfileDef_OuterCurve() {
		return (EReference) getIfcArbitraryClosedProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcArbitraryOpenProfileDef() {
		if (ifcArbitraryOpenProfileDefEClass == null) {
			ifcArbitraryOpenProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(29);
		}
		return ifcArbitraryOpenProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcArbitraryOpenProfileDef_Curve() {
		return (EReference) getIfcArbitraryOpenProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcArbitraryProfileDefWithVoids() {
		if (ifcArbitraryProfileDefWithVoidsEClass == null) {
			ifcArbitraryProfileDefWithVoidsEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(30);
		}
		return ifcArbitraryProfileDefWithVoidsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcArbitraryProfileDefWithVoids_InnerCurves() {
		return (EReference) getIfcArbitraryProfileDefWithVoids().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAsset() {
		if (ifcAssetEClass == null) {
			ifcAssetEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(31);
		}
		return ifcAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsset_AssetID() {
		return (EAttribute) getIfcAsset().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAsset_OriginalValue() {
		return (EReference) getIfcAsset().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAsset_CurrentValue() {
		return (EReference) getIfcAsset().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAsset_TotalReplacementCost() {
		return (EReference) getIfcAsset().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAsset_Owner() {
		return (EReference) getIfcAsset().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAsset_User() {
		return (EReference) getIfcAsset().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAsset_ResponsiblePerson() {
		return (EReference) getIfcAsset().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAsset_IncorporationDate() {
		return (EReference) getIfcAsset().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAsset_DepreciatedValue() {
		return (EReference) getIfcAsset().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAsymmetricIShapeProfileDef() {
		if (ifcAsymmetricIShapeProfileDefEClass == null) {
			ifcAsymmetricIShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(32);
		}
		return ifcAsymmetricIShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsymmetricIShapeProfileDef_TopFlangeWidth() {
		return (EAttribute) getIfcAsymmetricIShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsymmetricIShapeProfileDef_TopFlangeWidthAsString() {
		return (EAttribute) getIfcAsymmetricIShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsymmetricIShapeProfileDef_TopFlangeThickness() {
		return (EAttribute) getIfcAsymmetricIShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString() {
		return (EAttribute) getIfcAsymmetricIShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius() {
		return (EAttribute) getIfcAsymmetricIShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString() {
		return (EAttribute) getIfcAsymmetricIShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsymmetricIShapeProfileDef_CentreOfGravityInY() {
		return (EAttribute) getIfcAsymmetricIShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAsymmetricIShapeProfileDef_CentreOfGravityInYAsString() {
		return (EAttribute) getIfcAsymmetricIShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAxis1Placement() {
		if (ifcAxis1PlacementEClass == null) {
			ifcAxis1PlacementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(33);
		}
		return ifcAxis1PlacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAxis1Placement_Axis() {
		return (EReference) getIfcAxis1Placement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAxis2Placement2D() {
		if (ifcAxis2Placement2DEClass == null) {
			ifcAxis2Placement2DEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(34);
		}
		return ifcAxis2Placement2DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAxis2Placement2D_RefDirection() {
		return (EReference) getIfcAxis2Placement2D().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAxis2Placement3D() {
		if (ifcAxis2Placement3DEClass == null) {
			ifcAxis2Placement3DEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(35);
		}
		return ifcAxis2Placement3DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAxis2Placement3D_Axis() {
		return (EReference) getIfcAxis2Placement3D().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcAxis2Placement3D_RefDirection() {
		return (EReference) getIfcAxis2Placement3D().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBSplineCurve() {
		if (ifcBSplineCurveEClass == null) {
			ifcBSplineCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(36);
		}
		return ifcBSplineCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBSplineCurve_Degree() {
		return (EAttribute) getIfcBSplineCurve().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcBSplineCurve_ControlPointsList() {
		return (EReference) getIfcBSplineCurve().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBSplineCurve_CurveForm() {
		return (EAttribute) getIfcBSplineCurve().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBSplineCurve_ClosedCurve() {
		return (EAttribute) getIfcBSplineCurve().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBSplineCurve_SelfIntersect() {
		return (EAttribute) getIfcBSplineCurve().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBeam() {
		if (ifcBeamEClass == null) {
			ifcBeamEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(37);
		}
		return ifcBeamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBeamType() {
		if (ifcBeamTypeEClass == null) {
			ifcBeamTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(38);
		}
		return ifcBeamTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBeamType_PredefinedType() {
		return (EAttribute) getIfcBeamType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBezierCurve() {
		if (ifcBezierCurveEClass == null) {
			ifcBezierCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(39);
		}
		return ifcBezierCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBlobTexture() {
		if (ifcBlobTextureEClass == null) {
			ifcBlobTextureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(40);
		}
		return ifcBlobTextureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBlobTexture_RasterFormat() {
		return (EAttribute) getIfcBlobTexture().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBlobTexture_RasterCode() {
		return (EAttribute) getIfcBlobTexture().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBlock() {
		if (ifcBlockEClass == null) {
			ifcBlockEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(41);
		}
		return ifcBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBlock_XLength() {
		return (EAttribute) getIfcBlock().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBlock_XLengthAsString() {
		return (EAttribute) getIfcBlock().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBlock_YLength() {
		return (EAttribute) getIfcBlock().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBlock_YLengthAsString() {
		return (EAttribute) getIfcBlock().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBlock_ZLength() {
		return (EAttribute) getIfcBlock().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBlock_ZLengthAsString() {
		return (EAttribute) getIfcBlock().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoilerType() {
		if (ifcBoilerTypeEClass == null) {
			ifcBoilerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(42);
		}
		return ifcBoilerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoilerType_PredefinedType() {
		return (EAttribute) getIfcBoilerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBooleanClippingResult() {
		if (ifcBooleanClippingResultEClass == null) {
			ifcBooleanClippingResultEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(43);
		}
		return ifcBooleanClippingResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBooleanResult() {
		if (ifcBooleanResultEClass == null) {
			ifcBooleanResultEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(44);
		}
		return ifcBooleanResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBooleanResult_Operator() {
		return (EAttribute) getIfcBooleanResult().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcBooleanResult_FirstOperand() {
		return (EReference) getIfcBooleanResult().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcBooleanResult_SecondOperand() {
		return (EReference) getIfcBooleanResult().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBooleanResult_Dim() {
		return (EAttribute) getIfcBooleanResult().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoundaryCondition() {
		if (ifcBoundaryConditionEClass == null) {
			ifcBoundaryConditionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(45);
		}
		return ifcBoundaryConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryCondition_Name() {
		return (EAttribute) getIfcBoundaryCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoundaryEdgeCondition() {
		if (ifcBoundaryEdgeConditionEClass == null) {
			ifcBoundaryEdgeConditionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(46);
		}
		return ifcBoundaryEdgeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_LinearStiffnessByLengthX() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_LinearStiffnessByLengthXAsString() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_LinearStiffnessByLengthY() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_LinearStiffnessByLengthYAsString() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZ() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZAsString() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthX() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthXAsString() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthY() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthYAsString() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZ() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZAsString() {
		return (EAttribute) getIfcBoundaryEdgeCondition().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoundaryFaceCondition() {
		if (ifcBoundaryFaceConditionEClass == null) {
			ifcBoundaryFaceConditionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(47);
		}
		return ifcBoundaryFaceConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryFaceCondition_LinearStiffnessByAreaX() {
		return (EAttribute) getIfcBoundaryFaceCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryFaceCondition_LinearStiffnessByAreaXAsString() {
		return (EAttribute) getIfcBoundaryFaceCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryFaceCondition_LinearStiffnessByAreaY() {
		return (EAttribute) getIfcBoundaryFaceCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryFaceCondition_LinearStiffnessByAreaYAsString() {
		return (EAttribute) getIfcBoundaryFaceCondition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryFaceCondition_LinearStiffnessByAreaZ() {
		return (EAttribute) getIfcBoundaryFaceCondition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryFaceCondition_LinearStiffnessByAreaZAsString() {
		return (EAttribute) getIfcBoundaryFaceCondition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoundaryNodeCondition() {
		if (ifcBoundaryNodeConditionEClass == null) {
			ifcBoundaryNodeConditionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(48);
		}
		return ifcBoundaryNodeConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_LinearStiffnessX() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_LinearStiffnessXAsString() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_LinearStiffnessY() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_LinearStiffnessYAsString() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_LinearStiffnessZ() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_LinearStiffnessZAsString() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_RotationalStiffnessX() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_RotationalStiffnessXAsString() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_RotationalStiffnessY() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_RotationalStiffnessYAsString() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_RotationalStiffnessZ() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeCondition_RotationalStiffnessZAsString() {
		return (EAttribute) getIfcBoundaryNodeCondition().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoundaryNodeConditionWarping() {
		if (ifcBoundaryNodeConditionWarpingEClass == null) {
			ifcBoundaryNodeConditionWarpingEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(49);
		}
		return ifcBoundaryNodeConditionWarpingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeConditionWarping_WarpingStiffness() {
		return (EAttribute) getIfcBoundaryNodeConditionWarping().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundaryNodeConditionWarping_WarpingStiffnessAsString() {
		return (EAttribute) getIfcBoundaryNodeConditionWarping().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoundedCurve() {
		if (ifcBoundedCurveEClass == null) {
			ifcBoundedCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(50);
		}
		return ifcBoundedCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoundedSurface() {
		if (ifcBoundedSurfaceEClass == null) {
			ifcBoundedSurfaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(51);
		}
		return ifcBoundedSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoundingBox() {
		if (ifcBoundingBoxEClass == null) {
			ifcBoundingBoxEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(52);
		}
		return ifcBoundingBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcBoundingBox_Corner() {
		return (EReference) getIfcBoundingBox().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundingBox_XDim() {
		return (EAttribute) getIfcBoundingBox().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundingBox_XDimAsString() {
		return (EAttribute) getIfcBoundingBox().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundingBox_YDim() {
		return (EAttribute) getIfcBoundingBox().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundingBox_YDimAsString() {
		return (EAttribute) getIfcBoundingBox().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundingBox_ZDim() {
		return (EAttribute) getIfcBoundingBox().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundingBox_ZDimAsString() {
		return (EAttribute) getIfcBoundingBox().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoundingBox_Dim() {
		return (EAttribute) getIfcBoundingBox().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoxedHalfSpace() {
		if (ifcBoxedHalfSpaceEClass == null) {
			ifcBoxedHalfSpaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(53);
		}
		return ifcBoxedHalfSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcBoxedHalfSpace_Enclosure() {
		return (EReference) getIfcBoxedHalfSpace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBuilding() {
		if (ifcBuildingEClass == null) {
			ifcBuildingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(54);
		}
		return ifcBuildingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBuilding_ElevationOfRefHeight() {
		return (EAttribute) getIfcBuilding().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBuilding_ElevationOfRefHeightAsString() {
		return (EAttribute) getIfcBuilding().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBuilding_ElevationOfTerrain() {
		return (EAttribute) getIfcBuilding().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBuilding_ElevationOfTerrainAsString() {
		return (EAttribute) getIfcBuilding().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcBuilding_BuildingAddress() {
		return (EReference) getIfcBuilding().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBuildingElement() {
		if (ifcBuildingElementEClass == null) {
			ifcBuildingElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(55);
		}
		return ifcBuildingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBuildingElementComponent() {
		if (ifcBuildingElementComponentEClass == null) {
			ifcBuildingElementComponentEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(56);
		}
		return ifcBuildingElementComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBuildingElementPart() {
		if (ifcBuildingElementPartEClass == null) {
			ifcBuildingElementPartEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(57);
		}
		return ifcBuildingElementPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBuildingElementProxy() {
		if (ifcBuildingElementProxyEClass == null) {
			ifcBuildingElementProxyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(58);
		}
		return ifcBuildingElementProxyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBuildingElementProxy_CompositionType() {
		return (EAttribute) getIfcBuildingElementProxy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBuildingElementProxyType() {
		if (ifcBuildingElementProxyTypeEClass == null) {
			ifcBuildingElementProxyTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(59);
		}
		return ifcBuildingElementProxyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBuildingElementProxyType_PredefinedType() {
		return (EAttribute) getIfcBuildingElementProxyType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBuildingElementType() {
		if (ifcBuildingElementTypeEClass == null) {
			ifcBuildingElementTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(60);
		}
		return ifcBuildingElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBuildingStorey() {
		if (ifcBuildingStoreyEClass == null) {
			ifcBuildingStoreyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(61);
		}
		return ifcBuildingStoreyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBuildingStorey_Elevation() {
		return (EAttribute) getIfcBuildingStorey().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBuildingStorey_ElevationAsString() {
		return (EAttribute) getIfcBuildingStorey().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCShapeProfileDef() {
		if (ifcCShapeProfileDefEClass == null) {
			ifcCShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(62);
		}
		return ifcCShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_Depth() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_DepthAsString() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_Width() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_WidthAsString() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_WallThickness() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_WallThicknessAsString() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_Girth() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_GirthAsString() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_InternalFilletRadius() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_InternalFilletRadiusAsString() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_CentreOfGravityInX() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCShapeProfileDef_CentreOfGravityInXAsString() {
		return (EAttribute) getIfcCShapeProfileDef().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCableCarrierFittingType() {
		if (ifcCableCarrierFittingTypeEClass == null) {
			ifcCableCarrierFittingTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(63);
		}
		return ifcCableCarrierFittingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCableCarrierFittingType_PredefinedType() {
		return (EAttribute) getIfcCableCarrierFittingType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCableCarrierSegmentType() {
		if (ifcCableCarrierSegmentTypeEClass == null) {
			ifcCableCarrierSegmentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(64);
		}
		return ifcCableCarrierSegmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCableCarrierSegmentType_PredefinedType() {
		return (EAttribute) getIfcCableCarrierSegmentType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCableSegmentType() {
		if (ifcCableSegmentTypeEClass == null) {
			ifcCableSegmentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(65);
		}
		return ifcCableSegmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCableSegmentType_PredefinedType() {
		return (EAttribute) getIfcCableSegmentType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCalendarDate() {
		if (ifcCalendarDateEClass == null) {
			ifcCalendarDateEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(66);
		}
		return ifcCalendarDateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCalendarDate_DayComponent() {
		return (EAttribute) getIfcCalendarDate().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCalendarDate_MonthComponent() {
		return (EAttribute) getIfcCalendarDate().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCalendarDate_YearComponent() {
		return (EAttribute) getIfcCalendarDate().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCartesianPoint() {
		if (ifcCartesianPointEClass == null) {
			ifcCartesianPointEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(67);
		}
		return ifcCartesianPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianPoint_Coordinates() {
		return (EAttribute) getIfcCartesianPoint().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianPoint_CoordinatesAsString() {
		return (EAttribute) getIfcCartesianPoint().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianPoint_Dim() {
		return (EAttribute) getIfcCartesianPoint().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCartesianTransformationOperator() {
		if (ifcCartesianTransformationOperatorEClass == null) {
			ifcCartesianTransformationOperatorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(68);
		}
		return ifcCartesianTransformationOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCartesianTransformationOperator_Axis1() {
		return (EReference) getIfcCartesianTransformationOperator().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCartesianTransformationOperator_Axis2() {
		return (EReference) getIfcCartesianTransformationOperator().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCartesianTransformationOperator_LocalOrigin() {
		return (EReference) getIfcCartesianTransformationOperator().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator_Scale() {
		return (EAttribute) getIfcCartesianTransformationOperator().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator_ScaleAsString() {
		return (EAttribute) getIfcCartesianTransformationOperator().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator_Dim() {
		return (EAttribute) getIfcCartesianTransformationOperator().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCartesianTransformationOperator2D() {
		if (ifcCartesianTransformationOperator2DEClass == null) {
			ifcCartesianTransformationOperator2DEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(69);
		}
		return ifcCartesianTransformationOperator2DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCartesianTransformationOperator2DnonUniform() {
		if (ifcCartesianTransformationOperator2DnonUniformEClass == null) {
			ifcCartesianTransformationOperator2DnonUniformEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(70);
		}
		return ifcCartesianTransformationOperator2DnonUniformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator2DnonUniform_Scale2() {
		return (EAttribute) getIfcCartesianTransformationOperator2DnonUniform().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator2DnonUniform_Scale2AsString() {
		return (EAttribute) getIfcCartesianTransformationOperator2DnonUniform().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCartesianTransformationOperator3D() {
		if (ifcCartesianTransformationOperator3DEClass == null) {
			ifcCartesianTransformationOperator3DEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(71);
		}
		return ifcCartesianTransformationOperator3DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCartesianTransformationOperator3D_Axis3() {
		return (EReference) getIfcCartesianTransformationOperator3D().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCartesianTransformationOperator3DnonUniform() {
		if (ifcCartesianTransformationOperator3DnonUniformEClass == null) {
			ifcCartesianTransformationOperator3DnonUniformEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(72);
		}
		return ifcCartesianTransformationOperator3DnonUniformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator3DnonUniform_Scale2() {
		return (EAttribute) getIfcCartesianTransformationOperator3DnonUniform().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator3DnonUniform_Scale2AsString() {
		return (EAttribute) getIfcCartesianTransformationOperator3DnonUniform().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator3DnonUniform_Scale3() {
		return (EAttribute) getIfcCartesianTransformationOperator3DnonUniform().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCartesianTransformationOperator3DnonUniform_Scale3AsString() {
		return (EAttribute) getIfcCartesianTransformationOperator3DnonUniform().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCenterLineProfileDef() {
		if (ifcCenterLineProfileDefEClass == null) {
			ifcCenterLineProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(73);
		}
		return ifcCenterLineProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCenterLineProfileDef_Thickness() {
		return (EAttribute) getIfcCenterLineProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCenterLineProfileDef_ThicknessAsString() {
		return (EAttribute) getIfcCenterLineProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcChamferEdgeFeature() {
		if (ifcChamferEdgeFeatureEClass == null) {
			ifcChamferEdgeFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(74);
		}
		return ifcChamferEdgeFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcChamferEdgeFeature_Width() {
		return (EAttribute) getIfcChamferEdgeFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcChamferEdgeFeature_WidthAsString() {
		return (EAttribute) getIfcChamferEdgeFeature().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcChamferEdgeFeature_Height() {
		return (EAttribute) getIfcChamferEdgeFeature().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcChamferEdgeFeature_HeightAsString() {
		return (EAttribute) getIfcChamferEdgeFeature().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcChillerType() {
		if (ifcChillerTypeEClass == null) {
			ifcChillerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(75);
		}
		return ifcChillerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcChillerType_PredefinedType() {
		return (EAttribute) getIfcChillerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCircle() {
		if (ifcCircleEClass == null) {
			ifcCircleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(76);
		}
		return ifcCircleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCircle_Radius() {
		return (EAttribute) getIfcCircle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCircle_RadiusAsString() {
		return (EAttribute) getIfcCircle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCircleHollowProfileDef() {
		if (ifcCircleHollowProfileDefEClass == null) {
			ifcCircleHollowProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(77);
		}
		return ifcCircleHollowProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCircleHollowProfileDef_WallThickness() {
		return (EAttribute) getIfcCircleHollowProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCircleHollowProfileDef_WallThicknessAsString() {
		return (EAttribute) getIfcCircleHollowProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCircleProfileDef() {
		if (ifcCircleProfileDefEClass == null) {
			ifcCircleProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(78);
		}
		return ifcCircleProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCircleProfileDef_Radius() {
		return (EAttribute) getIfcCircleProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCircleProfileDef_RadiusAsString() {
		return (EAttribute) getIfcCircleProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcClassification() {
		if (ifcClassificationEClass == null) {
			ifcClassificationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(79);
		}
		return ifcClassificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcClassification_Source() {
		return (EAttribute) getIfcClassification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcClassification_Edition() {
		return (EAttribute) getIfcClassification().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassification_EditionDate() {
		return (EReference) getIfcClassification().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcClassification_Name() {
		return (EAttribute) getIfcClassification().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassification_Contains() {
		return (EReference) getIfcClassification().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcClassificationItem() {
		if (ifcClassificationItemEClass == null) {
			ifcClassificationItemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(80);
		}
		return ifcClassificationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassificationItem_Notation() {
		return (EReference) getIfcClassificationItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassificationItem_ItemOf() {
		return (EReference) getIfcClassificationItem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcClassificationItem_Title() {
		return (EAttribute) getIfcClassificationItem().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassificationItem_IsClassifiedItemIn() {
		return (EReference) getIfcClassificationItem().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassificationItem_IsClassifyingItemIn() {
		return (EReference) getIfcClassificationItem().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcClassificationItemRelationship() {
		if (ifcClassificationItemRelationshipEClass == null) {
			ifcClassificationItemRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(81);
		}
		return ifcClassificationItemRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassificationItemRelationship_RelatingItem() {
		return (EReference) getIfcClassificationItemRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassificationItemRelationship_RelatedItems() {
		return (EReference) getIfcClassificationItemRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcClassificationNotation() {
		if (ifcClassificationNotationEClass == null) {
			ifcClassificationNotationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(82);
		}
		return ifcClassificationNotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassificationNotation_NotationFacets() {
		return (EReference) getIfcClassificationNotation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcClassificationNotationFacet() {
		if (ifcClassificationNotationFacetEClass == null) {
			ifcClassificationNotationFacetEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(83);
		}
		return ifcClassificationNotationFacetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcClassificationNotationFacet_NotationValue() {
		return (EAttribute) getIfcClassificationNotationFacet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcClassificationReference() {
		if (ifcClassificationReferenceEClass == null) {
			ifcClassificationReferenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(84);
		}
		return ifcClassificationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcClassificationReference_ReferencedSource() {
		return (EReference) getIfcClassificationReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcClosedShell() {
		if (ifcClosedShellEClass == null) {
			ifcClosedShellEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(85);
		}
		return ifcClosedShellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCoilType() {
		if (ifcCoilTypeEClass == null) {
			ifcCoilTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(86);
		}
		return ifcCoilTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCoilType_PredefinedType() {
		return (EAttribute) getIfcCoilType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcColourRgb() {
		if (ifcColourRgbEClass == null) {
			ifcColourRgbEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(87);
		}
		return ifcColourRgbEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcColourRgb_Red() {
		return (EAttribute) getIfcColourRgb().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcColourRgb_RedAsString() {
		return (EAttribute) getIfcColourRgb().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcColourRgb_Green() {
		return (EAttribute) getIfcColourRgb().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcColourRgb_GreenAsString() {
		return (EAttribute) getIfcColourRgb().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcColourRgb_Blue() {
		return (EAttribute) getIfcColourRgb().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcColourRgb_BlueAsString() {
		return (EAttribute) getIfcColourRgb().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcColourSpecification() {
		if (ifcColourSpecificationEClass == null) {
			ifcColourSpecificationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(88);
		}
		return ifcColourSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcColourSpecification_Name() {
		return (EAttribute) getIfcColourSpecification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcColumn() {
		if (ifcColumnEClass == null) {
			ifcColumnEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(89);
		}
		return ifcColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcColumnType() {
		if (ifcColumnTypeEClass == null) {
			ifcColumnTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(90);
		}
		return ifcColumnTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcColumnType_PredefinedType() {
		return (EAttribute) getIfcColumnType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcComplexProperty() {
		if (ifcComplexPropertyEClass == null) {
			ifcComplexPropertyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(91);
		}
		return ifcComplexPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcComplexProperty_UsageName() {
		return (EAttribute) getIfcComplexProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcComplexProperty_HasProperties() {
		return (EReference) getIfcComplexProperty().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCompositeCurve() {
		if (ifcCompositeCurveEClass == null) {
			ifcCompositeCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(92);
		}
		return ifcCompositeCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCompositeCurve_Segments() {
		return (EReference) getIfcCompositeCurve().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCompositeCurve_SelfIntersect() {
		return (EAttribute) getIfcCompositeCurve().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCompositeCurveSegment() {
		if (ifcCompositeCurveSegmentEClass == null) {
			ifcCompositeCurveSegmentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(93);
		}
		return ifcCompositeCurveSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCompositeCurveSegment_Transition() {
		return (EAttribute) getIfcCompositeCurveSegment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCompositeCurveSegment_SameSense() {
		return (EAttribute) getIfcCompositeCurveSegment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCompositeCurveSegment_ParentCurve() {
		return (EReference) getIfcCompositeCurveSegment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCompositeCurveSegment_UsingCurves() {
		return (EReference) getIfcCompositeCurveSegment().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCompositeCurveSegment_Dim() {
		return (EAttribute) getIfcCompositeCurveSegment().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCompositeProfileDef() {
		if (ifcCompositeProfileDefEClass == null) {
			ifcCompositeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(94);
		}
		return ifcCompositeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCompositeProfileDef_Profiles() {
		return (EReference) getIfcCompositeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCompositeProfileDef_Label() {
		return (EAttribute) getIfcCompositeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCompressorType() {
		if (ifcCompressorTypeEClass == null) {
			ifcCompressorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(95);
		}
		return ifcCompressorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCompressorType_PredefinedType() {
		return (EAttribute) getIfcCompressorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCondenserType() {
		if (ifcCondenserTypeEClass == null) {
			ifcCondenserTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(96);
		}
		return ifcCondenserTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCondenserType_PredefinedType() {
		return (EAttribute) getIfcCondenserType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCondition() {
		if (ifcConditionEClass == null) {
			ifcConditionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(97);
		}
		return ifcConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConditionCriterion() {
		if (ifcConditionCriterionEClass == null) {
			ifcConditionCriterionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(98);
		}
		return ifcConditionCriterionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConditionCriterion_Criterion() {
		return (EReference) getIfcConditionCriterion().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConditionCriterion_CriterionDateTime() {
		return (EReference) getIfcConditionCriterion().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConic() {
		if (ifcConicEClass == null) {
			ifcConicEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(99);
		}
		return ifcConicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConic_Position() {
		return (EReference) getIfcConic().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConnectedFaceSet() {
		if (ifcConnectedFaceSetEClass == null) {
			ifcConnectedFaceSetEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(100);
		}
		return ifcConnectedFaceSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectedFaceSet_CfsFaces() {
		return (EReference) getIfcConnectedFaceSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConnectionCurveGeometry() {
		if (ifcConnectionCurveGeometryEClass == null) {
			ifcConnectionCurveGeometryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(101);
		}
		return ifcConnectionCurveGeometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionCurveGeometry_CurveOnRelatingElement() {
		return (EReference) getIfcConnectionCurveGeometry().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionCurveGeometry_CurveOnRelatedElement() {
		return (EReference) getIfcConnectionCurveGeometry().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConnectionGeometry() {
		if (ifcConnectionGeometryEClass == null) {
			ifcConnectionGeometryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(102);
		}
		return ifcConnectionGeometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConnectionPointEccentricity() {
		if (ifcConnectionPointEccentricityEClass == null) {
			ifcConnectionPointEccentricityEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(103);
		}
		return ifcConnectionPointEccentricityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConnectionPointEccentricity_EccentricityInX() {
		return (EAttribute) getIfcConnectionPointEccentricity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConnectionPointEccentricity_EccentricityInXAsString() {
		return (EAttribute) getIfcConnectionPointEccentricity().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConnectionPointEccentricity_EccentricityInY() {
		return (EAttribute) getIfcConnectionPointEccentricity().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConnectionPointEccentricity_EccentricityInYAsString() {
		return (EAttribute) getIfcConnectionPointEccentricity().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConnectionPointEccentricity_EccentricityInZ() {
		return (EAttribute) getIfcConnectionPointEccentricity().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConnectionPointEccentricity_EccentricityInZAsString() {
		return (EAttribute) getIfcConnectionPointEccentricity().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConnectionPointGeometry() {
		if (ifcConnectionPointGeometryEClass == null) {
			ifcConnectionPointGeometryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(104);
		}
		return ifcConnectionPointGeometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionPointGeometry_PointOnRelatingElement() {
		return (EReference) getIfcConnectionPointGeometry().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionPointGeometry_PointOnRelatedElement() {
		return (EReference) getIfcConnectionPointGeometry().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConnectionPortGeometry() {
		if (ifcConnectionPortGeometryEClass == null) {
			ifcConnectionPortGeometryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(105);
		}
		return ifcConnectionPortGeometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionPortGeometry_LocationAtRelatingElement() {
		return (EReference) getIfcConnectionPortGeometry().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionPortGeometry_LocationAtRelatedElement() {
		return (EReference) getIfcConnectionPortGeometry().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionPortGeometry_ProfileOfPort() {
		return (EReference) getIfcConnectionPortGeometry().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConnectionSurfaceGeometry() {
		if (ifcConnectionSurfaceGeometryEClass == null) {
			ifcConnectionSurfaceGeometryEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(106);
		}
		return ifcConnectionSurfaceGeometryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionSurfaceGeometry_SurfaceOnRelatingElement() {
		return (EReference) getIfcConnectionSurfaceGeometry().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConnectionSurfaceGeometry_SurfaceOnRelatedElement() {
		return (EReference) getIfcConnectionSurfaceGeometry().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConstraint() {
		if (ifcConstraintEClass == null) {
			ifcConstraintEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(107);
		}
		return ifcConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraint_Name() {
		return (EAttribute) getIfcConstraint().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraint_Description() {
		return (EAttribute) getIfcConstraint().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraint_ConstraintGrade() {
		return (EAttribute) getIfcConstraint().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraint_ConstraintSource() {
		return (EAttribute) getIfcConstraint().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraint_CreatingActor() {
		return (EReference) getIfcConstraint().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraint_CreationTime() {
		return (EReference) getIfcConstraint().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraint_UserDefinedGrade() {
		return (EAttribute) getIfcConstraint().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraint_ClassifiedAs() {
		return (EReference) getIfcConstraint().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraint_RelatesConstraints() {
		return (EReference) getIfcConstraint().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraint_IsRelatedWith() {
		return (EReference) getIfcConstraint().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraint_PropertiesForConstraint() {
		return (EReference) getIfcConstraint().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraint_Aggregates() {
		return (EReference) getIfcConstraint().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraint_IsAggregatedIn() {
		return (EReference) getIfcConstraint().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConstraintAggregationRelationship() {
		if (ifcConstraintAggregationRelationshipEClass == null) {
			ifcConstraintAggregationRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(108);
		}
		return ifcConstraintAggregationRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraintAggregationRelationship_Name() {
		return (EAttribute) getIfcConstraintAggregationRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraintAggregationRelationship_Description() {
		return (EAttribute) getIfcConstraintAggregationRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraintAggregationRelationship_RelatingConstraint() {
		return (EReference) getIfcConstraintAggregationRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraintAggregationRelationship_RelatedConstraints() {
		return (EReference) getIfcConstraintAggregationRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraintAggregationRelationship_LogicalAggregator() {
		return (EAttribute) getIfcConstraintAggregationRelationship().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConstraintClassificationRelationship() {
		if (ifcConstraintClassificationRelationshipEClass == null) {
			ifcConstraintClassificationRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(109);
		}
		return ifcConstraintClassificationRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraintClassificationRelationship_ClassifiedConstraint() {
		return (EReference) getIfcConstraintClassificationRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraintClassificationRelationship_RelatedClassifications() {
		return (EReference) getIfcConstraintClassificationRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConstraintRelationship() {
		if (ifcConstraintRelationshipEClass == null) {
			ifcConstraintRelationshipEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(110);
		}
		return ifcConstraintRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraintRelationship_Name() {
		return (EAttribute) getIfcConstraintRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstraintRelationship_Description() {
		return (EAttribute) getIfcConstraintRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraintRelationship_RelatingConstraint() {
		return (EReference) getIfcConstraintRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstraintRelationship_RelatedConstraints() {
		return (EReference) getIfcConstraintRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConstructionEquipmentResource() {
		if (ifcConstructionEquipmentResourceEClass == null) {
			ifcConstructionEquipmentResourceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(111);
		}
		return ifcConstructionEquipmentResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConstructionMaterialResource() {
		if (ifcConstructionMaterialResourceEClass == null) {
			ifcConstructionMaterialResourceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(112);
		}
		return ifcConstructionMaterialResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstructionMaterialResource_Suppliers() {
		return (EReference) getIfcConstructionMaterialResource().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstructionMaterialResource_UsageRatio() {
		return (EAttribute) getIfcConstructionMaterialResource().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstructionMaterialResource_UsageRatioAsString() {
		return (EAttribute) getIfcConstructionMaterialResource().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConstructionProductResource() {
		if (ifcConstructionProductResourceEClass == null) {
			ifcConstructionProductResourceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(113);
		}
		return ifcConstructionProductResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConstructionResource() {
		if (ifcConstructionResourceEClass == null) {
			ifcConstructionResourceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(114);
		}
		return ifcConstructionResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstructionResource_ResourceIdentifier() {
		return (EAttribute) getIfcConstructionResource().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstructionResource_ResourceGroup() {
		return (EAttribute) getIfcConstructionResource().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConstructionResource_ResourceConsumption() {
		return (EAttribute) getIfcConstructionResource().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConstructionResource_BaseQuantity() {
		return (EReference) getIfcConstructionResource().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcContextDependentUnit() {
		if (ifcContextDependentUnitEClass == null) {
			ifcContextDependentUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(115);
		}
		return ifcContextDependentUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcContextDependentUnit_Name() {
		return (EAttribute) getIfcContextDependentUnit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcControl() {
		if (ifcControlEClass == null) {
			ifcControlEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(116);
		}
		return ifcControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcControl_Controls() {
		return (EReference) getIfcControl().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcControllerType() {
		if (ifcControllerTypeEClass == null) {
			ifcControllerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(117);
		}
		return ifcControllerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcControllerType_PredefinedType() {
		return (EAttribute) getIfcControllerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConversionBasedUnit() {
		if (ifcConversionBasedUnitEClass == null) {
			ifcConversionBasedUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(118);
		}
		return ifcConversionBasedUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcConversionBasedUnit_Name() {
		return (EAttribute) getIfcConversionBasedUnit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcConversionBasedUnit_ConversionFactor() {
		return (EReference) getIfcConversionBasedUnit().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCooledBeamType() {
		if (ifcCooledBeamTypeEClass == null) {
			ifcCooledBeamTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(119);
		}
		return ifcCooledBeamTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCooledBeamType_PredefinedType() {
		return (EAttribute) getIfcCooledBeamType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCoolingTowerType() {
		if (ifcCoolingTowerTypeEClass == null) {
			ifcCoolingTowerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(120);
		}
		return ifcCoolingTowerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCoolingTowerType_PredefinedType() {
		return (EAttribute) getIfcCoolingTowerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCoordinatedUniversalTimeOffset() {
		if (ifcCoordinatedUniversalTimeOffsetEClass == null) {
			ifcCoordinatedUniversalTimeOffsetEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(121);
		}
		return ifcCoordinatedUniversalTimeOffsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCoordinatedUniversalTimeOffset_HourOffset() {
		return (EAttribute) getIfcCoordinatedUniversalTimeOffset().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCoordinatedUniversalTimeOffset_MinuteOffset() {
		return (EAttribute) getIfcCoordinatedUniversalTimeOffset().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCoordinatedUniversalTimeOffset_Sense() {
		return (EAttribute) getIfcCoordinatedUniversalTimeOffset().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCostItem() {
		if (ifcCostItemEClass == null) {
			ifcCostItemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(122);
		}
		return ifcCostItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCostSchedule() {
		if (ifcCostScheduleEClass == null) {
			ifcCostScheduleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(123);
		}
		return ifcCostScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCostSchedule_SubmittedBy() {
		return (EReference) getIfcCostSchedule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCostSchedule_PreparedBy() {
		return (EReference) getIfcCostSchedule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCostSchedule_SubmittedOn() {
		return (EReference) getIfcCostSchedule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCostSchedule_Status() {
		return (EAttribute) getIfcCostSchedule().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCostSchedule_TargetUsers() {
		return (EReference) getIfcCostSchedule().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCostSchedule_UpdateDate() {
		return (EReference) getIfcCostSchedule().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCostSchedule_ID() {
		return (EAttribute) getIfcCostSchedule().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCostSchedule_PredefinedType() {
		return (EAttribute) getIfcCostSchedule().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCostValue() {
		if (ifcCostValueEClass == null) {
			ifcCostValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(124);
		}
		return ifcCostValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCostValue_CostType() {
		return (EAttribute) getIfcCostValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCostValue_Condition() {
		return (EAttribute) getIfcCostValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCovering() {
		if (ifcCoveringEClass == null) {
			ifcCoveringEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(125);
		}
		return ifcCoveringEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCovering_PredefinedType() {
		return (EAttribute) getIfcCovering().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCovering_CoversSpaces() {
		return (EReference) getIfcCovering().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCovering_Covers() {
		return (EReference) getIfcCovering().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCoveringType() {
		if (ifcCoveringTypeEClass == null) {
			ifcCoveringTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(126);
		}
		return ifcCoveringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCoveringType_PredefinedType() {
		return (EAttribute) getIfcCoveringType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCraneRailAShapeProfileDef() {
		if (ifcCraneRailAShapeProfileDefEClass == null) {
			ifcCraneRailAShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(127);
		}
		return ifcCraneRailAShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_OverallHeight() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_OverallHeightAsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseWidth2() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseWidth2AsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_Radius() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_RadiusAsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_HeadWidth() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_HeadWidthAsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_HeadDepth2() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_HeadDepth2AsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_HeadDepth3() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_HeadDepth3AsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_WebThickness() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_WebThicknessAsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseWidth4() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseWidth4AsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseDepth1() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseDepth1AsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseDepth2() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseDepth2AsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseDepth3() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_BaseDepth3AsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_CentreOfGravityInY() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailAShapeProfileDef_CentreOfGravityInYAsString() {
		return (EAttribute) getIfcCraneRailAShapeProfileDef().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCraneRailFShapeProfileDef() {
		if (ifcCraneRailFShapeProfileDefEClass == null) {
			ifcCraneRailFShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(128);
		}
		return ifcCraneRailFShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_OverallHeight() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_OverallHeightAsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_HeadWidth() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_HeadWidthAsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_Radius() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_RadiusAsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_HeadDepth2() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_HeadDepth2AsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_HeadDepth3() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_HeadDepth3AsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_WebThickness() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_WebThicknessAsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_BaseDepth1() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_BaseDepth1AsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_BaseDepth2() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_BaseDepth2AsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_CentreOfGravityInY() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCraneRailFShapeProfileDef_CentreOfGravityInYAsString() {
		return (EAttribute) getIfcCraneRailFShapeProfileDef().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCrewResource() {
		if (ifcCrewResourceEClass == null) {
			ifcCrewResourceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(129);
		}
		return ifcCrewResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCsgPrimitive3D() {
		if (ifcCsgPrimitive3DEClass == null) {
			ifcCsgPrimitive3DEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(130);
		}
		return ifcCsgPrimitive3DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCsgPrimitive3D_Position() {
		return (EReference) getIfcCsgPrimitive3D().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCsgPrimitive3D_Dim() {
		return (EAttribute) getIfcCsgPrimitive3D().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCsgSolid() {
		if (ifcCsgSolidEClass == null) {
			ifcCsgSolidEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(131);
		}
		return ifcCsgSolidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCsgSolid_TreeRootExpression() {
		return (EReference) getIfcCsgSolid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurrencyRelationship() {
		if (ifcCurrencyRelationshipEClass == null) {
			ifcCurrencyRelationshipEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(132);
		}
		return ifcCurrencyRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurrencyRelationship_RelatingMonetaryUnit() {
		return (EReference) getIfcCurrencyRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurrencyRelationship_RelatedMonetaryUnit() {
		return (EReference) getIfcCurrencyRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurrencyRelationship_ExchangeRate() {
		return (EAttribute) getIfcCurrencyRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurrencyRelationship_ExchangeRateAsString() {
		return (EAttribute) getIfcCurrencyRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurrencyRelationship_RateDateTime() {
		return (EReference) getIfcCurrencyRelationship().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurrencyRelationship_RateSource() {
		return (EReference) getIfcCurrencyRelationship().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurtainWall() {
		if (ifcCurtainWallEClass == null) {
			ifcCurtainWallEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(133);
		}
		return ifcCurtainWallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurtainWallType() {
		if (ifcCurtainWallTypeEClass == null) {
			ifcCurtainWallTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(134);
		}
		return ifcCurtainWallTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurtainWallType_PredefinedType() {
		return (EAttribute) getIfcCurtainWallType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurve() {
		if (ifcCurveEClass == null) {
			ifcCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(135);
		}
		return ifcCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurve_Dim() {
		return (EAttribute) getIfcCurve().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurveBoundedPlane() {
		if (ifcCurveBoundedPlaneEClass == null) {
			ifcCurveBoundedPlaneEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(136);
		}
		return ifcCurveBoundedPlaneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurveBoundedPlane_BasisSurface() {
		return (EReference) getIfcCurveBoundedPlane().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurveBoundedPlane_OuterBoundary() {
		return (EReference) getIfcCurveBoundedPlane().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurveBoundedPlane_InnerBoundaries() {
		return (EReference) getIfcCurveBoundedPlane().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveBoundedPlane_Dim() {
		return (EAttribute) getIfcCurveBoundedPlane().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurveStyle() {
		if (ifcCurveStyleEClass == null) {
			ifcCurveStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(137);
		}
		return ifcCurveStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurveStyle_CurveFont() {
		return (EReference) getIfcCurveStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurveStyle_CurveWidth() {
		return (EReference) getIfcCurveStyle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurveStyle_CurveColour() {
		return (EReference) getIfcCurveStyle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurveStyleFont() {
		if (ifcCurveStyleFontEClass == null) {
			ifcCurveStyleFontEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(138);
		}
		return ifcCurveStyleFontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveStyleFont_Name() {
		return (EAttribute) getIfcCurveStyleFont().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurveStyleFont_PatternList() {
		return (EReference) getIfcCurveStyleFont().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurveStyleFontAndScaling() {
		if (ifcCurveStyleFontAndScalingEClass == null) {
			ifcCurveStyleFontAndScalingEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(139);
		}
		return ifcCurveStyleFontAndScalingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveStyleFontAndScaling_Name() {
		return (EAttribute) getIfcCurveStyleFontAndScaling().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcCurveStyleFontAndScaling_CurveFont() {
		return (EReference) getIfcCurveStyleFontAndScaling().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveStyleFontAndScaling_CurveFontScaling() {
		return (EAttribute) getIfcCurveStyleFontAndScaling().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveStyleFontAndScaling_CurveFontScalingAsString() {
		return (EAttribute) getIfcCurveStyleFontAndScaling().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurveStyleFontPattern() {
		if (ifcCurveStyleFontPatternEClass == null) {
			ifcCurveStyleFontPatternEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(140);
		}
		return ifcCurveStyleFontPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveStyleFontPattern_VisibleSegmentLength() {
		return (EAttribute) getIfcCurveStyleFontPattern().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveStyleFontPattern_VisibleSegmentLengthAsString() {
		return (EAttribute) getIfcCurveStyleFontPattern().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveStyleFontPattern_InvisibleSegmentLength() {
		return (EAttribute) getIfcCurveStyleFontPattern().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurveStyleFontPattern_InvisibleSegmentLengthAsString() {
		return (EAttribute) getIfcCurveStyleFontPattern().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDamperType() {
		if (ifcDamperTypeEClass == null) {
			ifcDamperTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(141);
		}
		return ifcDamperTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDamperType_PredefinedType() {
		return (EAttribute) getIfcDamperType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDateAndTime() {
		if (ifcDateAndTimeEClass == null) {
			ifcDateAndTimeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(142);
		}
		return ifcDateAndTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDateAndTime_DateComponent() {
		return (EReference) getIfcDateAndTime().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDateAndTime_TimeComponent() {
		return (EReference) getIfcDateAndTime().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDefinedSymbol() {
		if (ifcDefinedSymbolEClass == null) {
			ifcDefinedSymbolEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(143);
		}
		return ifcDefinedSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDefinedSymbol_Definition() {
		return (EReference) getIfcDefinedSymbol().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDefinedSymbol_Target() {
		return (EReference) getIfcDefinedSymbol().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDerivedProfileDef() {
		if (ifcDerivedProfileDefEClass == null) {
			ifcDerivedProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(144);
		}
		return ifcDerivedProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDerivedProfileDef_ParentProfile() {
		return (EReference) getIfcDerivedProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDerivedProfileDef_Operator() {
		return (EReference) getIfcDerivedProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDerivedProfileDef_Label() {
		return (EAttribute) getIfcDerivedProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDerivedUnit() {
		if (ifcDerivedUnitEClass == null) {
			ifcDerivedUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(145);
		}
		return ifcDerivedUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDerivedUnit_Elements() {
		return (EReference) getIfcDerivedUnit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDerivedUnit_UnitType() {
		return (EAttribute) getIfcDerivedUnit().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDerivedUnit_UserDefinedType() {
		return (EAttribute) getIfcDerivedUnit().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDerivedUnitElement() {
		if (ifcDerivedUnitElementEClass == null) {
			ifcDerivedUnitElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(146);
		}
		return ifcDerivedUnitElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDerivedUnitElement_Unit() {
		return (EReference) getIfcDerivedUnitElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDerivedUnitElement_Exponent() {
		return (EAttribute) getIfcDerivedUnitElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDiameterDimension() {
		if (ifcDiameterDimensionEClass == null) {
			ifcDiameterDimensionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(147);
		}
		return ifcDiameterDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDimensionCalloutRelationship() {
		if (ifcDimensionCalloutRelationshipEClass == null) {
			ifcDimensionCalloutRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(148);
		}
		return ifcDimensionCalloutRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDimensionCurve() {
		if (ifcDimensionCurveEClass == null) {
			ifcDimensionCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(149);
		}
		return ifcDimensionCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDimensionCurve_AnnotatedBySymbols() {
		return (EReference) getIfcDimensionCurve().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDimensionCurveDirectedCallout() {
		if (ifcDimensionCurveDirectedCalloutEClass == null) {
			ifcDimensionCurveDirectedCalloutEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(150);
		}
		return ifcDimensionCurveDirectedCalloutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDimensionCurveTerminator() {
		if (ifcDimensionCurveTerminatorEClass == null) {
			ifcDimensionCurveTerminatorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(151);
		}
		return ifcDimensionCurveTerminatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionCurveTerminator_Role() {
		return (EAttribute) getIfcDimensionCurveTerminator().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDimensionPair() {
		if (ifcDimensionPairEClass == null) {
			ifcDimensionPairEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(152);
		}
		return ifcDimensionPairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDimensionalExponents() {
		if (ifcDimensionalExponentsEClass == null) {
			ifcDimensionalExponentsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(153);
		}
		return ifcDimensionalExponentsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionalExponents_LengthExponent() {
		return (EAttribute) getIfcDimensionalExponents().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionalExponents_MassExponent() {
		return (EAttribute) getIfcDimensionalExponents().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionalExponents_TimeExponent() {
		return (EAttribute) getIfcDimensionalExponents().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionalExponents_ElectricCurrentExponent() {
		return (EAttribute) getIfcDimensionalExponents().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionalExponents_ThermodynamicTemperatureExponent() {
		return (EAttribute) getIfcDimensionalExponents().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionalExponents_AmountOfSubstanceExponent() {
		return (EAttribute) getIfcDimensionalExponents().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionalExponents_LuminousIntensityExponent() {
		return (EAttribute) getIfcDimensionalExponents().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDirection() {
		if (ifcDirectionEClass == null) {
			ifcDirectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(154);
		}
		return ifcDirectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDirection_DirectionRatios() {
		return (EAttribute) getIfcDirection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDirection_DirectionRatiosAsString() {
		return (EAttribute) getIfcDirection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDirection_Dim() {
		return (EAttribute) getIfcDirection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDiscreteAccessory() {
		if (ifcDiscreteAccessoryEClass == null) {
			ifcDiscreteAccessoryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(155);
		}
		return ifcDiscreteAccessoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDiscreteAccessoryType() {
		if (ifcDiscreteAccessoryTypeEClass == null) {
			ifcDiscreteAccessoryTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(156);
		}
		return ifcDiscreteAccessoryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionChamberElement() {
		if (ifcDistributionChamberElementEClass == null) {
			ifcDistributionChamberElementEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(157);
		}
		return ifcDistributionChamberElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionChamberElementType() {
		if (ifcDistributionChamberElementTypeEClass == null) {
			ifcDistributionChamberElementTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(158);
		}
		return ifcDistributionChamberElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDistributionChamberElementType_PredefinedType() {
		return (EAttribute) getIfcDistributionChamberElementType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionControlElement() {
		if (ifcDistributionControlElementEClass == null) {
			ifcDistributionControlElementEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(159);
		}
		return ifcDistributionControlElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDistributionControlElement_ControlElementId() {
		return (EAttribute) getIfcDistributionControlElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDistributionControlElement_AssignedToFlowElement() {
		return (EReference) getIfcDistributionControlElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionControlElementType() {
		if (ifcDistributionControlElementTypeEClass == null) {
			ifcDistributionControlElementTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(160);
		}
		return ifcDistributionControlElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionElement() {
		if (ifcDistributionElementEClass == null) {
			ifcDistributionElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(161);
		}
		return ifcDistributionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionElementType() {
		if (ifcDistributionElementTypeEClass == null) {
			ifcDistributionElementTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(162);
		}
		return ifcDistributionElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionFlowElement() {
		if (ifcDistributionFlowElementEClass == null) {
			ifcDistributionFlowElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(163);
		}
		return ifcDistributionFlowElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDistributionFlowElement_HasControlElements() {
		return (EReference) getIfcDistributionFlowElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionFlowElementType() {
		if (ifcDistributionFlowElementTypeEClass == null) {
			ifcDistributionFlowElementTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(164);
		}
		return ifcDistributionFlowElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDistributionPort() {
		if (ifcDistributionPortEClass == null) {
			ifcDistributionPortEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(165);
		}
		return ifcDistributionPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDistributionPort_FlowDirection() {
		return (EAttribute) getIfcDistributionPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDocumentElectronicFormat() {
		if (ifcDocumentElectronicFormatEClass == null) {
			ifcDocumentElectronicFormatEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(166);
		}
		return ifcDocumentElectronicFormatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentElectronicFormat_FileExtension() {
		return (EAttribute) getIfcDocumentElectronicFormat().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentElectronicFormat_MimeContentType() {
		return (EAttribute) getIfcDocumentElectronicFormat().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentElectronicFormat_MimeSubtype() {
		return (EAttribute) getIfcDocumentElectronicFormat().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDocumentInformation() {
		if (ifcDocumentInformationEClass == null) {
			ifcDocumentInformationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(167);
		}
		return ifcDocumentInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_DocumentId() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_Name() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_Description() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_DocumentReferences() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_Purpose() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_IntendedUse() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_Scope() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_Revision() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_DocumentOwner() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_Editors() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_CreationTime() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_LastRevisionTime() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_ElectronicFormat() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_ValidFrom() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_ValidUntil() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_Confidentiality() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformation_Status() {
		return (EAttribute) getIfcDocumentInformation().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_IsPointedTo() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformation_IsPointer() {
		return (EReference) getIfcDocumentInformation().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDocumentInformationRelationship() {
		if (ifcDocumentInformationRelationshipEClass == null) {
			ifcDocumentInformationRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(168);
		}
		return ifcDocumentInformationRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformationRelationship_RelatingDocument() {
		return (EReference) getIfcDocumentInformationRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentInformationRelationship_RelatedDocuments() {
		return (EReference) getIfcDocumentInformationRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDocumentInformationRelationship_RelationshipType() {
		return (EAttribute) getIfcDocumentInformationRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDocumentReference() {
		if (ifcDocumentReferenceEClass == null) {
			ifcDocumentReferenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(169);
		}
		return ifcDocumentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDocumentReference_ReferenceToDocument() {
		return (EReference) getIfcDocumentReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDoor() {
		if (ifcDoorEClass == null) {
			ifcDoorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(170);
		}
		return ifcDoorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoor_OverallHeight() {
		return (EAttribute) getIfcDoor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoor_OverallHeightAsString() {
		return (EAttribute) getIfcDoor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoor_OverallWidth() {
		return (EAttribute) getIfcDoor().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoor_OverallWidthAsString() {
		return (EAttribute) getIfcDoor().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDoorLiningProperties() {
		if (ifcDoorLiningPropertiesEClass == null) {
			ifcDoorLiningPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(171);
		}
		return ifcDoorLiningPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_LiningDepth() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_LiningDepthAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_LiningThickness() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_LiningThicknessAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_ThresholdDepth() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_ThresholdDepthAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_ThresholdThickness() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_ThresholdThicknessAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_TransomThickness() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_TransomThicknessAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_TransomOffset() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_TransomOffsetAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_LiningOffset() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_LiningOffsetAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_ThresholdOffset() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_ThresholdOffsetAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_CasingThickness() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_CasingThicknessAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_CasingDepth() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorLiningProperties_CasingDepthAsString() {
		return (EAttribute) getIfcDoorLiningProperties().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDoorLiningProperties_ShapeAspectStyle() {
		return (EReference) getIfcDoorLiningProperties().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDoorPanelProperties() {
		if (ifcDoorPanelPropertiesEClass == null) {
			ifcDoorPanelPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(172);
		}
		return ifcDoorPanelPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorPanelProperties_PanelDepth() {
		return (EAttribute) getIfcDoorPanelProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorPanelProperties_PanelDepthAsString() {
		return (EAttribute) getIfcDoorPanelProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorPanelProperties_PanelOperation() {
		return (EAttribute) getIfcDoorPanelProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorPanelProperties_PanelWidth() {
		return (EAttribute) getIfcDoorPanelProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorPanelProperties_PanelWidthAsString() {
		return (EAttribute) getIfcDoorPanelProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorPanelProperties_PanelPosition() {
		return (EAttribute) getIfcDoorPanelProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDoorPanelProperties_ShapeAspectStyle() {
		return (EReference) getIfcDoorPanelProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDoorStyle() {
		if (ifcDoorStyleEClass == null) {
			ifcDoorStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(173);
		}
		return ifcDoorStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorStyle_OperationType() {
		return (EAttribute) getIfcDoorStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorStyle_ConstructionType() {
		return (EAttribute) getIfcDoorStyle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorStyle_ParameterTakesPrecedence() {
		return (EAttribute) getIfcDoorStyle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoorStyle_Sizeable() {
		return (EAttribute) getIfcDoorStyle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDraughtingCallout() {
		if (ifcDraughtingCalloutEClass == null) {
			ifcDraughtingCalloutEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(174);
		}
		return ifcDraughtingCalloutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDraughtingCallout_Contents() {
		return (EReference) getIfcDraughtingCallout().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDraughtingCallout_IsRelatedFromCallout() {
		return (EReference) getIfcDraughtingCallout().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDraughtingCallout_IsRelatedToCallout() {
		return (EReference) getIfcDraughtingCallout().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDraughtingCalloutRelationship() {
		if (ifcDraughtingCalloutRelationshipEClass == null) {
			ifcDraughtingCalloutRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(175);
		}
		return ifcDraughtingCalloutRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDraughtingCalloutRelationship_Name() {
		return (EAttribute) getIfcDraughtingCalloutRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDraughtingCalloutRelationship_Description() {
		return (EAttribute) getIfcDraughtingCalloutRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDraughtingCalloutRelationship_RelatingDraughtingCallout() {
		return (EReference) getIfcDraughtingCalloutRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcDraughtingCalloutRelationship_RelatedDraughtingCallout() {
		return (EReference) getIfcDraughtingCalloutRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDraughtingPreDefinedColour() {
		if (ifcDraughtingPreDefinedColourEClass == null) {
			ifcDraughtingPreDefinedColourEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(176);
		}
		return ifcDraughtingPreDefinedColourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDraughtingPreDefinedCurveFont() {
		if (ifcDraughtingPreDefinedCurveFontEClass == null) {
			ifcDraughtingPreDefinedCurveFontEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(177);
		}
		return ifcDraughtingPreDefinedCurveFontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDraughtingPreDefinedTextFont() {
		if (ifcDraughtingPreDefinedTextFontEClass == null) {
			ifcDraughtingPreDefinedTextFontEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(178);
		}
		return ifcDraughtingPreDefinedTextFontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDuctFittingType() {
		if (ifcDuctFittingTypeEClass == null) {
			ifcDuctFittingTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(179);
		}
		return ifcDuctFittingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDuctFittingType_PredefinedType() {
		return (EAttribute) getIfcDuctFittingType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDuctSegmentType() {
		if (ifcDuctSegmentTypeEClass == null) {
			ifcDuctSegmentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(180);
		}
		return ifcDuctSegmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDuctSegmentType_PredefinedType() {
		return (EAttribute) getIfcDuctSegmentType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDuctSilencerType() {
		if (ifcDuctSilencerTypeEClass == null) {
			ifcDuctSilencerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(181);
		}
		return ifcDuctSilencerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDuctSilencerType_PredefinedType() {
		return (EAttribute) getIfcDuctSilencerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEdge() {
		if (ifcEdgeEClass == null) {
			ifcEdgeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(182);
		}
		return ifcEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcEdge_EdgeStart() {
		return (EReference) getIfcEdge().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcEdge_EdgeEnd() {
		return (EReference) getIfcEdge().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEdgeCurve() {
		if (ifcEdgeCurveEClass == null) {
			ifcEdgeCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(183);
		}
		return ifcEdgeCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcEdgeCurve_EdgeGeometry() {
		return (EReference) getIfcEdgeCurve().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEdgeCurve_SameSense() {
		return (EAttribute) getIfcEdgeCurve().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEdgeFeature() {
		if (ifcEdgeFeatureEClass == null) {
			ifcEdgeFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(184);
		}
		return ifcEdgeFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEdgeFeature_FeatureLength() {
		return (EAttribute) getIfcEdgeFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEdgeFeature_FeatureLengthAsString() {
		return (EAttribute) getIfcEdgeFeature().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEdgeLoop() {
		if (ifcEdgeLoopEClass == null) {
			ifcEdgeLoopEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(185);
		}
		return ifcEdgeLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcEdgeLoop_EdgeList() {
		return (EReference) getIfcEdgeLoop().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricApplianceType() {
		if (ifcElectricApplianceTypeEClass == null) {
			ifcElectricApplianceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(186);
		}
		return ifcElectricApplianceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricApplianceType_PredefinedType() {
		return (EAttribute) getIfcElectricApplianceType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricDistributionPoint() {
		if (ifcElectricDistributionPointEClass == null) {
			ifcElectricDistributionPointEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(187);
		}
		return ifcElectricDistributionPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricDistributionPoint_DistributionPointFunction() {
		return (EAttribute) getIfcElectricDistributionPoint().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricDistributionPoint_UserDefinedFunction() {
		return (EAttribute) getIfcElectricDistributionPoint().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricFlowStorageDeviceType() {
		if (ifcElectricFlowStorageDeviceTypeEClass == null) {
			ifcElectricFlowStorageDeviceTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(188);
		}
		return ifcElectricFlowStorageDeviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricFlowStorageDeviceType_PredefinedType() {
		return (EAttribute) getIfcElectricFlowStorageDeviceType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricGeneratorType() {
		if (ifcElectricGeneratorTypeEClass == null) {
			ifcElectricGeneratorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(189);
		}
		return ifcElectricGeneratorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricGeneratorType_PredefinedType() {
		return (EAttribute) getIfcElectricGeneratorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricHeaterType() {
		if (ifcElectricHeaterTypeEClass == null) {
			ifcElectricHeaterTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(190);
		}
		return ifcElectricHeaterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricHeaterType_PredefinedType() {
		return (EAttribute) getIfcElectricHeaterType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricMotorType() {
		if (ifcElectricMotorTypeEClass == null) {
			ifcElectricMotorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(191);
		}
		return ifcElectricMotorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricMotorType_PredefinedType() {
		return (EAttribute) getIfcElectricMotorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricTimeControlType() {
		if (ifcElectricTimeControlTypeEClass == null) {
			ifcElectricTimeControlTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(192);
		}
		return ifcElectricTimeControlTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricTimeControlType_PredefinedType() {
		return (EAttribute) getIfcElectricTimeControlType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricalBaseProperties() {
		if (ifcElectricalBasePropertiesEClass == null) {
			ifcElectricalBasePropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(193);
		}
		return ifcElectricalBasePropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_ElectricCurrentType() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_InputVoltage() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_InputVoltageAsString() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_InputFrequency() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_InputFrequencyAsString() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_FullLoadCurrent() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_FullLoadCurrentAsString() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_MinimumCircuitCurrent() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_MinimumCircuitCurrentAsString() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_MaximumPowerInput() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_MaximumPowerInputAsString() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_RatedPowerInput() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_RatedPowerInputAsString() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricalBaseProperties_InputPhase() {
		return (EAttribute) getIfcElectricalBaseProperties().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricalCircuit() {
		if (ifcElectricalCircuitEClass == null) {
			ifcElectricalCircuitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(194);
		}
		return ifcElectricalCircuitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricalElement() {
		if (ifcElectricalElementEClass == null) {
			ifcElectricalElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(195);
		}
		return ifcElectricalElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElement() {
		if (ifcElementEClass == null) {
			ifcElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(196);
		}
		return ifcElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElement_Tag() {
		return (EAttribute) getIfcElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_HasStructuralMember() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_FillsVoids() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_ConnectedTo() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_HasCoverings() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_HasProjections() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_ReferencedInStructures() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_HasPorts() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_HasOpenings() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_IsConnectionRealization() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_ProvidesBoundaries() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_ConnectedFrom() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElement_ContainedInStructure() {
		return (EReference) getIfcElement().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElementAssembly() {
		if (ifcElementAssemblyEClass == null) {
			ifcElementAssemblyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(197);
		}
		return ifcElementAssemblyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElementAssembly_AssemblyPlace() {
		return (EAttribute) getIfcElementAssembly().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElementAssembly_PredefinedType() {
		return (EAttribute) getIfcElementAssembly().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElementComponent() {
		if (ifcElementComponentEClass == null) {
			ifcElementComponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(198);
		}
		return ifcElementComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElementComponentType() {
		if (ifcElementComponentTypeEClass == null) {
			ifcElementComponentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(199);
		}
		return ifcElementComponentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElementQuantity() {
		if (ifcElementQuantityEClass == null) {
			ifcElementQuantityEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(200);
		}
		return ifcElementQuantityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElementQuantity_MethodOfMeasurement() {
		return (EAttribute) getIfcElementQuantity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElementQuantity_Quantities() {
		return (EReference) getIfcElementQuantity().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElementType() {
		if (ifcElementTypeEClass == null) {
			ifcElementTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(201);
		}
		return ifcElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElementType_ElementType() {
		return (EAttribute) getIfcElementType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElementarySurface() {
		if (ifcElementarySurfaceEClass == null) {
			ifcElementarySurfaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(202);
		}
		return ifcElementarySurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcElementarySurface_Position() {
		return (EReference) getIfcElementarySurface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElementarySurface_Dim() {
		return (EAttribute) getIfcElementarySurface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEllipse() {
		if (ifcEllipseEClass == null) {
			ifcEllipseEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(203);
		}
		return ifcEllipseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEllipse_SemiAxis1() {
		return (EAttribute) getIfcEllipse().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEllipse_SemiAxis1AsString() {
		return (EAttribute) getIfcEllipse().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEllipse_SemiAxis2() {
		return (EAttribute) getIfcEllipse().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEllipse_SemiAxis2AsString() {
		return (EAttribute) getIfcEllipse().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEllipseProfileDef() {
		if (ifcEllipseProfileDefEClass == null) {
			ifcEllipseProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(204);
		}
		return ifcEllipseProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEllipseProfileDef_SemiAxis1() {
		return (EAttribute) getIfcEllipseProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEllipseProfileDef_SemiAxis1AsString() {
		return (EAttribute) getIfcEllipseProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEllipseProfileDef_SemiAxis2() {
		return (EAttribute) getIfcEllipseProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEllipseProfileDef_SemiAxis2AsString() {
		return (EAttribute) getIfcEllipseProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEnergyConversionDevice() {
		if (ifcEnergyConversionDeviceEClass == null) {
			ifcEnergyConversionDeviceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(205);
		}
		return ifcEnergyConversionDeviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEnergyConversionDeviceType() {
		if (ifcEnergyConversionDeviceTypeEClass == null) {
			ifcEnergyConversionDeviceTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(206);
		}
		return ifcEnergyConversionDeviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEnergyProperties() {
		if (ifcEnergyPropertiesEClass == null) {
			ifcEnergyPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(207);
		}
		return ifcEnergyPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEnergyProperties_EnergySequence() {
		return (EAttribute) getIfcEnergyProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEnergyProperties_UserDefinedEnergySequence() {
		return (EAttribute) getIfcEnergyProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEnvironmentalImpactValue() {
		if (ifcEnvironmentalImpactValueEClass == null) {
			ifcEnvironmentalImpactValueEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(208);
		}
		return ifcEnvironmentalImpactValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEnvironmentalImpactValue_ImpactType() {
		return (EAttribute) getIfcEnvironmentalImpactValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEnvironmentalImpactValue_Category() {
		return (EAttribute) getIfcEnvironmentalImpactValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEnvironmentalImpactValue_UserDefinedCategory() {
		return (EAttribute) getIfcEnvironmentalImpactValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEquipmentElement() {
		if (ifcEquipmentElementEClass == null) {
			ifcEquipmentElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(209);
		}
		return ifcEquipmentElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEquipmentStandard() {
		if (ifcEquipmentStandardEClass == null) {
			ifcEquipmentStandardEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(210);
		}
		return ifcEquipmentStandardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEvaporativeCoolerType() {
		if (ifcEvaporativeCoolerTypeEClass == null) {
			ifcEvaporativeCoolerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(211);
		}
		return ifcEvaporativeCoolerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEvaporativeCoolerType_PredefinedType() {
		return (EAttribute) getIfcEvaporativeCoolerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEvaporatorType() {
		if (ifcEvaporatorTypeEClass == null) {
			ifcEvaporatorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(212);
		}
		return ifcEvaporatorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEvaporatorType_PredefinedType() {
		return (EAttribute) getIfcEvaporatorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcExtendedMaterialProperties() {
		if (ifcExtendedMaterialPropertiesEClass == null) {
			ifcExtendedMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(213);
		}
		return ifcExtendedMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcExtendedMaterialProperties_ExtendedProperties() {
		return (EReference) getIfcExtendedMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcExtendedMaterialProperties_Description() {
		return (EAttribute) getIfcExtendedMaterialProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcExtendedMaterialProperties_Name() {
		return (EAttribute) getIfcExtendedMaterialProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcExternalReference() {
		if (ifcExternalReferenceEClass == null) {
			ifcExternalReferenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(214);
		}
		return ifcExternalReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcExternalReference_Location() {
		return (EAttribute) getIfcExternalReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcExternalReference_ItemReference() {
		return (EAttribute) getIfcExternalReference().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcExternalReference_Name() {
		return (EAttribute) getIfcExternalReference().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcExternallyDefinedHatchStyle() {
		if (ifcExternallyDefinedHatchStyleEClass == null) {
			ifcExternallyDefinedHatchStyleEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(215);
		}
		return ifcExternallyDefinedHatchStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcExternallyDefinedSurfaceStyle() {
		if (ifcExternallyDefinedSurfaceStyleEClass == null) {
			ifcExternallyDefinedSurfaceStyleEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(216);
		}
		return ifcExternallyDefinedSurfaceStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcExternallyDefinedSymbol() {
		if (ifcExternallyDefinedSymbolEClass == null) {
			ifcExternallyDefinedSymbolEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(217);
		}
		return ifcExternallyDefinedSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcExternallyDefinedTextFont() {
		if (ifcExternallyDefinedTextFontEClass == null) {
			ifcExternallyDefinedTextFontEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(218);
		}
		return ifcExternallyDefinedTextFontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcExtrudedAreaSolid() {
		if (ifcExtrudedAreaSolidEClass == null) {
			ifcExtrudedAreaSolidEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(219);
		}
		return ifcExtrudedAreaSolidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcExtrudedAreaSolid_ExtrudedDirection() {
		return (EReference) getIfcExtrudedAreaSolid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcExtrudedAreaSolid_Depth() {
		return (EAttribute) getIfcExtrudedAreaSolid().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcExtrudedAreaSolid_DepthAsString() {
		return (EAttribute) getIfcExtrudedAreaSolid().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFace() {
		if (ifcFaceEClass == null) {
			ifcFaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(220);
		}
		return ifcFaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFace_Bounds() {
		return (EReference) getIfcFace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFaceBasedSurfaceModel() {
		if (ifcFaceBasedSurfaceModelEClass == null) {
			ifcFaceBasedSurfaceModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(221);
		}
		return ifcFaceBasedSurfaceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFaceBasedSurfaceModel_FbsmFaces() {
		return (EReference) getIfcFaceBasedSurfaceModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFaceBasedSurfaceModel_Dim() {
		return (EAttribute) getIfcFaceBasedSurfaceModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFaceBound() {
		if (ifcFaceBoundEClass == null) {
			ifcFaceBoundEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(222);
		}
		return ifcFaceBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFaceBound_Bound() {
		return (EReference) getIfcFaceBound().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFaceBound_Orientation() {
		return (EAttribute) getIfcFaceBound().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFaceOuterBound() {
		if (ifcFaceOuterBoundEClass == null) {
			ifcFaceOuterBoundEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(223);
		}
		return ifcFaceOuterBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFaceSurface() {
		if (ifcFaceSurfaceEClass == null) {
			ifcFaceSurfaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(224);
		}
		return ifcFaceSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFaceSurface_FaceSurface() {
		return (EReference) getIfcFaceSurface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFaceSurface_SameSense() {
		return (EAttribute) getIfcFaceSurface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFacetedBrep() {
		if (ifcFacetedBrepEClass == null) {
			ifcFacetedBrepEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(225);
		}
		return ifcFacetedBrepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFacetedBrepWithVoids() {
		if (ifcFacetedBrepWithVoidsEClass == null) {
			ifcFacetedBrepWithVoidsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(226);
		}
		return ifcFacetedBrepWithVoidsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFacetedBrepWithVoids_Voids() {
		return (EReference) getIfcFacetedBrepWithVoids().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFailureConnectionCondition() {
		if (ifcFailureConnectionConditionEClass == null) {
			ifcFailureConnectionConditionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(227);
		}
		return ifcFailureConnectionConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_TensionFailureX() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_TensionFailureXAsString() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_TensionFailureY() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_TensionFailureYAsString() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_TensionFailureZ() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_TensionFailureZAsString() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_CompressionFailureX() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_CompressionFailureXAsString() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_CompressionFailureY() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_CompressionFailureYAsString() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_CompressionFailureZ() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFailureConnectionCondition_CompressionFailureZAsString() {
		return (EAttribute) getIfcFailureConnectionCondition().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFanType() {
		if (ifcFanTypeEClass == null) {
			ifcFanTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(228);
		}
		return ifcFanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFanType_PredefinedType() {
		return (EAttribute) getIfcFanType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFastener() {
		if (ifcFastenerEClass == null) {
			ifcFastenerEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(229);
		}
		return ifcFastenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFastenerType() {
		if (ifcFastenerTypeEClass == null) {
			ifcFastenerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(230);
		}
		return ifcFastenerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFeatureElement() {
		if (ifcFeatureElementEClass == null) {
			ifcFeatureElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(231);
		}
		return ifcFeatureElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFeatureElementAddition() {
		if (ifcFeatureElementAdditionEClass == null) {
			ifcFeatureElementAdditionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(232);
		}
		return ifcFeatureElementAdditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFeatureElementAddition_ProjectsElements() {
		return (EReference) getIfcFeatureElementAddition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFeatureElementSubtraction() {
		if (ifcFeatureElementSubtractionEClass == null) {
			ifcFeatureElementSubtractionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(233);
		}
		return ifcFeatureElementSubtractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFeatureElementSubtraction_VoidsElements() {
		return (EReference) getIfcFeatureElementSubtraction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFillAreaStyle() {
		if (ifcFillAreaStyleEClass == null) {
			ifcFillAreaStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(234);
		}
		return ifcFillAreaStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFillAreaStyle_FillStyles() {
		return (EReference) getIfcFillAreaStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFillAreaStyleHatching() {
		if (ifcFillAreaStyleHatchingEClass == null) {
			ifcFillAreaStyleHatchingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(235);
		}
		return ifcFillAreaStyleHatchingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFillAreaStyleHatching_HatchLineAppearance() {
		return (EReference) getIfcFillAreaStyleHatching().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFillAreaStyleHatching_StartOfNextHatchLine() {
		return (EReference) getIfcFillAreaStyleHatching().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFillAreaStyleHatching_PointOfReferenceHatchLine() {
		return (EReference) getIfcFillAreaStyleHatching().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFillAreaStyleHatching_PatternStart() {
		return (EReference) getIfcFillAreaStyleHatching().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFillAreaStyleHatching_HatchLineAngle() {
		return (EAttribute) getIfcFillAreaStyleHatching().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFillAreaStyleHatching_HatchLineAngleAsString() {
		return (EAttribute) getIfcFillAreaStyleHatching().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFillAreaStyleTileSymbolWithStyle() {
		if (ifcFillAreaStyleTileSymbolWithStyleEClass == null) {
			ifcFillAreaStyleTileSymbolWithStyleEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(236);
		}
		return ifcFillAreaStyleTileSymbolWithStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFillAreaStyleTileSymbolWithStyle_Symbol() {
		return (EReference) getIfcFillAreaStyleTileSymbolWithStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFillAreaStyleTiles() {
		if (ifcFillAreaStyleTilesEClass == null) {
			ifcFillAreaStyleTilesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(237);
		}
		return ifcFillAreaStyleTilesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFillAreaStyleTiles_TilingPattern() {
		return (EReference) getIfcFillAreaStyleTiles().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFillAreaStyleTiles_Tiles() {
		return (EReference) getIfcFillAreaStyleTiles().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFillAreaStyleTiles_TilingScale() {
		return (EAttribute) getIfcFillAreaStyleTiles().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFillAreaStyleTiles_TilingScaleAsString() {
		return (EAttribute) getIfcFillAreaStyleTiles().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFilterType() {
		if (ifcFilterTypeEClass == null) {
			ifcFilterTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(238);
		}
		return ifcFilterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFilterType_PredefinedType() {
		return (EAttribute) getIfcFilterType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFireSuppressionTerminalType() {
		if (ifcFireSuppressionTerminalTypeEClass == null) {
			ifcFireSuppressionTerminalTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(239);
		}
		return ifcFireSuppressionTerminalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFireSuppressionTerminalType_PredefinedType() {
		return (EAttribute) getIfcFireSuppressionTerminalType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowController() {
		if (ifcFlowControllerEClass == null) {
			ifcFlowControllerEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(240);
		}
		return ifcFlowControllerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowControllerType() {
		if (ifcFlowControllerTypeEClass == null) {
			ifcFlowControllerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(241);
		}
		return ifcFlowControllerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowFitting() {
		if (ifcFlowFittingEClass == null) {
			ifcFlowFittingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(242);
		}
		return ifcFlowFittingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowFittingType() {
		if (ifcFlowFittingTypeEClass == null) {
			ifcFlowFittingTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(243);
		}
		return ifcFlowFittingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowInstrumentType() {
		if (ifcFlowInstrumentTypeEClass == null) {
			ifcFlowInstrumentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(244);
		}
		return ifcFlowInstrumentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFlowInstrumentType_PredefinedType() {
		return (EAttribute) getIfcFlowInstrumentType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowMeterType() {
		if (ifcFlowMeterTypeEClass == null) {
			ifcFlowMeterTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(245);
		}
		return ifcFlowMeterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFlowMeterType_PredefinedType() {
		return (EAttribute) getIfcFlowMeterType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowMovingDevice() {
		if (ifcFlowMovingDeviceEClass == null) {
			ifcFlowMovingDeviceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(246);
		}
		return ifcFlowMovingDeviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowMovingDeviceType() {
		if (ifcFlowMovingDeviceTypeEClass == null) {
			ifcFlowMovingDeviceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(247);
		}
		return ifcFlowMovingDeviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowSegment() {
		if (ifcFlowSegmentEClass == null) {
			ifcFlowSegmentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(248);
		}
		return ifcFlowSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowSegmentType() {
		if (ifcFlowSegmentTypeEClass == null) {
			ifcFlowSegmentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(249);
		}
		return ifcFlowSegmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowStorageDevice() {
		if (ifcFlowStorageDeviceEClass == null) {
			ifcFlowStorageDeviceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(250);
		}
		return ifcFlowStorageDeviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowStorageDeviceType() {
		if (ifcFlowStorageDeviceTypeEClass == null) {
			ifcFlowStorageDeviceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(251);
		}
		return ifcFlowStorageDeviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowTerminal() {
		if (ifcFlowTerminalEClass == null) {
			ifcFlowTerminalEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(252);
		}
		return ifcFlowTerminalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowTerminalType() {
		if (ifcFlowTerminalTypeEClass == null) {
			ifcFlowTerminalTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(253);
		}
		return ifcFlowTerminalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowTreatmentDevice() {
		if (ifcFlowTreatmentDeviceEClass == null) {
			ifcFlowTreatmentDeviceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(254);
		}
		return ifcFlowTreatmentDeviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFlowTreatmentDeviceType() {
		if (ifcFlowTreatmentDeviceTypeEClass == null) {
			ifcFlowTreatmentDeviceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(255);
		}
		return ifcFlowTreatmentDeviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFluidFlowProperties() {
		if (ifcFluidFlowPropertiesEClass == null) {
			ifcFluidFlowPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(256);
		}
		return ifcFluidFlowPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_PropertySource() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFluidFlowProperties_FlowConditionTimeSeries() {
		return (EReference) getIfcFluidFlowProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFluidFlowProperties_VelocityTimeSeries() {
		return (EReference) getIfcFluidFlowProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFluidFlowProperties_FlowrateTimeSeries() {
		return (EReference) getIfcFluidFlowProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFluidFlowProperties_Fluid() {
		return (EReference) getIfcFluidFlowProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFluidFlowProperties_PressureTimeSeries() {
		return (EReference) getIfcFluidFlowProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_UserDefinedPropertySource() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_TemperatureSingleValue() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_TemperatureSingleValueAsString() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_WetBulbTemperatureSingleValue() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_WetBulbTemperatureSingleValueAsString() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFluidFlowProperties_WetBulbTemperatureTimeSeries() {
		return (EReference) getIfcFluidFlowProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFluidFlowProperties_TemperatureTimeSeries() {
		return (EReference) getIfcFluidFlowProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcFluidFlowProperties_FlowrateSingleValue() {
		return (EReference) getIfcFluidFlowProperties().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_FlowConditionSingleValue() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_FlowConditionSingleValueAsString() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_VelocitySingleValue() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_VelocitySingleValueAsString() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_PressureSingleValue() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFluidFlowProperties_PressureSingleValueAsString() {
		return (EAttribute) getIfcFluidFlowProperties().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFooting() {
		if (ifcFootingEClass == null) {
			ifcFootingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(257);
		}
		return ifcFootingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFooting_PredefinedType() {
		return (EAttribute) getIfcFooting().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFuelProperties() {
		if (ifcFuelPropertiesEClass == null) {
			ifcFuelPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(258);
		}
		return ifcFuelPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFuelProperties_CombustionTemperature() {
		return (EAttribute) getIfcFuelProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFuelProperties_CombustionTemperatureAsString() {
		return (EAttribute) getIfcFuelProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFuelProperties_CarbonContent() {
		return (EAttribute) getIfcFuelProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFuelProperties_CarbonContentAsString() {
		return (EAttribute) getIfcFuelProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFuelProperties_LowerHeatingValue() {
		return (EAttribute) getIfcFuelProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFuelProperties_LowerHeatingValueAsString() {
		return (EAttribute) getIfcFuelProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFuelProperties_HigherHeatingValue() {
		return (EAttribute) getIfcFuelProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFuelProperties_HigherHeatingValueAsString() {
		return (EAttribute) getIfcFuelProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFurnishingElement() {
		if (ifcFurnishingElementEClass == null) {
			ifcFurnishingElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(259);
		}
		return ifcFurnishingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFurnishingElementType() {
		if (ifcFurnishingElementTypeEClass == null) {
			ifcFurnishingElementTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(260);
		}
		return ifcFurnishingElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFurnitureStandard() {
		if (ifcFurnitureStandardEClass == null) {
			ifcFurnitureStandardEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(261);
		}
		return ifcFurnitureStandardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFurnitureType() {
		if (ifcFurnitureTypeEClass == null) {
			ifcFurnitureTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(262);
		}
		return ifcFurnitureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFurnitureType_AssemblyPlace() {
		return (EAttribute) getIfcFurnitureType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGasTerminalType() {
		if (ifcGasTerminalTypeEClass == null) {
			ifcGasTerminalTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(263);
		}
		return ifcGasTerminalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGasTerminalType_PredefinedType() {
		return (EAttribute) getIfcGasTerminalType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGeneralMaterialProperties() {
		if (ifcGeneralMaterialPropertiesEClass == null) {
			ifcGeneralMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(264);
		}
		return ifcGeneralMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralMaterialProperties_MolecularWeight() {
		return (EAttribute) getIfcGeneralMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralMaterialProperties_MolecularWeightAsString() {
		return (EAttribute) getIfcGeneralMaterialProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralMaterialProperties_Porosity() {
		return (EAttribute) getIfcGeneralMaterialProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralMaterialProperties_PorosityAsString() {
		return (EAttribute) getIfcGeneralMaterialProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralMaterialProperties_MassDensity() {
		return (EAttribute) getIfcGeneralMaterialProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralMaterialProperties_MassDensityAsString() {
		return (EAttribute) getIfcGeneralMaterialProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGeneralProfileProperties() {
		if (ifcGeneralProfilePropertiesEClass == null) {
			ifcGeneralProfilePropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(265);
		}
		return ifcGeneralProfilePropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_PhysicalWeight() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_PhysicalWeightAsString() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_Perimeter() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_PerimeterAsString() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_MinimumPlateThickness() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_MinimumPlateThicknessAsString() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_MaximumPlateThickness() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_MaximumPlateThicknessAsString() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_CrossSectionArea() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeneralProfileProperties_CrossSectionAreaAsString() {
		return (EAttribute) getIfcGeneralProfileProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGeometricCurveSet() {
		if (ifcGeometricCurveSetEClass == null) {
			ifcGeometricCurveSetEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(266);
		}
		return ifcGeometricCurveSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGeometricRepresentationContext() {
		if (ifcGeometricRepresentationContextEClass == null) {
			ifcGeometricRepresentationContextEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(267);
		}
		return ifcGeometricRepresentationContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeometricRepresentationContext_CoordinateSpaceDimension() {
		return (EAttribute) getIfcGeometricRepresentationContext().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeometricRepresentationContext_Precision() {
		return (EAttribute) getIfcGeometricRepresentationContext().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeometricRepresentationContext_PrecisionAsString() {
		return (EAttribute) getIfcGeometricRepresentationContext().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGeometricRepresentationContext_WorldCoordinateSystem() {
		return (EReference) getIfcGeometricRepresentationContext().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGeometricRepresentationContext_TrueNorth() {
		return (EReference) getIfcGeometricRepresentationContext().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGeometricRepresentationContext_HasSubContexts() {
		return (EReference) getIfcGeometricRepresentationContext().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGeometricRepresentationItem() {
		if (ifcGeometricRepresentationItemEClass == null) {
			ifcGeometricRepresentationItemEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(268);
		}
		return ifcGeometricRepresentationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGeometricRepresentationSubContext() {
		if (ifcGeometricRepresentationSubContextEClass == null) {
			ifcGeometricRepresentationSubContextEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(269);
		}
		return ifcGeometricRepresentationSubContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGeometricRepresentationSubContext_ParentContext() {
		return (EReference) getIfcGeometricRepresentationSubContext().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeometricRepresentationSubContext_TargetScale() {
		return (EAttribute) getIfcGeometricRepresentationSubContext().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeometricRepresentationSubContext_TargetScaleAsString() {
		return (EAttribute) getIfcGeometricRepresentationSubContext().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeometricRepresentationSubContext_TargetView() {
		return (EAttribute) getIfcGeometricRepresentationSubContext().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeometricRepresentationSubContext_UserDefinedTargetView() {
		return (EAttribute) getIfcGeometricRepresentationSubContext().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGeometricSet() {
		if (ifcGeometricSetEClass == null) {
			ifcGeometricSetEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(270);
		}
		return ifcGeometricSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGeometricSet_Elements() {
		return (EReference) getIfcGeometricSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGeometricSet_Dim() {
		return (EAttribute) getIfcGeometricSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGrid() {
		if (ifcGridEClass == null) {
			ifcGridEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(271);
		}
		return ifcGridEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGrid_UAxes() {
		return (EReference) getIfcGrid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGrid_VAxes() {
		return (EReference) getIfcGrid().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGrid_WAxes() {
		return (EReference) getIfcGrid().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGrid_ContainedInStructure() {
		return (EReference) getIfcGrid().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGridAxis() {
		if (ifcGridAxisEClass == null) {
			ifcGridAxisEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(272);
		}
		return ifcGridAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGridAxis_AxisTag() {
		return (EAttribute) getIfcGridAxis().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGridAxis_AxisCurve() {
		return (EReference) getIfcGridAxis().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGridAxis_SameSense() {
		return (EAttribute) getIfcGridAxis().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGridAxis_PartOfW() {
		return (EReference) getIfcGridAxis().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGridAxis_PartOfV() {
		return (EReference) getIfcGridAxis().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGridAxis_PartOfU() {
		return (EReference) getIfcGridAxis().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGridAxis_HasIntersections() {
		return (EReference) getIfcGridAxis().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGridPlacement() {
		if (ifcGridPlacementEClass == null) {
			ifcGridPlacementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(273);
		}
		return ifcGridPlacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGridPlacement_PlacementLocation() {
		return (EReference) getIfcGridPlacement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGridPlacement_PlacementRefDirection() {
		return (EReference) getIfcGridPlacement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGroup() {
		if (ifcGroupEClass == null) {
			ifcGroupEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(274);
		}
		return ifcGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcGroup_IsGroupedBy() {
		return (EReference) getIfcGroup().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHalfSpaceSolid() {
		if (ifcHalfSpaceSolidEClass == null) {
			ifcHalfSpaceSolidEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(275);
		}
		return ifcHalfSpaceSolidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcHalfSpaceSolid_BaseSurface() {
		return (EReference) getIfcHalfSpaceSolid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHalfSpaceSolid_AgreementFlag() {
		return (EAttribute) getIfcHalfSpaceSolid().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHalfSpaceSolid_Dim() {
		return (EAttribute) getIfcHalfSpaceSolid().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHeatExchangerType() {
		if (ifcHeatExchangerTypeEClass == null) {
			ifcHeatExchangerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(276);
		}
		return ifcHeatExchangerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeatExchangerType_PredefinedType() {
		return (EAttribute) getIfcHeatExchangerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHumidifierType() {
		if (ifcHumidifierTypeEClass == null) {
			ifcHumidifierTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(277);
		}
		return ifcHumidifierTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHumidifierType_PredefinedType() {
		return (EAttribute) getIfcHumidifierType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHygroscopicMaterialProperties() {
		if (ifcHygroscopicMaterialPropertiesEClass == null) {
			ifcHygroscopicMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(278);
		}
		return ifcHygroscopicMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactor() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactorAsString() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactor() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactorAsString() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacity() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacityAsString() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_VaporPermeability() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_VaporPermeabilityAsString() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_MoistureDiffusivity() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHygroscopicMaterialProperties_MoistureDiffusivityAsString() {
		return (EAttribute) getIfcHygroscopicMaterialProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcIShapeProfileDef() {
		if (ifcIShapeProfileDefEClass == null) {
			ifcIShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(279);
		}
		return ifcIShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_OverallWidth() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_OverallWidthAsString() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_OverallDepth() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_OverallDepthAsString() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_WebThickness() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_WebThicknessAsString() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_FlangeThickness() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_FlangeThicknessAsString() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_FilletRadius() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIShapeProfileDef_FilletRadiusAsString() {
		return (EAttribute) getIfcIShapeProfileDef().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcImageTexture() {
		if (ifcImageTextureEClass == null) {
			ifcImageTextureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(280);
		}
		return ifcImageTextureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcImageTexture_UrlReference() {
		return (EAttribute) getIfcImageTexture().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcInventory() {
		if (ifcInventoryEClass == null) {
			ifcInventoryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(281);
		}
		return ifcInventoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcInventory_InventoryType() {
		return (EAttribute) getIfcInventory().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcInventory_Jurisdiction() {
		return (EReference) getIfcInventory().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcInventory_ResponsiblePersons() {
		return (EReference) getIfcInventory().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcInventory_LastUpdateDate() {
		return (EReference) getIfcInventory().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcInventory_CurrentValue() {
		return (EReference) getIfcInventory().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcInventory_OriginalValue() {
		return (EReference) getIfcInventory().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcIrregularTimeSeries() {
		if (ifcIrregularTimeSeriesEClass == null) {
			ifcIrregularTimeSeriesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(282);
		}
		return ifcIrregularTimeSeriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcIrregularTimeSeries_Values() {
		return (EReference) getIfcIrregularTimeSeries().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcIrregularTimeSeriesValue() {
		if (ifcIrregularTimeSeriesValueEClass == null) {
			ifcIrregularTimeSeriesValueEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(283);
		}
		return ifcIrregularTimeSeriesValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcIrregularTimeSeriesValue_TimeStamp() {
		return (EReference) getIfcIrregularTimeSeriesValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcIrregularTimeSeriesValue_ListValues() {
		return (EReference) getIfcIrregularTimeSeriesValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcJunctionBoxType() {
		if (ifcJunctionBoxTypeEClass == null) {
			ifcJunctionBoxTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(284);
		}
		return ifcJunctionBoxTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcJunctionBoxType_PredefinedType() {
		return (EAttribute) getIfcJunctionBoxType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLShapeProfileDef() {
		if (ifcLShapeProfileDefEClass == null) {
			ifcLShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(285);
		}
		return ifcLShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_Depth() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_DepthAsString() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_Width() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_WidthAsString() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_Thickness() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_ThicknessAsString() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_FilletRadius() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_FilletRadiusAsString() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_EdgeRadius() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_EdgeRadiusAsString() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_LegSlope() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_LegSlopeAsString() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_CentreOfGravityInX() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_CentreOfGravityInXAsString() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_CentreOfGravityInY() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLShapeProfileDef_CentreOfGravityInYAsString() {
		return (EAttribute) getIfcLShapeProfileDef().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLaborResource() {
		if (ifcLaborResourceEClass == null) {
			ifcLaborResourceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(286);
		}
		return ifcLaborResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLaborResource_SkillSet() {
		return (EAttribute) getIfcLaborResource().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLampType() {
		if (ifcLampTypeEClass == null) {
			ifcLampTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(287);
		}
		return ifcLampTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLampType_PredefinedType() {
		return (EAttribute) getIfcLampType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLibraryInformation() {
		if (ifcLibraryInformationEClass == null) {
			ifcLibraryInformationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(288);
		}
		return ifcLibraryInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLibraryInformation_Name() {
		return (EAttribute) getIfcLibraryInformation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLibraryInformation_Version() {
		return (EAttribute) getIfcLibraryInformation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLibraryInformation_Publisher() {
		return (EReference) getIfcLibraryInformation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLibraryInformation_VersionDate() {
		return (EReference) getIfcLibraryInformation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLibraryInformation_LibraryReference() {
		return (EReference) getIfcLibraryInformation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLibraryReference() {
		if (ifcLibraryReferenceEClass == null) {
			ifcLibraryReferenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(289);
		}
		return ifcLibraryReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLibraryReference_ReferenceIntoLibrary() {
		return (EReference) getIfcLibraryReference().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightDistributionData() {
		if (ifcLightDistributionDataEClass == null) {
			ifcLightDistributionDataEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(290);
		}
		return ifcLightDistributionDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightDistributionData_MainPlaneAngle() {
		return (EAttribute) getIfcLightDistributionData().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightDistributionData_MainPlaneAngleAsString() {
		return (EAttribute) getIfcLightDistributionData().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightDistributionData_SecondaryPlaneAngle() {
		return (EAttribute) getIfcLightDistributionData().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightDistributionData_SecondaryPlaneAngleAsString() {
		return (EAttribute) getIfcLightDistributionData().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightDistributionData_LuminousIntensity() {
		return (EAttribute) getIfcLightDistributionData().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightDistributionData_LuminousIntensityAsString() {
		return (EAttribute) getIfcLightDistributionData().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightFixtureType() {
		if (ifcLightFixtureTypeEClass == null) {
			ifcLightFixtureTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(291);
		}
		return ifcLightFixtureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightFixtureType_PredefinedType() {
		return (EAttribute) getIfcLightFixtureType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightIntensityDistribution() {
		if (ifcLightIntensityDistributionEClass == null) {
			ifcLightIntensityDistributionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(292);
		}
		return ifcLightIntensityDistributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightIntensityDistribution_LightDistributionCurve() {
		return (EAttribute) getIfcLightIntensityDistribution().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLightIntensityDistribution_DistributionData() {
		return (EReference) getIfcLightIntensityDistribution().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightSource() {
		if (ifcLightSourceEClass == null) {
			ifcLightSourceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(293);
		}
		return ifcLightSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSource_Name() {
		return (EAttribute) getIfcLightSource().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLightSource_LightColour() {
		return (EReference) getIfcLightSource().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSource_AmbientIntensity() {
		return (EAttribute) getIfcLightSource().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSource_AmbientIntensityAsString() {
		return (EAttribute) getIfcLightSource().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSource_Intensity() {
		return (EAttribute) getIfcLightSource().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSource_IntensityAsString() {
		return (EAttribute) getIfcLightSource().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightSourceAmbient() {
		if (ifcLightSourceAmbientEClass == null) {
			ifcLightSourceAmbientEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(294);
		}
		return ifcLightSourceAmbientEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightSourceDirectional() {
		if (ifcLightSourceDirectionalEClass == null) {
			ifcLightSourceDirectionalEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(295);
		}
		return ifcLightSourceDirectionalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLightSourceDirectional_Orientation() {
		return (EReference) getIfcLightSourceDirectional().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightSourceGoniometric() {
		if (ifcLightSourceGoniometricEClass == null) {
			ifcLightSourceGoniometricEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(296);
		}
		return ifcLightSourceGoniometricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLightSourceGoniometric_Position() {
		return (EReference) getIfcLightSourceGoniometric().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLightSourceGoniometric_ColourAppearance() {
		return (EReference) getIfcLightSourceGoniometric().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceGoniometric_ColourTemperature() {
		return (EAttribute) getIfcLightSourceGoniometric().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceGoniometric_ColourTemperatureAsString() {
		return (EAttribute) getIfcLightSourceGoniometric().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceGoniometric_LuminousFlux() {
		return (EAttribute) getIfcLightSourceGoniometric().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceGoniometric_LuminousFluxAsString() {
		return (EAttribute) getIfcLightSourceGoniometric().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceGoniometric_LightEmissionSource() {
		return (EAttribute) getIfcLightSourceGoniometric().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLightSourceGoniometric_LightDistributionDataSource() {
		return (EReference) getIfcLightSourceGoniometric().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightSourcePositional() {
		if (ifcLightSourcePositionalEClass == null) {
			ifcLightSourcePositionalEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(297);
		}
		return ifcLightSourcePositionalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLightSourcePositional_Position() {
		return (EReference) getIfcLightSourcePositional().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourcePositional_Radius() {
		return (EAttribute) getIfcLightSourcePositional().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourcePositional_RadiusAsString() {
		return (EAttribute) getIfcLightSourcePositional().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourcePositional_ConstantAttenuation() {
		return (EAttribute) getIfcLightSourcePositional().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourcePositional_ConstantAttenuationAsString() {
		return (EAttribute) getIfcLightSourcePositional().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourcePositional_DistanceAttenuation() {
		return (EAttribute) getIfcLightSourcePositional().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourcePositional_DistanceAttenuationAsString() {
		return (EAttribute) getIfcLightSourcePositional().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourcePositional_QuadricAttenuation() {
		return (EAttribute) getIfcLightSourcePositional().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourcePositional_QuadricAttenuationAsString() {
		return (EAttribute) getIfcLightSourcePositional().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightSourceSpot() {
		if (ifcLightSourceSpotEClass == null) {
			ifcLightSourceSpotEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(298);
		}
		return ifcLightSourceSpotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLightSourceSpot_Orientation() {
		return (EReference) getIfcLightSourceSpot().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceSpot_ConcentrationExponent() {
		return (EAttribute) getIfcLightSourceSpot().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceSpot_ConcentrationExponentAsString() {
		return (EAttribute) getIfcLightSourceSpot().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceSpot_SpreadAngle() {
		return (EAttribute) getIfcLightSourceSpot().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceSpot_SpreadAngleAsString() {
		return (EAttribute) getIfcLightSourceSpot().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceSpot_BeamWidthAngle() {
		return (EAttribute) getIfcLightSourceSpot().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLightSourceSpot_BeamWidthAngleAsString() {
		return (EAttribute) getIfcLightSourceSpot().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLine() {
		if (ifcLineEClass == null) {
			ifcLineEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(299);
		}
		return ifcLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLine_Pnt() {
		return (EReference) getIfcLine().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLine_Dir() {
		return (EReference) getIfcLine().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLinearDimension() {
		if (ifcLinearDimensionEClass == null) {
			ifcLinearDimensionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(300);
		}
		return ifcLinearDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLocalPlacement() {
		if (ifcLocalPlacementEClass == null) {
			ifcLocalPlacementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(301);
		}
		return ifcLocalPlacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLocalPlacement_PlacementRelTo() {
		return (EReference) getIfcLocalPlacement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLocalPlacement_RelativePlacement() {
		return (EReference) getIfcLocalPlacement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLocalTime() {
		if (ifcLocalTimeEClass == null) {
			ifcLocalTimeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(302);
		}
		return ifcLocalTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLocalTime_HourComponent() {
		return (EAttribute) getIfcLocalTime().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLocalTime_MinuteComponent() {
		return (EAttribute) getIfcLocalTime().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLocalTime_SecondComponent() {
		return (EAttribute) getIfcLocalTime().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLocalTime_SecondComponentAsString() {
		return (EAttribute) getIfcLocalTime().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcLocalTime_Zone() {
		return (EReference) getIfcLocalTime().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLocalTime_DaylightSavingOffset() {
		return (EAttribute) getIfcLocalTime().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLoop() {
		if (ifcLoopEClass == null) {
			ifcLoopEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(303);
		}
		return ifcLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcManifoldSolidBrep() {
		if (ifcManifoldSolidBrepEClass == null) {
			ifcManifoldSolidBrepEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(304);
		}
		return ifcManifoldSolidBrepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcManifoldSolidBrep_Outer() {
		return (EReference) getIfcManifoldSolidBrep().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMappedItem() {
		if (ifcMappedItemEClass == null) {
			ifcMappedItemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(305);
		}
		return ifcMappedItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMappedItem_MappingSource() {
		return (EReference) getIfcMappedItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMappedItem_MappingTarget() {
		return (EReference) getIfcMappedItem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterial() {
		if (ifcMaterialEClass == null) {
			ifcMaterialEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(306);
		}
		return ifcMaterialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterial_Name() {
		return (EAttribute) getIfcMaterial().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterial_HasRepresentation() {
		return (EReference) getIfcMaterial().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterial_ClassifiedAs() {
		return (EReference) getIfcMaterial().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterialClassificationRelationship() {
		if (ifcMaterialClassificationRelationshipEClass == null) {
			ifcMaterialClassificationRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(307);
		}
		return ifcMaterialClassificationRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialClassificationRelationship_MaterialClassifications() {
		return (EReference) getIfcMaterialClassificationRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialClassificationRelationship_ClassifiedMaterial() {
		return (EReference) getIfcMaterialClassificationRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterialDefinitionRepresentation() {
		if (ifcMaterialDefinitionRepresentationEClass == null) {
			ifcMaterialDefinitionRepresentationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(308);
		}
		return ifcMaterialDefinitionRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialDefinitionRepresentation_RepresentedMaterial() {
		return (EReference) getIfcMaterialDefinitionRepresentation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterialLayer() {
		if (ifcMaterialLayerEClass == null) {
			ifcMaterialLayerEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(309);
		}
		return ifcMaterialLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialLayer_Material() {
		return (EReference) getIfcMaterialLayer().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayer_LayerThickness() {
		return (EAttribute) getIfcMaterialLayer().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayer_LayerThicknessAsString() {
		return (EAttribute) getIfcMaterialLayer().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayer_IsVentilated() {
		return (EAttribute) getIfcMaterialLayer().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialLayer_ToMaterialLayerSet() {
		return (EReference) getIfcMaterialLayer().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterialLayerSet() {
		if (ifcMaterialLayerSetEClass == null) {
			ifcMaterialLayerSetEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(310);
		}
		return ifcMaterialLayerSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialLayerSet_MaterialLayers() {
		return (EReference) getIfcMaterialLayerSet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayerSet_LayerSetName() {
		return (EAttribute) getIfcMaterialLayerSet().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayerSet_TotalThickness() {
		return (EAttribute) getIfcMaterialLayerSet().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayerSet_TotalThicknessAsString() {
		return (EAttribute) getIfcMaterialLayerSet().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterialLayerSetUsage() {
		if (ifcMaterialLayerSetUsageEClass == null) {
			ifcMaterialLayerSetUsageEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(311);
		}
		return ifcMaterialLayerSetUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialLayerSetUsage_ForLayerSet() {
		return (EReference) getIfcMaterialLayerSetUsage().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayerSetUsage_LayerSetDirection() {
		return (EAttribute) getIfcMaterialLayerSetUsage().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayerSetUsage_DirectionSense() {
		return (EAttribute) getIfcMaterialLayerSetUsage().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayerSetUsage_OffsetFromReferenceLine() {
		return (EAttribute) getIfcMaterialLayerSetUsage().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMaterialLayerSetUsage_OffsetFromReferenceLineAsString() {
		return (EAttribute) getIfcMaterialLayerSetUsage().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterialList() {
		if (ifcMaterialListEClass == null) {
			ifcMaterialListEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(312);
		}
		return ifcMaterialListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialList_Materials() {
		return (EReference) getIfcMaterialList().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterialProperties() {
		if (ifcMaterialPropertiesEClass == null) {
			ifcMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(313);
		}
		return ifcMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMaterialProperties_Material() {
		return (EReference) getIfcMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMeasureWithUnit() {
		if (ifcMeasureWithUnitEClass == null) {
			ifcMeasureWithUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(314);
		}
		return ifcMeasureWithUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMeasureWithUnit_ValueComponent() {
		return (EReference) getIfcMeasureWithUnit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMeasureWithUnit_UnitComponent() {
		return (EReference) getIfcMeasureWithUnit().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMechanicalConcreteMaterialProperties() {
		if (ifcMechanicalConcreteMaterialPropertiesEClass == null) {
			ifcMechanicalConcreteMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(315);
		}
		return ifcMechanicalConcreteMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_CompressiveStrength() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_CompressiveStrengthAsString() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_MaxAggregateSize() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_MaxAggregateSizeAsString() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_AdmixturesDescription() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_Workability() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatio() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_ProtectivePoreRatioAsString() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalConcreteMaterialProperties_WaterImpermeability() {
		return (EAttribute) getIfcMechanicalConcreteMaterialProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMechanicalFastener() {
		if (ifcMechanicalFastenerEClass == null) {
			ifcMechanicalFastenerEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(316);
		}
		return ifcMechanicalFastenerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalFastener_NominalDiameter() {
		return (EAttribute) getIfcMechanicalFastener().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalFastener_NominalDiameterAsString() {
		return (EAttribute) getIfcMechanicalFastener().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalFastener_NominalLength() {
		return (EAttribute) getIfcMechanicalFastener().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalFastener_NominalLengthAsString() {
		return (EAttribute) getIfcMechanicalFastener().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMechanicalFastenerType() {
		if (ifcMechanicalFastenerTypeEClass == null) {
			ifcMechanicalFastenerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(317);
		}
		return ifcMechanicalFastenerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMechanicalMaterialProperties() {
		if (ifcMechanicalMaterialPropertiesEClass == null) {
			ifcMechanicalMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(318);
		}
		return ifcMechanicalMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_DynamicViscosity() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_DynamicViscosityAsString() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_YoungModulus() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_YoungModulusAsString() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_ShearModulus() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_ShearModulusAsString() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_PoissonRatio() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_PoissonRatioAsString() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_ThermalExpansionCoefficient() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalMaterialProperties_ThermalExpansionCoefficientAsString() {
		return (EAttribute) getIfcMechanicalMaterialProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMechanicalSteelMaterialProperties() {
		if (ifcMechanicalSteelMaterialPropertiesEClass == null) {
			ifcMechanicalSteelMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(319);
		}
		return ifcMechanicalSteelMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_YieldStress() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_YieldStressAsString() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_UltimateStress() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_UltimateStressAsString() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_UltimateStrain() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_UltimateStrainAsString() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_HardeningModule() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_HardeningModuleAsString() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_ProportionalStress() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_ProportionalStressAsString() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_PlasticStrain() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMechanicalSteelMaterialProperties_PlasticStrainAsString() {
		return (EAttribute) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMechanicalSteelMaterialProperties_Relaxations() {
		return (EReference) getIfcMechanicalSteelMaterialProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMember() {
		if (ifcMemberEClass == null) {
			ifcMemberEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(320);
		}
		return ifcMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMemberType() {
		if (ifcMemberTypeEClass == null) {
			ifcMemberTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(321);
		}
		return ifcMemberTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMemberType_PredefinedType() {
		return (EAttribute) getIfcMemberType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMetric() {
		if (ifcMetricEClass == null) {
			ifcMetricEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(322);
		}
		return ifcMetricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMetric_Benchmark() {
		return (EAttribute) getIfcMetric().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMetric_ValueSource() {
		return (EAttribute) getIfcMetric().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMetric_DataValue() {
		return (EReference) getIfcMetric().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMonetaryUnit() {
		if (ifcMonetaryUnitEClass == null) {
			ifcMonetaryUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(323);
		}
		return ifcMonetaryUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMonetaryUnit_Currency() {
		return (EAttribute) getIfcMonetaryUnit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMotorConnectionType() {
		if (ifcMotorConnectionTypeEClass == null) {
			ifcMotorConnectionTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(324);
		}
		return ifcMotorConnectionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMotorConnectionType_PredefinedType() {
		return (EAttribute) getIfcMotorConnectionType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMove() {
		if (ifcMoveEClass == null) {
			ifcMoveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(325);
		}
		return ifcMoveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMove_MoveFrom() {
		return (EReference) getIfcMove().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcMove_MoveTo() {
		return (EReference) getIfcMove().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMove_PunchList() {
		return (EAttribute) getIfcMove().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcNamedUnit() {
		if (ifcNamedUnitEClass == null) {
			ifcNamedUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(326);
		}
		return ifcNamedUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcNamedUnit_Dimensions() {
		return (EReference) getIfcNamedUnit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcNamedUnit_UnitType() {
		return (EAttribute) getIfcNamedUnit().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcObject() {
		if (ifcObjectEClass == null) {
			ifcObjectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(327);
		}
		return ifcObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcObject_ObjectType() {
		return (EAttribute) getIfcObject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObject_IsDefinedBy() {
		return (EReference) getIfcObject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcObjectDefinition() {
		if (ifcObjectDefinitionEClass == null) {
			ifcObjectDefinitionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(328);
		}
		return ifcObjectDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObjectDefinition_HasAssignments() {
		return (EReference) getIfcObjectDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObjectDefinition_IsDecomposedBy() {
		return (EReference) getIfcObjectDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObjectDefinition_Decomposes() {
		return (EReference) getIfcObjectDefinition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObjectDefinition_HasAssociations() {
		return (EReference) getIfcObjectDefinition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcObjectPlacement() {
		if (ifcObjectPlacementEClass == null) {
			ifcObjectPlacementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(329);
		}
		return ifcObjectPlacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObjectPlacement_PlacesObject() {
		return (EReference) getIfcObjectPlacement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObjectPlacement_ReferencedByPlacements() {
		return (EReference) getIfcObjectPlacement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcObjective() {
		if (ifcObjectiveEClass == null) {
			ifcObjectiveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(330);
		}
		return ifcObjectiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObjective_BenchmarkValues() {
		return (EReference) getIfcObjective().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcObjective_ResultValues() {
		return (EReference) getIfcObjective().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcObjective_ObjectiveQualifier() {
		return (EAttribute) getIfcObjective().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcObjective_UserDefinedQualifier() {
		return (EAttribute) getIfcObjective().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOccupant() {
		if (ifcOccupantEClass == null) {
			ifcOccupantEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(331);
		}
		return ifcOccupantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOccupant_PredefinedType() {
		return (EAttribute) getIfcOccupant().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOffsetCurve2D() {
		if (ifcOffsetCurve2DEClass == null) {
			ifcOffsetCurve2DEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(332);
		}
		return ifcOffsetCurve2DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOffsetCurve2D_BasisCurve() {
		return (EReference) getIfcOffsetCurve2D().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOffsetCurve2D_Distance() {
		return (EAttribute) getIfcOffsetCurve2D().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOffsetCurve2D_DistanceAsString() {
		return (EAttribute) getIfcOffsetCurve2D().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOffsetCurve2D_SelfIntersect() {
		return (EAttribute) getIfcOffsetCurve2D().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOffsetCurve3D() {
		if (ifcOffsetCurve3DEClass == null) {
			ifcOffsetCurve3DEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(333);
		}
		return ifcOffsetCurve3DEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOffsetCurve3D_BasisCurve() {
		return (EReference) getIfcOffsetCurve3D().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOffsetCurve3D_Distance() {
		return (EAttribute) getIfcOffsetCurve3D().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOffsetCurve3D_DistanceAsString() {
		return (EAttribute) getIfcOffsetCurve3D().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOffsetCurve3D_SelfIntersect() {
		return (EAttribute) getIfcOffsetCurve3D().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOffsetCurve3D_RefDirection() {
		return (EReference) getIfcOffsetCurve3D().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOneDirectionRepeatFactor() {
		if (ifcOneDirectionRepeatFactorEClass == null) {
			ifcOneDirectionRepeatFactorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(334);
		}
		return ifcOneDirectionRepeatFactorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOneDirectionRepeatFactor_RepeatFactor() {
		return (EReference) getIfcOneDirectionRepeatFactor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOpenShell() {
		if (ifcOpenShellEClass == null) {
			ifcOpenShellEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(335);
		}
		return ifcOpenShellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOpeningElement() {
		if (ifcOpeningElementEClass == null) {
			ifcOpeningElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(336);
		}
		return ifcOpeningElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOpeningElement_HasFillings() {
		return (EReference) getIfcOpeningElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOpticalMaterialProperties() {
		if (ifcOpticalMaterialPropertiesEClass == null) {
			ifcOpticalMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(337);
		}
		return ifcOpticalMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_VisibleTransmittance() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_VisibleTransmittanceAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_SolarTransmittance() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_SolarTransmittanceAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_ThermalIrTransmittance() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_ThermalIrTransmittanceAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_ThermalIrEmissivityBack() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_ThermalIrEmissivityBackAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_ThermalIrEmissivityFront() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_ThermalIrEmissivityFrontAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_VisibleReflectanceBack() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_VisibleReflectanceBackAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_VisibleReflectanceFront() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_VisibleReflectanceFrontAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_SolarReflectanceFront() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_SolarReflectanceFrontAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_SolarReflectanceBack() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOpticalMaterialProperties_SolarReflectanceBackAsString() {
		return (EAttribute) getIfcOpticalMaterialProperties().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOrderAction() {
		if (ifcOrderActionEClass == null) {
			ifcOrderActionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(338);
		}
		return ifcOrderActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOrderAction_ActionID() {
		return (EAttribute) getIfcOrderAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOrganization() {
		if (ifcOrganizationEClass == null) {
			ifcOrganizationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(339);
		}
		return ifcOrganizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOrganization_Id() {
		return (EAttribute) getIfcOrganization().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOrganization_Name() {
		return (EAttribute) getIfcOrganization().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOrganization_Description() {
		return (EAttribute) getIfcOrganization().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOrganization_Roles() {
		return (EReference) getIfcOrganization().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOrganization_Addresses() {
		return (EReference) getIfcOrganization().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOrganization_IsRelatedBy() {
		return (EReference) getIfcOrganization().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOrganization_Relates() {
		return (EReference) getIfcOrganization().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOrganization_Engages() {
		return (EReference) getIfcOrganization().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOrganizationRelationship() {
		if (ifcOrganizationRelationshipEClass == null) {
			ifcOrganizationRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(340);
		}
		return ifcOrganizationRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOrganizationRelationship_Name() {
		return (EAttribute) getIfcOrganizationRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOrganizationRelationship_Description() {
		return (EAttribute) getIfcOrganizationRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOrganizationRelationship_RelatingOrganization() {
		return (EReference) getIfcOrganizationRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOrganizationRelationship_RelatedOrganizations() {
		return (EReference) getIfcOrganizationRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOrientedEdge() {
		if (ifcOrientedEdgeEClass == null) {
			ifcOrientedEdgeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(341);
		}
		return ifcOrientedEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOrientedEdge_EdgeElement() {
		return (EReference) getIfcOrientedEdge().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOrientedEdge_Orientation() {
		return (EAttribute) getIfcOrientedEdge().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOutletType() {
		if (ifcOutletTypeEClass == null) {
			ifcOutletTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(342);
		}
		return ifcOutletTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOutletType_PredefinedType() {
		return (EAttribute) getIfcOutletType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOwnerHistory() {
		if (ifcOwnerHistoryEClass == null) {
			ifcOwnerHistoryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(343);
		}
		return ifcOwnerHistoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOwnerHistory_OwningUser() {
		return (EReference) getIfcOwnerHistory().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOwnerHistory_OwningApplication() {
		return (EReference) getIfcOwnerHistory().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOwnerHistory_State() {
		return (EAttribute) getIfcOwnerHistory().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOwnerHistory_ChangeAction() {
		return (EAttribute) getIfcOwnerHistory().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOwnerHistory_LastModifiedDate() {
		return (EAttribute) getIfcOwnerHistory().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOwnerHistory_LastModifyingUser() {
		return (EReference) getIfcOwnerHistory().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcOwnerHistory_LastModifyingApplication() {
		return (EReference) getIfcOwnerHistory().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcOwnerHistory_CreationDate() {
		return (EAttribute) getIfcOwnerHistory().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcParameterizedProfileDef() {
		if (ifcParameterizedProfileDefEClass == null) {
			ifcParameterizedProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(344);
		}
		return ifcParameterizedProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcParameterizedProfileDef_Position() {
		return (EReference) getIfcParameterizedProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPath() {
		if (ifcPathEClass == null) {
			ifcPathEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(345);
		}
		return ifcPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPath_EdgeList() {
		return (EReference) getIfcPath().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPerformanceHistory() {
		if (ifcPerformanceHistoryEClass == null) {
			ifcPerformanceHistoryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(346);
		}
		return ifcPerformanceHistoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPerformanceHistory_LifeCyclePhase() {
		return (EAttribute) getIfcPerformanceHistory().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPermeableCoveringProperties() {
		if (ifcPermeableCoveringPropertiesEClass == null) {
			ifcPermeableCoveringPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(347);
		}
		return ifcPermeableCoveringPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPermeableCoveringProperties_OperationType() {
		return (EAttribute) getIfcPermeableCoveringProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPermeableCoveringProperties_PanelPosition() {
		return (EAttribute) getIfcPermeableCoveringProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPermeableCoveringProperties_FrameDepth() {
		return (EAttribute) getIfcPermeableCoveringProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPermeableCoveringProperties_FrameDepthAsString() {
		return (EAttribute) getIfcPermeableCoveringProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPermeableCoveringProperties_FrameThickness() {
		return (EAttribute) getIfcPermeableCoveringProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPermeableCoveringProperties_FrameThicknessAsString() {
		return (EAttribute) getIfcPermeableCoveringProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPermeableCoveringProperties_ShapeAspectStyle() {
		return (EReference) getIfcPermeableCoveringProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPermit() {
		if (ifcPermitEClass == null) {
			ifcPermitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(348);
		}
		return ifcPermitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPermit_PermitID() {
		return (EAttribute) getIfcPermit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPerson() {
		if (ifcPersonEClass == null) {
			ifcPersonEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(349);
		}
		return ifcPersonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPerson_Id() {
		return (EAttribute) getIfcPerson().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPerson_FamilyName() {
		return (EAttribute) getIfcPerson().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPerson_GivenName() {
		return (EAttribute) getIfcPerson().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPerson_MiddleNames() {
		return (EAttribute) getIfcPerson().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPerson_PrefixTitles() {
		return (EAttribute) getIfcPerson().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPerson_SuffixTitles() {
		return (EAttribute) getIfcPerson().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPerson_Roles() {
		return (EReference) getIfcPerson().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPerson_Addresses() {
		return (EReference) getIfcPerson().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPerson_EngagedIn() {
		return (EReference) getIfcPerson().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPersonAndOrganization() {
		if (ifcPersonAndOrganizationEClass == null) {
			ifcPersonAndOrganizationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(350);
		}
		return ifcPersonAndOrganizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPersonAndOrganization_ThePerson() {
		return (EReference) getIfcPersonAndOrganization().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPersonAndOrganization_TheOrganization() {
		return (EReference) getIfcPersonAndOrganization().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPersonAndOrganization_Roles() {
		return (EReference) getIfcPersonAndOrganization().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPhysicalComplexQuantity() {
		if (ifcPhysicalComplexQuantityEClass == null) {
			ifcPhysicalComplexQuantityEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(351);
		}
		return ifcPhysicalComplexQuantityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPhysicalComplexQuantity_HasQuantities() {
		return (EReference) getIfcPhysicalComplexQuantity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPhysicalComplexQuantity_Discrimination() {
		return (EAttribute) getIfcPhysicalComplexQuantity().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPhysicalComplexQuantity_Quality() {
		return (EAttribute) getIfcPhysicalComplexQuantity().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPhysicalComplexQuantity_Usage() {
		return (EAttribute) getIfcPhysicalComplexQuantity().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPhysicalQuantity() {
		if (ifcPhysicalQuantityEClass == null) {
			ifcPhysicalQuantityEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(352);
		}
		return ifcPhysicalQuantityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPhysicalQuantity_Name() {
		return (EAttribute) getIfcPhysicalQuantity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPhysicalQuantity_Description() {
		return (EAttribute) getIfcPhysicalQuantity().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPhysicalQuantity_PartOfComplex() {
		return (EReference) getIfcPhysicalQuantity().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPhysicalSimpleQuantity() {
		if (ifcPhysicalSimpleQuantityEClass == null) {
			ifcPhysicalSimpleQuantityEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(353);
		}
		return ifcPhysicalSimpleQuantityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPhysicalSimpleQuantity_Unit() {
		return (EReference) getIfcPhysicalSimpleQuantity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPile() {
		if (ifcPileEClass == null) {
			ifcPileEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(354);
		}
		return ifcPileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPile_PredefinedType() {
		return (EAttribute) getIfcPile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPile_ConstructionType() {
		return (EAttribute) getIfcPile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPipeFittingType() {
		if (ifcPipeFittingTypeEClass == null) {
			ifcPipeFittingTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(355);
		}
		return ifcPipeFittingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPipeFittingType_PredefinedType() {
		return (EAttribute) getIfcPipeFittingType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPipeSegmentType() {
		if (ifcPipeSegmentTypeEClass == null) {
			ifcPipeSegmentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(356);
		}
		return ifcPipeSegmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPipeSegmentType_PredefinedType() {
		return (EAttribute) getIfcPipeSegmentType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPixelTexture() {
		if (ifcPixelTextureEClass == null) {
			ifcPixelTextureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(357);
		}
		return ifcPixelTextureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPixelTexture_Width() {
		return (EAttribute) getIfcPixelTexture().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPixelTexture_Height() {
		return (EAttribute) getIfcPixelTexture().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPixelTexture_ColourComponents() {
		return (EAttribute) getIfcPixelTexture().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPixelTexture_Pixel() {
		return (EAttribute) getIfcPixelTexture().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPlacement() {
		if (ifcPlacementEClass == null) {
			ifcPlacementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(358);
		}
		return ifcPlacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPlacement_Location() {
		return (EReference) getIfcPlacement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlacement_Dim() {
		return (EAttribute) getIfcPlacement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPlanarBox() {
		if (ifcPlanarBoxEClass == null) {
			ifcPlanarBoxEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(359);
		}
		return ifcPlanarBoxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPlanarBox_Placement() {
		return (EReference) getIfcPlanarBox().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPlanarExtent() {
		if (ifcPlanarExtentEClass == null) {
			ifcPlanarExtentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(360);
		}
		return ifcPlanarExtentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlanarExtent_SizeInX() {
		return (EAttribute) getIfcPlanarExtent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlanarExtent_SizeInXAsString() {
		return (EAttribute) getIfcPlanarExtent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlanarExtent_SizeInY() {
		return (EAttribute) getIfcPlanarExtent().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlanarExtent_SizeInYAsString() {
		return (EAttribute) getIfcPlanarExtent().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPlane() {
		if (ifcPlaneEClass == null) {
			ifcPlaneEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(361);
		}
		return ifcPlaneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPlate() {
		if (ifcPlateEClass == null) {
			ifcPlateEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(362);
		}
		return ifcPlateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPlateType() {
		if (ifcPlateTypeEClass == null) {
			ifcPlateTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(363);
		}
		return ifcPlateTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlateType_PredefinedType() {
		return (EAttribute) getIfcPlateType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPoint() {
		if (ifcPointEClass == null) {
			ifcPointEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(364);
		}
		return ifcPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPointOnCurve() {
		if (ifcPointOnCurveEClass == null) {
			ifcPointOnCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(365);
		}
		return ifcPointOnCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPointOnCurve_BasisCurve() {
		return (EReference) getIfcPointOnCurve().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPointOnCurve_PointParameter() {
		return (EAttribute) getIfcPointOnCurve().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPointOnCurve_PointParameterAsString() {
		return (EAttribute) getIfcPointOnCurve().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPointOnCurve_Dim() {
		return (EAttribute) getIfcPointOnCurve().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPointOnSurface() {
		if (ifcPointOnSurfaceEClass == null) {
			ifcPointOnSurfaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(366);
		}
		return ifcPointOnSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPointOnSurface_BasisSurface() {
		return (EReference) getIfcPointOnSurface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPointOnSurface_PointParameterU() {
		return (EAttribute) getIfcPointOnSurface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPointOnSurface_PointParameterUAsString() {
		return (EAttribute) getIfcPointOnSurface().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPointOnSurface_PointParameterV() {
		return (EAttribute) getIfcPointOnSurface().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPointOnSurface_PointParameterVAsString() {
		return (EAttribute) getIfcPointOnSurface().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPointOnSurface_Dim() {
		return (EAttribute) getIfcPointOnSurface().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPolyLoop() {
		if (ifcPolyLoopEClass == null) {
			ifcPolyLoopEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(367);
		}
		return ifcPolyLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPolyLoop_Polygon() {
		return (EReference) getIfcPolyLoop().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPolygonalBoundedHalfSpace() {
		if (ifcPolygonalBoundedHalfSpaceEClass == null) {
			ifcPolygonalBoundedHalfSpaceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(368);
		}
		return ifcPolygonalBoundedHalfSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPolygonalBoundedHalfSpace_Position() {
		return (EReference) getIfcPolygonalBoundedHalfSpace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPolygonalBoundedHalfSpace_PolygonalBoundary() {
		return (EReference) getIfcPolygonalBoundedHalfSpace().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPolyline() {
		if (ifcPolylineEClass == null) {
			ifcPolylineEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(369);
		}
		return ifcPolylineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPolyline_Points() {
		return (EReference) getIfcPolyline().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPort() {
		if (ifcPortEClass == null) {
			ifcPortEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(370);
		}
		return ifcPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPort_ContainedIn() {
		return (EReference) getIfcPort().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPort_ConnectedFrom() {
		return (EReference) getIfcPort().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPort_ConnectedTo() {
		return (EReference) getIfcPort().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPostalAddress() {
		if (ifcPostalAddressEClass == null) {
			ifcPostalAddressEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(371);
		}
		return ifcPostalAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPostalAddress_InternalLocation() {
		return (EAttribute) getIfcPostalAddress().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPostalAddress_AddressLines() {
		return (EAttribute) getIfcPostalAddress().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPostalAddress_PostalBox() {
		return (EAttribute) getIfcPostalAddress().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPostalAddress_Town() {
		return (EAttribute) getIfcPostalAddress().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPostalAddress_Region() {
		return (EAttribute) getIfcPostalAddress().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPostalAddress_PostalCode() {
		return (EAttribute) getIfcPostalAddress().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPostalAddress_Country() {
		return (EAttribute) getIfcPostalAddress().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPreDefinedColour() {
		if (ifcPreDefinedColourEClass == null) {
			ifcPreDefinedColourEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(372);
		}
		return ifcPreDefinedColourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPreDefinedCurveFont() {
		if (ifcPreDefinedCurveFontEClass == null) {
			ifcPreDefinedCurveFontEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(373);
		}
		return ifcPreDefinedCurveFontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPreDefinedDimensionSymbol() {
		if (ifcPreDefinedDimensionSymbolEClass == null) {
			ifcPreDefinedDimensionSymbolEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(374);
		}
		return ifcPreDefinedDimensionSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPreDefinedItem() {
		if (ifcPreDefinedItemEClass == null) {
			ifcPreDefinedItemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(375);
		}
		return ifcPreDefinedItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPreDefinedItem_Name() {
		return (EAttribute) getIfcPreDefinedItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPreDefinedPointMarkerSymbol() {
		if (ifcPreDefinedPointMarkerSymbolEClass == null) {
			ifcPreDefinedPointMarkerSymbolEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(376);
		}
		return ifcPreDefinedPointMarkerSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPreDefinedSymbol() {
		if (ifcPreDefinedSymbolEClass == null) {
			ifcPreDefinedSymbolEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(377);
		}
		return ifcPreDefinedSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPreDefinedTerminatorSymbol() {
		if (ifcPreDefinedTerminatorSymbolEClass == null) {
			ifcPreDefinedTerminatorSymbolEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(378);
		}
		return ifcPreDefinedTerminatorSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPreDefinedTextFont() {
		if (ifcPreDefinedTextFontEClass == null) {
			ifcPreDefinedTextFontEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(379);
		}
		return ifcPreDefinedTextFontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPresentationLayerAssignment() {
		if (ifcPresentationLayerAssignmentEClass == null) {
			ifcPresentationLayerAssignmentEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(380);
		}
		return ifcPresentationLayerAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPresentationLayerAssignment_Name() {
		return (EAttribute) getIfcPresentationLayerAssignment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPresentationLayerAssignment_Description() {
		return (EAttribute) getIfcPresentationLayerAssignment().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPresentationLayerAssignment_AssignedItems() {
		return (EReference) getIfcPresentationLayerAssignment().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPresentationLayerAssignment_Identifier() {
		return (EAttribute) getIfcPresentationLayerAssignment().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPresentationLayerWithStyle() {
		if (ifcPresentationLayerWithStyleEClass == null) {
			ifcPresentationLayerWithStyleEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(381);
		}
		return ifcPresentationLayerWithStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPresentationLayerWithStyle_LayerOn() {
		return (EAttribute) getIfcPresentationLayerWithStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPresentationLayerWithStyle_LayerFrozen() {
		return (EAttribute) getIfcPresentationLayerWithStyle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPresentationLayerWithStyle_LayerBlocked() {
		return (EAttribute) getIfcPresentationLayerWithStyle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPresentationLayerWithStyle_LayerStyles() {
		return (EReference) getIfcPresentationLayerWithStyle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPresentationStyle() {
		if (ifcPresentationStyleEClass == null) {
			ifcPresentationStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(382);
		}
		return ifcPresentationStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPresentationStyle_Name() {
		return (EAttribute) getIfcPresentationStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPresentationStyleAssignment() {
		if (ifcPresentationStyleAssignmentEClass == null) {
			ifcPresentationStyleAssignmentEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(383);
		}
		return ifcPresentationStyleAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPresentationStyleAssignment_Styles() {
		return (EReference) getIfcPresentationStyleAssignment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProcedure() {
		if (ifcProcedureEClass == null) {
			ifcProcedureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(384);
		}
		return ifcProcedureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProcedure_ProcedureID() {
		return (EAttribute) getIfcProcedure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProcedure_ProcedureType() {
		return (EAttribute) getIfcProcedure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProcedure_UserDefinedProcedureType() {
		return (EAttribute) getIfcProcedure().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProcess() {
		if (ifcProcessEClass == null) {
			ifcProcessEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(385);
		}
		return ifcProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProcess_OperatesOn() {
		return (EReference) getIfcProcess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProcess_IsSuccessorFrom() {
		return (EReference) getIfcProcess().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProcess_IsPredecessorTo() {
		return (EReference) getIfcProcess().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProduct() {
		if (ifcProductEClass == null) {
			ifcProductEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(386);
		}
		return ifcProductEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProduct_ObjectPlacement() {
		return (EReference) getIfcProduct().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProduct_Representation() {
		return (EReference) getIfcProduct().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProduct_ReferencedBy() {
		return (EReference) getIfcProduct().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProduct_Geometry() {
		return (EReference) getIfcProduct().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProductDefinitionShape() {
		if (ifcProductDefinitionShapeEClass == null) {
			ifcProductDefinitionShapeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(387);
		}
		return ifcProductDefinitionShapeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProductDefinitionShape_ShapeOfProduct() {
		return (EReference) getIfcProductDefinitionShape().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProductDefinitionShape_HasShapeAspects() {
		return (EReference) getIfcProductDefinitionShape().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProductRepresentation() {
		if (ifcProductRepresentationEClass == null) {
			ifcProductRepresentationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(388);
		}
		return ifcProductRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductRepresentation_Name() {
		return (EAttribute) getIfcProductRepresentation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductRepresentation_Description() {
		return (EAttribute) getIfcProductRepresentation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProductRepresentation_Representations() {
		return (EReference) getIfcProductRepresentation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProductsOfCombustionProperties() {
		if (ifcProductsOfCombustionPropertiesEClass == null) {
			ifcProductsOfCombustionPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(389);
		}
		return ifcProductsOfCombustionPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductsOfCombustionProperties_SpecificHeatCapacity() {
		return (EAttribute) getIfcProductsOfCombustionProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductsOfCombustionProperties_SpecificHeatCapacityAsString() {
		return (EAttribute) getIfcProductsOfCombustionProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductsOfCombustionProperties_N20Content() {
		return (EAttribute) getIfcProductsOfCombustionProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductsOfCombustionProperties_N20ContentAsString() {
		return (EAttribute) getIfcProductsOfCombustionProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductsOfCombustionProperties_COContent() {
		return (EAttribute) getIfcProductsOfCombustionProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductsOfCombustionProperties_COContentAsString() {
		return (EAttribute) getIfcProductsOfCombustionProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductsOfCombustionProperties_CO2Content() {
		return (EAttribute) getIfcProductsOfCombustionProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProductsOfCombustionProperties_CO2ContentAsString() {
		return (EAttribute) getIfcProductsOfCombustionProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProfileDef() {
		if (ifcProfileDefEClass == null) {
			ifcProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(390);
		}
		return ifcProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProfileDef_ProfileType() {
		return (EAttribute) getIfcProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProfileDef_ProfileName() {
		return (EAttribute) getIfcProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProfileProperties() {
		if (ifcProfilePropertiesEClass == null) {
			ifcProfilePropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(391);
		}
		return ifcProfilePropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProfileProperties_ProfileName() {
		return (EAttribute) getIfcProfileProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProfileProperties_ProfileDefinition() {
		return (EReference) getIfcProfileProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProject() {
		if (ifcProjectEClass == null) {
			ifcProjectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(392);
		}
		return ifcProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProject_LongName() {
		return (EAttribute) getIfcProject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProject_Phase() {
		return (EAttribute) getIfcProject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProject_RepresentationContexts() {
		return (EReference) getIfcProject().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProject_UnitsInContext() {
		return (EReference) getIfcProject().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProjectOrder() {
		if (ifcProjectOrderEClass == null) {
			ifcProjectOrderEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(393);
		}
		return ifcProjectOrderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProjectOrder_ID() {
		return (EAttribute) getIfcProjectOrder().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProjectOrder_PredefinedType() {
		return (EAttribute) getIfcProjectOrder().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProjectOrder_Status() {
		return (EAttribute) getIfcProjectOrder().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProjectOrderRecord() {
		if (ifcProjectOrderRecordEClass == null) {
			ifcProjectOrderRecordEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(394);
		}
		return ifcProjectOrderRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProjectOrderRecord_Records() {
		return (EReference) getIfcProjectOrderRecord().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProjectOrderRecord_PredefinedType() {
		return (EAttribute) getIfcProjectOrderRecord().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProjectionCurve() {
		if (ifcProjectionCurveEClass == null) {
			ifcProjectionCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(395);
		}
		return ifcProjectionCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProjectionElement() {
		if (ifcProjectionElementEClass == null) {
			ifcProjectionElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(396);
		}
		return ifcProjectionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProperty() {
		if (ifcPropertyEClass == null) {
			ifcPropertyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(397);
		}
		return ifcPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProperty_Name() {
		return (EAttribute) getIfcProperty().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProperty_Description() {
		return (EAttribute) getIfcProperty().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProperty_PropertyForDependance() {
		return (EReference) getIfcProperty().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProperty_PropertyDependsOn() {
		return (EReference) getIfcProperty().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcProperty_PartOfComplex() {
		return (EReference) getIfcProperty().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyBoundedValue() {
		if (ifcPropertyBoundedValueEClass == null) {
			ifcPropertyBoundedValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(398);
		}
		return ifcPropertyBoundedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyBoundedValue_UpperBoundValue() {
		return (EReference) getIfcPropertyBoundedValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyBoundedValue_LowerBoundValue() {
		return (EReference) getIfcPropertyBoundedValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyBoundedValue_Unit() {
		return (EReference) getIfcPropertyBoundedValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyConstraintRelationship() {
		if (ifcPropertyConstraintRelationshipEClass == null) {
			ifcPropertyConstraintRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(399);
		}
		return ifcPropertyConstraintRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyConstraintRelationship_RelatingConstraint() {
		return (EReference) getIfcPropertyConstraintRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyConstraintRelationship_RelatedProperties() {
		return (EReference) getIfcPropertyConstraintRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPropertyConstraintRelationship_Name() {
		return (EAttribute) getIfcPropertyConstraintRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPropertyConstraintRelationship_Description() {
		return (EAttribute) getIfcPropertyConstraintRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyDefinition() {
		if (ifcPropertyDefinitionEClass == null) {
			ifcPropertyDefinitionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(400);
		}
		return ifcPropertyDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyDefinition_HasAssociations() {
		return (EReference) getIfcPropertyDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyDependencyRelationship() {
		if (ifcPropertyDependencyRelationshipEClass == null) {
			ifcPropertyDependencyRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(401);
		}
		return ifcPropertyDependencyRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyDependencyRelationship_DependingProperty() {
		return (EReference) getIfcPropertyDependencyRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyDependencyRelationship_DependantProperty() {
		return (EReference) getIfcPropertyDependencyRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPropertyDependencyRelationship_Name() {
		return (EAttribute) getIfcPropertyDependencyRelationship().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPropertyDependencyRelationship_Description() {
		return (EAttribute) getIfcPropertyDependencyRelationship().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPropertyDependencyRelationship_Expression() {
		return (EAttribute) getIfcPropertyDependencyRelationship().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyEnumeratedValue() {
		if (ifcPropertyEnumeratedValueEClass == null) {
			ifcPropertyEnumeratedValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(402);
		}
		return ifcPropertyEnumeratedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyEnumeratedValue_EnumerationValues() {
		return (EReference) getIfcPropertyEnumeratedValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyEnumeratedValue_EnumerationReference() {
		return (EReference) getIfcPropertyEnumeratedValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyEnumeration() {
		if (ifcPropertyEnumerationEClass == null) {
			ifcPropertyEnumerationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(403);
		}
		return ifcPropertyEnumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPropertyEnumeration_Name() {
		return (EAttribute) getIfcPropertyEnumeration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyEnumeration_EnumerationValues() {
		return (EReference) getIfcPropertyEnumeration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyEnumeration_Unit() {
		return (EReference) getIfcPropertyEnumeration().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyListValue() {
		if (ifcPropertyListValueEClass == null) {
			ifcPropertyListValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(404);
		}
		return ifcPropertyListValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyListValue_ListValues() {
		return (EReference) getIfcPropertyListValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyListValue_Unit() {
		return (EReference) getIfcPropertyListValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyReferenceValue() {
		if (ifcPropertyReferenceValueEClass == null) {
			ifcPropertyReferenceValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(405);
		}
		return ifcPropertyReferenceValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPropertyReferenceValue_UsageName() {
		return (EAttribute) getIfcPropertyReferenceValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyReferenceValue_PropertyReference() {
		return (EReference) getIfcPropertyReferenceValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertySet() {
		if (ifcPropertySetEClass == null) {
			ifcPropertySetEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(406);
		}
		return ifcPropertySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertySet_HasProperties() {
		return (EReference) getIfcPropertySet().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertySetDefinition() {
		if (ifcPropertySetDefinitionEClass == null) {
			ifcPropertySetDefinitionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(407);
		}
		return ifcPropertySetDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertySetDefinition_PropertyDefinitionOf() {
		return (EReference) getIfcPropertySetDefinition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertySetDefinition_DefinesType() {
		return (EReference) getIfcPropertySetDefinition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertySingleValue() {
		if (ifcPropertySingleValueEClass == null) {
			ifcPropertySingleValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(408);
		}
		return ifcPropertySingleValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertySingleValue_NominalValue() {
		return (EReference) getIfcPropertySingleValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertySingleValue_Unit() {
		return (EReference) getIfcPropertySingleValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPropertyTableValue() {
		if (ifcPropertyTableValueEClass == null) {
			ifcPropertyTableValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(409);
		}
		return ifcPropertyTableValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyTableValue_DefiningValues() {
		return (EReference) getIfcPropertyTableValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyTableValue_DefinedValues() {
		return (EReference) getIfcPropertyTableValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPropertyTableValue_Expression() {
		return (EAttribute) getIfcPropertyTableValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyTableValue_DefiningUnit() {
		return (EReference) getIfcPropertyTableValue().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcPropertyTableValue_DefinedUnit() {
		return (EReference) getIfcPropertyTableValue().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProtectiveDeviceType() {
		if (ifcProtectiveDeviceTypeEClass == null) {
			ifcProtectiveDeviceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(410);
		}
		return ifcProtectiveDeviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProtectiveDeviceType_PredefinedType() {
		return (EAttribute) getIfcProtectiveDeviceType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcProxy() {
		if (ifcProxyEClass == null) {
			ifcProxyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(411);
		}
		return ifcProxyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProxy_ProxyType() {
		return (EAttribute) getIfcProxy().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcProxy_Tag() {
		return (EAttribute) getIfcProxy().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPumpType() {
		if (ifcPumpTypeEClass == null) {
			ifcPumpTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(412);
		}
		return ifcPumpTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPumpType_PredefinedType() {
		return (EAttribute) getIfcPumpType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcQuantityArea() {
		if (ifcQuantityAreaEClass == null) {
			ifcQuantityAreaEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(413);
		}
		return ifcQuantityAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityArea_AreaValue() {
		return (EAttribute) getIfcQuantityArea().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityArea_AreaValueAsString() {
		return (EAttribute) getIfcQuantityArea().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcQuantityCount() {
		if (ifcQuantityCountEClass == null) {
			ifcQuantityCountEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(414);
		}
		return ifcQuantityCountEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityCount_CountValue() {
		return (EAttribute) getIfcQuantityCount().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityCount_CountValueAsString() {
		return (EAttribute) getIfcQuantityCount().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcQuantityLength() {
		if (ifcQuantityLengthEClass == null) {
			ifcQuantityLengthEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(415);
		}
		return ifcQuantityLengthEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityLength_LengthValue() {
		return (EAttribute) getIfcQuantityLength().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityLength_LengthValueAsString() {
		return (EAttribute) getIfcQuantityLength().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcQuantityTime() {
		if (ifcQuantityTimeEClass == null) {
			ifcQuantityTimeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(416);
		}
		return ifcQuantityTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityTime_TimeValue() {
		return (EAttribute) getIfcQuantityTime().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityTime_TimeValueAsString() {
		return (EAttribute) getIfcQuantityTime().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcQuantityVolume() {
		if (ifcQuantityVolumeEClass == null) {
			ifcQuantityVolumeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(417);
		}
		return ifcQuantityVolumeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityVolume_VolumeValue() {
		return (EAttribute) getIfcQuantityVolume().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityVolume_VolumeValueAsString() {
		return (EAttribute) getIfcQuantityVolume().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcQuantityWeight() {
		if (ifcQuantityWeightEClass == null) {
			ifcQuantityWeightEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(418);
		}
		return ifcQuantityWeightEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityWeight_WeightValue() {
		return (EAttribute) getIfcQuantityWeight().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcQuantityWeight_WeightValueAsString() {
		return (EAttribute) getIfcQuantityWeight().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRadiusDimension() {
		if (ifcRadiusDimensionEClass == null) {
			ifcRadiusDimensionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(419);
		}
		return ifcRadiusDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRailing() {
		if (ifcRailingEClass == null) {
			ifcRailingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(420);
		}
		return ifcRailingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRailing_PredefinedType() {
		return (EAttribute) getIfcRailing().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRailingType() {
		if (ifcRailingTypeEClass == null) {
			ifcRailingTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(421);
		}
		return ifcRailingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRailingType_PredefinedType() {
		return (EAttribute) getIfcRailingType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRamp() {
		if (ifcRampEClass == null) {
			ifcRampEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(422);
		}
		return ifcRampEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRamp_ShapeType() {
		return (EAttribute) getIfcRamp().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRampFlight() {
		if (ifcRampFlightEClass == null) {
			ifcRampFlightEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(423);
		}
		return ifcRampFlightEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRampFlightType() {
		if (ifcRampFlightTypeEClass == null) {
			ifcRampFlightTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(424);
		}
		return ifcRampFlightTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRampFlightType_PredefinedType() {
		return (EAttribute) getIfcRampFlightType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRationalBezierCurve() {
		if (ifcRationalBezierCurveEClass == null) {
			ifcRationalBezierCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(425);
		}
		return ifcRationalBezierCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRationalBezierCurve_WeightsData() {
		return (EAttribute) getIfcRationalBezierCurve().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRationalBezierCurve_WeightsDataAsString() {
		return (EAttribute) getIfcRationalBezierCurve().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRectangleHollowProfileDef() {
		if (ifcRectangleHollowProfileDefEClass == null) {
			ifcRectangleHollowProfileDefEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(426);
		}
		return ifcRectangleHollowProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleHollowProfileDef_WallThickness() {
		return (EAttribute) getIfcRectangleHollowProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleHollowProfileDef_WallThicknessAsString() {
		return (EAttribute) getIfcRectangleHollowProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleHollowProfileDef_InnerFilletRadius() {
		return (EAttribute) getIfcRectangleHollowProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleHollowProfileDef_InnerFilletRadiusAsString() {
		return (EAttribute) getIfcRectangleHollowProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleHollowProfileDef_OuterFilletRadius() {
		return (EAttribute) getIfcRectangleHollowProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleHollowProfileDef_OuterFilletRadiusAsString() {
		return (EAttribute) getIfcRectangleHollowProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRectangleProfileDef() {
		if (ifcRectangleProfileDefEClass == null) {
			ifcRectangleProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(427);
		}
		return ifcRectangleProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleProfileDef_XDim() {
		return (EAttribute) getIfcRectangleProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleProfileDef_XDimAsString() {
		return (EAttribute) getIfcRectangleProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleProfileDef_YDim() {
		return (EAttribute) getIfcRectangleProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangleProfileDef_YDimAsString() {
		return (EAttribute) getIfcRectangleProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRectangularPyramid() {
		if (ifcRectangularPyramidEClass == null) {
			ifcRectangularPyramidEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(428);
		}
		return ifcRectangularPyramidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularPyramid_XLength() {
		return (EAttribute) getIfcRectangularPyramid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularPyramid_XLengthAsString() {
		return (EAttribute) getIfcRectangularPyramid().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularPyramid_YLength() {
		return (EAttribute) getIfcRectangularPyramid().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularPyramid_YLengthAsString() {
		return (EAttribute) getIfcRectangularPyramid().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularPyramid_Height() {
		return (EAttribute) getIfcRectangularPyramid().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularPyramid_HeightAsString() {
		return (EAttribute) getIfcRectangularPyramid().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRectangularTrimmedSurface() {
		if (ifcRectangularTrimmedSurfaceEClass == null) {
			ifcRectangularTrimmedSurfaceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(429);
		}
		return ifcRectangularTrimmedSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRectangularTrimmedSurface_BasisSurface() {
		return (EReference) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_U1() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_U1AsString() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_V1() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_V1AsString() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_U2() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_U2AsString() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_V2() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_V2AsString() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_Usense() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_Vsense() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRectangularTrimmedSurface_Dim() {
		return (EAttribute) getIfcRectangularTrimmedSurface().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcReferencesValueDocument() {
		if (ifcReferencesValueDocumentEClass == null) {
			ifcReferencesValueDocumentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(430);
		}
		return ifcReferencesValueDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcReferencesValueDocument_ReferencedDocument() {
		return (EReference) getIfcReferencesValueDocument().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcReferencesValueDocument_ReferencingValues() {
		return (EReference) getIfcReferencesValueDocument().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReferencesValueDocument_Name() {
		return (EAttribute) getIfcReferencesValueDocument().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReferencesValueDocument_Description() {
		return (EAttribute) getIfcReferencesValueDocument().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRegularTimeSeries() {
		if (ifcRegularTimeSeriesEClass == null) {
			ifcRegularTimeSeriesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(431);
		}
		return ifcRegularTimeSeriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRegularTimeSeries_TimeStep() {
		return (EAttribute) getIfcRegularTimeSeries().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRegularTimeSeries_TimeStepAsString() {
		return (EAttribute) getIfcRegularTimeSeries().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRegularTimeSeries_Values() {
		return (EReference) getIfcRegularTimeSeries().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcReinforcementBarProperties() {
		if (ifcReinforcementBarPropertiesEClass == null) {
			ifcReinforcementBarPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(432);
		}
		return ifcReinforcementBarPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_TotalCrossSectionArea() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_TotalCrossSectionAreaAsString() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_SteelGrade() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_BarSurface() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_EffectiveDepth() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_EffectiveDepthAsString() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_NominalBarDiameter() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_NominalBarDiameterAsString() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_BarCount() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementBarProperties_BarCountAsString() {
		return (EAttribute) getIfcReinforcementBarProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcReinforcementDefinitionProperties() {
		if (ifcReinforcementDefinitionPropertiesEClass == null) {
			ifcReinforcementDefinitionPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(433);
		}
		return ifcReinforcementDefinitionPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcementDefinitionProperties_DefinitionType() {
		return (EAttribute) getIfcReinforcementDefinitionProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcReinforcementDefinitionProperties_ReinforcementSectionDefinitions() {
		return (EReference) getIfcReinforcementDefinitionProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcReinforcingBar() {
		if (ifcReinforcingBarEClass == null) {
			ifcReinforcingBarEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(434);
		}
		return ifcReinforcingBarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingBar_NominalDiameter() {
		return (EAttribute) getIfcReinforcingBar().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingBar_NominalDiameterAsString() {
		return (EAttribute) getIfcReinforcingBar().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingBar_CrossSectionArea() {
		return (EAttribute) getIfcReinforcingBar().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingBar_CrossSectionAreaAsString() {
		return (EAttribute) getIfcReinforcingBar().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingBar_BarLength() {
		return (EAttribute) getIfcReinforcingBar().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingBar_BarLengthAsString() {
		return (EAttribute) getIfcReinforcingBar().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingBar_BarRole() {
		return (EAttribute) getIfcReinforcingBar().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingBar_BarSurface() {
		return (EAttribute) getIfcReinforcingBar().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcReinforcingElement() {
		if (ifcReinforcingElementEClass == null) {
			ifcReinforcingElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(435);
		}
		return ifcReinforcingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingElement_SteelGrade() {
		return (EAttribute) getIfcReinforcingElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcReinforcingMesh() {
		if (ifcReinforcingMeshEClass == null) {
			ifcReinforcingMeshEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(436);
		}
		return ifcReinforcingMeshEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_MeshLength() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_MeshLengthAsString() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_MeshWidth() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_MeshWidthAsString() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_LongitudinalBarNominalDiameter() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_LongitudinalBarNominalDiameterAsString() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_TransverseBarNominalDiameter() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_TransverseBarNominalDiameterAsString() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_LongitudinalBarCrossSectionArea() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_LongitudinalBarCrossSectionAreaAsString() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_TransverseBarCrossSectionArea() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_TransverseBarCrossSectionAreaAsString() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_LongitudinalBarSpacing() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_LongitudinalBarSpacingAsString() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_TransverseBarSpacing() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReinforcingMesh_TransverseBarSpacingAsString() {
		return (EAttribute) getIfcReinforcingMesh().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAggregates() {
		if (ifcRelAggregatesEClass == null) {
			ifcRelAggregatesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(437);
		}
		return ifcRelAggregatesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssigns() {
		if (ifcRelAssignsEClass == null) {
			ifcRelAssignsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(438);
		}
		return ifcRelAssignsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssigns_RelatedObjects() {
		return (EReference) getIfcRelAssigns().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelAssigns_RelatedObjectsType() {
		return (EAttribute) getIfcRelAssigns().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssignsTasks() {
		if (ifcRelAssignsTasksEClass == null) {
			ifcRelAssignsTasksEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(439);
		}
		return ifcRelAssignsTasksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsTasks_TimeForTask() {
		return (EReference) getIfcRelAssignsTasks().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssignsToActor() {
		if (ifcRelAssignsToActorEClass == null) {
			ifcRelAssignsToActorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(440);
		}
		return ifcRelAssignsToActorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsToActor_RelatingActor() {
		return (EReference) getIfcRelAssignsToActor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsToActor_ActingRole() {
		return (EReference) getIfcRelAssignsToActor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssignsToControl() {
		if (ifcRelAssignsToControlEClass == null) {
			ifcRelAssignsToControlEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(441);
		}
		return ifcRelAssignsToControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsToControl_RelatingControl() {
		return (EReference) getIfcRelAssignsToControl().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssignsToGroup() {
		if (ifcRelAssignsToGroupEClass == null) {
			ifcRelAssignsToGroupEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(442);
		}
		return ifcRelAssignsToGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsToGroup_RelatingGroup() {
		return (EReference) getIfcRelAssignsToGroup().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssignsToProcess() {
		if (ifcRelAssignsToProcessEClass == null) {
			ifcRelAssignsToProcessEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(443);
		}
		return ifcRelAssignsToProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsToProcess_RelatingProcess() {
		return (EReference) getIfcRelAssignsToProcess().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsToProcess_QuantityInProcess() {
		return (EReference) getIfcRelAssignsToProcess().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssignsToProduct() {
		if (ifcRelAssignsToProductEClass == null) {
			ifcRelAssignsToProductEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(444);
		}
		return ifcRelAssignsToProductEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsToProduct_RelatingProduct() {
		return (EReference) getIfcRelAssignsToProduct().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssignsToProjectOrder() {
		if (ifcRelAssignsToProjectOrderEClass == null) {
			ifcRelAssignsToProjectOrderEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(445);
		}
		return ifcRelAssignsToProjectOrderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssignsToResource() {
		if (ifcRelAssignsToResourceEClass == null) {
			ifcRelAssignsToResourceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(446);
		}
		return ifcRelAssignsToResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssignsToResource_RelatingResource() {
		return (EReference) getIfcRelAssignsToResource().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociates() {
		if (ifcRelAssociatesEClass == null) {
			ifcRelAssociatesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(447);
		}
		return ifcRelAssociatesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociates_RelatedObjects() {
		return (EReference) getIfcRelAssociates().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociatesAppliedValue() {
		if (ifcRelAssociatesAppliedValueEClass == null) {
			ifcRelAssociatesAppliedValueEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(448);
		}
		return ifcRelAssociatesAppliedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesAppliedValue_RelatingAppliedValue() {
		return (EReference) getIfcRelAssociatesAppliedValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociatesApproval() {
		if (ifcRelAssociatesApprovalEClass == null) {
			ifcRelAssociatesApprovalEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(449);
		}
		return ifcRelAssociatesApprovalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesApproval_RelatingApproval() {
		return (EReference) getIfcRelAssociatesApproval().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociatesClassification() {
		if (ifcRelAssociatesClassificationEClass == null) {
			ifcRelAssociatesClassificationEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(450);
		}
		return ifcRelAssociatesClassificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesClassification_RelatingClassification() {
		return (EReference) getIfcRelAssociatesClassification().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociatesConstraint() {
		if (ifcRelAssociatesConstraintEClass == null) {
			ifcRelAssociatesConstraintEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(451);
		}
		return ifcRelAssociatesConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelAssociatesConstraint_Intent() {
		return (EAttribute) getIfcRelAssociatesConstraint().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesConstraint_RelatingConstraint() {
		return (EReference) getIfcRelAssociatesConstraint().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociatesDocument() {
		if (ifcRelAssociatesDocumentEClass == null) {
			ifcRelAssociatesDocumentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(452);
		}
		return ifcRelAssociatesDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesDocument_RelatingDocument() {
		return (EReference) getIfcRelAssociatesDocument().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociatesLibrary() {
		if (ifcRelAssociatesLibraryEClass == null) {
			ifcRelAssociatesLibraryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(453);
		}
		return ifcRelAssociatesLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesLibrary_RelatingLibrary() {
		return (EReference) getIfcRelAssociatesLibrary().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociatesMaterial() {
		if (ifcRelAssociatesMaterialEClass == null) {
			ifcRelAssociatesMaterialEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(454);
		}
		return ifcRelAssociatesMaterialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesMaterial_RelatingMaterial() {
		return (EReference) getIfcRelAssociatesMaterial().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelAssociatesProfileProperties() {
		if (ifcRelAssociatesProfilePropertiesEClass == null) {
			ifcRelAssociatesProfilePropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(455);
		}
		return ifcRelAssociatesProfilePropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesProfileProperties_RelatingProfileProperties() {
		return (EReference) getIfcRelAssociatesProfileProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesProfileProperties_ProfileSectionLocation() {
		return (EReference) getIfcRelAssociatesProfileProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelAssociatesProfileProperties_ProfileOrientation() {
		return (EReference) getIfcRelAssociatesProfileProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnects() {
		if (ifcRelConnectsEClass == null) {
			ifcRelConnectsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(456);
		}
		return ifcRelConnectsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsElements() {
		if (ifcRelConnectsElementsEClass == null) {
			ifcRelConnectsElementsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(457);
		}
		return ifcRelConnectsElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsElements_ConnectionGeometry() {
		return (EReference) getIfcRelConnectsElements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsElements_RelatingElement() {
		return (EReference) getIfcRelConnectsElements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsElements_RelatedElement() {
		return (EReference) getIfcRelConnectsElements().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsPathElements() {
		if (ifcRelConnectsPathElementsEClass == null) {
			ifcRelConnectsPathElementsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(458);
		}
		return ifcRelConnectsPathElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelConnectsPathElements_RelatingPriorities() {
		return (EAttribute) getIfcRelConnectsPathElements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelConnectsPathElements_RelatedPriorities() {
		return (EAttribute) getIfcRelConnectsPathElements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelConnectsPathElements_RelatedConnectionType() {
		return (EAttribute) getIfcRelConnectsPathElements().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelConnectsPathElements_RelatingConnectionType() {
		return (EAttribute) getIfcRelConnectsPathElements().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsPortToElement() {
		if (ifcRelConnectsPortToElementEClass == null) {
			ifcRelConnectsPortToElementEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(459);
		}
		return ifcRelConnectsPortToElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsPortToElement_RelatingPort() {
		return (EReference) getIfcRelConnectsPortToElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsPortToElement_RelatedElement() {
		return (EReference) getIfcRelConnectsPortToElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsPorts() {
		if (ifcRelConnectsPortsEClass == null) {
			ifcRelConnectsPortsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(460);
		}
		return ifcRelConnectsPortsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsPorts_RelatingPort() {
		return (EReference) getIfcRelConnectsPorts().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsPorts_RelatedPort() {
		return (EReference) getIfcRelConnectsPorts().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsPorts_RealizingElement() {
		return (EReference) getIfcRelConnectsPorts().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsStructuralActivity() {
		if (ifcRelConnectsStructuralActivityEClass == null) {
			ifcRelConnectsStructuralActivityEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(461);
		}
		return ifcRelConnectsStructuralActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralActivity_RelatingElement() {
		return (EReference) getIfcRelConnectsStructuralActivity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralActivity_RelatedStructuralActivity() {
		return (EReference) getIfcRelConnectsStructuralActivity().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsStructuralElement() {
		if (ifcRelConnectsStructuralElementEClass == null) {
			ifcRelConnectsStructuralElementEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(462);
		}
		return ifcRelConnectsStructuralElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralElement_RelatingElement() {
		return (EReference) getIfcRelConnectsStructuralElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralElement_RelatedStructuralMember() {
		return (EReference) getIfcRelConnectsStructuralElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsStructuralMember() {
		if (ifcRelConnectsStructuralMemberEClass == null) {
			ifcRelConnectsStructuralMemberEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(463);
		}
		return ifcRelConnectsStructuralMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralMember_RelatingStructuralMember() {
		return (EReference) getIfcRelConnectsStructuralMember().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralMember_RelatedStructuralConnection() {
		return (EReference) getIfcRelConnectsStructuralMember().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralMember_AppliedCondition() {
		return (EReference) getIfcRelConnectsStructuralMember().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralMember_AdditionalConditions() {
		return (EReference) getIfcRelConnectsStructuralMember().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelConnectsStructuralMember_SupportedLength() {
		return (EAttribute) getIfcRelConnectsStructuralMember().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelConnectsStructuralMember_SupportedLengthAsString() {
		return (EAttribute) getIfcRelConnectsStructuralMember().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsStructuralMember_ConditionCoordinateSystem() {
		return (EReference) getIfcRelConnectsStructuralMember().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsWithEccentricity() {
		if (ifcRelConnectsWithEccentricityEClass == null) {
			ifcRelConnectsWithEccentricityEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(464);
		}
		return ifcRelConnectsWithEccentricityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsWithEccentricity_ConnectionConstraint() {
		return (EReference) getIfcRelConnectsWithEccentricity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelConnectsWithRealizingElements() {
		if (ifcRelConnectsWithRealizingElementsEClass == null) {
			ifcRelConnectsWithRealizingElementsEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(465);
		}
		return ifcRelConnectsWithRealizingElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelConnectsWithRealizingElements_RealizingElements() {
		return (EReference) getIfcRelConnectsWithRealizingElements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelConnectsWithRealizingElements_ConnectionType() {
		return (EAttribute) getIfcRelConnectsWithRealizingElements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelContainedInSpatialStructure() {
		if (ifcRelContainedInSpatialStructureEClass == null) {
			ifcRelContainedInSpatialStructureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(466);
		}
		return ifcRelContainedInSpatialStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelContainedInSpatialStructure_RelatedElements() {
		return (EReference) getIfcRelContainedInSpatialStructure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelContainedInSpatialStructure_RelatingStructure() {
		return (EReference) getIfcRelContainedInSpatialStructure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelCoversBldgElements() {
		if (ifcRelCoversBldgElementsEClass == null) {
			ifcRelCoversBldgElementsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(467);
		}
		return ifcRelCoversBldgElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelCoversBldgElements_RelatingBuildingElement() {
		return (EReference) getIfcRelCoversBldgElements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelCoversBldgElements_RelatedCoverings() {
		return (EReference) getIfcRelCoversBldgElements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelCoversSpaces() {
		if (ifcRelCoversSpacesEClass == null) {
			ifcRelCoversSpacesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(468);
		}
		return ifcRelCoversSpacesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelCoversSpaces_RelatedSpace() {
		return (EReference) getIfcRelCoversSpaces().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelCoversSpaces_RelatedCoverings() {
		return (EReference) getIfcRelCoversSpaces().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelDecomposes() {
		if (ifcRelDecomposesEClass == null) {
			ifcRelDecomposesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(469);
		}
		return ifcRelDecomposesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelDecomposes_RelatingObject() {
		return (EReference) getIfcRelDecomposes().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelDecomposes_RelatedObjects() {
		return (EReference) getIfcRelDecomposes().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelDefines() {
		if (ifcRelDefinesEClass == null) {
			ifcRelDefinesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(470);
		}
		return ifcRelDefinesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelDefines_RelatedObjects() {
		return (EReference) getIfcRelDefines().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelDefinesByProperties() {
		if (ifcRelDefinesByPropertiesEClass == null) {
			ifcRelDefinesByPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(471);
		}
		return ifcRelDefinesByPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelDefinesByProperties_RelatingPropertyDefinition() {
		return (EReference) getIfcRelDefinesByProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelDefinesByType() {
		if (ifcRelDefinesByTypeEClass == null) {
			ifcRelDefinesByTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(472);
		}
		return ifcRelDefinesByTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelDefinesByType_RelatingType() {
		return (EReference) getIfcRelDefinesByType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelFillsElement() {
		if (ifcRelFillsElementEClass == null) {
			ifcRelFillsElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(473);
		}
		return ifcRelFillsElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelFillsElement_RelatingOpeningElement() {
		return (EReference) getIfcRelFillsElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelFillsElement_RelatedBuildingElement() {
		return (EReference) getIfcRelFillsElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelFlowControlElements() {
		if (ifcRelFlowControlElementsEClass == null) {
			ifcRelFlowControlElementsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(474);
		}
		return ifcRelFlowControlElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelFlowControlElements_RelatedControlElements() {
		return (EReference) getIfcRelFlowControlElements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelFlowControlElements_RelatingFlowElement() {
		return (EReference) getIfcRelFlowControlElements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelInteractionRequirements() {
		if (ifcRelInteractionRequirementsEClass == null) {
			ifcRelInteractionRequirementsEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(475);
		}
		return ifcRelInteractionRequirementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelInteractionRequirements_DailyInteraction() {
		return (EAttribute) getIfcRelInteractionRequirements().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelInteractionRequirements_DailyInteractionAsString() {
		return (EAttribute) getIfcRelInteractionRequirements().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelInteractionRequirements_ImportanceRating() {
		return (EAttribute) getIfcRelInteractionRequirements().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelInteractionRequirements_ImportanceRatingAsString() {
		return (EAttribute) getIfcRelInteractionRequirements().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelInteractionRequirements_LocationOfInteraction() {
		return (EReference) getIfcRelInteractionRequirements().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelInteractionRequirements_RelatedSpaceProgram() {
		return (EReference) getIfcRelInteractionRequirements().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelInteractionRequirements_RelatingSpaceProgram() {
		return (EReference) getIfcRelInteractionRequirements().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelNests() {
		if (ifcRelNestsEClass == null) {
			ifcRelNestsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(476);
		}
		return ifcRelNestsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelOccupiesSpaces() {
		if (ifcRelOccupiesSpacesEClass == null) {
			ifcRelOccupiesSpacesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(477);
		}
		return ifcRelOccupiesSpacesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelOverridesProperties() {
		if (ifcRelOverridesPropertiesEClass == null) {
			ifcRelOverridesPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(478);
		}
		return ifcRelOverridesPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelOverridesProperties_OverridingProperties() {
		return (EReference) getIfcRelOverridesProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelProjectsElement() {
		if (ifcRelProjectsElementEClass == null) {
			ifcRelProjectsElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(479);
		}
		return ifcRelProjectsElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelProjectsElement_RelatingElement() {
		return (EReference) getIfcRelProjectsElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelProjectsElement_RelatedFeatureElement() {
		return (EReference) getIfcRelProjectsElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelReferencedInSpatialStructure() {
		if (ifcRelReferencedInSpatialStructureEClass == null) {
			ifcRelReferencedInSpatialStructureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(480);
		}
		return ifcRelReferencedInSpatialStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelReferencedInSpatialStructure_RelatedElements() {
		return (EReference) getIfcRelReferencedInSpatialStructure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelReferencedInSpatialStructure_RelatingStructure() {
		return (EReference) getIfcRelReferencedInSpatialStructure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelSchedulesCostItems() {
		if (ifcRelSchedulesCostItemsEClass == null) {
			ifcRelSchedulesCostItemsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(481);
		}
		return ifcRelSchedulesCostItemsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelSequence() {
		if (ifcRelSequenceEClass == null) {
			ifcRelSequenceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(482);
		}
		return ifcRelSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelSequence_RelatingProcess() {
		return (EReference) getIfcRelSequence().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelSequence_RelatedProcess() {
		return (EReference) getIfcRelSequence().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelSequence_TimeLag() {
		return (EAttribute) getIfcRelSequence().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelSequence_TimeLagAsString() {
		return (EAttribute) getIfcRelSequence().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelSequence_SequenceType() {
		return (EAttribute) getIfcRelSequence().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelServicesBuildings() {
		if (ifcRelServicesBuildingsEClass == null) {
			ifcRelServicesBuildingsEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(483);
		}
		return ifcRelServicesBuildingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelServicesBuildings_RelatingSystem() {
		return (EReference) getIfcRelServicesBuildings().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelServicesBuildings_RelatedBuildings() {
		return (EReference) getIfcRelServicesBuildings().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelSpaceBoundary() {
		if (ifcRelSpaceBoundaryEClass == null) {
			ifcRelSpaceBoundaryEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(484);
		}
		return ifcRelSpaceBoundaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelSpaceBoundary_RelatingSpace() {
		return (EReference) getIfcRelSpaceBoundary().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelSpaceBoundary_RelatedBuildingElement() {
		return (EReference) getIfcRelSpaceBoundary().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelSpaceBoundary_ConnectionGeometry() {
		return (EReference) getIfcRelSpaceBoundary().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelSpaceBoundary_PhysicalOrVirtualBoundary() {
		return (EAttribute) getIfcRelSpaceBoundary().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelSpaceBoundary_InternalOrExternalBoundary() {
		return (EAttribute) getIfcRelSpaceBoundary().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelVoidsElement() {
		if (ifcRelVoidsElementEClass == null) {
			ifcRelVoidsElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(485);
		}
		return ifcRelVoidsElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelVoidsElement_RelatingBuildingElement() {
		return (EReference) getIfcRelVoidsElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRelVoidsElement_RelatedOpeningElement() {
		return (EReference) getIfcRelVoidsElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelationship() {
		if (ifcRelationshipEClass == null) {
			ifcRelationshipEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(486);
		}
		return ifcRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRelaxation() {
		if (ifcRelaxationEClass == null) {
			ifcRelaxationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(487);
		}
		return ifcRelaxationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelaxation_RelaxationValue() {
		return (EAttribute) getIfcRelaxation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelaxation_RelaxationValueAsString() {
		return (EAttribute) getIfcRelaxation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelaxation_InitialStress() {
		return (EAttribute) getIfcRelaxation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRelaxation_InitialStressAsString() {
		return (EAttribute) getIfcRelaxation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRepresentation() {
		if (ifcRepresentationEClass == null) {
			ifcRepresentationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(488);
		}
		return ifcRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentation_ContextOfItems() {
		return (EReference) getIfcRepresentation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRepresentation_RepresentationIdentifier() {
		return (EAttribute) getIfcRepresentation().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRepresentation_RepresentationType() {
		return (EAttribute) getIfcRepresentation().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentation_Items() {
		return (EReference) getIfcRepresentation().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentation_RepresentationMap() {
		return (EReference) getIfcRepresentation().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentation_LayerAssignments() {
		return (EReference) getIfcRepresentation().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentation_OfProductRepresentation() {
		return (EReference) getIfcRepresentation().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRepresentationContext() {
		if (ifcRepresentationContextEClass == null) {
			ifcRepresentationContextEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(489);
		}
		return ifcRepresentationContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRepresentationContext_ContextIdentifier() {
		return (EAttribute) getIfcRepresentationContext().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRepresentationContext_ContextType() {
		return (EAttribute) getIfcRepresentationContext().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentationContext_RepresentationsInContext() {
		return (EReference) getIfcRepresentationContext().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRepresentationItem() {
		if (ifcRepresentationItemEClass == null) {
			ifcRepresentationItemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(490);
		}
		return ifcRepresentationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentationItem_LayerAssignments() {
		return (EReference) getIfcRepresentationItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentationItem_StyledByItem() {
		return (EReference) getIfcRepresentationItem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRepresentationMap() {
		if (ifcRepresentationMapEClass == null) {
			ifcRepresentationMapEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(491);
		}
		return ifcRepresentationMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentationMap_MappingOrigin() {
		return (EReference) getIfcRepresentationMap().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentationMap_MappedRepresentation() {
		return (EReference) getIfcRepresentationMap().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRepresentationMap_MapUsage() {
		return (EReference) getIfcRepresentationMap().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcResource() {
		if (ifcResourceEClass == null) {
			ifcResourceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(492);
		}
		return ifcResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcResource_ResourceOf() {
		return (EReference) getIfcResource().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRevolvedAreaSolid() {
		if (ifcRevolvedAreaSolidEClass == null) {
			ifcRevolvedAreaSolidEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(493);
		}
		return ifcRevolvedAreaSolidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRevolvedAreaSolid_Axis() {
		return (EReference) getIfcRevolvedAreaSolid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRevolvedAreaSolid_Angle() {
		return (EAttribute) getIfcRevolvedAreaSolid().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRevolvedAreaSolid_AngleAsString() {
		return (EAttribute) getIfcRevolvedAreaSolid().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRibPlateProfileProperties() {
		if (ifcRibPlateProfilePropertiesEClass == null) {
			ifcRibPlateProfilePropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(494);
		}
		return ifcRibPlateProfilePropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_Thickness() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_ThicknessAsString() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_RibHeight() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_RibHeightAsString() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_RibWidth() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_RibWidthAsString() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_RibSpacing() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_RibSpacingAsString() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRibPlateProfileProperties_Direction() {
		return (EAttribute) getIfcRibPlateProfileProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRightCircularCone() {
		if (ifcRightCircularConeEClass == null) {
			ifcRightCircularConeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(495);
		}
		return ifcRightCircularConeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRightCircularCone_Height() {
		return (EAttribute) getIfcRightCircularCone().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRightCircularCone_HeightAsString() {
		return (EAttribute) getIfcRightCircularCone().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRightCircularCone_BottomRadius() {
		return (EAttribute) getIfcRightCircularCone().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRightCircularCone_BottomRadiusAsString() {
		return (EAttribute) getIfcRightCircularCone().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRightCircularCylinder() {
		if (ifcRightCircularCylinderEClass == null) {
			ifcRightCircularCylinderEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(496);
		}
		return ifcRightCircularCylinderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRightCircularCylinder_Height() {
		return (EAttribute) getIfcRightCircularCylinder().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRightCircularCylinder_HeightAsString() {
		return (EAttribute) getIfcRightCircularCylinder().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRightCircularCylinder_Radius() {
		return (EAttribute) getIfcRightCircularCylinder().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRightCircularCylinder_RadiusAsString() {
		return (EAttribute) getIfcRightCircularCylinder().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRoof() {
		if (ifcRoofEClass == null) {
			ifcRoofEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(497);
		}
		return ifcRoofEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRoof_ShapeType() {
		return (EAttribute) getIfcRoof().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRoot() {
		if (ifcRootEClass == null) {
			ifcRootEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(498);
		}
		return ifcRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRoot_GlobalId() {
		return (EAttribute) getIfcRoot().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcRoot_OwnerHistory() {
		return (EReference) getIfcRoot().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRoot_Name() {
		return (EAttribute) getIfcRoot().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRoot_Description() {
		return (EAttribute) getIfcRoot().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRoundedEdgeFeature() {
		if (ifcRoundedEdgeFeatureEClass == null) {
			ifcRoundedEdgeFeatureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(499);
		}
		return ifcRoundedEdgeFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRoundedEdgeFeature_Radius() {
		return (EAttribute) getIfcRoundedEdgeFeature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRoundedEdgeFeature_RadiusAsString() {
		return (EAttribute) getIfcRoundedEdgeFeature().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRoundedRectangleProfileDef() {
		if (ifcRoundedRectangleProfileDefEClass == null) {
			ifcRoundedRectangleProfileDefEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(500);
		}
		return ifcRoundedRectangleProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRoundedRectangleProfileDef_RoundingRadius() {
		return (EAttribute) getIfcRoundedRectangleProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRoundedRectangleProfileDef_RoundingRadiusAsString() {
		return (EAttribute) getIfcRoundedRectangleProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSIUnit() {
		if (ifcSIUnitEClass == null) {
			ifcSIUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(501);
		}
		return ifcSIUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSIUnit_Prefix() {
		return (EAttribute) getIfcSIUnit().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSIUnit_Name() {
		return (EAttribute) getIfcSIUnit().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSanitaryTerminalType() {
		if (ifcSanitaryTerminalTypeEClass == null) {
			ifcSanitaryTerminalTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(502);
		}
		return ifcSanitaryTerminalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSanitaryTerminalType_PredefinedType() {
		return (EAttribute) getIfcSanitaryTerminalType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcScheduleTimeControl() {
		if (ifcScheduleTimeControlEClass == null) {
			ifcScheduleTimeControlEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(503);
		}
		return ifcScheduleTimeControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_ActualStart() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_EarlyStart() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_LateStart() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_ScheduleStart() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_ActualFinish() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_EarlyFinish() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_LateFinish() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_ScheduleFinish() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_ScheduleDuration() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_ScheduleDurationAsString() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_ActualDuration() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_ActualDurationAsString() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_RemainingTime() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_RemainingTimeAsString() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_FreeFloat() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_FreeFloatAsString() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_TotalFloat() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_TotalFloatAsString() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_IsCritical() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_StatusTime() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_StartFloat() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_StartFloatAsString() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_FinishFloat() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_FinishFloatAsString() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_Completion() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcScheduleTimeControl_CompletionAsString() {
		return (EAttribute) getIfcScheduleTimeControl().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcScheduleTimeControl_ScheduleTimeControlAssigned() {
		return (EReference) getIfcScheduleTimeControl().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSectionProperties() {
		if (ifcSectionPropertiesEClass == null) {
			ifcSectionPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(504);
		}
		return ifcSectionPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionProperties_SectionType() {
		return (EAttribute) getIfcSectionProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSectionProperties_StartProfile() {
		return (EReference) getIfcSectionProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSectionProperties_EndProfile() {
		return (EReference) getIfcSectionProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSectionReinforcementProperties() {
		if (ifcSectionReinforcementPropertiesEClass == null) {
			ifcSectionReinforcementPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(505);
		}
		return ifcSectionReinforcementPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionReinforcementProperties_LongitudinalStartPosition() {
		return (EAttribute) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionReinforcementProperties_LongitudinalStartPositionAsString() {
		return (EAttribute) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionReinforcementProperties_LongitudinalEndPosition() {
		return (EAttribute) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionReinforcementProperties_LongitudinalEndPositionAsString() {
		return (EAttribute) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionReinforcementProperties_TransversePosition() {
		return (EAttribute) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionReinforcementProperties_TransversePositionAsString() {
		return (EAttribute) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionReinforcementProperties_ReinforcementRole() {
		return (EAttribute) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSectionReinforcementProperties_SectionDefinition() {
		return (EReference) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSectionReinforcementProperties_CrossSectionReinforcementDefinitions() {
		return (EReference) getIfcSectionReinforcementProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSectionedSpine() {
		if (ifcSectionedSpineEClass == null) {
			ifcSectionedSpineEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(506);
		}
		return ifcSectionedSpineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSectionedSpine_SpineCurve() {
		return (EReference) getIfcSectionedSpine().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSectionedSpine_CrossSections() {
		return (EReference) getIfcSectionedSpine().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSectionedSpine_CrossSectionPositions() {
		return (EReference) getIfcSectionedSpine().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionedSpine_Dim() {
		return (EAttribute) getIfcSectionedSpine().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSensorType() {
		if (ifcSensorTypeEClass == null) {
			ifcSensorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(507);
		}
		return ifcSensorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSensorType_PredefinedType() {
		return (EAttribute) getIfcSensorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcServiceLife() {
		if (ifcServiceLifeEClass == null) {
			ifcServiceLifeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(508);
		}
		return ifcServiceLifeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcServiceLife_ServiceLifeType() {
		return (EAttribute) getIfcServiceLife().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcServiceLife_ServiceLifeDuration() {
		return (EAttribute) getIfcServiceLife().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcServiceLife_ServiceLifeDurationAsString() {
		return (EAttribute) getIfcServiceLife().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcServiceLifeFactor() {
		if (ifcServiceLifeFactorEClass == null) {
			ifcServiceLifeFactorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(509);
		}
		return ifcServiceLifeFactorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcServiceLifeFactor_PredefinedType() {
		return (EAttribute) getIfcServiceLifeFactor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcServiceLifeFactor_UpperValue() {
		return (EReference) getIfcServiceLifeFactor().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcServiceLifeFactor_MostUsedValue() {
		return (EReference) getIfcServiceLifeFactor().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcServiceLifeFactor_LowerValue() {
		return (EReference) getIfcServiceLifeFactor().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcShapeAspect() {
		if (ifcShapeAspectEClass == null) {
			ifcShapeAspectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(510);
		}
		return ifcShapeAspectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcShapeAspect_ShapeRepresentations() {
		return (EReference) getIfcShapeAspect().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcShapeAspect_Name() {
		return (EAttribute) getIfcShapeAspect().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcShapeAspect_Description() {
		return (EAttribute) getIfcShapeAspect().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcShapeAspect_ProductDefinitional() {
		return (EAttribute) getIfcShapeAspect().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcShapeAspect_PartOfProductDefinitionShape() {
		return (EReference) getIfcShapeAspect().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcShapeModel() {
		if (ifcShapeModelEClass == null) {
			ifcShapeModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(511);
		}
		return ifcShapeModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcShapeModel_OfShapeAspect() {
		return (EReference) getIfcShapeModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcShapeRepresentation() {
		if (ifcShapeRepresentationEClass == null) {
			ifcShapeRepresentationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(512);
		}
		return ifcShapeRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcShellBasedSurfaceModel() {
		if (ifcShellBasedSurfaceModelEClass == null) {
			ifcShellBasedSurfaceModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(513);
		}
		return ifcShellBasedSurfaceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcShellBasedSurfaceModel_SbsmBoundary() {
		return (EReference) getIfcShellBasedSurfaceModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcShellBasedSurfaceModel_Dim() {
		return (EAttribute) getIfcShellBasedSurfaceModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSimpleProperty() {
		if (ifcSimplePropertyEClass == null) {
			ifcSimplePropertyEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(514);
		}
		return ifcSimplePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSite() {
		if (ifcSiteEClass == null) {
			ifcSiteEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(515);
		}
		return ifcSiteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSite_RefLatitude() {
		return (EAttribute) getIfcSite().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSite_RefLongitude() {
		return (EAttribute) getIfcSite().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSite_RefElevation() {
		return (EAttribute) getIfcSite().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSite_RefElevationAsString() {
		return (EAttribute) getIfcSite().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSite_LandTitleNumber() {
		return (EAttribute) getIfcSite().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSite_SiteAddress() {
		return (EReference) getIfcSite().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSlab() {
		if (ifcSlabEClass == null) {
			ifcSlabEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(516);
		}
		return ifcSlabEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSlab_PredefinedType() {
		return (EAttribute) getIfcSlab().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSlabType() {
		if (ifcSlabTypeEClass == null) {
			ifcSlabTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(517);
		}
		return ifcSlabTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSlabType_PredefinedType() {
		return (EAttribute) getIfcSlabType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSlippageConnectionCondition() {
		if (ifcSlippageConnectionConditionEClass == null) {
			ifcSlippageConnectionConditionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(518);
		}
		return ifcSlippageConnectionConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSlippageConnectionCondition_SlippageX() {
		return (EAttribute) getIfcSlippageConnectionCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSlippageConnectionCondition_SlippageXAsString() {
		return (EAttribute) getIfcSlippageConnectionCondition().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSlippageConnectionCondition_SlippageY() {
		return (EAttribute) getIfcSlippageConnectionCondition().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSlippageConnectionCondition_SlippageYAsString() {
		return (EAttribute) getIfcSlippageConnectionCondition().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSlippageConnectionCondition_SlippageZ() {
		return (EAttribute) getIfcSlippageConnectionCondition().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSlippageConnectionCondition_SlippageZAsString() {
		return (EAttribute) getIfcSlippageConnectionCondition().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSolidModel() {
		if (ifcSolidModelEClass == null) {
			ifcSolidModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(519);
		}
		return ifcSolidModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSolidModel_Dim() {
		return (EAttribute) getIfcSolidModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSoundProperties() {
		if (ifcSoundPropertiesEClass == null) {
			ifcSoundPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(520);
		}
		return ifcSoundPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSoundProperties_IsAttenuating() {
		return (EAttribute) getIfcSoundProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSoundProperties_SoundScale() {
		return (EAttribute) getIfcSoundProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSoundProperties_SoundValues() {
		return (EReference) getIfcSoundProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSoundValue() {
		if (ifcSoundValueEClass == null) {
			ifcSoundValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(521);
		}
		return ifcSoundValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSoundValue_SoundLevelTimeSeries() {
		return (EReference) getIfcSoundValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSoundValue_Frequency() {
		return (EAttribute) getIfcSoundValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSoundValue_FrequencyAsString() {
		return (EAttribute) getIfcSoundValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSoundValue_SoundLevelSingleValue() {
		return (EReference) getIfcSoundValue().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpace() {
		if (ifcSpaceEClass == null) {
			ifcSpaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(522);
		}
		return ifcSpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpace_InteriorOrExteriorSpace() {
		return (EAttribute) getIfcSpace().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpace_ElevationWithFlooring() {
		return (EAttribute) getIfcSpace().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpace_ElevationWithFlooringAsString() {
		return (EAttribute) getIfcSpace().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpace_HasCoverings() {
		return (EReference) getIfcSpace().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpace_BoundedBy() {
		return (EReference) getIfcSpace().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpaceHeaterType() {
		if (ifcSpaceHeaterTypeEClass == null) {
			ifcSpaceHeaterTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(523);
		}
		return ifcSpaceHeaterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceHeaterType_PredefinedType() {
		return (EAttribute) getIfcSpaceHeaterType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpaceProgram() {
		if (ifcSpaceProgramEClass == null) {
			ifcSpaceProgramEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(524);
		}
		return ifcSpaceProgramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceProgram_SpaceProgramIdentifier() {
		return (EAttribute) getIfcSpaceProgram().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceProgram_MaxRequiredArea() {
		return (EAttribute) getIfcSpaceProgram().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceProgram_MaxRequiredAreaAsString() {
		return (EAttribute) getIfcSpaceProgram().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceProgram_MinRequiredArea() {
		return (EAttribute) getIfcSpaceProgram().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceProgram_MinRequiredAreaAsString() {
		return (EAttribute) getIfcSpaceProgram().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpaceProgram_RequestedLocation() {
		return (EReference) getIfcSpaceProgram().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceProgram_StandardRequiredArea() {
		return (EAttribute) getIfcSpaceProgram().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceProgram_StandardRequiredAreaAsString() {
		return (EAttribute) getIfcSpaceProgram().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpaceProgram_HasInteractionReqsFrom() {
		return (EReference) getIfcSpaceProgram().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpaceProgram_HasInteractionReqsTo() {
		return (EReference) getIfcSpaceProgram().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpaceThermalLoadProperties() {
		if (ifcSpaceThermalLoadPropertiesEClass == null) {
			ifcSpaceThermalLoadPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(525);
		}
		return ifcSpaceThermalLoadPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_ApplicableValueRatio() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_ApplicableValueRatioAsString() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_ThermalLoadSource() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_PropertySource() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_SourceDescription() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_MaximumValue() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_MaximumValueAsString() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_MinimumValue() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_MinimumValueAsString() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpaceThermalLoadProperties_ThermalLoadTimeSeriesValues() {
		return (EReference) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_UserDefinedThermalLoadSource() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_UserDefinedPropertySource() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceThermalLoadProperties_ThermalLoadType() {
		return (EAttribute) getIfcSpaceThermalLoadProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpaceType() {
		if (ifcSpaceTypeEClass == null) {
			ifcSpaceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(526);
		}
		return ifcSpaceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpaceType_PredefinedType() {
		return (EAttribute) getIfcSpaceType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpatialStructureElement() {
		if (ifcSpatialStructureElementEClass == null) {
			ifcSpatialStructureElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(527);
		}
		return ifcSpatialStructureElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpatialStructureElement_LongName() {
		return (EAttribute) getIfcSpatialStructureElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpatialStructureElement_CompositionType() {
		return (EAttribute) getIfcSpatialStructureElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpatialStructureElement_ReferencesElements() {
		return (EReference) getIfcSpatialStructureElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpatialStructureElement_ServicedBySystems() {
		return (EReference) getIfcSpatialStructureElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSpatialStructureElement_ContainsElements() {
		return (EReference) getIfcSpatialStructureElement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpatialStructureElementType() {
		if (ifcSpatialStructureElementTypeEClass == null) {
			ifcSpatialStructureElementTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(528);
		}
		return ifcSpatialStructureElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSphere() {
		if (ifcSphereEClass == null) {
			ifcSphereEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(529);
		}
		return ifcSphereEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSphere_Radius() {
		return (EAttribute) getIfcSphere().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSphere_RadiusAsString() {
		return (EAttribute) getIfcSphere().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStackTerminalType() {
		if (ifcStackTerminalTypeEClass == null) {
			ifcStackTerminalTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(530);
		}
		return ifcStackTerminalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStackTerminalType_PredefinedType() {
		return (EAttribute) getIfcStackTerminalType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStair() {
		if (ifcStairEClass == null) {
			ifcStairEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(531);
		}
		return ifcStairEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStair_ShapeType() {
		return (EAttribute) getIfcStair().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStairFlight() {
		if (ifcStairFlightEClass == null) {
			ifcStairFlightEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(532);
		}
		return ifcStairFlightEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStairFlight_NumberOfRiser() {
		return (EAttribute) getIfcStairFlight().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStairFlight_NumberOfTreads() {
		return (EAttribute) getIfcStairFlight().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStairFlight_RiserHeight() {
		return (EAttribute) getIfcStairFlight().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStairFlight_RiserHeightAsString() {
		return (EAttribute) getIfcStairFlight().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStairFlight_TreadLength() {
		return (EAttribute) getIfcStairFlight().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStairFlight_TreadLengthAsString() {
		return (EAttribute) getIfcStairFlight().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStairFlightType() {
		if (ifcStairFlightTypeEClass == null) {
			ifcStairFlightTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(533);
		}
		return ifcStairFlightTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStairFlightType_PredefinedType() {
		return (EAttribute) getIfcStairFlightType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralAction() {
		if (ifcStructuralActionEClass == null) {
			ifcStructuralActionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(534);
		}
		return ifcStructuralActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralAction_DestabilizingLoad() {
		return (EAttribute) getIfcStructuralAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralAction_CausedBy() {
		return (EReference) getIfcStructuralAction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralActivity() {
		if (ifcStructuralActivityEClass == null) {
			ifcStructuralActivityEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(535);
		}
		return ifcStructuralActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralActivity_AppliedLoad() {
		return (EReference) getIfcStructuralActivity().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralActivity_GlobalOrLocal() {
		return (EAttribute) getIfcStructuralActivity().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralActivity_AssignedToStructuralItem() {
		return (EReference) getIfcStructuralActivity().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralAnalysisModel() {
		if (ifcStructuralAnalysisModelEClass == null) {
			ifcStructuralAnalysisModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(536);
		}
		return ifcStructuralAnalysisModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralAnalysisModel_PredefinedType() {
		return (EAttribute) getIfcStructuralAnalysisModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralAnalysisModel_OrientationOf2DPlane() {
		return (EReference) getIfcStructuralAnalysisModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralAnalysisModel_LoadedBy() {
		return (EReference) getIfcStructuralAnalysisModel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralAnalysisModel_HasResults() {
		return (EReference) getIfcStructuralAnalysisModel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralConnection() {
		if (ifcStructuralConnectionEClass == null) {
			ifcStructuralConnectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(537);
		}
		return ifcStructuralConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralConnection_AppliedCondition() {
		return (EReference) getIfcStructuralConnection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralConnection_ConnectsStructuralMembers() {
		return (EReference) getIfcStructuralConnection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralConnectionCondition() {
		if (ifcStructuralConnectionConditionEClass == null) {
			ifcStructuralConnectionConditionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(538);
		}
		return ifcStructuralConnectionConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralConnectionCondition_Name() {
		return (EAttribute) getIfcStructuralConnectionCondition().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralCurveConnection() {
		if (ifcStructuralCurveConnectionEClass == null) {
			ifcStructuralCurveConnectionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(539);
		}
		return ifcStructuralCurveConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralCurveMember() {
		if (ifcStructuralCurveMemberEClass == null) {
			ifcStructuralCurveMemberEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(540);
		}
		return ifcStructuralCurveMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralCurveMember_PredefinedType() {
		return (EAttribute) getIfcStructuralCurveMember().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralCurveMemberVarying() {
		if (ifcStructuralCurveMemberVaryingEClass == null) {
			ifcStructuralCurveMemberVaryingEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(541);
		}
		return ifcStructuralCurveMemberVaryingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralItem() {
		if (ifcStructuralItemEClass == null) {
			ifcStructuralItemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(542);
		}
		return ifcStructuralItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralItem_AssignedStructuralActivity() {
		return (EReference) getIfcStructuralItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLinearAction() {
		if (ifcStructuralLinearActionEClass == null) {
			ifcStructuralLinearActionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(543);
		}
		return ifcStructuralLinearActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLinearAction_ProjectedOrTrue() {
		return (EAttribute) getIfcStructuralLinearAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLinearActionVarying() {
		if (ifcStructuralLinearActionVaryingEClass == null) {
			ifcStructuralLinearActionVaryingEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(544);
		}
		return ifcStructuralLinearActionVaryingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralLinearActionVarying_VaryingAppliedLoadLocation() {
		return (EReference) getIfcStructuralLinearActionVarying().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralLinearActionVarying_SubsequentAppliedLoads() {
		return (EReference) getIfcStructuralLinearActionVarying().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoad() {
		if (ifcStructuralLoadEClass == null) {
			ifcStructuralLoadEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(545);
		}
		return ifcStructuralLoadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoad_Name() {
		return (EAttribute) getIfcStructuralLoad().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadGroup() {
		if (ifcStructuralLoadGroupEClass == null) {
			ifcStructuralLoadGroupEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(546);
		}
		return ifcStructuralLoadGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadGroup_PredefinedType() {
		return (EAttribute) getIfcStructuralLoadGroup().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadGroup_ActionType() {
		return (EAttribute) getIfcStructuralLoadGroup().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadGroup_ActionSource() {
		return (EAttribute) getIfcStructuralLoadGroup().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadGroup_Coefficient() {
		return (EAttribute) getIfcStructuralLoadGroup().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadGroup_CoefficientAsString() {
		return (EAttribute) getIfcStructuralLoadGroup().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadGroup_Purpose() {
		return (EAttribute) getIfcStructuralLoadGroup().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralLoadGroup_SourceOfResultGroup() {
		return (EReference) getIfcStructuralLoadGroup().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralLoadGroup_LoadGroupFor() {
		return (EReference) getIfcStructuralLoadGroup().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadLinearForce() {
		if (ifcStructuralLoadLinearForceEClass == null) {
			ifcStructuralLoadLinearForceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(547);
		}
		return ifcStructuralLoadLinearForceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearForceX() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearForceXAsString() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearForceY() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearForceYAsString() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearForceZ() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearForceZAsString() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearMomentX() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearMomentXAsString() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearMomentY() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearMomentYAsString() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearMomentZ() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadLinearForce_LinearMomentZAsString() {
		return (EAttribute) getIfcStructuralLoadLinearForce().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadPlanarForce() {
		if (ifcStructuralLoadPlanarForceEClass == null) {
			ifcStructuralLoadPlanarForceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(548);
		}
		return ifcStructuralLoadPlanarForceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadPlanarForce_PlanarForceX() {
		return (EAttribute) getIfcStructuralLoadPlanarForce().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadPlanarForce_PlanarForceXAsString() {
		return (EAttribute) getIfcStructuralLoadPlanarForce().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadPlanarForce_PlanarForceY() {
		return (EAttribute) getIfcStructuralLoadPlanarForce().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadPlanarForce_PlanarForceYAsString() {
		return (EAttribute) getIfcStructuralLoadPlanarForce().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadPlanarForce_PlanarForceZ() {
		return (EAttribute) getIfcStructuralLoadPlanarForce().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadPlanarForce_PlanarForceZAsString() {
		return (EAttribute) getIfcStructuralLoadPlanarForce().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadSingleDisplacement() {
		if (ifcStructuralLoadSingleDisplacementEClass == null) {
			ifcStructuralLoadSingleDisplacementEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(549);
		}
		return ifcStructuralLoadSingleDisplacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_DisplacementX() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_DisplacementXAsString() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_DisplacementY() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_DisplacementYAsString() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_DisplacementZ() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_DisplacementZAsString() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacement().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadSingleDisplacementDistortion() {
		if (ifcStructuralLoadSingleDisplacementDistortionEClass == null) {
			ifcStructuralLoadSingleDisplacementDistortionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(550);
		}
		return ifcStructuralLoadSingleDisplacementDistortionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacementDistortion_Distortion() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacementDistortion().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString() {
		return (EAttribute) getIfcStructuralLoadSingleDisplacementDistortion().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadSingleForce() {
		if (ifcStructuralLoadSingleForceEClass == null) {
			ifcStructuralLoadSingleForceEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(551);
		}
		return ifcStructuralLoadSingleForceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_ForceX() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_ForceXAsString() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_ForceY() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_ForceYAsString() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_ForceZ() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_ForceZAsString() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_MomentX() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_MomentXAsString() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_MomentY() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_MomentYAsString() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_MomentZ() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForce_MomentZAsString() {
		return (EAttribute) getIfcStructuralLoadSingleForce().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadSingleForceWarping() {
		if (ifcStructuralLoadSingleForceWarpingEClass == null) {
			ifcStructuralLoadSingleForceWarpingEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(552);
		}
		return ifcStructuralLoadSingleForceWarpingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForceWarping_WarpingMoment() {
		return (EAttribute) getIfcStructuralLoadSingleForceWarping().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadSingleForceWarping_WarpingMomentAsString() {
		return (EAttribute) getIfcStructuralLoadSingleForceWarping().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadStatic() {
		if (ifcStructuralLoadStaticEClass == null) {
			ifcStructuralLoadStaticEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(553);
		}
		return ifcStructuralLoadStaticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralLoadTemperature() {
		if (ifcStructuralLoadTemperatureEClass == null) {
			ifcStructuralLoadTemperatureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(554);
		}
		return ifcStructuralLoadTemperatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadTemperature_DeltaT_Constant() {
		return (EAttribute) getIfcStructuralLoadTemperature().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadTemperature_DeltaT_ConstantAsString() {
		return (EAttribute) getIfcStructuralLoadTemperature().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadTemperature_DeltaT_Y() {
		return (EAttribute) getIfcStructuralLoadTemperature().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadTemperature_DeltaT_YAsString() {
		return (EAttribute) getIfcStructuralLoadTemperature().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadTemperature_DeltaT_Z() {
		return (EAttribute) getIfcStructuralLoadTemperature().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralLoadTemperature_DeltaT_ZAsString() {
		return (EAttribute) getIfcStructuralLoadTemperature().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralMember() {
		if (ifcStructuralMemberEClass == null) {
			ifcStructuralMemberEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(555);
		}
		return ifcStructuralMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralMember_ReferencesElement() {
		return (EReference) getIfcStructuralMember().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralMember_ConnectedBy() {
		return (EReference) getIfcStructuralMember().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralPlanarAction() {
		if (ifcStructuralPlanarActionEClass == null) {
			ifcStructuralPlanarActionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(556);
		}
		return ifcStructuralPlanarActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralPlanarAction_ProjectedOrTrue() {
		return (EAttribute) getIfcStructuralPlanarAction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralPlanarActionVarying() {
		if (ifcStructuralPlanarActionVaryingEClass == null) {
			ifcStructuralPlanarActionVaryingEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(557);
		}
		return ifcStructuralPlanarActionVaryingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralPlanarActionVarying_VaryingAppliedLoadLocation() {
		return (EReference) getIfcStructuralPlanarActionVarying().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralPlanarActionVarying_SubsequentAppliedLoads() {
		return (EReference) getIfcStructuralPlanarActionVarying().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralPointAction() {
		if (ifcStructuralPointActionEClass == null) {
			ifcStructuralPointActionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(558);
		}
		return ifcStructuralPointActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralPointConnection() {
		if (ifcStructuralPointConnectionEClass == null) {
			ifcStructuralPointConnectionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(559);
		}
		return ifcStructuralPointConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralPointReaction() {
		if (ifcStructuralPointReactionEClass == null) {
			ifcStructuralPointReactionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(560);
		}
		return ifcStructuralPointReactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralProfileProperties() {
		if (ifcStructuralProfilePropertiesEClass == null) {
			ifcStructuralProfilePropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(561);
		}
		return ifcStructuralProfilePropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_TorsionalConstantX() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_TorsionalConstantXAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MomentOfInertiaYZ() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MomentOfInertiaYZAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MomentOfInertiaY() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MomentOfInertiaYAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MomentOfInertiaZ() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MomentOfInertiaZAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_WarpingConstant() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_WarpingConstantAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_ShearCentreZ() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_ShearCentreZAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_ShearCentreY() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_ShearCentreYAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_ShearDeformationAreaZ() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_ShearDeformationAreaZAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_ShearDeformationAreaY() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_ShearDeformationAreaYAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MaximumSectionModulusY() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MaximumSectionModulusYAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MinimumSectionModulusY() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MinimumSectionModulusYAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MaximumSectionModulusZ() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MaximumSectionModulusZAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MinimumSectionModulusZ() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_MinimumSectionModulusZAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_TorsionalSectionModulus() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_TorsionalSectionModulusAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_CentreOfGravityInX() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_CentreOfGravityInXAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_CentreOfGravityInY() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralProfileProperties_CentreOfGravityInYAsString() {
		return (EAttribute) getIfcStructuralProfileProperties().getEStructuralFeatures().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralReaction() {
		if (ifcStructuralReactionEClass == null) {
			ifcStructuralReactionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(562);
		}
		return ifcStructuralReactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralReaction_Causes() {
		return (EReference) getIfcStructuralReaction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralResultGroup() {
		if (ifcStructuralResultGroupEClass == null) {
			ifcStructuralResultGroupEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(563);
		}
		return ifcStructuralResultGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralResultGroup_TheoryType() {
		return (EAttribute) getIfcStructuralResultGroup().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralResultGroup_ResultForLoadGroup() {
		return (EReference) getIfcStructuralResultGroup().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralResultGroup_IsLinear() {
		return (EAttribute) getIfcStructuralResultGroup().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralResultGroup_ResultGroupFor() {
		return (EReference) getIfcStructuralResultGroup().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralSteelProfileProperties() {
		if (ifcStructuralSteelProfilePropertiesEClass == null) {
			ifcStructuralSteelProfilePropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(564);
		}
		return ifcStructuralSteelProfilePropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSteelProfileProperties_ShearAreaZ() {
		return (EAttribute) getIfcStructuralSteelProfileProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSteelProfileProperties_ShearAreaZAsString() {
		return (EAttribute) getIfcStructuralSteelProfileProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSteelProfileProperties_ShearAreaY() {
		return (EAttribute) getIfcStructuralSteelProfileProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSteelProfileProperties_ShearAreaYAsString() {
		return (EAttribute) getIfcStructuralSteelProfileProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSteelProfileProperties_PlasticShapeFactorY() {
		return (EAttribute) getIfcStructuralSteelProfileProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSteelProfileProperties_PlasticShapeFactorYAsString() {
		return (EAttribute) getIfcStructuralSteelProfileProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSteelProfileProperties_PlasticShapeFactorZ() {
		return (EAttribute) getIfcStructuralSteelProfileProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSteelProfileProperties_PlasticShapeFactorZAsString() {
		return (EAttribute) getIfcStructuralSteelProfileProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralSurfaceConnection() {
		if (ifcStructuralSurfaceConnectionEClass == null) {
			ifcStructuralSurfaceConnectionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(565);
		}
		return ifcStructuralSurfaceConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralSurfaceMember() {
		if (ifcStructuralSurfaceMemberEClass == null) {
			ifcStructuralSurfaceMemberEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(566);
		}
		return ifcStructuralSurfaceMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSurfaceMember_PredefinedType() {
		return (EAttribute) getIfcStructuralSurfaceMember().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSurfaceMember_Thickness() {
		return (EAttribute) getIfcStructuralSurfaceMember().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSurfaceMember_ThicknessAsString() {
		return (EAttribute) getIfcStructuralSurfaceMember().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralSurfaceMemberVarying() {
		if (ifcStructuralSurfaceMemberVaryingEClass == null) {
			ifcStructuralSurfaceMemberVaryingEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(567);
		}
		return ifcStructuralSurfaceMemberVaryingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSurfaceMemberVarying_SubsequentThickness() {
		return (EAttribute) getIfcStructuralSurfaceMemberVarying().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSurfaceMemberVarying_SubsequentThicknessAsString() {
		return (EAttribute) getIfcStructuralSurfaceMemberVarying().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStructuralSurfaceMemberVarying_VaryingThicknessLocation() {
		return (EReference) getIfcStructuralSurfaceMemberVarying().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSurfaceMemberVarying_VaryingThickness() {
		return (EAttribute) getIfcStructuralSurfaceMemberVarying().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStructuralSurfaceMemberVarying_VaryingThicknessAsString() {
		return (EAttribute) getIfcStructuralSurfaceMemberVarying().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuredDimensionCallout() {
		if (ifcStructuredDimensionCalloutEClass == null) {
			ifcStructuredDimensionCalloutEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(568);
		}
		return ifcStructuredDimensionCalloutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStyleModel() {
		if (ifcStyleModelEClass == null) {
			ifcStyleModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(569);
		}
		return ifcStyleModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStyledItem() {
		if (ifcStyledItemEClass == null) {
			ifcStyledItemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(570);
		}
		return ifcStyledItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStyledItem_Item() {
		return (EReference) getIfcStyledItem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcStyledItem_Styles() {
		return (EReference) getIfcStyledItem().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcStyledItem_Name() {
		return (EAttribute) getIfcStyledItem().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStyledRepresentation() {
		if (ifcStyledRepresentationEClass == null) {
			ifcStyledRepresentationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(571);
		}
		return ifcStyledRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSubContractResource() {
		if (ifcSubContractResourceEClass == null) {
			ifcSubContractResourceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(572);
		}
		return ifcSubContractResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSubContractResource_SubContractor() {
		return (EReference) getIfcSubContractResource().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSubContractResource_JobDescription() {
		return (EAttribute) getIfcSubContractResource().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSubedge() {
		if (ifcSubedgeEClass == null) {
			ifcSubedgeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(573);
		}
		return ifcSubedgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSubedge_ParentEdge() {
		return (EReference) getIfcSubedge().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurface() {
		if (ifcSurfaceEClass == null) {
			ifcSurfaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(574);
		}
		return ifcSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceCurveSweptAreaSolid() {
		if (ifcSurfaceCurveSweptAreaSolidEClass == null) {
			ifcSurfaceCurveSweptAreaSolidEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(575);
		}
		return ifcSurfaceCurveSweptAreaSolidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceCurveSweptAreaSolid_Directrix() {
		return (EReference) getIfcSurfaceCurveSweptAreaSolid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceCurveSweptAreaSolid_StartParam() {
		return (EAttribute) getIfcSurfaceCurveSweptAreaSolid().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceCurveSweptAreaSolid_StartParamAsString() {
		return (EAttribute) getIfcSurfaceCurveSweptAreaSolid().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceCurveSweptAreaSolid_EndParam() {
		return (EAttribute) getIfcSurfaceCurveSweptAreaSolid().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceCurveSweptAreaSolid_EndParamAsString() {
		return (EAttribute) getIfcSurfaceCurveSweptAreaSolid().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceCurveSweptAreaSolid_ReferenceSurface() {
		return (EReference) getIfcSurfaceCurveSweptAreaSolid().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceOfLinearExtrusion() {
		if (ifcSurfaceOfLinearExtrusionEClass == null) {
			ifcSurfaceOfLinearExtrusionEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(576);
		}
		return ifcSurfaceOfLinearExtrusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceOfLinearExtrusion_ExtrudedDirection() {
		return (EReference) getIfcSurfaceOfLinearExtrusion().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceOfLinearExtrusion_Depth() {
		return (EAttribute) getIfcSurfaceOfLinearExtrusion().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceOfLinearExtrusion_DepthAsString() {
		return (EAttribute) getIfcSurfaceOfLinearExtrusion().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceOfRevolution() {
		if (ifcSurfaceOfRevolutionEClass == null) {
			ifcSurfaceOfRevolutionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(577);
		}
		return ifcSurfaceOfRevolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceOfRevolution_AxisPosition() {
		return (EReference) getIfcSurfaceOfRevolution().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceStyle() {
		if (ifcSurfaceStyleEClass == null) {
			ifcSurfaceStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(578);
		}
		return ifcSurfaceStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceStyle_Side() {
		return (EAttribute) getIfcSurfaceStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyle_Styles() {
		return (EReference) getIfcSurfaceStyle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceStyleLighting() {
		if (ifcSurfaceStyleLightingEClass == null) {
			ifcSurfaceStyleLightingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(579);
		}
		return ifcSurfaceStyleLightingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleLighting_DiffuseTransmissionColour() {
		return (EReference) getIfcSurfaceStyleLighting().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleLighting_DiffuseReflectionColour() {
		return (EReference) getIfcSurfaceStyleLighting().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleLighting_TransmissionColour() {
		return (EReference) getIfcSurfaceStyleLighting().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleLighting_ReflectanceColour() {
		return (EReference) getIfcSurfaceStyleLighting().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceStyleRefraction() {
		if (ifcSurfaceStyleRefractionEClass == null) {
			ifcSurfaceStyleRefractionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(580);
		}
		return ifcSurfaceStyleRefractionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceStyleRefraction_RefractionIndex() {
		return (EAttribute) getIfcSurfaceStyleRefraction().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceStyleRefraction_RefractionIndexAsString() {
		return (EAttribute) getIfcSurfaceStyleRefraction().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceStyleRefraction_DispersionFactor() {
		return (EAttribute) getIfcSurfaceStyleRefraction().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceStyleRefraction_DispersionFactorAsString() {
		return (EAttribute) getIfcSurfaceStyleRefraction().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceStyleRendering() {
		if (ifcSurfaceStyleRenderingEClass == null) {
			ifcSurfaceStyleRenderingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(581);
		}
		return ifcSurfaceStyleRenderingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceStyleRendering_Transparency() {
		return (EAttribute) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceStyleRendering_TransparencyAsString() {
		return (EAttribute) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleRendering_DiffuseColour() {
		return (EReference) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleRendering_TransmissionColour() {
		return (EReference) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleRendering_DiffuseTransmissionColour() {
		return (EReference) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleRendering_ReflectionColour() {
		return (EReference) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleRendering_SpecularColour() {
		return (EReference) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleRendering_SpecularHighlight() {
		return (EReference) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceStyleRendering_ReflectanceMethod() {
		return (EAttribute) getIfcSurfaceStyleRendering().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceStyleShading() {
		if (ifcSurfaceStyleShadingEClass == null) {
			ifcSurfaceStyleShadingEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(582);
		}
		return ifcSurfaceStyleShadingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleShading_SurfaceColour() {
		return (EReference) getIfcSurfaceStyleShading().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceStyleWithTextures() {
		if (ifcSurfaceStyleWithTexturesEClass == null) {
			ifcSurfaceStyleWithTexturesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(583);
		}
		return ifcSurfaceStyleWithTexturesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceStyleWithTextures_Textures() {
		return (EReference) getIfcSurfaceStyleWithTextures().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceTexture() {
		if (ifcSurfaceTextureEClass == null) {
			ifcSurfaceTextureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(584);
		}
		return ifcSurfaceTextureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceTexture_RepeatS() {
		return (EAttribute) getIfcSurfaceTexture().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceTexture_RepeatT() {
		return (EAttribute) getIfcSurfaceTexture().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSurfaceTexture_TextureType() {
		return (EAttribute) getIfcSurfaceTexture().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSurfaceTexture_TextureTransform() {
		return (EReference) getIfcSurfaceTexture().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSweptAreaSolid() {
		if (ifcSweptAreaSolidEClass == null) {
			ifcSweptAreaSolidEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(585);
		}
		return ifcSweptAreaSolidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSweptAreaSolid_SweptArea() {
		return (EReference) getIfcSweptAreaSolid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSweptAreaSolid_Position() {
		return (EReference) getIfcSweptAreaSolid().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSweptDiskSolid() {
		if (ifcSweptDiskSolidEClass == null) {
			ifcSweptDiskSolidEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(586);
		}
		return ifcSweptDiskSolidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSweptDiskSolid_Directrix() {
		return (EReference) getIfcSweptDiskSolid().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptDiskSolid_Radius() {
		return (EAttribute) getIfcSweptDiskSolid().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptDiskSolid_RadiusAsString() {
		return (EAttribute) getIfcSweptDiskSolid().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptDiskSolid_InnerRadius() {
		return (EAttribute) getIfcSweptDiskSolid().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptDiskSolid_InnerRadiusAsString() {
		return (EAttribute) getIfcSweptDiskSolid().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptDiskSolid_StartParam() {
		return (EAttribute) getIfcSweptDiskSolid().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptDiskSolid_StartParamAsString() {
		return (EAttribute) getIfcSweptDiskSolid().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptDiskSolid_EndParam() {
		return (EAttribute) getIfcSweptDiskSolid().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptDiskSolid_EndParamAsString() {
		return (EAttribute) getIfcSweptDiskSolid().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSweptSurface() {
		if (ifcSweptSurfaceEClass == null) {
			ifcSweptSurfaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(587);
		}
		return ifcSweptSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSweptSurface_SweptCurve() {
		return (EReference) getIfcSweptSurface().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSweptSurface_Position() {
		return (EReference) getIfcSweptSurface().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSweptSurface_Dim() {
		return (EAttribute) getIfcSweptSurface().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSwitchingDeviceType() {
		if (ifcSwitchingDeviceTypeEClass == null) {
			ifcSwitchingDeviceTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(588);
		}
		return ifcSwitchingDeviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSwitchingDeviceType_PredefinedType() {
		return (EAttribute) getIfcSwitchingDeviceType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSymbolStyle() {
		if (ifcSymbolStyleEClass == null) {
			ifcSymbolStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(589);
		}
		return ifcSymbolStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSymbolStyle_StyleOfSymbol() {
		return (EReference) getIfcSymbolStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSystem() {
		if (ifcSystemEClass == null) {
			ifcSystemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(590);
		}
		return ifcSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcSystem_ServicesBuildings() {
		return (EReference) getIfcSystem().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSystemFurnitureElementType() {
		if (ifcSystemFurnitureElementTypeEClass == null) {
			ifcSystemFurnitureElementTypeEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(591);
		}
		return ifcSystemFurnitureElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTShapeProfileDef() {
		if (ifcTShapeProfileDefEClass == null) {
			ifcTShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(592);
		}
		return ifcTShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_Depth() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_DepthAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FlangeWidth() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FlangeWidthAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_WebThickness() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_WebThicknessAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FlangeThickness() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FlangeThicknessAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FilletRadius() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FilletRadiusAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FlangeEdgeRadius() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FlangeEdgeRadiusAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_WebEdgeRadius() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_WebEdgeRadiusAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_WebSlope() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_WebSlopeAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FlangeSlope() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_FlangeSlopeAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_CentreOfGravityInY() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTShapeProfileDef_CentreOfGravityInYAsString() {
		return (EAttribute) getIfcTShapeProfileDef().getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTable() {
		if (ifcTableEClass == null) {
			ifcTableEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(593);
		}
		return ifcTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTable_Name() {
		return (EAttribute) getIfcTable().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTable_Rows() {
		return (EReference) getIfcTable().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTableRow() {
		if (ifcTableRowEClass == null) {
			ifcTableRowEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(594);
		}
		return ifcTableRowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTableRow_RowCells() {
		return (EReference) getIfcTableRow().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTableRow_IsHeading() {
		return (EAttribute) getIfcTableRow().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTableRow_OfTable() {
		return (EReference) getIfcTableRow().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTankType() {
		if (ifcTankTypeEClass == null) {
			ifcTankTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(595);
		}
		return ifcTankTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTankType_PredefinedType() {
		return (EAttribute) getIfcTankType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTask() {
		if (ifcTaskEClass == null) {
			ifcTaskEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(596);
		}
		return ifcTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTask_TaskId() {
		return (EAttribute) getIfcTask().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTask_Status() {
		return (EAttribute) getIfcTask().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTask_WorkMethod() {
		return (EAttribute) getIfcTask().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTask_IsMilestone() {
		return (EAttribute) getIfcTask().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTask_Priority() {
		return (EAttribute) getIfcTask().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTelecomAddress() {
		if (ifcTelecomAddressEClass == null) {
			ifcTelecomAddressEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(597);
		}
		return ifcTelecomAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTelecomAddress_TelephoneNumbers() {
		return (EAttribute) getIfcTelecomAddress().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTelecomAddress_FacsimileNumbers() {
		return (EAttribute) getIfcTelecomAddress().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTelecomAddress_PagerNumber() {
		return (EAttribute) getIfcTelecomAddress().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTelecomAddress_ElectronicMailAddresses() {
		return (EAttribute) getIfcTelecomAddress().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTelecomAddress_WWWHomePageURL() {
		return (EAttribute) getIfcTelecomAddress().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTendon() {
		if (ifcTendonEClass == null) {
			ifcTendonEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(598);
		}
		return ifcTendonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_PredefinedType() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_NominalDiameter() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_NominalDiameterAsString() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_CrossSectionArea() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_CrossSectionAreaAsString() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_TensionForce() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_TensionForceAsString() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_PreStress() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_PreStressAsString() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_FrictionCoefficient() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_FrictionCoefficientAsString() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_AnchorageSlip() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_AnchorageSlipAsString() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_MinCurvatureRadius() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTendon_MinCurvatureRadiusAsString() {
		return (EAttribute) getIfcTendon().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTendonAnchor() {
		if (ifcTendonAnchorEClass == null) {
			ifcTendonAnchorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(599);
		}
		return ifcTendonAnchorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTerminatorSymbol() {
		if (ifcTerminatorSymbolEClass == null) {
			ifcTerminatorSymbolEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(600);
		}
		return ifcTerminatorSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTerminatorSymbol_AnnotatedCurve() {
		return (EReference) getIfcTerminatorSymbol().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextLiteral() {
		if (ifcTextLiteralEClass == null) {
			ifcTextLiteralEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(601);
		}
		return ifcTextLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextLiteral_Literal() {
		return (EAttribute) getIfcTextLiteral().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextLiteral_Placement() {
		return (EReference) getIfcTextLiteral().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextLiteral_Path() {
		return (EAttribute) getIfcTextLiteral().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextLiteralWithExtent() {
		if (ifcTextLiteralWithExtentEClass == null) {
			ifcTextLiteralWithExtentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(602);
		}
		return ifcTextLiteralWithExtentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextLiteralWithExtent_Extent() {
		return (EReference) getIfcTextLiteralWithExtent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextLiteralWithExtent_BoxAlignment() {
		return (EAttribute) getIfcTextLiteralWithExtent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextStyle() {
		if (ifcTextStyleEClass == null) {
			ifcTextStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(603);
		}
		return ifcTextStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyle_TextCharacterAppearance() {
		return (EReference) getIfcTextStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyle_TextStyle() {
		return (EReference) getIfcTextStyle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyle_TextFontStyle() {
		return (EReference) getIfcTextStyle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextStyleFontModel() {
		if (ifcTextStyleFontModelEClass == null) {
			ifcTextStyleFontModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(604);
		}
		return ifcTextStyleFontModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleFontModel_FontFamily() {
		return (EAttribute) getIfcTextStyleFontModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleFontModel_FontStyle() {
		return (EAttribute) getIfcTextStyleFontModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleFontModel_FontVariant() {
		return (EAttribute) getIfcTextStyleFontModel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleFontModel_FontWeight() {
		return (EAttribute) getIfcTextStyleFontModel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyleFontModel_FontSize() {
		return (EReference) getIfcTextStyleFontModel().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextStyleForDefinedFont() {
		if (ifcTextStyleForDefinedFontEClass == null) {
			ifcTextStyleForDefinedFontEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(605);
		}
		return ifcTextStyleForDefinedFontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyleForDefinedFont_Colour() {
		return (EReference) getIfcTextStyleForDefinedFont().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyleForDefinedFont_BackgroundColour() {
		return (EReference) getIfcTextStyleForDefinedFont().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextStyleTextModel() {
		if (ifcTextStyleTextModelEClass == null) {
			ifcTextStyleTextModelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(606);
		}
		return ifcTextStyleTextModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyleTextModel_TextIndent() {
		return (EReference) getIfcTextStyleTextModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleTextModel_TextAlign() {
		return (EAttribute) getIfcTextStyleTextModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleTextModel_TextDecoration() {
		return (EAttribute) getIfcTextStyleTextModel().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyleTextModel_LetterSpacing() {
		return (EReference) getIfcTextStyleTextModel().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyleTextModel_WordSpacing() {
		return (EReference) getIfcTextStyleTextModel().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleTextModel_TextTransform() {
		return (EAttribute) getIfcTextStyleTextModel().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyleTextModel_LineHeight() {
		return (EReference) getIfcTextStyleTextModel().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextStyleWithBoxCharacteristics() {
		if (ifcTextStyleWithBoxCharacteristicsEClass == null) {
			ifcTextStyleWithBoxCharacteristicsEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(607);
		}
		return ifcTextStyleWithBoxCharacteristicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleWithBoxCharacteristics_BoxHeight() {
		return (EAttribute) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleWithBoxCharacteristics_BoxHeightAsString() {
		return (EAttribute) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleWithBoxCharacteristics_BoxWidth() {
		return (EAttribute) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleWithBoxCharacteristics_BoxWidthAsString() {
		return (EAttribute) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleWithBoxCharacteristics_BoxSlantAngle() {
		return (EAttribute) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleWithBoxCharacteristics_BoxSlantAngleAsString() {
		return (EAttribute) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleWithBoxCharacteristics_BoxRotateAngle() {
		return (EAttribute) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextStyleWithBoxCharacteristics_BoxRotateAngleAsString() {
		return (EAttribute) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextStyleWithBoxCharacteristics_CharacterSpacing() {
		return (EReference) getIfcTextStyleWithBoxCharacteristics().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextureCoordinate() {
		if (ifcTextureCoordinateEClass == null) {
			ifcTextureCoordinateEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(608);
		}
		return ifcTextureCoordinateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextureCoordinate_AnnotatedSurface() {
		return (EReference) getIfcTextureCoordinate().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextureCoordinateGenerator() {
		if (ifcTextureCoordinateGeneratorEClass == null) {
			ifcTextureCoordinateGeneratorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(609);
		}
		return ifcTextureCoordinateGeneratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextureCoordinateGenerator_Mode() {
		return (EAttribute) getIfcTextureCoordinateGenerator().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextureCoordinateGenerator_Parameter() {
		return (EReference) getIfcTextureCoordinateGenerator().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextureMap() {
		if (ifcTextureMapEClass == null) {
			ifcTextureMapEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(610);
		}
		return ifcTextureMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTextureMap_TextureMaps() {
		return (EReference) getIfcTextureMap().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextureVertex() {
		if (ifcTextureVertexEClass == null) {
			ifcTextureVertexEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(611);
		}
		return ifcTextureVertexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextureVertex_Coordinates() {
		return (EAttribute) getIfcTextureVertex().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextureVertex_CoordinatesAsString() {
		return (EAttribute) getIfcTextureVertex().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcThermalMaterialProperties() {
		if (ifcThermalMaterialPropertiesEClass == null) {
			ifcThermalMaterialPropertiesEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(612);
		}
		return ifcThermalMaterialPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalMaterialProperties_SpecificHeatCapacity() {
		return (EAttribute) getIfcThermalMaterialProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalMaterialProperties_SpecificHeatCapacityAsString() {
		return (EAttribute) getIfcThermalMaterialProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalMaterialProperties_BoilingPoint() {
		return (EAttribute) getIfcThermalMaterialProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalMaterialProperties_BoilingPointAsString() {
		return (EAttribute) getIfcThermalMaterialProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalMaterialProperties_FreezingPoint() {
		return (EAttribute) getIfcThermalMaterialProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalMaterialProperties_FreezingPointAsString() {
		return (EAttribute) getIfcThermalMaterialProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalMaterialProperties_ThermalConductivity() {
		return (EAttribute) getIfcThermalMaterialProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalMaterialProperties_ThermalConductivityAsString() {
		return (EAttribute) getIfcThermalMaterialProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTimeSeries() {
		if (ifcTimeSeriesEClass == null) {
			ifcTimeSeriesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(613);
		}
		return ifcTimeSeriesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeSeries_Name() {
		return (EAttribute) getIfcTimeSeries().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeSeries_Description() {
		return (EAttribute) getIfcTimeSeries().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeries_StartTime() {
		return (EReference) getIfcTimeSeries().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeries_EndTime() {
		return (EReference) getIfcTimeSeries().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeSeries_TimeSeriesDataType() {
		return (EAttribute) getIfcTimeSeries().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeSeries_DataOrigin() {
		return (EAttribute) getIfcTimeSeries().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeSeries_UserDefinedDataOrigin() {
		return (EAttribute) getIfcTimeSeries().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeries_Unit() {
		return (EReference) getIfcTimeSeries().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeries_DocumentedBy() {
		return (EReference) getIfcTimeSeries().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTimeSeriesReferenceRelationship() {
		if (ifcTimeSeriesReferenceRelationshipEClass == null) {
			ifcTimeSeriesReferenceRelationshipEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(614);
		}
		return ifcTimeSeriesReferenceRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeriesReferenceRelationship_ReferencedTimeSeries() {
		return (EReference) getIfcTimeSeriesReferenceRelationship().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeriesReferenceRelationship_TimeSeriesReferences() {
		return (EReference) getIfcTimeSeriesReferenceRelationship().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTimeSeriesSchedule() {
		if (ifcTimeSeriesScheduleEClass == null) {
			ifcTimeSeriesScheduleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(615);
		}
		return ifcTimeSeriesScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeriesSchedule_ApplicableDates() {
		return (EReference) getIfcTimeSeriesSchedule().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeSeriesSchedule_TimeSeriesScheduleType() {
		return (EAttribute) getIfcTimeSeriesSchedule().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeriesSchedule_TimeSeries() {
		return (EReference) getIfcTimeSeriesSchedule().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTimeSeriesValue() {
		if (ifcTimeSeriesValueEClass == null) {
			ifcTimeSeriesValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(616);
		}
		return ifcTimeSeriesValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTimeSeriesValue_ListValues() {
		return (EReference) getIfcTimeSeriesValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTopologicalRepresentationItem() {
		if (ifcTopologicalRepresentationItemEClass == null) {
			ifcTopologicalRepresentationItemEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(617);
		}
		return ifcTopologicalRepresentationItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTopologyRepresentation() {
		if (ifcTopologyRepresentationEClass == null) {
			ifcTopologyRepresentationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(618);
		}
		return ifcTopologyRepresentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTransformerType() {
		if (ifcTransformerTypeEClass == null) {
			ifcTransformerTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(619);
		}
		return ifcTransformerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTransformerType_PredefinedType() {
		return (EAttribute) getIfcTransformerType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTransportElement() {
		if (ifcTransportElementEClass == null) {
			ifcTransportElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(620);
		}
		return ifcTransportElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTransportElement_OperationType() {
		return (EAttribute) getIfcTransportElement().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTransportElement_CapacityByWeight() {
		return (EAttribute) getIfcTransportElement().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTransportElement_CapacityByWeightAsString() {
		return (EAttribute) getIfcTransportElement().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTransportElement_CapacityByNumber() {
		return (EAttribute) getIfcTransportElement().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTransportElement_CapacityByNumberAsString() {
		return (EAttribute) getIfcTransportElement().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTransportElementType() {
		if (ifcTransportElementTypeEClass == null) {
			ifcTransportElementTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(621);
		}
		return ifcTransportElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTransportElementType_PredefinedType() {
		return (EAttribute) getIfcTransportElementType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTrapeziumProfileDef() {
		if (ifcTrapeziumProfileDefEClass == null) {
			ifcTrapeziumProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(622);
		}
		return ifcTrapeziumProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrapeziumProfileDef_BottomXDim() {
		return (EAttribute) getIfcTrapeziumProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrapeziumProfileDef_BottomXDimAsString() {
		return (EAttribute) getIfcTrapeziumProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrapeziumProfileDef_TopXDim() {
		return (EAttribute) getIfcTrapeziumProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrapeziumProfileDef_TopXDimAsString() {
		return (EAttribute) getIfcTrapeziumProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrapeziumProfileDef_YDim() {
		return (EAttribute) getIfcTrapeziumProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrapeziumProfileDef_YDimAsString() {
		return (EAttribute) getIfcTrapeziumProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrapeziumProfileDef_TopXOffset() {
		return (EAttribute) getIfcTrapeziumProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrapeziumProfileDef_TopXOffsetAsString() {
		return (EAttribute) getIfcTrapeziumProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTrimmedCurve() {
		if (ifcTrimmedCurveEClass == null) {
			ifcTrimmedCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(623);
		}
		return ifcTrimmedCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTrimmedCurve_BasisCurve() {
		return (EReference) getIfcTrimmedCurve().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTrimmedCurve_Trim1() {
		return (EReference) getIfcTrimmedCurve().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTrimmedCurve_Trim2() {
		return (EReference) getIfcTrimmedCurve().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrimmedCurve_SenseAgreement() {
		return (EAttribute) getIfcTrimmedCurve().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTrimmedCurve_MasterRepresentation() {
		return (EAttribute) getIfcTrimmedCurve().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTubeBundleType() {
		if (ifcTubeBundleTypeEClass == null) {
			ifcTubeBundleTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(624);
		}
		return ifcTubeBundleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTubeBundleType_PredefinedType() {
		return (EAttribute) getIfcTubeBundleType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTwoDirectionRepeatFactor() {
		if (ifcTwoDirectionRepeatFactorEClass == null) {
			ifcTwoDirectionRepeatFactorEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(625);
		}
		return ifcTwoDirectionRepeatFactorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTwoDirectionRepeatFactor_SecondRepeatFactor() {
		return (EReference) getIfcTwoDirectionRepeatFactor().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTypeObject() {
		if (ifcTypeObjectEClass == null) {
			ifcTypeObjectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(626);
		}
		return ifcTypeObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTypeObject_ApplicableOccurrence() {
		return (EAttribute) getIfcTypeObject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTypeObject_HasPropertySets() {
		return (EReference) getIfcTypeObject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTypeObject_ObjectTypeOf() {
		return (EReference) getIfcTypeObject().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTypeProduct() {
		if (ifcTypeProductEClass == null) {
			ifcTypeProductEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(627);
		}
		return ifcTypeProductEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcTypeProduct_RepresentationMaps() {
		return (EReference) getIfcTypeProduct().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTypeProduct_Tag() {
		return (EAttribute) getIfcTypeProduct().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcUShapeProfileDef() {
		if (ifcUShapeProfileDefEClass == null) {
			ifcUShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(628);
		}
		return ifcUShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_Depth() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_DepthAsString() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_FlangeWidth() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_FlangeWidthAsString() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_WebThickness() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_WebThicknessAsString() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_FlangeThickness() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_FlangeThicknessAsString() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_FilletRadius() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_FilletRadiusAsString() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_EdgeRadius() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_EdgeRadiusAsString() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_FlangeSlope() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_FlangeSlopeAsString() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_CentreOfGravityInX() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUShapeProfileDef_CentreOfGravityInXAsString() {
		return (EAttribute) getIfcUShapeProfileDef().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcUnitAssignment() {
		if (ifcUnitAssignmentEClass == null) {
			ifcUnitAssignmentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(629);
		}
		return ifcUnitAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcUnitAssignment_Units() {
		return (EReference) getIfcUnitAssignment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcUnitaryEquipmentType() {
		if (ifcUnitaryEquipmentTypeEClass == null) {
			ifcUnitaryEquipmentTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(630);
		}
		return ifcUnitaryEquipmentTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcUnitaryEquipmentType_PredefinedType() {
		return (EAttribute) getIfcUnitaryEquipmentType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcValveType() {
		if (ifcValveTypeEClass == null) {
			ifcValveTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(631);
		}
		return ifcValveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcValveType_PredefinedType() {
		return (EAttribute) getIfcValveType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVector() {
		if (ifcVectorEClass == null) {
			ifcVectorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(632);
		}
		return ifcVectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcVector_Orientation() {
		return (EReference) getIfcVector().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVector_Magnitude() {
		return (EAttribute) getIfcVector().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVector_MagnitudeAsString() {
		return (EAttribute) getIfcVector().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVector_Dim() {
		return (EAttribute) getIfcVector().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVertex() {
		if (ifcVertexEClass == null) {
			ifcVertexEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(633);
		}
		return ifcVertexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVertexBasedTextureMap() {
		if (ifcVertexBasedTextureMapEClass == null) {
			ifcVertexBasedTextureMapEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(634);
		}
		return ifcVertexBasedTextureMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcVertexBasedTextureMap_TextureVertices() {
		return (EReference) getIfcVertexBasedTextureMap().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcVertexBasedTextureMap_TexturePoints() {
		return (EReference) getIfcVertexBasedTextureMap().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVertexLoop() {
		if (ifcVertexLoopEClass == null) {
			ifcVertexLoopEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(635);
		}
		return ifcVertexLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcVertexLoop_LoopVertex() {
		return (EReference) getIfcVertexLoop().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVertexPoint() {
		if (ifcVertexPointEClass == null) {
			ifcVertexPointEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(636);
		}
		return ifcVertexPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcVertexPoint_VertexGeometry() {
		return (EReference) getIfcVertexPoint().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVibrationIsolatorType() {
		if (ifcVibrationIsolatorTypeEClass == null) {
			ifcVibrationIsolatorTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(637);
		}
		return ifcVibrationIsolatorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVibrationIsolatorType_PredefinedType() {
		return (EAttribute) getIfcVibrationIsolatorType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVirtualElement() {
		if (ifcVirtualElementEClass == null) {
			ifcVirtualElementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(638);
		}
		return ifcVirtualElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVirtualGridIntersection() {
		if (ifcVirtualGridIntersectionEClass == null) {
			ifcVirtualGridIntersectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(639);
		}
		return ifcVirtualGridIntersectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcVirtualGridIntersection_IntersectingAxes() {
		return (EReference) getIfcVirtualGridIntersection().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVirtualGridIntersection_OffsetDistances() {
		return (EAttribute) getIfcVirtualGridIntersection().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVirtualGridIntersection_OffsetDistancesAsString() {
		return (EAttribute) getIfcVirtualGridIntersection().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWall() {
		if (ifcWallEClass == null) {
			ifcWallEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(640);
		}
		return ifcWallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWallStandardCase() {
		if (ifcWallStandardCaseEClass == null) {
			ifcWallStandardCaseEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(641);
		}
		return ifcWallStandardCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWallType() {
		if (ifcWallTypeEClass == null) {
			ifcWallTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(642);
		}
		return ifcWallTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWallType_PredefinedType() {
		return (EAttribute) getIfcWallType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWasteTerminalType() {
		if (ifcWasteTerminalTypeEClass == null) {
			ifcWasteTerminalTypeEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(643);
		}
		return ifcWasteTerminalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWasteTerminalType_PredefinedType() {
		return (EAttribute) getIfcWasteTerminalType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWaterProperties() {
		if (ifcWaterPropertiesEClass == null) {
			ifcWaterPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(644);
		}
		return ifcWaterPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_IsPotable() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_Hardness() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_HardnessAsString() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_AlkalinityConcentration() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_AlkalinityConcentrationAsString() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_AcidityConcentration() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_AcidityConcentrationAsString() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_ImpuritiesContent() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_ImpuritiesContentAsString() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_PHLevel() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_PHLevelAsString() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_DissolvedSolidsContent() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWaterProperties_DissolvedSolidsContentAsString() {
		return (EAttribute) getIfcWaterProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWindow() {
		if (ifcWindowEClass == null) {
			ifcWindowEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(645);
		}
		return ifcWindowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindow_OverallHeight() {
		return (EAttribute) getIfcWindow().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindow_OverallHeightAsString() {
		return (EAttribute) getIfcWindow().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindow_OverallWidth() {
		return (EAttribute) getIfcWindow().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindow_OverallWidthAsString() {
		return (EAttribute) getIfcWindow().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWindowLiningProperties() {
		if (ifcWindowLiningPropertiesEClass == null) {
			ifcWindowLiningPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(646);
		}
		return ifcWindowLiningPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_LiningDepth() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_LiningDepthAsString() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_LiningThickness() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_LiningThicknessAsString() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_TransomThickness() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_TransomThicknessAsString() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_MullionThickness() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_MullionThicknessAsString() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_FirstTransomOffset() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_FirstTransomOffsetAsString() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_SecondTransomOffset() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_SecondTransomOffsetAsString() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_FirstMullionOffset() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_FirstMullionOffsetAsString() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_SecondMullionOffset() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowLiningProperties_SecondMullionOffsetAsString() {
		return (EAttribute) getIfcWindowLiningProperties().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcWindowLiningProperties_ShapeAspectStyle() {
		return (EReference) getIfcWindowLiningProperties().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWindowPanelProperties() {
		if (ifcWindowPanelPropertiesEClass == null) {
			ifcWindowPanelPropertiesEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(647);
		}
		return ifcWindowPanelPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowPanelProperties_OperationType() {
		return (EAttribute) getIfcWindowPanelProperties().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowPanelProperties_PanelPosition() {
		return (EAttribute) getIfcWindowPanelProperties().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowPanelProperties_FrameDepth() {
		return (EAttribute) getIfcWindowPanelProperties().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowPanelProperties_FrameDepthAsString() {
		return (EAttribute) getIfcWindowPanelProperties().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowPanelProperties_FrameThickness() {
		return (EAttribute) getIfcWindowPanelProperties().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowPanelProperties_FrameThicknessAsString() {
		return (EAttribute) getIfcWindowPanelProperties().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcWindowPanelProperties_ShapeAspectStyle() {
		return (EReference) getIfcWindowPanelProperties().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWindowStyle() {
		if (ifcWindowStyleEClass == null) {
			ifcWindowStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(648);
		}
		return ifcWindowStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowStyle_ConstructionType() {
		return (EAttribute) getIfcWindowStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowStyle_OperationType() {
		return (EAttribute) getIfcWindowStyle().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowStyle_ParameterTakesPrecedence() {
		return (EAttribute) getIfcWindowStyle().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWindowStyle_Sizeable() {
		return (EAttribute) getIfcWindowStyle().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWorkControl() {
		if (ifcWorkControlEClass == null) {
			ifcWorkControlEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(649);
		}
		return ifcWorkControlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWorkControl_Identifier() {
		return (EAttribute) getIfcWorkControl().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcWorkControl_CreationDate() {
		return (EReference) getIfcWorkControl().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcWorkControl_Creators() {
		return (EReference) getIfcWorkControl().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWorkControl_Purpose() {
		return (EAttribute) getIfcWorkControl().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWorkControl_Duration() {
		return (EAttribute) getIfcWorkControl().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWorkControl_DurationAsString() {
		return (EAttribute) getIfcWorkControl().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWorkControl_TotalFloat() {
		return (EAttribute) getIfcWorkControl().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWorkControl_TotalFloatAsString() {
		return (EAttribute) getIfcWorkControl().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcWorkControl_StartTime() {
		return (EReference) getIfcWorkControl().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfcWorkControl_FinishTime() {
		return (EReference) getIfcWorkControl().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWorkControl_WorkControlType() {
		return (EAttribute) getIfcWorkControl().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWorkControl_UserDefinedControlType() {
		return (EAttribute) getIfcWorkControl().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWorkPlan() {
		if (ifcWorkPlanEClass == null) {
			ifcWorkPlanEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(650);
		}
		return ifcWorkPlanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWorkSchedule() {
		if (ifcWorkScheduleEClass == null) {
			ifcWorkScheduleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(651);
		}
		return ifcWorkScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcZShapeProfileDef() {
		if (ifcZShapeProfileDefEClass == null) {
			ifcZShapeProfileDefEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(652);
		}
		return ifcZShapeProfileDefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_Depth() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_DepthAsString() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_FlangeWidth() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_FlangeWidthAsString() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_WebThickness() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_WebThicknessAsString() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_FlangeThickness() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_FlangeThicknessAsString() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_FilletRadius() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_FilletRadiusAsString() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_EdgeRadius() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcZShapeProfileDef_EdgeRadiusAsString() {
		return (EAttribute) getIfcZShapeProfileDef().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcZone() {
		if (ifcZoneEClass == null) {
			ifcZoneEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(653);
		}
		return ifcZoneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAbsorbedDoseMeasure() {
		if (ifcAbsorbedDoseMeasureEClass == null) {
			ifcAbsorbedDoseMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(654);
		}
		return ifcAbsorbedDoseMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAbsorbedDoseMeasure_WrappedValue() {
		return (EAttribute) getIfcAbsorbedDoseMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAbsorbedDoseMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcAbsorbedDoseMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAccelerationMeasure() {
		if (ifcAccelerationMeasureEClass == null) {
			ifcAccelerationMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(655);
		}
		return ifcAccelerationMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAccelerationMeasure_WrappedValue() {
		return (EAttribute) getIfcAccelerationMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAccelerationMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcAccelerationMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAmountOfSubstanceMeasure() {
		if (ifcAmountOfSubstanceMeasureEClass == null) {
			ifcAmountOfSubstanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(656);
		}
		return ifcAmountOfSubstanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAmountOfSubstanceMeasure_WrappedValue() {
		return (EAttribute) getIfcAmountOfSubstanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAmountOfSubstanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcAmountOfSubstanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAngularVelocityMeasure() {
		if (ifcAngularVelocityMeasureEClass == null) {
			ifcAngularVelocityMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(657);
		}
		return ifcAngularVelocityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAngularVelocityMeasure_WrappedValue() {
		return (EAttribute) getIfcAngularVelocityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAngularVelocityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcAngularVelocityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAreaMeasure() {
		if (ifcAreaMeasureEClass == null) {
			ifcAreaMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(658);
		}
		return ifcAreaMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAreaMeasure_WrappedValue() {
		return (EAttribute) getIfcAreaMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcAreaMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcAreaMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoolean() {
		if (ifcBooleanEClass == null) {
			ifcBooleanEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(659);
		}
		return ifcBooleanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcBoolean_WrappedValue() {
		return (EAttribute) getIfcBoolean().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcContextDependentMeasure() {
		if (ifcContextDependentMeasureEClass == null) {
			ifcContextDependentMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(660);
		}
		return ifcContextDependentMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcContextDependentMeasure_WrappedValue() {
		return (EAttribute) getIfcContextDependentMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcContextDependentMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcContextDependentMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCountMeasure() {
		if (ifcCountMeasureEClass == null) {
			ifcCountMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(661);
		}
		return ifcCountMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCountMeasure_WrappedValue() {
		return (EAttribute) getIfcCountMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCountMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcCountMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurvatureMeasure() {
		if (ifcCurvatureMeasureEClass == null) {
			ifcCurvatureMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(662);
		}
		return ifcCurvatureMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurvatureMeasure_WrappedValue() {
		return (EAttribute) getIfcCurvatureMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCurvatureMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcCurvatureMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDayInMonthNumber() {
		if (ifcDayInMonthNumberEClass == null) {
			ifcDayInMonthNumberEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(663);
		}
		return ifcDayInMonthNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDayInMonthNumber_WrappedValue() {
		return (EAttribute) getIfcDayInMonthNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDaylightSavingHour() {
		if (ifcDaylightSavingHourEClass == null) {
			ifcDaylightSavingHourEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(664);
		}
		return ifcDaylightSavingHourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDaylightSavingHour_WrappedValue() {
		return (EAttribute) getIfcDaylightSavingHour().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDescriptiveMeasure() {
		if (ifcDescriptiveMeasureEClass == null) {
			ifcDescriptiveMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(665);
		}
		return ifcDescriptiveMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDescriptiveMeasure_WrappedValue() {
		return (EAttribute) getIfcDescriptiveMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDimensionCount() {
		if (ifcDimensionCountEClass == null) {
			ifcDimensionCountEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(666);
		}
		return ifcDimensionCountEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDimensionCount_WrappedValue() {
		return (EAttribute) getIfcDimensionCount().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDoseEquivalentMeasure() {
		if (ifcDoseEquivalentMeasureEClass == null) {
			ifcDoseEquivalentMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(667);
		}
		return ifcDoseEquivalentMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoseEquivalentMeasure_WrappedValue() {
		return (EAttribute) getIfcDoseEquivalentMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDoseEquivalentMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcDoseEquivalentMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDynamicViscosityMeasure() {
		if (ifcDynamicViscosityMeasureEClass == null) {
			ifcDynamicViscosityMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(668);
		}
		return ifcDynamicViscosityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDynamicViscosityMeasure_WrappedValue() {
		return (EAttribute) getIfcDynamicViscosityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcDynamicViscosityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcDynamicViscosityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricCapacitanceMeasure() {
		if (ifcElectricCapacitanceMeasureEClass == null) {
			ifcElectricCapacitanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(669);
		}
		return ifcElectricCapacitanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricCapacitanceMeasure_WrappedValue() {
		return (EAttribute) getIfcElectricCapacitanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricCapacitanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcElectricCapacitanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricChargeMeasure() {
		if (ifcElectricChargeMeasureEClass == null) {
			ifcElectricChargeMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(670);
		}
		return ifcElectricChargeMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricChargeMeasure_WrappedValue() {
		return (EAttribute) getIfcElectricChargeMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricChargeMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcElectricChargeMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricConductanceMeasure() {
		if (ifcElectricConductanceMeasureEClass == null) {
			ifcElectricConductanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(671);
		}
		return ifcElectricConductanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricConductanceMeasure_WrappedValue() {
		return (EAttribute) getIfcElectricConductanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricConductanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcElectricConductanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricCurrentMeasure() {
		if (ifcElectricCurrentMeasureEClass == null) {
			ifcElectricCurrentMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(672);
		}
		return ifcElectricCurrentMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricCurrentMeasure_WrappedValue() {
		return (EAttribute) getIfcElectricCurrentMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricCurrentMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcElectricCurrentMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricResistanceMeasure() {
		if (ifcElectricResistanceMeasureEClass == null) {
			ifcElectricResistanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(673);
		}
		return ifcElectricResistanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricResistanceMeasure_WrappedValue() {
		return (EAttribute) getIfcElectricResistanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricResistanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcElectricResistanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcElectricVoltageMeasure() {
		if (ifcElectricVoltageMeasureEClass == null) {
			ifcElectricVoltageMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(674);
		}
		return ifcElectricVoltageMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricVoltageMeasure_WrappedValue() {
		return (EAttribute) getIfcElectricVoltageMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcElectricVoltageMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcElectricVoltageMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcEnergyMeasure() {
		if (ifcEnergyMeasureEClass == null) {
			ifcEnergyMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(675);
		}
		return ifcEnergyMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEnergyMeasure_WrappedValue() {
		return (EAttribute) getIfcEnergyMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcEnergyMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcEnergyMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFontStyle() {
		if (ifcFontStyleEClass == null) {
			ifcFontStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(676);
		}
		return ifcFontStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFontStyle_WrappedValue() {
		return (EAttribute) getIfcFontStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFontVariant() {
		if (ifcFontVariantEClass == null) {
			ifcFontVariantEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(677);
		}
		return ifcFontVariantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFontVariant_WrappedValue() {
		return (EAttribute) getIfcFontVariant().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFontWeight() {
		if (ifcFontWeightEClass == null) {
			ifcFontWeightEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(678);
		}
		return ifcFontWeightEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFontWeight_WrappedValue() {
		return (EAttribute) getIfcFontWeight().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcForceMeasure() {
		if (ifcForceMeasureEClass == null) {
			ifcForceMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(679);
		}
		return ifcForceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcForceMeasure_WrappedValue() {
		return (EAttribute) getIfcForceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcForceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcForceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFrequencyMeasure() {
		if (ifcFrequencyMeasureEClass == null) {
			ifcFrequencyMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(680);
		}
		return ifcFrequencyMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFrequencyMeasure_WrappedValue() {
		return (EAttribute) getIfcFrequencyMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcFrequencyMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcFrequencyMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGloballyUniqueId() {
		if (ifcGloballyUniqueIdEClass == null) {
			ifcGloballyUniqueIdEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(681);
		}
		return ifcGloballyUniqueIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcGloballyUniqueId_WrappedValue() {
		return (EAttribute) getIfcGloballyUniqueId().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHeatFluxDensityMeasure() {
		if (ifcHeatFluxDensityMeasureEClass == null) {
			ifcHeatFluxDensityMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(682);
		}
		return ifcHeatFluxDensityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeatFluxDensityMeasure_WrappedValue() {
		return (EAttribute) getIfcHeatFluxDensityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeatFluxDensityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcHeatFluxDensityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHeatingValueMeasure() {
		if (ifcHeatingValueMeasureEClass == null) {
			ifcHeatingValueMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(683);
		}
		return ifcHeatingValueMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeatingValueMeasure_WrappedValue() {
		return (EAttribute) getIfcHeatingValueMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHeatingValueMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcHeatingValueMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHourInDay() {
		if (ifcHourInDayEClass == null) {
			ifcHourInDayEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(684);
		}
		return ifcHourInDayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcHourInDay_WrappedValue() {
		return (EAttribute) getIfcHourInDay().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcIdentifier() {
		if (ifcIdentifierEClass == null) {
			ifcIdentifierEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(685);
		}
		return ifcIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIdentifier_WrappedValue() {
		return (EAttribute) getIfcIdentifier().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcIlluminanceMeasure() {
		if (ifcIlluminanceMeasureEClass == null) {
			ifcIlluminanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(686);
		}
		return ifcIlluminanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIlluminanceMeasure_WrappedValue() {
		return (EAttribute) getIfcIlluminanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIlluminanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcIlluminanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcInductanceMeasure() {
		if (ifcInductanceMeasureEClass == null) {
			ifcInductanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(687);
		}
		return ifcInductanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcInductanceMeasure_WrappedValue() {
		return (EAttribute) getIfcInductanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcInductanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcInductanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcInteger() {
		if (ifcIntegerEClass == null) {
			ifcIntegerEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(688);
		}
		return ifcIntegerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcInteger_WrappedValue() {
		return (EAttribute) getIfcInteger().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcIntegerCountRateMeasure() {
		if (ifcIntegerCountRateMeasureEClass == null) {
			ifcIntegerCountRateMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(689);
		}
		return ifcIntegerCountRateMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIntegerCountRateMeasure_WrappedValue() {
		return (EAttribute) getIfcIntegerCountRateMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcIonConcentrationMeasure() {
		if (ifcIonConcentrationMeasureEClass == null) {
			ifcIonConcentrationMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(690);
		}
		return ifcIonConcentrationMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIonConcentrationMeasure_WrappedValue() {
		return (EAttribute) getIfcIonConcentrationMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIonConcentrationMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcIonConcentrationMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcIsothermalMoistureCapacityMeasure() {
		if (ifcIsothermalMoistureCapacityMeasureEClass == null) {
			ifcIsothermalMoistureCapacityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(691);
		}
		return ifcIsothermalMoistureCapacityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIsothermalMoistureCapacityMeasure_WrappedValue() {
		return (EAttribute) getIfcIsothermalMoistureCapacityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcIsothermalMoistureCapacityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcIsothermalMoistureCapacityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcKinematicViscosityMeasure() {
		if (ifcKinematicViscosityMeasureEClass == null) {
			ifcKinematicViscosityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(692);
		}
		return ifcKinematicViscosityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcKinematicViscosityMeasure_WrappedValue() {
		return (EAttribute) getIfcKinematicViscosityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcKinematicViscosityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcKinematicViscosityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLabel() {
		if (ifcLabelEClass == null) {
			ifcLabelEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(693);
		}
		return ifcLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLabel_WrappedValue() {
		return (EAttribute) getIfcLabel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLengthMeasure() {
		if (ifcLengthMeasureEClass == null) {
			ifcLengthMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(694);
		}
		return ifcLengthMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLengthMeasure_WrappedValue() {
		return (EAttribute) getIfcLengthMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLengthMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcLengthMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLinearForceMeasure() {
		if (ifcLinearForceMeasureEClass == null) {
			ifcLinearForceMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(695);
		}
		return ifcLinearForceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLinearForceMeasure_WrappedValue() {
		return (EAttribute) getIfcLinearForceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLinearForceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcLinearForceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLinearMomentMeasure() {
		if (ifcLinearMomentMeasureEClass == null) {
			ifcLinearMomentMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(696);
		}
		return ifcLinearMomentMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLinearMomentMeasure_WrappedValue() {
		return (EAttribute) getIfcLinearMomentMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLinearMomentMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcLinearMomentMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLinearStiffnessMeasure() {
		if (ifcLinearStiffnessMeasureEClass == null) {
			ifcLinearStiffnessMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(697);
		}
		return ifcLinearStiffnessMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLinearStiffnessMeasure_WrappedValue() {
		return (EAttribute) getIfcLinearStiffnessMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLinearStiffnessMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcLinearStiffnessMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLinearVelocityMeasure() {
		if (ifcLinearVelocityMeasureEClass == null) {
			ifcLinearVelocityMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(698);
		}
		return ifcLinearVelocityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLinearVelocityMeasure_WrappedValue() {
		return (EAttribute) getIfcLinearVelocityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLinearVelocityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcLinearVelocityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLogical() {
		if (ifcLogicalEClass == null) {
			ifcLogicalEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(699);
		}
		return ifcLogicalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLogical_WrappedValue() {
		return (EAttribute) getIfcLogical().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLuminousFluxMeasure() {
		if (ifcLuminousFluxMeasureEClass == null) {
			ifcLuminousFluxMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(700);
		}
		return ifcLuminousFluxMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLuminousFluxMeasure_WrappedValue() {
		return (EAttribute) getIfcLuminousFluxMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLuminousFluxMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcLuminousFluxMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLuminousIntensityDistributionMeasure() {
		if (ifcLuminousIntensityDistributionMeasureEClass == null) {
			ifcLuminousIntensityDistributionMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(701);
		}
		return ifcLuminousIntensityDistributionMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLuminousIntensityDistributionMeasure_WrappedValue() {
		return (EAttribute) getIfcLuminousIntensityDistributionMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLuminousIntensityDistributionMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcLuminousIntensityDistributionMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLuminousIntensityMeasure() {
		if (ifcLuminousIntensityMeasureEClass == null) {
			ifcLuminousIntensityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(702);
		}
		return ifcLuminousIntensityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLuminousIntensityMeasure_WrappedValue() {
		return (EAttribute) getIfcLuminousIntensityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcLuminousIntensityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcLuminousIntensityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMagneticFluxDensityMeasure() {
		if (ifcMagneticFluxDensityMeasureEClass == null) {
			ifcMagneticFluxDensityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(703);
		}
		return ifcMagneticFluxDensityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMagneticFluxDensityMeasure_WrappedValue() {
		return (EAttribute) getIfcMagneticFluxDensityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMagneticFluxDensityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMagneticFluxDensityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMagneticFluxMeasure() {
		if (ifcMagneticFluxMeasureEClass == null) {
			ifcMagneticFluxMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(704);
		}
		return ifcMagneticFluxMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMagneticFluxMeasure_WrappedValue() {
		return (EAttribute) getIfcMagneticFluxMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMagneticFluxMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMagneticFluxMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMassDensityMeasure() {
		if (ifcMassDensityMeasureEClass == null) {
			ifcMassDensityMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(705);
		}
		return ifcMassDensityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMassDensityMeasure_WrappedValue() {
		return (EAttribute) getIfcMassDensityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMassDensityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMassDensityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMassFlowRateMeasure() {
		if (ifcMassFlowRateMeasureEClass == null) {
			ifcMassFlowRateMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(706);
		}
		return ifcMassFlowRateMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMassFlowRateMeasure_WrappedValue() {
		return (EAttribute) getIfcMassFlowRateMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMassFlowRateMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMassFlowRateMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMassMeasure() {
		if (ifcMassMeasureEClass == null) {
			ifcMassMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(707);
		}
		return ifcMassMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMassMeasure_WrappedValue() {
		return (EAttribute) getIfcMassMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMassMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMassMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMassPerLengthMeasure() {
		if (ifcMassPerLengthMeasureEClass == null) {
			ifcMassPerLengthMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(708);
		}
		return ifcMassPerLengthMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMassPerLengthMeasure_WrappedValue() {
		return (EAttribute) getIfcMassPerLengthMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMassPerLengthMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMassPerLengthMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMinuteInHour() {
		if (ifcMinuteInHourEClass == null) {
			ifcMinuteInHourEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(709);
		}
		return ifcMinuteInHourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMinuteInHour_WrappedValue() {
		return (EAttribute) getIfcMinuteInHour().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcModulusOfElasticityMeasure() {
		if (ifcModulusOfElasticityMeasureEClass == null) {
			ifcModulusOfElasticityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(710);
		}
		return ifcModulusOfElasticityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcModulusOfElasticityMeasure_WrappedValue() {
		return (EAttribute) getIfcModulusOfElasticityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcModulusOfElasticityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcModulusOfElasticityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcModulusOfLinearSubgradeReactionMeasure() {
		if (ifcModulusOfLinearSubgradeReactionMeasureEClass == null) {
			ifcModulusOfLinearSubgradeReactionMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(711);
		}
		return ifcModulusOfLinearSubgradeReactionMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcModulusOfLinearSubgradeReactionMeasure_WrappedValue() {
		return (EAttribute) getIfcModulusOfLinearSubgradeReactionMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcModulusOfLinearSubgradeReactionMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcModulusOfLinearSubgradeReactionMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcModulusOfRotationalSubgradeReactionMeasure() {
		if (ifcModulusOfRotationalSubgradeReactionMeasureEClass == null) {
			ifcModulusOfRotationalSubgradeReactionMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(712);
		}
		return ifcModulusOfRotationalSubgradeReactionMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcModulusOfRotationalSubgradeReactionMeasure_WrappedValue() {
		return (EAttribute) getIfcModulusOfRotationalSubgradeReactionMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcModulusOfRotationalSubgradeReactionMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcModulusOfRotationalSubgradeReactionMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcModulusOfSubgradeReactionMeasure() {
		if (ifcModulusOfSubgradeReactionMeasureEClass == null) {
			ifcModulusOfSubgradeReactionMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(713);
		}
		return ifcModulusOfSubgradeReactionMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcModulusOfSubgradeReactionMeasure_WrappedValue() {
		return (EAttribute) getIfcModulusOfSubgradeReactionMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcModulusOfSubgradeReactionMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcModulusOfSubgradeReactionMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMoistureDiffusivityMeasure() {
		if (ifcMoistureDiffusivityMeasureEClass == null) {
			ifcMoistureDiffusivityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(714);
		}
		return ifcMoistureDiffusivityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMoistureDiffusivityMeasure_WrappedValue() {
		return (EAttribute) getIfcMoistureDiffusivityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMoistureDiffusivityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMoistureDiffusivityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMolecularWeightMeasure() {
		if (ifcMolecularWeightMeasureEClass == null) {
			ifcMolecularWeightMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(715);
		}
		return ifcMolecularWeightMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMolecularWeightMeasure_WrappedValue() {
		return (EAttribute) getIfcMolecularWeightMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMolecularWeightMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMolecularWeightMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMomentOfInertiaMeasure() {
		if (ifcMomentOfInertiaMeasureEClass == null) {
			ifcMomentOfInertiaMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(716);
		}
		return ifcMomentOfInertiaMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMomentOfInertiaMeasure_WrappedValue() {
		return (EAttribute) getIfcMomentOfInertiaMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMomentOfInertiaMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMomentOfInertiaMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMonetaryMeasure() {
		if (ifcMonetaryMeasureEClass == null) {
			ifcMonetaryMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(717);
		}
		return ifcMonetaryMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMonetaryMeasure_WrappedValue() {
		return (EAttribute) getIfcMonetaryMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMonetaryMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcMonetaryMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMonthInYearNumber() {
		if (ifcMonthInYearNumberEClass == null) {
			ifcMonthInYearNumberEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(718);
		}
		return ifcMonthInYearNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcMonthInYearNumber_WrappedValue() {
		return (EAttribute) getIfcMonthInYearNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcNumericMeasure() {
		if (ifcNumericMeasureEClass == null) {
			ifcNumericMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(719);
		}
		return ifcNumericMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcNumericMeasure_WrappedValue() {
		return (EAttribute) getIfcNumericMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcNumericMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcNumericMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPHMeasure() {
		if (ifcPHMeasureEClass == null) {
			ifcPHMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(720);
		}
		return ifcPHMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPHMeasure_WrappedValue() {
		return (EAttribute) getIfcPHMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPHMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcPHMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcParameterValue() {
		if (ifcParameterValueEClass == null) {
			ifcParameterValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(721);
		}
		return ifcParameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcParameterValue_WrappedValue() {
		return (EAttribute) getIfcParameterValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcParameterValue_WrappedValueAsString() {
		return (EAttribute) getIfcParameterValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPlanarForceMeasure() {
		if (ifcPlanarForceMeasureEClass == null) {
			ifcPlanarForceMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(722);
		}
		return ifcPlanarForceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlanarForceMeasure_WrappedValue() {
		return (EAttribute) getIfcPlanarForceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlanarForceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcPlanarForceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPlaneAngleMeasure() {
		if (ifcPlaneAngleMeasureEClass == null) {
			ifcPlaneAngleMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(723);
		}
		return ifcPlaneAngleMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlaneAngleMeasure_WrappedValue() {
		return (EAttribute) getIfcPlaneAngleMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPlaneAngleMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcPlaneAngleMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPowerMeasure() {
		if (ifcPowerMeasureEClass == null) {
			ifcPowerMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(724);
		}
		return ifcPowerMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPowerMeasure_WrappedValue() {
		return (EAttribute) getIfcPowerMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPowerMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcPowerMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPresentableText() {
		if (ifcPresentableTextEClass == null) {
			ifcPresentableTextEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(725);
		}
		return ifcPresentableTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPresentableText_WrappedValue() {
		return (EAttribute) getIfcPresentableText().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPressureMeasure() {
		if (ifcPressureMeasureEClass == null) {
			ifcPressureMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(726);
		}
		return ifcPressureMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPressureMeasure_WrappedValue() {
		return (EAttribute) getIfcPressureMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcPressureMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcPressureMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRadioActivityMeasure() {
		if (ifcRadioActivityMeasureEClass == null) {
			ifcRadioActivityMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(727);
		}
		return ifcRadioActivityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRadioActivityMeasure_WrappedValue() {
		return (EAttribute) getIfcRadioActivityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRadioActivityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcRadioActivityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRatioMeasure() {
		if (ifcRatioMeasureEClass == null) {
			ifcRatioMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(728);
		}
		return ifcRatioMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRatioMeasure_WrappedValue() {
		return (EAttribute) getIfcRatioMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRatioMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcRatioMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcReal() {
		if (ifcRealEClass == null) {
			ifcRealEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(729);
		}
		return ifcRealEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReal_WrappedValue() {
		return (EAttribute) getIfcReal().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcReal_WrappedValueAsString() {
		return (EAttribute) getIfcReal().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRotationalFrequencyMeasure() {
		if (ifcRotationalFrequencyMeasureEClass == null) {
			ifcRotationalFrequencyMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(730);
		}
		return ifcRotationalFrequencyMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRotationalFrequencyMeasure_WrappedValue() {
		return (EAttribute) getIfcRotationalFrequencyMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRotationalFrequencyMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcRotationalFrequencyMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRotationalMassMeasure() {
		if (ifcRotationalMassMeasureEClass == null) {
			ifcRotationalMassMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(731);
		}
		return ifcRotationalMassMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRotationalMassMeasure_WrappedValue() {
		return (EAttribute) getIfcRotationalMassMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRotationalMassMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcRotationalMassMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcRotationalStiffnessMeasure() {
		if (ifcRotationalStiffnessMeasureEClass == null) {
			ifcRotationalStiffnessMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(732);
		}
		return ifcRotationalStiffnessMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRotationalStiffnessMeasure_WrappedValue() {
		return (EAttribute) getIfcRotationalStiffnessMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcRotationalStiffnessMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcRotationalStiffnessMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSecondInMinute() {
		if (ifcSecondInMinuteEClass == null) {
			ifcSecondInMinuteEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(733);
		}
		return ifcSecondInMinuteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSecondInMinute_WrappedValue() {
		return (EAttribute) getIfcSecondInMinute().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSecondInMinute_WrappedValueAsString() {
		return (EAttribute) getIfcSecondInMinute().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSectionModulusMeasure() {
		if (ifcSectionModulusMeasureEClass == null) {
			ifcSectionModulusMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(734);
		}
		return ifcSectionModulusMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionModulusMeasure_WrappedValue() {
		return (EAttribute) getIfcSectionModulusMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionModulusMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcSectionModulusMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSectionalAreaIntegralMeasure() {
		if (ifcSectionalAreaIntegralMeasureEClass == null) {
			ifcSectionalAreaIntegralMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(735);
		}
		return ifcSectionalAreaIntegralMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionalAreaIntegralMeasure_WrappedValue() {
		return (EAttribute) getIfcSectionalAreaIntegralMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSectionalAreaIntegralMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcSectionalAreaIntegralMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcShearModulusMeasure() {
		if (ifcShearModulusMeasureEClass == null) {
			ifcShearModulusMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(736);
		}
		return ifcShearModulusMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcShearModulusMeasure_WrappedValue() {
		return (EAttribute) getIfcShearModulusMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcShearModulusMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcShearModulusMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSolidAngleMeasure() {
		if (ifcSolidAngleMeasureEClass == null) {
			ifcSolidAngleMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(737);
		}
		return ifcSolidAngleMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSolidAngleMeasure_WrappedValue() {
		return (EAttribute) getIfcSolidAngleMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSolidAngleMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcSolidAngleMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSoundPowerMeasure() {
		if (ifcSoundPowerMeasureEClass == null) {
			ifcSoundPowerMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(738);
		}
		return ifcSoundPowerMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSoundPowerMeasure_WrappedValue() {
		return (EAttribute) getIfcSoundPowerMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSoundPowerMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcSoundPowerMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSoundPressureMeasure() {
		if (ifcSoundPressureMeasureEClass == null) {
			ifcSoundPressureMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(739);
		}
		return ifcSoundPressureMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSoundPressureMeasure_WrappedValue() {
		return (EAttribute) getIfcSoundPressureMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSoundPressureMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcSoundPressureMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpecificHeatCapacityMeasure() {
		if (ifcSpecificHeatCapacityMeasureEClass == null) {
			ifcSpecificHeatCapacityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(740);
		}
		return ifcSpecificHeatCapacityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpecificHeatCapacityMeasure_WrappedValue() {
		return (EAttribute) getIfcSpecificHeatCapacityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpecificHeatCapacityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcSpecificHeatCapacityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpecularExponent() {
		if (ifcSpecularExponentEClass == null) {
			ifcSpecularExponentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(741);
		}
		return ifcSpecularExponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpecularExponent_WrappedValue() {
		return (EAttribute) getIfcSpecularExponent().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpecularExponent_WrappedValueAsString() {
		return (EAttribute) getIfcSpecularExponent().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpecularRoughness() {
		if (ifcSpecularRoughnessEClass == null) {
			ifcSpecularRoughnessEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(742);
		}
		return ifcSpecularRoughnessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpecularRoughness_WrappedValue() {
		return (EAttribute) getIfcSpecularRoughness().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcSpecularRoughness_WrappedValueAsString() {
		return (EAttribute) getIfcSpecularRoughness().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTemperatureGradientMeasure() {
		if (ifcTemperatureGradientMeasureEClass == null) {
			ifcTemperatureGradientMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(743);
		}
		return ifcTemperatureGradientMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTemperatureGradientMeasure_WrappedValue() {
		return (EAttribute) getIfcTemperatureGradientMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTemperatureGradientMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcTemperatureGradientMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcText() {
		if (ifcTextEClass == null) {
			ifcTextEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(744);
		}
		return ifcTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcText_WrappedValue() {
		return (EAttribute) getIfcText().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextAlignment() {
		if (ifcTextAlignmentEClass == null) {
			ifcTextAlignmentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(745);
		}
		return ifcTextAlignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextAlignment_WrappedValue() {
		return (EAttribute) getIfcTextAlignment().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextDecoration() {
		if (ifcTextDecorationEClass == null) {
			ifcTextDecorationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(746);
		}
		return ifcTextDecorationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextDecoration_WrappedValue() {
		return (EAttribute) getIfcTextDecoration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextFontName() {
		if (ifcTextFontNameEClass == null) {
			ifcTextFontNameEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(747);
		}
		return ifcTextFontNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextFontName_WrappedValue() {
		return (EAttribute) getIfcTextFontName().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextTransformation() {
		if (ifcTextTransformationEClass == null) {
			ifcTextTransformationEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(748);
		}
		return ifcTextTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTextTransformation_WrappedValue() {
		return (EAttribute) getIfcTextTransformation().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcThermalAdmittanceMeasure() {
		if (ifcThermalAdmittanceMeasureEClass == null) {
			ifcThermalAdmittanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(749);
		}
		return ifcThermalAdmittanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalAdmittanceMeasure_WrappedValue() {
		return (EAttribute) getIfcThermalAdmittanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalAdmittanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcThermalAdmittanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcThermalConductivityMeasure() {
		if (ifcThermalConductivityMeasureEClass == null) {
			ifcThermalConductivityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(750);
		}
		return ifcThermalConductivityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalConductivityMeasure_WrappedValue() {
		return (EAttribute) getIfcThermalConductivityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalConductivityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcThermalConductivityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcThermalExpansionCoefficientMeasure() {
		if (ifcThermalExpansionCoefficientMeasureEClass == null) {
			ifcThermalExpansionCoefficientMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(751);
		}
		return ifcThermalExpansionCoefficientMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalExpansionCoefficientMeasure_WrappedValue() {
		return (EAttribute) getIfcThermalExpansionCoefficientMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalExpansionCoefficientMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcThermalExpansionCoefficientMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcThermalResistanceMeasure() {
		if (ifcThermalResistanceMeasureEClass == null) {
			ifcThermalResistanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(752);
		}
		return ifcThermalResistanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalResistanceMeasure_WrappedValue() {
		return (EAttribute) getIfcThermalResistanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalResistanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcThermalResistanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcThermalTransmittanceMeasure() {
		if (ifcThermalTransmittanceMeasureEClass == null) {
			ifcThermalTransmittanceMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(753);
		}
		return ifcThermalTransmittanceMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalTransmittanceMeasure_WrappedValue() {
		return (EAttribute) getIfcThermalTransmittanceMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermalTransmittanceMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcThermalTransmittanceMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcThermodynamicTemperatureMeasure() {
		if (ifcThermodynamicTemperatureMeasureEClass == null) {
			ifcThermodynamicTemperatureMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(754);
		}
		return ifcThermodynamicTemperatureMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermodynamicTemperatureMeasure_WrappedValue() {
		return (EAttribute) getIfcThermodynamicTemperatureMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcThermodynamicTemperatureMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcThermodynamicTemperatureMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTimeMeasure() {
		if (ifcTimeMeasureEClass == null) {
			ifcTimeMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(755);
		}
		return ifcTimeMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeMeasure_WrappedValue() {
		return (EAttribute) getIfcTimeMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcTimeMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTimeStamp() {
		if (ifcTimeStampEClass == null) {
			ifcTimeStampEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(756);
		}
		return ifcTimeStampEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTimeStamp_WrappedValue() {
		return (EAttribute) getIfcTimeStamp().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTorqueMeasure() {
		if (ifcTorqueMeasureEClass == null) {
			ifcTorqueMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(757);
		}
		return ifcTorqueMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTorqueMeasure_WrappedValue() {
		return (EAttribute) getIfcTorqueMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcTorqueMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcTorqueMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVaporPermeabilityMeasure() {
		if (ifcVaporPermeabilityMeasureEClass == null) {
			ifcVaporPermeabilityMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(758);
		}
		return ifcVaporPermeabilityMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVaporPermeabilityMeasure_WrappedValue() {
		return (EAttribute) getIfcVaporPermeabilityMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVaporPermeabilityMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcVaporPermeabilityMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVolumeMeasure() {
		if (ifcVolumeMeasureEClass == null) {
			ifcVolumeMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(759);
		}
		return ifcVolumeMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVolumeMeasure_WrappedValue() {
		return (EAttribute) getIfcVolumeMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVolumeMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcVolumeMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVolumetricFlowRateMeasure() {
		if (ifcVolumetricFlowRateMeasureEClass == null) {
			ifcVolumetricFlowRateMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(760);
		}
		return ifcVolumetricFlowRateMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVolumetricFlowRateMeasure_WrappedValue() {
		return (EAttribute) getIfcVolumetricFlowRateMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcVolumetricFlowRateMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcVolumetricFlowRateMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWarpingConstantMeasure() {
		if (ifcWarpingConstantMeasureEClass == null) {
			ifcWarpingConstantMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(761);
		}
		return ifcWarpingConstantMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWarpingConstantMeasure_WrappedValue() {
		return (EAttribute) getIfcWarpingConstantMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWarpingConstantMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcWarpingConstantMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcWarpingMomentMeasure() {
		if (ifcWarpingMomentMeasureEClass == null) {
			ifcWarpingMomentMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(762);
		}
		return ifcWarpingMomentMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWarpingMomentMeasure_WrappedValue() {
		return (EAttribute) getIfcWarpingMomentMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcWarpingMomentMeasure_WrappedValueAsString() {
		return (EAttribute) getIfcWarpingMomentMeasure().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcYearNumber() {
		if (ifcYearNumberEClass == null) {
			ifcYearNumberEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(763);
		}
		return ifcYearNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcYearNumber_WrappedValue() {
		return (EAttribute) getIfcYearNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBoxAlignment() {
		if (ifcBoxAlignmentEClass == null) {
			ifcBoxAlignmentEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(764);
		}
		return ifcBoxAlignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCompoundPlaneAngleMeasure() {
		if (ifcCompoundPlaneAngleMeasureEClass == null) {
			ifcCompoundPlaneAngleMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(765);
		}
		return ifcCompoundPlaneAngleMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcCompoundPlaneAngleMeasure_WrappedValue() {
		return (EAttribute) getIfcCompoundPlaneAngleMeasure().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcNormalisedRatioMeasure() {
		if (ifcNormalisedRatioMeasureEClass == null) {
			ifcNormalisedRatioMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(766);
		}
		return ifcNormalisedRatioMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPositiveLengthMeasure() {
		if (ifcPositiveLengthMeasureEClass == null) {
			ifcPositiveLengthMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(767);
		}
		return ifcPositiveLengthMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPositivePlaneAngleMeasure() {
		if (ifcPositivePlaneAngleMeasureEClass == null) {
			ifcPositivePlaneAngleMeasureEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(768);
		}
		return ifcPositivePlaneAngleMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPositiveRatioMeasure() {
		if (ifcPositiveRatioMeasureEClass == null) {
			ifcPositiveRatioMeasureEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(769);
		}
		return ifcPositiveRatioMeasureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcComplexNumber() {
		if (ifcComplexNumberEClass == null) {
			ifcComplexNumberEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(934);
		}
		return ifcComplexNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcComplexNumber_WrappedValue() {
		return (EAttribute) getIfcComplexNumber().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcComplexNumber_WrappedValueAsString() {
		return (EAttribute) getIfcComplexNumber().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcNullStyle() {
		if (ifcNullStyleEClass == null) {
			ifcNullStyleEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(935);
		}
		return ifcNullStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfcNullStyle_WrappedValue() {
		return (EAttribute) getIfcNullStyle().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcActorSelect() {
		if (ifcActorSelectEClass == null) {
			ifcActorSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(936);
		}
		return ifcActorSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAppliedValueSelect() {
		if (ifcAppliedValueSelectEClass == null) {
			ifcAppliedValueSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(937);
		}
		return ifcAppliedValueSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcAxis2Placement() {
		if (ifcAxis2PlacementEClass == null) {
			ifcAxis2PlacementEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(938);
		}
		return ifcAxis2PlacementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcBooleanOperand() {
		if (ifcBooleanOperandEClass == null) {
			ifcBooleanOperandEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(939);
		}
		return ifcBooleanOperandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCharacterStyleSelect() {
		if (ifcCharacterStyleSelectEClass == null) {
			ifcCharacterStyleSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(940);
		}
		return ifcCharacterStyleSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcClassificationNotationSelect() {
		if (ifcClassificationNotationSelectEClass == null) {
			ifcClassificationNotationSelectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(941);
		}
		return ifcClassificationNotationSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcColour() {
		if (ifcColourEClass == null) {
			ifcColourEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(942);
		}
		return ifcColourEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcColourOrFactor() {
		if (ifcColourOrFactorEClass == null) {
			ifcColourOrFactorEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(943);
		}
		return ifcColourOrFactorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcConditionCriterionSelect() {
		if (ifcConditionCriterionSelectEClass == null) {
			ifcConditionCriterionSelectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(944);
		}
		return ifcConditionCriterionSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCsgSelect() {
		if (ifcCsgSelectEClass == null) {
			ifcCsgSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(945);
		}
		return ifcCsgSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurveFontOrScaledCurveFontSelect() {
		if (ifcCurveFontOrScaledCurveFontSelectEClass == null) {
			ifcCurveFontOrScaledCurveFontSelectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(946);
		}
		return ifcCurveFontOrScaledCurveFontSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurveOrEdgeCurve() {
		if (ifcCurveOrEdgeCurveEClass == null) {
			ifcCurveOrEdgeCurveEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(947);
		}
		return ifcCurveOrEdgeCurveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcCurveStyleFontSelect() {
		if (ifcCurveStyleFontSelectEClass == null) {
			ifcCurveStyleFontSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(948);
		}
		return ifcCurveStyleFontSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDateTimeSelect() {
		if (ifcDateTimeSelectEClass == null) {
			ifcDateTimeSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(949);
		}
		return ifcDateTimeSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDefinedSymbolSelect() {
		if (ifcDefinedSymbolSelectEClass == null) {
			ifcDefinedSymbolSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(950);
		}
		return ifcDefinedSymbolSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDerivedMeasureValue() {
		if (ifcDerivedMeasureValueEClass == null) {
			ifcDerivedMeasureValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(951);
		}
		return ifcDerivedMeasureValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDocumentSelect() {
		if (ifcDocumentSelectEClass == null) {
			ifcDocumentSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(952);
		}
		return ifcDocumentSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcDraughtingCalloutElement() {
		if (ifcDraughtingCalloutElementEClass == null) {
			ifcDraughtingCalloutElementEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(953);
		}
		return ifcDraughtingCalloutElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFillAreaStyleTileShapeSelect() {
		if (ifcFillAreaStyleTileShapeSelectEClass == null) {
			ifcFillAreaStyleTileShapeSelectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(954);
		}
		return ifcFillAreaStyleTileShapeSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcFillStyleSelect() {
		if (ifcFillStyleSelectEClass == null) {
			ifcFillStyleSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(955);
		}
		return ifcFillStyleSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcGeometricSetSelect() {
		if (ifcGeometricSetSelectEClass == null) {
			ifcGeometricSetSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(956);
		}
		return ifcGeometricSetSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcHatchLineDistanceSelect() {
		if (ifcHatchLineDistanceSelectEClass == null) {
			ifcHatchLineDistanceSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(957);
		}
		return ifcHatchLineDistanceSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLayeredItem() {
		if (ifcLayeredItemEClass == null) {
			ifcLayeredItemEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(958);
		}
		return ifcLayeredItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLibrarySelect() {
		if (ifcLibrarySelectEClass == null) {
			ifcLibrarySelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(959);
		}
		return ifcLibrarySelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcLightDistributionDataSourceSelect() {
		if (ifcLightDistributionDataSourceSelectEClass == null) {
			ifcLightDistributionDataSourceSelectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(960);
		}
		return ifcLightDistributionDataSourceSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMaterialSelect() {
		if (ifcMaterialSelectEClass == null) {
			ifcMaterialSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(961);
		}
		return ifcMaterialSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMeasureValue() {
		if (ifcMeasureValueEClass == null) {
			ifcMeasureValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(962);
		}
		return ifcMeasureValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcMetricValueSelect() {
		if (ifcMetricValueSelectEClass == null) {
			ifcMetricValueSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(963);
		}
		return ifcMetricValueSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcObjectReferenceSelect() {
		if (ifcObjectReferenceSelectEClass == null) {
			ifcObjectReferenceSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(964);
		}
		return ifcObjectReferenceSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcOrientationSelect() {
		if (ifcOrientationSelectEClass == null) {
			ifcOrientationSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(965);
		}
		return ifcOrientationSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPointOrVertexPoint() {
		if (ifcPointOrVertexPointEClass == null) {
			ifcPointOrVertexPointEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(966);
		}
		return ifcPointOrVertexPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcPresentationStyleSelect() {
		if (ifcPresentationStyleSelectEClass == null) {
			ifcPresentationStyleSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(967);
		}
		return ifcPresentationStyleSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcShell() {
		if (ifcShellEClass == null) {
			ifcShellEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(968);
		}
		return ifcShellEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSimpleValue() {
		if (ifcSimpleValueEClass == null) {
			ifcSimpleValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(969);
		}
		return ifcSimpleValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSizeSelect() {
		if (ifcSizeSelectEClass == null) {
			ifcSizeSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(970);
		}
		return ifcSizeSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSpecularHighlightSelect() {
		if (ifcSpecularHighlightSelectEClass == null) {
			ifcSpecularHighlightSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(971);
		}
		return ifcSpecularHighlightSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcStructuralActivityAssignmentSelect() {
		if (ifcStructuralActivityAssignmentSelectEClass == null) {
			ifcStructuralActivityAssignmentSelectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(972);
		}
		return ifcStructuralActivityAssignmentSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceOrFaceSurface() {
		if (ifcSurfaceOrFaceSurfaceEClass == null) {
			ifcSurfaceOrFaceSurfaceEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(973);
		}
		return ifcSurfaceOrFaceSurfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSurfaceStyleElementSelect() {
		if (ifcSurfaceStyleElementSelectEClass == null) {
			ifcSurfaceStyleElementSelectEClass = (EClass) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(974);
		}
		return ifcSurfaceStyleElementSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcSymbolStyleSelect() {
		if (ifcSymbolStyleSelectEClass == null) {
			ifcSymbolStyleSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(975);
		}
		return ifcSymbolStyleSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextFontSelect() {
		if (ifcTextFontSelectEClass == null) {
			ifcTextFontSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(976);
		}
		return ifcTextFontSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTextStyleSelect() {
		if (ifcTextStyleSelectEClass == null) {
			ifcTextStyleSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(977);
		}
		return ifcTextStyleSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcTrimmingSelect() {
		if (ifcTrimmingSelectEClass == null) {
			ifcTrimmingSelectEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(978);
		}
		return ifcTrimmingSelectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcUnit() {
		if (ifcUnitEClass == null) {
			ifcUnitEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(979);
		}
		return ifcUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcValue() {
		if (ifcValueEClass == null) {
			ifcValueEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(980);
		}
		return ifcValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfcVectorOrDirection() {
		if (ifcVectorOrDirectionEClass == null) {
			ifcVectorOrDirectionEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(981);
		}
		return ifcVectorOrDirectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTristate() {
		if (tristateEEnum == null) {
			tristateEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers()
					.get(0);
		}
		return tristateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcActionSourceTypeEnum() {
		if (ifcActionSourceTypeEnumEEnum == null) {
			ifcActionSourceTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(770);
		}
		return ifcActionSourceTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcActionTypeEnum() {
		if (ifcActionTypeEnumEEnum == null) {
			ifcActionTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(771);
		}
		return ifcActionTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcActuatorTypeEnum() {
		if (ifcActuatorTypeEnumEEnum == null) {
			ifcActuatorTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(772);
		}
		return ifcActuatorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAddressTypeEnum() {
		if (ifcAddressTypeEnumEEnum == null) {
			ifcAddressTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(773);
		}
		return ifcAddressTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAheadOrBehind() {
		if (ifcAheadOrBehindEEnum == null) {
			ifcAheadOrBehindEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(774);
		}
		return ifcAheadOrBehindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAirTerminalBoxTypeEnum() {
		if (ifcAirTerminalBoxTypeEnumEEnum == null) {
			ifcAirTerminalBoxTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(775);
		}
		return ifcAirTerminalBoxTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAirTerminalTypeEnum() {
		if (ifcAirTerminalTypeEnumEEnum == null) {
			ifcAirTerminalTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(776);
		}
		return ifcAirTerminalTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAirToAirHeatRecoveryTypeEnum() {
		if (ifcAirToAirHeatRecoveryTypeEnumEEnum == null) {
			ifcAirToAirHeatRecoveryTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(777);
		}
		return ifcAirToAirHeatRecoveryTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAlarmTypeEnum() {
		if (ifcAlarmTypeEnumEEnum == null) {
			ifcAlarmTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(778);
		}
		return ifcAlarmTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAnalysisModelTypeEnum() {
		if (ifcAnalysisModelTypeEnumEEnum == null) {
			ifcAnalysisModelTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(779);
		}
		return ifcAnalysisModelTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAnalysisTheoryTypeEnum() {
		if (ifcAnalysisTheoryTypeEnumEEnum == null) {
			ifcAnalysisTheoryTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(780);
		}
		return ifcAnalysisTheoryTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcArithmeticOperatorEnum() {
		if (ifcArithmeticOperatorEnumEEnum == null) {
			ifcArithmeticOperatorEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(781);
		}
		return ifcArithmeticOperatorEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcAssemblyPlaceEnum() {
		if (ifcAssemblyPlaceEnumEEnum == null) {
			ifcAssemblyPlaceEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(782);
		}
		return ifcAssemblyPlaceEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcBSplineCurveForm() {
		if (ifcBSplineCurveFormEEnum == null) {
			ifcBSplineCurveFormEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(783);
		}
		return ifcBSplineCurveFormEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcBeamTypeEnum() {
		if (ifcBeamTypeEnumEEnum == null) {
			ifcBeamTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(784);
		}
		return ifcBeamTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcBenchmarkEnum() {
		if (ifcBenchmarkEnumEEnum == null) {
			ifcBenchmarkEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(785);
		}
		return ifcBenchmarkEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcBoilerTypeEnum() {
		if (ifcBoilerTypeEnumEEnum == null) {
			ifcBoilerTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(786);
		}
		return ifcBoilerTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcBooleanOperator() {
		if (ifcBooleanOperatorEEnum == null) {
			ifcBooleanOperatorEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(787);
		}
		return ifcBooleanOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcBuildingElementProxyTypeEnum() {
		if (ifcBuildingElementProxyTypeEnumEEnum == null) {
			ifcBuildingElementProxyTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(788);
		}
		return ifcBuildingElementProxyTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCableCarrierFittingTypeEnum() {
		if (ifcCableCarrierFittingTypeEnumEEnum == null) {
			ifcCableCarrierFittingTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(789);
		}
		return ifcCableCarrierFittingTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCableCarrierSegmentTypeEnum() {
		if (ifcCableCarrierSegmentTypeEnumEEnum == null) {
			ifcCableCarrierSegmentTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(790);
		}
		return ifcCableCarrierSegmentTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCableSegmentTypeEnum() {
		if (ifcCableSegmentTypeEnumEEnum == null) {
			ifcCableSegmentTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(791);
		}
		return ifcCableSegmentTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcChangeActionEnum() {
		if (ifcChangeActionEnumEEnum == null) {
			ifcChangeActionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(792);
		}
		return ifcChangeActionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcChillerTypeEnum() {
		if (ifcChillerTypeEnumEEnum == null) {
			ifcChillerTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(793);
		}
		return ifcChillerTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCoilTypeEnum() {
		if (ifcCoilTypeEnumEEnum == null) {
			ifcCoilTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(794);
		}
		return ifcCoilTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcColumnTypeEnum() {
		if (ifcColumnTypeEnumEEnum == null) {
			ifcColumnTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(795);
		}
		return ifcColumnTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCompressorTypeEnum() {
		if (ifcCompressorTypeEnumEEnum == null) {
			ifcCompressorTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(796);
		}
		return ifcCompressorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCondenserTypeEnum() {
		if (ifcCondenserTypeEnumEEnum == null) {
			ifcCondenserTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(797);
		}
		return ifcCondenserTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcConnectionTypeEnum() {
		if (ifcConnectionTypeEnumEEnum == null) {
			ifcConnectionTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(798);
		}
		return ifcConnectionTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcConstraintEnum() {
		if (ifcConstraintEnumEEnum == null) {
			ifcConstraintEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(799);
		}
		return ifcConstraintEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcControllerTypeEnum() {
		if (ifcControllerTypeEnumEEnum == null) {
			ifcControllerTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(800);
		}
		return ifcControllerTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCooledBeamTypeEnum() {
		if (ifcCooledBeamTypeEnumEEnum == null) {
			ifcCooledBeamTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(801);
		}
		return ifcCooledBeamTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCoolingTowerTypeEnum() {
		if (ifcCoolingTowerTypeEnumEEnum == null) {
			ifcCoolingTowerTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(802);
		}
		return ifcCoolingTowerTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCostScheduleTypeEnum() {
		if (ifcCostScheduleTypeEnumEEnum == null) {
			ifcCostScheduleTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(803);
		}
		return ifcCostScheduleTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCoveringTypeEnum() {
		if (ifcCoveringTypeEnumEEnum == null) {
			ifcCoveringTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(804);
		}
		return ifcCoveringTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCurrencyEnum() {
		if (ifcCurrencyEnumEEnum == null) {
			ifcCurrencyEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(805);
		}
		return ifcCurrencyEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcCurtainWallTypeEnum() {
		if (ifcCurtainWallTypeEnumEEnum == null) {
			ifcCurtainWallTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(806);
		}
		return ifcCurtainWallTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDamperTypeEnum() {
		if (ifcDamperTypeEnumEEnum == null) {
			ifcDamperTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(807);
		}
		return ifcDamperTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDataOriginEnum() {
		if (ifcDataOriginEnumEEnum == null) {
			ifcDataOriginEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(808);
		}
		return ifcDataOriginEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDerivedUnitEnum() {
		if (ifcDerivedUnitEnumEEnum == null) {
			ifcDerivedUnitEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(809);
		}
		return ifcDerivedUnitEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDimensionExtentUsage() {
		if (ifcDimensionExtentUsageEEnum == null) {
			ifcDimensionExtentUsageEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(810);
		}
		return ifcDimensionExtentUsageEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDirectionSenseEnum() {
		if (ifcDirectionSenseEnumEEnum == null) {
			ifcDirectionSenseEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(811);
		}
		return ifcDirectionSenseEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDistributionChamberElementTypeEnum() {
		if (ifcDistributionChamberElementTypeEnumEEnum == null) {
			ifcDistributionChamberElementTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(812);
		}
		return ifcDistributionChamberElementTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDocumentConfidentialityEnum() {
		if (ifcDocumentConfidentialityEnumEEnum == null) {
			ifcDocumentConfidentialityEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(813);
		}
		return ifcDocumentConfidentialityEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDocumentStatusEnum() {
		if (ifcDocumentStatusEnumEEnum == null) {
			ifcDocumentStatusEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(814);
		}
		return ifcDocumentStatusEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDoorPanelOperationEnum() {
		if (ifcDoorPanelOperationEnumEEnum == null) {
			ifcDoorPanelOperationEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(815);
		}
		return ifcDoorPanelOperationEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDoorPanelPositionEnum() {
		if (ifcDoorPanelPositionEnumEEnum == null) {
			ifcDoorPanelPositionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(816);
		}
		return ifcDoorPanelPositionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDoorStyleConstructionEnum() {
		if (ifcDoorStyleConstructionEnumEEnum == null) {
			ifcDoorStyleConstructionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(817);
		}
		return ifcDoorStyleConstructionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDoorStyleOperationEnum() {
		if (ifcDoorStyleOperationEnumEEnum == null) {
			ifcDoorStyleOperationEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(818);
		}
		return ifcDoorStyleOperationEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDuctFittingTypeEnum() {
		if (ifcDuctFittingTypeEnumEEnum == null) {
			ifcDuctFittingTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(819);
		}
		return ifcDuctFittingTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDuctSegmentTypeEnum() {
		if (ifcDuctSegmentTypeEnumEEnum == null) {
			ifcDuctSegmentTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(820);
		}
		return ifcDuctSegmentTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcDuctSilencerTypeEnum() {
		if (ifcDuctSilencerTypeEnumEEnum == null) {
			ifcDuctSilencerTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(821);
		}
		return ifcDuctSilencerTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElectricApplianceTypeEnum() {
		if (ifcElectricApplianceTypeEnumEEnum == null) {
			ifcElectricApplianceTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(822);
		}
		return ifcElectricApplianceTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElectricCurrentEnum() {
		if (ifcElectricCurrentEnumEEnum == null) {
			ifcElectricCurrentEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(823);
		}
		return ifcElectricCurrentEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElectricDistributionPointFunctionEnum() {
		if (ifcElectricDistributionPointFunctionEnumEEnum == null) {
			ifcElectricDistributionPointFunctionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(824);
		}
		return ifcElectricDistributionPointFunctionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElectricFlowStorageDeviceTypeEnum() {
		if (ifcElectricFlowStorageDeviceTypeEnumEEnum == null) {
			ifcElectricFlowStorageDeviceTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(825);
		}
		return ifcElectricFlowStorageDeviceTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElectricGeneratorTypeEnum() {
		if (ifcElectricGeneratorTypeEnumEEnum == null) {
			ifcElectricGeneratorTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(826);
		}
		return ifcElectricGeneratorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElectricHeaterTypeEnum() {
		if (ifcElectricHeaterTypeEnumEEnum == null) {
			ifcElectricHeaterTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(827);
		}
		return ifcElectricHeaterTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElectricMotorTypeEnum() {
		if (ifcElectricMotorTypeEnumEEnum == null) {
			ifcElectricMotorTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(828);
		}
		return ifcElectricMotorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElectricTimeControlTypeEnum() {
		if (ifcElectricTimeControlTypeEnumEEnum == null) {
			ifcElectricTimeControlTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(829);
		}
		return ifcElectricTimeControlTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElementAssemblyTypeEnum() {
		if (ifcElementAssemblyTypeEnumEEnum == null) {
			ifcElementAssemblyTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(830);
		}
		return ifcElementAssemblyTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcElementCompositionEnum() {
		if (ifcElementCompositionEnumEEnum == null) {
			ifcElementCompositionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(831);
		}
		return ifcElementCompositionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcEnergySequenceEnum() {
		if (ifcEnergySequenceEnumEEnum == null) {
			ifcEnergySequenceEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(832);
		}
		return ifcEnergySequenceEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcEnvironmentalImpactCategoryEnum() {
		if (ifcEnvironmentalImpactCategoryEnumEEnum == null) {
			ifcEnvironmentalImpactCategoryEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(833);
		}
		return ifcEnvironmentalImpactCategoryEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcEvaporativeCoolerTypeEnum() {
		if (ifcEvaporativeCoolerTypeEnumEEnum == null) {
			ifcEvaporativeCoolerTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(834);
		}
		return ifcEvaporativeCoolerTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcEvaporatorTypeEnum() {
		if (ifcEvaporatorTypeEnumEEnum == null) {
			ifcEvaporatorTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(835);
		}
		return ifcEvaporatorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcFanTypeEnum() {
		if (ifcFanTypeEnumEEnum == null) {
			ifcFanTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(836);
		}
		return ifcFanTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcFilterTypeEnum() {
		if (ifcFilterTypeEnumEEnum == null) {
			ifcFilterTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(837);
		}
		return ifcFilterTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcFireSuppressionTerminalTypeEnum() {
		if (ifcFireSuppressionTerminalTypeEnumEEnum == null) {
			ifcFireSuppressionTerminalTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(838);
		}
		return ifcFireSuppressionTerminalTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcFlowDirectionEnum() {
		if (ifcFlowDirectionEnumEEnum == null) {
			ifcFlowDirectionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(839);
		}
		return ifcFlowDirectionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcFlowInstrumentTypeEnum() {
		if (ifcFlowInstrumentTypeEnumEEnum == null) {
			ifcFlowInstrumentTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(840);
		}
		return ifcFlowInstrumentTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcFlowMeterTypeEnum() {
		if (ifcFlowMeterTypeEnumEEnum == null) {
			ifcFlowMeterTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(841);
		}
		return ifcFlowMeterTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcFootingTypeEnum() {
		if (ifcFootingTypeEnumEEnum == null) {
			ifcFootingTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(842);
		}
		return ifcFootingTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcGasTerminalTypeEnum() {
		if (ifcGasTerminalTypeEnumEEnum == null) {
			ifcGasTerminalTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(843);
		}
		return ifcGasTerminalTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcGeometricProjectionEnum() {
		if (ifcGeometricProjectionEnumEEnum == null) {
			ifcGeometricProjectionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(844);
		}
		return ifcGeometricProjectionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcGlobalOrLocalEnum() {
		if (ifcGlobalOrLocalEnumEEnum == null) {
			ifcGlobalOrLocalEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(845);
		}
		return ifcGlobalOrLocalEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcHeatExchangerTypeEnum() {
		if (ifcHeatExchangerTypeEnumEEnum == null) {
			ifcHeatExchangerTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(846);
		}
		return ifcHeatExchangerTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcHumidifierTypeEnum() {
		if (ifcHumidifierTypeEnumEEnum == null) {
			ifcHumidifierTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(847);
		}
		return ifcHumidifierTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcInternalOrExternalEnum() {
		if (ifcInternalOrExternalEnumEEnum == null) {
			ifcInternalOrExternalEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(848);
		}
		return ifcInternalOrExternalEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcInventoryTypeEnum() {
		if (ifcInventoryTypeEnumEEnum == null) {
			ifcInventoryTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(849);
		}
		return ifcInventoryTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcJunctionBoxTypeEnum() {
		if (ifcJunctionBoxTypeEnumEEnum == null) {
			ifcJunctionBoxTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(850);
		}
		return ifcJunctionBoxTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcLampTypeEnum() {
		if (ifcLampTypeEnumEEnum == null) {
			ifcLampTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(851);
		}
		return ifcLampTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcLayerSetDirectionEnum() {
		if (ifcLayerSetDirectionEnumEEnum == null) {
			ifcLayerSetDirectionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(852);
		}
		return ifcLayerSetDirectionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcLightDistributionCurveEnum() {
		if (ifcLightDistributionCurveEnumEEnum == null) {
			ifcLightDistributionCurveEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(853);
		}
		return ifcLightDistributionCurveEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcLightEmissionSourceEnum() {
		if (ifcLightEmissionSourceEnumEEnum == null) {
			ifcLightEmissionSourceEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(854);
		}
		return ifcLightEmissionSourceEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcLightFixtureTypeEnum() {
		if (ifcLightFixtureTypeEnumEEnum == null) {
			ifcLightFixtureTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(855);
		}
		return ifcLightFixtureTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcLoadGroupTypeEnum() {
		if (ifcLoadGroupTypeEnumEEnum == null) {
			ifcLoadGroupTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(856);
		}
		return ifcLoadGroupTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcLogicalOperatorEnum() {
		if (ifcLogicalOperatorEnumEEnum == null) {
			ifcLogicalOperatorEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(857);
		}
		return ifcLogicalOperatorEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcMemberTypeEnum() {
		if (ifcMemberTypeEnumEEnum == null) {
			ifcMemberTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(858);
		}
		return ifcMemberTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcMotorConnectionTypeEnum() {
		if (ifcMotorConnectionTypeEnumEEnum == null) {
			ifcMotorConnectionTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(859);
		}
		return ifcMotorConnectionTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcNullStyleEnum() {
		if (ifcNullStyleEnumEEnum == null) {
			ifcNullStyleEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(860);
		}
		return ifcNullStyleEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcObjectTypeEnum() {
		if (ifcObjectTypeEnumEEnum == null) {
			ifcObjectTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(861);
		}
		return ifcObjectTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcObjectiveEnum() {
		if (ifcObjectiveEnumEEnum == null) {
			ifcObjectiveEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(862);
		}
		return ifcObjectiveEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcOccupantTypeEnum() {
		if (ifcOccupantTypeEnumEEnum == null) {
			ifcOccupantTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(863);
		}
		return ifcOccupantTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcOutletTypeEnum() {
		if (ifcOutletTypeEnumEEnum == null) {
			ifcOutletTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(864);
		}
		return ifcOutletTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPermeableCoveringOperationEnum() {
		if (ifcPermeableCoveringOperationEnumEEnum == null) {
			ifcPermeableCoveringOperationEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(865);
		}
		return ifcPermeableCoveringOperationEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPhysicalOrVirtualEnum() {
		if (ifcPhysicalOrVirtualEnumEEnum == null) {
			ifcPhysicalOrVirtualEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(866);
		}
		return ifcPhysicalOrVirtualEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPileConstructionEnum() {
		if (ifcPileConstructionEnumEEnum == null) {
			ifcPileConstructionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(867);
		}
		return ifcPileConstructionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPileTypeEnum() {
		if (ifcPileTypeEnumEEnum == null) {
			ifcPileTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(868);
		}
		return ifcPileTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPipeFittingTypeEnum() {
		if (ifcPipeFittingTypeEnumEEnum == null) {
			ifcPipeFittingTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(869);
		}
		return ifcPipeFittingTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPipeSegmentTypeEnum() {
		if (ifcPipeSegmentTypeEnumEEnum == null) {
			ifcPipeSegmentTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(870);
		}
		return ifcPipeSegmentTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPlateTypeEnum() {
		if (ifcPlateTypeEnumEEnum == null) {
			ifcPlateTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(871);
		}
		return ifcPlateTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcProcedureTypeEnum() {
		if (ifcProcedureTypeEnumEEnum == null) {
			ifcProcedureTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(872);
		}
		return ifcProcedureTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcProfileTypeEnum() {
		if (ifcProfileTypeEnumEEnum == null) {
			ifcProfileTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(873);
		}
		return ifcProfileTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcProjectOrderRecordTypeEnum() {
		if (ifcProjectOrderRecordTypeEnumEEnum == null) {
			ifcProjectOrderRecordTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(874);
		}
		return ifcProjectOrderRecordTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcProjectOrderTypeEnum() {
		if (ifcProjectOrderTypeEnumEEnum == null) {
			ifcProjectOrderTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(875);
		}
		return ifcProjectOrderTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcProjectedOrTrueLengthEnum() {
		if (ifcProjectedOrTrueLengthEnumEEnum == null) {
			ifcProjectedOrTrueLengthEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(876);
		}
		return ifcProjectedOrTrueLengthEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPropertySourceEnum() {
		if (ifcPropertySourceEnumEEnum == null) {
			ifcPropertySourceEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(877);
		}
		return ifcPropertySourceEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcProtectiveDeviceTypeEnum() {
		if (ifcProtectiveDeviceTypeEnumEEnum == null) {
			ifcProtectiveDeviceTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(878);
		}
		return ifcProtectiveDeviceTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcPumpTypeEnum() {
		if (ifcPumpTypeEnumEEnum == null) {
			ifcPumpTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(879);
		}
		return ifcPumpTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcRailingTypeEnum() {
		if (ifcRailingTypeEnumEEnum == null) {
			ifcRailingTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(880);
		}
		return ifcRailingTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcRampFlightTypeEnum() {
		if (ifcRampFlightTypeEnumEEnum == null) {
			ifcRampFlightTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(881);
		}
		return ifcRampFlightTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcRampTypeEnum() {
		if (ifcRampTypeEnumEEnum == null) {
			ifcRampTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(882);
		}
		return ifcRampTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcReflectanceMethodEnum() {
		if (ifcReflectanceMethodEnumEEnum == null) {
			ifcReflectanceMethodEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(883);
		}
		return ifcReflectanceMethodEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcReinforcingBarRoleEnum() {
		if (ifcReinforcingBarRoleEnumEEnum == null) {
			ifcReinforcingBarRoleEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(884);
		}
		return ifcReinforcingBarRoleEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcReinforcingBarSurfaceEnum() {
		if (ifcReinforcingBarSurfaceEnumEEnum == null) {
			ifcReinforcingBarSurfaceEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(885);
		}
		return ifcReinforcingBarSurfaceEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcResourceConsumptionEnum() {
		if (ifcResourceConsumptionEnumEEnum == null) {
			ifcResourceConsumptionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(886);
		}
		return ifcResourceConsumptionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcRibPlateDirectionEnum() {
		if (ifcRibPlateDirectionEnumEEnum == null) {
			ifcRibPlateDirectionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(887);
		}
		return ifcRibPlateDirectionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcRoleEnum() {
		if (ifcRoleEnumEEnum == null) {
			ifcRoleEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(888);
		}
		return ifcRoleEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcRoofTypeEnum() {
		if (ifcRoofTypeEnumEEnum == null) {
			ifcRoofTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(889);
		}
		return ifcRoofTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSIPrefix() {
		if (ifcSIPrefixEEnum == null) {
			ifcSIPrefixEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(890);
		}
		return ifcSIPrefixEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSIUnitName() {
		if (ifcSIUnitNameEEnum == null) {
			ifcSIUnitNameEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(891);
		}
		return ifcSIUnitNameEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSanitaryTerminalTypeEnum() {
		if (ifcSanitaryTerminalTypeEnumEEnum == null) {
			ifcSanitaryTerminalTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(892);
		}
		return ifcSanitaryTerminalTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSectionTypeEnum() {
		if (ifcSectionTypeEnumEEnum == null) {
			ifcSectionTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(893);
		}
		return ifcSectionTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSensorTypeEnum() {
		if (ifcSensorTypeEnumEEnum == null) {
			ifcSensorTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(894);
		}
		return ifcSensorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSequenceEnum() {
		if (ifcSequenceEnumEEnum == null) {
			ifcSequenceEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(895);
		}
		return ifcSequenceEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcServiceLifeFactorTypeEnum() {
		if (ifcServiceLifeFactorTypeEnumEEnum == null) {
			ifcServiceLifeFactorTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(896);
		}
		return ifcServiceLifeFactorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcServiceLifeTypeEnum() {
		if (ifcServiceLifeTypeEnumEEnum == null) {
			ifcServiceLifeTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(897);
		}
		return ifcServiceLifeTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSlabTypeEnum() {
		if (ifcSlabTypeEnumEEnum == null) {
			ifcSlabTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(898);
		}
		return ifcSlabTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSoundScaleEnum() {
		if (ifcSoundScaleEnumEEnum == null) {
			ifcSoundScaleEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(899);
		}
		return ifcSoundScaleEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSpaceHeaterTypeEnum() {
		if (ifcSpaceHeaterTypeEnumEEnum == null) {
			ifcSpaceHeaterTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(900);
		}
		return ifcSpaceHeaterTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSpaceTypeEnum() {
		if (ifcSpaceTypeEnumEEnum == null) {
			ifcSpaceTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(901);
		}
		return ifcSpaceTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcStackTerminalTypeEnum() {
		if (ifcStackTerminalTypeEnumEEnum == null) {
			ifcStackTerminalTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(902);
		}
		return ifcStackTerminalTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcStairFlightTypeEnum() {
		if (ifcStairFlightTypeEnumEEnum == null) {
			ifcStairFlightTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(903);
		}
		return ifcStairFlightTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcStairTypeEnum() {
		if (ifcStairTypeEnumEEnum == null) {
			ifcStairTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(904);
		}
		return ifcStairTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcStateEnum() {
		if (ifcStateEnumEEnum == null) {
			ifcStateEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(905);
		}
		return ifcStateEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcStructuralCurveTypeEnum() {
		if (ifcStructuralCurveTypeEnumEEnum == null) {
			ifcStructuralCurveTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(906);
		}
		return ifcStructuralCurveTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcStructuralSurfaceTypeEnum() {
		if (ifcStructuralSurfaceTypeEnumEEnum == null) {
			ifcStructuralSurfaceTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(907);
		}
		return ifcStructuralSurfaceTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSurfaceSide() {
		if (ifcSurfaceSideEEnum == null) {
			ifcSurfaceSideEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(908);
		}
		return ifcSurfaceSideEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSurfaceTextureEnum() {
		if (ifcSurfaceTextureEnumEEnum == null) {
			ifcSurfaceTextureEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(909);
		}
		return ifcSurfaceTextureEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcSwitchingDeviceTypeEnum() {
		if (ifcSwitchingDeviceTypeEnumEEnum == null) {
			ifcSwitchingDeviceTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(910);
		}
		return ifcSwitchingDeviceTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTankTypeEnum() {
		if (ifcTankTypeEnumEEnum == null) {
			ifcTankTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(911);
		}
		return ifcTankTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTendonTypeEnum() {
		if (ifcTendonTypeEnumEEnum == null) {
			ifcTendonTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(912);
		}
		return ifcTendonTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTextPath() {
		if (ifcTextPathEEnum == null) {
			ifcTextPathEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(913);
		}
		return ifcTextPathEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcThermalLoadSourceEnum() {
		if (ifcThermalLoadSourceEnumEEnum == null) {
			ifcThermalLoadSourceEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(914);
		}
		return ifcThermalLoadSourceEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcThermalLoadTypeEnum() {
		if (ifcThermalLoadTypeEnumEEnum == null) {
			ifcThermalLoadTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(915);
		}
		return ifcThermalLoadTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTimeSeriesDataTypeEnum() {
		if (ifcTimeSeriesDataTypeEnumEEnum == null) {
			ifcTimeSeriesDataTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(916);
		}
		return ifcTimeSeriesDataTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTimeSeriesScheduleTypeEnum() {
		if (ifcTimeSeriesScheduleTypeEnumEEnum == null) {
			ifcTimeSeriesScheduleTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(917);
		}
		return ifcTimeSeriesScheduleTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTransformerTypeEnum() {
		if (ifcTransformerTypeEnumEEnum == null) {
			ifcTransformerTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(918);
		}
		return ifcTransformerTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTransitionCode() {
		if (ifcTransitionCodeEEnum == null) {
			ifcTransitionCodeEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(919);
		}
		return ifcTransitionCodeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTransportElementTypeEnum() {
		if (ifcTransportElementTypeEnumEEnum == null) {
			ifcTransportElementTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(920);
		}
		return ifcTransportElementTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTrimmingPreference() {
		if (ifcTrimmingPreferenceEEnum == null) {
			ifcTrimmingPreferenceEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(921);
		}
		return ifcTrimmingPreferenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcTubeBundleTypeEnum() {
		if (ifcTubeBundleTypeEnumEEnum == null) {
			ifcTubeBundleTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(922);
		}
		return ifcTubeBundleTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcUnitEnum() {
		if (ifcUnitEnumEEnum == null) {
			ifcUnitEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(923);
		}
		return ifcUnitEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcUnitaryEquipmentTypeEnum() {
		if (ifcUnitaryEquipmentTypeEnumEEnum == null) {
			ifcUnitaryEquipmentTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(924);
		}
		return ifcUnitaryEquipmentTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcValveTypeEnum() {
		if (ifcValveTypeEnumEEnum == null) {
			ifcValveTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(925);
		}
		return ifcValveTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcVibrationIsolatorTypeEnum() {
		if (ifcVibrationIsolatorTypeEnumEEnum == null) {
			ifcVibrationIsolatorTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(926);
		}
		return ifcVibrationIsolatorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcWallTypeEnum() {
		if (ifcWallTypeEnumEEnum == null) {
			ifcWallTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(927);
		}
		return ifcWallTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcWasteTerminalTypeEnum() {
		if (ifcWasteTerminalTypeEnumEEnum == null) {
			ifcWasteTerminalTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(928);
		}
		return ifcWasteTerminalTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcWindowPanelOperationEnum() {
		if (ifcWindowPanelOperationEnumEEnum == null) {
			ifcWindowPanelOperationEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(929);
		}
		return ifcWindowPanelOperationEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcWindowPanelPositionEnum() {
		if (ifcWindowPanelPositionEnumEEnum == null) {
			ifcWindowPanelPositionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(930);
		}
		return ifcWindowPanelPositionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcWindowStyleConstructionEnum() {
		if (ifcWindowStyleConstructionEnumEEnum == null) {
			ifcWindowStyleConstructionEnumEEnum = (EEnum) EPackage.Registry.INSTANCE
					.getEPackage(Ifc2x3tc1Package.eNS_URI).getEClassifiers().get(931);
		}
		return ifcWindowStyleConstructionEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcWindowStyleOperationEnum() {
		if (ifcWindowStyleOperationEnumEEnum == null) {
			ifcWindowStyleOperationEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(932);
		}
		return ifcWindowStyleOperationEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIfcWorkControlTypeEnum() {
		if (ifcWorkControlTypeEnumEEnum == null) {
			ifcWorkControlTypeEnumEEnum = (EEnum) EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
					.getEClassifiers().get(933);
		}
		return ifcWorkControlTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ifc2x3tc1Factory getIfc2x3tc1Factory() {
		return (Ifc2x3tc1Factory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded)
			return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		} catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage) resource.getContents().get(0));
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed)
			return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.bimserver.models.ifc2x3tc1." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //Ifc2x3tc1PackageImpl
