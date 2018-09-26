package org.bimserver.geometry.accellerator;

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
		int savedPrimitives = 0;
		Set<Long> result = new HashSet<>();
		for (Integer key : map.keySet()) {
			Set<ReuseObject> set = map.get(key);
			for (ReuseObject reuseObject : set) {
				if (reuseObject.getSaveablePrimitives() == 0) {
					continue;
				}
				if (savedPrimitives >= trianglesToSave) {
					return result;
				}
				savedPrimitives += reuseObject.getSaveablePrimitives();
				result.add(reuseObject.getGeometryDataOid());
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
