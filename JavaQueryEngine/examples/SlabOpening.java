package org.bimserver.jqep;

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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcAreaMeasure;
import org.bimserver.models.ifc2x3tc1.IfcBuildingStorey;
import org.bimserver.models.ifc2x3tc1.IfcElement;
import org.bimserver.models.ifc2x3tc1.IfcElementQuantity;
import org.bimserver.models.ifc2x3tc1.IfcExtrudedAreaSolid;
import org.bimserver.models.ifc2x3tc1.IfcFeatureElementSubtraction;
import org.bimserver.models.ifc2x3tc1.IfcOpeningElement;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductDefinitionShape;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcProperty;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySetDefinition;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRectangleProfileDef;
import org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3tc1.IfcRelDefines;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRelVoidsElement;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcShapeRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.plugins.QueryEngineHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.emf.IfcModelInterface;

public class Query implements QueryInterface {

	@SuppressWarnings("rawtypes")
	@Override
	public void query(IfcModelInterface source, IfcModelInterface dest, Reporter reporter, QueryEngineHelper queryEngineHelper) {

		/*
		 * Checking how many element quantity is present in the given model. To
		 * ensure the model has element quantity
		 */
		List<IfcElementQuantity> qty = source.getAll(IfcElementQuantity.class);
		reporter.info("Total Element quantity in the model are " + qty.size());

		List<IfcBuildingStorey> stories = source.getAll(IfcBuildingStorey.class);
		List<IfcFeatureElementSubtraction> Opening_subjectToArea = new ArrayList<IfcFeatureElementSubtraction>();

		if (!(stories.isEmpty())) {
			for (IfcBuildingStorey storey : stories) {
				for (IfcRelContainedInSpatialStructure rel : storey.getContainsElements()) {
					for (IfcProduct product : rel.getRelatedElements()) {
						if (product instanceof IfcSlab) {
							IfcSlab tempSlab = (IfcSlab) product;
							IfcElement ifcslabElement = (IfcElement) tempSlab;
							for (IfcRelVoidsElement relVoids : ifcslabElement.getHasOpenings()) {
								Opening_subjectToArea.add(relVoids.getRelatedOpeningElement());
							}
						}
					}
				}
			}
		} else {
			reporter.info("Building stories not available...");
		}

		if (!(Opening_subjectToArea.isEmpty())) {
			reporter.info("Total Opening Element in the model which are associated to slabs are " + Opening_subjectToArea.size());
			Iterator OE_it = Opening_subjectToArea.iterator();
			while (OE_it.hasNext()) {
				IfcOpeningElement openingElement = (IfcOpeningElement) OE_it.next();
				
				IfcProductRepresentation representation = openingElement.getRepresentation();
				IfcProductDefinitionShape ifcProductDefinitionShape = (IfcProductDefinitionShape)representation;
				for (IfcRepresentation ifcRepresentation : ifcProductDefinitionShape.getRepresentations()) {
					if (ifcRepresentation instanceof IfcShapeRepresentation) {
						IfcShapeRepresentation ifcShapeRepresentation = (IfcShapeRepresentation)ifcRepresentation;
						for (IfcRepresentationItem item : ifcShapeRepresentation.getItems()) {
							if (item instanceof IfcExtrudedAreaSolid) {
								IfcExtrudedAreaSolid extrudedAreaSolid = (IfcExtrudedAreaSolid)item;
								IfcProfileDef sweptArea = extrudedAreaSolid.getSweptArea();
								if (sweptArea instanceof IfcRectangleProfileDef) {
									IfcRectangleProfileDef rectangleProfileDef = (IfcRectangleProfileDef)sweptArea;
									double area = rectangleProfileDef.getXDim() * rectangleProfileDef.getYDim();
									reporter.info("Area calculated from geometry: " + area);
								}
							}
						}
					}
				}
				
				for (IfcRelDefines ifcRelDefines : openingElement.getIsDefinedBy()) {
					if (ifcRelDefines instanceof IfcRelDefinesByProperties) {
						IfcRelDefinesByProperties ifcRelDefinesByProperties = (IfcRelDefinesByProperties) ifcRelDefines;
						IfcPropertySetDefinition relatingPropertyDefinition = ifcRelDefinesByProperties.getRelatingPropertyDefinition();
						if (relatingPropertyDefinition instanceof IfcPropertySet) {
							IfcPropertySet ifcPropertySet = (IfcPropertySet)relatingPropertyDefinition;
							for (IfcProperty ifcProperty : ifcPropertySet.getHasProperties()) {
								if (ifcProperty instanceof IfcPropertySingleValue) {
									IfcPropertySingleValue ifcPropertySingleValue = (IfcPropertySingleValue)ifcProperty;
									if (ifcPropertySingleValue.getNominalValue() instanceof IfcAreaMeasure) {
										IfcAreaMeasure ifcAreaMeasure = (IfcAreaMeasure)ifcPropertySingleValue.getNominalValue();
										reporter.info("Area from semantic: " + ifcAreaMeasure.getWrappedValue());
									}
								}
							}
						}
					}
				}
			}
		} else {
			reporter.info("No match for Opening element incorporated to slab");
		}
	}
}