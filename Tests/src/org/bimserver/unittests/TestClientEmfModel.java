package org.bimserver.unittests;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;
import org.bimserver.BimServer;
import org.bimserver.client.BimServerClient;
import org.bimserver.client.Session;
import org.bimserver.ifc.step.serializer.IfcStepSerializer;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.models.ifc2x3.IfcApplication;
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcBoundingBox;
import org.bimserver.models.ifc2x3.IfcBuilding;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcChangeActionEnum;
import org.bimserver.models.ifc2x3.IfcClosedShell;
import org.bimserver.models.ifc2x3.IfcConversionBasedUnit;
import org.bimserver.models.ifc2x3.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3.IfcDirection;
import org.bimserver.models.ifc2x3.IfcElementCompositionEnum;
import org.bimserver.models.ifc2x3.IfcFace;
import org.bimserver.models.ifc2x3.IfcFaceOuterBound;
import org.bimserver.models.ifc2x3.IfcFacetedBrep;
import org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext;
import org.bimserver.models.ifc2x3.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3.IfcLocalPlacement;
import org.bimserver.models.ifc2x3.IfcMeasureWithUnit;
import org.bimserver.models.ifc2x3.IfcOrganization;
import org.bimserver.models.ifc2x3.IfcOwnerHistory;
import org.bimserver.models.ifc2x3.IfcPerson;
import org.bimserver.models.ifc2x3.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3.IfcPlaneAngleMeasure;
import org.bimserver.models.ifc2x3.IfcPolyLoop;
import org.bimserver.models.ifc2x3.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3.IfcProject;
import org.bimserver.models.ifc2x3.IfcRelAggregates;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcSIPrefix;
import org.bimserver.models.ifc2x3.IfcSIUnit;
import org.bimserver.models.ifc2x3.IfcSIUnitName;
import org.bimserver.models.ifc2x3.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3.IfcSite;
import org.bimserver.models.ifc2x3.IfcUnitAssignment;
import org.bimserver.models.ifc2x3.IfcUnitEnum;
import org.bimserver.models.ifc2x3.IfcWall;
import org.bimserver.models.ifc2x3.Tristate;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.shared.SDownloadResult;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.UserException;
import org.bimserver.web.LocalDevBimWebServerStarter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestClientEmfModel {
	private Session session;
	private IfcOwnerHistory ownerHistory;
	private IfcLocalPlacement buildingStoreyLocalPlacement;
	private IfcGeometricRepresentationContext geometricContext;
	private BimServerClient bimServerClient;
	private static BimServer bimServer;

	@BeforeClass
	public static void setup() {
		try {
			File home = new File("home");
			if (home.isDirectory()) {
				FileUtils.deleteDirectory(home);
			}

			LocalDevBimWebServerStarter localDevBimWebServerStarter = new LocalDevBimWebServerStarter();
			localDevBimWebServerStarter.start("localhost", 8082, "home", "../BimWebServer/www");
			bimServer = localDevBimWebServerStarter.getBimServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void shutdown() {
//		bimServer.stop();
	}

	private int createProject() {
		try {
			SProject project =  bimServerClient.getServiceInterface().addProject("Project " + new Random().nextInt());
			return project.getId();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Test
	public void test() {
		bimServerClient = new BimServerClient();
//		bimServerClient.connectSoap("http://localhost:8082/soap");
		bimServerClient.connectProtocolBuffers("localhost", 8020);
//		bimServerClient.connectDirect(bimServer.getSystemService());
		try {
			bimServerClient.login("admin@bimserver.org", "admin");
			session = bimServerClient.createSession();
			int pid = createProject();
			session.startTransaction(pid);
			createIfcProject();
			long roid = session.commitTransaction();
			IfcModelInterface model = getSingleRevision(roid);
			IfcStepSerializer serializer = new IfcStepSerializer();
			serializer.init(model, null, bimServer.getPluginManager());
			serializer.writeToFile(new File("output/test.ifc"));
		} catch (UserException e) {
			e.printStackTrace();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}

	private IfcModelInterface getSingleRevision(long roid) throws UserException, ServerException, DeserializeException, IOException {
		SRevision revision = bimServerClient.getServiceInterface().getRevision(roid);
		SSerializer serializerByContentType = bimServerClient.getServiceInterface().getSerializerByContentType("application/ifc");
		int downloadId = bimServerClient.getServiceInterface().download(revision.getOid(), serializerByContentType.getName(), true);
		SDownloadResult downloadData = bimServerClient.getServiceInterface().getDownloadData(downloadId);
		DataHandler dataHandler = downloadData.getFile();
		DeserializerPlugin deserializerPlugin;
		try {
			deserializerPlugin = bimServer.getPluginManager().getFirstDeserializer("ifc", true);
			EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
			deserializer.init(bimServer.getPluginManager().requireSchemaDefinition());
			IfcModelInterface model = deserializer.read(dataHandler.getInputStream(), "test.ifc", true, 0);
			return model;
		} catch (PluginException e) {
			e.printStackTrace();
		}
		return null;
	}

	private IfcWall createWall() {
		IfcWall wall = session.create(IfcWall.class);
		wall.setGlobalId(makeGuid("3Ep4r0uuX5ywPYOUG2H2A4"));
		wall.setOwnerHistory(ownerHistory);
		wall.setName("Wall xyz");
		wall.setDescription("Description of Wall");
		
		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(1f, 0f, 0f));

		IfcLocalPlacement localPlacement = session.create(IfcLocalPlacement.class);
		localPlacement.setRelativePlacement(axis2Placement3D);
		localPlacement.setPlacementRelTo(buildingStoreyLocalPlacement);
		
		wall.setObjectPlacement(localPlacement);

		IfcShapeRepresentation brep = session.create(IfcShapeRepresentation.class);
		brep.setRepresentationIdentifier("Body");
		brep.setRepresentationType("Brep");
		brep.setContextOfItems(geometricContext);

		IfcClosedShell closedShell = session.create(IfcClosedShell.class);
		
		IfcCartesianPoint p1 = makeCartesianPoint(0f, 0f, 0f);
		IfcCartesianPoint p2 = makeCartesianPoint(0f, 200f, 0f);
		IfcCartesianPoint p3 = makeCartesianPoint(5400f, 200f, 0f);
		IfcCartesianPoint p4 = makeCartesianPoint(5400f, 0f, 0f);
		IfcCartesianPoint p5 = makeCartesianPoint(0f, 0f, 5000f);
		IfcCartesianPoint p6 = makeCartesianPoint(5400f, 0f, 5000f);
		IfcCartesianPoint p7 = makeCartesianPoint(5400f, 200f, 5000f);
		IfcCartesianPoint p8 = makeCartesianPoint(0, 200f, 5000f);
		
		closedShell.getCfsFaces().add(makeFace(p1, p2, p3, p4));
		closedShell.getCfsFaces().add(makeFace(p5, p6, p7, p8));
		closedShell.getCfsFaces().add(makeFace(p1, p5, p8, p2));
		closedShell.getCfsFaces().add(makeFace(p2, p8, p7, p3));
		closedShell.getCfsFaces().add(makeFace(p3, p7, p6, p4));
		closedShell.getCfsFaces().add(makeFace(p4, p6, p5, p1));
		IfcFacetedBrep facetedBrep = session.create(IfcFacetedBrep.class);
		facetedBrep.setOuter(closedShell);
		brep.getItems().add(facetedBrep);
		
		IfcBoundingBox boundingBox = session.create(IfcBoundingBox.class);
		boundingBox.setCorner(makeCartesianPoint(0f, 0f, 0f));
		boundingBox.setXDim(5400f);
		boundingBox.setYDim(200f);
		boundingBox.setZDim(5000f);
		
		IfcShapeRepresentation box = session.create(IfcShapeRepresentation.class);
		box.setRepresentationIdentifier("Box");
		box.setRepresentationType("BoundingBox");
		box.setContextOfItems(geometricContext);
		box.getItems().add(boundingBox);
		
		IfcProductDefinitionShape productDefinitionShape = session.create(IfcProductDefinitionShape.class);
		productDefinitionShape.getRepresentations().add(brep);
		productDefinitionShape.getRepresentations().add(box);
		
		wall.setRepresentation(productDefinitionShape);
		
		return wall;
	}
	
	private IfcFace makeFace(IfcCartesianPoint...cartesianPoints) {
		IfcFace face = session.create(IfcFace.class);
		IfcPolyLoop polyLoop = session.create(IfcPolyLoop.class);
		for (IfcCartesianPoint ifcCartesianPoint : cartesianPoints) {
			polyLoop.getPolygon().add(ifcCartesianPoint);
		}
		IfcFaceOuterBound faceOuterBound = session.create(IfcFaceOuterBound.class);
		faceOuterBound.setOrientation(Tristate.TRUE);
		faceOuterBound.setBound(polyLoop);
		face.getBounds().add(faceOuterBound);
		return face;
	}

	private IfcBuildingStorey createBuildingStorey() {
		IfcBuildingStorey buildingStorey = session.create(IfcBuildingStorey.class);
		buildingStorey.setGlobalId(makeGuid("36_p3GiZXEHxQ3gWcOhQPE"));
		buildingStorey.setName("Default Building Storey");
		buildingStorey.setLongName("Description of Default Building Storey");
		buildingStorey.setOwnerHistory(ownerHistory);
		buildingStorey.setCompositionType(IfcElementCompositionEnum.ELEMENT);

		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(1f, 0f, 0f));
		
		buildingStoreyLocalPlacement = session.create(IfcLocalPlacement.class);
		buildingStoreyLocalPlacement.setRelativePlacement(axis2Placement3D);
		buildingStorey.setObjectPlacement(buildingStoreyLocalPlacement);
		
		IfcRelContainedInSpatialStructure containedInSpatialStructure = session.create(IfcRelContainedInSpatialStructure.class);
		containedInSpatialStructure.setGlobalId(makeGuid("2m$RhK6IP2zh0BtKz5RbtU"));
		containedInSpatialStructure.setName("Default Building");
		containedInSpatialStructure.setDescription("Description of Default Building");
		containedInSpatialStructure.setOwnerHistory(ownerHistory);
		containedInSpatialStructure.setRelatingStructure(buildingStorey);
		containedInSpatialStructure.getRelatedElements().add(createWall());
		
		return buildingStorey;
	}

	private IfcBuilding createBuilding() {
		IfcBuilding building = session.create(IfcBuilding.class);
		building.setGlobalId(makeGuid("1MW5jGD1fBiRPPs7T9I5O8"));
		building.setName("Default Building");
		building.setLongName("Description of Default Building");
		building.setOwnerHistory(ownerHistory);
		building.setCompositionType(IfcElementCompositionEnum.ELEMENT);
		
		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(1f, 0f, 0f));
		
		IfcLocalPlacement localPlacement = session.create(IfcLocalPlacement.class);
		localPlacement.setRelativePlacement(axis2Placement3D);
		building.setObjectPlacement(localPlacement);
		
		IfcRelAggregates buildingBuildingStorey = session.create(IfcRelAggregates.class);
		buildingBuildingStorey.setRelatingObject(building);
		buildingBuildingStorey.getRelatedObjects().add(createBuildingStorey());
		
		return building;
	}

	private IfcSite createSite() {
		IfcSite site = session.create(IfcSite.class);
		site.setGlobalId(makeGuid("0X4tGlJqHCcwlHMZaCq8EN"));
		site.setDescription("Default Site");
		site.setLongName("Description of Default Site");
		site.setOwnerHistory(ownerHistory);
		
		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(1f, 0f, 0f));
		
		IfcLocalPlacement localPlacement = session.create(IfcLocalPlacement.class);
		localPlacement.setRelativePlacement(axis2Placement3D);
		site.setObjectPlacement(localPlacement);
		site.setCompositionType(IfcElementCompositionEnum.ELEMENT);
		site.getRefLatitude().add(24);
		site.getRefLatitude().add(28);
		site.getRefLatitude().add(0);
		site.getRefLongitude().add(54);
		site.getRefLongitude().add(25);
		site.getRefLongitude().add(0);
		
		IfcRelAggregates buildingBuildingStorey = session.create(IfcRelAggregates.class);
		buildingBuildingStorey.setRelatingObject(site);
		buildingBuildingStorey.getRelatedObjects().add(createBuilding());
		
		return site;
	}
	
	private void createIfcProject() {
		IfcProject project = session.create(IfcProject.class);
		project.setGlobalId(makeGuid("2o1ykWxGT4ZxPjHNe4gayR"));
		project.setName("Default Project");
		project.setDescription("Description of Default Project");
		project.setOwnerHistory(createOwnerHistory());
		project.setUnitsInContext(createUnits());
		geometricContext = createGeometricContext();
		project.getRepresentationContexts().add(geometricContext);
		
		IfcRelAggregates buildingBuildingStorey = session.create(IfcRelAggregates.class);
		buildingBuildingStorey.setRelatingObject(project);
		buildingBuildingStorey.getRelatedObjects().add(createSite());
	}

	private IfcCartesianPoint makeCartesianPoint(float x, float y, float z) {
		IfcCartesianPoint point = session.create(IfcCartesianPoint.class);
		point.getCoordinates().add(x);
		point.getCoordinates().add(y);
		point.getCoordinates().add(z);
		return point;
	}
	
	private IfcDirection makeDirection(float x, float y, float z) {
		IfcDirection direction = session.create(IfcDirection.class);
		direction.getDirectionRatios().add(x);
		direction.getDirectionRatios().add(y);
		direction.getDirectionRatios().add(z);
		return direction;
	}

	private IfcGeometricRepresentationContext createGeometricContext() {
		IfcCartesianPoint cartesianPoint = session.create(IfcCartesianPoint.class);
		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(cartesianPoint);
		
		IfcGeometricRepresentationContext geometricRepresentationContext = session.create(IfcGeometricRepresentationContext.class);
		geometricRepresentationContext.setContextType("Model");
		geometricRepresentationContext.setCoordinateSpaceDimension(3);
		geometricRepresentationContext.setPrecision(1.000E-5f);
		geometricRepresentationContext.setWorldCoordinateSystem(axis2Placement3D);
		return geometricRepresentationContext;
	}

	private IfcUnitAssignment createUnits() {
		IfcUnitAssignment unitAssignment = session.create(IfcUnitAssignment.class);
		unitAssignment.getUnits().add(makeSiUnit(IfcUnitEnum.LENGTHUNIT, IfcSIPrefix.MILLI, IfcSIUnitName.METRE));
		unitAssignment.getUnits().add(makeSiUnit(IfcUnitEnum.AREAUNIT, null, IfcSIUnitName.SQUARE_METRE));
		unitAssignment.getUnits().add(makeSiUnit(IfcUnitEnum.VOLUMEUNIT, null, IfcSIUnitName.CUBIC_METRE));
		
		IfcConversionBasedUnit conversionBasedUnit = session.create(IfcConversionBasedUnit.class);
		IfcDimensionalExponents dimensionalExponents = session.create(IfcDimensionalExponents.class);
		conversionBasedUnit.setDimensions(dimensionalExponents);
		IfcMeasureWithUnit measureWithUnit = session.create(IfcMeasureWithUnit.class);
		conversionBasedUnit.setConversionFactor(measureWithUnit);
		conversionBasedUnit.setUnitType(IfcUnitEnum.PLANEANGLEUNIT);
		conversionBasedUnit.setName("DEGREE");
		IfcSIUnit planeAngleUnit = makeSiUnit(IfcUnitEnum.PLANEANGLEUNIT, null, IfcSIUnitName.RADIAN);
		IfcPlaneAngleMeasure value = session.create(IfcPlaneAngleMeasure.class);
		value.setWrappedValue(1.745E-2f);
		measureWithUnit.setValueComponent(value);
		measureWithUnit.setUnitComponent(planeAngleUnit);
		unitAssignment.getUnits().add(planeAngleUnit);
		
		unitAssignment.getUnits().add(makeSiUnit(IfcUnitEnum.SOLIDANGLEUNIT, null, IfcSIUnitName.STERADIAN));
		unitAssignment.getUnits().add(makeSiUnit(IfcUnitEnum.MASSUNIT, null, IfcSIUnitName.GRAM));
		unitAssignment.getUnits().add(makeSiUnit(IfcUnitEnum.TIMEUNIT, null, IfcSIUnitName.SECOND));
		unitAssignment.getUnits().add(makeSiUnit(IfcUnitEnum.THERMODYNAMICTEMPERATUREUNIT, null, IfcSIUnitName.DEGREE_CELSIUS));
		unitAssignment.getUnits().add(makeSiUnit(IfcUnitEnum.LUMINOUSINTENSITYUNIT, null, IfcSIUnitName.LUMEN));
		return unitAssignment;
	}

	private IfcOwnerHistory createOwnerHistory() {
		IfcPerson person = session.create(IfcPerson.class);
		person.setId("ID001");
		person.setFamilyName("Bonsma");
		person.setGivenName("Peter");
		
		IfcOrganization organization = session.create(IfcOrganization.class);
		organization.setName("TNO");
		organization.setDescription("TNO Building Innovation");
		
		IfcPersonAndOrganization personAndOrganization = session.create(IfcPersonAndOrganization.class);
		personAndOrganization.setThePerson(person);
		personAndOrganization.setTheOrganization(organization);
		
		IfcApplication application = session.create(IfcApplication.class);
		application.setApplicationDeveloper(organization);
		application.setVersion("0.10");
		application.setApplicationIdentifier("TA 1001");
		application.setApplicationFullName("Test Application");
		
		ownerHistory = session.create(IfcOwnerHistory.class);
		ownerHistory.setOwningApplication(application);
		ownerHistory.setChangeAction(IfcChangeActionEnum.ADDED);
		ownerHistory.setCreationDate(1232965595);
		ownerHistory.setOwningUser(personAndOrganization);
		return ownerHistory;
	}
	
	private IfcSIUnit makeSiUnit(IfcUnitEnum unitEnum, IfcSIPrefix siPrefix, IfcSIUnitName siUnitName) {
		IfcSIUnit siUnit = session.create(IfcSIUnit.class);
		siUnit.setPrefix(siPrefix);
		siUnit.setUnitType(unitEnum);
		siUnit.setName(siUnitName);
		return siUnit;
	}
	
	private IfcGloballyUniqueId makeGuid(String guid) {
		IfcGloballyUniqueId ifcGloballyUniqueId = session.create(IfcGloballyUniqueId.class);
		ifcGloballyUniqueId.setWrappedValue(guid);
		return ifcGloballyUniqueId;
	}
}
