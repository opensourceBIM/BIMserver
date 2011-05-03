/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.*;

import org.bimserver.models.ifc2x3.impl.Ifc2DCompositeCurveImpl;
import org.bimserver.models.ifc2x3.impl.Ifc2x3PackageImpl;
import org.bimserver.models.ifc2x3.impl.IfcAbsorbedDoseMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcAccelerationMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcActionRequestImpl;
import org.bimserver.models.ifc2x3.impl.IfcActorImpl;
import org.bimserver.models.ifc2x3.impl.IfcActorRoleImpl;
import org.bimserver.models.ifc2x3.impl.IfcActuatorTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcAddressImpl;
import org.bimserver.models.ifc2x3.impl.IfcAirTerminalBoxTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcAirTerminalTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcAirToAirHeatRecoveryTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcAlarmTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcAmountOfSubstanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcAngularDimensionImpl;
import org.bimserver.models.ifc2x3.impl.IfcAngularVelocityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationCurveOccurrenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationFillAreaImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationFillAreaOccurrenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationOccurrenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationSurfaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationSurfaceOccurrenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationSymbolOccurrenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcAnnotationTextOccurrenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcApplicationImpl;
import org.bimserver.models.ifc2x3.impl.IfcAppliedValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcAppliedValueRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcApprovalActorRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcApprovalImpl;
import org.bimserver.models.ifc2x3.impl.IfcApprovalPropertyRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcApprovalRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcArbitraryClosedProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcArbitraryOpenProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcArbitraryProfileDefWithVoidsImpl;
import org.bimserver.models.ifc2x3.impl.IfcAreaMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcAssetImpl;
import org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcAxis1PlacementImpl;
import org.bimserver.models.ifc2x3.impl.IfcAxis2Placement2DImpl;
import org.bimserver.models.ifc2x3.impl.IfcAxis2Placement3DImpl;
import org.bimserver.models.ifc2x3.impl.IfcBSplineCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcBeamImpl;
import org.bimserver.models.ifc2x3.impl.IfcBeamTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcBezierCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcBlobTextureImpl;
import org.bimserver.models.ifc2x3.impl.IfcBlockImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoilerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcBooleanClippingResultImpl;
import org.bimserver.models.ifc2x3.impl.IfcBooleanImpl;
import org.bimserver.models.ifc2x3.impl.IfcBooleanResultImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoundaryConditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoundaryFaceConditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionWarpingImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoundedCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoundedSurfaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoundingBoxImpl;
import org.bimserver.models.ifc2x3.impl.IfcBoxedHalfSpaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcBuildingElementComponentImpl;
import org.bimserver.models.ifc2x3.impl.IfcBuildingElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcBuildingElementPartImpl;
import org.bimserver.models.ifc2x3.impl.IfcBuildingElementProxyImpl;
import org.bimserver.models.ifc2x3.impl.IfcBuildingElementProxyTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcBuildingElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcBuildingImpl;
import org.bimserver.models.ifc2x3.impl.IfcBuildingStoreyImpl;
import org.bimserver.models.ifc2x3.impl.IfcCShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcCableCarrierFittingTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCableCarrierSegmentTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCableSegmentTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCalendarDateImpl;
import org.bimserver.models.ifc2x3.impl.IfcCartesianPointImpl;
import org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator2DImpl;
import org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator2DnonUniformImpl;
import org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator3DImpl;
import org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperator3DnonUniformImpl;
import org.bimserver.models.ifc2x3.impl.IfcCartesianTransformationOperatorImpl;
import org.bimserver.models.ifc2x3.impl.IfcCenterLineProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcChamferEdgeFeatureImpl;
import org.bimserver.models.ifc2x3.impl.IfcChillerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCircleHollowProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcCircleImpl;
import org.bimserver.models.ifc2x3.impl.IfcCircleProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcClassificationImpl;
import org.bimserver.models.ifc2x3.impl.IfcClassificationItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcClassificationItemRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcClassificationNotationFacetImpl;
import org.bimserver.models.ifc2x3.impl.IfcClassificationNotationImpl;
import org.bimserver.models.ifc2x3.impl.IfcClassificationReferenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcClosedShellImpl;
import org.bimserver.models.ifc2x3.impl.IfcCoilTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcColourRgbImpl;
import org.bimserver.models.ifc2x3.impl.IfcColourSpecificationImpl;
import org.bimserver.models.ifc2x3.impl.IfcColumnImpl;
import org.bimserver.models.ifc2x3.impl.IfcColumnTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcComplexPropertyImpl;
import org.bimserver.models.ifc2x3.impl.IfcCompositeCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcCompositeCurveSegmentImpl;
import org.bimserver.models.ifc2x3.impl.IfcCompositeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcCompressorTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCondenserTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcConditionCriterionImpl;
import org.bimserver.models.ifc2x3.impl.IfcConditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcConicImpl;
import org.bimserver.models.ifc2x3.impl.IfcConnectedFaceSetImpl;
import org.bimserver.models.ifc2x3.impl.IfcConnectionCurveGeometryImpl;
import org.bimserver.models.ifc2x3.impl.IfcConnectionGeometryImpl;
import org.bimserver.models.ifc2x3.impl.IfcConnectionPointEccentricityImpl;
import org.bimserver.models.ifc2x3.impl.IfcConnectionPointGeometryImpl;
import org.bimserver.models.ifc2x3.impl.IfcConnectionPortGeometryImpl;
import org.bimserver.models.ifc2x3.impl.IfcConnectionSurfaceGeometryImpl;
import org.bimserver.models.ifc2x3.impl.IfcConstraintAggregationRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcConstraintClassificationRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcConstraintImpl;
import org.bimserver.models.ifc2x3.impl.IfcConstraintRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcConstructionEquipmentResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcConstructionMaterialResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcConstructionProductResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcConstructionResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcContextDependentMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcContextDependentUnitImpl;
import org.bimserver.models.ifc2x3.impl.IfcControlImpl;
import org.bimserver.models.ifc2x3.impl.IfcControllerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcConversionBasedUnitImpl;
import org.bimserver.models.ifc2x3.impl.IfcCooledBeamTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCoolingTowerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCoordinatedUniversalTimeOffsetImpl;
import org.bimserver.models.ifc2x3.impl.IfcCostItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcCostScheduleImpl;
import org.bimserver.models.ifc2x3.impl.IfcCostValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcCountMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcCoveringImpl;
import org.bimserver.models.ifc2x3.impl.IfcCoveringTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCraneRailAShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcCraneRailFShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcCrewResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcCsgPrimitive3DImpl;
import org.bimserver.models.ifc2x3.impl.IfcCsgSolidImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurrencyRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurtainWallImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurtainWallTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurvatureMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurveBoundedPlaneImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontAndScalingImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurveStyleFontPatternImpl;
import org.bimserver.models.ifc2x3.impl.IfcCurveStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcDamperTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDateAndTimeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDefinedSymbolImpl;
import org.bimserver.models.ifc2x3.impl.IfcDerivedProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcDerivedUnitElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcDerivedUnitImpl;
import org.bimserver.models.ifc2x3.impl.IfcDescriptiveMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcDiameterDimensionImpl;
import org.bimserver.models.ifc2x3.impl.IfcDimensionCalloutRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcDimensionCurveDirectedCalloutImpl;
import org.bimserver.models.ifc2x3.impl.IfcDimensionCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcDimensionCurveTerminatorImpl;
import org.bimserver.models.ifc2x3.impl.IfcDimensionPairImpl;
import org.bimserver.models.ifc2x3.impl.IfcDimensionalExponentsImpl;
import org.bimserver.models.ifc2x3.impl.IfcDirectionImpl;
import org.bimserver.models.ifc2x3.impl.IfcDiscreteAccessoryImpl;
import org.bimserver.models.ifc2x3.impl.IfcDiscreteAccessoryTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionChamberElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionChamberElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionControlElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionControlElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionFlowElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionFlowElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDistributionPortImpl;
import org.bimserver.models.ifc2x3.impl.IfcDocumentElectronicFormatImpl;
import org.bimserver.models.ifc2x3.impl.IfcDocumentInformationImpl;
import org.bimserver.models.ifc2x3.impl.IfcDocumentInformationRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcDocumentReferenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcDoorImpl;
import org.bimserver.models.ifc2x3.impl.IfcDoorLiningPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcDoorPanelPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcDoorStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcDoseEquivalentMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutImpl;
import org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcDraughtingPreDefinedColourImpl;
import org.bimserver.models.ifc2x3.impl.IfcDraughtingPreDefinedCurveFontImpl;
import org.bimserver.models.ifc2x3.impl.IfcDraughtingPreDefinedTextFontImpl;
import org.bimserver.models.ifc2x3.impl.IfcDuctFittingTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDuctSegmentTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDuctSilencerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcDynamicViscosityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcEdgeCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcEdgeFeatureImpl;
import org.bimserver.models.ifc2x3.impl.IfcEdgeImpl;
import org.bimserver.models.ifc2x3.impl.IfcEdgeLoopImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricApplianceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricCapacitanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricChargeMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricConductanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricCurrentMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricDistributionPointImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricFlowStorageDeviceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricGeneratorTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricHeaterTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricMotorTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricResistanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricTimeControlTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricVoltageMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricalBasePropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricalCircuitImpl;
import org.bimserver.models.ifc2x3.impl.IfcElectricalElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcElementAssemblyImpl;
import org.bimserver.models.ifc2x3.impl.IfcElementComponentImpl;
import org.bimserver.models.ifc2x3.impl.IfcElementComponentTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcElementQuantityImpl;
import org.bimserver.models.ifc2x3.impl.IfcElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcElementarySurfaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcEllipseImpl;
import org.bimserver.models.ifc2x3.impl.IfcEllipseProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcEnergyConversionDeviceImpl;
import org.bimserver.models.ifc2x3.impl.IfcEnergyConversionDeviceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcEnergyMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcEnergyPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcEnvironmentalImpactValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcEquipmentElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcEquipmentStandardImpl;
import org.bimserver.models.ifc2x3.impl.IfcEvaporativeCoolerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcEvaporatorTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcExtendedMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcExternalReferenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcExternallyDefinedHatchStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcExternallyDefinedSurfaceStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcExternallyDefinedSymbolImpl;
import org.bimserver.models.ifc2x3.impl.IfcExternallyDefinedTextFontImpl;
import org.bimserver.models.ifc2x3.impl.IfcExtrudedAreaSolidImpl;
import org.bimserver.models.ifc2x3.impl.IfcFaceBasedSurfaceModelImpl;
import org.bimserver.models.ifc2x3.impl.IfcFaceBoundImpl;
import org.bimserver.models.ifc2x3.impl.IfcFaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcFaceOuterBoundImpl;
import org.bimserver.models.ifc2x3.impl.IfcFaceSurfaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcFacetedBrepImpl;
import org.bimserver.models.ifc2x3.impl.IfcFacetedBrepWithVoidsImpl;
import org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcFanTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFastenerImpl;
import org.bimserver.models.ifc2x3.impl.IfcFastenerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFeatureElementAdditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcFeatureElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcFeatureElementSubtractionImpl;
import org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleHatchingImpl;
import org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleTileSymbolWithStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcFillAreaStyleTilesImpl;
import org.bimserver.models.ifc2x3.impl.IfcFilterTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFireSuppressionTerminalTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowControllerImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowControllerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowFittingImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowFittingTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowInstrumentTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowMeterTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowMovingDeviceImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowMovingDeviceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowSegmentImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowSegmentTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowStorageDeviceImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowStorageDeviceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowTerminalImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowTerminalTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowTreatmentDeviceImpl;
import org.bimserver.models.ifc2x3.impl.IfcFlowTreatmentDeviceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFluidFlowPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcFootingImpl;
import org.bimserver.models.ifc2x3.impl.IfcForceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcFrequencyMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcFuelPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcFurnishingElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcFurnishingElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcFurnitureStandardImpl;
import org.bimserver.models.ifc2x3.impl.IfcFurnitureTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcGasTerminalTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcGeneralMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcGeneralProfilePropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcGeometricCurveSetImpl;
import org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationContextImpl;
import org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationSubContextImpl;
import org.bimserver.models.ifc2x3.impl.IfcGeometricSetImpl;
import org.bimserver.models.ifc2x3.impl.IfcGloballyUniqueIdImpl;
import org.bimserver.models.ifc2x3.impl.IfcGridAxisImpl;
import org.bimserver.models.ifc2x3.impl.IfcGridImpl;
import org.bimserver.models.ifc2x3.impl.IfcGridPlacementImpl;
import org.bimserver.models.ifc2x3.impl.IfcGroupImpl;
import org.bimserver.models.ifc2x3.impl.IfcHalfSpaceSolidImpl;
import org.bimserver.models.ifc2x3.impl.IfcHeatExchangerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcHeatFluxDensityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcHeatingValueMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcHumidifierTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcIShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcIdentifierImpl;
import org.bimserver.models.ifc2x3.impl.IfcIlluminanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcImageTextureImpl;
import org.bimserver.models.ifc2x3.impl.IfcInductanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcIntegerCountRateMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcIntegerImpl;
import org.bimserver.models.ifc2x3.impl.IfcInventoryImpl;
import org.bimserver.models.ifc2x3.impl.IfcIonConcentrationMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcIrregularTimeSeriesImpl;
import org.bimserver.models.ifc2x3.impl.IfcIrregularTimeSeriesValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcIsothermalMoistureCapacityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcJunctionBoxTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcKinematicViscosityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcLShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcLabelImpl;
import org.bimserver.models.ifc2x3.impl.IfcLaborResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcLampTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcLengthMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcLibraryInformationImpl;
import org.bimserver.models.ifc2x3.impl.IfcLibraryReferenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightDistributionDataImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightFixtureTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightIntensityDistributionImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightSourceAmbientImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightSourceDirectionalImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightSourceGoniometricImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightSourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl;
import org.bimserver.models.ifc2x3.impl.IfcLightSourceSpotImpl;
import org.bimserver.models.ifc2x3.impl.IfcLineImpl;
import org.bimserver.models.ifc2x3.impl.IfcLinearDimensionImpl;
import org.bimserver.models.ifc2x3.impl.IfcLinearForceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcLinearMomentMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcLinearStiffnessMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcLinearVelocityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcLocalPlacementImpl;
import org.bimserver.models.ifc2x3.impl.IfcLocalTimeImpl;
import org.bimserver.models.ifc2x3.impl.IfcLogicalImpl;
import org.bimserver.models.ifc2x3.impl.IfcLoopImpl;
import org.bimserver.models.ifc2x3.impl.IfcLuminousFluxMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcLuminousIntensityDistributionMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcLuminousIntensityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMagneticFluxDensityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMagneticFluxMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcManifoldSolidBrepImpl;
import org.bimserver.models.ifc2x3.impl.IfcMappedItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcMassDensityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMassFlowRateMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMassMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMassPerLengthMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMaterialClassificationRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcMaterialDefinitionRepresentationImpl;
import org.bimserver.models.ifc2x3.impl.IfcMaterialImpl;
import org.bimserver.models.ifc2x3.impl.IfcMaterialLayerImpl;
import org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetImpl;
import org.bimserver.models.ifc2x3.impl.IfcMaterialLayerSetUsageImpl;
import org.bimserver.models.ifc2x3.impl.IfcMaterialListImpl;
import org.bimserver.models.ifc2x3.impl.IfcMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcMeasureWithUnitImpl;
import org.bimserver.models.ifc2x3.impl.IfcMechanicalConcreteMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcMechanicalFastenerImpl;
import org.bimserver.models.ifc2x3.impl.IfcMechanicalFastenerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcMechanicalMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcMechanicalSteelMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcMemberImpl;
import org.bimserver.models.ifc2x3.impl.IfcMemberTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcMetricImpl;
import org.bimserver.models.ifc2x3.impl.IfcModulusOfElasticityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcModulusOfLinearSubgradeReactionMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcModulusOfRotationalSubgradeReactionMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcModulusOfSubgradeReactionMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMoistureDiffusivityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMolecularWeightMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMomentOfInertiaMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMonetaryMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcMonetaryUnitImpl;
import org.bimserver.models.ifc2x3.impl.IfcMotorConnectionTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcMoveImpl;
import org.bimserver.models.ifc2x3.impl.IfcNamedUnitImpl;
import org.bimserver.models.ifc2x3.impl.IfcNormalisedRatioMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcNumericMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcObjectDefinitionImpl;
import org.bimserver.models.ifc2x3.impl.IfcObjectImpl;
import org.bimserver.models.ifc2x3.impl.IfcObjectPlacementImpl;
import org.bimserver.models.ifc2x3.impl.IfcObjectiveImpl;
import org.bimserver.models.ifc2x3.impl.IfcOccupantImpl;
import org.bimserver.models.ifc2x3.impl.IfcOffsetCurve2DImpl;
import org.bimserver.models.ifc2x3.impl.IfcOffsetCurve3DImpl;
import org.bimserver.models.ifc2x3.impl.IfcOneDirectionRepeatFactorImpl;
import org.bimserver.models.ifc2x3.impl.IfcOpenShellImpl;
import org.bimserver.models.ifc2x3.impl.IfcOpeningElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcOpticalMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcOrderActionImpl;
import org.bimserver.models.ifc2x3.impl.IfcOrganizationImpl;
import org.bimserver.models.ifc2x3.impl.IfcOrganizationRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcOrientedEdgeImpl;
import org.bimserver.models.ifc2x3.impl.IfcOutletTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcOwnerHistoryImpl;
import org.bimserver.models.ifc2x3.impl.IfcPHMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcParameterValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcParameterizedProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcPathImpl;
import org.bimserver.models.ifc2x3.impl.IfcPerformanceHistoryImpl;
import org.bimserver.models.ifc2x3.impl.IfcPermeableCoveringPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcPermitImpl;
import org.bimserver.models.ifc2x3.impl.IfcPersonAndOrganizationImpl;
import org.bimserver.models.ifc2x3.impl.IfcPersonImpl;
import org.bimserver.models.ifc2x3.impl.IfcPhysicalComplexQuantityImpl;
import org.bimserver.models.ifc2x3.impl.IfcPhysicalQuantityImpl;
import org.bimserver.models.ifc2x3.impl.IfcPhysicalSimpleQuantityImpl;
import org.bimserver.models.ifc2x3.impl.IfcPileImpl;
import org.bimserver.models.ifc2x3.impl.IfcPipeFittingTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcPipeSegmentTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcPixelTextureImpl;
import org.bimserver.models.ifc2x3.impl.IfcPlacementImpl;
import org.bimserver.models.ifc2x3.impl.IfcPlanarBoxImpl;
import org.bimserver.models.ifc2x3.impl.IfcPlanarExtentImpl;
import org.bimserver.models.ifc2x3.impl.IfcPlanarForceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcPlaneAngleMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcPlaneImpl;
import org.bimserver.models.ifc2x3.impl.IfcPlateImpl;
import org.bimserver.models.ifc2x3.impl.IfcPlateTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcPointImpl;
import org.bimserver.models.ifc2x3.impl.IfcPointOnCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcPointOnSurfaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcPolyLoopImpl;
import org.bimserver.models.ifc2x3.impl.IfcPolygonalBoundedHalfSpaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcPolylineImpl;
import org.bimserver.models.ifc2x3.impl.IfcPortImpl;
import org.bimserver.models.ifc2x3.impl.IfcPositiveLengthMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcPositivePlaneAngleMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcPositiveRatioMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcPostalAddressImpl;
import org.bimserver.models.ifc2x3.impl.IfcPowerMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcPreDefinedColourImpl;
import org.bimserver.models.ifc2x3.impl.IfcPreDefinedCurveFontImpl;
import org.bimserver.models.ifc2x3.impl.IfcPreDefinedDimensionSymbolImpl;
import org.bimserver.models.ifc2x3.impl.IfcPreDefinedItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcPreDefinedPointMarkerSymbolImpl;
import org.bimserver.models.ifc2x3.impl.IfcPreDefinedSymbolImpl;
import org.bimserver.models.ifc2x3.impl.IfcPreDefinedTerminatorSymbolImpl;
import org.bimserver.models.ifc2x3.impl.IfcPreDefinedTextFontImpl;
import org.bimserver.models.ifc2x3.impl.IfcPresentationLayerAssignmentImpl;
import org.bimserver.models.ifc2x3.impl.IfcPresentationLayerWithStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcPresentationStyleAssignmentImpl;
import org.bimserver.models.ifc2x3.impl.IfcPresentationStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcPressureMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcProcedureImpl;
import org.bimserver.models.ifc2x3.impl.IfcProcessImpl;
import org.bimserver.models.ifc2x3.impl.IfcProductDefinitionShapeImpl;
import org.bimserver.models.ifc2x3.impl.IfcProductImpl;
import org.bimserver.models.ifc2x3.impl.IfcProductRepresentationImpl;
import org.bimserver.models.ifc2x3.impl.IfcProductsOfCombustionPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcProfilePropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcProjectImpl;
import org.bimserver.models.ifc2x3.impl.IfcProjectOrderImpl;
import org.bimserver.models.ifc2x3.impl.IfcProjectOrderRecordImpl;
import org.bimserver.models.ifc2x3.impl.IfcProjectionCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcProjectionElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyBoundedValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyConstraintRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyDefinitionImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyDependencyRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyEnumeratedValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyEnumerationImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyListValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyReferenceValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertySetDefinitionImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertySetImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertySingleValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcPropertyTableValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcProtectiveDeviceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcProxyImpl;
import org.bimserver.models.ifc2x3.impl.IfcPumpTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcQuantityAreaImpl;
import org.bimserver.models.ifc2x3.impl.IfcQuantityCountImpl;
import org.bimserver.models.ifc2x3.impl.IfcQuantityLengthImpl;
import org.bimserver.models.ifc2x3.impl.IfcQuantityTimeImpl;
import org.bimserver.models.ifc2x3.impl.IfcQuantityVolumeImpl;
import org.bimserver.models.ifc2x3.impl.IfcQuantityWeightImpl;
import org.bimserver.models.ifc2x3.impl.IfcRadioActivityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcRadiusDimensionImpl;
import org.bimserver.models.ifc2x3.impl.IfcRailingImpl;
import org.bimserver.models.ifc2x3.impl.IfcRailingTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcRampFlightImpl;
import org.bimserver.models.ifc2x3.impl.IfcRampFlightTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcRampImpl;
import org.bimserver.models.ifc2x3.impl.IfcRatioMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcRationalBezierCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcRealImpl;
import org.bimserver.models.ifc2x3.impl.IfcRectangleHollowProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcRectangleProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcRectangularPyramidImpl;
import org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcReferencesValueDocumentImpl;
import org.bimserver.models.ifc2x3.impl.IfcRegularTimeSeriesImpl;
import org.bimserver.models.ifc2x3.impl.IfcReinforcementBarPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcReinforcementDefinitionPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl;
import org.bimserver.models.ifc2x3.impl.IfcReinforcingElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAggregatesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsTasksImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsToActorImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsToControlImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsToGroupImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsToProcessImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsToProductImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsToProjectOrderImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssignsToResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesAppliedValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesApprovalImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesClassificationImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesConstraintImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesDocumentImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesLibraryImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesMaterialImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelAssociatesProfilePropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsElementsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsPathElementsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsPortToElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsPortsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralActivityImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralMemberImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsWithEccentricityImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelConnectsWithRealizingElementsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelContainedInSpatialStructureImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelCoversBldgElementsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelCoversSpacesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelDecomposesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelDefinesByPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelDefinesByTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelDefinesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelFillsElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelFlowControlElementsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelInteractionRequirementsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelNestsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelOccupiesSpacesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelOverridesPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelProjectsElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelReferencedInSpatialStructureImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelSchedulesCostItemsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelSequenceImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelServicesBuildingsImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelSpaceBoundaryImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelVoidsElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl;
import org.bimserver.models.ifc2x3.impl.IfcRepresentationContextImpl;
import org.bimserver.models.ifc2x3.impl.IfcRepresentationImpl;
import org.bimserver.models.ifc2x3.impl.IfcRepresentationItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcRepresentationMapImpl;
import org.bimserver.models.ifc2x3.impl.IfcResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcRevolvedAreaSolidImpl;
import org.bimserver.models.ifc2x3.impl.IfcRibPlateProfilePropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcRightCircularConeImpl;
import org.bimserver.models.ifc2x3.impl.IfcRightCircularCylinderImpl;
import org.bimserver.models.ifc2x3.impl.IfcRoofImpl;
import org.bimserver.models.ifc2x3.impl.IfcRootImpl;
import org.bimserver.models.ifc2x3.impl.IfcRotationalFrequencyMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcRotationalMassMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcRotationalStiffnessMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcRoundedEdgeFeatureImpl;
import org.bimserver.models.ifc2x3.impl.IfcRoundedRectangleProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcSIUnitImpl;
import org.bimserver.models.ifc2x3.impl.IfcSanitaryTerminalTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcScheduleTimeControlImpl;
import org.bimserver.models.ifc2x3.impl.IfcSectionModulusMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcSectionPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcSectionReinforcementPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcSectionalAreaIntegralMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcSectionedSpineImpl;
import org.bimserver.models.ifc2x3.impl.IfcSensorTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcServiceLifeFactorImpl;
import org.bimserver.models.ifc2x3.impl.IfcServiceLifeImpl;
import org.bimserver.models.ifc2x3.impl.IfcShapeAspectImpl;
import org.bimserver.models.ifc2x3.impl.IfcShapeModelImpl;
import org.bimserver.models.ifc2x3.impl.IfcShapeRepresentationImpl;
import org.bimserver.models.ifc2x3.impl.IfcShearModulusMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcShellBasedSurfaceModelImpl;
import org.bimserver.models.ifc2x3.impl.IfcSimplePropertyImpl;
import org.bimserver.models.ifc2x3.impl.IfcSiteImpl;
import org.bimserver.models.ifc2x3.impl.IfcSlabImpl;
import org.bimserver.models.ifc2x3.impl.IfcSlabTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcSlippageConnectionConditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcSolidAngleMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcSolidModelImpl;
import org.bimserver.models.ifc2x3.impl.IfcSoundPowerMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcSoundPressureMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcSoundPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcSoundValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpaceHeaterTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpaceThermalLoadPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpaceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpecificHeatCapacityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpecularExponentImpl;
import org.bimserver.models.ifc2x3.impl.IfcSpecularRoughnessImpl;
import org.bimserver.models.ifc2x3.impl.IfcSphereImpl;
import org.bimserver.models.ifc2x3.impl.IfcStackTerminalTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcStairFlightImpl;
import org.bimserver.models.ifc2x3.impl.IfcStairFlightTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcStairImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralActionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralActivityImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralAnalysisModelImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralConnectionConditionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralConnectionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralCurveConnectionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralCurveMemberImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralCurveMemberVaryingImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLinearActionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLinearActionVaryingImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadGroupImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadPlanarForceImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementDistortionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleForceImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleForceWarpingImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadStaticImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralLoadTemperatureImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralMemberImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralPlanarActionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralPlanarActionVaryingImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralPointActionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralPointConnectionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralPointReactionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralReactionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceConnectionImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl;
import org.bimserver.models.ifc2x3.impl.IfcStructuredDimensionCalloutImpl;
import org.bimserver.models.ifc2x3.impl.IfcStyleModelImpl;
import org.bimserver.models.ifc2x3.impl.IfcStyledItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcStyledRepresentationImpl;
import org.bimserver.models.ifc2x3.impl.IfcSubContractResourceImpl;
import org.bimserver.models.ifc2x3.impl.IfcSubedgeImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceCurveSweptAreaSolidImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceOfLinearExtrusionImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceOfRevolutionImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleLightingImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRefractionImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRenderingImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleShadingImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleWithTexturesImpl;
import org.bimserver.models.ifc2x3.impl.IfcSurfaceTextureImpl;
import org.bimserver.models.ifc2x3.impl.IfcSweptAreaSolidImpl;
import org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl;
import org.bimserver.models.ifc2x3.impl.IfcSweptSurfaceImpl;
import org.bimserver.models.ifc2x3.impl.IfcSwitchingDeviceTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcSymbolStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcSystemFurnitureElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcSystemImpl;
import org.bimserver.models.ifc2x3.impl.IfcTShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcTableImpl;
import org.bimserver.models.ifc2x3.impl.IfcTableRowImpl;
import org.bimserver.models.ifc2x3.impl.IfcTankTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcTaskImpl;
import org.bimserver.models.ifc2x3.impl.IfcTelecomAddressImpl;
import org.bimserver.models.ifc2x3.impl.IfcTemperatureGradientMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcTendonAnchorImpl;
import org.bimserver.models.ifc2x3.impl.IfcTendonImpl;
import org.bimserver.models.ifc2x3.impl.IfcTerminatorSymbolImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextLiteralImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextLiteralWithExtentImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextStyleFontModelImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextStyleForDefinedFontImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextStyleTextModelImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextStyleWithBoxCharacteristicsImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextureCoordinateGeneratorImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextureCoordinateImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextureMapImpl;
import org.bimserver.models.ifc2x3.impl.IfcTextureVertexImpl;
import org.bimserver.models.ifc2x3.impl.IfcThermalAdmittanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcThermalConductivityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcThermalExpansionCoefficientMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcThermalMaterialPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcThermalResistanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcThermalTransmittanceMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcThermodynamicTemperatureMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcTimeMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcTimeSeriesImpl;
import org.bimserver.models.ifc2x3.impl.IfcTimeSeriesReferenceRelationshipImpl;
import org.bimserver.models.ifc2x3.impl.IfcTimeSeriesScheduleImpl;
import org.bimserver.models.ifc2x3.impl.IfcTimeSeriesValueImpl;
import org.bimserver.models.ifc2x3.impl.IfcTimeStampImpl;
import org.bimserver.models.ifc2x3.impl.IfcTopologicalRepresentationItemImpl;
import org.bimserver.models.ifc2x3.impl.IfcTopologyRepresentationImpl;
import org.bimserver.models.ifc2x3.impl.IfcTorqueMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcTransformerTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcTransportElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcTransportElementTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcTrimmedCurveImpl;
import org.bimserver.models.ifc2x3.impl.IfcTubeBundleTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcTwoDirectionRepeatFactorImpl;
import org.bimserver.models.ifc2x3.impl.IfcTypeObjectImpl;
import org.bimserver.models.ifc2x3.impl.IfcTypeProductImpl;
import org.bimserver.models.ifc2x3.impl.IfcUShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcUnitAssignmentImpl;
import org.bimserver.models.ifc2x3.impl.IfcUnitaryEquipmentTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcValveTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcVaporPermeabilityMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcVectorImpl;
import org.bimserver.models.ifc2x3.impl.IfcVertexBasedTextureMapImpl;
import org.bimserver.models.ifc2x3.impl.IfcVertexImpl;
import org.bimserver.models.ifc2x3.impl.IfcVertexLoopImpl;
import org.bimserver.models.ifc2x3.impl.IfcVertexPointImpl;
import org.bimserver.models.ifc2x3.impl.IfcVibrationIsolatorTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcVirtualElementImpl;
import org.bimserver.models.ifc2x3.impl.IfcVirtualGridIntersectionImpl;
import org.bimserver.models.ifc2x3.impl.IfcVolumeMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcVolumetricFlowRateMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcWallImpl;
import org.bimserver.models.ifc2x3.impl.IfcWallStandardCaseImpl;
import org.bimserver.models.ifc2x3.impl.IfcWallTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcWarpingConstantMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcWarpingMomentMeasureImpl;
import org.bimserver.models.ifc2x3.impl.IfcWasteTerminalTypeImpl;
import org.bimserver.models.ifc2x3.impl.IfcWaterPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcWindowImpl;
import org.bimserver.models.ifc2x3.impl.IfcWindowLiningPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcWindowPanelPropertiesImpl;
import org.bimserver.models.ifc2x3.impl.IfcWindowStyleImpl;
import org.bimserver.models.ifc2x3.impl.IfcWorkControlImpl;
import org.bimserver.models.ifc2x3.impl.IfcWorkPlanImpl;
import org.bimserver.models.ifc2x3.impl.IfcWorkScheduleImpl;
import org.bimserver.models.ifc2x3.impl.IfcZShapeProfileDefImpl;
import org.bimserver.models.ifc2x3.impl.IfcZoneImpl;
import org.bimserver.models.ifc2x3.impl.WrappedValueImpl;

