package org.bimserver.geometry;

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

public class Density {
	private float volume;
	private long nrPrimitives;
	private long geometryInfoId;
	private String type;
	private float biggestFaceAreaM2;

	public Density(String type, float volume, float biggestFaceAreaMm2, long nrPrimitives, long geometryInfoId) {
		this.type = type;
		this.volume = volume;
		this.biggestFaceAreaM2 = biggestFaceAreaMm2 / 1000000f;
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
		if (biggestFaceAreaM2 == 0f) {
			return 0;
		}
		float d = nrPrimitives / biggestFaceAreaM2;
		if (d < 0) {
			// WTF
			d = 0;
		}
		return d;
	}
	
	public float getBiggestFaceArea() {
		return biggestFaceAreaM2;
	}
}