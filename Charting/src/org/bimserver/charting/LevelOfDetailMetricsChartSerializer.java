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

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.bimserver.charting.Charts.Alluvial;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcProxy;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.utils.UTF8PrintWriter;
import org.eclipse.emf.ecore.EAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelOfDetailMetricsChartSerializer extends ChartEmfSerializer {

	public enum DetailMode {
		Everything, NoProxies, NoFurniture
	};

	private static final Logger LOGGER = LoggerFactory.getLogger(LevelOfDetailMetricsChartSerializer.class);

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManagerInterface pluginManager, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, pluginManager, packageMetaData, normalizeOids);
		// Pick chart.
		chart = new Alluvial();
		integrateSettings();
		// Prepare for data.
		rawData = new ArrayList<>();
	}

	@Override
	protected boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		if (getMode() == Mode.BODY) {
			DetailMode possibleDetailMode = (hasOption("Detail Mode")) ? (DetailMode) getOptionValue("Detail Mode") : DetailMode.Everything;
			DetailMode detailMode = (possibleDetailMode != null) ? possibleDetailMode : DetailMode.Everything;
			getLevelOfDetailData(detailMode);
			// Write chart.
			PrintWriter writer = new UTF8PrintWriter(outputStream);
			try {
				writer.print(chart.writeSVG(rawData));
				writer.flush();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			writer.close();
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED)
			return false;
		//
		return false;
	}

	@SuppressWarnings("serial")
	public void getLevelOfDetailData(DetailMode detailMode) {
		// See: DemoPlugins->Lod2ExcelServicePlugin.java
		// See: http://www.bimserver.org/wp-content/uploads/sites/28/2014/07/20140403_NLOD-extended.pdf
		float scaleFactorToMeter = 1;
		for (IfcSIUnit ifcSIUnit : model.getAll(IfcSIUnit.class)) {
			if (ifcSIUnit.getUnitType() == IfcUnitEnum.LENGTHUNIT) {
				IfcSIUnitName ifcSiUnitName = ifcSIUnit.getName();
				if (IfcSIUnitName.METRE == ifcSiUnitName) {
					IfcSIPrefix lengthPrefix = ifcSIUnit.getPrefix();
					if (lengthPrefix == IfcSIPrefix.DECA) {
						scaleFactorToMeter = 10f;
					} else if (lengthPrefix == IfcSIPrefix.CENTI) {
						scaleFactorToMeter = 0.1f;
					} else if (lengthPrefix == IfcSIPrefix.DECI) {
						scaleFactorToMeter = 0.01f;
					} else if (lengthPrefix == IfcSIPrefix.MILLI) {
						scaleFactorToMeter = 0.001f;
					} else if (lengthPrefix == IfcSIPrefix.NULL) {
						scaleFactorToMeter = 1;
					} else {
						// Unimplemented prefix.
					}
				} else {
					// Not a length measurement.
				}
			}
		}
		double cubicScaleFactor = Math.pow(scaleFactorToMeter, 3);
		Bounds totalBounds = new Bounds();
		// Whole IFC.
		int totalNrTriangles = 0, nrIfcProducts = 0, totalUsedAttributes = 0;
		// IFC minus proxies.
		int totalNrTrianglesNoProxies = 0, nrIfcProductsNoProxies = 0, totalUsedAttributesNoProxies = 0;
		// IFC minus furniture.
		int totalNrTrianglesNoFurniture = 0, nrIfcProductsNoFurniture = 0, totalUsedAttributesNoFurniture = 0;
		//
		double totalSpaceM3 = 0;
		model.getAll(GeometryInfo.class);
		model.getAll(Vector3f.class);
		int nrSpaces = 0;
		for (IfcSpace ifcSpace : model.getAll(IfcSpace.class)) {
			if (ifcSpace.getGeometry() != null) {
				Vector3f minBounds = ifcSpace.getGeometry().getMinBounds(), maxBounds = ifcSpace.getGeometry().getMinBounds();
				double v = cubicScaleFactor * (maxBounds.getX() - minBounds.getX() * (maxBounds.getY() - minBounds.getY()) * (maxBounds.getZ() - minBounds.getZ()));
				totalSpaceM3 += v;
				nrSpaces++;
			}
		}
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			GeometryInfo geometry = ifcProduct.getGeometry();
			if (geometry != null) {
				totalBounds.integrate(new Bounds(geometry.getMinBounds(), geometry.getMaxBounds()));
				Integer primitiveCount = geometry.getPrimitiveCount();
				// Failing to get a (cached?) primitive count, ask for the actual geometry.
				if (primitiveCount == null) {
					// Get the actual data out of the geometry information.
					GeometryData geometryData = geometry.getData();
					//
					if (geometryData != null) {
						byte[] positionsBuffer = geometryData.getVertices();
						primitiveCount = positionsBuffer.length / 3;
					}
				}
				primitiveCount = (primitiveCount != null) ? primitiveCount : 0;
				totalNrTriangles += primitiveCount;
				if (!(ifcProduct instanceof IfcFurnishingElement))
					totalNrTrianglesNoFurniture += primitiveCount;
				if (!(ifcProduct instanceof IfcProxy))
					totalNrTrianglesNoProxies += primitiveCount;
				int usedAttributes = 0;
				for (EAttribute eAttribute : ifcProduct.eClass().getEAllAttributes()) {
					Object val = ifcProduct.eGet(eAttribute);
					if (eAttribute.isMany()) {
						List<?> list = (List<?>) val;
						if (list.size() > 0)
							usedAttributes++;
					} else if (val != null)
						usedAttributes++;
				}
				for (IfcRelDefines ifcRelDefines : ifcProduct.getIsDefinedBy()) {
					if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
						IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
						IfcPropertySetDefinition propertySetDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
						if (propertySetDefinition instanceof IfcPropertySet) {
							IfcPropertySet ifcPropertySet = (IfcPropertySet) propertySetDefinition;
							usedAttributes += ifcPropertySet.getHasProperties().size();
						}
					}
				}
				totalUsedAttributes += usedAttributes;
				nrIfcProducts++;
				if (!(ifcProduct instanceof IfcFurnishingElement)) {
					totalUsedAttributesNoFurniture += usedAttributes;
					nrIfcProductsNoFurniture++;
				}
				if (!(ifcProduct instanceof IfcProxy)) {
					totalUsedAttributesNoProxies += usedAttributes;
					nrIfcProductsNoProxies++;
				}
			}
		}
		// Revise.
		if (detailMode == DetailMode.NoProxies) {
			nrIfcProducts = nrIfcProductsNoProxies;
			totalNrTriangles = totalNrTrianglesNoProxies;
			totalUsedAttributes = totalUsedAttributesNoProxies;
		} else if (detailMode == DetailMode.NoFurniture) {
			nrIfcProducts = nrIfcProductsNoFurniture;
			totalNrTriangles = totalNrTrianglesNoFurniture;
			totalUsedAttributes = totalUsedAttributesNoFurniture;
		}
		// Finalize calculated component values.
		final double volumeOfObjects = cubicScaleFactor * (totalBounds.maxX - totalBounds.minX) * (totalBounds.maxY - totalBounds.minY) * (totalBounds.maxZ - totalBounds.minZ);
		final int objectCount = nrIfcProducts;
		final int triangleCount = totalNrTriangles;
		final double volumeOfSpaces = totalSpaceM3;
		final int objectPropertiesCount = totalUsedAttributes;
		// Calculated components.
		final String objectCountString = String.format("Object Count: %d", objectCount);
		final String objectsVolumeString = (volumeOfObjects >= 1) ? String.format("Volume of Objects: %.2f meters\u00B3", volumeOfObjects) : String.format("Volume of Objects: %f meters\u00B3", volumeOfObjects);
		final String spacesVolumeString = (volumeOfSpaces >= 1) ? String.format("Volume of %d Spaces: %.2f meters\u00B3", nrSpaces, volumeOfSpaces) : String.format("Volume of %d Spaces: %f meters\u00B3", nrSpaces, volumeOfSpaces);
		final String triangleCountString = String.format("Triangle Count: %d", triangleCount);
		final String objectPropertiesCountString = String.format("Object Properties Count: %d", objectPropertiesCount);
		// Derivations.
		double objectCountByVolumeOfObjects = (volumeOfObjects > 0) ? objectCount / volumeOfObjects : 0;
		double triangleCountByVolumeOfObjects = (volumeOfObjects > 0) ? triangleCount / volumeOfObjects : 0;
		double objectCountByVolumeOfSpaces = (volumeOfSpaces > 0) ? objectCount / volumeOfSpaces : 0;
		double triangleCountByVolumeOfSpaces = (volumeOfSpaces > 0) ? triangleCount / volumeOfSpaces : 0;
		double objectPropertiesCountByObjectCount = (objectCount > 0) ? objectPropertiesCount / (float) objectCount : 0;
		// Derivation text.
		final String objectCountByObjectsVolumeString = String.format("Object Count / Volume of Objects: %.2f objects per meters\u00B3", objectCountByVolumeOfObjects);
		final String triangleCountByObjectsVolumeString = String.format("Triangle Count / Volume of Objects: %.2f triangles per meters\u00B3", triangleCountByVolumeOfObjects);
		final String objectCountBySpacesVolumeString = String.format("Object Count / Volume of Spaces: %.2f objects per meters\u00B3", objectCountByVolumeOfSpaces);
		final String triangleCountBySpacesVolumeString = String.format("Triangle Count / Volume of Spaces: %.2f triangles per meters\u00B3", triangleCountByVolumeOfSpaces);
		final String propertyCountByObjectCountString = String.format("Object Properties Count / Object Count: %.2f properties per object", objectPropertiesCountByObjectCount);
		/*
		 * derived, calculated component, size
		 * Objects/M3: 0.04, Objects: 917, 917
		 * Objects/M3: 0.04, M3 Volume: 26090 m3, 26090
		 */
		final String calculatedComponentColumn = "calculated component";
		final String derivationColumn = "derivation";
		final String sizeColumn = "size";
		chart.setDimensionLookupKeys("steps", Arrays.asList(derivationColumn, calculatedComponentColumn));
		chart.setDimensionLookupKey("size", sizeColumn);
		// Object Count / Volume of Objects
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, objectCountString);
				put(derivationColumn, objectCountByObjectsVolumeString);
				put(sizeColumn, objectCount);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, objectsVolumeString);
				put(derivationColumn, objectCountByObjectsVolumeString);
				put(sizeColumn, volumeOfObjects);
			}
		});
		// Triangle Count / Volume of Objects
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, triangleCountString);
				put(derivationColumn, triangleCountByObjectsVolumeString);
				put(sizeColumn, triangleCount);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, objectsVolumeString);
				put(derivationColumn, triangleCountByObjectsVolumeString);
				put(sizeColumn, volumeOfObjects);
			}
		});
		// Object Count / Volume of Spaces
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, objectCountString);
				put(derivationColumn, objectCountBySpacesVolumeString);
				put(sizeColumn, objectCount);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, spacesVolumeString);
				put(derivationColumn, objectCountBySpacesVolumeString);
				put(sizeColumn, volumeOfSpaces);
			}
		});
		// Triangle Count / Volume of Spaces
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, triangleCountString);
				put(derivationColumn, triangleCountBySpacesVolumeString);
				put(sizeColumn, triangleCount);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, spacesVolumeString);
				put(derivationColumn, triangleCountBySpacesVolumeString);
				put(sizeColumn, volumeOfSpaces);
			}
		});
		// Object Properties Count / Object Count
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, objectPropertiesCountString);
				put(derivationColumn, propertyCountByObjectCountString);
				put(sizeColumn, objectPropertiesCount);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put(calculatedComponentColumn, objectCountString);
				put(derivationColumn, propertyCountByObjectCountString);
				put(sizeColumn, objectCount);
			}
		});
	}

	class Bounds {
		double minX = Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		double minZ = Double.MAX_VALUE;
		double maxX = -Double.MAX_VALUE;
		double maxY = -Double.MAX_VALUE;
		double maxZ = -Double.MAX_VALUE;

		public Bounds() {}

		public Bounds(Vector3f minBounds, Vector3f maxBounds) {
			minX = minBounds.getX();
			minY = minBounds.getY();
			minZ = minBounds.getZ();
			maxX = maxBounds.getX();
			maxY = maxBounds.getY();
			maxZ = maxBounds.getZ();
		}

		public void integrate(Bounds bounds) {
			if (bounds.maxX > maxX)
				maxX = bounds.maxX;
			if (bounds.maxY > maxY)
				maxY = bounds.maxY;
			if (bounds.maxZ > maxZ)
				maxZ = bounds.maxZ;
			if (bounds.minX < minX)
				minX = bounds.minX;
			if (bounds.minY < minY)
				minY = bounds.minY;
			if (bounds.minZ < minZ)
				minZ = bounds.minZ;
		}

		@Override
		public String toString() {
			return minX + ", " + minY + ", " + minZ + ", " + maxX + ", " + maxY + ", " + maxZ;
		}
	}
}
