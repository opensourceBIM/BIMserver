package org.bimserver.database.actions;

import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.SIPrefix;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.emf.Ifc2x3.IfcAsymmetricIShapeProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcBlock;
import org.bimserver.ifc.emf.Ifc2x3.IfcBoundingBox;
import org.bimserver.ifc.emf.Ifc2x3.IfcBuilding;
import org.bimserver.ifc.emf.Ifc2x3.IfcBuildingStorey;
import org.bimserver.ifc.emf.Ifc2x3.IfcCShapeProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcCartesianPoint;
import org.bimserver.ifc.emf.Ifc2x3.IfcCenterLineProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcChamferEdgeFeature;
import org.bimserver.ifc.emf.Ifc2x3.IfcCircle;
import org.bimserver.ifc.emf.Ifc2x3.IfcCircleHollowProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcCircleProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcConnectionPointEccentricity;
import org.bimserver.ifc.emf.Ifc2x3.IfcCraneRailAShapeProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcCraneRailFShapeProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcCurveStyleFontPattern;
import org.bimserver.ifc.emf.Ifc2x3.IfcDoor;
import org.bimserver.ifc.emf.Ifc2x3.IfcDoorLiningProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcDoorPanelProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcEdgeFeature;
import org.bimserver.ifc.emf.Ifc2x3.IfcEllipse;
import org.bimserver.ifc.emf.Ifc2x3.IfcEllipseProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcExtrudedAreaSolid;
import org.bimserver.ifc.emf.Ifc2x3.IfcGeneralProfileProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcIShapeProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcLShapeProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcLightSourcePositional;
import org.bimserver.ifc.emf.Ifc2x3.IfcMaterialLayer;
import org.bimserver.ifc.emf.Ifc2x3.IfcMaterialLayerSetUsage;
import org.bimserver.ifc.emf.Ifc2x3.IfcMechanicalConcreteMaterialProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcMechanicalFastener;
import org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve2D;
import org.bimserver.ifc.emf.Ifc2x3.IfcOffsetCurve3D;
import org.bimserver.ifc.emf.Ifc2x3.IfcPermeableCoveringProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcPlanarExtent;
import org.bimserver.ifc.emf.Ifc2x3.IfcProject;
import org.bimserver.ifc.emf.Ifc2x3.IfcQuantityLength;
import org.bimserver.ifc.emf.Ifc2x3.IfcRectangleHollowProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcRectangleProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcRectangularPyramid;
import org.bimserver.ifc.emf.Ifc2x3.IfcReinforcementBarProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcReinforcingBar;
import org.bimserver.ifc.emf.Ifc2x3.IfcReinforcingMesh;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelConnectsStructuralMember;
import org.bimserver.ifc.emf.Ifc2x3.IfcRibPlateProfileProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcRightCircularCone;
import org.bimserver.ifc.emf.Ifc2x3.IfcRightCircularCylinder;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoundedEdgeFeature;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoundedRectangleProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcSIPrefix;
import org.bimserver.ifc.emf.Ifc2x3.IfcSIUnit;
import org.bimserver.ifc.emf.Ifc2x3.IfcSectionReinforcementProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcSite;
import org.bimserver.ifc.emf.Ifc2x3.IfcSlippageConnectionCondition;
import org.bimserver.ifc.emf.Ifc2x3.IfcSpace;
import org.bimserver.ifc.emf.Ifc2x3.IfcSphere;
import org.bimserver.ifc.emf.Ifc2x3.IfcStairFlight;
import org.bimserver.ifc.emf.Ifc2x3.IfcStructuralLoadSingleDisplacement;
import org.bimserver.ifc.emf.Ifc2x3.IfcStructuralProfileProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcStructuralSurfaceMember;
import org.bimserver.ifc.emf.Ifc2x3.IfcStructuralSurfaceMemberVarying;
import org.bimserver.ifc.emf.Ifc2x3.IfcSurfaceOfLinearExtrusion;
import org.bimserver.ifc.emf.Ifc2x3.IfcSweptDiskSolid;
import org.bimserver.ifc.emf.Ifc2x3.IfcTShapeProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcTendon;
import org.bimserver.ifc.emf.Ifc2x3.IfcTextStyleWithBoxCharacteristics;
import org.bimserver.ifc.emf.Ifc2x3.IfcTrapeziumProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcUShapeProfileDef;
import org.bimserver.ifc.emf.Ifc2x3.IfcUnit;
import org.bimserver.ifc.emf.Ifc2x3.IfcUnitAssignment;
import org.bimserver.ifc.emf.Ifc2x3.IfcUnitEnum;
import org.bimserver.ifc.emf.Ifc2x3.IfcVector;
import org.bimserver.ifc.emf.Ifc2x3.IfcVirtualGridIntersection;
import org.bimserver.ifc.emf.Ifc2x3.IfcWindow;
import org.bimserver.ifc.emf.Ifc2x3.IfcWindowLiningProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcWindowPanelProperties;
import org.bimserver.ifc.emf.Ifc2x3.IfcZShapeProfileDef;
import org.bimserver.shared.UserException;
import org.eclipse.emf.common.util.EList;

public abstract class BimDatabaseAction<T> {
	private final AccessMethod accessMethod;

	public abstract T execute(BimDatabaseSession bimDatabaseSession) throws UserException, BimDeadlockException, BimDatabaseException;

	public BimDatabaseAction(AccessMethod accessMethod) {
		this.accessMethod = accessMethod;
	}

