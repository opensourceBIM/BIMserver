package org.bimserver.utils;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcApplication;
import org.bimserver.models.ifc2x3tc1.IfcArbitraryClosedProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3tc1.IfcBuilding;
import org.bimserver.models.ifc2x3tc1.IfcCartesianPoint;
import org.bimserver.models.ifc2x3tc1.IfcChangeActionEnum;
import org.bimserver.models.ifc2x3tc1.IfcDirection;
import org.bimserver.models.ifc2x3tc1.IfcElementCompositionEnum;
import org.bimserver.models.ifc2x3tc1.IfcExtrudedAreaSolid;
import org.bimserver.models.ifc2x3tc1.IfcGeometricRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcOrganization;
import org.bimserver.models.ifc2x3tc1.IfcOwnerHistory;
import org.bimserver.models.ifc2x3tc1.IfcPerson;
import org.bimserver.models.ifc2x3tc1.IfcPersonAndOrganization;
import org.bimserver.models.ifc2x3tc1.IfcPolyline;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcProfileTypeEnum;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationContext;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitAssignment;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;
import org.bimserver.shared.GuidCompressor;
import org.eclipse.emf.common.util.EList;

public class RichIfcModel {

	private IfcModelInterface model;
	private IfcOwnerHistory defaultOwnerHistory;
	private IfcRepresentationContext defaultRepresentationContext;
	private boolean addOnCreate;

	public RichIfcModel(IfcModelInterface model, boolean addOnCreate) {
		this.model = model;
		this.addOnCreate = addOnCreate;
	}

	/**
	 * Create a decomposes relationship
	 * 
	 * @param parent The object that represents the nest or aggregation
	 * @param children The objects being nested or aggregated
	 * @throws IfcModelInterfaceException
	 */
	public void addDecomposes(IfcObjectDefinition parent, IfcObjectDefinition... children) throws IfcModelInterfaceException {
		IfcRelAggregates ifcRelAggregates = this.create(IfcRelAggregates.class);
		ifcRelAggregates.setRelatingObject(parent);
		for (IfcObjectDefinition child: children) {
			ifcRelAggregates.getRelatedObjects().add(child);
		}
	}

	public void addContains(IfcSpatialStructureElement parent, IfcProduct... children) throws IfcModelInterfaceException {
		IfcRelContainedInSpatialStructure rel = this.create(IfcRelContainedInSpatialStructure.class);
		rel.setRelatingStructure(parent);
		for (IfcProduct child: children) {
			rel.getRelatedElements().add(child);
		}
	}
	
	public <T extends IdEObject> T create(Class<T> clazz) throws IfcModelInterfaceException {
		T object = model.create(clazz);
		if (object instanceof IfcRoot) {
			((IfcRoot)object).setGlobalId(GuidCompressor.getNewIfcGloballyUniqueId());
			if (defaultOwnerHistory != null) {
				((IfcRoot)object).setOwnerHistory(defaultOwnerHistory);
			}
		}
		if (addOnCreate) {
			model.add(object.getOid(), object);
		}
		return object;
	}

	public void setDefaultOwnerHistory(IfcOwnerHistory ownerHistory) {
		this.defaultOwnerHistory = ownerHistory;
	}

	public IfcCartesianPoint createIfcCartesianPoint(double i, double j, double k) throws IfcModelInterfaceException {
		IfcCartesianPoint ifcCartesianPoint = create(IfcCartesianPoint.class);
		EList<Double> coordinates = ifcCartesianPoint.getCoordinates();
		coordinates.add(i);
		coordinates.add(j);
		coordinates.add(k);
		return ifcCartesianPoint;
	}

	public IfcAxis2Placement3D createBasicPosition(double i, double j, double k) throws IfcModelInterfaceException {
		IfcAxis2Placement3D axisPlacement = create(IfcAxis2Placement3D.class);
		axisPlacement.setLocation(createIfcCartesianPoint(i, j, k));
		
		IfcDirection axis = createDirection(0, 0, 1);
		IfcDirection direction = createDirection(1, 0, 0);
		
		axisPlacement.setAxis(axis);
		axisPlacement.setRefDirection(direction);
		return axisPlacement;
	}

	public IfcDirection createDirection(double i, double j, double k) throws IfcModelInterfaceException {
		IfcDirection ifcDirection = create(IfcDirection.class);
		EList<Double> directionRatios = ifcDirection.getDirectionRatios();
		directionRatios.add(i);
		directionRatios.add(j);
		directionRatios.add(k);
		return ifcDirection;
	}

	public IfcUnit createIfcSiUnit(IfcUnitEnum lengthunit, IfcSIPrefix milli, IfcSIUnitName metre) throws IfcModelInterfaceException {
		IfcSIUnit ifcSIUnit = create(IfcSIUnit.class);
		ifcSIUnit.setName(metre);
		ifcSIUnit.setPrefix(milli);
		ifcSIUnit.setUnitType(lengthunit);
		return ifcSIUnit;
	}

