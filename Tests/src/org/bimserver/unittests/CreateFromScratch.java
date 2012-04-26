package org.bimserver.unittests;

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

import org.bimserver.client.Session;
import org.bimserver.models.ifc2x3tc1.IfcApplication;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBoundingBox;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcChangeActionEnum;
import org.bimserver.models.ifc2x3tc1.IfcClosedShell;
import org.bimserver.models.ifc2x3tc1.IfcConversionBasedUnit;
import org.bimserver.models.ifc2x3tc1.IfcDimensionalExponents;
import org.bimserver.models.ifc2x3tc1.IfcDirection;
import org.bimserver.models.ifc2x3tc1.IfcElementCompositionEnum;
import org.bimserver.models.ifc2x3tc1.IfcFace;
import org.bimserver.models.ifc2x3tc1.IfcFaceOuterBound;
import org.bimserver.models.ifc2x3tc1.IfcFacetedBrep;
import org.bimserver.models.ifc2x3tc1.IfcGeometricRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcLocalPlacement;
import org.bimserver.models.ifc2x3tc1.IfcMeasureWithUnit;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPlaneAngleMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPolyLoop;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.Tristate;

public class CreateFromScratch {
	private IfcOwnerHistory ownerHistory;
	private IfcLocalPlacement buildingStoreyLocalPlacement;
	private IfcGeometricRepresentationContext geometricContext;

