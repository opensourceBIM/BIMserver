package org.bimserver.validationreport;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.shared.ModelColorizer;
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
		ModelColorizer modelColorizer = new ModelColorizer(model);
		for (Item item : items) {
			if (item instanceof Line) {
				Line line = (Line)item;
				if (line.getOid() != -1) {
					// This is about a specific object
					IdEObject idEObject = model.get(line.getOid());
					if (idEObject instanceof IfcProduct) {
						IfcProduct ifcProduct = (IfcProduct)idEObject;
						if (line.getType() == Type.SUCCESS) {
							// Make it transparent
							modelColorizer.makeTransparent(ifcProduct);
						} else {
							// Do nothing
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