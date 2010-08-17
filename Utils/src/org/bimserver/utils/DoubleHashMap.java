package org.bimserver.utils;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
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
