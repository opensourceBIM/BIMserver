package org.bimserver.ifc.file.compare;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bimserver.ifc.emf.Ifc2x3.IfcRoot;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class CompareResult {
	private final Map<EClass, List<Item>> items = new TreeMap<EClass, List<Item>>(new Comparator<EClass>() {
		@Override
		public int compare(EClass arg0, EClass arg1) {
			return arg0.getName().compareTo(arg1.getName());
		}
	});

	public static enum Type {
		ADDED, DELETED, MODIFIED;
	}

	public static class Item {

		public final EObject eObject;
		public final Type type;

		public Item(EObject eObject, Type type) {
			this.eObject = eObject;
			this.type = type;
		}
	}

	public void add(EObject eObject, Type type) {
		if (!items.containsKey(eObject.eClass())) {
			items.put(eObject.eClass(), new ArrayList<Item>());
		}
		items.get(eObject.eClass()).add(new Item(eObject, type));
	}

	public Map<EClass, List<Item>> getItems() {
		return items;
	}
	
	public void print(Writer out) throws IOException {
		for (EClass eClass : items.keySet()) {
			for (Item item : items.get(eClass)) {
				String name = "";
				if (item.eObject instanceof IfcRoot) {
					IfcRoot ifcRoot = (IfcRoot) item.eObject;
					if (ifcRoot.getName() != null) {
						name = " " + ifcRoot.getName();
					} else if (ifcRoot.getGlobalId() != null) {
						name = " " + ifcRoot.getGlobalId().getWrappedValue();
					}
				}
				if (item.type == Type.ADDED) {
					out.append(item.eObject.eClass().getName() + name + " added");
				} else if (item.type == Type.DELETED) {
					out.append(item.eObject.eClass().getName() + name + " deleted");
				}
			}
		}
	}

	public void dumpShort(Writer out) throws IOException {
		for (EClass eClass : items.keySet()) {
			out.append(eClass.getName() + " " + items.get(eClass).size());
		}
	}

	public int size() {
		int size = 0;
		for (List<Item> list : items.values()) {
			size += list.size();
		}
		return size;
	}
}