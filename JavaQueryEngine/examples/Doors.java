/*
 * This example fetches all stories from the model, 
 * orders them by elevation, selects the second floor, 
 * iterates over all doors, and print the doors higher than 2 meters
 * 
 * Example file: AC9R1-Haus-G-H-Ver2-2x3.ifc
 */

package org.bimserver.jqep;

import java.io.PrintWriter;
import org.bimserver.plugins.serializers.IfcModelInterface;
import java.util.*;
import org.bimserver.models.ifc2x3tc1.*;

public class Query implements QueryInterface {

	private IfcModelInterface model;
	private PrintWriter out;

	@Override
	public void query(IfcModelInterface source, IfcModelInterface dest, PrintWriter out) {
		out.println("Running doors example");
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
                            out.println(ifcDoor.getName() + " " + ifcDoor.getOverallHeight());
                            dest.add(ifcDoor);
                        }
            		}
            	}
            }
        }
	}
}