	public static IfcModel merge(Project project, Set<IfcModel> ifcModels) {
		long size = 0;
		for (IfcModel ifcModel : ifcModels) {
			size += ifcModel.size();
		}
		IfcModel endModel = new IfcModel((int)size);
		float foundPrefix = Float.MIN_VALUE;
		boolean allModelsSameScale = allModelsSameScale(ifcModels, foundPrefix);
		if (allModelsSameScale) {
			for (IfcModel ifcModel : ifcModels) {
			for (long key : ifcModel.keySet()) {
				endModel.add(ifcModel.get(key));
			}}
		} else {
			SIPrefix prefix = project.getExportLengthMeasurePrefix();
			for (IfcModel ifcModel : ifcModels) {
				setLengthUnitToMilli(ifcModel);
				float scale = (float) (getLengthUnitPrefix(ifcModel) * Math.pow(10.0, prefix.ordinal()));
				ifcModel.indexGuids();
				for (long key : ifcModel.keySet()) {
					IdEObject idEObject = ifcModel.get(key);
					if (idEObject instanceof IfcAsymmetricIShapeProfileDef) {
						setIfcAsymmetricIShapeProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcBlock) {
						setIfcBlock(idEObject, scale);
					} else if (idEObject instanceof IfcBoundingBox) {
						setIfcBoundingBox(idEObject, scale);
					} else if (idEObject instanceof IfcBuilding) {
						setIfcBuilding(idEObject, scale);
					} else if (idEObject instanceof IfcBuildingStorey) {
						setIfcBuildingStorey(idEObject, scale);
					} else if (idEObject instanceof IfcCartesianPoint) {
						setIfcCartesianPoint(idEObject, scale);
					} else if (idEObject instanceof IfcCenterLineProfileDef) {
						setIfcCenterLineProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcChamferEdgeFeature) {
						setIfcChamferEdgeFeature(idEObject, scale);
					} else if (idEObject instanceof IfcCircle) {
						setIfcCircle(idEObject, scale);
					} else if (idEObject instanceof IfcCircleHollowProfileDef) {
						setIfcCircleHollowProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcCircleProfileDef) {
						setIfcCircleProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcCraneRailAShapeProfileDef) {
						setIfcCraneRailAShapeProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcCraneRailFShapeProfileDef) {
						setIfcCraneRailFShapeProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcConnectionPointEccentricity) {
						setIfcConnectionPointEccentricity(idEObject, scale);
					} else if (idEObject instanceof IfcCShapeProfileDef) {
						setIfcCShapeProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcCurveStyleFontPattern) {
						setIfcCurveStyleFontPattern(idEObject, scale);
					} else if (idEObject instanceof IfcDoor) {
						setIfcDoor(idEObject, scale);
					} else if (idEObject instanceof IfcDoorLiningProperties) {
						setIfcDoorLiningProperties(idEObject, scale);
					} else if (idEObject instanceof IfcDoorPanelProperties) {
						setIfcDoorPanelProperties(idEObject, scale);
					} else if (idEObject instanceof IfcEdgeFeature) {
						setIfcEdgeFeature(idEObject, scale);
					} else if (idEObject instanceof IfcEllipse) {
						setIfcEllipse(idEObject, scale);
					} else if (idEObject instanceof IfcEllipseProfileDef) {
						setIfcEllipseProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcExtrudedAreaSolid) {
						setIfcExtrudedAreaSolid(idEObject, scale);
					} else if (idEObject instanceof IfcGeneralProfileProperties) {
						setIfcGeneralProfileProperties(idEObject, scale);
					} else if (idEObject instanceof IfcIShapeProfileDef) {
						setIfcIShapeProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcLightSourcePositional) {
						setIfcLightSourcePositional(idEObject, scale);
					} else if (idEObject instanceof IfcLShapeProfileDef) {
						setIfcLShapeProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcMaterialLayer) {
						setIfcMaterialLayer(idEObject, scale);
					} else if (idEObject instanceof IfcMaterialLayerSetUsage) {
						setIfcMaterialLayerSetUsage(idEObject, scale);
					} else if (idEObject instanceof IfcMechanicalConcreteMaterialProperties) {
						setIfcMechanicalConcreteMaterialProperties(idEObject, scale);
					} else if (idEObject instanceof IfcMechanicalFastener) {
						setIfcMechanicalFastener(idEObject, scale);
					} else if (idEObject instanceof IfcOffsetCurve2D) {
						setIfcOffsetCurve2D(idEObject, scale);
					} else if (idEObject instanceof IfcOffsetCurve3D) {
						setIfcOffsetCurve3D(idEObject, scale);
					} else if (idEObject instanceof IfcPermeableCoveringProperties) {
						setIfcPermeableCoveringProperties(idEObject, scale);
					} else if (idEObject instanceof IfcPlanarExtent) {
						setIfcPlanarExtent(idEObject, scale);
					} else if (idEObject instanceof IfcQuantityLength) {
						setIfcQuantityLength(idEObject, scale);
					} else if (idEObject instanceof IfcRectangleHollowProfileDef) {
						setIfcRectangleHollowProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcRectangleProfileDef) {
						setIfcRectangleProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcRectangularPyramid) {
						setIfcRectangularPyramid(idEObject, scale);
					} else if (idEObject instanceof IfcReinforcementBarProperties) {
						setIfcReinforcementBarProperties(idEObject, scale);
					} else if (idEObject instanceof IfcReinforcingBar) {
						setIfcReinforcingBar(idEObject, scale);
					} else if (idEObject instanceof IfcReinforcingMesh) {
						setIfcReinforcingMesh(idEObject, scale);
					} else if (idEObject instanceof IfcRelConnectsStructuralMember) {
						setIfcRelConnectsStructuralMember(idEObject, scale);
					} else if (idEObject instanceof IfcRibPlateProfileProperties) {
						setIfcRibPlateProfileProperties(idEObject, scale);
					} else if (idEObject instanceof IfcRightCircularCone) {
						setIfcRightCircularCone(idEObject, scale);
					} else if (idEObject instanceof IfcRightCircularCylinder) {
						setIfcRightCircularCylinder(idEObject, scale);
					} else if (idEObject instanceof IfcRoundedEdgeFeature) {
						setIfcRoundedEdgeFeature(idEObject, scale);
					} else if (idEObject instanceof IfcRoundedRectangleProfileDef) {
						setIfcRoundedRectangleProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcSectionReinforcementProperties) {
						setIfcSectionReinforcementProperties(idEObject, scale);
					} else if (idEObject instanceof IfcSite) {
						setIfcSite(idEObject, scale);
					} else if (idEObject instanceof IfcSlippageConnectionCondition) {
						setIfcSlippageConnectionCondition(idEObject, scale);
					} else if (idEObject instanceof IfcSpace) {
						setIfcSpace(idEObject, scale);
					} else if (idEObject instanceof IfcSphere) {
						setIfcSphere(idEObject, scale);
					} else if (idEObject instanceof IfcStairFlight) {
						setIfcStairFlight(idEObject, scale);
					} else if (idEObject instanceof IfcStructuralLoadSingleDisplacement) {
						setIfcStructuralLoadSingleDisplacement(idEObject, scale);
					} else if (idEObject instanceof IfcStructuralProfileProperties) {
						setIfcStructuralProfileProperties(idEObject, scale);
					} else if (idEObject instanceof IfcStructuralSurfaceMember) {
						setIfcStructuralSurfaceMember(idEObject, scale);
					} else if (idEObject instanceof IfcStructuralSurfaceMemberVarying) {
						setIfcStructuralSurfaceMemberVarying(idEObject, scale);
					} else if (idEObject instanceof IfcSurfaceOfLinearExtrusion) {
						setIfcSurfaceOfLinearExtrusion(idEObject, scale);
					} else if (idEObject instanceof IfcSweptDiskSolid) {
						setIfcSweptDiskSolid(idEObject, scale);
					} else if (idEObject instanceof IfcTendon) {
						setIfcTendon(idEObject, scale);
					} else if (idEObject instanceof IfcTextStyleWithBoxCharacteristics) {
						setIfcTextStyleWithBoxCharacteristics(idEObject, scale);
					} else if (idEObject instanceof IfcTrapeziumProfileDef) {
						setIfcTrapeziumProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcTShapeProfileDef) {
						setIfcTShapeProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcUShapeProfileDef) {
						setIfcUShapeProfileDef(idEObject, scale);
					} else if (idEObject instanceof IfcVector) {
						setIfcVector(idEObject, scale);
					} else if (idEObject instanceof IfcVirtualGridIntersection) {
						setIfcVirtualGridIntersection(idEObject, scale);
					} else if (idEObject instanceof IfcWindow) {
						setIfcWindow(idEObject, scale);
					} else if (idEObject instanceof IfcWindowLiningProperties) {
						setIfcWindowLiningProperties(idEObject, scale);
					} else if (idEObject instanceof IfcWindowPanelProperties) {
						setIfcWindowPanelProperties(idEObject, scale);
					} else if (idEObject instanceof IfcZShapeProfileDef) {
						setIfcZShapeProfileDef(idEObject, scale);
					}
					endModel.add(key, ifcModel.get(key));
				}
			}
		}
		return endModel;
	}

	private static boolean allModelsSameScale(Set<IfcModel> ifcModels, float foundPrefix) {
		for (IfcModel ifcModel : ifcModels) {
			float lengthUnitPrefix = getLengthUnitPrefix(ifcModel);
			if (foundPrefix != Float.MIN_VALUE) {
				if (lengthUnitPrefix != foundPrefix) {
					return false;
				}
			} else {
				foundPrefix = lengthUnitPrefix;
			}
		}
		return true;
	}

	private static void setIfcAsymmetricIShapeProfileDef(IdEObject idEObject, float scale) {
		setIfcIShapeProfileDef(idEObject, scale);
		IfcAsymmetricIShapeProfileDef ifcAsymmetricIShapeProfileDef = (IfcAsymmetricIShapeProfileDef) idEObject;
		if (ifcAsymmetricIShapeProfileDef.isSetCentreOfGravityInY()) {
			ifcAsymmetricIShapeProfileDef.setCentreOfGravityInY(ifcAsymmetricIShapeProfileDef.getCentreOfGravityInY() * scale);
		}
		if (ifcAsymmetricIShapeProfileDef.isSetTopFlangeFilletRadius()) {
			ifcAsymmetricIShapeProfileDef.setTopFlangeFilletRadius(ifcAsymmetricIShapeProfileDef.getTopFlangeFilletRadius() * scale);
		}
		if (ifcAsymmetricIShapeProfileDef.isSetTopFlangeThickness()) {
			ifcAsymmetricIShapeProfileDef.setTopFlangeThickness(ifcAsymmetricIShapeProfileDef.getTopFlangeThickness() * scale);
		}
		ifcAsymmetricIShapeProfileDef.setTopFlangeWidth(ifcAsymmetricIShapeProfileDef.getTopFlangeWidth() * scale);
	}

