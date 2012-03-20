package org.bimserver.tests.diff;

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
		int[] indices = new int[data.length];
		for (int i=0; i<data.length; i++) {
			indices[i] = i;
		}
		return indices;
	}

	public Fingerprint(int[] permutationIndices, int nrVertices) {
		this.permutationIndices = permutationIndices;
		data = new int[nrVertices * nrVertices];
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
			sb.append(data[i] + (i < data.length ? ", " : ""));
		}
		return sb.toString();
	}
}
