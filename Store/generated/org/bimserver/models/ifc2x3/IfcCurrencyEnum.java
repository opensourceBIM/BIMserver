/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

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

import org.bimserver.models.log.LogPackage;

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
 * A representation of the literals of the enumeration '<em><b>Ifc Currency Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyEnum()
 * @model
 * @generated
 */
public enum IfcCurrencyEnum implements Enumerator
{
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @generated
	 * @ordered
	 */
	NULL_LITERAL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>CNY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CNY
	 * @generated
	 * @ordered
	 */
	CNY_LITERAL(1, "CNY", "CNY"),

	/**
	 * The '<em><b>JPY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JPY
	 * @generated
	 * @ordered
	 */
	JPY_LITERAL(2, "JPY", "JPY"),

	/**
	 * The '<em><b>KYD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KYD
	 * @generated
	 * @ordered
	 */
	KYD_LITERAL(3, "KYD", "KYD"),

	/**
	 * The '<em><b>TTD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TTD
	 * @generated
	 * @ordered
	 */
	TTD_LITERAL(4, "TTD", "TTD"),

	/**
	 * The '<em><b>LKR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LKR
	 * @generated
	 * @ordered
	 */
	LKR_LITERAL(5, "LKR", "LKR"),

	/**
	 * The '<em><b>MXN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MXN
	 * @generated
	 * @ordered
	 */
	MXN_LITERAL(6, "MXN", "MXN"),

	/**
	 * The '<em><b>XEU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XEU
	 * @generated
	 * @ordered
	 */
	XEU_LITERAL(7, "XEU", "XEU"),

	/**
	 * The '<em><b>CAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAD
	 * @generated
	 * @ordered
	 */
	CAD_LITERAL(8, "CAD", "CAD"),

	/**
	 * The '<em><b>ZAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAR
	 * @generated
	 * @ordered
	 */
	ZAR_LITERAL(9, "ZAR", "ZAR"),

	/**
	 * The '<em><b>AUD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUD
	 * @generated
	 * @ordered
	 */
	AUD_LITERAL(10, "AUD", "AUD"),

	/**
	 * The '<em><b>DEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEM
	 * @generated
	 * @ordered
	 */
	DEM_LITERAL(11, "DEM", "DEM"),

	/**
	 * The '<em><b>NOK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOK
	 * @generated
	 * @ordered
	 */
	NOK_LITERAL(12, "NOK", "NOK"),

	/**
	 * The '<em><b>ILS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ILS
	 * @generated
	 * @ordered
	 */
	ILS_LITERAL(13, "ILS", "ILS"),

	/**
	 * The '<em><b>AES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AES
	 * @generated
	 * @ordered
	 */
	AES_LITERAL(14, "AES", "AES"),

	/**
	 * The '<em><b>FAK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAK
	 * @generated
	 * @ordered
	 */
	FAK_LITERAL(15, "FAK", "FAK"),

	/**
	 * The '<em><b>PKR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PKR
	 * @generated
	 * @ordered
	 */
	PKR_LITERAL(16, "PKR", "PKR"),

	/**
	 * The '<em><b>BBD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BBD
	 * @generated
	 * @ordered
	 */
	BBD_LITERAL(17, "BBD", "BBD"),

	/**
	 * The '<em><b>THB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THB
	 * @generated
	 * @ordered
	 */
	THB_LITERAL(18, "THB", "THB"),

	/**
	 * The '<em><b>SCR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCR
	 * @generated
	 * @ordered
	 */
	SCR_LITERAL(19, "SCR", "SCR"),

	/**
	 * The '<em><b>FKP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FKP
	 * @generated
	 * @ordered
	 */
	FKP_LITERAL(20, "FKP", "FKP"),

	/**
	 * The '<em><b>ATS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATS
	 * @generated
	 * @ordered
	 */
	ATS_LITERAL(21, "ATS", "ATS"),

	/**
	 * The '<em><b>FIM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIM
	 * @generated
	 * @ordered
	 */
	FIM_LITERAL(22, "FIM", "FIM"),

	/**
	 * The '<em><b>IDR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IDR
	 * @generated
	 * @ordered
	 */
	IDR_LITERAL(23, "IDR", "IDR"),

	/**
	 * The '<em><b>AED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AED
	 * @generated
	 * @ordered
	 */
	AED_LITERAL(24, "AED", "AED"),

	/**
	 * The '<em><b>PGK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PGK
	 * @generated
	 * @ordered
	 */
	PGK_LITERAL(25, "PGK", "PGK"),

