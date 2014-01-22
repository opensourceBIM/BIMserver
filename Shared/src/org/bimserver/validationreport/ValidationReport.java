package org.bimserver.validationreport;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ValidationReport {

	private final List<Item> items = new ArrayList<Item>();

	public void addHeader(String value) {
		items.add(new Header(value));
	}

	public String toHtml(String header, String footer) {
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		for (Item item : items) {
			item.toHtml(sb);
		}
		sb.append(footer);
		return sb.toString();
	}
	
	public JSONObject toJson() throws JSONException {
		JSONObject result = new JSONObject();
		JSONArray itemsJson = new JSONArray();
		result.put("items", itemsJson);
		for (Item item : items) {
			itemsJson.put(item.toJson());
		}
		return result;
	}

	public void applyToModel(IfcModelInterface model) throws IfcModelInterfaceException {
//		ModelColorizer modelColorizer = new ModelColorizer(model);
		for (Item item : items) {
			if (item instanceof Line) {
				Line line = (Line)item;
				if (line.getOid() != -1) {
					// This is about a specific object
					IdEObject idEObject = model.get(line.getOid());
					if (idEObject instanceof IfcProduct) {
						IfcProduct product = (IfcProduct)idEObject;
						double[] colors;
						float transparency;
						if (line.getType() == Type.SUCCESS) {
							// Make it transparent
							colors = new double[]{0.2, 0.2, 0.2};
							transparency = 0.98f;
//							modelColorizer.setColor(ifcProduct, new double[]{0.2, 0.2, 0.2}, 0.98f);
						} else {
							// Do nothing
							colors = new double[]{1.0, 0.0, 0.0};
							transparency = 0f;
//							modelColorizer.setColor(ifcProduct, new double[]{1.0, 0.0, 0.0}, 0f);
						}
						
						IfcProductRepresentation productRepresentation = product.getRepresentation();
						if (productRepresentation != null) {
							for (IfcRepresentation representation : productRepresentation.getRepresentations()) {
								IfcStyledItem styledItem = model.create(IfcStyledItem.class);
								if (!representation.getItems().isEmpty()) {
									representation.getItems().set(0, styledItem);
									IfcPresentationStyleAssignment presentationStyleAssignment = model.create(IfcPresentationStyleAssignment.class);
									styledItem.getStyles().add(presentationStyleAssignment);
									IfcSurfaceStyle surfaceStyle = model.create(IfcSurfaceStyle.class);
									presentationStyleAssignment.getStyles().add(surfaceStyle);
									IfcSurfaceStyleRendering surfaceStyleRendering = model.create(IfcSurfaceStyleRendering.class);
									surfaceStyle.getStyles().add(surfaceStyleRendering);
									IfcColourRgb colourRgb = model.create(IfcColourRgb.class);
									colourRgb.setRed(colors[0]);
									colourRgb.setGreen(colors[1]);
									colourRgb.setBlue(colors[2]);
									surfaceStyleRendering.setDiffuseColour(colourRgb);
									surfaceStyleRendering.setReflectionColour(colourRgb);
									surfaceStyleRendering.setSpecularColour(colourRgb);
									surfaceStyleRendering.setSurfaceColour(colourRgb);
									surfaceStyleRendering.setTransmissionColour(colourRgb);
									surfaceStyleRendering.setTransparency(transparency);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void add(Type type, long oid, String key, String is, String shouldBe) {
		items.add(new Line(type, oid, key, is, shouldBe));
	}
}