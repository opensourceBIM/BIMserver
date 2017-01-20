package org.bimserver.unittests;

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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
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

	public IfcWall createWall(IfcModelInterface model) throws IfcModelInterfaceException {
		IfcWall wall = model.create(IfcWall.class);
		wall.setGlobalId(makeGuid(model, "3Ep4r0uuX5ywPYOUG2H2A4"));
		wall.setOwnerHistory(ownerHistory);
		wall.setName("Wall xyz");
		wall.setDescription("Description of Wall");

		IfcAxis2Placement3D axis2Placement3D = model.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(model, 0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(model, 0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(model, 1f, 0f, 0f));

		IfcLocalPlacement localPlacement = model.create(IfcLocalPlacement.class);
		localPlacement.setRelativePlacement(axis2Placement3D);
		localPlacement.setPlacementRelTo(buildingStoreyLocalPlacement);

		wall.setObjectPlacement(localPlacement);

		IfcShapeRepresentation brep = model.create(IfcShapeRepresentation.class);
		brep.setRepresentationIdentifier("Body");
		brep.setRepresentationType("Brep");
		brep.setContextOfItems(geometricContext);

		IfcClosedShell closedShell = model.create(IfcClosedShell.class);

		IfcCartesianPoint p1 = makeCartesianPoint(model, 0f, 0f, 0f);
		IfcCartesianPoint p2 = makeCartesianPoint(model, 0f, 200f, 0f);
		IfcCartesianPoint p3 = makeCartesianPoint(model, 5400f, 200f, 0f);
		IfcCartesianPoint p4 = makeCartesianPoint(model, 5400f, 0f, 0f);
		IfcCartesianPoint p5 = makeCartesianPoint(model, 0f, 0f, 5000f);
		IfcCartesianPoint p6 = makeCartesianPoint(model, 5400f, 0f, 5000f);
		IfcCartesianPoint p7 = makeCartesianPoint(model, 5400f, 200f, 5000f);
		IfcCartesianPoint p8 = makeCartesianPoint(model, 0, 200f, 5000f);

		closedShell.getCfsFaces().add(makeFace(model, p1, p2, p3, p4));
		closedShell.getCfsFaces().add(makeFace(model, p5, p6, p7, p8));
		closedShell.getCfsFaces().add(makeFace(model, p1, p5, p8, p2));
		closedShell.getCfsFaces().add(makeFace(model, p2, p8, p7, p3));
		closedShell.getCfsFaces().add(makeFace(model, p3, p7, p6, p4));
		closedShell.getCfsFaces().add(makeFace(model, p4, p6, p5, p1));
		IfcFacetedBrep facetedBrep = model.create(IfcFacetedBrep.class);
		facetedBrep.setOuter(closedShell);
		brep.getItems().add(facetedBrep);

		IfcBoundingBox boundingBox = model.create(IfcBoundingBox.class);
		boundingBox.setCorner(makeCartesianPoint(model, 0f, 0f, 0f));
		boundingBox.setXDim(5400f);
		boundingBox.setYDim(200f);
		boundingBox.setZDim(5000f);

		IfcShapeRepresentation box = model.create(IfcShapeRepresentation.class);
		box.setRepresentationIdentifier("Box");
		box.setRepresentationType("BoundingBox");
		box.setContextOfItems(geometricContext);
		box.getItems().add(boundingBox);

		IfcProductDefinitionShape productDefinitionShape = model.create(IfcProductDefinitionShape.class);
		productDefinitionShape.getRepresentations().add(brep);
		productDefinitionShape.getRepresentations().add(box);

		wall.setRepresentation(productDefinitionShape);

		return wall;
	}

	private IfcFace makeFace(IfcModelInterface model, IfcCartesianPoint... cartesianPoints) throws IfcModelInterfaceException {
		IfcFace face = model.create(IfcFace.class);
		IfcPolyLoop polyLoop = model.create(IfcPolyLoop.class);
		for (IfcCartesianPoint ifcCartesianPoint : cartesianPoints) {
			polyLoop.getPolygon().add(ifcCartesianPoint);
		}
		IfcFaceOuterBound faceOuterBound = model.create(IfcFaceOuterBound.class);
		faceOuterBound.setOrientation(Tristate.TRUE);
		faceOuterBound.setBound(polyLoop);
		face.getBounds().add(faceOuterBound);
		return face;
	}

	private IfcBuildingStorey createBuildingStorey(IfcModelInterface model) throws IfcModelInterfaceException {
		IfcBuildingStorey buildingStorey = model.create(IfcBuildingStorey.class);
		buildingStorey.setGlobalId(makeGuid(model, "36_p3GiZXEHxQ3gWcOhQPE"));
		buildingStorey.setName("Default Building Storey");
		buildingStorey.setLongName("Description of Default Building Storey");
		buildingStorey.setOwnerHistory(ownerHistory);
		buildingStorey.setCompositionType(IfcElementCompositionEnum.ELEMENT);

		IfcAxis2Placement3D axis2Placement3D = model.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(model, 0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(model, 0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(model, 1f, 0f, 0f));

		buildingStoreyLocalPlacement = model.create(IfcLocalPlacement.class);
		buildingStoreyLocalPlacement.setRelativePlacement(axis2Placement3D);
		buildingStorey.setObjectPlacement(buildingStoreyLocalPlacement);

		IfcRelContainedInSpatialStructure containedInSpatialStructure = model.create(IfcRelContainedInSpatialStructure.class);
		containedInSpatialStructure.setGlobalId(makeGuid(model, "2m$RhK6IP2zh0BtKz5RbtU"));
		containedInSpatialStructure.setName("Default Building");
		containedInSpatialStructure.setDescription("Description of Default Building");
		containedInSpatialStructure.setOwnerHistory(ownerHistory);
		containedInSpatialStructure.setRelatingStructure(buildingStorey);
		containedInSpatialStructure.getRelatedElements().add(createWall(model));

		return buildingStorey;
	}

	private IfcBuilding createBuilding(IfcModelInterface model) throws IfcModelInterfaceException {
		IfcBuilding building = model.create(IfcBuilding.class);
		building.setGlobalId(makeGuid(model, "1MW5jGD1fBiRPPs7T9I5O8"));
		building.setName("Default Building");
		building.setLongName("Description of Default Building");
		building.setOwnerHistory(ownerHistory);
		building.setCompositionType(IfcElementCompositionEnum.ELEMENT);

		IfcAxis2Placement3D axis2Placement3D = model.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(model, 0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(model, 0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(model, 1f, 0f, 0f));

		IfcLocalPlacement localPlacement = model.create(IfcLocalPlacement.class);
		localPlacement.setRelativePlacement(axis2Placement3D);
		building.setObjectPlacement(localPlacement);

		IfcRelAggregates buildingBuildingStorey = model.create(IfcRelAggregates.class);
		buildingBuildingStorey.setRelatingObject(building);
		buildingBuildingStorey.getRelatedObjects().add(createBuildingStorey(model));

		return building;
	}

	private IfcSite createSite(IfcModelInterface model) throws IfcModelInterfaceException {
		IfcSite site = model.create(IfcSite.class);
		site.setGlobalId(makeGuid(model, "0X4tGlJqHCcwlHMZaCq8EN"));
		site.setDescription("Default Site");
		site.setLongName("Description of Default Site");
		site.setOwnerHistory(ownerHistory);

		IfcAxis2Placement3D axis2Placement3D = model.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(makeCartesianPoint(model, 0f, 0f, 0f));
		axis2Placement3D.setAxis(makeDirection(model, 0f, 0f, 1f));
		axis2Placement3D.setRefDirection(makeDirection(model, 1f, 0f, 0f));

		IfcLocalPlacement localPlacement = model.create(IfcLocalPlacement.class);
		localPlacement.setRelativePlacement(axis2Placement3D);
		site.setObjectPlacement(localPlacement);
		site.setCompositionType(IfcElementCompositionEnum.ELEMENT);
		site.getRefLatitude().add(24L);
		site.getRefLatitude().add(28L);
		site.getRefLatitude().add(0L);
		site.getRefLongitude().add(54L);
		site.getRefLongitude().add(25L);
		site.getRefLongitude().add(0L);

		IfcRelAggregates buildingBuildingStorey = model.create(IfcRelAggregates.class);
		buildingBuildingStorey.setRelatingObject(site);
		buildingBuildingStorey.getRelatedObjects().add(createBuilding(model));

		return site;
	}

	public void createIfcProject(IfcModelInterface model) throws IfcModelInterfaceException {
		IfcProject project = model.create(IfcProject.class);
		project.setGlobalId(makeGuid(model, "2o1ykWxGT4ZxPjHNe4gayR"));
		project.setName("Default Project");
		project.setDescription("Description of Default Project");
		project.setOwnerHistory(createOwnerHistory(model));
		project.setUnitsInContext(createUnits(model));
		geometricContext = createGeometricContext(model);
		project.getRepresentationContexts().add(geometricContext);

		IfcRelAggregates buildingBuildingStorey = model.create(IfcRelAggregates.class);
		buildingBuildingStorey.setRelatingObject(project);
		buildingBuildingStorey.getRelatedObjects().add(createSite(model));
	}

	private IfcCartesianPoint makeCartesianPoint(IfcModelInterface model, double x, double y, double z) throws IfcModelInterfaceException {
		IfcCartesianPoint point = model.create(IfcCartesianPoint.class);
		point.getCoordinates().add(x);
		point.getCoordinates().add(y);
		point.getCoordinates().add(z);
		return point;
	}

	private IfcDirection makeDirection(IfcModelInterface model, double x, double y, double z) throws IfcModelInterfaceException {
		IfcDirection direction = model.create(IfcDirection.class);
		direction.getDirectionRatios().add(x);
		direction.getDirectionRatios().add(y);
		direction.getDirectionRatios().add(z);
		return direction;
	}

	private IfcGeometricRepresentationContext createGeometricContext(IfcModelInterface model) throws IfcModelInterfaceException {
		IfcCartesianPoint cartesianPoint = model.create(IfcCartesianPoint.class);
		IfcAxis2Placement3D axis2Placement3D = model.create(IfcAxis2Placement3D.class);
		axis2Placement3D.setLocation(cartesianPoint);

		IfcGeometricRepresentationContext geometricRepresentationContext = model.create(IfcGeometricRepresentationContext.class);
		geometricRepresentationContext.setContextType("Model");
		geometricRepresentationContext.setCoordinateSpaceDimension(3);
		geometricRepresentationContext.setPrecision(1.000E-5f);
		geometricRepresentationContext.setWorldCoordinateSystem(axis2Placement3D);
		return geometricRepresentationContext;
	}

	private IfcUnitAssignment createUnits(IfcModelInterface model) throws IfcModelInterfaceException {
		IfcUnitAssignment unitAssignment = model.create(IfcUnitAssignment.class);
		unitAssignment.getUnits().add(makeSiUnit(model, IfcUnitEnum.LENGTHUNIT, IfcSIPrefix.MILLI, IfcSIUnitName.METRE));
		unitAssignment.getUnits().add(makeSiUnit(model, IfcUnitEnum.AREAUNIT, null, IfcSIUnitName.SQUARE_METRE));
		unitAssignment.getUnits().add(makeSiUnit(model, IfcUnitEnum.VOLUMEUNIT, null, IfcSIUnitName.CUBIC_METRE));

		IfcConversionBasedUnit conversionBasedUnit = model.create(IfcConversionBasedUnit.class);
		IfcDimensionalExponents dimensionalExponents = model.create(IfcDimensionalExponents.class);
		conversionBasedUnit.setDimensions(dimensionalExponents);
		IfcMeasureWithUnit measureWithUnit = model.create(IfcMeasureWithUnit.class);
		conversionBasedUnit.setConversionFactor(measureWithUnit);
		conversionBasedUnit.setUnitType(IfcUnitEnum.PLANEANGLEUNIT);
		conversionBasedUnit.setName("DEGREE");
		IfcSIUnit planeAngleUnit = makeSiUnit(model, IfcUnitEnum.PLANEANGLEUNIT, null, IfcSIUnitName.RADIAN);
		IfcPlaneAngleMeasure value = model.create(IfcPlaneAngleMeasure.class);
		value.setWrappedValue(1.745E-2f);
		measureWithUnit.setValueComponent(value);
		measureWithUnit.setUnitComponent(planeAngleUnit);
		unitAssignment.getUnits().add(planeAngleUnit);

		unitAssignment.getUnits().add(makeSiUnit(model, IfcUnitEnum.SOLIDANGLEUNIT, null, IfcSIUnitName.STERADIAN));
		unitAssignment.getUnits().add(makeSiUnit(model, IfcUnitEnum.MASSUNIT, null, IfcSIUnitName.GRAM));
		unitAssignment.getUnits().add(makeSiUnit(model, IfcUnitEnum.TIMEUNIT, null, IfcSIUnitName.SECOND));
		unitAssignment.getUnits().add(makeSiUnit(model, IfcUnitEnum.THERMODYNAMICTEMPERATUREUNIT, null, IfcSIUnitName.DEGREE_CELSIUS));
		unitAssignment.getUnits().add(makeSiUnit(model, IfcUnitEnum.LUMINOUSINTENSITYUNIT, null, IfcSIUnitName.LUMEN));
		return unitAssignment;
	}

	private IfcOwnerHistory createOwnerHistory(IfcModelInterface model) throws IfcModelInterfaceException {
		IfcPerson person = model.create(IfcPerson.class);
		person.setId("ID001");
		person.setFamilyName("Bonsma");
		person.setGivenName("Peter");

		IfcOrganization organization = model.create(IfcOrganization.class);
		organization.setName("TNO");
		organization.setDescription("TNO Building Innovation");

		IfcPersonAndOrganization personAndOrganization = model.create(IfcPersonAndOrganization.class);
		personAndOrganization.setThePerson(person);
		personAndOrganization.setTheOrganization(organization);

		IfcApplication application = model.create(IfcApplication.class);
		application.setApplicationDeveloper(organization);
		application.setVersion("0.10");
		application.setApplicationIdentifier("TA 1001");
		application.setApplicationFullName("Test Application");

		ownerHistory = model.create(IfcOwnerHistory.class);
		ownerHistory.setOwningApplication(application);
		ownerHistory.setChangeAction(IfcChangeActionEnum.ADDED);
		ownerHistory.setCreationDate(1232965595);
		ownerHistory.setOwningUser(personAndOrganization);
		return ownerHistory;
	}

	private IfcSIUnit makeSiUnit(IfcModelInterface model, IfcUnitEnum unitEnum, IfcSIPrefix siPrefix, IfcSIUnitName siUnitName) throws IfcModelInterfaceException {
		IfcSIUnit siUnit = model.create(IfcSIUnit.class);
		siUnit.setPrefix(siPrefix);
		siUnit.setUnitType(unitEnum);
		siUnit.setName(siUnitName);
		return siUnit;
	}

	private String makeGuid(IfcModelInterface model, String guid) {
		return guid;
	}
}