	private static void setIfcBlock(IdEObject idEObject, float scale) {
		IfcBlock ifcBlock = (IfcBlock) idEObject;
		ifcBlock.setXLength(ifcBlock.getXLength() * scale);
		ifcBlock.setYLength(ifcBlock.getYLength() * scale);
		ifcBlock.setZLength(ifcBlock.getZLength() * scale);
	}

	private static void setIfcBoundingBox(IdEObject idEObject, float scale) {
		IfcBoundingBox ifcBoundingBox = (IfcBoundingBox) idEObject;
		ifcBoundingBox.setXDim(ifcBoundingBox.getXDim() * scale);
		ifcBoundingBox.setYDim(ifcBoundingBox.getYDim() * scale);
		ifcBoundingBox.setZDim(ifcBoundingBox.getZDim() * scale);
	}

	private static void setIfcBuilding(IdEObject idEObject, float scale) {
		IfcBuilding ifcBuilding = (IfcBuilding) idEObject;
		if (ifcBuilding.isSetElevationOfRefHeight()) {
			ifcBuilding.setElevationOfRefHeight(ifcBuilding.getElevationOfRefHeight() * scale);
		}
		if (ifcBuilding.isSetElevationOfTerrain()) {
			ifcBuilding.setElevationOfTerrain(ifcBuilding.getElevationOfTerrain() * scale);
		}
	}

	private static void setIfcBuildingStorey(IdEObject idEObject, float scale) {
		IfcBuildingStorey ifcBuildingStorey = (IfcBuildingStorey) idEObject;
		if (ifcBuildingStorey.isSetElevation()) {
			ifcBuildingStorey.setElevation(ifcBuildingStorey.getElevation() * scale);
		}
	}

	private static void setIfcCartesianPoint(IdEObject idEObject, float scale) {
		IfcCartesianPoint ifcCartesianPoint = (IfcCartesianPoint) idEObject;
		EList<Float> coordinates = ifcCartesianPoint.getCoordinates();
		for (int index = 0; index < coordinates.size(); index++) {
			coordinates.set(index, coordinates.get(index) * scale);
		}
	}

	private static void setIfcCenterLineProfileDef(IdEObject idEObject, float scale) {
		IfcCenterLineProfileDef ifcCenterLineProfileDef = (IfcCenterLineProfileDef) idEObject;
		ifcCenterLineProfileDef.setThickness(ifcCenterLineProfileDef.getThickness() * scale);
	}

	private static void setIfcChamferEdgeFeature(IdEObject idEObject, float scale) {
		setIfcEdgeFeature(idEObject, scale);
		IfcChamferEdgeFeature ifcChamferEdgeFeature = (IfcChamferEdgeFeature) idEObject;
		if (ifcChamferEdgeFeature.isSetHeight()) {
			ifcChamferEdgeFeature.setHeight(ifcChamferEdgeFeature.getHeight() * scale);
		}
		if (ifcChamferEdgeFeature.isSetWidth()) {
			ifcChamferEdgeFeature.setWidth(ifcChamferEdgeFeature.getWidth() * scale);
		}
	}

	private static void setIfcDoor(IdEObject idEObject, float scale) {
		IfcDoor ifcDoor = (IfcDoor) idEObject;
		if (ifcDoor.isSetOverallHeight()) {
			ifcDoor.setOverallHeight(ifcDoor.getOverallHeight() * scale);
		}
		if (ifcDoor.isSetOverallWidth()) {
			ifcDoor.setOverallWidth(ifcDoor.getOverallWidth() * scale);
		}
	}

	private static void setIfcDoorLiningProperties(IdEObject idEObject, float scale) {
		IfcDoorLiningProperties ifcDoorLiningProperties = (IfcDoorLiningProperties) idEObject;
		if (ifcDoorLiningProperties.isSetCasingDepth()) {
			ifcDoorLiningProperties.setCasingDepth(ifcDoorLiningProperties.getCasingDepth() * scale);
		}
		if (ifcDoorLiningProperties.isSetCasingThickness()) {
			ifcDoorLiningProperties.setCasingThickness(ifcDoorLiningProperties.getCasingThickness() * scale);
		}
		if (ifcDoorLiningProperties.isSetLiningDepth()) {
			ifcDoorLiningProperties.setLiningDepth(ifcDoorLiningProperties.getLiningDepth() * scale);
		}
		if (ifcDoorLiningProperties.isSetLiningOffset()) {
			ifcDoorLiningProperties.setLiningOffset(ifcDoorLiningProperties.getLiningOffset() * scale);
		}
		if (ifcDoorLiningProperties.isSetLiningThickness()) {
			ifcDoorLiningProperties.setLiningThickness(ifcDoorLiningProperties.getLiningThickness() * scale);
		}
		if (ifcDoorLiningProperties.isSetThresholdDepth()) {
			ifcDoorLiningProperties.setThresholdDepth(ifcDoorLiningProperties.getThresholdDepth() * scale);
		}
		if (ifcDoorLiningProperties.isSetThresholdOffset()) {
			ifcDoorLiningProperties.setThresholdOffset(ifcDoorLiningProperties.getThresholdOffset() * scale);
		}
		if (ifcDoorLiningProperties.isSetThresholdThickness()) {
			ifcDoorLiningProperties.setThresholdThickness(ifcDoorLiningProperties.getThresholdThickness() * scale);
		}
		if (ifcDoorLiningProperties.isSetTransomOffset()) {
			ifcDoorLiningProperties.setTransomOffset(ifcDoorLiningProperties.getTransomOffset() * scale);
		}
		if (ifcDoorLiningProperties.isSetTransomThickness()) {
			ifcDoorLiningProperties.setTransomThickness(ifcDoorLiningProperties.getTransomThickness() * scale);
		}
	}

	private static void setIfcDoorPanelProperties(IdEObject idEObject, float scale) {
		IfcDoorPanelProperties ifcDoorPanelProperties = (IfcDoorPanelProperties) idEObject;
		if (ifcDoorPanelProperties.isSetPanelDepth()) {
			ifcDoorPanelProperties.setPanelDepth(ifcDoorPanelProperties.getPanelDepth() * scale);
		}
	}

	private static void setIfcEdgeFeature(IdEObject idEObject, float scale) {
		IfcEdgeFeature ifcEdgeFeature = (IfcEdgeFeature) idEObject;
		if (ifcEdgeFeature.isSetFeatureLength()) {
			ifcEdgeFeature.setFeatureLength(ifcEdgeFeature.getFeatureLength() * scale);
		}
	}

	private static void setIfcEllipse(IdEObject idEObject, float scale) {
		IfcEllipse ifcEllipse = (IfcEllipse) idEObject;
		ifcEllipse.setSemiAxis1(ifcEllipse.getSemiAxis1() * scale);
		ifcEllipse.setSemiAxis2(ifcEllipse.getSemiAxis2() * scale);
	}

	private static void setIfcEllipseProfileDef(IdEObject idEObject, float scale) {
		IfcEllipseProfileDef ifcEllipseProfileDef = (IfcEllipseProfileDef) idEObject;
		ifcEllipseProfileDef.setSemiAxis1(ifcEllipseProfileDef.getSemiAxis1() * scale);
		ifcEllipseProfileDef.setSemiAxis2(ifcEllipseProfileDef.getSemiAxis2() * scale);
	}

	private static void setIfcExtrudedAreaSolid(IdEObject idEObject, float scale) {
		IfcExtrudedAreaSolid ifcExtrudedAreaSolid = (IfcExtrudedAreaSolid) idEObject;
		ifcExtrudedAreaSolid.setDepth(ifcExtrudedAreaSolid.getDepth() * scale);
	}