	/**
	 * The '<em><b>GIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIP
	 * @generated
	 * @ordered
	 */
	GIP_LITERAL(26, "GIP", "GIP"),

	/**
	 * The '<em><b>QAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QAR
	 * @generated
	 * @ordered
	 */
	QAR_LITERAL(27, "QAR", "QAR"),

	/**
	 * The '<em><b>BHD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BHD
	 * @generated
	 * @ordered
	 */
	BHD_LITERAL(28, "BHD", "BHD"),

	/**
	 * The '<em><b>BWP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BWP
	 * @generated
	 * @ordered
	 */
	BWP_LITERAL(29, "BWP", "BWP"),

	/**
	 * The '<em><b>BSD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BSD
	 * @generated
	 * @ordered
	 */
	BSD_LITERAL(30, "BSD", "BSD"),

	/**
	 * The '<em><b>IRP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IRP
	 * @generated
	 * @ordered
	 */
	IRP_LITERAL(31, "IRP", "IRP"),

	/**
	 * The '<em><b>DKK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DKK
	 * @generated
	 * @ordered
	 */
	DKK_LITERAL(32, "DKK", "DKK"),

	/**
	 * The '<em><b>SEK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEK
	 * @generated
	 * @ordered
	 */
	SEK_LITERAL(33, "SEK", "SEK"),

	/**
	 * The '<em><b>MYR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MYR
	 * @generated
	 * @ordered
	 */
	MYR_LITERAL(34, "MYR", "MYR"),

	/**
	 * The '<em><b>FJD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FJD
	 * @generated
	 * @ordered
	 */
	FJD_LITERAL(35, "FJD", "FJD"),

	/**
	 * The '<em><b>DDP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DDP
	 * @generated
	 * @ordered
	 */
	DDP_LITERAL(36, "DDP", "DDP"),

	/**
	 * The '<em><b>GRX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRX
	 * @generated
	 * @ordered
	 */
	GRX_LITERAL(37, "GRX", "GRX"),

	/**
	 * The '<em><b>JMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JMD
	 * @generated
	 * @ordered
	 */
	JMD_LITERAL(38, "JMD", "JMD"),

	/**
	 * The '<em><b>KRW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KRW
	 * @generated
	 * @ordered
	 */
	KRW_LITERAL(39, "KRW", "KRW"),

	/**
	 * The '<em><b>EST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EST
	 * @generated
	 * @ordered
	 */
	EST_LITERAL(40, "EST", "EST"),

	/**
	 * The '<em><b>BGL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BGL
	 * @generated
	 * @ordered
	 */
	BGL_LITERAL(41, "BGL", "BGL"),

	/**
	 * The '<em><b>ZWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZWD
	 * @generated
	 * @ordered
	 */
	ZWD_LITERAL(42, "ZWD", "ZWD"),

	/**
	 * The '<em><b>CZK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CZK
	 * @generated
	 * @ordered
	 */
	CZK_LITERAL(43, "CZK", "CZK"),

	/**
	 * The '<em><b>FRF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRF
	 * @generated
	 * @ordered
	 */
	FRF_LITERAL(44, "FRF", "FRF"),

	/**
	 * The '<em><b>KWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KWD
	 * @generated
	 * @ordered
	 */
	KWD_LITERAL(45, "KWD", "KWD"),

	/**
	 * The '<em><b>VEB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEB
	 * @generated
	 * @ordered
	 */
	VEB_LITERAL(46, "VEB", "VEB"),

	/**
	 * The '<em><b>VND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VND
	 * @generated
	 * @ordered
	 */
	VND_LITERAL(47, "VND", "VND"),

	/**
	 * The '<em><b>TRL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRL
	 * @generated
	 * @ordered
	 */
	TRL_LITERAL(48, "TRL", "TRL"),

	/**
	 * The '<em><b>JOD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOD
	 * @generated
	 * @ordered
	 */
	JOD_LITERAL(49, "JOD", "JOD"),

	/**
	 * The '<em><b>NZD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NZD
	 * @generated
	 * @ordered
	 */
	NZD_LITERAL(50, "NZD", "NZD"),

	/**
	 * The '<em><b>CLP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLP
	 * @generated
	 * @ordered
	 */
	CLP_LITERAL(51, "CLP", "CLP"),

	/**
	 * The '<em><b>GBP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GBP
	 * @generated
	 * @ordered
	 */
	GBP_LITERAL(52, "GBP", "GBP"),

