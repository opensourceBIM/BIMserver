package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.IfcAreaMeasure;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement2D;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBoolean;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcClassificationNotationSelect;
import org.bimserver.models.ifc2x3tc1.IfcElectricCurrentMeasure;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcGridPlacement;
import org.bimserver.models.ifc2x3tc1.IfcIdentifier;
import org.bimserver.models.ifc2x3tc1.IfcInteger;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcLogical;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcObjectPlacement;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPlaneAngleMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPowerMeasure;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcQuantityVolume;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcText;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.IfcVolumeMeasure;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class IfcUtils {
	public static Path getShortestAllPaths(IdEObject start, IdEObject end) {
		Set<Path> paths = new LinkedHashSet<Path>();
		Path basePath = new Path(start);
		getAllPaths(basePath, end, paths, new HashSet<EObject>());
		System.out.println("Number of paths: " + paths.size());
		List<Path> pathList = new ArrayList<Path>(paths);
		java.util.Collections.sort(pathList, new Comparator<Path>() {
			@Override
			public int compare(Path o1, Path o2) {
				return o1.getLength() - o2.getLength();
			}
		});
		return pathList.get(0);
	}
	
	public static int getAllPaths(Path basePath, IdEObject otherObject, Set<Path> paths, Set<EObject> noConnectionPaths) {
		int connectionsFound = 0;
		if (noConnectionPaths.contains(basePath.getLastObject())) {
			return 0;
		}
		for (EReference eReference : basePath.getLastObject().eClass().getEAllReferences()) {
			Object reference = basePath.getLastObject().eGet(eReference);
			if (reference != null) {
				if (eReference.isMany()) {
					@SuppressWarnings("rawtypes")
					List list = (List)reference;
					for (int index=0; index<list.size(); index++) {
						Object refObject = list.get(index);
						IdEObject refIdEObject = (IdEObject)refObject;
						if (basePath.contains(refIdEObject)) {
							// do nothing
						} else if (refIdEObject == otherObject) {
							paths.add(new Path(basePath, eReference, index, refIdEObject));
							System.out.println(paths.size());
						} else {
							connectionsFound += getAllPaths(new Path(basePath, eReference, index, (IdEObject) refObject), otherObject, paths, noConnectionPaths);
						}
					}
				} else {
					if (basePath.contains((IdEObject) reference)) {
						// do nothing
					} else if (reference == otherObject) {
						paths.add(new Path(basePath, eReference, -1, (IdEObject) reference));
						System.out.println(paths.size());
					} else {
						connectionsFound += getAllPaths(new Path(basePath, eReference, -1, (IdEObject) reference), otherObject, paths, noConnectionPaths);
					}
				}
			}
		}
		if (connectionsFound == 0) {
			noConnectionPaths.add(basePath.getLastObject());
		}
		return connectionsFound;
	}
	
	public static IfcBuildingStorey getIfcBuildingStorey(IfcProduct ifcProduct) {
		if (ifcProduct instanceof IfcBuildingStorey) {
			return (IfcBuildingStorey) ifcProduct;
		}
		for (IfcRelDecomposes ifcRelDecomposes : ifcProduct.getDecomposes()) {
			IfcObjectDefinition relatingObject = ifcRelDecomposes.getRelatingObject();
			if (relatingObject instanceof IfcBuildingStorey) {
				return (IfcBuildingStorey)relatingObject;
			}
		}
		if (ifcProduct instanceof IfcElement) {
			IfcElement ifcElement = (IfcElement)ifcProduct;
			for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcElement.getContainedInStructure()) {
				IfcSpatialStructureElement relatingStructure = ifcRelContainedInSpatialStructure.getRelatingStructure();
				if (relatingStructure instanceof IfcBuildingStorey) {
					return (IfcBuildingStorey) relatingStructure;
				} else {
					if (relatingStructure instanceof IfcSpace) {
						return getIfcBuildingStorey(relatingStructure);
					}
				}
			}
		}
		return null;
	}

	public static List<IfcProduct> getDecomposition(IfcBuildingStorey ifcBuildingStorey) {
		List<IfcProduct> list = new ArrayList<>();
		for (IfcRelDecomposes ifcRelDecomposes : ifcBuildingStorey.getIsDecomposedBy()) {
			for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
				if (ifcObjectDefinition instanceof IfcProduct) {
					list.add((IfcProduct) ifcObjectDefinition);
				}
			}
		}
		return list;
	}

	public static List<IfcProduct> getContains(IfcBuildingStorey ifcBuildingStorey) {
		List<IfcProduct> list = new ArrayList<>();
		for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcBuildingStorey.getContainsElements()) {
			for (IfcProduct ifcProduct : ifcRelContainedInSpatialStructure.getRelatedElements()) {
				list.add(ifcProduct);
			}
		}
		return list;
	}
	
	public static IfcProject getIfcProject(IfcProduct ifcProduct) {
		if (ifcProduct instanceof IfcProject) {
			return (IfcProject) ifcProduct;
		}
		for (IfcRelDecomposes ifcRelDecomposes : ifcProduct.getDecomposes()) {
			IfcObjectDefinition relatingObject = ifcRelDecomposes.getRelatingObject();
			if (relatingObject instanceof IfcProject) {
				return (IfcProject)relatingObject;
			} else if (relatingObject instanceof IfcProduct){
				return getIfcProject((IfcProduct) relatingObject);
			}
		}
		if (ifcProduct instanceof IfcElement) {
			IfcElement ifcElement = (IfcElement)ifcProduct;
			for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcElement.getContainedInStructure()) {
				IfcSpatialStructureElement relatingStructure = ifcRelContainedInSpatialStructure.getRelatingStructure();
				if (relatingStructure instanceof IfcProject) {
					return (IfcProject) relatingStructure;
				} else if (relatingStructure instanceof IfcBuildingStorey) {
					return getIfcProject(relatingStructure);
				} else {
					if (relatingStructure instanceof IfcSpace) {
						return getIfcProject(relatingStructure);
					}
				}
			}
		}
		return null;
	}
	
	public static Tristate getBooleanProperty(IfcObject ifcObject, String propertyName) {
		for (IfcRelDefines ifcRelDefines : ifcObject.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet)propertySetDefinition;
					for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
						if (ifcProperty instanceof IfcPropertySingleValue) {
							IfcPropertySingleValue propertyValue = (IfcPropertySingleValue)ifcProperty;
							if (ifcProperty.getName().equals(propertyName)) {
								IfcBoolean label = (IfcBoolean)propertyValue.getNominalValue();
								return label.getWrappedValue();
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Lists all properties of a given IfcPopertySet that are of type IfcPropertySingleValue, all values are converted to the appropriate Java type
	 * 
	 * @param ifcObject
	 * @param propertySetName
	 * @return
	 */
	public static Map<String, Object> listProperties(IfcObject ifcObject, String propertySetName) {
		Map<String, Object> result = new HashMap<>();
		for (IfcRelDefines ifcRelDefines : ifcObject.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet)propertySetDefinition;
					if (ifcPropertySet.getName() != null && ifcPropertySet.getName().equalsIgnoreCase(propertySetName)) {
						for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
							if (ifcProperty instanceof IfcPropertySingleValue) {
								IfcPropertySingleValue propertyValue = (IfcPropertySingleValue)ifcProperty;
								result.put(propertyValue.getName(), nominalValueToObject(propertyValue.getNominalValue()));
							}
						}
					}
				}
			}
		}
		return result;
	}

	private static Object nominalValueToObject(IfcValue nominalValue) {
		if (nominalValue instanceof IfcLabel) {
			return ((IfcLabel)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcIdentifier) {
			return ((IfcIdentifier)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcBoolean) {
			return ((IfcBoolean)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcText) {
			return ((IfcText)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcLengthMeasure) {
			return ((IfcLengthMeasure)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcPlaneAngleMeasure) {
			return ((IfcPlaneAngleMeasure)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcAreaMeasure) {
			return ((IfcAreaMeasure)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcVolumeMeasure) {
			return ((IfcVolumeMeasure)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcReal) {
			return ((IfcReal)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcPowerMeasure) {
			return ((IfcPowerMeasure)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcInteger) {
			return ((IfcInteger)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcElectricCurrentMeasure) {
			return ((IfcElectricCurrentMeasure)nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcLogical) {
			return ((IfcLogical)nominalValue).getWrappedValue();
		} else {
			throw new RuntimeException("Not implemented: " + nominalValue.eClass().getName());
		}
	}
	
	private static String nominalValueToString(IfcValue nominalValue) {
		Object object = nominalValueToObject(nominalValue);
		if (object == null) {
			return null;
		}
		return object.toString();
	}

	public static String getStringProperty(IfcObject ifcObject, String propertyName) {
		for (IfcRelDefines ifcRelDefines : ifcObject.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet)propertySetDefinition;
					for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
						if (ifcProperty instanceof IfcPropertySingleValue) {
							IfcPropertySingleValue propertyValue = (IfcPropertySingleValue)ifcProperty;
							if (ifcProperty.getName().equals(propertyName)) {
								IfcValue nominalValue = propertyValue.getNominalValue();
								return nominalValueToString(nominalValue);
							}
						}
					}
				}
			}
		}
		return null;
	}

	public static Set<String> listPropertyNames(IfcProduct ifcProduct) {
		Set<String> list = new HashSet<>();
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet)propertySetDefinition;
					for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
						list.add(ifcProperty.getName());
					}
				}
			}
		}
		return list;
	}

	public static Double getIfcQuantityVolume(IfcProduct ifcProduct, String name) {
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcElementQuantity) {
					if (propertySetDefinition.getName().equals("BaseQuantities")) {
						IfcElementQuantity ifcElementQuantity = (IfcElementQuantity)propertySetDefinition;
						for (IfcPhysicalQuantity ifcPhysicalQuantity : ifcElementQuantity.getQuantities()) {
							if (ifcPhysicalQuantity instanceof IfcQuantityVolume) {
								return ((IfcQuantityVolume)ifcPhysicalQuantity).getVolumeValue();
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public static List<String> listElementQuantities(IfcProduct ifcProduct) {
		List<String> list = new ArrayList<>();
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties)ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcElementQuantity) {
					IfcElementQuantity ifcElementQuantity = (IfcElementQuantity)propertySetDefinition;
					list.add(ifcElementQuantity.getName());
				}
			}
		}
		return list;
	}

	public static double[] getAbsolutePosition(IfcProduct ifcProduct) throws PlacementNotImplementedException {
		return getAbsolutePosition(ifcProduct.getObjectPlacement());
	}
	
	/**
	 * Not finished, does not take into account the directions
	 * 
	 * @param ifcObjectPlacement
	 * @return
	 * @throws PlacementNotImplementedException
	 */
	public static double[] getAbsolutePosition(IfcObjectPlacement ifcObjectPlacement) throws PlacementNotImplementedException {
		if (ifcObjectPlacement instanceof IfcGridPlacement) {
			throw new PlacementNotImplementedException("IfcGridPlacement has not been implemented");
		} else if (ifcObjectPlacement instanceof IfcLocalPlacement) {
			IfcLocalPlacement ifcLocalPlacement = (IfcLocalPlacement)ifcObjectPlacement;
			IfcAxis2Placement relativePlacement = ifcLocalPlacement.getRelativePlacement();
			if (relativePlacement instanceof IfcAxis2Placement2D) {
				throw new PlacementNotImplementedException("IfcAxis2Placement2D has not been implemented");
			} else if (relativePlacement instanceof IfcAxis2Placement3D) {
				IfcAxis2Placement3D ifcAxis2Placement3D = (IfcAxis2Placement3D)relativePlacement;
				IfcObjectPlacement placementRelativeTo = ifcLocalPlacement.getPlacementRelTo();
				if (placementRelativeTo == null) {
					IfcCartesianPoint ifcCartesianPoint = ifcAxis2Placement3D.getLocation();
					return new double[]{ifcCartesianPoint.getCoordinates().get(0), ifcCartesianPoint.getCoordinates().get(1), ifcCartesianPoint.getCoordinates().get(2)};
				} else {
					double[] relative = getAbsolutePosition(placementRelativeTo);
					IfcCartesianPoint ifcCartesianPoint = ifcAxis2Placement3D.getLocation();
					return new double[]{relative[0] + ifcCartesianPoint.getCoordinates().get(0), relative[1] + ifcCartesianPoint.getCoordinates().get(1), relative[2] + ifcCartesianPoint.getCoordinates().get(2)};
				}
			}
		}
		return new double[]{0d, 0d, 0d};
	}

	public static List<IfcClassificationNotationSelect> getClassifications(IfcSpace ifcSpace, IfcModelInterface model) {
		List<IfcClassificationNotationSelect> result = new ArrayList<>();
		for (IfcRelAssociatesClassification ifcRelAssociatesClassification : model.getAll(IfcRelAssociatesClassification.class)) {
			if (ifcRelAssociatesClassification.getRelatedObjects().contains(ifcSpace)) {
				result.add(ifcRelAssociatesClassification.getRelatingClassification());
			}
		}
		return result;
	}

	public static boolean hasProperty(IfcProduct ifcProduct, String propertyName) {
		return listPropertyNames(ifcProduct).contains(propertyName);
	}

	public static float getLengthUnitPrefix(IfcModelInterface model) {
		float lengthUnitPrefix = 1.0f;
		boolean prefixFound = false;
		for (IfcProject ifcProject : model.getAll(IfcProject.class)) {
			IfcUnitAssignment unitsInContext = ifcProject.getUnitsInContext();
			if (unitsInContext != null) {
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
}