	private static void setIfcGeneralProfileProperties(IdEObject idEObject, float scale) {
		IfcGeneralProfileProperties ifcGeneralProfileProperties = (IfcGeneralProfileProperties) idEObject;
		if (ifcGeneralProfileProperties.isSetMaximumPlateThickness()) {
			ifcGeneralProfileProperties.setMaximumPlateThickness(ifcGeneralProfileProperties.getMaximumPlateThickness() * scale);
		}
		if (ifcGeneralProfileProperties.isSetMinimumPlateThickness()) {
			ifcGeneralProfileProperties.setMinimumPlateThickness(ifcGeneralProfileProperties.getMinimumPlateThickness() * scale);
		}
		ifcGeneralProfileProperties.setPerimeter(ifcGeneralProfileProperties.getPerimeter() * scale);
	}

	private static void setIfcCircle(IdEObject idEObject, float scale) {
		IfcCircle ifcCircle = (IfcCircle) idEObject;
		ifcCircle.setRadius(ifcCircle.getRadius() * scale);
	}

	private static void setIfcCircleHollowProfileDef(IdEObject idEObject, float scale) {
		setIfcCircleProfileDef(idEObject, scale);
		IfcCircleHollowProfileDef ifcCircleHollowProfileDef = (IfcCircleHollowProfileDef) idEObject;
		ifcCircleHollowProfileDef.setWallThickness(ifcCircleHollowProfileDef.getWallThickness() * scale);
	}

	private static void setIfcCircleProfileDef(IdEObject idEObject, float scale) {
		IfcCircleProfileDef ifcCircleProfileDef = (IfcCircleProfileDef) idEObject;
		ifcCircleProfileDef.setRadius(ifcCircleProfileDef.getRadius() * scale);
	}

	private static void setIfcCraneRailAShapeProfileDef(IdEObject idEObject, float scale) {
		IfcCraneRailAShapeProfileDef ifcCraneRailAShapeProfileDef = (IfcCraneRailAShapeProfileDef) idEObject;
		ifcCraneRailAShapeProfileDef.setBaseDepth1(ifcCraneRailAShapeProfileDef.getBaseDepth1() * scale);
		ifcCraneRailAShapeProfileDef.setBaseDepth2(ifcCraneRailAShapeProfileDef.getBaseDepth2() * scale);
		ifcCraneRailAShapeProfileDef.setBaseDepth3(ifcCraneRailAShapeProfileDef.getBaseDepth3() * scale);
		ifcCraneRailAShapeProfileDef.setBaseWidth2(ifcCraneRailAShapeProfileDef.getBaseWidth2() * scale);
		ifcCraneRailAShapeProfileDef.setBaseWidth4(ifcCraneRailAShapeProfileDef.getBaseWidth4() * scale);
		if (ifcCraneRailAShapeProfileDef.isSetCentreOfGravityInY()) {
			ifcCraneRailAShapeProfileDef.setCentreOfGravityInY(ifcCraneRailAShapeProfileDef.getCentreOfGravityInY() * scale);
		}
		ifcCraneRailAShapeProfileDef.setHeadDepth2(ifcCraneRailAShapeProfileDef.getHeadDepth2() * scale);
		ifcCraneRailAShapeProfileDef.setHeadDepth3(ifcCraneRailAShapeProfileDef.getHeadDepth3() * scale);
		ifcCraneRailAShapeProfileDef.setHeadWidth(ifcCraneRailAShapeProfileDef.getHeadWidth() * scale);
		ifcCraneRailAShapeProfileDef.setOverallHeight(ifcCraneRailAShapeProfileDef.getOverallHeight() * scale);
		if (ifcCraneRailAShapeProfileDef.isSetRadius()) {
			ifcCraneRailAShapeProfileDef.setRadius(ifcCraneRailAShapeProfileDef.getRadius() * scale);
		}
		ifcCraneRailAShapeProfileDef.setWebThickness(ifcCraneRailAShapeProfileDef.getWebThickness() * scale);
	}

	private static void setIfcCraneRailFShapeProfileDef(IdEObject idEObject, float scale) {
		IfcCraneRailFShapeProfileDef ifcCraneRailFShapeProfileDef = (IfcCraneRailFShapeProfileDef) idEObject;
		ifcCraneRailFShapeProfileDef.setBaseDepth1(ifcCraneRailFShapeProfileDef.getBaseDepth1() * scale);
		ifcCraneRailFShapeProfileDef.setBaseDepth2(ifcCraneRailFShapeProfileDef.getBaseDepth2() * scale);
		if (ifcCraneRailFShapeProfileDef.isSetCentreOfGravityInY()) {
			ifcCraneRailFShapeProfileDef.setCentreOfGravityInY(ifcCraneRailFShapeProfileDef.getCentreOfGravityInY() * scale);
		}
		ifcCraneRailFShapeProfileDef.setHeadDepth2(ifcCraneRailFShapeProfileDef.getHeadDepth2() * scale);
		ifcCraneRailFShapeProfileDef.setHeadDepth3(ifcCraneRailFShapeProfileDef.getHeadDepth3() * scale);
		ifcCraneRailFShapeProfileDef.setHeadWidth(ifcCraneRailFShapeProfileDef.getHeadWidth() * scale);
		ifcCraneRailFShapeProfileDef.setOverallHeight(ifcCraneRailFShapeProfileDef.getOverallHeight() * scale);
		if (ifcCraneRailFShapeProfileDef.isSetRadius()) {
			ifcCraneRailFShapeProfileDef.setRadius(ifcCraneRailFShapeProfileDef.getRadius() * scale);
		}
		ifcCraneRailFShapeProfileDef.setWebThickness(ifcCraneRailFShapeProfileDef.getWebThickness() * scale);
	}

	private static void setIfcConnectionPointEccentricity(IdEObject idEObject, float scale) {
		IfcConnectionPointEccentricity ifcConnectionPointEccentricity = (IfcConnectionPointEccentricity) idEObject;
		if (ifcConnectionPointEccentricity.isSetEccentricityInX()) {
			ifcConnectionPointEccentricity.setEccentricityInX(ifcConnectionPointEccentricity.getEccentricityInX() * scale);
		}
		if (ifcConnectionPointEccentricity.isSetEccentricityInY()) {
			ifcConnectionPointEccentricity.setEccentricityInY(ifcConnectionPointEccentricity.getEccentricityInY() * scale);
		}
		if (ifcConnectionPointEccentricity.isSetEccentricityInZ()) {
			ifcConnectionPointEccentricity.setEccentricityInZ(ifcConnectionPointEccentricity.getEccentricityInZ() * scale);
		}
	}

	private static void setIfcCShapeProfileDef(IdEObject idEObject, float scale) {
		IfcCShapeProfileDef ifcCShapeProfileDef = (IfcCShapeProfileDef) idEObject;
		if (ifcCShapeProfileDef.isSetCentreOfGravityInX()) {
			ifcCShapeProfileDef.setCentreOfGravityInX(ifcCShapeProfileDef.getCentreOfGravityInX() * scale);
		}
		ifcCShapeProfileDef.setDepth(ifcCShapeProfileDef.getDepth() * scale);
		ifcCShapeProfileDef.setGirth(ifcCShapeProfileDef.getGirth() * scale);
		if (ifcCShapeProfileDef.isSetInternalFilletRadius()) {
			ifcCShapeProfileDef.setInternalFilletRadius(ifcCShapeProfileDef.getInternalFilletRadius() * scale);
		}
		ifcCShapeProfileDef.setWallThickness(ifcCShapeProfileDef.getWallThickness() * scale);
		ifcCShapeProfileDef.setWidth(ifcCShapeProfileDef.getWidth() * scale);
	}

	private static void setIfcCurveStyleFontPattern(IdEObject idEObject, float scale) {
		IfcCurveStyleFontPattern ifcCurveStyleFontPattern = (IfcCurveStyleFontPattern) idEObject;
		ifcCurveStyleFontPattern.setVisibleSegmentLength(ifcCurveStyleFontPattern.getVisibleSegmentLength() * scale);
		ifcCurveStyleFontPattern.setInvisibleSegmentLength(ifcCurveStyleFontPattern.getInvisibleSegmentLength() * scale);
	}