	public IfcBuilding createDefaultProjectStructure(double x, double y, double z) throws IfcModelInterfaceException {
		IfcPerson person = create(IfcPerson.class);
		IfcOrganization organization = create(IfcOrganization.class);
		organization.setName("Required");
		
		IfcPersonAndOrganization owningUser = create(IfcPersonAndOrganization.class);
		owningUser.setTheOrganization(organization);
		owningUser.setThePerson(person);
		
		IfcOrganization developer = create(IfcOrganization.class);
		developer.setName("Required");
		
		IfcApplication application = create(IfcApplication.class);
		application.setApplicationDeveloper(developer);
		application.setApplicationFullName("Required");
		application.setApplicationIdentifier("Required");
		application.setVersion("1.0");
		
		IfcOwnerHistory ownerHistory = create(IfcOwnerHistory.class);
		ownerHistory.setChangeAction(IfcChangeActionEnum.ADDED);
		ownerHistory.setCreationDate(System.currentTimeMillis() / 1000);
		ownerHistory.setOwningApplication(application);
		ownerHistory.setOwningUser(owningUser);
		
		setDefaultOwnerHistory(ownerHistory);
		
		IfcAxis2Placement3D contextAxisPlacement = create(IfcAxis2Placement3D.class);
		contextAxisPlacement.setLocation(createIfcCartesianPoint(x, y, z));
		
		IfcGeometricRepresentationContext representationContext = create(IfcGeometricRepresentationContext.class);
		representationContext.setCoordinateSpaceDimension(3);
		representationContext.setPrecision(0.00001);
		representationContext.setWorldCoordinateSystem(contextAxisPlacement);
		representationContext.setContextType("Model");
		setDefaultRepresentationContext(representationContext);
		
		IfcUnitAssignment ifcUnitAssigment = create(IfcUnitAssignment.class);
		
		ifcUnitAssigment.getUnits().add(createIfcSiUnit(IfcUnitEnum.LENGTHUNIT, IfcSIPrefix.MILLI, IfcSIUnitName.METRE));
		ifcUnitAssigment.getUnits().add(createIfcSiUnit(IfcUnitEnum.VOLUMEUNIT, IfcSIPrefix.NULL, IfcSIUnitName.CUBIC_METRE));
		ifcUnitAssigment.getUnits().add(createIfcSiUnit(IfcUnitEnum.PLANEANGLEUNIT, IfcSIPrefix.NULL, IfcSIUnitName.RADIAN));
		ifcUnitAssigment.getUnits().add(createIfcSiUnit(IfcUnitEnum.SOLIDANGLEUNIT, IfcSIPrefix.NULL, IfcSIUnitName.STERADIAN));
		ifcUnitAssigment.getUnits().add(createIfcSiUnit(IfcUnitEnum.MASSUNIT, IfcSIPrefix.NULL, IfcSIUnitName.GRAM));
		ifcUnitAssigment.getUnits().add(createIfcSiUnit(IfcUnitEnum.TIMEUNIT, IfcSIPrefix.NULL, IfcSIUnitName.SECOND));
		ifcUnitAssigment.getUnits().add(createIfcSiUnit(IfcUnitEnum.THERMODYNAMICTEMPERATUREUNIT, IfcSIPrefix.NULL, IfcSIUnitName.DEGREE_CELSIUS));
		ifcUnitAssigment.getUnits().add(createIfcSiUnit(IfcUnitEnum.LUMINOUSINTENSITYUNIT, IfcSIPrefix.NULL, IfcSIUnitName.LUMEN));
		
		IfcProject ifcProject = create(IfcProject.class);
		ifcProject.getRepresentationContexts().add(representationContext);
		ifcProject.setUnitsInContext(ifcUnitAssigment);
		ifcProject.setName("Demo Project");
		
		IfcSite ifcSite = create(IfcSite.class);
		ifcSite.setCompositionType(IfcElementCompositionEnum.ELEMENT);
		ifcSite.setName("Default site");

		IfcBuilding ifcBuilding = create(IfcBuilding.class);
		ifcBuilding.setCompositionType(IfcElementCompositionEnum.ELEMENT);
		ifcBuilding.setName("Default building");
		
		addDecomposes(ifcProject, ifcSite);
		addDecomposes(ifcSite, ifcBuilding);
		
		return ifcBuilding;
	}

	public IfcProductRepresentation createRectangularExtrusionProductRepresentation(double width, double depth, double height) throws IfcModelInterfaceException {
		IfcPolyline ifcPolyline = create(IfcPolyline.class);
		EList<IfcCartesianPoint> points = ifcPolyline.getPoints();
		points.add(createIfcCartesianPoint(0, 0, 0));
		points.add(createIfcCartesianPoint(width, 0, 0));
		points.add(createIfcCartesianPoint(width, depth, 0));
		points.add(createIfcCartesianPoint(0, depth, 0));
		points.add(createIfcCartesianPoint(0, 0, 0));
		
		IfcArbitraryClosedProfileDef def = create(IfcArbitraryClosedProfileDef.class);
		def.setProfileType(IfcProfileTypeEnum.AREA);
		def.setOuterCurve(ifcPolyline);
		
		IfcExtrudedAreaSolid extrudedAreaSolid = create(IfcExtrudedAreaSolid.class);
		extrudedAreaSolid.setDepth(height);
		extrudedAreaSolid.setSweptArea(def);
		extrudedAreaSolid.setPosition(createBasicPosition(0, 0, 0));
		extrudedAreaSolid.setExtrudedDirection(createDirection(0, 0, 1));
		
		IfcProductRepresentation productRepresentation = create(IfcProductRepresentation.class);
		IfcShapeRepresentation shapeRepresentation = create(IfcShapeRepresentation.class);
		if (defaultRepresentationContext != null) {
			shapeRepresentation.setContextOfItems(defaultRepresentationContext);
		}
		shapeRepresentation.setRepresentationType("SweptSolid");
		shapeRepresentation.setRepresentationIdentifier("Body");
		shapeRepresentation.getItems().add(extrudedAreaSolid);
		productRepresentation.getRepresentations().add(shapeRepresentation);
		
		return productRepresentation;
	}
	
	public void setDefaultRepresentationContext(IfcRepresentationContext defaultRepresentationContext) {
		this.defaultRepresentationContext = defaultRepresentationContext;
	}
	
	public IfcOwnerHistory getDefaultOwnerHistory() {
		return defaultOwnerHistory;
	}
	
	public IfcRepresentationContext getDefaultRepresentationContext() {
		return defaultRepresentationContext;
	}
}