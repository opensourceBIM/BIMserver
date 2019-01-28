package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

import org.bimserver.emf.IfcModelInterface;

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
				return o1.getModelMetaData().getDate().compareTo(o2.getModelMetaData().getDate());
			}
		});
		this.clear();
		for (IfcModelInterface ifcModel : tmpList) {
			add(ifcModel);
		}
	}
}