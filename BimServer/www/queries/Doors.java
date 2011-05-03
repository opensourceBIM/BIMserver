/*
 * This example fetches all stories from the model, 
 * orders them by elevation, selects the second floor, 
 * iterates over all doors, and print the doors higher than 2 meters
 * 
 * Example file: AC9R1-Haus-G-H-Ver2-2x3.ifc
 */

package org.bimserver.querycompiler;

import java.io.PrintWriter;
import org.bimserver.ifc.IfcModel;
import java.util.*;
import org.bimserver.ifc.emf.Ifc2x3.*;

public class Query implements QueryInterface {

	private IfcModel model;
	private PrintWriter out;

	@Override
	public void query(IfcModel model, PrintWriter out) {
        List<IfcBuildingStorey> stories = model.getAll(IfcBuildingStorey.class);
        Map<Float, IfcBuildingStorey> orderedStories = new TreeMap<Float, IfcBuildingStorey>();
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
                        }
            		}
            	}
            }
        }
	}
}