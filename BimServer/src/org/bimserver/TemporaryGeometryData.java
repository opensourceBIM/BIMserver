package org.bimserver;

import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

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

import com.fasterxml.jackson.databind.node.ObjectNode;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

public class TemporaryGeometryData {

	private long oid;
	private int nrPrimitives;
	private long size;
	private double[] mibu;
	private double[] mabu;
	private IntBuffer indices;
	private DoubleBuffer vertices;
	private ObjectNode additionalData;
	private boolean hasTransparancy;
	private int nrVertices;
	private int nrColors;

	public TemporaryGeometryData(long oid, ObjectNode additionalData, int nrPrimitives, long size, double[] mibu, double[] mabu, IntBuffer indices, DoubleBuffer vertices, boolean hasTransparancy, int nrColors) {
		this.oid = oid;
		this.additionalData = additionalData;
		this.nrPrimitives = nrPrimitives;
		this.size = size;
		this.mibu = mibu;
		this.mabu = mabu;
		this.indices = indices;
		this.vertices = vertices;
		this.hasTransparancy = hasTransparancy;
		this.nrVertices = vertices.capacity();
		this.nrColors = nrColors;
	}
	
	public IntBuffer getIndices() {
		return indices;
	}
	
	public DoubleBuffer getVertices() {
		return vertices;
	}
	
	public double[] getMibu() {
		return mibu;
	}

	public double[] getMabu() {
		return mabu;
	}
	
	public long getSize() {
		return size;
	}
	
	public ObjectNode getAdditionalData() {
		return additionalData;
	}
	
	public int getNrPrimitives() {
		return nrPrimitives;
	}
	
	public long getOid() {
		return oid;
	}

	public boolean hasTransparancy() {
		return hasTransparancy;
	}

	public int getNrVertices() {
		return nrVertices;
	}

	public int getNrColors() {
		return nrColors;
	}
}
