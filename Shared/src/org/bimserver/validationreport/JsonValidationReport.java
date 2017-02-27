package org.bimserver.validationreport;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Charsets;

public class JsonValidationReport implements IssueInterface {

	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private final List<Item> items = new ArrayList<Item>();
	private final Map<String, Boolean> checkResults = new HashMap<>();

	public JsonValidationReport() {
	}

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

	public ObjectNode toJson(ObjectMapper OBJECT_MAPPER) {
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		ArrayNode itemsJson = OBJECT_MAPPER.createArrayNode();
		ObjectNode checks = OBJECT_MAPPER.createObjectNode();
		result.set("checks", checks);
		result.set("items", itemsJson);
		for (Item item : items) {
			itemsJson.add(item.toJson(OBJECT_MAPPER));
		}
		for (String identifier : checkResults.keySet()) {
			checks.put(identifier, checkResults.get(identifier));
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
	
	public void add(Type messageType, String type, String guid, long oid, String key, String is, String shouldBe) {
		items.add(new Line(messageType, oid, key, is, shouldBe));
	}

	public Issue add(Type messageType, String type, String guid, Long oid, String key, Object is, String shouldBe) {
		Line line = new Line(messageType, oid, key, is == null ? "" : is.toString(), shouldBe);
		items.add(line);
		return line;
	}
	
	@Override
	public void add(Type messageType, String message, Object is, String shouldBe) throws IssueException {
		add(messageType, null, null, null, message, is, shouldBe);
	}

	@Override
	public byte[] getBytes() {
		return toJson(OBJECT_MAPPER).toString().getBytes(Charsets.UTF_8);
	}

	@Override
	public void validate() throws IssueValidationException {
		// Nothing to validate
	}

	@Override
	public void setCheckValid(String identifier, boolean valid) {
		checkResults.put(identifier, valid);
	}

	@Override
	public boolean isValid() {
		for (Item item : items) {
			if (item instanceof Line) {
				Line line = (Line)item;
				if (line.getType() == Type.ERROR) {
					return false;
				}
			}
		}
		return true;
	}

	public List<Item> getErrors() {
		List<Item> list = new ArrayList<>();
		for (Item item : items) {
			if (item.getType() == Type.ERROR) {
				list.add(item);
			}
		}
		return list;
	}
}