import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.log.ClashDetectionSettingsUpdated;
import org.bimserver.models.log.DatabaseCreated;
import org.bimserver.models.log.Download;
import org.bimserver.models.log.GeoTagUpdated;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.log.LogFactory;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.NewCheckoutAdded;
import org.bimserver.models.log.NewIgnoreFileUploaded;
import org.bimserver.models.log.NewProjectAdded;
import org.bimserver.models.log.NewRevisionAdded;
import org.bimserver.models.log.NewUserAdded;
import org.bimserver.models.log.PasswordChanged;
import org.bimserver.models.log.PasswordReset;
import org.bimserver.models.log.ProjectDeleted;
import org.bimserver.models.log.ProjectUndeleted;
import org.bimserver.models.log.ProjectUpdated;
import org.bimserver.models.log.RevisionUpdated;
import org.bimserver.models.log.ServerLog;
import org.bimserver.models.log.ServerStarted;
import org.bimserver.models.log.SettingsSaved;
import org.bimserver.models.log.UserAddedToProject;
import org.bimserver.models.log.UserChanged;
import org.bimserver.models.log.UserDeleted;
import org.bimserver.models.log.UserRemovedFromProject;
import org.bimserver.models.log.UserUndeleted;

import org.bimserver.models.log.impl.LogPackageImpl;