	/**
	 * The '<em><b>KES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KES
	 * @generated
	 * @ordered
	 */
	KES_LITERAL(53, "KES", "KES"),

	/**
	 * The '<em><b>CHF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHF
	 * @generated
	 * @ordered
	 */
	CHF_LITERAL(54, "CHF", "CHF"),

	/**
	 * The '<em><b>EGL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EGL
	 * @generated
	 * @ordered
	 */
	EGL_LITERAL(55, "EGL", "EGL"),

	/**
	 * The '<em><b>MUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUR
	 * @generated
	 * @ordered
	 */
	MUR_LITERAL(56, "MUR", "MUR"),

	/**
	 * The '<em><b>SAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAR
	 * @generated
	 * @ordered
	 */
	SAR_LITERAL(57, "SAR", "SAR"),

	/**
	 * The '<em><b>BZD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BZD
	 * @generated
	 * @ordered
	 */
	BZD_LITERAL(58, "BZD", "BZD"),

	/**
	 * The '<em><b>INR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INR
	 * @generated
	 * @ordered
	 */
	INR_LITERAL(59, "INR", "INR"),

	/**
	 * The '<em><b>PTN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PTN
	 * @generated
	 * @ordered
	 */
	PTN_LITERAL(60, "PTN", "PTN"),

	/**
	 * The '<em><b>TWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWD
	 * @generated
	 * @ordered
	 */
	TWD_LITERAL(61, "TWD", "TWD"),

	/**
	 * The '<em><b>BMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BMD
	 * @generated
	 * @ordered
	 */
	BMD_LITERAL(62, "BMD", "BMD"),

	/**
	 * The '<em><b>ITL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ITL
	 * @generated
	 * @ordered
	 */
	ITL_LITERAL(63, "ITL", "ITL"),

	/**
	 * The '<em><b>OMR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OMR
	 * @generated
	 * @ordered
	 */
	OMR_LITERAL(64, "OMR", "OMR"),

	/**
	 * The '<em><b>SGD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SGD
	 * @generated
	 * @ordered
	 */
	SGD_LITERAL(65, "SGD", "SGD"),

	/**
	 * The '<em><b>NLG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NLG
	 * @generated
	 * @ordered
	 */
	NLG_LITERAL(66, "NLG", "NLG"),

	/**
	 * The '<em><b>SKP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SKP
	 * @generated
	 * @ordered
	 */
	SKP_LITERAL(67, "SKP", "SKP"),

	/**
	 * The '<em><b>HKD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HKD
	 * @generated
	 * @ordered
	 */
	HKD_LITERAL(68, "HKD", "HKD"),

	/**
	 * The '<em><b>RUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUR
	 * @generated
	 * @ordered
	 */
	RUR_LITERAL(69, "RUR", "RUR"),

	/**
	 * The '<em><b>GMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GMD
	 * @generated
	 * @ordered
	 */
	GMD_LITERAL(70, "GMD", "GMD"),

	/**
	 * The '<em><b>CYS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CYS
	 * @generated
	 * @ordered
	 */
	CYS_LITERAL(71, "CYS", "CYS"),

	/**
	 * The '<em><b>CBD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CBD
	 * @generated
	 * @ordered
	 */
	CBD_LITERAL(72, "CBD", "CBD"),

	/**
	 * The '<em><b>BRL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRL
	 * @generated
	 * @ordered
	 */
	BRL_LITERAL(73, "BRL", "BRL"),

	/**
	 * The '<em><b>EUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EUR
	 * @generated
	 * @ordered
	 */
	EUR_LITERAL(74, "EUR", "EUR"),

	/**
	 * The '<em><b>ICK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ICK
	 * @generated
	 * @ordered
	 */
	ICK_LITERAL(75, "ICK", "ICK"),

	/**
	 * The '<em><b>BEG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEG
	 * @generated
	 * @ordered
	 */
	BEG_LITERAL(76, "BEG", "BEG"),

	/**
	 * The '<em><b>PHP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHP
	 * @generated
	 * @ordered
	 */
	PHP_LITERAL(77, "PHP", "PHP"),

	/**
	 * The '<em><b>HUF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUF
	 * @generated
	 * @ordered
	 */
	HUF_LITERAL(78, "HUF", "HUF"),

	/**
	 * The '<em><b>PLN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLN
	 * @generated
	 * @ordered
	 */
	PLN_LITERAL(79, "PLN", "PLN"),

	/**
	 * The '<em><b>USD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USD
	 * @generated
	 * @ordered
	 */
	USD_LITERAL(80, "USD", "USD"),

