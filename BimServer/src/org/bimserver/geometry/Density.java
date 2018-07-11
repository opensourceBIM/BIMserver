package org.bimserver.geometry;

public class Density {
	private float volume;
	private long nrPrimitives;
	private long geometryInfoId;
	private String type;
	private float biggestFaceArea;

	public Density(String type, float volume, float biggestFaceArea, long nrPrimitives, long geometryInfoId) {
		this.type = type;
		this.volume = volume;
		this.biggestFaceArea = biggestFaceArea;
		this.nrPrimitives = nrPrimitives;
		this.geometryInfoId = geometryInfoId;
	}
	
	public String getType() {
		return type;
	}
	
	public long getGeometryInfoId() {
		return geometryInfoId;
	}
	
	public long getNrPrimitives() {
		return nrPrimitives;
	}
	
	public float getVolume() {
		return volume;
	}
	
	public float getDensityValue() {
		if (biggestFaceArea == 0f) {
			return 0;
		}
		float d = nrPrimitives / biggestFaceArea;
		if (d < 0) {
			// WTF
			d = 0;
		}
		return d;
	}
	
	public float getBiggestFaceArea() {
		return biggestFaceArea;
	}
}