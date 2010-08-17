//import java.util.Arrays;
//
//import org.citygml4j.factory.GMLFactory;
//import org.citygml4j.model.gml.MultiSurface;
//import org.ebouw.ifc_public.IfcEngine;

//package org.bimserver.citygml;
//
//import java.io.File;
//import java.util.List;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.Marshaller;
//
//import org.bimserver.ifc.IfcRootObject;
//import org.bimserver.ifc.database.IfcDatabase;
//import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
//import org.bimserver.ifc.emf.Ifc2x3.IfcSpace;
//import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
//import org.citygml4j.model.citygml.building.Building;
//import org.citygml4j.model.citygml.building.InteriorRoomProperty;
//import org.citygml4j.model.citygml.building.Room;
//import org.citygml4j.model.citygml.core.CityModel;
//import org.citygml4j.model.citygml.core.CityObjectMember;
//import org.citygml4j.model.citygml.core.CoreModule;
//import org.citygml4j.model.gml.MultiSurface;
//import org.citygml4j.model.gml.MultiSurfaceProperty;
//import org.citygml4j.util.JAXBNamespacePrefixMapper;
//import org.ebouw.ifc_public.IfcEngine;
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EDataType;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EStructuralFeature;
//
//public class IfcToCityGMLCreateStatements {
//
//
//	public void convertCreateStatements() throws IncorrectIfcFileException, Exception {
//		IfcDatabase<Long> ifcDatabase = new IfcDatabase<Long>(model);
//
//		Building building = citygml.createBuilding();
//		
//		CityModel cityModel = citygml.createCityModel();
//		CityObjectMember cityObjectMember = citygml.createCityObjectMember();
//		cityObjectMember.setCityObject(building);
//		cityModel.addCityObjectMember(cityObjectMember);
//
//		ifcEngine = IfcEngine.getInstance();
//		modelID = ifcEngine.sdaiCreateModelBN(0, "test.ifc", "lib\\IFC2x3_Final.exp");
//
//		for (EObject eObject : model.getObjects().values()) {
//			IfcRootObject ifcRootObject = (IfcRootObject) eObject;
//			int instanceId = ifcEngine.sdaiCreateInstance(modelID, ifcEngine.sdaiGetEntity(modelID, eObject.eClass().getName().toUpperCase()));
//			ifcRootObject.setInstanceId(instanceId);
//			for (EStructuralFeature eStructuralFeature : eObject.eClass().getEAllStructuralFeatures()) {
//				Object value = ifcRootObject.eGet(eStructuralFeature);
//				if (eStructuralFeature.getEType() instanceof EClass) {
//					EClass eClass = (EClass) eStructuralFeature.getEType();
//					if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf(eClass)) {
//						if (value != null) {
//							if (value instanceof EList) {
//
//							} else {
//								EObject valueObject = (EObject) value;
//								Object realValue = valueObject.eGet(valueObject.eClass().getEStructuralFeature("wrappedValue"));
//								int sdaiType = getSdaiType(eStructuralFeature);
//								System.out
//										.println(eObject.eClass().getName() + "." + eStructuralFeature.getName() + ":" + eStructuralFeature.getEType().getName() + "/" + sdaiType);
//								System.out.println(realValue);
//								ifcEngine.sdaiPutAttrBN(instanceId, eStructuralFeature.getName(), sdaiType, realValue);
//							}
//						}
//					} else {
//
//					}
//				} else if (eStructuralFeature.getEType() instanceof EEnum) {
//
//				} else if (eStructuralFeature.getEType() instanceof EDataType) {
//				}
//			}
//		}
//
//		List<IfcSpace> spaces = ifcDatabase.getAll(IfcSpace.class);
//		for (IfcSpace ifcSpace : spaces) {
//			Room room = citygml.createRoom();
//			MultiSurfaceProperty multiSurfaceProperty = gml.createMultiSurfaceProperty();
//			MultiSurface ms = gml.createMultiSurface();
//			multiSurfaceProperty.setMultiSurface(ms);
//			room.setLod4MultiSurface(multiSurfaceProperty);
//			InteriorRoomProperty createInteriorRoomProperty = citygml.createInteriorRoomProperty();
//			createInteriorRoomProperty.setObject(room);
//			building.addInteriorRoom(createInteriorRoomProperty);
//
//		}
//
//		JAXBContext jaxbCtx = ctx.createJAXBContext();
//		Marshaller marshaller = jaxbCtx.createMarshaller();
//
//		JAXBNamespacePrefixMapper nsMapper = new JAXBNamespacePrefixMapper();
//		nsMapper.setNamespacePrefixMapping(CoreModule.v1_0_0.getNamespaceUri(), "");
//
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", nsMapper);
//		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, CoreModule.v1_0_0.getNamespaceUri() + " " + CoreModule.v1_0_0.getSchemaLocation());
//
//		JAXBElement<?> cityModelElement = citygml.cityGML2jaxb(cityModel);
//
//		marshaller.marshal(cityModelElement, new File("AC11-Institute-Var-2-IFC.gml"));
//	}
//}

//
//	class Entity {
//		private final int instanceId;
//
//		public Entity(int instanceId) {
//			this.instanceId = instanceId;
//		}
//
//		public void addToMultiSurface(MultiSurface ms, GMLFactory gml) throws Exception {
//			IfcEngine.SurfaceProperties sp = ifcEngine.initializeModellingInstance(modelID, 0.0, instanceId);
//			int verticesCount = sp.getVerticesCount();
//			float[] coordinates = new float[verticesCount * 3];
//			float[] normals = new float[verticesCount * 3];
//			int[] indices = new int[sp.getIndicesCount()];
//			ifcEngine.finalizeModelling(modelID, coordinates, normals, indices);
//			for (int i = 0; i < indices.length; i++) {
//				int i1 = indices[i];
//				int i2 = indices[++i];
//				int i3 = indices[++i];
//				ms.addSurfaceMember(createSurfaceProperty(gml, Arrays.asList(new Double[] { (double) coordinates[i1 * 3], (double) coordinates[i1 * 3 + 1],
//						(double) coordinates[i1 * 3 + 2], (double) coordinates[i2 * 3], (double) coordinates[i2 * 3 + 1], (double) coordinates[i2 * 3 + 2],
//						(double) coordinates[i3 * 3], (double) coordinates[i3 * 3 + 1], (double) coordinates[i3 * 3 + 2], (double) coordinates[i1 * 3],
//						(double) coordinates[i1 * 3 + 1], (double) coordinates[i1 * 3 + 2] })));
//			}
//		}
//	}