	/**
	 * The '<em><b>MTL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MTL
	 * @generated
	 * @ordered
	 */
	MTL_LITERAL(81, "MTL", "MTL"),

	/**
	 * The '<em><b>LUF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUF
	 * @generated
	 * @ordered
	 */
	LUF_LITERAL(82, "LUF", "LUF"),

	/**
	 * The '<em><b>BND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BND
	 * @generated
	 * @ordered
	 */
	BND_LITERAL(83, "BND", "BND");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL = 0;

	/**
	 * The '<em><b>CNY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CNY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CNY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CNY = 1;

	/**
	 * The '<em><b>JPY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JPY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JPY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JPY = 2;

	/**
	 * The '<em><b>KYD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KYD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KYD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KYD = 3;

	/**
	 * The '<em><b>TTD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TTD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TTD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TTD = 4;

	/**
	 * The '<em><b>LKR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LKR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LKR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LKR = 5;

	/**
	 * The '<em><b>MXN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MXN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MXN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MXN = 6;

	/**
	 * The '<em><b>XEU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XEU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XEU_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XEU = 7;

	/**
	 * The '<em><b>CAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CAD = 8;

	/**
	 * The '<em><b>ZAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZAR = 9;

	/**
	 * The '<em><b>AUD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AUD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AUD = 10;

	/**
	 * The '<em><b>DEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEM = 11;

	/**
	 * The '<em><b>NOK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOK = 12;

	/**
	 * The '<em><b>ILS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ILS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ILS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ILS = 13;

	/**
	 * The '<em><b>AES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AES = 14;

	/**
	 * The '<em><b>FAK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAK = 15;

	/**
	 * The '<em><b>PKR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PKR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PKR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PKR = 16;

	/**
	 * The '<em><b>BBD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BBD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BBD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BBD = 17;

	/**
	 * The '<em><b>THB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THB = 18;

	/**
	 * The '<em><b>SCR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCR = 19;

	/**
	 * The '<em><b>FKP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FKP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FKP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FKP = 20;

	/**
	 * The '<em><b>ATS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATS = 21;

	/**
	 * The '<em><b>FIM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIM = 22;

	/**
	 * The '<em><b>IDR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IDR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IDR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IDR = 23;

	/**
	 * The '<em><b>AED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AED = 24;

	/**
	 * The '<em><b>PGK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PGK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PGK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PGK = 25;

	/**
	 * The '<em><b>GIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GIP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GIP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GIP = 26;

	/**
	 * The '<em><b>QAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QAR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QAR = 27;

	/**
	 * The '<em><b>BHD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BHD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BHD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BHD = 28;

	/**
	 * The '<em><b>BWP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BWP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BWP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BWP = 29;

	/**
	 * The '<em><b>BSD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BSD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BSD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BSD = 30;

	/**
	 * The '<em><b>IRP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IRP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IRP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IRP = 31;

	/**
	 * The '<em><b>DKK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DKK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DKK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DKK = 32;

	/**
	 * The '<em><b>SEK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEK = 33;

	/**
	 * The '<em><b>MYR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MYR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MYR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MYR = 34;

	/**
	 * The '<em><b>FJD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FJD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FJD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FJD = 35;

	/**
	 * The '<em><b>DDP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DDP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DDP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DDP = 36;

	/**
	 * The '<em><b>GRX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRX_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRX = 37;

	/**
	 * The '<em><b>JMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JMD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JMD = 38;

	/**
	 * The '<em><b>KRW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KRW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KRW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KRW = 39;

	/**
	 * The '<em><b>EST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EST_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EST = 40;

	/**
	 * The '<em><b>BGL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BGL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BGL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BGL = 41;

	/**
	 * The '<em><b>ZWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZWD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZWD = 42;

	/**
	 * The '<em><b>CZK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CZK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CZK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CZK = 43;

	/**
	 * The '<em><b>FRF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FRF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRF = 44;

	/**
	 * The '<em><b>KWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KWD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KWD = 45;

	/**
	 * The '<em><b>VEB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VEB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VEB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEB = 46;

	/**
	 * The '<em><b>VND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VND = 47;

	/**
	 * The '<em><b>TRL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRL = 48;

	/**
	 * The '<em><b>JOD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOD = 49;

	/**
	 * The '<em><b>NZD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NZD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NZD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NZD = 50;

	/**
	 * The '<em><b>CLP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLP = 51;

	/**
	 * The '<em><b>GBP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GBP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GBP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GBP = 52;

	/**
	 * The '<em><b>KES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KES = 53;

	/**
	 * The '<em><b>CHF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHF = 54;

	/**
	 * The '<em><b>EGL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EGL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EGL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EGL = 55;

	/**
	 * The '<em><b>MUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MUR = 56;

	/**
	 * The '<em><b>SAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SAR = 57;

	/**
	 * The '<em><b>BZD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BZD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BZD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BZD = 58;

	/**
	 * The '<em><b>INR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INR = 59;

	/**
	 * The '<em><b>PTN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PTN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PTN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PTN = 60;

	/**
	 * The '<em><b>TWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWD = 61;

	/**
	 * The '<em><b>BMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BMD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BMD = 62;

	/**
	 * The '<em><b>ITL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ITL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ITL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ITL = 63;

	/**
	 * The '<em><b>OMR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OMR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OMR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OMR = 64;

	/**
	 * The '<em><b>SGD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SGD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SGD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SGD = 65;

	/**
	 * The '<em><b>NLG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NLG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NLG_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NLG = 66;

	/**
	 * The '<em><b>SKP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SKP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SKP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SKP = 67;

	/**
	 * The '<em><b>HKD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HKD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HKD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HKD = 68;

	/**
	 * The '<em><b>RUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUR = 69;

	/**
	 * The '<em><b>GMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GMD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GMD = 70;

	/**
	 * The '<em><b>CYS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CYS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CYS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CYS = 71;

	/**
	 * The '<em><b>CBD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CBD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CBD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CBD = 72;

	/**
	 * The '<em><b>BRL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BRL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRL = 73;

	/**
	 * The '<em><b>EUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EUR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EUR = 74;

	/**
	 * The '<em><b>ICK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ICK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ICK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ICK = 75;

	/**
	 * The '<em><b>BEG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BEG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BEG_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BEG = 76;

	/**
	 * The '<em><b>PHP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PHP = 77;

	/**
	 * The '<em><b>HUF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HUF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HUF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HUF = 78;

	/**
	 * The '<em><b>PLN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLN = 79;

	/**
	 * The '<em><b>USD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USD = 80;

	/**
	 * The '<em><b>MTL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MTL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MTL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MTL = 81;

	/**
	 * The '<em><b>LUF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUF = 82;

	/**
	 * The '<em><b>BND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BND = 83;

	/**
	 * An array of all the '<em><b>Ifc Currency Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCurrencyEnum[] VALUES_ARRAY =
		new IfcCurrencyEnum[]
		{
			NULL_LITERAL,
			CNY_LITERAL,
			JPY_LITERAL,
			KYD_LITERAL,
			TTD_LITERAL,
			LKR_LITERAL,
			MXN_LITERAL,
			XEU_LITERAL,
			CAD_LITERAL,
			ZAR_LITERAL,
			AUD_LITERAL,
			DEM_LITERAL,
			NOK_LITERAL,
			ILS_LITERAL,
			AES_LITERAL,
			FAK_LITERAL,
			PKR_LITERAL,
			BBD_LITERAL,
			THB_LITERAL,
			SCR_LITERAL,
			FKP_LITERAL,
			ATS_LITERAL,
			FIM_LITERAL,
			IDR_LITERAL,
			AED_LITERAL,
			PGK_LITERAL,
			GIP_LITERAL,
			QAR_LITERAL,
			BHD_LITERAL,
			BWP_LITERAL,
			BSD_LITERAL,
			IRP_LITERAL,
			DKK_LITERAL,
			SEK_LITERAL,
			MYR_LITERAL,
			FJD_LITERAL,
			DDP_LITERAL,
			GRX_LITERAL,
			JMD_LITERAL,
			KRW_LITERAL,
			EST_LITERAL,
			BGL_LITERAL,
			ZWD_LITERAL,
			CZK_LITERAL,
			FRF_LITERAL,
			KWD_LITERAL,
			VEB_LITERAL,
			VND_LITERAL,
			TRL_LITERAL,
			JOD_LITERAL,
			NZD_LITERAL,
			CLP_LITERAL,
			GBP_LITERAL,
			KES_LITERAL,
			CHF_LITERAL,
			EGL_LITERAL,
			MUR_LITERAL,
			SAR_LITERAL,
			BZD_LITERAL,
			INR_LITERAL,
			PTN_LITERAL,
			TWD_LITERAL,
			BMD_LITERAL,
			ITL_LITERAL,
			OMR_LITERAL,
			SGD_LITERAL,
			NLG_LITERAL,
			SKP_LITERAL,
			HKD_LITERAL,
			RUR_LITERAL,
			GMD_LITERAL,
			CYS_LITERAL,
			CBD_LITERAL,
			BRL_LITERAL,
			EUR_LITERAL,
			ICK_LITERAL,
			BEG_LITERAL,
			PHP_LITERAL,
			HUF_LITERAL,
			PLN_LITERAL,
			USD_LITERAL,
			MTL_LITERAL,
			LUF_LITERAL,
			BND_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Currency Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcCurrencyEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Currency Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCurrencyEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCurrencyEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Currency Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCurrencyEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCurrencyEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Currency Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCurrencyEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case CNY: return CNY_LITERAL;
			case JPY: return JPY_LITERAL;
			case KYD: return KYD_LITERAL;
			case TTD: return TTD_LITERAL;
			case LKR: return LKR_LITERAL;
			case MXN: return MXN_LITERAL;
			case XEU: return XEU_LITERAL;
			case CAD: return CAD_LITERAL;
			case ZAR: return ZAR_LITERAL;
			case AUD: return AUD_LITERAL;
			case DEM: return DEM_LITERAL;
			case NOK: return NOK_LITERAL;
			case ILS: return ILS_LITERAL;
			case AES: return AES_LITERAL;
			case FAK: return FAK_LITERAL;
			case PKR: return PKR_LITERAL;
			case BBD: return BBD_LITERAL;
			case THB: return THB_LITERAL;
			case SCR: return SCR_LITERAL;
			case FKP: return FKP_LITERAL;
			case ATS: return ATS_LITERAL;
			case FIM: return FIM_LITERAL;
			case IDR: return IDR_LITERAL;
			case AED: return AED_LITERAL;
			case PGK: return PGK_LITERAL;
			case GIP: return GIP_LITERAL;
			case QAR: return QAR_LITERAL;
			case BHD: return BHD_LITERAL;
			case BWP: return BWP_LITERAL;
			case BSD: return BSD_LITERAL;
			case IRP: return IRP_LITERAL;
			case DKK: return DKK_LITERAL;
			case SEK: return SEK_LITERAL;
			case MYR: return MYR_LITERAL;
			case FJD: return FJD_LITERAL;
			case DDP: return DDP_LITERAL;
			case GRX: return GRX_LITERAL;
			case JMD: return JMD_LITERAL;
			case KRW: return KRW_LITERAL;
			case EST: return EST_LITERAL;
			case BGL: return BGL_LITERAL;
			case ZWD: return ZWD_LITERAL;
			case CZK: return CZK_LITERAL;
			case FRF: return FRF_LITERAL;
			case KWD: return KWD_LITERAL;
			case VEB: return VEB_LITERAL;
			case VND: return VND_LITERAL;
			case TRL: return TRL_LITERAL;
			case JOD: return JOD_LITERAL;
			case NZD: return NZD_LITERAL;
			case CLP: return CLP_LITERAL;
			case GBP: return GBP_LITERAL;
			case KES: return KES_LITERAL;
			case CHF: return CHF_LITERAL;
			case EGL: return EGL_LITERAL;
			case MUR: return MUR_LITERAL;
			case SAR: return SAR_LITERAL;
			case BZD: return BZD_LITERAL;
			case INR: return INR_LITERAL;
			case PTN: return PTN_LITERAL;
			case TWD: return TWD_LITERAL;
			case BMD: return BMD_LITERAL;
			case ITL: return ITL_LITERAL;
			case OMR: return OMR_LITERAL;
			case SGD: return SGD_LITERAL;
			case NLG: return NLG_LITERAL;
			case SKP: return SKP_LITERAL;
			case HKD: return HKD_LITERAL;
			case RUR: return RUR_LITERAL;
			case GMD: return GMD_LITERAL;
			case CYS: return CYS_LITERAL;
			case CBD: return CBD_LITERAL;
			case BRL: return BRL_LITERAL;
			case EUR: return EUR_LITERAL;
			case ICK: return ICK_LITERAL;
			case BEG: return BEG_LITERAL;
			case PHP: return PHP_LITERAL;
			case HUF: return HUF_LITERAL;
			case PLN: return PLN_LITERAL;
			case USD: return USD_LITERAL;
			case MTL: return MTL_LITERAL;
			case LUF: return LUF_LITERAL;
			case BND: return BND_LITERAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IfcCurrencyEnum(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //IfcCurrencyEnum