	private static void setIfcIShapeProfileDef(IdEObject idEObject, float scale) {
		IfcIShapeProfileDef ifcIShapeProfileDef = (IfcIShapeProfileDef) idEObject;
		if (ifcIShapeProfileDef.isSetFilletRadius()) {
			ifcIShapeProfileDef.setFilletRadius(ifcIShapeProfileDef.getFilletRadius() * scale);
		}
		ifcIShapeProfileDef.setFlangeThickness(ifcIShapeProfileDef.getFlangeThickness() * scale);
		ifcIShapeProfileDef.setOverallDepth(ifcIShapeProfileDef.getOverallDepth() * scale);
		ifcIShapeProfileDef.setOverallWidth(ifcIShapeProfileDef.getOverallWidth() * scale);
		ifcIShapeProfileDef.setWebThickness(ifcIShapeProfileDef.getWebThickness() * scale);
	}

	private static void setIfcLightSourcePositional(IdEObject idEObject, float scale) {
		IfcLightSourcePositional ifcLightSourcePositional = (IfcLightSourcePositional) idEObject;
		ifcLightSourcePositional.setRadius(ifcLightSourcePositional.getRadius() * scale);
	}

	private static void setIfcLShapeProfileDef(IdEObject idEObject, float scale) {
		IfcLShapeProfileDef ifcLShapeProfileDef = (IfcLShapeProfileDef) idEObject;
		if (ifcLShapeProfileDef.isSetCentreOfGravityInX()) {
			ifcLShapeProfileDef.setCentreOfGravityInX(ifcLShapeProfileDef.getCentreOfGravityInX() * scale);
		}
		if (ifcLShapeProfileDef.isSetCentreOfGravityInY()) {
			ifcLShapeProfileDef.setCentreOfGravityInY(ifcLShapeProfileDef.getCentreOfGravityInY() * scale);
		}
		ifcLShapeProfileDef.setDepth(ifcLShapeProfileDef.getDepth() * scale);
		ifcLShapeProfileDef.setEdgeRadius(ifcLShapeProfileDef.getEdgeRadius() * scale);
		if (ifcLShapeProfileDef.isSetFilletRadius()) {
			ifcLShapeProfileDef.setFilletRadius(ifcLShapeProfileDef.getFilletRadius() * scale);
		}
		ifcLShapeProfileDef.setThickness(ifcLShapeProfileDef.getThickness() * scale);
		if (ifcLShapeProfileDef.isSetWidth()) {
			ifcLShapeProfileDef.setWidth(ifcLShapeProfileDef.getWidth() * scale);
		}
	}

	private static void setIfcMaterialLayer(IdEObject idEObject, float scale) {
		IfcMaterialLayer ifcMaterialLayer = (IfcMaterialLayer) idEObject;
		ifcMaterialLayer.setLayerThickness(ifcMaterialLayer.getLayerThickness() * scale);
	}

	private static void setIfcMaterialLayerSetUsage(IdEObject idEObject, float scale) {
		IfcMaterialLayerSetUsage ifcMaterialLayerSetUsage = (IfcMaterialLayerSetUsage) idEObject;
		ifcMaterialLayerSetUsage.setOffsetFromReferenceLine(ifcMaterialLayerSetUsage.getOffsetFromReferenceLine() * scale);
	}

	private static void setIfcMechanicalConcreteMaterialProperties(IdEObject idEObject, float scale) {
		IfcMechanicalConcreteMaterialProperties ifcMechanicalConcreteMaterialProperties = (IfcMechanicalConcreteMaterialProperties) idEObject;
		if (ifcMechanicalConcreteMaterialProperties.isSetMaxAggregateSize()) {
			ifcMechanicalConcreteMaterialProperties.setMaxAggregateSize(ifcMechanicalConcreteMaterialProperties.getMaxAggregateSize() * scale);
		}
	}

	private static void setIfcMechanicalFastener(IdEObject idEObject, float scale) {
		IfcMechanicalFastener ifcMechanicalFastener = (IfcMechanicalFastener) idEObject;
		if (ifcMechanicalFastener.isSetNominalDiameter()) {
			ifcMechanicalFastener.setNominalDiameter(ifcMechanicalFastener.getNominalDiameter() * scale);
		}
		if (ifcMechanicalFastener.isSetNominalLength()) {
			ifcMechanicalFastener.setNominalLength(ifcMechanicalFastener.getNominalLength() * scale);
		}
	}

	private static void setIfcOffsetCurve2D(IdEObject idEObject, float scale) {
		IfcOffsetCurve2D ifcOffsetCurve2D = (IfcOffsetCurve2D) idEObject;
		ifcOffsetCurve2D.setDistance(ifcOffsetCurve2D.getDistance() * scale);
	}

	private static void setIfcOffsetCurve3D(IdEObject idEObject, float scale) {
		IfcOffsetCurve3D ifcOffsetCurve3D = (IfcOffsetCurve3D) idEObject;
		ifcOffsetCurve3D.setDistance(ifcOffsetCurve3D.getDistance() * scale);
	}

	private static void setIfcPermeableCoveringProperties(IdEObject idEObject, float scale) {
		IfcPermeableCoveringProperties ifcPermeableCoveringProperties = (IfcPermeableCoveringProperties) idEObject;
		if (ifcPermeableCoveringProperties.isSetFrameDepth()) {
			ifcPermeableCoveringProperties.setFrameDepth(ifcPermeableCoveringProperties.getFrameDepth() * scale);
		}
		if (ifcPermeableCoveringProperties.isSetFrameThickness()) {
			ifcPermeableCoveringProperties.setFrameThickness(ifcPermeableCoveringProperties.getFrameThickness() * scale);
		}
	}

	private static void setIfcPlanarExtent(IdEObject idEObject, float scale) {
		IfcPlanarExtent ifcPlanarExtent = (IfcPlanarExtent) idEObject;
		ifcPlanarExtent.setSizeInX(ifcPlanarExtent.getSizeInX() * scale);
		ifcPlanarExtent.setSizeInY(ifcPlanarExtent.getSizeInY() * scale);
	}

	private static void setIfcQuantityLength(IdEObject idEObject, float scale) {
		IfcQuantityLength ifcQuantityLength = (IfcQuantityLength) idEObject;
		ifcQuantityLength.setLengthValue(ifcQuantityLength.getLengthValue() * scale);
	}

	private static void setIfcRectangleHollowProfileDef(IdEObject idEObject, float scale) {
		setIfcRectangleProfileDef(idEObject, scale);
		IfcRectangleHollowProfileDef ifcRectangleHollowProfileDef = (IfcRectangleHollowProfileDef) idEObject;
		if (ifcRectangleHollowProfileDef.isSetInnerFilletRadius()) {
			ifcRectangleHollowProfileDef.setInnerFilletRadius(ifcRectangleHollowProfileDef.getInnerFilletRadius() * scale);
		}
		if (ifcRectangleHollowProfileDef.isSetOuterFilletRadius()) {
			ifcRectangleHollowProfileDef.setOuterFilletRadius(ifcRectangleHollowProfileDef.getOuterFilletRadius() * scale);
		}
		ifcRectangleHollowProfileDef.setWallThickness(ifcRectangleHollowProfileDef.getWallThickness() * scale);
	}

	private static void setIfcRectangleProfileDef(IdEObject idEObject, float scale) {
		IfcRectangleProfileDef ifcRectangleProfileDef = (IfcRectangleProfileDef) idEObject;
		ifcRectangleProfileDef.setXDim(ifcRectangleProfileDef.getXDim() * scale);
		ifcRectangleProfileDef.setYDim(ifcRectangleProfileDef.getYDim() * scale);
	}

	private static void setIfcRectangularPyramid(IdEObject idEObject, float scale) {
		IfcRectangularPyramid ifcRectangularPyramid = (IfcRectangularPyramid) idEObject;
		ifcRectangularPyramid.setHeight(ifcRectangularPyramid.getHeight() * scale);
		ifcRectangularPyramid.setXLength(ifcRectangularPyramid.getXLength() * scale);
		ifcRectangularPyramid.setYLength(ifcRectangularPyramid.getYLength() * scale);
	}

