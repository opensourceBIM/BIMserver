package org.bimserver.geometry.accellerator;

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

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReuseSet {

	private final Map<Integer, Set<ReuseObject>> map = new TreeMap<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}});

	public Set<Long> getListOfGeometryDataIds(int trianglesToSave) {
		// TODO since this is fixed now, it can be precomputed
		Set<Long> result = new HashSet<>();
		for (Integer key : map.keySet()) {
			Set<ReuseObject> set = map.get(key);
			for (ReuseObject reuseObject : set) {
				if (reuseObject.getSaveablePrimitives() == 0) {
					// Since it's ordered, we can return right away since we're at the end
					return result;
				}
				if (reuseObject.getSaveablePrimitives() > trianglesToSave) {
					result.add(reuseObject.getGeometryDataOid());
				} else {
					return result;
				}
			}
		}
		return result;
	}

	public void add(long geometryDataOid, int reused, int nrPrimitives) {
		ReuseObject reuseObject = new ReuseObject(geometryDataOid, reused, nrPrimitives);
		
		Set<ReuseObject> set = map.get(reuseObject.getSaveablePrimitives());
		if (set == null) {
			set = new HashSet<>();
			map.put(reuseObject.getSaveablePrimitives(), set);
		}
		set.add(reuseObject);
	}

	public void add(ReuseObject reuseObject) {
		Set<ReuseObject> set = map.get(reuseObject.getSaveablePrimitives());
		if (set == null) {
			set = new HashSet<>();
			map.put(reuseObject.getSaveablePrimitives(), set);
		}
		set.add(reuseObject);
	}
}
