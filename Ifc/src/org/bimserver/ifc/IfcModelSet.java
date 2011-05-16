package org.bimserver.ifc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class IfcModelSet extends LinkedHashSet<IfcModel> {
	private static final long serialVersionUID = 7322433737304593455L;

	public IfcModelSet(IfcModel... models) {
		for (IfcModel model : models) {
			add(model);
		}
	}
	
	public void sortByDate() {
		ArrayList<IfcModel> tmpList = new ArrayList<IfcModel>(this);
		Collections.sort(tmpList, new Comparator<IfcModel>() {
			@Override
			public int compare(IfcModel o1, IfcModel o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		this.clear();
		for (IfcModel ifcModel : tmpList) {
			add(ifcModel);
		}
	}
}