	private static void setIfcReinforcementBarProperties(IdEObject idEObject, float scale) {
		IfcReinforcementBarProperties ifcReinforcementBarProperties = (IfcReinforcementBarProperties) idEObject;
		if (ifcReinforcementBarProperties.isSetEffectiveDepth()) {
			ifcReinforcementBarProperties.setEffectiveDepth(ifcReinforcementBarProperties.getEffectiveDepth() * scale);
		}
		if (ifcReinforcementBarProperties.isSetNominalBarDiameter()) {
			ifcReinforcementBarProperties.setNominalBarDiameter(ifcReinforcementBarProperties.getNominalBarDiameter() * scale);
		}
	}

	private static void setIfcReinforcingBar(IdEObject idEObject, float scale) {
		IfcReinforcingBar ifcReinforcingBar = (IfcReinforcingBar) idEObject;
		if (ifcReinforcingBar.isSetBarLength()) {
			ifcReinforcingBar.setBarLength(ifcReinforcingBar.getBarLength() * scale);
		}
		ifcReinforcingBar.setNominalDiameter(ifcReinforcingBar.getNominalDiameter() * scale);
	}

	private static void setIfcReinforcingMesh(IdEObject idEObject, float scale) {
		IfcReinforcingMesh ifcReinforcingMesh = (IfcReinforcingMesh) idEObject;
		if (ifcReinforcingMesh.isSetMeshLength()) {
			ifcReinforcingMesh.setMeshLength(ifcReinforcingMesh.getMeshLength() * scale);
		}
		if (ifcReinforcingMesh.isSetMeshWidth()) {
			ifcReinforcingMesh.setMeshWidth(ifcReinforcingMesh.getMeshWidth() * scale);
		}
		ifcReinforcingMesh.setLongitudinalBarNominalDiameter(ifcReinforcingMesh.getLongitudinalBarNominalDiameter() * scale);
		ifcReinforcingMesh.setLongitudinalBarSpacing(ifcReinforcingMesh.getLongitudinalBarSpacing() * scale);
		ifcReinforcingMesh.setTransverseBarNominalDiameter(ifcReinforcingMesh.getLongitudinalBarSpacing() * scale);
		ifcReinforcingMesh.setTransverseBarSpacing(ifcReinforcingMesh.getTransverseBarSpacing() * scale);
	}

	private static void setIfcRelConnectsStructuralMember(IdEObject idEObject, float scale) {
		IfcRelConnectsStructuralMember ifcRelConnectsStructuralMember = (IfcRelConnectsStructuralMember) idEObject;
		if (ifcRelConnectsStructuralMember.isSetSupportedLength()) {
			ifcRelConnectsStructuralMember.setSupportedLength(ifcRelConnectsStructuralMember.getSupportedLength() * scale);
		}
	}

	private static void setIfcRibPlateProfileProperties(IdEObject idEObject, float scale) {
		IfcRibPlateProfileProperties ifcRibPlateProfileProperties = (IfcRibPlateProfileProperties) idEObject;
		if (ifcRibPlateProfileProperties.isSetRibHeight()) {
			ifcRibPlateProfileProperties.setRibHeight(ifcRibPlateProfileProperties.getRibHeight() * scale);
		}
		if (ifcRibPlateProfileProperties.isSetRibSpacing()) {
			ifcRibPlateProfileProperties.setRibSpacing(ifcRibPlateProfileProperties.getRibSpacing() * scale);
		}
		if (ifcRibPlateProfileProperties.isSetRibWidth()) {
			ifcRibPlateProfileProperties.setRibWidth(ifcRibPlateProfileProperties.getRibWidth() * scale);
		}
		if (ifcRibPlateProfileProperties.isSetThickness()) {
			ifcRibPlateProfileProperties.setThickness(ifcRibPlateProfileProperties.getThickness() * scale);
		}
	}

	private static void setIfcRightCircularCone(IdEObject idEObject, float scale) {
		IfcRightCircularCone ifcRightCircularCone = (IfcRightCircularCone) idEObject;
		ifcRightCircularCone.setBottomRadius(ifcRightCircularCone.getBottomRadius() * scale);
		ifcRightCircularCone.setHeight(ifcRightCircularCone.getHeight() * scale);
	}

	private static void setIfcRightCircularCylinder(IdEObject idEObject, float scale) {
		IfcRightCircularCylinder ifcRightCircularCylinder = (IfcRightCircularCylinder) idEObject;
		ifcRightCircularCylinder.setHeight(ifcRightCircularCylinder.getHeight() * scale);
		ifcRightCircularCylinder.setRadius(ifcRightCircularCylinder.getRadius() * scale);
	}

	private static void setIfcRoundedEdgeFeature(IdEObject idEObject, float scale) {
		setIfcEdgeFeature(idEObject, scale);
		IfcRoundedEdgeFeature ifcRoundedEdgeFeature = (IfcRoundedEdgeFeature) idEObject;
		if (ifcRoundedEdgeFeature.isSetRadius()) {
			ifcRoundedEdgeFeature.setRadius(ifcRoundedEdgeFeature.getRadius() * scale);
		}
	}

	private static void setIfcRoundedRectangleProfileDef(IdEObject idEObject, float scale) {
		setIfcRectangleProfileDef(idEObject, scale);
		IfcRoundedRectangleProfileDef ifcRoundedRectangleProfileDef = (IfcRoundedRectangleProfileDef) idEObject;
		ifcRoundedRectangleProfileDef.setRoundingRadius(ifcRoundedRectangleProfileDef.getRoundingRadius() * scale);
	}

	private static void setIfcSectionReinforcementProperties(IdEObject idEObject, float scale) {
		IfcSectionReinforcementProperties ifcSectionReinforcementProperties = (IfcSectionReinforcementProperties) idEObject;
		ifcSectionReinforcementProperties.setLongitudinalEndPosition(ifcSectionReinforcementProperties.getLongitudinalEndPosition() * scale);
		ifcSectionReinforcementProperties.setLongitudinalStartPosition(ifcSectionReinforcementProperties.getLongitudinalStartPosition() * scale);
		if (ifcSectionReinforcementProperties.isSetTransversePosition()) {
			ifcSectionReinforcementProperties.setTransversePosition(ifcSectionReinforcementProperties.getTransversePosition() * scale);
		}
	}

	private static void setIfcSite(IdEObject idEObject, float scale) {
		IfcSite ifcSite = (IfcSite) idEObject;
		if (ifcSite.isSetRefElevation()) {
			ifcSite.setRefElevation(ifcSite.getRefElevation() * scale);
		}
	}

	private static void setIfcSlippageConnectionCondition(IdEObject idEObject, float scale) {
		IfcSlippageConnectionCondition ifcSlippageConnectionCondition = (IfcSlippageConnectionCondition) idEObject;
		if (ifcSlippageConnectionCondition.isSetSlippageX()) {
			ifcSlippageConnectionCondition.setSlippageX(ifcSlippageConnectionCondition.getSlippageX() * scale);
		}
		if (ifcSlippageConnectionCondition.isSetSlippageY()) {
			ifcSlippageConnectionCondition.setSlippageY(ifcSlippageConnectionCondition.getSlippageY() * scale);
		}
		if (ifcSlippageConnectionCondition.isSetSlippageZ()) {
			ifcSlippageConnectionCondition.setSlippageZ(ifcSlippageConnectionCondition.getSlippageZ() * scale);
		}
	}

	private static void setIfcSpace(IdEObject idEObject, float scale) {
		IfcSpace ifcSpace = (IfcSpace) idEObject;
		if (ifcSpace.isSetElevationWithFlooring()) {
			ifcSpace.setElevationWithFlooring(ifcSpace.getElevationWithFlooring() * scale);
		}
	}

	private static void setIfcSphere(IdEObject idEObject, float scale) {
		IfcSphere ifcSphere = (IfcSphere) idEObject;
		ifcSphere.setRadius(ifcSphere.getRadius() * scale);
	}

