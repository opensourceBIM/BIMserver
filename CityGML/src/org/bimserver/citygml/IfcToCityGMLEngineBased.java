//import java.util.Iterator;
//
//import org.bimserver.citygml.IfcToCityGML.Entity;
//import org.ebouw.ifc_public.IfcEngine;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EEnumLiteral;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.ecore.EcorePackage;

//import java.util.Arrays;
//
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
//import org.citygml4j.model.gml.MultiSurface;
//import org.ebouw.ifc_public.IfcEngine;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EClassifier;
//import org.eclipse.emf.ecore.EDataType;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EStructuralFeature;

//package org.bimserver.citygml;
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.Marshaller;
//
//import org.bimserver.citygml.IfcToCityGML.Entity;
//import org.bimserver.emf.IfcModel;
//import org.bimserver.ifc.IfcRootObject;
//import org.bimserver.ifc.database.IfcDatabase;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Factory;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
//import org.bimserver.ifc.emf.Ifc2x3.IfcDoor;
//import org.bimserver.ifc.emf.Ifc2x3.IfcElement;
//import org.bimserver.ifc.emf.Ifc2x3.IfcFurnishingElement;
//import org.bimserver.ifc.emf.Ifc2x3.IfcInternalOrExternalEnum;
//import org.bimserver.ifc.emf.Ifc2x3.IfcOpeningElement;
//import org.bimserver.ifc.emf.Ifc2x3.IfcProduct;
//import org.bimserver.ifc.emf.Ifc2x3.IfcRelContainedInSpatialStructure;
//import org.bimserver.ifc.emf.Ifc2x3.IfcRelFillsElement;
//import org.bimserver.ifc.emf.Ifc2x3.IfcRelSpaceBoundary;
//import org.bimserver.ifc.emf.Ifc2x3.IfcRelVoidsElement;
//import org.bimserver.ifc.emf.Ifc2x3.IfcSlab;
//import org.bimserver.ifc.emf.Ifc2x3.IfcSpace;
//import org.bimserver.ifc.emf.Ifc2x3.IfcVirtualElement;
//import org.bimserver.ifc.emf.Ifc2x3.IfcWallStandardCase;
//import org.bimserver.ifc.emf.Ifc2x3.IfcWindow;
//import org.bimserver.tests.TestFile;
//import org.citygml4j.CityGMLContext;
//import org.citygml4j.factory.CityGMLFactory;
//import org.citygml4j.model.citygml.CityGMLModuleVersion;
//import org.citygml4j.model.citygml.building.BoundarySurface;
//import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
//import org.citygml4j.model.citygml.building.Building;
//import org.citygml4j.model.citygml.building.BuildingFurniture;
//import org.citygml4j.model.citygml.building.Door;
//import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
//import org.citygml4j.model.citygml.building.InteriorRoomProperty;
//import org.citygml4j.model.citygml.building.OpeningProperty;
//import org.citygml4j.model.citygml.building.RoofSurface;
//import org.citygml4j.model.citygml.building.Room;
//import org.citygml4j.model.citygml.building.Window;
//import org.citygml4j.model.citygml.core.CityModel;
//import org.citygml4j.model.citygml.core.CityObject;
//import org.citygml4j.model.citygml.core.CityObjectMember;
//import org.citygml4j.model.citygml.core.CoreModule;
//import org.citygml4j.model.gml.CompositeSurface;
//import org.citygml4j.model.gml.GeometryProperty;
//import org.citygml4j.model.gml.MultiSurface;
//import org.citygml4j.model.gml.MultiSurfaceProperty;
//import org.citygml4j.model.gml.Solid;
//import org.citygml4j.model.gml.SolidProperty;
//import org.citygml4j.model.gml.SurfaceProperty;
//import org.citygml4j.util.JAXBNamespacePrefixMapper;
//import org.ebouw.ifc_public.IfcEngine;
//import org.eclipse.emf.common.util.BasicEList;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EClassifier;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EEnumLiteral;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EStructuralFeature;
//
//public class IfcToCityGMLEngineBased {
//	public void convertEngineBased() {
//		ifcEngine = IfcEngine.getInstance();
//		try {
//			TestFile testFile = TestFile.AC11;
//			modelID = ifcEngine.sdaiOpenModelBN(1, testFile.getFile().getAbsolutePath(), "lib\\IFC2x3_Final.exp");
//
//			// File ifcSchemaFile = new File("lib\\IFC2x3_Final.exp");
//			// ExpressSchemaParser schemaParser = new
//			// ExpressSchemaParser(ifcSchemaFile);
//			// schemaParser.parse();
//			// SchemaDefinition schema = schemaParser.getSchema();
//			// new DerivedReader(ifcSchemaFile, schema);
//
//			Map<EClassifier, Integer> entityIds = new HashMap<EClassifier, Integer>();
//			Map<Integer, EObject> objects = new HashMap<Integer, EObject>();
//			for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
//				if (eClassifier instanceof EClass) {
//					EClass eClass = (EClass) eClassifier;
//					int entityId = ifcEngine.sdaiGetEntity(modelID, eClass.getName().toUpperCase());
//					entityIds.put(eClass, entityId);
//					Iterator<Entity> iterator = createIterator(entityId, modelID, ifcEngine);
//					while (iterator.hasNext()) {
//						IfcRootObject object = (IfcRootObject) Ifc2x3Factory.eINSTANCE.create(eClass);
//						Entity entity = iterator.next();
//						int instanceId = entity.instanceId;
//						object.setInstanceId(instanceId);
//						objects.put(instanceId, object);
//					}
//				}
//			}
//			System.out.println("1");
//			for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
//				if (eClassifier instanceof EClass) {
//					EClass eClass = (EClass) eClassifier;
//					Iterator<Entity> iterator = createIterator(entityIds.get(eClass), modelID, ifcEngine);
//					while (iterator.hasNext()) {
//						Entity entity = iterator.next();
//						EObject object = objects.get(entity.instanceId);
//						for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
//							if (!eStructuralFeature.isDerived() && !eStructuralFeature.isTransient() && !eStructuralFeature.isVolatile()) {
//								int sdaiType = getSdaiType(eStructuralFeature);
//								Object value = ifcEngine.sdaiGetAttrBN(entity.instanceId, eStructuralFeature.getName(), sdaiType);
//								if (eStructuralFeature.getEType() instanceof EClass) {
//									EClass referenceEClass = (EClass) eStructuralFeature.getEType();
//									if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(referenceEClass)) {
//										if (value instanceof Integer && (Integer) value == 0) {
//										} else {
//											if (eStructuralFeature.getUpperBound() == -1 || eStructuralFeature.getUpperBound() > 1) {
//												BasicEList list = (BasicEList) object.eGet(eStructuralFeature);
//												int v = (Integer) value;
//												if (v != 0) {
//													int size = ifcEngine.sdaiGetMemberCount(v);
//													EClass eC = (EClass) eStructuralFeature.getEType();
//													int sdaiType2 = getSdaiType(eC.getEStructuralFeature("wrappedValue"));
//													for (int w = 0; w < size; w++) {
//														Object engiGetAggrElement = ifcEngine.engiGetAggrElement(v, w, sdaiType2);
//														if (engiGetAggrElement instanceof Integer && (Integer) engiGetAggrElement == 0) {
//															// $
//														} else {
//															list.addUnique(createWrappedValue((EClass) eStructuralFeature.getEType(), engiGetAggrElement));
//														}
//													}
//												}
//											} else {
//												object.eSet(eStructuralFeature, createWrappedValue((EClass) eStructuralFeature.getEType(), value));
//											}
//										}
//									} else {
//										int v = (Integer) value;
//										if (eStructuralFeature.getUpperBound() == -1 || eStructuralFeature.getUpperBound() > 1) {
//											if (v != 0) {
//												BasicEList list = (BasicEList) object.eGet(eStructuralFeature);
//												int size = ifcEngine.sdaiGetMemberCount(v);
//												for (int w = 0; w < size; w++) {
//													int engiGetAggrElement = (Integer) ifcEngine.engiGetAggrElement(v, w, IfcEngine.sdaiINSTANCE);
//													if (engiGetAggrElement != 0) {
//														list.addUnique(objects.get(engiGetAggrElement));
//													}
//												}
//											}
//										} else {
//											if (v != 0) {
//												object.eSet(eStructuralFeature, objects.get(v));
//											}
//										}
//									}
//								} else if (eStructuralFeature.getEType() instanceof EEnum) {
//									if (!(value instanceof Integer) && value != null) {
//										EEnum eEnum = (EEnum) eStructuralFeature.getEType();
//										String str = value.toString();
//										str = str.substring(1, str.length() - 1);
//										EEnumLiteral eEnumLiteral = eEnum.getEEnumLiteral(str);
//										if (eEnumLiteral == null) {
//											System.out.println(str + " not found in " + eEnum.getName());
//										}
//										object.eSet(eStructuralFeature, eEnumLiteral.getInstance());
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//			// FastIfcFileReader fastIfcFileReader = new
//			// FastIfcFileReader(schema);
//			// fastIfcFileReader.read(testFile.getFile());
//			// IfcModel IfcModel = fastIfcFileReader.getModel();
//			// IfcSerializer ifcSerializer = new IfcSerializer(IfcModel,
//			// schema);
//			// ifcSerializer.write(new File("test.ifc"));
//			IfcModel<Integer> IfcModel = new IfcModel<Integer>(objects);
//			System.out.println("2");
//
//			CityGMLContext ctx = new CityGMLContext();
//			CityGMLFactory citygml = ctx.createCityGMLFactory(CityGMLModuleVersion.v1_0_0);
//			gml = ctx.createGMLFactory();
//
//			Building building = citygml.createBuilding();
//
//			Solid solid = gml.createSolid();
//			SolidProperty solidProperty = gml.createSolidProperty();
//			solidProperty.setSolid(solid);
//			building.setLod2Solid(solidProperty);
//
//			CompositeSurface compositeSurface = gml.createCompositeSurface();
//			SurfaceProperty exterior = gml.createSurfaceProperty();
//			exterior.setSurface(compositeSurface);
//			solid.setExterior(exterior);
//
//			IfcDatabase<Integer> ifcDatabase = new IfcDatabase<Integer>(IfcModel);
//			Map<EObject, CityObject> convertedObjects = new HashMap<EObject, CityObject>();
//			for (IfcSpace ifcSpace : ifcDatabase.getAll(IfcSpace.class)) {
//				if (convertedObjects.containsKey(ifcSpace)) {
//				} else {
//					Room room = citygml.createRoom();
//					room.addName(createName(ifcSpace.getName().getWrappedValue()));
//					convertedObjects.put(ifcSpace, room);
//					MultiSurfaceProperty multiSurfaceProperty = gml.createMultiSurfaceProperty();
//					MultiSurface ms = gml.createMultiSurface();
//					multiSurfaceProperty.setMultiSurface(ms);
//					room.setLod4MultiSurface(multiSurfaceProperty);
//					InteriorRoomProperty createInteriorRoomProperty = citygml.createInteriorRoomProperty();
//					createInteriorRoomProperty.setObject(room);
//					building.addInteriorRoom(createInteriorRoomProperty);
//					setGeometry(ms, ((IfcRootObject) ifcSpace).getInstanceId());
//					for (IfcRelSpaceBoundary boundary : ifcSpace.getBoundedBy()) {
//						IfcElement relating = boundary.getRelatedBuildingElement();
//						if (relating instanceof IfcWallStandardCase) {
//							IfcWallStandardCase ifcWall = (IfcWallStandardCase) relating;
//							if (convertedObjects.containsKey(ifcWall)) {
//								// BoundarySurfaceProperty
//								// boundarySurfaceProperty =
//								// citygml.createBoundarySurfaceProperty();
//								// boundarySurfaceProperty.setObject((BoundarySurface)convertedObjects.get(ifcWall));
//								// room.addBoundedBySurface(boundarySurfaceProperty);
//							} else {
//								BoundarySurface boundarySurface = null;
//								if (boundary.getInternalOrExternalBoundary() == IfcInternalOrExternalEnum.INTERNAL) {
//									boundarySurface = citygml.createInteriorWallSurface();
//								} else {
//									boundarySurface = citygml.createWallSurface();
//								}
//								boundarySurface.addName(createName(ifcWall.getName().getWrappedValue()));
//								convertedObjects.put(ifcWall, boundarySurface);
//								BoundarySurfaceProperty boundarySurfaceProperty = citygml.createBoundarySurfaceProperty();
//								boundarySurfaceProperty.setObject(boundarySurface);
//								MultiSurface wallMs = gml.createMultiSurface();
//								MultiSurfaceProperty wallMSP = gml.createMultiSurfaceProperty();
//								wallMSP.setMultiSurface(wallMs);
//								boundarySurface.setLod4MultiSurface(wallMSP);
//								setGeometry(wallMs, ((IfcRootObject) ifcWall).getInstanceId());
//								room.addBoundedBySurface(boundarySurfaceProperty);
//								for (IfcRelVoidsElement ifcRelVoidsElement : ifcWall.getHasOpenings()) {
//									IfcOpeningElement ifcOpeningElement = (IfcOpeningElement) ifcRelVoidsElement.getRelatedOpeningElement();
//									for (IfcRelFillsElement filling : ifcOpeningElement.getHasFillings()) {
//										IfcElement relatedBuildingElement = filling.getRelatedBuildingElement();
//										if (relatedBuildingElement instanceof IfcWindow) {
//											if (convertedObjects.containsKey(relatedBuildingElement)) {
//											} else {
//												Window window = citygml.createWindow();
//												window.getName().add(createName(relatedBuildingElement.getName().getWrappedValue()));
//												convertedObjects.put(relatedBuildingElement, window);
//												MultiSurfaceProperty windowMSP = gml.createMultiSurfaceProperty();
//												MultiSurface windowMs = gml.createMultiSurface();
//												windowMSP.setMultiSurface(windowMs);
//												window.setLod4MultiSurface(windowMSP);
//												setGeometry(windowMs, ((IfcRootObject) relatedBuildingElement).getInstanceId());
//												OpeningProperty openingProperty = citygml.createOpeningProperty();
//												openingProperty.setObject(window);
//												boundarySurface.addOpening(openingProperty);
//											}
//										} else if (relatedBuildingElement instanceof IfcDoor) {
//											if (convertedObjects.containsKey(relatedBuildingElement)) {
//											} else {
//												Door door = citygml.createDoor();
//												door.getName().add(createName(relatedBuildingElement.getName().getWrappedValue()));
//												convertedObjects.put(relatedBuildingElement, door);
//												MultiSurfaceProperty doorMSP = gml.createMultiSurfaceProperty();
//												MultiSurface doorMs = gml.createMultiSurface();
//												doorMSP.setMultiSurface(doorMs);
//												door.setLod4MultiSurface(doorMSP);
//												setGeometry(doorMs, ((IfcRootObject) relatedBuildingElement).getInstanceId());
//												OpeningProperty openingProperty = citygml.createOpeningProperty();
//												openingProperty.setObject(door);
//												boundarySurface.addOpening(openingProperty);
//											}
//										}
//									}
//								}
//							}
//						} else if (relating instanceof IfcSlab) {
//							if (convertedObjects.containsKey(relating)) {
//							} else {
//								RoofSurface roofSurface = citygml.createRoofSurface();
//								MultiSurfaceProperty roofMSP = gml.createMultiSurfaceProperty();
//								MultiSurface roofMs = gml.createMultiSurface();
//								roofMSP.setMultiSurface(roofMs);
//								roofSurface.setLod4MultiSurface(roofMSP);
//								setGeometry(roofMs, ((IfcRootObject) relating).getInstanceId());
//								BoundarySurfaceProperty boundarySurfaceProperty = citygml.createBoundarySurfaceProperty();
//								boundarySurfaceProperty.setObject(roofSurface);
//								room.addBoundedBySurface(boundarySurfaceProperty);
//								convertedObjects.put(relating, roofSurface);
//							}
//						} else if (relating == null || relating instanceof IfcWindow || relating instanceof IfcDoor || relating instanceof IfcVirtualElement) {
//							// ignore
//						} else {
//							System.out.println(relating);
//						}
//					}
//					for (IfcRelContainedInSpatialStructure contains : ifcSpace.getContainsElements()) {
//						for (IfcProduct ifcProduct : contains.getRelatedElements()) {
//							if (ifcProduct instanceof IfcFurnishingElement) {
//								if (convertedObjects.containsKey(ifcProduct)) {
//								} else {
//									BuildingFurniture buildingFurniture = citygml.createBuildingFurniture();
//									GeometryProperty createGeometryProperty = gml.createGeometryProperty();
//									MultiSurface createMultiSurface = gml.createMultiSurface();
//									setGeometry(createMultiSurface, ((IfcRootObject) ifcProduct).getInstanceId());
//									createGeometryProperty.setGeometry(createMultiSurface);
//									buildingFurniture.setLod4Geometry(createGeometryProperty);
//									convertedObjects.put(ifcProduct, buildingFurniture);
//									InteriorFurnitureProperty ifp = citygml.createInteriorFurnitureProperty();
//									ifp.setObject(buildingFurniture);
//									room.addInteriorFurniture(ifp);
//								}
//							}
//						}
//					}
//				}
//			}
//			System.out.println("3");
//
//			CityModel cityModel = citygml.createCityModel();
//			CityObjectMember cityObjectMember = citygml.createCityObjectMember();
//			cityObjectMember.setCityObject(building);
//			cityModel.addCityObjectMember(cityObjectMember);
//
//			JAXBContext jaxbCtx = ctx.createJAXBContext();
//			Marshaller marshaller = jaxbCtx.createMarshaller();
//
//			JAXBNamespacePrefixMapper nsMapper = new JAXBNamespacePrefixMapper();
//			nsMapper.setNamespacePrefixMapping(CoreModule.v1_0_0.getNamespaceUri(), "");
//
//			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//			marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", nsMapper);
//			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, CoreModule.v1_0_0.getNamespaceUri() + " " + CoreModule.v1_0_0.getSchemaLocation());
//
//			JAXBElement<?> cityModelElement = citygml.cityGML2jaxb(cityModel);
//
//			marshaller.marshal(cityModelElement, new File("AC11-Institute-Var-2-IFC.gml"));
//			System.out.println("4");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//

