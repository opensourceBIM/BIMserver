/*
 * This example fetches all stories from the model, 
 * orders them by elevation, selects the second floor, 
 * iterates over all doors, and print the doors higher than 2 meters
 * 
 * Example file: AC9R1-Haus-G-H-Ver2-2x3.ifc
 */

package org.bimserver.jqep;

import java.io.PrintWriter;

import org.bimserver.plugins.QueryEngineHelper;
import org.bimserver.plugins.Reporter;
import org.bimserver.emf.IfcModelInterface;
import java.util.*;
import org.bimserver.models.ifc2x3tc1.*;

public class Query implements QueryInterface {

	private IfcModelInterface model;

	@Override
	public void query(IfcModelInterface source, IfcModelInterface dest, Reporter reporter, QueryEngineHelper queryEngineHelper) {
		reporter.info("Running doors example");
        List<IfcBuildingStorey> stories = source.getAll(IfcBuildingStorey.class);
        Map<Double, IfcBuildingStorey> orderedStories = new TreeMap<Double, IfcBuildingStorey>();
        for (IfcBuildingStorey storey : stories) {
            orderedStories.put(storey.getElevation(), storey);
        }
        if (orderedStories.size() > 1) {
            IfcBuildingStorey firstFloor = stories.get(1);
            for (IfcRelContainedInSpatialStructure rel : firstFloor.getContainsElements()) {
            	for (IfcProduct product : rel.getRelatedElements()) {
            		if (product instanceof IfcDoor) {
            			IfcDoor ifcDoor = (IfcDoor)product;
                        if (ifcDoor.getOverallHeight() > 2) {
                        	reporter.info(ifcDoor.getName() + " " + ifcDoor.getOverallHeight());
                        	queryEngineHelper.copy(ifcDoor, dest);
                        }
            		}
            	}
            }
        }
	}
}