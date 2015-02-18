package org.bimserver.citygml;

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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.bimserver.citygml.xbuilding.GlobalIdType;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.models.geometry.GeometryData;
import org.bimserver.models.geometry.GeometryInfo;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcColumn;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcFlowTerminal;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcInternalOrExternalEnum;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOpeningElement;
import org.bimserver.models.ifc2x3tc1.IfcPostalAddress;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDecomposes;
import org.bimserver.models.ifc2x3tc1.IfcRelFillsElement;
import org.bimserver.models.ifc2x3tc1.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3tc1.IfcRelVoidsElement;
import org.bimserver.models.ifc2x3tc1.IfcRoof;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcStair;
import org.bimserver.models.ifc2x3tc1.IfcVirtualElement;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.plugins.serializers.AbstractGeometrySerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.factory.XALFactory;
import org.citygml4j.impl.citygml.generics.DoubleAttributeImpl;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.citygml.generics.DoubleAttribute;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.DirectPositionList;
import org.citygml4j.model.gml.geometry.primitives.Exterior;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.xal.AddressDetails;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReadException;
import org.citygml4j.xml.io.writer.CityGMLWriteException;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

public class CityGmlSerializer extends AbstractGeometrySerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityGmlSerializer.class);
	private GMLFactory gml;
	private XALFactory xal;
	private CityGMLFactory citygml;
	private Map<EObject, AbstractCityObject> convertedObjects;
	private CityGMLContext ctx;

	// private ObjectFactory xbuilding;
	// private org.citygml4j.jaxb.gml._3_1_1.ObjectFactory gmlObjectFactory;

	public CityGmlSerializer() {
	}

	@Override
	public void init(IfcModelInterface ifcModel, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		super.init(ifcModel, projectInfo, pluginManager, renderEnginePlugin, packageMetaData, normalizeOids);
		this.model = ifcModel;
		ctx = new CityGMLContext();
		citygml = new CityGMLFactory();
		gml = new GMLFactory();
		xal = new XALFactory();
		// xbuilding = new ObjectFactory();
		// gmlObjectFactory = new org.citygml4j.jaxb.gml._3_1_1.ObjectFactory();
		convertedObjects = new HashMap<EObject, AbstractCityObject>();
	}

	private Code createName(String value) {
		Code code = gml.createCode();
		code.setValue(value);
		return code;
	}

	@Override
	public void reset() {
		setMode(Mode.BODY);
	}

	public boolean write(OutputStream out, ProgressReporter progressReporter) throws SerializerException {
		if (getMode() == Mode.BODY) {
			CityModel cityModel = citygml.createCityModel();
			cityModel.setName(createNameList(getModel().getModelMetaData().getName()));
			JAXBBuilder builder = null;
			try {
				builder = ctx.createJAXBBuilder(getClass().getClassLoader());
			} catch (JAXBException e) {
				LOGGER.error("", e);
			}
			for (IfcProject ifcProject : getModel().getAll(IfcProject.class)) {
				for (IfcRelDecomposes ifcRelDecomposes : ifcProject.getIsDecomposedBy()) {
					for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
						if (ifcObjectDefinition instanceof IfcBuilding) {
							IfcBuilding ifcBuilding = (IfcBuilding) ifcObjectDefinition;
							processBuilding(cityModel, ifcBuilding);
						} else if (ifcObjectDefinition instanceof IfcSite) {
							IfcSite ifcSite = (IfcSite) ifcObjectDefinition;
							for (IfcRelDecomposes siteComposites : ifcSite.getIsDecomposedBy()) {
								for (IfcObjectDefinition siteCompositeObject : siteComposites.getRelatedObjects()) {
									if (siteCompositeObject instanceof IfcBuilding) {
										processBuilding(cityModel, (IfcBuilding) siteCompositeObject);
									}
								}
							}
						}
					}
				}
			}
			for (EObject eObject : model.getValues()) {
				if (eObject instanceof IfcProduct) {
					if (!convertedObjects.containsKey(eObject)) {
//						System.out.println("Not converted: " + eObject);
					}
				}
			}
			try {
				CityGMLOutputFactory outputFactory = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
				PrintWriter writer = new PrintWriter(out);
				CityGMLWriter cityGmlWriter = outputFactory.createCityGMLWriter(writer);

				cityGmlWriter.setPrefixes(CityGMLVersion.v1_0_0);
				cityGmlWriter.setWriteEncoding(true);
				cityGmlWriter.setSchemaLocations(CityGMLVersion.v1_0_0);
				cityGmlWriter.setIndentString("  ");
				cityGmlWriter.write(cityModel);
				cityGmlWriter.close();
				writer.flush();
			} catch (CityGMLReadException e) {
				LOGGER.error("", e);
			} catch (CityGMLWriteException e) {
				LOGGER.error("", e);
			}
			setMode(Mode.FINISHED);
			return true;
		} else if (getMode() == Mode.FINISHED) {
			return false;
		}
		return false;
	}

	private List<Code> createNameList(String string) {
		ArrayList<Code> arrayList = new ArrayList<Code>();
		arrayList.add(createName(string));
		return arrayList;
	}

	private void processBuilding(CityModel cityModel, IfcBuilding ifcBuilding) throws SerializerException {
		Building building = citygml.createBuilding();
		setGlobalId(building, ifcBuilding);
		setName(building.getName(), ifcBuilding.getName());

		CityObjectMember cityObjectMember = citygml.createCityObjectMember();
		cityObjectMember.setCityObject(building);
		cityModel.addCityObjectMember(cityObjectMember);

		IfcPostalAddress ifcBuildingAddress = ifcBuilding.getBuildingAddress();
		if (ifcBuildingAddress != null) {
			building.addAddress(createAddress(ifcBuildingAddress));
		}

		for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcBuilding.getContainsElements()) {
			for (IfcProduct ifcProduct : ifcRelContainedInSpatialStructure.getRelatedElements()) {
				processBoundary(building, createFakeRoom(building), ifcProduct, null);
			}
		}

		for (IfcRelDecomposes ifcRelDecomposes : ifcBuilding.getIsDecomposedBy()) {
			for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
				if (ifcObjectDefinition instanceof IfcBuildingStorey) {
					IfcBuildingStorey ifcBuildingStorey = (IfcBuildingStorey) ifcObjectDefinition;
					processStorey(building, ifcBuildingStorey);
				}
			}
		}
	}

	private void setGlobalId(AbstractCityObject cityObject, IfcRoot ifcRoot) {
		if (ifcRoot != null && ifcRoot.getGlobalId() != null && ifcRoot.getGlobalId() != null) {
			GlobalIdType globalId = new GlobalIdType();
			globalId.setValue(ifcRoot.getGlobalId());
			for (Element element : globalId.get_ADEComponent()) {
				ADEComponent adeComponent = new ADEComponent(element);
				cityObject.addGenericApplicationPropertyOfCityObject(adeComponent);
			}
		}
	}

	private void processStorey(Building building, IfcBuildingStorey ifcBuildingStorey) throws SerializerException {
		for (IfcRelDecomposes ifcRelDecomposes : ifcBuildingStorey.getIsDecomposedBy()) {
			for (IfcObjectDefinition ifcObjectDefinition : ifcRelDecomposes.getRelatedObjects()) {
				if (ifcObjectDefinition instanceof IfcSpace) {
					IfcSpace ifcSpace = (IfcSpace) ifcObjectDefinition;
					processSpace(building, ifcSpace);
				}
			}
		}
		for (IfcRelContainedInSpatialStructure ifcRelContainedInSpatialStructure : ifcBuildingStorey.getContainsElements()) {
			for (IfcProduct ifcProduct : ifcRelContainedInSpatialStructure.getRelatedElements()) {
				if (!convertedObjects.containsKey(ifcProduct)) {
					Room room = createFakeRoom(building);
					processBoundary(building, room, ifcProduct, null);
					if (ifcProduct instanceof IfcSpace) {
						IfcSpace ifcSpace = (IfcSpace) ifcProduct;
						processSpace(building, ifcSpace);
					} else if (ifcProduct instanceof IfcSlab) {
						convertSlab(building, room, (IfcSlab) ifcProduct);
					}
				}
			}
		}
		for (IfcRelContainedInSpatialStructure spatialStructure : ifcBuildingStorey.getContainsElements()) {
			for (IfcProduct ifcProduct : spatialStructure.getRelatedElements()) {
				if (ifcProduct instanceof IfcRoof) {
					RoofSurface roofSurface = citygml.createRoofSurface();
					MultiSurfaceProperty roofMSP = gml.createMultiSurfaceProperty();
					MultiSurface roofMs = gml.createMultiSurface();
					roofMSP.setMultiSurface(roofMs);
					roofSurface.setLod4MultiSurface(roofMSP);
					setGeometry(roofMs, (IfcProduct) ifcProduct);
					BoundarySurfaceProperty boundarySurfaceProperty = citygml.createBoundarySurfaceProperty();
					boundarySurfaceProperty.setObject(roofSurface);
					convertedObjects.put(ifcProduct, roofSurface);
					setName(roofSurface.getName(), ifcProduct.getName());
					setGlobalId(roofSurface, ifcProduct);
					// IfcRoof ifcRoof = (IfcRoof) ifcProduct;
					// RoofTypeEnum roofTypeEnum =
					// RoofTypeEnum.valueOf(ifcRoof.getShapeType().getName());
					// roofSurface.addGenericApplicationPropertyOfCityObject(roofTypeEnum);
					building.addBoundedBySurface(boundarySurfaceProperty);
				} else {
					List<Element> processProduct = processProduct(ifcProduct);
					if (processProduct != null) {
						for (Element element : processProduct) {
							building.addGenericADEComponent(new ADEComponent(element));
						}
					}
				}
			}
		}
	}

	private Room createFakeRoom(Building building) {
		Room room = citygml.createRoom();
		MultiSurfaceProperty multiSurfaceProperty = gml.createMultiSurfaceProperty();
		MultiSurface ms = gml.createMultiSurface();
		multiSurfaceProperty.setMultiSurface(ms);
		room.setLod4MultiSurface(multiSurfaceProperty);
		InteriorRoomProperty createInteriorRoomProperty = citygml.createInteriorRoomProperty();
		createInteriorRoomProperty.setObject(room);
		building.addInteriorRoom(createInteriorRoomProperty);
		return room;
	}

	private List<Element> processProduct(IfcProduct ifcProduct) throws SerializerException {
		// if (ifcProduct instanceof IfcWallStandardCase || ifcProduct
		// instanceof IfcWall || ifcProduct instanceof IfcWindow || ifcProduct
		// instanceof IfcDoor
		// || ifcProduct instanceof IfcSlab) {
		// // Do nothing, because it should already have been converted
		if (ifcProduct instanceof IfcStair) {
			// List<Double> coordinates = null;
			//
			// StairType stairType = xbuilding.createStairType();
			// MultiSurfacePropertyType multiSurfacePropertyType = new
			// MultiSurfacePropertyType();
			// MultiSurfaceType multiSurfaceType = new MultiSurfaceType();
			// SurfacePropertyType surfacePropertyType = new
			// SurfacePropertyType();
			// Set<SurfaceProperty> geometry = getGeometry(ifcProduct);
			// PolygonType polygonType = new PolygonType();
			// LinearRingPropertyType linearRingProperty =
			// gmlObjectFactory.createLinearRingPropertyType();
			//
			// DirectPositionListType posList =
			// gmlObjectFactory.createDirectPositionListType();
			// posList.setValue(coordinates);
			// posList.setSrsDimension(BigInteger.valueOf(3));
			// LinearRingType linearRingType = new LinearRingType();
			// linearRingType.setPosList(posList);
			// linearRingProperty.setLinearRing(linearRingType);
			//
			// //
			// polygonType.setExterior(gmlObjectFactory.createExterior(linearRingProperty));
			// // Compile error, LinearRingPropertyType is not a subtype of
			// AbstractRingPropertyType
			// surfacePropertyType.set_Surface(gmlObjectFactory.createPolygon(polygonType));
			// multiSurfaceType.getSurfaceMember().add(surfacePropertyType);
			// multiSurfacePropertyType.setMultiSurface(multiSurfaceType);
			// stairType.setLod4MultiSurface(multiSurfacePropertyType);
			// return stairType.get_ADEComponent();
		}
		// } else if (ifcProduct instanceof IfcRailing) {
		// RailingType railing = new RailingType();
		// IfcRailing ifcRailing = (IfcRailing) ifcProduct;
		// MultiSurfaceProperty railingMSP = gml.createMultiSurfaceProperty();
		// MultiSurface stairMs = gml.createMultiSurface();
		// setGeometry(stairMs, ifcProduct);
		// railingMSP.setMultiSurface(stairMs);
		// railing.setLod4MultiSurface(railingMSP);
		// setName(railing.getName(), ifcProduct.getName());
		// setGlobalId(railing, ifcProduct);
		// railing.setGlobalId(ifcProduct.getGlobalId());
		// railing.setPredefinedType(RailingTypeEnum.valueOf(ifcRailing.getPredefinedType().getName().replace("_",
		// "___")));
		// return railing;
		// } else if (ifcProduct instanceof IfcAnnotation) {
		// AnnotationType annotation = new AnnotationType();
		// MultiSurfaceProperty annotationMSP =
		// gml.createMultiSurfaceProperty();
		// MultiSurface stairMs = gml.createMultiSurface();
		// setGeometry(stairMs, ifcProduct);
		// annotationMSP.setMultiSurface(stairMs);
		// annotation.setLod4MultiSurface(annotationMSP);
		// setName(annotation.getName(), ifcProduct.getName());
		// setGlobalId(annotation, ifcProduct);
		// annotation.setGlobalId(ifcProduct.getGlobalId());
		// return annotation;
		// } else if (ifcProduct instanceof IfcColumn) {
		// Column column = new Column();
		// MultiSurfaceProperty columnMSP = gml.createMultiSurfaceProperty();
		// MultiSurface stairMs = gml.createMultiSurface();
		// setGeometry(stairMs, ifcProduct);
		// columnMSP.setMultiSurface(stairMs);
		// column.setLod4MultiSurface(columnMSP);
		// setName(column.getName(), ifcProduct.getName());
		// setGlobalId(column, ifcProduct);
		// column.setGlobalId(ifcProduct.getGlobalId());
		// return column;
		// } else if (ifcProduct instanceof IfcBuildingElementProxy) {
		// // Do nothing, this is a bad IFC thing
		// } else if (ifcProduct instanceof IfcBeam) {
		// BeamType beamType = new BeamType();
		// MultiSurfaceProperty beamMSP = gml.createMultiSurfaceProperty();
		// MultiSurface stairMs = gml.createMultiSurface();
		// setGeometry(stairMs, ifcProduct);
		// beamMSP.setMultiSurface(stairMs);
		// beamType.setLod4MultiSurface(beamMSP);
		// setName(beam.getName(), ifcProduct.getName());
		// setGlobalId(beam, ifcProduct);
		// beam.setGlobalId(ifcProduct.getGlobalId());
		// return beam;
		else if (ifcProduct instanceof IfcOpeningElement) {
			// OpeningElementType openingElement = new OpeningElementType();
			// MultiSurfaceProperty openingElementMSP =
			// gml.createMultiSurfaceProperty();
			// MultiSurface stairMs = gml.createMultiSurface();
			// setGeometry(stairMs, ifcProduct);
			// openingElementMSP.setMultiSurface(stairMs);
			// openingElement.setLod4MultiSurface((MultiSurfacePropertyType)
			// openingElementMSP);
			// openingElement.setLod4MultiSurface(openingElementMSP);
			// setName(openingElement.getName(), ifcProduct.getName());
			// setGlobalId(openingElement, ifcProduct);
			// ifcProduct.setGlobalId(ifcProduct.getGlobalId());
			// return openingElement.get_ADEComponent();
		}
		return null;
	}

	private void processSpace(Building building, IfcSpace ifcSpace) throws SerializerException {
		Room room = citygml.createRoom();
		setName(room.getName(), ifcSpace.getName());
		setGlobalId(room, ifcSpace);
		convertedObjects.put(ifcSpace, room);
		MultiSurfaceProperty multiSurfaceProperty = gml.createMultiSurfaceProperty();
		MultiSurface ms = gml.createMultiSurface();
		multiSurfaceProperty.setMultiSurface(ms);
		room.setLod4MultiSurface(multiSurfaceProperty);
		InteriorRoomProperty createInteriorRoomProperty = citygml.createInteriorRoomProperty();
		createInteriorRoomProperty.setObject(room);
		building.addInteriorRoom(createInteriorRoomProperty);
		setGeometry(ms, ifcSpace);
		for (IfcRelSpaceBoundary boundary : ifcSpace.getBoundedBy()) {
			if (!convertedObjects.containsKey(boundary.getRelatedBuildingElement())) {
				processBoundary(building, room, boundary.getRelatedBuildingElement(), boundary.getInternalOrExternalBoundary());
			}
		}
		for (IfcRelContainedInSpatialStructure contains : ifcSpace.getContainsElements()) {
			for (IfcProduct ifcProduct : contains.getRelatedElements()) {
				if (!convertedObjects.containsKey(ifcProduct)) {
					processBoundary(building, room, ifcProduct, null);
				}
			}
		}
	}

	private void processBoundary(Building building, Room room, IfcProduct ifcElement, IfcInternalOrExternalEnum boundayType) throws SerializerException {
		if (ifcElement instanceof IfcWall) {
			IfcWall ifcWall = (IfcWall) ifcElement;
			if (!convertedObjects.containsKey(ifcWall)) {
				AbstractBoundarySurface boundarySurface = null;
				if (boundayType == null || boundayType == IfcInternalOrExternalEnum.INTERNAL) {
					boundarySurface = citygml.createInteriorWallSurface();
				} else {
					boundarySurface = citygml.createWallSurface();
				}
				setName(boundarySurface.getName(), ifcWall.getName());
				setGlobalId(boundarySurface, ifcWall);
				convertedObjects.put(ifcWall, boundarySurface);
				BoundarySurfaceProperty boundarySurfaceProperty = citygml.createBoundarySurfaceProperty();
				boundarySurfaceProperty.setObject(boundarySurface);
				MultiSurface wallMs = gml.createMultiSurface();
				MultiSurfaceProperty wallMSP = gml.createMultiSurfaceProperty();
				wallMSP.setMultiSurface(wallMs);
				boundarySurface.setLod4MultiSurface(wallMSP);
				setGeometry(wallMs, ifcWall);
				building.addBoundedBySurface(boundarySurfaceProperty);
				for (IfcRelVoidsElement ifcRelVoidsElement : ifcWall.getHasOpenings()) {
					IfcOpeningElement ifcOpeningElement = (IfcOpeningElement) ifcRelVoidsElement.getRelatedOpeningElement();
					for (IfcRelFillsElement filling : ifcOpeningElement.getHasFillings()) {
						IfcElement ifcRelatedBuildingElement = filling.getRelatedBuildingElement();
						if (ifcRelatedBuildingElement instanceof IfcWindow) {
							if (!convertedObjects.containsKey(ifcRelatedBuildingElement)) {
								Window window = createWindow((IfcWindow) ifcRelatedBuildingElement);
								OpeningProperty openingProperty = citygml.createOpeningProperty();
								openingProperty.setObject(window);
								boundarySurface.addOpening(openingProperty);
								convertedObjects.put(ifcRelatedBuildingElement, window);
							}
						} else if (ifcRelatedBuildingElement instanceof IfcDoor) {
							if (!convertedObjects.containsKey(ifcRelatedBuildingElement)) {
								Door door = createDoor(ifcRelatedBuildingElement);
								OpeningProperty openingProperty = citygml.createOpeningProperty();
								openingProperty.setObject(door);
								boundarySurface.addOpening(openingProperty);
								convertedObjects.put(ifcRelatedBuildingElement, door);
							}
						}
					}
				}
			}
		} else if (ifcElement instanceof IfcSlab) {
			convertSlab(building, room, (IfcSlab) ifcElement);
		} else if (ifcElement instanceof IfcRoof) {
			if (!convertedObjects.containsKey(ifcElement)) {
				RoofSurface roofSurface = createRoof(building, ifcElement);
				convertedObjects.put(ifcElement, roofSurface);
			}
		} else if (ifcElement instanceof IfcOpeningElement) {
			List<Element> processProduct = processProduct(ifcElement);
			if (processProduct != null) {
				for (Element element : processProduct) {
					room.addGenericADEComponent(new ADEComponent(element));
				}
			}
		} else if (ifcElement instanceof IfcColumn) {
			// List<Element> processProduct = processProduct(ifcElement);
			// if (processProduct != null) {
			// room.addGenericApplicationPropertyOfRoom(processProduct);
			// }
		} else if (ifcElement == null || ifcElement instanceof IfcWindow || ifcElement instanceof IfcDoor || ifcElement instanceof IfcVirtualElement) {
			// ignore
		} else if (ifcElement instanceof IfcFurnishingElement) {
			// BuildingFurniture buildingFurniture =
			// citygml.createBuildingFurniture();
			// GeometryProperty createGeometryProperty =
			// gml.createGeometryProperty();
			// MultiSurface createMultiSurface = gml.createMultiSurface();
			// setGeometry(createMultiSurface, ifcElement);
			// createGeometryProperty.setGeometry(createMultiSurface);
			// buildingFurniture.setLod4Geometry(createGeometryProperty);
			// InteriorFurnitureProperty ifp =
			// citygml.createInteriorFurnitureProperty();
			// ifp.setObject(buildingFurniture);
			// setName(buildingFurniture.getName(), ifcElement.getName());
			// setGlobalId(buildingFurniture, ifcElement);
			// room.addInteriorFurniture(ifp);
			// convertedObjects.put(ifcElement, buildingFurniture);
		} else if (ifcElement instanceof IfcFlowTerminal) {
			// FlowTerminal flowTerminal = new FlowTerminal();
			// setName(flowTerminal.getName(), ifcElement.getName());
			// MultiSurfaceProperty createGeometryProperty =
			// gml.createMultiSurfaceProperty();
			// MultiSurface createMultiSurface = gml.createMultiSurface();
			// setGeometry(createMultiSurface, ifcElement);
			// createGeometryProperty.setMultiSurface(createMultiSurface);
			// flowTerminal.setLod4MultiSurface(createGeometryProperty);
			// room.getGenericApplicationPropertyOfRoom().add(flowTerminal);
			// setName(flowTerminal.getName(), ifcElement.getName());
			// setGlobalId(flowTerminal, ifcElement);
			// flowTerminal.setGlobalId(ifcElement.getGlobalId());
			// convertedObjects.put(ifcElement, flowTerminal);
		}
	}

	private void convertSlab(Building building, Room room, IfcSlab ifcSlab) throws SerializerException {
		if (!convertedObjects.containsKey(ifcSlab)) {
			if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.ROOF) {
				RoofSurface roofSurface = createRoof(building, ifcSlab);
				convertedObjects.put(ifcSlab, roofSurface);
			} else if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.FLOOR || ifcSlab.getPredefinedType() == IfcSlabTypeEnum.BASESLAB
					|| ifcSlab.getPredefinedType() == IfcSlabTypeEnum.LANDING || ifcSlab.getPredefinedType() == IfcSlabTypeEnum.NULL) {
				FloorSurface floorSurface = createFloor(room, ifcSlab, ifcSlab);
				convertedObjects.put(ifcSlab, floorSurface);
			}
		}
	}

	private Door createDoor(IfcElement ifcRelatedBuildingElement) throws SerializerException {
		IfcDoor ifcDoor = (IfcDoor) ifcRelatedBuildingElement;
		Door door = citygml.createDoor();
		setName(door.getName(), ifcRelatedBuildingElement.getName());
		setGlobalId(door, ifcRelatedBuildingElement);
		MultiSurfaceProperty doorMSP = gml.createMultiSurfaceProperty();
		MultiSurface doorMs = gml.createMultiSurface();
		doorMSP.setMultiSurface(doorMs);
		door.setLod4MultiSurface(doorMSP);
		setGeometry(doorMs, ifcRelatedBuildingElement);
		DoubleAttribute genericAttributeWidth = new DoubleAttributeImpl();
		genericAttributeWidth.setName("OverallWidth");
		genericAttributeWidth.setValue((double) ifcDoor.getOverallWidth());
		door.addGenericAttribute(genericAttributeWidth);
		DoubleAttribute genericAttributeHeight = new DoubleAttributeImpl();
		genericAttributeHeight.setValue((double) ifcDoor.getOverallHeight());
		genericAttributeHeight.setName("OverallHeight");
		door.addGenericAttribute(genericAttributeHeight);
		return door;
	}

	private FloorSurface createFloor(Room room, IfcProduct ifcRelating, IfcSlab ifcSlab) throws SerializerException {
		FloorSurface floorSurface = citygml.createFloorSurface();
		MultiSurfaceProperty floorMSP = gml.createMultiSurfaceProperty();
		MultiSurface floorMs = gml.createMultiSurface();
		floorMSP.setMultiSurface(floorMs);
		floorSurface.setLod4MultiSurface(floorMSP);
		setGeometry(floorMs, ifcRelating);
		BoundarySurfaceProperty boundarySurfaceProperty = citygml.createBoundarySurfaceProperty();
		boundarySurfaceProperty.setObject(floorSurface);
		room.addBoundedBySurface(boundarySurfaceProperty);
		setName(floorSurface.getName(), ifcSlab.getName());
		setGlobalId(floorSurface, ifcSlab);
		return floorSurface;
	}

	private RoofSurface createRoof(Building building, IfcProduct ifcRelating) throws SerializerException {
		RoofSurface roofSurface = citygml.createRoofSurface();
		MultiSurfaceProperty roofMSP = gml.createMultiSurfaceProperty();
		MultiSurface roofMs = gml.createMultiSurface();
		roofMSP.setMultiSurface(roofMs);
		roofSurface.setLod4MultiSurface(roofMSP);
		setGeometry(roofMs, ifcRelating);
		BoundarySurfaceProperty boundarySurfaceProperty = citygml.createBoundarySurfaceProperty();
		boundarySurfaceProperty.setObject(roofSurface);
		building.addBoundedBySurface(boundarySurfaceProperty);
		setName(roofSurface.getName(), ifcRelating.getName());
		setGlobalId(roofSurface, ifcRelating);
		return roofSurface;
	}

	private Window createWindow(IfcWindow ifcWindow) throws SerializerException {
		Window window = citygml.createWindow();
		setName(window.getName(), ifcWindow.getName());
		setGlobalId(window, ifcWindow);
		MultiSurfaceProperty windowMSP = gml.createMultiSurfaceProperty();
		MultiSurface windowMs = gml.createMultiSurface();
		windowMSP.setMultiSurface(windowMs);
		window.setLod4MultiSurface(windowMSP);
		setGeometry(windowMs, ifcWindow);
		DoubleAttribute genericAttributeWidth = new DoubleAttributeImpl();
		genericAttributeWidth.setValue((double) ifcWindow.getOverallWidth());
		genericAttributeWidth.setName("OverallWidth");
		window.addGenericAttribute(genericAttributeWidth);
		DoubleAttribute genericAttributeHeight = new DoubleAttributeImpl();
		genericAttributeHeight.setValue((double) ifcWindow.getOverallHeight());
		genericAttributeHeight.setName("OverallHeight");
		window.addGenericAttribute(genericAttributeHeight);
		return window;
	}

	private void setName(List<Code> name, String value) {
		if (value != null && !value.trim().equals("")) {
			name.add(createName(value));
		}
	}

	private AddressProperty createAddress(IfcPostalAddress ifcBuildingAddress) {
		Address address = citygml.createAddress();
		XalAddressProperty xalAddressProperty = citygml.createXalAddressProperty();
		AddressDetails addressDetails = xal.createAddressDetails();
		xalAddressProperty.setAddressDetails(addressDetails);
		address.setXalAddress(xalAddressProperty);
		AddressProperty addressProperty = citygml.createAddressProperty();
		addressProperty.setObject(address);
		return addressProperty;
	}

	private void setGeometry(MultiSurface ms, IfcProduct ifcProduct) {
		GeometryInfo geometryInfo = ifcProduct.getGeometry();
		if (geometryInfo != null) {
			GeometryData geometryData = geometryInfo.getData();
			ByteBuffer verticesBuffer = ByteBuffer.wrap(geometryData.getVertices());

			while (verticesBuffer.hasRemaining()) {
				float x1 = verticesBuffer.getFloat();
				float y1 = verticesBuffer.getFloat();
				float z1 = verticesBuffer.getFloat();
				float x2 = verticesBuffer.getFloat();
				float y2 = verticesBuffer.getFloat();
				float z2 = verticesBuffer.getFloat();
				float x3 = verticesBuffer.getFloat();
				float y3 = verticesBuffer.getFloat();
				float z3 = verticesBuffer.getFloat();
				ms.addSurfaceMember(createSurfaceProperty(
						gml,
						Arrays.asList(new Double[] {
								(double) x1, (double) y1, (double) z1,
								(double) x3, (double) y3, (double) z3,
								(double) x2, (double) y2, (double) z2,
								(double) x1, (double) y1, (double) z1})));
			}
		}
	}

	private SurfaceProperty createSurfaceProperty(GMLFactory gml, List<Double> points) {
		Polygon polygon = gml.createPolygon();

		Exterior exterior = gml.createExterior();
		polygon.setExterior(exterior);

		LinearRing linearRing = gml.createLinearRing();
		exterior.setRing(linearRing);

		DirectPositionList posList = gml.createDirectPositionList();
		posList.setValue(points);
		posList.setSrsDimension(3);
		linearRing.setPosList(posList);

		SurfaceProperty surfaceProperty = gml.createSurfaceProperty();
		surfaceProperty.setGeometry(polygon);

		return surfaceProperty;
	}
}