//
//	private void setGeometry(MultiSurface ms, int instanceId) throws Exception {
//		if (instanceId == 0) {
//			return;
//		}
//		IfcEngine.SurfaceProperties sp = ifcEngine.initializeModellingInstance(modelID, 0.0, instanceId);
//		int verticesCount = sp.getVerticesCount();
//		float[] coordinates = new float[verticesCount * 3];
//		float[] normals = new float[verticesCount * 3];
//		int[] indices = new int[sp.getIndicesCount()];
//		ifcEngine.finalizeModelling(modelID, coordinates, normals, indices);
//		for (int i = 0; i < indices.length; i++) {
//			int i1 = indices[i];
//			int i2 = indices[++i];
//			int i3 = indices[++i];
//			ms.addSurfaceMember(createSurfaceProperty(gml, Arrays.asList(new Double[] { (double) coordinates[i1 * 3], (double) coordinates[i1 * 3 + 1],
//					(double) coordinates[i1 * 3 + 2], (double) coordinates[i2 * 3], (double) coordinates[i2 * 3 + 1], (double) coordinates[i2 * 3 + 2],
//					(double) coordinates[i3 * 3], (double) coordinates[i3 * 3 + 1], (double) coordinates[i3 * 3 + 2], (double) coordinates[i1 * 3],
//					(double) coordinates[i1 * 3 + 1], (double) coordinates[i1 * 3 + 2] })));
//		}
//	}


