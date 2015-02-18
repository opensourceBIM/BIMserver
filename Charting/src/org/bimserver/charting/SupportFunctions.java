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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.mutable.MutableInt;
import org.bimserver.charting.Charts.Chart;
import org.bimserver.charting.Export.IfcObjectWithTrace;
import org.bimserver.charting.Export.StackTrace;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.ifc2x3tc1.IfcClassification;
import org.bimserver.models.ifc2x3tc1.IfcClassificationNotation;
import org.bimserver.models.ifc2x3tc1.IfcClassificationNotationFacet;
import org.bimserver.models.ifc2x3tc1.IfcClassificationNotationSelect;
import org.bimserver.models.ifc2x3tc1.IfcClassificationReference;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialList;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObject;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesClassification;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
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
		return getDataWithTreeStructure("hierarchy", model, chart);
	}

	public static ArrayList<LinkedHashMap<String, Object>> getClusterStructureWithAreaFromIFCData(IfcModelInterface model, Chart chart) {
		return getDataWithTreeStructure("clusters", model, chart);
	}

	public static ArrayList<LinkedHashMap<String, Object>> getDataWithTreeStructure(String structureKeyword, IfcModelInterface model, Chart chart) {
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
						Double area = getRoughAreaEstimateFromIfcProduct(ifcProduct);
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
			hierarchyColumnNames.add(String.format("%s%d", structureKeyword, i + 1));
		// Update the chart configuration.
		chart.setDimensionLookupKeys(structureKeyword, hierarchyColumnNames);
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
				} else if (stackLowerRange < i && i <= stackUpperBound) {
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

	public static Double getRoughAreaEstimateFromIfcProduct(IfcProduct ifcProduct) {
		GeometryInfo geometry = ifcProduct.getGeometry();
		Double area = null;
		if (geometry != null) {
			Vector3f min = geometry.getMinBounds();
			Vector3f max = geometry.getMaxBounds();
			Vector3d delta = new Vector3d(max.getX() - min.getX(), max.getY() - min.getY(), max.getZ() - min.getZ());
			// A (of rectangular prism boundary) = 2(wl + hl + hw) 
			area = 2 * (delta.x() * delta.y() + delta.z() * delta.y() + delta.z() * delta.x());
		}
		return area;
	}

	public static Double getRoughVolumeEstimateFromIfcProduct(IfcProduct ifcProduct) {
		GeometryInfo geometry = ifcProduct.getGeometry();
		Double volume = null;
		if (geometry != null) {
			Vector3f min = geometry.getMinBounds();
			Vector3f max = geometry.getMaxBounds();
			Vector3d delta = new Vector3d(max.getX() - min.getX(), max.getY() - min.getY(), max.getZ() - min.getZ());
			// V (of rectangular prism boundary) = whl 
			volume = delta.x() * delta.y() * delta.z();
		}
		return volume;
	}

	public static ArrayList<LinkedHashMap<String, Object>> getIfcDataByClassWithTreeStructure(String structureKeyword, IfcModelInterface model, Chart chart, int superClassesToStepBackwardsThrough) {
		ArrayList<LinkedHashMap<String, Object>> rawData = new ArrayList<>();
		// Prepare for static iteration.
		LinkedHashMap<Class<? extends IfcProduct>, Integer> ifcProductClassCounts = new LinkedHashMap<>();
		// Iterate only the products.
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class))
		{
			Class<? extends IfcProduct> key = ifcProduct.getClass();
			Integer value = 0;
			if (ifcProductClassCounts.containsKey(key))
				value = ifcProductClassCounts.get(key);
			ifcProductClassCounts.put(key, value + 1);
		}
		// Derive the column names.
		ArrayList<String> hierarchyColumnNames = new ArrayList<>();
		superClassesToStepBackwardsThrough = Math.max(0, superClassesToStepBackwardsThrough);
		String leafColumnName = String.format("%s%d", structureKeyword, superClassesToStepBackwardsThrough + 1);
		for (int i = 0; i < superClassesToStepBackwardsThrough + 1; i++)
			hierarchyColumnNames.add(String.format("%s%d", structureKeyword, i + 1));
		// Update the chart configuration.
		chart.setDimensionLookupKeys(structureKeyword, hierarchyColumnNames);
		chart.setDimensionLookupKey("size", "size");
		chart.setDimensionLookupKey("label", "label");
		chart.setDimensionLookupKey("color", "size");
		// Add each entry.
		for (Entry<Class<? extends IfcProduct>, Integer> countedEntry : ifcProductClassCounts.entrySet()) {
			// Prepare to store this raw data entry.
			LinkedHashMap<String, Object> dataEntry = new LinkedHashMap<>();
			//
			Integer count = countedEntry.getValue();
			Class<? extends IfcProduct> productClass = countedEntry.getKey();
			// Sanitize.
			String className = getSanitizedSimpleClassName(productClass);
			// Name the group.
			String name = String.format("%s (%s)", className, count);
			dataEntry.put(leafColumnName, name);
			// Step back through the inheritance of the IfcProduct.
			if (superClassesToStepBackwardsThrough > 0) {
				Class<?> childClass = productClass;
				for (int i = superClassesToStepBackwardsThrough - 1; i >= 0; i--) {
					String thisColumnName = String.format("%s%d", structureKeyword, i + 1);
					Class<?> superClass = childClass.getSuperclass();
					String enclosingClassName = getSanitizedSimpleClassName(superClass);
					dataEntry.put(thisColumnName, enclosingClassName);
					// Update pointer.
					childClass = superClass;
				}
			}
			dataEntry.put("size", count);
			dataEntry.put("label", name);
			// Push the entry into the data pool.
			rawData.add(dataEntry);
		}
		// Send it all back.
		return rawData;
	}

	public static Comparator<Double> sortSmallerValuesToFront = new Comparator<Double>() {
		public int compare(Double p1, Double p2) {
			//
			Double a = (p1 != null) ? p1 : 0;
			Double b = (p2 != null) ? p2 : 0;
			// Smaller values at start, larger values at end.
			return a.compareTo(b);
		}
	};

	public static ArrayList<LinkedHashMap<String, Object>> getIfcMaterialsByClassWithTreeStructure(String structureKeyword, IfcModelInterface model, Chart chart, MutableInt subChartCount) {
		// Derive the column name.
		String leafColumnName = structureKeyword;
		// Update the chart configuration.
		chart.setDimensionLookupKey(structureKeyword, leafColumnName);
		chart.setDimensionLookupKey("date", "date");
		chart.setDimensionLookupKey("size", "size");
		// Prepare to iterate the relationships.
		LinkedHashMap<String, ArrayList<Double>> materialNameWithSizes = new LinkedHashMap<>(); 
		// Iterate only the relationships.
		for (IfcRelAssociatesMaterial ifcRelAssociatesMaterial : model.getAllWithSubTypes(IfcRelAssociatesMaterial.class))
		{
			// IfcMaterialSelect: IfcMaterial, IfcMaterialList, IfcMaterialLayerSetUsage, IfcMaterialLayerSet, IfcMaterialLayer.
			IfcMaterialSelect materialLike = ifcRelAssociatesMaterial.getRelatingMaterial();
			// If there was a material-like object, sum it across X.
			if (materialLike != null) {
				// Get material name, like: Brick (000000), Air (000001); or, Concrete (0000000).
				String materialName = getNameOfMaterialsFromMaterialLike(materialLike, true, true);
				// Use material name if available. Otherwise, use OID of top-level material-like object.
				String name = (materialName != null) ? materialName : String.format("%d", materialLike.getOid());
				// Add entry if it doesn't exist.
				if (!materialNameWithSizes.containsKey(name))
					materialNameWithSizes.put(name, new ArrayList<Double>());
				// Get existing size data.
				ArrayList<Double> sizes = materialNameWithSizes.get(name);
				// Iterate objects.
				EList<IfcRoot> ifcRoots = ifcRelAssociatesMaterial.getRelatedObjects();
				for (IfcRoot ifcRoot : ifcRoots) {
					Double size = 0.0;
					if (ifcRoot instanceof IfcObjectDefinition) {
						IfcObjectDefinition ifcObjectDefinition = (IfcObjectDefinition)ifcRoot;
						if (ifcObjectDefinition instanceof IfcObject) {
							IfcObject ifcObject = (IfcObject)ifcObjectDefinition;
							if (ifcObject instanceof IfcProduct) {
								IfcProduct ifcProduct = (IfcProduct)ifcObject;
								Double volume = getRoughVolumeEstimateFromIfcProduct(ifcProduct);
								size = volume;
							}
						}
					}
					if (size != null && size > 0)
						sizes.add(size);
				}
			}
		}
		//
		subChartCount.setValue(materialNameWithSizes.size());
		//
		ArrayList<LinkedHashMap<String, Object>> rawData = new ArrayList<>();
		//
		for (Entry<String, ArrayList<Double>> entry : materialNameWithSizes.entrySet()) {
			String name = entry.getKey();
			// Get existing size data.
			ArrayList<Double> sizes = materialNameWithSizes.get(name);
			// Sort, value ascending.
			Collections.sort(sizes, sortSmallerValuesToFront);
			sizes.add(0, 0.0);
			if (sizes.size() == 1)
				sizes.add(0, 0.0);
			// Count including empty first entry.
			double count = Math.max(1, sizes.size() - 1);
			double step = 10000.0 / count;
			double runningSize = 0.0;
			// Add sum of zero at entry zero.
			int i = 0;
			// Iterate objects, summing them across 0 to 10000 (an arbitrary range, a way to relate to other sums along X).
			for (Double size : sizes) {
				double someMeasurement = (size != null) ? size : 0.0;
				runningSize += someMeasurement;
				// Prepare to store this raw data entry.
				LinkedHashMap<String, Object> dataEntry = new LinkedHashMap<>();
				// Name the group.
				dataEntry.put(leafColumnName, name);
				dataEntry.put("date", i * step);
				dataEntry.put("size", runningSize);
				// Push the entry into the data pool.
				rawData.add(dataEntry);
				//
				i += 1;
			}
		}
		// Send it all back.
		return rawData;
	}

	public static String getNameOfMaterialsFromMaterialLike(IfcMaterialSelect materialLike, boolean includeIfcMaterialOID, boolean includeLayerPercentages) {
		String materialName = null;
		if (materialLike instanceof IfcMaterial) {
			IfcMaterial ifcMaterial = (IfcMaterial)materialLike;
			materialName = ifcMaterial.getName();
			if (includeIfcMaterialOID)
				materialName += String.format(" (%d)", ifcMaterial.getOid());
		} else if (materialLike instanceof IfcMaterialList) {
			IfcMaterialList ifcMaterialList = (IfcMaterialList)materialLike;
			ArrayList<String> materials = new ArrayList<>();
			for (IfcMaterial ifcMaterial : ifcMaterialList.getMaterials()) {
				String thisName = getNameOfMaterialsFromMaterialLike(ifcMaterial, includeIfcMaterialOID, includeLayerPercentages);
				materials.add(thisName);
			}
			materialName = StringUtils.join(materials, ", ");
		} else if (materialLike instanceof IfcMaterialLayerSetUsage) {
			IfcMaterialLayerSetUsage ifcMaterialLayerSetUsage = (IfcMaterialLayerSetUsage)materialLike;
			IfcMaterialLayerSet ifcMaterialLayerSet = ifcMaterialLayerSetUsage.getForLayerSet();
			return getNameOfMaterialsFromMaterialLike(ifcMaterialLayerSet, includeIfcMaterialOID, includeLayerPercentages);
		} else if (materialLike instanceof IfcMaterialLayerSet) {
			IfcMaterialLayerSet ifcMaterialLayerSet = (IfcMaterialLayerSet)materialLike;
			ArrayList<String> materials = new ArrayList<>();
			ArrayList<Double> thicknesses = new ArrayList<>();
			double thicknessSum = 0.0;
			for (IfcMaterialLayer ifcMaterialLayer : ifcMaterialLayerSet.getMaterialLayers()) {
				String thisName = getNameOfMaterialsFromMaterialLike(ifcMaterialLayer.getMaterial(), includeIfcMaterialOID, includeLayerPercentages);
				materials.add(thisName);
				//
				if (includeLayerPercentages) {
					double layerThickness = ifcMaterialLayer.getLayerThickness();
					thicknesses.add(layerThickness);
					thicknessSum += layerThickness;
				}
			}
			// Calculate percentages and add them to names.
			if (includeLayerPercentages && thicknessSum > 0)
				for (int i = 0; i < materials.size(); i++) {
					double thisPercent = 100 * thicknesses.get(i) / thicknessSum;
					String newMaterialName = String.format("%.2f%% %s", thisPercent, materials.get(i));
					materials.set(i, newMaterialName);
				}
			// Create the joined name.
			materialName = StringUtils.join(materials, ", ");
		} else if (materialLike instanceof IfcMaterialLayer) {
			IfcMaterialLayer ifcMaterialLayer = (IfcMaterialLayer)materialLike;
			return getNameOfMaterialsFromMaterialLike(ifcMaterialLayer.getMaterial(), includeIfcMaterialOID, includeLayerPercentages);
		}
		return materialName;
	}

	public static ArrayList<LinkedHashMap<String, Object>> getIfcMaterialsByNameWithTreeStructure(String structureKeyword, IfcModelInterface model, Chart chart, MutableInt subChartCount) {
		// Derive the column name.
		String leafColumnName = structureKeyword;
		// Update the chart configuration.
		chart.setDimensionLookupKey(structureKeyword, leafColumnName);
		chart.setDimensionLookupKey("date", "date");
		chart.setDimensionLookupKey("size", "size");
		// Prepare to iterate the relationships.
		LinkedHashMap<String, ArrayList<Double>> materialNameWithSizes = new LinkedHashMap<>(); 
		// Iterate only the relationships.
		for (IfcRelAssociatesMaterial ifcRelAssociatesMaterial : model.getAllWithSubTypes(IfcRelAssociatesMaterial.class))
		{
			// IfcMaterialSelect: IfcMaterial, IfcMaterialList, IfcMaterialLayerSetUsage, IfcMaterialLayerSet, IfcMaterialLayer.
			IfcMaterialSelect materialLike = ifcRelAssociatesMaterial.getRelatingMaterial();
			// If there was a material-like object, sum the names of what it decomposes into across X individually.
			if (materialLike != null) {
				// First, get size data from IFC products.
				ArrayList<Double> sizes = new ArrayList<>();
				// Iterate objects.
				EList<IfcRoot> ifcRoots = ifcRelAssociatesMaterial.getRelatedObjects();
				for (IfcRoot ifcRoot : ifcRoots) {
					Double size = 0.0;
					if (ifcRoot instanceof IfcObjectDefinition) {
						IfcObjectDefinition ifcObjectDefinition = (IfcObjectDefinition)ifcRoot;
						if (ifcObjectDefinition instanceof IfcObject) {
							IfcObject ifcObject = (IfcObject)ifcObjectDefinition;
							if (ifcObject instanceof IfcProduct) {
								IfcProduct ifcProduct = (IfcProduct)ifcObject;
								Double volume = getRoughVolumeEstimateFromIfcProduct(ifcProduct);
								size = volume;
							}
						}
					}
					if (size != null && size > 0)
						sizes.add(size);
				}
				// Get material names with percentages, like: Material Name -> 0.5
				LinkedHashMap<String, Double> materials = getNameOfMaterialsFromMaterialLikeWithPercents(materialLike, false);
				// Second, iterate materials, realizing the percentage of the sizes onto the collection of sizes for each material name.
				for (Entry<String, Double> materialEntry : materials.entrySet()) {
					String materialName = materialEntry.getKey();
					Double percent = materialEntry.getValue();
					// Use material name if available. Otherwise, use OID of top-level material-like object.
					String name = (materialName != null) ? materialName : String.format("%d", materialLike.getOid());
					// Add entry if it doesn't exist.
					if (!materialNameWithSizes.containsKey(name))
						materialNameWithSizes.put(name, new ArrayList<Double>());
					ArrayList<Double> theseSizes = materialNameWithSizes.get(name);
					// Get existing size data.
					if (percent != null && percent > 0) {
						// If not alteration is required, clone into the stack.
						if (percent == 1.0)
							theseSizes.addAll(sizes);
						// Otherwise, realize the percent of the size.
						else
							for (Double size : sizes)
								theseSizes.add(size * percent);
					}
				}
			}
		}
		//
		subChartCount.setValue(materialNameWithSizes.size());
		//
		ArrayList<LinkedHashMap<String, Object>> rawData = new ArrayList<>();
		//
		for (Entry<String, ArrayList<Double>> entry : materialNameWithSizes.entrySet()) {
			String name = entry.getKey();
			// Get existing size data.
			ArrayList<Double> sizes = materialNameWithSizes.get(name);
			// Sort, value ascending.
			Collections.sort(sizes, sortSmallerValuesToFront);
			sizes.add(0, 0.0);
			if (sizes.size() == 1)
				sizes.add(0, 0.0);
			// Count including empty first entry.
			double count = Math.max(1, sizes.size() - 1);
			double step = 10000.0 / count;
			double runningSize = 0.0;
			// Add sum of zero at entry zero.
			int i = 0;
			// Iterate objects, summing them across 0 to 10000 (an arbitrary range, a way to relate to other sums along X).
			for (Double size : sizes) {
				double someMeasurement = (size != null) ? size : 0.0;
				runningSize += someMeasurement;
				// Prepare to store this raw data entry.
				LinkedHashMap<String, Object> dataEntry = new LinkedHashMap<>();
				// Name the group.
				dataEntry.put(leafColumnName, name);
				dataEntry.put("date", i * step);
				dataEntry.put("size", runningSize);
				// Push the entry into the data pool.
				rawData.add(dataEntry);
				//
				i += 1;
			}
		}
		// Send it all back.
		return rawData;
	}

	public static LinkedHashMap<String, Double> getNameOfMaterialsFromMaterialLikeWithPercents(IfcMaterialSelect materialLike, boolean includeIfcMaterialOID) {
		// Prepare a place to store materials, like: Material Name -> 1.0
		LinkedHashMap<String, Double> parts = new LinkedHashMap<>();
		//
		if (materialLike instanceof IfcMaterial) {
			IfcMaterial ifcMaterial = (IfcMaterial)materialLike;
			String materialName = ifcMaterial.getName();
			if (includeIfcMaterialOID)
				materialName += String.format(" (%d)", ifcMaterial.getOid());
			// Material is 100% of the composition.
			parts.put(materialName, 1.0);
		} else if (materialLike instanceof IfcMaterialList) {
			IfcMaterialList ifcMaterialList = (IfcMaterialList)materialLike;
			for (IfcMaterial ifcMaterial : ifcMaterialList.getMaterials()) {
				String thisName = getNameOfMaterialsFromMaterialLike(ifcMaterial, includeIfcMaterialOID, false);
				// Pretend each material is 100% of the composition, because it was intentionally not specified. 
				parts.put(thisName, 1.0);
			}
		} else if (materialLike instanceof IfcMaterialLayerSetUsage) {
			IfcMaterialLayerSetUsage ifcMaterialLayerSetUsage = (IfcMaterialLayerSetUsage)materialLike;
			IfcMaterialLayerSet ifcMaterialLayerSet = ifcMaterialLayerSetUsage.getForLayerSet();
			return getNameOfMaterialsFromMaterialLikeWithPercents(ifcMaterialLayerSet, includeIfcMaterialOID);
		} else if (materialLike instanceof IfcMaterialLayerSet) {
			IfcMaterialLayerSet ifcMaterialLayerSet = (IfcMaterialLayerSet)materialLike;
			ArrayList<String> materials = new ArrayList<>();
			ArrayList<Double> thicknesses = new ArrayList<>();
			double thicknessSum = 0.0;
			for (IfcMaterialLayer ifcMaterialLayer : ifcMaterialLayerSet.getMaterialLayers()) {
				String thisName = getNameOfMaterialsFromMaterialLike(ifcMaterialLayer.getMaterial(), includeIfcMaterialOID, false);
				materials.add(thisName);
				//
				double layerThickness = ifcMaterialLayer.getLayerThickness();
				thicknesses.add(layerThickness);
				thicknessSum += layerThickness;
			}
			// Calculate percentages and add the materials.
			for (int i = 0; i < materials.size(); i++) {
				double thisPercent = (thicknessSum > 0) ? thicknesses.get(i) / thicknessSum : 0;
				parts.put(materials.get(i), thisPercent);
			}
		} else if (materialLike instanceof IfcMaterialLayer) {
			IfcMaterialLayer ifcMaterialLayer = (IfcMaterialLayer)materialLike;
			return getNameOfMaterialsFromMaterialLikeWithPercents(ifcMaterialLayer.getMaterial(), includeIfcMaterialOID);
		}
		return parts;
	}

	public static ArrayList<LinkedHashMap<String, Object>> getIfcByClassificationReferenceWithTreeStructure(String structureKeyword, IfcModelInterface model, Chart chart, boolean includeClassificationSystem) {
		ArrayList<LinkedHashMap<String, Object>> rawData = new ArrayList<>();
		// Prepare for static iteration.
		LinkedHashMap<IfcRelAssociatesClassification, Integer> ifcClassificationWithCounts = new LinkedHashMap<>();
		// Iterate only the products.
		for (IfcRelAssociatesClassification ifcRelAssociatesClassification : model.getAllWithSubTypes(IfcRelAssociatesClassification.class))
		{
			IfcRelAssociatesClassification key = ifcRelAssociatesClassification;
			Integer value = 0;
			if (ifcClassificationWithCounts.containsKey(key))
				value = ifcClassificationWithCounts.get(key);
			// Count.
			EList<IfcRoot> a = ifcRelAssociatesClassification.getRelatedObjects();
			ifcClassificationWithCounts.put(key, value + a.size());
		}
		// Derive the column names.
		ArrayList<String> hierarchyColumnNames = new ArrayList<>();
		int extraColumns = (includeClassificationSystem) ? 1 : 0;
		String leafColumnName = String.format("%s%d", structureKeyword, extraColumns + 1);
		for (int i = 0; i < extraColumns + 1; i++)
			hierarchyColumnNames.add(String.format("%s%d", structureKeyword, i + 1));
		// Update the chart configuration.
		chart.setDimensionLookupKeys(structureKeyword, hierarchyColumnNames);
		chart.setDimensionLookupKey("size", "size");
		chart.setDimensionLookupKey("label", "label");
		chart.setDimensionLookupKey("color", "size");
		// Add each entry.
		for (Entry<IfcRelAssociatesClassification, Integer> countedEntry : ifcClassificationWithCounts.entrySet()) {
			//
			Integer count = countedEntry.getValue();
			IfcRelAssociatesClassification ifcRelAssociatesClassification = countedEntry.getKey();
			//
			LinkedList<String> itemReferenceNames = new LinkedList<>();
			String classificationSystem = (ifcRelAssociatesClassification.isSetName()) ? ifcRelAssociatesClassification.getName() : "(no name)";
			//
			IfcClassificationNotationSelect notationOrReference = ifcRelAssociatesClassification.getRelatingClassification();
			if (notationOrReference instanceof IfcClassificationNotation) {
				// Get notation.
				IfcClassificationNotation notation = (IfcClassificationNotation)notationOrReference;
				// Go through the facets of this annotation.
				for (IfcClassificationNotationFacet facet : notation.getNotationFacets()) {
					String notationValue = facet.getNotationValue();
					itemReferenceNames.add(notationValue);
				}
				// TODO: Look up notation in classification. No inverse lookup is available.
			} else if (notationOrReference instanceof IfcClassificationReference) {
				// Get reference.
				IfcClassificationReference reference = (IfcClassificationReference)notationOrReference;
				// Get the reference name.
				String itemReferenceName = reference.getItemReference();
				itemReferenceNames.add(itemReferenceName);
				// Get the classification the reference links out to.
				IfcClassification classification = reference.getReferencedSource();
				// Use it.
				if (classification != null)
					classificationSystem = classification.getName();
			}
			//
			while (itemReferenceNames.size() > 0) {
				String itemReferenceName = itemReferenceNames.pop();
				// Prepare to store this raw data entry.
				LinkedHashMap<String, Object> dataEntry = new LinkedHashMap<>();
				// Name the group.
				String name = String.format("%s (%s)", itemReferenceName, count);
				dataEntry.put(leafColumnName, name);
				if (includeClassificationSystem)
					dataEntry.put(hierarchyColumnNames.get(0), classificationSystem);
				dataEntry.put("size", count);
				dataEntry.put("label", name);
				// Push the entry into the data pool.
				rawData.add(dataEntry);
			}
		}
		// Send it all back.
		return rawData;
	}

	/**
	 * @param enclosingClass
	 */
	public static String getSanitizedSimpleClassName(Class<?> enclosingClass) {
		String enclosingClassName = (enclosingClass != null) ? enclosingClass.getSimpleName() : "";
		if (enclosingClassName.endsWith("Impl"))
			enclosingClassName = enclosingClassName.substring(0, enclosingClassName.length() - "Impl".length());
		if (enclosingClassName.startsWith("Ifc"))
			enclosingClassName = enclosingClassName.substring("Ifc".length(), enclosingClassName.length());
		return StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(enclosingClassName), ' ');
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
