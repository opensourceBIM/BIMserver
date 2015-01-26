package org.bimserver.charting;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 *****************************************************************************/

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.bimserver.charting.Charts.Chart;
import org.bimserver.charting.Export.IfcObjectWithTrace;
import org.bimserver.charting.Export.StackTrace;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.store.SIPrefix;
import org.eclipse.emf.common.util.EList;
import org.openmali.vecmath2.Vector3d;

public class SupportFunctions {

	public static ArrayList<LinkedHashMap<String, Object>> getTreeStructureWithAreaFromIFCData(IfcModelInterface model, Chart chart) {
		ArrayList<LinkedHashMap<String, Object>> rawData = new ArrayList<>();
		// Get units.
		String units = "units"; 
		SIPrefix prefix = SupportFunctions.getLengthUnitPrefix(model);
		if (prefix != null)
			units = prefix.getLiteral();
		// Prepare for static iteration.
		int maxDepth = 0;
		LinkedList<IfcObjectWithTrace> leaves = new LinkedList<>();
		LinkedList<IfcObjectWithTrace> parts = new LinkedList<>();
		// Iterate, but start with projects.
		for (IfcProject ifcProject : model.getAll(IfcProject.class))
			parts.add(new IfcObjectWithTrace(ifcProject));
		// Iterate the IFC going 1 level at a time (ex: Projects -> Sites, then Sites -> Buildings, then Buildings -> IfcProducts, then IfcProducts -> IfcProducts).
		while (parts.size() > 0) {
			IfcObjectWithTrace entry = parts.pop();
			StackTrace traceAtThisPoint = entry.Key;
			IfcObject parentObject = entry.Value;
			// Get name to be added to stack.
			int parentId = parentObject.getExpressId();
			String ifcParentName = (parentId >= 0) ? String.format("%s (%d)", parentObject.getName(), parentObject.getExpressId()) : parentObject.getName();
			// Make the stack trace.
			StackTrace traceAtChildren = new StackTrace(traceAtThisPoint);
			traceAtChildren.add(ifcParentName);
			// Track the children that are getting put into the raw data at this point.
			LinkedList<IfcObjectWithTrace> childrenInThisPass = new LinkedList<>();
			// Walk the relationship from the parent to its child objects.
			for (IfcRelDecomposes ifcRelDecomposes : parentObject.getIsDecomposedBy()) {
				// Iterate what the object decomposes into.
				for (IfcObjectDefinition definition : ifcRelDecomposes.getRelatedObjects())
					childrenInThisPass.add(new IfcObjectWithTrace(traceAtChildren, (IfcObject) definition));
			}
			// If IfcObject happens to be something like an IfcBuildingStorey, go looking through its structure.
			if (parentObject instanceof IfcSpatialStructureElement) {
				IfcSpatialStructureElement ifcSpatialStructureElement = (IfcSpatialStructureElement) parentObject;
				for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcSpatialStructureElement.getContainsElements())
					for (IfcProduct ifcProduct : ifcRelContainedInSpatialStructure.getRelatedElements()) {
						Double area = null;
						GeometryInfo geometry = ifcProduct.getGeometry();
						if (geometry != null) {
							Vector3f min = geometry.getMinBounds();
							Vector3f max = geometry.getMaxBounds();
							Vector3d delta = new Vector3d(max.getX() - min.getX(), max.getY() - min.getY(), max.getZ() - min.getZ());
							area = delta.lengthSquared();
						}
						childrenInThisPass.add(new IfcObjectWithTrace(traceAtChildren, ifcProduct, area));
					}
			}
			// Test if this node is a leaf. If it is, keep it.
			if (childrenInThisPass.size() == 0) {
				leaves.add(entry);
				// Update depth.
				int depthAtThisPoint = traceAtThisPoint.size() + 1;
				if (depthAtThisPoint > maxDepth)
					maxDepth = depthAtThisPoint;
			} else
				parts.addAll(childrenInThisPass);
		}
		// Derive the column names.
		ArrayList<String> hierarchyColumnNames = new ArrayList<>();
		for (int i = 0; i < maxDepth; i++)
			hierarchyColumnNames.add(String.format("hierarchy%d", i + 1));
		// Update the chart configuration.
		chart.setDimensionLookupKeys("hierarchy", hierarchyColumnNames);
		chart.setDimensionLookupKey("size", "size");
		chart.setDimensionLookupKey("label", "label");
		chart.setDimensionLookupKey("color", hierarchyColumnNames.get(Math.max(0, maxDepth - 2)));
		// Iterate the leaf nodes.
		for (IfcObjectWithTrace leaf : leaves) {
			StackTrace traceAtThisPoint = leaf.Key;
			IfcObject leafObject = leaf.Value;
			// Prepare to store this raw data entry.
			LinkedHashMap<String, Object> leafDataEntry = new LinkedHashMap<>();
			// Prepare to iterate backwards along column names (ex. hierarchy10, ..., hierarchy1).
			int leafDepthIndex = maxDepth - 1;
			int sizeOfStack = traceAtThisPoint.size();
			int stackUpperBound = leafDepthIndex - 1;
			int stackLowerRange = stackUpperBound - sizeOfStack;
			// Iterate backwards along column names.
			for (int i = leafDepthIndex; i >= 0; i--) {
				String column = hierarchyColumnNames.get(i);
				String value;
				if (i == leafDepthIndex) {
					value = String.format("%s (%d)", leafObject.getName(), leafObject.getOid());
					if (units != null && leaf.Size != null) {
						if (leaf.Size > 0)
							value += String.format(" ~%s %s\u00B2", leaf.Size.intValue(), units);
						else
							value += String.format(" %s %s\u00B2", leaf.Size, units);
					}
					leafDataEntry.put("label", leafObject.getName());
					leafDataEntry.put("size", leaf.Size);
				}
				else if (stackLowerRange < i && i <= stackUpperBound) {
					int index = sizeOfStack - (stackUpperBound - i) - 1;
					value = traceAtThisPoint.get(index);
				} else
					value = null;
				// Add column.
				leafDataEntry.put(column, value);
			}
			// Add the data.
			rawData.add(leafDataEntry);
		}
		// Send it all back.
		return rawData;
	}

	public static SIPrefix getLengthUnitPrefix(IfcModelInterface model) {
		SIPrefix lengthUnitPrefix = null;
		boolean prefixFound = false;
		Map<Long, IdEObject> objects = model.getObjects();
		for (IdEObject object : objects.values()) {
			if (object instanceof IfcProject) {
				IfcUnitAssignment unitsInContext = ((IfcProject) object).getUnitsInContext();
				if (unitsInContext != null) {
					EList<IfcUnit> units = unitsInContext.getUnits();
					for (IfcUnit unit : units) {
						if (unit instanceof IfcSIUnit) {
							IfcSIUnit ifcSIUnit = (IfcSIUnit) unit;
							IfcUnitEnum unitType = ifcSIUnit.getUnitType();
							if (unitType == IfcUnitEnum.LENGTHUNIT) {
								prefixFound = true;
								switch (ifcSIUnit.getPrefix()) {
								case EXA:
									lengthUnitPrefix = SIPrefix.EXAMETER;
									break;
								case PETA:
									lengthUnitPrefix = SIPrefix.PETAMETER;
									break;
								case TERA:
									lengthUnitPrefix = SIPrefix.TERAMETER;
									break;
								case GIGA:
									lengthUnitPrefix = SIPrefix.GIGAMETER;
									break;
								case MEGA:
									lengthUnitPrefix = SIPrefix.MEGAMETER;
									break;
								case KILO:
									lengthUnitPrefix = SIPrefix.KILOMETER;
									break;
								case HECTO:
									lengthUnitPrefix = SIPrefix.HECTOMETER;
									break;
								case DECA:
									lengthUnitPrefix = SIPrefix.DECAMETER;
									break;
								case DECI:
									lengthUnitPrefix = SIPrefix.DECIMETER;
									break;
								case CENTI:
									lengthUnitPrefix = SIPrefix.CENTIMETER;
									break;
								case MILLI:
									lengthUnitPrefix = SIPrefix.MILLIMETER;
									break;
								case MICRO:
									lengthUnitPrefix = SIPrefix.MICROMETER;
									break;
								case NANO:
									lengthUnitPrefix = SIPrefix.NANOMETER;
									break;
								case PICO:
									lengthUnitPrefix = SIPrefix.PICOMETER;
									break;
								case FEMTO:
									lengthUnitPrefix = SIPrefix.FEMTOMETER;
									break;
								case ATTO:
									lengthUnitPrefix = SIPrefix.ATTOMETER;
									break;
								case NULL:
									lengthUnitPrefix = SIPrefix.METER;
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
