package org.bimserver;

public class Range {

	private float[] reusableFirstVertex;
	private float[] reusableLastVertex;
	private long geometryDataOid = -1;

	public Range(float[] reusableFirstVertex, float[] reusableLastVertex) {
		this.reusableFirstVertex = reusableFirstVertex;
		this.reusableLastVertex = reusableLastVertex;
	}
	
	public void setGeometryDataOid(long geometryDataOid) {
		this.geometryDataOid = geometryDataOid;
	}

	public boolean isSimilar(Range range) {
		float[] diff1 = new float[]{range.reusableFirstVertex[0] - reusableFirstVertex[0], range.reusableFirstVertex[1] - reusableFirstVertex[1], range.reusableFirstVertex[2] - reusableFirstVertex[2]};
		float[] diff2 = new float[]{range.reusableLastVertex[0] - reusableLastVertex[0], range.reusableLastVertex[1] - reusableLastVertex[1], range.reusableLastVertex[2] - reusableLastVertex[2]};
		return diff1[0] == diff2[0] && diff1[1] == diff2[1] && diff1[2] == diff2[2];
	}
	
	public float[] getOffset(Range other) {
		return new float[]{other.reusableFirstVertex[0] - reusableFirstVertex[0], other.reusableFirstVertex[1] - reusableFirstVertex[1], other.reusableFirstVertex[2] - reusableFirstVertex[2]};
	}
	
	public long getGeometryDataOid() {
		return geometryDataOid;
	}
}
