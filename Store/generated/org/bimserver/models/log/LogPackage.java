/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.log;

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
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.bimserver.models.log.LogFactory
 * @model kind="package"
 * @generated
 */
public interface LogPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "log";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "log";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "log";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LogPackage eINSTANCE = org.bimserver.models.log.impl.LogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.LogActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.LogActionImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getLogAction()
	 * @generated
	 */
	int LOG_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ACTION__DATE = 0;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ACTION__EXECUTOR = 1;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ACTION__ACCESS_METHOD = 2;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_ACTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ServerLogImpl <em>Server Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ServerLogImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getServerLog()
	 * @generated
	 */
	int SERVER_LOG = 1;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_LOG__ACTIONS = 0;

	/**
	 * The number of structural features of the '<em>Server Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_LOG_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewUserAddedImpl <em>New User Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewUserAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewUserAdded()
	 * @generated
	 */
	int NEW_USER_ADDED = 2;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New User Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_USER_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewProjectAddedImpl <em>New Project Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewProjectAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewProjectAdded()
	 * @generated
	 */
	int NEW_PROJECT_ADDED = 3;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED__PARENT_PROJECT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>New Project Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_PROJECT_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewRevisionAddedImpl <em>New Revision Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewRevisionAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewRevisionAdded()
	 * @generated
	 */
	int NEW_REVISION_ADDED = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED__REVISION = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Revision Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_REVISION_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewCheckoutAddedImpl <em>New Checkout Added</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewCheckoutAddedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewCheckoutAdded()
	 * @generated
	 */
	int NEW_CHECKOUT_ADDED = 5;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Checkout</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED__CHECKOUT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Checkout Added</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_CHECKOUT_ADDED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.SettingsSavedImpl <em>Settings Saved</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.SettingsSavedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getSettingsSaved()
	 * @generated
	 */
	int SETTINGS_SAVED = 6;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_SAVED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_SAVED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_SAVED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>Settings Saved</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SETTINGS_SAVED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserAddedToProjectImpl <em>User Added To Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserAddedToProjectImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserAddedToProject()
	 * @generated
	 */
	int USER_ADDED_TO_PROJECT = 7;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT__PROJECT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User Added To Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_ADDED_TO_PROJECT_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.NewIgnoreFileUploadedImpl <em>New Ignore File Uploaded</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.NewIgnoreFileUploadedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewIgnoreFileUploaded()
	 * @generated
	 */
	int NEW_IGNORE_FILE_UPLOADED = 8;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_IGNORE_FILE_UPLOADED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_IGNORE_FILE_UPLOADED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_IGNORE_FILE_UPLOADED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>New Ignore File Uploaded</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_IGNORE_FILE_UPLOADED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.DownloadImpl <em>Download</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.DownloadImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getDownload()
	 * @generated
	 */
	int DOWNLOAD = 9;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>Download</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOWNLOAD_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserRemovedFromProjectImpl <em>User Removed From Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserRemovedFromProjectImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserRemovedFromProject()
	 * @generated
	 */
	int USER_REMOVED_FROM_PROJECT = 10;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT__PROJECT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User Removed From Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_REMOVED_FROM_PROJECT_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectDeletedImpl <em>Project Deleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectDeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectDeleted()
	 * @generated
	 */
	int PROJECT_DELETED = 11;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Deleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DELETED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserDeletedImpl <em>User Deleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserDeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserDeleted()
	 * @generated
	 */
	int USER_DELETED = 12;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Deleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DELETED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.PasswordResetImpl <em>Password Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.PasswordResetImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordReset()
	 * @generated
	 */
	int PASSWORD_RESET = 13;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Password Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_RESET_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.DatabaseCreatedImpl <em>Database Created</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.DatabaseCreatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getDatabaseCreated()
	 * @generated
	 */
	int DATABASE_CREATED = 14;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__PATH = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED__VERSION = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Database Created</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_CREATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ServerStartedImpl <em>Server Started</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ServerStartedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getServerStarted()
	 * @generated
	 */
	int SERVER_STARTED = 15;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_STARTED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_STARTED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_STARTED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The number of structural features of the '<em>Server Started</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_STARTED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectUpdatedImpl <em>Project Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUpdated()
	 * @generated
	 */
	int PROJECT_UPDATED = 16;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UPDATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserUndeletedImpl <em>User Undeleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserUndeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserUndeleted()
	 * @generated
	 */
	int USER_UNDELETED = 17;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Undeleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNDELETED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ProjectUndeletedImpl <em>Project Undeleted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ProjectUndeletedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUndeleted()
	 * @generated
	 */
	int PROJECT_UNDELETED = 18;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED__PROJECT = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Project Undeleted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_UNDELETED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.RevisionUpdatedImpl <em>Revision Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.RevisionUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionUpdated()
	 * @generated
	 */
	int REVISION_UPDATED = 19;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED__REVISION = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Revision Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_UPDATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.GeoTagUpdatedImpl <em>Geo Tag Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.GeoTagUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getGeoTagUpdated()
	 * @generated
	 */
	int GEO_TAG_UPDATED = 20;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Geo Tag</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED__GEO_TAG = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Geo Tag Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEO_TAG_UPDATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl <em>Clash Detection Settings Updated</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getClashDetectionSettingsUpdated()
	 * @generated
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED = 21;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>Clash Detection Settings</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Clash Detection Settings Updated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASH_DETECTION_SETTINGS_UPDATED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.PasswordChangedImpl <em>Password Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.PasswordChangedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordChanged()
	 * @generated
	 */
	int PASSWORD_CHANGED = 22;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Password Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_CHANGED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.impl.UserChangedImpl <em>User Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.impl.UserChangedImpl
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserChanged()
	 * @generated
	 */
	int USER_CHANGED = 23;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__DATE = LOG_ACTION__DATE;

	/**
	 * The feature id for the '<em><b>Executor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__EXECUTOR = LOG_ACTION__EXECUTOR;

	/**
	 * The feature id for the '<em><b>Access Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__ACCESS_METHOD = LOG_ACTION__ACCESS_METHOD;

	/**
	 * The feature id for the '<em><b>User</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED__USER = LOG_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_CHANGED_FEATURE_COUNT = LOG_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.bimserver.models.log.AccessMethod <em>Access Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.bimserver.models.log.AccessMethod
	 * @see org.bimserver.models.log.impl.LogPackageImpl#getAccessMethod()
	 * @generated
	 */
	int ACCESS_METHOD = 24;


	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.LogAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.bimserver.models.log.LogAction
	 * @generated
	 */
	EClass getLogAction();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.LogAction#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.bimserver.models.log.LogAction#getDate()
	 * @see #getLogAction()
	 * @generated
	 */
	EAttribute getLogAction_Date();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.LogAction#getExecutor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Executor</em>'.
	 * @see org.bimserver.models.log.LogAction#getExecutor()
	 * @see #getLogAction()
	 * @generated
	 */
	EReference getLogAction_Executor();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.LogAction#getAccessMethod <em>Access Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Method</em>'.
	 * @see org.bimserver.models.log.LogAction#getAccessMethod()
	 * @see #getLogAction()
	 * @generated
	 */
	EAttribute getLogAction_AccessMethod();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ServerLog <em>Server Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Log</em>'.
	 * @see org.bimserver.models.log.ServerLog
	 * @generated
	 */
	EClass getServerLog();

	/**
	 * Returns the meta object for the reference list '{@link org.bimserver.models.log.ServerLog#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see org.bimserver.models.log.ServerLog#getActions()
	 * @see #getServerLog()
	 * @generated
	 */
	EReference getServerLog_Actions();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewUserAdded <em>New User Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New User Added</em>'.
	 * @see org.bimserver.models.log.NewUserAdded
	 * @generated
	 */
	EClass getNewUserAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewUserAdded#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.NewUserAdded#getUser()
	 * @see #getNewUserAdded()
	 * @generated
	 */
	EReference getNewUserAdded_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewProjectAdded <em>New Project Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Project Added</em>'.
	 * @see org.bimserver.models.log.NewProjectAdded
	 * @generated
	 */
	EClass getNewProjectAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewProjectAdded#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.NewProjectAdded#getProject()
	 * @see #getNewProjectAdded()
	 * @generated
	 */
	EReference getNewProjectAdded_Project();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewProjectAdded#getParentProject <em>Parent Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Project</em>'.
	 * @see org.bimserver.models.log.NewProjectAdded#getParentProject()
	 * @see #getNewProjectAdded()
	 * @generated
	 */
	EReference getNewProjectAdded_ParentProject();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewRevisionAdded <em>New Revision Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Revision Added</em>'.
	 * @see org.bimserver.models.log.NewRevisionAdded
	 * @generated
	 */
	EClass getNewRevisionAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewRevisionAdded#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.log.NewRevisionAdded#getRevision()
	 * @see #getNewRevisionAdded()
	 * @generated
	 */
	EReference getNewRevisionAdded_Revision();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewCheckoutAdded <em>New Checkout Added</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Checkout Added</em>'.
	 * @see org.bimserver.models.log.NewCheckoutAdded
	 * @generated
	 */
	EClass getNewCheckoutAdded();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.NewCheckoutAdded#getCheckout <em>Checkout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Checkout</em>'.
	 * @see org.bimserver.models.log.NewCheckoutAdded#getCheckout()
	 * @see #getNewCheckoutAdded()
	 * @generated
	 */
	EReference getNewCheckoutAdded_Checkout();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.SettingsSaved <em>Settings Saved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Settings Saved</em>'.
	 * @see org.bimserver.models.log.SettingsSaved
	 * @generated
	 */
	EClass getSettingsSaved();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserAddedToProject <em>User Added To Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Added To Project</em>'.
	 * @see org.bimserver.models.log.UserAddedToProject
	 * @generated
	 */
	EClass getUserAddedToProject();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserAddedToProject#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserAddedToProject#getUser()
	 * @see #getUserAddedToProject()
	 * @generated
	 */
	EReference getUserAddedToProject_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserAddedToProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.UserAddedToProject#getProject()
	 * @see #getUserAddedToProject()
	 * @generated
	 */
	EReference getUserAddedToProject_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.NewIgnoreFileUploaded <em>New Ignore File Uploaded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Ignore File Uploaded</em>'.
	 * @see org.bimserver.models.log.NewIgnoreFileUploaded
	 * @generated
	 */
	EClass getNewIgnoreFileUploaded();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.Download <em>Download</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Download</em>'.
	 * @see org.bimserver.models.log.Download
	 * @generated
	 */
	EClass getDownload();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserRemovedFromProject <em>User Removed From Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Removed From Project</em>'.
	 * @see org.bimserver.models.log.UserRemovedFromProject
	 * @generated
	 */
	EClass getUserRemovedFromProject();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserRemovedFromProject#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserRemovedFromProject#getUser()
	 * @see #getUserRemovedFromProject()
	 * @generated
	 */
	EReference getUserRemovedFromProject_User();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserRemovedFromProject#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.UserRemovedFromProject#getProject()
	 * @see #getUserRemovedFromProject()
	 * @generated
	 */
	EReference getUserRemovedFromProject_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ProjectDeleted <em>Project Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Deleted</em>'.
	 * @see org.bimserver.models.log.ProjectDeleted
	 * @generated
	 */
	EClass getProjectDeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ProjectDeleted#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.ProjectDeleted#getProject()
	 * @see #getProjectDeleted()
	 * @generated
	 */
	EReference getProjectDeleted_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserDeleted <em>User Deleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Deleted</em>'.
	 * @see org.bimserver.models.log.UserDeleted
	 * @generated
	 */
	EClass getUserDeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserDeleted#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserDeleted#getUser()
	 * @see #getUserDeleted()
	 * @generated
	 */
	EReference getUserDeleted_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.PasswordReset <em>Password Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Password Reset</em>'.
	 * @see org.bimserver.models.log.PasswordReset
	 * @generated
	 */
	EClass getPasswordReset();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.PasswordReset#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.PasswordReset#getUser()
	 * @see #getPasswordReset()
	 * @generated
	 */
	EReference getPasswordReset_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.DatabaseCreated <em>Database Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database Created</em>'.
	 * @see org.bimserver.models.log.DatabaseCreated
	 * @generated
	 */
	EClass getDatabaseCreated();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.DatabaseCreated#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.bimserver.models.log.DatabaseCreated#getPath()
	 * @see #getDatabaseCreated()
	 * @generated
	 */
	EAttribute getDatabaseCreated_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.bimserver.models.log.DatabaseCreated#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.bimserver.models.log.DatabaseCreated#getVersion()
	 * @see #getDatabaseCreated()
	 * @generated
	 */
	EAttribute getDatabaseCreated_Version();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ServerStarted <em>Server Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Started</em>'.
	 * @see org.bimserver.models.log.ServerStarted
	 * @generated
	 */
	EClass getServerStarted();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ProjectUpdated <em>Project Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Updated</em>'.
	 * @see org.bimserver.models.log.ProjectUpdated
	 * @generated
	 */
	EClass getProjectUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ProjectUpdated#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.ProjectUpdated#getProject()
	 * @see #getProjectUpdated()
	 * @generated
	 */
	EReference getProjectUpdated_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserUndeleted <em>User Undeleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Undeleted</em>'.
	 * @see org.bimserver.models.log.UserUndeleted
	 * @generated
	 */
	EClass getUserUndeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserUndeleted#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserUndeleted#getUser()
	 * @see #getUserUndeleted()
	 * @generated
	 */
	EReference getUserUndeleted_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ProjectUndeleted <em>Project Undeleted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Undeleted</em>'.
	 * @see org.bimserver.models.log.ProjectUndeleted
	 * @generated
	 */
	EClass getProjectUndeleted();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ProjectUndeleted#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see org.bimserver.models.log.ProjectUndeleted#getProject()
	 * @see #getProjectUndeleted()
	 * @generated
	 */
	EReference getProjectUndeleted_Project();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.RevisionUpdated <em>Revision Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision Updated</em>'.
	 * @see org.bimserver.models.log.RevisionUpdated
	 * @generated
	 */
	EClass getRevisionUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.RevisionUpdated#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see org.bimserver.models.log.RevisionUpdated#getRevision()
	 * @see #getRevisionUpdated()
	 * @generated
	 */
	EReference getRevisionUpdated_Revision();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.GeoTagUpdated <em>Geo Tag Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geo Tag Updated</em>'.
	 * @see org.bimserver.models.log.GeoTagUpdated
	 * @generated
	 */
	EClass getGeoTagUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.GeoTagUpdated#getGeoTag <em>Geo Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Geo Tag</em>'.
	 * @see org.bimserver.models.log.GeoTagUpdated#getGeoTag()
	 * @see #getGeoTagUpdated()
	 * @generated
	 */
	EReference getGeoTagUpdated_GeoTag();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.ClashDetectionSettingsUpdated <em>Clash Detection Settings Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clash Detection Settings Updated</em>'.
	 * @see org.bimserver.models.log.ClashDetectionSettingsUpdated
	 * @generated
	 */
	EClass getClashDetectionSettingsUpdated();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.ClashDetectionSettingsUpdated#getClashDetectionSettings <em>Clash Detection Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clash Detection Settings</em>'.
	 * @see org.bimserver.models.log.ClashDetectionSettingsUpdated#getClashDetectionSettings()
	 * @see #getClashDetectionSettingsUpdated()
	 * @generated
	 */
	EReference getClashDetectionSettingsUpdated_ClashDetectionSettings();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.PasswordChanged <em>Password Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Password Changed</em>'.
	 * @see org.bimserver.models.log.PasswordChanged
	 * @generated
	 */
	EClass getPasswordChanged();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.PasswordChanged#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.PasswordChanged#getUser()
	 * @see #getPasswordChanged()
	 * @generated
	 */
	EReference getPasswordChanged_User();

	/**
	 * Returns the meta object for class '{@link org.bimserver.models.log.UserChanged <em>User Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Changed</em>'.
	 * @see org.bimserver.models.log.UserChanged
	 * @generated
	 */
	EClass getUserChanged();

	/**
	 * Returns the meta object for the reference '{@link org.bimserver.models.log.UserChanged#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>User</em>'.
	 * @see org.bimserver.models.log.UserChanged#getUser()
	 * @see #getUserChanged()
	 * @generated
	 */
	EReference getUserChanged_User();

	/**
	 * Returns the meta object for enum '{@link org.bimserver.models.log.AccessMethod <em>Access Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access Method</em>'.
	 * @see org.bimserver.models.log.AccessMethod
	 * @generated
	 */
	EEnum getAccessMethod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LogFactory getLogFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.LogActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.LogActionImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getLogAction()
		 * @generated
		 */
		EClass LOG_ACTION = eINSTANCE.getLogAction();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_ACTION__DATE = eINSTANCE.getLogAction_Date();

		/**
		 * The meta object literal for the '<em><b>Executor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG_ACTION__EXECUTOR = eINSTANCE.getLogAction_Executor();

		/**
		 * The meta object literal for the '<em><b>Access Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_ACTION__ACCESS_METHOD = eINSTANCE.getLogAction_AccessMethod();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ServerLogImpl <em>Server Log</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ServerLogImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getServerLog()
		 * @generated
		 */
		EClass SERVER_LOG = eINSTANCE.getServerLog();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_LOG__ACTIONS = eINSTANCE.getServerLog_Actions();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewUserAddedImpl <em>New User Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewUserAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewUserAdded()
		 * @generated
		 */
		EClass NEW_USER_ADDED = eINSTANCE.getNewUserAdded();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_USER_ADDED__USER = eINSTANCE.getNewUserAdded_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewProjectAddedImpl <em>New Project Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewProjectAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewProjectAdded()
		 * @generated
		 */
		EClass NEW_PROJECT_ADDED = eINSTANCE.getNewProjectAdded();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_PROJECT_ADDED__PROJECT = eINSTANCE.getNewProjectAdded_Project();

		/**
		 * The meta object literal for the '<em><b>Parent Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_PROJECT_ADDED__PARENT_PROJECT = eINSTANCE.getNewProjectAdded_ParentProject();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewRevisionAddedImpl <em>New Revision Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewRevisionAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewRevisionAdded()
		 * @generated
		 */
		EClass NEW_REVISION_ADDED = eINSTANCE.getNewRevisionAdded();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_REVISION_ADDED__REVISION = eINSTANCE.getNewRevisionAdded_Revision();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewCheckoutAddedImpl <em>New Checkout Added</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewCheckoutAddedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewCheckoutAdded()
		 * @generated
		 */
		EClass NEW_CHECKOUT_ADDED = eINSTANCE.getNewCheckoutAdded();

		/**
		 * The meta object literal for the '<em><b>Checkout</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_CHECKOUT_ADDED__CHECKOUT = eINSTANCE.getNewCheckoutAdded_Checkout();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.SettingsSavedImpl <em>Settings Saved</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.SettingsSavedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getSettingsSaved()
		 * @generated
		 */
		EClass SETTINGS_SAVED = eINSTANCE.getSettingsSaved();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserAddedToProjectImpl <em>User Added To Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserAddedToProjectImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserAddedToProject()
		 * @generated
		 */
		EClass USER_ADDED_TO_PROJECT = eINSTANCE.getUserAddedToProject();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ADDED_TO_PROJECT__USER = eINSTANCE.getUserAddedToProject_User();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_ADDED_TO_PROJECT__PROJECT = eINSTANCE.getUserAddedToProject_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.NewIgnoreFileUploadedImpl <em>New Ignore File Uploaded</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.NewIgnoreFileUploadedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getNewIgnoreFileUploaded()
		 * @generated
		 */
		EClass NEW_IGNORE_FILE_UPLOADED = eINSTANCE.getNewIgnoreFileUploaded();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.DownloadImpl <em>Download</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.DownloadImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getDownload()
		 * @generated
		 */
		EClass DOWNLOAD = eINSTANCE.getDownload();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserRemovedFromProjectImpl <em>User Removed From Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserRemovedFromProjectImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserRemovedFromProject()
		 * @generated
		 */
		EClass USER_REMOVED_FROM_PROJECT = eINSTANCE.getUserRemovedFromProject();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_REMOVED_FROM_PROJECT__USER = eINSTANCE.getUserRemovedFromProject_User();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_REMOVED_FROM_PROJECT__PROJECT = eINSTANCE.getUserRemovedFromProject_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ProjectDeletedImpl <em>Project Deleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ProjectDeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectDeleted()
		 * @generated
		 */
		EClass PROJECT_DELETED = eINSTANCE.getProjectDeleted();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_DELETED__PROJECT = eINSTANCE.getProjectDeleted_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserDeletedImpl <em>User Deleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserDeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserDeleted()
		 * @generated
		 */
		EClass USER_DELETED = eINSTANCE.getUserDeleted();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DELETED__USER = eINSTANCE.getUserDeleted_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.PasswordResetImpl <em>Password Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.PasswordResetImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordReset()
		 * @generated
		 */
		EClass PASSWORD_RESET = eINSTANCE.getPasswordReset();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSWORD_RESET__USER = eINSTANCE.getPasswordReset_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.DatabaseCreatedImpl <em>Database Created</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.DatabaseCreatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getDatabaseCreated()
		 * @generated
		 */
		EClass DATABASE_CREATED = eINSTANCE.getDatabaseCreated();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_CREATED__PATH = eINSTANCE.getDatabaseCreated_Path();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE_CREATED__VERSION = eINSTANCE.getDatabaseCreated_Version();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ServerStartedImpl <em>Server Started</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ServerStartedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getServerStarted()
		 * @generated
		 */
		EClass SERVER_STARTED = eINSTANCE.getServerStarted();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ProjectUpdatedImpl <em>Project Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ProjectUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUpdated()
		 * @generated
		 */
		EClass PROJECT_UPDATED = eINSTANCE.getProjectUpdated();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_UPDATED__PROJECT = eINSTANCE.getProjectUpdated_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserUndeletedImpl <em>User Undeleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserUndeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserUndeleted()
		 * @generated
		 */
		EClass USER_UNDELETED = eINSTANCE.getUserUndeleted();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_UNDELETED__USER = eINSTANCE.getUserUndeleted_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ProjectUndeletedImpl <em>Project Undeleted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ProjectUndeletedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getProjectUndeleted()
		 * @generated
		 */
		EClass PROJECT_UNDELETED = eINSTANCE.getProjectUndeleted();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_UNDELETED__PROJECT = eINSTANCE.getProjectUndeleted_Project();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.RevisionUpdatedImpl <em>Revision Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.RevisionUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getRevisionUpdated()
		 * @generated
		 */
		EClass REVISION_UPDATED = eINSTANCE.getRevisionUpdated();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION_UPDATED__REVISION = eINSTANCE.getRevisionUpdated_Revision();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.GeoTagUpdatedImpl <em>Geo Tag Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.GeoTagUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getGeoTagUpdated()
		 * @generated
		 */
		EClass GEO_TAG_UPDATED = eINSTANCE.getGeoTagUpdated();

		/**
		 * The meta object literal for the '<em><b>Geo Tag</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEO_TAG_UPDATED__GEO_TAG = eINSTANCE.getGeoTagUpdated_GeoTag();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl <em>Clash Detection Settings Updated</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.ClashDetectionSettingsUpdatedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getClashDetectionSettingsUpdated()
		 * @generated
		 */
		EClass CLASH_DETECTION_SETTINGS_UPDATED = eINSTANCE.getClashDetectionSettingsUpdated();

		/**
		 * The meta object literal for the '<em><b>Clash Detection Settings</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASH_DETECTION_SETTINGS_UPDATED__CLASH_DETECTION_SETTINGS = eINSTANCE.getClashDetectionSettingsUpdated_ClashDetectionSettings();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.PasswordChangedImpl <em>Password Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.PasswordChangedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getPasswordChanged()
		 * @generated
		 */
		EClass PASSWORD_CHANGED = eINSTANCE.getPasswordChanged();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PASSWORD_CHANGED__USER = eINSTANCE.getPasswordChanged_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.impl.UserChangedImpl <em>User Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.impl.UserChangedImpl
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getUserChanged()
		 * @generated
		 */
		EClass USER_CHANGED = eINSTANCE.getUserChanged();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_CHANGED__USER = eINSTANCE.getUserChanged_User();

		/**
		 * The meta object literal for the '{@link org.bimserver.models.log.AccessMethod <em>Access Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.bimserver.models.log.AccessMethod
		 * @see org.bimserver.models.log.impl.LogPackageImpl#getAccessMethod()
		 * @generated
		 */
		EEnum ACCESS_METHOD = eINSTANCE.getAccessMethod();

	}

} //LogPackage