import org.bimserver.models.store.*;

import org.bimserver.models.store.impl.CheckoutImpl;
import org.bimserver.models.store.impl.ClashDetectionSettingsImpl;
import org.bimserver.models.store.impl.ClashImpl;
import org.bimserver.models.store.impl.ConcreteRevisionImpl;
import org.bimserver.models.store.impl.EidClashImpl;
import org.bimserver.models.store.impl.GeoTagImpl;
import org.bimserver.models.store.impl.GuidClashImpl;
import org.bimserver.models.store.impl.IgnoreFileImpl;
import org.bimserver.models.store.impl.ProjectImpl;
import org.bimserver.models.store.impl.RevisionImpl;
import org.bimserver.models.store.impl.SerializerImpl;
import org.bimserver.models.store.impl.SettingsImpl;
import org.bimserver.models.store.impl.StorePackageImpl;
import org.bimserver.models.store.impl.UserImpl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LogPackageImpl extends EPackageImpl implements LogPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverLogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newUserAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newProjectAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newRevisionAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newCheckoutAddedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settingsSavedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userAddedToProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newIgnoreFileUploadedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass downloadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userRemovedFromProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectDeletedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDeletedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passwordResetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseCreatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serverStartedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectUpdatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userUndeletedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectUndeletedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionUpdatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geoTagUpdatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clashDetectionSettingsUpdatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passwordChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum accessMethodEEnum = null;

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
	 * @see org.bimserver.models.log.LogPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LogPackageImpl()
	{
		super(eNS_URI, LogFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LogPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LogPackage init()
	{
		if (isInited) return (LogPackage)EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI);

		// Obtain or create and register package
		LogPackageImpl theLogPackage = (LogPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LogPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LogPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		StorePackageImpl theStorePackage = (StorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI) instanceof StorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI) : StorePackage.eINSTANCE);
		Ifc2x3PackageImpl theIfc2x3Package = (Ifc2x3PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ifc2x3Package.eNS_URI) instanceof Ifc2x3PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ifc2x3Package.eNS_URI) : Ifc2x3Package.eINSTANCE);

		// Create package meta-data objects
		theLogPackage.createPackageContents();
		theStorePackage.createPackageContents();
		theIfc2x3Package.createPackageContents();

		// Initialize created meta-data
		theLogPackage.initializePackageContents();
		theStorePackage.initializePackageContents();
		theIfc2x3Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLogPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LogPackage.eNS_URI, theLogPackage);
		return theLogPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogAction()
	{
		return logActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogAction_Date()
	{
		return (EAttribute)logActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogAction_Executor()
	{
		return (EReference)logActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLogAction_AccessMethod()
	{
		return (EAttribute)logActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerLog()
	{
		return serverLogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServerLog_Actions()
	{
		return (EReference)serverLogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewUserAdded()
	{
		return newUserAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewUserAdded_User()
	{
		return (EReference)newUserAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewProjectAdded()
	{
		return newProjectAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewProjectAdded_Project()
	{
		return (EReference)newProjectAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewProjectAdded_ParentProject()
	{
		return (EReference)newProjectAddedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewRevisionAdded()
	{
		return newRevisionAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewRevisionAdded_Revision()
	{
		return (EReference)newRevisionAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewCheckoutAdded()
	{
		return newCheckoutAddedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewCheckoutAdded_Checkout()
	{
		return (EReference)newCheckoutAddedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettingsSaved()
	{
		return settingsSavedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserAddedToProject()
	{
		return userAddedToProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserAddedToProject_User()
	{
		return (EReference)userAddedToProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserAddedToProject_Project()
	{
		return (EReference)userAddedToProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewIgnoreFileUploaded()
	{
		return newIgnoreFileUploadedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDownload()
	{
		return downloadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserRemovedFromProject()
	{
		return userRemovedFromProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserRemovedFromProject_User()
	{
		return (EReference)userRemovedFromProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserRemovedFromProject_Project()
	{
		return (EReference)userRemovedFromProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectDeleted()
	{
		return projectDeletedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectDeleted_Project()
	{
		return (EReference)projectDeletedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDeleted()
	{
		return userDeletedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserDeleted_User()
	{
		return (EReference)userDeletedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPasswordReset()
	{
		return passwordResetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPasswordReset_User()
	{
		return (EReference)passwordResetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseCreated()
	{
		return databaseCreatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseCreated_Path()
	{
		return (EAttribute)databaseCreatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDatabaseCreated_Version()
	{
		return (EAttribute)databaseCreatedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServerStarted()
	{
		return serverStartedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectUpdated()
	{
		return projectUpdatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectUpdated_Project()
	{
		return (EReference)projectUpdatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserUndeleted()
	{
		return userUndeletedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserUndeleted_User()
	{
		return (EReference)userUndeletedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectUndeleted()
	{
		return projectUndeletedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProjectUndeleted_Project()
	{
		return (EReference)projectUndeletedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevisionUpdated()
	{
		return revisionUpdatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevisionUpdated_Revision()
	{
		return (EReference)revisionUpdatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeoTagUpdated()
	{
		return geoTagUpdatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeoTagUpdated_GeoTag()
	{
		return (EReference)geoTagUpdatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClashDetectionSettingsUpdated()
	{
		return clashDetectionSettingsUpdatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClashDetectionSettingsUpdated_ClashDetectionSettings()
	{
		return (EReference)clashDetectionSettingsUpdatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPasswordChanged()
	{
		return passwordChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPasswordChanged_User()
	{
		return (EReference)passwordChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserChanged()
	{
		return userChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserChanged_User()
	{
		return (EReference)userChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAccessMethod()
	{
		return accessMethodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogFactory getLogFactory()
	{
		return (LogFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		logActionEClass = createEClass(LOG_ACTION);
		createEAttribute(logActionEClass, LOG_ACTION__DATE);
		createEReference(logActionEClass, LOG_ACTION__EXECUTOR);
		createEAttribute(logActionEClass, LOG_ACTION__ACCESS_METHOD);

		serverLogEClass = createEClass(SERVER_LOG);
		createEReference(serverLogEClass, SERVER_LOG__ACTIONS);

		newUserAddedEClass = createEClass(NEW_USER_ADDED);
		createEReference(newUserAddedEClass, NEW_USER_ADDED__USER);

		newProjectAddedEClass = createEClass(NEW_PROJECT_ADDED);
		createEReference(newProjectAddedEClass, NEW_PROJECT_ADDED__PROJECT);
		createEReference(newProjectAddedEClass, NEW_PROJECT_ADDED__PARENT_PROJECT);

		newRevisionAddedEClass = createEClass(NEW_REVISION_ADDED);
		createEReference(newRevisionAddedEClass, NEW_REVISION_ADDED__REVISION);

		newCheckoutAddedEClass = createEClass(NEW_CHECKOUT_ADDED);
		createEReference(newCheckoutAddedEClass, NEW_CHECKOUT_ADDED__CHECKOUT);

		settingsSavedEClass = createEClass(SETTINGS_SAVED);

		userAddedToProjectEClass = createEClass(USER_ADDED_TO_PROJECT);
		createEReference(userAddedToProjectEClass, USER_ADDED_TO_PROJECT__USER);
		createEReference(userAddedToProjectEClass, USER_ADDED_TO_PROJECT__PROJECT);

		newIgnoreFileUploadedEClass = createEClass(NEW_IGNORE_FILE_UPLOADED);

		downloadEClass = createEClass(DOWNLOAD);

		userRemovedFromProjectEClass = createEClass(USER_REMOVED_FROM_PROJECT);
		createEReference(userRemovedFromProjectEClass, USER_REMOVED_FROM_PROJECT__USER);
		createEReference(userRemovedFromProjectEClass, USER_REMOVED_FROM_PROJECT__PROJECT);

		projectDeletedEClass = createEClass(PROJECT_DELETED);
		createEReference(projectDeletedEClass, PROJECT_DELETED__PROJECT);

		userDeletedEClass = createEClass(USER_DELETED);
		createEReference(userDeletedEClass, USER_DELETED__USER);

		passwordResetEClass = createEClass(PASSWORD_RESET);
		createEReference(passwordResetEClass, PASSWORD_RESET__USER);

		databaseCreatedEClass = createEClass(DATABASE_CREATED);
		createEAttribute(databaseCreatedEClass, DATABASE_CREATED__PATH);
		createEAttribute(databaseCreatedEClass, DATABASE_CREATED__VERSION);

		serverStartedEClass = createEClass(SERVER_STARTED);

		projectUpdatedEClass = createEClass(PROJECT_UPDATED);
		createEReference(projectUpdatedEClass, PROJECT_UPDATED__PROJECT);

		userUndeletedEClass = createEClass(USER_UNDELETED);
		createEReference(userUndeletedEClass, USER_UNDELETED__USER);

		projectUndeletedEClass = createEClass(PROJECT_UNDELETED);
		createEReference(projectUndeletedEClass, PROJECT_UNDELETED__PROJECT);

		revisionUpdatedEClass = createEClass(REVISION_UPDATED);
		createEReference(revisionUpdatedEClass, REVISION_UPDATED__REVISION);

		geoTagUpdatedEClass = createEClass(GEO_TAG_UPDATED);
		createEReference(geoTagUpdatedEClass, GEO_TAG_UPDATED__GEO_TAG);

		clashDetectionSettingsUpdatedEClass = createEClass(CLASH_DETECTION_SETTINGS_UPDATED);
		createEReference(clashDetectionSettingsUpdatedEClass, CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS);

		passwordChangedEClass = createEClass(PASSWORD_CHANGED);
		createEReference(passwordChangedEClass, PASSWORD_CHANGED__USER);

		userChangedEClass = createEClass(USER_CHANGED);
		createEReference(userChangedEClass, USER_CHANGED__USER);

		// Create enums
		accessMethodEEnum = createEEnum(ACCESS_METHOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		StorePackage theStorePackage = (StorePackage)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		newUserAddedEClass.getESuperTypes().add(this.getLogAction());
		newProjectAddedEClass.getESuperTypes().add(this.getLogAction());
		newRevisionAddedEClass.getESuperTypes().add(this.getLogAction());
		newCheckoutAddedEClass.getESuperTypes().add(this.getLogAction());
		settingsSavedEClass.getESuperTypes().add(this.getLogAction());
		userAddedToProjectEClass.getESuperTypes().add(this.getLogAction());
		newIgnoreFileUploadedEClass.getESuperTypes().add(this.getLogAction());
		downloadEClass.getESuperTypes().add(this.getLogAction());
		userRemovedFromProjectEClass.getESuperTypes().add(this.getLogAction());
		projectDeletedEClass.getESuperTypes().add(this.getLogAction());
		userDeletedEClass.getESuperTypes().add(this.getLogAction());
		passwordResetEClass.getESuperTypes().add(this.getLogAction());
		databaseCreatedEClass.getESuperTypes().add(this.getLogAction());
		serverStartedEClass.getESuperTypes().add(this.getLogAction());
		projectUpdatedEClass.getESuperTypes().add(this.getLogAction());
		userUndeletedEClass.getESuperTypes().add(this.getLogAction());
		projectUndeletedEClass.getESuperTypes().add(this.getLogAction());
		revisionUpdatedEClass.getESuperTypes().add(this.getLogAction());
		geoTagUpdatedEClass.getESuperTypes().add(this.getLogAction());
		clashDetectionSettingsUpdatedEClass.getESuperTypes().add(this.getLogAction());
		passwordChangedEClass.getESuperTypes().add(this.getLogAction());
		userChangedEClass.getESuperTypes().add(this.getLogAction());

		// Initialize classes and features; add operations and parameters
		initEClass(logActionEClass, LogAction.class, "LogAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLogAction_Date(), ecorePackage.getEDate(), "date", null, 0, 1, LogAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogAction_Executor(), theStorePackage.getUser(), null, "executor", null, 0, 1, LogAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogAction_AccessMethod(), this.getAccessMethod(), "accessMethod", null, 0, 1, LogAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serverLogEClass, ServerLog.class, "ServerLog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServerLog_Actions(), this.getLogAction(), null, "actions", null, 0, -1, ServerLog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newUserAddedEClass, NewUserAdded.class, "NewUserAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewUserAdded_User(), theStorePackage.getUser(), null, "user", null, 0, 1, NewUserAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newProjectAddedEClass, NewProjectAdded.class, "NewProjectAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewProjectAdded_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, NewProjectAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewProjectAdded_ParentProject(), theStorePackage.getProject(), null, "parentProject", null, 0, 1, NewProjectAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newRevisionAddedEClass, NewRevisionAdded.class, "NewRevisionAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewRevisionAdded_Revision(), theStorePackage.getRevision(), null, "revision", null, 0, 1, NewRevisionAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newCheckoutAddedEClass, NewCheckoutAdded.class, "NewCheckoutAdded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewCheckoutAdded_Checkout(), theStorePackage.getCheckout(), null, "checkout", null, 0, 1, NewCheckoutAdded.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(settingsSavedEClass, SettingsSaved.class, "SettingsSaved", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userAddedToProjectEClass, UserAddedToProject.class, "UserAddedToProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserAddedToProject_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserAddedToProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserAddedToProject_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, UserAddedToProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newIgnoreFileUploadedEClass, NewIgnoreFileUploaded.class, "NewIgnoreFileUploaded", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(downloadEClass, Download.class, "Download", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userRemovedFromProjectEClass, UserRemovedFromProject.class, "UserRemovedFromProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserRemovedFromProject_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserRemovedFromProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserRemovedFromProject_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, UserRemovedFromProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectDeletedEClass, ProjectDeleted.class, "ProjectDeleted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectDeleted_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, ProjectDeleted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDeletedEClass, UserDeleted.class, "UserDeleted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserDeleted_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserDeleted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(passwordResetEClass, PasswordReset.class, "PasswordReset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPasswordReset_User(), theStorePackage.getUser(), null, "user", null, 0, 1, PasswordReset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(databaseCreatedEClass, DatabaseCreated.class, "DatabaseCreated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDatabaseCreated_Path(), ecorePackage.getEString(), "path", null, 0, 1, DatabaseCreated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDatabaseCreated_Version(), ecorePackage.getEInt(), "version", null, 0, 1, DatabaseCreated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serverStartedEClass, ServerStarted.class, "ServerStarted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(projectUpdatedEClass, ProjectUpdated.class, "ProjectUpdated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectUpdated_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, ProjectUpdated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userUndeletedEClass, UserUndeleted.class, "UserUndeleted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserUndeleted_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserUndeleted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectUndeletedEClass, ProjectUndeleted.class, "ProjectUndeleted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectUndeleted_Project(), theStorePackage.getProject(), null, "project", null, 0, 1, ProjectUndeleted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(revisionUpdatedEClass, RevisionUpdated.class, "RevisionUpdated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRevisionUpdated_Revision(), theStorePackage.getRevision(), null, "revision", null, 0, 1, RevisionUpdated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(geoTagUpdatedEClass, GeoTagUpdated.class, "GeoTagUpdated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeoTagUpdated_GeoTag(), theStorePackage.getGeoTag(), null, "geoTag", null, 0, 1, GeoTagUpdated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clashDetectionSettingsUpdatedEClass, ClashDetectionSettingsUpdated.class, "ClashDetectionSettingsUpdated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClashDetectionSettingsUpdated_ClashDetectionSettings(), theStorePackage.getClashDetectionSettings(), null, "clashDetectionSettings", null, 0, 1, ClashDetectionSettingsUpdated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(passwordChangedEClass, PasswordChanged.class, "PasswordChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPasswordChanged_User(), theStorePackage.getUser(), null, "user", null, 0, 1, PasswordChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userChangedEClass, UserChanged.class, "UserChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserChanged_User(), theStorePackage.getUser(), null, "user", null, 0, 1, UserChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(accessMethodEEnum, AccessMethod.class, "AccessMethod");
		addEEnumLiteral(accessMethodEEnum, AccessMethod.SOAP_LITERAL);
		addEEnumLiteral(accessMethodEEnum, AccessMethod.WEB_INTERFACE_LITERAL);
		addEEnumLiteral(accessMethodEEnum, AccessMethod.INTERNAL_LITERAL);
		addEEnumLiteral(accessMethodEEnum, AccessMethod.REST_LITERAL);
		addEEnumLiteral(accessMethodEEnum, AccessMethod.SYNDICATION_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //LogPackageImpl
