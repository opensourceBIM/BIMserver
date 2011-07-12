package org.bimserver.shared;

import java.util.ArrayList;
import java.util.List;

public class SRevisionSummary {
	private List<SRevisionSummaryContainer> list = new ArrayList<SRevisionSummaryContainer>();

	public SRevisionSummary() {
		SRevisionSummaryContainer ifcEntities = new SRevisionSummaryContainer();
		ifcEntities.setName("IFC Entities");
		list.add(ifcEntities);

		SRevisionSummaryContainer ifcRelations = new SRevisionSummaryContainer();
		ifcRelations.setName("IFC Relations");
		list.add(ifcRelations);

		SRevisionSummaryContainer ifcPrimitives = new SRevisionSummaryContainer();
		ifcPrimitives.setName("IFC Primitives");
		list.add(ifcPrimitives);
		
		SRevisionSummaryContainer ifcRest = new SRevisionSummaryContainer();
		ifcRest.setName("Rest");
		list.add(ifcRest);
	}

	public List<SRevisionSummaryContainer> getList() {
		return list;
	}

	public void setList(List<SRevisionSummaryContainer> list) {
		this.list = list;
	}

	public SRevisionSummaryContainer get(String string) {
		for (SRevisionSummaryContainer container : list) {
			if (container.getName().equals(string)) {
				return container;
			}
		}
		return null;
	}
}