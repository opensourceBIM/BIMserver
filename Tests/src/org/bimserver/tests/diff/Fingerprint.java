package org.bimserver.tests.diff;

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

import java.util.Arrays;

public class Fingerprint {
	private final int[] data;
	private int position;
	private final int[] permutationIndices;
	
	public Fingerprint(int nrVertices) {
		data = new int[nrVertices * nrVertices];
		this.permutationIndices = createDefaultPermutationIndices();
	}
	
	private int[] createDefaultPermutationIndices() {
		int[] indices = new int[(int) Math.sqrt(data.length)];
		for (int i=0; i<indices.length; i++) {
			indices[i] = i;
		}
		return indices;
	}

	public Fingerprint(int[] permutationIndices, int nrVertices) {
		data = new int[nrVertices * nrVertices];
		this.permutationIndices = permutationIndices;
	}
	
	public int[] getPermutationIndices() {
		return permutationIndices;
	}
	
	public boolean isHigher(Fingerprint other) {
		for (int i=0; i<data.length; i++) {
			if (data[i] > other.data[i]) {
				return true;
			} else if (data[i] < other.data[i]) {
				return false;
			}
		}
		return false;
	}

	public int get(int i) {
		return data[i];
	}

	public void add(int val) {
		data[position++] = val;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fingerprint other = (Fingerprint) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (position != other.position)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<data.length; i++) {
			sb.append(data[i] + (i < data.length - 1 ? ", " : ""));
		}
		sb.append(" - " + permutationIndices.length);
		return sb.toString();
	}
}