	private static void setIfcStairFlight(IdEObject idEObject, float scale) {
		IfcStairFlight ifcStairFlight = (IfcStairFlight) idEObject;
		if (ifcStairFlight.isSetRiserHeight()) {
			ifcStairFlight.setRiserHeight(ifcStairFlight.getRiserHeight() * scale);
		}
		if (ifcStairFlight.isSetTreadLength()) {
			ifcStairFlight.setTreadLength(ifcStairFlight.getTreadLength() * scale);
		}
	}

	private static void setIfcStructuralLoadSingleDisplacement(IdEObject idEObject, float scale) {
		IfcStructuralLoadSingleDisplacement ifcStructuralLoadSingleDisplacement = (IfcStructuralLoadSingleDisplacement) idEObject;
		if (ifcStructuralLoadSingleDisplacement.isSetDisplacementX()) {
			ifcStructuralLoadSingleDisplacement.setDisplacementX(ifcStructuralLoadSingleDisplacement.getDisplacementX() * scale);
		}
		if (ifcStructuralLoadSingleDisplacement.isSetDisplacementY()) {
			ifcStructuralLoadSingleDisplacement.setDisplacementY(ifcStructuralLoadSingleDisplacement.getDisplacementY() * scale);
		}
		if (ifcStructuralLoadSingleDisplacement.isSetDisplacementZ()) {
			ifcStructuralLoadSingleDisplacement.setDisplacementZ(ifcStructuralLoadSingleDisplacement.getDisplacementZ() * scale);
		}
	}

	private static void setIfcStructuralProfileProperties(IdEObject idEObject, float scale) {
		setIfcGeneralProfileProperties(idEObject, scale);
		IfcStructuralProfileProperties ifcStructuralProfileProperties = (IfcStructuralProfileProperties) idEObject;
		if (ifcStructuralProfileProperties.isSetCentreOfGravityInX()) {
			ifcStructuralProfileProperties.setCentreOfGravityInX(ifcStructuralProfileProperties.getCentreOfGravityInX() * scale);
		}
		if (ifcStructuralProfileProperties.isSetCentreOfGravityInY()) {
			ifcStructuralProfileProperties.setCentreOfGravityInY(ifcStructuralProfileProperties.getCentreOfGravityInY() * scale);
		}
		if (ifcStructuralProfileProperties.isSetShearCentreY()) {
			ifcStructuralProfileProperties.setShearCentreY(ifcStructuralProfileProperties.getShearCentreY() * scale);
		}
		if (ifcStructuralProfileProperties.isSetShearCentreZ()) {
			ifcStructuralProfileProperties.setShearCentreZ(ifcStructuralProfileProperties.getShearCentreZ() * scale);
		}
	}

	private static void setIfcStructuralSurfaceMember(IdEObject idEObject, float scale) {
		IfcStructuralSurfaceMember ifcStructuralSurfaceMember = (IfcStructuralSurfaceMember) idEObject;
		if (ifcStructuralSurfaceMember.isSetThickness()) {
			ifcStructuralSurfaceMember.setThickness(ifcStructuralSurfaceMember.getThickness() * scale);
		}
	}

	private static void setIfcStructuralSurfaceMemberVarying(IdEObject idEObject, float scale) {
		setIfcStructuralSurfaceMember(idEObject, scale);
		IfcStructuralSurfaceMemberVarying ifcStructuralSurfaceMemberVarying = (IfcStructuralSurfaceMemberVarying) idEObject;
		EList<Float> subsequentThickness = ifcStructuralSurfaceMemberVarying.getSubsequentThickness();
		for (int index = 0; index < subsequentThickness.size(); index++) {
			subsequentThickness.set(index, subsequentThickness.get(index) * scale);
		}
	}

	private static void setIfcSurfaceOfLinearExtrusion(IdEObject idEObject, float scale) {
		IfcSurfaceOfLinearExtrusion ifcSurfaceOfLinearExtrusion = (IfcSurfaceOfLinearExtrusion) idEObject;
		ifcSurfaceOfLinearExtrusion.setDepth(ifcSurfaceOfLinearExtrusion.getDepth() * scale);
	}

	private static void setIfcSweptDiskSolid(IdEObject idEObject, float scale) {
		IfcSweptDiskSolid ifcSweptDiskSolid = (IfcSweptDiskSolid) idEObject;
		if (ifcSweptDiskSolid.isSetInnerRadius()) {
			ifcSweptDiskSolid.setInnerRadius(ifcSweptDiskSolid.getInnerRadius() * scale);
		}
		ifcSweptDiskSolid.setRadius(ifcSweptDiskSolid.getRadius() * scale);
	}

	private static void setIfcTendon(IdEObject idEObject, float scale) {
		IfcTendon ifcTendon = (IfcTendon) idEObject;
		if (ifcTendon.isSetAnchorageSlip()) {
			ifcTendon.setAnchorageSlip(ifcTendon.getAnchorageSlip() * scale);
		}
		if (ifcTendon.isSetMinCurvatureRadius()) {
			ifcTendon.setMinCurvatureRadius(ifcTendon.getMinCurvatureRadius() * scale);
		}
		ifcTendon.setNominalDiameter(ifcTendon.getNominalDiameter() * scale);
	}

	private static void setIfcTextStyleWithBoxCharacteristics(IdEObject idEObject, float scale) {
		IfcTextStyleWithBoxCharacteristics ifcTextStyleWithBoxCharacteristics = (IfcTextStyleWithBoxCharacteristics) idEObject;
		if (ifcTextStyleWithBoxCharacteristics.isSetBoxHeight()) {
			ifcTextStyleWithBoxCharacteristics.setBoxHeight(ifcTextStyleWithBoxCharacteristics.getBoxHeight() * scale);
		}
		if (ifcTextStyleWithBoxCharacteristics.isSetBoxWidth()) {
			ifcTextStyleWithBoxCharacteristics.setBoxWidth(ifcTextStyleWithBoxCharacteristics.getBoxWidth() * scale);
		}
	}

	private static void setIfcTrapeziumProfileDef(IdEObject idEObject, float scale) {
		IfcTrapeziumProfileDef ifcTrapeziumProfileDef = (IfcTrapeziumProfileDef) idEObject;
		ifcTrapeziumProfileDef.setBottomXDim(ifcTrapeziumProfileDef.getBottomXDim() * scale);
		ifcTrapeziumProfileDef.setTopXDim(ifcTrapeziumProfileDef.getTopXDim() * scale);
		ifcTrapeziumProfileDef.setTopXOffset(ifcTrapeziumProfileDef.getTopXOffset() * scale);
		ifcTrapeziumProfileDef.setYDim(ifcTrapeziumProfileDef.getYDim() * scale);
	}

	private static void setIfcTShapeProfileDef(IdEObject idEObject, float scale) {
		IfcTShapeProfileDef ifcTShapeProfileDef = (IfcTShapeProfileDef) idEObject;
		if (ifcTShapeProfileDef.isSetCentreOfGravityInY()) {
			ifcTShapeProfileDef.setCentreOfGravityInY(ifcTShapeProfileDef.getCentreOfGravityInY() * scale);
		}
		ifcTShapeProfileDef.setDepth(ifcTShapeProfileDef.getDepth() * scale);
		if (ifcTShapeProfileDef.isSetFilletRadius()) {
			ifcTShapeProfileDef.setFilletRadius(ifcTShapeProfileDef.getFilletRadius() * scale);
		}
		ifcTShapeProfileDef.setFlangeWidth(ifcTShapeProfileDef.getFlangeWidth() * scale);
		ifcTShapeProfileDef.setFlangeThickness(ifcTShapeProfileDef.getFlangeThickness() * scale);
		ifcTShapeProfileDef.setFlangeWidth(ifcTShapeProfileDef.getFlangeWidth() * scale);
		if (ifcTShapeProfileDef.isSetWebEdgeRadius()) {
			ifcTShapeProfileDef.setWebEdgeRadius(ifcTShapeProfileDef.getWebEdgeRadius() * scale);
		}
		ifcTShapeProfileDef.setWebThickness(ifcTShapeProfileDef.getWebThickness() * scale);
	}

