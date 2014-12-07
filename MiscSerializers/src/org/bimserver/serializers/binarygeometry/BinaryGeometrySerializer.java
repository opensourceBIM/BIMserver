package org.bimserver.serializers.binarygeometry;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.ifc2x3tc1.GeometryData;
import org.bimserver.models.ifc2x3tc1.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcMaterial;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayer;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3tc1.IfcMaterialLayerSetUsage;
import org.bimserver.models.ifc2x3tc1.IfcMaterialSelect;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociates;
import org.bimserver.models.ifc2x3tc1.IfcRelAssociatesMaterial;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.plugins.serializers.AbstractGeometrySerializer;
import org.bimserver.plugins.serializers.AligningOutputStream;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryGeometrySerializer extends AbstractGeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(BinaryGeometrySerializer.class);
	private static final byte FORMAT_VERSION = 4;
	private final HashMap<String, HashMap<String, HashSet<Long>>> typeMaterialGeometryRel = new HashMap<String, HashMap<String, HashSet<Long>>>();
	private static final byte GEOMETRY_TYPE_TRIANGLES = 0;
	private static final byte GEOMETRY_TYPE_INSTANCE = 1;

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}

	@Override
	protected boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		if (getMode() == Mode.BODY) {
			try {
				calculateGeometryExtents();
				writeGeometries(outputStream);
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

	private void writeGeometries(OutputStream outputStream) throws IOException {
		long start = System.nanoTime();

		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		dataOutputStream.writeUTF("BGS");
		dataOutputStream.writeByte(FORMAT_VERSION);
		
		Bounds modelBounds = new Bounds();
		int nrObjects = 0;
		
		List<IfcProduct> products = getModel().getAllWithSubTypes(IfcProduct.class);
		long oidCounter = 1;
		for (IfcProduct ifcProduct : products) {
			GeometryInfo geometryInfo = ifcProduct.getGeometry();
			if (geometryInfo != null && geometryInfo.getTransformation() != null && geometryInfo.getData().getVertices() != null) {
				// This is for geometry that is generated on-the-fly
				if (geometryInfo.getData().getOid() == -1) {
					((IdEObjectImpl)geometryInfo.getData()).setOid(oidCounter++);
				}

				Bounds objectBounds = new Bounds(new Float3(geometryInfo.getMinBounds().getX(), geometryInfo.getMinBounds().getY(), geometryInfo.getMinBounds()
						.getZ()), new Float3(geometryInfo.getMaxBounds().getX(), geometryInfo.getMaxBounds().getY(), geometryInfo.getMaxBounds().getZ()));
				modelBounds.integrate(objectBounds);
				nrObjects++;
			}
		}
		modelBounds.writeTo(dataOutputStream);
		dataOutputStream.writeInt(nrObjects);
		int bytesSaved = 0;
		int bytesTotal = 0;
		
		Set<Long> concreteGeometrySent = new HashSet<>();
		
		dataOutputStream.flush();
		
		int counter = 0;
		
		for (IfcProduct ifcProduct : products) {
			GeometryInfo geometryInfo = ifcProduct.getGeometry();
			if (geometryInfo != null && geometryInfo.getTransformation() != null && geometryInfo.getData().getVertices() != null) {
				dataOutputStream.writeUTF(ifcProduct.eClass().getName());
				dataOutputStream.writeLong(ifcProduct.getOid());
				
				GeometryData geometryData = geometryInfo.getData();
				byte[] vertices = geometryData.getVertices();
				
				// BEWARE, ByteOrder is always LITTLE_ENDIAN, because that's what GPU's seem to prefer, Java's ByteBuffer default is BIG_ENDIAN though!
				
				bytesTotal += vertices.length;
				byte geometryType = geometryData.getOid() != -1 && concreteGeometrySent.contains(geometryData.getOid()) ? GEOMETRY_TYPE_INSTANCE : GEOMETRY_TYPE_TRIANGLES;
				dataOutputStream.write(geometryType);

				if (outputStream instanceof AligningOutputStream) {
					((AligningOutputStream)outputStream).align4();
				} else {
					int skip = 4 - (dataOutputStream.size() % 4);
					if(skip != 0 && skip != 4) {
						dataOutputStream.write(new byte[skip]);
					}
				}
				
				dataOutputStream.write(geometryInfo.getTransformation());

				if (geometryType == GEOMETRY_TYPE_INSTANCE) {
					dataOutputStream.writeLong(geometryData.getOid());
					bytesSaved += vertices.length;
				} else if (geometryType == GEOMETRY_TYPE_TRIANGLES) {
					dataOutputStream.writeLong(geometryData.getOid());

					Bounds objectBounds = new Bounds(geometryInfo.getMinBounds(), geometryInfo.getMaxBounds());
					objectBounds.writeTo(dataOutputStream);

					ByteBuffer indicesBuffer = ByteBuffer.wrap(geometryData.getIndices());
					dataOutputStream.writeInt(indicesBuffer.capacity() / 4);
					dataOutputStream.write(indicesBuffer.array());
					
					ByteBuffer vertexByteBuffer = ByteBuffer.wrap(vertices);
					dataOutputStream.writeInt(vertexByteBuffer.capacity() / 4);
					dataOutputStream.write(vertexByteBuffer.array());
					
					ByteBuffer normalsBuffer = ByteBuffer.wrap(geometryData.getNormals());
					dataOutputStream.writeInt(normalsBuffer.capacity() / 4);
					dataOutputStream.write(normalsBuffer.array());

					if (geometryData.getMaterials() != null) {
//						ByteBuffer materialIndexByteBuffer = ByteBuffer.wrap(geometryData.getMaterialIndices());
//						materialIndexByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
//						IntBuffer materialIndicesBuffer = materialIndexByteBuffer.asIntBuffer();
						
						
						ByteBuffer materialsBuffer = ByteBuffer.wrap(geometryData.getMaterials());
						dataOutputStream.writeInt(materialsBuffer.capacity() / 4);
						dataOutputStream.write(materialsBuffer.array());
//						
//						for (int i=0; i<materialsBuffer.capacity(); i++) {
//							dataOutputStream.writeFloat(materialsBuffer.get(i));
//						}
						
//						dataOutputStream.writeInt(materialIndicesBuffer.capacity() * 3);
//						for (int i=0; i<materialIndicesBuffer.capacity(); i++) {
//							int materialIndex = materialIndicesBuffer.get(i);
//							if (materialIndex == -1) {
//								ByteBuffer test = ByteBuffer.wrap(new byte[16]);
//								test.order(ByteOrder.LITTLE_ENDIAN);
//								FloatBuffer fl = test.asFloatBuffer();
//								fl.put(1f);
//								fl.put(0f);
//								fl.put(0f);
//								fl.put(1f);
//								for (int j=0; j<3; j++) {
//									dataOutputStream.write(test.array());
//								}
//							} else {
//								float r = materialsBuffer.get(materialIndex * 4);
//								float g = materialsBuffer.get(materialIndex * 4 + 1);
//								float b = materialsBuffer.get(materialIndex * 4 + 2);
//								float a = materialsBuffer.get(materialIndex * 4 + 3);
//								ByteBuffer test = ByteBuffer.wrap(new byte[16]);
//								test.order(ByteOrder.LITTLE_ENDIAN);
//								FloatBuffer fl = test.asFloatBuffer();
//								fl.put(r);
//								fl.put(g);
//								fl.put(b);
//								fl.put(a);
//								for (int j=0; j<3; j++) {
//									dataOutputStream.write(test.array());
//								}
//							}
//						}
					} else {
						dataOutputStream.writeInt(0);
					}
					
					concreteGeometrySent.add(geometryData.getOid());
				}
				counter++;
//				if (counter % 12 == 0) {
					dataOutputStream.flush();
//				}
			}
		}
		dataOutputStream.flush();
		if (bytesTotal != 0 && bytesSaved != 0) {
			LOGGER.info((100 * bytesSaved / bytesTotal) + "% saved");
		}
		long end = System.nanoTime();
		LOGGER.debug(((end - start) / 1000000) + " ms");
	}
	
	private void add(Set<IfcProduct> alreadySent, IfcObjectDefinition parent) {
		if (alreadySent.contains(parent)) {
			return;
		}
		if (parent instanceof IfcProduct) {
			alreadySent.add((IfcProduct) parent);
		}
		EList<IfcRelDecomposes> isDecomposedBy = parent.getIsDecomposedBy();
		for (IfcRelDecomposes ifcRelDecomposes : isDecomposedBy) {
			for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
				add(alreadySent, ifcObjectDefinition);
			}
		}
	}
	
	@SuppressWarnings("unused")
	private Set<IfcProduct> getNicelyOrdered(IfcModelInterface model) {
		Set<IfcProduct> alreadySent = new LinkedHashSet<>();
		List<IfcBuildingStorey> stories = model.getAllWithSubTypes(IfcBuildingStorey.class);
		Collections.sort(stories, new Comparator<IfcBuildingStorey>(){
			@Override
			public int compare(IfcBuildingStorey o1, IfcBuildingStorey o2) {
				return (int) (o1.getElevation() - o2.getElevation());
			}
		});
		for (IfcBuildingStorey ifcBuildingStorey : stories) {
			add(alreadySent, ifcBuildingStorey);
		}
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			if (!alreadySent.contains(ifcProduct)) {
				alreadySent.add(ifcProduct);
			}
		}
		return alreadySent;
	}

	public String getMaterial(IfcProduct ifcProduct) throws Exception {
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
//						materialFound = surfaceStyleIds.contains(filterSpaces);
//						if (materialFound) {
							material = filterSpaces;
//						}
					}
				}
			}
		} else if (relatingMaterial instanceof IfcMaterial) {
			IfcMaterial ifcMaterial = (IfcMaterial) relatingMaterial;
			String name = ifcMaterial.getName();
			String filterSpaces = fitNameForQualifiedName(name);
//			materialFound = surfaceStyleIds.contains(filterSpaces);
//			if (materialFound) {
				material = filterSpaces;
//			}
		}

		// If no material was found then derive one from the presentation style
		if (!materialFound) {
			IfcProductRepresentation representation = ifcProduct.getRepresentation();
			if (representation != null) {
				EList<IfcRepresentation> representations = representation.getRepresentations();
				for (IfcRepresentation rep : representations) {
					EList<IfcRepresentationItem> items = rep.getItems();
					for (IfcRepresentationItem item : items) {
						if (item instanceof IfcStyledItem) {
							material = processStyledItem(material, (IfcStyledItem) item);
						} else {
							EList<IfcStyledItem> styledByItem = item.getStyledByItem();
							for (IfcStyledItem sItem : styledByItem) {
								material = processStyledItem(material, sItem);
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
		if (material == null) {
			return "UNKNOWN";
		}
		return material;
	}
	
	private String processStyledItem(String material, IfcStyledItem sItem) {
		for (IfcStyledItem ifc : sItem.getStyledByItem()) {
			processStyledItem(material, ifc);
		}
		EList<IfcPresentationStyleAssignment> styles = sItem.getStyles();
		for (IfcPresentationStyleAssignment sa : styles) {
			EList<IfcPresentationStyleSelect> styles2 = sa.getStyles();
			for (IfcPresentationStyleSelect pss : styles2) {
				if (pss instanceof IfcSurfaceStyle) {
					IfcSurfaceStyle ss = (IfcSurfaceStyle) pss;
					material = "" + ss.getOid();
				}
			}
		}
		return material;
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