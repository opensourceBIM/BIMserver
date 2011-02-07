package org.bimserver.citygml;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.citygml.objects.Annotation;
import org.bimserver.citygml.objects.Beam;
import org.bimserver.citygml.objects.Column;
import org.bimserver.citygml.objects.FlowTerminal;
import org.bimserver.citygml.objects.GlobalId;
import org.bimserver.citygml.objects.Railing;
import org.bimserver.citygml.objects.Stair;
import org.bimserver.database.store.Project;
import org.bimserver.database.store.User;
import org.bimserver.ifc.BimModelSerializer;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SerializerException;
import org.bimserver.ifc.database.IfcDatabase;
import org.bimserver.ifc.emf.Ifc2x3.IfcAnnotation;
import org.bimserver.ifc.emf.Ifc2x3.IfcBeam;
import org.bimserver.ifc.emf.Ifc2x3.IfcBuilding;
import org.bimserver.ifc.emf.Ifc2x3.IfcBuildingElementProxy;
import org.bimserver.ifc.emf.Ifc2x3.IfcBuildingStorey;
import org.bimserver.ifc.emf.Ifc2x3.IfcColumn;
import org.bimserver.ifc.emf.Ifc2x3.IfcDoor;
import org.bimserver.ifc.emf.Ifc2x3.IfcElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcFlowTerminal;
import org.bimserver.ifc.emf.Ifc2x3.IfcFurnishingElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcInternalOrExternalEnum;
import org.bimserver.ifc.emf.Ifc2x3.IfcObjectDefinition;
import org.bimserver.ifc.emf.Ifc2x3.IfcOpeningElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcPostalAddress;
import org.bimserver.ifc.emf.Ifc2x3.IfcProduct;
import org.bimserver.ifc.emf.Ifc2x3.IfcProject;
import org.bimserver.ifc.emf.Ifc2x3.IfcRailing;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelContainedInSpatialStructure;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelDecomposes;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelFillsElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelSpaceBoundary;
import org.bimserver.ifc.emf.Ifc2x3.IfcRelVoidsElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoof;
import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.bimserver.ifc.emf.Ifc2x3.IfcSite;
import org.bimserver.ifc.emf.Ifc2x3.IfcSlab;
import org.bimserver.ifc.emf.Ifc2x3.IfcSlabTypeEnum;
import org.bimserver.ifc.emf.Ifc2x3.IfcSpace;
import org.bimserver.ifc.emf.Ifc2x3.IfcStair;
import org.bimserver.ifc.emf.Ifc2x3.IfcStairTypeEnum;
import org.bimserver.ifc.emf.Ifc2x3.IfcVirtualElement;
import org.bimserver.ifc.emf.Ifc2x3.IfcWall;
import org.bimserver.ifc.emf.Ifc2x3.IfcWallStandardCase;
import org.bimserver.ifc.emf.Ifc2x3.IfcWindow;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.ifcengine.FailSafeIfcEngine;
import org.bimserver.ifcengine.Geometry;
import org.bimserver.ifcengine.IfcEngineException;
import org.bimserver.ifcengine.IfcEngineFactory;
import org.bimserver.ifcengine.IfcEngineModel;
import org.bimserver.ifcengine.Instance;
import org.bimserver.ifcengine.SurfaceProperties;
import org.bimserver.ifcengine.jvm.IfcEngine.InstanceVisualisationProperties;
import org.bimserver.shared.ResultType;
import org.citygml4j.CityGMLContext;
import org.citygml4j.factory.CityGMLFactory;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.factory.XALFactory;
import org.citygml4j.impl.jaxb.citygml.generics._1.GenericDoubleAttributeImpl;
import org.citygml4j.model.citygml.CityGMLModuleVersion;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BoundarySurface;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.XalAddressProperty;
import org.citygml4j.model.gml.Code;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.Exterior;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.Polygon;
import org.citygml4j.model.gml.SurfaceProperty;
import org.citygml4j.model.xal.AddressDetails;
import org.citygml4j.util.JAXBNamespacePrefixMapper;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ade.RailingTypeEnum;
import ade.StairTypeEnum;