//private int getSdaiType(EStructuralFeature eStructuralFeature) {
//	EClassifier eType = eStructuralFeature.getEType();
//	if (eType instanceof EEnum) {
//		return IfcEngine.sdaiSTRING;
//	} else if (eType instanceof EClass) {
//		if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eType)) {
//			EClass wt = (EClass) eType;
//			if (eStructuralFeature.getUpperBound() == -1 || eStructuralFeature.getUpperBound() > 1) {
//				return IfcEngine.sdaiAGGR;
//			} else {
//				return getSdaiType(wt.getEStructuralFeature("wrappedValue"));
//			}
//		} else {
//			if (eStructuralFeature.getUpperBound() == -1 || eStructuralFeature.getUpperBound() > 1) {
//				return IfcEngine.sdaiAGGR;
//			} else {
//				return IfcEngine.sdaiINSTANCE;
//			}
//		}
//	} else if (eType instanceof EDataType) {
//		Class<?> instanceClass = eType.getInstanceClass();
//		if (instanceClass == Boolean.class || instanceClass == boolean.class) {
//			return IfcEngine.sdaiBOOLEAN;
//		} else if (instanceClass == Integer.class || instanceClass == int.class) {
//			return IfcEngine.sdaiINTEGER;
//		} else if (instanceClass == Float.class || instanceClass == float.class || instanceClass == Double.class || instanceClass == double.class) {
//			return IfcEngine.sdaiREAL;
//		} else if (instanceClass == String.class) {
//			return IfcEngine.sdaiSTRING;
//		}
//	}
//	throw new RuntimeException("unimplemented type " + eType.getName());
//}