	public IfcWall createWall(Session session) {
		IfcWall wall = session.create(IfcWall.class);
		wall.setGlobalId(makeGuid(session, "3Ep4r0uuX5ywPYOUG2H2A4"));
		wall.setOwnerHistory(ownerHistory);
		wall.setName("Wall xyz");
		wall.setDescription("Description of Wall");

		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(session, 0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(session, 0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(session, 1f, 0f, 0f));

		IfcLocalPlacement localPlacement = session.create(IfcLocalPlacement.class);
		localPlacement.setRelativePlacement(axis2Placement3D);
		localPlacement.setPlacementRelTo(buildingStoreyLocalPlacement);

		wall.setObjectPlacement(localPlacement);

		IfcShapeRepresentation brep = session.create(IfcShapeRepresentation.class);
		brep.setRepresentationIdentifier("Body");
		brep.setRepresentationType("Brep");
		brep.setContextOfItems(geometricContext);

		IfcClosedShell closedShell = session.create(IfcClosedShell.class);

		IfcCartesianPoint p1 = makeCartesianPoint(session, 0f, 0f, 0f);
		IfcCartesianPoint p2 = makeCartesianPoint(session, 0f, 200f, 0f);
		IfcCartesianPoint p3 = makeCartesianPoint(session, 5400f, 200f, 0f);
		IfcCartesianPoint p4 = makeCartesianPoint(session, 5400f, 0f, 0f);
		IfcCartesianPoint p5 = makeCartesianPoint(session, 0f, 0f, 5000f);
		IfcCartesianPoint p6 = makeCartesianPoint(session, 5400f, 0f, 5000f);
		IfcCartesianPoint p7 = makeCartesianPoint(session, 5400f, 200f, 5000f);
		IfcCartesianPoint p8 = makeCartesianPoint(session, 0, 200f, 5000f);

		closedShell.getCfsFaces().add(makeFace(session, p1, p2, p3, p4));
		closedShell.getCfsFaces().add(makeFace(session, p5, p6, p7, p8));
		closedShell.getCfsFaces().add(makeFace(session, p1, p5, p8, p2));
		closedShell.getCfsFaces().add(makeFace(session, p2, p8, p7, p3));
		closedShell.getCfsFaces().add(makeFace(session, p3, p7, p6, p4));
		closedShell.getCfsFaces().add(makeFace(session, p4, p6, p5, p1));
		IfcFacetedBrep facetedBrep = session.create(IfcFacetedBrep.class);
		facetedBrep.setOuter(closedShell);
		brep.getItems().add(facetedBrep);

		IfcBoundingBox boundingBox = session.create(IfcBoundingBox.class);
		boundingBox.setCorner(makeCartesianPoint(session, 0f, 0f, 0f));
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

	private IfcFace makeFace(Session session, IfcCartesianPoint... cartesianPoints) {
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

	private IfcBuildingStorey createBuildingStorey(Session session) {
		IfcBuildingStorey buildingStorey = session.create(IfcBuildingStorey.class);
		buildingStorey.setGlobalId(makeGuid(session, "36_p3GiZXEHxQ3gWcOhQPE"));
		buildingStorey.setName("Default Building Storey");
		buildingStorey.setLongName("Description of Default Building Storey");
		buildingStorey.setOwnerHistory(ownerHistory);
		buildingStorey.setCompositionType(IfcElementCompositionEnum.ELEMENT);

		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(session, 0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(session, 0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(session, 1f, 0f, 0f));

		buildingStoreyLocalPlacement = session.create(IfcLocalPlacement.class);
		buildingStoreyLocalPlacement.setRelativePlacement(axis2Placement3D);
		buildingStorey.setObjectPlacement(buildingStoreyLocalPlacement);

		IfcRelContainedInSpatialStructure containedInSpatialStructure = session.create(IfcRelContainedInSpatialStructure.class);
		containedInSpatialStructure.setGlobalId(makeGuid(session, "2m$RhK6IP2zh0BtKz5RbtU"));
		containedInSpatialStructure.setName("Default Building");
		containedInSpatialStructure.setDescription("Description of Default Building");
		containedInSpatialStructure.setOwnerHistory(ownerHistory);
		containedInSpatialStructure.setRelatingStructure(buildingStorey);
		containedInSpatialStructure.getRelatedElements().add(createWall(session));

		return buildingStorey;
	}

	private IfcBuilding createBuilding(Session session) {
		IfcBuilding building = session.create(IfcBuilding.class);
		building.setGlobalId(makeGuid(session, "1MW5jGD1fBiRPPs7T9I5O8"));
		building.setName("Default Building");
		building.setLongName("Description of Default Building");
		building.setOwnerHistory(ownerHistory);
		building.setCompositionType(IfcElementCompositionEnum.ELEMENT);

		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(session, 0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(session, 0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(session, 1f, 0f, 0f));

		IfcLocalPlacement localPlacement = session.create(IfcLocalPlacement.class);
		localPlacement.setRelativePlacement(axis2Placement3D);
		building.setObjectPlacement(localPlacement);

		IfcRelAggregates buildingBuildingStorey = session.create(IfcRelAggregates.class);
		buildingBuildingStorey.setRelatingObject(building);
		buildingBuildingStorey.getRelatedObjects().add(createBuildingStorey(session));

		return building;
	}

	private IfcSite createSite(Session session) {
		IfcSite site = session.create(IfcSite.class);
		site.setGlobalId(makeGuid(session, "0X4tGlJqHCcwlHMZaCq8EN"));
		site.setDescription("Default Site");
		site.setLongName("Description of Default Site");
		site.setOwnerHistory(ownerHistory);

		IfcAxis2Placement3D axis2Placement3D = session.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(session, 0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(session, 0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(session, 1f, 0f, 0f));

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
		buildingBuildingStorey.getRelatedObjects().add(createBuilding(session));

		return site;
	}

	public void createIfcProject(Session session) {
		IfcProject project = session.create(IfcProject.class);
		project.setGlobalId(makeGuid(session, "2o1ykWxGT4ZxPjHNe4gayR"));
		project.setName("Default Project");
		project.setDescription("Description of Default Project");
		project.setOwnerHistory(createOwnerHistory(session));
		project.setUnitsInContext(createUnits(session));
		geometricContext = createGeometricContext(session);
		project.getRepresentationContexts().add(geometricContext);

		IfcRelAggregates buildingBuildingStorey = session.create(IfcRelAggregates.class);
		buildingBuildingStorey.setRelatingObject(project);
		buildingBuildingStorey.getRelatedObjects().add(createSite(session));
	}

	private IfcCartesianPoint makeCartesianPoint(Session session, double x, double y, double z) {
		IfcCartesianPoint point = session.create(IfcCartesianPoint.class);
		point.getCoordinates().add(x);
		point.getCoordinates().add(y);
		point.getCoordinates().add(z);
		return point;
	}

	private IfcDirection makeDirection(Session session, double x, double y, double z) {
		IfcDirection direction = session.create(IfcDirection.class);
		direction.getDirectionRatios().add(x);
		direction.getDirectionRatios().add(y);
		direction.getDirectionRatios().add(z);
		return direction;
	}

	private IfcGeometricRepresentationContext createGeometricContext(Session session) {
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

	private IfcUnitAssignment createUnits(Session session) {
		IfcUnitAssignment unitAssignment = session.create(IfcUnitAssignment.class);
		unitAssignment.getUnits().add(makeSiUnit(session, IfcUnitEnum.LENGTHUNIT, IfcSIPrefix.MILLI, IfcSIUnitName.METRE));
		unitAssignment.getUnits().add(makeSiUnit(session, IfcUnitEnum.AREAUNIT, null, IfcSIUnitName.SQUARE_METRE));
		unitAssignment.getUnits().add(makeSiUnit(session, IfcUnitEnum.VOLUMEUNIT, null, IfcSIUnitName.CUBIC_METRE));

		IfcConversionBasedUnit conversionBasedUnit = session.create(IfcConversionBasedUnit.class);
		IfcDimensionalExponents dimensionalExponents = session.create(IfcDimensionalExponents.class);
		conversionBasedUnit.setDimensions(dimensionalExponents);
		IfcMeasureWithUnit measureWithUnit = session.create(IfcMeasureWithUnit.class);
		conversionBasedUnit.setConversionFactor(measureWithUnit);
		conversionBasedUnit.setUnitType(IfcUnitEnum.PLANEANGLEUNIT);
		conversionBasedUnit.setName("DEGREE");
		IfcSIUnit planeAngleUnit = makeSiUnit(session, IfcUnitEnum.PLANEANGLEUNIT, null, IfcSIUnitName.RADIAN);
		IfcPlaneAngleMeasure value = session.create(IfcPlaneAngleMeasure.class);
		value.setWrappedValue(1.745E-2f);
		measureWithUnit.setValueComponent(value);
		measureWithUnit.setUnitComponent(planeAngleUnit);
		unitAssignment.getUnits().add(planeAngleUnit);

		unitAssignment.getUnits().add(makeSiUnit(session, IfcUnitEnum.SOLIDANGLEUNIT, null, IfcSIUnitName.STERADIAN));
		unitAssignment.getUnits().add(makeSiUnit(session, IfcUnitEnum.MASSUNIT, null, IfcSIUnitName.GRAM));
		unitAssignment.getUnits().add(makeSiUnit(session, IfcUnitEnum.TIMEUNIT, null, IfcSIUnitName.SECOND));
		unitAssignment.getUnits().add(makeSiUnit(session, IfcUnitEnum.THERMODYNAMICTEMPERATUREUNIT, null, IfcSIUnitName.DEGREE_CELSIUS));
		unitAssignment.getUnits().add(makeSiUnit(session, IfcUnitEnum.LUMINOUSINTENSITYUNIT, null, IfcSIUnitName.LUMEN));
		return unitAssignment;
	}

	private IfcOwnerHistory createOwnerHistory(Session session) {
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

	private IfcSIUnit makeSiUnit(Session session, IfcUnitEnum unitEnum, IfcSIPrefix siPrefix, IfcSIUnitName siUnitName) {
		IfcSIUnit siUnit = session.create(IfcSIUnit.class);
		siUnit.setPrefix(siPrefix);
		siUnit.setUnitType(unitEnum);
		siUnit.setName(siUnitName);
		return siUnit;
	}

	private IfcGloballyUniqueId makeGuid(Session session, String guid) {
		IfcGloballyUniqueId ifcGloballyUniqueId = session.create(IfcGloballyUniqueId.class);
		ifcGloballyUniqueId.setWrappedValue(guid);
		return ifcGloballyUniqueId;
	}
}