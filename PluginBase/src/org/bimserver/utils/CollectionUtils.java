package org.bimserver.utils;

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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionUtils {
	public static <A> Set<A> mapToSet(Map<?, A> map) {
		Set<A> set = new HashSet<A>();
		for (A a : map.values()) {
			set.add(a);
		}
		return set;
	}

	public static <A> Set<A> singleSet(A object) {
		HashSet<A> set = new HashSet<A>();
		set.add(object);
		return set;
	}

	public static <T> List<T> setToList(Set<T> set) {
		List<T> list = new ArrayList<T>();
		for (T t : set) {
			list.add(t);
		}
		return list;
	}

	public static <K, V> List<V> mapToList(Map<K, V> result) {
		List<V> list = new ArrayList<V>();
		for (V v : result.values()) {
			list.add(v);
		}
		return list;
	}
}