//	private Object createWrappedValue(EClass eType, Object value) {
//		EObject create = eType.getEPackage().getEFactoryInstance().create(eType);
//		EStructuralFeature feature = eType.getEStructuralFeature("wrappedValue");
//		if (feature.getEType() instanceof EEnum) {
//			EEnum eEnum = (EEnum) feature.getEType();
//			String str = value.toString();
//			str = str.substring(1, str.length() - 1);
//			EEnumLiteral eEnumLiteral = eEnum.getEEnumLiteral(str);
//			create.eSet(feature, eEnumLiteral);
//		} else {
//			if (feature.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
//				create.eSet(eType.getEStructuralFeature("stringValue" + feature.getName()), value.toString());
//				create.eSet(feature, Float.parseFloat(value.toString()));
//			} else {
//				create.eSet(feature, value);
//			}
//		}
//		return create;
//	}

//private Iterator<Entity> createIterator(int entityId, final int modelID, final IfcEngine ifcEngine) throws Exception {
//	final int aggregateId = ifcEngine.sdaiGetEntityExtent(modelID, entityId);
//	final int sdaiGetMemberCount = ifcEngine.sdaiGetMemberCount(aggregateId);
//	Iterator<Entity> iterator = new Iterator<Entity>() {
//		int currentIndex = 0;
//
//		@Override
//		public boolean hasNext() {
//			return currentIndex < sdaiGetMemberCount;
//		}
//
//		@Override
//		public Entity next() {
//			try {
//				return new Entity((int) ((Integer) ifcEngine.engiGetAggrElement(aggregateId, currentIndex++, IfcEngine.sdaiINSTANCE)));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return null;
//		}
//
//		@Override
//		public void remove() {
//			throw new RuntimeException("not implemented");
//		}
//	};
//	return iterator;
//}

//}
