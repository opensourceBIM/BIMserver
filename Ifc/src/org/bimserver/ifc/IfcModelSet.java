package org.bimserver.ifc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

import org.bimserver.plugins.serializers.IfcModelInterface;

public class IfcModelSet extends LinkedHashSet<IfcModelInterface> {
	private static final long serialVersionUID = 7322433737304593455L;

	public IfcModelSet(IfcModelInterface... models) {
		for (IfcModelInterface model : models) {
			add(model);
		}
	}
	
	public void sortByDate() {
		ArrayList<IfcModelInterface> tmpList = new ArrayList<IfcModelInterface>(this);
		Collections.sort(tmpList, new Comparator<IfcModelInterface>() {
			@Override
			public int compare(IfcModelInterface o1, IfcModelInterface o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		this.clear();
		for (IfcModelInterface ifcModel : tmpList) {
			add(ifcModel);
		}
	}
}