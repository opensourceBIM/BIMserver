package org.bimserver.charting.Containers;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

public class Pair<K, V> {

	private final K Element;
	private final V Translation;
	
	public static <K, V> Pair<K, V> createPair(K element0, V element1) {
		return new Pair<K, V>(element0, element1);
	}

	public Pair(K element0, V element1) {
		this.Element = element0;
		this.Translation = element1;
	}

	// Left-side.
	public K getLeft() {
		return Element;
	}

	public K getElementValue() {
		return Element;
	}

	public K getWorldSpaceValue() {
		return Element;
	}

	// Right-side.
	public V getRight() {
		return Translation;
	}

	public V getTranslationValue() {
		return Translation;
	}

	public V getActualValue() {
		return Translation;
	}
}