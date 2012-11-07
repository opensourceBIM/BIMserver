package org.bimserver.geometry.json;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryInstance;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.scenejs.GeometrySerializer;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

/*
 * A few notes:
 * 	- Not using a JSON library here, measured a performance gain of x2 compared with streaming gson
 *  - Not sending indices because the client can figure those out themselves (just count from 0 -> primitivecount * 3)
 */

public class JsonGeometrySerializer extends GeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonGeometrySerializer.class);

	private final HashMap<String, HashMap<String, HashSet<Long>>> typeMaterialGeometryRel = new HashMap<String, HashMap<String, HashSet<Long>>>();
	private final List<String> surfaceStyleIds = new ArrayList<String>();
	private boolean isFirst = true;

	@Override
	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, IfcEngine ifcEngine, boolean normalizeOids) throws SerializerException {
		super.init(model, projectInfo, pluginManager, ifcEngine, normalizeOids);
	}

	@Override
	public void reset() {
		isFirst = true;
		typeMaterialGeometryRel.clear();
		surfaceStyleIds.clear();
		setMode(Mode.BODY);
	}

	@Override
	public boolean write(OutputStream out) throws SerializerException {
		if (getMode() == Mode.BODY) {
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, Charsets.UTF_8);
			try {
				PrintWriter writer = new PrintWriter(outputStreamWriter);

				writer.print("{\"geometry\":[");
				writeGeometries(writer);
				writer.print("]}");
				
				writer.flush();
			} catch (Exception e) {
				LOGGER.error("", e);
			}
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private void writeGeometries(PrintWriter writer) throws IfcEngineException, SerializerException, IOException {
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			writeGeometricObject(writer, ifcProduct);
		}
	}

	private void writeGeometricObject(PrintWriter writer, IfcProduct ifcProduct) throws IfcEngineException, SerializerException, IOException {
		boolean materialFound = false;
		String material = ifcProduct.eClass().getName();
		if (ifcProduct instanceof IfcSlab && ((IfcSlab)ifcProduct).getPredefinedType() == IfcSlabTypeEnum.ROOF) {
			material = Ifc2x3tc1Package.eINSTANCE.getIfcRoof().getName();
		}
		
		IfcMaterialSelect relatingMaterial = null;
		for (IfcRelAssociates ifcRelAssociates : ifcProduct.getHasAssociations()) {
			if (ifcRelAssociates instanceof IfcRelAssociatesMaterial) {
				IfcRelAssociatesMaterial ifcRelAssociatesMaterial = (IfcRelAssociatesMaterial)ifcRelAssociates;
				relatingMaterial = ifcRelAssociatesMaterial.getRelatingMaterial();
			}
		}

		// Try to find the IFC material name
		if (relatingMaterial instanceof IfcMaterialLayerSetUsage) {
			IfcMaterialLayerSetUsage mlsu = (IfcMaterialLayerSetUsage) relatingMaterial;
			IfcMaterialLayerSet forLayerSet = mlsu.getForLayerSet();
			if (forLayerSet != null) {
				EList<IfcMaterialLayer> materialLayers = forLayerSet.getMaterialLayers();
				for (IfcMaterialLayer ml : materialLayers) {
					IfcMaterial ifcMaterial = ml.getMaterial();
					if (ifcMaterial != null) {
						String name = ifcMaterial.getName();
						String filterSpaces = fitNameForQualifiedName(name);
						materialFound = surfaceStyleIds.contains(filterSpaces);
						if (materialFound) {
							material = filterSpaces;
						}
					}
				}
			}
		} else if (relatingMaterial instanceof IfcMaterial) {
			IfcMaterial ifcMaterial = (IfcMaterial) relatingMaterial;
			String name = ifcMaterial.getName();
			String filterSpaces = fitNameForQualifiedName(name);
			materialFound = surfaceStyleIds.contains(filterSpaces);
			if (materialFound) {
				material = filterSpaces;
			}
		}

		// If no material was found then derive one from the presentation style
		if (!materialFound) {
			IfcProductRepresentation representation = ifcProduct.getRepresentation();
			if (representation instanceof IfcProductDefinitionShape) {
				IfcProductDefinitionShape pds = (IfcProductDefinitionShape) representation;
				EList<IfcRepresentation> representations = pds.getRepresentations();
				for (IfcRepresentation rep : representations) {
					if (rep instanceof IfcShapeRepresentation) {
						IfcShapeRepresentation sRep = (IfcShapeRepresentation) rep;
						EList<IfcRepresentationItem> items = sRep.getItems();
						for (IfcRepresentationItem item : items) {
							EList<IfcStyledItem> styledByItem = item.getStyledByItem();
							for (IfcStyledItem sItem : styledByItem) {
								EList<IfcPresentationStyleAssignment> styles = sItem.getStyles();
								for (IfcPresentationStyleAssignment sa : styles) {
									EList<IfcPresentationStyleSelect> styles2 = sa.getStyles();
									for (IfcPresentationStyleSelect pss : styles2) {
										if (pss instanceof IfcSurfaceStyle) {
											IfcSurfaceStyle ss = (IfcSurfaceStyle) pss;
											String name = ss.getName();
											String filterSpaces = fitNameForQualifiedName(name);
											materialFound = surfaceStyleIds.contains(filterSpaces);
											if (materialFound) {
												material = filterSpaces;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		HashMap<String, HashSet<Long>> materialGeometryRel = typeMaterialGeometryRel.get(ifcProduct.eClass().getName());
		if (materialGeometryRel == null) {
			materialGeometryRel = new HashMap<String, HashSet<Long>>();
			typeMaterialGeometryRel.put(ifcProduct.eClass().getName(), materialGeometryRel);
		}

		HashSet<Long> hashSet = materialGeometryRel.get(material);
		if (hashSet == null) {
			hashSet = new HashSet<Long>();
			materialGeometryRel.put(material, hashSet);
		}
		hashSet.add(ifcProduct.getOid());

		if (isFirst ) {
			writer.print("{");
			isFirst = false;
		} else {
			writer.print(",{");
		}
		writeGeometryFromInstancesGeometryObject(writer, ifcProduct, material);
		
		writer.print("}");
	}

	private void writeGeometryFromInstancesGeometryObject(PrintWriter writer, IfcProduct ifcObject, String material) throws IOException {
		GeometryInstance geometryInstance = ifcObject.getGeometryInstance();

		if (geometryInstance != null) {
			ByteBuffer verticesBuffer = ByteBuffer.wrap(geometryInstance.getVertices());
			ByteBuffer normalsBuffer = ByteBuffer.wrap(geometryInstance.getNormals());

			writer.print("\"material\":\"" + material + "\",");
			writer.print("\"type\":\"geometry\",");
			writer.print("\"coreId\":\"" + ifcObject.getOid() + "\",");
			writer.print("\"primitive\":\"triangles\",");
			writer.print("\"positions\":[");
			int t = geometryInstance.getPrimitiveCount() * 3 * 3;
			for (int i = 0; i < t; i++) {
				if (i < t - 1) {
					writer.print(verticesBuffer.getFloat() + ",");
				} else {
					writer.print(verticesBuffer.getFloat());
				}
			}
			writer.print("], \"normals\":[");
			for (int i = 0; i < t; i++) {
				if (i < t - 1) {
					writer.print(normalsBuffer.getFloat() + ",");
				} else {
					writer.print(normalsBuffer.getFloat());
				}
			}
			writer.print("]");
			writer.print(",\"nrindices\":" + (geometryInstance.getPrimitiveCount() * 3));
		}
	}

	private String fitNameForQualifiedName(String name) {
		if (name == null) {
			return "Null";
		}
		StringBuilder builder = new StringBuilder(name);
		int indexOfChar = builder.indexOf(" ");
		while (indexOfChar >= 0) {
			builder.deleteCharAt(indexOfChar);
			indexOfChar = builder.indexOf(" ");
		}
		indexOfChar = builder.indexOf(",");
		while (indexOfChar >= 0) {
			builder.setCharAt(indexOfChar, '_');
			indexOfChar = builder.indexOf(",");
		}
		indexOfChar = builder.indexOf("/");
		while (indexOfChar >= 0) {
			builder.setCharAt(indexOfChar, '_');
			indexOfChar = builder.indexOf("/");
		}
		indexOfChar = builder.indexOf("*");
		while (indexOfChar >= 0) {
			builder.setCharAt(indexOfChar, '_');
			indexOfChar = builder.indexOf("/");
		}
		return builder.toString();
	}
}