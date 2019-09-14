package org.bimserver.utils;

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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.lang3.NotImplementedException;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;
import org.bimserver.geometry.AxisAlignedBoundingBox2D;
import org.bimserver.geometry.AxisAlignedBoundingBox3D;
import org.bimserver.geometry.Vector2D;
import org.bimserver.geometry.Vector3D;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcAreaMeasure;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement2D;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBoolean;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcClassificationNotationSelect;
import org.bimserver.models.ifc2x3tc1.IfcCountMeasure;
import org.bimserver.models.ifc2x3tc1.IfcElectricCurrentMeasure;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcFace;
import org.bimserver.models.ifc2x3tc1.IfcFaceBound;
import org.bimserver.models.ifc2x3tc1.IfcGridPlacement;
import org.bimserver.models.ifc2x3tc1.IfcIdentifier;
import org.bimserver.models.ifc2x3tc1.IfcInteger;
import org.bimserver.models.ifc2x3tc1.IfcLabel;
import org.bimserver.models.ifc2x3tc1.IfcLengthMeasure;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcLogical;
import org.bimserver.models.ifc2x3tc1.IfcLoop;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialList;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcObjectPlacement;
import org.bimserver.models.ifc2x3tc1.IfcPhysicalQuantity;
import org.bimserver.models.ifc2x3tc1.IfcPlaneAngleMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPolyLoop;
import org.bimserver.models.ifc2x3tc1.IfcPowerMeasure;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcQuantityArea;
import org.bimserver.models.ifc2x3tc1.IfcQuantityVolume;
import org.bimserver.models.ifc2x3tc1.IfcReal;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcText;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.IfcValue;
import org.bimserver.models.ifc2x3tc1.IfcVolumeMeasure;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcPropertySetDefinitionSelect;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.google.common.base.Joiner;

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
					List list = (List) reference;
					for (int index = 0; index < list.size(); index++) {
						Object refObject = list.get(index);
						IdEObject refIdEObject = (IdEObject) refObject;
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
				return (IfcBuildingStorey) relatingObject;
			}
		}
		if (ifcProduct instanceof IfcElement) {
			IfcElement ifcElement = (IfcElement) ifcProduct;
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

	public static Set<IfcProduct> getDecompositionAndContainmentRecursive(IfcObjectDefinition parent) {
		Set<IfcProduct> set = new HashSet<>();
		getDecompositionAndContainmentRecursive(set, parent);
		return set;
	}
	
	public static Set<IfcProduct> getDecompositionAndContainmentRecursive(Set<IfcProduct> result, IfcObjectDefinition parent) {
		for (IfcRelDecomposes ifcRelDecomposes : parent.getIsDecomposedBy()) {
			for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
				if (ifcObjectDefinition instanceof IfcProduct) {
					result.add((IfcProduct) ifcObjectDefinition);
				}
				getDecompositionAndContainmentRecursive(result, ifcObjectDefinition);
			}
		}
		if (parent instanceof IfcSpatialStructureElement) {
			IfcSpatialStructureElement ifcSpatialStructureElement = (IfcSpatialStructureElement)parent;
			for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcSpatialStructureElement.getContainsElements()) {
				for (IfcProduct ifcProduct : ifcRelContainedInSpatialStructure.getRelatedElements()) {
					result.add(ifcProduct);
					getDecompositionAndContainmentRecursive(result, ifcProduct);
				}
			}
		}
		return result;
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
				return (IfcProject) relatingObject;
			} else if (relatingObject instanceof IfcProduct) {
				return getIfcProject((IfcProduct) relatingObject);
			}
		}
		if (ifcProduct instanceof IfcElement) {
			IfcElement ifcElement = (IfcElement) ifcProduct;
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

	public static IdEObject getIfcProject(IdEObject ifcProduct) {
		if (ifcProduct.eClass().getEPackage() == Ifc4Package.eINSTANCE) {
			return getIfcProject((org.bimserver.models.ifc4.IfcProduct) ifcProduct);
		} else if (ifcProduct.eClass().getEPackage() == Ifc2x3tc1Package.eINSTANCE) {
			return getIfcProject((IfcProduct) ifcProduct);
		}
		return null;
	}

	public static org.bimserver.models.ifc4.IfcProject getIfcProject(org.bimserver.models.ifc4.IfcProduct ifcProduct) {
		if (ifcProduct instanceof IfcProject) {
			return (org.bimserver.models.ifc4.IfcProject) ifcProduct;
		}
		for (org.bimserver.models.ifc4.IfcRelAggregates ifcRelAggregates : ifcProduct.getDecomposes()) {
			org.bimserver.models.ifc4.IfcObjectDefinition relatingObject = ifcRelAggregates.getRelatingObject();
			if (relatingObject instanceof org.bimserver.models.ifc4.IfcProject) {
				return (org.bimserver.models.ifc4.IfcProject) relatingObject;
			} else if (relatingObject instanceof org.bimserver.models.ifc4.IfcProduct) {
				return getIfcProject((org.bimserver.models.ifc4.IfcProduct) relatingObject);
			}
		}
		if (ifcProduct instanceof org.bimserver.models.ifc4.IfcElement) {
			org.bimserver.models.ifc4.IfcElement ifcElement = (org.bimserver.models.ifc4.IfcElement) ifcProduct;
			for (org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcElement.getContainedInStructure()) {
				org.bimserver.models.ifc4.IfcSpatialElement relatingStructure = ifcRelContainedInSpatialStructure.getRelatingStructure();
				if (relatingStructure instanceof org.bimserver.models.ifc4.IfcProject) {
					return (org.bimserver.models.ifc4.IfcProject) relatingStructure;
				} else if (relatingStructure instanceof org.bimserver.models.ifc4.IfcBuildingStorey) {
					return getIfcProject(relatingStructure);
				} else {
					if (relatingStructure instanceof org.bimserver.models.ifc4.IfcSpace) {
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
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet) propertySetDefinition;
					for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
						if (ifcProperty instanceof IfcPropertySingleValue) {
							IfcPropertySingleValue propertyValue = (IfcPropertySingleValue) ifcProperty;
							if (ifcProperty.getName().equals(propertyName)) {
								IfcBoolean label = (IfcBoolean) propertyValue.getNominalValue();
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
	 * Lists all properties of a given IfcPopertySet that are of type
	 * IfcPropertySingleValue, all values are converted to the appropriate Java
	 * type
	 * 
	 * @param ifcObject
	 * @param propertySetName
	 * @return
	 */
	public static Map<String, Object> listProperties(IfcObject ifcObject, String propertySetName) {
		Map<String, Object> result = new HashMap<>();
		for (IfcRelDefines ifcRelDefines : ifcObject.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet) propertySetDefinition;
					if (ifcPropertySet.getName() != null && ifcPropertySet.getName().equalsIgnoreCase(propertySetName)) {
						for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
							if (ifcProperty instanceof IfcPropertySingleValue) {
								IfcPropertySingleValue propertyValue = (IfcPropertySingleValue) ifcProperty;
								result.put(propertyValue.getName(), nominalValueToObject(propertyValue.getNominalValue()));
							}
						}
					}
				}
			}
		}
		return result;
	}

	public static Object nominalValueToObject(IfcValue nominalValue) {
		if (nominalValue instanceof IfcLabel) {
			return ((IfcLabel) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcIdentifier) {
			return ((IfcIdentifier) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcBoolean) {
			return ((IfcBoolean) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcText) {
			return ((IfcText) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcLengthMeasure) {
			return ((IfcLengthMeasure) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcPlaneAngleMeasure) {
			return ((IfcPlaneAngleMeasure) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcAreaMeasure) {
			return ((IfcAreaMeasure) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcVolumeMeasure) {
			return ((IfcVolumeMeasure) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcReal) {
			return ((IfcReal) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcPowerMeasure) {
			return ((IfcPowerMeasure) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcInteger) {
			return ((IfcInteger) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcElectricCurrentMeasure) {
			return ((IfcElectricCurrentMeasure) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcLogical) {
			return ((IfcLogical) nominalValue).getWrappedValue();
		} else if (nominalValue instanceof IfcCountMeasure) {
			return ((IfcCountMeasure) nominalValue).getWrappedValue();
		} else {
			throw new RuntimeException("Not implemented: " + nominalValue.eClass().getName());
		}
	}

	public static String nominalValueToString(IfcValue nominalValue) {
		Object object = nominalValueToObject(nominalValue);
		if (object == null) {
			return null;
		}
		return object.toString();
	}

	public static String getStringProperty(IfcObject ifcObject, String propertyName) {
		for (IfcRelDefines ifcRelDefines : ifcObject.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet) propertySetDefinition;
					for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
						if (ifcProperty instanceof IfcPropertySingleValue) {
							IfcPropertySingleValue propertyValue = (IfcPropertySingleValue) ifcProperty;
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
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet) propertySetDefinition;
					for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
						list.add(ifcProperty.getName());
					}
				}
			}
		}
		return list;
	}

	public static Double getIfcQuantityVolume(IfcProduct ifcProduct) {
		Double volume = null;
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcElementQuantity) {
					IfcElementQuantity ifcElementQuantity = (IfcElementQuantity) propertySetDefinition;
					for (IfcPhysicalQuantity ifcPhysicalQuantity : ifcElementQuantity.getQuantities()) {
						if (ifcPhysicalQuantity instanceof IfcQuantityVolume) {
							if (volume == null) {
								volume = 0d;
							}
							volume += ((IfcQuantityVolume) ifcPhysicalQuantity).getVolumeValue();
						}
					}
				}
			}
		}
		return volume;
	}

	public static Double getIfcQuantityArea(IfcProduct ifcProduct) {
		Double area = null;
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcElementQuantity) {
					IfcElementQuantity ifcElementQuantity = (IfcElementQuantity) propertySetDefinition;
					for (IfcPhysicalQuantity ifcPhysicalQuantity : ifcElementQuantity.getQuantities()) {
						if (ifcPhysicalQuantity instanceof IfcQuantityArea) {
							if (area == null) {
								area = 0d;
							}
							area += ((IfcQuantityArea) ifcPhysicalQuantity).getAreaValue();
						}
					}
				}
			}
		}
		return area;
	}

	public static Double getIfcQuantityVolume(IdEObject idEObject) {
		if (idEObject instanceof IfcProduct) {
			return getIfcQuantityVolume((IfcProduct) idEObject);
		} else if (idEObject instanceof org.bimserver.models.ifc4.IfcProduct) {
			return getIfcQuantityVolume((org.bimserver.models.ifc4.IfcProduct) idEObject);
		}
		return null;
	}

	public static Double getIfcQuantityArea(IdEObject idEObject) {
		if (idEObject instanceof IfcProduct) {
			return getIfcQuantityArea((IfcProduct) idEObject);
		} else if (idEObject instanceof org.bimserver.models.ifc4.IfcProduct) {
			return getIfcQuantityArea((org.bimserver.models.ifc4.IfcProduct) idEObject);
		}
		return null;
	}

	public static Double getIfcQuantityVolume(org.bimserver.models.ifc4.IfcProduct ifcProduct) {
		Double volume = null;
		for (org.bimserver.models.ifc4.IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof org.bimserver.models.ifc4.IfcRelDefinesByProperties) {
				org.bimserver.models.ifc4.IfcRelDefinesByProperties ifcRelDefinesByProperties = (org.bimserver.models.ifc4.IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinitionSelect relatingPropertyDefinitionSelect = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (relatingPropertyDefinitionSelect instanceof org.bimserver.models.ifc4.IfcPropertySetDefinition) {
					org.bimserver.models.ifc4.IfcPropertySetDefinition propertySetDefinition = (org.bimserver.models.ifc4.IfcPropertySetDefinition) relatingPropertyDefinitionSelect;
					if (propertySetDefinition instanceof org.bimserver.models.ifc4.IfcElementQuantity) {
						org.bimserver.models.ifc4.IfcElementQuantity ifcElementQuantity = (org.bimserver.models.ifc4.IfcElementQuantity) propertySetDefinition;
						for (org.bimserver.models.ifc4.IfcPhysicalQuantity ifcPhysicalQuantity : ifcElementQuantity.getQuantities()) {
							if (ifcPhysicalQuantity instanceof org.bimserver.models.ifc4.IfcQuantityVolume) {
								if (volume == null) {
									volume = 0d;
								}
								volume += ((org.bimserver.models.ifc4.IfcQuantityVolume) ifcPhysicalQuantity).getVolumeValue();
							}
						}
					}
				}
			}
		}
		return volume;
	}

	public static Double getIfcQuantityArea(org.bimserver.models.ifc4.IfcProduct ifcProduct) {
		Double area = null;
		for (org.bimserver.models.ifc4.IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof org.bimserver.models.ifc4.IfcRelDefinesByProperties) {
				org.bimserver.models.ifc4.IfcRelDefinesByProperties ifcRelDefinesByProperties = (org.bimserver.models.ifc4.IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinitionSelect relatingPropertyDefinitionSelect = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (relatingPropertyDefinitionSelect instanceof org.bimserver.models.ifc4.IfcPropertySetDefinition) {
					org.bimserver.models.ifc4.IfcPropertySetDefinition propertySetDefinition = (org.bimserver.models.ifc4.IfcPropertySetDefinition) relatingPropertyDefinitionSelect;
					if (propertySetDefinition instanceof org.bimserver.models.ifc4.IfcElementQuantity) {
						org.bimserver.models.ifc4.IfcElementQuantity ifcElementQuantity = (org.bimserver.models.ifc4.IfcElementQuantity) propertySetDefinition;
						for (org.bimserver.models.ifc4.IfcPhysicalQuantity ifcPhysicalQuantity : ifcElementQuantity.getQuantities()) {
							if (ifcPhysicalQuantity instanceof org.bimserver.models.ifc4.IfcQuantityArea) {
								if (area == null) {
									area = 0d;
								}
								area += ((org.bimserver.models.ifc4.IfcQuantityArea) ifcPhysicalQuantity).getAreaValue();
							}
						}
					}
				}
			}
		}
		return area;
	}

	public static List<String> listElementQuantities(IfcProduct ifcProduct) {
		List<String> list = new ArrayList<>();
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcElementQuantity) {
					IfcElementQuantity ifcElementQuantity = (IfcElementQuantity) propertySetDefinition;
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
			IfcLocalPlacement ifcLocalPlacement = (IfcLocalPlacement) ifcObjectPlacement;
			IfcAxis2Placement relativePlacement = ifcLocalPlacement.getRelativePlacement();
			if (relativePlacement instanceof IfcAxis2Placement2D) {
				throw new PlacementNotImplementedException("IfcAxis2Placement2D has not been implemented");
			} else if (relativePlacement instanceof IfcAxis2Placement3D) {
				IfcAxis2Placement3D ifcAxis2Placement3D = (IfcAxis2Placement3D) relativePlacement;
				IfcObjectPlacement placementRelativeTo = ifcLocalPlacement.getPlacementRelTo();
				if (placementRelativeTo == null) {
					IfcCartesianPoint ifcCartesianPoint = ifcAxis2Placement3D.getLocation();
					return new double[] { ifcCartesianPoint.getCoordinates().get(0), ifcCartesianPoint.getCoordinates().get(1), ifcCartesianPoint.getCoordinates().get(2) };
				} else {
					double[] relative = getAbsolutePosition(placementRelativeTo);
					IfcCartesianPoint ifcCartesianPoint = ifcAxis2Placement3D.getLocation();
					return new double[] { relative[0] + ifcCartesianPoint.getCoordinates().get(0), relative[1] + ifcCartesianPoint.getCoordinates().get(1), relative[2] + ifcCartesianPoint.getCoordinates().get(2) };
				}
			}
		}
		return new double[] { 0d, 0d, 0d };
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

	public static LengthUnit getLengthUnit(IfcModelInterface model) {
		if (model.getPackageMetaData().getSchema() == Schema.IFC2X3TC1) {
			IfcSIPrefix prefix = getUnitPrefix(model, IfcUnitEnum.LENGTHUNIT);
			if (prefix != null) {
				return LengthUnit.fromPrefix(prefix);
			}
		} else if (model.getPackageMetaData().getSchema() == Schema.IFC4) {
			org.bimserver.models.ifc4.IfcSIPrefix prefix = getUnitPrefix(model, org.bimserver.models.ifc4.IfcUnitEnum.LENGTHUNIT);
			if (prefix != null) {
				return LengthUnit.fromPrefix(prefix);
			}
		}
		return null;
	}

	public static MassUnit getWeightUnit(IfcModelInterface model) {
		if (model.getPackageMetaData().getSchema() == Schema.IFC2X3TC1) {
			IfcSIPrefix prefix = getUnitPrefix(model, IfcUnitEnum.MASSUNIT);
			if (prefix != null) {
				return MassUnit.fromPrefix(prefix);
			}
		} else if (model.getPackageMetaData().getSchema() == Schema.IFC4) {
			org.bimserver.models.ifc4.IfcSIPrefix prefix = getUnitPrefix(model, org.bimserver.models.ifc4.IfcUnitEnum.MASSUNIT);
			if (prefix != null) {
				return MassUnit.fromPrefix(prefix);
			}
		}
		return null;
	}

	public static AreaUnit getAreaUnit(IfcModelInterface model) {
		if (model.getPackageMetaData().getSchema() == Schema.IFC2X3TC1) {
			IfcSIPrefix prefix = getUnitPrefix(model, IfcUnitEnum.AREAUNIT);
			if (prefix != null) {
				return AreaUnit.fromPrefix(prefix);
			}
		} else if (model.getPackageMetaData().getSchema() == Schema.IFC4) {
			org.bimserver.models.ifc4.IfcSIPrefix prefix = getUnitPrefix(model, org.bimserver.models.ifc4.IfcUnitEnum.AREAUNIT);
			if (prefix != null) {
				return AreaUnit.fromPrefix(prefix);
			}
		}
		return null;
	}

	public static VolumeUnit getVolumeUnit(IfcModelInterface model) {
		if (model.getPackageMetaData().getSchema() == Schema.IFC2X3TC1) {
			IfcSIPrefix prefix = getUnitPrefix(model, IfcUnitEnum.VOLUMEUNIT);
			if (prefix != null) {
				return VolumeUnit.fromPrefix(prefix);
			}
		} else if (model.getPackageMetaData().getSchema() == Schema.IFC4) {
			org.bimserver.models.ifc4.IfcSIPrefix prefix = getUnitPrefix(model, org.bimserver.models.ifc4.IfcUnitEnum.VOLUMEUNIT);
			if (prefix != null) {
				return VolumeUnit.fromPrefix(prefix);
			}
		}
		return null;
	}
	
	public static IfcSIPrefix getUnitPrefix(IfcModelInterface model, IfcUnitEnum unitToFind) {
		for (IfcProject ifcProject : model.getAll(IfcProject.class)) {
			IfcUnitAssignment unitsInContext = ifcProject.getUnitsInContext();
			if (unitsInContext != null) {
				EList<IfcUnit> units = unitsInContext.getUnits();
				for (IfcUnit unit : units) {
					if (unit instanceof IfcSIUnit) {
						IfcSIUnit ifcSIUnit = (IfcSIUnit) unit;
						IfcUnitEnum unitType = ifcSIUnit.getUnitType();
						if (unitType == unitToFind) {
							IfcSIPrefix prefix = ifcSIUnit.getPrefix();
							return prefix;
						}
					}
				}
			}
		}
		return null;
	}

	public static org.bimserver.models.ifc4.IfcSIPrefix getUnitPrefix(IfcModelInterface model, org.bimserver.models.ifc4.IfcUnitEnum unitToFind) {
		for (org.bimserver.models.ifc4.IfcProject ifcProject : model.getAll(org.bimserver.models.ifc4.IfcProject.class)) {
			org.bimserver.models.ifc4.IfcUnitAssignment unitsInContext = ifcProject.getUnitsInContext();
			if (unitsInContext != null) {
				EList<org.bimserver.models.ifc4.IfcUnit> units = unitsInContext.getUnits();
				for (org.bimserver.models.ifc4.IfcUnit unit : units) {
					if (unit instanceof org.bimserver.models.ifc4.IfcSIUnit) {
						org.bimserver.models.ifc4.IfcSIUnit ifcSIUnit = (org.bimserver.models.ifc4.IfcSIUnit) unit;
						org.bimserver.models.ifc4.IfcUnitEnum unitType = ifcSIUnit.getUnitType();
						if (unitType == unitToFind) {
							org.bimserver.models.ifc4.IfcSIPrefix prefix = ifcSIUnit.getPrefix();
							return prefix;
						}
					}
				}
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static float getLengthUnitPrefix(IfcModelInterface model) {
		float lengthUnitPrefix = 1.0f;
		boolean prefixFound = false;
		for (IdEObject ifcProject : model.getAll(model.getPackageMetaData().getEClass("IfcProject"))) {
			IdEObject unitsInContext = (IdEObject) ifcProject.eGet(ifcProject.eClass().getEStructuralFeature("UnitsInContext"));
			if (unitsInContext != null) {
				EList<IdEObject> units = (EList<IdEObject>) unitsInContext.eGet(unitsInContext.eClass().getEStructuralFeature("Units"));
				for (IdEObject unit : units) {
					if (model.getPackageMetaData().getEClass("IfcSIUnit").isSuperTypeOf(unit.eClass())) {
						Object unitType = unit.eGet(unit.eClass().getEStructuralFeature("UnitType"));
						if (unitType.toString().contentEquals("LENGTHUNIT")) {
							Object prefix = unit.eGet(unit.eClass().getEStructuralFeature("Prefix"));
							if (prefix != null) {
								prefixFound = true;
								lengthUnitPrefix = getLengthUnitPrefixMm(prefix.toString());
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

	public static float getLengthUnitPrefixMm(String prefix) {
		float lengthUnitPrefix = 1f;
		switch (prefix) {
		case "EXA":
			lengthUnitPrefix = 1.0e18f;
			break;
		case "PETA":
			lengthUnitPrefix = 1.0e15f;
			break;
		case "TERA":
			lengthUnitPrefix = 1.0e12f;
			break;
		case "GIGA":
			lengthUnitPrefix = 1.0e9f;
			break;
		case "MEGA":
			lengthUnitPrefix = 1.0e6f;
			break;
		case "KILO":
			lengthUnitPrefix = 1.0e3f;
			break;
		case "HECTO":
			lengthUnitPrefix = 1.0e2f;
			break;
		case "DECA":
			lengthUnitPrefix = 1.0e1f;
			break;
		case "DECI":
			lengthUnitPrefix = 1.0e-1f;
			break;
		case "CENTI":
			lengthUnitPrefix = 1.0e-2f;
			break;
		case "MILLI":
			lengthUnitPrefix = 1.0e-3f;
			break;
		case "MICRO":
			lengthUnitPrefix = 1.0e-6f;
			break;
		case "NANO":
			lengthUnitPrefix = 1.0e-9f;
			break;
		case "PICO":
			lengthUnitPrefix = 1.0e-12f;
			break;
		case "FEMTO":
			lengthUnitPrefix = 1.0e-15f;
			break;
		case "ATTO":
			lengthUnitPrefix = 1.0e-18f;
			break;
		case "NULL":
			break;
		}
		return lengthUnitPrefix;
	}

	public static int getNrOfProperties(IdEObject ifcProduct) {
		if (ifcProduct instanceof IfcProduct) {
			return getNrOfProperties((IfcProduct) ifcProduct);
		} else if (ifcProduct instanceof org.bimserver.models.ifc4.IfcProduct) {
			return getNrOfProperties((org.bimserver.models.ifc4.IfcProduct) ifcProduct);
		}
		return -1;
	}

	public static int getNrOfProperties(IfcProduct ifcProduct) {
		int nrProperties = 0;
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					IfcPropertySet ifcPropertySet = (IfcPropertySet) propertySetDefinition;
					nrProperties += ifcPropertySet.getHasProperties().size();
				}
			}
		}
		return nrProperties;
	}

	public static int getNrOfProperties(org.bimserver.models.ifc4.IfcProduct ifcProduct) {
		int nrProperties = 0;
		for (org.bimserver.models.ifc4.IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof org.bimserver.models.ifc4.IfcRelDefinesByProperties) {
				org.bimserver.models.ifc4.IfcRelDefinesByProperties ifcRelDefinesByProperties = (org.bimserver.models.ifc4.IfcRelDefinesByProperties) ifcRelDefines;
				org.bimserver.models.ifc4.IfcPropertySetDefinitionSelect propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof org.bimserver.models.ifc4.IfcPropertySet) {
					org.bimserver.models.ifc4.IfcPropertySet ifcPropertySet = (org.bimserver.models.ifc4.IfcPropertySet) propertySetDefinition;
					nrProperties += ifcPropertySet.getHasProperties().size();
				}
			}
		}
		return nrProperties;
	}

	public static int getNrOfPropertySets(IdEObject ifcProduct) {
		if (ifcProduct instanceof IfcProduct) {
			return getNrOfPropertySets(((IfcProduct) ifcProduct));
		} else if (ifcProduct instanceof org.bimserver.models.ifc4.IfcProduct) {
			return getNrOfPropertySets(((org.bimserver.models.ifc4.IfcProduct) ifcProduct));
		}
		return -1;
	}

	public static int getNrOfPropertySets(IfcProduct ifcProduct) {
		int nrPropertySets = 0;
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					nrPropertySets++;
				}
			}
		}
		return nrPropertySets;
	}

	public static int getNrOfPropertySets(org.bimserver.models.ifc4.IfcProduct ifcProduct) {
		int nrPropertySets = 0;
		for (org.bimserver.models.ifc4.IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof org.bimserver.models.ifc4.IfcRelDefinesByProperties) {
				org.bimserver.models.ifc4.IfcRelDefinesByProperties ifcRelDefinesByProperties = (org.bimserver.models.ifc4.IfcRelDefinesByProperties) ifcRelDefines;
				org.bimserver.models.ifc4.IfcPropertySetDefinitionSelect propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof org.bimserver.models.ifc4.IfcPropertySetDefinition) {
					nrPropertySets++;
				}
			}
		}
		return nrPropertySets;
	}

	public static int getNrOfPSets(IdEObject ifcProduct, boolean onlyOfficial) {
		if (ifcProduct instanceof IfcProduct) {
			return getNrOfPSets((IfcProduct) ifcProduct, onlyOfficial);
		} else if (ifcProduct instanceof org.bimserver.models.ifc4.IfcProduct) {
			return getNrOfPSets((org.bimserver.models.ifc4.IfcProduct) ifcProduct, onlyOfficial);
		}
		return -1;
	}

	public static int getNrOfPSets(IfcProduct ifcProduct, boolean onlyOfficial) {
		int nrPSets = 0;
		for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
				IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
				IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof IfcPropertySet) {
					if (onlyOfficial) {
						try {
							Ifc2x3tc1OfficialPsets.valueOf(propertySetDefinition.getName());
							nrPSets++;
						} catch (Exception e) {
						}
					} else {
						if (propertySetDefinition.getName().startsWith("Pset_")) {
							nrPSets++;
						}
					}
				}
			}
		}
		return nrPSets;
	}

	public static int getNrOfPSets(org.bimserver.models.ifc4.IfcProduct ifcProduct, boolean onlyOfficial) {
		int nrPSets = 0;
		for (org.bimserver.models.ifc4.IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
			if (ifcRelDefines instanceof org.bimserver.models.ifc4.IfcRelDefinesByProperties) {
				org.bimserver.models.ifc4.IfcRelDefinesByProperties ifcRelDefinesByProperties = (org.bimserver.models.ifc4.IfcRelDefinesByProperties) ifcRelDefines;
				org.bimserver.models.ifc4.IfcPropertySetDefinitionSelect propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
				if (propertySetDefinition instanceof org.bimserver.models.ifc4.IfcPropertySetDefinition) {
					String name = (String) propertySetDefinition.eGet(propertySetDefinition.eClass().getEStructuralFeature("Name"));
					if (onlyOfficial) {
						try {
							Ifc4OfficialPsets.valueOf(name);
							nrPSets++;
						} catch (Exception e) {
						}
					} else {
						if (name.startsWith("Pset_")) {
							nrPSets++;
						}
					}
				}
			}
		}
		return nrPSets;
	}

	public static String getMaterial(IfcProduct ifcProduct) {
		Set<IfcMaterial> materials = new HashSet<>();
		for (IfcRelAssociates ifcRelAssociates : ifcProduct.getHasAssociations()) {
			if (ifcRelAssociates instanceof IfcRelAssociatesMaterial) {
				IfcRelAssociatesMaterial ifcRelAssociatesMaterial = (IfcRelAssociatesMaterial) ifcRelAssociates;
				IfcMaterialSelect relatingMaterial = ifcRelAssociatesMaterial.getRelatingMaterial();
				if (relatingMaterial instanceof IfcMaterial) {
					materials.add((IfcMaterial) relatingMaterial);
				} else if (relatingMaterial instanceof IfcMaterialLayerSetUsage) {
					IfcMaterialLayerSetUsage ifcMaterialLayerSetUsage = (IfcMaterialLayerSetUsage) relatingMaterial;
					IfcMaterialLayerSet forLayerSet = ifcMaterialLayerSetUsage.getForLayerSet();
					for (IfcMaterialLayer ifcMaterialLayer : forLayerSet.getMaterialLayers()) {
						IfcMaterial material = ifcMaterialLayer.getMaterial();
						materials.add(material);
					}
				} else if (relatingMaterial instanceof IfcMaterialList) {
					materials.addAll(((IfcMaterialList) relatingMaterial).getMaterials());
				} else if (relatingMaterial instanceof IfcMaterialLayerSet) {
					for (IfcMaterialLayer ifcMaterialLayer : ((IfcMaterialLayerSet) relatingMaterial).getMaterialLayers()) {
						materials.add(ifcMaterialLayer.getMaterial());
					}
				} else {
					throw new UnsupportedOperationException(relatingMaterial.toString());
				}
			}
		}

		Iterator<IfcMaterial> iterator = materials.iterator();
		while (iterator.hasNext()) {
			IfcMaterial next = iterator.next();
			if (next == null || next.getName() == null) {
				iterator.remove();
			}
		}

		return Joiner.on(", ").join(materials.stream().map(new Function<IfcMaterial, String>() {
			@Override
			public String apply(IfcMaterial input) {
				return input.getName();
			}
		}).iterator());
	}

	public static String getMaterial(IdEObject ifcProduct) {
		if (ifcProduct instanceof IfcProduct) {
			return getMaterial((IfcProduct) ifcProduct);
		} else if (ifcProduct instanceof org.bimserver.models.ifc4.IfcProduct) {
			return getMaterial((org.bimserver.models.ifc4.IfcProduct) ifcProduct);
		}
		return null;
	}

	public static String getMaterial(org.bimserver.models.ifc4.IfcProduct ifcProduct) {
		Set<org.bimserver.models.ifc4.IfcMaterial> materials = new HashSet<>();
		for (org.bimserver.models.ifc4.IfcRelAssociates ifcRelAssociates : ifcProduct.getHasAssociations()) {
			if (ifcRelAssociates instanceof org.bimserver.models.ifc4.IfcRelAssociatesMaterial) {
				org.bimserver.models.ifc4.IfcRelAssociatesMaterial ifcRelAssociatesMaterial = (org.bimserver.models.ifc4.IfcRelAssociatesMaterial) ifcRelAssociates;
				org.bimserver.models.ifc4.IfcMaterialSelect relatingMaterial = ifcRelAssociatesMaterial.getRelatingMaterial();
				if (relatingMaterial instanceof org.bimserver.models.ifc4.IfcMaterial) {
					materials.add((org.bimserver.models.ifc4.IfcMaterial) relatingMaterial);
				} else if (relatingMaterial instanceof org.bimserver.models.ifc4.IfcMaterialLayerSetUsage) {
					org.bimserver.models.ifc4.IfcMaterialLayerSetUsage ifcMaterialLayerSetUsage = (org.bimserver.models.ifc4.IfcMaterialLayerSetUsage) relatingMaterial;
					org.bimserver.models.ifc4.IfcMaterialLayerSet forLayerSet = ifcMaterialLayerSetUsage.getForLayerSet();
					for (org.bimserver.models.ifc4.IfcMaterialLayer ifcMaterialLayer : forLayerSet.getMaterialLayers()) {
						org.bimserver.models.ifc4.IfcMaterial material = ifcMaterialLayer.getMaterial();
						if (material != null) {
							materials.add(material);
						}
					}
				} else if (relatingMaterial instanceof org.bimserver.models.ifc4.IfcMaterialList) {
					materials.addAll(((org.bimserver.models.ifc4.IfcMaterialList) relatingMaterial).getMaterials());
				} else if (relatingMaterial instanceof org.bimserver.models.ifc4.IfcMaterialLayerSet) {
					for (org.bimserver.models.ifc4.IfcMaterialLayer ifcMaterialLayer : ((org.bimserver.models.ifc4.IfcMaterialLayerSet) relatingMaterial).getMaterialLayers()) {
						materials.add(ifcMaterialLayer.getMaterial());
					}
				} else {
					throw new UnsupportedOperationException(relatingMaterial.toString());
				}
			}
		}

		Iterator<org.bimserver.models.ifc4.IfcMaterial> iterator = materials.iterator();
		while (iterator.hasNext()) {
			org.bimserver.models.ifc4.IfcMaterial next = iterator.next();
			if (next == null || next.getName() == null) {
				iterator.remove();
			}
		}

		return Joiner.on(", ").join(materials.stream().map(new Function<org.bimserver.models.ifc4.IfcMaterial, String>() {
			@Override
			public String apply(org.bimserver.models.ifc4.IfcMaterial input) {
				return input.getName();
			}
		}).iterator());
	}

	public static String getClassification(IfcProduct ifcProduct, IfcModelInterface model) {
		for (IfcRelAssociatesClassification ifcRelAssociatesClassification : model.getAll(IfcRelAssociatesClassification.class)) {
			if (ifcRelAssociatesClassification.getRelatedObjects().contains(ifcProduct)) {
				return ifcRelAssociatesClassification.getName();
			}
		}
		return null;
	}

	public static int getNrOfRelations(IfcProduct product) {
		return product.getDecomposes().size() + product.getHasAssignments().size() + product.getHasAssociations().size() + product.getIsDecomposedBy().size() + product.getReferencedBy().size() + product.getIsDefinedBy().size();
	}

	public static int getNrOfRelations(org.bimserver.models.ifc4.IfcProduct product) {
		return product.getDeclares().size() + product.getDecomposes().size() + product.getHasAssignments().size() + product.getHasAssociations().size() + product.getHasContext().size() + product.getIsDeclaredBy().size() + product.getIsDecomposedBy().size() + product.getIsDefinedBy().size() + product.getIsNestedBy().size() + product.getIsTypedBy().size() + product.getNests().size() + product.getReferencedBy().size();
	}

	public static int getNrOfRelations(IdEObject product) {
		if (product instanceof IfcProduct) {
			return getNrOfRelations((IfcProduct)product);
		} else if (product instanceof org.bimserver.models.ifc4.IfcProduct) {
			return getNrOfRelations((org.bimserver.models.ifc4.IfcProduct)product);
		}
		return 0;
	}

	public static int countContains(IfcSpatialStructureElement object) {
		int total = 0;
		for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : object.getContainsElements()) {
			for (IfcProduct ifcProduct : ifcRelContainedInSpatialStructure.getRelatedElements()) {
				total += 1;
				if (ifcProduct instanceof IfcSpatialStructureElement) {
					total += countContains((IfcSpatialStructureElement) ifcProduct);
				}
			}
		}
		return total;
	}
	
	public static int countDecomposed(IfcObjectDefinition object) {
		int total = 0;
		for (IfcRelDecomposes ifcRelDecomposes : object.getIsDecomposedBy()) {
			for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
				total += 1;
				total += countDecomposed(ifcObjectDefinition);
			}
		}
		return total;
	}

	public static String dumpRepresentationInfo(IfcProduct ifcProduct) {
		StringBuilder sb = new StringBuilder();
		sb.append("Dumping representation info for " + ifcProduct.eClass().getName() + "\n");
		IfcProductRepresentation representation = ifcProduct.getRepresentation();
		for (IfcRepresentation ifcRepresentation : representation.getRepresentations()) {
			sb.append("\t" + ifcRepresentation.eClass().getName() + "\n");
			if (ifcRepresentation instanceof IfcShapeRepresentation) {
				IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation)ifcRepresentation;
				sb.append("\t\tRepresentationIdentifier: " + ifcShapeRepresentation.getRepresentationIdentifier() + "\n");
				sb.append("\t\tRepresentationType: " + ifcShapeRepresentation.getRepresentationType() + "\n");
			}
			for (IfcRepresentationItem ifcRepresentationItem : ifcRepresentation.getItems()) {
				sb.append("\t\t" + ifcRepresentationItem.eClass().getName() + "\n");
			}
		}
		return sb.toString();
	}

	public static AxisAlignedBoundingBox2D getBoundingBox2D(List<IfcCartesianPoint> points) throws GeometryException {
		AxisAlignedBoundingBox2D box2d = new AxisAlignedBoundingBox2D();
		for (IfcCartesianPoint ifcCartesianPoint : points) {
			EList<Double> coordinates = ifcCartesianPoint.getCoordinates();
			if (coordinates.size() > 2) {
				throw new GeometryException("Too many dimensions (" + coordinates.size() + ") for 2D boundingbox");
			}
			box2d.process(coordinates);
		}
		return box2d;
	}

	public static AxisAlignedBoundingBox3D getBoundingBox3D(List<IfcCartesianPoint> points) throws GeometryException {
		AxisAlignedBoundingBox3D box3d = new AxisAlignedBoundingBox3D();
		for (IfcCartesianPoint ifcCartesianPoint : points) {
			EList<Double> coordinates = ifcCartesianPoint.getCoordinates();
			if (coordinates.size() < 2) {
				throw new GeometryException("Not enough dimensions (" + coordinates.size() + ") for 3D boundingbox");
			}
			box3d.process(coordinates);
		}
		return box3d;
	}
	
	public static Vector2D getCenter2D(List<IfcCartesianPoint> points) throws GeometryException {
		AxisAlignedBoundingBox2D bb = getBoundingBox2D(points);
		return bb.getCenter();
	}

	public static Vector3D getCenter3D(List<IfcCartesianPoint> points) throws GeometryException {
		AxisAlignedBoundingBox3D bb = getBoundingBox3D(points);
		return bb.getCenter();
	}

	public static AxisAlignedBoundingBox3D getBoundingBox3D(EList<IfcFace> cfsFaces) {
		AxisAlignedBoundingBox3D box = new AxisAlignedBoundingBox3D();
		for (IfcFace ifcFace : cfsFaces) {
			for (IfcFaceBound ifcFaceBound : ifcFace.getBounds()) {
				IfcLoop ifcLoop = ifcFaceBound.getBound();
				if (ifcLoop instanceof IfcPolyLoop) {
					IfcPolyLoop ifcPolyLoop = (IfcPolyLoop)ifcLoop;
					for (IfcCartesianPoint ifcCartesianPoint : ifcPolyLoop.getPolygon()) {
						box.process(ifcCartesianPoint.getCoordinates());
					}
				} else {
					throw new NotImplementedException(ifcLoop.eClass().getName());
				}
			}
		}
		return box;
	}
}