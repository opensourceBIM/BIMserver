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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DoubleHashMap<A, B> {
	private final Map<A, B> ab;
	private final Map<B, A> ba;

	public DoubleHashMap() {
		this(0);
	}
	
	public DoubleHashMap(int capacity) {
		ab = new HashMap<A, B>(capacity);
		ba = new HashMap<B, A>(capacity);
	}

	public void put(A a, B b) {
		ab.put(a, b);
		ba.put(b, a);
	}

	public boolean containsA(A a) {
		return ab.containsKey(a);
	}

	public boolean containsB(B b) {
		return ba.containsKey(b);
	}

	public B getB(A a) {
		return ab.get(a);
	}

	public A getA(B b) {
		return ba.get(b);
	}

	public Set<A> keyASet() {
		return ab.keySet();
	}

	public Set<B> keyBSet() {
		return ba.keySet();
	}
}
