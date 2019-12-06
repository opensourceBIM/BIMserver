package org.bimserver.geometry;

import java.nio.DoubleBuffer;
import java.util.Arrays;

public class ComplexLine2 implements Comparable<ComplexLine2> {

	private int index1;
	private int index2;
	private double[] v1;
	private double[] v2;

	public ComplexLine2(int index1, int index2, DoubleBuffer verticesAsDouble, float margin) {
		if (index1 > index2) {
			this.index1 = index2;
			this.index2 = index1;
		} else {
			this.index1 = index1;
			this.index2 = index2;
		}
		this.v1 = new double[] { round(verticesAsDouble.get(index1 * 3), margin), round(verticesAsDouble.get(index1 * 3 + 1), margin), round(verticesAsDouble.get(index1 * 3 + 2), margin)};
		this.v2 = new double[] { round(verticesAsDouble.get(index2 * 3), margin), round(verticesAsDouble.get(index2 * 3 + 1), margin), round(verticesAsDouble.get(index2 * 3 + 2), margin)};

		// Canonical ordering of vertices
		for (int i=0; i<3; i++) {
			if (this.v1[i] == this.v2[i]) {
				// Continue the loop
			} else if (this.v1[i] > this.v2[i]) {
				double[] tmp = this.v1;
				this.v1 = this.v2;
				this.v2 = tmp;
				break;
			} else {
				break;
			}
		}
	}
	
	private double round(double input, double margin) {
		return margin * (long)(input / margin);
	}
	
	public double[] getV1() {
		return v1;
	}
	
	public double[] getV2() {
		return v2;
	}
	
	public int getIndex1() {
		return index1;
	}
	
	public int getIndex2() {
		return index2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(v1);
		result = prime * result + Arrays.hashCode(v2);
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
		ComplexLine2 other = (ComplexLine2) obj;
		if (!Arrays.equals(v1, other.v1))
			return false;
		if (!Arrays.equals(v2, other.v2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return Arrays.toString(v1) + " - "  + Arrays.toString(v2);
	}

	@Override
	public int compareTo(ComplexLine2 o) {
		for (int i=0; i<3; i++) {
			if (this.v1[i] == o.v1[i]) {
				// Continue
			} else {
				return Double.compare(this.v1[i], o.v1[i]);
			}
		}
		for (int i=0; i<3; i++) {
			if (this.v2[i] == o.v2[i]) {
				// Continue
			} else {
				return Double.compare(this.v2[i], o.v2[i]);
			}
		}
		return 0;
	}
}
