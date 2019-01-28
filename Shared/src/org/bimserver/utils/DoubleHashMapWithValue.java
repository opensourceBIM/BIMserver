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

public class DoubleHashMapWithValue<A, B, C> {
	private Map<A, B> ab;
	private Map<B, A> ba;
	private Map<A, C> ac;
	
	public DoubleHashMapWithValue(int capacity) {
		ab = new HashMap<A, B>(capacity);
		ba = new HashMap<B, A>(capacity);
		ac = new HashMap<A, C>(capacity);
	}
	
	public void put(A a, B b, C c) {
		ab.put(a, b);
		ba.put(b, a);
		ac.put(a, c);
	}
	
	public boolean containsA(A a) {
		return ab.containsKey(a);
	}
	
	public boolean containsB(B b) {
		return ba.containsKey(b);
	}
	
	public C getC(A a) {
		return ac.get(a);
	}

	public B getB(A a) {
		return ab.get(a);
	}
}