public class CityGmlSerializer extends BimModelSerializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityGmlSerializer.class);
	private final FailSafeIfcEngine ifcEngine;
	private final GMLFactory gml;
	private final XALFactory xal;
	private final CityGMLFactory citygml;
	private final Map<EObject, CityObject> convertedObjects;
	private final CityGMLContext ctx;
	private final XBuildingAdeContext xBuildingAdeContext;
	private final IfcModel model;
	private final SchemaDefinition schemaDefinition;
	private SimpleMode mode = SimpleMode.BUSY;
	private final Project project;
	private final User user;
	
	public CityGmlSerializer(Project project, User user, String fileName, IfcModel IfcModel, SchemaDefinition schemaDefinition, FieldIgnoreMap fieldIgnoreMap, IfcEngineFactory ifcEngineFactory) throws SerializerException {
		super(fileName, IfcModel, fieldIgnoreMap);
		this.project = project;
		this.user = user;
		try {
			this.ifcEngine = ifcEngineFactory.createFailSafeIfcEngine();
		} catch (IfcEngineException e) {
			throw new SerializerException(e);
		}
		this.model = IfcModel;
		this.schemaDefinition = schemaDefinition;
		ctx = new CityGMLContext();
		citygml = ctx.createCityGMLFactory(CityGMLModuleVersion.v1_0_0);
		gml = ctx.createGMLFactory();
		xal = ctx.createXALFactory();
		xBuildingAdeContext = new XBuildingAdeContext();
		ctx.registerADEContext(xBuildingAdeContext);
		convertedObjects = new HashMap<EObject, CityObject>();
	}

	private Code createName(String value) {
		Code code = gml.createCode();
		code.setValue(value);
		return code;
	}

	public int write(OutputStream out) throws SerializerException {
		if (mode == SimpleMode.BUSY) {
			PrintWriter writer = new PrintWriter(out);
			IfcDatabase ifcDatabase = new IfcDatabase(model, null);
			CityModel cityModel = citygml.createCityModel();
			for (IfcProject ifcProject : ifcDatabase.getAll(IfcProject.class)) {
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
			try {
				JAXBContext jaxbCtx = ctx.createJAXBContext();
				Marshaller marshaller = jaxbCtx.createMarshaller();
				
				JAXBNamespacePrefixMapper nsMapper = new JAXBNamespacePrefixMapper();
				nsMapper.setNamespacePrefixMapping(CoreModule.v1_0_0.getNamespaceUri(), "core");
				nsMapper.setNamespacePrefixMapping(XBuildingAdeContext.NAMESPACE_URI, "xbuilding");
				
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", nsMapper);
				marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, CoreModule.v1_0_0.getNamespaceUri() + " " + CoreModule.v1_0_0.getSchemaLocation());
				
				JAXBElement<?> cityModelElement = citygml.cityGML2jaxb(cityModel);
				
				marshaller.marshal(cityModelElement, writer);
			} catch (JAXBException e) {
				throw new SerializerException(e);
			}
			writer.flush();
			mode = SimpleMode.DONE;
			ifcEngine.close();
			return 1;
		} else if (mode == SimpleMode.DONE) {
			return -1;
		}
		return -1;
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

	private void setGlobalId(CityObject cityObject, IfcRoot ifcRoot) {
		if (ifcRoot != null && ifcRoot.getGlobalId() != null && ifcRoot.getGlobalId().getWrappedValue() != null) {
			GlobalId globalId = new GlobalId();
			globalId.setValue(ifcRoot.getGlobalId().getWrappedValue());
			cityObject.addGenericApplicationPropertyOfCityObject(globalId);
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
					// if (ifcProduct instanceof IfcSpace) {
					// IfcSpace ifcSpace = (IfcSpace) ifcProduct;
					// processSpace(building, ifcSpace);
					// } else {
					// System.out.println("4b: " + ifcProduct);
					// }
				}
			}
		}
		// for (IfcRelContainedInSpatialStructure spatialStructure :
		// ifcBuildingStorey.getContainsElements()) {
		// for (IfcProduct ifcProduct : spatialStructure.getRelatedElements()) {
		// if (ifcProduct instanceof IfcRoof) {
		// RoofSurface roofSurface = citygml.createRoofSurface();
		// MultiSurfaceProperty roofMSP = gml.createMultiSurfaceProperty();
		// MultiSurface roofMs = gml.createMultiSurface();
		// roofMSP.setMultiSurface(roofMs);
		// roofSurface.setLod4MultiSurface(roofMSP);
		// setGeometry(roofMs, (IfcRootObject) ifcProduct);
		// BoundarySurfaceProperty boundarySurfaceProperty =
		// citygml.createBoundarySurfaceProperty();
		// boundarySurfaceProperty.setObject(roofSurface);
		// convertedObjects.put(ifcProduct, roofSurface);
		// setName(roofSurface.getName(), ifcProduct.getName());
		// setGlobalId(roofSurface, ifcProduct);
		// // IfcRoof ifcRoof = (IfcRoof)ifcProduct;
		// // RoofTypeEnum roofTypeEnum =
		// RoofTypeEnum.valueOf(ifcRoof.getShapeType().getName());
		// //
		// roofSurface.addGenericApplicationPropertyOfCityObject(roofTypeEnum);
		// building.addBoundedBySurface(boundarySurfaceProperty);
		// } else {
		// ADEComponent cityObject = processProduct(ifcProduct);
		// if (cityObject != null) {
		// building.addGenericApplicationPropertyOfBuilding(cityObject);
		// }
		// }
		// }
		// }
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

	private ADEComponent processProduct(IfcProduct ifcProduct) throws SerializerException {
		if (ifcProduct instanceof IfcWallStandardCase || ifcProduct instanceof IfcWall || ifcProduct instanceof IfcWindow || ifcProduct instanceof IfcDoor
				|| ifcProduct instanceof IfcSlab) {
			// Do nothing, because it should already have been converted
		} else if (ifcProduct instanceof IfcStair) {
			Stair stair = new Stair();
			MultiSurfaceProperty stairMSP = gml.createMultiSurfaceProperty();
			MultiSurface stairMs = gml.createMultiSurface();
			setGeometry(stairMs, ifcProduct);
			stairMSP.setMultiSurface(stairMs);
			stair.setLod3MultiSurface(stairMSP);
			setName(stair.getName(), ifcProduct.getName());
			setGlobalId(stair, ifcProduct);
			stair.setGlobalId(ifcProduct.getGlobalId());
			IfcStairTypeEnum ifcShapeType = ((IfcStair) ifcProduct).getShapeType();
			stair.setType(StairTypeEnum.valueOf(ifcShapeType.getName().replace("_", "___")));
			return stair;
		} else if (ifcProduct instanceof IfcRailing) {
			Railing railing = new Railing();
			IfcRailing ifcRailing = (IfcRailing) ifcProduct;
			MultiSurfaceProperty railingMSP = gml.createMultiSurfaceProperty();
			MultiSurface stairMs = gml.createMultiSurface();
			setGeometry(stairMs, ifcProduct);
			railingMSP.setMultiSurface(stairMs);
			railing.setLod3MultiSurface(railingMSP);
			setName(railing.getName(), ifcProduct.getName());
			setGlobalId(railing, ifcProduct);
			railing.setGlobalId(ifcProduct.getGlobalId());
			railing.setPredefinedType(RailingTypeEnum.valueOf(ifcRailing.getPredefinedType().getName().replace("_", "___")));
			return railing;
		} else if (ifcProduct instanceof IfcAnnotation) {
			Annotation annotation = new Annotation();
			MultiSurfaceProperty annotationMSP = gml.createMultiSurfaceProperty();
			MultiSurface stairMs = gml.createMultiSurface();
			setGeometry(stairMs, ifcProduct);
			annotationMSP.setMultiSurface(stairMs);
			annotation.setLod3MultiSurface(annotationMSP);
			setName(annotation.getName(), ifcProduct.getName());
			setGlobalId(annotation, ifcProduct);
			annotation.setGlobalId(ifcProduct.getGlobalId());
			return annotation;
		} else if (ifcProduct instanceof IfcColumn) {
			Column column = new Column();
			MultiSurfaceProperty columnMSP = gml.createMultiSurfaceProperty();
			MultiSurface stairMs = gml.createMultiSurface();
			setGeometry(stairMs, ifcProduct);
			columnMSP.setMultiSurface(stairMs);
			column.setLod3MultiSurface(columnMSP);
			setName(column.getName(), ifcProduct.getName());
			setGlobalId(column, ifcProduct);
			column.setGlobalId(ifcProduct.getGlobalId());
			return column;
		} else if (ifcProduct instanceof IfcBuildingElementProxy) {
			// Do nothing, this is a bad IFC thing
		} else if (ifcProduct instanceof IfcBeam) {
			Beam beam = new Beam();
			MultiSurfaceProperty beamMSP = gml.createMultiSurfaceProperty();
			MultiSurface stairMs = gml.createMultiSurface();
			setGeometry(stairMs, ifcProduct);
			beamMSP.setMultiSurface(stairMs);
			beam.setLod3MultiSurface(beamMSP);
			setName(beam.getName(), ifcProduct.getName());
			setGlobalId(beam, ifcProduct);
			beam.setGlobalId(ifcProduct.getGlobalId());
			return beam;
			// } else if (ifcProduct instanceof IfcOpeningElement) {
			// OpeningElement openingElement = new OpeningElement();
			// MultiSurfaceProperty openingElementMSP =
			// gml.createMultiSurfaceProperty();
			// MultiSurface stairMs = gml.createMultiSurface();
			// setGeometry(stairMs, (IfcRootObject) ifcProduct);
			// openingElementMSP.setMultiSurface(stairMs);
			// openingElement.setLod3MultiSurface(openingElementMSP);
			// setName(openingElement.getName(), ifcProduct.getName());
			// setGlobalId(openingElement, ifcProduct);
			// ifcProduct.setGlobalId(ifcProduct.getGlobalId());
			// return openingElement;
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
				BoundarySurface boundarySurface = null;
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
			if (!convertedObjects.containsKey(ifcElement)) {
				IfcSlab ifcSlab = (IfcSlab) ifcElement;
				if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.ROOF) {
					RoofSurface roofSurface = createRoof(building, ifcSlab);
					convertedObjects.put(ifcElement, roofSurface);
				} else if (ifcSlab.getPredefinedType() == IfcSlabTypeEnum.FLOOR || ifcSlab.getPredefinedType() == IfcSlabTypeEnum.BASESLAB
						|| ifcSlab.getPredefinedType() == IfcSlabTypeEnum.LANDING || ifcSlab.getPredefinedType() == IfcSlabTypeEnum.NULL) {
					FloorSurface floorSurface = createFloor(room, ifcElement, ifcSlab);
					convertedObjects.put(ifcElement, floorSurface);
				}
			}
		} else if (ifcElement instanceof IfcRoof) {
			if (!convertedObjects.containsKey(ifcElement)) {
				RoofSurface roofSurface = createRoof(building, ifcElement);
				convertedObjects.put(ifcElement, roofSurface);
			}
		} else if (ifcElement instanceof IfcOpeningElement) {
			// room.addGenericApplicationPropertyOfRoom(processProduct(ifcRelating));
		} else if (ifcElement instanceof IfcColumn) {
			room.addGenericApplicationPropertyOfRoom(processProduct(ifcElement));
		} else if (ifcElement == null || ifcElement instanceof IfcWindow || ifcElement instanceof IfcDoor || ifcElement instanceof IfcVirtualElement) {
			// ignore
		} else if (ifcElement instanceof IfcFurnishingElement) {
			BuildingFurniture buildingFurniture = citygml.createBuildingFurniture();
			GeometryProperty createGeometryProperty = gml.createGeometryProperty();
			MultiSurface createMultiSurface = gml.createMultiSurface();
			setGeometry(createMultiSurface, ifcElement);
			createGeometryProperty.setGeometry(createMultiSurface);
			buildingFurniture.setLod4Geometry(createGeometryProperty);
			InteriorFurnitureProperty ifp = citygml.createInteriorFurnitureProperty();
			ifp.setObject(buildingFurniture);
			setName(buildingFurniture.getName(), ifcElement.getName());
			setGlobalId(buildingFurniture, ifcElement);
			room.addInteriorFurniture(ifp);
			convertedObjects.put(ifcElement, buildingFurniture);
		} else if (ifcElement instanceof IfcFlowTerminal) {
			FlowTerminal flowTerminal = new FlowTerminal();
			setName(flowTerminal.getName(), ifcElement.getName());
			MultiSurfaceProperty createGeometryProperty = gml.createMultiSurfaceProperty();
			MultiSurface createMultiSurface = gml.createMultiSurface();
			setGeometry(createMultiSurface, ifcElement);
			createGeometryProperty.setMultiSurface(createMultiSurface);
			flowTerminal.setLod3MultiSurface(createGeometryProperty);
			room.getGenericApplicationPropertyOfRoom().add(flowTerminal);
			setName(flowTerminal.getName(), ifcElement.getName());
			setGlobalId(flowTerminal, ifcElement);
			flowTerminal.setGlobalId(ifcElement.getGlobalId());
			convertedObjects.put(ifcElement, flowTerminal);
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
		GenericDoubleAttributeImpl genericAttributeWidth = new GenericDoubleAttributeImpl();
		genericAttributeWidth.setName("OverallWidth");
		genericAttributeWidth.setValue((double) ifcDoor.getOverallWidth());
		door.addGenericAttribute(genericAttributeWidth);
		GenericDoubleAttributeImpl genericAttributeHeight = new GenericDoubleAttributeImpl();
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
		GenericDoubleAttributeImpl genericAttributeWidth = new GenericDoubleAttributeImpl();
		genericAttributeWidth.setValue((double) ifcWindow.getOverallWidth());
		genericAttributeWidth.setName("OverallWidth");
		window.addGenericAttribute(genericAttributeWidth);
		GenericDoubleAttributeImpl genericAttributeHeight = new GenericDoubleAttributeImpl();
		genericAttributeHeight.setValue((double) ifcWindow.getOverallHeight());
		genericAttributeHeight.setName("OverallHeight");
		window.addGenericAttribute(genericAttributeHeight);
		return window;
	}

	private void setName(List<Code> name, String value) {
		if (value != null) {
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

	private void setGeometry(MultiSurface ms, IfcRoot ifcRootObject) throws SerializerException {
		IfcModel ifcModel = new IfcModel();
		convertToSubset(ifcRootObject.eClass(), ifcRootObject, ifcModel, new HashMap<EObject, EObject>());
		IfcStepSerializer ifcSerializer = new IfcStepSerializer(project, user, "", ifcModel, schemaDefinition);
		try {
			IfcEngineModel model = ifcEngine.openModel(ifcSerializer.getBytes());
			try {
				model.setPostProcessing(true);
				SurfaceProperties initializeModelling = model.initializeModelling();
				Geometry geometry = model.finalizeModelling(initializeModelling);
				if (geometry != null) {
					for (Instance instance : model.getInstances(ifcRootObject.eClass().getName().toUpperCase())) {
						InstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
						for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i += 3) {
							int i1 = geometry.getIndex(i);
							int i2 = geometry.getIndex(i + 1);
							int i3 = geometry.getIndex(i + 2);
							ms.addSurfaceMember(createSurfaceProperty(gml, Arrays.asList(new Double[] { (double) geometry.getVertex(i1 * 3), (double) geometry.getVertex(i1 * 3 + 1),
									(double) geometry.getVertex(i1 * 3 + 2), (double) geometry.getVertex(i3 * 3), (double) geometry.getVertex(i3 * 3 + 1),
									(double) geometry.getVertex(i3 * 3 + 2), (double) geometry.getVertex(i2 * 3), (double) geometry.getVertex(i2 * 3 + 1),
									(double) geometry.getVertex(i2 * 3 + 2), (double) geometry.getVertex(i1 * 3), (double) geometry.getVertex(i1 * 3 + 1),
									(double) geometry.getVertex(i1 * 3 + 2) })));
						}
					}
				}
			} finally {
				model.close();
			}
		} catch (IfcEngineException e) {
			throw new SerializerException("IfcEngineException", e);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

	private static SurfaceProperty createSurfaceProperty(GMLFactory gml, List<Double> points) {
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
		surfaceProperty.setSurface(polygon);

		return surfaceProperty;
	}

	@Override
	public String getContentType() {
		return ResultType.CITYGML.getContentType();
	}
}