	private static void setIfcUShapeProfileDef(IdEObject idEObject, float scale) {
		IfcUShapeProfileDef ifcUShapeProfileDef = (IfcUShapeProfileDef) idEObject;
		if (ifcUShapeProfileDef.isSetCentreOfGravityInX()) {
			ifcUShapeProfileDef.setCentreOfGravityInX(ifcUShapeProfileDef.getCentreOfGravityInX() * scale);
		}
		ifcUShapeProfileDef.setDepth(ifcUShapeProfileDef.getDepth() * scale);
		if (ifcUShapeProfileDef.isSetEdgeRadius()) {
			ifcUShapeProfileDef.setEdgeRadius(ifcUShapeProfileDef.getEdgeRadius() * scale);
		}
		if (ifcUShapeProfileDef.isSetFilletRadius()) {
			ifcUShapeProfileDef.setFilletRadius(ifcUShapeProfileDef.getFilletRadius() * scale);
		}
		ifcUShapeProfileDef.setFlangeThickness(ifcUShapeProfileDef.getFlangeThickness() * scale);
		ifcUShapeProfileDef.setFlangeWidth(ifcUShapeProfileDef.getFlangeWidth() * scale);
		ifcUShapeProfileDef.setWebThickness(ifcUShapeProfileDef.getWebThickness() * scale);
	}

	private static void setIfcVector(IdEObject idEObject, float scale) {
		IfcVector ifcVector = (IfcVector) idEObject;
		ifcVector.setMagnitude(ifcVector.getMagnitude() * scale);
	}

	private static void setIfcVirtualGridIntersection(IdEObject idEObject, float scale) {
		IfcVirtualGridIntersection ifcVirtualGridIntersection = (IfcVirtualGridIntersection) idEObject;
		EList<Float> offsetDistances = ifcVirtualGridIntersection.getOffsetDistances();
		for (Float offsetDistance : offsetDistances) {
			offsetDistance *= scale;
		}
	}

	private static void setIfcWindow(IdEObject idEObject, float scale) {
		IfcWindow ifcWindow = (IfcWindow) idEObject;
		if (ifcWindow.isSetOverallHeight()) {
			ifcWindow.setOverallHeight(ifcWindow.getOverallHeight() * scale);
		}
		if (ifcWindow.isSetOverallWidth()) {
			ifcWindow.setOverallWidth(ifcWindow.getOverallWidth() * scale);
		}
	}

	private static void setIfcWindowLiningProperties(IdEObject idEObject, float scale) {
		IfcWindowLiningProperties ifcWindowLiningProperties = (IfcWindowLiningProperties) idEObject;
		if (ifcWindowLiningProperties.isSetLiningDepth()) {
			ifcWindowLiningProperties.setLiningDepth(ifcWindowLiningProperties.getLiningDepth() * scale);
		}
		if (ifcWindowLiningProperties.isSetLiningThickness()) {
			ifcWindowLiningProperties.setLiningThickness(ifcWindowLiningProperties.getLiningThickness() * scale);
		}
		if (ifcWindowLiningProperties.isSetMullionThickness()) {
			ifcWindowLiningProperties.setMullionThickness(ifcWindowLiningProperties.getMullionThickness() * scale);
		}
		if (ifcWindowLiningProperties.isSetTransomThickness()) {
			ifcWindowLiningProperties.setTransomThickness(ifcWindowLiningProperties.getTransomThickness() * scale);
		}
	}

	private static void setIfcWindowPanelProperties(IdEObject idEObject, float scale) {
		IfcWindowPanelProperties ifcWindowPanelProperties = (IfcWindowPanelProperties) idEObject;
		if (ifcWindowPanelProperties.isSetFrameDepth()) {
			ifcWindowPanelProperties.setFrameDepth(ifcWindowPanelProperties.getFrameDepth() * scale);
		}
		if (ifcWindowPanelProperties.isSetFrameThickness()) {
			ifcWindowPanelProperties.setFrameThickness(ifcWindowPanelProperties.getFrameThickness() * scale);
		}
	}

	private static void setIfcZShapeProfileDef(IdEObject idEObject, float scale) {
		IfcZShapeProfileDef ifcZShapeProfileDef = (IfcZShapeProfileDef) idEObject;
		ifcZShapeProfileDef.setDepth(ifcZShapeProfileDef.getDepth() * scale);
		if (ifcZShapeProfileDef.isSetEdgeRadius()) {
			ifcZShapeProfileDef.setEdgeRadius(ifcZShapeProfileDef.getEdgeRadius() * scale);
		}
		if (ifcZShapeProfileDef.isSetFilletRadius()) {
			ifcZShapeProfileDef.setFilletRadius(ifcZShapeProfileDef.getFilletRadius() * scale);
		}
		ifcZShapeProfileDef.setFlangeThickness(ifcZShapeProfileDef.getFlangeThickness() * scale);
		ifcZShapeProfileDef.setFlangeWidth(ifcZShapeProfileDef.getFlangeWidth() * scale);
		ifcZShapeProfileDef.setWebThickness(ifcZShapeProfileDef.getWebThickness() * scale);
	}

	private static float getLengthUnitPrefix(IfcModel model) {
		float lengthUnitPrefix = 1.0f;
		boolean prefixFound = false;
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				IfcUnitAssignment unitsInContext = ((IfcProject) object).getUnitsInContext();
				EList<IfcUnit> units = unitsInContext.getUnits();
				for (IfcUnit unit : units) {
					if (unit instanceof IfcSIUnit) {
						IfcSIUnit ifcSIUnit = (IfcSIUnit) unit;
						IfcUnitEnum unitType = ifcSIUnit.getUnitType();
						if (unitType == IfcUnitEnum.LENGTHUNIT) {
							IfcSIPrefix prefix = ifcSIUnit.getPrefix();
							if (prefix != null) {
								prefixFound = true;
								switch (prefix) {
								case EXA:
									lengthUnitPrefix = 1.0e18f;
									break;
								case PETA:
									lengthUnitPrefix = 1.0e15f;
									break;
								case TERA:
									lengthUnitPrefix = 1.0e12f;
									break;
								case GIGA:
									lengthUnitPrefix = 1.0e9f;
									break;
								case MEGA:
									lengthUnitPrefix = 1.0e6f;
									break;
								case KILO:
									lengthUnitPrefix = 1.0e3f;
									break;
								case HECTO:
									lengthUnitPrefix = 1.0e2f;
									break;
								case DECA:
									lengthUnitPrefix = 1.0e1f;
									break;
								case DECI:
									lengthUnitPrefix = 1.0e-1f;
									break;
								case CENTI:
									lengthUnitPrefix = 1.0e-2f;
									break;
								case MILLI:
									lengthUnitPrefix = 1.0e-3f;
									break;
								case MICRO:
									lengthUnitPrefix = 1.0e-6f;
									break;
								case NANO:
									lengthUnitPrefix = 1.0e-9f;
									break;
								case PICO:
									lengthUnitPrefix = 1.0e-12f;
									break;
								case FEMTO:
									lengthUnitPrefix = 1.0e-15f;
									break;
								case ATTO:
									lengthUnitPrefix = 1.0e-18f;
									break;
								case NULL:
									break;
								}
								break;
							}
						}
					}
				}
			}
			if (prefixFound)
				break;
		}
		return lengthUnitPrefix;
	}

	private static void setLengthUnitToMilli(IfcModel model) {
		Map<Long, IdEObject> objects = model.getObjects();
		boolean prefixFound = false;
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				IfcUnitAssignment unitsInContext = ((IfcProject) object).getUnitsInContext();
				EList<IfcUnit> units = unitsInContext.getUnits();
				for (IfcUnit unit : units) {
					if (unit instanceof IfcSIUnit) {
						IfcSIUnit ifcSIUnit = (IfcSIUnit) unit;
						IfcUnitEnum unitType = ifcSIUnit.getUnitType();
						if (unitType == IfcUnitEnum.LENGTHUNIT) {
							prefixFound = true;
							ifcSIUnit.setPrefix(IfcSIPrefix.MILLI);
							break;
						}
					}
				}
			}
			if (prefixFound)
				break;
		}
	}

	public AccessMethod getAccessMethod() {
		return accessMethod;
	}
}